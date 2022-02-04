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

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.base.dto.BaseUploadServer
import com.vk.sdk.api.photos.dto.PhotosGetAlbumsResponse
import com.vk.sdk.api.photos.dto.PhotosGetAllCommentsResponse
import com.vk.sdk.api.photos.dto.PhotosGetAllExtendedResponse
import com.vk.sdk.api.photos.dto.PhotosGetAllResponse
import com.vk.sdk.api.photos.dto.PhotosGetCommentsExtendedResponse
import com.vk.sdk.api.photos.dto.PhotosGetCommentsExtendedSort
import com.vk.sdk.api.photos.dto.PhotosGetCommentsResponse
import com.vk.sdk.api.photos.dto.PhotosGetCommentsSort
import com.vk.sdk.api.photos.dto.PhotosGetExtendedResponse
import com.vk.sdk.api.photos.dto.PhotosGetNewTagsResponse
import com.vk.sdk.api.photos.dto.PhotosGetResponse
import com.vk.sdk.api.photos.dto.PhotosGetUserPhotosExtendedResponse
import com.vk.sdk.api.photos.dto.PhotosGetUserPhotosResponse
import com.vk.sdk.api.photos.dto.PhotosPhoto
import com.vk.sdk.api.photos.dto.PhotosPhotoAlbumFull
import com.vk.sdk.api.photos.dto.PhotosPhotoFull
import com.vk.sdk.api.photos.dto.PhotosPhotoTag
import com.vk.sdk.api.photos.dto.PhotosPhotoUpload
import com.vk.sdk.api.photos.dto.PhotosReportCommentReason
import com.vk.sdk.api.photos.dto.PhotosReportReason
import com.vk.sdk.api.photos.dto.PhotosSaveOwnerCoverPhotoResponse
import com.vk.sdk.api.photos.dto.PhotosSaveOwnerPhotoResponse
import com.vk.sdk.api.photos.dto.PhotosSearchResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class PhotosService {
    /**
     * Confirms a tag on a photo.
     *
     * @param photoId - Photo ID.
     * @param tagId - Tag ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosConfirmTag(
        photoId: String,
        tagId: Int,
        ownerId: UserId? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.confirmTag") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
        GsonHolder.gson.fromJson(it, Int::class.java)
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
     * @return [VKRequest] with [PhotosPhotoAlbumFull]
     */
    fun photosCreateAlbum(
        title: String,
        groupId: UserId? = null,
        description: String? = null,
        privacyView: List<String>? = null,
        privacyComment: List<String>? = null,
        uploadByAdminsOnly: Boolean? = null,
        commentsDisabled: Boolean? = null
    ): VKRequest<PhotosPhotoAlbumFull> = NewApiRequest("photos.createAlbum") {
        GsonHolder.gson.fromJson(it, PhotosPhotoAlbumFull::class.java)
    }
    .apply {
        addParam("title", title, minLength = 2)
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
        GsonHolder.gson.fromJson(it, Int::class.java)
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
     * @param photoId - Photo ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosDelete(photoId: Int, ownerId: UserId? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("photos.delete") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("photo_id", photoId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Deletes a photo album belonging to the current user.
     *
     * @param albumId - Album ID.
     * @param groupId - ID of the community that owns the album.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosDeleteAlbum(albumId: Int, groupId: UserId? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("photos.deleteAlbum") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun photosDeleteComment(commentId: Int, ownerId: UserId? = null): VKRequest<BaseBoolInt> =
            NewApiRequest("photos.deleteComment") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
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
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.edit") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
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
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.editAlbum") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosEditComment(
        commentId: Int,
        ownerId: UserId? = null,
        message: String? = null,
        attachments: List<String>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.editComment") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @param feedType - Type of feed obtained in 'feed' field of the method.
     * @param feed - unixtime, that can be obtained with [vk.com/dev/newsfeed.get|newsfeed.get]
     * method in date field to get all photos uploaded by the user on a specific day, or photos the
     * user has been tagged on. Also, 'uid' parameter of the user the event happened with shall be
     * specified.
     * @param photoSizes - '1' - to return photo sizes in a [vk.com/dev/photo_sizes|special format]
     * @param offset
     * @param count
     * @return [VKRequest] with [PhotosGetResponse]
     */
    fun photosGet(
        ownerId: UserId? = null,
        albumId: String? = null,
        photoIds: List<String>? = null,
        rev: Boolean? = null,
        feedType: String? = null,
        feed: Int? = null,
        photoSizes: Boolean? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<PhotosGetResponse> = NewApiRequest("photos.get") {
        GsonHolder.gson.fromJson(it, PhotosGetResponse::class.java)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        albumId?.let { addParam("album_id", it) }
        photoIds?.let { addParam("photo_ids", it) }
        rev?.let { addParam("rev", it) }
        feedType?.let { addParam("feed_type", it) }
        feed?.let { addParam("feed", it) }
        photoSizes?.let { addParam("photo_sizes", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
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
     * @param feedType - Type of feed obtained in 'feed' field of the method.
     * @param feed - unixtime, that can be obtained with [vk.com/dev/newsfeed.get|newsfeed.get]
     * method in date field to get all photos uploaded by the user on a specific day, or photos the
     * user has been tagged on. Also, 'uid' parameter of the user the event happened with shall be
     * specified.
     * @param photoSizes - '1' - to return photo sizes in a [vk.com/dev/photo_sizes|special format]
     * @param offset
     * @param count
     * @return [VKRequest] with [PhotosGetExtendedResponse]
     */
    fun photosGetExtended(
        ownerId: UserId? = null,
        albumId: String? = null,
        photoIds: List<String>? = null,
        rev: Boolean? = null,
        feedType: String? = null,
        feed: Int? = null,
        photoSizes: Boolean? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<PhotosGetExtendedResponse> = NewApiRequest("photos.get") {
        GsonHolder.gson.fromJson(it, PhotosGetExtendedResponse::class.java)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        albumId?.let { addParam("album_id", it) }
        photoIds?.let { addParam("photo_ids", it) }
        rev?.let { addParam("rev", it) }
        addParam("extended", true)
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
     * @return [VKRequest] with [PhotosGetAlbumsResponse]
     */
    fun photosGetAlbums(
        ownerId: UserId? = null,
        albumIds: List<Int>? = null,
        offset: Int? = null,
        count: Int? = null,
        needSystem: Boolean? = null,
        needCovers: Boolean? = null,
        photoSizes: Boolean? = null
    ): VKRequest<PhotosGetAlbumsResponse> = NewApiRequest("photos.getAlbums") {
        GsonHolder.gson.fromJson(it, PhotosGetAlbumsResponse::class.java)
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
     * @return [VKRequest] with [Int]
     */
    fun photosGetAlbumsCount(userId: UserId? = null, groupId: UserId? = null): VKRequest<Int> =
            NewApiRequest("photos.getAlbumsCount") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it) }
        groupId?.let { addParam("group_id", it) }
    }

    /**
     * Returns a list of photos belonging to a user or community, in reverse chronological order.
     *
     * @param ownerId - ID of a user or community that owns the photos. Use a negative value to
     * designate a community ID.
     * @param offset - Offset needed to return a specific subset of photos. By default, '0'.
     * @param count - Number of photos to return.
     * @param photoSizes - '1' - to return image sizes in [vk.com/dev/photo_sizes|special format].
     * @param noServiceAlbums - '1' - to return photos only from standard albums, '0' - to return
     * all photos including those in service albums, e.g., 'My wall photos' (default)
     * @param needHidden - '1' - to show information about photos being hidden from the block above
     * the wall.
     * @param skipHidden - '1' - not to return photos being hidden from the block above the wall.
     * Works only with owner_id>0, no_service_albums is ignored.
     * @return [VKRequest] with [PhotosGetAllResponse]
     */
    fun photosGetAll(
        ownerId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        photoSizes: Boolean? = null,
        noServiceAlbums: Boolean? = null,
        needHidden: Boolean? = null,
        skipHidden: Boolean? = null
    ): VKRequest<PhotosGetAllResponse> = NewApiRequest("photos.getAll") {
        GsonHolder.gson.fromJson(it, PhotosGetAllResponse::class.java)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        photoSizes?.let { addParam("photo_sizes", it) }
        noServiceAlbums?.let { addParam("no_service_albums", it) }
        needHidden?.let { addParam("need_hidden", it) }
        skipHidden?.let { addParam("skip_hidden", it) }
    }

    /**
     * Returns a list of photos belonging to a user or community, in reverse chronological order.
     *
     * @param ownerId - ID of a user or community that owns the photos. Use a negative value to
     * designate a community ID.
     * @param offset - Offset needed to return a specific subset of photos. By default, '0'.
     * @param count - Number of photos to return.
     * @param photoSizes - '1' - to return image sizes in [vk.com/dev/photo_sizes|special format].
     * @param noServiceAlbums - '1' - to return photos only from standard albums, '0' - to return
     * all photos including those in service albums, e.g., 'My wall photos' (default)
     * @param needHidden - '1' - to show information about photos being hidden from the block above
     * the wall.
     * @param skipHidden - '1' - not to return photos being hidden from the block above the wall.
     * Works only with owner_id>0, no_service_albums is ignored.
     * @return [VKRequest] with [PhotosGetAllExtendedResponse]
     */
    fun photosGetAllExtended(
        ownerId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        photoSizes: Boolean? = null,
        noServiceAlbums: Boolean? = null,
        needHidden: Boolean? = null,
        skipHidden: Boolean? = null
    ): VKRequest<PhotosGetAllExtendedResponse> = NewApiRequest("photos.getAll") {
        GsonHolder.gson.fromJson(it, PhotosGetAllExtendedResponse::class.java)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        addParam("extended", true)
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
     * @return [VKRequest] with [PhotosGetAllCommentsResponse]
     */
    fun photosGetAllComments(
        ownerId: UserId? = null,
        albumId: Int? = null,
        needLikes: Boolean? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<PhotosGetAllCommentsResponse> = NewApiRequest("photos.getAllComments") {
        GsonHolder.gson.fromJson(it, PhotosGetAllCommentsResponse::class.java)
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
     * @param photoSizes - '1' - to return photo sizes in a
     * @return [VKRequest] with [Unit]
     */
    fun photosGetById(photos: List<String>, photoSizes: Boolean? = null):
            VKRequest<List<PhotosPhoto>> = NewApiRequest("photos.getById") {
        val typeToken = object: TypeToken<List<PhotosPhoto>>() {}.type
        GsonHolder.gson.fromJson<List<PhotosPhoto>>(it, typeToken)
    }
    .apply {
        addParam("photos", photos)
        photoSizes?.let { addParam("photo_sizes", it) }
    }

    /**
     * Returns information about photos by their IDs.
     *
     * @param photos - IDs separated with a comma, that are IDs of users who posted photos and IDs
     * of photos themselves with an underscore character between such IDs. To get information about a
     * photo in the group album, you shall specify group ID instead of user ID. Example_
     * "1_129207899,6492_135055734, , -20629724_271945303"
     * @param photoSizes - '1' - to return photo sizes in a
     * @return [VKRequest] with [Unit]
     */
    fun photosGetByIdExtended(photos: List<String>, photoSizes: Boolean? = null):
            VKRequest<List<PhotosPhotoFull>> = NewApiRequest("photos.getById") {
        val typeToken = object: TypeToken<List<PhotosPhotoFull>>() {}.type
        GsonHolder.gson.fromJson<List<PhotosPhotoFull>>(it, typeToken)
    }
    .apply {
        addParam("photos", photos)
        addParam("extended", true)
        photoSizes?.let { addParam("photo_sizes", it) }
    }

    /**
     * Returns an upload link for chat cover pictures.
     *
     * @param chatId - ID of the chat for which you want to upload a cover photo.
     * @param cropX
     * @param cropY
     * @param cropWidth - Width (in pixels) of the photo after cropping.
     * @return [VKRequest] with [BaseUploadServer]
     */
    fun photosGetChatUploadServer(
        chatId: Int,
        cropX: Int? = null,
        cropY: Int? = null,
        cropWidth: Int? = null
    ): VKRequest<BaseUploadServer> = NewApiRequest("photos.getChatUploadServer") {
        GsonHolder.gson.fromJson(it, BaseUploadServer::class.java)
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
     * @param fields
     * @return [VKRequest] with [PhotosGetCommentsResponse]
     */
    fun photosGetComments(
        photoId: Int,
        ownerId: UserId? = null,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: PhotosGetCommentsSort? = null,
        accessKey: String? = null,
        fields: List<UsersFields>? = null
    ): VKRequest<PhotosGetCommentsResponse> = NewApiRequest("photos.getComments") {
        GsonHolder.gson.fromJson(it, PhotosGetCommentsResponse::class.java)
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
     * @return [VKRequest] with [PhotosGetCommentsExtendedResponse]
     */
    fun photosGetCommentsExtended(
        photoId: Int,
        ownerId: UserId? = null,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: PhotosGetCommentsExtendedSort? = null,
        accessKey: String? = null,
        fields: List<UsersFields>? = null
    ): VKRequest<PhotosGetCommentsExtendedResponse> = NewApiRequest("photos.getComments") {
        GsonHolder.gson.fromJson(it, PhotosGetCommentsExtendedResponse::class.java)
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
     * @return [VKRequest] with [BaseUploadServer]
     */
    fun photosGetMarketAlbumUploadServer(groupId: UserId): VKRequest<BaseUploadServer> =
            NewApiRequest("photos.getMarketAlbumUploadServer") {
        GsonHolder.gson.fromJson(it, BaseUploadServer::class.java)
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
     * @return [VKRequest] with [BaseUploadServer]
     */
    fun photosGetMarketUploadServer(
        groupId: UserId,
        mainPhoto: Boolean? = null,
        cropX: Int? = null,
        cropY: Int? = null,
        cropWidth: Int? = null
    ): VKRequest<BaseUploadServer> = NewApiRequest("photos.getMarketUploadServer") {
        GsonHolder.gson.fromJson(it, BaseUploadServer::class.java)
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
     * @return [VKRequest] with [PhotosPhotoUpload]
     */
    fun photosGetMessagesUploadServer(peerId: Int? = null): VKRequest<PhotosPhotoUpload> =
            NewApiRequest("photos.getMessagesUploadServer") {
        GsonHolder.gson.fromJson(it, PhotosPhotoUpload::class.java)
    }
    .apply {
        peerId?.let { addParam("peer_id", it) }
    }

    /**
     * Returns a list of photos with tags that have not been viewed.
     *
     * @param offset - Offset needed to return a specific subset of photos.
     * @param count - Number of photos to return.
     * @return [VKRequest] with [PhotosGetNewTagsResponse]
     */
    fun photosGetNewTags(offset: Int? = null, count: Int? = null):
            VKRequest<PhotosGetNewTagsResponse> = NewApiRequest("photos.getNewTags") {
        GsonHolder.gson.fromJson(it, PhotosGetNewTagsResponse::class.java)
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
     * @return [VKRequest] with [BaseUploadServer]
     */
    fun photosGetOwnerCoverPhotoUploadServer(
        groupId: UserId,
        cropX: Int? = null,
        cropY: Int? = null,
        cropX2: Int? = null,
        cropY2: Int? = null
    ): VKRequest<BaseUploadServer> = NewApiRequest("photos.getOwnerCoverPhotoUploadServer") {
        GsonHolder.gson.fromJson(it, BaseUploadServer::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        cropX?.let { addParam("crop_x", it, min = 0) }
        cropY?.let { addParam("crop_y", it, min = 0) }
        cropX2?.let { addParam("crop_x2", it, min = 0) }
        cropY2?.let { addParam("crop_y2", it, min = 0) }
    }

    /**
     * Returns an upload server address for a profile or community photo.
     *
     * @param ownerId - identifier of a community or current user. "Note that community id must be
     * negative. 'owner_id=1' - user, 'owner_id=-1' - community, "
     * @return [VKRequest] with [BaseUploadServer]
     */
    fun photosGetOwnerPhotoUploadServer(ownerId: UserId? = null): VKRequest<BaseUploadServer> =
            NewApiRequest("photos.getOwnerPhotoUploadServer") {
        GsonHolder.gson.fromJson(it, BaseUploadServer::class.java)
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
    ): VKRequest<List<PhotosPhotoTag>> = NewApiRequest("photos.getTags") {
        val typeToken = object: TypeToken<List<PhotosPhotoTag>>() {}.type
        GsonHolder.gson.fromJson<List<PhotosPhotoTag>>(it, typeToken)
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
     * @return [VKRequest] with [PhotosPhotoUpload]
     */
    fun photosGetUploadServer(albumId: Int? = null, groupId: UserId? = null):
            VKRequest<PhotosPhotoUpload> = NewApiRequest("photos.getUploadServer") {
        GsonHolder.gson.fromJson(it, PhotosPhotoUpload::class.java)
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
     * @param sort - Sort order_ '1' - by date the tag was added in ascending order, '0' - by date
     * the tag was added in descending order
     * @return [VKRequest] with [PhotosGetUserPhotosResponse]
     */
    fun photosGetUserPhotos(
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: String? = null
    ): VKRequest<PhotosGetUserPhotosResponse> = NewApiRequest("photos.getUserPhotos") {
        GsonHolder.gson.fromJson(it, PhotosGetUserPhotosResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        sort?.let { addParam("sort", it) }
    }

    /**
     * Returns a list of photos in which a user is tagged.
     *
     * @param userId - User ID.
     * @param offset - Offset needed to return a specific subset of photos. By default, '0'.
     * @param count - Number of photos to return. Maximum value is 1000.
     * @param sort - Sort order_ '1' - by date the tag was added in ascending order, '0' - by date
     * the tag was added in descending order
     * @return [VKRequest] with [PhotosGetUserPhotosExtendedResponse]
     */
    fun photosGetUserPhotosExtended(
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: String? = null
    ): VKRequest<PhotosGetUserPhotosExtendedResponse> = NewApiRequest("photos.getUserPhotos") {
        GsonHolder.gson.fromJson(it, PhotosGetUserPhotosExtendedResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        addParam("extended", true)
        sort?.let { addParam("sort", it) }
    }

    /**
     * Returns the server address for photo upload onto a user's wall.
     *
     * @param groupId - ID of community to whose wall the photo will be uploaded.
     * @return [VKRequest] with [PhotosPhotoUpload]
     */
    fun photosGetWallUploadServer(groupId: UserId? = null): VKRequest<PhotosPhotoUpload> =
            NewApiRequest("photos.getWallUploadServer") {
        GsonHolder.gson.fromJson(it, PhotosPhotoUpload::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosMakeCover(
        photoId: Int,
        ownerId: UserId? = null,
        albumId: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.makeCover") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @param photoId - Photo ID.
     * @param ownerId - ID of the user or community that owns the photo.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosMove(
        targetAlbumId: Int,
        photoId: Int,
        ownerId: UserId? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.move") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("target_album_id", targetAlbumId)
        addParam("photo_id", photoId)
        ownerId?.let { addParam("owner_id", it) }
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
        GsonHolder.gson.fromJson(it, Int::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosRemoveTag(
        photoId: Int,
        tagId: Int,
        ownerId: UserId? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.removeTag") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosReorderAlbums(
        albumId: Int,
        ownerId: UserId? = null,
        before: Int? = null,
        after: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.reorderAlbums") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosReorderPhotos(
        photoId: Int,
        ownerId: UserId? = null,
        before: Int? = null,
        after: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.reorderPhotos") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * extremism, '3' - violence, '4' - drug propaganda, '5' - adult material, '6' - insult, abuse
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosReport(
        ownerId: UserId,
        photoId: Int,
        reason: PhotosReportReason? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.report") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosReportComment(
        ownerId: UserId,
        commentId: Int,
        reason: PhotosReportCommentReason? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("photos.reportComment") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun photosRestore(photoId: Int, ownerId: UserId? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("photos.restore") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun photosRestoreComment(commentId: Int, ownerId: UserId? = null): VKRequest<BaseBoolInt> =
            NewApiRequest("photos.restoreComment") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
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
    ): VKRequest<List<PhotosPhoto>> = NewApiRequest("photos.save") {
        val typeToken = object: TypeToken<List<PhotosPhoto>>() {}.type
        GsonHolder.gson.fromJson<List<PhotosPhoto>>(it, typeToken)
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
    ): VKRequest<List<PhotosPhoto>> = NewApiRequest("photos.saveMarketAlbumPhoto") {
        val typeToken = object: TypeToken<List<PhotosPhoto>>() {}.type
        GsonHolder.gson.fromJson<List<PhotosPhoto>>(it, typeToken)
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
    ): VKRequest<List<PhotosPhoto>> = NewApiRequest("photos.saveMarketPhoto") {
        val typeToken = object: TypeToken<List<PhotosPhoto>>() {}.type
        GsonHolder.gson.fromJson<List<PhotosPhoto>>(it, typeToken)
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
    ): VKRequest<List<PhotosPhoto>> = NewApiRequest("photos.saveMessagesPhoto") {
        val typeToken = object: TypeToken<List<PhotosPhoto>>() {}.type
        GsonHolder.gson.fromJson<List<PhotosPhoto>>(it, typeToken)
    }
    .apply {
        addParam("photo", photo)
        server?.let { addParam("server", it) }
        hash?.let { addParam("hash", it) }
    }

    /**
     * Saves cover photo after successful uploading.
     *
     * @param hash - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @param photo - Parameter returned when photos are [vk.com/dev/upload_files|uploaded to
     * server].
     * @return [VKRequest] with [PhotosSaveOwnerCoverPhotoResponse]
     */
    fun photosSaveOwnerCoverPhoto(hash: String, photo: String):
            VKRequest<PhotosSaveOwnerCoverPhotoResponse> =
            NewApiRequest("photos.saveOwnerCoverPhoto") {
        GsonHolder.gson.fromJson(it, PhotosSaveOwnerCoverPhotoResponse::class.java)
    }
    .apply {
        addParam("hash", hash)
        addParam("photo", photo)
    }

    /**
     * Saves a profile or community photo. Upload URL can be got with the
     * [vk.com/dev/photos.getOwnerPhotoUploadServer|photos.getOwnerPhotoUploadServer] method.
     *
     * @param server - parameter returned after [vk.com/dev/upload_files|photo upload].
     * @param hash - parameter returned after [vk.com/dev/upload_files|photo upload].
     * @param photo - parameter returned after [vk.com/dev/upload_files|photo upload].
     * @return [VKRequest] with [PhotosSaveOwnerPhotoResponse]
     */
    fun photosSaveOwnerPhoto(
        server: String? = null,
        hash: String? = null,
        photo: String? = null
    ): VKRequest<PhotosSaveOwnerPhotoResponse> = NewApiRequest("photos.saveOwnerPhoto") {
        GsonHolder.gson.fromJson(it, PhotosSaveOwnerPhotoResponse::class.java)
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
    ): VKRequest<List<PhotosPhoto>> = NewApiRequest("photos.saveWallPhoto") {
        val typeToken = object: TypeToken<List<PhotosPhoto>>() {}.type
        GsonHolder.gson.fromJson<List<PhotosPhoto>>(it, typeToken)
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
     * @return [VKRequest] with [PhotosSearchResponse]
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
    ): VKRequest<PhotosSearchResponse> = NewApiRequest("photos.search") {
        GsonHolder.gson.fromJson(it, PhotosSearchResponse::class.java)
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
}
