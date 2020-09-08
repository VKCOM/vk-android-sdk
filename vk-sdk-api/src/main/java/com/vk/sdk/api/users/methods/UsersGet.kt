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
package com.vk.sdk.api.users.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.users.dto.UsersFields
import com.vk.sdk.api.users.dto.UsersGetNameCase
import com.vk.sdk.api.users.dto.UsersUserXtrCounters
import com.vk.sdk.api.users.responses.UsersGetResponse
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns detailed information on users.
 * @param userIds User IDs or screen names ('screen_name'). By default, current user ID. 
 * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate'
 * (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile',
 * 'contacts', 'education', 'online', 'counters', 'relation', 'last_seen', 'activity',
 * 'can_write_private_message', 'can_see_all_posts', 'can_post', 'universities', 'can_invite_to_chats' 
 * @param nameCase Case for declension of user name and surname: 'nom' � nominative (default), 'gen'
 * � genitive , 'dat' � dative, 'acc' � accusative , 'ins' � instrumental , 'abl' � prepositional 
 */
class UsersGet(
    private val userIds: List<String>? = null,
    private val fields: List<UsersFields>? = null,
    private val nameCase: UsersGetNameCase? = null
) : VKRequest<List<UsersUserXtrCounters>>("users.get") {
    init {
        userIds?.let { value ->
            addParam("user_ids", value)
        }
        fields?.let { value ->
            addParam("fields", value.map { it.value })
        }
        nameCase?.let { value ->
            addParam("name_case", value.value)
        }
    }

    override fun parse(r: JSONObject): List<UsersUserXtrCounters> =
            GsonHolder.gson.fromJson(r.toString(), UsersGetResponse::class.java).response
}
