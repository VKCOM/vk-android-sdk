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
import kotlin.String

enum class GroupsFields(
    val value: String
) {
    @SerializedName("market")
    MARKET("market"),

    @SerializedName("market_services")
    MARKET_SERVICES("market_services"),

    @SerializedName("member_status")
    MEMBER_STATUS("member_status"),

    @SerializedName("is_favorite")
    IS_FAVORITE("is_favorite"),

    @SerializedName("is_subscribed")
    IS_SUBSCRIBED("is_subscribed"),

    @SerializedName("is_subscribed_podcasts")
    IS_SUBSCRIBED_PODCASTS("is_subscribed_podcasts"),

    @SerializedName("can_subscribe_podcasts")
    CAN_SUBSCRIBE_PODCASTS("can_subscribe_podcasts"),

    @SerializedName("city")
    CITY("city"),

    @SerializedName("country")
    COUNTRY("country"),

    @SerializedName("verified")
    VERIFIED("verified"),

    @SerializedName("description")
    DESCRIPTION("description"),

    @SerializedName("wiki_page")
    WIKI_PAGE("wiki_page"),

    @SerializedName("members_count")
    MEMBERS_COUNT("members_count"),

    @SerializedName("requests_count")
    REQUESTS_COUNT("requests_count"),

    @SerializedName("counters")
    COUNTERS("counters"),

    @SerializedName("cover")
    COVER("cover"),

    @SerializedName("can_post")
    CAN_POST("can_post"),

    @SerializedName("can_suggest")
    CAN_SUGGEST("can_suggest"),

    @SerializedName("can_upload_story")
    CAN_UPLOAD_STORY("can_upload_story"),

    @SerializedName("can_upload_doc")
    CAN_UPLOAD_DOC("can_upload_doc"),

    @SerializedName("can_upload_video")
    CAN_UPLOAD_VIDEO("can_upload_video"),

    @SerializedName("can_upload_clip")
    CAN_UPLOAD_CLIP("can_upload_clip"),

    @SerializedName("can_see_all_posts")
    CAN_SEE_ALL_POSTS("can_see_all_posts"),

    @SerializedName("can_create_topic")
    CAN_CREATE_TOPIC("can_create_topic"),

    @SerializedName("crop_photo")
    CROP_PHOTO("crop_photo"),

    @SerializedName("activity")
    ACTIVITY("activity"),

    @SerializedName("fixed_post")
    FIXED_POST("fixed_post"),

    @SerializedName("has_photo")
    HAS_PHOTO("has_photo"),

    @SerializedName("status")
    STATUS("status"),

    @SerializedName("main_album_id")
    MAIN_ALBUM_ID("main_album_id"),

    @SerializedName("links")
    LINKS("links"),

    @SerializedName("contacts")
    CONTACTS("contacts"),

    @SerializedName("site")
    SITE("site"),

    @SerializedName("main_section")
    MAIN_SECTION("main_section"),

    @SerializedName("secondary_section")
    SECONDARY_SECTION("secondary_section"),

    @SerializedName("wall")
    WALL("wall"),

    @SerializedName("trending")
    TRENDING("trending"),

    @SerializedName("had_torch")
    HAD_TORCH("had_torch"),

    @SerializedName("can_message")
    CAN_MESSAGE("can_message"),

    @SerializedName("is_market_cart_enabled")
    IS_MARKET_CART_ENABLED("is_market_cart_enabled"),

    @SerializedName("is_messages_blocked")
    IS_MESSAGES_BLOCKED("is_messages_blocked"),

    @SerializedName("can_send_notify")
    CAN_SEND_NOTIFY("can_send_notify"),

    @SerializedName("has_group_channel")
    HAS_GROUP_CHANNEL("has_group_channel"),

    @SerializedName("group_channel")
    GROUP_CHANNEL("group_channel"),

    @SerializedName("online_status")
    ONLINE_STATUS("online_status"),

    @SerializedName("start_date")
    START_DATE("start_date"),

    @SerializedName("finish_date")
    FINISH_DATE("finish_date"),

    @SerializedName("age_limits")
    AGE_LIMITS("age_limits"),

    @SerializedName("ban_info")
    BAN_INFO("ban_info"),

    @SerializedName("action_button")
    ACTION_BUTTON("action_button"),

    @SerializedName("author_id")
    AUTHOR_ID("author_id"),

    @SerializedName("phone")
    PHONE("phone"),

    @SerializedName("has_market_app")
    HAS_MARKET_APP("has_market_app"),

    @SerializedName("vkpay_can_transfer")
    VKPAY_CAN_TRANSFER("vkpay_can_transfer"),

    @SerializedName("vkpay_receiver_id")
    VKPAY_RECEIVER_ID("vkpay_receiver_id"),

    @SerializedName("using_vkpay_market_app")
    USING_VKPAY_MARKET_APP("using_vkpay_market_app"),

    @SerializedName("addresses")
    ADDRESSES("addresses"),

    @SerializedName("live_covers")
    LIVE_COVERS("live_covers"),

    @SerializedName("is_adult")
    IS_ADULT("is_adult"),

    @SerializedName("is_hidden_from_feed")
    IS_HIDDEN_FROM_FEED("is_hidden_from_feed"),

    @SerializedName("can_subscribe_posts")
    CAN_SUBSCRIBE_POSTS("can_subscribe_posts"),

    @SerializedName("create_date")
    CREATE_DATE("create_date"),

    @SerializedName("menu")
    MENU("menu"),

    @SerializedName("warning_notification")
    WARNING_NOTIFICATION("warning_notification"),

    @SerializedName("donut")
    DONUT("donut"),

    @SerializedName("donut_payment_info")
    DONUT_PAYMENT_INFO("donut_payment_info"),

    @SerializedName("can_post_donut")
    CAN_POST_DONUT("can_post_donut"),

    @SerializedName("can_see_members")
    CAN_SEE_MEMBERS("can_see_members"),

    @SerializedName("msg_push_allowed")
    MSG_PUSH_ALLOWED("msg_push_allowed"),

    @SerializedName("chats_status")
    CHATS_STATUS("chats_status"),

    @SerializedName("can_report")
    CAN_REPORT("can_report"),

    @SerializedName("has_suggestions")
    HAS_SUGGESTIONS("has_suggestions"),

    @SerializedName("show_suggestions")
    SHOW_SUGGESTIONS("show_suggestions"),

    @SerializedName("verification_end_time")
    VERIFICATION_END_TIME("verification_end_time"),

    @SerializedName("can_manage")
    CAN_MANAGE("can_manage"),

    @SerializedName("can_view_stats")
    CAN_VIEW_STATS("can_view_stats"),

    @SerializedName("can_view_post_reach_stats")
    CAN_VIEW_POST_REACH_STATS("can_view_post_reach_stats"),

    @SerializedName("stories_archive_count")
    STORIES_ARCHIVE_COUNT("stories_archive_count"),

    @SerializedName("video_live_level")
    VIDEO_LIVE_LEVEL("video_live_level"),

    @SerializedName("video_live_count")
    VIDEO_LIVE_COUNT("video_live_count"),

    @SerializedName("clips_count")
    CLIPS_COUNT("clips_count"),

    @SerializedName("microlanding")
    MICROLANDING("microlanding"),

    @SerializedName("tariffs")
    TARIFFS("tariffs"),

    @SerializedName("has_unseen_stories")
    HAS_UNSEEN_STORIES("has_unseen_stories"),

    @SerializedName("like")
    LIKE("like"),

    @SerializedName("youla_status")
    YOULA_STATUS("youla_status"),

    @SerializedName("youla_use_wallpost_redirect")
    YOULA_USE_WALLPOST_REDIRECT("youla_use_wallpost_redirect"),

    @SerializedName("youla_use_wallpost_redirect_onboarding")
    YOULA_USE_WALLPOST_REDIRECT_ONBOARDING("youla_use_wallpost_redirect_onboarding"),

    @SerializedName("youla_wallpost_redirect_miniapp_url")
    YOULA_WALLPOST_REDIRECT_MINIAPP_URL("youla_wallpost_redirect_miniapp_url"),

    @SerializedName("classifieds_antibaraholka_design_version")
    CLASSIFIEDS_ANTIBARAHOLKA_DESIGN_VERSION("classifieds_antibaraholka_design_version"),

    @SerializedName("is_youla_posting_to_wall_allowed")
    IS_YOULA_POSTING_TO_WALL_ALLOWED("is_youla_posting_to_wall_allowed"),

    @SerializedName("worki_use_wallpost_redirect")
    WORKI_USE_WALLPOST_REDIRECT("worki_use_wallpost_redirect"),

    @SerializedName("is_business")
    IS_BUSINESS("is_business"),

    @SerializedName("textlive")
    TEXTLIVE("textlive"),

    @SerializedName("textlives_count")
    TEXTLIVES_COUNT("textlives_count"),

    @SerializedName("friends")
    FRIENDS("friends"),

    @SerializedName("is_widget_messages_enabled")
    IS_WIDGET_MESSAGES_ENABLED("is_widget_messages_enabled"),

    @SerializedName("deactivated_message")
    DEACTIVATED_MESSAGE("deactivated_message"),

    @SerializedName("worki_action_menu_item")
    WORKI_ACTION_MENU_ITEM("worki_action_menu_item"),

    @SerializedName("youla_posting_method")
    YOULA_POSTING_METHOD("youla_posting_method"),

    @SerializedName("members_count_text")
    MEMBERS_COUNT_TEXT("members_count_text");
}
