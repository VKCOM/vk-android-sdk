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
import com.vk.sdk.api.board.dto.BoardGetTopicsExtendedResponseDto
import com.vk.sdk.api.board.dto.BoardGetTopicsOrder
import com.vk.sdk.api.board.dto.BoardGetTopicsPreview
import com.vk.sdk.api.board.responses.BoardGetTopicsExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of topics on a community's discussion board.
 * @param groupId ID of the community that owns the discussion board. minimum 0
 * @param topicIds IDs of topics to be returned (100 maximum). By default, all topics are returned.
 * If this parameter is set, the 'order', 'offset', and 'count' parameters are ignored. 
 * @param order Sort order: '1' � by date updated in reverse chronological order. '2' � by date
 * created in reverse chronological order. '-1' � by date updated in chronological order. '-2' � by
 * date created in chronological order. If no sort order is specified, topics are returned in the order
 * specified by the group administrator. Pinned topics are returned first, regardless of the sorting. 
 * @param offset Offset needed to return a specific subset of topics. minimum 0
 * @param count Number of topics to return. default 40 minimum 0 maximum 100
 * @param extended '1' � to return information about users who created topics or who posted there
 * last, '0' � to return no additional fields (default) 
 * @param preview '1' � to return the first comment in each topic,, '2' � to return the last comment
 * in each topic,, '0' � to return no comments. By default: '0'. 
 * @param previewLength Number of characters after which to truncate the previewed comment. To
 * preview the full comment, specify '0'. default 90 minimum 0
 */
class BoardGetTopicsExtended(
    private val groupId: Int,
    private val topicIds: List<Int>? = null,
    private val order: BoardGetTopicsOrder? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null,
    private val preview: BoardGetTopicsPreview? = null,
    private val previewLength: Int? = null
) : VKRequest<BoardGetTopicsExtendedResponseDto>("board.getTopics") {
    init {
        addParam("group_id", groupId)
        topicIds?.let { value ->
            addParam("topic_ids", value)
        }
        order?.let { value ->
            addParam("order", value.value)
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
        preview?.let { value ->
            addParam("preview", value.value)
        }
        previewLength?.let { value ->
            addParam("preview_length", value)
        }
    }

    override fun parse(r: JSONObject): BoardGetTopicsExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            BoardGetTopicsExtendedResponse::class.java).response
}
