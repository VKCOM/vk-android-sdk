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
package com.vk.sdk.api.apps.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.apps.dto.AppsGetNameCase
import com.vk.sdk.api.apps.dto.AppsGetPlatform
import com.vk.sdk.api.apps.dto.AppsGetResponseDto
import com.vk.sdk.api.apps.responses.AppsGetResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns applications data.
 * @param appId Application ID minimum 0
 * @param appIds List of application ID 
 * @param platform platform. Possible values: *'ios' � iOS,, *'android' � Android,, *'winphone' �
 * Windows Phone,, *'web' � ���������� �� vk.com. By default: 'web'. default "web"
 * @param extended  default 0
 * @param returnFriends  default 0
 * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate'
 * (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile',
 * 'contacts', 'education', 'online', 'counters', 'relation', 'last_seen', 'activity',
 * 'can_write_private_message', 'can_see_all_posts', 'can_post', 'universities', (only if
 * return_friends - 1) 
 * @param nameCase Case for declension of user name and surname: 'nom' � nominative (default),,
 * 'gen' � genitive,, 'dat' � dative,, 'acc' � accusative,, 'ins' � instrumental,, 'abl' �
 * prepositional. (only if 'return_friends' = '1') 
 */
class AppsGet(
    private val appId: Int? = null,
    private val appIds: List<String>? = null,
    private val platform: AppsGetPlatform? = null,
    private val extended: Boolean? = null,
    private val returnFriends: Boolean? = null,
    private val fields: List<UsersFields>? = null,
    private val nameCase: AppsGetNameCase? = null
) : VKRequest<AppsGetResponseDto>("apps.get") {
    init {
        appId?.let { value ->
            addParam("app_id", value)
        }
        appIds?.let { value ->
            addParam("app_ids", value)
        }
        platform?.let { value ->
            addParam("platform", value.value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        returnFriends?.let { value ->
            addParam("return_friends", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        nameCase?.let { value ->
            addParam("name_case", value.value)
        }
    }

    override fun parse(r: JSONObject): AppsGetResponseDto = GsonHolder.gson.fromJson(r.toString(),
            AppsGetResponse::class.java).response
}
