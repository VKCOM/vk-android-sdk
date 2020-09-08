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
package com.vk.sdk.api.board.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.board.dto.BoardGetCommentsResponseDto
import com.vk.sdk.api.board.dto.BoardGetCommentsSort
import com.vk.sdk.api.board.responses.BoardGetCommentsResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * Returns a list of comments on a topic on a community's discussion board.
 * @param groupId ID of the community that owns the discussion board. minimum 0
 * @param topicId Topic ID. minimum 0
 * @param needLikes '1' � to return the 'likes' field, '0' � not to return the 'likes' field
 * (default) 
 * @param startCommentId  minimum 0
 * @param offset Offset needed to return a specific subset of comments. 
 * @param count Number of comments to return. default 20 minimum 0 maximum 100
 * @param extended '1' � to return information about users who posted comments, '0' � to return no
 * additional fields (default) 
 * @param sort Sort order: 'asc' � by creation date in chronological order, 'desc' � by creation
 * date in reverse chronological order, 
 */
class BoardGetComments(
    private val groupId: Int,
    private val topicId: Int,
    private val needLikes: Boolean? = null,
    private val startCommentId: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null,
    private val sort: BoardGetCommentsSort? = null
) : VKRequest<BoardGetCommentsResponseDto>("board.getComments") {
    init {
        addParam("group_id", groupId)
        addParam("topic_id", topicId)
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
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        sort?.let { value ->
            addParam("sort", value.value)
        }
    }

    override fun parse(r: JSONObject): BoardGetCommentsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), BoardGetCommentsResponse::class.java).response
}
