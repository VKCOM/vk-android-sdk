package com.vk.api.sdk

import com.vk.api.sdk.auth.VKAccessToken
import com.vk.dto.common.id.UserId

fun interface AccessTokenRefresher {
    fun refresh(): RefreshResult

    data class RefreshResult(
        val successRefresh: List<VKAccessToken>,
        val errorRefresh: List<UserId>
    )
}