package com.vk.api.sdk.exceptions

import com.vk.dto.common.id.UserId

class UnableToRefreshAccessTokenException @JvmOverloads constructor(
    val isCritical: Boolean,
    val userId: UserId,
    message: String?,
    cause: Throwable? = null
) : RuntimeException(message, cause)

sealed class RefreshFailCause: Throwable() {
    /**
     * Иcключение, которое нужно бросать, когда во время рефреша у залогиненного юзера нет токена.
     * Нужно отправлять статистику по таким исключениям.
    */
    class EmptyTokenLoggedUser: RefreshFailCause()

    /**
     * Иcключение, которое нужно бросать, когда во время рефреша у не залогиненного юзера нет токена.
     * По таким исключениям отправлять статистику НЕ нужно.
     */
    class EmptyTokenUnloggedUser: RefreshFailCause()

    class InvalidToken: RefreshFailCause()
}