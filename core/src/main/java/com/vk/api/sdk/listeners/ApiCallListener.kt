package com.vk.api.sdk.listeners

interface ApiCallListener {
    fun onApiCallStart(reqId: Long, url: String) {}
    fun onApiCallSuccess(reqId: Long) {}
    fun onApiCallFailed(reqId: Long, throwable: Throwable) {}

    companion object {
        val EMPTY = object : ApiCallListener {}
    }
}