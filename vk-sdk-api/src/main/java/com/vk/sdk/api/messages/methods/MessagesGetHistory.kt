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
package com.vk.sdk.api.messages.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.messages.dto.MessagesGetHistoryResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetHistoryRev
import com.vk.sdk.api.messages.responses.MessagesGetHistoryResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns message history for the specified user or group chat.
 * @param offset Offset needed to return a specific subset of messages. 
 * @param count Number of messages to return. default 20 minimum 0 maximum 200
 * @param userId ID of the user whose message history you want to return. 
 * @param peerId  
 * @param startMessageId Starting message ID from which to return history. minimum 0
 * @param rev Sort order: '1' � return messages in chronological order. '0' � return messages in
 * reverse chronological order. 
 * @param extended Information whether the response should be extended 
 * @param fields Profile fields to return. 
 * @param groupId Group ID (for group messages with group access token) minimum 0
 */
class MessagesGetHistory(
    private val offset: Int? = null,
    private val count: Int? = null,
    private val userId: Int? = null,
    private val peerId: Int? = null,
    private val startMessageId: Int? = null,
    private val rev: MessagesGetHistoryRev? = null,
    private val extended: Boolean? = null,
    private val fields: List<UsersFields>? = null,
    private val groupId: Int? = null
) : VKRequest<MessagesGetHistoryResponseDto>("messages.getHistory") {
    init {
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        userId?.let { value ->
            addParam("user_id", value)
        }
        peerId?.let { value ->
            addParam("peer_id", value)
        }
        startMessageId?.let { value ->
            addParam("start_message_id", value)
        }
        rev?.let { value ->
            addParam("rev", value.value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
    }

    override fun parse(r: JSONObject): MessagesGetHistoryResponseDto =
            GsonHolder.gson.fromJson(r.toString(), MessagesGetHistoryResponse::class.java).response
}
