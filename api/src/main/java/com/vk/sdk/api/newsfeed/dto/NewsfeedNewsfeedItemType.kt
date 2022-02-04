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
package com.vk.sdk.api.newsfeed.dto

import com.google.gson.annotations.SerializedName
import kotlin.String

enum class NewsfeedNewsfeedItemType(
    val value: String
) {
    @SerializedName("post")
    POST("post"),

    @SerializedName("photo")
    PHOTO("photo"),

    @SerializedName("photo_tag")
    PHOTO_TAG("photo_tag"),

    @SerializedName("wall_photo")
    WALL_PHOTO("wall_photo"),

    @SerializedName("friend")
    FRIEND("friend"),

    @SerializedName("audio")
    AUDIO("audio"),

    @SerializedName("video")
    VIDEO("video"),

    @SerializedName("topic")
    TOPIC("topic"),

    @SerializedName("digest")
    DIGEST("digest"),

    @SerializedName("stories")
    STORIES("stories"),

    @SerializedName("clips")
    CLIPS("clips"),

    @SerializedName("promo_button")
    PROMO_BUTTON("promo_button"),

    @SerializedName("recommended_groups")
    RECOMMENDED_GROUPS("recommended_groups"),

    @SerializedName("tags_suggestions")
    TAGS_SUGGESTIONS("tags_suggestions"),

    @SerializedName("games_carousel")
    GAMES_CAROUSEL("games_carousel"),

    @SerializedName("feedback_poll")
    FEEDBACK_POLL("feedback_poll"),

    @SerializedName("animated_block")
    ANIMATED_BLOCK("animated_block"),

    @SerializedName("textlive")
    TEXTLIVE("textlive"),

    @SerializedName("videos_promo")
    VIDEOS_PROMO("videos_promo"),

    @SerializedName("recommended_artists")
    RECOMMENDED_ARTISTS("recommended_artists"),

    @SerializedName("recommended_playlists")
    RECOMMENDED_PLAYLISTS("recommended_playlists"),

    @SerializedName("clips_autoplay")
    CLIPS_AUTOPLAY("clips_autoplay"),

    @SerializedName("recommended_game")
    RECOMMENDED_GAME("recommended_game"),

    @SerializedName("clips_challenges")
    CLIPS_CHALLENGES("clips_challenges"),

    @SerializedName("expert_card")
    EXPERT_CARD("expert_card"),

    @SerializedName("videos_for_you")
    VIDEOS_FOR_YOU("videos_for_you"),

    @SerializedName("liked_by_friends_groups")
    LIKED_BY_FRIENDS_GROUPS("liked_by_friends_groups"),

    @SerializedName("recommended_mini_app")
    RECOMMENDED_MINI_APP("recommended_mini_app"),

    @SerializedName("note")
    NOTE("note"),

    @SerializedName("audio_playlist")
    AUDIO_PLAYLIST("audio_playlist"),

    @SerializedName("clip")
    CLIP("clip"),

    @SerializedName("clips_block")
    CLIPS_BLOCK("clips_block"),

    @SerializedName("videos_for_you_block")
    VIDEOS_FOR_YOU_BLOCK("videos_for_you_block"),

    @SerializedName("mini_apps_carousel")
    MINI_APPS_CAROUSEL("mini_apps_carousel"),

    @SerializedName("video_postcard")
    VIDEO_POSTCARD("video_postcard");
}
