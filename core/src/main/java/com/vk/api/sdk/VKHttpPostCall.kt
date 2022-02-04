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
        var isMultipart: Boolean = true
            private set
        var parts: MutableMap<String, HttpMultipartEntry> = HashMap()
            private set
        var retryCount: Int = Int.MAX_VALUE
            private set
        var timeoutMs: Long = 0
            private set
        var isAwaitNetwork: Boolean = false
            private set

        open fun url(url: String) = apply { this.url = url }
        open fun multipart(multipart: Boolean) = apply { this.isMultipart = multipart }
        open fun args(key: String, value: String) = apply { parts[key] = HttpMultipartEntry.Text(value) }
        open fun args(key: String, fileUri: Uri) = apply { parts[key] = HttpMultipartEntry.File(fileUri) }
        open fun args(key: String, fileUri: Uri, fileName: String) = apply { parts[key] = HttpMultipartEntry.File(fileUri, fileName) }
        open fun parts(parts: Map<String, HttpMultipartEntry>) = apply { this.parts.putAll(parts) }
        open fun retryCount(count: Int) = apply { this.retryCount = count }
        open fun timeout(timeout: Long) = apply { this.timeoutMs = timeout }
        open fun awaitNetwork(isAwaitNetwork: Boolean) = apply { this.isAwaitNetwork = isAwaitNetwork }

        open fun build() = VKHttpPostCall(this)
    }

    val url: String
    val isMultipart: Boolean
    val parts: Map<String, HttpMultipartEntry>
    val retryCount: Int
    val timeoutMs: Long
    val isAwaitNetwork: Boolean

    protected constructor(b: Builder) {
        if (b.url.isBlank()) throw IllegalArgumentException("Illegal url value: ${b.url}")
        if (b.timeoutMs < 0) throw IllegalArgumentException("Illegal timeout value: ${b.timeoutMs}")
        if (!b.isMultipart && b.parts.any { it.value !is HttpMultipartEntry.Text }) {
            throw IllegalStateException("Non multipart calls should consist of text arguments only")
        }
        this.url = b.url
        this.isMultipart = b.isMultipart
        this.parts = b.parts
        this.retryCount = b.retryCount
        this.timeoutMs = b.timeoutMs
        this.isAwaitNetwork = b.isAwaitNetwork
    }
}