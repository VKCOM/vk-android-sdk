package com.vk.api.sdk

import com.vk.api.sdk.auth.VKAccessToken

data class VKApiCredentials(
    val accessToken: String,
    val secret: String?,
    val expiresInSec: Int,
    val createdMs: Long
) {
    companion object {
        fun lazyFrom(
            accessToken: String,
            secret: String?,
            expiresInSec: Int,
            createdMs: Long
        ): Lazy<VKApiCredentials> {
            return lazy(LazyThreadSafetyMode.NONE) { VKApiCredentials(accessToken, secret, expiresInSec, createdMs) }
        }

        fun lazyFrom(tokenProvider: () -> VKAccessToken?): Lazy<VKApiCredentials> {
            return lazy {
                val token = tokenProvider()
                val accessToken = token?.accessToken ?: ""
                val secret = token?.secret
                VKApiCredentials(accessToken, secret, token?.expiresInSec ?: 0, token?.createdMs ?: 0)
            }
        }
    }
}