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
package com.vk.sdk.api.stories.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.apps.dto.AppsAppMin
import com.vk.sdk.api.audio.dto.AudioAudio
import com.vk.sdk.api.base.dto.BaseLink
import com.vk.sdk.api.market.dto.MarketMarketItem
import com.vk.sdk.api.polls.dto.PollsPoll
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param clickableArea
 * @param id - Clickable sticker ID
 * @param type
 * @param hashtag
 * @param linkObject
 * @param mention
 * @param tooltipText
 * @param ownerId
 * @param storyId
 * @param question
 * @param questionButton
 * @param placeId
 * @param marketItem
 * @param audio
 * @param audioStartTime
 * @param style
 * @param subtype
 * @param postOwnerId
 * @param postId
 * @param poll
 * @param color - Color, hex format
 * @param stickerId - Sticker ID
 * @param stickerPackId - Sticker pack ID
 * @param app
 * @param appContext - Additional context for app sticker
 * @param hasNewInteractions - Whether current user has unread interaction with this app
 * @param isBroadcastNotifyAllowed - Whether current user allowed broadcast notify from this app
 * @param situationalThemeId
 * @param situationalAppUrl
 */
data class StoriesClickableSticker(
    @SerializedName("clickable_area")
    val clickableArea: List<StoriesClickableArea>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: StoriesClickableSticker.Type,
    @SerializedName("hashtag")
    val hashtag: String? = null,
    @SerializedName("link_object")
    val linkObject: BaseLink? = null,
    @SerializedName("mention")
    val mention: String? = null,
    @SerializedName("tooltip_text")
    val tooltipText: String? = null,
    @SerializedName("owner_id")
    val ownerId: UserId? = null,
    @SerializedName("story_id")
    val storyId: Int? = null,
    @SerializedName("question")
    val question: String? = null,
    @SerializedName("question_button")
    val questionButton: String? = null,
    @SerializedName("place_id")
    val placeId: Int? = null,
    @SerializedName("market_item")
    val marketItem: MarketMarketItem? = null,
    @SerializedName("audio")
    val audio: AudioAudio? = null,
    @SerializedName("audio_start_time")
    val audioStartTime: Int? = null,
    @SerializedName("style")
    val style: StoriesClickableSticker.Style? = null,
    @SerializedName("subtype")
    val subtype: StoriesClickableSticker.Subtype? = null,
    @SerializedName("post_owner_id")
    val postOwnerId: UserId? = null,
    @SerializedName("post_id")
    val postId: Int? = null,
    @SerializedName("poll")
    val poll: PollsPoll? = null,
    @SerializedName("color")
    val color: String? = null,
    @SerializedName("sticker_id")
    val stickerId: Int? = null,
    @SerializedName("sticker_pack_id")
    val stickerPackId: Int? = null,
    @SerializedName("app")
    val app: AppsAppMin? = null,
    @SerializedName("app_context")
    val appContext: String? = null,
    @SerializedName("has_new_interactions")
    val hasNewInteractions: Boolean? = null,
    @SerializedName("is_broadcast_notify_allowed")
    val isBroadcastNotifyAllowed: Boolean? = null,
    @SerializedName("situational_theme_id")
    val situationalThemeId: Int? = null,
    @SerializedName("situational_app_url")
    val situationalAppUrl: String? = null
) {
    enum class Type(
        val value: String
    ) {
        @SerializedName("hashtag")
        HASHTAG("hashtag"),

        @SerializedName("mention")
        MENTION("mention"),

        @SerializedName("link")
        LINK("link"),

        @SerializedName("question")
        QUESTION("question"),

        @SerializedName("place")
        PLACE("place"),

        @SerializedName("market_item")
        MARKET_ITEM("market_item"),

        @SerializedName("music")
        MUSIC("music"),

        @SerializedName("story_reply")
        STORY_REPLY("story_reply"),

        @SerializedName("owner")
        OWNER("owner"),

        @SerializedName("post")
        POST("post"),

        @SerializedName("poll")
        POLL("poll"),

        @SerializedName("sticker")
        STICKER("sticker"),

        @SerializedName("app")
        APP("app"),

        @SerializedName("situational_theme")
        SITUATIONAL_THEME("situational_theme");
    }

    enum class Style(
        val value: String
    ) {
        @SerializedName("transparent")
        TRANSPARENT("transparent"),

        @SerializedName("blue_gradient")
        BLUE_GRADIENT("blue_gradient"),

        @SerializedName("red_gradient")
        RED_GRADIENT("red_gradient"),

        @SerializedName("underline")
        UNDERLINE("underline"),

        @SerializedName("blue")
        BLUE("blue"),

        @SerializedName("green")
        GREEN("green"),

        @SerializedName("white")
        WHITE("white"),

        @SerializedName("question_reply")
        QUESTION_REPLY("question_reply"),

        @SerializedName("light")
        LIGHT("light"),

        @SerializedName("impressive")
        IMPRESSIVE("impressive");
    }

    enum class Subtype(
        val value: String
    ) {
        @SerializedName("market_item")
        MARKET_ITEM("market_item"),

        @SerializedName("aliexpress_product")
        ALIEXPRESS_PRODUCT("aliexpress_product");
    }
}
