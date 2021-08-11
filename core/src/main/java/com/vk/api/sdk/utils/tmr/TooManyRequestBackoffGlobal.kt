package com.vk.api.sdk.utils.tmr

import android.os.SystemClock
import java.util.ArrayDeque

/**
 * Для блокировки запросов используется Circular buffer
 */
object TooManyRequestBackoffGlobal : TooManyRequestLimitBackoff {

    private val lastTimestamps = ArrayDeque<Long>()

    @Synchronized
    override fun waitBeforeCall(
        maxRetryCount: Int,
        maxRetryTime: Long
    ) {
        fillIfNeeded(maxRetryCount)

        val currentTimestamp = SystemClock.elapsedRealtime()
        lastTimestamps.addLast(currentTimestamp)
        val firstTimestamp = lastTimestamps.removeFirst()

        val waitFor = maxRetryTime - (currentTimestamp - firstTimestamp)
        if (waitFor > 0) {
            Thread.sleep(waitFor)
        }
    }

    @Synchronized
    private fun fillIfNeeded(maxRequest: Int) {
        if (maxRequest == lastTimestamps.size) {
            return
        }

        if (maxRequest > lastTimestamps.size) {
            val diff = maxRequest - lastTimestamps.size
            repeat(diff) {
                lastTimestamps.addFirst(0L)
            }
        } else {
            val diff = lastTimestamps.size - maxRequest
            repeat(diff) {
                lastTimestamps.removeFirst()
            }
        }
    }
}