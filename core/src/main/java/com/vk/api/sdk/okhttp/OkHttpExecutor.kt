/*******************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 vk.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.vk.api.sdk.okhttp

import android.net.Uri
import android.os.Looper
import com.vk.api.sdk.VKApiConfig
import com.vk.api.sdk.VKApiCredentials
import com.vk.api.sdk.VKApiProgressListener
import com.vk.api.sdk.VKHost
import com.vk.api.sdk.VKOkHttpProvider
import com.vk.api.sdk.exceptions.IgnoredAccessTokenException
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.exceptions.VKInternalServerErrorException
import com.vk.api.sdk.exceptions.VKLargeEntityException
import com.vk.api.sdk.internal.HttpMultipartEntry
import com.vk.api.sdk.internal.QueryStringGenerator
import com.vk.api.sdk.utils.SecureInfoStripper
import com.vk.api.sdk.utils.activeAccessToken
import com.vk.api.sdk.utils.activeExpiresInSec
import com.vk.api.sdk.utils.activeSecret
import com.vk.api.sdk.utils.log.Logger
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException
import java.net.HttpURLConnection.HTTP_ENTITY_TOO_LARGE
import java.net.URLEncoder
import okhttp3.CacheControl
import okhttp3.Headers
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

open class OkHttpExecutor(protected val config: OkHttpExecutorConfig) {
    protected val context = config.context
    private val lock = Any()
    private val okHttpProvider: VKOkHttpProvider by lazy {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw IllegalStateException("UI thread")
        }
        updateClient(config.okHttpProvider)
        return@lazy config.okHttpProvider
    }
    val host: String
        get() = config.hostProvider()

    @Volatile
    var credentials: Lazy<List<VKApiCredentials>> = config.credentials

    private val secureInfoStripper = lazy {
        SecureInfoStripper.generateBaseStripper(
            setOf("accessToken")
        )
    }

    private val reducedExpiresInSec: Int
        get() = (credentials.value.activeExpiresInSec() * config.expiresInReduceRatio).toInt() // -x%
    val isLoggedIn: Boolean
        get() = credentials.value.activeAccessToken().isNotBlank()
    val tokenContainsAndValid: Boolean
        get() = credentials.value.all { tokenContainsAndValid(it) }
    private fun tokenContainsAndValid(credentials: VKApiCredentials): Boolean =
        credentials.accessToken.isNotBlank() && (credentials.expiresInSec <= 0 || credentials.createdMs + credentials.expiresInSec * config.expiresInReduceRatio * 1000 > System.currentTimeMillis())

    private val customEndpoint = config.customEndpoint

    @Volatile
    var ignoredAccessToken: String? = null
        private set

    fun setCredentials(credentials: List<VKApiCredentials>) {
        log(credentials.toString())
        this.credentials = lazy { credentials }
    }

    internal fun setCredentials(credentials: Lazy<List<VKApiCredentials>>) {
        if (credentials.isInitialized()) {
            log(credentials.value.toString())
        }
        this.credentials = credentials
    }

    fun ignoreAccessToken(accessToken: String?) {
        ignoredAccessToken = accessToken
    }

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    open fun execute(call: OkHttpMethodCall): ExecutorResponse {
        val actualAccessToken = getActualAccessToken(call)
        checkAccessTokenIsIgnored(call.method, actualAccessToken)
        val actualSecret = getActualSecret(call)
        checkNonSecretMethodCall(call)

        val queryString = QueryStringGenerator.buildSignedQueryStringForMethod(
            methodName = call.method,
            methodArgs = call.args,
            methodVersion = call.version,
            activeAccessToken = actualAccessToken,
            secret = actualSecret,
            appId = config.appId,
            isMultipleTokens = call.isMultipleTokens,
            accessTokens = credentials.value.map { it.accessToken },
            forceAnonymous = call.forceAnonymous
        )
        val requestBody = validateQueryString(call, queryString).toRequestBody(MIME_APPLICATION.toMediaTypeOrNull())

        val reqHost = call.requestUrl ?: host
        val requestBuilder = Request.Builder()
                .post(requestBody)
                .url("${resolveEndpoint(reqHost)}/${call.method}")
                .cacheControl(CacheControl.FORCE_NETWORK)
                .tag(Map::class.java, call.tag?.toMap())

        call.customTag?.let { customTag ->
            requestBuilder.tag(customTag.javaClass, customTag)
        }

        val request = requestBuilder.build()
        val executorAccessToken = credentials.value.activeAccessToken()
        val okHttpResponse = executeRequest(request)
        return ExecutorResponse(readResponse(okHttpResponse), okHttpResponse.headers, executorAccessToken)
    }

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    fun execute(call: OkHttpPostCall, progressListener: VKApiProgressListener?): ExecutorResponse {
        val body = if (call.isMultipart) {
            MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .updateWith(call.parts)
                .build()
        } else {
            val queryString = call.parts
                .filterValues { it is HttpMultipartEntry.Text }
                .map {
                    val key = it.key
                    val value = (it.value as HttpMultipartEntry.Text).textValue
                    "$key=${URLEncoder.encode(value, UTF_8)}"
                }
                .joinToString("&")
            queryString.toRequestBody(MIME_APPLICATION.toMediaType())
        }
        val requestBody = ProgressRequestBody(body, progressListener)

        val request = makePostCallRequestBuilder(call, requestBody).build()
        val response = executeRequest(request)
        return ExecutorResponse(readResponse(response), response.headers)
    }

    protected open fun makePostCallRequestBuilder(call: OkHttpPostCall, requestBody: RequestBody): Request.Builder {
        return Request.Builder()
            .post(requestBody)
            .url(call.url)
            .cacheControl(CacheControl.FORCE_NETWORK)
    }

    @Throws(VKApiException::class)
    protected fun validateQueryString(call: OkHttpMethodCall, paramsString: String): String {
        if (call.method.startsWith("execute.")) {
            val uri = Uri.parse("https://${VKHost.host}/?$paramsString")
            if (uri.getQueryParameters("method").contains("execute")
                    && !uri.getQueryParameters("code").isNullOrEmpty()) {
                throw VKApiExecutionException(
                        VKApiCodes.CODE_ACCESS_DENIED,
                        call.method,
                        false,
                        "Hey dude don't execute your hacky code ;)"
                )
            }
        }
        return paramsString
    }

    @Throws(InterruptedException::class, IOException::class)
    fun executeRequest(request: Request): Response {
        return okHttpProvider.getClient().newCall(request).execute()
    }

    fun readResponse(response: Response): JSONObject? {
        if (response.code == HTTP_ENTITY_TOO_LARGE) {
            throw VKLargeEntityException(response.message)
        }
        if (response.code in 500..599) {
            throw VKInternalServerErrorException(response.code, response.body?.use { it.string() } ?: "null")
        }

        return response.body?.byteStream()?.let { inputStream ->
            config.responseBodyJsonConverter.convertResponse(
                inputStream,
                response.headers["content-type"],
                path = response.request.url.encodedPath
            )
        }
    }

    protected open fun getActualAccessToken(call: OkHttpMethodCall): String? = credentials.value.activeAccessToken()
    protected open fun getActualSecret(call: OkHttpMethodCall): String? = credentials.value.activeSecret()

    @Throws(IgnoredAccessTokenException::class)
    protected fun checkAccessTokenIsIgnored(method: String, requestAccessToken: String?) {
        if (ignoredAccessToken != null
                && requestAccessToken != null
                && requestAccessToken == ignoredAccessToken) {
            throw IgnoredAccessTokenException(method)
        }
    }

    protected open fun checkNonSecretMethodCall(call: OkHttpMethodCall) {
        //do nothing
    }

    private fun MultipartBody.Builder.updateWith(parts: Map<String, HttpMultipartEntry>): MultipartBody.Builder {
        for ((key, entry) in parts) {
            if (entry is HttpMultipartEntry.Text) {
                this.addFormDataPart(key, entry.textValue)
            } else if (entry is HttpMultipartEntry.File) {
                val partBody = FileFullRequestBody(context, entry.fileUri)
                this.addFormDataPart(key, convertFileNameToSafeValue(entry.fileName ?: ""), partBody)
            }
        }
        return this
    }

    private fun resolveEndpoint(host: String): String {
        if (customEndpoint.isEmpty() || customEndpoint == VKApiConfig.DEFAULT_API_ENDPOINT) {
            return defaultApiEndpoint(host)
        }
        return customEndpoint
    }

    private fun updateClient(provider: VKOkHttpProvider) {
        provider.updateClient(object : VKOkHttpProvider.BuilderUpdateFunction {
            override fun update(builder: OkHttpClient.Builder): OkHttpClient.Builder {
                if (Logger.LogLevel.NONE != config.logger.logLevel.value) {
                    builder.addInterceptor(createLoggingInterceptor(config.logFilterCredentials, config.logger, config.loggingPrefixer))
                }
                return builder
            }
        })
    }

    protected open fun createLoggingInterceptor(
        filterCredentials: Boolean,
        logger: Logger,
        loggingPrefixer: LoggingPrefixer
    ): LoggingInterceptor {
        return LoggingInterceptor(filterCredentials, logger, loggingPrefixer)
    }

    private fun convertFileNameToSafeValue(fileName: String): String {
        return URLEncoder.encode(fileName.replace("\"", "\\\""), UTF_8)
    }

    private fun log(message: String) {
        config.logger.log(Logger.LogLevel.VERBOSE, "[SET CREDENTIALS IN API] ${secureInfoStripper.value.strip(message)}")
    }

    data class ExecutorResponse(
        val responseBodyJson: JSONObject?,
        val headers: Headers,
        val executorRequestAccessToken: String? = null
    )

    companion object {
        const val MIME_APPLICATION: String = "application/x-www-form-urlencoded; charset=utf-8"
        private const val UTF_8 = "UTF-8"

        private fun defaultApiEndpoint(host: String) = "https://$host/method"
    }

}