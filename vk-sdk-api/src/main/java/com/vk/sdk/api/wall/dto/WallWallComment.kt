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
import com.vk.sdk.api.base.dto.BaseLikesInfo
import com.vk.sdk.api.comment.dto.CommentThread
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param date Date when the comment has been added in Unixtime
 * @param fromId Author ID
 * @param id Comment ID
 * @param text Comment text
 * @param attachments no description
 * @param likes no description
 * @param realOffset Real position of the comment
 * @param replyToComment Replied comment ID
 * @param replyToUser Replied user ID
 * @param thread no description
 * @param postId no description
 * @param ownerId no description
 * @param parentsStack no description
 * @param deleted no description
 */
data class WallWallComment(
    @SerializedName(value="date")
    val date: Int,
    @SerializedName(value="from_id")
    val fromId: Int,
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="text")
    val text: String,
    @SerializedName(value="attachments")
    val attachments: List<WallCommentAttachment>? = null,
    @SerializedName(value="likes")
    val likes: BaseLikesInfo? = null,
    @SerializedName(value="real_offset")
    val realOffset: Int? = null,
    @SerializedName(value="reply_to_comment")
    val replyToComment: Int? = null,
    @SerializedName(value="reply_to_user")
    val replyToUser: Int? = null,
    @SerializedName(value="thread")
    val thread: CommentThread? = null,
    @SerializedName(value="post_id")
    val postId: Int? = null,
    @SerializedName(value="owner_id")
    val ownerId: Int? = null,
    @SerializedName(value="parents_stack")
    val parentsStack: List<Int>? = null,
    @SerializedName(value="deleted")
    val deleted: Boolean? = null
)
