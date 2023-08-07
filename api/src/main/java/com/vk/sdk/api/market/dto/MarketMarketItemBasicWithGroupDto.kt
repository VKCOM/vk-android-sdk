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
 * @param id - Item ID
 * @param ownerId - Item owner's ID
 * @param title - Item title
 * @param price
 * @param isGroupVerified
 * @param groupName
 * @param groupLink
 * @param isOwner
 * @param isAdult
 * @param thumbPhoto - URL of the preview image
 * @param isFavorite
 */
data class MarketMarketItemBasicWithGroupDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: MarketPriceDto,
    @SerializedName("is_group_verified")
    val isGroupVerified: Boolean? = null,
    @SerializedName("group_name")
    val groupName: String? = null,
    @SerializedName("group_link")
    val groupLink: String? = null,
    @SerializedName("is_owner")
    val isOwner: Boolean? = null,
    @SerializedName("is_adult")
    val isAdult: Boolean? = null,
    @SerializedName("thumb_photo")
    val thumbPhoto: String? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null
)
