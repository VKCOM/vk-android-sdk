package com.vk.api.sdk.exceptions

class IgnoredAccessTokenException(method: String) : VKApiExecutionException(
        VKApiCodes.CODE_IGNORED_ACCESS_TOKEN,
        method,
        false,
        "Ignored Access Token"
)