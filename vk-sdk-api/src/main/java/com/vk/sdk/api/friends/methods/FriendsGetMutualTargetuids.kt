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
import com.vk.sdk.api.friends.dto.FriendsMutualFriend
import com.vk.sdk.api.friends.responses.FriendsGetMutualTargetUidsResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of user IDs of the mutual friends of two users.
 * @param sourceUid ID of the user whose friends will be checked against the friends of the user
 * specified in 'target_uid'. minimum 0
 * @param targetUid ID of the user whose friends will be checked against the friends of the user
 * specified in 'source_uid'. minimum 0
 * @param targetUids IDs of the users whose friends will be checked against the friends of the user
 * specified in 'source_uid'. 
 * @param order Sort order: 'random' � random order 
 * @param count Number of mutual friends to return. minimum 0
 * @param offset Offset needed to return a specific subset of mutual friends. minimum 0
 */
class FriendsGetMutualTargetuids(
    private val sourceUid: Int? = null,
    private val targetUid: Int? = null,
    private val targetUids: List<Int>? = null,
    private val order: String? = null,
    private val count: Int? = null,
    private val offset: Int? = null
) : VKRequest<List<FriendsMutualFriend>>("friends.getMutual") {
    init {
        sourceUid?.let { value ->
            addParam("source_uid", value)
        }
        targetUid?.let { value ->
            addParam("target_uid", value)
        }
        targetUids?.let { value ->
            addParam("target_uids", value)
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

    override fun parse(r: JSONObject): List<FriendsMutualFriend> =
            GsonHolder.gson.fromJson(r.toString(),
            FriendsGetMutualTargetUidsResponse::class.java).response
}
