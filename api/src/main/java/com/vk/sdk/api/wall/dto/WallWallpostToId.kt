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
import com.vk.sdk.api.base.dto.BaseCommentsInfo
import com.vk.sdk.api.base.dto.BaseLikesInfo
import com.vk.sdk.api.base.dto.BaseRepostsInfo
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param attachments
 * @param comments
 * @param copyOwnerId - ID of the source post owner
 * @param copyPostId - ID of the source post
 * @param date - Date of publishing in Unixtime
 * @param fromId - Post author ID
 * @param geo
 * @param id - Post ID
 * @param isFavorite - Information whether the post in favorites list
 * @param likes
 * @param postId - wall post ID (if comment)
 * @param postSource
 * @param postType
 * @param reposts
 * @param signerId - Post signer ID
 * @param text - Post text
 * @param toId - Wall owner's ID
 */
data class WallWallpostToId(
    @SerializedName("attachments")
    val attachments: List<WallWallpostAttachment>? = null,
    @SerializedName("comments")
    val comments: BaseCommentsInfo? = null,
    @SerializedName("copy_owner_id")
    val copyOwnerId: UserId? = null,
    @SerializedName("copy_post_id")
    val copyPostId: Int? = null,
    @SerializedName("date")
    val date: Int? = null,
    @SerializedName("from_id")
    val fromId: UserId? = null,
    @SerializedName("geo")
    val geo: WallGeo? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("is_favorite")
    val isFavorite: Boolean? = null,
    @SerializedName("likes")
    val likes: BaseLikesInfo? = null,
    @SerializedName("post_id")
    val postId: Int? = null,
    @SerializedName("post_source")
    val postSource: WallPostSource? = null,
    @SerializedName("post_type")
    val postType: WallPostType? = null,
    @SerializedName("reposts")
    val reposts: BaseRepostsInfo? = null,
    @SerializedName("signer_id")
    val signerId: UserId? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("to_id")
    val toId: UserId? = null
)
