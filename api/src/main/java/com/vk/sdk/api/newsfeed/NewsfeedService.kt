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
package com.vk.sdk.api.newsfeed

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.dto.BaseUserGroupFieldsDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.newsfeed.dto.NewsfeedCommentsFiltersDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedGenericResponseDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetBannedExtendedResponseDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetBannedResponseDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetCommentsResponseDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetListsExtendedResponseDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetListsResponseDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetMentionsResponseDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetSuggestedSourcesResponseDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedNewsfeedItemTypeDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedSearchResponseDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedUnsubscribeTypeDto
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.users.dto.UsersFieldsDto
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class NewsfeedService {
    /**
     * Prevents news from specified users and communities from appearing in the current user's
     * newsfeed.
     *
     * @param userIds
     * @param groupIds
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun newsfeedAddBan(userIds: List<UserId>? = null, groupIds: List<UserId>? = null):
            VKRequest<BaseBoolIntDto> = NewApiRequest("newsfeed.addBan") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        userIds?.let { addParam("user_ids", it, min = 1) }
        groupIds?.let { addParam("group_ids", it, min = 1) }
    }

    /**
     * Allows news from previously banned users and communities to be shown in the current user's
     * newsfeed.
     *
     * @param userIds
     * @param groupIds
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun newsfeedDeleteBan(userIds: List<UserId>? = null, groupIds: List<UserId>? = null):
            VKRequest<BaseOkResponseDto> = NewApiRequest("newsfeed.deleteBan") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        userIds?.let { addParam("user_ids", it, min = 1) }
        groupIds?.let { addParam("group_ids", it, min = 1) }
    }

    /**
     * @param listId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun newsfeedDeleteList(listId: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("newsfeed.deleteList") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("list_id", listId, min = 0)
    }

    /**
     * Returns data required to show newsfeed for the current user.
     *
     * @param filters - Filters to apply_ 'post' - new wall posts, 'photo' - new photos,
     * 'photo_tag' - new photo tags, 'wall_photo' - new wall photos, 'friend' - new friends
     * @param returnBanned - '1' - to return news items from banned sources
     * @param startTime - Earliest timestamp (in Unix time) of a news item to return. By default, 24
     * hours ago.
     * @param endTime - Latest timestamp (in Unix time) of a news item to return. By default, the
     * current time.
     * @param maxPhotos - Maximum number of photos to return. By default, '5'.
     * @param sourceIds - Sources to obtain news from, separated by commas. User IDs can be
     * specified in formats '' or 'u' , where '' is the user's friend ID. Community IDs can be
     * specified in formats '-' or 'g' , where '' is the community ID. If the parameter is not set, all
     * of the user's friends and communities are returned, except for banned sources, which can be
     * obtained with the [vk.com/dev/newsfeed.getBanned|newsfeed.getBanned] method.
     * @param startFrom - identifier required to get the next page of results. Value for this
     * parameter is returned in 'next_from' field in a reply.
     * @param count - Number of news items to return (default 50, maximum 100). For auto feed, you
     * can use the 'new_offset' parameter returned by this method.
     * @param fields - Additional fields of [vk.com/dev/fields|profiles] and
     * [vk.com/dev/fields_groups|communities] to return.
     * @param section
     * @return [VKRequest] with [NewsfeedGenericResponseDto]
     */
    fun newsfeedGet(
        filters: List<NewsfeedNewsfeedItemTypeDto>? = null,
        returnBanned: Boolean? = null,
        startTime: Int? = null,
        endTime: Int? = null,
        maxPhotos: Int? = null,
        sourceIds: String? = null,
        startFrom: String? = null,
        count: Int? = null,
        fields: List<BaseUserGroupFieldsDto>? = null,
        section: String? = null
    ): VKRequest<NewsfeedGenericResponseDto> = NewApiRequest("newsfeed.get") {
        GsonHolder.gson.parse<NewsfeedGenericResponseDto>(it)
    }
    .apply {
        val filtersJsonConverted = filters?.map {
            it.value
        }
        filtersJsonConverted?.let { addParam("filters", it) }
        returnBanned?.let { addParam("return_banned", it) }
        startTime?.let { addParam("start_time", it, min = 0) }
        endTime?.let { addParam("end_time", it, min = 0) }
        maxPhotos?.let { addParam("max_photos", it, min = 0) }
        sourceIds?.let { addParam("source_ids", it) }
        startFrom?.let { addParam("start_from", it) }
        count?.let { addParam("count", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        section?.let { addParam("section", it) }
    }

    /**
     * Returns a list of users and communities banned from the current user's newsfeed.
     *
     * @param extended - '1' - return extra information about users and communities
     * @param fields - Profile fields to return.
     * @param nameCase - Case for declension of user name and surname_ 'nom' - nominative (default),
     * 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' -
     * prepositional
     * @return [VKRequest] with [NewsfeedGetBannedResponseDto]
     */
    fun newsfeedGetBanned(
        extended: Boolean? = null,
        fields: List<UsersFieldsDto>? = null,
        nameCase: String? = null
    ): VKRequest<NewsfeedGetBannedResponseDto> = NewApiRequest("newsfeed.getBanned") {
        GsonHolder.gson.parse<NewsfeedGetBannedResponseDto>(it)
    }
    .apply {
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it) }
    }

    /**
     * Returns a list of users and communities banned from the current user's newsfeed.
     *
     * @param fields - Profile fields to return.
     * @param nameCase - Case for declension of user name and surname_ 'nom' - nominative (default),
     * 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' -
     * prepositional
     * @return [VKRequest] with [NewsfeedGetBannedExtendedResponseDto]
     */
    fun newsfeedGetBannedExtended(fields: List<UsersFieldsDto>? = null, nameCase: String? = null):
            VKRequest<NewsfeedGetBannedExtendedResponseDto> = NewApiRequest("newsfeed.getBanned") {
        GsonHolder.gson.parse<NewsfeedGetBannedExtendedResponseDto>(it)
    }
    .apply {
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it) }
    }

    /**
     * Returns a list of comments in the current user's newsfeed.
     *
     * @param count - Number of comments to return. For auto feed, you can use the 'new_offset'
     * parameter returned by this method.
     * @param filters - Filters to apply_ 'post' - new comments on wall posts, 'photo' - new
     * comments on photos, 'video' - new comments on videos, 'topic' - new comments on discussions,
     * 'note' - new comments on notes,
     * @param reposts - Object ID, comments on repost of which shall be returned, e.g.
     * 'wall1_45486'. (If the parameter is set, the 'filters' parameter is optional.),
     * @param startTime - Earliest timestamp (in Unix time) of a comment to return. By default, 24
     * hours ago.
     * @param endTime - Latest timestamp (in Unix time) of a comment to return. By default, the
     * current time.
     * @param lastCommentsCount
     * @param startFrom - Identificator needed to return the next page with results. Value for this
     * parameter returns in 'next_from' field.
     * @param fields - Additional fields of [vk.com/dev/fields|profiles] and
     * [vk.com/dev/fields_groups|communities] to return.
     * @return [VKRequest] with [NewsfeedGetCommentsResponseDto]
     */
    fun newsfeedGetComments(
        count: Int? = null,
        filters: List<NewsfeedCommentsFiltersDto>? = null,
        reposts: String? = null,
        startTime: Int? = null,
        endTime: Int? = null,
        lastCommentsCount: Int? = null,
        startFrom: String? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<NewsfeedGetCommentsResponseDto> = NewApiRequest("newsfeed.getComments") {
        GsonHolder.gson.parse<NewsfeedGetCommentsResponseDto>(it)
    }
    .apply {
        count?.let { addParam("count", it, min = 0, max = 100) }
        val filtersJsonConverted = filters?.map {
            it.value
        }
        filtersJsonConverted?.let { addParam("filters", it) }
        reposts?.let { addParam("reposts", it) }
        startTime?.let { addParam("start_time", it, min = 0) }
        endTime?.let { addParam("end_time", it, min = 0) }
        lastCommentsCount?.let { addParam("last_comments_count", it, min = 0, max = 10) }
        startFrom?.let { addParam("start_from", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of newsfeeds followed by the current user.
     *
     * @param listIds - numeric list identifiers.
     * @param extended - Return additional list info
     * @return [VKRequest] with [NewsfeedGetListsResponseDto]
     */
    fun newsfeedGetLists(listIds: List<Int>? = null, extended: Boolean? = null):
            VKRequest<NewsfeedGetListsResponseDto> = NewApiRequest("newsfeed.getLists") {
        GsonHolder.gson.parse<NewsfeedGetListsResponseDto>(it)
    }
    .apply {
        listIds?.let { addParam("list_ids", it) }
        extended?.let { addParam("extended", it) }
    }

    /**
     * Returns a list of newsfeeds followed by the current user.
     *
     * @param listIds - numeric list identifiers.
     * @return [VKRequest] with [NewsfeedGetListsExtendedResponseDto]
     */
    fun newsfeedGetListsExtended(listIds: List<Int>? = null):
            VKRequest<NewsfeedGetListsExtendedResponseDto> = NewApiRequest("newsfeed.getLists") {
        GsonHolder.gson.parse<NewsfeedGetListsExtendedResponseDto>(it)
    }
    .apply {
        listIds?.let { addParam("list_ids", it) }
        addParam("extended", true)
    }

    /**
     * Returns a list of posts on user walls in which the current user is mentioned.
     *
     * @param ownerId - Owner ID.
     * @param startTime - Earliest timestamp (in Unix time) of a post to return. By default, 24
     * hours ago.
     * @param endTime - Latest timestamp (in Unix time) of a post to return. By default, the current
     * time.
     * @param offset - Offset needed to return a specific subset of posts.
     * @param count - Number of posts to return.
     * @return [VKRequest] with [NewsfeedGetMentionsResponseDto]
     */
    fun newsfeedGetMentions(
        ownerId: UserId? = null,
        startTime: Int? = null,
        endTime: Int? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<NewsfeedGetMentionsResponseDto> = NewApiRequest("newsfeed.getMentions") {
        GsonHolder.gson.parse<NewsfeedGetMentionsResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        startTime?.let { addParam("start_time", it, min = 0) }
        endTime?.let { addParam("end_time", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 50) }
    }

    /**
     * , Returns a list of newsfeeds recommended to the current user.
     *
     * @param startTime - Earliest timestamp (in Unix time) of a news item to return. By default, 24
     * hours ago.
     * @param endTime - Latest timestamp (in Unix time) of a news item to return. By default, the
     * current time.
     * @param maxPhotos - Maximum number of photos to return. By default, '5'.
     * @param startFrom - 'new_from' value obtained in previous call.
     * @param count - Number of news items to return.
     * @param fields - Additional fields of [vk.com/dev/fields|profiles] and
     * [vk.com/dev/fields_groups|communities] to return.
     * @return [VKRequest] with [NewsfeedGenericResponseDto]
     */
    fun newsfeedGetRecommended(
        startTime: Int? = null,
        endTime: Int? = null,
        maxPhotos: Int? = null,
        startFrom: String? = null,
        count: Int? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<NewsfeedGenericResponseDto> = NewApiRequest("newsfeed.getRecommended") {
        GsonHolder.gson.parse<NewsfeedGenericResponseDto>(it)
    }
    .apply {
        startTime?.let { addParam("start_time", it, min = 0) }
        endTime?.let { addParam("end_time", it, min = 0) }
        maxPhotos?.let { addParam("max_photos", it, min = 0) }
        startFrom?.let { addParam("start_from", it) }
        count?.let { addParam("count", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns communities and users that current user is suggested to follow.
     *
     * @param offset - offset required to choose a particular subset of communities or users.
     * @param count - amount of communities or users to return.
     * @param shuffle - shuffle the returned list or not.
     * @param fields - list of extra fields to be returned. See available fields for
     * [vk.com/dev/fields|users] and [vk.com/dev/fields_groups|communities].
     * @return [VKRequest] with [NewsfeedGetSuggestedSourcesResponseDto]
     */
    fun newsfeedGetSuggestedSources(
        offset: Int? = null,
        count: Int? = null,
        shuffle: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<NewsfeedGetSuggestedSourcesResponseDto> =
            NewApiRequest("newsfeed.getSuggestedSources") {
        GsonHolder.gson.parse<NewsfeedGetSuggestedSourcesResponseDto>(it)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        shuffle?.let { addParam("shuffle", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Hides an item from the newsfeed.
     *
     * @param type - Item type. Possible values_ *'wall' - post on the wall,, *'tag' - tag on a
     * photo,, *'profilephoto' - profile photo,, *'video' - video,, *'audio' - audio.
     * @param ownerId - Item owner's identifier (user or community), "Note that community id must be
     * negative. 'owner_id=1' - user , 'owner_id=-1' - community "
     * @param itemId - Item identifier
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun newsfeedIgnoreItem(
        type: String,
        ownerId: UserId? = null,
        itemId: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("newsfeed.ignoreItem") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("type", type)
        ownerId?.let { addParam("owner_id", it) }
        itemId?.let { addParam("item_id", it, min = 0) }
    }

    /**
     * Creates and edits user newsfeed lists
     *
     * @param title - list name.
     * @param listId - numeric list identifier (if not sent, will be set automatically).
     * @param sourceIds - users and communities identifiers to be added to the list. Community
     * identifiers must be negative numbers.
     * @param noReposts - reposts display on and off ('1' is for off).
     * @return [VKRequest] with [Int]
     */
    fun newsfeedSaveList(
        title: String,
        listId: Int? = null,
        sourceIds: List<UserId>? = null,
        noReposts: Boolean? = null
    ): VKRequest<Int> = NewApiRequest("newsfeed.saveList") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        addParam("title", title)
        listId?.let { addParam("list_id", it, min = 0) }
        sourceIds?.let { addParam("source_ids", it) }
        noReposts?.let { addParam("no_reposts", it) }
    }

    /**
     * Returns search results by statuses.
     *
     * @param q - Search query string (e.g., 'New Year').
     * @param extended - '1' - to return additional information about the user or community that
     * placed the post.
     * @param count - Number of posts to return.
     * @param latitude - Geographical latitude point (in degrees, -90 to 90) within which to search.
     * @param longitude - Geographical longitude point (in degrees, -180 to 180) within which to
     * search.
     * @param startTime - Earliest timestamp (in Unix time) of a news item to return. By default, 24
     * hours ago.
     * @param endTime - Latest timestamp (in Unix time) of a news item to return. By default, the
     * current time.
     * @param startFrom
     * @param fields - Additional fields of [vk.com/dev/fields|profiles] and
     * [vk.com/dev/fields_groups|communities] to return.
     * @return [VKRequest] with [NewsfeedSearchResponseDto]
     */
    fun newsfeedSearch(
        q: String? = null,
        extended: Boolean? = null,
        count: Int? = null,
        latitude: Float? = null,
        longitude: Float? = null,
        startTime: Int? = null,
        endTime: Int? = null,
        startFrom: String? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<NewsfeedSearchResponseDto> = NewApiRequest("newsfeed.search") {
        GsonHolder.gson.parse<NewsfeedSearchResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it) }
        extended?.let { addParam("extended", it) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        latitude?.let { addParam("latitude", it) }
        longitude?.let { addParam("longitude", it) }
        startTime?.let { addParam("start_time", it, min = 0) }
        endTime?.let { addParam("end_time", it, min = 0) }
        startFrom?.let { addParam("start_from", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a hidden item to the newsfeed.
     *
     * @param type - Item type. Possible values_ *'wall' - post on the wall,, *'tag' - tag on a
     * photo,, *'profilephoto' - profile photo,, *'video' - video,, *'audio' - audio.
     * @param ownerId - Item owner's identifier (user or community), "Note that community id must be
     * negative. 'owner_id=1' - user , 'owner_id=-1' - community "
     * @param itemId - Item identifier
     * @param trackCode - Track code of unignored item
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun newsfeedUnignoreItem(
        type: String,
        ownerId: UserId,
        itemId: Int,
        trackCode: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("newsfeed.unignoreItem") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("type", type)
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
        trackCode?.let { addParam("track_code", it) }
    }

    /**
     * Unsubscribes the current user from specified newsfeeds.
     *
     * @param type - Type of object from which to unsubscribe_ 'note' - note, 'photo' - photo,
     * 'post' - post on user wall or community wall, 'topic' - topic, 'video' - video
     * @param itemId - Object ID.
     * @param ownerId - Object owner ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun newsfeedUnsubscribe(
        type: NewsfeedUnsubscribeTypeDto,
        itemId: Int,
        ownerId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("newsfeed.unsubscribe") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("type", type.value)
        addParam("item_id", itemId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
    }

    object NewsfeedAddBanRestrictions {
        const val USER_IDS_MIN: Long = 1

        const val GROUP_IDS_MIN: Long = 1
    }

    object NewsfeedDeleteBanRestrictions {
        const val USER_IDS_MIN: Long = 1

        const val GROUP_IDS_MIN: Long = 1
    }

    object NewsfeedDeleteListRestrictions {
        const val LIST_ID_MIN: Long = 0
    }

    object NewsfeedGetRestrictions {
        const val START_TIME_MIN: Long = 0

        const val END_TIME_MIN: Long = 0

        const val MAX_PHOTOS_MIN: Long = 0

        const val COUNT_MIN: Long = 0
    }

    object NewsfeedGetCommentsRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100

        const val START_TIME_MIN: Long = 0

        const val END_TIME_MIN: Long = 0

        const val LAST_COMMENTS_COUNT_MIN: Long = 0

        const val LAST_COMMENTS_COUNT_MAX: Long = 10
    }

    object NewsfeedGetMentionsRestrictions {
        const val START_TIME_MIN: Long = 0

        const val END_TIME_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 50
    }

    object NewsfeedGetRecommendedRestrictions {
        const val START_TIME_MIN: Long = 0

        const val END_TIME_MIN: Long = 0

        const val MAX_PHOTOS_MIN: Long = 0

        const val COUNT_MIN: Long = 0
    }

    object NewsfeedGetSuggestedSourcesRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object NewsfeedIgnoreItemRestrictions {
        const val ITEM_ID_MIN: Long = 0
    }

    object NewsfeedSaveListRestrictions {
        const val LIST_ID_MIN: Long = 0
    }

    object NewsfeedSearchRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200

        const val START_TIME_MIN: Long = 0

        const val END_TIME_MIN: Long = 0
    }

    object NewsfeedUnignoreItemRestrictions {
        const val ITEM_ID_MIN: Long = 0
    }

    object NewsfeedUnsubscribeRestrictions {
        const val ITEM_ID_MIN: Long = 0
    }
}
