package com.vk.api.sdk.okhttp

import java.util.concurrent.atomic.AtomicInteger

/**
 * Numeric prefixer for api logging
 * Response and its request will be marked with same number starting from 0
 **/
class DefaultLoggingPrefixer : LoggingPrefixer {
    private val id = AtomicInteger(0)

    override fun getPrefix() = id.getAndIncrement().toString()

}