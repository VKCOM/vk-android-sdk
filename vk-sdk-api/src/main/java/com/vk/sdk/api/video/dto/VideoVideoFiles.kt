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
import kotlin.String

/**
 * @param external - URL of the external player
 * @param mp4240 - URL of the mpeg4 file with 240p quality
 * @param mp4360 - URL of the mpeg4 file with 360p quality
 * @param mp4480 - URL of the mpeg4 file with 480p quality
 * @param mp4720 - URL of the mpeg4 file with 720p quality
 * @param mp41080 - URL of the mpeg4 file with 1080p quality
 * @param mp41440 - URL of the mpeg4 file with 2K quality
 * @param mp42160 - URL of the mpeg4 file with 4K quality
 * @param flv320 - URL of the flv file with 320p quality
 */
data class VideoVideoFiles(
    @SerializedName("external")
    val external: String? = null,
    @SerializedName("mp4_240")
    val mp4240: String? = null,
    @SerializedName("mp4_360")
    val mp4360: String? = null,
    @SerializedName("mp4_480")
    val mp4480: String? = null,
    @SerializedName("mp4_720")
    val mp4720: String? = null,
    @SerializedName("mp4_1080")
    val mp41080: String? = null,
    @SerializedName("mp4_1440")
    val mp41440: String? = null,
    @SerializedName("mp4_2160")
    val mp42160: String? = null,
    @SerializedName("flv_320")
    val flv320: String? = null
)
