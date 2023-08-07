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
package com.vk.sdk.api.wall

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.dto.BaseUserGroupFieldsDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.wall.dto.WallCreateCommentResponseDto
import com.vk.sdk.api.wall.dto.WallEditResponseDto
import com.vk.sdk.api.wall.dto.WallEditTopicIdDto
import com.vk.sdk.api.wall.dto.WallGetByIdExtendedResponseDto
import com.vk.sdk.api.wall.dto.WallGetCommentExtendedResponseDto
import com.vk.sdk.api.wall.dto.WallGetCommentResponseDto
import com.vk.sdk.api.wall.dto.WallGetCommentsExtendedResponseDto
import com.vk.sdk.api.wall.dto.WallGetCommentsExtendedSortDto
import com.vk.sdk.api.wall.dto.WallGetCommentsResponseDto
import com.vk.sdk.api.wall.dto.WallGetCommentsSortDto
import com.vk.sdk.api.wall.dto.WallGetExtendedResponseDto
import com.vk.sdk.api.wall.dto.WallGetRepostsResponseDto
import com.vk.sdk.api.wall.dto.WallGetResponseDto
import com.vk.sdk.api.wall.dto.WallPostAdsStealthResponseDto
import com.vk.sdk.api.wall.dto.WallPostResponseDto
import com.vk.sdk.api.wall.dto.WallPostTopicIdDto
import com.vk.sdk.api.wall.dto.WallReportCommentReasonDto
import com.vk.sdk.api.wall.dto.WallReportPostReasonDto
import com.vk.sdk.api.wall.dto.WallRepostResponseDto
import com.vk.sdk.api.wall.dto.WallSearchExtendedResponseDto
import com.vk.sdk.api.wall.dto.WallSearchResponseDto
import com.vk.sdk.api.wall.dto.WallWallItemDto
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class WallService {
    /**
     * @param link
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun wallCheckCopyrightLink(link: String): VKRequest<BaseBoolIntDto> =
            NewApiRequest("wall.checkCopyrightLink") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("link", link)
    }

    /**
     * @param ownerId
     * @param postId
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun wallCloseComments(ownerId: UserId, postId: Int): VKRequest<BaseBoolIntDto> =
            NewApiRequest("wall.closeComments") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("post_id", postId, min = 0)
    }

    /**
     * Adds a comment to a post on a user wall or community wall.
     *
     * @param postId - Post ID.
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param fromGroup - Group ID.
     * @param message - (Required if 'attachments' is not set.) Text of the comment.
     * @param replyToComment - ID of comment to reply.
     * @param attachments - (Required if 'message' is not set.) List of media objects attached to
     * the comment, in the following format_ "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type
     * of media ojbect_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document,
     * '<owner_id>' - ID of the media owner. '<media_id>' - Media ID. For example_
     * "photo100172_166443618,photo66748_265827614"
     * @param stickerId - Sticker ID.
     * @param guid - Unique identifier to avoid repeated comments.
     * @return [VKRequest] with [WallCreateCommentResponseDto]
     */
    fun wallCreateComment(
        postId: Int,
        ownerId: UserId? = null,
        fromGroup: UserId? = null,
        message: String? = null,
        replyToComment: Int? = null,
        attachments: List<String>? = null,
        stickerId: Int? = null,
        guid: String? = null
    ): VKRequest<WallCreateCommentResponseDto> = NewApiRequest("wall.createComment") {
        GsonHolder.gson.parse<WallCreateCommentResponseDto>(it)
    }
    .apply {
        addParam("post_id", postId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        fromGroup?.let { addParam("from_group", it, min = 0) }
        message?.let { addParam("message", it) }
        replyToComment?.let { addParam("reply_to_comment", it) }
        attachments?.let { addParam("attachments", it) }
        stickerId?.let { addParam("sticker_id", it, min = 0) }
        guid?.let { addParam("guid", it) }
    }

    /**
     * Deletes a post from a user wall or community wall.
     *
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param postId - ID of the post to be deleted.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun wallDelete(ownerId: UserId? = null, postId: Int? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("wall.delete") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        postId?.let { addParam("post_id", it, min = 0) }
    }

    /**
     * Deletes a comment on a post on a user wall or community wall.
     *
     * @param commentId - Comment ID.
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun wallDeleteComment(commentId: Int, ownerId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("wall.deleteComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("comment_id", commentId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Edits a post on a user wall or community wall.
     *
     * @param postId
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param friendsOnly
     * @param message - (Required if 'attachments' is not set.) Text of the post.
     * @param attachments - (Required if 'message' is not set.) List of objects attached to the
     * post, in the following format_ "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media
     * attachment_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' -
     * ID of the media application owner. '<media_id>' - Media application ID. Example_
     * "photo100172_166443618,photo66748_265827614", May contain a link to an external page to include
     * in the post. Example_ "photo66748_265827614,http_//habrahabr.ru", "NOTE_ If more than one link
     * is being attached, an error is thrown."
     * @param primaryAttachments
     * @param services
     * @param signed
     * @param publishDate
     * @param lat
     * @param long
     * @param placeId
     * @param markAsAds
     * @param closeComments
     * @param donutPaidDuration
     * @param posterBkgId
     * @param posterBkgOwnerId
     * @param posterBkgAccessHash
     * @param copyright
     * @param topicId - Topic ID. Allowed values can be obtained from newsfeed.getPostTopics method
     * @return [VKRequest] with [WallEditResponseDto]
     */
    fun wallEdit(
        postId: Int,
        ownerId: UserId? = null,
        friendsOnly: Boolean? = null,
        message: String? = null,
        attachments: List<String>? = null,
        primaryAttachments: List<String>? = null,
        services: String? = null,
        signed: Boolean? = null,
        publishDate: Int? = null,
        lat: Float? = null,
        long: Float? = null,
        placeId: Int? = null,
        markAsAds: Boolean? = null,
        closeComments: Boolean? = null,
        donutPaidDuration: Int? = null,
        posterBkgId: Int? = null,
        posterBkgOwnerId: UserId? = null,
        posterBkgAccessHash: String? = null,
        copyright: String? = null,
        topicId: WallEditTopicIdDto? = null
    ): VKRequest<WallEditResponseDto> = NewApiRequest("wall.edit") {
        GsonHolder.gson.parse<WallEditResponseDto>(it)
    }
    .apply {
        addParam("post_id", postId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        friendsOnly?.let { addParam("friends_only", it) }
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
        primaryAttachments?.let { addParam("primary_attachments", it) }
        services?.let { addParam("services", it) }
        signed?.let { addParam("signed", it) }
        publishDate?.let { addParam("publish_date", it, min = 0) }
        lat?.let { addParam("lat", it) }
        long?.let { addParam("long", it) }
        placeId?.let { addParam("place_id", it, min = 0) }
        markAsAds?.let { addParam("mark_as_ads", it) }
        closeComments?.let { addParam("close_comments", it) }
        donutPaidDuration?.let { addParam("donut_paid_duration", it) }
        posterBkgId?.let { addParam("poster_bkg_id", it, min = 0) }
        posterBkgOwnerId?.let { addParam("poster_bkg_owner_id", it) }
        posterBkgAccessHash?.let { addParam("poster_bkg_access_hash", it) }
        copyright?.let { addParam("copyright", it) }
        topicId?.let { addParam("topic_id", it.value) }
    }

    /**
     * Allows to edit hidden post.
     *
     * @param postId - Post ID. Used for publishing of scheduled and suggested posts.
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param message - (Required if 'attachments' is not set.) Text of the post.
     * @param attachments - (Required if 'message' is not set.) List of objects attached to the
     * post, in the following format_ "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media
     * attachment_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, 'page' -
     * wiki-page, 'note' - note, 'poll' - poll, 'album' - photo album, '<owner_id>' - ID of the media
     * application owner. '<media_id>' - Media application ID. Example_
     * "photo100172_166443618,photo66748_265827614", May contain a link to an external page to include
     * in the post. Example_ "photo66748_265827614,http_//habrahabr.ru", "NOTE_ If more than one link
     * is being attached, an error will be thrown."
     * @param signed - Only for posts in communities with 'from_group' set to '1'_ '1' - post will
     * be signed with the name of the posting user, '0' - post will not be signed (default)
     * @param lat - Geographical latitude of a check-in, in degrees (from -90 to 90).
     * @param long - Geographical longitude of a check-in, in degrees (from -180 to 180).
     * @param placeId - ID of the location where the user was tagged.
     * @param linkButton - Link button ID
     * @param linkTitle - Link title
     * @param linkImage - Link image url
     * @param linkVideo - Link video ID in format "<owner_id>_<media_id>"
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun wallEditAdsStealth(
        postId: Int,
        ownerId: UserId? = null,
        message: String? = null,
        attachments: List<String>? = null,
        signed: Boolean? = null,
        lat: Float? = null,
        long: Float? = null,
        placeId: Int? = null,
        linkButton: String? = null,
        linkTitle: String? = null,
        linkImage: String? = null,
        linkVideo: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("wall.editAdsStealth") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("post_id", postId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
        signed?.let { addParam("signed", it) }
        lat?.let { addParam("lat", it) }
        long?.let { addParam("long", it) }
        placeId?.let { addParam("place_id", it, min = 0) }
        linkButton?.let { addParam("link_button", it) }
        linkTitle?.let { addParam("link_title", it) }
        linkImage?.let { addParam("link_image", it) }
        linkVideo?.let { addParam("link_video", it) }
    }

    /**
     * Edits a comment on a user wall or community wall.
     *
     * @param commentId - Comment ID.
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param message - New comment text.
     * @param attachments - List of objects attached to the comment, in the following format_ ,
     * "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media attachment_ 'photo' - photo,
     * 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' - ID of the media attachment
     * owner. '<media_id>' - Media attachment ID. For example_
     * "photo100172_166443618,photo66748_265827614"
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun wallEditComment(
        commentId: Int,
        ownerId: UserId? = null,
        message: String? = null,
        attachments: List<String>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("wall.editComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("comment_id", commentId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
    }

    /**
     * Returns a list of posts on a user wall or community wall.
     *
     * @param ownerId - ID of the user or community that owns the wall. By default, current user ID.
     * Use a negative value to designate a community ID.
     * @param domain - User or community short address.
     * @param offset - Offset needed to return a specific subset of posts.
     * @param count - Number of posts to return (maximum 100).
     * @param filter
     * @param extended - '1' - to return 'wall', 'profiles', and 'groups' fields, '0' - to return no
     * additional fields (default)
     * @param fields
     * @return [VKRequest] with [WallGetResponseDto]
     */
    fun wallGet(
        ownerId: UserId? = null,
        domain: String? = null,
        offset: Int? = null,
        count: Int? = null,
        filter: String? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<WallGetResponseDto> = NewApiRequest("wall.get") {
        GsonHolder.gson.parse<WallGetResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        domain?.let { addParam("domain", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        filter?.let { addParam("filter", it) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of posts on a user wall or community wall.
     *
     * @param ownerId - ID of the user or community that owns the wall. By default, current user ID.
     * Use a negative value to designate a community ID.
     * @param domain - User or community short address.
     * @param offset - Offset needed to return a specific subset of posts.
     * @param count - Number of posts to return (maximum 100).
     * @param filter
     * @param fields
     * @return [VKRequest] with [WallGetExtendedResponseDto]
     */
    fun wallGetExtended(
        ownerId: UserId? = null,
        domain: String? = null,
        offset: Int? = null,
        count: Int? = null,
        filter: String? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<WallGetExtendedResponseDto> = NewApiRequest("wall.get") {
        GsonHolder.gson.parse<WallGetExtendedResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        domain?.let { addParam("domain", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        filter?.let { addParam("filter", it) }
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of posts from user or community walls by their IDs.
     *
     * @param posts - User or community IDs and post IDs, separated by underscores. Use a negative
     * value to designate a community ID. Example_ "93388_21539,93388_20904,2943_4276,-1_1"
     * @param extended - '1' - to return user and community objects needed to display posts, '0' -
     * no additional fields are returned (default)
     * @param copyHistoryDepth - Sets the number of parent elements to include in the array
     * 'copy_history' that is returned if the post is a repost from another wall.
     * @param fields
     * @return [VKRequest] with [Unit]
     */
    fun wallGetById(
        posts: List<String>,
        extended: Boolean? = null,
        copyHistoryDepth: Int? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<List<WallWallItemDto>> = NewApiRequest("wall.getById") {
        GsonHolder.gson.parseList<WallWallItemDto>(it)
    }
    .apply {
        addParam("posts", posts)
        extended?.let { addParam("extended", it) }
        copyHistoryDepth?.let { addParam("copy_history_depth", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of posts from user or community walls by their IDs.
     *
     * @param posts - User or community IDs and post IDs, separated by underscores. Use a negative
     * value to designate a community ID. Example_ "93388_21539,93388_20904,2943_4276,-1_1"
     * @param copyHistoryDepth - Sets the number of parent elements to include in the array
     * 'copy_history' that is returned if the post is a repost from another wall.
     * @param fields
     * @return [VKRequest] with [WallGetByIdExtendedResponseDto]
     */
    fun wallGetByIdExtended(
        posts: List<String>,
        copyHistoryDepth: Int? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<WallGetByIdExtendedResponseDto> = NewApiRequest("wall.getById") {
        GsonHolder.gson.parse<WallGetByIdExtendedResponseDto>(it)
    }
    .apply {
        addParam("posts", posts)
        addParam("extended", true)
        copyHistoryDepth?.let { addParam("copy_history_depth", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a comment on a post on a user wall or community wall.
     *
     * @param commentId - Comment ID.
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param extended
     * @param fields
     * @return [VKRequest] with [WallGetCommentResponseDto]
     */
    fun wallGetComment(
        commentId: Int,
        ownerId: UserId? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<WallGetCommentResponseDto> = NewApiRequest("wall.getComment") {
        GsonHolder.gson.parse<WallGetCommentResponseDto>(it)
    }
    .apply {
        addParam("comment_id", commentId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a comment on a post on a user wall or community wall.
     *
     * @param commentId - Comment ID.
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param fields
     * @return [VKRequest] with [WallGetCommentExtendedResponseDto]
     */
    fun wallGetCommentExtended(
        commentId: Int,
        ownerId: UserId? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<WallGetCommentExtendedResponseDto> = NewApiRequest("wall.getComment") {
        GsonHolder.gson.parse<WallGetCommentExtendedResponseDto>(it)
    }
    .apply {
        addParam("comment_id", commentId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of comments on a post on a user wall or community wall.
     *
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param postId - Post ID.
     * @param needLikes - '1' - to return the 'likes' field, '0' - not to return the 'likes' field
     * (default)
     * @param startCommentId
     * @param offset - Offset needed to return a specific subset of comments.
     * @param count - Number of comments to return (maximum 100).
     * @param sort - Sort order_ 'asc' - chronological, 'desc' - reverse chronological
     * @param previewLength - Number of characters at which to truncate comments when previewed. By
     * default, '90'. Specify '0' if you do not want to truncate comments.
     * @param extended
     * @param fields
     * @param commentId - Comment ID.
     * @param threadItemsCount - Count items in threads.
     * @return [VKRequest] with [WallGetCommentsResponseDto]
     */
    fun wallGetComments(
        ownerId: UserId? = null,
        postId: Int? = null,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: WallGetCommentsSortDto? = null,
        previewLength: Int? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null,
        commentId: Int? = null,
        threadItemsCount: Int? = null
    ): VKRequest<WallGetCommentsResponseDto> = NewApiRequest("wall.getComments") {
        GsonHolder.gson.parse<WallGetCommentsResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        postId?.let { addParam("post_id", it, min = 0) }
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it, min = 0) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0) }
        sort?.let { addParam("sort", it.value) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        commentId?.let { addParam("comment_id", it, min = 0) }
        threadItemsCount?.let { addParam("thread_items_count", it, min = 0, max = 10) }
    }

    /**
     * Returns a list of comments on a post on a user wall or community wall.
     *
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param postId - Post ID.
     * @param needLikes - '1' - to return the 'likes' field, '0' - not to return the 'likes' field
     * (default)
     * @param startCommentId
     * @param offset - Offset needed to return a specific subset of comments.
     * @param count - Number of comments to return (maximum 100).
     * @param sort - Sort order_ 'asc' - chronological, 'desc' - reverse chronological
     * @param previewLength - Number of characters at which to truncate comments when previewed. By
     * default, '90'. Specify '0' if you do not want to truncate comments.
     * @param fields
     * @param commentId - Comment ID.
     * @param threadItemsCount - Count items in threads.
     * @return [VKRequest] with [WallGetCommentsExtendedResponseDto]
     */
    fun wallGetCommentsExtended(
        ownerId: UserId? = null,
        postId: Int? = null,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: WallGetCommentsExtendedSortDto? = null,
        previewLength: Int? = null,
        fields: List<BaseUserGroupFieldsDto>? = null,
        commentId: Int? = null,
        threadItemsCount: Int? = null
    ): VKRequest<WallGetCommentsExtendedResponseDto> = NewApiRequest("wall.getComments") {
        GsonHolder.gson.parse<WallGetCommentsExtendedResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        postId?.let { addParam("post_id", it, min = 0) }
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it, min = 0) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0) }
        sort?.let { addParam("sort", it.value) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        commentId?.let { addParam("comment_id", it, min = 0) }
        threadItemsCount?.let { addParam("thread_items_count", it, min = 0, max = 10) }
    }

    /**
     * Returns information about reposts of a post on user wall or community wall.
     *
     * @param ownerId - User ID or community ID. By default, current user ID. Use a negative value
     * to designate a community ID.
     * @param postId - Post ID.
     * @param offset - Offset needed to return a specific subset of reposts.
     * @param count - Number of reposts to return.
     * @return [VKRequest] with [WallGetRepostsResponseDto]
     */
    fun wallGetReposts(
        ownerId: UserId? = null,
        postId: Int? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<WallGetRepostsResponseDto> = NewApiRequest("wall.getReposts") {
        GsonHolder.gson.parse<WallGetRepostsResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        postId?.let { addParam("post_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * @param ownerId
     * @param postId
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun wallOpenComments(ownerId: UserId, postId: Int): VKRequest<BaseBoolIntDto> =
            NewApiRequest("wall.openComments") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("post_id", postId, min = 0)
    }

    /**
     * Pins the post on wall.
     *
     * @param postId - Post ID.
     * @param ownerId - ID of the user or community that owns the wall. By default, current user ID.
     * Use a negative value to designate a community ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun wallPin(postId: Int, ownerId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("wall.pin") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("post_id", postId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Adds a new post on a user wall or community wall. Can also be used to publish suggested or
     * scheduled posts.
     *
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param friendsOnly - '1' - post will be available to friends only, '0' - post will be
     * available to all users (default)
     * @param fromGroup - For a community_ '1' - post will be published by the community, '0' - post
     * will be published by the user (default)
     * @param message - (Required if 'attachments' is not set.) Text of the post.
     * @param attachments - (Required if 'message' is not set.) List of objects attached to the
     * post, in the following format_ "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media
     * attachment_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, 'page' -
     * wiki-page, 'note' - note, 'poll' - poll, 'album' - photo album, '<owner_id>' - ID of the media
     * application owner. '<media_id>' - Media application ID. Example_
     * "photo100172_166443618,photo66748_265827614", May contain a link to an external page to include
     * in the post. Example_ "photo66748_265827614,http_//habrahabr.ru", "NOTE_ If more than one link
     * is being attached, an error will be thrown."
     * @param primaryAttachments
     * @param services - List of services or websites the update will be exported to, if the user
     * has so requested. Sample values_ 'twitter', 'facebook'.
     * @param signed - Only for posts in communities with 'from_group' set to '1'_ '1' - post will
     * be signed with the name of the posting user, '0' - post will not be signed (default)
     * @param publishDate - Publication date (in Unix time). If used, posting will be delayed until
     * the set time.
     * @param lat - Geographical latitude of a check-in, in degrees (from -90 to 90).
     * @param long - Geographical longitude of a check-in, in degrees (from -180 to 180).
     * @param placeId - ID of the location where the user was tagged.
     * @param postId - Post ID. Used for publishing of scheduled and suggested posts.
     * @param guid
     * @param markAsAds
     * @param closeComments
     * @param donutPaidDuration
     * @param muteNotifications
     * @param copyright
     * @param topicId - Topic ID. Allowed values can be obtained from newsfeed.getPostTopics method
     * @return [VKRequest] with [WallPostResponseDto]
     */
    fun wallPost(
        ownerId: UserId? = null,
        friendsOnly: Boolean? = null,
        fromGroup: Boolean? = null,
        message: String? = null,
        attachments: List<String>? = null,
        primaryAttachments: List<String>? = null,
        services: String? = null,
        signed: Boolean? = null,
        publishDate: Int? = null,
        lat: Float? = null,
        long: Float? = null,
        placeId: Int? = null,
        postId: Int? = null,
        guid: String? = null,
        markAsAds: Boolean? = null,
        closeComments: Boolean? = null,
        donutPaidDuration: Int? = null,
        muteNotifications: Boolean? = null,
        copyright: String? = null,
        topicId: WallPostTopicIdDto? = null
    ): VKRequest<WallPostResponseDto> = NewApiRequest("wall.post") {
        GsonHolder.gson.parse<WallPostResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        friendsOnly?.let { addParam("friends_only", it) }
        fromGroup?.let { addParam("from_group", it) }
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
        primaryAttachments?.let { addParam("primary_attachments", it) }
        services?.let { addParam("services", it) }
        signed?.let { addParam("signed", it) }
        publishDate?.let { addParam("publish_date", it, min = 0) }
        lat?.let { addParam("lat", it) }
        long?.let { addParam("long", it) }
        placeId?.let { addParam("place_id", it, min = 0) }
        postId?.let { addParam("post_id", it, min = 0) }
        guid?.let { addParam("guid", it) }
        markAsAds?.let { addParam("mark_as_ads", it) }
        closeComments?.let { addParam("close_comments", it) }
        donutPaidDuration?.let { addParam("donut_paid_duration", it) }
        muteNotifications?.let { addParam("mute_notifications", it) }
        copyright?.let { addParam("copyright", it) }
        topicId?.let { addParam("topic_id", it.value) }
    }

    /**
     * Allows to create hidden post which will not be shown on the community's wall and can be used
     * for creating an ad with type "Community post".
     *
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param message - (Required if 'attachments' is not set.) Text of the post.
     * @param attachments - (Required if 'message' is not set.) List of objects attached to the
     * post, in the following format_ "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media
     * attachment_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, 'page' -
     * wiki-page, 'note' - note, 'poll' - poll, 'album' - photo album, '<owner_id>' - ID of the media
     * application owner. '<media_id>' - Media application ID. Example_
     * "photo100172_166443618,photo66748_265827614", May contain a link to an external page to include
     * in the post. Example_ "photo66748_265827614,http_//habrahabr.ru", "NOTE_ If more than one link
     * is being attached, an error will be thrown."
     * @param signed - Only for posts in communities with 'from_group' set to '1'_ '1' - post will
     * be signed with the name of the posting user, '0' - post will not be signed (default)
     * @param lat - Geographical latitude of a check-in, in degrees (from -90 to 90).
     * @param long - Geographical longitude of a check-in, in degrees (from -180 to 180).
     * @param placeId - ID of the location where the user was tagged.
     * @param guid - Unique identifier to avoid duplication the same post.
     * @param linkButton - Link button ID
     * @param linkTitle - Link title
     * @param linkImage - Link image url
     * @param linkVideo - Link video ID in format "<owner_id>_<media_id>"
     * @return [VKRequest] with [WallPostAdsStealthResponseDto]
     */
    fun wallPostAdsStealth(
        ownerId: UserId,
        message: String? = null,
        attachments: List<String>? = null,
        signed: Boolean? = null,
        lat: Float? = null,
        long: Float? = null,
        placeId: Int? = null,
        guid: String? = null,
        linkButton: String? = null,
        linkTitle: String? = null,
        linkImage: String? = null,
        linkVideo: String? = null
    ): VKRequest<WallPostAdsStealthResponseDto> = NewApiRequest("wall.postAdsStealth") {
        GsonHolder.gson.parse<WallPostAdsStealthResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
        signed?.let { addParam("signed", it) }
        lat?.let { addParam("lat", it) }
        long?.let { addParam("long", it) }
        placeId?.let { addParam("place_id", it, min = 0) }
        guid?.let { addParam("guid", it) }
        linkButton?.let { addParam("link_button", it) }
        linkTitle?.let { addParam("link_title", it) }
        linkImage?.let { addParam("link_image", it) }
        linkVideo?.let { addParam("link_video", it) }
    }

    /**
     * Reports (submits a complaint about) a comment on a post on a user wall or community wall.
     *
     * @param ownerId - ID of the user or community that owns the wall.
     * @param commentId - Comment ID.
     * @param reason - Reason for the complaint_ '0' - spam, '1' - child pornography, '2' -
     * extremism, '3' - violence, '4' - drug propaganda, '5' - adult material, '6' - insult, abuse
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun wallReportComment(
        ownerId: UserId,
        commentId: Int,
        reason: WallReportCommentReasonDto? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("wall.reportComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("comment_id", commentId, min = 0)
        reason?.let { addParam("reason", it.value) }
    }

    /**
     * Reports (submits a complaint about) a post on a user wall or community wall.
     *
     * @param ownerId - ID of the user or community that owns the wall.
     * @param postId - Post ID.
     * @param reason - Reason for the complaint_ '0' - spam, '1' - child pornography, '2' -
     * extremism, '3' - violence, '4' - drug propaganda, '5' - adult material, '6' - insult, abuse
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun wallReportPost(
        ownerId: UserId,
        postId: Int,
        reason: WallReportPostReasonDto? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("wall.reportPost") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("post_id", postId, min = 0)
        reason?.let { addParam("reason", it.value) }
    }

    /**
     * Reposts (copies) an object to a user wall or community wall.
     *
     * @param objectValue - ID of the object to be reposted on the wall. Example_ "wall66748_3675"
     * @param message - Comment to be added along with the reposted object.
     * @param groupId - Target community ID when reposting to a community.
     * @param markAsAds
     * @param muteNotifications
     * @return [VKRequest] with [WallRepostResponseDto]
     */
    fun wallRepost(
        objectValue: String,
        message: String? = null,
        groupId: UserId? = null,
        markAsAds: Boolean? = null,
        muteNotifications: Boolean? = null
    ): VKRequest<WallRepostResponseDto> = NewApiRequest("wall.repost") {
        GsonHolder.gson.parse<WallRepostResponseDto>(it)
    }
    .apply {
        addParam("object", objectValue)
        message?.let { addParam("message", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        markAsAds?.let { addParam("mark_as_ads", it) }
        muteNotifications?.let { addParam("mute_notifications", it) }
    }

    /**
     * Restores a post deleted from a user wall or community wall.
     *
     * @param ownerId - User ID or community ID from whose wall the post was deleted. Use a negative
     * value to designate a community ID.
     * @param postId - ID of the post to be restored.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun wallRestore(ownerId: UserId? = null, postId: Int? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("wall.restore") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        postId?.let { addParam("post_id", it, min = 0) }
    }

    /**
     * Restores a comment deleted from a user wall or community wall.
     *
     * @param commentId - Comment ID.
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun wallRestoreComment(commentId: Int, ownerId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("wall.restoreComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("comment_id", commentId)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Allows to search posts on user or community walls.
     *
     * @param ownerId - user or community id. "Remember that for a community 'owner_id' must be
     * negative."
     * @param domain - user or community screen name.
     * @param query - search query string.
     * @param ownersOnly - '1' - returns only page owner's posts.
     * @param count - count of posts to return.
     * @param offset - Offset needed to return a specific subset of posts.
     * @param extended - show extended post info.
     * @param fields
     * @return [VKRequest] with [WallSearchResponseDto]
     */
    fun wallSearch(
        ownerId: UserId? = null,
        domain: String? = null,
        query: String? = null,
        ownersOnly: Boolean? = null,
        count: Int? = null,
        offset: Int? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<WallSearchResponseDto> = NewApiRequest("wall.search") {
        GsonHolder.gson.parse<WallSearchResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        domain?.let { addParam("domain", it) }
        query?.let { addParam("query", it, maxLength = 9000) }
        ownersOnly?.let { addParam("owners_only", it) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        offset?.let { addParam("offset", it, min = 0) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Allows to search posts on user or community walls.
     *
     * @param ownerId - user or community id. "Remember that for a community 'owner_id' must be
     * negative."
     * @param domain - user or community screen name.
     * @param query - search query string.
     * @param ownersOnly - '1' - returns only page owner's posts.
     * @param count - count of posts to return.
     * @param offset - Offset needed to return a specific subset of posts.
     * @param fields
     * @return [VKRequest] with [WallSearchExtendedResponseDto]
     */
    fun wallSearchExtended(
        ownerId: UserId? = null,
        domain: String? = null,
        query: String? = null,
        ownersOnly: Boolean? = null,
        count: Int? = null,
        offset: Int? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<WallSearchExtendedResponseDto> = NewApiRequest("wall.search") {
        GsonHolder.gson.parse<WallSearchExtendedResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        domain?.let { addParam("domain", it) }
        query?.let { addParam("query", it, maxLength = 9000) }
        ownersOnly?.let { addParam("owners_only", it) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        offset?.let { addParam("offset", it, min = 0) }
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Unpins the post on wall.
     *
     * @param postId - Post ID.
     * @param ownerId - ID of the user or community that owns the wall. By default, current user ID.
     * Use a negative value to designate a community ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun wallUnpin(postId: Int, ownerId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("wall.unpin") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("post_id", postId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
    }

    object WallCloseCommentsRestrictions {
        const val POST_ID_MIN: Long = 0
    }

    object WallCreateCommentRestrictions {
        const val POST_ID_MIN: Long = 0

        const val FROM_GROUP_MIN: Long = 0

        const val STICKER_ID_MIN: Long = 0
    }

    object WallDeleteRestrictions {
        const val POST_ID_MIN: Long = 0
    }

    object WallDeleteCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 0
    }

    object WallEditRestrictions {
        const val POST_ID_MIN: Long = 0

        const val PUBLISH_DATE_MIN: Long = 0

        const val PLACE_ID_MIN: Long = 0

        const val POSTER_BKG_ID_MIN: Long = 0

        const val TOPIC_ID_MIN: Long = 0
    }

    object WallEditAdsStealthRestrictions {
        const val POST_ID_MIN: Long = 0

        const val PLACE_ID_MIN: Long = 0
    }

    object WallEditCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 0
    }

    object WallGetRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0
    }

    object WallGetExtendedRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0
    }

    object WallGetCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 0
    }

    object WallGetCommentExtendedRestrictions {
        const val COMMENT_ID_MIN: Long = 0
    }

    object WallGetCommentsRestrictions {
        const val POST_ID_MIN: Long = 0

        const val START_COMMENT_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val PREVIEW_LENGTH_MIN: Long = 0

        const val COMMENT_ID_MIN: Long = 0

        const val THREAD_ITEMS_COUNT_MIN: Long = 0

        const val THREAD_ITEMS_COUNT_MAX: Long = 10
    }

    object WallGetCommentsExtendedRestrictions {
        const val POST_ID_MIN: Long = 0

        const val START_COMMENT_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val PREVIEW_LENGTH_MIN: Long = 0

        const val COMMENT_ID_MIN: Long = 0

        const val THREAD_ITEMS_COUNT_MIN: Long = 0

        const val THREAD_ITEMS_COUNT_MAX: Long = 10
    }

    object WallGetRepostsRestrictions {
        const val POST_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object WallOpenCommentsRestrictions {
        const val POST_ID_MIN: Long = 0
    }

    object WallPinRestrictions {
        const val POST_ID_MIN: Long = 0
    }

    object WallPostRestrictions {
        const val PUBLISH_DATE_MIN: Long = 0

        const val PLACE_ID_MIN: Long = 0

        const val POST_ID_MIN: Long = 0

        const val TOPIC_ID_MIN: Long = 0
    }

    object WallPostAdsStealthRestrictions {
        const val PLACE_ID_MIN: Long = 0
    }

    object WallReportCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 0

        const val REASON_MIN: Long = 0
    }

    object WallReportPostRestrictions {
        const val POST_ID_MIN: Long = 0

        const val REASON_MIN: Long = 0
    }

    object WallRepostRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object WallRestoreRestrictions {
        const val POST_ID_MIN: Long = 0
    }

    object WallSearchRestrictions {
        const val QUERY_MAX_LENGTH: Int = 9000

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100

        const val OFFSET_MIN: Long = 0
    }

    object WallSearchExtendedRestrictions {
        const val QUERY_MAX_LENGTH: Int = 9000

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100

        const val OFFSET_MIN: Long = 0
    }

    object WallUnpinRestrictions {
        const val POST_ID_MIN: Long = 0
    }
}
