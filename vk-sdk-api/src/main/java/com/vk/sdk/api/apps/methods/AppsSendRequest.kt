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
import com.vk.sdk.api.apps.dto.AppsSendRequestType
import com.vk.sdk.api.apps.responses.AppsSendRequestResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Sends a request to another user in an app that uses VK authorization.
 * @param userId id of the user to send a request minimum 0
 * @param text request text 
 * @param type request type. Values: 'invite' � if the request is sent to a user who does not have
 * the app installed,, 'request' � if a user has already installed the app default "request"
 * @param name  maxLength 128
 * @param key special string key to be sent with the request 
 * @param separate  
 */
class AppsSendRequest(
    private val userId: Int,
    private val text: String? = null,
    private val type: AppsSendRequestType? = null,
    private val name: String? = null,
    private val key: String? = null,
    private val separate: Boolean? = null
) : VKRequest<Int>("apps.sendRequest") {
    init {
        addParam("user_id", userId)
        text?.let { value ->
            addParam("text", value)
        }
        type?.let { value ->
            addParam("type", value.value)
        }
        name?.let { value ->
            addParam("name", value)
        }
        key?.let { value ->
            addParam("key", value)
        }
        separate?.let { value ->
            addParam("separate", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): Int = GsonHolder.gson.fromJson(r.toString(),
            AppsSendRequestResponse::class.java).response
}
