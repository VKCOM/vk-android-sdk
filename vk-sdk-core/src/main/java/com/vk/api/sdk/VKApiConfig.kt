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
import com.vk.api.sdk.utils.log.DefaultApiLogger
import com.vk.api.sdk.utils.log.Logger
import java.util.concurrent.TimeUnit

/**
 * Configuration for VK SDK
 * By using VK.initialize(config) you can customize configuration
 */
@Suppress("ConvertSecondaryConstructorToPrimary")
data class VKApiConfig(
    val context: Context,
    val appId: Int = 0,
    val validationHandler: VKApiValidationHandler?,
    val deviceId: Lazy<String> = lazy { "" },
    val version: String = DEFAULT_API_VERSION,
    val okHttpProvider: VKOkHttpProvider = VKOkHttpProvider.DefaultProvider(),
    val defaultTimeoutMs: Long = TimeUnit.SECONDS.toMillis(10),
    val postRequestsTimeout: Long = TimeUnit.MINUTES.toMillis(5),
    val logger: Logger = DefaultApiLogger(lazy { Logger.LogLevel.NONE }, "VKSdkApi"),
    val accessToken: Lazy<String> = lazy { "" },
    val secret: Lazy<String?> = lazy { null },
    val logFilterCredentials: Boolean = true,
    val debugCycleCalls: Lazy<Boolean> = lazy { false },
    val callsPerSecondLimit: Int = 3,
    val httpApiHostProvider: () -> String = { DEFAULT_API_DOMAIN },
    val lang: String = "en",
    val keyValueStorage: VKKeyValueStorage = VKPreferencesKeyValueStorage(context),
    val customApiEndpoint: Lazy<String> = lazy { DEFAULT_API_ENDPOINT }
) {

    fun builder(context: Context) = Builder(VKApiConfig(context, validationHandler = VKDefaultValidationHandler(context)))

    fun buildUpon() = Builder(this)

    class Builder internal constructor(private var config: VKApiConfig) {

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
            config = config.copy(customApiEndpoint = lazy { endpoint })
        }

        fun setCustomValueStorage(storage: VKKeyValueStorage) = apply {
            config = config.copy(keyValueStorage = storage)
        }

        fun setLang(lang: String) = apply {
            config = config.copy(lang = lang)
        }

        fun setHttpApiHostProvider(hostProvider: () -> String) = apply {
            config = config.copy(httpApiHostProvider = hostProvider)
        }

        fun setAccessToken(accessToken: String) = apply {
            config = config.copy(accessToken = lazy { accessToken })
        }

        fun setOkHttpProvider(okHttpProvider: VKOkHttpProvider) = apply {
            config = config.copy(okHttpProvider = okHttpProvider)
        }

        fun setLogFilterCredentials(filter: Boolean) = apply {
            config = config.copy(logFilterCredentials = filter)
        }

        fun setDefaultTimeoutMs(timeout: Long) = apply {
            config = config.copy(defaultTimeoutMs = timeout)
        }

        fun setPostRequestsTimeoutMs(timeout: Long) = apply {
            config = config.copy(postRequestsTimeout = timeout)
        }

        fun setCallsPerSecondLimit(limit: Int) = apply {
            config = config.copy(callsPerSecondLimit = limit)
        }

        fun setDebugCycleCalls(debugCycleCalls: Boolean) = apply {
            config = config.copy(debugCycleCalls = lazy { debugCycleCalls })
        }

        fun build(): VKApiConfig {
            return config
        }
    }

    companion object {
        const val DEFAULT_DOMAIN = "vk.com"
        const val DEFAULT_API_VERSION = "5.90"
        const val DEFAULT_API_DOMAIN = "api.vk.com"
        const val DEFAULT_OAUTH_DOMAIN = "oauth.vk.com"
        const val DEFAULT_STATIC_DOMAIN = "static.vk.com"
        const val DEFAULT_API_ENDPOINT = "https://$DEFAULT_API_DOMAIN/method"
    }
}