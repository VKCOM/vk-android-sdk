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
import com.google.gson.JsonNull
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import kotlin.String

enum class UsersFields(
    val value: String
) {
    FIRST_NAME_NOM("first_name_nom"),

    FIRST_NAME_GEN("first_name_gen"),

    FIRST_NAME_DAT("first_name_dat"),

    FIRST_NAME_ACC("first_name_acc"),

    FIRST_NAME_INS("first_name_ins"),

    FIRST_NAME_ABL("first_name_abl"),

    LAST_NAME_NOM("last_name_nom"),

    LAST_NAME_GEN("last_name_gen"),

    LAST_NAME_DAT("last_name_dat"),

    LAST_NAME_ACC("last_name_acc"),

    LAST_NAME_INS("last_name_ins"),

    LAST_NAME_ABL("last_name_abl"),

    PHOTO_ID("photo_id"),

    VERIFIED("verified"),

    SEX("sex"),

    BDATE("bdate"),

    CITY("city"),

    COUNTRY("country"),

    HOME_TOWN("home_town"),

    HAS_PHOTO("has_photo"),

    PHOTO_50("photo_50"),

    PHOTO_100("photo_100"),

    PHOTO_200_ORIG("photo_200_orig"),

    PHOTO_200("photo_200"),

    PHOTO_400("photo_400"),

    PHOTO_400_ORIG("photo_400_orig"),

    PHOTO_MAX("photo_max"),

    PHOTO_MAX_ORIG("photo_max_orig"),

    PHOTO_MAX_SIZE("photo_max_size"),

    ONLINE("online"),

    LISTS("lists"),

    DOMAIN("domain"),

    HAS_MOBILE("has_mobile"),

    CONTACTS("contacts"),

    SITE("site"),

    EDUCATION("education"),

    UNIVERSITIES("universities"),

    SCHOOLS("schools"),

    STATUS("status"),

    LAST_SEEN("last_seen"),

    FOLLOWERS_COUNT("followers_count"),

    COUNTERS("counters"),

    COMMON_COUNT("common_count"),

    OCCUPATION("occupation"),

    NICKNAME("nickname"),

    RELATIVES("relatives"),

    RELATION("relation"),

    PERSONAL("personal"),

    CONNECTIONS("connections"),

    EXPORTS("exports"),

    WALL_COMMENTS("wall_comments"),

    ACTIVITIES("activities"),

    INTERESTS("interests"),

    MUSIC("music"),

    MOVIES("movies"),

    TV("tv"),

    BOOKS("books"),

    GAMES("games"),

    ABOUT("about"),

    QUOTES("quotes"),

    CAN_POST("can_post"),

    CAN_SEE_ALL_POSTS("can_see_all_posts"),

    CAN_SEE_AUDIO("can_see_audio"),

    CAN_WRITE_PRIVATE_MESSAGE("can_write_private_message"),

    CAN_SEND_FRIEND_REQUEST("can_send_friend_request"),

    IS_FAVORITE("is_favorite"),

    IS_HIDDEN_FROM_FEED("is_hidden_from_feed"),

    TIMEZONE("timezone"),

    SCREEN_NAME("screen_name"),

    MAIDEN_NAME("maiden_name"),

    CROP_PHOTO("crop_photo"),

    IS_FRIEND("is_friend"),

    FRIEND_STATUS("friend_status"),

    CAREER("career"),

    MILITARY("military"),

    BLACKLISTED("blacklisted"),

    BLACKLISTED_BY_ME("blacklisted_by_me"),

    CAN_SUBSCRIBE_POSTS("can_subscribe_posts"),

    DESCRIPTIONS("descriptions"),

    TRENDING("trending"),

    MUTUAL("mutual"),

    FRIENDSHIP_WEEKS("friendship_weeks"),

    CAN_INVITE_TO_CHATS("can_invite_to_chats"),

    STORIES_ARCHIVE_COUNT("stories_archive_count"),

    VIDEO_LIVE_LEVEL("video_live_level"),

    VIDEO_LIVE_COUNT("video_live_count"),

    CLIPS_COUNT("clips_count"),

    SERVICE_DESCRIPTION("service_description"),

    IS_DEAD("is_dead");

    class Serializer : JsonSerializer<UsersFields>, JsonDeserializer<UsersFields> {
        override fun serialize(
            src: UsersFields?,
            typeOfSrc: Type?,
            context: JsonSerializationContext?
        ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): UsersFields {
            val value = values().firstOrNull {
                it.value.toString() == json?.asJsonPrimitive?.asString
            }
            return value ?: throw JsonParseException(json.toString())
        }
    }
}
