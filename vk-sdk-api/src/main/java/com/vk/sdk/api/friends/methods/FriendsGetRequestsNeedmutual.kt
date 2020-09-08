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
import com.vk.sdk.api.friends.dto.FriendsGetRequestsNeedMutualResponseDto
import com.vk.sdk.api.friends.dto.FriendsGetRequestsSort
import com.vk.sdk.api.friends.responses.FriendsGetRequestsNeedMutualResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns information about the current user's incoming and outgoing friend requests.
 * @param offset Offset needed to return a specific subset of friend requests. minimum 0
 * @param count Number of friend requests to return (default 100, maximum 1000). default 100 minimum
 * 0 maximum 1000
 * @param extended '1' � to return response messages from users who have sent a friend request or,
 * if 'suggested' is set to '1', to return a list of suggested friends 
 * @param needMutual '1' � to return a list of mutual friends (up to 20), if any 
 * @param out '1' � to return outgoing requests, '0' � to return incoming requests (default) 
 * @param sort Sort order: '1' � by number of mutual friends, '0' � by date minimum 0
 * @param needViewed  default 0
 * @param suggested '1' � to return a list of suggested friends, '0' � to return friend requests
 * (default) 
 * @param ref  maxLength 255
 * @param fields  
 */
class FriendsGetRequestsNeedmutual(
    private val offset: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null,
    private val needMutual: Boolean? = null,
    private val out: Boolean? = null,
    private val sort: FriendsGetRequestsSort? = null,
    private val needViewed: Boolean? = null,
    private val suggested: Boolean? = null,
    private val ref: String? = null,
    private val fields: List<UsersFields>? = null
) : VKRequest<FriendsGetRequestsNeedMutualResponseDto>("friends.getRequests") {
    init {
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        needMutual?.let { value ->
            addParam("need_mutual", if (value) 1 else 0)
        }
        out?.let { value ->
            addParam("out", if (value) 1 else 0)
        }
        sort?.let { value ->
            addParam("sort", value.value)
        }
        needViewed?.let { value ->
            addParam("need_viewed", if (value) 1 else 0)
        }
        suggested?.let { value ->
            addParam("suggested", if (value) 1 else 0)
        }
        ref?.let { value ->
            addParam("ref", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): FriendsGetRequestsNeedMutualResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            FriendsGetRequestsNeedMutualResponse::class.java).response
}
