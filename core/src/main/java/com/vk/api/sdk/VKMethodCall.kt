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

/**
 * This class contains info about api request
 */
open class VKMethodCall {
    open class Builder {
        var requestUrl: String? = null
            private set
        var method: String = ""
            private set
        var version: String = ""
            private set
        var args: MutableMap<String,String> = LinkedHashMap()
            private set
        var retryCount: Int = DEFAULT_RETRY_COUNT
            private set
        var skipValidation: Boolean = false
            private set
        var isAwaitNetwork: Boolean = false
            private set
        var ignoreExecuteErrors: IntArray? = null
            private set
        var allowNoAuth: Boolean = false
            private set
        var isAnonymous: Boolean = false
            private set

        open fun url(url: String?) = apply { this.requestUrl = url }
        /**
         * Api method name
         * You can find all methods here: https://vk.com/dev/methods
         */
        open fun method(method: String) = apply { this.method = method }
        open fun version(version: String) = apply { this.version = version }
        open fun args(args: Map<String,String>) = apply { this.args.putAll(args) }
        open fun args(key: String, value: String) = apply { this.args[key] = value }
        open fun args(key: String, value: Boolean) = apply { this.args[key] = if (value) "1" else "0" }
        open fun args(key: String, value: Any) = apply { this.args[key] = value.toString() }
        open fun retryCount(count: Int) = apply { this.retryCount = count }
        open fun skipValidation(skip: Boolean) = apply { this.skipValidation = skip }
        open fun awaitNetwork(isAwaitNetwork: Boolean) = apply { this.isAwaitNetwork = isAwaitNetwork }
        open fun ignoreExecuteErrors(ignoredErrors: IntArray?) = apply { this.ignoreExecuteErrors = ignoredErrors }
        open fun allowNoAuth(allowNoAuth: Boolean) = apply { this.allowNoAuth = allowNoAuth }
        open fun setAnonymous(allow: Boolean) = apply { this.isAnonymous = allow }

        open fun build() = VKMethodCall(this)
    }

    val requestUrl: String?
    val method: String
    val version: String
    val args: Map<String,String>
    val retryCount: Int
    val skipValidation: Boolean
    val isAwaitNetwork: Boolean
    val allowNoAuth: Boolean
    val isAnonymous: Boolean
    val ignoreExecuteErrors: IntArray?

    protected constructor(b: Builder) {
        if (b.method.isBlank()) throw IllegalArgumentException("method is null or empty")
        if (b.version.isBlank()) throw IllegalArgumentException("version is null or empty")
        this.requestUrl = b.requestUrl
        this.method = b.method
        this.version = b.version
        this.args = b.args
        this.retryCount = b.retryCount
        this.skipValidation = b.skipValidation
        this.isAwaitNetwork = b.isAwaitNetwork
        this.ignoreExecuteErrors = b.ignoreExecuteErrors
        this.allowNoAuth = b.allowNoAuth
        this.isAnonymous = b.isAnonymous
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as VKMethodCall
        if (method != other.method) return false
        if (args != other.args) return false
        return true
    }
    override fun hashCode() = 31 * method.hashCode() + args.hashCode()
    override fun toString() = "VKMethodCall(method='$method', args=$args)"

    companion object {
        const val DEFAULT_RETRY_COUNT = 4
    }
}