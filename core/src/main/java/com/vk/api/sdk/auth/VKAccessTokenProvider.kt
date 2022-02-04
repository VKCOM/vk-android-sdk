package com.vk.api.sdk.auth

interface VKAccessTokenProvider {
    fun getToken(): String
    fun setToken(token: String)
    fun clear()
    fun isUsed(): Boolean
}