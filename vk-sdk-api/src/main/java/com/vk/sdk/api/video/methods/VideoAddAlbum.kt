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
import com.vk.sdk.api.video.dto.VideoAddAlbumPrivacy
import com.vk.sdk.api.video.dto.VideoAddAlbumResponseDto
import com.vk.sdk.api.video.responses.VideoAddAlbumResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Creates an empty album for videos.
 * @param groupId Community ID (if the album will be created in a community). minimum 0
 * @param title Album title. 
 * @param privacy new access permissions for the album. Possible values: , *'0' � all users,, *'1' �
 * friends only,, *'2' � friends and friends of friends,, *'3' � "only me". 
 */
class VideoAddAlbum(
    private val groupId: Int? = null,
    private val title: String? = null,
    private val privacy: List<VideoAddAlbumPrivacy>? = null
) : VKRequest<VideoAddAlbumResponseDto>("video.addAlbum") {
    init {
        groupId?.let { value ->
            addParam("group_id", value)
        }
        title?.let { value ->
            addParam("title", value)
        }
        privacy?.let { value ->
            addParam("privacy", value.map { it.value })
        }
    }

    override fun parse(r: JSONObject): VideoAddAlbumResponseDto =
            GsonHolder.gson.fromJson(r.toString(), VideoAddAlbumResponse::class.java).response
}
