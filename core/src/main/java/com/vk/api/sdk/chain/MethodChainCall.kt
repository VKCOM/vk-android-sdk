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

package com.vk.api.sdk.chain

import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.VKApiResponseParser
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.okhttp.OkHttpExecutor
import com.vk.api.sdk.okhttp.OkHttpMethodCall
import com.vk.api.sdk.utils.hasExecuteError
import com.vk.api.sdk.utils.hasSimpleError
import com.vk.api.sdk.utils.toExecuteError
import com.vk.api.sdk.utils.toSimpleError
import java.util.*

open class MethodChainCall<T>(
        manager: VKApiManager,
        val okHttpExecutor: OkHttpExecutor,
        val callBuilder: OkHttpMethodCall.Builder,
        var defaultDeviceId: String,
        val defaultLang: String,
        val parser: VKApiResponseParser<T>?) : ChainCall<T>(manager) {

    private val responseValidator = manager.config.responseValidator

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
        callBuilder.args(VKApiCodes.PARAM_DEVICE_ID, deviceId.toLowerCase(Locale.getDefault()))

        var lang = callBuilder.args(VKApiCodes.PARAM_LANG) ?: ""
        if (lang.isBlank()) {
            lang = defaultLang
        }
        callBuilder.args(VKApiCodes.PARAM_LANG, lang.toLowerCase(Locale.getDefault()))

        return runRequest(callBuilder.build())
    }

    open fun runRequest(mc: OkHttpMethodCall): T? {
        return parseResult(okHttpExecutor.execute(mc), mc.method, mc.isExtended(), null)
    }

    fun parseResult(
        methodResponse: OkHttpExecutor.MethodResponse,
        methodName: String,
        extended: Boolean,
        ignoredExecuteErrors: IntArray?
    ): T? {
        val response = methodResponse.response
        return when {
            response == null -> throw VKApiException("Response returned null instead of valid string response")
            response.hasSimpleError() -> throw response.toSimpleError(methodName, methodResponse.executorRequestAccessToken)
            response.hasExecuteError(ignoredExecuteErrors) -> throw response.toExecuteError(methodName, ignoredExecuteErrors)
            else -> {
                try {
                    responseValidator?.value?.validateResponse(methodName, extended, response, methodResponse.headers)
                } catch (ignore: Throwable) {}

                parser?.parse(response)
            }
        }
    }
}