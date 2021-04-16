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
package com.vk.sdk.api.fave.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseLink
import com.vk.sdk.api.market.dto.MarketMarketItem
import com.vk.sdk.api.video.dto.VideoVideo
import com.vk.sdk.api.wall.dto.WallWallpostFull
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List

/**
 * @param addedDate - Timestamp, when this item was bookmarked
 * @param seen - Has user seen this item
 * @param tags
 * @param type - Item type
 * @param link
 * @param post
 * @param product
 * @param video
 */
data class FaveBookmark(
    @SerializedName("added_date")
    val addedDate: Int,
    @SerializedName("seen")
    val seen: Boolean,
    @SerializedName("tags")
    val tags: List<FaveTag>,
    @SerializedName("type")
    val type: FaveBookmarkType,
    @SerializedName("link")
    val link: BaseLink? = null,
    @SerializedName("post")
    val post: WallWallpostFull? = null,
    @SerializedName("product")
    val product: MarketMarketItem? = null,
    @SerializedName("video")
    val video: VideoVideo? = null
)
