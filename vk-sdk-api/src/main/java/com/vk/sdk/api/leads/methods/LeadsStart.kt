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
import com.vk.sdk.api.leads.dto.LeadsStart
import com.vk.sdk.api.leads.responses.LeadsStartResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Creates new session for the user passing the offer.
 * @param leadId Lead ID. minimum 0
 * @param secret Secret key from the lead testing interface. 
 * @param uid  default 0 minimum 0
 * @param aid  default 0 minimum 0
 * @param testMode  default 0
 * @param force  default 0
 */
class LeadsStart(
    private val leadId: Int,
    private val secret: String,
    private val uid: Int? = null,
    private val aid: Int? = null,
    private val testMode: Boolean? = null,
    private val force: Boolean? = null
) : VKRequest<LeadsStart>("leads.start") {
    init {
        addParam("lead_id", leadId)
        addParam("secret", secret)
        uid?.let { value ->
            addParam("uid", value)
        }
        aid?.let { value ->
            addParam("aid", value)
        }
        testMode?.let { value ->
            addParam("test_mode", if (value) 1 else 0)
        }
        force?.let { value ->
            addParam("force", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): com.vk.sdk.api.leads.dto.LeadsStart =
            GsonHolder.gson.fromJson(r.toString(), LeadsStartResponse::class.java).response
}
