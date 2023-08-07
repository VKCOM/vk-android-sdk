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
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseLikesInfoDto
import com.vk.sdk.api.base.dto.BaseRepostsInfoDto
import com.vk.sdk.api.users.dto.UsersUserFullDto
import com.vk.sdk.api.wall.dto.WallCommentAttachmentDto
import com.vk.sdk.api.wall.dto.WallPostSourceDto
import kotlin.Float
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
 * @param ownerId - Wall owner's ID
 * @param canDelete - Information whether current user can delete the comment
 * @param comments
 * @param likes
 * @param media
 * @param postSource
 * @param reposts
 * @param user
 * @param isFavorite - Information whether the post in favorites list
 * @param shortTextRate - Preview length control parameter
 */
data class WidgetsWidgetCommentDto(
    @SerializedName("date")
    val date: Int,
    @SerializedName("from_id")
    val fromId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("post_type")
    val postType: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("to_id")
    val toId: Int,
    @SerializedName("attachments")
    val attachments: List<WallCommentAttachmentDto>? = null,
    @SerializedName("owner_id")
    val ownerId: UserId? = null,
    @SerializedName("can_delete")
    val canDelete: BaseBoolIntDto? = null,
    @SerializedName("comments")
    val comments: WidgetsCommentRepliesDto? = null,
    @SerializedName("likes")
    val likes: BaseLikesInfoDto? = null,
    @SerializedName("media")
    val media: WidgetsCommentMediaDto? = null,
    @SerializedName("post_source")
    val postSource: WallPostSourceDto? = null,
    @SerializedName("reposts")
    val reposts: BaseRepostsInfoDto? = null,
    @SerializedName("user")
    val user: UsersUserFullDto? = null,
    @SerializedName("is_favorite")
    val isFavorite: BaseBoolIntDto? = null,
    @SerializedName("short_text_rate")
    val shortTextRate: Float? = null
)
