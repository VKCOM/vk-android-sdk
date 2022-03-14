package com.vk.api.sdk.okhttp

import com.vk.api.sdk.utils.UserAgentProvider
import okhttp3.Interceptor
import okhttp3.Response

class UserAgentInterceptor(private val userAgent: UserAgentProvider) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestWithUserAgent = originalRequest.newBuilder()
            .header("User-Agent", userAgent.getUserAgent())
            .build()
        return chain.proceed(requestWithUserAgent)
    }

}