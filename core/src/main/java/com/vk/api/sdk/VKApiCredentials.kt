package com.vk.api.sdk

import com.vk.dto.common.id.UserId

data class VKApiCredentials(
    val accessToken: String,
    val secret: String?,
    val expiresInSec: Int,
    val createdMs: Long,
    val userId: UserId
)