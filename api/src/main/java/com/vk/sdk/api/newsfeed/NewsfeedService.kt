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
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.newsfeed.dto.NewsfeedCommentsFilters
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetBannedExtendedNameCase
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetBannedExtendedResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetBannedNameCase
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetBannedResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetCommentsResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetListsExtendedResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetListsResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetMentionsResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetRecommendedResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetSuggestedSourcesResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedNewsfeedItemType
import com.vk.sdk.api.newsfeed.dto.NewsfeedSearchExtendedResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedSearchResponse
import com.vk.sdk.api.newsfeed.dto.NewsfeedUnsubscribeType
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class NewsfeedService {
    /**
     * Prevents news from specified users and communities from appearing in the current user's
     * newsfeed.
     *
     * @param userIds
     * @param groupIds
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun newsfeedAddBan(userIds: List<Int>? = null, groupIds: List<Int>? = null):
            VKRequest<BaseOkResponse> = NewApiRequest("newsfeed.addBan") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        userIds?.let { addParam("user_ids", it) }
        groupIds?.let { addParam("group_ids", it) }
    }

    /**
     * Allows news from previously banned users and communities to be shown in the current user's
     * newsfeed.
     *
     * @param userIds
     * @param groupIds
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun newsfeedDeleteBan(userIds: List<Int>? = null, groupIds: List<Int>? = null):
            VKRequest<BaseOkResponse> = NewApiRequest("newsfeed.deleteBan") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        userIds?.let { addParam("user_ids", it) }
        groupIds?.let { addParam("group_ids", it) }
    }

    /**
     * @param listId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun newsfeedDeleteList(listId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("newsfeed.deleteList") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [NewsfeedGetResponse]
     */
    fun newsfeedGet(
        filters: List<NewsfeedNewsfeedItemType>? = null,
        returnBanned: Boolean? = null,
        startTime: Int? = null,
        endTime: Int? = null,
        maxPhotos: Int? = null,
        sourceIds: String? = null,
        startFrom: String? = null,
        count: Int? = null,
        fields: List<BaseUserGroupFields>? = null,
        section: String? = null
    ): VKRequest<NewsfeedGetResponse> = NewApiRequest("newsfeed.get") {
        GsonHolder.gson.fromJson(it, NewsfeedGetResponse::class.java)
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
     * @param fields - Profile fields to return.
     * @param nameCase - Case for declension of user name and surname_ 'nom' - nominative (default),
     * 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' -
     * prepositional
     * @return [VKRequest] with [NewsfeedGetBannedResponse]
     */
    fun newsfeedGetBanned(fields: List<UsersFields>? = null, nameCase: NewsfeedGetBannedNameCase? =
            null): VKRequest<NewsfeedGetBannedResponse> = NewApiRequest("newsfeed.getBanned") {
        GsonHolder.gson.fromJson(it, NewsfeedGetBannedResponse::class.java)
    }
    .apply {
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it.value) }
    }

    /**
     * Returns a list of users and communities banned from the current user's newsfeed.
     *
     * @param fields - Profile fields to return.
     * @param nameCase - Case for declension of user name and surname_ 'nom' - nominative (default),
     * 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' -
     * prepositional
     * @return [VKRequest] with [NewsfeedGetBannedExtendedResponse]
     */
    fun newsfeedGetBannedExtended(fields: List<UsersFields>? = null,
            nameCase: NewsfeedGetBannedExtendedNameCase? = null):
            VKRequest<NewsfeedGetBannedExtendedResponse> = NewApiRequest("newsfeed.getBanned") {
        GsonHolder.gson.fromJson(it, NewsfeedGetBannedExtendedResponse::class.java)
    }
    .apply {
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it.value) }
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
     * @return [VKRequest] with [NewsfeedGetCommentsResponse]
     */
    fun newsfeedGetComments(
        count: Int? = null,
        filters: List<NewsfeedCommentsFilters>? = null,
        reposts: String? = null,
        startTime: Int? = null,
        endTime: Int? = null,
        lastCommentsCount: Int? = null,
        startFrom: String? = null,
        fields: List<BaseUserGroupFields>? = null
    ): VKRequest<NewsfeedGetCommentsResponse> = NewApiRequest("newsfeed.getComments") {
        GsonHolder.gson.fromJson(it, NewsfeedGetCommentsResponse::class.java)
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
     * @return [VKRequest] with [NewsfeedGetListsResponse]
     */
    fun newsfeedGetLists(listIds: List<Int>? = null): VKRequest<NewsfeedGetListsResponse> =
            NewApiRequest("newsfeed.getLists") {
        GsonHolder.gson.fromJson(it, NewsfeedGetListsResponse::class.java)
    }
    .apply {
        listIds?.let { addParam("list_ids", it) }
    }

    /**
     * Returns a list of newsfeeds followed by the current user.
     *
     * @param listIds - numeric list identifiers.
     * @return [VKRequest] with [NewsfeedGetListsExtendedResponse]
     */
    fun newsfeedGetListsExtended(listIds: List<Int>? = null):
            VKRequest<NewsfeedGetListsExtendedResponse> = NewApiRequest("newsfeed.getLists") {
        GsonHolder.gson.fromJson(it, NewsfeedGetListsExtendedResponse::class.java)
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
     * @return [VKRequest] with [NewsfeedGetMentionsResponse]
     */
    fun newsfeedGetMentions(
        ownerId: UserId? = null,
        startTime: Int? = null,
        endTime: Int? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<NewsfeedGetMentionsResponse> = NewApiRequest("newsfeed.getMentions") {
        GsonHolder.gson.fromJson(it, NewsfeedGetMentionsResponse::class.java)
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
     * @return [VKRequest] with [NewsfeedGetRecommendedResponse]
     */
    fun newsfeedGetRecommended(
        startTime: Int? = null,
        endTime: Int? = null,
        maxPhotos: Int? = null,
        startFrom: String? = null,
        count: Int? = null,
        fields: List<BaseUserGroupFields>? = null
    ): VKRequest<NewsfeedGetRecommendedResponse> = NewApiRequest("newsfeed.getRecommended") {
        GsonHolder.gson.fromJson(it, NewsfeedGetRecommendedResponse::class.java)
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
     * @return [VKRequest] with [NewsfeedGetSuggestedSourcesResponse]
     */
    fun newsfeedGetSuggestedSources(
        offset: Int? = null,
        count: Int? = null,
        shuffle: Boolean? = null,
        fields: List<BaseUserGroupFields>? = null
    ): VKRequest<NewsfeedGetSuggestedSourcesResponse> =
            NewApiRequest("newsfeed.getSuggestedSources") {
        GsonHolder.gson.fromJson(it, NewsfeedGetSuggestedSourcesResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun newsfeedIgnoreItem(
        type: String,
        ownerId: UserId? = null,
        itemId: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("newsfeed.ignoreItem") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
        GsonHolder.gson.fromJson(it, Int::class.java)
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
     * @return [VKRequest] with [NewsfeedSearchResponse]
     */
    fun newsfeedSearch(
        q: String? = null,
        count: Int? = null,
        latitude: Float? = null,
        longitude: Float? = null,
        startTime: Int? = null,
        endTime: Int? = null,
        startFrom: String? = null,
        fields: List<BaseUserGroupFields>? = null
    ): VKRequest<NewsfeedSearchResponse> = NewApiRequest("newsfeed.search") {
        GsonHolder.gson.fromJson(it, NewsfeedSearchResponse::class.java)
    }
    .apply {
        q?.let { addParam("q", it) }
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
     * Returns search results by statuses.
     *
     * @param q - Search query string (e.g., 'New Year').
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
     * @return [VKRequest] with [NewsfeedSearchExtendedResponse]
     */
    fun newsfeedSearchExtended(
        q: String? = null,
        count: Int? = null,
        latitude: Float? = null,
        longitude: Float? = null,
        startTime: Int? = null,
        endTime: Int? = null,
        startFrom: String? = null,
        fields: List<BaseUserGroupFields>? = null
    ): VKRequest<NewsfeedSearchExtendedResponse> = NewApiRequest("newsfeed.search") {
        GsonHolder.gson.fromJson(it, NewsfeedSearchExtendedResponse::class.java)
    }
    .apply {
        q?.let { addParam("q", it) }
        addParam("extended", true)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun newsfeedUnignoreItem(
        type: String,
        ownerId: UserId,
        itemId: Int,
        trackCode: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("newsfeed.unignoreItem") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun newsfeedUnsubscribe(
        type: NewsfeedUnsubscribeType,
        itemId: Int,
        ownerId: UserId? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("newsfeed.unsubscribe") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("type", type.value)
        addParam("item_id", itemId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
    }
}
