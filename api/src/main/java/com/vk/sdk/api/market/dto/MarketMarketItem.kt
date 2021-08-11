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
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * @param availability
 * @param category
 * @param description - Item description
 * @param id - Item ID
 * @param ownerId - Item owner's ID
 * @param price
 * @param title - Item title
 * @param accessKey - Access key for the market item
 * @param buttonTitle - Title for button for url
 * @param date - Date when the item has been created in Unixtime
 * @param externalId
 * @param isFavorite
 * @param thumbPhoto - URL of the preview image
 * @param url - URL to item
 * @param variantsGroupingId
 * @param isMainVariant
 * @param sku
 */
data class MarketMarketItem(
    @SerializedName("availability")
    val availability: MarketMarketItemAvailability,
    @SerializedName("category")
    val category: MarketMarketCategory,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("price")
    val price: MarketPrice,
    @SerializedName("title")
    val title: String,
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("button_title")
    val buttonTitle: String? = null,
    @SerializedName("date")
    val date: Int? = null,
    @SerializedName("external_id")
    val externalId: String? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName("thumb_photo")
    val thumbPhoto: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("variants_grouping_id")
    val variantsGroupingId: Int? = null,
    @SerializedName("is_main_variant")
    val isMainVariant: Boolean? = null,
    @SerializedName("sku")
    val sku: String? = null
)
