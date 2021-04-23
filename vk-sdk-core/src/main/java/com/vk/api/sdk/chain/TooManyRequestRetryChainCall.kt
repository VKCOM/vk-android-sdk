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

import android.os.SystemClock
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.utils.ExponentialBackoff
import java.util.*

internal class TooManyRequestRetryChainCall<T>(manager: VKApiManager, retryLimit: Int, val chain: ChainCall<T>) : RetryChainCall<T>(manager, retryLimit) {
    @Throws(Exception::class)
    override fun call(args: ChainArgs): T? {
        for (i in 0..retryLimit) {
            Backoff.waitBeforeCall()
            try {
                val result = chain.call(args)
                Backoff.reset()
                return result
            } catch (ex: VKApiExecutionException) {
                if (ex.isTooManyRequestsError) {
                    logDebug("Too many requests", ex)
                    Backoff.backoff()
                } else {
                    throw ex
                }
            }
        }
        throw VKApiException("Can't handle too many requests due to retry limit! (retryLimit=$retryLimit)")
    }

    private object Backoff {
        const val TIMEOUT: Long = 1000
        private val bf = ExponentialBackoff(minDelayMs = TIMEOUT, maxDelayMs = TIMEOUT * 8, factor = 1.2f)

        private const val MAX_CALLS_PER_SECOND = 4
        private const val SECOND_IN_MILLIS = 1000
        private val lastTimestamps = ArrayDeque<Long>().apply { // used in synchronized method
            repeat(MAX_CALLS_PER_SECOND) {
                addLast(0)
            }
        }

        @Synchronized
        fun waitBeforeCall() {
            bf.waitIfNeeded()

            val currentTimestamp = SystemClock.elapsedRealtime()
            lastTimestamps.addLast(currentTimestamp)
            val firstTimestamp = lastTimestamps.removeFirst()

            val waitFor = SECOND_IN_MILLIS - (currentTimestamp - firstTimestamp)
            if (waitFor > 0) {
                Thread.sleep(waitFor)
            }
        }

        @Synchronized
        fun backoff() = bf.onError()

        @Synchronized
        fun reset() = bf.reset()
    }
}