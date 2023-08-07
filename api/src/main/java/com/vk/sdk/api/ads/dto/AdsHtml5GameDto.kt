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
import kotlin.Boolean
import kotlin.Float
import kotlin.String
import kotlin.collections.List

/**
 * @param trackCode - Stats track code
 * @param launchButtonText - Text on the Play button
 * @param autolaunch - Skip Play button and launch game immediately
 * @param sourceUrl - Webkit application URL
 * @param viewportRatio - Viewport ratio (width / height) of webkit application
 * @param teaserPhoto - Game preview photo in different sizes
 * @param inappActions - Client actions to call from webview
 */
data class AdsHtml5GameDto(
    @SerializedName("track_code")
    val trackCode: String,
    @SerializedName("launch_button_text")
    val launchButtonText: String,
    @SerializedName("autolaunch")
    val autolaunch: Boolean,
    @SerializedName("source_url")
    val sourceUrl: String,
    @SerializedName("viewport_ratio")
    val viewportRatio: Float,
    @SerializedName("teaser_photo")
    val teaserPhoto: List<BaseImageDto>,
    @SerializedName("inapp_actions")
    val inappActions: List<AdsHtml5GameInappActionDto>
)
