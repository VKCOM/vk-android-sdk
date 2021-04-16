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
 * @param wishlistsAePromoBannerShow
 * @param 2faRequired - Two factor authentication is enabled
 * @param country - Country code
 * @param httpsRequired - Information whether HTTPS-only is enabled
 * @param intro - Information whether user has been processed intro
 * @param showVkAppsIntro
 * @param miniAppsAdsSlotId - Ads slot id for MyTarget
 * @param qrPromotion
 * @param linkRedirects
 * @param lang - Language ID
 * @param noWallReplies - Information whether wall comments should be hidden
 * @param ownPostsDefault - Information whether only owners posts should be shown
 * @param subscriptions
 */
data class AccountInfo(
    @SerializedName("wishlists_ae_promo_banner_show")
    val wishlistsAePromoBannerShow: BaseBoolInt? = null,
    @SerializedName("2fa_required")
    val `2faRequired`: BaseBoolInt? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("https_required")
    val httpsRequired: BaseBoolInt? = null,
    @SerializedName("intro")
    val intro: BaseBoolInt? = null,
    @SerializedName("show_vk_apps_intro")
    val showVkAppsIntro: Boolean? = null,
    @SerializedName("mini_apps_ads_slot_id")
    val miniAppsAdsSlotId: Int? = null,
    @SerializedName("qr_promotion")
    val qrPromotion: Int? = null,
    @SerializedName("link_redirects")
    val linkRedirects: Any? = null,
    @SerializedName("lang")
    val lang: Int? = null,
    @SerializedName("no_wall_replies")
    val noWallReplies: BaseBoolInt? = null,
    @SerializedName("own_posts_default")
    val ownPostsDefault: BaseBoolInt? = null,
    @SerializedName("subscriptions")
    val subscriptions: List<Int>? = null
)
