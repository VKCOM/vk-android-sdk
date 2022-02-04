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
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param created - Date when the album has been created in Unixtime
 * @param id - Photo album ID
 * @param ownerId - Album owner's ID
 * @param size - Photos number
 * @param title - Photo album title
 * @param updated - Date when the album has been updated last time in Unixtime
 * @param canUpload - Information whether current user can upload photo to the album
 * @param commentsDisabled - Information whether album comments are disabled
 * @param description - Photo album description
 * @param canDelete - album can delete
 * @param sizes
 * @param thumbId - Thumb photo ID
 * @param thumbIsLast - Information whether the album thumb is last photo
 * @param thumbSrc - URL of the thumb image
 * @param uploadByAdminsOnly - Information whether only community administrators can upload photos
 */
data class PhotosPhotoAlbumFull(
    @SerializedName("created")
    val created: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("size")
    val size: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated")
    val updated: Int,
    @SerializedName("can_upload")
    val canUpload: BaseBoolInt? = null,
    @SerializedName("comments_disabled")
    val commentsDisabled: BaseBoolInt? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("can_delete")
    val canDelete: Boolean? = null,
    @SerializedName("sizes")
    val sizes: List<PhotosPhotoSizes>? = null,
    @SerializedName("thumb_id")
    val thumbId: Int? = null,
    @SerializedName("thumb_is_last")
    val thumbIsLast: BaseBoolInt? = null,
    @SerializedName("thumb_src")
    val thumbSrc: String? = null,
    @SerializedName("upload_by_admins_only")
    val uploadByAdminsOnly: BaseBoolInt? = null
)
