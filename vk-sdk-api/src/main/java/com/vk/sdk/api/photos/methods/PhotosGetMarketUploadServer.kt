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
import com.vk.sdk.api.base.dto.BaseUploadServer
import com.vk.sdk.api.photos.responses.PhotosGetMarketUploadServerResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * Returns the server address for market photo upload.
 * @param groupId Community ID. minimum 0
 * @param mainPhoto '1' if you want to upload the main item photo. 
 * @param cropX X coordinate of the crop left upper corner. minimum 0
 * @param cropY Y coordinate of the crop left upper corner. minimum 0
 * @param cropWidth Width of the cropped photo in px. minimum 400
 */
class PhotosGetMarketUploadServer(
    private val groupId: Int,
    private val mainPhoto: Boolean? = null,
    private val cropX: Int? = null,
    private val cropY: Int? = null,
    private val cropWidth: Int? = null
) : VKRequest<BaseUploadServer>("photos.getMarketUploadServer") {
    init {
        addParam("group_id", groupId)
        mainPhoto?.let { value ->
            addParam("main_photo", if (value) 1 else 0)
        }
        cropX?.let { value ->
            addParam("crop_x", value)
        }
        cropY?.let { value ->
            addParam("crop_y", value)
        }
        cropWidth?.let { value ->
            addParam("crop_width", value)
        }
    }

    override fun parse(r: JSONObject): BaseUploadServer = GsonHolder.gson.fromJson(r.toString(),
            PhotosGetMarketUploadServerResponse::class.java).response
}
