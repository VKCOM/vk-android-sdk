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
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.messages.dto.MessagesGetConversationsByIdResponseDto
import com.vk.sdk.api.messages.responses.MessagesGetConversationsByIdResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns conversations by their IDs
 * @param peerIds Destination IDs. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' +
 * 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. " 
 * @param extended Return extended properties 
 * @param fields Profile and communities fields to return. 
 * @param groupId Group ID (for group messages with group access token) minimum 0
 */
class MessagesGetConversationsById(
    private val peerIds: List<Int>,
    private val extended: Boolean? = null,
    private val fields: List<BaseUserGroupFields>? = null,
    private val groupId: Int? = null
) : VKRequest<MessagesGetConversationsByIdResponseDto>("messages.getConversationsById") {
    init {
        addParam("peer_ids", peerIds)
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

    override fun parse(r: JSONObject): MessagesGetConversationsByIdResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            MessagesGetConversationsByIdResponse::class.java).response
}
