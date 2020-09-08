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
import com.vk.sdk.api.photos.dto.PhotosPhotoAlbumFull
import com.vk.sdk.api.photos.responses.PhotosCreateAlbumResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Creates an empty photo album.
 * @param title Album title. minLength 2
 * @param groupId ID of the community in which the album will be created. 
 * @param description Album description. 
 * @param privacyView  default "all"
 * @param privacyComment  default "all"
 * @param uploadByAdminsOnly  
 * @param commentsDisabled  
 */
class PhotosCreateAlbum(
    private val title: String,
    private val groupId: Int? = null,
    private val description: String? = null,
    private val privacyView: List<String>? = null,
    private val privacyComment: List<String>? = null,
    private val uploadByAdminsOnly: Boolean? = null,
    private val commentsDisabled: Boolean? = null
) : VKRequest<PhotosPhotoAlbumFull>("photos.createAlbum") {
    init {
        addParam("title", title)
        groupId?.let { value ->
            addParam("group_id", value)
        }
        description?.let { value ->
            addParam("description", value)
        }
        privacyView?.let { value ->
            addParam("privacy_view", value)
        }
        privacyComment?.let { value ->
            addParam("privacy_comment", value)
        }
        uploadByAdminsOnly?.let { value ->
            addParam("upload_by_admins_only", if (value) 1 else 0)
        }
        commentsDisabled?.let { value ->
            addParam("comments_disabled", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): PhotosPhotoAlbumFull = GsonHolder.gson.fromJson(r.toString(),
            PhotosCreateAlbumResponse::class.java).response
}
