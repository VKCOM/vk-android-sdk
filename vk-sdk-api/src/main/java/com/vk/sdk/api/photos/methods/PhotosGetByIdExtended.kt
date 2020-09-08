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
import com.vk.sdk.api.photos.dto.PhotosPhotoFull
import com.vk.sdk.api.photos.responses.PhotosGetByIdExtendedResponse
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns information about photos by their IDs.
 * @param photos IDs separated with a comma, that are IDs of users who posted photos and IDs of
 * photos themselves with an underscore character between such IDs. To get information about a photo in
 * the group album, you shall specify group ID instead of user ID. Example:
 * "1_129207899,6492_135055734, , -20629724_271945303" 
 * @param extended '1' � to return additional fields, '0' � (default) 
 * @param photoSizes '1' � to return photo sizes in a 
 */
class PhotosGetByIdExtended(
    private val photos: List<String>,
    private val extended: Boolean? = null,
    private val photoSizes: Boolean? = null
) : VKRequest<List<PhotosPhotoFull>>("photos.getById") {
    init {
        addParam("photos", photos)
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        photoSizes?.let { value ->
            addParam("photo_sizes", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): List<PhotosPhotoFull> =
            GsonHolder.gson.fromJson(r.toString(),
            PhotosGetByIdExtendedResponse::class.java).response
}
