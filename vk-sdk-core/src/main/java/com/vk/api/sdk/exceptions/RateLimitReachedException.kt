package com.vk.api.sdk.exceptions

class RateLimitReachedException(method: String, message: String): VKApiExecutionException(
        code = VKApiCodes.CODE_RATE_LIMIT_REACHED,
        apiMethod = method,
        hasLocalizedMessage = false,
        detailMessage = message
)