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
package com.vk.sdk.api.ads.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseImageDto
import com.vk.sdk.api.base.dto.BaseLinkButtonActionDto
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param action - Button action
 * @param icon - Block icon in different sizes
 * @param title - Block title
 * @param ttl - Block TTL in seconds
 * @param allowHide - Allow user hide block manually
 * @param backgroundColor - Block background color in RGB HEX (without leading #)
 * @param description - Block description
 * @param trackCode
 */
data class AdsCatchUpLinkDto(
    @SerializedName("action")
    val action: BaseLinkButtonActionDto,
    @SerializedName("icon")
    val icon: List<BaseImageDto>,
    @SerializedName("title")
    val title: String,
    @SerializedName("ttl")
    val ttl: Int,
    @SerializedName("allow_hide")
    val allowHide: Boolean? = null,
    @SerializedName("background_color")
    val backgroundColor: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("track_code")
    val trackCode: String? = null
)
