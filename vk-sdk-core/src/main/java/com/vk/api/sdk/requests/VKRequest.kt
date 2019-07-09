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

package com.vk.api.sdk.requests

import com.vk.api.sdk.internal.ApiCommand
import com.vk.api.sdk.*
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import org.json.JSONObject
import java.io.IOException
import java.util.LinkedHashMap

/**
 * Base class for making vk api requests
 * Override method name, parameters and response parser
 * Use sdk sample as an example
 * If you need more flexibility, use ApiCommand
 */
open class VKRequest<T>(var method: String) : VKApiResponseParser<T>, ApiCommand<T>() {
    val params = LinkedHashMap<String, String>()

    // Params

    fun addParam(name: String, value: String?) = apply { if (value != null) params[name] = value }
    fun addParam(name: String, value: Int) = apply { if (value != 0) params[name] = Integer.toString(value) }
    fun addParam(name: String, value: Long) = apply { if (value != 0L) params[name] = java.lang.Long.toString(value) }
    fun addParam(name: CharSequence, values: Array<*>) = addParam(name.toString(), values.joinToString(","))
    fun addParam(name: CharSequence, values: Iterable<*>) = addParam(name.toString(), values.joinToString(","))
    fun addParam(name: CharSequence, values: IntArray) = addParam(name.toString(), values.joinToString(","))

    @Throws(VKApiException::class)
    override fun parse(response: String): T {
        try {
            return parse(JSONObject(response))
        } catch (e: Throwable) {
            throw VKApiExecutionException(ERROR_MALFORMED_RESPONSE, method, true,
                    "[$method] ${e.localizedMessage}")
        }
    }

    /**
     * The method you need to override to implement response parsing
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(Exception::class)
    open fun parse(r: JSONObject): T {
        return r as T
    }

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    override fun onExecute(manager: VKApiManager): T {
        val config = manager.config

        params["lang"] = config.lang
        params["device_id"] = config.deviceId.value
        params["v"] = config.version

        return manager.execute(VKMethodCall.Builder()
                .args(params)
                .method(method)
                .version(config.version)
                .build(), this)
    }

    companion object {
        const val ERROR_MALFORMED_RESPONSE = -2
    }
}