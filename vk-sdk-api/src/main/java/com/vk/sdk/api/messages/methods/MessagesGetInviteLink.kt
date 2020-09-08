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
import com.vk.sdk.api.messages.dto.MessagesGetInviteLinkResponseDto
import com.vk.sdk.api.messages.responses.MessagesGetInviteLinkResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * @param peerId Destination ID. minimum 0
 * @param reset 1 � to generate new link (revoke previous), 0 � to return previous link. default
 * false
 * @param groupId Group ID minimum 0
 */
class MessagesGetInviteLink(
    private val peerId: Int,
    private val reset: Boolean? = null,
    private val groupId: Int? = null
) : VKRequest<MessagesGetInviteLinkResponseDto>("messages.getInviteLink") {
    init {
        addParam("peer_id", peerId)
        reset?.let { value ->
            addParam("reset", if (value) 1 else 0)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
    }

    override fun parse(r: JSONObject): MessagesGetInviteLinkResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            MessagesGetInviteLinkResponse::class.java).response
}
