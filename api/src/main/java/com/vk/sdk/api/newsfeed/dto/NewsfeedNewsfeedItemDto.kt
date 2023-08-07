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
import com.vk.sdk.api.ads.dto.AdsHideReasonsDto
import com.vk.sdk.api.ads.dto.AdsHtml5GameInappActionDto
import com.vk.sdk.api.ads.dto.AdsItemBlockAdItemDto
import com.vk.sdk.api.ads.dto.AdsItemBlockAdStatPixelDto
import com.vk.sdk.api.aliexpress.dto.AliexpressBlockPanelDto
import com.vk.sdk.api.aliexpress.dto.AliexpressCarouselItemDto
import com.vk.sdk.api.aliexpress.dto.AliexpressPromoCardDto
import com.vk.sdk.api.aliexpress.dto.AliexpressSocialFooterDto
import com.vk.sdk.api.apps.dto.AppsAppDto
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseCommentsInfoDto
import com.vk.sdk.api.base.dto.BaseImageDto
import com.vk.sdk.api.base.dto.BaseLikesDto
import com.vk.sdk.api.base.dto.BaseLikesInfoDto
import com.vk.sdk.api.base.dto.BaseLinkButtonDto
import com.vk.sdk.api.base.dto.BaseLinkDto
import com.vk.sdk.api.base.dto.BaseRepostsInfoDto
import com.vk.sdk.api.classifieds.dto.ClassifiedsWorkiCarouselItemDto
import com.vk.sdk.api.classifieds.dto.ClassifiedsYoulaCarouselBlockGroupDto
import com.vk.sdk.api.classifieds.dto.ClassifiedsYoulaGroupsBlockDto
import com.vk.sdk.api.classifieds.dto.ClassifiedsYoulaItemExtendedDto
import com.vk.sdk.api.discover.dto.DiscoverCarouselButtonDto
import com.vk.sdk.api.discover.dto.DiscoverCarouselItemDto
import com.vk.sdk.api.discover.dto.DiscoverCarouselObjectsTypeDto
import com.vk.sdk.api.friends.dto.FriendsEntrypointsDto
import com.vk.sdk.api.friends.dto.FriendsRecBlockFooterDto
import com.vk.sdk.api.friends.dto.FriendsRecBlockInfoCardDto
import com.vk.sdk.api.friends.dto.FriendsRecProfileDto
import com.vk.sdk.api.groups.dto.GroupsSuggestionDto
import com.vk.sdk.api.market.dto.MarketGroupsBlockDto
import com.vk.sdk.api.market.dto.MarketItemOwnerInfoDto
import com.vk.sdk.api.market.dto.MarketItemPromotionInfoDto
import com.vk.sdk.api.market.dto.MarketMarketCategoryDto
import com.vk.sdk.api.market.dto.MarketMarketItemAvailabilityDto
import com.vk.sdk.api.market.dto.MarketPriceDto
import com.vk.sdk.api.messages.dto.MessagesChatSuggestionDto
import com.vk.sdk.api.photos.dto.PhotosPhotoDto
import com.vk.sdk.api.photos.dto.PhotosTagsSuggestionItemDto
import com.vk.sdk.api.photos.dto.PhotosTagsSuggestionItemEndCardDto
import com.vk.sdk.api.shortVideo.dto.ShortVideoChallengeFeedItemDto
import com.vk.sdk.api.textlives.dto.TextlivesTextliveTextpostBlockDto
import com.vk.sdk.api.video.dto.VideoVideoDto
import com.vk.sdk.api.video.dto.VideoVideoFullDto
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

sealed class NewsfeedNewsfeedItemDto {
    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param carouselOffset - Index of current carousel element
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     * @param copyHistory
     * @param canEdit - Information whether current user can edit the post
     * @param createdBy - Post creator ID (if post still can be edited)
     * @param canDelete - Information whether current user can delete the post
     * @param canPin - Information whether current user can pin the post
     * @param donut
     * @param isPinned - Information whether the post is pinned
     * @param comments
     * @param markedAsAds - Information whether the post is marked as ads
     * @param topicId - Topic ID. Allowed values can be obtained from newsfeed.getPostTopics method
     * @param hash - Hash for sharing
     * @param toId
     * @param accessKey - Access key to private object
     * @param isDeleted
     * @param deletedReason
     * @param deletedDetails
     * @param attachments
     * @param copyright - Information about the source of the post
     * @param edited - Date of editing in Unixtime
     * @param fromId - Post author ID
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
    data class NewsfeedItemWallpostDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null,
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
        @SerializedName("comments")
        val comments: BaseCommentsInfoDto? = null,
        @SerializedName("marked_as_ads")
        val markedAsAds: BaseBoolIntDto? = null,
        @SerializedName("topic_id")
        val topicId: NewsfeedItemWallpostDto.TopicIdDto? = null,
        @SerializedName("hash")
        val hash: String? = null,
        @SerializedName("to_id")
        val toId: UserId? = null,
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
        @SerializedName("edited")
        val edited: Int? = null,
        @SerializedName("from_id")
        val fromId: UserId? = null,
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
    ) : NewsfeedNewsfeedItemDto() {
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
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param photos
     * @param postId - Post ID
     * @param carouselOffset - Index of current carousel element
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemPhotoDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("photos")
        val photos: NewsfeedItemPhotoPhotosDto? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param photoTags
     * @param postId - Post ID
     * @param carouselOffset - Index of current carousel element
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemPhotoTagDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("photo_tags")
        val photoTags: NewsfeedItemPhotoTagPhotoTagsDto? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param friends
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemFriendDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("friends")
        val friends: NewsfeedItemFriendFriendsDto? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param audio
     * @param postId - Post ID
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemAudioDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("audio")
        val audio: NewsfeedItemAudioAudioDto? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param video
     * @param postId - Post ID
     * @param carouselOffset - Index of current carousel element
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemVideoDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("video")
        val video: NewsfeedItemVideoVideoDto? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param postId - Topic post ID
     * @param text - Post text
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param comments
     * @param likes
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemTopicDto(
        @SerializedName("post_id")
        val postId: Int,
        @SerializedName("text")
        val text: String,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("comments")
        val comments: BaseCommentsInfoDto? = null,
        @SerializedName("likes")
        val likes: BaseLikesInfoDto? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param feedId - id of feed in digest
     * @param items
     * @param mainPostIds
     * @param template - type of digest
     * @param header
     * @param footer
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemDigestDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("feed_id")
        val feedId: String? = null,
        @SerializedName("items")
        val items: List<NewsfeedItemDigestItemDto>? = null,
        @SerializedName("main_post_ids")
        val mainPostIds: List<String>? = null,
        @SerializedName("template")
        val template: NewsfeedItemDigestDto.TemplateDto? = null,
        @SerializedName("header")
        val header: NewsfeedItemDigestHeaderDto? = null,
        @SerializedName("footer")
        val footer: NewsfeedItemDigestFooterDto? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto() {
        enum class TemplateDto(
            val value: String
        ) {
            @SerializedName("list")
            LIST("list"),

            @SerializedName("grid")
            GRID("grid"),

            @SerializedName("single")
            SINGLE("single");
        }
    }

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param text
     * @param title
     * @param action
     * @param images
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemPromoButtonDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("action")
        val action: NewsfeedItemPromoButtonActionDto? = null,
        @SerializedName("images")
        val images: List<NewsfeedItemPromoButtonImageDto>? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type - type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param adsTitle - Block title (e.g. "Promoted post" or just "Ad")
     * @param adsId1 - Block unique id (part 1)
     * @param adsId2 - Block unique id (part 2)
     * @param ads - Array of ads. However always array with single element
     * @param advertiserInfoUrl
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     * @param hideReasons
     * @param adsStatistics - Array of statistics pixels (block level)
     * @param adsDebug - Debug information
     * @param header
     * @param adSource - Source of ads
     * @param adMarker - some unique ad id
     */
    data class NewsfeedItemAdsBlockDto(
        @SerializedName("type")
        val type: String,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("ads_title")
        val adsTitle: String,
        @SerializedName("ads_id1")
        val adsId1: Int,
        @SerializedName("ads_id2")
        val adsId2: Int,
        @SerializedName("ads")
        val ads: List<AdsItemBlockAdItemDto>,
        @SerializedName("advertiser_info_url")
        val advertiserInfoUrl: String,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null,
        @SerializedName("hide_reasons")
        val hideReasons: AdsHideReasonsDto? = null,
        @SerializedName("ads_statistics")
        val adsStatistics: List<AdsItemBlockAdStatPixelDto>? = null,
        @SerializedName("ads_debug")
        val adsDebug: String? = null,
        @SerializedName("header")
        val header: NewsfeedNewsfeedItemHeaderDto? = null,
        @SerializedName("ad_source")
        val adSource: NewsfeedItemAdsBlockDto.AdSourceDto? = null,
        @SerializedName("ad_marker")
        val adMarker: String? = null
    ) : NewsfeedNewsfeedItemDto() {
        enum class AdSourceDto(
            val value: String
        ) {
            @SerializedName("vkontakte")
            VKONTAKTE("vkontakte"),

            @SerializedName("vkfeed")
            VKFEED("vkfeed");
        }
    }

    /**
     * @param banner
     * @param poll
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemFeedbackPollDto(
        @SerializedName("banner")
        val banner: NewsfeedItemFeedbackPollBannerDto,
        @SerializedName("poll")
        val poll: NewsfeedItemFeedbackPollPollDto,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param blockId
     * @param text
     * @param animation
     * @param decoration - none - without background, background - with background, card - looks
     * like a card
     * @param subtitle
     * @param button
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemAnimatedBlockDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("block_id")
        val blockId: String? = null,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("animation")
        val animation: NewsfeedItemAnimatedBlockAnimationDto? = null,
        @SerializedName("decoration")
        val decoration: NewsfeedItemAnimatedBlockDto.DecorationDto? = null,
        @SerializedName("subtitle")
        val subtitle: String? = null,
        @SerializedName("button")
        val button: BaseLinkButtonDto? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto() {
        enum class DecorationDto(
            val value: String
        ) {
            @SerializedName("none")
            NONE("none"),

            @SerializedName("background")
            BACKGROUND("background"),

            @SerializedName("card")
            CARD("card");
        }
    }

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param title
     * @param items
     * @param nextFrom - Next from value
     * @param button
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemClipsBlockDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("items")
        val items: List<VideoVideoDto>? = null,
        @SerializedName("next_from")
        val nextFrom: String? = null,
        @SerializedName("button")
        val button: BaseLinkButtonDto? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param title - Title of the block
     * @param items - Items of the block
     * @param count - Total count of recommendations
     * @param button
     * @param isAsync
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param nextFrom - Encoded string for the next page
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemRecommendedGroupsBlockDto(
        @SerializedName("title")
        val title: String,
        @SerializedName("items")
        val items: List<GroupsSuggestionDto>,
        @SerializedName("count")
        val count: Int,
        @SerializedName("button")
        val button: BaseLinkButtonDto,
        @SerializedName("is_async")
        val isAsync: Boolean,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("next_from")
        val nextFrom: String? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param endCard
     * @param recognitionArticleLink - help link
     * @param items
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemRecognizeBlockDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("end_card")
        val endCard: PhotosTagsSuggestionItemEndCardDto? = null,
        @SerializedName("recognition_article_link")
        val recognitionArticleLink: String? = null,
        @SerializedName("items")
        val items: List<PhotosTagsSuggestionItemDto>? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param button
     * @param items
     * @param title
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param objects
     * @param objectsType
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemAppsCarouselDto(
        @SerializedName("button")
        val button: DiscoverCarouselButtonDto,
        @SerializedName("items")
        val items: List<DiscoverCarouselItemDto>,
        @SerializedName("title")
        val title: String,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("objects")
        val objects: List<AppsAppDto>? = null,
        @SerializedName("objects_type")
        val objectsType: DiscoverCarouselObjectsTypeDto? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param textliveTextpostBlock
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemTextliveBlockDto(
        @SerializedName("textlive_textpost_block")
        val textliveTextpostBlock: TextlivesTextliveTextpostBlockDto,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type - type
     * @param items
     * @param createButtonUrl - Create button url
     * @param moreButtonUrl - More button url
     * @param isAsync
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param canBeFiltered - can be filtered
     * @param blockTitle - Block title
     * @param blockDescription - Block description
     * @param trackCode
     * @param group
     * @param viewStyle
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemYoulaCarouselBlockDto(
        @SerializedName("type")
        val type: String,
        @SerializedName("items")
        val items: List<ClassifiedsYoulaItemExtendedDto>,
        @SerializedName("create_button_url")
        val createButtonUrl: String,
        @SerializedName("more_button_url")
        val moreButtonUrl: String,
        @SerializedName("is_async")
        val isAsync: Boolean,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("can_be_filtered")
        val canBeFiltered: Boolean? = null,
        @SerializedName("block_title")
        val blockTitle: String? = null,
        @SerializedName("block_description")
        val blockDescription: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("group")
        val group: ClassifiedsYoulaCarouselBlockGroupDto? = null,
        @SerializedName("view_style")
        val viewStyle: String? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type - type
     * @param bundle - bundle
     * @param blockTitle - Block title
     * @param trackCode
     * @param goodsCarouselViewType - Display style of block
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param canBeFiltered - can be filtered
     * @param blockPanel - Block top panel
     * @param promoCard - Promo card item
     * @param items
     * @param moreButton - More button url
     * @param footer
     * @param useOnelineProductTitle - Show product title in one row
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemAliexpressCarouselBlockDto(
        @SerializedName("type")
        val type: String,
        @SerializedName("bundle")
        val bundle: NewsfeedItemAliexpressCarouselBlockDto.BundleDto,
        @SerializedName("block_title")
        val blockTitle: String,
        @SerializedName("track_code")
        val trackCode: String,
        @SerializedName("goods_carousel_view_type")
        val goodsCarouselViewType: String,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("can_be_filtered")
        val canBeFiltered: Boolean? = null,
        @SerializedName("block_panel")
        val blockPanel: AliexpressBlockPanelDto? = null,
        @SerializedName("promo_card")
        val promoCard: AliexpressPromoCardDto? = null,
        @SerializedName("items")
        val items: List<AliexpressCarouselItemDto>? = null,
        @SerializedName("more_button")
        val moreButton: BaseLinkButtonDto? = null,
        @SerializedName("footer")
        val footer: AliexpressSocialFooterDto? = null,
        @SerializedName("use_oneline_product_title")
        val useOnelineProductTitle: Boolean? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto() {
        enum class BundleDto(
            val value: String
        ) {
            @SerializedName("aliexpress_item")
            ALIEXPRESS_ITEM("aliexpress_item"),

            @SerializedName("market_item")
            MARKET_ITEM("market_item");
        }
    }

    /**
     * @param app
     * @param title
     * @param buttonText
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param friendsPlayingText
     * @param friendsAvatars
     * @param appCover
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemRecommendedAppBlockDto(
        @SerializedName("app")
        val app: AppsAppDto,
        @SerializedName("title")
        val title: String,
        @SerializedName("button_text")
        val buttonText: String,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("friends_playing_text")
        val friendsPlayingText: String? = null,
        @SerializedName("friends_avatars")
        val friendsAvatars: List<List<BaseImageDto>>? = null,
        @SerializedName("app_cover")
        val appCover: List<BaseImageDto>? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param title
     * @param items
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemClipsChallengesBlockUmbrellaDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("items")
        val items: List<ShortVideoChallengeFeedItemDto>? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param type
     * @param expertCard
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemExpertCardWidgetDto(
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("type")
        val type: String? = null,
        @SerializedName("expert_card")
        val expertCard: NewsfeedExpertCardWidgetDto? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type - type
     * @param items
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param blockTitle - Block title
     * @param moreButton - More button url
     * @param trackCode
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemWorkiCarouselBlockDto(
        @SerializedName("type")
        val type: String,
        @SerializedName("items")
        val items: List<ClassifiedsWorkiCarouselItemDto>,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("block_title")
        val blockTitle: String? = null,
        @SerializedName("more_button")
        val moreButton: BaseLinkButtonDto? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param title - Title of the block
     * @param items - Items of the block
     * @param count - Total count of recommendations
     * @param button
     * @param isAsync
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param nextFrom - Encoded string for the next page
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemFriendsRecommendationsGroupsBlockDto(
        @SerializedName("title")
        val title: String,
        @SerializedName("items")
        val items: List<GroupsSuggestionDto>,
        @SerializedName("count")
        val count: Int,
        @SerializedName("button")
        val button: BaseLinkButtonDto,
        @SerializedName("is_async")
        val isAsync: Boolean,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("next_from")
        val nextFrom: String? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param title
     * @param items
     * @param nextFrom - Next from value
     * @param button
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemVideosForYouBlockDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("items")
        val items: List<VideoVideoFullDto>? = null,
        @SerializedName("next_from")
        val nextFrom: String? = null,
        @SerializedName("button")
        val button: BaseLinkButtonDto? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type - type
     * @param title
     * @param trackCode
     * @param isAsync
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param data
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemYoulaGroupsBlockDto(
        @SerializedName("type")
        val type: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("track_code")
        val trackCode: String,
        @SerializedName("is_async")
        val isAsync: Boolean,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("data")
        val data: ClassifiedsYoulaGroupsBlockDto? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param title
     * @param description
     * @param privacyText
     * @param item
     * @param buttons
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemVideoPostcardBlockDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("privacy_text")
        val privacyText: String? = null,
        @SerializedName("item")
        val item: VideoVideoFullDto? = null,
        @SerializedName("buttons")
        val buttons: List<BaseLinkButtonDto>? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param items - Items of the block
     * @param count - Total count of recommendations
     * @param button
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param nextFrom - Encoded string for a next page
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemRecommendedChatsBlockDto(
        @SerializedName("items")
        val items: List<MessagesChatSuggestionDto>,
        @SerializedName("count")
        val count: Int,
        @SerializedName("button")
        val button: BaseLinkButtonDto,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("next_from")
        val nextFrom: String? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param availability
     * @param category
     * @param description - Item description
     * @param id - Item ID
     * @param ownerId - Item owner's ID
     * @param price
     * @param title - Item title
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     * @param albumsIds
     * @param photos
     * @param canComment - Information whether current use can comment the item
     * @param canRepost - Information whether current use can repost the item
     * @param likes
     * @param reposts
     * @param viewsCount - Views number
     * @param wishlistItemId - Object identifier in wishlist of viewer
     * @param cancelInfo - Information for cancel and revert order
     * @param userAgreementInfo - User agreement info
     * @param adId - Contains ad ID if it has
     * @param ownerInfo - Information about the group where the item is placed
     * @param canEdit - Can the item be updated by current user?
     * @param canDelete - Can item be deleted by current user?
     * @param canShowConvertToService - Can the item be converted from a product into a service?
     * @param promotion - Information about promotion of the item
     * @param vkPayDiscount - The amount of the discount if VK Pay is used for payment
     * @param accessKey - Access key for the market item
     * @param buttonTitle - Title for button for url
     * @param categoryV2
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
     */
    data class NewsfeedItemMarketItemDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
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
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null,
        @SerializedName("albums_ids")
        val albumsIds: List<Int>? = null,
        @SerializedName("photos")
        val photos: List<PhotosPhotoDto>? = null,
        @SerializedName("can_comment")
        val canComment: BaseBoolIntDto? = null,
        @SerializedName("can_repost")
        val canRepost: BaseBoolIntDto? = null,
        @SerializedName("likes")
        val likes: BaseLikesDto? = null,
        @SerializedName("reposts")
        val reposts: BaseRepostsInfoDto? = null,
        @SerializedName("views_count")
        val viewsCount: Int? = null,
        @SerializedName("wishlist_item_id")
        val wishlistItemId: Int? = null,
        @SerializedName("cancel_info")
        val cancelInfo: BaseLinkDto? = null,
        @SerializedName("user_agreement_info")
        val userAgreementInfo: String? = null,
        @SerializedName("ad_id")
        val adId: Int? = null,
        @SerializedName("owner_info")
        val ownerInfo: MarketItemOwnerInfoDto? = null,
        @SerializedName("can_edit")
        val canEdit: Boolean? = null,
        @SerializedName("can_delete")
        val canDelete: Boolean? = null,
        @SerializedName("can_show_convert_to_service")
        val canShowConvertToService: Boolean? = null,
        @SerializedName("promotion")
        val promotion: MarketItemPromotionInfoDto? = null,
        @SerializedName("vk_pay_discount")
        val vkPayDiscount: Int? = null,
        @SerializedName("access_key")
        val accessKey: String? = null,
        @SerializedName("button_title")
        val buttonTitle: String? = null,
        @SerializedName("category_v2")
        val categoryV2: MarketMarketCategoryDto? = null,
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
        val postOwnerId: UserId? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param type
     * @param entrypoints
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemFriendsEntrypointsBlockDto(
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("type")
        val type: String? = null,
        @SerializedName("entrypoints")
        val entrypoints: FriendsEntrypointsDto? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param title
     * @param profiles
     * @param date - Date when item has been added in Unixtime
     * @param sourceId - Item source ID
     * @param nextFrom
     * @param infoCard
     * @param accountImportBlockPos
     * @param footer
     * @param trackCode
     * @param type
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemFriendsRecommendBlockDto(
        @SerializedName("title")
        val title: String,
        @SerializedName("profiles")
        val profiles: List<FriendsRecProfileDto>,
        @SerializedName("date")
        val date: Int,
        @SerializedName("source_id")
        val sourceId: UserId? = null,
        @SerializedName("next_from")
        val nextFrom: String? = null,
        @SerializedName("info_card")
        val infoCard: FriendsRecBlockInfoCardDto? = null,
        @SerializedName("account_import_block_pos")
        val accountImportBlockPos: Int? = null,
        @SerializedName("footer")
        val footer: FriendsRecBlockFooterDto? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("type")
        val type: String? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param interestItems
     * @param title
     * @param subtitle
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemInterestsDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("interest_items")
        val interestItems: List<NewsfeedItemInterestItemDto>? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("subtitle")
        val subtitle: String? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param inappActions - Client actions to call from webview
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param autolaunch
     * @param sourceUrl
     * @param viewportHeight
     * @param viewportRatio
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemGenericWebviewBlockDto(
        @SerializedName("inapp_actions")
        val inappActions: List<AdsHtml5GameInappActionDto>,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("autolaunch")
        val autolaunch: Boolean? = null,
        @SerializedName("source_url")
        val sourceUrl: String? = null,
        @SerializedName("viewport_height")
        val viewportHeight: Float? = null,
        @SerializedName("viewport_ratio")
        val viewportRatio: Float? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param app
     * @param title
     * @param buttonText
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param friendsPlayingText
     * @param friendsAvatars
     * @param appCover
     * @param achievementText
     * @param achievementImage
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemAchievementGameBlockDto(
        @SerializedName("app")
        val app: AppsAppDto,
        @SerializedName("title")
        val title: String,
        @SerializedName("button_text")
        val buttonText: String,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("friends_playing_text")
        val friendsPlayingText: String? = null,
        @SerializedName("friends_avatars")
        val friendsAvatars: List<List<BaseImageDto>>? = null,
        @SerializedName("app_cover")
        val appCover: List<BaseImageDto>? = null,
        @SerializedName("achievement_text")
        val achievementText: String? = null,
        @SerializedName("achievement_image")
        val achievementImage: List<BaseImageDto>? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param app
     * @param title
     * @param buttonText
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param friendsPlayingText
     * @param friendsIds
     * @param appCover
     * @param appAvatar
     * @param descriptionText
     * @param friendsAvatars
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemBookmarkGameBlockDto(
        @SerializedName("app")
        val app: AppsAppDto,
        @SerializedName("title")
        val title: String,
        @SerializedName("button_text")
        val buttonText: String,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("friends_playing_text")
        val friendsPlayingText: String? = null,
        @SerializedName("friends_ids")
        val friendsIds: List<UserId>? = null,
        @SerializedName("app_cover")
        val appCover: List<BaseImageDto>? = null,
        @SerializedName("app_avatar")
        val appAvatar: List<BaseImageDto>? = null,
        @SerializedName("description_text")
        val descriptionText: String? = null,
        @SerializedName("friends_avatars")
        val friendsAvatars: List<List<BaseImageDto>>? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type - type
     * @param title
     * @param trackCode
     * @param isAsync
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param data
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemMarketGroupsBlockDto(
        @SerializedName("type")
        val type: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("track_code")
        val trackCode: String,
        @SerializedName("is_async")
        val isAsync: Boolean,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("data")
        val data: MarketGroupsBlockDto? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param audioPlaylist
     * @param postId - Post ID
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemAudioPlaylistDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("audio_playlist")
        val audioPlaylist: NewsfeedItemAudioPlaylistElementsDto? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param width
     * @param height
     * @param type
     * @param items
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param trackCode
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedMediaDiscoverBlockDto(
        @SerializedName("width")
        val width: Int,
        @SerializedName("height")
        val height: Int,
        @SerializedName("type")
        val type: String,
        @SerializedName("items")
        val items: List<NewsfeedMediaDiscoverItemDto>,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param header
     * @param shownNewsCount
     * @param showMoreCount
     * @param showMoreText
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param dzenCompilation
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedDzenTopStoriesBlockDto(
        @SerializedName("type")
        val type: String,
        @SerializedName("header")
        val header: NewsfeedDzenTopStoriesBlockHeaderDto,
        @SerializedName("shown_news_count")
        val shownNewsCount: Int,
        @SerializedName("show_more_count")
        val showMoreCount: Int,
        @SerializedName("show_more_text")
        val showMoreText: String,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("dzen_compilation")
        val dzenCompilation: NewsfeedDzenCompilationDto? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param header
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedDzenStoryNewsBlockDto(
        @SerializedName("type")
        val type: String,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("header")
        val header: NewsfeedItemDigestHeaderDto? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param title
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedItemSignalsDto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemTypeDto,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    /**
     * @param type
     * @param trackCode
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param image
     * @param description
     * @param more
     * @param popup
     * @param isAsync
     * @param shortTextRate - Preview length control parameter
     * @param feedback
     */
    data class NewsfeedInfoBlockDto(
        @SerializedName("type")
        val type: String,
        @SerializedName("track_code")
        val trackCode: String,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("image")
        val image: NewsfeedNewsfeedItemHeaderImageDto? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("more")
        val more: NewsfeedInfoBlockButtonDto? = null,
        @SerializedName("popup")
        val popup: NewsfeedInfoBlockPopupDto? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedbackDto? = null
    ) : NewsfeedNewsfeedItemDto()

    class Deserializer : JsonDeserializer<NewsfeedNewsfeedItemDto> {
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type?,
            context: JsonDeserializationContext
        ): NewsfeedNewsfeedItemDto {
            val type = json.asJsonObject.get("type").asString
            return when (type) {
                "post" -> context.deserialize(json, NewsfeedItemWallpostDto::class.java)
                "photo" -> context.deserialize(json, NewsfeedItemPhotoDto::class.java)
                "wall_photo" -> context.deserialize(json, NewsfeedItemPhotoDto::class.java)
                "photo_tag" -> context.deserialize(json, NewsfeedItemPhotoTagDto::class.java)
                "friend" -> context.deserialize(json, NewsfeedItemFriendDto::class.java)
                "audio" -> context.deserialize(json, NewsfeedItemAudioDto::class.java)
                "video" -> context.deserialize(json, NewsfeedItemVideoDto::class.java)
                "topic" -> context.deserialize(json, NewsfeedItemTopicDto::class.java)
                "digest" -> context.deserialize(json, NewsfeedItemDigestDto::class.java)
                "promo_button" -> context.deserialize(json, NewsfeedItemPromoButtonDto::class.java)
                else -> throw IllegalStateException("no mapping for the type:" + type)
            }
        }
    }
}
