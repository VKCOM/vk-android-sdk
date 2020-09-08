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

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseCountry
import com.vk.sdk.api.base.dto.BaseCropPhoto
import com.vk.sdk.api.base.dto.BaseObject
import java.lang.reflect.Type
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param market no description
 * @param memberStatus Current user's member status
 * @param isAdult Information whether community is adult
 * @param isHiddenFromFeed Information whether community is hidden from current user's newsfeed
 * @param isFavorite Information whether community is in faves
 * @param isSubscribed Information whether current user is subscribed
 * @param city no description
 * @param country no description
 * @param verified Information whether community is verified
 * @param description Community description
 * @param wikiPage Community's main wiki page title
 * @param membersCount Community members number
 * @param videoLiveLevel Community level live streams achievements
 * @param videoLiveCount Number of community's live streams
 * @param counters no description
 * @param cover no description
 * @param canPost Information whether current user can post on community's wall
 * @param canSeeAllPosts Information whether current user can see all posts on community's wall
 * @param activity Type of group, start date of event or category of public page
 * @param fixedPost Fixed post ID
 * @param canCreateTopic Information whether current user can create topic
 * @param canUploadDoc Information whether current user can upload doc
 * @param canUploadStory Information whether current user can upload story
 * @param canUploadVideo Information whether current user can upload video
 * @param hasPhoto Information whether community has photo
 * @param cropPhoto ������ � ������, �� ������� �������� ���������� � ����������� ����������
 * ����������
 * @param status Community status
 * @param mainAlbumId Community's main photo album ID
 * @param links no description
 * @param contacts no description
 * @param wall Information about wall status in community
 * @param site Community's website
 * @param mainSection no description
 * @param trending Information whether the community has a "fire" pictogram.
 * @param canMessage Information whether current user can send a message to community
 * @param isMessagesBlocked Information whether community can send a message to current user
 * @param canSendNotify Information whether community can send notifications by phone number to
 * current user
 * @param onlineStatus Status of replies in community messages
 * @param ageLimits Information whether age limit
 * @param banInfo User ban info
 * @param hasMarketApp Information whether community has installed market app
 * @param addresses Info about addresses in groups
 * @param isSubscribedPodcasts Information whether current user is subscribed to podcasts
 * @param canSubscribePodcasts Owner in whitelist or not
 * @param canSubscribePosts Can subscribe to wall
 * @param liveCovers Live covers state
 * @param adminLevel no description
 * @param deactivated Information whether community is banned
 * @param finishDate Finish date in Unixtime format
 * @param id Community ID
 * @param isAdmin Information whether current user is administrator
 * @param isAdvertiser Information whether current user is advertiser
 * @param isClosed no description
 * @param isMember Information whether current user is member
 * @param name Community name
 * @param photo100 URL of square photo of the community with 100 pixels in width
 * @param photo200 URL of square photo of the community with 200 pixels in width
 * @param photo50 URL of square photo of the community with 50 pixels in width
 * @param screenName Domain of the community page
 * @param startDate Start date in Unixtime format
 * @param type no description
 */
data class GroupsGroupFull(
    @SerializedName(value="market")
    val market: GroupsMarketInfo? = null,
    @SerializedName(value="member_status")
    val memberStatus: GroupsGroupFullMemberStatus? = null,
    @SerializedName(value="is_adult")
    val isAdult: BaseBoolInt? = null,
    @SerializedName(value="is_hidden_from_feed")
    val isHiddenFromFeed: BaseBoolInt? = null,
    @SerializedName(value="is_favorite")
    val isFavorite: BaseBoolInt? = null,
    @SerializedName(value="is_subscribed")
    val isSubscribed: BaseBoolInt? = null,
    @SerializedName(value="city")
    val city: BaseObject? = null,
    @SerializedName(value="country")
    val country: BaseCountry? = null,
    @SerializedName(value="verified")
    val verified: BaseBoolInt? = null,
    @SerializedName(value="description")
    val description: String? = null,
    @SerializedName(value="wiki_page")
    val wikiPage: String? = null,
    @SerializedName(value="members_count")
    val membersCount: Int? = null,
    @SerializedName(value="video_live_level")
    val videoLiveLevel: Int? = null,
    @SerializedName(value="video_live_count")
    val videoLiveCount: Int? = null,
    @SerializedName(value="counters")
    val counters: GroupsCountersGroup? = null,
    @SerializedName(value="cover")
    val cover: GroupsCover? = null,
    @SerializedName(value="can_post")
    val canPost: BaseBoolInt? = null,
    @SerializedName(value="can_see_all_posts")
    val canSeeAllPosts: BaseBoolInt? = null,
    @SerializedName(value="activity")
    val activity: String? = null,
    @SerializedName(value="fixed_post")
    val fixedPost: Int? = null,
    @SerializedName(value="can_create_topic")
    val canCreateTopic: BaseBoolInt? = null,
    @SerializedName(value="can_upload_doc")
    val canUploadDoc: BaseBoolInt? = null,
    @SerializedName(value="can_upload_story")
    val canUploadStory: BaseBoolInt? = null,
    @SerializedName(value="can_upload_video")
    val canUploadVideo: BaseBoolInt? = null,
    @SerializedName(value="has_photo")
    val hasPhoto: BaseBoolInt? = null,
    @SerializedName(value="crop_photo")
    val cropPhoto: BaseCropPhoto? = null,
    @SerializedName(value="status")
    val status: String? = null,
    @SerializedName(value="main_album_id")
    val mainAlbumId: Int? = null,
    @SerializedName(value="links")
    val links: List<GroupsLinksItem>? = null,
    @SerializedName(value="contacts")
    val contacts: List<GroupsContactsItem>? = null,
    @SerializedName(value="wall")
    val wall: Wall? = null,
    @SerializedName(value="site")
    val site: String? = null,
    @SerializedName(value="main_section")
    val mainSection: GroupsGroupFullMainSection? = null,
    @SerializedName(value="trending")
    val trending: BaseBoolInt? = null,
    @SerializedName(value="can_message")
    val canMessage: BaseBoolInt? = null,
    @SerializedName(value="is_messages_blocked")
    val isMessagesBlocked: BaseBoolInt? = null,
    @SerializedName(value="can_send_notify")
    val canSendNotify: BaseBoolInt? = null,
    @SerializedName(value="online_status")
    val onlineStatus: GroupsOnlineStatus? = null,
    @SerializedName(value="age_limits")
    val ageLimits: GroupsGroupFullAgeLimits? = null,
    @SerializedName(value="ban_info")
    val banInfo: GroupsGroupBanInfo? = null,
    @SerializedName(value="has_market_app")
    val hasMarketApp: Boolean? = null,
    @SerializedName(value="addresses")
    val addresses: GroupsAddressesInfo? = null,
    @SerializedName(value="is_subscribed_podcasts")
    val isSubscribedPodcasts: Boolean? = null,
    @SerializedName(value="can_subscribe_podcasts")
    val canSubscribePodcasts: Boolean? = null,
    @SerializedName(value="can_subscribe_posts")
    val canSubscribePosts: Boolean? = null,
    @SerializedName(value="live_covers")
    val liveCovers: GroupsLiveCovers? = null,
    @SerializedName(value="admin_level")
    val adminLevel: GroupsGroupAdminLevel? = null,
    @SerializedName(value="deactivated")
    val deactivated: String? = null,
    @SerializedName(value="finish_date")
    val finishDate: Int? = null,
    @SerializedName(value="id")
    val id: Int? = null,
    @SerializedName(value="is_admin")
    val isAdmin: BaseBoolInt? = null,
    @SerializedName(value="is_advertiser")
    val isAdvertiser: BaseBoolInt? = null,
    @SerializedName(value="is_closed")
    val isClosed: GroupsGroupIsClosed? = null,
    @SerializedName(value="is_member")
    val isMember: BaseBoolInt? = null,
    @SerializedName(value="name")
    val name: String? = null,
    @SerializedName(value="photo_100")
    val photo100: String? = null,
    @SerializedName(value="photo_200")
    val photo200: String? = null,
    @SerializedName(value="photo_50")
    val photo50: String? = null,
    @SerializedName(value="screen_name")
    val screenName: String? = null,
    @SerializedName(value="start_date")
    val startDate: Int? = null,
    @SerializedName(value="type")
    val type: GroupsGroupType? = null
) {
    enum class Wall(
        val value: Int
    ) {
        DISABLED(0),

        OPEN(1),

        LIMITED(2),

        RESTRICTED(3);

        class Serializer : JsonDeserializer<Wall> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): Wall = values().first { it.value.toString() == json!!.asJsonPrimitive.toString() }
        }
    }
}
