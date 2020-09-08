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
package com.vk.sdk.api.photos.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseLikes
import com.vk.sdk.api.base.dto.BaseObjectCount
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param albumId Album ID
 * @param date Date when uploaded
 * @param id Photo ID
 * @param ownerId Photo owner's ID
 * @param accessKey Access key for the photo
 * @param canComment Information whether current user can comment the photo
 * @param comments no description
 * @param height Original photo height
 * @param images no description
 * @param lat Latitude
 * @param likes no description
 * @param long Longitude
 * @param postId Post ID
 * @param reposts no description
 * @param tags no description
 * @param text Photo caption
 * @param userId ID of the user who have uploaded the photo
 * @param width Original photo width
 */
data class PhotosPhotoFull(
    @SerializedName(value="album_id")
    val albumId: Int,
    @SerializedName(value="date")
    val date: Int,
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="owner_id")
    val ownerId: Int,
    @SerializedName(value="access_key")
    val accessKey: String? = null,
    @SerializedName(value="can_comment")
    val canComment: BaseBoolInt? = null,
    @SerializedName(value="comments")
    val comments: BaseObjectCount? = null,
    @SerializedName(value="height")
    val height: Int? = null,
    @SerializedName(value="images")
    val images: List<PhotosImage>? = null,
    @SerializedName(value="lat")
    val lat: Float? = null,
    @SerializedName(value="likes")
    val likes: BaseLikes? = null,
    @SerializedName(value="long")
    val long: Float? = null,
    @SerializedName(value="post_id")
    val postId: Int? = null,
    @SerializedName(value="reposts")
    val reposts: BaseObjectCount? = null,
    @SerializedName(value="tags")
    val tags: BaseObjectCount? = null,
    @SerializedName(value="text")
    val text: String? = null,
    @SerializedName(value="user_id")
    val userId: Int? = null,
    @SerializedName(value="width")
    val width: Int? = null
)
