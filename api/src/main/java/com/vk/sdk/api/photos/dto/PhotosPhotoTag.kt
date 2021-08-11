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
import kotlin.Float
import kotlin.Int
import kotlin.String

/**
 * @param date - Date when tag has been added in Unixtime
 * @param id - Tag ID
 * @param placerId - ID of the tag creator
 * @param taggedName - Tag description
 * @param userId - Tagged user ID
 * @param viewed - Information whether the tag is reviewed
 * @param x - Coordinate X of the left upper corner
 * @param x2 - Coordinate X of the right lower corner
 * @param y - Coordinate Y of the left upper corner
 * @param y2 - Coordinate Y of the right lower corner
 * @param description - Tagged description.
 */
data class PhotosPhotoTag(
    @SerializedName("date")
    val date: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("placer_id")
    val placerId: Int,
    @SerializedName("tagged_name")
    val taggedName: String,
    @SerializedName("user_id")
    val userId: UserId,
    @SerializedName("viewed")
    val viewed: BaseBoolInt,
    @SerializedName("x")
    val x: Float,
    @SerializedName("x2")
    val x2: Float,
    @SerializedName("y")
    val y: Float,
    @SerializedName("y2")
    val y2: Float,
    @SerializedName("description")
    val description: String? = null
)
