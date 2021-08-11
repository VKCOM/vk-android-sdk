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
package com.vk.sdk.api.base.dto

import com.google.gson.annotations.SerializedName
import kotlin.String

enum class BaseUserGroupFields(
    val value: String
) {
    @SerializedName("about")
    ABOUT("about"),

    @SerializedName("action_button")
    ACTION_BUTTON("action_button"),

    @SerializedName("activities")
    ACTIVITIES("activities"),

    @SerializedName("activity")
    ACTIVITY("activity"),

    @SerializedName("addresses")
    ADDRESSES("addresses"),

    @SerializedName("admin_level")
    ADMIN_LEVEL("admin_level"),

    @SerializedName("age_limits")
    AGE_LIMITS("age_limits"),

    @SerializedName("author_id")
    AUTHOR_ID("author_id"),

    @SerializedName("ban_info")
    BAN_INFO("ban_info"),

    @SerializedName("bdate")
    BDATE("bdate"),

    @SerializedName("blacklisted")
    BLACKLISTED("blacklisted"),

    @SerializedName("blacklisted_by_me")
    BLACKLISTED_BY_ME("blacklisted_by_me"),

    @SerializedName("books")
    BOOKS("books"),

    @SerializedName("can_create_topic")
    CAN_CREATE_TOPIC("can_create_topic"),

    @SerializedName("can_message")
    CAN_MESSAGE("can_message"),

    @SerializedName("is_widget_messages_enabled")
    IS_WIDGET_MESSAGES_ENABLED("is_widget_messages_enabled"),

    @SerializedName("can_post")
    CAN_POST("can_post"),

    @SerializedName("can_see_all_posts")
    CAN_SEE_ALL_POSTS("can_see_all_posts"),

    @SerializedName("can_see_audio")
    CAN_SEE_AUDIO("can_see_audio"),

    @SerializedName("can_send_friend_request")
    CAN_SEND_FRIEND_REQUEST("can_send_friend_request"),

    @SerializedName("can_upload_video")
    CAN_UPLOAD_VIDEO("can_upload_video"),

    @SerializedName("can_write_private_message")
    CAN_WRITE_PRIVATE_MESSAGE("can_write_private_message"),

    @SerializedName("career")
    CAREER("career"),

    @SerializedName("city")
    CITY("city"),

    @SerializedName("common_count")
    COMMON_COUNT("common_count"),

    @SerializedName("connections")
    CONNECTIONS("connections"),

    @SerializedName("contacts")
    CONTACTS("contacts"),

    @SerializedName("counters")
    COUNTERS("counters"),

    @SerializedName("country")
    COUNTRY("country"),

    @SerializedName("cover")
    COVER("cover"),

    @SerializedName("crop_photo")
    CROP_PHOTO("crop_photo"),

    @SerializedName("deactivated")
    DEACTIVATED("deactivated"),

    @SerializedName("description")
    DESCRIPTION("description"),

    @SerializedName("domain")
    DOMAIN("domain"),

    @SerializedName("education")
    EDUCATION("education"),

    @SerializedName("exports")
    EXPORTS("exports"),

    @SerializedName("finish_date")
    FINISH_DATE("finish_date"),

    @SerializedName("fixed_post")
    FIXED_POST("fixed_post"),

    @SerializedName("followers_count")
    FOLLOWERS_COUNT("followers_count"),

    @SerializedName("friend_status")
    FRIEND_STATUS("friend_status"),

    @SerializedName("games")
    GAMES("games"),

    @SerializedName("has_market_app")
    HAS_MARKET_APP("has_market_app"),

    @SerializedName("has_mobile")
    HAS_MOBILE("has_mobile"),

    @SerializedName("has_photo")
    HAS_PHOTO("has_photo"),

    @SerializedName("home_town")
    HOME_TOWN("home_town"),

    @SerializedName("id")
    ID("id"),

    @SerializedName("interests")
    INTERESTS("interests"),

    @SerializedName("is_admin")
    IS_ADMIN("is_admin"),

    @SerializedName("is_closed")
    IS_CLOSED("is_closed"),

    @SerializedName("is_favorite")
    IS_FAVORITE("is_favorite"),

    @SerializedName("is_friend")
    IS_FRIEND("is_friend"),

    @SerializedName("is_hidden_from_feed")
    IS_HIDDEN_FROM_FEED("is_hidden_from_feed"),

    @SerializedName("is_member")
    IS_MEMBER("is_member"),

    @SerializedName("is_messages_blocked")
    IS_MESSAGES_BLOCKED("is_messages_blocked"),

    @SerializedName("can_send_notify")
    CAN_SEND_NOTIFY("can_send_notify"),

    @SerializedName("is_subscribed")
    IS_SUBSCRIBED("is_subscribed"),

    @SerializedName("last_seen")
    LAST_SEEN("last_seen"),

    @SerializedName("links")
    LINKS("links"),

    @SerializedName("lists")
    LISTS("lists"),

    @SerializedName("maiden_name")
    MAIDEN_NAME("maiden_name"),

    @SerializedName("main_album_id")
    MAIN_ALBUM_ID("main_album_id"),

    @SerializedName("main_section")
    MAIN_SECTION("main_section"),

    @SerializedName("market")
    MARKET("market"),

    @SerializedName("member_status")
    MEMBER_STATUS("member_status"),

    @SerializedName("members_count")
    MEMBERS_COUNT("members_count"),

    @SerializedName("military")
    MILITARY("military"),

    @SerializedName("movies")
    MOVIES("movies"),

    @SerializedName("music")
    MUSIC("music"),

    @SerializedName("name")
    NAME("name"),

    @SerializedName("nickname")
    NICKNAME("nickname"),

    @SerializedName("occupation")
    OCCUPATION("occupation"),

    @SerializedName("online")
    ONLINE("online"),

    @SerializedName("online_status")
    ONLINE_STATUS("online_status"),

    @SerializedName("personal")
    PERSONAL("personal"),

    @SerializedName("phone")
    PHONE("phone"),

    @SerializedName("photo_100")
    PHOTO_100("photo_100"),

    @SerializedName("photo_200")
    PHOTO_200("photo_200"),

    @SerializedName("photo_200_orig")
    PHOTO_200_ORIG("photo_200_orig"),

    @SerializedName("photo_400_orig")
    PHOTO_400_ORIG("photo_400_orig"),

    @SerializedName("photo_50")
    PHOTO_50("photo_50"),

    @SerializedName("photo_id")
    PHOTO_ID("photo_id"),

    @SerializedName("photo_max")
    PHOTO_MAX("photo_max"),

    @SerializedName("photo_max_orig")
    PHOTO_MAX_ORIG("photo_max_orig"),

    @SerializedName("quotes")
    QUOTES("quotes"),

    @SerializedName("relation")
    RELATION("relation"),

    @SerializedName("relatives")
    RELATIVES("relatives"),

    @SerializedName("schools")
    SCHOOLS("schools"),

    @SerializedName("screen_name")
    SCREEN_NAME("screen_name"),

    @SerializedName("sex")
    SEX("sex"),

    @SerializedName("site")
    SITE("site"),

    @SerializedName("start_date")
    START_DATE("start_date"),

    @SerializedName("status")
    STATUS("status"),

    @SerializedName("timezone")
    TIMEZONE("timezone"),

    @SerializedName("trending")
    TRENDING("trending"),

    @SerializedName("tv")
    TV("tv"),

    @SerializedName("type")
    TYPE("type"),

    @SerializedName("universities")
    UNIVERSITIES("universities"),

    @SerializedName("verified")
    VERIFIED("verified"),

    @SerializedName("wall_comments")
    WALL_COMMENTS("wall_comments"),

    @SerializedName("wiki_page")
    WIKI_PAGE("wiki_page"),

    @SerializedName("vk_admin_status")
    VK_ADMIN_STATUS("vk_admin_status");
}
