package com.vk.api.sdk.utils.tmr

interface TooManyRequestLimitBackoff {
    fun waitBeforeCall(
        maxRetryCount: Int,
        maxRetryTime: Long
    )
}
