/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 vk.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
*/
// *********************************************************************
// THIS FILE IS AUTO GENERATED!
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING.
// *********************************************************************
package com.vk.sdk.api.messages.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param ownerId
 * @param title - Chat title
 * @param state
 * @param activeIds
 * @param acl
 * @param membersCount
 * @param friendsCount
 * @param pinnedMessage
 * @param photo
 * @param adminIds - Ids of chat admins
 * @param isGroupChannel
 * @param permissions
 * @param isDisappearing
 * @param theme
 * @param disappearingChatLink
 * @param isService
 */
data class MessagesChatSettings(
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("title")
    val title: String,
    @SerializedName("state")
    val state: MessagesChatSettingsState,
    @SerializedName("active_ids")
    val activeIds: List<UserId>,
    @SerializedName("acl")
    val acl: MessagesChatSettingsAcl,
    @SerializedName("members_count")
    val membersCount: Int? = null,
    @SerializedName("friends_count")
    val friendsCount: Int? = null,
    @SerializedName("pinned_message")
    val pinnedMessage: MessagesPinnedMessage? = null,
    @SerializedName("photo")
    val photo: MessagesChatSettingsPhoto? = null,
    @SerializedName("admin_ids")
    val adminIds: List<UserId>? = null,
    @SerializedName("is_group_channel")
    val isGroupChannel: Boolean? = null,
    @SerializedName("permissions")
    val permissions: MessagesChatSettingsPermissions? = null,
    @SerializedName("is_disappearing")
    val isDisappearing: Boolean? = null,
    @SerializedName("theme")
    val theme: String? = null,
    @SerializedName("disappearing_chat_link")
    val disappearingChatLink: String? = null,
    @SerializedName("is_service")
    val isService: Boolean? = null
)
