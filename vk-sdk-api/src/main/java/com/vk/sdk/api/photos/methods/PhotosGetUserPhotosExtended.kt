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
import com.vk.sdk.api.photos.dto.PhotosGetUserPhotosExtendedResponseDto
import com.vk.sdk.api.photos.responses.PhotosGetUserPhotosExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Returns a list of photos in which a user is tagged.
 * @param userId User ID. minimum 0
 * @param offset Offset needed to return a specific subset of photos. By default, '0'. minimum 0
 * @param count Number of photos to return. Maximum value is 1000. default 20 minimum 0 maximum 1000
 * @param extended '1' � to return an additional 'likes' field, '0' � (default) 
 * @param sort Sort order: '1' � by date the tag was added in ascending order, '0' � by date the tag
 * was added in descending order 
 */
class PhotosGetUserPhotosExtended(
    private val userId: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null,
    private val sort: String? = null
) : VKRequest<PhotosGetUserPhotosExtendedResponseDto>("photos.getUserPhotos") {
    init {
        userId?.let { value ->
            addParam("user_id", value)
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
        sort?.let { value ->
            addParam("sort", value)
        }
    }

    override fun parse(r: JSONObject): PhotosGetUserPhotosExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            PhotosGetUserPhotosExtendedResponse::class.java).response
}
