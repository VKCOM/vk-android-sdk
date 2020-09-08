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
import com.vk.sdk.api.link.dto.LinkTargetObject
import com.vk.sdk.api.photos.dto.PhotosPhoto
import com.vk.sdk.api.video.dto.VideoVideo
import kotlin.Boolean
import kotlin.String

/**
 * @param url Link URL
 * @param application no description
 * @param button no description
 * @param caption Link caption
 * @param description Link description
 * @param id Link ID
 * @param isFavorite no description
 * @param photo no description
 * @param previewPage String ID of the page with article preview
 * @param previewUrl URL of the page with article preview
 * @param product no description
 * @param rating no description
 * @param title Link title
 * @param targetObject no description
 * @param isExternal Information whether the current link is external
 * @param video Video from link
 */
data class BaseLink(
    @SerializedName(value="url")
    val url: String,
    @SerializedName(value="application")
    val application: BaseLinkApplication? = null,
    @SerializedName(value="button")
    val button: BaseLinkButton? = null,
    @SerializedName(value="caption")
    val caption: String? = null,
    @SerializedName(value="description")
    val description: String? = null,
    @SerializedName(value="id")
    val id: String? = null,
    @SerializedName(value="is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName(value="photo")
    val photo: PhotosPhoto? = null,
    @SerializedName(value="preview_page")
    val previewPage: String? = null,
    @SerializedName(value="preview_url")
    val previewUrl: String? = null,
    @SerializedName(value="product")
    val product: BaseLinkProduct? = null,
    @SerializedName(value="rating")
    val rating: BaseLinkRating? = null,
    @SerializedName(value="title")
    val title: String? = null,
    @SerializedName(value="target_object")
    val targetObject: LinkTargetObject? = null,
    @SerializedName(value="is_external")
    val isExternal: Boolean? = null,
    @SerializedName(value="video")
    val video: VideoVideo? = null
)
