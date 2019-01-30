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
import com.vk.api.sdk.internal.Validation
import com.vk.api.sdk.utils.log.DefaultApiLogger
import com.vk.api.sdk.utils.log.Logger
import com.vk.api.sdk.utils.applyPos
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

/**
 * Configuration for VK SDK
 * By using VK.initialize(config) you can customize configuration
 */
@Suppress("ConvertSecondaryConstructorToPrimary")
class VKApiConfig {
    class Builder {
        var context: Context? = null
            private set
        var appId: Int = 0
            private set
        var callsPerSecondLimit: Int = 3
            private set
        var httpApiHost: String = DEFAULT_API_DOMAIN
            private set
        var deviceId: String = ""
            private set
        var lang: String = "en"
            private set
        var accessToken: String = ""
            private set
        var secret: String? = null
            private set

        var version: String = DEFAULT_API_VERSION

        var okHttpProvider: VKOkHttpProvider = VKOkHttpProvider.DefaultProvider()
            private set
        var logFilterCredentials: Boolean = false
            private set
        var validationHandler: VKApiValidationHandler? = null
            private set
        var logger: Logger = DefaultApiLogger(Logger.LogLevel.NONE, "VKSdkApi")
            private set
        var defaultTimeoutMs: Long = TimeUnit.SECONDS.toMillis(10)
            private set
        var postRequestsTimeout = TimeUnit.MINUTES.toMillis(5)
            private set

        fun context(context: Context) = apply { this.context = context }
        fun appId(appId: Int) = apply { this.appId = appId }
        fun callsPerSecondLimit(callsPerSecondLimit: Int) = apply { this.callsPerSecondLimit = callsPerSecondLimit }
        fun httpApiHost(httpApiHost: String) = apply { this.httpApiHost = httpApiHost }
        fun deviceId(deviceId: String) = apply { this.deviceId = deviceId }
        fun lang(lang: String) = apply { this.lang = lang }
        fun version(version: String) = apply { this.version = version }
        fun accessToken(accessToken: String) = apply { this.accessToken = accessToken }
        fun secret(secret: String?) = apply { this.secret = secret }
        fun okHttpProvider(okHttpProvider: VKOkHttpProvider) = apply { this.okHttpProvider = okHttpProvider }
        fun logFilterCredentials(logFilterCredentials: Boolean) = apply { this.logFilterCredentials = logFilterCredentials }
        fun validationHandler(handler: VKApiValidationHandler) = apply { this.validationHandler = handler }
        fun logger(logger: Logger) = apply { this.logger = logger }
        fun defaultTimeout(value: Long, timeUnit: TimeUnit) = apply { this.defaultTimeoutMs = timeUnit.toMillis(value) }
        fun postRequestsTimeout(timeoutMs: Long) = applyPos(timeoutMs) { postRequestsTimeout = it }

        fun build() = VKApiConfig(this)
    }

    val context: Context
    val appId: Int
    val callsPerSecondLimit: Int
    val httpApiHost: String
    val deviceId: String
    val lang: String
    val accessToken: String
    val version: String
    val secret: String?
    val okHttpProvider: VKOkHttpProvider
    val logFilterCredentials: Boolean
    val defaultTimeoutMs: Long
    val postRequestsTimeout: Long
    val validationHandler: VKApiValidationHandler?
    val logger: Logger

    private constructor(b: Builder) {
        Validation.assertContextValid(b.context)
        Validation.assertCallsPerSecondLimitValid(b.callsPerSecondLimit)
        Validation.assertHttpHostValid(b.httpApiHost)
        Validation.assertLangValid(b.lang)
        Validation.assertAccessTokenValid(b.accessToken)

        context = b.context!!
        appId = b.appId
        callsPerSecondLimit = b.callsPerSecondLimit
        httpApiHost = b.httpApiHost
        accessToken = b.accessToken
        deviceId = b.deviceId
        lang = b.lang
        secret = b.secret
        version = b.version
        okHttpProvider = b.okHttpProvider
        logFilterCredentials = b.logFilterCredentials
        validationHandler = b.validationHandler
        logger = b.logger
        defaultTimeoutMs = b.defaultTimeoutMs
        postRequestsTimeout = b.postRequestsTimeout
    }

    override fun toString() = "ApiConfig(" +
            "callsPerSecondLimit=$callsPerSecondLimit, " +
            "httpApiHost='$httpApiHost', " +
            "deviceId='$deviceId', " +
            "lang='$lang', " +
            "accessToken='$accessToken', " +
            "secret='$secret', " +
            "version='$version', " +
            "logFilterCredentials=$logFilterCredentials, " +
            "defaultTimeoutMs=$defaultTimeoutMs," +
            "postRequestsTimeout=$postRequestsTimeout)"

    companion object {
        const val DEFAULT_DOMAIN = "vk.com"
        const val DEFAULT_API_VERSION = "5.90"
        const val DEFAULT_API_DOMAIN = "api.vk.com"
    }
}