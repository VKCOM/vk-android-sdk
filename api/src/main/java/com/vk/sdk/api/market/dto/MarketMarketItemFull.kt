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
package com.vk.sdk.api.market.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseLikes
import com.vk.sdk.api.base.dto.BaseLink
import com.vk.sdk.api.base.dto.BaseRepostsInfo
import com.vk.sdk.api.photos.dto.PhotosPhoto
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param albumsIds
 * @param photos
 * @param canComment - Information whether current use can comment the item
 * @param canRepost - Information whether current use can repost the item
 * @param likes
 * @param reposts
 * @param viewsCount - Views number
 * @param wishlistItemId - Object identifier in wishlist of viewer
 * @param cancelInfo - Information for cancel and revert order
 * @param userAgreementInfo - User agreement info
 * @param accessKey - Access key for the market item
 * @param availability
 * @param buttonTitle - Title for button for url
 * @param category
 * @param date - Date when the item has been created in Unixtime
 * @param description - Item description
 * @param externalId
 * @param id - Item ID
 * @param isFavorite
 * @param ownerId - Item owner's ID
 * @param price
 * @param thumbPhoto - URL of the preview image
 * @param title - Item title
 * @param url - URL to item
 * @param variantsGroupingId
 * @param isMainVariant
 * @param sku
 */
data class MarketMarketItemFull(
    @SerializedName("albums_ids")
    val albumsIds: List<Int>? = null,
    @SerializedName("photos")
    val photos: List<PhotosPhoto>? = null,
    @SerializedName("can_comment")
    val canComment: BaseBoolInt? = null,
    @SerializedName("can_repost")
    val canRepost: BaseBoolInt? = null,
    @SerializedName("likes")
    val likes: BaseLikes? = null,
    @SerializedName("reposts")
    val reposts: BaseRepostsInfo? = null,
    @SerializedName("views_count")
    val viewsCount: Int? = null,
    @SerializedName("wishlist_item_id")
    val wishlistItemId: Int? = null,
    @SerializedName("cancel_info")
    val cancelInfo: BaseLink? = null,
    @SerializedName("user_agreement_info")
    val userAgreementInfo: String? = null,
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("availability")
    val availability: MarketMarketItemAvailability? = null,
    @SerializedName("button_title")
    val buttonTitle: String? = null,
    @SerializedName("category")
    val category: MarketMarketCategory? = null,
    @SerializedName("date")
    val date: Int? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("external_id")
    val externalId: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName("owner_id")
    val ownerId: UserId? = null,
    @SerializedName("price")
    val price: MarketPrice? = null,
    @SerializedName("thumb_photo")
    val thumbPhoto: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("variants_grouping_id")
    val variantsGroupingId: Int? = null,
    @SerializedName("is_main_variant")
    val isMainVariant: Boolean? = null,
    @SerializedName("sku")
    val sku: String? = null
)
