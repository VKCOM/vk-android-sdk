package com.vk.api.sdk.exceptions

class UnableToRefreshAccessTokenException @JvmOverloads constructor(
    val isCritical: Boolean,
    message: String?,
    cause: Throwable? = null
) : RuntimeException(message, cause)