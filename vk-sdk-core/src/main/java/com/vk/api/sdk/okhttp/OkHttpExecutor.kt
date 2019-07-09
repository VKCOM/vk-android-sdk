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
import android.support.v4.util.LongSparseArray
import com.vk.api.sdk.OauthHttpUrlPostCall
import com.vk.api.sdk.VKApiProgressListener
import com.vk.api.sdk.VKOkHttpProvider
import com.vk.api.sdk.chain.ChainArgs
import com.vk.api.sdk.exceptions.*
import com.vk.api.sdk.internal.HttpMultipartEntry
import com.vk.api.sdk.internal.QueryStringGenerator
import com.vk.api.sdk.internal.Validation
import com.vk.api.sdk.utils.log.Logger
import com.vk.api.sdk.utils.set
import okhttp3.*
import java.io.IOException
import java.net.HttpURLConnection.HTTP_ENTITY_TOO_LARGE
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

open class OkHttpExecutor(protected val config: OkHttpExecutorConfig) {
    // Extra delay to let api respond with specified timeout
    protected val timeoutDelay = 500
    protected val context = config.context
    private val lock = Any()
    private val okHttpProvider: VKOkHttpProvider by lazy {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw IllegalStateException("UI thread")
        }
        updateClient(config.okHttpProvider)
        return@lazy config.okHttpProvider
    }
    val host = config.host
    @Volatile protected var accessToken = config.accessToken
    @Volatile protected var secret = config.secret

    private val clientsByTimeouts = LongSparseArray<OkHttpClient>()

    fun setCredentials(accessToken: String, secret: String?) {
        Validation.assertAccessTokenValid(accessToken)
        this.accessToken = accessToken
        this.secret = secret
    }

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    open fun execute(call: OkHttpMethodCall): String? {

        val queryString = QueryStringGenerator.buildQueryString(accessToken, secret, config.appId, call)
        val requestBody = RequestBody.create(MediaType.parse(MIME_APPLICATION), validateQueryString(call, queryString))

        val request = Request.Builder()
                .post(requestBody)
                .url("https://$host/method/${call.method}")
                .cacheControl(CacheControl.FORCE_NETWORK)
                .tag(Map::class.java, call.tag?.toMap())
                .build()
        return readResponse(executeRequest(request))
    }

    open fun execute(call: OauthHttpUrlPostCall, chainArgs: ChainArgs?): String? {
        val url = if (chainArgs != null && chainArgs.hasCaptcha()) {
            Uri.parse(call.url)
                    .buildUpon()
                    .appendQueryParameter(VKApiCodes.EXTRA_CAPTCHA_KEY, chainArgs.captchaKey)
                    .appendQueryParameter(VKApiCodes.EXTRA_CAPTCHA_SID, chainArgs.captchaSid)
                    .build()
                    .toString()

        } else {
            call.url
        }
        val request = Request.Builder()
                .post(RequestBody.create(null, ""))
                .cacheControl(CacheControl.FORCE_NETWORK)
                .url(url)
                .build()

        return readResponse(executeRequest(request, call.timeoutMs + timeoutDelay))
    }

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    fun execute(call: OkHttpPostCall, progressListener: VKApiProgressListener?): String? {
        val body = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .updateWith(call.parts)
                .build()
        val requestBody = ProgressRequestBody(body, progressListener)

        val timeout = if (call.timeoutMs > 0) call.timeoutMs else config.postRequestsTimeout

        val request = Request.Builder()
                .post(requestBody)
                .url(call.url)
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()

        return readResponse(executeRequest(request, timeout))
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

    protected fun executeRequest(request: Request): Response {
        return executeRequest(request, config.defaultTimeoutMs)
    }

    @Throws(InterruptedException::class, IOException::class)
    protected fun executeRequest(request: Request, timeoutMs: Long): Response {
        return clientWithTimeOut(timeoutMs).newCall(request).execute()
    }

    protected fun readResponse(response: Response): String? {
        if (response.code() == HTTP_ENTITY_TOO_LARGE) {
            throw VKLargeEntityException(response.message())
        }
        val rb = response.body()
        return try {
            rb?.string()
        } catch (ex: IOException) {
            throw VKNetworkIOException(ex)
        } finally {
            rb?.close()
        }
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

    private fun clientWithTimeOut(timeoutMs: Long): OkHttpClient {
        synchronized(lock) {
            val baseClient = okHttpProvider.getClient()
            val defaultClient = getDefaultClient()

            // Here we check whether the default client has changed in comparison
            // with the cached client with the default timeouts.
            // If that happened, then we need to reset all cached clients,
            // since the default clients could be added proxy interceptors or something else.
            if (!isSame(baseClient, defaultClient)) {
                clearClients()
            }

            // We increase timeout by 500ms to make sure that all long poll calls will pass.
            val fixedTimeoutMs = timeoutMs + timeoutDelay
            return getClient(fixedTimeoutMs) ?: createClient(fixedTimeoutMs)
        }
    }

    private fun getDefaultClient(): OkHttpClient {
        val timeoutMs = config.defaultTimeoutMs
        return getClient(timeoutMs) ?: createClient(timeoutMs)
    }

    private fun getClient(timeoutMs: Long): OkHttpClient? {
        return clientsByTimeouts[timeoutMs]
    }

    private fun createClient(timeoutMs: Long): OkHttpClient {
        val client = okHttpProvider.getClient()
                .newBuilder()
                .readTimeout(timeoutMs, TimeUnit.MILLISECONDS)
                .connectTimeout(timeoutMs, TimeUnit.MILLISECONDS)
                .build()
        clientsByTimeouts[timeoutMs] = client
        return client
    }

    private fun clearClients() {
        clientsByTimeouts.clear()
    }

    private fun isSame(c1: OkHttpClient, c2: OkHttpClient): Boolean {
        return c1.connectTimeoutMillis() == c2.connectTimeoutMillis()
                && c1.readTimeoutMillis() == c2.readTimeoutMillis()
                && c1.writeTimeoutMillis() == c2.writeTimeoutMillis()
                && c1.pingIntervalMillis() == c2.pingIntervalMillis()
                && c1.proxy() == c2.proxy()
                && c1.proxySelector() == c2.proxySelector()
                && c1.cookieJar() == c2.cookieJar()
                && c1.cache() == c2.cache()
                && c1.dns() == c2.dns()
                && c1.socketFactory() == c2.socketFactory()
                && c1.sslSocketFactory() == c2.sslSocketFactory()
                && c1.sslSocketFactory() == c2.sslSocketFactory()
                && c1.hostnameVerifier() == c2.hostnameVerifier()
                && c1.certificatePinner() == c2.certificatePinner()
                && c1.authenticator() == c2.authenticator()
                && c1.proxyAuthenticator() == c2.proxyAuthenticator()
                && c1.connectionPool() == c2.connectionPool()
                && c1.followSslRedirects() == c2.followSslRedirects()
                && c1.followRedirects() == c2.followRedirects()
                && c1.retryOnConnectionFailure() == c2.retryOnConnectionFailure()
                && c1.dispatcher() == c2.dispatcher()
                && c1.protocols() == c2.protocols()
                && c1.connectionSpecs() == c2.connectionSpecs()
                && c1.interceptors() == c2.interceptors()
                && c1.networkInterceptors() == c2.networkInterceptors()
    }

    private fun updateClient(provider: VKOkHttpProvider) {
        provider.updateClient(object : VKOkHttpProvider.BuilderUpdateFunction {
            override fun update(builder: OkHttpClient.Builder): OkHttpClient.Builder {
                if (Logger.LogLevel.NONE != config.logger.logLevel) {
                    builder.addInterceptor(LoggingInterceptor(config.logFilterCredentials, config.logger))
                }
                return builder
            }
        })
    }

    private fun convertFileNameToSafeValue(fileName: String): String {
        return URLEncoder.encode(fileName.replace("\"", "\\\""), UTF_8)
    }

    companion object {
        const val MIME_APPLICATION: String = "application/x-www-form-urlencoded; charset=utf-8"
        private const val UTF_8 = "UTF-8"
    }

}