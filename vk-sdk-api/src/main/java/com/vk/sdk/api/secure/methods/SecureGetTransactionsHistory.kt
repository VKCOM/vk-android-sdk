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
package com.vk.sdk.api.secure.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.secure.dto.SecureTransaction
import com.vk.sdk.api.secure.responses.SecureGetTransactionsHistoryResponse
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Shows history of votes transaction between users and the application.
 * @param type  
 * @param uidFrom  minimum 0
 * @param uidTo  minimum 0
 * @param dateFrom  minimum 0
 * @param dateTo  minimum 0
 * @param limit  default 1000 minimum 0 maximum 1000
 */
class SecureGetTransactionsHistory(
    private val type: Int? = null,
    private val uidFrom: Int? = null,
    private val uidTo: Int? = null,
    private val dateFrom: Int? = null,
    private val dateTo: Int? = null,
    private val limit: Int? = null
) : VKRequest<List<SecureTransaction>>("secure.getTransactionsHistory") {
    init {
        type?.let { value ->
            addParam("type", value)
        }
        uidFrom?.let { value ->
            addParam("uid_from", value)
        }
        uidTo?.let { value ->
            addParam("uid_to", value)
        }
        dateFrom?.let { value ->
            addParam("date_from", value)
        }
        dateTo?.let { value ->
            addParam("date_to", value)
        }
        limit?.let { value ->
            addParam("limit", value)
        }
    }

    override fun parse(r: JSONObject): List<SecureTransaction> =
            GsonHolder.gson.fromJson(r.toString(),
            SecureGetTransactionsHistoryResponse::class.java).response
}
