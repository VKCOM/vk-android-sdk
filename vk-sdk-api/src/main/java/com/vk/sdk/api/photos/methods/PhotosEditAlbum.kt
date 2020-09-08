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
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Edits information about a photo album.
 * @param albumId ID of the photo album to be edited. minimum 0
 * @param title New album title. 
 * @param description New album description. 
 * @param ownerId ID of the user or community that owns the album. 
 * @param privacyView  
 * @param privacyComment  
 * @param uploadByAdminsOnly  
 * @param commentsDisabled  
 */
class PhotosEditAlbum(
    private val albumId: Int,
    private val title: String? = null,
    private val description: String? = null,
    private val ownerId: Int? = null,
    private val privacyView: List<String>? = null,
    private val privacyComment: List<String>? = null,
    private val uploadByAdminsOnly: Boolean? = null,
    private val commentsDisabled: Boolean? = null
) : VKRequest<BaseOkResponseDto>("photos.editAlbum") {
    init {
        addParam("album_id", albumId)
        title?.let { value ->
            addParam("title", value)
        }
        description?.let { value ->
            addParam("description", value)
        }
        ownerId?.let { value ->
            addParam("owner_id", value)
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

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
