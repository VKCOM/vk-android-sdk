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
import com.vk.sdk.api.groups.dto.GroupsFields
import com.vk.sdk.api.groups.dto.GroupsFilter
import com.vk.sdk.api.groups.dto.GroupsGetExtendedResponseDto
import com.vk.sdk.api.groups.responses.GroupsGetExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of the communities to which a user belongs.
 * @param userId User ID. minimum 0
 * @param extended '1' � to return complete information about a user's communities, '0' � to return
 * a list of community IDs without any additional fields (default), 
 * @param filter Types of communities to return: 'admin' � to return communities administered by the
 * user , 'editor' � to return communities where the user is an administrator or editor, 'moder' � to
 * return communities where the user is an administrator, editor, or moderator, 'groups' � to return
 * only groups, 'publics' � to return only public pages, 'events' � to return only events 
 * @param fields Profile fields to return. 
 * @param offset Offset needed to return a specific subset of communities. minimum 0
 * @param count Number of communities to return. minimum 0 maximum 1000
 */
class GroupsGetExtended(
    private val userId: Int? = null,
    private val extended: Boolean? = null,
    private val filter: List<GroupsFilter>? = null,
    private val fields: List<GroupsFields>? = null,
    private val offset: Int? = null,
    private val count: Int? = null
) : VKRequest<GroupsGetExtendedResponseDto>("groups.get") {
    init {
        userId?.let { value ->
            addParam("user_id", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        filter?.let { value ->
            addParam("filter", value.map { it.value })
        }
        fields?.let { value ->
            addParam("fields", value.map { it.value })
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
    }

    override fun parse(r: JSONObject): GroupsGetExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(), GroupsGetExtendedResponse::class.java).response
}
