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
package com.vk.sdk.api.stories

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.stories.dto.StoriesGetBannedExtendedResponse
import com.vk.sdk.api.stories.dto.StoriesGetBannedResponse
import com.vk.sdk.api.stories.dto.StoriesGetByIdExtendedResponse
import com.vk.sdk.api.stories.dto.StoriesGetPhotoUploadServerResponse
import com.vk.sdk.api.stories.dto.StoriesGetV5113Response
import com.vk.sdk.api.stories.dto.StoriesGetVideoUploadServerResponse
import com.vk.sdk.api.stories.dto.StoriesGetViewersExtendedV5115Response
import com.vk.sdk.api.stories.dto.StoriesSaveResponse
import com.vk.sdk.api.stories.dto.StoriesStoryStats
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class StoriesService {
    /**
     * Allows to hide stories from chosen sources from current user's feed.
     *
     * @param ownersIds - List of sources IDs
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun storiesBanOwner(ownersIds: List<UserId>): VKRequest<BaseOkResponse> =
            NewApiRequest("stories.banOwner") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owners_ids", ownersIds)
    }

    /**
     * Allows to delete story.
     *
     * @param ownerId - Story owner's ID. Current user id is used by default.
     * @param storyId - Story ID.
     * @param stories
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun storiesDelete(
        ownerId: UserId? = null,
        storyId: Int? = null,
        stories: List<String>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("stories.delete") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        storyId?.let { addParam("story_id", it, min = 0) }
        stories?.let { addParam("stories", it) }
    }

    /**
     * Returns stories available for current user.
     *
     * @param ownerId - Owner ID.
     * @param fields
     * @return [VKRequest] with [StoriesGetV5113Response]
     */
    fun storiesGet(ownerId: UserId? = null, fields: List<BaseUserGroupFields>? = null):
            VKRequest<StoriesGetV5113Response> = NewApiRequest("stories.get") {
        GsonHolder.gson.fromJson(it, StoriesGetV5113Response::class.java)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns list of sources hidden from current user's feed.
     *
     * @param fields - Additional fields to return
     * @return [VKRequest] with [StoriesGetBannedResponse]
     */
    fun storiesGetBanned(fields: List<BaseUserGroupFields>? = null):
            VKRequest<StoriesGetBannedResponse> = NewApiRequest("stories.getBanned") {
        GsonHolder.gson.fromJson(it, StoriesGetBannedResponse::class.java)
    }
    .apply {
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns list of sources hidden from current user's feed.
     *
     * @param fields - Additional fields to return
     * @return [VKRequest] with [StoriesGetBannedExtendedResponse]
     */
    fun storiesGetBannedExtended(fields: List<BaseUserGroupFields>? = null):
            VKRequest<StoriesGetBannedExtendedResponse> = NewApiRequest("stories.getBanned") {
        GsonHolder.gson.fromJson(it, StoriesGetBannedExtendedResponse::class.java)
    }
    .apply {
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns story by its ID.
     *
     * @param stories - Stories IDs separated by commas. Use format {owner_id}+'_'+{story_id}, for
     * example, 12345_54331.
     * @param fields - Additional fields to return
     * @return [VKRequest] with [StoriesGetByIdExtendedResponse]
     */
    fun storiesGetById(stories: List<String>, fields: List<BaseUserGroupFields>? = null):
            VKRequest<StoriesGetByIdExtendedResponse> = NewApiRequest("stories.getById") {
        GsonHolder.gson.fromJson(it, StoriesGetByIdExtendedResponse::class.java)
    }
    .apply {
        addParam("stories", stories)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns URL for uploading a story with photo.
     *
     * @param addToNews - 1 - to add the story to friend's feed.
     * @param userIds - List of users IDs who can see the story.
     * @param replyToStory - ID of the story to reply with the current.
     * @param linkText - Link text (for community's stories only).
     * @param linkUrl - Link URL. Internal links on https_//vk.com only.
     * @param groupId - ID of the community to upload the story (should be verified or with the
     * "fire" icon).
     * @param clickableStickers
     * @return [VKRequest] with [StoriesGetPhotoUploadServerResponse]
     */
    fun storiesGetPhotoUploadServer(
        addToNews: Boolean? = null,
        userIds: List<Int>? = null,
        replyToStory: String? = null,
        linkText: String? = null,
        linkUrl: String? = null,
        groupId: UserId? = null,
        clickableStickers: String? = null
    ): VKRequest<StoriesGetPhotoUploadServerResponse> =
            NewApiRequest("stories.getPhotoUploadServer") {
        GsonHolder.gson.fromJson(it, StoriesGetPhotoUploadServerResponse::class.java)
    }
    .apply {
        addToNews?.let { addParam("add_to_news", it) }
        userIds?.let { addParam("user_ids", it) }
        replyToStory?.let { addParam("reply_to_story", it) }
        linkText?.let { addParam("link_text", it) }
        linkUrl?.let { addParam("link_url", it, maxLength = 2048) }
        groupId?.let { addParam("group_id", it, min = 0) }
        clickableStickers?.let { addParam("clickable_stickers", it) }
    }

    /**
     * Returns replies to the story.
     *
     * @param ownerId - Story owner ID.
     * @param storyId - Story ID.
     * @param accessKey - Access key for the private object.
     * @param fields - Additional fields to return
     * @return [VKRequest] with [StoriesGetV5113Response]
     */
    fun storiesGetReplies(
        ownerId: UserId,
        storyId: Int,
        accessKey: String? = null,
        fields: List<BaseUserGroupFields>? = null
    ): VKRequest<StoriesGetV5113Response> = NewApiRequest("stories.getReplies") {
        GsonHolder.gson.fromJson(it, StoriesGetV5113Response::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("story_id", storyId, min = 0)
        accessKey?.let { addParam("access_key", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns stories available for current user.
     *
     * @param ownerId - Story owner ID. 
     * @param storyId - Story ID.
     * @return [VKRequest] with [StoriesStoryStats]
     */
    fun storiesGetStats(ownerId: UserId, storyId: Int): VKRequest<StoriesStoryStats> =
            NewApiRequest("stories.getStats") {
        GsonHolder.gson.fromJson(it, StoriesStoryStats::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("story_id", storyId, min = 0)
    }

    /**
     * Allows to receive URL for uploading story with video.
     *
     * @param addToNews - 1 - to add the story to friend's feed.
     * @param userIds - List of users IDs who can see the story.
     * @param replyToStory - ID of the story to reply with the current.
     * @param linkText - Link text (for community's stories only).
     * @param linkUrl - Link URL. Internal links on https_//vk.com only.
     * @param groupId - ID of the community to upload the story (should be verified or with the
     * "fire" icon).
     * @param clickableStickers
     * @return [VKRequest] with [StoriesGetVideoUploadServerResponse]
     */
    fun storiesGetVideoUploadServer(
        addToNews: Boolean? = null,
        userIds: List<Int>? = null,
        replyToStory: String? = null,
        linkText: String? = null,
        linkUrl: String? = null,
        groupId: UserId? = null,
        clickableStickers: String? = null
    ): VKRequest<StoriesGetVideoUploadServerResponse> =
            NewApiRequest("stories.getVideoUploadServer") {
        GsonHolder.gson.fromJson(it, StoriesGetVideoUploadServerResponse::class.java)
    }
    .apply {
        addToNews?.let { addParam("add_to_news", it) }
        userIds?.let { addParam("user_ids", it) }
        replyToStory?.let { addParam("reply_to_story", it) }
        linkText?.let { addParam("link_text", it) }
        linkUrl?.let { addParam("link_url", it, maxLength = 2048) }
        groupId?.let { addParam("group_id", it, min = 0) }
        clickableStickers?.let { addParam("clickable_stickers", it) }
    }

    /**
     * Returns a list of story viewers.
     *
     * @param ownerId - Story owner ID.
     * @param storyId - Story ID.
     * @param count - Maximum number of results.
     * @param offset - Offset needed to return a specific subset of results.
     * @return [VKRequest] with [StoriesGetViewersExtendedV5115Response]
     */
    fun storiesGetViewers(
        ownerId: UserId,
        storyId: Int,
        count: Int? = null,
        offset: Int? = null
    ): VKRequest<StoriesGetViewersExtendedV5115Response> = NewApiRequest("stories.getViewers") {
        GsonHolder.gson.fromJson(it, StoriesGetViewersExtendedV5115Response::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("story_id", storyId, min = 0)
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
    }

    /**
     * Returns a list of story viewers.
     *
     * @param ownerId - Story owner ID.
     * @param storyId - Story ID.
     * @param count - Maximum number of results.
     * @param offset - Offset needed to return a specific subset of results.
     * @return [VKRequest] with [StoriesGetViewersExtendedV5115Response]
     */
    fun storiesGetViewersExtended(
        ownerId: UserId,
        storyId: Int,
        count: Int? = null,
        offset: Int? = null
    ): VKRequest<StoriesGetViewersExtendedV5115Response> = NewApiRequest("stories.getViewers") {
        GsonHolder.gson.fromJson(it, StoriesGetViewersExtendedV5115Response::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("story_id", storyId, min = 0)
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        addParam("extended", true)
    }

    /**
     * Hides all replies in the last 24 hours from the user to current user's stories.
     *
     * @param ownerId - ID of the user whose replies should be hidden.
     * @param groupId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun storiesHideAllReplies(ownerId: UserId, groupId: UserId? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("stories.hideAllReplies") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Hides the reply to the current user's story.
     *
     * @param ownerId - ID of the user whose replies should be hidden.
     * @param storyId - Story ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun storiesHideReply(ownerId: UserId, storyId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("stories.hideReply") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("story_id", storyId, min = 0)
    }

    /**
     * @param uploadResults
     * @param fields
     * @return [VKRequest] with [StoriesSaveResponse]
     */
    fun storiesSave(uploadResults: List<String>, fields: List<String>? = null):
            VKRequest<StoriesSaveResponse> = NewApiRequest("stories.save") {
        GsonHolder.gson.fromJson(it, StoriesSaveResponse::class.java)
    }
    .apply {
        addParam("upload_results", uploadResults)
        fields?.let { addParam("fields", it) }
    }

    /**
     * @param q
     * @param placeId
     * @param latitude
     * @param longitude
     * @param radius
     * @param mentionedId
     * @param count
     * @param fields
     * @return [VKRequest] with [StoriesGetV5113Response]
     */
    fun storiesSearch(
        q: String? = null,
        placeId: Int? = null,
        latitude: Float? = null,
        longitude: Float? = null,
        radius: Int? = null,
        mentionedId: Int? = null,
        count: Int? = null,
        fields: List<String>? = null
    ): VKRequest<StoriesGetV5113Response> = NewApiRequest("stories.search") {
        GsonHolder.gson.fromJson(it, StoriesGetV5113Response::class.java)
    }
    .apply {
        q?.let { addParam("q", it, maxLength = 255) }
        placeId?.let { addParam("place_id", it, min = 0) }
        latitude?.let { addParam("latitude", it) }
        longitude?.let { addParam("longitude", it) }
        radius?.let { addParam("radius", it, min = 0) }
        mentionedId?.let { addParam("mentioned_id", it) }
        count?.let { addParam("count", it, min = 1, max = 1000) }
        fields?.let { addParam("fields", it) }
    }

    /**
     * @param accessKey
     * @param message
     * @param isBroadcast
     * @param isAnonymous
     * @param unseenMarker
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun storiesSendInteraction(
        accessKey: String,
        message: String? = null,
        isBroadcast: Boolean? = null,
        isAnonymous: Boolean? = null,
        unseenMarker: Boolean? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("stories.sendInteraction") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("access_key", accessKey)
        message?.let { addParam("message", it, maxLength = 1000) }
        isBroadcast?.let { addParam("is_broadcast", it) }
        isAnonymous?.let { addParam("is_anonymous", it) }
        unseenMarker?.let { addParam("unseen_marker", it) }
    }

    /**
     * Allows to show stories from hidden sources in current user's feed.
     *
     * @param ownersIds - List of hidden sources to show stories from.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun storiesUnbanOwner(ownersIds: List<UserId>): VKRequest<BaseOkResponse> =
            NewApiRequest("stories.unbanOwner") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owners_ids", ownersIds)
    }
}
