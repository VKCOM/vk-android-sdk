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

import com.vk.api.sdk.VKApiConfig
import com.vk.api.sdk.VKMethodCall

open class OkHttpMethodCall {
    open class Builder {
        var requestUrl: String? = null
            private set
        var endpointPath: VKApiConfig.EndpointPathName = VKApiConfig.EndpointPathName.METHOD
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
        open fun setEndpointPath(urlMethodName: VKApiConfig.EndpointPathName) = apply { this.endpointPath = urlMethodName }
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
            setEndpointPath(call.endpointPath)
        }

        open fun build() = OkHttpMethodCall(this)
    }

    val requestUrl: String?
    val setEndpointPath: VKApiConfig.EndpointPathName
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
        this.setEndpointPath = b.endpointPath
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