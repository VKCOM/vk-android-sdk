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
package com.vk.sdk.api.wall.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.groups.dto.GroupsGroup
import com.vk.sdk.api.users.dto.UsersUser
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List

/**
 * @param count - Total number
 * @param items
 * @param profiles
 * @param groups
 * @param currentLevelCount - Count of replies of current level
 * @param canPost - Information whether current user can comment the post
 * @param showReplyButton
 * @param groupsCanPost - Information whether groups can comment the post
 */
data class WallGetCommentsExtendedResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("items")
    val items: List<WallWallComment>,
    @SerializedName("profiles")
    val profiles: List<UsersUser>,
    @SerializedName("groups")
    val groups: List<GroupsGroup>,
    @SerializedName("current_level_count")
    val currentLevelCount: Int? = null,
    @SerializedName("can_post")
    val canPost: Boolean? = null,
    @SerializedName("show_reply_button")
    val showReplyButton: Boolean? = null,
    @SerializedName("groups_can_post")
    val groupsCanPost: Boolean? = null
)
