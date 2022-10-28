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

package com.vk.api.sdk

import android.content.Context
import com.vk.api.sdk.auth.VKAccessTokenProvider
import com.vk.api.sdk.okhttp.DefaultLoggingPrefixer
import com.vk.api.sdk.okhttp.LoggingPrefixer
import com.vk.api.sdk.response.DefaultJsonResponseConverter
import com.vk.api.sdk.response.JsonResponseTypeConverter
import com.vk.api.sdk.response.ResponseBodyJsonConverter
import com.vk.api.sdk.utils.ApiMethodPriorityBackoff
import com.vk.api.sdk.utils.log.DefaultApiLogger
import com.vk.api.sdk.utils.log.Logger
import org.json.JSONObject
import java.util.concurrent.TimeUnit

/**
 * Configuration for VK SDK
 * By using VK.initialize(config) you can customize configuration
 */
@Suppress("ConvertSecondaryConstructorToPrimary")
data class VKApiConfig(
    val context: Context,
    val appId: Int = 0,
    val validationHandler: VKApiValidationHandler? = null,
    val apiCallListener: VKApiCallListener? = null,
    val deviceId: Lazy<String> = lazy { "" },
    val version: String = DEFAULT_API_VERSION,
    val okHttpProvider: VKOkHttpProvider = VKOkHttpProvider.DefaultProvider(),
    val logger: Logger = DefaultApiLogger(lazy { Logger.LogLevel.NONE }, "VKSdkApi"),
    val loggingPrefixer: LoggingPrefixer = DefaultLoggingPrefixer(),
    internal val accessToken: Lazy<String> = lazy { "" },
    internal val secret: Lazy<String?> = lazy { null },
    internal val expiresInSec: Lazy<Int> = lazy { 0 },
    internal val createdMs: Lazy<Long> = lazy { 0 },
    val clientSecret: String = "",
    val logFilterCredentials: Boolean = true,
    val debugCycleCalls: Lazy<Boolean> = lazy { false },
    val callsPerSecondLimit: Int = 3,
    val apiHostProvider: () -> String = { DEFAULT_API_DOMAIN },
    val langProvider: () -> String = { DEFAULT_LANGUAGE },
    val keyValueStorage: VKKeyValueStorage = VKPreferencesKeyValueStorage(context),
    val customApiEndpoint: () -> String = { DEFAULT_API_ENDPOINT },
    val maxRateLimitBackoffTimeoutMs: Long = TimeUnit.HOURS.toMillis(1),
    val minRateLimitBackoffTimeoutMs: Long = maxRateLimitBackoffTimeoutMs,
    val apiMethodPriorityBackoff: ApiMethodPriorityBackoff = ApiMethodPriorityBackoff.DEFAULT,
    val externalDeviceId: Lazy<String?> = lazy { null },
    val anonymousTokenProvider: Lazy<VKAccessTokenProvider?> = lazy { null },
    val customJsonResponseTypeConverters: List<JsonResponseTypeConverter> = listOf(),
    val accessTokenRefresher: Lazy<AccessTokenRefresher?> = lazy { null },
    val expiresInReduceRatioJson: () -> JSONObject? = { null }
) {

    val responseBodyJsonConverter: ResponseBodyJsonConverter by lazy {
        ResponseBodyJsonConverter(
            listOf(
                *customJsonResponseTypeConverters.toTypedArray(),
                DefaultJsonResponseConverter(),
            )
        )
    }

    val lang get() = langProvider()

    fun builder(context: Context) = Builder(VKApiConfig(context, validationHandler = VKDefaultValidationHandler(context)))

    fun buildUpon() = Builder(this)

    class Builder internal constructor(private var config: VKApiConfig) {

        private val customJsonResponseTypeConverters = mutableListOf<JsonResponseTypeConverter>()
            .apply { addAll(config.customJsonResponseTypeConverters) }

        fun setLogger(logger: Logger) = apply {
            config = config.copy(logger = logger)
        }

        fun setAppId(id: Int) = apply {
            config = config.copy(appId = id)
        }

        fun setValidationHandler(vkApiValidationHandler: VKApiValidationHandler?) = apply {
            config = config.copy(validationHandler = vkApiValidationHandler)
        }

        fun setDeviceID(deviceId: String) = apply {
            config = config.copy(deviceId = lazy { deviceId })
        }

        fun setApiVersion(version: String) = apply {
            config = config.copy(version = version)
        }

        fun setCustomApiEndpoint(endpoint: String) = apply {
            config = config.copy(customApiEndpoint = { endpoint })
        }

        fun setCustomValueStorage(storage: VKKeyValueStorage) = apply {
            config = config.copy(keyValueStorage = storage)
        }

        fun setLangProvider(langProvider: () -> String) = apply {
            config = config.copy(langProvider = langProvider)
        }

        fun setApiHostProvider(apiHostProvider: () -> String) = apply {
            config = config.copy(apiHostProvider = apiHostProvider)
        }

        fun setAccessToken(accessToken: String) = apply {
            config = config.copy(accessToken = lazy { accessToken })
        }

        fun setexpiresInSec(expiresInSec: Int) = apply {
            config = config.copy(expiresInSec = lazy { expiresInSec })
        }

        fun setCreated(createdMs: Long) = apply {
            config = config.copy(createdMs = lazy { createdMs })
        }

        fun setClientSecret(clientSecret: String) = apply {
            config = config.copy(clientSecret = clientSecret)
        }

        fun setOkHttpProvider(okHttpProvider: VKOkHttpProvider) = apply {
            config = config.copy(okHttpProvider = okHttpProvider)
        }

        fun setLogFilterCredentials(filter: Boolean) = apply {
            config = config.copy(logFilterCredentials = filter)
        }

        fun setCallsPerSecondLimit(limit: Int) = apply {
            config = config.copy(callsPerSecondLimit = limit)
        }

        fun setDebugCycleCalls(debugCycleCalls: Boolean) = apply {
            config = config.copy(debugCycleCalls = lazy { debugCycleCalls })
        }

        fun setMinRateLimitBackoff(minRateLimitBackoffTimeoutMs: Long) = apply {
            config = config.copy(minRateLimitBackoffTimeoutMs = minRateLimitBackoffTimeoutMs)
        }

        fun setMaxRateLimitBackoff(maxRateLimitBackoffTimeoutMs: Long) = apply {
            config = config.copy(maxRateLimitBackoffTimeoutMs = maxRateLimitBackoffTimeoutMs)
        }

        fun setExternalDeviceID(externalDeviceId: String?) = apply {
            config = config.copy(externalDeviceId = lazy { externalDeviceId })
        }

        fun setAnonymousTokenProvider(provider: VKAccessTokenProvider?) = apply {
            config = config.copy(anonymousTokenProvider = lazy { provider })
        }

        fun setLoggingPrefixer(loggingPrefixer: LoggingPrefixer) = apply {
            config = config.copy(loggingPrefixer = loggingPrefixer)
        }

        fun addCustomJsonResponseTypeConverter(converter: JsonResponseTypeConverter) = apply {
            customJsonResponseTypeConverters += converter
        }

        fun removeCustomJsonResponseTypeConverter(converter: JsonResponseTypeConverter) = apply {
            customJsonResponseTypeConverters -= converter
        }

        fun setAccessTokenRefresher(refresher: AccessTokenRefresher) = apply {
            config = config.copy(accessTokenRefresher = lazy { refresher })
        }

        fun build(): VKApiConfig {
            return config.copy(customJsonResponseTypeConverters = customJsonResponseTypeConverters)
        }
    }

    enum class EndpointPathName(val pathName: String) {
        METHOD("/method"),
        EMPTY("")
    }

    companion object {
        const val DEFAULT_LANGUAGE = "en"
        const val DEFAULT_API_VERSION = "5.131"

        val DEFAULT_DOMAIN: String
            get() = "vk.com"
        val DEFAULT_API_DOMAIN: String
            get() = "api.${VKHost.host}"
        val DEFAULT_OAUTH_DOMAIN: String
            get() = "oauth.${VKHost.host}"
        val DEFAULT_STATIC_DOMAIN: String
            get() = "static.${VKHost.host}"
        val DEFAULT_API_ENDPOINT: String
            get() = "https://${DEFAULT_API_DOMAIN}/method"
    }
}