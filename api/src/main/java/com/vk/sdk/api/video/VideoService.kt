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
package com.vk.sdk.api.video

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.video.dto.VideoAddAlbumPrivacyDto
import com.vk.sdk.api.video.dto.VideoAddAlbumResponseDto
import com.vk.sdk.api.video.dto.VideoEditAlbumPrivacyDto
import com.vk.sdk.api.video.dto.VideoGetAlbumsByVideoExtendedResponseDto
import com.vk.sdk.api.video.dto.VideoGetAlbumsExtendedResponseDto
import com.vk.sdk.api.video.dto.VideoGetAlbumsResponseDto
import com.vk.sdk.api.video.dto.VideoGetCommentsExtendedResponseDto
import com.vk.sdk.api.video.dto.VideoGetCommentsExtendedSortDto
import com.vk.sdk.api.video.dto.VideoGetCommentsResponseDto
import com.vk.sdk.api.video.dto.VideoGetCommentsSortDto
import com.vk.sdk.api.video.dto.VideoGetLongPollServerResponseDto
import com.vk.sdk.api.video.dto.VideoGetResponseDto
import com.vk.sdk.api.video.dto.VideoGetSortAlbumDto
import com.vk.sdk.api.video.dto.VideoLiveCategoryDto
import com.vk.sdk.api.video.dto.VideoReportCommentReasonDto
import com.vk.sdk.api.video.dto.VideoReportReasonDto
import com.vk.sdk.api.video.dto.VideoSaveResultDto
import com.vk.sdk.api.video.dto.VideoSearchExtendedFiltersDto
import com.vk.sdk.api.video.dto.VideoSearchExtendedResponseDto
import com.vk.sdk.api.video.dto.VideoSearchExtendedSortDto
import com.vk.sdk.api.video.dto.VideoSearchFiltersDto
import com.vk.sdk.api.video.dto.VideoSearchResponseDto
import com.vk.sdk.api.video.dto.VideoSearchSortDto
import com.vk.sdk.api.video.dto.VideoStartStreamingResponseDto
import com.vk.sdk.api.video.dto.VideoStopStreamingResponseDto
import com.vk.sdk.api.video.dto.VideoVideoAlbumFullDto
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class VideoService {
    /**
     * Adds a video to a user or community page.
     *
     * @param videoId - Video ID.
     * @param ownerId - ID of the user or community that owns the video. Use a negative value to
     * designate a community ID.
     * @param targetId - identifier of a user or community to add a video to. Use a negative value
     * to designate a community ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoAdd(
        videoId: Int,
        ownerId: UserId,
        targetId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.add") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("video_id", videoId, min = 0)
        addParam("owner_id", ownerId)
        targetId?.let { addParam("target_id", it) }
    }

    /**
     * Creates an empty album for videos.
     *
     * @param groupId - Community ID (if the album will be created in a community).
     * @param title - Album title.
     * @param privacy - new access permissions for the album. Possible values_ , *'0' - all users,,
     * *'1' - friends only,, *'2' - friends and friends of friends,, *'3' - "only me".
     * @return [VKRequest] with [VideoAddAlbumResponseDto]
     */
    fun videoAddAlbum(
        groupId: UserId? = null,
        title: String? = null,
        privacy: List<VideoAddAlbumPrivacyDto>? = null
    ): VKRequest<VideoAddAlbumResponseDto> = NewApiRequest("video.addAlbum") {
        GsonHolder.gson.parse<VideoAddAlbumResponseDto>(it)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 1) }
        title?.let { addParam("title", it) }
        val privacyJsonConverted = privacy?.map {
            it.value
        }
        privacyJsonConverted?.let { addParam("privacy", it) }
    }

    /**
     * @param ownerId
     * @param videoId
     * @param targetId
     * @param albumId
     * @param albumIds
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoAddToAlbum(
        ownerId: UserId,
        videoId: Int,
        targetId: UserId? = null,
        albumId: Int? = null,
        albumIds: List<Int>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.addToAlbum") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId, min = 0)
        targetId?.let { addParam("target_id", it) }
        albumId?.let { addParam("album_id", it) }
        albumIds?.let { addParam("album_ids", it) }
    }

    /**
     * Adds a new comment on a video.
     *
     * @param videoId - Video ID.
     * @param ownerId - ID of the user or community that owns the video.
     * @param message - New comment text.
     * @param attachments - List of objects attached to the comment, in the following format_
     * "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media attachment_ 'photo' - photo,
     * 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' - ID of the media attachment
     * owner. '<media_id>' - Media attachment ID. Example_ "photo100172_166443618,photo66748_265827614"
     * @param fromGroup - '1' - to post the comment from a community name (only if 'owner_id'<0)
     * @param replyToComment
     * @param stickerId
     * @param guid
     * @param trackCode
     * @return [VKRequest] with [Int]
     */
    fun videoCreateComment(
        videoId: Int,
        ownerId: UserId? = null,
        message: String? = null,
        attachments: List<String>? = null,
        fromGroup: Boolean? = null,
        replyToComment: Int? = null,
        stickerId: Int? = null,
        guid: String? = null,
        trackCode: String? = null
    ): VKRequest<Int> = NewApiRequest("video.createComment") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        addParam("video_id", videoId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
        fromGroup?.let { addParam("from_group", it) }
        replyToComment?.let { addParam("reply_to_comment", it, min = 0) }
        stickerId?.let { addParam("sticker_id", it, min = 0) }
        guid?.let { addParam("guid", it) }
        trackCode?.let { addParam("track_code", it) }
    }

    /**
     * Deletes a video from a user or community page.
     *
     * @param videoId - Video ID.
     * @param ownerId - ID of the user or community that owns the video.
     * @param targetId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoDelete(
        videoId: Int,
        ownerId: UserId? = null,
        targetId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.delete") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("video_id", videoId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        targetId?.let { addParam("target_id", it) }
    }

    /**
     * Deletes a video album.
     *
     * @param albumId - Album ID.
     * @param groupId - Community ID (if the album is owned by a community).
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoDeleteAlbum(albumId: Int, groupId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("video.deleteAlbum") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("album_id", albumId, min = 0)
        groupId?.let { addParam("group_id", it, min = 1) }
    }

    /**
     * Deletes a comment on a video.
     *
     * @param commentId - ID of the comment to be deleted.
     * @param ownerId - ID of the user or community that owns the video.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoDeleteComment(commentId: Int, ownerId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("video.deleteComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("comment_id", commentId)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Edits information about a video on a user or community page.
     *
     * @param videoId - Video ID.
     * @param ownerId - ID of the user or community that owns the video.
     * @param name - New video title.
     * @param desc - New video description.
     * @param privacyView - Privacy settings in a [vk.com/dev/privacy_setting|special format].
     * Privacy setting is available for videos uploaded to own profile by user.
     * @param privacyComment - Privacy settings for comments in a
     * [vk.com/dev/privacy_setting|special format].
     * @param noComments - Disable comments for the group video.
     * @param repeat - '1' - to repeat the playback of the video, '0' - to play the video once,
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoEdit(
        videoId: Int,
        ownerId: UserId? = null,
        name: String? = null,
        desc: String? = null,
        privacyView: List<String>? = null,
        privacyComment: List<String>? = null,
        noComments: Boolean? = null,
        repeat: Boolean? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.edit") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("video_id", videoId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        name?.let { addParam("name", it) }
        desc?.let { addParam("desc", it) }
        privacyView?.let { addParam("privacy_view", it) }
        privacyComment?.let { addParam("privacy_comment", it) }
        noComments?.let { addParam("no_comments", it) }
        repeat?.let { addParam("repeat", it) }
    }

    /**
     * Edits the title of a video album.
     *
     * @param albumId - Album ID.
     * @param groupId - Community ID (if the album edited is owned by a community).
     * @param title - New album title.
     * @param privacy - new access permissions for the album. Possible values_ , *'0' - all users,,
     * *'1' - friends only,, *'2' - friends and friends of friends,, *'3' - "only me".
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoEditAlbum(
        albumId: Int,
        groupId: UserId? = null,
        title: String? = null,
        privacy: List<VideoEditAlbumPrivacyDto>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.editAlbum") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("album_id", albumId, min = 0)
        groupId?.let { addParam("group_id", it, min = 1) }
        title?.let { addParam("title", it) }
        val privacyJsonConverted = privacy?.map {
            it.value
        }
        privacyJsonConverted?.let { addParam("privacy", it) }
    }

    /**
     * Edits the text of a comment on a video.
     *
     * @param commentId - Comment ID.
     * @param ownerId - ID of the user or community that owns the video.
     * @param message - New comment text.
     * @param attachments - List of objects attached to the comment, in the following format_
     * "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media attachment_ 'photo' - photo,
     * 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' - ID of the media attachment
     * owner. '<media_id>' - Media attachment ID. Example_ "photo100172_166443618,photo66748_265827614"
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoEditComment(
        commentId: Int,
        ownerId: UserId? = null,
        message: String? = null,
        attachments: List<String>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.editComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("comment_id", commentId)
        ownerId?.let { addParam("owner_id", it) }
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
    }

    /**
     * Returns detailed information about videos.
     *
     * @param ownerId - ID of the user or community that owns the video(s).
     * @param videos - Video IDs, in the following format_
     * "<owner_id>_<media_id>,<owner_id>_<media_id>", Use a negative value to designate a community ID.
     * Example_ "-4363_136089719,13245770_137352259"
     * @param albumId - ID of the album containing the video(s).
     * @param count - Number of videos to return.
     * @param offset - Offset needed to return a specific subset of videos.
     * @param extended - '1' - to return an extended response with additional fields
     * @param fields
     * @param sortAlbum - Sort order_ '0' - newest video first, '1' - oldest video first
     * @return [VKRequest] with [VideoGetResponseDto]
     */
    fun videoGet(
        ownerId: UserId? = null,
        videos: List<String>? = null,
        albumId: Int? = null,
        count: Int? = null,
        offset: Int? = null,
        extended: Boolean? = null,
        fields: List<String>? = null,
        sortAlbum: VideoGetSortAlbumDto? = null
    ): VKRequest<VideoGetResponseDto> = NewApiRequest("video.get") {
        GsonHolder.gson.parse<VideoGetResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        videos?.let { addParam("videos", it) }
        albumId?.let { addParam("album_id", it) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        offset?.let { addParam("offset", it, min = 0) }
        extended?.let { addParam("extended", it) }
        fields?.let { addParam("fields", it) }
        sortAlbum?.let { addParam("sort_album", it.value) }
    }

    /**
     * Returns video album info
     *
     * @param albumId - Album ID.
     * @param ownerId - identifier of a user or community to add a video to. Use a negative value to
     * designate a community ID.
     * @return [VKRequest] with [VideoVideoAlbumFullDto]
     */
    fun videoGetAlbumById(albumId: Int, ownerId: UserId? = null): VKRequest<VideoVideoAlbumFullDto>
            = NewApiRequest("video.getAlbumById") {
        GsonHolder.gson.parse<VideoVideoAlbumFullDto>(it)
    }
    .apply {
        addParam("album_id", albumId)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Returns a list of video albums owned by a user or community.
     *
     * @param ownerId - ID of the user or community that owns the video album(s).
     * @param offset - Offset needed to return a specific subset of video albums.
     * @param count - Number of video albums to return.
     * @param extended - '1' - to return additional information about album privacy settings for the
     * current user
     * @param needSystem
     * @return [VKRequest] with [VideoGetAlbumsResponseDto]
     */
    fun videoGetAlbums(
        ownerId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        extended: Boolean? = null,
        needSystem: Boolean? = null
    ): VKRequest<VideoGetAlbumsResponseDto> = NewApiRequest("video.getAlbums") {
        GsonHolder.gson.parse<VideoGetAlbumsResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        extended?.let { addParam("extended", it) }
        needSystem?.let { addParam("need_system", it) }
    }

    /**
     * Returns a list of video albums owned by a user or community.
     *
     * @param ownerId - ID of the user or community that owns the video album(s).
     * @param offset - Offset needed to return a specific subset of video albums.
     * @param count - Number of video albums to return.
     * @param needSystem
     * @return [VKRequest] with [VideoGetAlbumsExtendedResponseDto]
     */
    fun videoGetAlbumsExtended(
        ownerId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        needSystem: Boolean? = null
    ): VKRequest<VideoGetAlbumsExtendedResponseDto> = NewApiRequest("video.getAlbums") {
        GsonHolder.gson.parse<VideoGetAlbumsExtendedResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        addParam("extended", true)
        needSystem?.let { addParam("need_system", it) }
    }

    /**
     * @param ownerId
     * @param videoId
     * @param targetId
     * @param extended
     * @return [VKRequest] with [Unit]
     */
    fun videoGetAlbumsByVideo(
        ownerId: UserId,
        videoId: Int,
        targetId: UserId? = null,
        extended: Boolean? = null
    ): VKRequest<List<Int>> = NewApiRequest("video.getAlbumsByVideo") {
        GsonHolder.gson.parseList<Int>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId, min = 0)
        targetId?.let { addParam("target_id", it) }
        extended?.let { addParam("extended", it) }
    }

    /**
     * @param ownerId
     * @param videoId
     * @param targetId
     * @return [VKRequest] with [VideoGetAlbumsByVideoExtendedResponseDto]
     */
    fun videoGetAlbumsByVideoExtended(
        ownerId: UserId,
        videoId: Int,
        targetId: UserId? = null
    ): VKRequest<VideoGetAlbumsByVideoExtendedResponseDto> =
            NewApiRequest("video.getAlbumsByVideo") {
        GsonHolder.gson.parse<VideoGetAlbumsByVideoExtendedResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId, min = 0)
        targetId?.let { addParam("target_id", it) }
        addParam("extended", true)
    }

    /**
     * Returns a list of comments on a video.
     *
     * @param videoId - Video ID.
     * @param ownerId - ID of the user or community that owns the video.
     * @param needLikes - '1' - to return an additional 'likes' field
     * @param startCommentId
     * @param offset - Offset needed to return a specific subset of comments.
     * @param count - Number of comments to return.
     * @param sort - Sort order_ 'asc' - oldest comment first, 'desc' - newest comment first
     * @param extended
     * @param fields
     * @return [VKRequest] with [VideoGetCommentsResponseDto]
     */
    fun videoGetComments(
        videoId: Int,
        ownerId: UserId? = null,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: VideoGetCommentsSortDto? = null,
        extended: Boolean? = null,
        fields: List<String>? = null
    ): VKRequest<VideoGetCommentsResponseDto> = NewApiRequest("video.getComments") {
        GsonHolder.gson.parse<VideoGetCommentsResponseDto>(it)
    }
    .apply {
        addParam("video_id", videoId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it, min = 0) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        sort?.let { addParam("sort", it.value) }
        extended?.let { addParam("extended", it) }
        fields?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of comments on a video.
     *
     * @param videoId - Video ID.
     * @param ownerId - ID of the user or community that owns the video.
     * @param needLikes - '1' - to return an additional 'likes' field
     * @param startCommentId
     * @param offset - Offset needed to return a specific subset of comments.
     * @param count - Number of comments to return.
     * @param sort - Sort order_ 'asc' - oldest comment first, 'desc' - newest comment first
     * @param fields
     * @return [VKRequest] with [VideoGetCommentsExtendedResponseDto]
     */
    fun videoGetCommentsExtended(
        videoId: Int,
        ownerId: UserId? = null,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: VideoGetCommentsExtendedSortDto? = null,
        fields: List<String>? = null
    ): VKRequest<VideoGetCommentsExtendedResponseDto> = NewApiRequest("video.getComments") {
        GsonHolder.gson.parse<VideoGetCommentsExtendedResponseDto>(it)
    }
    .apply {
        addParam("video_id", videoId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it, min = 0) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        sort?.let { addParam("sort", it.value) }
        addParam("extended", true)
        fields?.let { addParam("fields", it) }
    }

    /**
     * @param videoId
     * @param ownerId
     * @return [VKRequest] with [VideoGetLongPollServerResponseDto]
     */
    fun videoGetLongPollServer(videoId: Int, ownerId: UserId? = null):
            VKRequest<VideoGetLongPollServerResponseDto> =
            NewApiRequest("video.getLongPollServer") {
        GsonHolder.gson.parse<VideoGetLongPollServerResponseDto>(it)
    }
    .apply {
        addParam("video_id", videoId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * @return [VKRequest] with [Unit]
     */
    fun videoLiveGetCategories(): VKRequest<List<VideoLiveCategoryDto>> =
            NewApiRequest("video.liveGetCategories") {
        GsonHolder.gson.parseList<VideoLiveCategoryDto>(it)
    }

    /**
     * @param ownerId
     * @param videoId
     * @param targetId
     * @param albumId
     * @param albumIds
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoRemoveFromAlbum(
        ownerId: UserId,
        videoId: Int,
        targetId: UserId? = null,
        albumId: Int? = null,
        albumIds: List<Int>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.removeFromAlbum") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId, min = 0)
        targetId?.let { addParam("target_id", it) }
        albumId?.let { addParam("album_id", it) }
        albumIds?.let { addParam("album_ids", it) }
    }

    /**
     * Reorders the album in the list of user video albums.
     *
     * @param albumId - Album ID.
     * @param ownerId - ID of the user or community that owns the albums..
     * @param before - ID of the album before which the album in question shall be placed.
     * @param after - ID of the album after which the album in question shall be placed.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoReorderAlbums(
        albumId: Int,
        ownerId: UserId? = null,
        before: Int? = null,
        after: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.reorderAlbums") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("album_id", albumId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        before?.let { addParam("before", it, min = 0) }
        after?.let { addParam("after", it, min = 0) }
    }

    /**
     * Reorders the video in the video album.
     *
     * @param ownerId - ID of the user or community that owns the video.
     * @param videoId - ID of the video.
     * @param targetId - ID of the user or community that owns the album with videos.
     * @param albumId - ID of the video album.
     * @param beforeOwnerId - ID of the user or community that owns the video before which the video
     * in question shall be placed.
     * @param beforeVideoId - ID of the video before which the video in question shall be placed.
     * @param afterOwnerId - ID of the user or community that owns the video after which the photo
     * in question shall be placed.
     * @param afterVideoId - ID of the video after which the photo in question shall be placed.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoReorderVideos(
        ownerId: UserId,
        videoId: Int,
        targetId: UserId? = null,
        albumId: Int? = null,
        beforeOwnerId: UserId? = null,
        beforeVideoId: Int? = null,
        afterOwnerId: UserId? = null,
        afterVideoId: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.reorderVideos") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId, min = 0)
        targetId?.let { addParam("target_id", it) }
        albumId?.let { addParam("album_id", it) }
        beforeOwnerId?.let { addParam("before_owner_id", it) }
        beforeVideoId?.let { addParam("before_video_id", it, min = 0) }
        afterOwnerId?.let { addParam("after_owner_id", it) }
        afterVideoId?.let { addParam("after_video_id", it, min = 0) }
    }

    /**
     * Reports (submits a complaint about) a video.
     *
     * @param ownerId - ID of the user or community that owns the video.
     * @param videoId - Video ID.
     * @param reason - Reason for the complaint_ '0' - spam, '1' - child pornography, '2' -
     * extremism, '3' - violence, '4' - drug propaganda, '5' - adult material, '6' - insult, abuse
     * @param comment - Comment describing the complaint.
     * @param searchQuery - (If the video was found in search results.) Search query string.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoReport(
        ownerId: UserId,
        videoId: Int,
        reason: VideoReportReasonDto? = null,
        comment: String? = null,
        searchQuery: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.report") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId, min = 0)
        reason?.let { addParam("reason", it.value) }
        comment?.let { addParam("comment", it) }
        searchQuery?.let { addParam("search_query", it) }
    }

    /**
     * Reports (submits a complaint about) a comment on a video.
     *
     * @param ownerId - ID of the user or community that owns the video.
     * @param commentId - ID of the comment being reported.
     * @param reason - Reason for the complaint_ , 0 - spam , 1 - child pornography , 2 - extremism
     * , 3 - violence , 4 - drug propaganda , 5 - adult material , 6 - insult, abuse
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoReportComment(
        ownerId: UserId,
        commentId: Int,
        reason: VideoReportCommentReasonDto? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("video.reportComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("comment_id", commentId, min = 0)
        reason?.let { addParam("reason", it.value) }
    }

    /**
     * Restores a previously deleted video.
     *
     * @param videoId - Video ID.
     * @param ownerId - ID of the user or community that owns the video.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoRestore(videoId: Int, ownerId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("video.restore") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("video_id", videoId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Restores a previously deleted comment on a video.
     *
     * @param commentId - ID of the deleted comment.
     * @param ownerId - ID of the user or community that owns the video.
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun videoRestoreComment(commentId: Int, ownerId: UserId? = null): VKRequest<BaseBoolIntDto> =
            NewApiRequest("video.restoreComment") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("comment_id", commentId)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Returns a server address (required for upload) and video data.
     *
     * @param name - Name of the video.
     * @param description - Description of the video.
     * @param isPrivate - '1' - to designate the video as private (send it via a private message),
     * the video will not appear on the user's video list and will not be available by ID for other
     * users, '0' - not to designate the video as private
     * @param wallpost - '1' - to post the saved video on a user's wall, '0' - not to post the saved
     * video on a user's wall
     * @param link - URL for embedding the video from an external website.
     * @param groupId - ID of the community in which the video will be saved. By default, the
     * current user's page.
     * @param albumId - ID of the album to which the saved video will be added.
     * @param privacyView
     * @param privacyComment
     * @param noComments
     * @param repeat - '1' - to repeat the playback of the video, '0' - to play the video once,
     * @param compression
     * @return [VKRequest] with [VideoSaveResultDto]
     */
    fun videoSave(
        name: String? = null,
        description: String? = null,
        isPrivate: Boolean? = null,
        wallpost: Boolean? = null,
        link: String? = null,
        groupId: UserId? = null,
        albumId: Int? = null,
        privacyView: List<String>? = null,
        privacyComment: List<String>? = null,
        noComments: Boolean? = null,
        repeat: Boolean? = null,
        compression: Boolean? = null
    ): VKRequest<VideoSaveResultDto> = NewApiRequest("video.save") {
        GsonHolder.gson.parse<VideoSaveResultDto>(it)
    }
    .apply {
        name?.let { addParam("name", it) }
        description?.let { addParam("description", it) }
        isPrivate?.let { addParam("is_private", it) }
        wallpost?.let { addParam("wallpost", it) }
        link?.let { addParam("link", it) }
        groupId?.let { addParam("group_id", it, min = 1) }
        albumId?.let { addParam("album_id", it, min = 0) }
        privacyView?.let { addParam("privacy_view", it) }
        privacyComment?.let { addParam("privacy_comment", it) }
        noComments?.let { addParam("no_comments", it) }
        repeat?.let { addParam("repeat", it) }
        compression?.let { addParam("compression", it) }
    }

    /**
     * Returns a list of videos under the set search criterion.
     *
     * @param q - Search query string (e.g., 'The Beatles').
     * @param sort - Sort order_ '1' - by duration, '2' - by relevance, '0' - by date added
     * @param hd - If not null, only searches for high-definition videos.
     * @param adult - '1' - to disable the Safe Search filter, '0' - to enable the Safe Search
     * filter
     * @param live
     * @param filters - Filters to apply_ 'youtube' - return YouTube videos only, 'vimeo' - return
     * Vimeo videos only, 'short' - return short videos only, 'long' - return long videos only
     * @param searchOwn
     * @param offset - Offset needed to return a specific subset of videos.
     * @param longer
     * @param shorter
     * @param count - Number of videos to return.
     * @param extended
     * @param fields
     * @return [VKRequest] with [VideoSearchResponseDto]
     */
    fun videoSearch(
        q: String? = null,
        sort: VideoSearchSortDto? = null,
        hd: Int? = null,
        adult: Boolean? = null,
        live: Boolean? = null,
        filters: List<VideoSearchFiltersDto>? = null,
        searchOwn: Boolean? = null,
        offset: Int? = null,
        longer: Int? = null,
        shorter: Int? = null,
        count: Int? = null,
        extended: Boolean? = null,
        fields: List<String>? = null
    ): VKRequest<VideoSearchResponseDto> = NewApiRequest("video.search") {
        GsonHolder.gson.parse<VideoSearchResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it) }
        sort?.let { addParam("sort", it.value) }
        hd?.let { addParam("hd", it) }
        adult?.let { addParam("adult", it) }
        live?.let { addParam("live", it) }
        val filtersJsonConverted = filters?.map {
            it.value
        }
        filtersJsonConverted?.let { addParam("filters", it) }
        searchOwn?.let { addParam("search_own", it) }
        offset?.let { addParam("offset", it, min = 0) }
        longer?.let { addParam("longer", it, min = 0) }
        shorter?.let { addParam("shorter", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        extended?.let { addParam("extended", it) }
        fields?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of videos under the set search criterion.
     *
     * @param q - Search query string (e.g., 'The Beatles').
     * @param sort - Sort order_ '1' - by duration, '2' - by relevance, '0' - by date added
     * @param hd - If not null, only searches for high-definition videos.
     * @param adult - '1' - to disable the Safe Search filter, '0' - to enable the Safe Search
     * filter
     * @param live
     * @param filters - Filters to apply_ 'youtube' - return YouTube videos only, 'vimeo' - return
     * Vimeo videos only, 'short' - return short videos only, 'long' - return long videos only
     * @param searchOwn
     * @param offset - Offset needed to return a specific subset of videos.
     * @param longer
     * @param shorter
     * @param count - Number of videos to return.
     * @param fields
     * @return [VKRequest] with [VideoSearchExtendedResponseDto]
     */
    fun videoSearchExtended(
        q: String? = null,
        sort: VideoSearchExtendedSortDto? = null,
        hd: Int? = null,
        adult: Boolean? = null,
        live: Boolean? = null,
        filters: List<VideoSearchExtendedFiltersDto>? = null,
        searchOwn: Boolean? = null,
        offset: Int? = null,
        longer: Int? = null,
        shorter: Int? = null,
        count: Int? = null,
        fields: List<String>? = null
    ): VKRequest<VideoSearchExtendedResponseDto> = NewApiRequest("video.search") {
        GsonHolder.gson.parse<VideoSearchExtendedResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it) }
        sort?.let { addParam("sort", it.value) }
        hd?.let { addParam("hd", it) }
        adult?.let { addParam("adult", it) }
        live?.let { addParam("live", it) }
        val filtersJsonConverted = filters?.map {
            it.value
        }
        filtersJsonConverted?.let { addParam("filters", it) }
        searchOwn?.let { addParam("search_own", it) }
        offset?.let { addParam("offset", it, min = 0) }
        longer?.let { addParam("longer", it, min = 0) }
        shorter?.let { addParam("shorter", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        addParam("extended", true)
        fields?.let { addParam("fields", it) }
    }

    /**
     * @param videoId
     * @param name
     * @param description
     * @param wallpost
     * @param groupId
     * @param privacyView
     * @param privacyComment
     * @param noComments
     * @param categoryId
     * @param publish
     * @return [VKRequest] with [VideoStartStreamingResponseDto]
     */
    fun videoStartStreaming(
        videoId: Int? = null,
        name: String? = null,
        description: String? = null,
        wallpost: Boolean? = null,
        groupId: UserId? = null,
        privacyView: List<String>? = null,
        privacyComment: List<String>? = null,
        noComments: Boolean? = null,
        categoryId: Int? = null,
        publish: Boolean? = null
    ): VKRequest<VideoStartStreamingResponseDto> = NewApiRequest("video.startStreaming") {
        GsonHolder.gson.parse<VideoStartStreamingResponseDto>(it)
    }
    .apply {
        videoId?.let { addParam("video_id", it, min = 0) }
        name?.let { addParam("name", it) }
        description?.let { addParam("description", it) }
        wallpost?.let { addParam("wallpost", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        privacyView?.let { addParam("privacy_view", it) }
        privacyComment?.let { addParam("privacy_comment", it) }
        noComments?.let { addParam("no_comments", it) }
        categoryId?.let { addParam("category_id", it, min = 0) }
        publish?.let { addParam("publish", it) }
    }

    /**
     * @param groupId
     * @param videoId
     * @return [VKRequest] with [VideoStopStreamingResponseDto]
     */
    fun videoStopStreaming(groupId: UserId? = null, videoId: Int? = null):
            VKRequest<VideoStopStreamingResponseDto> = NewApiRequest("video.stopStreaming") {
        GsonHolder.gson.parse<VideoStopStreamingResponseDto>(it)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 1) }
        videoId?.let { addParam("video_id", it, min = 0) }
    }

    /**
     * Unpin comment of a video.
     *
     * @param ownerId - ID of the user or community that owns the video.
     * @param commentId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun videoUnpinComment(ownerId: UserId, commentId: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("video.unpinComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("comment_id", commentId, min = 1)
    }

    object VideoAddRestrictions {
        const val VIDEO_ID_MIN: Long = 0
    }

    object VideoAddAlbumRestrictions {
        const val GROUP_ID_MIN: Long = 1
    }

    object VideoAddToAlbumRestrictions {
        const val VIDEO_ID_MIN: Long = 0
    }

    object VideoCreateCommentRestrictions {
        const val VIDEO_ID_MIN: Long = 0

        const val REPLY_TO_COMMENT_MIN: Long = 0

        const val STICKER_ID_MIN: Long = 0
    }

    object VideoDeleteRestrictions {
        const val VIDEO_ID_MIN: Long = 0
    }

    object VideoDeleteAlbumRestrictions {
        const val ALBUM_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 1
    }

    object VideoEditRestrictions {
        const val VIDEO_ID_MIN: Long = 0
    }

    object VideoEditAlbumRestrictions {
        const val ALBUM_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 1
    }

    object VideoGetRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200

        const val OFFSET_MIN: Long = 0
    }

    object VideoGetAlbumsRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object VideoGetAlbumsExtendedRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object VideoGetAlbumsByVideoRestrictions {
        const val VIDEO_ID_MIN: Long = 0
    }

    object VideoGetAlbumsByVideoExtendedRestrictions {
        const val VIDEO_ID_MIN: Long = 0
    }

    object VideoGetCommentsRestrictions {
        const val VIDEO_ID_MIN: Long = 0

        const val START_COMMENT_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object VideoGetCommentsExtendedRestrictions {
        const val VIDEO_ID_MIN: Long = 0

        const val START_COMMENT_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object VideoGetLongPollServerRestrictions {
        const val VIDEO_ID_MIN: Long = 0
    }

    object VideoRemoveFromAlbumRestrictions {
        const val VIDEO_ID_MIN: Long = 0
    }

    object VideoReorderAlbumsRestrictions {
        const val ALBUM_ID_MIN: Long = 0

        const val BEFORE_MIN: Long = 0

        const val AFTER_MIN: Long = 0
    }

    object VideoReorderVideosRestrictions {
        const val VIDEO_ID_MIN: Long = 0

        const val BEFORE_VIDEO_ID_MIN: Long = 0

        const val AFTER_VIDEO_ID_MIN: Long = 0
    }

    object VideoReportRestrictions {
        const val VIDEO_ID_MIN: Long = 0

        const val REASON_MIN: Long = 0
    }

    object VideoReportCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 0

        const val REASON_MIN: Long = 0
    }

    object VideoRestoreRestrictions {
        const val VIDEO_ID_MIN: Long = 0
    }

    object VideoSaveRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val ALBUM_ID_MIN: Long = 0
    }

    object VideoSearchRestrictions {
        const val OFFSET_MIN: Long = 0

        const val LONGER_MIN: Long = 0

        const val SHORTER_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200
    }

    object VideoSearchExtendedRestrictions {
        const val OFFSET_MIN: Long = 0

        const val LONGER_MIN: Long = 0

        const val SHORTER_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200
    }

    object VideoStartStreamingRestrictions {
        const val VIDEO_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0

        const val CATEGORY_ID_MIN: Long = 0
    }

    object VideoStopStreamingRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val VIDEO_ID_MIN: Long = 0
    }

    object VideoUnpinCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 1
    }
}
