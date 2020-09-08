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
package com.vk.sdk.api.video.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.video.dto.VideoGetCommentsExtendedResponseDto
import com.vk.sdk.api.video.dto.VideoGetCommentsSort
import com.vk.sdk.api.video.responses.VideoGetCommentsExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of comments on a video.
 * @param videoId Video ID. minimum 0
 * @param ownerId ID of the user or community that owns the video. 
 * @param needLikes '1' � to return an additional 'likes' field 
 * @param startCommentId  minimum 0
 * @param offset Offset needed to return a specific subset of comments. 
 * @param count Number of comments to return. default 20 minimum 0 maximum 100
 * @param sort Sort order: 'asc' � oldest comment first, 'desc' � newest comment first 
 * @param extended  
 * @param fields  
 */
class VideoGetCommentsExtended(
    private val videoId: Int,
    private val ownerId: Int? = null,
    private val needLikes: Boolean? = null,
    private val startCommentId: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val sort: VideoGetCommentsSort? = null,
    private val extended: Boolean? = null,
    private val fields: List<String>? = null
) : VKRequest<VideoGetCommentsExtendedResponseDto>("video.getComments") {
    init {
        addParam("video_id", videoId)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        needLikes?.let { value ->
            addParam("need_likes", if (value) 1 else 0)
        }
        startCommentId?.let { value ->
            addParam("start_comment_id", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        sort?.let { value ->
            addParam("sort", value.value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): VideoGetCommentsExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            VideoGetCommentsExtendedResponse::class.java).response
}
