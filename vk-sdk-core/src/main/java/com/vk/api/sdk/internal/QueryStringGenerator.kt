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

package com.vk.api.sdk.internal

import com.vk.api.sdk.okhttp.OkHttpMethodCall
import com.vk.api.sdk.utils.getValue
import com.vk.api.sdk.utils.threadLocal
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.security.MessageDigest

object QueryStringGenerator {

    private val strBuilder by threadLocal { StringBuilder() }

    fun buildQueryString(accessToken: String?, secret: String?, appId: Int, call: OkHttpMethodCall) =
            buildQueryString(accessToken, secret, appId, call.method, call.version, call.args)

    fun buildQueryString(accessToken: String?,
                         secret: String?,
                         appId: Int,
                         method: String,
                         version: String,
                         args: Map<String, String>): String {
        if (secret.isNullOrEmpty()) {
            return generateQueryString(version, args, accessToken, appId,true)
        }
        val queryStringUnescaped = generateQueryString(version, args, accessToken, appId,false)
        val sigArgs = "/method/$method?$queryStringUnescaped$secret"
        val md5 = md5(sigArgs)
        val queryStringEscaped = generateQueryString(version, args, accessToken, appId,true)
        return "$queryStringEscaped&sig=$md5"
    }

    private fun generateQueryString(version: String,
                                    args: Map<String, String>,
                                    accessToken: String?,
                                    appId: Int,
                                    isApplyUrlEncode: Boolean): String {
        // Don't worry StringBuilder.plus operator fun used
        strBuilder.clear()
        var sb = strBuilder + "v=" + version + "&https=1&"
        for ((key, value) in args) {
            if (key != "v" && key != "access_token" && key != "api_id") {
                sb = sb.plus(key) + "=" + value.encodeUrlAsUtf8(isApplyUrlEncode) + "&"
            }
        }
        sb = if (!accessToken.isNullOrEmpty()) {
            sb + "access_token=" + accessToken + "&"
        } else if (appId != 0) {
            sb + "api_id=" + appId.toString() + "&"
        } else {
            sb + "&"
        }
        sb.setLength(sb.length - 1)
        return sb.toString()
    }

    private fun String.encodeUrlAsUtf8(applyUrlEncode: Boolean): String {
        if (!applyUrlEncode) {
            return this
        }
        try {
            return URLEncoder.encode(this, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            throw RuntimeException(e)
        }
    }

    private operator fun StringBuilder.plus(str: String) = this.append(str)

    private fun StringBuilder.clear() = this.setLength(0)

    @Deprecated(message = "Use common method", replaceWith = ReplaceWith("VKUtils.MD5.convert"))
    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        val digested = md.digest(input.toByteArray())
        return digested.joinToString("") {
            String.format("%02x", it)
        }
    }
}