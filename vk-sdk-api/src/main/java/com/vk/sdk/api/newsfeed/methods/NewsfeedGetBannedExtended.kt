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
package com.vk.sdk.api.newsfeed.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetBannedExtendedResponseDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedGetBannedNameCase
import com.vk.sdk.api.newsfeed.responses.NewsfeedGetBannedExtendedResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of users and communities banned from the current user's newsfeed.
 * @param extended '1' � return extra information about users and communities 
 * @param fields Profile fields to return. 
 * @param nameCase Case for declension of user name and surname: 'nom' � nominative (default), 'gen'
 * � genitive , 'dat' � dative, 'acc' � accusative , 'ins' � instrumental , 'abl' � prepositional 
 */
class NewsfeedGetBannedExtended(
    private val extended: Boolean? = null,
    private val fields: List<UsersFields>? = null,
    private val nameCase: NewsfeedGetBannedNameCase? = null
) : VKRequest<NewsfeedGetBannedExtendedResponseDto>("newsfeed.getBanned") {
    init {
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        nameCase?.let { value ->
            addParam("name_case", value.value)
        }
    }

    override fun parse(r: JSONObject): NewsfeedGetBannedExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            NewsfeedGetBannedExtendedResponse::class.java).response
}
