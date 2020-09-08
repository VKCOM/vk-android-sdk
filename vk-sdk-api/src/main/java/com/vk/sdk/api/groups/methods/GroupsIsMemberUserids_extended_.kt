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
package com.vk.sdk.api.groups.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.groups.dto.GroupsMemberStatusFull
import com.vk.sdk.api.groups.responses.GroupsIsMemberUserIdsExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns information specifying whether a user is a member of a community.
 * @param groupId ID or screen name of the community. 
 * @param userId User ID. minimum 0
 * @param userIds User IDs. 
 * @param extended '1' � to return an extended response with additional fields. By default: '0'. 
 */
class GroupsIsMemberUserids_extended_(
    private val groupId: String,
    private val userId: Int? = null,
    private val userIds: List<Int>? = null,
    private val extended: Boolean? = null
) : VKRequest<List<GroupsMemberStatusFull>>("groups.isMember") {
    init {
        addParam("group_id", groupId)
        userId?.let { value ->
            addParam("user_id", value)
        }
        userIds?.let { value ->
            addParam("user_ids", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): List<GroupsMemberStatusFull> =
            GsonHolder.gson.fromJson(r.toString(),
            GroupsIsMemberUserIdsExtendedResponse::class.java).response
}
