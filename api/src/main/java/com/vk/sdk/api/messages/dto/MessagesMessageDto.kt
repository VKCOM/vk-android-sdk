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
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseGeoDto
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param date - Date when the message has been sent in Unixtime
 * @param fromId - Message author's ID
 * @param id - Message ID
 * @param out - Information whether the message is outcoming
 * @param peerId - Peer ID
 * @param text - Message text
 * @param action
 * @param adminAuthorId - Only for messages from community. Contains user ID of community admin, who
 * sent this message.
 * @param attachments
 * @param conversationMessageId - Unique auto-incremented number for all messages with this peer
 * @param deleted - Is it an deleted message
 * @param fwdMessages
 * @param geo
 * @param important - Is it an important message
 * @param isHidden
 * @param isCropped - this message is cropped for bot
 * @param keyboard
 * @param membersCount - Members number
 * @param payload
 * @param randomId - ID used for sending messages. It returned only for outgoing messages
 * @param ref
 * @param refSource
 * @param replyMessage
 * @param reactionId - Reaction id set on message
 * @param reactions - Actual reactions counters on this message
 * @param lastReactionId - Last reaction id set on this message
 * @param updateTime - Date when the message has been updated in Unixtime
 * @param wasListened - Was the audio message inside already listened by you
 * @param pinnedAt - Date when the message has been pinned in Unixtime
 * @param isSilent - Is silent message, push without sound
 */
data class MessagesMessageDto(
    @SerializedName("date")
    val date: Int,
    @SerializedName("from_id")
    val fromId: UserId,
    @SerializedName("id")
    val id: Int,
    @SerializedName("out")
    val out: BaseBoolIntDto,
    @SerializedName("peer_id")
    val peerId: UserId,
    @SerializedName("text")
    val text: String,
    @SerializedName("action")
    val action: MessagesActionOneOfDto? = null,
    @SerializedName("admin_author_id")
    val adminAuthorId: UserId? = null,
    @SerializedName("attachments")
    val attachments: List<MessagesMessageAttachmentDto>? = null,
    @SerializedName("conversation_message_id")
    val conversationMessageId: Int? = null,
    @SerializedName("deleted")
    val deleted: BaseBoolIntDto? = null,
    @SerializedName("fwd_messages")
    val fwdMessages: List<MessagesForeignMessageDto>? = null,
    @SerializedName("geo")
    val geo: BaseGeoDto? = null,
    @SerializedName("important")
    val important: Boolean? = null,
    @SerializedName("is_hidden")
    val isHidden: Boolean? = null,
    @SerializedName("is_cropped")
    val isCropped: Boolean? = null,
    @SerializedName("keyboard")
    val keyboard: MessagesKeyboardDto? = null,
    @SerializedName("members_count")
    val membersCount: Int? = null,
    @SerializedName("payload")
    val payload: String? = null,
    @SerializedName("random_id")
    val randomId: Int? = null,
    @SerializedName("ref")
    val ref: String? = null,
    @SerializedName("ref_source")
    val refSource: String? = null,
    @SerializedName("reply_message")
    val replyMessage: MessagesForeignMessageDto? = null,
    @SerializedName("reaction_id")
    val reactionId: Int? = null,
    @SerializedName("reactions")
    val reactions: List<MessagesReactionCounterResponseItemDto>? = null,
    @SerializedName("last_reaction_id")
    val lastReactionId: Int? = null,
    @SerializedName("update_time")
    val updateTime: Int? = null,
    @SerializedName("was_listened")
    val wasListened: Boolean? = null,
    @SerializedName("pinned_at")
    val pinnedAt: Int? = null,
    @SerializedName("is_silent")
    val isSilent: Boolean? = null
)
