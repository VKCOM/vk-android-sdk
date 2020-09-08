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
import com.vk.sdk.api.messages.dto.MessagesGetImportantMessagesExtendedResponseDto
import com.vk.sdk.api.messages.responses.MessagesGetImportantMessagesExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of user's important messages.
 * @param count Amount of needed important messages. default 20 minimum 0 maximum 200
 * @param offset  minimum 0
 * @param startMessageId  minimum 0
 * @param previewLength Maximum length of messages body. minimum 0
 * @param fields Actors fields to return. 
 * @param extended Return extended properties 
 * @param groupId Group ID (for group messages with group access token) minimum 0
 */
class MessagesGetImportantMessagesExtended(
    private val count: Int? = null,
    private val offset: Int? = null,
    private val startMessageId: Int? = null,
    private val previewLength: Int? = null,
    private val fields: List<BaseUserGroupFields>? = null,
    private val extended: Boolean? = null,
    private val groupId: Int? = null
) : VKRequest<MessagesGetImportantMessagesExtendedResponseDto>("messages.getImportantMessages") {
    init {
        count?.let { value ->
            addParam("count", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        startMessageId?.let { value ->
            addParam("start_message_id", value)
        }
        previewLength?.let { value ->
            addParam("preview_length", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
    }

    override fun parse(r: JSONObject): MessagesGetImportantMessagesExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            MessagesGetImportantMessagesExtendedResponse::class.java).response
}
