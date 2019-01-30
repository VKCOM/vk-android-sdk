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

import com.vk.api.sdk.VKApiProgressListener
import com.vk.api.sdk.VKApiResponseParser
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.VKHttpPostCall
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.okhttp.OkHttpExecutor
import com.vk.api.sdk.okhttp.OkHttpPostCall
import com.vk.api.sdk.utils.hasSimpleError
import com.vk.api.sdk.utils.toSimpleError

class HttpPostChainCall<T>(manager: VKApiManager,
                           val okHttpExecutor: OkHttpExecutor,
                           val call: VKHttpPostCall,
                           val progressListener: VKApiProgressListener?,
                           val parser: VKApiResponseParser<T>?) : ChainCall<T>(manager) {
    @Throws(Exception::class)
    override fun call(args: ChainArgs): T? {
        val response = okHttpExecutor.execute(OkHttpPostCall(call), progressListener)
        return when {
            response == null -> throw VKApiException("Response returned null instead of valid string response")
            response.hasSimpleError() -> throw response.toSimpleError("post")
            else -> parser?.parse(response)
        }
    }

}