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
package com.vk.sdk.api.base.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.link.dto.LinkTargetObjectDto
import com.vk.sdk.api.photos.dto.PhotosPhotoDto
import com.vk.sdk.api.video.dto.VideoVideoFullDto
import kotlin.Boolean
import kotlin.String

/**
 * @param url - Link URL
 * @param text
 * @param product
 * @param application
 * @param button
 * @param caption - Link caption
 * @param description - Link description
 * @param id - Link ID
 * @param isFavorite
 * @param photo
 * @param previewPage - String ID of the page with article preview
 * @param previewUrl - URL of the page with article preview
 * @param rating
 * @param title - Link title
 * @param targetObject
 * @param isExternal - Information whether the current link is external
 * @param video - Video from link
 */
data class BaseLinkDto(
    @SerializedName("url")
    val url: String,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("product")
    val product: BaseLinkProductDto? = null,
    @SerializedName("application")
    val application: BaseLinkApplicationDto? = null,
    @SerializedName("button")
    val button: BaseLinkButtonDto? = null,
    @SerializedName("caption")
    val caption: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName("photo")
    val photo: PhotosPhotoDto? = null,
    @SerializedName("preview_page")
    val previewPage: String? = null,
    @SerializedName("preview_url")
    val previewUrl: String? = null,
    @SerializedName("rating")
    val rating: BaseLinkRatingDto? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("target_object")
    val targetObject: LinkTargetObjectDto? = null,
    @SerializedName("is_external")
    val isExternal: Boolean? = null,
    @SerializedName("video")
    val video: VideoVideoFullDto? = null
)
