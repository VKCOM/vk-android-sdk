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
import com.vk.sdk.api.base.dto.BaseLink
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id
 * @param groupId
 * @param userId
 * @param date
 * @param status
 * @param itemsCount
 * @param totalPrice
 * @param displayOrderId
 * @param trackNumber
 * @param trackLink
 * @param comment
 * @param address
 * @param merchantComment
 * @param weight
 * @param previewOrderItems - Several order items for preview
 * @param cancelInfo - Information for cancel and revert order
 */
data class MarketOrder(
    @SerializedName("id")
    val id: Int,
    @SerializedName("group_id")
    val groupId: UserId,
    @SerializedName("user_id")
    val userId: UserId,
    @SerializedName("date")
    val date: Int,
    @SerializedName("status")
    val status: Int,
    @SerializedName("items_count")
    val itemsCount: Int,
    @SerializedName("total_price")
    val totalPrice: MarketPrice,
    @SerializedName("display_order_id")
    val displayOrderId: String? = null,
    @SerializedName("track_number")
    val trackNumber: String? = null,
    @SerializedName("track_link")
    val trackLink: String? = null,
    @SerializedName("comment")
    val comment: String? = null,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("merchant_comment")
    val merchantComment: String? = null,
    @SerializedName("weight")
    val weight: Int? = null,
    @SerializedName("preview_order_items")
    val previewOrderItems: List<MarketOrderItem>? = null,
    @SerializedName("cancel_info")
    val cancelInfo: BaseLink? = null
)
