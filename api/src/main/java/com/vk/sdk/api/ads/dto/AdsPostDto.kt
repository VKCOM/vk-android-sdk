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
package com.vk.sdk.api.ads.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.wall.dto.WallWallpostAttachmentDto
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id - Post id
 * @param fromId - From id
 * @param ownerId - Owner id
 * @param date - Date
 * @param edited - Edited date
 * @param isPinned - Is pinned
 * @param markedAsAds - Marked as ads
 * @param adsEasyPromote
 * @param donut
 * @param comments
 * @param shortTextRate - Short text rate
 * @param type - Type
 * @param isFavorite - Is favorite
 * @param likes
 * @param views
 * @param reactions
 * @param reactionSetId - Reaction set id
 * @param postType - Post type
 * @param reposts
 * @param text - Text
 * @param isPromotedPostStealth - Is promoted post stealth
 * @param hash - Hash
 * @param owner
 * @param attachments
 * @param createdBy - Created by
 * @param carouselOffset - Carousel offset
 * @param canEdit - Can edit
 * @param canDelete - Can delete
 * @param canPin - Can pin
 */
data class AdsPostDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("from_id")
    val fromId: Int? = null,
    @SerializedName("owner_id")
    val ownerId: UserId? = null,
    @SerializedName("date")
    val date: Int? = null,
    @SerializedName("edited")
    val edited: Int? = null,
    @SerializedName("is_pinned")
    val isPinned: Int? = null,
    @SerializedName("marked_as_ads")
    val markedAsAds: Int? = null,
    @SerializedName("ads_easy_promote")
    val adsEasyPromote: AdsPostEasyPromoteDto? = null,
    @SerializedName("donut")
    val donut: AdsPostDonutDto? = null,
    @SerializedName("comments")
    val comments: AdsPostCommentsDto? = null,
    @SerializedName("short_text_rate")
    val shortTextRate: Float? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName("likes")
    val likes: AdsPostLikesDto? = null,
    @SerializedName("views")
    val views: AdsPostViewsDto? = null,
    @SerializedName("reactions")
    val reactions: AdsPostReactionsDto? = null,
    @SerializedName("reaction_set_id")
    val reactionSetId: String? = null,
    @SerializedName("post_type")
    val postType: String? = null,
    @SerializedName("reposts")
    val reposts: AdsPostRepostsDto? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("is_promoted_post_stealth")
    val isPromotedPostStealth: Boolean? = null,
    @SerializedName("hash")
    val hash: String? = null,
    @SerializedName("owner")
    val owner: AdsPostOwnerDto? = null,
    @SerializedName("attachments")
    val attachments: List<WallWallpostAttachmentDto>? = null,
    @SerializedName("created_by")
    val createdBy: Int? = null,
    @SerializedName("carousel_offset")
    val carouselOffset: Int? = null,
    @SerializedName("can_edit")
    val canEdit: Int? = null,
    @SerializedName("can_delete")
    val canDelete: Int? = null,
    @SerializedName("can_pin")
    val canPin: Int? = null
)
