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
package com.vk.sdk.api.wall.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseCommentsInfoDto
import com.vk.sdk.api.base.dto.BaseLikesInfoDto
import com.vk.sdk.api.base.dto.BaseRepostsInfoDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedItemWallpostFeedbackDto
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param copyHistory
 * @param canEdit - Information whether current user can edit the post
 * @param createdBy - Post creator ID (if post still can be edited)
 * @param canDelete - Information whether current user can delete the post
 * @param canPin - Information whether current user can pin the post
 * @param donut
 * @param isPinned - Information whether the post is pinned
 * @param comments
 * @param markedAsAds - Information whether the post is marked as ads
 * @param topicId - Topic ID. Allowed values can be obtained from newsfeed.getPostTopics method
 * @param shortTextRate - Preview length control parameter
 * @param hash - Hash for sharing
 * @param type
 * @param feedback
 * @param toId
 * @param carouselOffset - Index of current carousel element
 * @param accessKey - Access key to private object
 * @param isDeleted
 * @param deletedReason
 * @param deletedDetails
 * @param attachments
 * @param copyright - Information about the source of the post
 * @param date - Date of publishing in Unixtime
 * @param edited - Date of editing in Unixtime
 * @param fromId - Post author ID
 * @param geo
 * @param id - Post ID
 * @param isArchived - Is post archived, only for post owners
 * @param isFavorite - Information whether the post in favorites list
 * @param likes - Count of likes
 * @param ownerId - Wall owner's ID
 * @param postId - If post type 'reply', contains original post ID
 * @param parentsStack - If post type 'reply', contains original parent IDs stack
 * @param postSource
 * @param postType
 * @param reposts
 * @param signerId - Post signer ID
 * @param text - Post text
 * @param views - Count of views
 */
data class WallWallpostFullDto(
    @SerializedName("copy_history")
    val copyHistory: List<WallWallpostFullDto>? = null,
    @SerializedName("can_edit")
    val canEdit: BaseBoolIntDto? = null,
    @SerializedName("created_by")
    val createdBy: UserId? = null,
    @SerializedName("can_delete")
    val canDelete: BaseBoolIntDto? = null,
    @SerializedName("can_pin")
    val canPin: BaseBoolIntDto? = null,
    @SerializedName("donut")
    val donut: WallWallpostDonutDto? = null,
    @SerializedName("is_pinned")
    val isPinned: BaseBoolIntDto? = null,
    @SerializedName("comments")
    val comments: BaseCommentsInfoDto? = null,
    @SerializedName("marked_as_ads")
    val markedAsAds: BaseBoolIntDto? = null,
    @SerializedName("topic_id")
    val topicId: WallWallpostFullDto.TopicIdDto? = null,
    @SerializedName("short_text_rate")
    val shortTextRate: Float? = null,
    @SerializedName("hash")
    val hash: String? = null,
    @SerializedName("type")
    val type: WallPostTypeDto? = null,
    @SerializedName("feedback")
    val feedback: NewsfeedItemWallpostFeedbackDto? = null,
    @SerializedName("to_id")
    val toId: UserId? = null,
    @SerializedName("carousel_offset")
    val carouselOffset: Int? = null,
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("is_deleted")
    val isDeleted: Boolean? = null,
    @SerializedName("deleted_reason")
    val deletedReason: String? = null,
    @SerializedName("deleted_details")
    val deletedDetails: String? = null,
    @SerializedName("attachments")
    val attachments: List<WallWallpostAttachmentDto>? = null,
    @SerializedName("copyright")
    val copyright: WallPostCopyrightDto? = null,
    @SerializedName("date")
    val date: Int? = null,
    @SerializedName("edited")
    val edited: Int? = null,
    @SerializedName("from_id")
    val fromId: UserId? = null,
    @SerializedName("geo")
    val geo: WallGeoDto? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("is_archived")
    val isArchived: Boolean? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName("likes")
    val likes: BaseLikesInfoDto? = null,
    @SerializedName("owner_id")
    val ownerId: UserId? = null,
    @SerializedName("post_id")
    val postId: Int? = null,
    @SerializedName("parents_stack")
    val parentsStack: List<Int>? = null,
    @SerializedName("post_source")
    val postSource: WallPostSourceDto? = null,
    @SerializedName("post_type")
    val postType: WallPostTypeDto? = null,
    @SerializedName("reposts")
    val reposts: BaseRepostsInfoDto? = null,
    @SerializedName("signer_id")
    val signerId: UserId? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("views")
    val views: WallViewsDto? = null
) {
    enum class TopicIdDto(
        val value: Int
    ) {
        @SerializedName("0")
        EMPTY_TOPIC(0),

        @SerializedName("1")
        ART(1),

        @SerializedName("7")
        IT(7),

        @SerializedName("12")
        GAMES(12),

        @SerializedName("16")
        MUSIC(16),

        @SerializedName("19")
        PHOTO(19),

        @SerializedName("21")
        SCIENCE_AND_TECH(21),

        @SerializedName("23")
        SPORT(23),

        @SerializedName("25")
        TRAVEL(25),

        @SerializedName("26")
        TV_AND_CINEMA(26),

        @SerializedName("32")
        HUMOR(32),

        @SerializedName("43")
        FASHION(43);
    }
}
