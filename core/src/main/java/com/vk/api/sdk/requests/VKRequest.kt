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

package com.vk.api.sdk.requests

import com.vk.api.sdk.VKApiConfig
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.VKApiResponseParser
import com.vk.api.sdk.VKMethodCall
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.internal.ApiCommand
import com.vk.dto.common.id.UserId
import org.json.JSONObject
import java.io.IOException
import java.util.*

/**
 * Base class for making vk api requests
 * Override method name, parameters and response parser
 * Use sdk sample as an example
 * If you need more flexibility, use ApiCommand
 */
open class VKRequest<T>(var method: String, val requestApiVersion: String? = null) : VKApiResponseParser<T>, ApiCommand<T>() {

    @Volatile
    protected var allowNoAuth: Boolean = false

    @Volatile
    protected var isAnonymous: Boolean = false
        private set

    val params = LinkedHashMap<String, String>()

    // Params

    fun addParam(name: String, value: String?) = apply { if (value != null) params[name] = value }
    fun addParam(name: String, value: Boolean) = apply { params[name] = if (value) "1" else "0" }
    fun addParam(name: String, value: Int) = apply { if (value != 0) params[name] = Integer.toString(value) }
    fun addParam(name: String, value: Long) = apply { if (value != 0L) params[name] = java.lang.Long.toString(value) }
    fun addParam(name: String, value: Float) = apply { if (value != 0f) params[name] = java.lang.Float.toString(value) }
    fun addParam(name: CharSequence, values: Array<*>) = addParam(name.toString(), values.joinToString(","))
    fun addParam(name: CharSequence, values: Iterable<*>) = addParam(name.toString(), values.joinToString(","))
    fun addParam(name: CharSequence, values: IntArray) = addParam(name.toString(), values.joinToString(","))
    fun addParam(name: String, value: UserId?) = apply { if (value != null) params[name] = value.value.toString() }
    fun addParam(name: CharSequence, values: List<UserId>) = addParam(name.toString(), values.joinToString(",", transform = { it.value.toString() }))

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
        val version = requestApiVersion ?: config.version
        params["lang"] = config.lang
        params["device_id"] = config.deviceId.value
        config.externalDeviceId.value?.let { params["external_device_id"] = it }
        params["v"] = version

        val callBuilder = createBaseCallBuilder(config)
                .args(params)
                .method(method)
                .version(version)
                .setAnonymous(isAnonymous)
                .allowNoAuth(allowNoAuth)
        return manager.execute(callBuilder.build(), this)
    }

    /**
     * It's safe to call this method without user credentials
     */
    open fun allowNoAuth() = apply { allowNoAuth = true }

    open fun setAnonymous(allow: Boolean) = apply { isAnonymous = allow }

    protected open fun createBaseCallBuilder(config: VKApiConfig): VKMethodCall.Builder {
        return VKMethodCall.Builder()
    }

    companion object {
        const val ERROR_MALFORMED_RESPONSE = -2
    }
}