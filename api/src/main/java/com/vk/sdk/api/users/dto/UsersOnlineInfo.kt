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

import com.google.gson.annotations.SerializedName
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * @param visible - Whether you can see real online status of user or not
 * @param lastSeen - Last time we saw user being active
 * @param isOnline - Whether user is currently online or not
 * @param appId - Application id from which user is currently online or was last seen online
 * @param isMobile - Is user online from desktop app or mobile app
 * @param status - In case user online is not visible, it indicates approximate timeframe of user
 * online
 */
data class UsersOnlineInfo(
    @SerializedName("visible")
    val visible: Boolean,
    @SerializedName("last_seen")
    val lastSeen: Int? = null,
    @SerializedName("is_online")
    val isOnline: Boolean? = null,
    @SerializedName("app_id")
    val appId: Int? = null,
    @SerializedName("is_mobile")
    val isMobile: Boolean? = null,
    @SerializedName("status")
    val status: UsersOnlineInfo.Status? = null
) {
    enum class Status(
        val value: String
    ) {
        @SerializedName("recently")
        RECENTLY("recently"),

        @SerializedName("last_week")
        LAST_WEEK("last_week"),

        @SerializedName("last_month")
        LAST_MONTH("last_month"),

        @SerializedName("long_ago")
        LONG_AGO("long_ago"),

        @SerializedName("not_show")
        NOT_SHOW("not_show");
    }
}
