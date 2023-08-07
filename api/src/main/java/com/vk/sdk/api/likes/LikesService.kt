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
package com.vk.sdk.api.likes

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.likes.dto.LikesAddResponseDto
import com.vk.sdk.api.likes.dto.LikesDeleteResponseDto
import com.vk.sdk.api.likes.dto.LikesGetListExtendedFilterDto
import com.vk.sdk.api.likes.dto.LikesGetListExtendedFriendsOnlyDto
import com.vk.sdk.api.likes.dto.LikesGetListExtendedResponseDto
import com.vk.sdk.api.likes.dto.LikesGetListFilterDto
import com.vk.sdk.api.likes.dto.LikesGetListFriendsOnlyDto
import com.vk.sdk.api.likes.dto.LikesGetListResponseDto
import com.vk.sdk.api.likes.dto.LikesIsLikedResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class LikesService {
    /**
     * Adds the specified object to the 'Likes' list of the current user.
     *
     * @param type - Object type_ 'post' - post on user or community wall, 'comment' - comment on a
     * wall post, 'photo' - photo, 'audio' - audio, 'video' - video, 'story' - story, 'note' - note,
     * 'photo_comment' - comment on the photo, 'video_comment' - comment on the video,
     * 'topic_comment' - comment in the discussion, 'sitepage' - page of the site where the
     * [vk.com/dev/Like|Like widget] is installed
     * @param itemId - Object ID.
     * @param ownerId - ID of the user or community that owns the object.
     * @param accessKey - Access key required for an object owned by a private entity.
     * @return [VKRequest] with [LikesAddResponseDto]
     */
    fun likesAdd(
        type: String,
        itemId: Int,
        ownerId: UserId? = null,
        accessKey: String? = null
    ): VKRequest<LikesAddResponseDto> = NewApiRequest("likes.add") {
        GsonHolder.gson.parse<LikesAddResponseDto>(it)
    }
    .apply {
        addParam("type", type)
        addParam("item_id", itemId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        accessKey?.let { addParam("access_key", it) }
    }

    /**
     * Deletes the specified object from the 'Likes' list of the current user.
     *
     * @param type - Object type_ 'post' - post on user or community wall, 'comment' - comment on a
     * wall post, 'photo' - photo, 'audio' - audio, 'video' - video, 'story' - story, 'note' - note,
     * 'photo_comment' - comment on the photo, 'video_comment' - comment on the video,
     * 'topic_comment' - comment in the discussion, 'sitepage' - page of the site where the
     * [vk.com/dev/Like|Like widget] is installed
     * @param itemId - Object ID.
     * @param ownerId - ID of the user or community that owns the object.
     * @param accessKey - Access key required for an object owned by a private entity.
     * @return [VKRequest] with [LikesDeleteResponseDto]
     */
    fun likesDelete(
        type: String,
        itemId: Int,
        ownerId: UserId? = null,
        accessKey: String? = null
    ): VKRequest<LikesDeleteResponseDto> = NewApiRequest("likes.delete") {
        GsonHolder.gson.parse<LikesDeleteResponseDto>(it)
    }
    .apply {
        addParam("type", type)
        addParam("item_id", itemId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        accessKey?.let { addParam("access_key", it) }
    }

    /**
     * Returns a list of IDs of users who added the specified object to their 'Likes' list.
     *
     * @param type - , Object type_ 'post' - post on user or community wall, 'comment' - comment on
     * a wall post, 'photo' - photo, 'audio' - audio, 'video' - video, 'story' - story, 'note' - note,
     * 'photo_comment' - comment on the photo, 'video_comment' - comment on the video,
     * 'topic_comment' - comment in the discussion, 'sitepage' - page of the site where the
     * [vk.com/dev/Like|Like widget] is installed
     * @param ownerId - ID of the user, community, or application that owns the object. If the
     * 'type' parameter is set as 'sitepage', the application ID is passed as 'owner_id'. Use negative
     * value for a community id. If the 'type' parameter is not set, the 'owner_id' is assumed to be
     * either the current user or the same application ID as if the 'type' parameter was set to
     * 'sitepage'.
     * @param itemId - Object ID. If 'type' is set as 'sitepage', 'item_id' can include the
     * 'page_id' parameter value used during initialization of the [vk.com/dev/Like|Like widget].
     * @param pageUrl - URL of the page where the [vk.com/dev/Like|Like widget] is installed. Used
     * instead of the 'item_id' parameter.
     * @param filter - Filters to apply_ 'likes' - returns information about all users who liked the
     * object (default), 'copies' - returns information only about users who told their friends about
     * the object
     * @param friendsOnly - Specifies which users are returned_ '1' - to return only the current
     * user's friends, '0' - to return all users (default)
     * @param extended - Specifies whether extended information will be returned. '1' - to return
     * extended information about users and communities from the 'Likes' list, '0' - to return no
     * additional information (default)
     * @param offset - Offset needed to select a specific subset of users.
     * @param count - Number of user IDs to return (maximum '1000'). Default is '100' if
     * 'friends_only' is set to '0', otherwise, the default is '10' if 'friends_only' is set to '1'.
     * @param skipOwn
     * @param fields
     * @return [VKRequest] with [LikesGetListResponseDto]
     */
    fun likesGetList(
        type: String,
        ownerId: UserId? = null,
        itemId: Int? = null,
        pageUrl: String? = null,
        filter: LikesGetListFilterDto? = null,
        friendsOnly: LikesGetListFriendsOnlyDto? = null,
        extended: Boolean? = null,
        offset: Int? = null,
        count: Int? = null,
        skipOwn: Boolean? = null,
        fields: List<String>? = null
    ): VKRequest<LikesGetListResponseDto> = NewApiRequest("likes.getList") {
        GsonHolder.gson.parse<LikesGetListResponseDto>(it)
    }
    .apply {
        addParam("type", type)
        ownerId?.let { addParam("owner_id", it) }
        itemId?.let { addParam("item_id", it) }
        pageUrl?.let { addParam("page_url", it) }
        filter?.let { addParam("filter", it.value) }
        friendsOnly?.let { addParam("friends_only", it.value) }
        extended?.let { addParam("extended", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        skipOwn?.let { addParam("skip_own", it) }
        fields?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of IDs of users who added the specified object to their 'Likes' list.
     *
     * @param type - , Object type_ 'post' - post on user or community wall, 'comment' - comment on
     * a wall post, 'photo' - photo, 'audio' - audio, 'video' - video, 'story' - story, 'note' - note,
     * 'photo_comment' - comment on the photo, 'video_comment' - comment on the video,
     * 'topic_comment' - comment in the discussion, 'sitepage' - page of the site where the
     * [vk.com/dev/Like|Like widget] is installed
     * @param ownerId - ID of the user, community, or application that owns the object. If the
     * 'type' parameter is set as 'sitepage', the application ID is passed as 'owner_id'. Use negative
     * value for a community id. If the 'type' parameter is not set, the 'owner_id' is assumed to be
     * either the current user or the same application ID as if the 'type' parameter was set to
     * 'sitepage'.
     * @param itemId - Object ID. If 'type' is set as 'sitepage', 'item_id' can include the
     * 'page_id' parameter value used during initialization of the [vk.com/dev/Like|Like widget].
     * @param pageUrl - URL of the page where the [vk.com/dev/Like|Like widget] is installed. Used
     * instead of the 'item_id' parameter.
     * @param filter - Filters to apply_ 'likes' - returns information about all users who liked the
     * object (default), 'copies' - returns information only about users who told their friends about
     * the object
     * @param friendsOnly - Specifies which users are returned_ '1' - to return only the current
     * user's friends, '0' - to return all users (default)
     * @param offset - Offset needed to select a specific subset of users.
     * @param count - Number of user IDs to return (maximum '1000'). Default is '100' if
     * 'friends_only' is set to '0', otherwise, the default is '10' if 'friends_only' is set to '1'.
     * @param skipOwn
     * @param fields
     * @return [VKRequest] with [LikesGetListExtendedResponseDto]
     */
    fun likesGetListExtended(
        type: String,
        ownerId: UserId? = null,
        itemId: Int? = null,
        pageUrl: String? = null,
        filter: LikesGetListExtendedFilterDto? = null,
        friendsOnly: LikesGetListExtendedFriendsOnlyDto? = null,
        offset: Int? = null,
        count: Int? = null,
        skipOwn: Boolean? = null,
        fields: List<String>? = null
    ): VKRequest<LikesGetListExtendedResponseDto> = NewApiRequest("likes.getList") {
        GsonHolder.gson.parse<LikesGetListExtendedResponseDto>(it)
    }
    .apply {
        addParam("type", type)
        ownerId?.let { addParam("owner_id", it) }
        itemId?.let { addParam("item_id", it) }
        pageUrl?.let { addParam("page_url", it) }
        filter?.let { addParam("filter", it.value) }
        friendsOnly?.let { addParam("friends_only", it.value) }
        addParam("extended", true)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        skipOwn?.let { addParam("skip_own", it) }
        fields?.let { addParam("fields", it) }
    }

    /**
     * Checks for the object in the 'Likes' list of the specified user.
     *
     * @param type - Object type_ 'post' - post on user or community wall, 'comment' - comment on a
     * wall post, 'photo' - photo, 'audio' - audio, 'video' - video, 'story' - story, 'note' - note,
     * 'photo_comment' - comment on the photo, 'video_comment' - comment on the video,
     * 'topic_comment' - comment in the discussion
     * @param itemId - Object ID.
     * @param userId - User ID.
     * @param ownerId - ID of the user or community that owns the object.
     * @return [VKRequest] with [LikesIsLikedResponseDto]
     */
    fun likesIsLiked(
        type: String,
        itemId: Int,
        userId: UserId? = null,
        ownerId: UserId? = null
    ): VKRequest<LikesIsLikedResponseDto> = NewApiRequest("likes.isLiked") {
        GsonHolder.gson.parse<LikesIsLikedResponseDto>(it)
    }
    .apply {
        addParam("type", type)
        addParam("item_id", itemId, min = 0)
        userId?.let { addParam("user_id", it, min = 0) }
        ownerId?.let { addParam("owner_id", it) }
    }

    object LikesAddRestrictions {
        const val ITEM_ID_MIN: Long = 0
    }

    object LikesDeleteRestrictions {
        const val ITEM_ID_MIN: Long = 0
    }

    object LikesGetListRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object LikesGetListExtendedRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object LikesIsLikedRestrictions {
        const val ITEM_ID_MIN: Long = 0

        const val USER_ID_MIN: Long = 0
    }
}
