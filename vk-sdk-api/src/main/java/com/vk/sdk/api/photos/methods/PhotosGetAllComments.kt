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
import com.vk.sdk.api.photos.dto.PhotosGetAllCommentsResponseDto
import com.vk.sdk.api.photos.responses.PhotosGetAllCommentsResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * Returns a list of comments on a specific photo album or all albums of the user sorted in reverse
 * chronological order.
 * @param ownerId ID of the user or community that owns the album(s). 
 * @param albumId Album ID. If the parameter is not set, comments on all of the user's albums will
 * be returned. minimum 0
 * @param needLikes '1' � to return an additional 'likes' field, '0' � (default) 
 * @param offset Offset needed to return a specific subset of comments. By default, '0'. minimum 0
 * @param count Number of comments to return. By default, '20'. Maximum value, '100'. minimum 0
 */
class PhotosGetAllComments(
    private val ownerId: Int? = null,
    private val albumId: Int? = null,
    private val needLikes: Boolean? = null,
    private val offset: Int? = null,
    private val count: Int? = null
) : VKRequest<PhotosGetAllCommentsResponseDto>("photos.getAllComments") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        albumId?.let { value ->
            addParam("album_id", value)
        }
        needLikes?.let { value ->
            addParam("need_likes", if (value) 1 else 0)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
    }

    override fun parse(r: JSONObject): PhotosGetAllCommentsResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            PhotosGetAllCommentsResponse::class.java).response
}
