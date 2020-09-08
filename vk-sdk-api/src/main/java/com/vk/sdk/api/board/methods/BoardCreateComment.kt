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
package com.vk.sdk.api.board.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.board.responses.BoardCreateCommentResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Adds a comment on a topic on a community's discussion board.
 * @param groupId ID of the community that owns the discussion board. minimum 0
 * @param topicId ID of the topic to be commented on. minimum 0
 * @param message (Required if 'attachments' is not set.) Text of the comment. 
 * @param attachments (Required if 'text' is not set.) List of media objects attached to the
 * comment, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", '' � Type of media
 * object: 'photo' � photo, 'video' � video, 'audio' � audio, 'doc' � document, '<owner_id>' � ID of
 * the media owner. '<media_id>' � Media ID. 
 * @param fromGroup '1' � to post the comment as by the community, '0' � to post the comment as by
 * the user (default) 
 * @param stickerId Sticker ID. minimum 0
 * @param guid Unique identifier to avoid repeated comments. 
 */
class BoardCreateComment(
    private val groupId: Int,
    private val topicId: Int,
    private val message: String? = null,
    private val attachments: List<String>? = null,
    private val fromGroup: Boolean? = null,
    private val stickerId: Int? = null,
    private val guid: String? = null
) : VKRequest<Int>("board.createComment") {
    init {
        addParam("group_id", groupId)
        addParam("topic_id", topicId)
        message?.let { value ->
            addParam("message", value)
        }
        attachments?.let { value ->
            addParam("attachments", value)
        }
        fromGroup?.let { value ->
            addParam("from_group", if (value) 1 else 0)
        }
        stickerId?.let { value ->
            addParam("sticker_id", value)
        }
        guid?.let { value ->
            addParam("guid", value)
        }
    }

    override fun parse(r: JSONObject): Int = GsonHolder.gson.fromJson(r.toString(),
            BoardCreateCommentResponse::class.java).response
}
