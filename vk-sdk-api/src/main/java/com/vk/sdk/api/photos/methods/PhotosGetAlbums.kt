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
import com.vk.sdk.api.photos.dto.PhotosGetAlbumsResponseDto
import com.vk.sdk.api.photos.responses.PhotosGetAlbumsResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of a user's or community's photo albums.
 * @param ownerId ID of the user or community that owns the albums. 
 * @param albumIds Album IDs. 
 * @param offset Offset needed to return a specific subset of albums. minimum 0
 * @param count Number of albums to return. minimum 0
 * @param needSystem '1' � to return system albums with negative IDs 
 * @param needCovers '1' � to return an additional 'thumb_src' field, '0' � (default) 
 * @param photoSizes '1' � to return photo sizes in a 
 */
class PhotosGetAlbums(
    private val ownerId: Int? = null,
    private val albumIds: List<Int>? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val needSystem: Boolean? = null,
    private val needCovers: Boolean? = null,
    private val photoSizes: Boolean? = null
) : VKRequest<PhotosGetAlbumsResponseDto>("photos.getAlbums") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        albumIds?.let { value ->
            addParam("album_ids", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        needSystem?.let { value ->
            addParam("need_system", if (value) 1 else 0)
        }
        needCovers?.let { value ->
            addParam("need_covers", if (value) 1 else 0)
        }
        photoSizes?.let { value ->
            addParam("photo_sizes", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): PhotosGetAlbumsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), PhotosGetAlbumsResponse::class.java).response
}
