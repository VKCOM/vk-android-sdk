package com.vk.api.sdk.chain

import android.content.Context
import android.os.SystemClock
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.RateLimitReachedException
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.utils.RateLimitTokenBackoff

/**
 * chain call which handles [VKApiCodes.CODE_RATE_LIMIT_REACHED] error code
 * for now if we receive that code we don't have to call this method for the next backoff time
 * in most cases normal back off time is 1 hour
 *
 * if backoff time for the current method is not over we throw our custom [RateLimitReachedException]
 * and don't do real api method call
 *
 * @param manager - [VKApiManager] instance
 * @param method - method name
 * @param chainCall - current [ChainCall]
 */
class RateLimitReachedChainCall<T>(
    manager: VKApiManager,
    private val method: String,
    private val backoff: RateLimitTokenBackoff,
    private val chainCall: ChainCall<T>
): ChainCall<T>(manager) {

    override fun call(args: ChainArgs): T? {
        if (backoff.shouldWait(method)) {
            throw RateLimitReachedException(method, DETAIL_MESSAGE)
        }

        backoff.reset(method)
        try {
            return chainCall.call(args)
        } catch (ex: VKApiExecutionException) {
            if (ex.isRateLimitReachedError) {
                backoff.backoff(method)
                logDebug(DETAIL_MESSAGE, ex)
            }
            throw ex
        }
    }

    companion object {
        private const val DETAIL_MESSAGE = "Rate limit reached."
    }
}