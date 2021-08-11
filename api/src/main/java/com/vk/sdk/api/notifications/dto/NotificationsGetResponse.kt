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
package com.vk.sdk.api.notifications.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.apps.dto.AppsApp
import com.vk.sdk.api.groups.dto.GroupsGroup
import com.vk.sdk.api.photos.dto.PhotosPhoto
import com.vk.sdk.api.users.dto.UsersUser
import com.vk.sdk.api.video.dto.VideoVideo
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param count - Total number
 * @param items
 * @param profiles
 * @param groups
 * @param lastViewed - Time when user has been checked notifications last time
 * @param photos
 * @param videos
 * @param apps
 * @param nextFrom
 * @param ttl
 */
data class NotificationsGetResponse(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("items")
    val items: List<NotificationsNotificationItem>? = null,
    @SerializedName("profiles")
    val profiles: List<UsersUser>? = null,
    @SerializedName("groups")
    val groups: List<GroupsGroup>? = null,
    @SerializedName("last_viewed")
    val lastViewed: Int? = null,
    @SerializedName("photos")
    val photos: List<PhotosPhoto>? = null,
    @SerializedName("videos")
    val videos: List<VideoVideo>? = null,
    @SerializedName("apps")
    val apps: List<AppsApp>? = null,
    @SerializedName("next_from")
    val nextFrom: String? = null,
    @SerializedName("ttl")
    val ttl: Int? = null
)
