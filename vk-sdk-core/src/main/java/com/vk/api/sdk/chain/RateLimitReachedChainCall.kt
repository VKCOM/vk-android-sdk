package com.vk.api.sdk.chain

import android.content.Context
import android.os.SystemClock
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.RateLimitReachedException
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiExecutionException

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
    private val backoff: RateLimitBackoff,
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

    /**
     * backoff implementation for the api rate limit
     *
     * @param context - android [Context]
     * @param backoffTimeMs - backoff time in ms the default is 1 hour
     *
     * it's based on [SystemClock.elapsedRealtime] and here we don't want to handle system reboot
     *
     * in case of reboot we will make another api call and then go through a normal [RateLimitBackoff] logic
     */
    class RateLimitBackoff(
        context: Context,
        private val backoffTimeMs: Long,
        private val realTimeProvider: () -> Long = {
            SystemClock.elapsedRealtime()
        }
    ) {

        private val prefStorage by lazy {
            context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        }

        fun shouldWait(operationKey: String): Boolean {
            if (prefStorage.contains(operationKey).not()) {
                return false
            }

            val elapsedTime = realTimeProvider()
            val value = prefStorage.getLong(operationKey, backoffTimeMs)

            //we don't want to handle device reboot
            if (elapsedTime - value >= 0) {
                return value + backoffTimeMs > elapsedTime
            }

            return false
        }

        fun reset(operationKey: String) {
            prefStorage.edit().remove(operationKey).apply()
        }

        fun backoff(operationKey: String) {
            prefStorage.edit().putLong(operationKey, realTimeProvider()).apply()
        }
    }

    companion object {
        private const val DETAIL_MESSAGE = "Rate limit reached."
        private const val PREF_NAME = "rate_limit_backoff_storage"
    }
}