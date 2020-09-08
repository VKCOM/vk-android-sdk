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
import com.vk.sdk.api.photos.dto.PhotosGetExtendedResponseDto
import com.vk.sdk.api.photos.responses.PhotosGetExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of a user's or community's photos.
 * @param ownerId ID of the user or community that owns the photos. Use a negative value to
 * designate a community ID. 
 * @param albumId Photo album ID. To return information about photos from service albums, use the
 * following string values: 'profile, wall, saved'. 
 * @param photoIds Photo IDs. 
 * @param rev Sort order: '1' � reverse chronological, '0' � chronological 
 * @param extended '1' � to return additional 'likes', 'comments', and 'tags' fields, '0' �
 * (default) 
 * @param feedType Type of feed obtained in 'feed' field of the method. 
 * @param feed unixtime, that can be obtained with [vk.com/dev/newsfeed.get|newsfeed.get] method in
 * date field to get all photos uploaded by the user on a specific day, or photos the user has been
 * tagged on. Also, 'uid' parameter of the user the event happened with shall be specified. 
 * @param photoSizes '1' � to return photo sizes in a [vk.com/dev/photo_sizes|special format] 
 * @param offset  minimum 0
 * @param count  default 50 minimum 0 maximum 1000
 */
class PhotosGetExtended(
    private val ownerId: Int? = null,
    private val albumId: String? = null,
    private val photoIds: List<String>? = null,
    private val rev: Boolean? = null,
    private val extended: Boolean? = null,
    private val feedType: String? = null,
    private val feed: Int? = null,
    private val photoSizes: Boolean? = null,
    private val offset: Int? = null,
    private val count: Int? = null
) : VKRequest<PhotosGetExtendedResponseDto>("photos.get") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        albumId?.let { value ->
            addParam("album_id", value)
        }
        photoIds?.let { value ->
            addParam("photo_ids", value)
        }
        rev?.let { value ->
            addParam("rev", if (value) 1 else 0)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        feedType?.let { value ->
            addParam("feed_type", value)
        }
        feed?.let { value ->
            addParam("feed", value)
        }
        photoSizes?.let { value ->
            addParam("photo_sizes", if (value) 1 else 0)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
    }

    override fun parse(r: JSONObject): PhotosGetExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(), PhotosGetExtendedResponse::class.java).response
}
