package com.vk.api.sdk

import okhttp3.Headers

interface VKApiResponseValidator {
    fun validateResponse(
        method: String,
        extended: Boolean,
        response: String,
        headers: Headers
    )
}