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
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Edits a comment on a topic on a community's discussion board.
 * @param groupId ID of the community that owns the discussion board. minimum 0
 * @param topicId Topic ID. minimum 0
 * @param commentId ID of the comment on the topic. minimum 0
 * @param message (Required if 'attachments' is not set). New comment text. 
 * @param attachments (Required if 'message' is not set.) List of media objects attached to the
 * comment, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", '' � Type of media
 * object: 'photo' � photo, 'video' � video, 'audio' � audio, 'doc' � document, '<owner_id>' � ID of
 * the media owner. '<media_id>' � Media ID. Example: "photo100172_166443618,photo66748_265827614" 
 */
class BoardEditComment(
    private val groupId: Int,
    private val topicId: Int,
    private val commentId: Int,
    private val message: String? = null,
    private val attachments: List<String>? = null
) : VKRequest<BaseOkResponseDto>("board.editComment") {
    init {
        addParam("group_id", groupId)
        addParam("topic_id", topicId)
        addParam("comment_id", commentId)
        message?.let { value ->
            addParam("message", value)
        }
        attachments?.let { value ->
            addParam("attachments", value)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
