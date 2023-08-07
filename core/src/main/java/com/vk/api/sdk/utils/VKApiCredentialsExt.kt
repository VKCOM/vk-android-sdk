package com.vk.api.sdk.utils

import com.vk.api.sdk.VKApiCredentials
import com.vk.dto.common.id.UserId

fun List<VKApiCredentials>.activeAccessToken(): String = firstOrNull()?.accessToken ?: ""
fun List<VKApiCredentials>.activeSecret(): String? = firstOrNull()?.secret
fun List<VKApiCredentials>.activeExpiresInSec(): Int = firstOrNull()?.expiresInSec ?: 0
fun List<VKApiCredentials>.activeCreatedMs(): Long = firstOrNull()?.createdMs ?: 0L
fun List<VKApiCredentials>.activeUserId(): UserId = firstOrNull()?.userId ?: UserId.DEFAULT