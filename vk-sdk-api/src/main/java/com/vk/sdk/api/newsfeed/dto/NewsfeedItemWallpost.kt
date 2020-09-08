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
package com.vk.sdk.api.newsfeed.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseCommentsInfo
import com.vk.sdk.api.base.dto.BaseGeo
import com.vk.sdk.api.base.dto.BaseLikesInfo
import com.vk.sdk.api.base.dto.BaseRepostsInfo
import com.vk.sdk.api.wall.dto.WallPostSource
import com.vk.sdk.api.wall.dto.WallViews
import com.vk.sdk.api.wall.dto.WallWallpost
import com.vk.sdk.api.wall.dto.WallWallpostAttachment
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param activity no description
 * @param attachments no description
 * @param comments no description
 * @param copyHistory no description
 * @param feedback no description
 * @param geo no description
 * @param isFavorite Information whether the post in favorites list
 * @param likes no description
 * @param markedAsAds Information whether the post is marked as ads
 * @param postId Post ID
 * @param postSource no description
 * @param postType no description
 * @param reposts no description
 * @param signerId Post signer ID
 * @param text Post text
 * @param views Count of views
 * @param shortTextRate Preview length control parameter
 * @param carouselOffset Index of current carousel element
 * @param type no description
 * @param sourceId Item source ID
 * @param date Date when item has been added in Unixtime
 */
data class NewsfeedItemWallpost(
    @SerializedName(value="activity")
    val activity: NewsfeedEventActivity? = null,
    @SerializedName(value="attachments")
    val attachments: List<WallWallpostAttachment>? = null,
    @SerializedName(value="comments")
    val comments: BaseCommentsInfo? = null,
    @SerializedName(value="copy_history")
    val copyHistory: List<WallWallpost>? = null,
    @SerializedName(value="feedback")
    val feedback: NewsfeedItemWallpostFeedback? = null,
    @SerializedName(value="geo")
    val geo: BaseGeo? = null,
    @SerializedName(value="is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName(value="likes")
    val likes: BaseLikesInfo? = null,
    @SerializedName(value="marked_as_ads")
    val markedAsAds: BaseBoolInt? = null,
    @SerializedName(value="post_id")
    val postId: Int? = null,
    @SerializedName(value="post_source")
    val postSource: WallPostSource? = null,
    @SerializedName(value="post_type")
    val postType: NewsfeedItemWallpostType? = null,
    @SerializedName(value="reposts")
    val reposts: BaseRepostsInfo? = null,
    @SerializedName(value="signer_id")
    val signerId: Int? = null,
    @SerializedName(value="text")
    val text: String? = null,
    @SerializedName(value="views")
    val views: WallViews? = null,
    @SerializedName(value="short_text_rate")
    val shortTextRate: Float? = null,
    @SerializedName(value="carousel_offset")
    val carouselOffset: Int? = null,
    @SerializedName(value="type")
    val type: NewsfeedNewsfeedItemType? = null,
    @SerializedName(value="source_id")
    val sourceId: Int? = null,
    @SerializedName(value="date")
    val date: Int? = null
)
