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

import android.net.Uri
import com.vk.api.sdk.internal.HttpMultipartEntry

/**
 * This class can be used for uploading files to server
 */
open class VKHttpPostCall {
    open class Builder {
        var url: String = ""
            private set
        var parts: MutableMap<String, HttpMultipartEntry> = HashMap()
            private set
        var retryCount: Int = Int.MAX_VALUE
            private set
        var timeoutMs: Long = 0
            private set

        open fun url(url: String) = apply { this.url = url }
        open fun args(key: String, value: String) = apply { parts[key] = HttpMultipartEntry.Text(value) }
        open fun args(key: String, fileUri: Uri) = apply { parts[key] = HttpMultipartEntry.File(fileUri) }
        open fun args(key: String, fileUri: Uri, fileName: String) = apply { parts[key] = HttpMultipartEntry.File(fileUri, fileName) }
        open fun retryCount(count: Int) = apply { this.retryCount = count }
        open fun timeout(timeout: Long) = apply { this.timeoutMs = timeout }

        open fun build() = VKHttpPostCall(this)
    }

    val url: String
    val parts: Map<String, HttpMultipartEntry>
    val retryCount: Int
    val timeoutMs: Long

    protected constructor(b: Builder) {
        if (b.url.isBlank()) throw IllegalArgumentException("Illegal url value: ${b.url}")
        if (b.timeoutMs < 0) throw IllegalArgumentException("Illegal timeout value: ${b.timeoutMs}")
        this.url = b.url
        this.parts = b.parts
        this.retryCount = b.retryCount
        this.timeoutMs = b.timeoutMs
    }
}