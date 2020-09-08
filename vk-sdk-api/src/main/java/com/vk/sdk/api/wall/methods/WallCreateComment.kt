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
package com.vk.sdk.api.wall.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.wall.dto.WallCreateCommentResponseDto
import com.vk.sdk.api.wall.responses.WallCreateCommentResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Adds a comment to a post on a user wall or community wall.
 * @param postId Post ID. minimum 0
 * @param ownerId User ID or community ID. Use a negative value to designate a community ID. 
 * @param fromGroup Group ID. minimum 0
 * @param message (Required if 'attachments' is not set.) Text of the comment. 
 * @param replyToComment ID of comment to reply. 
 * @param attachments (Required if 'message' is not set.) List of media objects attached to the
 * comment, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", '' � Type of media
 * ojbect: 'photo' � photo, 'video' � video, 'audio' � audio, 'doc' � document, '<owner_id>' � ID of
 * the media owner. '<media_id>' � Media ID. For example: "photo100172_166443618,photo66748_265827614" 
 * @param stickerId Sticker ID. minimum 0
 * @param guid Unique identifier to avoid repeated comments. 
 */
class WallCreateComment(
    private val postId: Int,
    private val ownerId: Int? = null,
    private val fromGroup: Int? = null,
    private val message: String? = null,
    private val replyToComment: Int? = null,
    private val attachments: List<String>? = null,
    private val stickerId: Int? = null,
    private val guid: String? = null
) : VKRequest<WallCreateCommentResponseDto>("wall.createComment") {
    init {
        addParam("post_id", postId)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        fromGroup?.let { value ->
            addParam("from_group", value)
        }
        message?.let { value ->
            addParam("message", value)
        }
        replyToComment?.let { value ->
            addParam("reply_to_comment", value)
        }
        attachments?.let { value ->
            addParam("attachments", value)
        }
        stickerId?.let { value ->
            addParam("sticker_id", value)
        }
        guid?.let { value ->
            addParam("guid", value)
        }
    }

    override fun parse(r: JSONObject): WallCreateCommentResponseDto =
            GsonHolder.gson.fromJson(r.toString(), WallCreateCommentResponse::class.java).response
}
