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
package com.vk.sdk.api.stories.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.photos.dto.PhotosPhoto
import com.vk.sdk.api.video.dto.VideoVideo
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * @param id - Story ID.
 * @param ownerId - Story owner's ID.
 * @param accessKey - Access key for private object.
 * @param canComment - Information whether current user can comment the story (0 - no, 1 - yes).
 * @param canReply - Information whether current user can reply to the story (0 - no, 1 - yes).
 * @param canSee - Information whether current user can see the story (0 - no, 1 - yes).
 * @param canLike - Information whether current user can like the story.
 * @param canShare - Information whether current user can share the story (0 - no, 1 - yes).
 * @param canHide - Information whether current user can hide the story (0 - no, 1 - yes).
 * @param date - Date when story has been added in Unixtime.
 * @param expiresAt - Story expiration time. Unixtime.
 * @param isDeleted - Information whether the story is deleted (false - no, true - yes).
 * @param isExpired - Information whether the story is expired (false - no, true - yes).
 * @param link
 * @param parentStory
 * @param parentStoryAccessKey - Access key for private object.
 * @param parentStoryId - Parent story ID.
 * @param parentStoryOwnerId - Parent story owner's ID.
 * @param photo
 * @param replies - Replies counters to current story.
 * @param seen - Information whether current user has seen the story or not (0 - no, 1 - yes).
 * @param type
 * @param clickableStickers
 * @param video
 * @param views - Views number.
 * @param canAsk - Information whether story has question sticker and current user can send question
 * to the author
 * @param canAskAnonymous - Information whether story has question sticker and current user can send
 * anonymous question to the author
 * @param narrativesCount
 * @param firstNarrativeTitle
 * @param birthdayWishUserId
 * @param canUseInNarrative
 */
data class StoriesStory(
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("can_comment")
    val canComment: BaseBoolInt? = null,
    @SerializedName("can_reply")
    val canReply: BaseBoolInt? = null,
    @SerializedName("can_see")
    val canSee: BaseBoolInt? = null,
    @SerializedName("can_like")
    val canLike: Boolean? = null,
    @SerializedName("can_share")
    val canShare: BaseBoolInt? = null,
    @SerializedName("can_hide")
    val canHide: BaseBoolInt? = null,
    @SerializedName("date")
    val date: Int? = null,
    @SerializedName("expires_at")
    val expiresAt: Int? = null,
    @SerializedName("is_deleted")
    val isDeleted: Boolean? = null,
    @SerializedName("is_expired")
    val isExpired: Boolean? = null,
    @SerializedName("link")
    val link: StoriesStoryLink? = null,
    @SerializedName("parent_story")
    val parentStory: StoriesStory? = null,
    @SerializedName("parent_story_access_key")
    val parentStoryAccessKey: String? = null,
    @SerializedName("parent_story_id")
    val parentStoryId: Int? = null,
    @SerializedName("parent_story_owner_id")
    val parentStoryOwnerId: Int? = null,
    @SerializedName("photo")
    val photo: PhotosPhoto? = null,
    @SerializedName("replies")
    val replies: StoriesReplies? = null,
    @SerializedName("seen")
    val seen: BaseBoolInt? = null,
    @SerializedName("type")
    val type: StoriesStoryType? = null,
    @SerializedName("clickable_stickers")
    val clickableStickers: StoriesClickableStickers? = null,
    @SerializedName("video")
    val video: VideoVideo? = null,
    @SerializedName("views")
    val views: Int? = null,
    @SerializedName("can_ask")
    val canAsk: BaseBoolInt? = null,
    @SerializedName("can_ask_anonymous")
    val canAskAnonymous: BaseBoolInt? = null,
    @SerializedName("narratives_count")
    val narrativesCount: Int? = null,
    @SerializedName("first_narrative_title")
    val firstNarrativeTitle: String? = null,
    @SerializedName("birthday_wish_user_id")
    val birthdayWishUserId: Int? = null,
    @SerializedName("can_use_in_narrative")
    val canUseInNarrative: Boolean? = null
)
