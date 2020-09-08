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
import com.vk.sdk.api.messages.dto.MessagesGetHistoryAttachmentsMediaType
import com.vk.sdk.api.messages.dto.MessagesGetHistoryAttachmentsResponseDto
import com.vk.sdk.api.messages.responses.MessagesGetHistoryAttachmentsResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns media files from the dialog or group chat.
 * @param peerId Peer ID. ", For group chat: '2000000000 + chat ID' , , For community: '-community
 * ID'" 
 * @param mediaType Type of media files to return: *'photo',, *'video',, *'audio',, *'doc',,
 * *'link'.,*'market'.,*'wall'.,*'share' default "photo"
 * @param startFrom Message ID to start return results from. 
 * @param count Number of objects to return. default 30 minimum 0 maximum 200
 * @param photoSizes '1' � to return photo sizes in a 
 * @param fields Additional profile [vk.com/dev/fields|fields] to return.  
 * @param groupId Group ID (for group messages with group access token) minimum 0
 * @param preserveOrder  
 * @param maxForwardsLevel  default 45 minimum 0 maximum 45
 */
class MessagesGetHistoryAttachments(
    private val peerId: Int,
    private val mediaType: MessagesGetHistoryAttachmentsMediaType? = null,
    private val startFrom: String? = null,
    private val count: Int? = null,
    private val photoSizes: Boolean? = null,
    private val fields: List<UsersFields>? = null,
    private val groupId: Int? = null,
    private val preserveOrder: Boolean? = null,
    private val maxForwardsLevel: Int? = null
) : VKRequest<MessagesGetHistoryAttachmentsResponseDto>("messages.getHistoryAttachments") {
    init {
        addParam("peer_id", peerId)
        mediaType?.let { value ->
            addParam("media_type", value.value)
        }
        startFrom?.let { value ->
            addParam("start_from", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        photoSizes?.let { value ->
            addParam("photo_sizes", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        preserveOrder?.let { value ->
            addParam("preserve_order", if (value) 1 else 0)
        }
        maxForwardsLevel?.let { value ->
            addParam("max_forwards_level", value)
        }
    }

    override fun parse(r: JSONObject): MessagesGetHistoryAttachmentsResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            MessagesGetHistoryAttachmentsResponse::class.java).response
}
