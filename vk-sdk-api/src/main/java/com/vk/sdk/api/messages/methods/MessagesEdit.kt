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
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.messages.responses.MessagesEditResponse
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Edits the message.
 * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' +
 * 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. " 
 * @param message (Required if 'attachments' is not set.) Text of the message. 
 * @param lat Geographical latitude of a check-in, in degrees (from -90 to 90). 
 * @param long Geographical longitude of a check-in, in degrees (from -180 to 180). 
 * @param attachment (Required if 'message' is not set.) List of objects attached to the message,
 * separated by commas, in the following format: "<owner_id>_<media_id>", '' � Type of media
 * attachment: 'photo' � photo, 'video' � video, 'audio' � audio, 'doc' � document, 'wall' � wall post,
 * '<owner_id>' � ID of the media attachment owner. '<media_id>' � media attachment ID. Example:
 * "photo100172_166443618" 
 * @param keepForwardMessages '1' � to keep forwarded, messages. 
 * @param keepSnippets '1' � to keep attached snippets. 
 * @param groupId Group ID (for group messages with user access token) minimum 0
 * @param dontParseLinks  default false
 * @param messageId  minimum 0
 * @param conversationMessageId  minimum 0
 * @param template  
 * @param keyboard  
 */
class MessagesEdit(
    private val peerId: Int,
    private val message: String? = null,
    private val lat: Float? = null,
    private val long: Float? = null,
    private val attachment: String? = null,
    private val keepForwardMessages: Boolean? = null,
    private val keepSnippets: Boolean? = null,
    private val groupId: Int? = null,
    private val dontParseLinks: Boolean? = null,
    private val messageId: Int? = null,
    private val conversationMessageId: Int? = null,
    private val template: String? = null,
    private val keyboard: String? = null
) : VKRequest<BaseBoolInt>("messages.edit") {
    init {
        addParam("peer_id", peerId)
        message?.let { value ->
            addParam("message", value)
        }
        lat?.let { value ->
            addParam("lat", value.toString())
        }
        long?.let { value ->
            addParam("long", value.toString())
        }
        attachment?.let { value ->
            addParam("attachment", value)
        }
        keepForwardMessages?.let { value ->
            addParam("keep_forward_messages", if (value) 1 else 0)
        }
        keepSnippets?.let { value ->
            addParam("keep_snippets", if (value) 1 else 0)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        dontParseLinks?.let { value ->
            addParam("dont_parse_links", if (value) 1 else 0)
        }
        messageId?.let { value ->
            addParam("message_id", value)
        }
        conversationMessageId?.let { value ->
            addParam("conversation_message_id", value)
        }
        template?.let { value ->
            addParam("template", value)
        }
        keyboard?.let { value ->
            addParam("keyboard", value)
        }
    }

    override fun parse(r: JSONObject): BaseBoolInt = GsonHolder.gson.fromJson(r.toString(),
            MessagesEditResponse::class.java).response
}
