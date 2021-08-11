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
package com.vk.sdk.api.notifications.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.audio.dto.AudioArtist
import com.vk.sdk.api.audio.dto.AudioGenre
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseLikes
import com.vk.sdk.api.base.dto.BasePropertyExists
import com.vk.sdk.api.base.dto.BaseRepostsInfo
import com.vk.sdk.api.board.dto.BoardTopic
import com.vk.sdk.api.photos.dto.PhotosImage
import com.vk.sdk.api.photos.dto.PhotosPhoto
import com.vk.sdk.api.photos.dto.PhotosPhotoSizes
import com.vk.sdk.api.video.dto.VideoVideo
import com.vk.sdk.api.video.dto.VideoVideoImage
import com.vk.sdk.api.wall.dto.WallGeo
import com.vk.sdk.api.wall.dto.WallPostSource
import com.vk.sdk.api.wall.dto.WallPostType
import com.vk.sdk.api.wall.dto.WallWallpost
import com.vk.sdk.api.wall.dto.WallWallpostAttachment
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param attachments
 * @param comments - Number of comments
 * @param copyOwnerId - ID of the source post owner
 * @param copyPostId - ID of the source post
 * @param date - Date when the comment has been added in Unixtime
 * @param fromId - Post author ID
 * @param geo
 * @param id - Comment ID
 * @param isFavorite - Whether video is added to bookmarks
 * @param likes
 * @param postId - Post ID
 * @param postSource
 * @param postType
 * @param reposts
 * @param signerId - Post signer ID
 * @param text - Comment text
 * @param toId - Wall owner's ID
 * @param accessKey - Video access key
 * @param height - Video height
 * @param images
 * @param lat - Latitude
 * @param long - Longitude
 * @param ownerId - Author ID
 * @param photo256 - URL of image with 2560 px width
 * @param canComment - Information whether current user can comment the video
 * @param place
 * @param sizes
 * @param userId - Id of the user who uploaded the video if it was uploaded to a group by member
 * @param width - Video width
 * @param hasTags - Whether photo has attached tag links
 * @param created - Date when the topic has been created in Unixtime
 * @param createdBy - Creator ID
 * @param isClosed - Information whether the topic is closed
 * @param isFixed - Information whether the topic is fixed
 * @param title - Video title
 * @param updated - Date when the topic has been updated in Unixtime
 * @param updatedBy - ID of user who updated the topic
 * @param addingDate - Date when the video has been added in Unixtime
 * @param canEdit - Information whether current user can edit the video
 * @param canLike - Information whether current user can like the video
 * @param canRepost - Information whether current user can repost the video
 * @param canSubscribe - Information whether current user can subscribe to author of the video
 * @param canAddToFaves - Information whether current user can add the video to favourites
 * @param canAdd - Information whether current user can add the video
 * @param canAttachLink - Information whether current user can attach action button to the video
 * @param isPrivate - 1 if video is private
 * @param description - Video description
 * @param duration - Video duration in seconds
 * @param image
 * @param firstFrame
 * @param player - Video embed URL
 * @param processing - Returns if the video is processing
 * @param converting - 1 if  video is being converted
 * @param added - 1 if video is added to user's albums
 * @param isSubscribed - 1 if user is subscribed to author of the video
 * @param trackCode
 * @param repeat - Information whether the video is repeated
 * @param type
 * @param views - Number of views
 * @param localViews - If video is external, number of views on vk
 * @param contentRestricted - Restriction code
 * @param contentRestrictedMessage - Restriction text
 * @param balance - Live donations balance
 * @param liveStatus - Live stream status
 * @param live - 1 if the video is a live stream
 * @param upcoming - 1 if the video is an upcoming stream
 * @param liveStartTime - Date in Unixtime when the live stream is scheduled to start by the author
 * @param liveNotify - Whether current user is subscribed to the upcoming live stream notification
 * (if not subscribed to the author)
 * @param spectators - Number of spectators of the stream
 * @param platform - External platform
 * @param isExplicit - 1 if music clip and has explicit content
 * @param mainArtists - Main music artists of the clip
 * @param featuredArtists - Featured music artists of the clip
 * @param subtitle - Music clip subtitle
 * @param releaseDate - Release date of the music clip
 * @param genres - Music genres of the clip
 * @param photo
 * @param post
 * @param topic
 * @param video
 */
data class NotificationsNotificationParent(
    @SerializedName("attachments")
    val attachments: List<WallWallpostAttachment>? = null,
    @SerializedName("comments")
    val comments: Int? = null,
    @SerializedName("copy_owner_id")
    val copyOwnerId: Int? = null,
    @SerializedName("copy_post_id")
    val copyPostId: Int? = null,
    @SerializedName("date")
    val date: Int? = null,
    @SerializedName("from_id")
    val fromId: Int? = null,
    @SerializedName("geo")
    val geo: WallGeo? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName("likes")
    val likes: BaseLikes? = null,
    @SerializedName("post_id")
    val postId: Int? = null,
    @SerializedName("post_source")
    val postSource: WallPostSource? = null,
    @SerializedName("post_type")
    val postType: WallPostType? = null,
    @SerializedName("reposts")
    val reposts: BaseRepostsInfo? = null,
    @SerializedName("signer_id")
    val signerId: Int? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("to_id")
    val toId: Int? = null,
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("images")
    val images: List<PhotosImage>? = null,
    @SerializedName("lat")
    val lat: Float? = null,
    @SerializedName("long")
    val long: Float? = null,
    @SerializedName("owner_id")
    val ownerId: UserId? = null,
    @SerializedName("photo_256")
    val photo256: String? = null,
    @SerializedName("can_comment")
    val canComment: BaseBoolInt? = null,
    @SerializedName("place")
    val place: String? = null,
    @SerializedName("sizes")
    val sizes: List<PhotosPhotoSizes>? = null,
    @SerializedName("user_id")
    val userId: UserId? = null,
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("has_tags")
    val hasTags: Boolean? = null,
    @SerializedName("created")
    val created: Int? = null,
    @SerializedName("created_by")
    val createdBy: Int? = null,
    @SerializedName("is_closed")
    val isClosed: BaseBoolInt? = null,
    @SerializedName("is_fixed")
    val isFixed: BaseBoolInt? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("updated")
    val updated: Int? = null,
    @SerializedName("updated_by")
    val updatedBy: Int? = null,
    @SerializedName("adding_date")
    val addingDate: Int? = null,
    @SerializedName("can_edit")
    val canEdit: BaseBoolInt? = null,
    @SerializedName("can_like")
    val canLike: BaseBoolInt? = null,
    @SerializedName("can_repost")
    val canRepost: BaseBoolInt? = null,
    @SerializedName("can_subscribe")
    val canSubscribe: BaseBoolInt? = null,
    @SerializedName("can_add_to_faves")
    val canAddToFaves: BaseBoolInt? = null,
    @SerializedName("can_add")
    val canAdd: BaseBoolInt? = null,
    @SerializedName("can_attach_link")
    val canAttachLink: BaseBoolInt? = null,
    @SerializedName("is_private")
    val isPrivate: BaseBoolInt? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("duration")
    val duration: Int? = null,
    @SerializedName("image")
    val image: List<VideoVideoImage>? = null,
    @SerializedName("first_frame")
    val firstFrame: List<VideoVideoImage>? = null,
    @SerializedName("player")
    val player: String? = null,
    @SerializedName("processing")
    val processing: BasePropertyExists? = null,
    @SerializedName("converting")
    val converting: BaseBoolInt? = null,
    @SerializedName("added")
    val added: BaseBoolInt? = null,
    @SerializedName("is_subscribed")
    val isSubscribed: BaseBoolInt? = null,
    @SerializedName("track_code")
    val trackCode: String? = null,
    @SerializedName("repeat")
    val repeat: BasePropertyExists? = null,
    @SerializedName("type")
    val type: NotificationsNotificationParent.Type? = null,
    @SerializedName("views")
    val views: Int? = null,
    @SerializedName("local_views")
    val localViews: Int? = null,
    @SerializedName("content_restricted")
    val contentRestricted: Int? = null,
    @SerializedName("content_restricted_message")
    val contentRestrictedMessage: String? = null,
    @SerializedName("balance")
    val balance: Int? = null,
    @SerializedName("live_status")
    val liveStatus: NotificationsNotificationParent.LiveStatus? = null,
    @SerializedName("live")
    val live: BasePropertyExists? = null,
    @SerializedName("upcoming")
    val upcoming: BasePropertyExists? = null,
    @SerializedName("live_start_time")
    val liveStartTime: Int? = null,
    @SerializedName("live_notify")
    val liveNotify: BaseBoolInt? = null,
    @SerializedName("spectators")
    val spectators: Int? = null,
    @SerializedName("platform")
    val platform: String? = null,
    @SerializedName("is_explicit")
    val isExplicit: BaseBoolInt? = null,
    @SerializedName("main_artists")
    val mainArtists: List<AudioArtist>? = null,
    @SerializedName("featured_artists")
    val featuredArtists: List<AudioArtist>? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("release_date")
    val releaseDate: Int? = null,
    @SerializedName("genres")
    val genres: List<AudioGenre>? = null,
    @SerializedName("photo")
    val photo: PhotosPhoto? = null,
    @SerializedName("post")
    val post: WallWallpost? = null,
    @SerializedName("topic")
    val topic: BoardTopic? = null,
    @SerializedName("video")
    val video: VideoVideo? = null
) {
    enum class Type(
        val value: String
    ) {
        @SerializedName("video")
        VIDEO("video"),

        @SerializedName("music_video")
        MUSIC_VIDEO("music_video"),

        @SerializedName("movie")
        MOVIE("movie");
    }

    enum class LiveStatus(
        val value: String
    ) {
        @SerializedName("waiting")
        WAITING("waiting"),

        @SerializedName("started")
        STARTED("started"),

        @SerializedName("finished")
        FINISHED("finished"),

        @SerializedName("failed")
        FAILED("failed"),

        @SerializedName("upcoming")
        UPCOMING("upcoming");
    }
}
