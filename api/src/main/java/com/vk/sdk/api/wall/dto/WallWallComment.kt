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
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseLikesInfo
import com.vk.sdk.api.comment.dto.CommentThread
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id - Comment ID
 * @param fromId - Author ID
 * @param date - Date when the comment has been added in Unixtime
 * @param text - Comment text
 * @param canEdit
 * @param postId
 * @param ownerId
 * @param parentsStack
 * @param photoId
 * @param videoId
 * @param attachments
 * @param donut
 * @param likes
 * @param realOffset - Real position of the comment
 * @param replyToUser - Replied user ID
 * @param replyToComment - Replied comment ID
 * @param thread
 * @param deleted
 * @param pid - Photo ID
 */
data class WallWallComment(
    @SerializedName("id")
    val id: Int,
    @SerializedName("from_id")
    val fromId: UserId,
    @SerializedName("date")
    val date: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("can_edit")
    val canEdit: BaseBoolInt? = null,
    @SerializedName("post_id")
    val postId: Int? = null,
    @SerializedName("owner_id")
    val ownerId: UserId? = null,
    @SerializedName("parents_stack")
    val parentsStack: List<Int>? = null,
    @SerializedName("photo_id")
    val photoId: Int? = null,
    @SerializedName("video_id")
    val videoId: Int? = null,
    @SerializedName("attachments")
    val attachments: List<WallCommentAttachment>? = null,
    @SerializedName("donut")
    val donut: WallWallCommentDonut? = null,
    @SerializedName("likes")
    val likes: BaseLikesInfo? = null,
    @SerializedName("real_offset")
    val realOffset: Int? = null,
    @SerializedName("reply_to_user")
    val replyToUser: UserId? = null,
    @SerializedName("reply_to_comment")
    val replyToComment: Int? = null,
    @SerializedName("thread")
    val thread: CommentThread? = null,
    @SerializedName("deleted")
    val deleted: Boolean? = null,
    @SerializedName("pid")
    val pid: Int? = null
)
