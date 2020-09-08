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
package com.vk.sdk.api.wall.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.wall.dto.WallGetCommentsResponseDto
import com.vk.sdk.api.wall.dto.WallGetCommentsSort
import com.vk.sdk.api.wall.responses.WallGetCommentsResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of comments on a post on a user wall or community wall.
 * @param ownerId User ID or community ID. Use a negative value to designate a community ID. 
 * @param postId Post ID. minimum 0
 * @param needLikes '1' � to return the 'likes' field, '0' � not to return the 'likes' field
 * (default) 
 * @param startCommentId  minimum 0
 * @param offset Offset needed to return a specific subset of comments. 
 * @param count Number of comments to return (maximum 100). minimum 0
 * @param sort Sort order: 'asc' � chronological, 'desc' � reverse chronological 
 * @param previewLength Number of characters at which to truncate comments when previewed. By
 * default, '90'. Specify '0' if you do not want to truncate comments. minimum 0
 * @param extended  
 * @param fields  
 * @param commentId Comment ID. minimum 0
 * @param threadItemsCount Count items in threads. default 0 minimum 0 maximum 10
 */
class WallGetComments(
    private val ownerId: Int? = null,
    private val postId: Int? = null,
    private val needLikes: Boolean? = null,
    private val startCommentId: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val sort: WallGetCommentsSort? = null,
    private val previewLength: Int? = null,
    private val extended: Boolean? = null,
    private val fields: List<BaseUserGroupFields>? = null,
    private val commentId: Int? = null,
    private val threadItemsCount: Int? = null
) : VKRequest<WallGetCommentsResponseDto>("wall.getComments") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        postId?.let { value ->
            addParam("post_id", value)
        }
        needLikes?.let { value ->
            addParam("need_likes", if (value) 1 else 0)
        }
        startCommentId?.let { value ->
            addParam("start_comment_id", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        sort?.let { value ->
            addParam("sort", value.value)
        }
        previewLength?.let { value ->
            addParam("preview_length", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        commentId?.let { value ->
            addParam("comment_id", value)
        }
        threadItemsCount?.let { value ->
            addParam("thread_items_count", value)
        }
    }

    override fun parse(r: JSONObject): WallGetCommentsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), WallGetCommentsResponse::class.java).response
}
