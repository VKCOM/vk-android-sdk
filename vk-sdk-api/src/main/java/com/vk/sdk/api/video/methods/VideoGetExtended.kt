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
import com.vk.sdk.api.video.dto.VideoGetExtendedResponseDto
import com.vk.sdk.api.video.responses.VideoGetExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns detailed information about videos.
 * @param ownerId ID of the user or community that owns the video(s). 
 * @param videos Video IDs, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>",
 * Use a negative value to designate a community ID. Example: "-4363_136089719,13245770_137352259" 
 * @param albumId ID of the album containing the video(s). 
 * @param count Number of videos to return. default 100 minimum 0 maximum 200
 * @param offset Offset needed to return a specific subset of videos. minimum 0
 * @param extended '1' � to return an extended response with additional fields 
 */
class VideoGetExtended(
    private val ownerId: Int? = null,
    private val videos: List<String>? = null,
    private val albumId: Int? = null,
    private val count: Int? = null,
    private val offset: Int? = null,
    private val extended: Boolean? = null
) : VKRequest<VideoGetExtendedResponseDto>("video.get") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        videos?.let { value ->
            addParam("videos", value)
        }
        albumId?.let { value ->
            addParam("album_id", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): VideoGetExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(), VideoGetExtendedResponse::class.java).response
}
