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
package com.vk.sdk.api.groups.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.audio.dto.AudioAudioDto
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseCountryDto
import com.vk.sdk.api.base.dto.BaseCropPhotoDto
import com.vk.sdk.api.base.dto.BaseObjectDto
import com.vk.sdk.api.base.dto.BaseOwnerCoverDto
import com.vk.sdk.api.video.dto.VideoLiveInfoDto
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id - Community ID
 * @param memberStatus - Current user's member status
 * @param isAdult - Information whether community is adult
 * @param isHiddenFromFeed - Information whether community is hidden from current user's newsfeed
 * @param isFavorite - Information whether community is in faves
 * @param isSubscribed - Information whether current user is subscribed
 * @param city
 * @param country
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
 * @param canCallToCommunity - Information whether current user can call to community
 * @param canUploadDoc - Information whether current user can upload doc
 * @param canUploadVideo - Information whether current user can upload video
 * @param canSeeAllPosts - Information whether current user can see all posts on community's wall
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
 * @param canSendNotify - Information whether community can send notifications by phone number to
 * current user
 * @param onlineStatus - Status of replies in community messages
 * @param invitedBy - Inviter ID
 * @param ageLimits - Information whether age limit
 * @param banInfo - User ban info
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
 * @param verified - Information whether community is verified
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
 * @param market
 * @param hasMarketApp - Information whether community has installed market app
 * @param usingVkpayMarketApp
 */
data class GroupsGroupFullDto(
    @SerializedName("id")
    val id: UserId,
    @SerializedName("member_status")
    val memberStatus: GroupsGroupFullMemberStatusDto? = null,
    @SerializedName("is_adult")
    val isAdult: BaseBoolIntDto? = null,
    @SerializedName("is_hidden_from_feed")
    val isHiddenFromFeed: BaseBoolIntDto? = null,
    @SerializedName("is_favorite")
    val isFavorite: BaseBoolIntDto? = null,
    @SerializedName("is_subscribed")
    val isSubscribed: BaseBoolIntDto? = null,
    @SerializedName("city")
    val city: BaseObjectDto? = null,
    @SerializedName("country")
    val country: BaseCountryDto? = null,
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
    val counters: GroupsCountersGroupDto? = null,
    @SerializedName("cover")
    val cover: BaseOwnerCoverDto? = null,
    @SerializedName("can_post")
    val canPost: BaseBoolIntDto? = null,
    @SerializedName("can_suggest")
    val canSuggest: BaseBoolIntDto? = null,
    @SerializedName("can_upload_story")
    val canUploadStory: BaseBoolIntDto? = null,
    @SerializedName("can_call_to_community")
    val canCallToCommunity: Boolean? = null,
    @SerializedName("can_upload_doc")
    val canUploadDoc: BaseBoolIntDto? = null,
    @SerializedName("can_upload_video")
    val canUploadVideo: BaseBoolIntDto? = null,
    @SerializedName("can_see_all_posts")
    val canSeeAllPosts: BaseBoolIntDto? = null,
    @SerializedName("can_create_topic")
    val canCreateTopic: BaseBoolIntDto? = null,
    @SerializedName("activity")
    val activity: String? = null,
    @SerializedName("fixed_post")
    val fixedPost: Int? = null,
    @SerializedName("has_photo")
    val hasPhoto: BaseBoolIntDto? = null,
    @SerializedName("crop_photo")
    val cropPhoto: BaseCropPhotoDto? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("status_audio")
    val statusAudio: AudioAudioDto? = null,
    @SerializedName("main_album_id")
    val mainAlbumId: Int? = null,
    @SerializedName("links")
    val links: List<GroupsLinksItemDto>? = null,
    @SerializedName("contacts")
    val contacts: List<GroupsContactsItemDto>? = null,
    @SerializedName("wall")
    val wall: GroupsGroupFullDto.WallDto? = null,
    @SerializedName("site")
    val site: String? = null,
    @SerializedName("main_section")
    val mainSection: GroupsGroupFullSectionDto? = null,
    @SerializedName("secondary_section")
    val secondarySection: GroupsGroupFullSectionDto? = null,
    @SerializedName("trending")
    val trending: BaseBoolIntDto? = null,
    @SerializedName("can_message")
    val canMessage: BaseBoolIntDto? = null,
    @SerializedName("is_messages_blocked")
    val isMessagesBlocked: BaseBoolIntDto? = null,
    @SerializedName("can_send_notify")
    val canSendNotify: BaseBoolIntDto? = null,
    @SerializedName("online_status")
    val onlineStatus: GroupsOnlineStatusDto? = null,
    @SerializedName("invited_by")
    val invitedBy: Int? = null,
    @SerializedName("age_limits")
    val ageLimits: GroupsGroupFullAgeLimitsDto? = null,
    @SerializedName("ban_info")
    val banInfo: GroupsGroupBanInfoDto? = null,
    @SerializedName("has_group_channel")
    val hasGroupChannel: Boolean? = null,
    @SerializedName("addresses")
    val addresses: GroupsAddressesInfoDto? = null,
    @SerializedName("is_subscribed_podcasts")
    val isSubscribedPodcasts: Boolean? = null,
    @SerializedName("can_subscribe_podcasts")
    val canSubscribePodcasts: Boolean? = null,
    @SerializedName("can_subscribe_posts")
    val canSubscribePosts: Boolean? = null,
    @SerializedName("live_covers")
    val liveCovers: GroupsLiveCoversDto? = null,
    @SerializedName("stories_archive_count")
    val storiesArchiveCount: Int? = null,
    @SerializedName("has_unseen_stories")
    val hasUnseenStories: Boolean? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("screen_name")
    val screenName: String? = null,
    @SerializedName("is_closed")
    val isClosed: GroupsGroupIsClosedDto? = null,
    @SerializedName("type")
    val type: GroupsGroupTypeDto? = null,
    @SerializedName("is_admin")
    val isAdmin: BaseBoolIntDto? = null,
    @SerializedName("admin_level")
    val adminLevel: GroupsGroupAdminLevelDto? = null,
    @SerializedName("is_member")
    val isMember: BaseBoolIntDto? = null,
    @SerializedName("is_advertiser")
    val isAdvertiser: BaseBoolIntDto? = null,
    @SerializedName("start_date")
    val startDate: Int? = null,
    @SerializedName("finish_date")
    val finishDate: Int? = null,
    @SerializedName("verified")
    val verified: BaseBoolIntDto? = null,
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
    val photoMaxSize: GroupsPhotoSizeDto? = null,
    @SerializedName("is_video_live_notifications_blocked")
    val isVideoLiveNotificationsBlocked: BaseBoolIntDto? = null,
    @SerializedName("video_live")
    val videoLive: VideoLiveInfoDto? = null,
    @SerializedName("market")
    val market: GroupsMarketInfoDto? = null,
    @SerializedName("has_market_app")
    val hasMarketApp: Boolean? = null,
    @SerializedName("using_vkpay_market_app")
    val usingVkpayMarketApp: Boolean? = null
) {
    enum class WallDto(
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
