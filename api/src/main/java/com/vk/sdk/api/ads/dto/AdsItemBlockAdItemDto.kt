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
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseLinkButtonActionDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedItemWallpostFeedbackDto
import com.vk.sdk.api.video.dto.VideoVideoFullDto
import com.vk.sdk.api.wall.dto.WallWallpostFullDto
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param type - type
 * @param adData - Encrypted ad data for tracking and registering events
 * @param adDataImpression - Encrypted ad data for tracking and registering events
 * @param ageRestriction - Age restriction label
 * @param disclaimer - Disclaimer text
 * @param disclaimerImg
 * @param genre - App genre label
 * @param cards - Array of cards
 * @param timeToLive - Ad block TTL
 * @param photoIcon - Array of different sizes for icon image
 * @param video - Ad video
 * @param html5App
 * @param action
 * @param post - Ad post
 * @param skad
 * @param shortTextRate - Preview length control parameter
 * @param isDescriptionClickable
 * @param headerCatchUpLink
 * @param statistics - Array of statistics pixels (banner level)
 * @param feedback
 * @param title - Title
 * @param description - Description / main text or subtitle
 * @param photoMain - Array of different sizes for main image
 * @param followers - App followers label
 * @param rating - App rating label
 * @param domain - Site domain label
 * @param siteDescription - Site description / label
 * @param button - CTA button text
 * @param buttonOpen - Alternative app CTA button text if promoted app is already installed
 * @param linkUrl - Main link url
 * @param linkUrlTarget - Link url target
 * @param linkType - Link action type
 * @param groupId - Group to join in case of join_group_and_open_url link_type
 * @param userId - User to join in case of user_subscribe_and_open_url link_type
 * @param links - Links for click on different parts of banner
 * @param androidApp - Promoted Android app
 * @param iosApp - Promoted iOS app
 * @param wphoneApp - Promoted WPhone app
 */
data class AdsItemBlockAdItemDto(
    @SerializedName("type")
    val type: AdsItemBlockAdItemDto.TypeDto,
    @SerializedName("ad_data")
    val adData: String,
    @SerializedName("ad_data_impression")
    val adDataImpression: String,
    @SerializedName("age_restriction")
    val ageRestriction: String? = null,
    @SerializedName("disclaimer")
    val disclaimer: String? = null,
    @SerializedName("disclaimer_img")
    val disclaimerImg: AdsItemBlockDisclaimerImgDto? = null,
    @SerializedName("genre")
    val genre: String? = null,
    @SerializedName("cards")
    val cards: List<AdsItemBlockAdCardDto>? = null,
    @SerializedName("time_to_live")
    val timeToLive: Int? = null,
    @SerializedName("photo_icon")
    val photoIcon: List<AdsItemBlockAdPhotoBaseDto>? = null,
    @SerializedName("video")
    val video: VideoVideoFullDto? = null,
    @SerializedName("html5_app")
    val html5App: AdsHtml5GameDto? = null,
    @SerializedName("action")
    val action: BaseLinkButtonActionDto? = null,
    @SerializedName("post")
    val post: WallWallpostFullDto? = null,
    @SerializedName("skad")
    val skad: AdsSkadDto? = null,
    @SerializedName("short_text_rate")
    val shortTextRate: Float? = null,
    @SerializedName("is_description_clickable")
    val isDescriptionClickable: Boolean? = null,
    @SerializedName("header_catch_up_link")
    val headerCatchUpLink: AdsCatchUpLinkDto? = null,
    @SerializedName("statistics")
    val statistics: List<AdsItemBlockAdStatPixelDto>? = null,
    @SerializedName("feedback")
    val feedback: NewsfeedItemWallpostFeedbackDto? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("photo_main")
    val photoMain: List<AdsItemBlockAdPhotoMainDto>? = null,
    @SerializedName("followers")
    val followers: String? = null,
    @SerializedName("rating")
    val rating: Float? = null,
    @SerializedName("domain")
    val domain: String? = null,
    @SerializedName("site_description")
    val siteDescription: String? = null,
    @SerializedName("button")
    val button: String? = null,
    @SerializedName("button_open")
    val buttonOpen: String? = null,
    @SerializedName("link_url")
    val linkUrl: String? = null,
    @SerializedName("link_url_target")
    val linkUrlTarget: AdsItemBlockAdItemDto.LinkUrlTargetDto? = null,
    @SerializedName("link_type")
    val linkType: AdsItemBlockAdItemDto.LinkTypeDto? = null,
    @SerializedName("group_id")
    val groupId: UserId? = null,
    @SerializedName("user_id")
    val userId: UserId? = null,
    @SerializedName("links")
    val links: AdsItemBlockAdBannerBaseLinksDto? = null,
    @SerializedName("android_app")
    val androidApp: AdsItemBlockAdAppDto? = null,
    @SerializedName("ios_app")
    val iosApp: AdsItemBlockAdAppIosDto? = null,
    @SerializedName("wphone_app")
    val wphoneApp: AdsItemBlockAdAppDto? = null
) {
    enum class TypeDto(
        val value: String
    ) {
        @SerializedName("post")
        POST("post"),

        @SerializedName("app")
        APP("app"),

        @SerializedName("site")
        SITE("site"),

        @SerializedName("site_slider")
        SITE_SLIDER("site_slider"),

        @SerializedName("site_video")
        SITE_VIDEO("site_video"),

        @SerializedName("app_slider")
        APP_SLIDER("app_slider"),

        @SerializedName("app_video")
        APP_VIDEO("app_video"),

        @SerializedName("html5_ad")
        HTML5_AD("html5_ad");
    }

    enum class LinkUrlTargetDto(
        val value: String
    ) {
        @SerializedName("internal")
        INTERNAL("internal"),

        @SerializedName("external")
        EXTERNAL("external"),

        @SerializedName("internal_hidden")
        INTERNAL_HIDDEN("internal_hidden");
    }

    enum class LinkTypeDto(
        val value: String
    ) {
        @SerializedName("open_url")
        OPEN_URL("open_url"),

        @SerializedName("join_group_and_open_url")
        JOIN_GROUP_AND_OPEN_URL("join_group_and_open_url"),

        @SerializedName("user_subscribe_and_open_url")
        USER_SUBSCRIBE_AND_OPEN_URL("user_subscribe_and_open_url");
    }
}
