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
package com.vk.sdk.api.ads.dto

import com.google.gson.annotations.SerializedName
import kotlin.String

/**
 * @param type - Stat pixel type
 * @param url - Stat pixel url
 */
data class AdsItemBlockAdStatPixelDto(
    @SerializedName("type")
    val type: AdsItemBlockAdStatPixelDto.TypeDto? = null,
    @SerializedName("url")
    val url: String? = null
) {
    enum class TypeDto(
        val value: String
    ) {
        @SerializedName("load")
        LOAD("load"),

        @SerializedName("impression")
        IMPRESSION("impression"),

        @SerializedName("click")
        CLICK("click"),

        @SerializedName("hide")
        HIDE("hide"),

        @SerializedName("click_deeplink")
        CLICK_DEEPLINK("click_deeplink"),

        @SerializedName("click_post_owner")
        CLICK_POST_OWNER("click_post_owner"),

        @SerializedName("like_post")
        LIKE_POST("like_post"),

        @SerializedName("click_post_link")
        CLICK_POST_LINK("click_post_link"),

        @SerializedName("share_post")
        SHARE_POST("share_post"),

        @SerializedName("video_start")
        VIDEO_START("video_start"),

        @SerializedName("video_pause")
        VIDEO_PAUSE("video_pause"),

        @SerializedName("video_resume")
        VIDEO_RESUME("video_resume"),

        @SerializedName("video_play")
        VIDEO_PLAY("video_play"),

        @SerializedName("video_play_3s")
        VIDEO_PLAY_3S("video_play_3s"),

        @SerializedName("video_play_10s")
        VIDEO_PLAY_10S("video_play_10s"),

        @SerializedName("video_play_25")
        VIDEO_PLAY_25("video_play_25"),

        @SerializedName("video_play_50")
        VIDEO_PLAY_50("video_play_50"),

        @SerializedName("video_play_75")
        VIDEO_PLAY_75("video_play_75"),

        @SerializedName("video_play_95")
        VIDEO_PLAY_95("video_play_95"),

        @SerializedName("video_play_100")
        VIDEO_PLAY_100("video_play_100"),

        @SerializedName("video_volume_on")
        VIDEO_VOLUME_ON("video_volume_on"),

        @SerializedName("video_volume_off")
        VIDEO_VOLUME_OFF("video_volume_off"),

        @SerializedName("video_fullscreen_on")
        VIDEO_FULLSCREEN_ON("video_fullscreen_on"),

        @SerializedName("video_fullscreen_off")
        VIDEO_FULLSCREEN_OFF("video_fullscreen_off"),

        @SerializedName("impression_pretty_card")
        IMPRESSION_PRETTY_CARD("impression_pretty_card"),

        @SerializedName("audio_click")
        AUDIO_CLICK("audio_click"),

        @SerializedName("click_pretty_card")
        CLICK_PRETTY_CARD("click_pretty_card"),

        @SerializedName("show_off")
        SHOW_OFF("show_off");
    }
}
