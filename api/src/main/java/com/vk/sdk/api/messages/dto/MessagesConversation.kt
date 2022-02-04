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
 * @param peer
 * @param lastMessageId - ID of the last message in conversation
 * @param inRead - Last message user have read
 * @param outRead - Last outcoming message have been read by the opponent
 * @param sortId
 * @param lastConversationMessageId - Conversation message ID of the last message in conversation
 * @param unreadCount - Unread messages number
 * @param isMarkedUnread - Is this conversation uread
 * @param outReadBy
 * @param important
 * @param unanswered
 * @param specialServiceType
 * @param messageRequestData
 * @param mentions - Ids of messages with mentions
 * @param expireMessages - Ids of messages with expiration time
 * @param currentKeyboard
 * @param pushSettings
 * @param canWrite
 * @param canSendMoney
 * @param canReceiveMoney
 * @param chatSettings
 * @param spamExpiration
 * @param isNew
 * @param isArchived
 */
data class MessagesConversation(
    @SerializedName("peer")
    val peer: MessagesConversationPeer,
    @SerializedName("last_message_id")
    val lastMessageId: Int,
    @SerializedName("in_read")
    val inRead: Int,
    @SerializedName("out_read")
    val outRead: Int,
    @SerializedName("sort_id")
    val sortId: MessagesConversationSortId? = null,
    @SerializedName("last_conversation_message_id")
    val lastConversationMessageId: Int? = null,
    @SerializedName("unread_count")
    val unreadCount: Int? = null,
    @SerializedName("is_marked_unread")
    val isMarkedUnread: Boolean? = null,
    @SerializedName("out_read_by")
    val outReadBy: MessagesOutReadBy? = null,
    @SerializedName("important")
    val important: Boolean? = null,
    @SerializedName("unanswered")
    val unanswered: Boolean? = null,
    @SerializedName("special_service_type")
    val specialServiceType: MessagesConversation.SpecialServiceType? = null,
    @SerializedName("message_request_data")
    val messageRequestData: MessagesMessageRequestData? = null,
    @SerializedName("mentions")
    val mentions: List<Int>? = null,
    @SerializedName("expire_messages")
    val expireMessages: List<Int>? = null,
    @SerializedName("current_keyboard")
    val currentKeyboard: MessagesKeyboard? = null,
    @SerializedName("push_settings")
    val pushSettings: MessagesPushSettings? = null,
    @SerializedName("can_write")
    val canWrite: MessagesConversationCanWrite? = null,
    @SerializedName("can_send_money")
    val canSendMoney: Boolean? = null,
    @SerializedName("can_receive_money")
    val canReceiveMoney: Boolean? = null,
    @SerializedName("chat_settings")
    val chatSettings: MessagesChatSettings? = null,
    @SerializedName("spam_expiration")
    val spamExpiration: Int? = null,
    @SerializedName("is_new")
    val isNew: Boolean? = null,
    @SerializedName("is_archived")
    val isArchived: Boolean? = null
) {
    enum class SpecialServiceType(
        val value: String
    ) {
        @SerializedName("business_notify")
        BUSINESS_NOTIFY("business_notify");
    }
}
