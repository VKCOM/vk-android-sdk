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
package com.vk.sdk.api.gifts.dto

import com.google.gson.annotations.SerializedName
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * @param id - Gift ID
 * @param thumb512 - URL of the preview image with 512 px in width
 * @param thumb256 - URL of the preview image with 256 px in width
 * @param thumb48 - URL of the preview image with 48 px in width
 * @param thumb96 - URL of the preview image with 96 px in width
 * @param stickersProductId - ID of the sticker pack, if the gift is representing one
 * @param isStickersStyle - Information whether gift represents a stickers style
 * @param buildId - ID of the build of constructor gift
 * @param keywords - Keywords used for search
 */
data class GiftsLayout(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("thumb_512")
    val thumb512: String? = null,
    @SerializedName("thumb_256")
    val thumb256: String? = null,
    @SerializedName("thumb_48")
    val thumb48: String? = null,
    @SerializedName("thumb_96")
    val thumb96: String? = null,
    @SerializedName("stickers_product_id")
    val stickersProductId: Int? = null,
    @SerializedName("is_stickers_style")
    val isStickersStyle: Boolean? = null,
    @SerializedName("build_id")
    val buildId: String? = null,
    @SerializedName("keywords")
    val keywords: String? = null
)
