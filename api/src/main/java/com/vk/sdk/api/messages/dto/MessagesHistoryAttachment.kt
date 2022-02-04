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

/**
 * @param attachment
 * @param messageId - Message ID
 * @param fromId - Message author's ID
 * @param forwardLevel - Forward level (optional)
 * @param wasListened
 */
data class MessagesHistoryAttachment(
    @SerializedName("attachment")
    val attachment: MessagesHistoryMessageAttachment,
    @SerializedName("message_id")
    val messageId: Int,
    @SerializedName("from_id")
    val fromId: UserId,
    @SerializedName("forward_level")
    val forwardLevel: Int? = null,
    @SerializedName("was_listened")
    val wasListened: Boolean? = null
)
