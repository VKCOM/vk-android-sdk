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
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetMentionsResponseDto
import com.vk.sdk.api.newsfeed.responses.NewsfeedGetMentionsResponse
import kotlin.Int
import org.json.JSONObject

/**
 * Returns a list of posts on user walls in which the current user is mentioned.
 * @param ownerId Owner ID. 
 * @param startTime Earliest timestamp (in Unix time) of a post to return. By default, 24 hours ago.
 * minimum 0
 * @param endTime Latest timestamp (in Unix time) of a post to return. By default, the current time.
 * minimum 0
 * @param offset Offset needed to return a specific subset of posts. minimum 0
 * @param count Number of posts to return. default 20 minimum 0 maximum 50
 */
class NewsfeedGetMentions(
    private val ownerId: Int? = null,
    private val startTime: Int? = null,
    private val endTime: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null
) : VKRequest<NewsfeedGetMentionsResponseDto>("newsfeed.getMentions") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        startTime?.let { value ->
            addParam("start_time", value)
        }
        endTime?.let { value ->
            addParam("end_time", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
    }

    override fun parse(r: JSONObject): NewsfeedGetMentionsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), NewsfeedGetMentionsResponse::class.java).response
}
