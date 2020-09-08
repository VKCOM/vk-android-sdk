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
import com.vk.sdk.api.friends.dto.FriendsGetSuggestionsFilter
import com.vk.sdk.api.friends.dto.FriendsGetSuggestionsNameCase
import com.vk.sdk.api.friends.dto.FriendsGetSuggestionsResponseDto
import com.vk.sdk.api.friends.responses.FriendsGetSuggestionsResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of profiles of users whom the current user may know.
 * @param filter Types of potential friends to return: 'mutual' � users with many mutual friends ,
 * 'contacts' � users found with the [vk.com/dev/account.importContacts|account.importContacts] method
 * , 'mutual_contacts' � users who imported the same contacts as the current user with the
 * [vk.com/dev/account.importContacts|account.importContacts] method 
 * @param count Number of suggestions to return. default 500 minimum 0 maximum 500
 * @param offset Offset needed to return a specific subset of suggestions. minimum 0
 * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate'
 * (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile',
 * 'rate', 'contacts', 'education', 'online', 'counters'. 
 * @param nameCase Case for declension of user name and surname: , 'nom' � nominative (default) ,
 * 'gen' � genitive , 'dat' � dative , 'acc' � accusative , 'ins' � instrumental , 'abl' �
 * prepositional 
 */
class FriendsGetSuggestions(
    private val filter: List<FriendsGetSuggestionsFilter>? = null,
    private val count: Int? = null,
    private val offset: Int? = null,
    private val fields: List<UsersFields>? = null,
    private val nameCase: FriendsGetSuggestionsNameCase? = null
) : VKRequest<FriendsGetSuggestionsResponseDto>("friends.getSuggestions") {
    init {
        filter?.let { value ->
            addParam("filter", value.map { it.value })
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
    }

    override fun parse(r: JSONObject): FriendsGetSuggestionsResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            FriendsGetSuggestionsResponse::class.java).response
}
