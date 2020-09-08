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
import com.vk.sdk.api.newsfeed.dto.NewsfeedSearchExtendedResponseDto
import com.vk.sdk.api.newsfeed.responses.NewsfeedSearchExtendedResponse
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns search results by statuses.
 * @param q Search query string (e.g., 'New Year'). 
 * @param extended '1' � to return additional information about the user or community that placed
 * the post. 
 * @param count Number of posts to return. default 30 minimum 0 maximum 200
 * @param latitude Geographical latitude point (in degrees, -90 to 90) within which to search. 
 * @param longitude Geographical longitude point (in degrees, -180 to 180) within which to search. 
 * @param startTime Earliest timestamp (in Unix time) of a news item to return. By default, 24 hours
 * ago. minimum 0
 * @param endTime Latest timestamp (in Unix time) of a news item to return. By default, the current
 * time. minimum 0
 * @param startFrom  
 * @param fields Additional fields of [vk.com/dev/fields|profiles] and
 * [vk.com/dev/fields_groups|communities] to return. 
 */
class NewsfeedSearchExtended(
    private val q: String? = null,
    private val extended: Boolean? = null,
    private val count: Int? = null,
    private val latitude: Float? = null,
    private val longitude: Float? = null,
    private val startTime: Int? = null,
    private val endTime: Int? = null,
    private val startFrom: String? = null,
    private val fields: List<BaseUserGroupFields>? = null
) : VKRequest<NewsfeedSearchExtendedResponseDto>("newsfeed.search") {
    init {
        q?.let { value ->
            addParam("q", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        count?.let { value ->
            addParam("count", value)
        }
        latitude?.let { value ->
            addParam("latitude", value.toString())
        }
        longitude?.let { value ->
            addParam("longitude", value.toString())
        }
        startTime?.let { value ->
            addParam("start_time", value)
        }
        endTime?.let { value ->
            addParam("end_time", value)
        }
        startFrom?.let { value ->
            addParam("start_from", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): NewsfeedSearchExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            NewsfeedSearchExtendedResponse::class.java).response
}
