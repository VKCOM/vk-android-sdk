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
import com.vk.sdk.api.messages.dto.MessagesLongpollParams
import com.vk.sdk.api.messages.responses.MessagesGetLongPollServerResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * Returns data required for connection to a Long Poll server.
 * @param needPts '1' � to return the 'pts' field, needed for the
 * [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method. 
 * @param groupId Group ID (for group messages with user access token) minimum 0
 * @param lpVersion Long poll version default 0 minimum 0
 */
class MessagesGetLongPollServer(
    private val needPts: Boolean? = null,
    private val groupId: Int? = null,
    private val lpVersion: Int? = null
) : VKRequest<MessagesLongpollParams>("messages.getLongPollServer") {
    init {
        needPts?.let { value ->
            addParam("need_pts", if (value) 1 else 0)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        lpVersion?.let { value ->
            addParam("lp_version", value)
        }
    }

    override fun parse(r: JSONObject): MessagesLongpollParams =
            GsonHolder.gson.fromJson(r.toString(),
            MessagesGetLongPollServerResponse::class.java).response
}
