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
data class VKApiConfig(val context: Context,
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
                       val callsPerSecondLimit: Int = 3,
                       val httpApiHost: Lazy<String>  = lazy { DEFAULT_API_DOMAIN },
                       val lang: String = "en") {

    companion object {
        const val DEFAULT_DOMAIN = "vk.com"
        const val DEFAULT_API_VERSION = "5.90"
        const val DEFAULT_API_DOMAIN = "api.vk.com"
    }
}