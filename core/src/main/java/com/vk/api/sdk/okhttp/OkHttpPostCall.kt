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

import com.vk.api.sdk.VKHttpPostCall
import com.vk.api.sdk.internal.HttpMultipartEntry

open class OkHttpPostCall {
    open class Builder {
        var url: String = ""
            private set
        var isMultipart: Boolean = true
            private set
        var parts: MutableMap<String, HttpMultipartEntry> = HashMap()
            private set
        var timeoutMs: Long = 0

        fun url(url: String) = apply { this.url = url }
        fun multipart(multipart: Boolean) = apply { this.isMultipart = multipart }
        fun parts(parts: Map<String, HttpMultipartEntry>) = apply { this.parts.clear(); this.parts.putAll(parts) }
        fun timeout(timeout: Long) = apply { this.timeoutMs = timeout }

        open fun build() = OkHttpPostCall(this)
    }

    val url: String
    val isMultipart: Boolean
    val parts: Map<String, HttpMultipartEntry>
    val timeoutMs: Long

    protected constructor(b: Builder) {
        require(b.url.isNotBlank()) { "Illegal url value: url is blank." }
        require(b.timeoutMs >= 0) { "Illegal timeout value: ${b.timeoutMs}. It must be >= 0." }
        if (!b.isMultipart && b.parts.any { it.value !is HttpMultipartEntry.Text }) {
            throw IllegalStateException("Non multipart calls should consist of text arguments only")
        }
        this.url = b.url
        this.isMultipart = b.isMultipart
        this.parts = b.parts
        this.timeoutMs = b.timeoutMs
    }

    constructor(call: VKHttpPostCall) {
        this.url = call.url
        this.isMultipart = call.isMultipart
        this.parts = call.parts
        this.timeoutMs = call.timeoutMs
    }
}