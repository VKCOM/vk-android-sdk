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
import com.vk.sdk.api.friends.dto.FriendsGetFieldsResponseDto
import com.vk.sdk.api.friends.dto.FriendsGetNameCase
import com.vk.sdk.api.friends.dto.FriendsGetOrder
import com.vk.sdk.api.friends.responses.FriendsGetFieldsResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of user IDs or detailed information about a user's friends.
 * @param userId User ID. By default, the current user ID. 
 * @param order Sort order: , 'name' � by name (enabled only if the 'fields' parameter is used),
 * 'hints' � by rating, similar to how friends are sorted in My friends section, , This parameter is
 * available only for [vk.com/dev/standalone|desktop applications]. 
 * @param listId ID of the friend list returned by the
 * [vk.com/dev/friends.getLists|friends.getLists] method to be used as the source. This parameter is
 * taken into account only when the uid parameter is set to the current user ID. This parameter is
 * available only for [vk.com/dev/standalone|desktop applications]. minimum 0
 * @param count Number of friends to return. default 5000 minimum 0
 * @param offset Offset needed to return a specific subset of friends. minimum 0
 * @param fields Profile fields to return. Sample values: 'uid', 'first_name', 'last_name',
 * 'nickname', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium',
 * 'photo_big', 'domain', 'has_mobile', 'rate', 'contacts', 'education'. 
 * @param nameCase Case for declension of user name and surname: , 'nom' � nominative (default) ,
 * 'gen' � genitive , 'dat' � dative , 'acc' � accusative , 'ins' � instrumental , 'abl' �
 * prepositional 
 * @param ref  maxLength 255
 */
class FriendsGetFields(
    private val userId: Int? = null,
    private val order: FriendsGetOrder? = null,
    private val listId: Int? = null,
    private val count: Int? = null,
    private val offset: Int? = null,
    private val fields: List<UsersFields>? = null,
    private val nameCase: FriendsGetNameCase? = null,
    private val ref: String? = null
) : VKRequest<FriendsGetFieldsResponseDto>("friends.get") {
    init {
        userId?.let { value ->
            addParam("user_id", value)
        }
        order?.let { value ->
            addParam("order", value.value)
        }
        listId?.let { value ->
            addParam("list_id", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        nameCase?.let { value ->
            addParam("name_case", value.value)
        }
        ref?.let { value ->
            addParam("ref", value)
        }
    }

    override fun parse(r: JSONObject): FriendsGetFieldsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), FriendsGetFieldsResponse::class.java).response
}
