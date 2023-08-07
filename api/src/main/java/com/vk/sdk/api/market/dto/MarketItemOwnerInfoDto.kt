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
import com.vk.sdk.api.base.dto.BaseImageDto
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Information about the group where the item is placed
 * @param avatar - Avatar of the group
 * @param name - Name of the group
 * @param category - Category of the item or description of the group
 * @param categoryUrl - Link to the section of the group
 * @param isCorporatedMarket - Is the group is VK corporated market
 * @param marketType - Type of the market group
 */
data class MarketItemOwnerInfoDto(
    @SerializedName("avatar")
    val avatar: List<BaseImageDto>? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("category_url")
    val categoryUrl: String? = null,
    @SerializedName("is_corporated_market")
    val isCorporatedMarket: Boolean? = null,
    @SerializedName("market_type")
    val marketType: MarketOwnerTypeDto? = null
)
