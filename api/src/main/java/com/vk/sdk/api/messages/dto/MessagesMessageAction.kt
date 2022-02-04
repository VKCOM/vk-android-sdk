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
import kotlin.Int
import kotlin.String

/**
 * @param type
 * @param conversationMessageId - Message ID
 * @param email - Email address for chat_invite_user or chat_kick_user actions
 * @param memberId - User or email peer ID
 * @param message - Message body of related message
 * @param photo
 * @param text - New chat title for chat_create and chat_title_update actions
 */
data class MessagesMessageAction(
    @SerializedName("type")
    val type: MessagesMessageActionStatus,
    @SerializedName("conversation_message_id")
    val conversationMessageId: Int? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("member_id")
    val memberId: UserId? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("photo")
    val photo: MessagesMessageActionPhoto? = null,
    @SerializedName("text")
    val text: String? = null
)
