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
package com.vk.sdk.api.board

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.board.dto.BoardGetCommentsExtendedResponse
import com.vk.sdk.api.board.dto.BoardGetCommentsExtendedSort
import com.vk.sdk.api.board.dto.BoardGetCommentsResponse
import com.vk.sdk.api.board.dto.BoardGetCommentsSort
import com.vk.sdk.api.board.dto.BoardGetTopicsExtendedOrder
import com.vk.sdk.api.board.dto.BoardGetTopicsExtendedPreview
import com.vk.sdk.api.board.dto.BoardGetTopicsExtendedResponse
import com.vk.sdk.api.board.dto.BoardGetTopicsOrder
import com.vk.sdk.api.board.dto.BoardGetTopicsPreview
import com.vk.sdk.api.board.dto.BoardGetTopicsResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class BoardService {
    /**
     * Creates a new topic on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param title - Topic title.
     * @param text - Text of the topic.
     * @param fromGroup - For a community_ '1' - to post the topic as by the community, '0' - to
     * post the topic as by the user (default)
     * @param attachments - List of media objects attached to the topic, in the following format_
     * "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media object_ 'photo' - photo,
     * 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' - ID of the media owner.
     * '<media_id>' - Media ID. Example_ "photo100172_166443618,photo66748_265827614", , "NOTE_ If you
     * try to attach more than one reference, an error will be thrown.",
     * @return [VKRequest] with [Int]
     */
    fun boardAddTopic(
        groupId: UserId,
        title: String,
        text: String? = null,
        fromGroup: Boolean? = null,
        attachments: List<String>? = null
    ): VKRequest<Int> = NewApiRequest("board.addTopic") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("title", title)
        text?.let { addParam("text", it) }
        fromGroup?.let { addParam("from_group", it) }
        attachments?.let { addParam("attachments", it) }
    }

    /**
     * Closes a topic on a community's discussion board so that comments cannot be posted.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun boardCloseTopic(groupId: Int, topicId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("board.closeTopic") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 0)
        addParam("topic_id", topicId, min = 0)
    }

    /**
     * Adds a comment on a topic on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - ID of the topic to be commented on.
     * @param message - (Required if 'attachments' is not set.) Text of the comment.
     * @param attachments - (Required if 'text' is not set.) List of media objects attached to the
     * comment, in the following format_ "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of
     * media object_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document,
     * '<owner_id>' - ID of the media owner. '<media_id>' - Media ID.
     * @param fromGroup - '1' - to post the comment as by the community, '0' - to post the comment
     * as by the user (default)
     * @param stickerId - Sticker ID.
     * @param guid - Unique identifier to avoid repeated comments.
     * @return [VKRequest] with [Int]
     */
    fun boardCreateComment(
        groupId: UserId,
        topicId: Int,
        message: String? = null,
        attachments: List<String>? = null,
        fromGroup: Boolean? = null,
        stickerId: Int? = null,
        guid: String? = null
    ): VKRequest<Int> = NewApiRequest("board.createComment") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("topic_id", topicId, min = 0)
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
        fromGroup?.let { addParam("from_group", it) }
        stickerId?.let { addParam("sticker_id", it, min = 0) }
        guid?.let { addParam("guid", it) }
    }

    /**
     * Deletes a comment on a topic on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @param commentId - Comment ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun boardDeleteComment(
        groupId: UserId,
        topicId: Int,
        commentId: Int
    ): VKRequest<BaseOkResponse> = NewApiRequest("board.deleteComment") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("topic_id", topicId, min = 1)
        addParam("comment_id", commentId, min = 1)
    }

    /**
     * Deletes a topic from a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun boardDeleteTopic(groupId: UserId, topicId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("board.deleteTopic") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("topic_id", topicId, min = 0)
    }

    /**
     * Edits a comment on a topic on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @param commentId - ID of the comment on the topic.
     * @param message - (Required if 'attachments' is not set). New comment text.
     * @param attachments - (Required if 'message' is not set.) List of media objects attached to
     * the comment, in the following format_ "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type
     * of media object_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document,
     * '<owner_id>' - ID of the media owner. '<media_id>' - Media ID. Example_
     * "photo100172_166443618,photo66748_265827614"
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun boardEditComment(
        groupId: UserId,
        topicId: Int,
        commentId: Int,
        message: String? = null,
        attachments: List<String>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("board.editComment") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("topic_id", topicId, min = 0)
        addParam("comment_id", commentId, min = 0)
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
    }

    /**
     * Edits the title of a topic on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @param title - New title of the topic.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun boardEditTopic(
        groupId: UserId,
        topicId: Int,
        title: String
    ): VKRequest<BaseOkResponse> = NewApiRequest("board.editTopic") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("topic_id", topicId, min = 0)
        addParam("title", title)
    }

    /**
     * Pins a topic (fixes its place) to the top of a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun boardFixTopic(groupId: Int, topicId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("board.fixTopic") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 0)
        addParam("topic_id", topicId, min = 0)
    }

    /**
     * Returns a list of comments on a topic on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @param needLikes - '1' - to return the 'likes' field, '0' - not to return the 'likes' field
     * (default)
     * @param startCommentId
     * @param offset - Offset needed to return a specific subset of comments.
     * @param count - Number of comments to return.
     * @param sort - Sort order_ 'asc' - by creation date in chronological order, 'desc' - by
     * creation date in reverse chronological order,
     * @return [VKRequest] with [BoardGetCommentsResponse]
     */
    fun boardGetComments(
        groupId: UserId,
        topicId: Int,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: BoardGetCommentsSort? = null
    ): VKRequest<BoardGetCommentsResponse> = NewApiRequest("board.getComments") {
        GsonHolder.gson.fromJson(it, BoardGetCommentsResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("topic_id", topicId, min = 0)
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it, min = 0) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        sort?.let { addParam("sort", it.value) }
    }

    /**
     * Returns a list of comments on a topic on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @param needLikes - '1' - to return the 'likes' field, '0' - not to return the 'likes' field
     * (default)
     * @param startCommentId
     * @param offset - Offset needed to return a specific subset of comments.
     * @param count - Number of comments to return.
     * @param sort - Sort order_ 'asc' - by creation date in chronological order, 'desc' - by
     * creation date in reverse chronological order,
     * @return [VKRequest] with [BoardGetCommentsExtendedResponse]
     */
    fun boardGetCommentsExtended(
        groupId: UserId,
        topicId: Int,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: BoardGetCommentsExtendedSort? = null
    ): VKRequest<BoardGetCommentsExtendedResponse> = NewApiRequest("board.getComments") {
        GsonHolder.gson.fromJson(it, BoardGetCommentsExtendedResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("topic_id", topicId, min = 0)
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it, min = 0) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        addParam("extended", true)
        sort?.let { addParam("sort", it.value) }
    }

    /**
     * Returns a list of topics on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicIds - IDs of topics to be returned (100 maximum). By default, all topics are
     * returned. If this parameter is set, the 'order', 'offset', and 'count' parameters are ignored.
     * @param order - Sort order_ '1' - by date updated in reverse chronological order. '2' - by
     * date created in reverse chronological order. '-1' - by date updated in chronological order.
     * '-2' - by date created in chronological order. If no sort order is specified, topics are
     * returned in the order specified by the group administrator. Pinned topics are returned first,
     * regardless of the sorting.
     * @param offset - Offset needed to return a specific subset of topics.
     * @param count - Number of topics to return.
     * @param preview - '1' - to return the first comment in each topic,, '2' - to return the last
     * comment in each topic,, '0' - to return no comments. By default_ '0'.
     * @param previewLength - Number of characters after which to truncate the previewed comment. To
     * preview the full comment, specify '0'.
     * @return [VKRequest] with [BoardGetTopicsResponse]
     */
    fun boardGetTopics(
        groupId: UserId,
        topicIds: List<Int>? = null,
        order: BoardGetTopicsOrder? = null,
        offset: Int? = null,
        count: Int? = null,
        preview: BoardGetTopicsPreview? = null,
        previewLength: Int? = null
    ): VKRequest<BoardGetTopicsResponse> = NewApiRequest("board.getTopics") {
        GsonHolder.gson.fromJson(it, BoardGetTopicsResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        topicIds?.let { addParam("topic_ids", it) }
        order?.let { addParam("order", it.value) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        preview?.let { addParam("preview", it.value) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
    }

    /**
     * Returns a list of topics on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicIds - IDs of topics to be returned (100 maximum). By default, all topics are
     * returned. If this parameter is set, the 'order', 'offset', and 'count' parameters are ignored.
     * @param order - Sort order_ '1' - by date updated in reverse chronological order. '2' - by
     * date created in reverse chronological order. '-1' - by date updated in chronological order.
     * '-2' - by date created in chronological order. If no sort order is specified, topics are
     * returned in the order specified by the group administrator. Pinned topics are returned first,
     * regardless of the sorting.
     * @param offset - Offset needed to return a specific subset of topics.
     * @param count - Number of topics to return.
     * @param preview - '1' - to return the first comment in each topic,, '2' - to return the last
     * comment in each topic,, '0' - to return no comments. By default_ '0'.
     * @param previewLength - Number of characters after which to truncate the previewed comment. To
     * preview the full comment, specify '0'.
     * @return [VKRequest] with [BoardGetTopicsExtendedResponse]
     */
    fun boardGetTopicsExtended(
        groupId: UserId,
        topicIds: List<Int>? = null,
        order: BoardGetTopicsExtendedOrder? = null,
        offset: Int? = null,
        count: Int? = null,
        preview: BoardGetTopicsExtendedPreview? = null,
        previewLength: Int? = null
    ): VKRequest<BoardGetTopicsExtendedResponse> = NewApiRequest("board.getTopics") {
        GsonHolder.gson.fromJson(it, BoardGetTopicsExtendedResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        topicIds?.let { addParam("topic_ids", it) }
        order?.let { addParam("order", it.value) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        addParam("extended", true)
        preview?.let { addParam("preview", it.value) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
    }

    /**
     * Re-opens a previously closed topic on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun boardOpenTopic(groupId: Int, topicId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("board.openTopic") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 0)
        addParam("topic_id", topicId, min = 0)
    }

    /**
     * Restores a comment deleted from a topic on a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @param commentId - Comment ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun boardRestoreComment(
        groupId: UserId,
        topicId: Int,
        commentId: Int
    ): VKRequest<BaseOkResponse> = NewApiRequest("board.restoreComment") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("topic_id", topicId, min = 0)
        addParam("comment_id", commentId, min = 0)
    }

    /**
     * Unpins a pinned topic from the top of a community's discussion board.
     *
     * @param groupId - ID of the community that owns the discussion board.
     * @param topicId - Topic ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun boardUnfixTopic(groupId: Int, topicId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("board.unfixTopic") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 0)
        addParam("topic_id", topicId, min = 0)
    }
}
