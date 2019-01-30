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

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Wrapper for okhttp
 */
abstract class VKOkHttpProvider {
    interface BuilderUpdateFunction {
        fun update(builder: OkHttpClient.Builder): OkHttpClient.Builder
    }

    abstract fun getClient(): OkHttpClient
    abstract fun updateClient(f: BuilderUpdateFunction)

    class DefaultProvider : VKOkHttpProvider() {
        @Volatile
        private var okHttpClient: OkHttpClient? = null

        override fun getClient(): OkHttpClient {
            if (okHttpClient == null) {
                okHttpClient = OkHttpClient().newBuilder()
                        .connectTimeout(20, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(20, TimeUnit.SECONDS)
                        .followRedirects(true)
                        .followSslRedirects(true)
                        .build()
            }
            return okHttpClient!!
        }

        override fun updateClient(f: VKOkHttpProvider.BuilderUpdateFunction) {
            if (okHttpClient != null) {
                okHttpClient = f.update(okHttpClient!!.newBuilder()).build()
            }
        }
    }
}