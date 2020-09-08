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
import com.vk.sdk.api.friends.dto.FriendsFriendExtendedStatus
import com.vk.sdk.api.friends.responses.FriendsAreFriendsExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Checks the current user's friendship status with other specified users.
 * @param userIds IDs of the users whose friendship status to check. 
 * @param needSign '1' � to return 'sign' field. 'sign' is
 * md5("{id}_{user_id}_{friends_status}_{application_secret}"), where id is current user ID. This field
 * allows to check that data has not been modified by the client. By default: '0'. 
 * @param extended Return friend request read_state field 
 */
class FriendsAreFriendsExtended(
    private val userIds: List<Int>,
    private val needSign: Boolean? = null,
    private val extended: Boolean? = null
) : VKRequest<List<FriendsFriendExtendedStatus>>("friends.areFriends") {
    init {
        addParam("user_ids", userIds)
        needSign?.let { value ->
            addParam("need_sign", if (value) 1 else 0)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): List<FriendsFriendExtendedStatus> =
            GsonHolder.gson.fromJson(r.toString(),
            FriendsAreFriendsExtendedResponse::class.java).response
}
