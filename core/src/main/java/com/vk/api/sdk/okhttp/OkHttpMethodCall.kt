/**
 * Copyright (c) 2020 - present, LLC “V Kontakte”
 *
 * 1. Permission is hereby granted to any person obtaining a copy of this Software to
 * use the Software without charge.
 *
 * 2. Restrictions
 * You may not modify, merge, publish, distribute, sublicense, and/or sell copies,
 * create derivative works based upon the Software or any part thereof.
 *
 * 3. Termination
 * This License is effective until terminated. LLC “V Kontakte” may terminate this
 * License at any time without any negative consequences to our rights.
 * You may terminate this License at any time by deleting the Software and all copies
 * thereof. Upon termination of this license for any reason, you shall continue to be
 * bound by the provisions of Section 2 above.
 * Termination will be without prejudice to any rights LLC “V Kontakte” may have as
 * a result of this agreement.
 *
 * 4. Disclaimer of warranty and liability
 * THE SOFTWARE IS MADE AVAILABLE ON THE “AS IS” BASIS. LLC “V KONTAKTE” DISCLAIMS
 * ALL WARRANTIES THAT THE SOFTWARE MAY BE SUITABLE OR UNSUITABLE FOR ANY SPECIFIC
 * PURPOSES OF USE. LLC “V KONTAKTE” CAN NOT GUARANTEE AND DOES NOT PROMISE ANY
 * SPECIFIC RESULTS OF USE OF THE SOFTWARE.
 * UNDER NO CIRCUMSTANCES LLC “V KONTAKTE” BEAR LIABILITY TO THE LICENSEE OR ANY
 * THIRD PARTIES FOR ANY DAMAGE IN CONNECTION WITH USE OF THE SOFTWARE.
*/
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

import com.vk.api.sdk.VKMethodCall

open class OkHttpMethodCall {
    open class Builder {
        var requestUrl: String? = null
            private set
        var method: String = ""
            private set
        var version: String = ""
            private set
        var args: MutableMap<String,String> = HashMap()
            private set
        var tag: RequestTag? = null
            private set
        var customTag: Any? = null
            private set
        var allowNoAuth: Boolean = false
            private set
        var retryCount = VKMethodCall.DEFAULT_RETRY_COUNT
            private set

        open fun url(url: String?) = apply { this.requestUrl = url }
        open fun method(method: String) = apply { this.method = method }
        open fun version(version: String) = apply { this.version = version }

        open fun args(args: Map<String,String>) = apply { this.args.putAll(args) }
        open fun args(key: String, value: String) = apply { this.args.put(key,value) }
        fun args(key: String) = this.args[key]

        fun tag(requestTag: RequestTag?) = apply { this.tag = requestTag }
        fun customTag(tag: Any?) = apply { this.customTag = tag }

        fun allowNoAuth(allow: Boolean) = apply { this.allowNoAuth = allow }

        fun retryCount(count: Int) = apply { this.retryCount = count }

        open fun from(call: VKMethodCall) = apply {
            method(call.method)
            version(call.version)
            args(call.args)
            allowNoAuth(call.allowNoAuth)
            retryCount(call.retryCount)
            url(call.requestUrl)
        }

        open fun build() = OkHttpMethodCall(this)
    }

    val requestUrl: String?
    val method: String
    val version: String
    val args: Map<String,String>
    val tag: RequestTag?
    val customTag: Any?
    val allowNoAuth: Boolean
    val retryCount: Int

    protected constructor(b: Builder) {
        if (b.method.isBlank()) throw IllegalArgumentException("method is null or empty")
        if (b.version.isBlank()) throw IllegalArgumentException("version is null or empty")
        this.requestUrl = b.requestUrl
        this.method = b.method
        this.version = b.version
        this.args = b.args
        this.tag = b.tag
        this.customTag = b.customTag
        this.allowNoAuth= b.allowNoAuth
        this.retryCount = b.retryCount
    }

    fun isExtended() = args["extended"] == "true" || args["extended"] == "1"
}