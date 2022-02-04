/**
 * Copyright (c) 2020 - present, LLC “V Kontakte”
 *
 * 1. Permission is hereby granted to any person obtaining a copy of this Software to
 * use the Software without charge.
 *
 * 2. Restrictions
 * You may not modify, merge, publish, distribute, sublicense, and/or sell copies,
 * create derivative works based upon the Software or any part thereof.
 *
 * 3. Termination
 * This License is effective until terminated. LLC “V Kontakte” may terminate this
 * License at any time without any negative consequences to our rights.
 * You may terminate this License at any time by deleting the Software and all copies
 * thereof. Upon termination of this license for any reason, you shall continue to be
 * bound by the provisions of Section 2 above.
 * Termination will be without prejudice to any rights LLC “V Kontakte” may have as
 * a result of this agreement.
 *
 * 4. Disclaimer of warranty and liability
 * THE SOFTWARE IS MADE AVAILABLE ON THE “AS IS” BASIS. LLC “V KONTAKTE” DISCLAIMS
 * ALL WARRANTIES THAT THE SOFTWARE MAY BE SUITABLE OR UNSUITABLE FOR ANY SPECIFIC
 * PURPOSES OF USE. LLC “V KONTAKTE” CAN NOT GUARANTEE AND DOES NOT PROMISE ANY
 * SPECIFIC RESULTS OF USE OF THE SOFTWARE.
 * UNDER NO CIRCUMSTANCES LLC “V KONTAKTE” BEAR LIABILITY TO THE LICENSEE OR ANY
 * THIRD PARTIES FOR ANY DAMAGE IN CONNECTION WITH USE OF THE SOFTWARE.
*/
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
import com.vk.api.sdk.VKApiCredentials
import com.vk.api.sdk.VKApiProgressListener
import com.vk.api.sdk.VKOkHttpProvider
import com.vk.api.sdk.exceptions.*
import com.vk.api.sdk.internal.HttpMultipartEntry
import com.vk.api.sdk.internal.QueryStringGenerator
import com.vk.api.sdk.utils.log.Logger
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.net.HttpURLConnection.HTTP_ENTITY_TOO_LARGE
import java.net.URLEncoder

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
    private var credentialsProvider = VKApiCredentials.lazyFrom(config.accessToken, config.secret)

    val accessToken: String
        get() = credentialsProvider.value.accessToken
    val secret: String?
        get() = credentialsProvider.value.secret

    private val customEndpoint = config.customEndpoint

    @Volatile var ignoredAccessToken: String? = null
        private set

    fun setCredentials(accessToken: String, secret: String?) {
        this.credentialsProvider =  VKApiCredentials.lazyFrom(accessToken, secret)
    }

    internal fun setCredentials(credentialsProvider: Lazy<VKApiCredentials>) {
        this.credentialsProvider = credentialsProvider
    }

    fun ignoreAccessToken(accessToken: String?) {
        ignoredAccessToken = accessToken
    }

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    open fun execute(call: OkHttpMethodCall): MethodResponse {

        val actualAccessToken = getActualAccessToken(call)

        checkAccessTokenIsIgnored(call.method, actualAccessToken)

        val actualSecret = getActualSecret(call)
        
        checkNonSecretMethodCall(call)

        val queryString = QueryStringGenerator.buildSignedQueryStringForMethod(
            call.method, call.args, call.version, actualAccessToken, actualSecret, config.appId
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
        val executorAccessToken = accessToken
        val okHttpResponse = executeRequest(request)
        return MethodResponse(readResponse(okHttpResponse), okHttpResponse.headers, executorAccessToken)
    }

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    fun execute(call: OkHttpPostCall, progressListener: VKApiProgressListener?): String? {
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

        return readResponse(executeRequest(request))
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
            val uri = Uri.parse("https://vk.com/?$paramsString")
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

    fun readResponse(response: Response): String? {
        if (response.code == HTTP_ENTITY_TOO_LARGE) {
            throw VKLargeEntityException(response.message)
        }

        val body = response.body?.use { it.string() }
        if (response.code in 500..599) {
            throw VKInternalServerErrorException(response.code, body ?: "null")
        }
        return body
    }

    protected open fun getActualAccessToken(call: OkHttpMethodCall): String? = accessToken
    protected open fun getActualSecret(call: OkHttpMethodCall): String? = secret

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

    private fun resolveEndpoint(host: String) = if (customEndpoint.isNotEmpty()) {
        customEndpoint
    } else {
        defaultApiEndpoint(host)
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
        logger: Logger, loggingPrefixer:
        LoggingPrefixer
    ): LoggingInterceptor {
        return LoggingInterceptor(filterCredentials, logger, loggingPrefixer)
    }

    private fun convertFileNameToSafeValue(fileName: String): String {
        return URLEncoder.encode(fileName.replace("\"", "\\\""), UTF_8)
    }

    data class MethodResponse(
            val response: String?,
            val headers: Headers,
            val executorRequestAccessToken: String?)

    companion object {
        const val MIME_APPLICATION: String = "application/x-www-form-urlencoded; charset=utf-8"
        private const val UTF_8 = "UTF-8"

        private fun defaultApiEndpoint(host: String) = "https://$host/method"
    }

}