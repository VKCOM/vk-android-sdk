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
package com.vk.sdk.api.account.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param wishlistsAePromoBannerShow no description
 * @param twoFaRequired Two factor authentication is enabled
 * @param country Country code
 * @param httpsRequired Information whether HTTPS-only is enabled
 * @param intro Information whether user has been processed intro
 * @param showVkAppsIntro no description
 * @param miniAppsAdsSlotId Ads slot id for MyTarget
 * @param qrPromotion no description
 * @param linkRedirects no description
 * @param lang Language ID
 * @param noWallReplies Information whether wall comments should be hidden
 * @param ownPostsDefault Information whether only owners posts should be shown
 * @param subscriptions no description
 */
data class AccountInfo(
    @SerializedName(value="wishlists_ae_promo_banner_show")
    val wishlistsAePromoBannerShow: BaseBoolInt? = null,
    @SerializedName(value="2fa_required")
    val twoFaRequired: BaseBoolInt? = null,
    @SerializedName(value="country")
    val country: String? = null,
    @SerializedName(value="https_required")
    val httpsRequired: BaseBoolInt? = null,
    @SerializedName(value="intro")
    val intro: BaseBoolInt? = null,
    @SerializedName(value="show_vk_apps_intro")
    val showVkAppsIntro: Boolean? = null,
    @SerializedName(value="mini_apps_ads_slot_id")
    val miniAppsAdsSlotId: Int? = null,
    @SerializedName(value="qr_promotion")
    val qrPromotion: Int? = null,
    @SerializedName(value="link_redirects")
    val linkRedirects: Any? = null,
    @SerializedName(value="lang")
    val lang: Int? = null,
    @SerializedName(value="no_wall_replies")
    val noWallReplies: BaseBoolInt? = null,
    @SerializedName(value="own_posts_default")
    val ownPostsDefault: BaseBoolInt? = null,
    @SerializedName(value="subscriptions")
    val subscriptions: List<Int>? = null
)
