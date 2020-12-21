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
package com.vk.sdk.api.friends.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.audio.dto.AudioAudio
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseCity
import com.vk.sdk.api.base.dto.BaseCountry
import com.vk.sdk.api.base.dto.BaseCropPhoto
import com.vk.sdk.api.base.dto.BaseSex
import com.vk.sdk.api.owner.dto.OwnerState
import com.vk.sdk.api.photos.dto.PhotosPhoto
import com.vk.sdk.api.users.dto.UsersCareer
import com.vk.sdk.api.users.dto.UsersExports
import com.vk.sdk.api.users.dto.UsersLastSeen
import com.vk.sdk.api.users.dto.UsersMilitary
import com.vk.sdk.api.users.dto.UsersOccupation
import com.vk.sdk.api.users.dto.UsersOnlineInfo
import com.vk.sdk.api.users.dto.UsersPersonal
import com.vk.sdk.api.users.dto.UsersRelative
import com.vk.sdk.api.users.dto.UsersSchool
import com.vk.sdk.api.users.dto.UsersUniversity
import com.vk.sdk.api.users.dto.UsersUserCounters
import com.vk.sdk.api.users.dto.UsersUserMin
import com.vk.sdk.api.users.dto.UsersUserRelation
import com.vk.sdk.api.users.dto.UsersUserType
import com.vk.sdk.api.video.dto.VideoLiveInfo
import java.lang.reflect.Type
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param phone User phone
 * @param firstNameNom User's first name in nominative case
 * @param firstNameGen User's first name in genitive case
 * @param firstNameDat User's first name in dative case
 * @param firstNameAcc User's first name in accusative case
 * @param firstNameIns User's first name in instrumental case
 * @param firstNameAbl User's first name in prepositional case
 * @param lastNameNom User's last name in nominative case
 * @param lastNameGen User's last name in genitive case
 * @param lastNameDat User's last name in dative case
 * @param lastNameAcc User's last name in accusative case
 * @param lastNameIns User's last name in instrumental case
 * @param lastNameAbl User's last name in prepositional case
 * @param nickname User nickname
 * @param maidenName User maiden name
 * @param contactName User contact name
 * @param domain Domain name of the user's page
 * @param bdate User's date of birth
 * @param city no description
 * @param country no description
 * @param timezone User's timezone
 * @param ownerState no description
 * @param photo200 URL of square photo of the user with 200 pixels in width
 * @param photoMax URL of square photo of the user with maximum width
 * @param photo200Orig URL of user's photo with 200 pixels in width
 * @param photo400Orig URL of user's photo with 400 pixels in width
 * @param photoMaxOrig URL of user's photo of maximum size
 * @param photoId ID of the user's main photo
 * @param hasPhoto Information whether the user has main photo
 * @param hasMobile Information whether the user specified his phone number
 * @param isFriend Information whether the user is a friend of current user
 * @param wallComments Information whether current user can comment wall posts
 * @param canPost Information whether current user can post on the user's wall
 * @param canSeeAllPosts Information whether current user can see other users' audio on the wall
 * @param canSeeAudio Information whether current user can see the user's audio
 * @param type no description
 * @param email no description
 * @param skype no description
 * @param facebook no description
 * @param facebookName no description
 * @param twitter no description
 * @param livejournal no description
 * @param instagram no description
 * @param test no description
 * @param videoLive no description
 * @param isVideoLiveNotificationsBlocked no description
 * @param isService no description
 * @param serviceDescription no description
 * @param photo no description
 * @param photoBig no description
 * @param photo400 no description
 * @param photoMaxSize no description
 * @param language no description
 * @param storiesArchiveCount no description
 * @param wallDefault no description
 * @param canCall Information whether current user can call
 * @param canSeeWishes Information whether current user can see the user's wishes
 * @param canSeeGifts Information whether current user can see the user's gifts
 * @param interests no description
 * @param books no description
 * @param tv no description
 * @param quotes no description
 * @param about no description
 * @param games no description
 * @param movies no description
 * @param activities no description
 * @param music no description
 * @param canWritePrivateMessage Information whether current user can write private message
 * @param canSendFriendRequest Information whether current user can send a friend request
 * @param canBeInvitedGroup Information whether current user can be invited to the community
 * @param mobilePhone User's mobile phone number
 * @param homePhone User's additional phone number
 * @param site User's website
 * @param statusAudio no description
 * @param status User's status
 * @param activity User's status
 * @param lastSeen no description
 * @param exports no description
 * @param cropPhoto no description
 * @param followersCount Number of user's followers
 * @param videoLiveLevel User level in live streams achievements
 * @param videoLiveCount Number of user's live streams
 * @param clipsCount Number of user's clips
 * @param blacklisted Information whether current user is in the requested user's blacklist.
 * @param blacklistedByMe Information whether the requested user is in current user's blacklist
 * @param isFavorite Information whether the requested user is in faves of current user
 * @param isHiddenFromFeed Information whether the requested user is hidden from current user's
 * newsfeed
 * @param commonCount Number of common friends with current user
 * @param occupation no description
 * @param career no description
 * @param military no description
 * @param university University ID
 * @param universityName University name
 * @param universityGroupId no description
 * @param faculty Faculty ID
 * @param facultyName Faculty name
 * @param graduation Graduation year
 * @param educationForm Education form
 * @param educationStatus User's education status
 * @param homeTown User hometown
 * @param relation User relationship status
 * @param relationPartner no description
 * @param personal no description
 * @param universities no description
 * @param schools no description
 * @param relatives no description
 * @param isSubscribedPodcasts Information whether current user is subscribed to podcasts
 * @param canSubscribePodcasts Owner in whitelist or not
 * @param canSubscribePosts Can subscribe to wall
 * @param counters no description
 * @param accessKey no description
 * @param canUploadDoc no description
 * @param hash no description
 * @param hasEmail no description
 * @param sex User sex
 * @param screenName Domain name of the user's page
 * @param photo50 URL of square photo of the user with 50 pixels in width
 * @param photo100 URL of square photo of the user with 100 pixels in width
 * @param onlineInfo no description
 * @param online Information whether the user is online
 * @param onlineMobile Information whether the user is online in mobile site or application
 * @param onlineApp Application ID
 * @param verified Information whether the user is verified
 * @param trending Information whether the user has a "fire" pictogram.
 * @param friendStatus no description
 * @param mutual no description
 * @param deactivated Returns if a profile is deleted or blocked
 * @param firstName User first name
 * @param hidden Returns if a profile is hidden.
 * @param id User ID
 * @param lastName User last name
 * @param canAccessClosed no description
 * @param isClosed no description
 */
data class FriendsUserXtrPhone(
    @SerializedName(value="phone")
    val phone: String? = null,
    @SerializedName(value="first_name_nom")
    val firstNameNom: String? = null,
    @SerializedName(value="first_name_gen")
    val firstNameGen: String? = null,
    @SerializedName(value="first_name_dat")
    val firstNameDat: String? = null,
    @SerializedName(value="first_name_acc")
    val firstNameAcc: String? = null,
    @SerializedName(value="first_name_ins")
    val firstNameIns: String? = null,
    @SerializedName(value="first_name_abl")
    val firstNameAbl: String? = null,
    @SerializedName(value="last_name_nom")
    val lastNameNom: String? = null,
    @SerializedName(value="last_name_gen")
    val lastNameGen: String? = null,
    @SerializedName(value="last_name_dat")
    val lastNameDat: String? = null,
    @SerializedName(value="last_name_acc")
    val lastNameAcc: String? = null,
    @SerializedName(value="last_name_ins")
    val lastNameIns: String? = null,
    @SerializedName(value="last_name_abl")
    val lastNameAbl: String? = null,
    @SerializedName(value="nickname")
    val nickname: String? = null,
    @SerializedName(value="maiden_name")
    val maidenName: String? = null,
    @SerializedName(value="contact_name")
    val contactName: String? = null,
    @SerializedName(value="domain")
    val domain: String? = null,
    @SerializedName(value="bdate")
    val bdate: String? = null,
    @SerializedName(value="city")
    val city: BaseCity? = null,
    @SerializedName(value="country")
    val country: BaseCountry? = null,
    @SerializedName(value="timezone")
    val timezone: Float? = null,
    @SerializedName(value="owner_state")
    val ownerState: OwnerState? = null,
    @SerializedName(value="photo_200")
    val photo200: String? = null,
    @SerializedName(value="photo_max")
    val photoMax: String? = null,
    @SerializedName(value="photo_200_orig")
    val photo200Orig: String? = null,
    @SerializedName(value="photo_400_orig")
    val photo400Orig: String? = null,
    @SerializedName(value="photo_max_orig")
    val photoMaxOrig: String? = null,
    @SerializedName(value="photo_id")
    val photoId: String? = null,
    @SerializedName(value="has_photo")
    val hasPhoto: BaseBoolInt? = null,
    @SerializedName(value="has_mobile")
    val hasMobile: BaseBoolInt? = null,
    @SerializedName(value="is_friend")
    val isFriend: BaseBoolInt? = null,
    @SerializedName(value="wall_comments")
    val wallComments: BaseBoolInt? = null,
    @SerializedName(value="can_post")
    val canPost: BaseBoolInt? = null,
    @SerializedName(value="can_see_all_posts")
    val canSeeAllPosts: BaseBoolInt? = null,
    @SerializedName(value="can_see_audio")
    val canSeeAudio: BaseBoolInt? = null,
    @SerializedName(value="type")
    val type: UsersUserType? = null,
    @SerializedName(value="email")
    val email: String? = null,
    @SerializedName(value="skype")
    val skype: String? = null,
    @SerializedName(value="facebook")
    val facebook: String? = null,
    @SerializedName(value="facebook_name")
    val facebookName: String? = null,
    @SerializedName(value="twitter")
    val twitter: String? = null,
    @SerializedName(value="livejournal")
    val livejournal: String? = null,
    @SerializedName(value="instagram")
    val instagram: String? = null,
    @SerializedName(value="test")
    val test: BaseBoolInt? = null,
    @SerializedName(value="video_live")
    val videoLive: VideoLiveInfo? = null,
    @SerializedName(value="is_video_live_notifications_blocked")
    val isVideoLiveNotificationsBlocked: BaseBoolInt? = null,
    @SerializedName(value="is_service")
    val isService: Boolean? = null,
    @SerializedName(value="service_description")
    val serviceDescription: String? = null,
    @SerializedName(value="photo")
    val photo: String? = null,
    @SerializedName(value="photo_big")
    val photoBig: String? = null,
    @SerializedName(value="photo_400")
    val photo400: String? = null,
    @SerializedName(value="photo_max_size")
    val photoMaxSize: PhotosPhoto? = null,
    @SerializedName(value="language")
    val language: String? = null,
    @SerializedName(value="stories_archive_count")
    val storiesArchiveCount: Int? = null,
    @SerializedName(value="wall_default")
    val wallDefault: WallDefault? = null,
    @SerializedName(value="can_call")
    val canCall: Boolean? = null,
    @SerializedName(value="can_see_wishes")
    val canSeeWishes: Boolean? = null,
    @SerializedName(value="can_see_gifts")
    val canSeeGifts: BaseBoolInt? = null,
    @SerializedName(value="interests")
    val interests: String? = null,
    @SerializedName(value="books")
    val books: String? = null,
    @SerializedName(value="tv")
    val tv: String? = null,
    @SerializedName(value="quotes")
    val quotes: String? = null,
    @SerializedName(value="about")
    val about: String? = null,
    @SerializedName(value="games")
    val games: String? = null,
    @SerializedName(value="movies")
    val movies: String? = null,
    @SerializedName(value="activities")
    val activities: String? = null,
    @SerializedName(value="music")
    val music: String? = null,
    @SerializedName(value="can_write_private_message")
    val canWritePrivateMessage: BaseBoolInt? = null,
    @SerializedName(value="can_send_friend_request")
    val canSendFriendRequest: BaseBoolInt? = null,
    @SerializedName(value="can_be_invited_group")
    val canBeInvitedGroup: Boolean? = null,
    @SerializedName(value="mobile_phone")
    val mobilePhone: String? = null,
    @SerializedName(value="home_phone")
    val homePhone: String? = null,
    @SerializedName(value="site")
    val site: String? = null,
    @SerializedName(value="status_audio")
    val statusAudio: AudioAudio? = null,
    @SerializedName(value="status")
    val status: String? = null,
    @SerializedName(value="activity")
    val activity: String? = null,
    @SerializedName(value="last_seen")
    val lastSeen: UsersLastSeen? = null,
    @SerializedName(value="exports")
    val exports: UsersExports? = null,
    @SerializedName(value="crop_photo")
    val cropPhoto: BaseCropPhoto? = null,
    @SerializedName(value="followers_count")
    val followersCount: Int? = null,
    @SerializedName(value="video_live_level")
    val videoLiveLevel: Int? = null,
    @SerializedName(value="video_live_count")
    val videoLiveCount: Int? = null,
    @SerializedName(value="clips_count")
    val clipsCount: Int? = null,
    @SerializedName(value="blacklisted")
    val blacklisted: BaseBoolInt? = null,
    @SerializedName(value="blacklisted_by_me")
    val blacklistedByMe: BaseBoolInt? = null,
    @SerializedName(value="is_favorite")
    val isFavorite: BaseBoolInt? = null,
    @SerializedName(value="is_hidden_from_feed")
    val isHiddenFromFeed: BaseBoolInt? = null,
    @SerializedName(value="common_count")
    val commonCount: Int? = null,
    @SerializedName(value="occupation")
    val occupation: UsersOccupation? = null,
    @SerializedName(value="career")
    val career: List<UsersCareer>? = null,
    @SerializedName(value="military")
    val military: List<UsersMilitary>? = null,
    @SerializedName(value="university")
    val university: Int? = null,
    @SerializedName(value="university_name")
    val universityName: String? = null,
    @SerializedName(value="university_group_id")
    val universityGroupId: Int? = null,
    @SerializedName(value="faculty")
    val faculty: Int? = null,
    @SerializedName(value="faculty_name")
    val facultyName: String? = null,
    @SerializedName(value="graduation")
    val graduation: Int? = null,
    @SerializedName(value="education_form")
    val educationForm: String? = null,
    @SerializedName(value="education_status")
    val educationStatus: String? = null,
    @SerializedName(value="home_town")
    val homeTown: String? = null,
    @SerializedName(value="relation")
    val relation: UsersUserRelation? = null,
    @SerializedName(value="relation_partner")
    val relationPartner: UsersUserMin? = null,
    @SerializedName(value="personal")
    val personal: UsersPersonal? = null,
    @SerializedName(value="universities")
    val universities: List<UsersUniversity>? = null,
    @SerializedName(value="schools")
    val schools: List<UsersSchool>? = null,
    @SerializedName(value="relatives")
    val relatives: List<UsersRelative>? = null,
    @SerializedName(value="is_subscribed_podcasts")
    val isSubscribedPodcasts: Boolean? = null,
    @SerializedName(value="can_subscribe_podcasts")
    val canSubscribePodcasts: Boolean? = null,
    @SerializedName(value="can_subscribe_posts")
    val canSubscribePosts: Boolean? = null,
    @SerializedName(value="counters")
    val counters: UsersUserCounters? = null,
    @SerializedName(value="access_key")
    val accessKey: String? = null,
    @SerializedName(value="can_upload_doc")
    val canUploadDoc: BaseBoolInt? = null,
    @SerializedName(value="hash")
    val hash: String? = null,
    @SerializedName(value="has_email")
    val hasEmail: Boolean? = null,
    @SerializedName(value="sex")
    val sex: BaseSex? = null,
    @SerializedName(value="screen_name")
    val screenName: String? = null,
    @SerializedName(value="photo_50")
    val photo50: String? = null,
    @SerializedName(value="photo_100")
    val photo100: String? = null,
    @SerializedName(value="online_info")
    val onlineInfo: UsersOnlineInfo? = null,
    @SerializedName(value="online")
    val online: BaseBoolInt? = null,
    @SerializedName(value="online_mobile")
    val onlineMobile: BaseBoolInt? = null,
    @SerializedName(value="online_app")
    val onlineApp: Int? = null,
    @SerializedName(value="verified")
    val verified: BaseBoolInt? = null,
    @SerializedName(value="trending")
    val trending: BaseBoolInt? = null,
    @SerializedName(value="friend_status")
    val friendStatus: FriendsFriendStatusStatus? = null,
    @SerializedName(value="mutual")
    val mutual: FriendsRequestsMutual? = null,
    @SerializedName(value="deactivated")
    val deactivated: String? = null,
    @SerializedName(value="first_name")
    val firstName: String? = null,
    @SerializedName(value="hidden")
    val hidden: Int? = null,
    @SerializedName(value="id")
    val id: Int? = null,
    @SerializedName(value="last_name")
    val lastName: String? = null,
    @SerializedName(value="can_access_closed")
    val canAccessClosed: Boolean? = null,
    @SerializedName(value="is_closed")
    val isClosed: Boolean? = null
) {
    enum class WallDefault(
        val value: String
    ) {
        OWNER("owner"),

        ALL("all");

        class Serializer : JsonSerializer<WallDefault>, JsonDeserializer<WallDefault> {
            override fun serialize(
                src: WallDefault?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): WallDefault {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }
}
