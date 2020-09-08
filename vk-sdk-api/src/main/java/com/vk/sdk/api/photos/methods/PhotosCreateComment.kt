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
package com.vk.sdk.api.photos.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.photos.responses.PhotosCreateCommentResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Adds a new comment on the photo.
 * @param photoId Photo ID. 
 * @param ownerId ID of the user or community that owns the photo. 
 * @param message Comment text. 
 * @param attachments (Required if 'message' is not set.) List of objects attached to the post, in
 * the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", '' � Type of media attachment:
 * 'photo' � photo, 'video' � video, 'audio' � audio, 'doc' � document, '<owner_id>' � Media attachment
 * owner ID. '<media_id>' � Media attachment ID. Example: "photo100172_166443618,photo66748_265827614" 
 * @param fromGroup '1' � to post a comment from the community 
 * @param replyToComment  
 * @param stickerId  minimum 0
 * @param accessKey  
 * @param guid  
 */
class PhotosCreateComment(
    private val photoId: Int,
    private val ownerId: Int? = null,
    private val message: String? = null,
    private val attachments: List<String>? = null,
    private val fromGroup: Boolean? = null,
    private val replyToComment: Int? = null,
    private val stickerId: Int? = null,
    private val accessKey: String? = null,
    private val guid: String? = null
) : VKRequest<Int>("photos.createComment") {
    init {
        addParam("photo_id", photoId)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        message?.let { value ->
            addParam("message", value)
        }
        attachments?.let { value ->
            addParam("attachments", value)
        }
        fromGroup?.let { value ->
            addParam("from_group", if (value) 1 else 0)
        }
        replyToComment?.let { value ->
            addParam("reply_to_comment", value)
        }
        stickerId?.let { value ->
            addParam("sticker_id", value)
        }
        accessKey?.let { value ->
            addParam("access_key", value)
        }
        guid?.let { value ->
            addParam("guid", value)
        }
    }

    override fun parse(r: JSONObject): Int = GsonHolder.gson.fromJson(r.toString(),
            PhotosCreateCommentResponse::class.java).response
}
