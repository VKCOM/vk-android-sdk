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
import com.vk.sdk.api.photos.dto.PhotosGetCommentsExtendedResponseDto
import com.vk.sdk.api.photos.dto.PhotosGetCommentsSort
import com.vk.sdk.api.photos.responses.PhotosGetCommentsExtendedResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of comments on a photo.
 * @param photoId Photo ID. 
 * @param ownerId ID of the user or community that owns the photo. 
 * @param needLikes '1' � to return an additional 'likes' field, '0' � (default) 
 * @param startCommentId  minimum 0
 * @param offset Offset needed to return a specific subset of comments. By default, '0'. 
 * @param count Number of comments to return. default "20" minimum 0 maximum 100
 * @param sort Sort order: 'asc' � old first, 'desc' � new first 
 * @param accessKey  
 * @param extended  
 * @param fields  
 */
class PhotosGetCommentsExtended(
    private val photoId: Int,
    private val ownerId: Int? = null,
    private val needLikes: Boolean? = null,
    private val startCommentId: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val sort: PhotosGetCommentsSort? = null,
    private val accessKey: String? = null,
    private val extended: Boolean? = null,
    private val fields: List<UsersFields>? = null
) : VKRequest<PhotosGetCommentsExtendedResponseDto>("photos.getComments") {
    init {
        addParam("photo_id", photoId)
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
        accessKey?.let { value ->
            addParam("access_key", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): PhotosGetCommentsExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            PhotosGetCommentsExtendedResponse::class.java).response
}
