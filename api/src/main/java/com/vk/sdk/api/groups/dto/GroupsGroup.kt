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
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.video.dto.VideoLiveInfo
import kotlin.Int
import kotlin.String

/**
 * @param id - Community ID
 * @param name - Community name
 * @param screenName - Domain of the community page
 * @param isClosed
 * @param type
 * @param isAdmin - Information whether current user is administrator
 * @param adminLevel
 * @param isMember - Information whether current user is member
 * @param isAdvertiser - Information whether current user is advertiser
 * @param startDate - Start date in Unixtime format
 * @param finishDate - Finish date in Unixtime format
 * @param deactivated - Information whether community is banned
 * @param photo50 - URL of square photo of the community with 50 pixels in width
 * @param photo100 - URL of square photo of the community with 100 pixels in width
 * @param photo200 - URL of square photo of the community with 200 pixels in width
 * @param photo200Orig - URL of square photo of the community with 200 pixels in width original
 * @param photo400 - URL of square photo of the community with 400 pixels in width
 * @param photo400Orig - URL of square photo of the community with 400 pixels in width original
 * @param photoMax - URL of square photo of the community with max pixels in width
 * @param photoMaxOrig - URL of square photo of the community with max pixels in width original
 * @param estDate - Established date
 * @param publicDateLabel - Public date label
 * @param photoMaxSize
 * @param isVideoLiveNotificationsBlocked
 * @param videoLive
 */
data class GroupsGroup(
    @SerializedName("id")
    val id: UserId,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("screen_name")
    val screenName: String? = null,
    @SerializedName("is_closed")
    val isClosed: GroupsGroupIsClosed? = null,
    @SerializedName("type")
    val type: GroupsGroupType? = null,
    @SerializedName("is_admin")
    val isAdmin: BaseBoolInt? = null,
    @SerializedName("admin_level")
    val adminLevel: GroupsGroupAdminLevel? = null,
    @SerializedName("is_member")
    val isMember: BaseBoolInt? = null,
    @SerializedName("is_advertiser")
    val isAdvertiser: BaseBoolInt? = null,
    @SerializedName("start_date")
    val startDate: Int? = null,
    @SerializedName("finish_date")
    val finishDate: Int? = null,
    @SerializedName("deactivated")
    val deactivated: String? = null,
    @SerializedName("photo_50")
    val photo50: String? = null,
    @SerializedName("photo_100")
    val photo100: String? = null,
    @SerializedName("photo_200")
    val photo200: String? = null,
    @SerializedName("photo_200_orig")
    val photo200Orig: String? = null,
    @SerializedName("photo_400")
    val photo400: String? = null,
    @SerializedName("photo_400_orig")
    val photo400Orig: String? = null,
    @SerializedName("photo_max")
    val photoMax: String? = null,
    @SerializedName("photo_max_orig")
    val photoMaxOrig: String? = null,
    @SerializedName("est_date")
    val estDate: String? = null,
    @SerializedName("public_date_label")
    val publicDateLabel: String? = null,
    @SerializedName("photo_max_size")
    val photoMaxSize: GroupsPhotoSize? = null,
    @SerializedName("is_video_live_notifications_blocked")
    val isVideoLiveNotificationsBlocked: BaseBoolInt? = null,
    @SerializedName("video_live")
    val videoLive: VideoLiveInfo? = null
)
