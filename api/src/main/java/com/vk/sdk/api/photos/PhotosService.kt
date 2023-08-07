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
package com.vk.sdk.api.photos

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.dto.BaseUploadServerDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.photos.dto.PhotosGetAlbumsResponseDto
import com.vk.sdk.api.photos.dto.PhotosGetAllCommentsResponseDto
import com.vk.sdk.api.photos.dto.PhotosGetAllResponseDto
import com.vk.sdk.api.photos.dto.PhotosGetCommentsExtendedResponseDto
import com.vk.sdk.api.photos.dto.PhotosGetCommentsExtendedSortDto
import com.vk.sdk.api.photos.dto.PhotosGetCommentsResponseDto
import com.vk.sdk.api.photos.dto.PhotosGetCommentsSortDto
import com.vk.sdk.api.photos.dto.PhotosGetNewTagsResponseDto
import com.vk.sdk.api.photos.dto.PhotosGetResponseDto
import com.vk.sdk.api.photos.dto.PhotosGetUserPhotosResponseDto
import com.vk.sdk.api.photos.dto.PhotosPhotoAlbumFullDto
import com.vk.sdk.api.photos.dto.PhotosPhotoDto
import com.vk.sdk.api.photos.dto.PhotosPhotoTagDto
import com.vk.sdk.api.photos.dto.PhotosPhotoUploadDto
import com.vk.sdk.api.photos.dto.PhotosReportCommentReasonDto
import com.vk.sdk.api.photos.dto.PhotosReportReasonDto
import com.vk.sdk.api.photos.dto.PhotosSaveOwnerCoverPhotoResponseDto
import com.vk.sdk.api.photos.dto.PhotosSaveOwnerPhotoResponseDto
import com.vk.sdk.api.photos.dto.PhotosSearchResponseDto
import com.vk.sdk.api.users.dto.UsersFieldsDto
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class PhotosService {
    /**
     * Confirms a tag on a photo.
     *
     * @param photoId - Photo ID.
     * @param tagId - Tag ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosConfirmTag(
        photoId: String,
        tagId: Int,
        ownerId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.confirmTag") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("photo_id", photoId)
        addParam("tag_id", tagId)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Allows to copy a photo to the "Saved photos" album
     *
     * @param ownerId - photo's owner ID
     * @param photoId - photo ID
     * @param accessKey - for private photos
     * @return [VKRequest] with [Int]
     */
    fun photosCopy(
        ownerId: UserId,
        photoId: Int,
        accessKey: String? = null
    ): VKRequest<Int> = NewApiRequest("photos.copy") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("photo_id", photoId, min = 0)
        accessKey?.let { addParam("access_key", it) }
    }

    /**
     * Creates an empty photo album.
     *
     * @param title - Album title.
     * @param groupId - ID of the community in which the album will be created.
     * @param description - Album description.
     * @param privacyView
     * @param privacyComment
     * @param uploadByAdminsOnly
     * @param commentsDisabled
     * @return [VKRequest] with [PhotosPhotoAlbumFullDto]
     */
    fun photosCreateAlbum(
        title: String,
        groupId: UserId? = null,
        description: String? = null,
        privacyView: List<String>? = null,
        privacyComment: List<String>? = null,
        uploadByAdminsOnly: Boolean? = null,
        commentsDisabled: Boolean? = null
    ): VKRequest<PhotosPhotoAlbumFullDto> = NewApiRequest("photos.createAlbum") {
        GsonHolder.gson.parse<PhotosPhotoAlbumFullDto>(it)
    }
    .apply {
        addParam("title", title, minLength = 1)
        groupId?.let { addParam("group_id", it) }
        description?.let { addParam("description", it) }
        privacyView?.let { addParam("privacy_view", it) }
        privacyComment?.let { addParam("privacy_comment", it) }
        uploadByAdminsOnly?.let { addParam("upload_by_admins_only", it) }
        commentsDisabled?.let { addParam("comments_disabled", it) }
    }

    /**
     * Adds a new comment on the photo.
     *
     * @param photoId - Photo ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @param message - Comment text.
     * @param attachments - (Required if 'message' is not set.) List of objects attached to the
     * post, in the following format_ "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media
     * attachment_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' -
     * Media attachment owner ID. '<media_id>' - Media attachment ID. Example_
     * "photo100172_166443618,photo66748_265827614"
     * @param fromGroup - '1' - to post a comment from the community
     * @param replyToComment
     * @param stickerId
     * @param accessKey
     * @param guid
     * @return [VKRequest] with [Int]
     */
    fun photosCreateComment(
        photoId: Int,
        ownerId: UserId? = null,
        message: String? = null,
        attachments: List<String>? = null,
        fromGroup: Boolean? = null,
        replyToComment: Int? = null,
        stickerId: Int? = null,
        accessKey: String? = null,
        guid: String? = null
    ): VKRequest<Int> = NewApiRequest("photos.createComment") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        addParam("photo_id", photoId)
        ownerId?.let { addParam("owner_id", it) }
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
        fromGroup?.let { addParam("from_group", it) }
        replyToComment?.let { addParam("reply_to_comment", it) }
        stickerId?.let { addParam("sticker_id", it, min = 0) }
        accessKey?.let { addParam("access_key", it) }
        guid?.let { addParam("guid", it) }
    }

    /**
     * Deletes a photo.
     *
     * @param ownerId - ID of the user or community that owns the photo.
     * @param photoId - Photo ID.
     * @param photos
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosDelete(
        ownerId: UserId? = null,
        photoId: Int? = null,
        photos: List<String>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.delete") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        photoId?.let { addParam("photo_id", it, min = 0) }
        photos?.let { addParam("photos", it) }
    }

    /**
     * Deletes a photo album belonging to the current user.
     *
     * @param albumId - Album ID.
     * @param groupId - ID of the community that owns the album.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosDeleteAlbum(albumId: Int, groupId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("photos.deleteAlbum") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("album_id", albumId, min = 0)
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Deletes a comment on the photo.
     *
     * @param commentId - Comment ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun photosDeleteComment(commentId: Int, ownerId: UserId? = null): VKRequest<BaseBoolIntDto> =
            NewApiRequest("photos.deleteComment") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("comment_id", commentId)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Edits the caption of a photo.
     *
     * @param photoId - Photo ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @param caption - New caption for the photo. If this parameter is not set, it is considered to
     * be equal to an empty string.
     * @param latitude
     * @param longitude
     * @param placeStr
     * @param foursquareId
     * @param deletePlace
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosEdit(
        photoId: Int,
        ownerId: UserId? = null,
        caption: String? = null,
        latitude: Float? = null,
        longitude: Float? = null,
        placeStr: String? = null,
        foursquareId: String? = null,
        deletePlace: Boolean? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.edit") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("photo_id", photoId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        caption?.let { addParam("caption", it) }
        latitude?.let { addParam("latitude", it) }
        longitude?.let { addParam("longitude", it) }
        placeStr?.let { addParam("place_str", it) }
        foursquareId?.let { addParam("foursquare_id", it) }
        deletePlace?.let { addParam("delete_place", it) }
    }

    /**
     * Edits information about a photo album.
     *
     * @param albumId - ID of the photo album to be edited.
     * @param title - New album title.
     * @param description - New album description.
     * @param ownerId - ID of the user or community that owns the album.
     * @param privacyView
     * @param privacyComment
     * @param uploadByAdminsOnly
     * @param commentsDisabled
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosEditAlbum(
        albumId: Int,
        title: String? = null,
        description: String? = null,
        ownerId: UserId? = null,
        privacyView: List<String>? = null,
        privacyComment: List<String>? = null,
        uploadByAdminsOnly: Boolean? = null,
        commentsDisabled: Boolean? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.editAlbum") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("album_id", albumId, min = 0)
        title?.let { addParam("title", it) }
        description?.let { addParam("description", it) }
        ownerId?.let { addParam("owner_id", it) }
        privacyView?.let { addParam("privacy_view", it) }
        privacyComment?.let { addParam("privacy_comment", it) }
        uploadByAdminsOnly?.let { addParam("upload_by_admins_only", it) }
        commentsDisabled?.let { addParam("comments_disabled", it) }
    }

    /**
     * Edits a comment on a photo.
     *
     * @param commentId - Comment ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @param message - New text of the comment.
     * @param attachments - (Required if 'message' is not set.) List of objects attached to the
     * post, in the following format_ "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media
     * attachment_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' -
     * Media attachment owner ID. '<media_id>' - Media attachment ID. Example_
     * "photo100172_166443618,photo66748_265827614"
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosEditComment(
        commentId: Int,
        ownerId: UserId? = null,
        message: String? = null,
        attachments: List<String>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.editComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("comment_id", commentId)
        ownerId?.let { addParam("owner_id", it) }
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
    }

    /**
     * Returns a list of a user's or community's photos.
     *
     * @param ownerId - ID of the user or community that owns the photos. Use a negative value to
     * designate a community ID.
     * @param albumId - Photo album ID. To return information about photos from service albums, use
     * the following string values_ 'profile, wall, saved'.
     * @param photoIds - Photo IDs.
     * @param rev - Sort order_ '1' - reverse chronological, '0' - chronological
     * @param extended - '1' - to return additional 'likes', 'comments', and 'tags' fields, '0' -
     * (default)
     * @param feedType - Type of feed obtained in 'feed' field of the method.
     * @param feed - unixtime, that can be obtained with [vk.com/dev/newsfeed.get|newsfeed.get]
     * method in date field to get all photos uploaded by the user on a specific day, or photos the
     * user has been tagged on. Also, 'uid' parameter of the user the event happened with shall be
     * specified.
     * @param photoSizes - '1' - to return photo sizes in a [vk.com/dev/photo_sizes|special format]
     * @param offset
     * @param count
     * @return [VKRequest] with [PhotosGetResponseDto]
     */
    fun photosGet(
        ownerId: UserId? = null,
        albumId: String? = null,
        photoIds: List<String>? = null,
        rev: Boolean? = null,
        extended: Boolean? = null,
        feedType: String? = null,
        feed: Int? = null,
        photoSizes: Boolean? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<PhotosGetResponseDto> = NewApiRequest("photos.get") {
        GsonHolder.gson.parse<PhotosGetResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        albumId?.let { addParam("album_id", it) }
        photoIds?.let { addParam("photo_ids", it) }
        rev?.let { addParam("rev", it) }
        extended?.let { addParam("extended", it) }
        feedType?.let { addParam("feed_type", it) }
        feed?.let { addParam("feed", it) }
        photoSizes?.let { addParam("photo_sizes", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * Returns a list of a user's or community's photo albums.
     *
     * @param ownerId - ID of the user or community that owns the albums.
     * @param albumIds - Album IDs.
     * @param offset - Offset needed to return a specific subset of albums.
     * @param count - Number of albums to return.
     * @param needSystem - '1' - to return system albums with negative IDs
     * @param needCovers - '1' - to return an additional 'thumb_src' field, '0' - (default)
     * @param photoSizes - '1' - to return photo sizes in a
     * @return [VKRequest] with [PhotosGetAlbumsResponseDto]
     */
    fun photosGetAlbums(
        ownerId: UserId? = null,
        albumIds: List<Int>? = null,
        offset: Int? = null,
        count: Int? = null,
        needSystem: Boolean? = null,
        needCovers: Boolean? = null,
        photoSizes: Boolean? = null
    ): VKRequest<PhotosGetAlbumsResponseDto> = NewApiRequest("photos.getAlbums") {
        GsonHolder.gson.parse<PhotosGetAlbumsResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        albumIds?.let { addParam("album_ids", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        needSystem?.let { addParam("need_system", it) }
        needCovers?.let { addParam("need_covers", it) }
        photoSizes?.let { addParam("photo_sizes", it) }
    }

    /**
     * Returns the number of photo albums belonging to a user or community.
     *
     * @param userId - User ID.
     * @param groupId - Community ID.
     * @param needSystem
     * @return [VKRequest] with [Int]
     */
    fun photosGetAlbumsCount(
        userId: UserId? = null,
        groupId: UserId? = null,
        needSystem: Boolean? = null
    ): VKRequest<Int> = NewApiRequest("photos.getAlbumsCount") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it) }
        groupId?.let { addParam("group_id", it) }
        needSystem?.let { addParam("need_system", it) }
    }

    /**
     * Returns a list of photos belonging to a user or community, in reverse chronological order.
     *
     * @param ownerId - ID of a user or community that owns the photos. Use a negative value to
     * designate a community ID.
     * @param extended - '1' - to return detailed information about photos
     * @param offset - Offset needed to return a specific subset of photos. By default, '0'.
     * @param count - Number of photos to return.
     * @param photoSizes - '1' - to return image sizes in [vk.com/dev/photo_sizes|special format].
     * @param noServiceAlbums - '1' - to return photos only from standard albums, '0' - to return
     * all photos including those in service albums, e.g., 'My wall photos' (default)
     * @param needHidden - '1' - to show information about photos being hidden from the block above
     * the wall.
     * @param skipHidden - '1' - not to return photos being hidden from the block above the wall.
     * Works only with owner_id>0, no_service_albums is ignored.
     * @return [VKRequest] with [PhotosGetAllResponseDto]
     */
    fun photosGetAll(
        ownerId: UserId? = null,
        extended: Boolean? = null,
        offset: Int? = null,
        count: Int? = null,
        photoSizes: Boolean? = null,
        noServiceAlbums: Boolean? = null,
        needHidden: Boolean? = null,
        skipHidden: Boolean? = null
    ): VKRequest<PhotosGetAllResponseDto> = NewApiRequest("photos.getAll") {
        GsonHolder.gson.parse<PhotosGetAllResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        extended?.let { addParam("extended", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        photoSizes?.let { addParam("photo_sizes", it) }
        noServiceAlbums?.let { addParam("no_service_albums", it) }
        needHidden?.let { addParam("need_hidden", it) }
        skipHidden?.let { addParam("skip_hidden", it) }
    }

    /**
     * Returns a list of comments on a specific photo album or all albums of the user sorted in
     * reverse chronological order.
     *
     * @param ownerId - ID of the user or community that owns the album(s).
     * @param albumId - Album ID. If the parameter is not set, comments on all of the user's albums
     * will be returned.
     * @param needLikes - '1' - to return an additional 'likes' field, '0' - (default)
     * @param offset - Offset needed to return a specific subset of comments. By default, '0'.
     * @param count - Number of comments to return. By default, '20'. Maximum value, '100'.
     * @return [VKRequest] with [PhotosGetAllCommentsResponseDto]
     */
    fun photosGetAllComments(
        ownerId: UserId? = null,
        albumId: Int? = null,
        needLikes: Boolean? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<PhotosGetAllCommentsResponseDto> = NewApiRequest("photos.getAllComments") {
        GsonHolder.gson.parse<PhotosGetAllCommentsResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        albumId?.let { addParam("album_id", it, min = 0) }
        needLikes?.let { addParam("need_likes", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
    }

    /**
     * Returns information about photos by their IDs.
     *
     * @param photos - IDs separated with a comma, that are IDs of users who posted photos and IDs
     * of photos themselves with an underscore character between such IDs. To get information about a
     * photo in the group album, you shall specify group ID instead of user ID. Example_
     * "1_129207899,6492_135055734, , -20629724_271945303"
     * @param extended - '1' - to return additional fields, '0' - (default)
     * @param photoSizes - '1' - to return photo sizes in a
     * @return [VKRequest] with [Unit]
     */
    fun photosGetById(
        photos: List<String>,
        extended: Boolean? = null,
        photoSizes: Boolean? = null
    ): VKRequest<List<PhotosPhotoDto>> = NewApiRequest("photos.getById") {
        GsonHolder.gson.parseList<PhotosPhotoDto>(it)
    }
    .apply {
        addParam("photos", photos)
        extended?.let { addParam("extended", it) }
        photoSizes?.let { addParam("photo_sizes", it) }
    }

    /**
     * Returns an upload link for chat cover pictures.
     *
     * @param chatId - ID of the chat for which you want to upload a cover photo.
     * @param cropX
     * @param cropY
     * @param cropWidth - Width (in pixels) of the photo after cropping.
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun photosGetChatUploadServer(
        chatId: Int,
        cropX: Int? = null,
        cropY: Int? = null,
        cropWidth: Int? = null
    ): VKRequest<BaseUploadServerDto> = NewApiRequest("photos.getChatUploadServer") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }
    .apply {
        addParam("chat_id", chatId, min = 0)
        cropX?.let { addParam("crop_x", it, min = 0) }
        cropY?.let { addParam("crop_y", it, min = 0) }
        cropWidth?.let { addParam("crop_width", it, min = 200) }
    }

    /**
     * Returns a list of comments on a photo.
     *
     * @param photoId - Photo ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @param needLikes - '1' - to return an additional 'likes' field, '0' - (default)
     * @param startCommentId
     * @param offset - Offset needed to return a specific subset of comments. By default, '0'.
     * @param count - Number of comments to return.
     * @param sort - Sort order_ 'asc' - old first, 'desc' - new first
     * @param accessKey
     * @param extended
     * @param fields
     * @return [VKRequest] with [PhotosGetCommentsResponseDto]
     */
    fun photosGetComments(
        photoId: Int,
        ownerId: UserId? = null,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: PhotosGetCommentsSortDto? = null,
        accessKey: String? = null,
        extended: Boolean? = null,
        fields: List<UsersFieldsDto>? = null
    ): VKRequest<PhotosGetCommentsResponseDto> = NewApiRequest("photos.getComments") {
        GsonHolder.gson.parse<PhotosGetCommentsResponseDto>(it)
    }
    .apply {
        addParam("photo_id", photoId)
        ownerId?.let { addParam("owner_id", it) }
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it, min = 0) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        sort?.let { addParam("sort", it.value) }
        accessKey?.let { addParam("access_key", it) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of comments on a photo.
     *
     * @param photoId - Photo ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @param needLikes - '1' - to return an additional 'likes' field, '0' - (default)
     * @param startCommentId
     * @param offset - Offset needed to return a specific subset of comments. By default, '0'.
     * @param count - Number of comments to return.
     * @param sort - Sort order_ 'asc' - old first, 'desc' - new first
     * @param accessKey
     * @param fields
     * @return [VKRequest] with [PhotosGetCommentsExtendedResponseDto]
     */
    fun photosGetCommentsExtended(
        photoId: Int,
        ownerId: UserId? = null,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: PhotosGetCommentsExtendedSortDto? = null,
        accessKey: String? = null,
        fields: List<UsersFieldsDto>? = null
    ): VKRequest<PhotosGetCommentsExtendedResponseDto> = NewApiRequest("photos.getComments") {
        GsonHolder.gson.parse<PhotosGetCommentsExtendedResponseDto>(it)
    }
    .apply {
        addParam("photo_id", photoId)
        ownerId?.let { addParam("owner_id", it) }
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it, min = 0) }
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        sort?.let { addParam("sort", it.value) }
        accessKey?.let { addParam("access_key", it) }
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns the server address for market album photo upload.
     *
     * @param groupId - Community ID.
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun photosGetMarketAlbumUploadServer(groupId: UserId): VKRequest<BaseUploadServerDto> =
            NewApiRequest("photos.getMarketAlbumUploadServer") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * Returns the server address for market photo upload.
     *
     * @param groupId - Community ID.
     * @param mainPhoto - '1' if you want to upload the main item photo.
     * @param cropX - X coordinate of the crop left upper corner.
     * @param cropY - Y coordinate of the crop left upper corner.
     * @param cropWidth - Width of the cropped photo in px.
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun photosGetMarketUploadServer(
        groupId: UserId,
        mainPhoto: Boolean? = null,
        cropX: Int? = null,
        cropY: Int? = null,
        cropWidth: Int? = null
    ): VKRequest<BaseUploadServerDto> = NewApiRequest("photos.getMarketUploadServer") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        mainPhoto?.let { addParam("main_photo", it) }
        cropX?.let { addParam("crop_x", it, min = 0) }
        cropY?.let { addParam("crop_y", it, min = 0) }
        cropWidth?.let { addParam("crop_width", it, min = 400) }
    }

    /**
     * Returns the server address for photo upload in a private message for a user.
     *
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'Chat ID', e.g. '2000000001'. For community_ '- Community ID', e.g. '-12345'. "
     * @return [VKRequest] with [PhotosPhotoUploadDto]
     */
    fun photosGetMessagesUploadServer(peerId: Int? = null): VKRequest<PhotosPhotoUploadDto> =
            NewApiRequest("photos.getMessagesUploadServer") {
        GsonHolder.gson.parse<PhotosPhotoUploadDto>(it)
    }
    .apply {
        peerId?.let { addParam("peer_id", it) }
    }

    /**
     * Returns a list of photos with tags that have not been viewed.
     *
     * @param offset - Offset needed to return a specific subset of photos.
     * @param count - Number of photos to return.
     * @return [VKRequest] with [PhotosGetNewTagsResponseDto]
     */
    fun photosGetNewTags(offset: Int? = null, count: Int? = null):
            VKRequest<PhotosGetNewTagsResponseDto> = NewApiRequest("photos.getNewTags") {
        GsonHolder.gson.parse<PhotosGetNewTagsResponseDto>(it)
    }
    .apply {
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 100) }
    }

    /**
     * Returns the server address for owner cover upload.
     *
     * @param groupId - ID of community that owns the album (if the photo will be uploaded to a
     * community album).
     * @param cropX - X coordinate of the left-upper corner
     * @param cropY - Y coordinate of the left-upper corner
     * @param cropX2 - X coordinate of the right-bottom corner
     * @param cropY2 - Y coordinate of the right-bottom corner
     * @param isVideoCover
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun photosGetOwnerCoverPhotoUploadServer(
        groupId: UserId? = null,
        cropX: Int? = null,
        cropY: Int? = null,
        cropX2: Int? = null,
        cropY2: Int? = null,
        isVideoCover: Boolean? = null
    ): VKRequest<BaseUploadServerDto> = NewApiRequest("photos.getOwnerCoverPhotoUploadServer") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 1) }
        cropX?.let { addParam("crop_x", it, min = 0) }
        cropY?.let { addParam("crop_y", it, min = 0) }
        cropX2?.let { addParam("crop_x2", it, min = 0) }
        cropY2?.let { addParam("crop_y2", it, min = 0) }
        isVideoCover?.let { addParam("is_video_cover", it) }
    }

    /**
     * Returns an upload server address for a profile or community photo.
     *
     * @param ownerId - identifier of a community or current user. "Note that community id must be
     * negative. 'owner_id=1' - user, 'owner_id=-1' - community, "
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun photosGetOwnerPhotoUploadServer(ownerId: UserId? = null): VKRequest<BaseUploadServerDto> =
            NewApiRequest("photos.getOwnerPhotoUploadServer") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Returns a list of tags on a photo.
     *
     * @param photoId - Photo ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @param accessKey
     * @return [VKRequest] with [Unit]
     */
    fun photosGetTags(
        photoId: Int,
        ownerId: UserId? = null,
        accessKey: String? = null
    ): VKRequest<List<PhotosPhotoTagDto>> = NewApiRequest("photos.getTags") {
        GsonHolder.gson.parseList<PhotosPhotoTagDto>(it)
    }
    .apply {
        addParam("photo_id", photoId)
        ownerId?.let { addParam("owner_id", it) }
        accessKey?.let { addParam("access_key", it) }
    }

    /**
     * Returns the server address for photo upload.
     *
     * @param albumId
     * @param groupId - ID of community that owns the album (if the photo will be uploaded to a
     * community album).
     * @return [VKRequest] with [PhotosPhotoUploadDto]
     */
    fun photosGetUploadServer(albumId: Int? = null, groupId: UserId? = null):
            VKRequest<PhotosPhotoUploadDto> = NewApiRequest("photos.getUploadServer") {
        GsonHolder.gson.parse<PhotosPhotoUploadDto>(it)
    }
    .apply {
        albumId?.let { addParam("album_id", it) }
        groupId?.let { addParam("group_id", it) }
    }

    /**
     * Returns a list of photos in which a user is tagged.
     *
     * @param userId - User ID.
     * @param offset - Offset needed to return a specific subset of photos. By default, '0'.
     * @param count - Number of photos to return. Maximum value is 1000.
     * @param extended - '1' - to return an additional 'likes' field, '0' - (default)
     * @param sort - Sort order_ '1' - by date the tag was added in ascending order, '0' - by date
     * the tag was added in descending order
     * @return [VKRequest] with [PhotosGetUserPhotosResponseDto]
     */
    fun photosGetUserPhotos(
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        extended: Boolean? = null,
        sort: String? = null
    ): VKRequest<PhotosGetUserPhotosResponseDto> = NewApiRequest("photos.getUserPhotos") {
        GsonHolder.gson.parse<PhotosGetUserPhotosResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        extended?.let { addParam("extended", it) }
        sort?.let { addParam("sort", it) }
    }

    /**
     * Returns the server address for photo upload onto a user's wall.
     *
     * @param groupId - ID of community to whose wall the photo will be uploaded.
     * @return [VKRequest] with [PhotosPhotoUploadDto]
     */
    fun photosGetWallUploadServer(groupId: UserId? = null): VKRequest<PhotosPhotoUploadDto> =
            NewApiRequest("photos.getWallUploadServer") {
        GsonHolder.gson.parse<PhotosPhotoUploadDto>(it)
    }
    .apply {
        groupId?.let { addParam("group_id", it) }
    }

    /**
     * Makes a photo into an album cover.
     *
     * @param photoId - Photo ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @param albumId - Album ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosMakeCover(
        photoId: Int,
        ownerId: UserId? = null,
        albumId: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.makeCover") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("photo_id", photoId)
        ownerId?.let { addParam("owner_id", it) }
        albumId?.let { addParam("album_id", it) }
    }

    /**
     * Moves a photo from one album to another.
     *
     * @param targetAlbumId - ID of the album to which the photo will be moved.
     * @param photoIds
     * @param ownerId - ID of the user or community that owns the photo.
     * @param copyAndDelete - Move by copy and delete original photo (be careful reverse ordering by
     * default)
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosMove(
        targetAlbumId: Int,
        photoIds: List<Int>,
        ownerId: UserId? = null,
        copyAndDelete: Boolean? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.move") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("target_album_id", targetAlbumId)
        addParam("photo_ids", photoIds)
        ownerId?.let { addParam("owner_id", it) }
        copyAndDelete?.let { addParam("copy_and_delete", it) }
    }

    /**
     * Adds a tag on the photo.
     *
     * @param photoId - Photo ID.
     * @param userId - ID of the user to be tagged.
     * @param ownerId - ID of the user or community that owns the photo.
     * @param x - Upper left-corner coordinate of the tagged area (as a percentage of the photo's
     * width).
     * @param y - Upper left-corner coordinate of the tagged area (as a percentage of the photo's
     * height).
     * @param x2 - Lower right-corner coordinate of the tagged area (as a percentage of the photo's
     * width).
     * @param y2 - Lower right-corner coordinate of the tagged area (as a percentage of the photo's
     * height).
     * @return [VKRequest] with [Int]
     */
    fun photosPutTag(
        photoId: Int,
        userId: UserId,
        ownerId: UserId? = null,
        x: Float? = null,
        y: Float? = null,
        x2: Float? = null,
        y2: Float? = null
    ): VKRequest<Int> = NewApiRequest("photos.putTag") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        addParam("photo_id", photoId, min = 0)
        addParam("user_id", userId)
        ownerId?.let { addParam("owner_id", it) }
        x?.let { addParam("x", it) }
        y?.let { addParam("y", it) }
        x2?.let { addParam("x2", it) }
        y2?.let { addParam("y2", it) }
    }

    /**
     * Removes a tag from a photo.
     *
     * @param photoId - Photo ID.
     * @param tagId - Tag ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosRemoveTag(
        photoId: Int,
        tagId: Int,
        ownerId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.removeTag") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("photo_id", photoId)
        addParam("tag_id", tagId)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Reorders the album in the list of user albums.
     *
     * @param albumId - Album ID.
     * @param ownerId - ID of the user or community that owns the album.
     * @param before - ID of the album before which the album in question shall be placed.
     * @param after - ID of the album after which the album in question shall be placed.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosReorderAlbums(
        albumId: Int,
        ownerId: UserId? = null,
        before: Int? = null,
        after: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.reorderAlbums") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("album_id", albumId)
        ownerId?.let { addParam("owner_id", it) }
        before?.let { addParam("before", it) }
        after?.let { addParam("after", it) }
    }

    /**
     * Reorders the photo in the list of photos of the user album.
     *
     * @param photoId - Photo ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @param before - ID of the photo before which the photo in question shall be placed.
     * @param after - ID of the photo after which the photo in question shall be placed.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosReorderPhotos(
        photoId: Int,
        ownerId: UserId? = null,
        before: Int? = null,
        after: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.reorderPhotos") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("photo_id", photoId)
        ownerId?.let { addParam("owner_id", it) }
        before?.let { addParam("before", it) }
        after?.let { addParam("after", it) }
    }

    /**
     * Reports (submits a complaint about) a photo.
     *
     * @param ownerId - ID of the user or community that owns the photo.
     * @param photoId - Photo ID.
     * @param reason - Reason for the complaint_ '0' - spam, '1' - child pornography, '2' -
     * extremism, '3' - violence, '4' - drug propaganda, '5' - adult material, '6' - insult, abuse,
     * '8' - suicide calls
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosReport(
        ownerId: UserId,
        photoId: Int,
        reason: PhotosReportReasonDto? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.report") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("photo_id", photoId, min = 0)
        reason?.let { addParam("reason", it.value) }
    }

    /**
     * Reports (submits a complaint about) a comment on a photo.
     *
     * @param ownerId - ID of the user or community that owns the photo.
     * @param commentId - ID of the comment being reported.
     * @param reason - Reason for the complaint_ '0' - spam, '1' - child pornography, '2' -
     * extremism, '3' - violence, '4' - drug propaganda, '5' - adult material, '6' - insult, abuse
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosReportComment(
        ownerId: UserId,
        commentId: Int,
        reason: PhotosReportCommentReasonDto? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("photos.reportComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("comment_id", commentId, min = 0)
        reason?.let { addParam("reason", it.value) }
    }

    /**
     * Restores a deleted photo.
     *
     * @param photoId - Photo ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun photosRestore(photoId: Int, ownerId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("photos.restore") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("photo_id", photoId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Restores a deleted comment on a photo.
     *
     * @param commentId - ID of the deleted comment.
     * @param ownerId - ID of the user or community that owns the photo.
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun photosRestoreComment(commentId: Int, ownerId: UserId? = null): VKRequest<BaseBoolIntDto> =
            NewApiRequest("photos.restoreComment") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("comment_id", commentId)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Saves photos after successful uploading.
     *
     * @param albumId - ID of the album to save photos to.
     * @param groupId - ID of the community to save photos to.
     * @param server - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param photosList - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param hash - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param latitude - Geographical latitude, in degrees (from '-90' to '90').
     * @param longitude - Geographical longitude, in degrees (from '-180' to '180').
     * @param caption - Text describing the photo. 2048 digits max.
     * @return [VKRequest] with [Unit]
     */
    fun photosSave(
        albumId: Int? = null,
        groupId: UserId? = null,
        server: Int? = null,
        photosList: String? = null,
        hash: String? = null,
        latitude: Float? = null,
        longitude: Float? = null,
        caption: String? = null
    ): VKRequest<List<PhotosPhotoDto>> = NewApiRequest("photos.save") {
        GsonHolder.gson.parseList<PhotosPhotoDto>(it)
    }
    .apply {
        albumId?.let { addParam("album_id", it) }
        groupId?.let { addParam("group_id", it) }
        server?.let { addParam("server", it) }
        photosList?.let { addParam("photos_list", it) }
        hash?.let { addParam("hash", it) }
        latitude?.let { addParam("latitude", it) }
        longitude?.let { addParam("longitude", it) }
        caption?.let { addParam("caption", it) }
    }

    /**
     * Saves market album photos after successful uploading.
     *
     * @param groupId - Community ID.
     * @param photo - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param server - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param hash - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @return [VKRequest] with [Unit]
     */
    fun photosSaveMarketAlbumPhoto(
        groupId: UserId,
        photo: String,
        server: Int,
        hash: String
    ): VKRequest<List<PhotosPhotoDto>> = NewApiRequest("photos.saveMarketAlbumPhoto") {
        GsonHolder.gson.parseList<PhotosPhotoDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("photo", photo)
        addParam("server", server, min = 0)
        addParam("hash", hash)
    }

    /**
     * Saves market photos after successful uploading.
     *
     * @param photo - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param server - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param hash - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param groupId - Community ID.
     * @param cropData - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param cropHash - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @return [VKRequest] with [Unit]
     */
    fun photosSaveMarketPhoto(
        photo: String,
        server: Int,
        hash: String,
        groupId: UserId? = null,
        cropData: String? = null,
        cropHash: String? = null
    ): VKRequest<List<PhotosPhotoDto>> = NewApiRequest("photos.saveMarketPhoto") {
        GsonHolder.gson.parseList<PhotosPhotoDto>(it)
    }
    .apply {
        addParam("photo", photo)
        addParam("server", server)
        addParam("hash", hash)
        groupId?.let { addParam("group_id", it, min = 0) }
        cropData?.let { addParam("crop_data", it) }
        cropHash?.let { addParam("crop_hash", it) }
    }

    /**
     * Saves a photo after being successfully uploaded. URL obtained with
     * [vk.com/dev/photos.getMessagesUploadServer|photos.getMessagesUploadServer] method.
     *
     * @param photo - Parameter returned when the photo is [vk.com/dev/upload_files|uploaded to the
     * server].
     * @param server
     * @param hash
     * @return [VKRequest] with [Unit]
     */
    fun photosSaveMessagesPhoto(
        photo: String,
        server: Int? = null,
        hash: String? = null
    ): VKRequest<List<PhotosPhotoDto>> = NewApiRequest("photos.saveMessagesPhoto") {
        GsonHolder.gson.parseList<PhotosPhotoDto>(it)
    }
    .apply {
        addParam("photo", photo)
        server?.let { addParam("server", it) }
        hash?.let { addParam("hash", it) }
    }

    /**
     * Saves cover photo after successful uploading.
     *
     * @param cropX
     * @param cropHeight
     * @param cropY
     * @param cropWidth
     * @param responseJson
     * @param hash - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param photo - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param isVideoCover
     * @return [VKRequest] with [PhotosSaveOwnerCoverPhotoResponseDto]
     */
    fun photosSaveOwnerCoverPhoto(
        cropX: Int? = null,
        cropHeight: Int? = null,
        cropY: Int? = null,
        cropWidth: Int? = null,
        responseJson: String? = null,
        hash: String? = null,
        photo: String? = null,
        isVideoCover: Boolean? = null
    ): VKRequest<PhotosSaveOwnerCoverPhotoResponseDto> =
            NewApiRequest("photos.saveOwnerCoverPhoto") {
        GsonHolder.gson.parse<PhotosSaveOwnerCoverPhotoResponseDto>(it)
    }
    .apply {
        cropX?.let { addParam("crop_x", it, min = 0) }
        cropHeight?.let { addParam("crop_height", it, min = 0) }
        cropY?.let { addParam("crop_y", it, min = 0) }
        cropWidth?.let { addParam("crop_width", it, min = 0) }
        responseJson?.let { addParam("response_json", it) }
        hash?.let { addParam("hash", it) }
        photo?.let { addParam("photo", it) }
        isVideoCover?.let { addParam("is_video_cover", it) }
    }

    /**
     * Saves a profile or community photo. Upload URL can be got with the
     * [vk.com/dev/photos.getOwnerPhotoUploadServer|photos.getOwnerPhotoUploadServer] method.
     *
     * @param server - parameter returned after [vk.com/dev/upload_files|photo upload].
     * @param hash - parameter returned after [vk.com/dev/upload_files|photo upload].
     * @param photo - parameter returned after [vk.com/dev/upload_files|photo upload].
     * @return [VKRequest] with [PhotosSaveOwnerPhotoResponseDto]
     */
    fun photosSaveOwnerPhoto(
        server: String? = null,
        hash: String? = null,
        photo: String? = null
    ): VKRequest<PhotosSaveOwnerPhotoResponseDto> = NewApiRequest("photos.saveOwnerPhoto") {
        GsonHolder.gson.parse<PhotosSaveOwnerPhotoResponseDto>(it)
    }
    .apply {
        server?.let { addParam("server", it) }
        hash?.let { addParam("hash", it) }
        photo?.let { addParam("photo", it) }
    }

    /**
     * Saves a photo to a user's or community's wall after being uploaded.
     *
     * @param photo - Parameter returned when the the photo is [vk.com/dev/upload_files|uploaded to
     * the server].
     * @param userId - ID of the user on whose wall the photo will be saved.
     * @param groupId - ID of community on whose wall the photo will be saved.
     * @param server
     * @param hash
     * @param latitude - Geographical latitude, in degrees (from '-90' to '90').
     * @param longitude - Geographical longitude, in degrees (from '-180' to '180').
     * @param caption - Text describing the photo. 2048 digits max.
     * @return [VKRequest] with [Unit]
     */
    fun photosSaveWallPhoto(
        photo: String,
        userId: UserId? = null,
        groupId: UserId? = null,
        server: Int? = null,
        hash: String? = null,
        latitude: Float? = null,
        longitude: Float? = null,
        caption: String? = null
    ): VKRequest<List<PhotosPhotoDto>> = NewApiRequest("photos.saveWallPhoto") {
        GsonHolder.gson.parseList<PhotosPhotoDto>(it)
    }
    .apply {
        addParam("photo", photo)
        userId?.let { addParam("user_id", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
        server?.let { addParam("server", it) }
        hash?.let { addParam("hash", it) }
        latitude?.let { addParam("latitude", it) }
        longitude?.let { addParam("longitude", it) }
        caption?.let { addParam("caption", it) }
    }

    /**
     * Returns a list of photos.
     *
     * @param q - Search query string.
     * @param lat - Geographical latitude, in degrees (from '-90' to '90').
     * @param long - Geographical longitude, in degrees (from '-180' to '180').
     * @param startTime
     * @param endTime
     * @param sort - Sort order_
     * @param offset - Offset needed to return a specific subset of photos.
     * @param count - Number of photos to return.
     * @param radius - Radius of search in meters (works very approximately). Available values_
     * '10', '100', '800', '6000', '50000'.
     * @return [VKRequest] with [PhotosSearchResponseDto]
     */
    fun photosSearch(
        q: String? = null,
        lat: Float? = null,
        long: Float? = null,
        startTime: Int? = null,
        endTime: Int? = null,
        sort: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        radius: Int? = null
    ): VKRequest<PhotosSearchResponseDto> = NewApiRequest("photos.search") {
        GsonHolder.gson.parse<PhotosSearchResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it) }
        lat?.let { addParam("lat", it) }
        long?.let { addParam("long", it) }
        startTime?.let { addParam("start_time", it, min = 0) }
        endTime?.let { addParam("end_time", it, min = 0) }
        sort?.let { addParam("sort", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        radius?.let { addParam("radius", it, min = 0) }
    }

    object PhotosCopyRestrictions {
        const val PHOTO_ID_MIN: Long = 0
    }

    object PhotosCreateAlbumRestrictions {
        const val TITLE_MIN_LENGTH: Int = 1
    }

    object PhotosCreateCommentRestrictions {
        const val STICKER_ID_MIN: Long = 0
    }

    object PhotosDeleteRestrictions {
        const val PHOTO_ID_MIN: Long = 0
    }

    object PhotosDeleteAlbumRestrictions {
        const val ALBUM_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object PhotosEditRestrictions {
        const val PHOTO_ID_MIN: Long = 0
    }

    object PhotosEditAlbumRestrictions {
        const val ALBUM_ID_MIN: Long = 0
    }

    object PhotosGetRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object PhotosGetAlbumsRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0
    }

    object PhotosGetAllRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200
    }

    object PhotosGetAllCommentsRestrictions {
        const val ALBUM_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0
    }

    object PhotosGetChatUploadServerRestrictions {
        const val CHAT_ID_MIN: Long = 0

        const val CROP_X_MIN: Long = 0

        const val CROP_Y_MIN: Long = 0

        const val CROP_WIDTH_MIN: Long = 200
    }

    object PhotosGetCommentsRestrictions {
        const val START_COMMENT_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object PhotosGetCommentsExtendedRestrictions {
        const val START_COMMENT_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object PhotosGetMarketAlbumUploadServerRestrictions {
        const val GROUP_ID_MIN: Long = 1
    }

    object PhotosGetMarketUploadServerRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val CROP_X_MIN: Long = 0

        const val CROP_Y_MIN: Long = 0

        const val CROP_WIDTH_MIN: Long = 400
    }

    object PhotosGetNewTagsRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object PhotosGetOwnerCoverPhotoUploadServerRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val CROP_X_MIN: Long = 0

        const val CROP_Y_MIN: Long = 0

        const val CROP_X2_MIN: Long = 0

        const val CROP_Y2_MIN: Long = 0
    }

    object PhotosGetUserPhotosRestrictions {
        const val USER_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object PhotosPutTagRestrictions {
        const val PHOTO_ID_MIN: Long = 0
    }

    object PhotosReportRestrictions {
        const val PHOTO_ID_MIN: Long = 0

        const val REASON_MIN: Long = 0
    }

    object PhotosReportCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 0

        const val REASON_MIN: Long = 0
    }

    object PhotosRestoreRestrictions {
        const val PHOTO_ID_MIN: Long = 0
    }

    object PhotosSaveMarketAlbumPhotoRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val SERVER_MIN: Long = 0
    }

    object PhotosSaveMarketPhotoRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object PhotosSaveOwnerCoverPhotoRestrictions {
        const val CROP_X_MIN: Long = 0

        const val CROP_HEIGHT_MIN: Long = 0

        const val CROP_Y_MIN: Long = 0

        const val CROP_WIDTH_MIN: Long = 0
    }

    object PhotosSaveWallPhotoRestrictions {
        const val USER_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object PhotosSearchRestrictions {
        const val START_TIME_MIN: Long = 0

        const val END_TIME_MIN: Long = 0

        const val SORT_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000

        const val RADIUS_MIN: Long = 0
    }
}
