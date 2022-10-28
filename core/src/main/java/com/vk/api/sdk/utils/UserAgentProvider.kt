package com.vk.api.sdk.utils

fun interface UserAgentProvider {
    fun getUserAgent(): String
}