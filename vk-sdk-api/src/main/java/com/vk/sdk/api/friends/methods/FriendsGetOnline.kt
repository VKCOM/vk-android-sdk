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
package com.vk.sdk.api.friends.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.friends.responses.FriendsGetOnlineResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of user IDs of a user's friends who are online.
 * @param userId User ID. minimum 0
 * @param listId Friend list ID. If this parameter is not set, information about all online friends
 * is returned. minimum 0
 * @param onlineMobile '1' � to return an additional 'online_mobile' field, '0' � (default), 
 * @param order Sort order: 'random' � random order 
 * @param count Number of friends to return. minimum 0
 * @param offset Offset needed to return a specific subset of friends. minimum 0
 */
class FriendsGetOnline(
    private val userId: Int? = null,
    private val listId: Int? = null,
    private val onlineMobile: Boolean? = null,
    private val order: String? = null,
    private val count: Int? = null,
    private val offset: Int? = null
) : VKRequest<List<Int>>("friends.getOnline") {
    init {
        userId?.let { value ->
            addParam("user_id", value)
        }
        listId?.let { value ->
            addParam("list_id", value)
        }
        onlineMobile?.let { value ->
            addParam("online_mobile", if (value) 1 else 0)
        }
        order?.let { value ->
            addParam("order", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
    }

    override fun parse(r: JSONObject): List<Int> = GsonHolder.gson.fromJson(r.toString(),
            FriendsGetOnlineResponse::class.java).response
}
