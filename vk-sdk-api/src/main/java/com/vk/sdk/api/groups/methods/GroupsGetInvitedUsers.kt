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
import com.vk.sdk.api.groups.dto.GroupsGetInvitedUsersNameCase
import com.vk.sdk.api.groups.dto.GroupsGetInvitedUsersResponseDto
import com.vk.sdk.api.groups.responses.GroupsGetInvitedUsersResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns invited users list of a community
 * @param groupId Group ID to return invited users for. minimum 0
 * @param offset Offset needed to return a specific subset of results. minimum 0
 * @param count Number of results to return. default 20 minimum 0
 * @param fields List of additional fields to be returned. Available values: 'sex, bdate, city,
 * country, photo_50, photo_100, photo_200_orig, photo_200, photo_400_orig, photo_max, photo_max_orig,
 * online, online_mobile, lists, domain, has_mobile, contacts, connections, site, education,
 * universities, schools, can_post, can_see_all_posts, can_see_audio, can_write_private_message,
 * status, last_seen, common_count, relation, relatives, counters'. 
 * @param nameCase Case for declension of user name and surname. Possible values: *'nom' �
 * nominative (default),, *'gen' � genitive,, *'dat' � dative,, *'acc' � accusative, , *'ins' �
 * instrumental,, *'abl' � prepositional. 
 */
class GroupsGetInvitedUsers(
    private val groupId: Int,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val fields: List<UsersFields>? = null,
    private val nameCase: GroupsGetInvitedUsersNameCase? = null
) : VKRequest<GroupsGetInvitedUsersResponseDto>("groups.getInvitedUsers") {
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
        nameCase?.let { value ->
            addParam("name_case", value.value)
        }
    }

    override fun parse(r: JSONObject): GroupsGetInvitedUsersResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            GroupsGetInvitedUsersResponse::class.java).response
}
