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

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseLikes
import com.vk.sdk.api.base.dto.BasePropertyExists
import com.vk.sdk.api.base.dto.BaseRepostsInfo
import com.vk.sdk.api.board.dto.BoardTopic
import com.vk.sdk.api.media.dto.MediaRestriction
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
 * @param attachments no description
 * @param comments Number of comments
 * @param copyOwnerId ID of the source post owner
 * @param copyPostId ID of the source post
 * @param date Date when the comment has been added in Unixtime
 * @param fromId Post author ID
 * @param geo no description
 * @param id Comment ID
 * @param isFavorite Whether video is added to bookmarks
 * @param likes no description
 * @param postId Post ID
 * @param postSource no description
 * @param postType no description
 * @param reposts no description
 * @param signerId Post signer ID
 * @param text Comment text
 * @param toId Wall owner's ID
 * @param accessKey Video access key
 * @param albumId Album ID
 * @param height Video height
 * @param images no description
 * @param lat Latitude
 * @param long Longitude
 * @param ownerId Author ID
 * @param photo256 URL of image with 2560 px width
 * @param canComment Information whether current user can comment the video
 * @param place no description
 * @param sizes no description
 * @param userId Id of the user who uploaded the video if it was uploaded to a group by member
 * @param width Video width
 * @param hasTags Whether photo has attached tag links
 * @param restrictions no description
 * @param created Date when the topic has been created in Unixtime
 * @param createdBy Creator ID
 * @param isClosed Information whether the topic is closed
 * @param isFixed Information whether the topic is fixed
 * @param title Video title
 * @param updated Date when the topic has been updated in Unixtime
 * @param updatedBy ID of user who updated the topic
 * @param addingDate Date when the video has been added in Unixtime
 * @param canEdit Information whether current user can edit the video
 * @param canLike Information whether current user can like the video
 * @param canRepost Information whether current user can repost the video
 * @param canSubscribe Information whether current user can subscribe to author of the video
 * @param canAddToFaves Information whether current user can add the video to favourites
 * @param canAdd Information whether current user can add the video
 * @param canAttachLink Information whether current user can attach action button to the video
 * @param isPrivate 1 if video is private
 * @param description Video description
 * @param duration Video duration in seconds
 * @param image no description
 * @param firstFrame no description
 * @param player Video embed URL
 * @param processing Returns if the video is processing
 * @param converting 1 if  video is being converted
 * @param restriction no description
 * @param added 1 if video is added to user's albums
 * @param isSubscribed 1 if user is subscribed to author of the video
 * @param trackCode no description
 * @param repeat Information whether the video is repeated
 * @param type no description
 * @param views Number of views
 * @param localViews If video is external, number of views on vk
 * @param contentRestricted Restriction code
 * @param contentRestrictedMessage Restriction text
 * @param balance Live donations balance
 * @param liveStatus Live stream status
 * @param live 1 if the video is a live stream
 * @param upcoming 1 if the video is an upcoming stream
 * @param spectators Number of spectators of the stream
 * @param platform External platform
 * @param photo no description
 * @param post no description
 * @param topic no description
 * @param video no description
 */
data class NotificationsNotificationParent(
    @SerializedName(value="attachments")
    val attachments: List<WallWallpostAttachment>? = null,
    @SerializedName(value="comments")
    val comments: Int? = null,
    @SerializedName(value="copy_owner_id")
    val copyOwnerId: Int? = null,
    @SerializedName(value="copy_post_id")
    val copyPostId: Int? = null,
    @SerializedName(value="date")
    val date: Int? = null,
    @SerializedName(value="from_id")
    val fromId: Int? = null,
    @SerializedName(value="geo")
    val geo: WallGeo? = null,
    @SerializedName(value="id")
    val id: Int? = null,
    @SerializedName(value="is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName(value="likes")
    val likes: BaseLikes? = null,
    @SerializedName(value="post_id")
    val postId: Int? = null,
    @SerializedName(value="post_source")
    val postSource: WallPostSource? = null,
    @SerializedName(value="post_type")
    val postType: WallPostType? = null,
    @SerializedName(value="reposts")
    val reposts: BaseRepostsInfo? = null,
    @SerializedName(value="signer_id")
    val signerId: Int? = null,
    @SerializedName(value="text")
    val text: String? = null,
    @SerializedName(value="to_id")
    val toId: Int? = null,
    @SerializedName(value="access_key")
    val accessKey: String? = null,
    @SerializedName(value="album_id")
    val albumId: Int? = null,
    @SerializedName(value="height")
    val height: Int? = null,
    @SerializedName(value="images")
    val images: List<PhotosImage>? = null,
    @SerializedName(value="lat")
    val lat: Float? = null,
    @SerializedName(value="long")
    val long: Float? = null,
    @SerializedName(value="owner_id")
    val ownerId: Int? = null,
    @SerializedName(value="photo_256")
    val photo256: String? = null,
    @SerializedName(value="can_comment")
    val canComment: BaseBoolInt? = null,
    @SerializedName(value="place")
    val place: String? = null,
    @SerializedName(value="sizes")
    val sizes: List<PhotosPhotoSizes>? = null,
    @SerializedName(value="user_id")
    val userId: Int? = null,
    @SerializedName(value="width")
    val width: Int? = null,
    @SerializedName(value="has_tags")
    val hasTags: Boolean? = null,
    @SerializedName(value="restrictions")
    val restrictions: MediaRestriction? = null,
    @SerializedName(value="created")
    val created: Int? = null,
    @SerializedName(value="created_by")
    val createdBy: Int? = null,
    @SerializedName(value="is_closed")
    val isClosed: BaseBoolInt? = null,
    @SerializedName(value="is_fixed")
    val isFixed: BaseBoolInt? = null,
    @SerializedName(value="title")
    val title: String? = null,
    @SerializedName(value="updated")
    val updated: Int? = null,
    @SerializedName(value="updated_by")
    val updatedBy: Int? = null,
    @SerializedName(value="adding_date")
    val addingDate: Int? = null,
    @SerializedName(value="can_edit")
    val canEdit: BaseBoolInt? = null,
    @SerializedName(value="can_like")
    val canLike: BaseBoolInt? = null,
    @SerializedName(value="can_repost")
    val canRepost: BaseBoolInt? = null,
    @SerializedName(value="can_subscribe")
    val canSubscribe: BaseBoolInt? = null,
    @SerializedName(value="can_add_to_faves")
    val canAddToFaves: BaseBoolInt? = null,
    @SerializedName(value="can_add")
    val canAdd: BaseBoolInt? = null,
    @SerializedName(value="can_attach_link")
    val canAttachLink: BaseBoolInt? = null,
    @SerializedName(value="is_private")
    val isPrivate: BaseBoolInt? = null,
    @SerializedName(value="description")
    val description: String? = null,
    @SerializedName(value="duration")
    val duration: Int? = null,
    @SerializedName(value="image")
    val image: List<VideoVideoImage>? = null,
    @SerializedName(value="first_frame")
    val firstFrame: List<VideoVideoImage>? = null,
    @SerializedName(value="player")
    val player: String? = null,
    @SerializedName(value="processing")
    val processing: BasePropertyExists? = null,
    @SerializedName(value="converting")
    val converting: BaseBoolInt? = null,
    @SerializedName(value="restriction")
    val restriction: MediaRestriction? = null,
    @SerializedName(value="added")
    val added: BaseBoolInt? = null,
    @SerializedName(value="is_subscribed")
    val isSubscribed: BaseBoolInt? = null,
    @SerializedName(value="track_code")
    val trackCode: String? = null,
    @SerializedName(value="repeat")
    val repeat: BasePropertyExists? = null,
    @SerializedName(value="type")
    val type: Type? = null,
    @SerializedName(value="views")
    val views: Int? = null,
    @SerializedName(value="local_views")
    val localViews: Int? = null,
    @SerializedName(value="content_restricted")
    val contentRestricted: Int? = null,
    @SerializedName(value="content_restricted_message")
    val contentRestrictedMessage: String? = null,
    @SerializedName(value="balance")
    val balance: Int? = null,
    @SerializedName(value="live_status")
    val liveStatus: LiveStatus? = null,
    @SerializedName(value="live")
    val live: BasePropertyExists? = null,
    @SerializedName(value="upcoming")
    val upcoming: BasePropertyExists? = null,
    @SerializedName(value="spectators")
    val spectators: Int? = null,
    @SerializedName(value="platform")
    val platform: String? = null,
    @SerializedName(value="photo")
    val photo: PhotosPhoto? = null,
    @SerializedName(value="post")
    val post: WallWallpost? = null,
    @SerializedName(value="topic")
    val topic: BoardTopic? = null,
    @SerializedName(value="video")
    val video: VideoVideo? = null
) {
    enum class Type(
        val value: String
    ) {
        VIDEO("video"),

        MUSIC_VIDEO("music_video"),

        MOVIE("movie");

        class Serializer : JsonDeserializer<Type> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: java.lang.reflect.Type?,
                context: JsonDeserializationContext?
            ): Type = values().first { it.value.toString() == json!!.asJsonPrimitive.toString() }
        }
    }

    enum class LiveStatus(
        val value: String
    ) {
        WAITING("waiting"),

        STARTED("started"),

        FINISHED("finished"),

        FAILED("failed"),

        UPCOMING("upcoming");

        class Serializer : JsonDeserializer<LiveStatus> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: java.lang.reflect.Type?,
                context: JsonDeserializationContext?
            ): LiveStatus = values().first { it.value.toString() ==
                    json!!.asJsonPrimitive.toString() }
        }
    }
}
