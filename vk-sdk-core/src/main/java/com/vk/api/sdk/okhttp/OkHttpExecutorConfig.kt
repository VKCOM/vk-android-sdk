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

import android.content.Context
import com.vk.api.sdk.VKApiConfig
import com.vk.api.sdk.VKOkHttpProvider
import com.vk.api.sdk.internal.Validation
import com.vk.api.sdk.utils.log.Logger

@Suppress("ConvertSecondaryConstructorToPrimary")
class OkHttpExecutorConfig(private val apiConfig: VKApiConfig) {
    val context: Context
        get() = apiConfig.context
    val appId: Int
        get() = apiConfig.appId
    val host: String
        get() = apiConfig.httpApiHost.value
    val accessToken: String
        get() = apiConfig.accessToken.value
    val secret: String?
        get() = apiConfig.secret.value
    val okHttpProvider: VKOkHttpProvider
        get() = apiConfig.okHttpProvider
    val logFilterCredentials: Boolean
        get() = apiConfig.logFilterCredentials
    val defaultTimeoutMs: Long
        get() = apiConfig.defaultTimeoutMs
    val postRequestsTimeout: Long
        get() = apiConfig.postRequestsTimeout
    val logger: Logger
        get() = apiConfig.logger

    init {
        Validation.assertContextValid(context)
        Validation.assertHttpHostValid(host)
        Validation.assertAccessTokenValid(accessToken)
    }

    override fun toString() = "OkHttpExecutorConfig(" +
            "host='$host', " +
            "accessToken='$accessToken', " +
            "secret='$secret', " +
            "logFilterCredentials=$logFilterCredentials)"

}