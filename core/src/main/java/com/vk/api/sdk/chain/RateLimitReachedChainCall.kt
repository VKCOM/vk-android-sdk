/**
 * Copyright (c) 2020 - present, LLC “V Kontakte”
 *
 * 1. Permission is hereby granted to any person obtaining a copy of this Software to
 * use the Software without charge.
 *
 * 2. Restrictions
 * You may not modify, merge, publish, distribute, sublicense, and/or sell copies,
 * create derivative works based upon the Software or any part thereof.
 *
 * 3. Termination
 * This License is effective until terminated. LLC “V Kontakte” may terminate this
 * License at any time without any negative consequences to our rights.
 * You may terminate this License at any time by deleting the Software and all copies
 * thereof. Upon termination of this license for any reason, you shall continue to be
 * bound by the provisions of Section 2 above.
 * Termination will be without prejudice to any rights LLC “V Kontakte” may have as
 * a result of this agreement.
 *
 * 4. Disclaimer of warranty and liability
 * THE SOFTWARE IS MADE AVAILABLE ON THE “AS IS” BASIS. LLC “V KONTAKTE” DISCLAIMS
 * ALL WARRANTIES THAT THE SOFTWARE MAY BE SUITABLE OR UNSUITABLE FOR ANY SPECIFIC
 * PURPOSES OF USE. LLC “V KONTAKTE” CAN NOT GUARANTEE AND DOES NOT PROMISE ANY
 * SPECIFIC RESULTS OF USE OF THE SOFTWARE.
 * UNDER NO CIRCUMSTANCES LLC “V KONTAKTE” BEAR LIABILITY TO THE LICENSEE OR ANY
 * THIRD PARTIES FOR ANY DAMAGE IN CONNECTION WITH USE OF THE SOFTWARE.
*/
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