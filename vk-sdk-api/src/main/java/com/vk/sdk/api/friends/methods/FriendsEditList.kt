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
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Edits a friend list of the current user.
 * @param listId Friend list ID. minimum 0
 * @param name Name of the friend list. 
 * @param userIds IDs of users in the friend list. 
 * @param addUserIds (Applies if 'user_ids' parameter is not set.), User IDs to add to the friend
 * list. 
 * @param deleteUserIds (Applies if 'user_ids' parameter is not set.), User IDs to delete from the
 * friend list. 
 */
class FriendsEditList(
    private val listId: Int,
    private val name: String? = null,
    private val userIds: List<Int>? = null,
    private val addUserIds: List<Int>? = null,
    private val deleteUserIds: List<Int>? = null
) : VKRequest<BaseOkResponseDto>("friends.editList") {
    init {
        addParam("list_id", listId)
        name?.let { value ->
            addParam("name", value)
        }
        userIds?.let { value ->
            addParam("user_ids", value)
        }
        addUserIds?.let { value ->
            addParam("add_user_ids", value)
        }
        deleteUserIds?.let { value ->
            addParam("delete_user_ids", value)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
