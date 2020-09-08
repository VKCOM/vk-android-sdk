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

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
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
 * @param clickableArea no description
 * @param id Clickable sticker ID
 * @param type no description
 * @param hashtag no description
 * @param linkObject no description
 * @param mention no description
 * @param tooltipText no description
 * @param ownerId no description
 * @param storyId no description
 * @param question no description
 * @param questionButton no description
 * @param placeId no description
 * @param marketItem no description
 * @param audio no description
 * @param audioStartTime no description
 * @param style no description
 * @param subtype no description
 * @param postOwnerId no description
 * @param postId no description
 * @param poll no description
 * @param color Color, hex format
 * @param stickerId Sticker ID
 * @param stickerPackId Sticker pack ID
 * @param app no description
 * @param appContext Additional context for app sticker
 * @param hasNewInteractions Whether current user has unread interaction with this app
 * @param isBroadcastNotifyAllowed Whether current user allowed broadcast notify from this app
 */
data class StoriesClickableSticker(
    @SerializedName(value="clickable_area")
    val clickableArea: List<StoriesClickableArea>,
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="type")
    val type: Type,
    @SerializedName(value="hashtag")
    val hashtag: String? = null,
    @SerializedName(value="link_object")
    val linkObject: BaseLink? = null,
    @SerializedName(value="mention")
    val mention: String? = null,
    @SerializedName(value="tooltip_text")
    val tooltipText: String? = null,
    @SerializedName(value="owner_id")
    val ownerId: Int? = null,
    @SerializedName(value="story_id")
    val storyId: Int? = null,
    @SerializedName(value="question")
    val question: String? = null,
    @SerializedName(value="question_button")
    val questionButton: String? = null,
    @SerializedName(value="place_id")
    val placeId: Int? = null,
    @SerializedName(value="market_item")
    val marketItem: MarketMarketItem? = null,
    @SerializedName(value="audio")
    val audio: AudioAudio? = null,
    @SerializedName(value="audio_start_time")
    val audioStartTime: Int? = null,
    @SerializedName(value="style")
    val style: Style? = null,
    @SerializedName(value="subtype")
    val subtype: Subtype? = null,
    @SerializedName(value="post_owner_id")
    val postOwnerId: Int? = null,
    @SerializedName(value="post_id")
    val postId: Int? = null,
    @SerializedName(value="poll")
    val poll: PollsPoll? = null,
    @SerializedName(value="color")
    val color: String? = null,
    @SerializedName(value="sticker_id")
    val stickerId: Int? = null,
    @SerializedName(value="sticker_pack_id")
    val stickerPackId: Int? = null,
    @SerializedName(value="app")
    val app: AppsAppMin? = null,
    @SerializedName(value="app_context")
    val appContext: String? = null,
    @SerializedName(value="has_new_interactions")
    val hasNewInteractions: Boolean? = null,
    @SerializedName(value="is_broadcast_notify_allowed")
    val isBroadcastNotifyAllowed: Boolean? = null
) {
    enum class Subtype(
        val value: String
    ) {
        MARKET_ITEM("market_item"),

        ALIEXPRESS_PRODUCT("aliexpress_product");

        class Serializer : JsonDeserializer<Subtype> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: java.lang.reflect.Type?,
                context: JsonDeserializationContext?
            ): Subtype = values().first { it.value.toString() == json!!.asJsonPrimitive.toString() }
        }
    }

    enum class Style(
        val value: String
    ) {
        TRANSPARENT("transparent"),

        BLUE_GRADIENT("blue_gradient"),

        RED_GRADIENT("red_gradient"),

        UNDERLINE("underline"),

        BLUE("blue"),

        GREEN("green"),

        WHITE("white"),

        QUESTION_REPLY("question_reply"),

        LIGHT("light"),

        IMPRESSIVE("impressive");

        class Serializer : JsonDeserializer<Style> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: java.lang.reflect.Type?,
                context: JsonDeserializationContext?
            ): Style = values().first { it.value.toString() == json!!.asJsonPrimitive.toString() }
        }
    }

    enum class Type(
        val value: String
    ) {
        HASHTAG("hashtag"),

        MENTION("mention"),

        LINK("link"),

        QUESTION("question"),

        PLACE("place"),

        MARKET_ITEM("market_item"),

        MUSIC("music"),

        STORY_REPLY("story_reply"),

        OWNER("owner"),

        POST("post"),

        POLL("poll"),

        STICKER("sticker"),

        APP("app");

        class Serializer : JsonDeserializer<Type> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: java.lang.reflect.Type?,
                context: JsonDeserializationContext?
            ): Type = values().first { it.value.toString() == json!!.asJsonPrimitive.toString() }
        }
    }
}
