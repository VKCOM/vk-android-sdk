package com.vk.api.sdk.chain

import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.RateLimitReachedException
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.utils.TokenExponentialBackoff

/**
 * chain call which handles [VKApiCodes.CODE_RATE_LIMIT_REACHED] error code
 * for now if we receive that code we don't have to call this method for the next backoff time
 * in most cases normal back off time is 1 hour
 *
 * if backoff time for the current method is not over we throw our custom [RateLimitReachedException]
 * and don't do real api method call
 *
 * @param manager - [VKApiManager] instance
 * @param section - method name
 * @param chainCall - current [ChainCall]
 */
class RateLimitReachedChainCall<T>(
    manager: VKApiManager,
    private val section: String,
    private val backoff: TokenExponentialBackoff,
    private val chainCall: ChainCall<T>
): ChainCall<T>(manager) {

    override fun call(args: ChainArgs): T? {
        if (backoff.shouldWait(section)) {
            throw RateLimitReachedException(section, DETAIL_MESSAGE)
        }

        try {
            return chainCall.call(args).also {
                backoff.reset(section)
            }
        } catch (ex: VKApiExecutionException) {
            if (ex.isRateLimitReachedError) {
                backoff.backoff(section)
                logDebug(DETAIL_MESSAGE, ex)
            }
            throw ex
        }
    }

    companion object {
        private const val DETAIL_MESSAGE = "Rate limit reached."
    }
}