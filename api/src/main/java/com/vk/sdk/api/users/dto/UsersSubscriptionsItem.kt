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
package com.vk.sdk.api.users.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.audio.dto.AudioAudio
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseCountry
import com.vk.sdk.api.base.dto.BaseCropPhoto
import com.vk.sdk.api.base.dto.BaseObject
import com.vk.sdk.api.base.dto.BaseSex
import com.vk.sdk.api.friends.dto.FriendsFriendStatusStatus
import com.vk.sdk.api.friends.dto.FriendsRequestsMutual
import com.vk.sdk.api.groups.dto.GroupsAddressesInfo
import com.vk.sdk.api.groups.dto.GroupsContactsItem
import com.vk.sdk.api.groups.dto.GroupsCountersGroup
import com.vk.sdk.api.groups.dto.GroupsCover
import com.vk.sdk.api.groups.dto.GroupsGroupAdminLevel
import com.vk.sdk.api.groups.dto.GroupsGroupBanInfo
import com.vk.sdk.api.groups.dto.GroupsGroupFullAgeLimits
import com.vk.sdk.api.groups.dto.GroupsGroupFullMemberStatus
import com.vk.sdk.api.groups.dto.GroupsGroupFullSection
import com.vk.sdk.api.groups.dto.GroupsGroupIsClosed
import com.vk.sdk.api.groups.dto.GroupsGroupType
import com.vk.sdk.api.groups.dto.GroupsLinksItem
import com.vk.sdk.api.groups.dto.GroupsLiveCovers
import com.vk.sdk.api.groups.dto.GroupsMarketInfo
import com.vk.sdk.api.groups.dto.GroupsOnlineStatus
import com.vk.sdk.api.groups.dto.GroupsPhotoSize
import com.vk.sdk.api.video.dto.VideoLiveInfo
import java.lang.IllegalStateException
import java.lang.reflect.Type
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

sealed class UsersSubscriptionsItem {
    /**
     * @param id - User ID
     * @param type
     * @param sex - User sex
     * @param screenName - Domain name of the user's page
     * @param photo50 - URL of square photo of the user with 50 pixels in width
     * @param photo100 - URL of square photo of the user with 100 pixels in width
     * @param onlineInfo
     * @param online - Information whether the user is online
     * @param onlineMobile - Information whether the user is online in mobile site or application
     * @param onlineApp - Application ID
     * @param verified - Information whether the user is verified
     * @param trending - Information whether the user has a "fire" pictogram.
     * @param friendStatus
     * @param mutual
     * @param deactivated - Returns if a profile is deleted or blocked
     * @param firstName - User first name
     * @param hidden - Returns if a profile is hidden.
     * @param lastName - User last name
     * @param canAccessClosed
     * @param isClosed
     */
    data class UsersUserXtrType(
        @SerializedName("id")
        val id: UserId,
        @SerializedName("type")
        val type: UsersUserType? = null,
        @SerializedName("sex")
        val sex: BaseSex? = null,
        @SerializedName("screen_name")
        val screenName: String? = null,
        @SerializedName("photo_50")
        val photo50: String? = null,
        @SerializedName("photo_100")
        val photo100: String? = null,
        @SerializedName("online_info")
        val onlineInfo: UsersOnlineInfo? = null,
        @SerializedName("online")
        val online: BaseBoolInt? = null,
        @SerializedName("online_mobile")
        val onlineMobile: BaseBoolInt? = null,
        @SerializedName("online_app")
        val onlineApp: Int? = null,
        @SerializedName("verified")
        val verified: BaseBoolInt? = null,
        @SerializedName("trending")
        val trending: BaseBoolInt? = null,
        @SerializedName("friend_status")
        val friendStatus: FriendsFriendStatusStatus? = null,
        @SerializedName("mutual")
        val mutual: FriendsRequestsMutual? = null,
        @SerializedName("deactivated")
        val deactivated: String? = null,
        @SerializedName("first_name")
        val firstName: String? = null,
        @SerializedName("hidden")
        val hidden: Int? = null,
        @SerializedName("last_name")
        val lastName: String? = null,
        @SerializedName("can_access_closed")
        val canAccessClosed: Boolean? = null,
        @SerializedName("is_closed")
        val isClosed: Boolean? = null
    ) : UsersSubscriptionsItem()

    /**
     * @param id - Community ID
     * @param market
     * @param memberStatus - Current user's member status
     * @param isAdult - Information whether community is adult
     * @param isHiddenFromFeed - Information whether community is hidden from current user's
     * newsfeed
     * @param isFavorite - Information whether community is in faves
     * @param isSubscribed - Information whether current user is subscribed
     * @param city
     * @param country
     * @param verified - Information whether community is verified
     * @param description - Community description
     * @param wikiPage - Community's main wiki page title
     * @param membersCount - Community members number
     * @param membersCountText - Info about number of users in group
     * @param requestsCount - The number of incoming requests to the community
     * @param videoLiveLevel - Community level live streams achievements
     * @param videoLiveCount - Number of community's live streams
     * @param clipsCount - Number of community's clips
     * @param counters
     * @param cover
     * @param canPost - Information whether current user can post on community's wall
     * @param canSuggest
     * @param canUploadStory - Information whether current user can upload story
     * @param canUploadDoc - Information whether current user can upload doc
     * @param canUploadVideo - Information whether current user can upload video
     * @param canSeeAllPosts - Information whether current user can see all posts on community's
     * wall
     * @param canCreateTopic - Information whether current user can create topic
     * @param activity - Type of group, start date of event or category of public page
     * @param fixedPost - Fixed post ID
     * @param hasPhoto - Information whether community has photo
     * @param
     * cropPhoto - ------ - ------, -- ------- -------- ---------- - ----------- ---------- ----------
     * @param status - Community status
     * @param statusAudio
     * @param mainAlbumId - Community's main photo album ID
     * @param links
     * @param contacts
     * @param wall - Information about wall status in community
     * @param site - Community's website
     * @param mainSection
     * @param secondarySection
     * @param trending - Information whether the community has a "fire" pictogram.
     * @param canMessage - Information whether current user can send a message to community
     * @param isMessagesBlocked - Information whether community can send a message to current user
     * @param canSendNotify - Information whether community can send notifications by phone number
     * to current user
     * @param onlineStatus - Status of replies in community messages
     * @param invitedBy - Inviter ID
     * @param ageLimits - Information whether age limit
     * @param banInfo - User ban info
     * @param hasMarketApp - Information whether community has installed market app
     * @param usingVkpayMarketApp
     * @param hasGroupChannel
     * @param addresses - Info about addresses in groups
     * @param isSubscribedPodcasts - Information whether current user is subscribed to podcasts
     * @param canSubscribePodcasts - Owner in whitelist or not
     * @param canSubscribePosts - Can subscribe to wall
     * @param liveCovers - Live covers state
     * @param storiesArchiveCount
     * @param hasUnseenStories
     * @param name - Community name
     * @param screenName - Domain of the community page
     * @param isClosed
     * @param type
     * @param isAdmin - Information whether current user is administrator
     * @param adminLevel
     * @param isMember - Information whether current user is member
     * @param isAdvertiser - Information whether current user is advertiser
     * @param startDate - Start date in Unixtime format
     * @param finishDate - Finish date in Unixtime format
     * @param deactivated - Information whether community is banned
     * @param photo50 - URL of square photo of the community with 50 pixels in width
     * @param photo100 - URL of square photo of the community with 100 pixels in width
     * @param photo200 - URL of square photo of the community with 200 pixels in width
     * @param photo200Orig - URL of square photo of the community with 200 pixels in width original
     * @param photo400 - URL of square photo of the community with 400 pixels in width
     * @param photo400Orig - URL of square photo of the community with 400 pixels in width original
     * @param photoMax - URL of square photo of the community with max pixels in width
     * @param photoMaxOrig - URL of square photo of the community with max pixels in width original
     * @param estDate - Established date
     * @param publicDateLabel - Public date label
     * @param photoMaxSize
     * @param isVideoLiveNotificationsBlocked
     * @param videoLive
     */
    data class GroupsGroupFull(
        @SerializedName("id")
        val id: UserId,
        @SerializedName("market")
        val market: GroupsMarketInfo? = null,
        @SerializedName("member_status")
        val memberStatus: GroupsGroupFullMemberStatus? = null,
        @SerializedName("is_adult")
        val isAdult: BaseBoolInt? = null,
        @SerializedName("is_hidden_from_feed")
        val isHiddenFromFeed: BaseBoolInt? = null,
        @SerializedName("is_favorite")
        val isFavorite: BaseBoolInt? = null,
        @SerializedName("is_subscribed")
        val isSubscribed: BaseBoolInt? = null,
        @SerializedName("city")
        val city: BaseObject? = null,
        @SerializedName("country")
        val country: BaseCountry? = null,
        @SerializedName("verified")
        val verified: BaseBoolInt? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("wiki_page")
        val wikiPage: String? = null,
        @SerializedName("members_count")
        val membersCount: Int? = null,
        @SerializedName("members_count_text")
        val membersCountText: String? = null,
        @SerializedName("requests_count")
        val requestsCount: Int? = null,
        @SerializedName("video_live_level")
        val videoLiveLevel: Int? = null,
        @SerializedName("video_live_count")
        val videoLiveCount: Int? = null,
        @SerializedName("clips_count")
        val clipsCount: Int? = null,
        @SerializedName("counters")
        val counters: GroupsCountersGroup? = null,
        @SerializedName("cover")
        val cover: GroupsCover? = null,
        @SerializedName("can_post")
        val canPost: BaseBoolInt? = null,
        @SerializedName("can_suggest")
        val canSuggest: BaseBoolInt? = null,
        @SerializedName("can_upload_story")
        val canUploadStory: BaseBoolInt? = null,
        @SerializedName("can_upload_doc")
        val canUploadDoc: BaseBoolInt? = null,
        @SerializedName("can_upload_video")
        val canUploadVideo: BaseBoolInt? = null,
        @SerializedName("can_see_all_posts")
        val canSeeAllPosts: BaseBoolInt? = null,
        @SerializedName("can_create_topic")
        val canCreateTopic: BaseBoolInt? = null,
        @SerializedName("activity")
        val activity: String? = null,
        @SerializedName("fixed_post")
        val fixedPost: Int? = null,
        @SerializedName("has_photo")
        val hasPhoto: BaseBoolInt? = null,
        @SerializedName("crop_photo")
        val cropPhoto: BaseCropPhoto? = null,
        @SerializedName("status")
        val status: String? = null,
        @SerializedName("status_audio")
        val statusAudio: AudioAudio? = null,
        @SerializedName("main_album_id")
        val mainAlbumId: Int? = null,
        @SerializedName("links")
        val links: List<GroupsLinksItem>? = null,
        @SerializedName("contacts")
        val contacts: List<GroupsContactsItem>? = null,
        @SerializedName("wall")
        val wall: GroupsGroupFull.Wall? = null,
        @SerializedName("site")
        val site: String? = null,
        @SerializedName("main_section")
        val mainSection: GroupsGroupFullSection? = null,
        @SerializedName("secondary_section")
        val secondarySection: GroupsGroupFullSection? = null,
        @SerializedName("trending")
        val trending: BaseBoolInt? = null,
        @SerializedName("can_message")
        val canMessage: BaseBoolInt? = null,
        @SerializedName("is_messages_blocked")
        val isMessagesBlocked: BaseBoolInt? = null,
        @SerializedName("can_send_notify")
        val canSendNotify: BaseBoolInt? = null,
        @SerializedName("online_status")
        val onlineStatus: GroupsOnlineStatus? = null,
        @SerializedName("invited_by")
        val invitedBy: Int? = null,
        @SerializedName("age_limits")
        val ageLimits: GroupsGroupFullAgeLimits? = null,
        @SerializedName("ban_info")
        val banInfo: GroupsGroupBanInfo? = null,
        @SerializedName("has_market_app")
        val hasMarketApp: Boolean? = null,
        @SerializedName("using_vkpay_market_app")
        val usingVkpayMarketApp: Boolean? = null,
        @SerializedName("has_group_channel")
        val hasGroupChannel: Boolean? = null,
        @SerializedName("addresses")
        val addresses: GroupsAddressesInfo? = null,
        @SerializedName("is_subscribed_podcasts")
        val isSubscribedPodcasts: Boolean? = null,
        @SerializedName("can_subscribe_podcasts")
        val canSubscribePodcasts: Boolean? = null,
        @SerializedName("can_subscribe_posts")
        val canSubscribePosts: Boolean? = null,
        @SerializedName("live_covers")
        val liveCovers: GroupsLiveCovers? = null,
        @SerializedName("stories_archive_count")
        val storiesArchiveCount: Int? = null,
        @SerializedName("has_unseen_stories")
        val hasUnseenStories: Boolean? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("screen_name")
        val screenName: String? = null,
        @SerializedName("is_closed")
        val isClosed: GroupsGroupIsClosed? = null,
        @SerializedName("type")
        val type: GroupsGroupType? = null,
        @SerializedName("is_admin")
        val isAdmin: BaseBoolInt? = null,
        @SerializedName("admin_level")
        val adminLevel: GroupsGroupAdminLevel? = null,
        @SerializedName("is_member")
        val isMember: BaseBoolInt? = null,
        @SerializedName("is_advertiser")
        val isAdvertiser: BaseBoolInt? = null,
        @SerializedName("start_date")
        val startDate: Int? = null,
        @SerializedName("finish_date")
        val finishDate: Int? = null,
        @SerializedName("deactivated")
        val deactivated: String? = null,
        @SerializedName("photo_50")
        val photo50: String? = null,
        @SerializedName("photo_100")
        val photo100: String? = null,
        @SerializedName("photo_200")
        val photo200: String? = null,
        @SerializedName("photo_200_orig")
        val photo200Orig: String? = null,
        @SerializedName("photo_400")
        val photo400: String? = null,
        @SerializedName("photo_400_orig")
        val photo400Orig: String? = null,
        @SerializedName("photo_max")
        val photoMax: String? = null,
        @SerializedName("photo_max_orig")
        val photoMaxOrig: String? = null,
        @SerializedName("est_date")
        val estDate: String? = null,
        @SerializedName("public_date_label")
        val publicDateLabel: String? = null,
        @SerializedName("photo_max_size")
        val photoMaxSize: GroupsPhotoSize? = null,
        @SerializedName("is_video_live_notifications_blocked")
        val isVideoLiveNotificationsBlocked: BaseBoolInt? = null,
        @SerializedName("video_live")
        val videoLive: VideoLiveInfo? = null
    ) : UsersSubscriptionsItem() {
        enum class Wall(
            val value: Int
        ) {
            @SerializedName("0")
            DISABLED(0),

            @SerializedName("1")
            OPEN(1),

            @SerializedName("2")
            LIMITED(2),

            @SerializedName("3")
            RESTRICTED(3);
        }
    }

    class Deserializer : JsonDeserializer<UsersSubscriptionsItem> {
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type?,
            context: JsonDeserializationContext
        ): UsersSubscriptionsItem {
            val type = json.asJsonObject.get("type").asString
            return when(type) {
                "profile" -> context.deserialize(json, UsersUserXtrType::class.java)
                "group" -> context.deserialize(json, GroupsGroupFull::class.java)
                "page" -> context.deserialize(json, GroupsGroupFull::class.java)
                "event" -> context.deserialize(json, GroupsGroupFull::class.java)
                else -> throw IllegalStateException("no mapping for the type:" + type)
            }
        }
    }
}
