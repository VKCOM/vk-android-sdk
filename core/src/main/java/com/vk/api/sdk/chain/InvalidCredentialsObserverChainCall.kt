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
import com.vk.api.sdk.utils.activeAccessToken
import com.vk.api.sdk.utils.activeUserId
import com.vk.dto.common.id.UserId
import com.vk.dto.common.id.isReal

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
                    val executorAccessToken = manager.executor.credentials.value.activeAccessToken()
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

                //ответы с пятой ошибкой долетают после того, как уже разлогинили юзера с невалидным AT
                //и из-за этого происходил логаут следующего авторизованного юзера с валидным AT
                //если токена от невалидного юзера уже нет в api manager'e, значит мы уже разлогинили этого пользователя и не надо снова дергать логаут
                getRealUserIdFromExeceptionOrThrow(ex)
                synchronized(InvalidCredentialsObserverChainCall::class.java) {
                    val userId = getRealUserIdFromExeceptionOrThrow(ex)
                    if (ex.code == VKApiCodes.CODE_ERROR_USER_DEACTIVATED) {
                        manager.illegalCredentialsListener?.onUserDeactivated(ex.apiMethod, userId)
                    } else {
                        manager.illegalCredentialsListener?.onInvalidCredentials(ex.apiMethod, ex.userBanInfo, userId)
                    }
                }
            }
            throw ex
        }
    }

    @Throws(VKApiExecutionException::class)
    private fun getRealUserIdFromExeceptionOrThrow(ex: VKApiExecutionException): UserId {
        val userId = manager.executor.credentials.value.find { it.accessToken == ex.accessToken }?.userId
        if (userId == null || userId.isReal().not()) {
            throw ex
        }
        return userId
    }
}