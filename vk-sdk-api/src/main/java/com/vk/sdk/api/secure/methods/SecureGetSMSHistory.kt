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
import com.vk.sdk.api.secure.dto.SecureSmsNotification
import com.vk.sdk.api.secure.responses.SecureGetSMSHistoryResponse
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Shows a list of SMS notifications sent by the application using
 * [vk.com/dev/secure.sendSMSNotification|secure.sendSMSNotification] method.
 * @param userId  minimum 0
 * @param dateFrom filter by start date. It is set as UNIX-time. minimum 0
 * @param dateTo filter by end date. It is set as UNIX-time. minimum 0
 * @param limit number of returned posts. By default � 1000. default 1000 minimum 0 maximum 1000
 */
class SecureGetSMSHistory(
    private val userId: Int? = null,
    private val dateFrom: Int? = null,
    private val dateTo: Int? = null,
    private val limit: Int? = null
) : VKRequest<List<SecureSmsNotification>>("secure.getSMSHistory") {
    init {
        userId?.let { value ->
            addParam("user_id", value)
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

    override fun parse(r: JSONObject): List<SecureSmsNotification> =
            GsonHolder.gson.fromJson(r.toString(), SecureGetSMSHistoryResponse::class.java).response
}
