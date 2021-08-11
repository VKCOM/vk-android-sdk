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
package com.vk.sdk.api.widgets.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseLikesInfo
import com.vk.sdk.api.base.dto.BaseRepostsInfo
import com.vk.sdk.api.users.dto.UsersUserFull
import com.vk.sdk.api.wall.dto.WallCommentAttachment
import com.vk.sdk.api.wall.dto.WallPostSource
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param date - Date when the comment has been added in Unixtime
 * @param fromId - Comment author ID
 * @param id - Comment ID
 * @param postType - Post type
 * @param text - Comment text
 * @param toId - Wall owner
 * @param attachments
 * @param canDelete - Information whether current user can delete the comment
 * @param comments
 * @param likes
 * @param media
 * @param postSource
 * @param reposts
 * @param user
 */
data class WidgetsWidgetComment(
    @SerializedName("date")
    val date: Int,
    @SerializedName("from_id")
    val fromId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("post_type")
    val postType: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("to_id")
    val toId: Int,
    @SerializedName("attachments")
    val attachments: List<WallCommentAttachment>? = null,
    @SerializedName("can_delete")
    val canDelete: BaseBoolInt? = null,
    @SerializedName("comments")
    val comments: WidgetsCommentReplies? = null,
    @SerializedName("likes")
    val likes: BaseLikesInfo? = null,
    @SerializedName("media")
    val media: WidgetsCommentMedia? = null,
    @SerializedName("post_source")
    val postSource: WallPostSource? = null,
    @SerializedName("reposts")
    val reposts: BaseRepostsInfo? = null,
    @SerializedName("user")
    val user: UsersUserFull? = null
)
