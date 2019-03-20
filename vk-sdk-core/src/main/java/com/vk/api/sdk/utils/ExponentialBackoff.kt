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

package com.vk.api.sdk.utils

import java.util.*
import java.util.concurrent.TimeUnit

open class ExponentialBackoff(private val minDelayMs: Long = TimeUnit.MILLISECONDS.toMillis(100),
                         private val maxDelayMs: Long = TimeUnit.MINUTES.toMillis(5),
                         private val factor: Float = 2f,
                         private val jitter: Float = 0.1f) {
    private val random = Random(System.currentTimeMillis())
    var delayMs = minDelayMs
        private set
    var errorsCount = 0
        private set

    fun shouldWait() = errorsCount > 0

    fun reset() {
        delayMs = minDelayMs
        errorsCount = 0
    }

    fun onError() = increase()

    fun increase() {
        delayMs = Math.min(delayMs * factor, maxDelayMs.toFloat()).toLong()
        delayMs += variance(delayMs * jitter)
        errorsCount++
    }

    private fun variance(std: Float) = (random.nextGaussian() * std).toLong()

    companion object {
        @JvmStatic
        fun forNetworkWait() = ExponentialBackoff(minDelayMs = 500, maxDelayMs = 60000, factor = 1.5f)
    }
}