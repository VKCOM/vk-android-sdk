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
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param adFormat - Ad format
 * @param campaignId - Campaign ID
 * @param costType
 * @param description - Ad description
 * @param id - Ad ID
 * @param imageSrc - Image URL
 * @param linkUrl - URL of advertised object
 * @param linkType - Type of advertised object
 * @param title - Ad title
 * @param imageSrc2x - URL of the preview image in double size
 * @param linkDomain - Domain of advertised object
 * @param previewLink - link to preview an ad as it is shown on the website
 * @param video - Information whether the ad is a video
 * @param social - Social
 * @param okved - Okved
 * @param ageRestriction - Age restriction
 * @param goalType - Goal type
 * @param linkTitle - Link title
 * @param linkButton - Link button
 * @param repeatVideo - Repeat video
 * @param videoSrc240 - Video source 240p
 * @param videoSrc360 - Video source 360p
 * @param videoSrc480 - Video source 480p
 * @param videoSrc720 - Video source 720p
 * @param videoSrc1080 - Video source 1080p
 * @param videoImageSrc - Video image source
 * @param videoImageSrc2x - Video image source 2x
 * @param videoDuration - Video duration
 * @param iconSrc - Icon source
 * @param iconSrc2x - Icon source 2x
 * @param post
 * @param storiesData
 * @param clipsList
 */
data class AdsAdLayoutDto(
    @SerializedName("ad_format")
    val adFormat: Int,
    @SerializedName("campaign_id")
    val campaignId: Int,
    @SerializedName("cost_type")
    val costType: AdsAdCostTypeDto,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_src")
    val imageSrc: String,
    @SerializedName("link_url")
    val linkUrl: String,
    @SerializedName("link_type")
    val linkType: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("image_src_2x")
    val imageSrc2x: String? = null,
    @SerializedName("link_domain")
    val linkDomain: String? = null,
    @SerializedName("preview_link")
    val previewLink: String? = null,
    @SerializedName("video")
    val video: BaseBoolIntDto? = null,
    @SerializedName("social")
    val social: Boolean? = null,
    @SerializedName("okved")
    val okved: String? = null,
    @SerializedName("age_restriction")
    val ageRestriction: Int? = null,
    @SerializedName("goal_type")
    val goalType: Int? = null,
    @SerializedName("link_title")
    val linkTitle: String? = null,
    @SerializedName("link_button")
    val linkButton: String? = null,
    @SerializedName("repeat_video")
    val repeatVideo: Int? = null,
    @SerializedName("video_src_240")
    val videoSrc240: String? = null,
    @SerializedName("video_src_360")
    val videoSrc360: String? = null,
    @SerializedName("video_src_480")
    val videoSrc480: String? = null,
    @SerializedName("video_src_720")
    val videoSrc720: String? = null,
    @SerializedName("video_src_1080")
    val videoSrc1080: String? = null,
    @SerializedName("video_image_src")
    val videoImageSrc: String? = null,
    @SerializedName("video_image_src_2x")
    val videoImageSrc2x: String? = null,
    @SerializedName("video_duration")
    val videoDuration: Int? = null,
    @SerializedName("icon_src")
    val iconSrc: String? = null,
    @SerializedName("icon_src_2x")
    val iconSrc2x: String? = null,
    @SerializedName("post")
    val post: AdsPostDto? = null,
    @SerializedName("stories_data")
    val storiesData: AdsStoriesDto? = null,
    @SerializedName("clips_list")
    val clipsList: List<AdsClipItemDto>? = null
)
