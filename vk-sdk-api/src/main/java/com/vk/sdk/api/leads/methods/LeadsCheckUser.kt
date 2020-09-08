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
import com.vk.sdk.api.leads.dto.LeadsChecked
import com.vk.sdk.api.leads.responses.LeadsCheckUserResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Checks if the user can start the lead.
 * @param leadId Lead ID. minimum 0
 * @param testResult Value to be return in 'result' field when test mode is used. minimum 0
 * @param testMode  default 0
 * @param autoStart  default 0
 * @param age User age. minimum 0
 * @param country User country code. 
 */
class LeadsCheckUser(
    private val leadId: Int,
    private val testResult: Int? = null,
    private val testMode: Boolean? = null,
    private val autoStart: Boolean? = null,
    private val age: Int? = null,
    private val country: String? = null
) : VKRequest<LeadsChecked>("leads.checkUser") {
    init {
        addParam("lead_id", leadId)
        testResult?.let { value ->
            addParam("test_result", value)
        }
        testMode?.let { value ->
            addParam("test_mode", if (value) 1 else 0)
        }
        autoStart?.let { value ->
            addParam("auto_start", if (value) 1 else 0)
        }
        age?.let { value ->
            addParam("age", value)
        }
        country?.let { value ->
            addParam("country", value)
        }
    }

    override fun parse(r: JSONObject): LeadsChecked = GsonHolder.gson.fromJson(r.toString(),
            LeadsCheckUserResponse::class.java).response
}
