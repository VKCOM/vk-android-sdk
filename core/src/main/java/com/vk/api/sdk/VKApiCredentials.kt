package com.vk.api.sdk

import com.vk.api.sdk.auth.VKAccessToken

data class VKApiCredentials(val accessToken: String, val secret: String?) {
    companion object {
        fun lazyFrom(accessToken: String, secret: String?): Lazy<VKApiCredentials> {
            return lazy(LazyThreadSafetyMode.NONE) { VKApiCredentials(accessToken, secret) }
        }

        fun lazyFrom(tokenProvider: () -> VKAccessToken?): Lazy<VKApiCredentials> {
            return lazy {
                val token = tokenProvider()
                val accessToken = token?.accessToken ?: ""
                val secret = token?.secret
                VKApiCredentials(accessToken, secret)
            }
        }
    }
}