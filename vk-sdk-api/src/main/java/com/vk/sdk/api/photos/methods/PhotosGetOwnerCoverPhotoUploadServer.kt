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
import com.vk.sdk.api.base.responses.BaseGetUploadServerResponse
import kotlin.Int
import org.json.JSONObject

/**
 * Returns the server address for owner cover upload.
 * @param groupId ID of community that owns the album (if the photo will be uploaded to a community
 * album). minimum 0
 * @param cropX X coordinate of the left-upper corner default 0 minimum 0
 * @param cropY Y coordinate of the left-upper corner default 0 minimum 0
 * @param cropX2 X coordinate of the right-bottom corner default 795 minimum 0
 * @param cropY2 Y coordinate of the right-bottom corner default 200 minimum 0
 */
class PhotosGetOwnerCoverPhotoUploadServer(
    private val groupId: Int,
    private val cropX: Int? = null,
    private val cropY: Int? = null,
    private val cropX2: Int? = null,
    private val cropY2: Int? = null
) : VKRequest<BaseUploadServer>("photos.getOwnerCoverPhotoUploadServer") {
    init {
        addParam("group_id", groupId)
        cropX?.let { value ->
            addParam("crop_x", value)
        }
        cropY?.let { value ->
            addParam("crop_y", value)
        }
        cropX2?.let { value ->
            addParam("crop_x2", value)
        }
        cropY2?.let { value ->
            addParam("crop_y2", value)
        }
    }

    override fun parse(r: JSONObject): BaseUploadServer = GsonHolder.gson.fromJson(r.toString(),
            BaseGetUploadServerResponse::class.java).response
}
