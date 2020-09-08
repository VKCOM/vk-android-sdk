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
import java.lang.reflect.Type
import kotlin.String

enum class GroupsFields(
    val value: String
) {
    MARKET("market"),

    MEMBER_STATUS("member_status"),

    IS_FAVORITE("is_favorite"),

    IS_SUBSCRIBED("is_subscribed"),

    CITY("city"),

    COUNTRY("country"),

    VERIFIED("verified"),

    DESCRIPTION("description"),

    WIKI_PAGE("wiki_page"),

    MEMBERS_COUNT("members_count"),

    COUNTERS("counters"),

    COVER("cover"),

    CAN_POST("can_post"),

    CAN_SEE_ALL_POSTS("can_see_all_posts"),

    ACTIVITY("activity"),

    FIXED_POST("fixed_post"),

    CAN_CREATE_TOPIC("can_create_topic"),

    CAN_UPLOAD_VIDEO("can_upload_video"),

    HAS_PHOTO("has_photo"),

    STATUS("status"),

    MAIN_ALBUM_ID("main_album_id"),

    LINKS("links"),

    CONTACTS("contacts"),

    SITE("site"),

    MAIN_SECTION("main_section"),

    TRENDING("trending"),

    CAN_MESSAGE("can_message"),

    IS_MARKET_CART_ENABLED("is_market_cart_enabled"),

    IS_MESSAGES_BLOCKED("is_messages_blocked"),

    CAN_SEND_NOTIFY("can_send_notify"),

    ONLINE_STATUS("online_status"),

    START_DATE("start_date"),

    FINISH_DATE("finish_date"),

    AGE_LIMITS("age_limits"),

    BAN_INFO("ban_info"),

    ACTION_BUTTON("action_button"),

    AUTHOR_ID("author_id"),

    PHONE("phone"),

    HAS_MARKET_APP("has_market_app"),

    ADDRESSES("addresses"),

    LIVE_COVERS("live_covers"),

    IS_ADULT("is_adult"),

    CAN_SUBSCRIBE_POSTS("can_subscribe_posts"),

    MENU("menu"),

    WARNING_NOTIFICATION("warning_notification"),

    DONUT("donut"),

    DONUT_PAYMENT_INFO("donut_payment_info"),

    CAN_POST_DONUT("can_post_donut"),

    CAN_SEE_MEMBERS("can_see_members"),

    MSG_PUSH_ALLOWED("msg_push_allowed"),

    CHATS_STATUS("chats_status"),

    CAN_REPORT("can_report"),

    HAS_SUGGESTIONS("has_suggestions"),

    SHOW_SUGGESTIONS("show_suggestions"),

    VERIFICATION_END_TIME("verification_end_time"),

    CAN_MANAGE("can_manage"),

    CAN_VIEW_STATS("can_view_stats"),

    CAN_VIEW_POST_REACH_STATS("can_view_post_reach_stats"),

    STORIES_ARCHIVE_COUNT("stories_archive_count"),

    VIDEO_LIVE_LEVEL("video_live_level"),

    VIDEO_LIVE_COUNT("video_live_count"),

    CLIPS_COUNT("clips_count");

    class Serializer : JsonDeserializer<GroupsFields> {
        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): GroupsFields = values().first { it.value.toString() == json!!.asJsonPrimitive.toString()
                }
    }
}
