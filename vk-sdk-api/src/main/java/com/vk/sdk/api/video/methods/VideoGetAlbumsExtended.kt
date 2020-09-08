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
import com.vk.sdk.api.video.dto.VideoGetAlbumsExtendedResponseDto
import com.vk.sdk.api.video.responses.VideoGetAlbumsExtendedResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * Returns a list of video albums owned by a user or community.
 * @param ownerId ID of the user or community that owns the video album(s). 
 * @param offset Offset needed to return a specific subset of video albums. minimum 0
 * @param count Number of video albums to return. default 50 minimum 0 maximum 100
 * @param extended '1' � to return additional information about album privacy settings for the
 * current user 
 * @param needSystem  default 0
 */
class VideoGetAlbumsExtended(
    private val ownerId: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null,
    private val needSystem: Boolean? = null
) : VKRequest<VideoGetAlbumsExtendedResponseDto>("video.getAlbums") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        needSystem?.let { value ->
            addParam("need_system", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): VideoGetAlbumsExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            VideoGetAlbumsExtendedResponse::class.java).response
}
