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
package com.vk.sdk.api.leads.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.leads.dto.LeadsEntry
import com.vk.sdk.api.leads.dto.LeadsGetUsersStatus
import com.vk.sdk.api.leads.responses.LeadsGetUsersResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of last user actions for the offer.
 * @param offerId Offer ID. minimum 0
 * @param secret Secret key obtained in the lead testing interface. 
 * @param offset Offset needed to return a specific subset of results. minimum 0
 * @param count Number of results to return. default 100 minimum 0 maximum 1000
 * @param status Action type. Possible values: *'0' � start,, *'1' � finish,, *'2' � blocking
 * users,, *'3' � start in a test mode,, *'4' � finish in a test mode. minimum 0
 * @param reverse Sort order. Possible values: *'1' � chronological,, *'0' � reverse chronological. 
 */
class LeadsGetUsers(
    private val offerId: Int,
    private val secret: String,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val status: LeadsGetUsersStatus? = null,
    private val reverse: Boolean? = null
) : VKRequest<List<LeadsEntry>>("leads.getUsers") {
    init {
        addParam("offer_id", offerId)
        addParam("secret", secret)
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        status?.let { value ->
            addParam("status", value.value)
        }
        reverse?.let { value ->
            addParam("reverse", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): List<LeadsEntry> = GsonHolder.gson.fromJson(r.toString(),
            LeadsGetUsersResponse::class.java).response
}
