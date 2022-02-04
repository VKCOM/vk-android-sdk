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

package com.vk.api.sdk.chain

import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiExecutionException

class InvalidCredentialsObserverChainCall<T>(
        manager: VKApiManager,
        private val chain: ChainCall<T>,
        private val checkAuthCount: Int = 0
) : ChainCall<T>(manager) {
    @Throws(Exception::class)
    override fun call(args: ChainArgs): T? = callWithAuthCheck(args, 0)

    private fun callWithAuthCheck(args: ChainArgs, iteration: Int): T? {
        try {
            return chain.call(args)
        } catch (ex: VKApiExecutionException) {
            if (ex.isInvalidCredentialsError) {
                if (checkAuthCount > 0 && iteration < checkAuthCount) {
                    val failedAccessToken = ex.accessToken
                    val executorAccessToken = manager.executor.accessToken
                    val ignoredAccessToken = manager.executor.ignoredAccessToken

                    val isDifferentAccessToken = failedAccessToken != executorAccessToken
                    val isIgnoredAccessToken = ignoredAccessToken != null && failedAccessToken == ignoredAccessToken

                    // Если запрос выполнялся в тот момент, когда a/t был отличен от того, что сейчас
                    // или же a/t, с которым выполнялся запрос, должен быть заигнорен, то пробуем повторить запрос
                    // (Во втором случае, IgnoredAccessTokenException выбросит executor при необходимости)
                    if (failedAccessToken != null && (isDifferentAccessToken || isIgnoredAccessToken)) {
                        return callWithAuthCheck(args, iteration + 1)
                    }
                }

                if (ex.code == VKApiCodes.CODE_ERROR_USER_DEACTIVATED) {
                    manager.illegalCredentialsListener?.onUserDeactivated(ex.apiMethod)
                } else {
                    manager.illegalCredentialsListener?.onInvalidCredentials(ex.apiMethod, ex.userBanInfo)
                }
            }
            throw ex
        }
    }
}