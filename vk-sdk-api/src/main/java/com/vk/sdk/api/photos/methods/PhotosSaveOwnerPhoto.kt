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
import com.vk.sdk.api.photos.dto.PhotosSaveOwnerPhotoResponseDto
import com.vk.sdk.api.photos.responses.PhotosSaveOwnerPhotoResponse
import kotlin.String
import org.json.JSONObject

/**
 * Saves a profile or community photo. Upload URL can be got with the
 * [vk.com/dev/photos.getOwnerPhotoUploadServer|photos.getOwnerPhotoUploadServer] method.
 * @param server parameter returned after [vk.com/dev/upload_files|photo upload]. 
 * @param hash parameter returned after [vk.com/dev/upload_files|photo upload]. 
 * @param photo parameter returned after [vk.com/dev/upload_files|photo upload]. 
 */
class PhotosSaveOwnerPhoto(
    private val server: String? = null,
    private val hash: String? = null,
    private val photo: String? = null
) : VKRequest<PhotosSaveOwnerPhotoResponseDto>("photos.saveOwnerPhoto") {
    init {
        server?.let { value ->
            addParam("server", value)
        }
        hash?.let { value ->
            addParam("hash", value)
        }
        photo?.let { value ->
            addParam("photo", value)
        }
    }

    override fun parse(r: JSONObject): PhotosSaveOwnerPhotoResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            PhotosSaveOwnerPhotoResponse::class.java).response
}
