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
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param ownerId no description
 * @param title Chat title
 * @param state no description
 * @param activeIds no description
 * @param acl no description
 * @param membersCount no description
 * @param friendsCount no description
 * @param pinnedMessage no description
 * @param photo no description
 * @param adminIds Ids of chat admins
 * @param isGroupChannel no description
 * @param permissions no description
 * @param isDisappearing no description
 * @param theme no description
 * @param disappearingChatLink no description
 * @param isService no description
 */
data class MessagesChatSettings(
    @SerializedName(value="owner_id")
    val ownerId: Int,
    @SerializedName(value="title")
    val title: String,
    @SerializedName(value="state")
    val state: MessagesChatSettingsState,
    @SerializedName(value="active_ids")
    val activeIds: List<Int>,
    @SerializedName(value="acl")
    val acl: MessagesChatSettingsAcl,
    @SerializedName(value="members_count")
    val membersCount: Int? = null,
    @SerializedName(value="friends_count")
    val friendsCount: Int? = null,
    @SerializedName(value="pinned_message")
    val pinnedMessage: MessagesPinnedMessage? = null,
    @SerializedName(value="photo")
    val photo: MessagesChatSettingsPhoto? = null,
    @SerializedName(value="admin_ids")
    val adminIds: List<Int>? = null,
    @SerializedName(value="is_group_channel")
    val isGroupChannel: Boolean? = null,
    @SerializedName(value="permissions")
    val permissions: MessagesChatSettingsPermissions? = null,
    @SerializedName(value="is_disappearing")
    val isDisappearing: Boolean? = null,
    @SerializedName(value="theme")
    val theme: String? = null,
    @SerializedName(value="disappearing_chat_link")
    val disappearingChatLink: String? = null,
    @SerializedName(value="is_service")
    val isService: Boolean? = null
)
