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

import com.vk.api.sdk.utils.log.Logger
import com.vk.api.sdk.utils.log.Logger.*
import com.vk.api.sdk.utils.threadLocal
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import java.util.Collections.min

class LoggingInterceptor(
    private val filterCredentials: Boolean,
    private val keysToFilter: Collection<String>,
    private val logger: Logger
) : Interceptor {
    // For backward compatibility
    constructor(filterCredentials: Boolean, logger: Logger) : this(
        filterCredentials,
        listOf("access_token", "key", "client_secret"),
        logger
    )

    // (key1|key2|...)=[a-z0-9]+
    private val sensitiveKeysRequestRegex: Regex by lazy {
        val pattern = StringBuilder().apply {
            append("(")
            append(keysToFilter.joinToString("|"))
            append(")=[a-z0-9]+")
        }.toString()

        Regex(pattern, RegexOption.IGNORE_CASE)
    }
    private val sensitiveKeyRequestTransformer: (MatchResult) -> CharSequence by lazy {
        { match: MatchResult ->
            "${match.groupValues[1]}=<HIDE>"
        }
    }

    // "(key1|key2|...)":[a-z0-9]+
    private val sensitiveKeysResponseRegex: Regex by lazy {
        val pattern = StringBuilder().apply {
            append("\"(")
            append(keysToFilter.joinToString("|"))
            append(")\":\"[a-z0-9]+\"")
        }.toString()

        Regex(pattern, RegexOption.IGNORE_CASE)
    }
    private val sensitiveKeysResponseTransformer: (MatchResult) -> CharSequence by lazy {
        { match: MatchResult ->
            "\"${match.groupValues[1]}\":<HIDE>"
        }
    }

    private val delegate by threadLocal {
        HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                val finalMessage = if (filterCredentials) filterCredentials(message) else message
                logger.log(logger.logLevel.value, finalMessage)
            }

            private fun filterCredentials(msg: String): String {
                return removeSensitiveKeys(msg)
            }
        })
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        // Do not log big bodies because of probability of OutOfMemoryError
        val request = chain.request()
        val bodyLength = request.body?.contentLength() ?: 0
        val logLevel = request.tag(LogLevelRequestTag::class.java)?.level ?: logger.logLevel.value
        delegate.level = when (bodyLength > 64 || bodyLength <= 0) {
            true -> levelsMap[min(listOf(logLevel, LogLevel.WARNING))]
            else -> levelsMap[logLevel]
        }!!
        return delegate.intercept(chain)
    }

    private fun removeSensitiveKeys(msg: String): String {
        return msg
            .replace(sensitiveKeysRequestRegex, sensitiveKeyRequestTransformer)
            .replace(sensitiveKeysResponseRegex, sensitiveKeysResponseTransformer)
    }

    companion object {
        private val levelsMap = mapOf(
                LogLevel.NONE to Level.NONE,
                LogLevel.ERROR to Level.NONE,
                LogLevel.WARNING to Level.BASIC,
                LogLevel.DEBUG to Level.HEADERS,
                LogLevel.VERBOSE to Level.BODY,
                LogLevel.NONE to Level.NONE,
        )
    }
}