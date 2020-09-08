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
package com.vk.sdk.api.notifications.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.notifications.dto.NotificationsSendMessageItem
import com.vk.sdk.api.notifications.responses.NotificationsSendMessageResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * @param userIds  
 * @param message  maxLength 254
 * @param fragment  maxLength 2047
 * @param groupId  minimum 0
 * @param randomId  
 */
class NotificationsSendMessage(
    private val userIds: List<Int>,
    private val message: String,
    private val fragment: String? = null,
    private val groupId: Int? = null,
    private val randomId: Int? = null
) : VKRequest<List<NotificationsSendMessageItem>>("notifications.sendMessage") {
    init {
        addParam("user_ids", userIds)
        addParam("message", message)
        fragment?.let { value ->
            addParam("fragment", value)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        randomId?.let { value ->
            addParam("random_id", value)
        }
    }

    override fun parse(r: JSONObject): List<NotificationsSendMessageItem> =
            GsonHolder.gson.fromJson(r.toString(),
            NotificationsSendMessageResponse::class.java).response
}
