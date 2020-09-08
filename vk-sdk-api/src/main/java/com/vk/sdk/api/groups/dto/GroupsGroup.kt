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
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Int
import kotlin.String

/**
 * @param adminLevel no description
 * @param deactivated Information whether community is banned
 * @param finishDate Finish date in Unixtime format
 * @param id Community ID
 * @param isAdmin Information whether current user is administrator
 * @param isAdvertiser Information whether current user is advertiser
 * @param isClosed no description
 * @param isMember Information whether current user is member
 * @param name Community name
 * @param photo100 URL of square photo of the community with 100 pixels in width
 * @param photo200 URL of square photo of the community with 200 pixels in width
 * @param photo50 URL of square photo of the community with 50 pixels in width
 * @param screenName Domain of the community page
 * @param startDate Start date in Unixtime format
 * @param type no description
 */
data class GroupsGroup(
    @SerializedName(value="admin_level")
    val adminLevel: GroupsGroupAdminLevel? = null,
    @SerializedName(value="deactivated")
    val deactivated: String? = null,
    @SerializedName(value="finish_date")
    val finishDate: Int? = null,
    @SerializedName(value="id")
    val id: Int? = null,
    @SerializedName(value="is_admin")
    val isAdmin: BaseBoolInt? = null,
    @SerializedName(value="is_advertiser")
    val isAdvertiser: BaseBoolInt? = null,
    @SerializedName(value="is_closed")
    val isClosed: GroupsGroupIsClosed? = null,
    @SerializedName(value="is_member")
    val isMember: BaseBoolInt? = null,
    @SerializedName(value="name")
    val name: String? = null,
    @SerializedName(value="photo_100")
    val photo100: String? = null,
    @SerializedName(value="photo_200")
    val photo200: String? = null,
    @SerializedName(value="photo_50")
    val photo50: String? = null,
    @SerializedName(value="screen_name")
    val screenName: String? = null,
    @SerializedName(value="start_date")
    val startDate: Int? = null,
    @SerializedName(value="type")
    val type: GroupsGroupType? = null
)
