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
import com.vk.sdk.api.messages.dto.MessagesSendIntent
import com.vk.sdk.api.messages.responses.MessagesSendUserIdsResponse
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Sends a message.
 * @param userId User ID (by default � current user). 
 * @param randomId Unique identifier to avoid resending the message. 
 * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' +
 * 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. " 
 * @param domain User's short address (for example, 'illarionov'). 
 * @param chatId ID of conversation the message will relate to. minimum 0 maximum 100000000
 * @param userIds IDs of message recipients (if new conversation shall be started). 
 * @param message (Required if 'attachments' is not set.) Text of the message. 
 * @param lat Geographical latitude of a check-in, in degrees (from -90 to 90). 
 * @param long Geographical longitude of a check-in, in degrees (from -180 to 180). 
 * @param attachment (Required if 'message' is not set.) List of objects attached to the message,
 * separated by commas, in the following format: "<owner_id>_<media_id>", '' � Type of media
 * attachment: 'photo' � photo, 'video' � video, 'audio' � audio, 'doc' � document, 'wall' � wall post,
 * '<owner_id>' � ID of the media attachment owner. '<media_id>' � media attachment ID. Example:
 * "photo100172_166443618" 
 * @param replyTo  
 * @param forwardMessages ID of forwarded messages, separated with a comma. Listed messages of the
 * sender will be shown in the message body at the recipient's. Example: "123,431,544" 
 * @param stickerId Sticker id. minimum 0
 * @param groupId Group ID (for group messages with group access token) minimum 0
 * @param keyboard  
 * @param template  
 * @param payload  maxLength 1000
 * @param dontParseLinks  default false
 * @param disableMentions  default false
 * @param intent  default "default"
 * @param subscribeId  minimum 0 maximum 100
 */
class MessagesSendUserids(
    private val userId: Int? = null,
    private val randomId: Int? = null,
    private val peerId: Int? = null,
    private val domain: String? = null,
    private val chatId: Int? = null,
    private val userIds: List<Int>? = null,
    private val message: String? = null,
    private val lat: Float? = null,
    private val long: Float? = null,
    private val attachment: String? = null,
    private val replyTo: Int? = null,
    private val forwardMessages: List<Int>? = null,
    private val stickerId: Int? = null,
    private val groupId: Int? = null,
    private val keyboard: String? = null,
    private val template: String? = null,
    private val payload: String? = null,
    private val dontParseLinks: Boolean? = null,
    private val disableMentions: Boolean? = null,
    private val intent: MessagesSendIntent? = null,
    private val subscribeId: Int? = null
) : VKRequest<List<Any>>("messages.send") {
    init {
        userId?.let { value ->
            addParam("user_id", value)
        }
        randomId?.let { value ->
            addParam("random_id", value)
        }
        peerId?.let { value ->
            addParam("peer_id", value)
        }
        domain?.let { value ->
            addParam("domain", value)
        }
        chatId?.let { value ->
            addParam("chat_id", value)
        }
        userIds?.let { value ->
            addParam("user_ids", value)
        }
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
        replyTo?.let { value ->
            addParam("reply_to", value)
        }
        forwardMessages?.let { value ->
            addParam("forward_messages", value)
        }
        stickerId?.let { value ->
            addParam("sticker_id", value)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        keyboard?.let { value ->
            addParam("keyboard", value)
        }
        template?.let { value ->
            addParam("template", value)
        }
        payload?.let { value ->
            addParam("payload", value)
        }
        dontParseLinks?.let { value ->
            addParam("dont_parse_links", if (value) 1 else 0)
        }
        disableMentions?.let { value ->
            addParam("disable_mentions", if (value) 1 else 0)
        }
        intent?.let { value ->
            addParam("intent", value.value)
        }
        subscribeId?.let { value ->
            addParam("subscribe_id", value)
        }
    }

    override fun parse(r: JSONObject): List<Any> = GsonHolder.gson.fromJson(r.toString(),
            MessagesSendUserIdsResponse::class.java).response
}
