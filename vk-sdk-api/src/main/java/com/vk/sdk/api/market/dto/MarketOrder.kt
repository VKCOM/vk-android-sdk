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
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id no description
 * @param groupId no description
 * @param userId no description
 * @param date no description
 * @param status no description
 * @param itemsCount no description
 * @param totalPrice no description
 * @param displayOrderId no description
 * @param trackNumber no description
 * @param trackLink no description
 * @param comment no description
 * @param address no description
 * @param merchantComment no description
 * @param weight no description
 * @param previewOrderItems Several order items for preview
 */
data class MarketOrder(
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="group_id")
    val groupId: Int,
    @SerializedName(value="user_id")
    val userId: Int,
    @SerializedName(value="date")
    val date: Int,
    @SerializedName(value="status")
    val status: Int,
    @SerializedName(value="items_count")
    val itemsCount: Int,
    @SerializedName(value="total_price")
    val totalPrice: MarketPrice,
    @SerializedName(value="display_order_id")
    val displayOrderId: String? = null,
    @SerializedName(value="track_number")
    val trackNumber: String? = null,
    @SerializedName(value="track_link")
    val trackLink: String? = null,
    @SerializedName(value="comment")
    val comment: String? = null,
    @SerializedName(value="address")
    val address: String? = null,
    @SerializedName(value="merchant_comment")
    val merchantComment: String? = null,
    @SerializedName(value="weight")
    val weight: Int? = null,
    @SerializedName(value="preview_order_items")
    val previewOrderItems: List<MarketOrderItem>? = null
)
