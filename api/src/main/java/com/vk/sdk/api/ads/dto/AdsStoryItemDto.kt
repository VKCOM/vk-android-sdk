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
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * @param id - Story id
 * @param ownerId - Owner id
 * @param rawId - Story raw id
 * @param date - Date
 * @param time - Time
 * @param type - Type
 * @param unread - Is unread
 * @param canLike - Can like
 * @param canComment - Can comment
 * @param canShare - Can share
 * @param canRemove - Can remove
 * @param canManage - Can manage
 * @param canAsk - Can ask
 * @param canAskAnonymous - Can ask anonymous
 * @param reactionSetId - Reaction set id
 * @param isProfileQuestion - Is profile question
 * @param stats
 * @param link
 * @param photoUrl - Photo url
 * @param previewUrl - Preview url
 * @param trackCode - Track code
 * @param isPartOfNarrative - Is part of narrative
 * @param isAds - Is ads
 * @param videoUrl - Video url
 * @param firstFrame - First frame
 * @param smallPreview - Small preview
 * @param isLiked - Is liked
 * @param likeHash - Like hash
 * @param reportHash - Report hash
 */
data class AdsStoryItemDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("owner_id")
    val ownerId: UserId? = null,
    @SerializedName("raw_id")
    val rawId: String? = null,
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("time")
    val time: Int? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("unread")
    val unread: Boolean? = null,
    @SerializedName("canLike")
    val canLike: Boolean? = null,
    @SerializedName("can_comment")
    val canComment: Boolean? = null,
    @SerializedName("can_share")
    val canShare: Boolean? = null,
    @SerializedName("can_remove")
    val canRemove: Boolean? = null,
    @SerializedName("can_manage")
    val canManage: Boolean? = null,
    @SerializedName("can_ask")
    val canAsk: Boolean? = null,
    @SerializedName("can_ask_anonymous")
    val canAskAnonymous: Boolean? = null,
    @SerializedName("reaction_set_id")
    val reactionSetId: String? = null,
    @SerializedName("isProfileQuestion")
    val isProfileQuestion: Boolean? = null,
    @SerializedName("stats")
    val stats: AdsStoryItemStatsDto? = null,
    @SerializedName("link")
    val link: AdsStoryItemLinkDto? = null,
    @SerializedName("photo_url")
    val photoUrl: String? = null,
    @SerializedName("preview_url")
    val previewUrl: String? = null,
    @SerializedName("track_code")
    val trackCode: String? = null,
    @SerializedName("isPartOfNarrative")
    val isPartOfNarrative: Boolean? = null,
    @SerializedName("isAds")
    val isAds: Boolean? = null,
    @SerializedName("video_url")
    val videoUrl: String? = null,
    @SerializedName("first_frame")
    val firstFrame: String? = null,
    @SerializedName("small_preview")
    val smallPreview: String? = null,
    @SerializedName("isLiked")
    val isLiked: Boolean? = null,
    @SerializedName("likeHash")
    val likeHash: String? = null,
    @SerializedName("report_hash")
    val reportHash: String? = null
)
