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
package com.vk.sdk.api.video.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BasePropertyExists
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param count - Total number of videos in album
 * @param updatedTime - Date when the album has been updated last time in Unixtime
 * @param id - Album ID
 * @param ownerId - Album owner's ID
 * @param title - Album title
 * @param image - Album cover image in different sizes
 * @param imageBlur - Need blur album thumb or not
 * @param isSystem - Information whether album is system
 */
data class VideoVideoAlbumFull(
    @SerializedName("count")
    val count: Int,
    @SerializedName("updated_time")
    val updatedTime: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: List<VideoVideoImage>? = null,
    @SerializedName("image_blur")
    val imageBlur: BasePropertyExists? = null,
    @SerializedName("is_system")
    val isSystem: BasePropertyExists? = null
)
