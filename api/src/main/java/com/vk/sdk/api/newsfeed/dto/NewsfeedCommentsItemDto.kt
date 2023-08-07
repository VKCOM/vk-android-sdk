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
package com.vk.sdk.api.newsfeed.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.audio.dto.AudioArtistDto
import com.vk.sdk.api.audio.dto.AudioGenreDto
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseLikesDto
import com.vk.sdk.api.base.dto.BaseLikesInfoDto
import com.vk.sdk.api.base.dto.BaseObjectCountDto
import com.vk.sdk.api.base.dto.BasePropertyExistsDto
import com.vk.sdk.api.base.dto.BaseRepostsInfoDto
import com.vk.sdk.api.market.dto.MarketMarketCategoryDto
import com.vk.sdk.api.market.dto.MarketMarketItemAvailabilityDto
import com.vk.sdk.api.market.dto.MarketPriceDto
import com.vk.sdk.api.photos.dto.PhotosImageDto
import com.vk.sdk.api.photos.dto.PhotosPhotoSizesDto
import com.vk.sdk.api.video.dto.VideoVideoImageDto
import com.vk.sdk.api.wall.dto.WallGeoDto
import com.vk.sdk.api.wall.dto.WallPostCopyrightDto
import com.vk.sdk.api.wall.dto.WallPostSourceDto
import com.vk.sdk.api.wall.dto.WallPostTypeDto
import com.vk.sdk.api.wall.dto.WallViewsDto
import com.vk.sdk.api.wall.dto.WallWallpostAttachmentDto
import com.vk.sdk.api.wall.dto.WallWallpostDonutDto
import com.vk.sdk.api.wall.dto.WallWallpostFullDto
import java.lang.IllegalStateException
import java.lang.reflect.Type
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

sealed class NewsfeedCommentsItemDto {
    /**
     * @param type
     * @param text
     * @param comments
     * @param likes
     * @param sourceId
     * @param date
     * @param postId
     */
    data class NewsfeedCommentsItemTypeTopicDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("comments")
        val comments: NewsfeedCommentsBaseDto? = null,
        @SerializedName("likes")
        val likes: BaseLikesDto? = null,
        @SerializedName("source_id")
        val sourceId: UserId? = null,
        @SerializedName("date")
        val date: Int? = null,
        @SerializedName("post_id")
        val postId: Int? = null
    ) : NewsfeedCommentsItemDto()

    /**
     * @param albumId - Album ID
     * @param date - Date when uploaded
     * @param id - Photo ID
     * @param ownerId - Photo owner's ID
     * @param hasTags - Whether photo has attached tag links
     * @param type
     * @param comments
     * @param likes
     * @param accessKey - Access key for the photo
     * @param height - Original photo height
     * @param images
     * @param lat - Latitude
     * @param long - Longitude
     * @param photo256 - URL of image with 2560 px width
     * @param canComment - Information whether current user can comment the photo
     * @param place
     * @param postId - Post ID
     * @param sizes
     * @param squareCrop
     * @param text - Photo caption
     * @param userId - ID of the user who have uploaded the photo
     * @param width - Original photo width
     * @param reposts
     * @param tags
     * @param hidden - Returns if the photo is hidden above the wall
     * @param realOffset - Real position of the photo
     * @param verticalAlign - Sets vertical alignment of a photo
     * @param sourceId
     */
    data class NewsfeedCommentsItemTypePhotoDto(
        @SerializedName("album_id")
        val albumId: Int,
        @SerializedName("date")
        val date: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("owner_id")
        val ownerId: UserId,
        @SerializedName("has_tags")
        val hasTags: Boolean,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("comments")
        val comments: NewsfeedCommentsBaseDto? = null,
        @SerializedName("likes")
        val likes: BaseLikesDto? = null,
        @SerializedName("access_key")
        val accessKey: String? = null,
        @SerializedName("height")
        val height: Int? = null,
        @SerializedName("images")
        val images: List<PhotosImageDto>? = null,
        @SerializedName("lat")
        val lat: Float? = null,
        @SerializedName("long")
        val long: Float? = null,
        @SerializedName("photo_256")
        val photo256: String? = null,
        @SerializedName("can_comment")
        val canComment: BaseBoolIntDto? = null,
        @SerializedName("place")
        val place: String? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("sizes")
        val sizes: List<PhotosPhotoSizesDto>? = null,
        @SerializedName("square_crop")
        val squareCrop: String? = null,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("user_id")
        val userId: UserId? = null,
        @SerializedName("width")
        val width: Int? = null,
        @SerializedName("reposts")
        val reposts: BaseRepostsInfoDto? = null,
        @SerializedName("tags")
        val tags: BaseObjectCountDto? = null,
        @SerializedName("hidden")
        val hidden: BasePropertyExistsDto? = null,
        @SerializedName("real_offset")
        val realOffset: Int? = null,
        @SerializedName("vertical_align")
        val verticalAlign: NewsfeedCommentsItemTypePhotoDto.VerticalAlignDto? = null,
        @SerializedName("source_id")
        val sourceId: UserId? = null
    ) : NewsfeedCommentsItemDto() {
        enum class VerticalAlignDto(
            val value: String
        ) {
            @SerializedName("top")
            TOP("top"),

            @SerializedName("middle")
            MIDDLE("middle"),

            @SerializedName("bottom")
            BOTTOM("bottom");
        }
    }

    /**
     * @param text
     * @param comments
     * @param likes
     * @param type
     * @param responseType
     * @param accessKey - Video access key
     * @param addingDate - Date when the video has been added in Unixtime
     * @param canComment - Information whether current user can comment the video
     * @param canEdit - Information whether current user can edit the video
     * @param canDelete - Information whether current user can delete the video
     * @param canLike - Information whether current user can like the video
     * @param canRepost - Information whether current user can repost the video
     * @param canSubscribe - Information whether current user can subscribe to author of the video
     * @param canAddToFaves - Information whether current user can add the video to favourites
     * @param canAdd - Information whether current user can add the video
     * @param canAttachLink - Information whether current user can attach action button to the video
     * @param canEditPrivacy - Information whether current user can edit the video privacy
     * @param isPrivate - 1 if video is private
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
     * @param views - Number of views
     * @param localViews - If video is external, number of views on vk
     * @param contentRestricted - Restriction code
     * @param contentRestrictedMessage - Restriction text
     * @param balance - Live donations balance
     * @param live - 1 if the video is a live stream
     * @param upcoming - 1 if the video is an upcoming stream
     * @param liveStartTime - Date in Unixtime when the live stream is scheduled to start by the
     * author
     * @param liveNotify - Whether current user is subscribed to the upcoming live stream
     * notification (if not subscribed to the author)
     * @param spectators - Number of spectators of the stream
     * @param platform - External platform
     * @param reposts
     * @param isExplicit - 1 if music clip and has explicit content
     * @param mainArtists - Main music artists of the clip
     * @param featuredArtists - Featured music artists of the clip
     * @param subtitle - Music clip subtitle
     * @param releaseDate - Release date of the music clip
     * @param genres - Music genres of the clip
     * @param sourceId
     * @param postId
     */
    data class NewsfeedCommentsItemTypeVideoDto(
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("comments")
        val comments: NewsfeedCommentsBaseDto? = null,
        @SerializedName("likes")
        val likes: BaseLikesDto? = null,
        @SerializedName("type")
        val type: NewsfeedCommentsItemTypeVideoDto.TypeDto? = null,
        @SerializedName("response_type")
        val responseType: NewsfeedCommentsItemTypeVideoDto.ResponseTypeDto? = null,
        @SerializedName("access_key")
        val accessKey: String? = null,
        @SerializedName("adding_date")
        val addingDate: Int? = null,
        @SerializedName("can_comment")
        val canComment: BaseBoolIntDto? = null,
        @SerializedName("can_edit")
        val canEdit: BaseBoolIntDto? = null,
        @SerializedName("can_delete")
        val canDelete: BaseBoolIntDto? = null,
        @SerializedName("can_like")
        val canLike: BaseBoolIntDto? = null,
        @SerializedName("can_repost")
        val canRepost: Int? = null,
        @SerializedName("can_subscribe")
        val canSubscribe: BaseBoolIntDto? = null,
        @SerializedName("can_add_to_faves")
        val canAddToFaves: BaseBoolIntDto? = null,
        @SerializedName("can_add")
        val canAdd: BaseBoolIntDto? = null,
        @SerializedName("can_attach_link")
        val canAttachLink: BaseBoolIntDto? = null,
        @SerializedName("can_edit_privacy")
        val canEditPrivacy: BaseBoolIntDto? = null,
        @SerializedName("is_private")
        val isPrivate: BaseBoolIntDto? = null,
        @SerializedName("date")
        val date: Int? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("duration")
        val duration: Int? = null,
        @SerializedName("image")
        val image: List<VideoVideoImageDto>? = null,
        @SerializedName("first_frame")
        val firstFrame: List<VideoVideoImageDto>? = null,
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
        val processing: BasePropertyExistsDto? = null,
        @SerializedName("converting")
        val converting: BaseBoolIntDto? = null,
        @SerializedName("added")
        val added: BaseBoolIntDto? = null,
        @SerializedName("is_subscribed")
        val isSubscribed: BaseBoolIntDto? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("repeat")
        val repeat: BasePropertyExistsDto? = null,
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
        @SerializedName("live")
        val live: BasePropertyExistsDto? = null,
        @SerializedName("upcoming")
        val upcoming: BasePropertyExistsDto? = null,
        @SerializedName("live_start_time")
        val liveStartTime: Int? = null,
        @SerializedName("live_notify")
        val liveNotify: BaseBoolIntDto? = null,
        @SerializedName("spectators")
        val spectators: Int? = null,
        @SerializedName("platform")
        val platform: String? = null,
        @SerializedName("reposts")
        val reposts: BaseRepostsInfoDto? = null,
        @SerializedName("is_explicit")
        val isExplicit: BaseBoolIntDto? = null,
        @SerializedName("main_artists")
        val mainArtists: List<AudioArtistDto>? = null,
        @SerializedName("featured_artists")
        val featuredArtists: List<AudioArtistDto>? = null,
        @SerializedName("subtitle")
        val subtitle: String? = null,
        @SerializedName("release_date")
        val releaseDate: Int? = null,
        @SerializedName("genres")
        val genres: List<AudioGenreDto>? = null,
        @SerializedName("source_id")
        val sourceId: UserId? = null,
        @SerializedName("post_id")
        val postId: Int? = null
    ) : NewsfeedCommentsItemDto() {
        enum class TypeDto(
            val value: String
        ) {
            @SerializedName("video")
            VIDEO("video"),

            @SerializedName("music_video")
            MUSIC_VIDEO("music_video"),

            @SerializedName("movie")
            MOVIE("movie"),

            @SerializedName("live")
            LIVE("live"),

            @SerializedName("short_video")
            SHORT_VIDEO("short_video");
        }

        enum class ResponseTypeDto(
            val value: String
        ) {
            @SerializedName("min")
            MIN("min"),

            @SerializedName("full")
            FULL("full");
        }
    }

    /**
     * @param type
     * @param text
     * @param comments
     * @param likes
     * @param sourceId
     * @param date
     * @param postId
     */
    data class NewsfeedCommentsItemTypeNotesDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("comments")
        val comments: NewsfeedCommentsBaseDto? = null,
        @SerializedName("likes")
        val likes: BaseLikesDto? = null,
        @SerializedName("source_id")
        val sourceId: UserId? = null,
        @SerializedName("date")
        val date: Int? = null,
        @SerializedName("post_id")
        val postId: Int? = null
    ) : NewsfeedCommentsItemDto()

    /**
     * @param fromId
     * @param comments
     * @param copyHistory
     * @param canEdit - Information whether current user can edit the post
     * @param createdBy - Post creator ID (if post still can be edited)
     * @param canDelete - Information whether current user can delete the post
     * @param canPin - Information whether current user can pin the post
     * @param donut
     * @param isPinned - Information whether the post is pinned
     * @param markedAsAds - Information whether the post is marked as ads
     * @param topicId - Topic ID. Allowed values can be obtained from newsfeed.getPostTopics method
     * @param shortTextRate - Preview length control parameter
     * @param hash - Hash for sharing
     * @param type
     * @param feedback
     * @param toId
     * @param carouselOffset - Index of current carousel element
     * @param accessKey - Access key to private object
     * @param isDeleted
     * @param deletedReason
     * @param deletedDetails
     * @param attachments
     * @param copyright - Information about the source of the post
     * @param date - Date of publishing in Unixtime
     * @param edited - Date of editing in Unixtime
     * @param geo
     * @param id - Post ID
     * @param isArchived - Is post archived, only for post owners
     * @param isFavorite - Information whether the post in favorites list
     * @param likes - Count of likes
     * @param ownerId - Wall owner's ID
     * @param postId - If post type 'reply', contains original post ID
     * @param parentsStack - If post type 'reply', contains original parent IDs stack
     * @param postSource
     * @param postType
     * @param reposts
     * @param signerId - Post signer ID
     * @param text - Post text
     * @param views - Count of views
     */
    data class NewsfeedCommentsItemTypePostDto(
        @SerializedName("from_id")
        val fromId: UserId? = null,
        @SerializedName("comments")
        val comments: NewsfeedCommentsBaseDto? = null,
        @SerializedName("copy_history")
        val copyHistory: List<WallWallpostFullDto>? = null,
        @SerializedName("can_edit")
        val canEdit: BaseBoolIntDto? = null,
        @SerializedName("created_by")
        val createdBy: UserId? = null,
        @SerializedName("can_delete")
        val canDelete: BaseBoolIntDto? = null,
        @SerializedName("can_pin")
        val canPin: BaseBoolIntDto? = null,
        @SerializedName("donut")
        val donut: WallWallpostDonutDto? = null,
        @SerializedName("is_pinned")
        val isPinned: BaseBoolIntDto? = null,
        @SerializedName("marked_as_ads")
        val markedAsAds: BaseBoolIntDto? = null,
        @SerializedName("topic_id")
        val topicId: NewsfeedCommentsItemTypePostDto.TopicIdDto? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("hash")
        val hash: String? = null,
        @SerializedName("type")
        val type: WallPostTypeDto? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null,
        @SerializedName("to_id")
        val toId: UserId? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null,
        @SerializedName("access_key")
        val accessKey: String? = null,
        @SerializedName("is_deleted")
        val isDeleted: Boolean? = null,
        @SerializedName("deleted_reason")
        val deletedReason: String? = null,
        @SerializedName("deleted_details")
        val deletedDetails: String? = null,
        @SerializedName("attachments")
        val attachments: List<WallWallpostAttachmentDto>? = null,
        @SerializedName("copyright")
        val copyright: WallPostCopyrightDto? = null,
        @SerializedName("date")
        val date: Int? = null,
        @SerializedName("edited")
        val edited: Int? = null,
        @SerializedName("geo")
        val geo: WallGeoDto? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("is_archived")
        val isArchived: Boolean? = null,
        @SerializedName("is_favorite")
        val isFavorite: Boolean? = null,
        @SerializedName("likes")
        val likes: BaseLikesInfoDto? = null,
        @SerializedName("owner_id")
        val ownerId: UserId? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("parents_stack")
        val parentsStack: List<Int>? = null,
        @SerializedName("post_source")
        val postSource: WallPostSourceDto? = null,
        @SerializedName("post_type")
        val postType: WallPostTypeDto? = null,
        @SerializedName("reposts")
        val reposts: BaseRepostsInfoDto? = null,
        @SerializedName("signer_id")
        val signerId: UserId? = null,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("views")
        val views: WallViewsDto? = null
    ) : NewsfeedCommentsItemDto() {
        enum class TopicIdDto(
            val value: Int
        ) {
            @SerializedName("0")
            EMPTY_TOPIC(0),

            @SerializedName("1")
            ART(1),

            @SerializedName("7")
            IT(7),

            @SerializedName("12")
            GAMES(12),

            @SerializedName("16")
            MUSIC(16),

            @SerializedName("19")
            PHOTO(19),

            @SerializedName("21")
            SCIENCE_AND_TECH(21),

            @SerializedName("23")
            SPORT(23),

            @SerializedName("25")
            TRAVEL(25),

            @SerializedName("26")
            TV_AND_CINEMA(26),

            @SerializedName("32")
            HUMOR(32),

            @SerializedName("43")
            FASHION(43);
        }
    }

    /**
     * @param availability
     * @param category
     * @param description - Item description
     * @param id - Item ID
     * @param ownerId - Item owner's ID
     * @param price
     * @param title - Item title
     * @param type
     * @param comments
     * @param likes
     * @param accessKey - Access key for the market item
     * @param buttonTitle - Title for button for url
     * @param categoryV2
     * @param date - Date when the item has been created in Unixtime
     * @param externalId
     * @param isFavorite
     * @param isOwner
     * @param isAdult
     * @param thumbPhoto - URL of the preview image
     * @param url - URL to item
     * @param variantsGroupingId
     * @param isMainVariant
     * @param sku
     * @param postId - Attach for post id
     * @param postOwnerId - Attach for post owner id
     * @param sourceId
     */
    data class NewsfeedCommentsItemTypeMarketDto(
        @SerializedName("availability")
        val availability: MarketMarketItemAvailabilityDto,
        @SerializedName("category")
        val category: MarketMarketCategoryDto,
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("owner_id")
        val ownerId: UserId,
        @SerializedName("price")
        val price: MarketPriceDto,
        @SerializedName("title")
        val title: String,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("comments")
        val comments: NewsfeedCommentsBaseDto? = null,
        @SerializedName("likes")
        val likes: BaseLikesDto? = null,
        @SerializedName("access_key")
        val accessKey: String? = null,
        @SerializedName("button_title")
        val buttonTitle: String? = null,
        @SerializedName("category_v2")
        val categoryV2: MarketMarketCategoryDto? = null,
        @SerializedName("date")
        val date: Int? = null,
        @SerializedName("external_id")
        val externalId: String? = null,
        @SerializedName("is_favorite")
        val isFavorite: Boolean? = null,
        @SerializedName("is_owner")
        val isOwner: Boolean? = null,
        @SerializedName("is_adult")
        val isAdult: Boolean? = null,
        @SerializedName("thumb_photo")
        val thumbPhoto: String? = null,
        @SerializedName("url")
        val url: String? = null,
        @SerializedName("variants_grouping_id")
        val variantsGroupingId: Int? = null,
        @SerializedName("is_main_variant")
        val isMainVariant: Boolean? = null,
        @SerializedName("sku")
        val sku: String? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("post_owner_id")
        val postOwnerId: UserId? = null,
        @SerializedName("source_id")
        val sourceId: UserId? = null
    ) : NewsfeedCommentsItemDto()

    class Deserializer : JsonDeserializer<NewsfeedCommentsItemDto> {
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type?,
            context: JsonDeserializationContext
        ): NewsfeedCommentsItemDto {
            val type = json.asJsonObject.get("type").asString
            return when (type) {
                "topic" -> context.deserialize(json, NewsfeedCommentsItemTypeTopicDto::class.java)
                "photo" -> context.deserialize(json, NewsfeedCommentsItemTypePhotoDto::class.java)
                "video" -> context.deserialize(json, NewsfeedCommentsItemTypeVideoDto::class.java)
                "notes" -> context.deserialize(json, NewsfeedCommentsItemTypeNotesDto::class.java)
                "post" -> context.deserialize(json, NewsfeedCommentsItemTypePostDto::class.java)
                "market" -> context.deserialize(json, NewsfeedCommentsItemTypeMarketDto::class.java)
                else -> throw IllegalStateException("no mapping for the type:" + type)
            }
        }
    }
}
