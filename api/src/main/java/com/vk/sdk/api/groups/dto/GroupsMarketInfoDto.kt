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
package com.vk.sdk.api.groups.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.market.dto.MarketCurrencyDto
import com.vk.sdk.api.market.dto.MarketPriceDto
import kotlin.Int
import kotlin.String

/**
 * @param type - Market type
 * @param contactId - Contact person ID
 * @param currency
 * @param currencyText - Currency name
 * @param isShowHeaderItemsLink - Shop header items link is enabled
 * @param enabled - Information whether the market is enabled
 * @param mainAlbumId - Main market album ID
 * @param priceMax - Maximum price
 * @param priceMin - Minimum price
 * @param minOrderPrice
 */
data class GroupsMarketInfoDto(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("contact_id")
    val contactId: Int? = null,
    @SerializedName("currency")
    val currency: MarketCurrencyDto? = null,
    @SerializedName("currency_text")
    val currencyText: String? = null,
    @SerializedName("is_show_header_items_link")
    val isShowHeaderItemsLink: BaseBoolIntDto? = null,
    @SerializedName("enabled")
    val enabled: BaseBoolIntDto? = null,
    @SerializedName("main_album_id")
    val mainAlbumId: Int? = null,
    @SerializedName("price_max")
    val priceMax: String? = null,
    @SerializedName("price_min")
    val priceMin: String? = null,
    @SerializedName("min_order_price")
    val minOrderPrice: MarketPriceDto? = null
)
