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

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import kotlin.String

enum class BaseUserGroupFields(
    val value: String
) {
    ABOUT("about"),

    ACTION_BUTTON("action_button"),

    ACTIVITIES("activities"),

    ACTIVITY("activity"),

    ADDRESSES("addresses"),

    ADMIN_LEVEL("admin_level"),

    AGE_LIMITS("age_limits"),

    AUTHOR_ID("author_id"),

    BAN_INFO("ban_info"),

    BDATE("bdate"),

    BLACKLISTED("blacklisted"),

    BLACKLISTED_BY_ME("blacklisted_by_me"),

    BOOKS("books"),

    CAN_CREATE_TOPIC("can_create_topic"),

    CAN_MESSAGE("can_message"),

    CAN_POST("can_post"),

    CAN_SEE_ALL_POSTS("can_see_all_posts"),

    CAN_SEE_AUDIO("can_see_audio"),

    CAN_SEND_FRIEND_REQUEST("can_send_friend_request"),

    CAN_UPLOAD_VIDEO("can_upload_video"),

    CAN_WRITE_PRIVATE_MESSAGE("can_write_private_message"),

    CAREER("career"),

    CITY("city"),

    COMMON_COUNT("common_count"),

    CONNECTIONS("connections"),

    CONTACTS("contacts"),

    COUNTERS("counters"),

    COUNTRY("country"),

    COVER("cover"),

    CROP_PHOTO("crop_photo"),

    DEACTIVATED("deactivated"),

    DESCRIPTION("description"),

    DOMAIN("domain"),

    EDUCATION("education"),

    EXPORTS("exports"),

    FINISH_DATE("finish_date"),

    FIXED_POST("fixed_post"),

    FOLLOWERS_COUNT("followers_count"),

    FRIEND_STATUS("friend_status"),

    GAMES("games"),

    HAS_MARKET_APP("has_market_app"),

    HAS_MOBILE("has_mobile"),

    HAS_PHOTO("has_photo"),

    HOME_TOWN("home_town"),

    ID("id"),

    INTERESTS("interests"),

    IS_ADMIN("is_admin"),

    IS_CLOSED("is_closed"),

    IS_FAVORITE("is_favorite"),

    IS_FRIEND("is_friend"),

    IS_HIDDEN_FROM_FEED("is_hidden_from_feed"),

    IS_MEMBER("is_member"),

    IS_MESSAGES_BLOCKED("is_messages_blocked"),

    CAN_SEND_NOTIFY("can_send_notify"),

    IS_SUBSCRIBED("is_subscribed"),

    LAST_SEEN("last_seen"),

    LINKS("links"),

    LISTS("lists"),

    MAIDEN_NAME("maiden_name"),

    MAIN_ALBUM_ID("main_album_id"),

    MAIN_SECTION("main_section"),

    MARKET("market"),

    MEMBER_STATUS("member_status"),

    MEMBERS_COUNT("members_count"),

    MILITARY("military"),

    MOVIES("movies"),

    MUSIC("music"),

    NAME("name"),

    NICKNAME("nickname"),

    OCCUPATION("occupation"),

    ONLINE("online"),

    ONLINE_STATUS("online_status"),

    PERSONAL("personal"),

    PHONE("phone"),

    PHOTO_100("photo_100"),

    PHOTO_200("photo_200"),

    PHOTO_200_ORIG("photo_200_orig"),

    PHOTO_400_ORIG("photo_400_orig"),

    PHOTO_50("photo_50"),

    PHOTO_ID("photo_id"),

    PHOTO_MAX("photo_max"),

    PHOTO_MAX_ORIG("photo_max_orig"),

    QUOTES("quotes"),

    RELATION("relation"),

    RELATIVES("relatives"),

    SCHOOLS("schools"),

    SCREEN_NAME("screen_name"),

    SEX("sex"),

    SITE("site"),

    START_DATE("start_date"),

    STATUS("status"),

    TIMEZONE("timezone"),

    TRENDING("trending"),

    TV("tv"),

    TYPE("type"),

    UNIVERSITIES("universities"),

    VERIFIED("verified"),

    WALL_COMMENTS("wall_comments"),

    WIKI_PAGE("wiki_page"),

    VK_ADMIN_STATUS("vk_admin_status");

    class Serializer : JsonDeserializer<BaseUserGroupFields> {
        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): BaseUserGroupFields = values().first { it.value.toString() ==
                json!!.asJsonPrimitive.toString() }
    }
}
