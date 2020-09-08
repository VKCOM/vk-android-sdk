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
import kotlin.Int

/**
 * @param albums Albums number
 * @param audios Audios number
 * @param followers Followers number
 * @param friends Friends number
 * @param gifts Gifts number
 * @param groups Communities number
 * @param notes Notes number
 * @param onlineFriends Online friends number
 * @param pages Public pages number
 * @param photos Photos number
 * @param subscriptions Subscriptions number
 * @param userPhotos Number of photos with user
 * @param userVideos Number of videos with user
 * @param videos Videos number
 */
data class UsersUserCounters(
    @SerializedName(value="albums")
    val albums: Int? = null,
    @SerializedName(value="audios")
    val audios: Int? = null,
    @SerializedName(value="followers")
    val followers: Int? = null,
    @SerializedName(value="friends")
    val friends: Int? = null,
    @SerializedName(value="gifts")
    val gifts: Int? = null,
    @SerializedName(value="groups")
    val groups: Int? = null,
    @SerializedName(value="notes")
    val notes: Int? = null,
    @SerializedName(value="online_friends")
    val onlineFriends: Int? = null,
    @SerializedName(value="pages")
    val pages: Int? = null,
    @SerializedName(value="photos")
    val photos: Int? = null,
    @SerializedName(value="subscriptions")
    val subscriptions: Int? = null,
    @SerializedName(value="user_photos")
    val userPhotos: Int? = null,
    @SerializedName(value="user_videos")
    val userVideos: Int? = null,
    @SerializedName(value="videos")
    val videos: Int? = null
)
