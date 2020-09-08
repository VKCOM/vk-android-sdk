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
import com.vk.sdk.api.photos.responses.PhotosSaveMarketPhotoResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Saves market photos after successful uploading.
 * @param photo Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server]. 
 * @param server Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server]. 
 * @param hash Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server]. 
 * @param groupId Community ID. minimum 0
 * @param cropData Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server]. 
 * @param cropHash Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server]. 
 */
class PhotosSaveMarketPhoto(
    private val photo: String,
    private val server: Int,
    private val hash: String,
    private val groupId: Int? = null,
    private val cropData: String? = null,
    private val cropHash: String? = null
) : VKRequest<List<PhotosPhoto>>("photos.saveMarketPhoto") {
    init {
        addParam("photo", photo)
        addParam("server", server)
        addParam("hash", hash)
        groupId?.let { value ->
            addParam("group_id", value)
        }
        cropData?.let { value ->
            addParam("crop_data", value)
        }
        cropHash?.let { value ->
            addParam("crop_hash", value)
        }
    }

    override fun parse(r: JSONObject): List<PhotosPhoto> = GsonHolder.gson.fromJson(r.toString(),
            PhotosSaveMarketPhotoResponse::class.java).response
}
