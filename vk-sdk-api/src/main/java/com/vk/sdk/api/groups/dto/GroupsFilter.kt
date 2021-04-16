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

enum class GroupsFilter(
    val value: String
) {
    @SerializedName("admin")
    ADMIN("admin"),

    @SerializedName("editor")
    EDITOR("editor"),

    @SerializedName("moder")
    MODER("moder"),

    @SerializedName("advertiser")
    ADVERTISER("advertiser"),

    @SerializedName("enabled_notifications")
    ENABLED_NOTIFICATIONS("enabled_notifications"),

    @SerializedName("can_enable_notifications")
    CAN_ENABLE_NOTIFICATIONS("can_enable_notifications"),

    @SerializedName("stories_not_pinned")
    STORIES_NOT_PINNED("stories_not_pinned"),

    @SerializedName("groups")
    GROUPS("groups"),

    @SerializedName("publics")
    PUBLICS("publics"),

    @SerializedName("events")
    EVENTS("events"),

    @SerializedName("has_addresses")
    HAS_ADDRESSES("has_addresses"),

    @SerializedName("can_post_clips")
    CAN_POST_CLIPS("can_post_clips");
}
