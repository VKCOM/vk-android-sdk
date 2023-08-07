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
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseLikesDto
import com.vk.sdk.api.base.dto.BaseObjectCountDto
import com.vk.sdk.api.base.dto.BasePropertyExistsDto
import com.vk.sdk.api.base.dto.BaseRepostsInfoDto
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param albumId - Album ID
 * @param date - Date when uploaded
 * @param id - Photo ID
 * @param ownerId - Photo owner's ID
 * @param hasTags - Whether photo has attached tag links
 * @param accessKey - Access key for the photo
 * @param height - Original photo height
 * @param images
 * @param lat - Latitude
 * @param long - Longitude
 * @param photo256 - URL of image with 2560 px width
 * @param canComment - Information whether current user can comment the photo
 * @param place
 * @param postId - Post ID
 * @param sizes
 * @param squareCrop
 * @param text - Photo caption
 * @param userId - ID of the user who have uploaded the photo
 * @param width - Original photo width
 * @param likes
 * @param comments
 * @param reposts
 * @param tags
 * @param hidden - Returns if the photo is hidden above the wall
 * @param realOffset - Real position of the photo
 * @param verticalAlign - Sets vertical alignment of a photo
 */
data class PhotosPhotoDto(
    @SerializedName("album_id")
    val albumId: Int,
    @SerializedName("date")
    val date: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("has_tags")
    val hasTags: Boolean,
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("images")
    val images: List<PhotosImageDto>? = null,
    @SerializedName("lat")
    val lat: Float? = null,
    @SerializedName("long")
    val long: Float? = null,
    @SerializedName("photo_256")
    val photo256: String? = null,
    @SerializedName("can_comment")
    val canComment: BaseBoolIntDto? = null,
    @SerializedName("place")
    val place: String? = null,
    @SerializedName("post_id")
    val postId: Int? = null,
    @SerializedName("sizes")
    val sizes: List<PhotosPhotoSizesDto>? = null,
    @SerializedName("square_crop")
    val squareCrop: String? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("user_id")
    val userId: UserId? = null,
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("likes")
    val likes: BaseLikesDto? = null,
    @SerializedName("comments")
    val comments: BaseObjectCountDto? = null,
    @SerializedName("reposts")
    val reposts: BaseRepostsInfoDto? = null,
    @SerializedName("tags")
    val tags: BaseObjectCountDto? = null,
    @SerializedName("hidden")
    val hidden: BasePropertyExistsDto? = null,
    @SerializedName("real_offset")
    val realOffset: Int? = null,
    @SerializedName("vertical_align")
    val verticalAlign: PhotosPhotoDto.VerticalAlignDto? = null
) {
    enum class VerticalAlignDto(
        val value: String
    ) {
        @SerializedName("top")
        TOP("top"),

        @SerializedName("middle")
        MIDDLE("middle"),

        @SerializedName("bottom")
        BOTTOM("bottom");
    }
}
