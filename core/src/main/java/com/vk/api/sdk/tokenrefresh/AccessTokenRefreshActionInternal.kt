package com.vk.api.sdk.tokenrefresh

import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.chain.ChainArgs
import com.vk.api.sdk.chain.ChainCall
import com.vk.api.sdk.exceptions.RefreshFailCause
import com.vk.api.sdk.exceptions.UnableToRefreshAccessTokenException
import com.vk.api.sdk.utils.log.Logger
import java.lang.IllegalStateException

class AccessTokenRefreshActionInternal(
    private val apiManager: VKApiManager
) {
    @Volatile
    private var forceRefresh: Boolean = false

    fun activateForce() {
        this.forceRefresh = true
    }

    fun <T> refresh(chain: ChainCall<T>, args: ChainArgs): T? {
        return try {
            if (forceRefresh) {
                synchronized(this) {
                    if (forceRefresh) {
                        refreshImpl()
                    }
                }
            }

            val isLoggedIn = apiManager.executor.isLoggedIn
            if (!apiManager.executor.tokenContainsAndValid && isLoggedIn) {
                synchronized(this) {
                    if (!apiManager.executor.tokenContainsAndValid) {
                        refreshImpl()
                    }
                }
            }

            chain.call(args)
        } catch (e: UnableToRefreshAccessTokenException) {
            apiManager.config.logger.log(Logger.LogLevel.ERROR, "An error occurred on token refresh, isCritical = ${e.isCritical}", e)

            if (e.isCritical) {
                apiManager.illegalCredentialsListener?.onInvalidCredentials("refresh token", null, e.userId, e.cause)
                return null
            }

            throw e
        } catch (other: Throwable) {
            apiManager.config.logger.log(Logger.LogLevel.ERROR, "An error occurred on token refresh", other)
            throw other
        }
    }

    private fun refreshImpl() {
        if(!apiManager.executor.isLoggedIn) {
            return
        }

        val refreshResult = apiManager.config.accessTokenRefresher.value?.refresh() ?: throw IllegalStateException("You must set AccessTokenRefresher for ApiConfig")
        apiManager.credentialsChangeListener?.onCredentialsChanged(refreshResult.successRefresh)
        refreshResult.errorRefresh.forEach { userId ->
            apiManager.illegalCredentialsListener?.onInvalidCredentials("refresh token", null, userId, RefreshFailCause.InvalidToken())
        }
        forceRefresh = false
    }
}