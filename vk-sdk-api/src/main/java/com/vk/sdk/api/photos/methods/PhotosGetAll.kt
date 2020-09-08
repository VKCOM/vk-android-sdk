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
import com.vk.sdk.api.photos.dto.PhotosGetAllResponseDto
import com.vk.sdk.api.photos.responses.PhotosGetAllResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * Returns a list of photos belonging to a user or community, in reverse chronological order.
 * @param ownerId ID of a user or community that owns the photos. Use a negative value to designate
 * a community ID. 
 * @param extended '1' � to return detailed information about photos 
 * @param offset Offset needed to return a specific subset of photos. By default, '0'. minimum 0
 * @param count Number of photos to return. default 20 minimum 0 maximum 200
 * @param photoSizes '1' � to return image sizes in [vk.com/dev/photo_sizes|special format]. 
 * @param noServiceAlbums '1' � to return photos only from standard albums, '0' � to return all
 * photos including those in service albums, e.g., 'My wall photos' (default) 
 * @param needHidden '1' � to show information about photos being hidden from the block above the
 * wall. 
 * @param skipHidden '1' � not to return photos being hidden from the block above the wall. Works
 * only with owner_id>0, no_service_albums is ignored. 
 */
class PhotosGetAll(
    private val ownerId: Int? = null,
    private val extended: Boolean? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val photoSizes: Boolean? = null,
    private val noServiceAlbums: Boolean? = null,
    private val needHidden: Boolean? = null,
    private val skipHidden: Boolean? = null
) : VKRequest<PhotosGetAllResponseDto>("photos.getAll") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        photoSizes?.let { value ->
            addParam("photo_sizes", if (value) 1 else 0)
        }
        noServiceAlbums?.let { value ->
            addParam("no_service_albums", if (value) 1 else 0)
        }
        needHidden?.let { value ->
            addParam("need_hidden", if (value) 1 else 0)
        }
        skipHidden?.let { value ->
            addParam("skip_hidden", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): PhotosGetAllResponseDto =
            GsonHolder.gson.fromJson(r.toString(), PhotosGetAllResponse::class.java).response
}
