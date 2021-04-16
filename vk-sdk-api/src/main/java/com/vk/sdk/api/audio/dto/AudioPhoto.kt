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
package com.vk.sdk.api.audio.dto

import com.google.gson.annotations.SerializedName
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param width - Photo width
 * @param height - Photo height
 * @param id
 * @param photo34 - Photo size 34
 * @param photo68 - Photo size 68
 * @param photo135 - Photo size 135
 * @param photo270 - Photo size 270
 * @param photo300 - Photo size 300
 * @param photo600 - Photo size 600
 * @param photo1200 - Photo size 1200
 * @param sizes - Photo sizes
 */
data class AudioPhoto(
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("photo_34")
    val photo34: String? = null,
    @SerializedName("photo_68")
    val photo68: String? = null,
    @SerializedName("photo_135")
    val photo135: String? = null,
    @SerializedName("photo_270")
    val photo270: String? = null,
    @SerializedName("photo_300")
    val photo300: String? = null,
    @SerializedName("photo_600")
    val photo600: String? = null,
    @SerializedName("photo_1200")
    val photo1200: String? = null,
    @SerializedName("sizes")
    val sizes: List<AudioPhotoSizes>? = null
)
