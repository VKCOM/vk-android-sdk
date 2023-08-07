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
import com.vk.sdk.api.base.dto.BaseImageDto
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param groupId - Group ID
 * @param groupPhoto
 * @param title - Item title
 * @param subtitle - Item subtitle
 * @param url - Community url
 * @param marketItems
 * @param hasNew - Group has new products
 * @param newCount - Count of new products
 * @param isSubscribed - Is user subscribed to group?
 * @param reason - Reason of adding group to portlet
 * @param lastPhotoText - Last photo overlay text
 */
data class MarketGroupsBlockGroupDto(
    @SerializedName("group_id")
    val groupId: UserId,
    @SerializedName("group_photo")
    val groupPhoto: List<BaseImageDto>,
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("market_items")
    val marketItems: List<MarketGroupsBlockMarketItemDto>,
    @SerializedName("has_new")
    val hasNew: Boolean,
    @SerializedName("new_count")
    val newCount: Int,
    @SerializedName("is_subscribed")
    val isSubscribed: Boolean,
    @SerializedName("reason")
    val reason: MarketGroupsBlockGroupDto.ReasonDto,
    @SerializedName("last_photo_text")
    val lastPhotoText: String? = null
) {
    enum class ReasonDto(
        val value: String
    ) {
        @SerializedName("subscription")
        SUBSCRIPTION("subscription"),

        @SerializedName("ml_recommendations")
        ML_RECOMMENDATIONS("ml_recommendations"),

        @SerializedName("similar_recommendations")
        SIMILAR_RECOMMENDATIONS("similar_recommendations");
    }
}
