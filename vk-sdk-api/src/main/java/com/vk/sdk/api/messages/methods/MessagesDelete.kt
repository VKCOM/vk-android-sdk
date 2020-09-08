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
package com.vk.sdk.api.messages.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.messages.responses.MessagesDeleteResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import kotlin.collections.Map
import org.json.JSONObject

/**
 * Deletes one or more messages.
 * @param messageIds Message IDs. 
 * @param spam '1' � to mark message as spam. 
 * @param groupId Group ID (for group messages with user access token) minimum 0
 * @param deleteForAll '1' � delete message for for all. default false
 */
class MessagesDelete(
    private val messageIds: List<Int>? = null,
    private val spam: Boolean? = null,
    private val groupId: Int? = null,
    private val deleteForAll: Boolean? = null
) : VKRequest<Map<Int, BaseBoolInt>>("messages.delete") {
    init {
        messageIds?.let { value ->
            addParam("message_ids", value)
        }
        spam?.let { value ->
            addParam("spam", if (value) 1 else 0)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        deleteForAll?.let { value ->
            addParam("delete_for_all", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): Map<Int, BaseBoolInt> =
            GsonHolder.gson.fromJson(r.toString(), MessagesDeleteResponse::class.java).response
}
