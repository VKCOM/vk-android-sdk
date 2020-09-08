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
package com.vk.sdk.api.likes.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.likes.dto.LikesAddResponseDto
import com.vk.sdk.api.likes.responses.LikesAddResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Adds the specified object to the 'Likes' list of the current user.
 * @param type Object type: 'post' � post on user or community wall, 'comment' � comment on a wall
 * post, 'photo' � photo, 'audio' � audio, 'video' � video, 'note' � note, 'photo_comment' � comment on
 * the photo, 'video_comment' � comment on the video, 'topic_comment' � comment in the discussion,
 * 'sitepage' � page of the site where the [vk.com/dev/Like|Like widget] is installed 
 * @param itemId Object ID. minimum 0
 * @param ownerId ID of the user or community that owns the object. 
 * @param accessKey Access key required for an object owned by a private entity. 
 */
class LikesAdd(
    private val type: String,
    private val itemId: Int,
    private val ownerId: Int? = null,
    private val accessKey: String? = null
) : VKRequest<LikesAddResponseDto>("likes.add") {
    init {
        addParam("type", type)
        addParam("item_id", itemId)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        accessKey?.let { value ->
            addParam("access_key", value)
        }
    }

    override fun parse(r: JSONObject): LikesAddResponseDto = GsonHolder.gson.fromJson(r.toString(),
            LikesAddResponse::class.java).response
}
