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

import com.google.gson.annotations.SerializedName
import kotlin.String

enum class UsersFields(
    val value: String
) {
    @SerializedName("first_name_nom")
    FIRST_NAME_NOM("first_name_nom"),

    @SerializedName("first_name_gen")
    FIRST_NAME_GEN("first_name_gen"),

    @SerializedName("first_name_dat")
    FIRST_NAME_DAT("first_name_dat"),

    @SerializedName("first_name_acc")
    FIRST_NAME_ACC("first_name_acc"),

    @SerializedName("first_name_ins")
    FIRST_NAME_INS("first_name_ins"),

    @SerializedName("first_name_abl")
    FIRST_NAME_ABL("first_name_abl"),

    @SerializedName("last_name_nom")
    LAST_NAME_NOM("last_name_nom"),

    @SerializedName("last_name_gen")
    LAST_NAME_GEN("last_name_gen"),

    @SerializedName("last_name_dat")
    LAST_NAME_DAT("last_name_dat"),

    @SerializedName("last_name_acc")
    LAST_NAME_ACC("last_name_acc"),

    @SerializedName("last_name_ins")
    LAST_NAME_INS("last_name_ins"),

    @SerializedName("last_name_abl")
    LAST_NAME_ABL("last_name_abl"),

    @SerializedName("photo_id")
    PHOTO_ID("photo_id"),

    @SerializedName("verified")
    VERIFIED("verified"),

    @SerializedName("sex")
    SEX("sex"),

    @SerializedName("bdate")
    BDATE("bdate"),

    @SerializedName("birthdate")
    BIRTHDATE("birthdate"),

    @SerializedName("bdate_visibility")
    BDATE_VISIBILITY("bdate_visibility"),

    @SerializedName("city")
    CITY("city"),

    @SerializedName("country")
    COUNTRY("country"),

    @SerializedName("home_town")
    HOME_TOWN("home_town"),

    @SerializedName("has_photo")
    HAS_PHOTO("has_photo"),

    @SerializedName("photo")
    PHOTO("photo"),

    @SerializedName("photo_rec")
    PHOTO_REC("photo_rec"),

    @SerializedName("photo_50")
    PHOTO_50("photo_50"),

    @SerializedName("photo_100")
    PHOTO_100("photo_100"),

    @SerializedName("photo_200_orig")
    PHOTO_200_ORIG("photo_200_orig"),

    @SerializedName("photo_200")
    PHOTO_200("photo_200"),

    @SerializedName("photo_400")
    PHOTO_400("photo_400"),

    @SerializedName("photo_400_orig")
    PHOTO_400_ORIG("photo_400_orig"),

    @SerializedName("photo_big")
    PHOTO_BIG("photo_big"),

    @SerializedName("photo_medium")
    PHOTO_MEDIUM("photo_medium"),

    @SerializedName("photo_medium_rec")
    PHOTO_MEDIUM_REC("photo_medium_rec"),

    @SerializedName("photo_max")
    PHOTO_MAX("photo_max"),

    @SerializedName("photo_max_orig")
    PHOTO_MAX_ORIG("photo_max_orig"),

    @SerializedName("photo_max_size")
    PHOTO_MAX_SIZE("photo_max_size"),

    @SerializedName("profile_buttons")
    PROFILE_BUTTONS("profile_buttons"),

    @SerializedName("profile_buttons_tablet")
    PROFILE_BUTTONS_TABLET("profile_buttons_tablet"),

    @SerializedName("third_party_buttons")
    THIRD_PARTY_BUTTONS("third_party_buttons"),

    @SerializedName("online")
    ONLINE("online"),

    @SerializedName("lists")
    LISTS("lists"),

    @SerializedName("domain")
    DOMAIN("domain"),

    @SerializedName("has_mobile")
    HAS_MOBILE("has_mobile"),

    @SerializedName("contacts")
    CONTACTS("contacts"),

    @SerializedName("lang")
    LANG("lang"),

    @SerializedName("language")
    LANGUAGE("language"),

    @SerializedName("can_call")
    CAN_CALL("can_call"),

    @SerializedName("site")
    SITE("site"),

    @SerializedName("education")
    EDUCATION("education"),

    @SerializedName("universities")
    UNIVERSITIES("universities"),

    @SerializedName("schools")
    SCHOOLS("schools"),

    @SerializedName("status")
    STATUS("status"),

    @SerializedName("last_seen")
    LAST_SEEN("last_seen"),

    @SerializedName("followers_count")
    FOLLOWERS_COUNT("followers_count"),

    @SerializedName("counters")
    COUNTERS("counters"),

    @SerializedName("common_count")
    COMMON_COUNT("common_count"),

    @SerializedName("online_info")
    ONLINE_INFO("online_info"),

    @SerializedName("contact_name")
    CONTACT_NAME("contact_name"),

    @SerializedName("occupation")
    OCCUPATION("occupation"),

    @SerializedName("nickname")
    NICKNAME("nickname"),

    @SerializedName("relatives")
    RELATIVES("relatives"),

    @SerializedName("relation")
    RELATION("relation"),

    @SerializedName("personal")
    PERSONAL("personal"),

    @SerializedName("connections")
    CONNECTIONS("connections"),

    @SerializedName("exports")
    EXPORTS("exports"),

    @SerializedName("wall_comments")
    WALL_COMMENTS("wall_comments"),

    @SerializedName("wall_default")
    WALL_DEFAULT("wall_default"),

    @SerializedName("is_student")
    IS_STUDENT("is_student"),

    @SerializedName("activities")
    ACTIVITIES("activities"),

    @SerializedName("activity")
    ACTIVITY("activity"),

    @SerializedName("interests")
    INTERESTS("interests"),

    @SerializedName("image_status")
    IMAGE_STATUS("image_status"),

    @SerializedName("music")
    MUSIC("music"),

    @SerializedName("music_awards")
    MUSIC_AWARDS("music_awards"),

    @SerializedName("movies")
    MOVIES("movies"),

    @SerializedName("tv")
    TV("tv"),

    @SerializedName("books")
    BOOKS("books"),

    @SerializedName("buttons")
    BUTTONS("buttons"),

    @SerializedName("is_no_index")
    IS_NO_INDEX("is_no_index"),

    @SerializedName("games")
    GAMES("games"),

    @SerializedName("about")
    ABOUT("about"),

    @SerializedName("quotes")
    QUOTES("quotes"),

    @SerializedName("can_post")
    CAN_POST("can_post"),

    @SerializedName("can_see_all_posts")
    CAN_SEE_ALL_POSTS("can_see_all_posts"),

    @SerializedName("can_see_audio")
    CAN_SEE_AUDIO("can_see_audio"),

    @SerializedName("can_see_gifts")
    CAN_SEE_GIFTS("can_see_gifts"),

    @SerializedName("work")
    WORK("work"),

    @SerializedName("places")
    PLACES("places"),

    @SerializedName("can_write_private_message")
    CAN_WRITE_PRIVATE_MESSAGE("can_write_private_message"),

    @SerializedName("can_send_friend_request")
    CAN_SEND_FRIEND_REQUEST("can_send_friend_request"),

    @SerializedName("can_be_invited_group")
    CAN_BE_INVITED_GROUP("can_be_invited_group"),

    @SerializedName("can_upload_doc")
    CAN_UPLOAD_DOC("can_upload_doc"),

    @SerializedName("is_favorite")
    IS_FAVORITE("is_favorite"),

    @SerializedName("is_hidden_from_feed")
    IS_HIDDEN_FROM_FEED("is_hidden_from_feed"),

    @SerializedName("timezone")
    TIMEZONE("timezone"),

    @SerializedName("screen_name")
    SCREEN_NAME("screen_name"),

    @SerializedName("maiden_name")
    MAIDEN_NAME("maiden_name"),

    @SerializedName("crop_photo")
    CROP_PHOTO("crop_photo"),

    @SerializedName("is_friend")
    IS_FRIEND("is_friend"),

    @SerializedName("friend_status")
    FRIEND_STATUS("friend_status"),

    @SerializedName("career")
    CAREER("career"),

    @SerializedName("military")
    MILITARY("military"),

    @SerializedName("blacklisted")
    BLACKLISTED("blacklisted"),

    @SerializedName("blacklisted_by_me")
    BLACKLISTED_BY_ME("blacklisted_by_me"),

    @SerializedName("can_subscribe_posts")
    CAN_SUBSCRIBE_POSTS("can_subscribe_posts"),

    @SerializedName("descriptions")
    DESCRIPTIONS("descriptions"),

    @SerializedName("trending")
    TRENDING("trending"),

    @SerializedName("mutual")
    MUTUAL("mutual"),

    @SerializedName("friendship_weeks")
    FRIENDSHIP_WEEKS("friendship_weeks"),

    @SerializedName("can_invite_to_chats")
    CAN_INVITE_TO_CHATS("can_invite_to_chats"),

    @SerializedName("stories_archive_count")
    STORIES_ARCHIVE_COUNT("stories_archive_count"),

    @SerializedName("has_unseen_stories")
    HAS_UNSEEN_STORIES("has_unseen_stories"),

    @SerializedName("video_live")
    VIDEO_LIVE("video_live"),

    @SerializedName("video_live_level")
    VIDEO_LIVE_LEVEL("video_live_level"),

    @SerializedName("video_live_count")
    VIDEO_LIVE_COUNT("video_live_count"),

    @SerializedName("clips_count")
    CLIPS_COUNT("clips_count"),

    @SerializedName("service_description")
    SERVICE_DESCRIPTION("service_description"),

    @SerializedName("is_dead")
    IS_DEAD("is_dead"),

    @SerializedName("test")
    TEST("test"),

    @SerializedName("gifts_tooltip")
    GIFTS_TOOLTIP("gifts_tooltip"),

    @SerializedName("emoji_status")
    EMOJI_STATUS("emoji_status"),

    @SerializedName("can_call_from_group")
    CAN_CALL_FROM_GROUP("can_call_from_group"),

    @SerializedName("can_see_wishes")
    CAN_SEE_WISHES("can_see_wishes"),

    @SerializedName("is_video_live_notifications_blocked")
    IS_VIDEO_LIVE_NOTIFICATIONS_BLOCKED("is_video_live_notifications_blocked"),

    @SerializedName("is_adult")
    IS_ADULT("is_adult"),

    @SerializedName("is_subscribed")
    IS_SUBSCRIBED("is_subscribed"),

    @SerializedName("is_subscribed_stories")
    IS_SUBSCRIBED_STORIES("is_subscribed_stories"),

    @SerializedName("can_subscribe_stories")
    CAN_SUBSCRIBE_STORIES("can_subscribe_stories"),

    @SerializedName("can_ask_question")
    CAN_ASK_QUESTION("can_ask_question"),

    @SerializedName("can_ask_anonymous")
    CAN_ASK_ANONYMOUS("can_ask_anonymous"),

    @SerializedName("is_subscribed_podcasts")
    IS_SUBSCRIBED_PODCASTS("is_subscribed_podcasts"),

    @SerializedName("can_subscribe_podcasts")
    CAN_SUBSCRIBE_PODCASTS("can_subscribe_podcasts"),

    @SerializedName("subscription_country")
    SUBSCRIPTION_COUNTRY("subscription_country"),

    @SerializedName("has_email")
    HAS_EMAIL("has_email"),

    @SerializedName("has_rights")
    HAS_RIGHTS("has_rights"),

    @SerializedName("sys_username")
    SYS_USERNAME("sys_username"),

    @SerializedName("employee_mark")
    EMPLOYEE_MARK("employee_mark"),

    @SerializedName("rights_location")
    RIGHTS_LOCATION("rights_location");
}
