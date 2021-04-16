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

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.video.dto.FiltersParam
import com.vk.sdk.api.video.dto.PrivacyParam
import com.vk.sdk.api.video.dto.ReasonParam
import com.vk.sdk.api.video.dto.SortParam
import com.vk.sdk.api.video.dto.VideoAddAlbumResponse
import com.vk.sdk.api.video.dto.VideoGetAlbumsByVideoExtendedResponse
import com.vk.sdk.api.video.dto.VideoGetAlbumsExtendedResponse
import com.vk.sdk.api.video.dto.VideoGetAlbumsResponse
import com.vk.sdk.api.video.dto.VideoGetCommentsExtendedResponse
import com.vk.sdk.api.video.dto.VideoGetCommentsResponse
import com.vk.sdk.api.video.dto.VideoGetResponse
import com.vk.sdk.api.video.dto.VideoSaveResult
import com.vk.sdk.api.video.dto.VideoSearchExtendedResponse
import com.vk.sdk.api.video.dto.VideoSearchResponse
import com.vk.sdk.api.video.dto.VideoVideoAlbumFull
import kotlin.Boolean
import kotlin.Int
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoAdd(
        videoId: Int,
        ownerId: Int,
        targetId: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.add") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("video_id", videoId)
        addParam("owner_id", ownerId)
        targetId?.let { addParam("target_id", it) }
    }

    /**
     * Creates an empty album for videos.
     *
     * @param groupId - Community ID (if the album will be created in a community).
     * @param title - Album title.
     * @param privacy - new access permissions for the album. Possible values: , *'0' - all users,,
     * *'1' - friends only,, *'2' - friends and friends of friends,, *'3' - "only me".
     * @return [VKRequest] with [VideoAddAlbumResponse]
     */
    fun videoAddAlbum(
        groupId: Int? = null,
        title: String? = null,
        privacy: List<PrivacyParam>? = null
    ): VKRequest<VideoAddAlbumResponse> = NewApiRequest("video.addAlbum") {
        GsonHolder.gson.fromJson(it, VideoAddAlbumResponse::class.java)
    }
    .apply {
        groupId?.let { addParam("group_id", it) }
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoAddToAlbum(
        ownerId: Int,
        videoId: Int,
        targetId: Int? = null,
        albumId: Int? = null,
        albumIds: List<Int>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.addToAlbum") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId)
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
     * @param attachments - List of objects attached to the comment, in the following format:
     * "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media attachment: 'photo' - photo,
     * 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' - ID of the media attachment
     * owner. '<media_id>' - Media attachment ID. Example: "photo100172_166443618,photo66748_265827614"
     * @param fromGroup - '1' - to post the comment from a community name (only if 'owner_id'<0)
     * @param replyToComment
     * @param stickerId
     * @param guid
     * @return [VKRequest] with [Int]
     */
    fun videoCreateComment(
        videoId: Int,
        ownerId: Int? = null,
        message: String? = null,
        attachments: List<String>? = null,
        fromGroup: Boolean? = null,
        replyToComment: Int? = null,
        stickerId: Int? = null,
        guid: String? = null
    ): VKRequest<Int> = NewApiRequest("video.createComment") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }
    .apply {
        addParam("video_id", videoId)
        ownerId?.let { addParam("owner_id", it) }
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
        fromGroup?.let { addParam("from_group", it) }
        replyToComment?.let { addParam("reply_to_comment", it) }
        stickerId?.let { addParam("sticker_id", it) }
        guid?.let { addParam("guid", it) }
    }

    /**
     * Deletes a video from a user or community page.
     *
     * @param videoId - Video ID.
     * @param ownerId - ID of the user or community that owns the video.
     * @param targetId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoDelete(
        videoId: Int,
        ownerId: Int? = null,
        targetId: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.delete") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("video_id", videoId)
        ownerId?.let { addParam("owner_id", it) }
        targetId?.let { addParam("target_id", it) }
    }

    /**
     * Deletes a video album.
     *
     * @param albumId - Album ID.
     * @param groupId - Community ID (if the album is owned by a community).
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoDeleteAlbum(albumId: Int, groupId: Int? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("video.deleteAlbum") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("album_id", albumId)
        groupId?.let { addParam("group_id", it) }
    }

    /**
     * Deletes a comment on a video.
     *
     * @param commentId - ID of the comment to be deleted.
     * @param ownerId - ID of the user or community that owns the video.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoDeleteComment(commentId: Int, ownerId: Int? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("video.deleteComment") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoEdit(
        videoId: Int,
        ownerId: Int? = null,
        name: String? = null,
        desc: String? = null,
        privacyView: List<String>? = null,
        privacyComment: List<String>? = null,
        noComments: Boolean? = null,
        repeat: Boolean? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.edit") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("video_id", videoId)
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
     * @param title - New album title.
     * @param groupId - Community ID (if the album edited is owned by a community).
     * @param privacy - new access permissions for the album. Possible values: , *'0' - all users,,
     * *'1' - friends only,, *'2' - friends and friends of friends,, *'3' - "only me".
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoEditAlbum(
        albumId: Int,
        title: String,
        groupId: Int? = null,
        privacy: List<PrivacyParam>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.editAlbum") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("album_id", albumId)
        addParam("title", title)
        groupId?.let { addParam("group_id", it) }
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
     * @param attachments - List of objects attached to the comment, in the following format:
     * "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media attachment: 'photo' - photo,
     * 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' - ID of the media attachment
     * owner. '<media_id>' - Media attachment ID. Example: "photo100172_166443618,photo66748_265827614"
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoEditComment(
        commentId: Int,
        ownerId: Int? = null,
        message: String? = null,
        attachments: List<String>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.editComment") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @param videos - Video IDs, in the following format:
     * "<owner_id>_<media_id>,<owner_id>_<media_id>", Use a negative value to designate a community ID.
     * Example: "-4363_136089719,13245770_137352259"
     * @param albumId - ID of the album containing the video(s).
     * @param count - Number of videos to return.
     * @param offset - Offset needed to return a specific subset of videos.
     * @param fields
     * @return [VKRequest] with [VideoGetResponse]
     */
    fun videoGet(
        ownerId: Int? = null,
        videos: List<String>? = null,
        albumId: Int? = null,
        count: Int? = null,
        offset: Int? = null,
        fields: List<String>? = null
    ): VKRequest<VideoGetResponse> = NewApiRequest("video.get") {
        GsonHolder.gson.fromJson(it, VideoGetResponse::class.java)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        videos?.let { addParam("videos", it) }
        albumId?.let { addParam("album_id", it) }
        count?.let { addParam("count", it) }
        offset?.let { addParam("offset", it) }
        fields?.let { addParam("fields", it) }
    }

    /**
     * Returns video album info
     *
     * @param albumId - Album ID.
     * @param ownerId - identifier of a user or community to add a video to. Use a negative value to
     * designate a community ID.
     * @return [VKRequest] with [VideoVideoAlbumFull]
     */
    fun videoGetAlbumById(albumId: Int, ownerId: Int? = null): VKRequest<VideoVideoAlbumFull> =
            NewApiRequest("video.getAlbumById") {
        GsonHolder.gson.fromJson(it, VideoVideoAlbumFull::class.java)
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
     * @param needSystem
     * @return [VKRequest] with [VideoGetAlbumsResponse]
     */
    fun videoGetAlbums(
        ownerId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        needSystem: Boolean? = null
    ): VKRequest<VideoGetAlbumsResponse> = NewApiRequest("video.getAlbums") {
        GsonHolder.gson.fromJson(it, VideoGetAlbumsResponse::class.java)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it) }
        needSystem?.let { addParam("need_system", it) }
    }

    /**
     * Returns a list of video albums owned by a user or community.
     *
     * @param ownerId - ID of the user or community that owns the video album(s).
     * @param offset - Offset needed to return a specific subset of video albums.
     * @param count - Number of video albums to return.
     * @param needSystem
     * @return [VKRequest] with [VideoGetAlbumsExtendedResponse]
     */
    fun videoGetAlbumsExtended(
        ownerId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        needSystem: Boolean? = null
    ): VKRequest<VideoGetAlbumsExtendedResponse> = NewApiRequest("video.getAlbums") {
        GsonHolder.gson.fromJson(it, VideoGetAlbumsExtendedResponse::class.java)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it) }
        addParam("extended", true)
        needSystem?.let { addParam("need_system", it) }
    }

    /**
     * @param ownerId
     * @param videoId
     * @param targetId
     * @return [VKRequest] with [Unit]
     */
    fun videoGetAlbumsByVideo(
        ownerId: Int,
        videoId: Int,
        targetId: Int? = null
    ): VKRequest<List<Int>> = NewApiRequest("video.getAlbumsByVideo") {
        val typeToken = object: TypeToken<List<Int>>() {}.type
        GsonHolder.gson.fromJson<List<Int>>(it, typeToken)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId)
        targetId?.let { addParam("target_id", it) }
    }

    /**
     * @param ownerId
     * @param videoId
     * @param targetId
     * @return [VKRequest] with [VideoGetAlbumsByVideoExtendedResponse]
     */
    fun videoGetAlbumsByVideoExtended(
        ownerId: Int,
        videoId: Int,
        targetId: Int? = null
    ): VKRequest<VideoGetAlbumsByVideoExtendedResponse> = NewApiRequest("video.getAlbumsByVideo") {
        GsonHolder.gson.fromJson(it, VideoGetAlbumsByVideoExtendedResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId)
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
     * @param sort - Sort order: 'asc' - oldest comment first, 'desc' - newest comment first
     * @param fields
     * @return [VKRequest] with [VideoGetCommentsResponse]
     */
    fun videoGetComments(
        videoId: Int,
        ownerId: Int? = null,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: SortParam? = null,
        fields: List<String>? = null
    ): VKRequest<VideoGetCommentsResponse> = NewApiRequest("video.getComments") {
        GsonHolder.gson.fromJson(it, VideoGetCommentsResponse::class.java)
    }
    .apply {
        addParam("video_id", videoId)
        ownerId?.let { addParam("owner_id", it) }
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it) }
        sort?.let { addParam("sort", it.value) }
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
     * @param sort - Sort order: 'asc' - oldest comment first, 'desc' - newest comment first
     * @param fields
     * @return [VKRequest] with [VideoGetCommentsExtendedResponse]
     */
    fun videoGetCommentsExtended(
        videoId: Int,
        ownerId: Int? = null,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: SortParam? = null,
        fields: List<String>? = null
    ): VKRequest<VideoGetCommentsExtendedResponse> = NewApiRequest("video.getComments") {
        GsonHolder.gson.fromJson(it, VideoGetCommentsExtendedResponse::class.java)
    }
    .apply {
        addParam("video_id", videoId)
        ownerId?.let { addParam("owner_id", it) }
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it) }
        sort?.let { addParam("sort", it.value) }
        addParam("extended", true)
        fields?.let { addParam("fields", it) }
    }

    /**
     * @param ownerId
     * @param videoId
     * @param targetId
     * @param albumId
     * @param albumIds
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoRemoveFromAlbum(
        ownerId: Int,
        videoId: Int,
        targetId: Int? = null,
        albumId: Int? = null,
        albumIds: List<Int>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.removeFromAlbum") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoReorderAlbums(
        albumId: Int,
        ownerId: Int? = null,
        before: Int? = null,
        after: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.reorderAlbums") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("album_id", albumId)
        ownerId?.let { addParam("owner_id", it) }
        before?.let { addParam("before", it) }
        after?.let { addParam("after", it) }
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoReorderVideos(
        ownerId: Int,
        videoId: Int,
        targetId: Int? = null,
        albumId: Int? = null,
        beforeOwnerId: Int? = null,
        beforeVideoId: Int? = null,
        afterOwnerId: Int? = null,
        afterVideoId: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.reorderVideos") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId)
        targetId?.let { addParam("target_id", it) }
        albumId?.let { addParam("album_id", it) }
        beforeOwnerId?.let { addParam("before_owner_id", it) }
        beforeVideoId?.let { addParam("before_video_id", it) }
        afterOwnerId?.let { addParam("after_owner_id", it) }
        afterVideoId?.let { addParam("after_video_id", it) }
    }

    /**
     * Reports (submits a complaint about) a video.
     *
     * @param ownerId - ID of the user or community that owns the video.
     * @param videoId - Video ID.
     * @param reason - Reason for the complaint: '0' - spam, '1' - child pornography, '2' -
     * extremism, '3' - violence, '4' - drug propaganda, '5' - adult material, '6' - insult, abuse
     * @param comment - Comment describing the complaint.
     * @param searchQuery - (If the video was found in search results.) Search query string.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoReport(
        ownerId: Int,
        videoId: Int,
        reason: ReasonParam? = null,
        comment: String? = null,
        searchQuery: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.report") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId)
        reason?.let { addParam("reason", it.value) }
        comment?.let { addParam("comment", it) }
        searchQuery?.let { addParam("search_query", it) }
    }

    /**
     * Reports (submits a complaint about) a comment on a video.
     *
     * @param ownerId - ID of the user or community that owns the video.
     * @param commentId - ID of the comment being reported.
     * @param reason - Reason for the complaint: , 0 - spam , 1 - child pornography , 2 - extremism
     * , 3 - violence , 4 - drug propaganda , 5 - adult material , 6 - insult, abuse
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoReportComment(
        ownerId: Int,
        commentId: Int,
        reason: ReasonParam? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("video.reportComment") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("comment_id", commentId)
        reason?.let { addParam("reason", it.value) }
    }

    /**
     * Restores a previously deleted video.
     *
     * @param videoId - Video ID.
     * @param ownerId - ID of the user or community that owns the video.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun videoRestore(videoId: Int, ownerId: Int? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("video.restore") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("video_id", videoId)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Restores a previously deleted comment on a video.
     *
     * @param commentId - ID of the deleted comment.
     * @param ownerId - ID of the user or community that owns the video.
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun videoRestoreComment(commentId: Int, ownerId: Int? = null): VKRequest<BaseBoolInt> =
            NewApiRequest("video.restoreComment") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
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
     * @return [VKRequest] with [VideoSaveResult]
     */
    fun videoSave(
        name: String? = null,
        description: String? = null,
        isPrivate: Boolean? = null,
        wallpost: Boolean? = null,
        link: String? = null,
        groupId: Int? = null,
        albumId: Int? = null,
        privacyView: List<String>? = null,
        privacyComment: List<String>? = null,
        noComments: Boolean? = null,
        repeat: Boolean? = null,
        compression: Boolean? = null
    ): VKRequest<VideoSaveResult> = NewApiRequest("video.save") {
        GsonHolder.gson.fromJson(it, VideoSaveResult::class.java)
    }
    .apply {
        name?.let { addParam("name", it) }
        description?.let { addParam("description", it) }
        isPrivate?.let { addParam("is_private", it) }
        wallpost?.let { addParam("wallpost", it) }
        link?.let { addParam("link", it) }
        groupId?.let { addParam("group_id", it) }
        albumId?.let { addParam("album_id", it) }
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
     * @param sort - Sort order: '1' - by duration, '2' - by relevance, '0' - by date added
     * @param hd - If not null, only searches for high-definition videos.
     * @param adult - '1' - to disable the Safe Search filter, '0' - to enable the Safe Search
     * filter
     * @param filters - Filters to apply: 'youtube' - return YouTube videos only, 'vimeo' - return
     * Vimeo videos only, 'short' - return short videos only, 'long' - return long videos only
     * @param searchOwn
     * @param offset - Offset needed to return a specific subset of videos.
     * @param longer
     * @param shorter
     * @param count - Number of videos to return.
     * @return [VKRequest] with [VideoSearchResponse]
     */
    fun videoSearch(
        q: String,
        sort: SortParam? = null,
        hd: Int? = null,
        adult: Boolean? = null,
        filters: List<FiltersParam>? = null,
        searchOwn: Boolean? = null,
        offset: Int? = null,
        longer: Int? = null,
        shorter: Int? = null,
        count: Int? = null
    ): VKRequest<VideoSearchResponse> = NewApiRequest("video.search") {
        GsonHolder.gson.fromJson(it, VideoSearchResponse::class.java)
    }
    .apply {
        addParam("q", q)
        sort?.let { addParam("sort", it.value) }
        hd?.let { addParam("hd", it) }
        adult?.let { addParam("adult", it) }
        val filtersJsonConverted = filters?.map {
            it.value
        }
        filtersJsonConverted?.let { addParam("filters", it) }
        searchOwn?.let { addParam("search_own", it) }
        offset?.let { addParam("offset", it) }
        longer?.let { addParam("longer", it) }
        shorter?.let { addParam("shorter", it) }
        count?.let { addParam("count", it) }
    }

    /**
     * Returns a list of videos under the set search criterion.
     *
     * @param q - Search query string (e.g., 'The Beatles').
     * @param sort - Sort order: '1' - by duration, '2' - by relevance, '0' - by date added
     * @param hd - If not null, only searches for high-definition videos.
     * @param adult - '1' - to disable the Safe Search filter, '0' - to enable the Safe Search
     * filter
     * @param filters - Filters to apply: 'youtube' - return YouTube videos only, 'vimeo' - return
     * Vimeo videos only, 'short' - return short videos only, 'long' - return long videos only
     * @param searchOwn
     * @param offset - Offset needed to return a specific subset of videos.
     * @param longer
     * @param shorter
     * @param count - Number of videos to return.
     * @return [VKRequest] with [VideoSearchExtendedResponse]
     */
    fun videoSearchExtended(
        q: String,
        sort: SortParam? = null,
        hd: Int? = null,
        adult: Boolean? = null,
        filters: List<FiltersParam>? = null,
        searchOwn: Boolean? = null,
        offset: Int? = null,
        longer: Int? = null,
        shorter: Int? = null,
        count: Int? = null
    ): VKRequest<VideoSearchExtendedResponse> = NewApiRequest("video.search") {
        GsonHolder.gson.fromJson(it, VideoSearchExtendedResponse::class.java)
    }
    .apply {
        addParam("q", q)
        sort?.let { addParam("sort", it.value) }
        hd?.let { addParam("hd", it) }
        adult?.let { addParam("adult", it) }
        val filtersJsonConverted = filters?.map {
            it.value
        }
        filtersJsonConverted?.let { addParam("filters", it) }
        searchOwn?.let { addParam("search_own", it) }
        offset?.let { addParam("offset", it) }
        longer?.let { addParam("longer", it) }
        shorter?.let { addParam("shorter", it) }
        count?.let { addParam("count", it) }
        addParam("extended", true)
    }
}
