package com.vk.api.sdk.utils.tmr

object TooManyRequestBackoffEmpty : TooManyRequestLimitBackoff {
    override fun waitBeforeCall(maxRetryCount: Int, maxRetryTime: Long) {
        // DO NOTHING
    }
}
