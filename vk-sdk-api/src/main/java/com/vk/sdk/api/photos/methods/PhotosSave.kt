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
import com.vk.sdk.api.photos.dto.PhotosPhoto
import com.vk.sdk.api.photos.responses.PhotosSaveResponse
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Saves photos after successful uploading.
 * @param albumId ID of the album to save photos to. 
 * @param groupId ID of the community to save photos to. 
 * @param server Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server]. 
 * @param photosList Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
 * server]. 
 * @param hash Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server]. 
 * @param latitude Geographical latitude, in degrees (from '-90' to '90'). 
 * @param longitude Geographical longitude, in degrees (from '-180' to '180'). 
 * @param caption Text describing the photo. 2048 digits max. 
 */
class PhotosSave(
    private val albumId: Int? = null,
    private val groupId: Int? = null,
    private val server: Int? = null,
    private val photosList: String? = null,
    private val hash: String? = null,
    private val latitude: Float? = null,
    private val longitude: Float? = null,
    private val caption: String? = null
) : VKRequest<List<PhotosPhoto>>("photos.save") {
    init {
        albumId?.let { value ->
            addParam("album_id", value)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        server?.let { value ->
            addParam("server", value)
        }
        photosList?.let { value ->
            addParam("photos_list", value)
        }
        hash?.let { value ->
            addParam("hash", value)
        }
        latitude?.let { value ->
            addParam("latitude", value.toString())
        }
        longitude?.let { value ->
            addParam("longitude", value.toString())
        }
        caption?.let { value ->
            addParam("caption", value)
        }
    }

    override fun parse(r: JSONObject): List<PhotosPhoto> = GsonHolder.gson.fromJson(r.toString(),
            PhotosSaveResponse::class.java).response
}
