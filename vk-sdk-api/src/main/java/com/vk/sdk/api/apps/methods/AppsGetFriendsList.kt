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
import com.vk.sdk.api.apps.dto.AppsGetFriendsListResponseDto
import com.vk.sdk.api.apps.dto.AppsGetFriendsListType
import com.vk.sdk.api.apps.responses.AppsGetFriendsListResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Creates friends list for requests and invites in current app.
 * @param extended  default 0
 * @param count List size. default 20 minimum 0 maximum 5000
 * @param offset  default 0 minimum 0
 * @param type List type. Possible values: * 'invite' � available for invites (don't play the
 * game),, * 'request' � available for request (play the game). By default: 'invite'. default "invite"
 * @param fields Additional profile fields, see [vk.com/dev/fields|description]. 
 */
class AppsGetFriendsList(
    private val extended: Boolean? = null,
    private val count: Int? = null,
    private val offset: Int? = null,
    private val type: AppsGetFriendsListType? = null,
    private val fields: List<UsersFields>? = null
) : VKRequest<AppsGetFriendsListResponseDto>("apps.getFriendsList") {
    init {
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        count?.let { value ->
            addParam("count", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        type?.let { value ->
            addParam("type", value.value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): AppsGetFriendsListResponseDto =
            GsonHolder.gson.fromJson(r.toString(), AppsGetFriendsListResponse::class.java).response
}
