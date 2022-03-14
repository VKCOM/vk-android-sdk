package com.vk.api.sdk.chain

import com.vk.api.sdk.VKApiManager

abstract class RetryChainCall<T>(manager: VKApiManager, val retryLimit: Int) : ChainCall<T>(manager) {
    init {
        if (retryLimit < 0) throw IllegalArgumentException("retryLimit must be >= 0")
    }
}