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
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param adminId - Chat creator ID
 * @param id - Chat ID
 * @param type - Chat type
 * @param users
 * @param membersCount - Count members in a chat
 * @param kicked - Shows that user has been kicked from the chat
 * @param left - Shows that user has been left the chat
 * @param photo100 - URL of the preview image with 100 px in width
 * @param photo200 - URL of the preview image with 200 px in width
 * @param photo50 - URL of the preview image with 50 px in width
 * @param pushSettings
 * @param title - Chat title
 * @param isDefaultPhoto - If provided photo is default
 * @param isGroupChannel - If chat is group channel
 */
data class MessagesChat(
    @SerializedName("admin_id")
    val adminId: UserId,
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("users")
    val users: List<UserId>,
    @SerializedName("members_count")
    val membersCount: Int,
    @SerializedName("kicked")
    val kicked: BaseBoolInt? = null,
    @SerializedName("left")
    val left: BaseBoolInt? = null,
    @SerializedName("photo_100")
    val photo100: String? = null,
    @SerializedName("photo_200")
    val photo200: String? = null,
    @SerializedName("photo_50")
    val photo50: String? = null,
    @SerializedName("push_settings")
    val pushSettings: MessagesChatPushSettings? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("is_default_photo")
    val isDefaultPhoto: Boolean? = null,
    @SerializedName("is_group_channel")
    val isGroupChannel: Boolean? = null
)
