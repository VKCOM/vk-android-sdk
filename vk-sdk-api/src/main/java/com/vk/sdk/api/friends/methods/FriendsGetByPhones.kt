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
import com.vk.sdk.api.friends.dto.FriendsUserXtrPhone
import com.vk.sdk.api.friends.responses.FriendsGetByPhonesResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of the current user's friends whose phone numbers, validated or specified in a
 * profile, are in a given list.
 * @param phones List of phone numbers in MSISDN format (maximum 1000). Example:
 * "+79219876543,+79111234567" 
 * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate'
 * (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile',
 * 'rate', 'contacts', 'education', 'online, counters'. 
 */
class FriendsGetByPhones(
    private val phones: List<String>? = null,
    private val fields: List<UsersFields>? = null
) : VKRequest<List<FriendsUserXtrPhone>>("friends.getByPhones") {
    init {
        phones?.let { value ->
            addParam("phones", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): List<FriendsUserXtrPhone> =
            GsonHolder.gson.fromJson(r.toString(), FriendsGetByPhonesResponse::class.java).response
}
