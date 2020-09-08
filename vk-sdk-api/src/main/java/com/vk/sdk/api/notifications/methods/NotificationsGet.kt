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
package com.vk.sdk.api.notifications.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.notifications.dto.NotificationsGetFilters
import com.vk.sdk.api.notifications.dto.NotificationsGetResponseDto
import com.vk.sdk.api.notifications.responses.NotificationsGetResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of notifications about other users' feedback to the current user's wall posts.
 * @param count Number of notifications to return. default 30 minimum 1 maximum 100
 * @param startFrom  
 * @param filters Type of notifications to return: 'wall' � wall posts, 'mentions' � mentions in
 * wall posts, comments, or topics, 'comments' � comments to wall posts, photos, and videos, 'likes' �
 * likes, 'reposted' � wall posts that are copied from the current user's wall, 'followers' � new
 * followers, 'friends' � accepted friend requests 
 * @param startTime Earliest timestamp (in Unix time) of a notification to return. By default, 24
 * hours ago. 
 * @param endTime Latest timestamp (in Unix time) of a notification to return. By default, the
 * current time. 
 */
class NotificationsGet(
    private val count: Int? = null,
    private val startFrom: String? = null,
    private val filters: List<NotificationsGetFilters>? = null,
    private val startTime: Int? = null,
    private val endTime: Int? = null
) : VKRequest<NotificationsGetResponseDto>("notifications.get") {
    init {
        count?.let { value ->
            addParam("count", value)
        }
        startFrom?.let { value ->
            addParam("start_from", value)
        }
        filters?.let { value ->
            addParam("filters", value.map { it.value })
        }
        startTime?.let { value ->
            addParam("start_time", value)
        }
        endTime?.let { value ->
            addParam("end_time", value)
        }
    }

    override fun parse(r: JSONObject): NotificationsGetResponseDto =
            GsonHolder.gson.fromJson(r.toString(), NotificationsGetResponse::class.java).response
}
