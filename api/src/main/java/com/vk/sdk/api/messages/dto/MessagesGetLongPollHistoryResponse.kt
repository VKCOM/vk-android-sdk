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
import com.vk.sdk.api.groups.dto.GroupsGroupFull
import com.vk.sdk.api.users.dto.UsersUserFull
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List

/**
 * @param history
 * @param messages
 * @param credentials
 * @param profiles
 * @param groups
 * @param chats
 * @param newPts - Persistence timestamp
 * @param fromPts
 * @param more - Has more
 * @param conversations
 */
data class MessagesGetLongPollHistoryResponse(
    @SerializedName("history")
    val history: List<List<Int>>? = null,
    @SerializedName("messages")
    val messages: MessagesLongpollMessages? = null,
    @SerializedName("credentials")
    val credentials: MessagesLongpollParams? = null,
    @SerializedName("profiles")
    val profiles: List<UsersUserFull>? = null,
    @SerializedName("groups")
    val groups: List<GroupsGroupFull>? = null,
    @SerializedName("chats")
    val chats: List<MessagesChat>? = null,
    @SerializedName("new_pts")
    val newPts: Int? = null,
    @SerializedName("from_pts")
    val fromPts: Int? = null,
    @SerializedName("more")
    val more: Boolean? = null,
    @SerializedName("conversations")
    val conversations: List<MessagesConversation>? = null
)
