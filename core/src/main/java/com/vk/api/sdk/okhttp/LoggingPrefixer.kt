package com.vk.api.sdk.okhttp

/**
 * Adds prefix for response and request log outputs to spot which response refers to which request
 * Prefix is requested one time per http call and stored in thread local variable in [LoggingInterceptor]
 * thus every request and response will be marked with the same prefix
 **/
fun interface LoggingPrefixer {
    fun getPrefix(): String
}