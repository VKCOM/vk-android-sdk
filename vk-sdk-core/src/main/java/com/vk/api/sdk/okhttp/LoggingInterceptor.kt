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

import android.support.v4.util.ArrayMap
import com.vk.api.sdk.utils.log.Logger
import com.vk.api.sdk.utils.getValue
import com.vk.api.sdk.utils.threadLocal
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptor(private val filterCredentials: Boolean, private val logger: Logger) : Interceptor {
    private val delegate by threadLocal {
        HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                val finalMessage = if (filterCredentials) filterCredentials(message) else message
                logger.log(logger.logLevel.value, finalMessage)
            }

            private fun filterCredentials(msg: String): String {
                return msg
                        .replace("access_token=[a-z0-9]+".toRegex(), "access_token=<HIDE>")
                        .replace("key=[a-z0-9]+".toRegex(), "key=<HIDE>")
            }
        })
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        // Do not log big bodies because of probability of OutOfMemoryError
        val bodyLength = chain.request().body()?.contentLength() ?: 0
        delegate.level =
                if (bodyLength > 1024L) HttpLoggingInterceptor.Level.BASIC
                else LogLevelMap.levelsMap[logger.logLevel.value]
        return delegate.intercept(chain)
    }

    object LogLevelMap {
        val levelsMap = ArrayMap<Logger.LogLevel, HttpLoggingInterceptor.Level>()
        init {
            levelsMap[Logger.LogLevel.NONE] = HttpLoggingInterceptor.Level.NONE
            levelsMap[Logger.LogLevel.ERROR] = HttpLoggingInterceptor.Level.NONE
            levelsMap[Logger.LogLevel.WARNING] = HttpLoggingInterceptor.Level.BASIC
            levelsMap[Logger.LogLevel.DEBUG] = HttpLoggingInterceptor.Level.HEADERS
            levelsMap[Logger.LogLevel.VERBOSE] = HttpLoggingInterceptor.Level.BODY
        }
    }
}