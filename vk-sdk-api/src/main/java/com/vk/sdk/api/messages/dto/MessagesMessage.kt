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
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseGeo
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param date Date when the message has been sent in Unixtime
 * @param fromId Message author's ID
 * @param id Message ID
 * @param out Information whether the message is outcoming
 * @param peerId Peer ID
 * @param text Message text
 * @param action no description
 * @param adminAuthorId Only for messages from community. Contains user ID of community admin, who
 * sent this message.
 * @param attachments no description
 * @param conversationMessageId Unique auto-incremented number for all messages with this peer
 * @param deleted Is it an deleted message
 * @param fwdMessages Forwarded messages
 * @param geo no description
 * @param important Is it an important message
 * @param isHidden no description
 * @param isCropped this message is cropped for bot
 * @param keyboard no description
 * @param membersCount Members number
 * @param payload no description
 * @param randomId ID used for sending messages. It returned only for outgoing messages
 * @param ref no description
 * @param refSource no description
 * @param replyMessage no description
 * @param updateTime Date when the message has been updated in Unixtime
 * @param wasListened Was the audio message inside already listened by you
 * @param pinnedAt Date when the message has been pinned in Unixtime
 */
data class MessagesMessage(
    @SerializedName(value="date")
    val date: Int,
    @SerializedName(value="from_id")
    val fromId: Int,
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="out")
    val out: BaseBoolInt,
    @SerializedName(value="peer_id")
    val peerId: Int,
    @SerializedName(value="text")
    val text: String,
    @SerializedName(value="action")
    val action: MessagesMessageAction? = null,
    @SerializedName(value="admin_author_id")
    val adminAuthorId: Int? = null,
    @SerializedName(value="attachments")
    val attachments: List<MessagesMessageAttachment>? = null,
    @SerializedName(value="conversation_message_id")
    val conversationMessageId: Int? = null,
    @SerializedName(value="deleted")
    val deleted: BaseBoolInt? = null,
    @SerializedName(value="fwd_messages")
    val fwdMessages: List<MessagesForeignMessage>? = null,
    @SerializedName(value="geo")
    val geo: BaseGeo? = null,
    @SerializedName(value="important")
    val important: Boolean? = null,
    @SerializedName(value="is_hidden")
    val isHidden: Boolean? = null,
    @SerializedName(value="is_cropped")
    val isCropped: Boolean? = null,
    @SerializedName(value="keyboard")
    val keyboard: MessagesKeyboard? = null,
    @SerializedName(value="members_count")
    val membersCount: Int? = null,
    @SerializedName(value="payload")
    val payload: String? = null,
    @SerializedName(value="random_id")
    val randomId: Int? = null,
    @SerializedName(value="ref")
    val ref: String? = null,
    @SerializedName(value="ref_source")
    val refSource: String? = null,
    @SerializedName(value="reply_message")
    val replyMessage: MessagesForeignMessage? = null,
    @SerializedName(value="update_time")
    val updateTime: Int? = null,
    @SerializedName(value="was_listened")
    val wasListened: Boolean? = null,
    @SerializedName(value="pinned_at")
    val pinnedAt: Int? = null
)
