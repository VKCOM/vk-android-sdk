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
import kotlin.Float
import kotlin.String
import kotlin.collections.List

/**
 * @param cardId - Card id
 * @param price - Price
 * @param oldPrice - Old price
 * @param statistics - Array of statistics pixels (card level)
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
data class AdsItemBlockAdCardDto(
    @SerializedName("card_id")
    val cardId: String,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("old_price")
    val oldPrice: String? = null,
    @SerializedName("statistics")
    val statistics: List<AdsItemBlockAdStatPixelDto>? = null,
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
    val linkUrlTarget: AdsItemBlockAdCardDto.LinkUrlTargetDto? = null,
    @SerializedName("link_type")
    val linkType: AdsItemBlockAdCardDto.LinkTypeDto? = null,
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
