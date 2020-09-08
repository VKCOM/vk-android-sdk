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

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param peer no description
 * @param lastMessageId ID of the last message in conversation
 * @param inRead Last message user have read
 * @param outRead Last outcoming message have been read by the opponent
 * @param unreadCount Unread messages number
 * @param isMarkedUnread Is this conversation uread
 * @param important no description
 * @param unanswered no description
 * @param specialServiceType no description
 * @param messageRequestData no description
 * @param mentions Ids of messages with mentions
 * @param expireMessages Ids of messages with expiration time
 * @param currentKeyboard no description
 * @param canSendMoney no description
 * @param canReceiveMoney no description
 */
data class MessagesConversation(
    @SerializedName(value="peer")
    val peer: MessagesConversationPeer,
    @SerializedName(value="last_message_id")
    val lastMessageId: Int,
    @SerializedName(value="in_read")
    val inRead: Int,
    @SerializedName(value="out_read")
    val outRead: Int,
    @SerializedName(value="unread_count")
    val unreadCount: Int? = null,
    @SerializedName(value="is_marked_unread")
    val isMarkedUnread: Boolean? = null,
    @SerializedName(value="important")
    val important: Boolean? = null,
    @SerializedName(value="unanswered")
    val unanswered: Boolean? = null,
    @SerializedName(value="special_service_type")
    val specialServiceType: SpecialServiceType? = null,
    @SerializedName(value="message_request_data")
    val messageRequestData: MessagesMessageRequestData? = null,
    @SerializedName(value="mentions")
    val mentions: List<Int>? = null,
    @SerializedName(value="expire_messages")
    val expireMessages: List<Int>? = null,
    @SerializedName(value="current_keyboard")
    val currentKeyboard: MessagesKeyboard? = null,
    @SerializedName(value="can_send_money")
    val canSendMoney: Boolean? = null,
    @SerializedName(value="can_receive_money")
    val canReceiveMoney: Boolean? = null
) {
    enum class SpecialServiceType(
        val value: String
    ) {
        BUSINESS_NOTIFY("business_notify");

        class Serializer : JsonDeserializer<SpecialServiceType> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): SpecialServiceType = values().first { it.value.toString() ==
                    json!!.asJsonPrimitive.toString() }
        }
    }
}
