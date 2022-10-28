package com.vk.api.sdk.chain

import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.InternalServerErrorOccurredException
import com.vk.api.sdk.exceptions.RateLimitReachedException
import com.vk.api.sdk.exceptions.VKInternalServerErrorException
import com.vk.api.sdk.utils.TokenExponentialBackoff

class InternalErrorChainCall<T>(
    manager: VKApiManager,
    private val method: String,
    private val backoff: TokenExponentialBackoff,
    private val chainCall: ChainCall<T>
): ChainCall<T>(manager) {

    private val errorDescription by lazy { "Internal server error occurred while executing $method." }

    override fun call(args: ChainArgs): T? {
        if (backoff.shouldWait(method)) {
            throw InternalServerErrorOccurredException(errorDescription)
        }

        try {
            return chainCall.call(args).also {
                backoff.reset(method)
            }
        } catch (ex: VKInternalServerErrorException) {
            backoff.backoff(method)
            logDebug(errorDescription, ex)
            throw ex
        }
    }

}