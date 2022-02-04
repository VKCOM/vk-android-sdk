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
package com.vk.sdk.api.aliexpress.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseLinkButton
import com.vk.sdk.api.market.dto.MarketPrice
import com.vk.sdk.api.photos.dto.PhotosPhoto
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String

/**
 * @param id - Item id
 * @param title - Item title
 * @param isFavorite - Information whether the current item has been added to bookmarks
 * @param url - Base product url
 * @param detailsButton - Details action
 * @param price - Aliexpress item price
 * @param discountText - Discount text
 * @param deliveryDateText - Delivery details text
 * @param label - Any text label for item
 * @param rating - Item rating
 * @param ordersCount - Item orders count
 * @param actionButton - Button action
 * @param photo
 */
data class AliexpressCarouselItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("is_favorite")
    val isFavorite: Boolean,
    @SerializedName("url")
    val url: String,
    @SerializedName("details_button")
    val detailsButton: BaseLinkButton,
    @SerializedName("price")
    val price: MarketPrice? = null,
    @SerializedName("discount_text")
    val discountText: String? = null,
    @SerializedName("delivery_date_text")
    val deliveryDateText: String? = null,
    @SerializedName("label")
    val label: String? = null,
    @SerializedName("rating")
    val rating: Float? = null,
    @SerializedName("orders_count")
    val ordersCount: Int? = null,
    @SerializedName("action_button")
    val actionButton: BaseLinkButton? = null,
    @SerializedName("photo")
    val photo: PhotosPhoto? = null
)
