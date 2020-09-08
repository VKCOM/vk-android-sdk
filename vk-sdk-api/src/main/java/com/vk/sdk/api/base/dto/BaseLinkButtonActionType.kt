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

enum class BaseLinkButtonActionType(
    val value: String
) {
    OPEN_URL("open_url"),

    JOIN_GROUP_AND_OPEN_URL("join_group_and_open_url"),

    OPEN_SECTION("open_section"),

    FOLLOW("follow"),

    UPLOAD_VIDEO("upload_video"),

    CREATE_PLAYLIST("create_playlist"),

    CREATE_ALBUM("create_album"),

    FRIENDS_LISTS("friends_lists"),

    FRIENDS_SORT_MODES("friends_sort_modes"),

    ADD_FRIEND("add_friend"),

    QR_CAMERA("qr_camera"),

    FRIENDS_REQUESTS("friends_requests"),

    OPEN_SCREEN("open_screen"),

    OPEN_SCREEN_LARGE("open_screen_large"),

    FRIENDS_MESSAGE("friends_message"),

    FRIENDS_SEND_GIFT("friends_send_gift"),

    FRIENDS_LABEL("friends_label"),

    PLAY_AUDIOS_FROM_BLOCK("play_audios_from_block"),

    PLAY_SHUFFLED_AUDIOS_FROM_BLOCK("play_shuffled_audios_from_block"),

    UNFOLLOW_ARTIST("unfollow_artist"),

    CREATE_GROUP("create_group"),

    CLOSE_NOTIFICATION("close_notification"),

    SWITCH_SECTION("switch_section"),

    CLEAR_RECENT_GROUPS("clear_recent_groups"),

    CLOSE_CATALOG_BANNER("close_catalog_banner");

    class Serializer : JsonDeserializer<BaseLinkButtonActionType> {
        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): BaseLinkButtonActionType = values().first { it.value.toString() ==
                json!!.asJsonPrimitive.toString() }
    }
}
