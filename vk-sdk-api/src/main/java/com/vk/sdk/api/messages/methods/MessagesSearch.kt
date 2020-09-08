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
import com.vk.sdk.api.messages.dto.MessagesSearchResponseDto
import com.vk.sdk.api.messages.responses.MessagesSearchResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of the current user's private messages that match search criteria.
 * @param q Search query string. 
 * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' +
 * 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. " 
 * @param date Date to search message before in Unixtime. minimum 0
 * @param previewLength Number of characters after which to truncate a previewed message. To preview
 * the full message, specify '0'. "NOTE: Messages are not truncated by default. Messages are truncated
 * by words." default 0 minimum 0
 * @param offset Offset needed to return a specific subset of messages. default 0 minimum 0
 * @param count Number of messages to return. default 20 minimum 0 maximum 100
 * @param extended  
 * @param fields  
 * @param groupId Group ID (for group messages with group access token) minimum 0
 */
class MessagesSearch(
    private val q: String? = null,
    private val peerId: Int? = null,
    private val date: Int? = null,
    private val previewLength: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null,
    private val fields: List<String>? = null,
    private val groupId: Int? = null
) : VKRequest<MessagesSearchResponseDto>("messages.search") {
    init {
        q?.let { value ->
            addParam("q", value)
        }
        peerId?.let { value ->
            addParam("peer_id", value)
        }
        date?.let { value ->
            addParam("date", value)
        }
        previewLength?.let { value ->
            addParam("preview_length", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
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

    override fun parse(r: JSONObject): MessagesSearchResponseDto =
            GsonHolder.gson.fromJson(r.toString(), MessagesSearchResponse::class.java).response
}
