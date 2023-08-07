package com.vk.api.sdk

import com.vk.api.sdk.auth.VKAccessToken

interface ApiCredentialsChangeListener {
    fun onCredentialsChanged(credentials: List<VKAccessToken>)
}