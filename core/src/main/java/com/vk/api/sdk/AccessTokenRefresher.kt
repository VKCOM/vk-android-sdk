package com.vk.api.sdk

import com.vk.api.sdk.auth.VKAccessToken

fun interface AccessTokenRefresher {
    fun refresh(): VKAccessToken
}