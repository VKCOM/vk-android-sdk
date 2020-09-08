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
import com.vk.sdk.api.polls.dto.PollsGetVotersNameCase
import com.vk.sdk.api.polls.dto.PollsVoters
import com.vk.sdk.api.polls.responses.PollsGetVotersResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of IDs of users who selected specific answers in the poll.
 * @param pollId Poll ID. minimum 0
 * @param answerIds Answer IDs. 
 * @param ownerId ID of the user or community that owns the poll. Use a negative value to designate
 * a community ID. 
 * @param isBoard  
 * @param friendsOnly '1' � to return only current user's friends, '0' � to return all users
 * (default), 
 * @param offset Offset needed to return a specific subset of voters. '0' � (default) minimum 0
 * @param count Number of user IDs to return (if the 'friends_only' parameter is not set, maximum
 * '1000', otherwise '10'). '100' � (default) minimum 0
 * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate
 * (birthdate)', 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile',
 * 'rate', 'contacts', 'education', 'online', 'counters'. 
 * @param nameCase Case for declension of user name and surname: , 'nom' � nominative (default) ,
 * 'gen' � genitive , 'dat' � dative , 'acc' � accusative , 'ins' � instrumental , 'abl' �
 * prepositional 
 */
class PollsGetVoters(
    private val pollId: Int,
    private val answerIds: List<Int>,
    private val ownerId: Int? = null,
    private val isBoard: Boolean? = null,
    private val friendsOnly: Boolean? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val fields: List<UsersFields>? = null,
    private val nameCase: PollsGetVotersNameCase? = null
) : VKRequest<List<PollsVoters>>("polls.getVoters") {
    init {
        addParam("poll_id", pollId)
        addParam("answer_ids", answerIds)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        isBoard?.let { value ->
            addParam("is_board", if (value) 1 else 0)
        }
        friendsOnly?.let { value ->
            addParam("friends_only", if (value) 1 else 0)
        }
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

    override fun parse(r: JSONObject): List<PollsVoters> = GsonHolder.gson.fromJson(r.toString(),
            PollsGetVotersResponse::class.java).response
}
