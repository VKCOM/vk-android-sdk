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

package com.vk.api.sdk.chain

import com.vk.api.sdk.VKApiResponseParser
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.okhttp.OkHttpExecutor
import com.vk.api.sdk.okhttp.OkHttpMethodCall
import com.vk.api.sdk.utils.hasExecuteError
import com.vk.api.sdk.utils.hasSimpleError
import com.vk.api.sdk.utils.toExecuteError
import com.vk.api.sdk.utils.toSimpleError

open class MethodChainCall<T>(
        manager: VKApiManager,
        val okHttpExecutor: OkHttpExecutor,
        val callBuilder: OkHttpMethodCall.Builder,
        var defaultDeviceId: String,
        val defaultLang: String,
        val parser: VKApiResponseParser<T>?) : ChainCall<T>(manager) {

    @Throws(Exception::class)
    override fun call(args: ChainArgs): T? {
        if (args.hasCaptcha()) {
            callBuilder
                    .args(VKApiCodes.EXTRA_CAPTCHA_SID, args.captchaSid)
                    .args(VKApiCodes.EXTRA_CAPTCHA_KEY, args.captchaKey)
        }

        if (args.userConfirmed) {
            callBuilder.args(VKApiCodes.EXTRA_CONFIRM, "1")
        }

        var deviceId = callBuilder.args(VKApiCodes.PARAM_DEVICE_ID) ?: ""
        if (deviceId.isBlank()) {
            deviceId = defaultDeviceId
        }
        callBuilder.args(VKApiCodes.PARAM_DEVICE_ID, deviceId.toLowerCase())

        var lang = callBuilder.args(VKApiCodes.PARAM_LANG) ?: ""
        if (lang.isBlank()) {
            lang = defaultLang
        }
        callBuilder.args(VKApiCodes.PARAM_LANG, lang.toLowerCase())

        return runRequest(callBuilder.build())
    }

    open fun runRequest(mc: OkHttpMethodCall) = parseResult(okHttpExecutor.execute(mc), mc.method, null)

    fun parseResult(response: String?, methodName: String, ignoredExecuteErrors: IntArray?) = when {
        response == null -> throw VKApiException("Response returned null instead of valid string response")
        response.hasSimpleError() -> throw response.toSimpleError(methodName)
        response.hasExecuteError(ignoredExecuteErrors) -> throw response.toExecuteError(methodName, ignoredExecuteErrors)
        else -> parser?.parse(response)
    }
}