package com.vk.api.sdk

interface ApiCredentialsChangeListener {
    fun onCredentialsChanged(accessToken: String, secret: String?, expiresInSec: Int, createdMs: Long)
}