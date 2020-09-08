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
package com.vk.sdk.api.media.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseImage
import com.vk.sdk.api.video.dto.VideoRestrictionButton
import kotlin.String
import kotlin.collections.List

/**
 * @param title no description
 * @param text no description
 * @param button no description
 * @param alwaysShown Need show restriction always or not
 * @param blur Need blur current video or not
 * @param canPlay Can play video or not
 * @param canPreview Can preview video or not
 * @param cardIcon no description
 * @param listIcon no description
 */
data class MediaRestriction(
    @SerializedName(value="title")
    val title: String,
    @SerializedName(value="text")
    val text: String? = null,
    @SerializedName(value="button")
    val button: VideoRestrictionButton? = null,
    @SerializedName(value="always_shown")
    val alwaysShown: BaseBoolInt? = null,
    @SerializedName(value="blur")
    val blur: BaseBoolInt? = null,
    @SerializedName(value="can_play")
    val canPlay: BaseBoolInt? = null,
    @SerializedName(value="can_preview")
    val canPreview: BaseBoolInt? = null,
    @SerializedName(value="card_icon")
    val cardIcon: List<BaseImage>? = null,
    @SerializedName(value="list_icon")
    val listIcon: List<BaseImage>? = null
)
