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
import com.vk.sdk.api.messages.dto.MessagesGetLongPollHistoryResponseDto
import com.vk.sdk.api.messages.responses.MessagesGetLongPollHistoryResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns updates in user's private messages.
 * @param ts Last value of the 'ts' parameter returned from the Long Poll server or by using
 * [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method. minimum 0
 * @param pts Lsat value of 'pts' parameter returned from the Long Poll server or by using
 * [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method. minimum 0
 * @param previewLength Number of characters after which to truncate a previewed message. To preview
 * the full message, specify '0'. "NOTE: Messages are not truncated by default. Messages are truncated
 * by words." minimum 0
 * @param onlines '1' � to return history with online users only. 
 * @param fields Additional profile [vk.com/dev/fields|fields] to return. default
 * "photo,photo_medium_rec,sex,online,screen_name"
 * @param eventsLimit Maximum number of events to return. default 1000 minimum 1000
 * @param msgsLimit Maximum number of messages to return. default 200 minimum 200
 * @param maxMsgId Maximum ID of the message among existing ones in the local copy. Both messages
 * received with API methods (for example, , ), and data received from a Long Poll server (events with
 * code 4) are taken into account. minimum 0
 * @param groupId Group ID (for group messages with user access token) minimum 0
 * @param lpVersion  minimum 0
 * @param lastN  default 0 minimum 0 maximum 2000
 * @param credentials  
 */
class MessagesGetLongPollHistory(
    private val ts: Int? = null,
    private val pts: Int? = null,
    private val previewLength: Int? = null,
    private val onlines: Boolean? = null,
    private val fields: List<UsersFields>? = null,
    private val eventsLimit: Int? = null,
    private val msgsLimit: Int? = null,
    private val maxMsgId: Int? = null,
    private val groupId: Int? = null,
    private val lpVersion: Int? = null,
    private val lastN: Int? = null,
    private val credentials: Boolean? = null
) : VKRequest<MessagesGetLongPollHistoryResponseDto>("messages.getLongPollHistory") {
    init {
        ts?.let { value ->
            addParam("ts", value)
        }
        pts?.let { value ->
            addParam("pts", value)
        }
        previewLength?.let { value ->
            addParam("preview_length", value)
        }
        onlines?.let { value ->
            addParam("onlines", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        eventsLimit?.let { value ->
            addParam("events_limit", value)
        }
        msgsLimit?.let { value ->
            addParam("msgs_limit", value)
        }
        maxMsgId?.let { value ->
            addParam("max_msg_id", value)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        lpVersion?.let { value ->
            addParam("lp_version", value)
        }
        lastN?.let { value ->
            addParam("last_n", value)
        }
        credentials?.let { value ->
            addParam("credentials", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): MessagesGetLongPollHistoryResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            MessagesGetLongPollHistoryResponse::class.java).response
}
