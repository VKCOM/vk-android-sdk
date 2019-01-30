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
import com.vk.api.sdk.exceptions.VKApiIllegalResponseException
import com.vk.api.sdk.utils.ExponentialBackoff

class InternalErrorRetryChainCall<T>(manager: VKApiManager, retryLimit: Int, val chain: ChainCall<T>) :
        RetryChainCall<T>(manager, retryLimit) {

    private val backoff = ExponentialBackoff(minDelayMs = 1000, maxDelayMs = 60 * 1000, factor = 1.5f)

    @Throws(Exception::class)
    override fun call(args: ChainArgs): T? {
        var latestException: Exception? = null
        while (retryLimit < 0 || backoff.errorsCount <= retryLimit) {
            if (backoff.shouldWait()) {
                Thread.sleep(backoff.delayMs)
            }
            try {
                return chain.call(args)
            } catch (ex: VKApiExecutionException) {
                if (ex.isInternalServerError) {
                    logWarning("", ex)
                    latestException = ex
                    backoff.onError()
                } else {
                    throw ex
                }
            } catch (ex: VKApiIllegalResponseException) {
                logWarning("", ex)
                latestException = ex
                backoff.onError()
            }
        }

        throw when (latestException) {
            null -> VKApiException("api-call failed due to retry limits, but no exception has tracked")
            else -> latestException
        }
    }

}