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
package com.vk.sdk.api.video.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.audio.dto.AudioArtist
import com.vk.sdk.api.audio.dto.AudioGenre
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseLikes
import com.vk.sdk.api.base.dto.BasePropertyExists
import com.vk.sdk.api.base.dto.BaseRepostsInfo
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param accessKey - Video access key
 * @param addingDate - Date when the video has been added in Unixtime
 * @param canComment - Information whether current user can comment the video
 * @param canEdit - Information whether current user can edit the video
 * @param canLike - Information whether current user can like the video
 * @param canRepost - Information whether current user can repost the video
 * @param canSubscribe - Information whether current user can subscribe to author of the video
 * @param canAddToFaves - Information whether current user can add the video to favourites
 * @param canAdd - Information whether current user can add the video
 * @param canAttachLink - Information whether current user can attach action button to the video
 * @param isPrivate - 1 if video is private
 * @param comments - Number of comments
 * @param date - Date when video has been uploaded in Unixtime
 * @param description - Video description
 * @param duration - Video duration in seconds
 * @param image
 * @param firstFrame
 * @param width - Video width
 * @param height - Video height
 * @param id - Video ID
 * @param ownerId - Video owner ID
 * @param userId - Id of the user who uploaded the video if it was uploaded to a group by member
 * @param title - Video title
 * @param isFavorite - Whether video is added to bookmarks
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
 * @param likes
 * @param reposts
 * @param isExplicit - 1 if music clip and has explicit content
 * @param mainArtists - Main music artists of the clip
 * @param featuredArtists - Featured music artists of the clip
 * @param subtitle - Music clip subtitle
 * @param releaseDate - Release date of the music clip
 * @param genres - Music genres of the clip
 */
data class VideoVideo(
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("adding_date")
    val addingDate: Int? = null,
    @SerializedName("can_comment")
    val canComment: BaseBoolInt? = null,
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
    @SerializedName("comments")
    val comments: Int? = null,
    @SerializedName("date")
    val date: Int? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("duration")
    val duration: Int? = null,
    @SerializedName("image")
    val image: List<VideoVideoImage>? = null,
    @SerializedName("first_frame")
    val firstFrame: List<VideoVideoImage>? = null,
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("owner_id")
    val ownerId: UserId? = null,
    @SerializedName("user_id")
    val userId: UserId? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null,
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
    val type: VideoVideo.Type? = null,
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
    val liveStatus: VideoVideo.LiveStatus? = null,
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
    @SerializedName("likes")
    val likes: BaseLikes? = null,
    @SerializedName("reposts")
    val reposts: BaseRepostsInfo? = null,
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
    val genres: List<AudioGenre>? = null
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
