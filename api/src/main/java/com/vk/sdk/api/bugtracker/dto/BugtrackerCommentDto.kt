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
package com.vk.sdk.api.bugtracker.dto

import com.google.gson.annotations.SerializedName
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param bugreportId
 * @param commentId
 * @param created
 * @param text
 * @param metaText
 * @param fromId
 * @param authorName
 * @param authorPhoto
 * @param editHash
 * @param removeHash
 * @param isHidden
 * @param attachments
 * @param isUnread
 */
data class BugtrackerCommentDto(
    @SerializedName("bugreport_id")
    val bugreportId: Int,
    @SerializedName("comment_id")
    val commentId: Int,
    @SerializedName("created")
    val created: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("meta_text")
    val metaText: String? = null,
    @SerializedName("from_id")
    val fromId: Int? = null,
    @SerializedName("author_name")
    val authorName: String? = null,
    @SerializedName("author_photo")
    val authorPhoto: String? = null,
    @SerializedName("edit_hash")
    val editHash: String? = null,
    @SerializedName("remove_hash")
    val removeHash: String? = null,
    @SerializedName("is_hidden")
    val isHidden: Boolean? = null,
    @SerializedName("attachments")
    val attachments: List<BugtrackerAttachmentDto>? = null,
    @SerializedName("is_unread")
    val isUnread: Boolean? = null
)
