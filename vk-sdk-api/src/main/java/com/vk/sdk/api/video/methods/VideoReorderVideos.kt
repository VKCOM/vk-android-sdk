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
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Int
import org.json.JSONObject

/**
 * Reorders the video in the video album.
 * @param ownerId ID of the user or community that owns the video. 
 * @param videoId ID of the video. minimum 0
 * @param targetId ID of the user or community that owns the album with videos. 
 * @param albumId ID of the video album. 
 * @param beforeOwnerId ID of the user or community that owns the video before which the video in
 * question shall be placed. 
 * @param beforeVideoId ID of the video before which the video in question shall be placed. minimum
 * 0
 * @param afterOwnerId ID of the user or community that owns the video after which the photo in
 * question shall be placed. 
 * @param afterVideoId ID of the video after which the photo in question shall be placed. minimum 0
 */
class VideoReorderVideos(
    private val ownerId: Int,
    private val videoId: Int,
    private val targetId: Int? = null,
    private val albumId: Int? = null,
    private val beforeOwnerId: Int? = null,
    private val beforeVideoId: Int? = null,
    private val afterOwnerId: Int? = null,
    private val afterVideoId: Int? = null
) : VKRequest<BaseOkResponseDto>("video.reorderVideos") {
    init {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId)
        targetId?.let { value ->
            addParam("target_id", value)
        }
        albumId?.let { value ->
            addParam("album_id", value)
        }
        beforeOwnerId?.let { value ->
            addParam("before_owner_id", value)
        }
        beforeVideoId?.let { value ->
            addParam("before_video_id", value)
        }
        afterOwnerId?.let { value ->
            addParam("after_owner_id", value)
        }
        afterVideoId?.let { value ->
            addParam("after_video_id", value)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
