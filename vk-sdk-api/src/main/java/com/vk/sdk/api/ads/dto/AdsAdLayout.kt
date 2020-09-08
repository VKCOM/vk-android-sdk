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
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Int
import kotlin.String

/**
 * @param adFormat Ad format
 * @param campaignId Campaign ID
 * @param costType no description
 * @param description Ad description
 * @param id Ad ID
 * @param imageSrc Image URL
 * @param linkUrl URL of advertised object
 * @param title Ad title
 * @param imageSrc2x URL of the preview image in double size
 * @param linkDomain Domain of advertised object
 * @param previewLink link to preview an ad as it is shown on the website
 * @param video Information whether the ad is a video
 */
data class AdsAdLayout(
    @SerializedName(value="ad_format")
    val adFormat: Int,
    @SerializedName(value="campaign_id")
    val campaignId: Int,
    @SerializedName(value="cost_type")
    val costType: AdsAdCostType,
    @SerializedName(value="description")
    val description: String,
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="image_src")
    val imageSrc: String,
    @SerializedName(value="link_url")
    val linkUrl: String,
    @SerializedName(value="title")
    val title: String,
    @SerializedName(value="image_src_2x")
    val imageSrc2x: String? = null,
    @SerializedName(value="link_domain")
    val linkDomain: String? = null,
    @SerializedName(value="preview_link")
    val previewLink: Int? = null,
    @SerializedName(value="video")
    val video: BaseBoolInt? = null
)
