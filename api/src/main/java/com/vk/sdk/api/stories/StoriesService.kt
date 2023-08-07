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
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.dto.BaseUserGroupFieldsDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.stories.dto.StoriesGetBannedExtendedResponseDto
import com.vk.sdk.api.stories.dto.StoriesGetBannedResponseDto
import com.vk.sdk.api.stories.dto.StoriesGetByIdExtendedResponseDto
import com.vk.sdk.api.stories.dto.StoriesGetPhotoUploadServerResponseDto
import com.vk.sdk.api.stories.dto.StoriesGetStatsV5200ResponseDto
import com.vk.sdk.api.stories.dto.StoriesGetV5113ResponseDto
import com.vk.sdk.api.stories.dto.StoriesGetVideoUploadServerResponseDto
import com.vk.sdk.api.stories.dto.StoriesGetViewersExtendedV5115ResponseDto
import com.vk.sdk.api.stories.dto.StoriesSaveResponseDto
import com.vk.sdk.api.stories.dto.StoriesStoryStatsDto
import com.vk.sdk.api.stories.dto.StoriesUploadResultDto
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class StoriesService {
    /**
     * Allows to hide stories from chosen sources from current user's feed.
     *
     * @param ownersIds - List of sources IDs
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun storiesBanOwner(ownersIds: List<UserId>): VKRequest<BaseOkResponseDto> =
            NewApiRequest("stories.banOwner") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun storiesDelete(
        ownerId: UserId? = null,
        storyId: Int? = null,
        stories: List<String>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("stories.delete") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @param extended - '1' - to return additional fields for users and communities. Default value
     * is 0.
     * @param fields
     * @return [VKRequest] with [StoriesGetV5113ResponseDto]
     */
    fun storiesGet(
        ownerId: UserId? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<StoriesGetV5113ResponseDto> = NewApiRequest("stories.get") {
        GsonHolder.gson.parse<StoriesGetV5113ResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns list of sources hidden from current user's feed.
     *
     * @param extended - '1' - to return additional fields for users and communities. Default value
     * is 0.
     * @param fields - Additional fields to return
     * @return [VKRequest] with [StoriesGetBannedResponseDto]
     */
    fun storiesGetBanned(extended: Boolean? = null, fields: List<BaseUserGroupFieldsDto>? = null):
            VKRequest<StoriesGetBannedResponseDto> = NewApiRequest("stories.getBanned") {
        GsonHolder.gson.parse<StoriesGetBannedResponseDto>(it)
    }
    .apply {
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns list of sources hidden from current user's feed.
     *
     * @param fields - Additional fields to return
     * @return [VKRequest] with [StoriesGetBannedExtendedResponseDto]
     */
    fun storiesGetBannedExtended(fields: List<BaseUserGroupFieldsDto>? = null):
            VKRequest<StoriesGetBannedExtendedResponseDto> = NewApiRequest("stories.getBanned") {
        GsonHolder.gson.parse<StoriesGetBannedExtendedResponseDto>(it)
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
     * @param extended - '1' - to return additional fields for users and communities. Default value
     * is 0.
     * @param fields - Additional fields to return
     * @return [VKRequest] with [StoriesGetByIdExtendedResponseDto]
     */
    fun storiesGetById(
        stories: List<String>,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<StoriesGetByIdExtendedResponseDto> = NewApiRequest("stories.getById") {
        GsonHolder.gson.parse<StoriesGetByIdExtendedResponseDto>(it)
    }
    .apply {
        addParam("stories", stories)
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * @param ownerId
     * @param storyId
     * @return [VKRequest] with [StoriesGetStatsV5200ResponseDto]
     */
    fun storiesGetDetailedStats(ownerId: UserId, storyId: Int):
            VKRequest<StoriesGetStatsV5200ResponseDto> = NewApiRequest("stories.getDetailedStats") {
        GsonHolder.gson.parse<StoriesGetStatsV5200ResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("story_id", storyId, min = 0)
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
     * @return [VKRequest] with [StoriesGetPhotoUploadServerResponseDto]
     */
    fun storiesGetPhotoUploadServer(
        addToNews: Boolean? = null,
        userIds: List<Int>? = null,
        replyToStory: String? = null,
        linkText: String? = null,
        linkUrl: String? = null,
        groupId: UserId? = null,
        clickableStickers: String? = null
    ): VKRequest<StoriesGetPhotoUploadServerResponseDto> =
            NewApiRequest("stories.getPhotoUploadServer") {
        GsonHolder.gson.parse<StoriesGetPhotoUploadServerResponseDto>(it)
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
     * @param extended - '1' - to return additional fields for users and communities. Default value
     * is 0.
     * @param fields - Additional fields to return
     * @return [VKRequest] with [StoriesGetV5113ResponseDto]
     */
    fun storiesGetReplies(
        ownerId: UserId,
        storyId: Int,
        accessKey: String? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<StoriesGetV5113ResponseDto> = NewApiRequest("stories.getReplies") {
        GsonHolder.gson.parse<StoriesGetV5113ResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("story_id", storyId, min = 0)
        accessKey?.let { addParam("access_key", it) }
        extended?.let { addParam("extended", it) }
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
     * @return [VKRequest] with [StoriesStoryStatsDto]
     */
    fun storiesGetStats(ownerId: UserId, storyId: Int): VKRequest<StoriesStoryStatsDto> =
            NewApiRequest("stories.getStats") {
        GsonHolder.gson.parse<StoriesStoryStatsDto>(it)
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
     * @return [VKRequest] with [StoriesGetVideoUploadServerResponseDto]
     */
    fun storiesGetVideoUploadServer(
        addToNews: Boolean? = null,
        userIds: List<Int>? = null,
        replyToStory: String? = null,
        linkText: String? = null,
        linkUrl: String? = null,
        groupId: UserId? = null,
        clickableStickers: String? = null
    ): VKRequest<StoriesGetVideoUploadServerResponseDto> =
            NewApiRequest("stories.getVideoUploadServer") {
        GsonHolder.gson.parse<StoriesGetVideoUploadServerResponseDto>(it)
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
     * @param storyId - Story ID.
     * @param ownerId - Story owner ID.
     * @param count - Maximum number of results.
     * @param offset - Offset needed to return a specific subset of results.
     * @param extended - '1' - to return detailed information about photos
     * @param fields
     * @return [VKRequest] with [StoriesGetViewersExtendedV5115ResponseDto]
     */
    fun storiesGetViewers(
        storyId: Int,
        ownerId: UserId? = null,
        count: Int? = null,
        offset: Int? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<StoriesGetViewersExtendedV5115ResponseDto> = NewApiRequest("stories.getViewers") {
        GsonHolder.gson.parse<StoriesGetViewersExtendedV5115ResponseDto>(it)
    }
    .apply {
        addParam("story_id", storyId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of story viewers.
     *
     * @param storyId - Story ID.
     * @param ownerId - Story owner ID.
     * @param count - Maximum number of results.
     * @param offset - Offset needed to return a specific subset of results.
     * @param fields
     * @return [VKRequest] with [StoriesGetViewersExtendedV5115ResponseDto]
     */
    fun storiesGetViewersExtended(
        storyId: Int,
        ownerId: UserId? = null,
        count: Int? = null,
        offset: Int? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<StoriesGetViewersExtendedV5115ResponseDto> = NewApiRequest("stories.getViewers") {
        GsonHolder.gson.parse<StoriesGetViewersExtendedV5115ResponseDto>(it)
    }
    .apply {
        addParam("story_id", storyId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Hides all replies in the last 24 hours from the user to current user's stories.
     *
     * @param ownerId - ID of the user whose replies should be hidden.
     * @param groupId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun storiesHideAllReplies(ownerId: UserId, groupId: UserId? = null):
            VKRequest<BaseOkResponseDto> = NewApiRequest("stories.hideAllReplies") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun storiesHideReply(ownerId: UserId, storyId: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("stories.hideReply") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("story_id", storyId, min = 0)
    }

    /**
     * @param uploadResults
     * @param uploadResultsJson
     * @param extended
     * @param fields
     * @return [VKRequest] with [StoriesSaveResponseDto]
     */
    fun storiesSave(
        uploadResults: List<String>? = null,
        uploadResultsJson: List<StoriesUploadResultDto>? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<StoriesSaveResponseDto> = NewApiRequest("stories.save") {
        GsonHolder.gson.parse<StoriesSaveResponseDto>(it)
    }
    .apply {
        uploadResults?.let { addParam("upload_results", it) }
        uploadResultsJson?.let { addParam("upload_results_json",
                GsonHolder.gson.toJson(uploadResultsJson)) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * @param q
     * @param placeId
     * @param latitude
     * @param longitude
     * @param radius
     * @param mentionedId
     * @param count
     * @param extended
     * @param fields
     * @return [VKRequest] with [StoriesGetV5113ResponseDto]
     */
    fun storiesSearch(
        q: String? = null,
        placeId: Int? = null,
        latitude: Float? = null,
        longitude: Float? = null,
        radius: Int? = null,
        mentionedId: Int? = null,
        count: Int? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<StoriesGetV5113ResponseDto> = NewApiRequest("stories.search") {
        GsonHolder.gson.parse<StoriesGetV5113ResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it, maxLength = 255) }
        placeId?.let { addParam("place_id", it, min = 0) }
        latitude?.let { addParam("latitude", it) }
        longitude?.let { addParam("longitude", it) }
        radius?.let { addParam("radius", it, min = 0) }
        mentionedId?.let { addParam("mentioned_id", it) }
        count?.let { addParam("count", it, min = 1, max = 1000) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * @param accessKey
     * @param message
     * @param isBroadcast
     * @param isAnonymous
     * @param unseenMarker
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun storiesSendInteraction(
        accessKey: String,
        message: String? = null,
        isBroadcast: Boolean? = null,
        isAnonymous: Boolean? = null,
        unseenMarker: Boolean? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("stories.sendInteraction") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun storiesUnbanOwner(ownersIds: List<UserId>): VKRequest<BaseOkResponseDto> =
            NewApiRequest("stories.unbanOwner") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owners_ids", ownersIds)
    }

    object StoriesDeleteRestrictions {
        const val STORY_ID_MIN: Long = 0
    }

    object StoriesGetDetailedStatsRestrictions {
        const val STORY_ID_MIN: Long = 0
    }

    object StoriesGetPhotoUploadServerRestrictions {
        const val LINK_URL_MAX_LENGTH: Int = 2048

        const val GROUP_ID_MIN: Long = 0
    }

    object StoriesGetRepliesRestrictions {
        const val STORY_ID_MIN: Long = 0
    }

    object StoriesGetStatsRestrictions {
        const val STORY_ID_MIN: Long = 0
    }

    object StoriesGetVideoUploadServerRestrictions {
        const val LINK_URL_MAX_LENGTH: Int = 2048

        const val GROUP_ID_MIN: Long = 0
    }

    object StoriesGetViewersRestrictions {
        const val STORY_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val OFFSET_MIN: Long = 0
    }

    object StoriesGetViewersExtendedRestrictions {
        const val STORY_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val OFFSET_MIN: Long = 0
    }

    object StoriesHideAllRepliesRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object StoriesHideReplyRestrictions {
        const val STORY_ID_MIN: Long = 0
    }

    object StoriesSearchRestrictions {
        const val Q_MAX_LENGTH: Int = 255

        const val PLACE_ID_MIN: Long = 0

        const val RADIUS_MIN: Long = 0

        const val COUNT_MIN: Long = 1

        const val COUNT_MAX: Long = 1000
    }

    object StoriesSendInteractionRestrictions {
        const val MESSAGE_MAX_LENGTH: Int = 1000
    }
}
