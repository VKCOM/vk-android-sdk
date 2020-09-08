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
package com.vk.sdk.api.polls.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.polls.dto.PollsGetByIdNameCase
import com.vk.sdk.api.polls.dto.PollsPoll
import com.vk.sdk.api.polls.responses.PollsGetByIdResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns detailed information about a poll by its ID.
 * @param pollId Poll ID. minimum 0
 * @param ownerId ID of the user or community that owns the poll. Use a negative value to designate
 * a community ID. 
 * @param isBoard '1' � poll is in a board, '0' � poll is on a wall. '0' by default. 
 * @param extended  
 * @param friendsCount  default 3 minimum 0 maximum 100
 * @param fields  
 * @param nameCase  default "nom"
 */
class PollsGetById(
    private val pollId: Int,
    private val ownerId: Int? = null,
    private val isBoard: Boolean? = null,
    private val extended: Boolean? = null,
    private val friendsCount: Int? = null,
    private val fields: List<String>? = null,
    private val nameCase: PollsGetByIdNameCase? = null
) : VKRequest<PollsPoll>("polls.getById") {
    init {
        addParam("poll_id", pollId)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        isBoard?.let { value ->
            addParam("is_board", if (value) 1 else 0)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        friendsCount?.let { value ->
            addParam("friends_count", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        nameCase?.let { value ->
            addParam("name_case", value.value)
        }
    }

    override fun parse(r: JSONObject): PollsPoll = GsonHolder.gson.fromJson(r.toString(),
            PollsGetByIdResponse::class.java).response
}
