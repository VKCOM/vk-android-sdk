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
import com.vk.sdk.api.aliexpress.dto.AliexpressBlockPanel
import com.vk.sdk.api.aliexpress.dto.AliexpressCarouselItem
import com.vk.sdk.api.aliexpress.dto.AliexpressPromoCard
import com.vk.sdk.api.aliexpress.dto.AliexpressSocialFooter
import com.vk.sdk.api.apps.dto.AppsApp
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseCommentsInfo
import com.vk.sdk.api.base.dto.BaseImage
import com.vk.sdk.api.base.dto.BaseLikesInfo
import com.vk.sdk.api.base.dto.BaseLinkButton
import com.vk.sdk.api.base.dto.BaseRepostsInfo
import com.vk.sdk.api.classifieds.dto.ClassifiedsWorkiCarouselItem
import com.vk.sdk.api.classifieds.dto.ClassifiedsYoulaCarouselBlockGroup
import com.vk.sdk.api.classifieds.dto.ClassifiedsYoulaGroupsBlock
import com.vk.sdk.api.classifieds.dto.ClassifiedsYoulaItemExtended
import com.vk.sdk.api.discover.dto.DiscoverCarouselButton
import com.vk.sdk.api.discover.dto.DiscoverCarouselItem
import com.vk.sdk.api.discover.dto.DiscoverCarouselObjectsType
import com.vk.sdk.api.groups.dto.GroupsSuggestion
import com.vk.sdk.api.messages.dto.MessagesChatSuggestion
import com.vk.sdk.api.photos.dto.PhotosTagsSuggestionItem
import com.vk.sdk.api.photos.dto.PhotosTagsSuggestionItemEndCard
import com.vk.sdk.api.stories.dto.StoriesStory
import com.vk.sdk.api.textlives.dto.TextlivesTextliveTextpostBlock
import com.vk.sdk.api.video.dto.VideoVideo
import com.vk.sdk.api.video.dto.VideoVideoFull
import com.vk.sdk.api.wall.dto.WallGeo
import com.vk.sdk.api.wall.dto.WallPostCopyright
import com.vk.sdk.api.wall.dto.WallPostSource
import com.vk.sdk.api.wall.dto.WallPostType
import com.vk.sdk.api.wall.dto.WallViews
import com.vk.sdk.api.wall.dto.WallWallpostAttachment
import com.vk.sdk.api.wall.dto.WallWallpostDonut
import com.vk.sdk.api.wall.dto.WallWallpostFull
import java.lang.IllegalStateException
import java.lang.reflect.Type
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

sealed class NewsfeedNewsfeedItem {
    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param feedback
     * @param carouselOffset - Index of current carousel element
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
     * @param shortTextRate - Preview length control parameter
     * @param hash - Hash for sharing
     * @param accessKey - Access key to private object
     * @param isDeleted
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
    data class NewsfeedItemWallpost(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("feedback")
        val feedback: NewsfeedItemWallpostFeedback? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null,
        @SerializedName("copy_history")
        val copyHistory: List<WallWallpostFull>? = null,
        @SerializedName("can_edit")
        val canEdit: BaseBoolInt? = null,
        @SerializedName("created_by")
        val createdBy: UserId? = null,
        @SerializedName("can_delete")
        val canDelete: BaseBoolInt? = null,
        @SerializedName("can_pin")
        val canPin: BaseBoolInt? = null,
        @SerializedName("donut")
        val donut: WallWallpostDonut? = null,
        @SerializedName("is_pinned")
        val isPinned: Int? = null,
        @SerializedName("comments")
        val comments: BaseCommentsInfo? = null,
        @SerializedName("marked_as_ads")
        val markedAsAds: BaseBoolInt? = null,
        @SerializedName("topic_id")
        val topicId: NewsfeedItemWallpost.TopicId? = null,
        @SerializedName("short_text_rate")
        val shortTextRate: Float? = null,
        @SerializedName("hash")
        val hash: String? = null,
        @SerializedName("access_key")
        val accessKey: String? = null,
        @SerializedName("is_deleted")
        val isDeleted: Boolean? = null,
        @SerializedName("attachments")
        val attachments: List<WallWallpostAttachment>? = null,
        @SerializedName("copyright")
        val copyright: WallPostCopyright? = null,
        @SerializedName("edited")
        val edited: Int? = null,
        @SerializedName("from_id")
        val fromId: UserId? = null,
        @SerializedName("geo")
        val geo: WallGeo? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("is_archived")
        val isArchived: Boolean? = null,
        @SerializedName("is_favorite")
        val isFavorite: Boolean? = null,
        @SerializedName("likes")
        val likes: BaseLikesInfo? = null,
        @SerializedName("owner_id")
        val ownerId: UserId? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("parents_stack")
        val parentsStack: List<Int>? = null,
        @SerializedName("post_source")
        val postSource: WallPostSource? = null,
        @SerializedName("post_type")
        val postType: WallPostType? = null,
        @SerializedName("reposts")
        val reposts: BaseRepostsInfo? = null,
        @SerializedName("signer_id")
        val signerId: UserId? = null,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("views")
        val views: WallViews? = null
    ) : NewsfeedNewsfeedItem() {
        enum class TopicId(
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
     */
    data class NewsfeedItemPhoto(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("photos")
        val photos: NewsfeedItemPhotoPhotos? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param photoTags
     * @param postId - Post ID
     * @param carouselOffset - Index of current carousel element
     */
    data class NewsfeedItemPhotoTag(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("photo_tags")
        val photoTags: NewsfeedItemPhotoTagPhotoTags? = null,
        @SerializedName("post_id")
        val postId: Int? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param friends
     */
    data class NewsfeedItemFriend(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("friends")
        val friends: NewsfeedItemFriendFriends? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param audio
     * @param postId - Post ID
     */
    data class NewsfeedItemAudio(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("audio")
        val audio: NewsfeedItemAudioAudio? = null,
        @SerializedName("post_id")
        val postId: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param video
     * @param carouselOffset - Index of current carousel element
     */
    data class NewsfeedItemVideo(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("video")
        val video: NewsfeedItemVideoVideo? = null,
        @SerializedName("carousel_offset")
        val carouselOffset: Int? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param postId - Topic post ID
     * @param text - Post text
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param comments
     * @param likes
     */
    data class NewsfeedItemTopic(
        @SerializedName("post_id")
        val postId: Int,
        @SerializedName("text")
        val text: String,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("comments")
        val comments: BaseCommentsInfo? = null,
        @SerializedName("likes")
        val likes: BaseLikesInfo? = null
    ) : NewsfeedNewsfeedItem()

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
     * @param trackCode
     */
    data class NewsfeedItemDigest(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("feed_id")
        val feedId: String? = null,
        @SerializedName("items")
        val items: List<NewsfeedItemDigestItem>? = null,
        @SerializedName("main_post_ids")
        val mainPostIds: List<String>? = null,
        @SerializedName("template")
        val template: NewsfeedItemDigest.Template? = null,
        @SerializedName("header")
        val header: NewsfeedItemDigestHeader? = null,
        @SerializedName("footer")
        val footer: NewsfeedItemDigestFooter? = null,
        @SerializedName("track_code")
        val trackCode: String? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Template(
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
     * @param trackCode
     */
    data class NewsfeedItemPromoButton(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("action")
        val action: NewsfeedItemPromoButtonAction? = null,
        @SerializedName("images")
        val images: List<NewsfeedItemPromoButtonImage>? = null,
        @SerializedName("track_code")
        val trackCode: String? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param blockType
     * @param stories
     * @param title
     * @param trackCode
     */
    data class NewsfeedItemStoriesBlock(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("block_type")
        val blockType: NewsfeedItemStoriesBlock.BlockType? = null,
        @SerializedName("stories")
        val stories: List<StoriesStory>? = null,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null
    ) : NewsfeedNewsfeedItem() {
        enum class BlockType(
            val value: String
        ) {
            @SerializedName("local")
            LOCAL("local"),

            @SerializedName("remote")
            REMOTE("remote");
        }
    }

    /**
     * @param banner
     * @param poll
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param trackCode
     */
    data class NewsfeedItemFeedbackPoll(
        @SerializedName("banner")
        val banner: NewsfeedItemFeedbackPollBanner,
        @SerializedName("poll")
        val poll: NewsfeedItemFeedbackPollPoll,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("track_code")
        val trackCode: String? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param blockId
     * @param text
     * @param animation
     * @param trackCode
     * @param decoration - none - without background, background - with background, card - looks
     * like a card
     * @param subtitle
     * @param button
     */
    data class NewsfeedItemAnimatedBlock(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("block_id")
        val blockId: String? = null,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("animation")
        val animation: NewsfeedItemAnimatedBlockAnimation? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("decoration")
        val decoration: NewsfeedItemAnimatedBlock.Decoration? = null,
        @SerializedName("subtitle")
        val subtitle: String? = null,
        @SerializedName("button")
        val button: BaseLinkButton? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Decoration(
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
     * @param trackCode
     * @param items
     * @param nextFrom - Next from value
     * @param button
     */
    data class NewsfeedItemClipsBlock(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("items")
        val items: List<VideoVideo>? = null,
        @SerializedName("next_from")
        val nextFrom: String? = null,
        @SerializedName("button")
        val button: BaseLinkButton? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param title - Title of the block
     * @param items - Items of the block
     * @param count - Total count of recommendations
     * @param trackCode - Track code of the block
     * @param button
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param nextFrom - Encoded string for the next page
     */
    data class NewsfeedItemRecommendedGroupsBlock(
        @SerializedName("title")
        val title: String,
        @SerializedName("items")
        val items: List<GroupsSuggestion>,
        @SerializedName("count")
        val count: Int,
        @SerializedName("track_code")
        val trackCode: String,
        @SerializedName("button")
        val button: BaseLinkButton,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("next_from")
        val nextFrom: String? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param endCard
     * @param recognitionArticleLink - help link
     * @param trackCode - Track code of the block
     * @param items
     */
    data class NewsfeedItemRecognizeBlock(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("end_card")
        val endCard: PhotosTagsSuggestionItemEndCard? = null,
        @SerializedName("recognition_article_link")
        val recognitionArticleLink: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("items")
        val items: List<PhotosTagsSuggestionItem>? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param button
     * @param items
     * @param title
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param objects
     * @param objectsType
     * @param trackCode
     */
    data class NewsfeedItemAppsCarousel(
        @SerializedName("button")
        val button: DiscoverCarouselButton,
        @SerializedName("items")
        val items: List<DiscoverCarouselItem>,
        @SerializedName("title")
        val title: String,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("objects")
        val objects: List<AppsApp>? = null,
        @SerializedName("objects_type")
        val objectsType: DiscoverCarouselObjectsType? = null,
        @SerializedName("track_code")
        val trackCode: String? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param textliveTextpostBlock
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param trackCode
     */
    data class NewsfeedItemTextliveBlock(
        @SerializedName("textlive_textpost_block")
        val textliveTextpostBlock: TextlivesTextliveTextpostBlock,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("track_code")
        val trackCode: String? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type - type
     * @param items
     * @param createButtonUrl - Create button url
     * @param moreButtonUrl - More button url
     * @param blockTitle - Block title
     * @param blockDescription - Block description
     * @param trackCode
     * @param group
     * @param viewStyle
     */
    data class NewsfeedItemYoulaCarouselBlock(
        @SerializedName("type")
        val type: NewsfeedItemYoulaCarouselBlock.Type,
        @SerializedName("items")
        val items: List<ClassifiedsYoulaItemExtended>,
        @SerializedName("create_button_url")
        val createButtonUrl: String,
        @SerializedName("more_button_url")
        val moreButtonUrl: String,
        @SerializedName("block_title")
        val blockTitle: String? = null,
        @SerializedName("block_description")
        val blockDescription: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("group")
        val group: ClassifiedsYoulaCarouselBlockGroup? = null,
        @SerializedName("view_style")
        val viewStyle: String? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Type(
            val value: String
        ) {
            @SerializedName("youla_carousel")
            YOULA_CAROUSEL("youla_carousel");
        }
    }

    /**
     * @param type - type
     * @param blockTitle - Block title
     * @param trackCode
     * @param goodsCarouselViewType - Display style of block
     * @param blockPanel - Block top panel
     * @param promoCard - Promo card item
     * @param items
     * @param moreButton - More button url
     * @param footer
     * @param useOnelineProductTitle - Show product title in one row
     * @param isAsync - Load products via API method
     */
    data class NewsfeedItemAliexpressCarouselBlock(
        @SerializedName("type")
        val type: NewsfeedItemAliexpressCarouselBlock.Type,
        @SerializedName("block_title")
        val blockTitle: String,
        @SerializedName("track_code")
        val trackCode: String,
        @SerializedName("goods_carousel_view_type")
        val goodsCarouselViewType: String,
        @SerializedName("block_panel")
        val blockPanel: AliexpressBlockPanel? = null,
        @SerializedName("promo_card")
        val promoCard: AliexpressPromoCard? = null,
        @SerializedName("items")
        val items: List<AliexpressCarouselItem>? = null,
        @SerializedName("more_button")
        val moreButton: BaseLinkButton? = null,
        @SerializedName("footer")
        val footer: AliexpressSocialFooter? = null,
        @SerializedName("use_oneline_product_title")
        val useOnelineProductTitle: Boolean? = null,
        @SerializedName("is_async")
        val isAsync: Boolean? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Type(
            val value: String
        ) {
            @SerializedName("aliexpress_carousel")
            ALIEXPRESS_CAROUSEL("aliexpress_carousel");
        }
    }

    /**
     * @param app
     * @param title
     * @param buttonText
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param trackCode
     * @param friendsPlayingText
     * @param friendsAvatars
     * @param appCover
     */
    data class NewsfeedItemRecommendedAppBlock(
        @SerializedName("app")
        val app: AppsApp,
        @SerializedName("title")
        val title: String,
        @SerializedName("button_text")
        val buttonText: String,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("friends_playing_text")
        val friendsPlayingText: String? = null,
        @SerializedName("friends_avatars")
        val friendsAvatars: List<List<BaseImage>>? = null,
        @SerializedName("app_cover")
        val appCover: List<BaseImage>? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type
     * @param expertCard
     */
    data class NewsfeedItemExpertCardWidget(
        @SerializedName("type")
        val type: NewsfeedItemExpertCardWidget.Type? = null,
        @SerializedName("expert_card")
        val expertCard: NewsfeedExpertCardWidget? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Type(
            val value: String
        ) {
            @SerializedName("expert_card")
            EXPERT_CARD("expert_card");
        }
    }

    /**
     * @param type - type
     * @param items
     * @param blockTitle - Block title
     * @param moreButton - More button url
     * @param trackCode
     */
    data class NewsfeedItemWorkiCarouselBlock(
        @SerializedName("type")
        val type: NewsfeedItemWorkiCarouselBlock.Type,
        @SerializedName("items")
        val items: List<ClassifiedsWorkiCarouselItem>,
        @SerializedName("block_title")
        val blockTitle: String? = null,
        @SerializedName("more_button")
        val moreButton: BaseLinkButton? = null,
        @SerializedName("track_code")
        val trackCode: String? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Type(
            val value: String
        ) {
            @SerializedName("worki_carousel")
            WORKI_CAROUSEL("worki_carousel");
        }
    }

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param title
     * @param trackCode
     * @param items
     * @param nextFrom - Next from value
     * @param button
     */
    data class NewsfeedItemVideosForYouBlock(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("items")
        val items: List<VideoVideoFull>? = null,
        @SerializedName("next_from")
        val nextFrom: String? = null,
        @SerializedName("button")
        val button: BaseLinkButton? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param type - type
     * @param title
     * @param trackCode
     * @param isAsync
     * @param data
     */
    data class NewsfeedItemYoulaGroupsBlock(
        @SerializedName("type")
        val type: NewsfeedItemYoulaGroupsBlock.Type,
        @SerializedName("title")
        val title: String,
        @SerializedName("track_code")
        val trackCode: String,
        @SerializedName("is_async")
        val isAsync: Boolean,
        @SerializedName("data")
        val data: ClassifiedsYoulaGroupsBlock? = null
    ) : NewsfeedNewsfeedItem() {
        enum class Type(
            val value: String
        ) {
            @SerializedName("youla_groups_block")
            YOULA_GROUPS_BLOCK("youla_groups_block");
        }
    }

    /**
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param title
     * @param description
     * @param privacyText
     * @param trackCode
     * @param item
     * @param buttons
     */
    data class NewsfeedItemVideoPostcardBlock(
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
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
        @SerializedName("track_code")
        val trackCode: String? = null,
        @SerializedName("item")
        val item: VideoVideoFull? = null,
        @SerializedName("buttons")
        val buttons: List<BaseLinkButton>? = null
    ) : NewsfeedNewsfeedItem()

    /**
     * @param items - Items of the block
     * @param count - Total count of recommendations
     * @param trackCode - Track code of the block
     * @param button
     * @param type
     * @param sourceId - Item source ID
     * @param date - Date when item has been added in Unixtime
     * @param nextFrom - Encoded string for a next page
     */
    data class NewsfeedItemRecommendedChatsBlock(
        @SerializedName("items")
        val items: List<MessagesChatSuggestion>,
        @SerializedName("count")
        val count: Int,
        @SerializedName("track_code")
        val trackCode: String,
        @SerializedName("button")
        val button: BaseLinkButton,
        @SerializedName("type")
        val type: NewsfeedNewsfeedItemType,
        @SerializedName("source_id")
        val sourceId: UserId,
        @SerializedName("date")
        val date: Int,
        @SerializedName("next_from")
        val nextFrom: String? = null
    ) : NewsfeedNewsfeedItem()

    class Deserializer : JsonDeserializer<NewsfeedNewsfeedItem> {
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type?,
            context: JsonDeserializationContext
        ): NewsfeedNewsfeedItem {
            val type = json.asJsonObject.get("type").asString
            return when(type) {
                "post" -> context.deserialize(json, NewsfeedItemWallpost::class.java)
                "photo" -> context.deserialize(json, NewsfeedItemPhoto::class.java)
                "wall_photo" -> context.deserialize(json, NewsfeedItemPhoto::class.java)
                "photo_tag" -> context.deserialize(json, NewsfeedItemPhotoTag::class.java)
                "friend" -> context.deserialize(json, NewsfeedItemFriend::class.java)
                "audio" -> context.deserialize(json, NewsfeedItemAudio::class.java)
                "video" -> context.deserialize(json, NewsfeedItemVideo::class.java)
                "topic" -> context.deserialize(json, NewsfeedItemTopic::class.java)
                "digest" -> context.deserialize(json, NewsfeedItemDigest::class.java)
                "promo_button" -> context.deserialize(json, NewsfeedItemPromoButton::class.java)
                else -> throw IllegalStateException("no mapping for the type:" + type)
            }
        }
    }
}
