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
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException

internal class TooManyRequestRetryChainCall<T>(manager: VKApiManager, retryLimit: Int, val chain: ChainCall<T>) : RetryChainCall<T>(manager, retryLimit) {
    @Throws(Exception::class)
    override fun call(args: ChainArgs): T? {
        var sleepByTooManyRequest = false
        for (i in 0..retryLimit) {
            if (sleepByTooManyRequest) {
                Thread.sleep(TIMEOUT)
            }
            try {
                return chain.call(args)
            } catch (ex: VKApiExecutionException) {
                if (ex.isTooManyRequestsError) {
                    logDebug("Too many requests", ex)
                    sleepByTooManyRequest = true
                } else {
                    throw ex
                }
            }
        }
        throw VKApiException("Can't handle too many requests due to retry limit!")
    }

    companion object {
        private const val TIMEOUT: Long = 1100
    }
}