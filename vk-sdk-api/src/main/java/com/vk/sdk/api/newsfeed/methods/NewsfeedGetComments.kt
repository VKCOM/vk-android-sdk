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
package com.vk.sdk.api.newsfeed.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.newsfeed.dto.NewsfeedCommentsFilters
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetCommentsResponseDto
import com.vk.sdk.api.newsfeed.responses.NewsfeedGetCommentsResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of comments in the current user's newsfeed.
 * @param count Number of comments to return. For auto feed, you can use the 'new_offset' parameter
 * returned by this method. default 30 minimum 0 maximum 100
 * @param filters Filters to apply: 'post' � new comments on wall posts, 'photo' � new comments on
 * photos, 'video' � new comments on videos, 'topic' � new comments on discussions, 'note' � new
 * comments on notes, 
 * @param reposts Object ID, comments on repost of which shall be returned, e.g. 'wall1_45486'. (If
 * the parameter is set, the 'filters' parameter is optional.), 
 * @param startTime Earliest timestamp (in Unix time) of a comment to return. By default, 24 hours
 * ago. minimum 0
 * @param endTime Latest timestamp (in Unix time) of a comment to return. By default, the current
 * time. minimum 0
 * @param lastCommentsCount  default 0 minimum 0 maximum 10
 * @param startFrom Identificator needed to return the next page with results. Value for this
 * parameter returns in 'next_from' field. 
 * @param fields Additional fields of [vk.com/dev/fields|profiles] and
 * [vk.com/dev/fields_groups|communities] to return. 
 */
class NewsfeedGetComments(
    private val count: Int? = null,
    private val filters: List<NewsfeedCommentsFilters>? = null,
    private val reposts: String? = null,
    private val startTime: Int? = null,
    private val endTime: Int? = null,
    private val lastCommentsCount: Int? = null,
    private val startFrom: String? = null,
    private val fields: List<BaseUserGroupFields>? = null
) : VKRequest<NewsfeedGetCommentsResponseDto>("newsfeed.getComments") {
    init {
        count?.let { value ->
            addParam("count", value)
        }
        filters?.let { value ->
            addParam("filters", value.map { it.value })
        }
        reposts?.let { value ->
            addParam("reposts", value)
        }
        startTime?.let { value ->
            addParam("start_time", value)
        }
        endTime?.let { value ->
            addParam("end_time", value)
        }
        lastCommentsCount?.let { value ->
            addParam("last_comments_count", value)
        }
        startFrom?.let { value ->
            addParam("start_from", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): NewsfeedGetCommentsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), NewsfeedGetCommentsResponse::class.java).response
}
