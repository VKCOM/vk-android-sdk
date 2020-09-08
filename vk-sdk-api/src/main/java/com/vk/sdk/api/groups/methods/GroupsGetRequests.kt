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
import com.vk.sdk.api.groups.dto.GroupsGetRequestsResponseDto
import com.vk.sdk.api.groups.responses.GroupsGetRequestsResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of requests to the community.
 * @param groupId Community ID. minimum 0
 * @param offset Offset needed to return a specific subset of results. minimum 0
 * @param count Number of results to return. default 20 minimum 0 maximum 200
 * @param fields Profile fields to return. 
 */
class GroupsGetRequests(
    private val groupId: Int,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val fields: List<UsersFields>? = null
) : VKRequest<GroupsGetRequestsResponseDto>("groups.getRequests") {
    init {
        addParam("group_id", groupId)
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): GroupsGetRequestsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), GroupsGetRequestsResponse::class.java).response
}
