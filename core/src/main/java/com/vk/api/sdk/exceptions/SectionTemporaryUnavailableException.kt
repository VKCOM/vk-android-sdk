package com.vk.api.sdk.exceptions

class SectionTemporaryUnavailableException(method: String, message: String) :
    VKApiExecutionException(
        code = VKApiCodes.CODE_SECTION_TEMPORARY_UNAVAILABLE,
        apiMethod = method,
        hasLocalizedMessage = false,
        detailMessage = message
    )