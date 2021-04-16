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
package com.vk.sdk.api.board.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseLikesInfo
import com.vk.sdk.api.wall.dto.WallCommentAttachment
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param date - Date when the comment has been added in Unixtime
 * @param fromId - Author ID
 * @param id - Comment ID
 * @param text - Comment text
 * @param attachments
 * @param realOffset - Real position of the comment
 * @param canEdit - Information whether current user can edit the comment
 * @param likes
 */
data class BoardTopicComment(
    @SerializedName("date")
    val date: Int,
    @SerializedName("from_id")
    val fromId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("attachments")
    val attachments: List<WallCommentAttachment>? = null,
    @SerializedName("real_offset")
    val realOffset: Int? = null,
    @SerializedName("can_edit")
    val canEdit: BaseBoolInt? = null,
    @SerializedName("likes")
    val likes: BaseLikesInfo? = null
)
