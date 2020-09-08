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
package com.vk.sdk.api.groups.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * @param groupId  minimum 0
 * @param messages  
 * @param botsCapabilities  
 * @param botsStartButton  
 * @param botsAddToChat  
 */
class GroupsSetSettings(
    private val groupId: Int,
    private val messages: Boolean? = null,
    private val botsCapabilities: Boolean? = null,
    private val botsStartButton: Boolean? = null,
    private val botsAddToChat: Boolean? = null
) : VKRequest<BaseOkResponseDto>("groups.setSettings") {
    init {
        addParam("group_id", groupId)
        messages?.let { value ->
            addParam("messages", if (value) 1 else 0)
        }
        botsCapabilities?.let { value ->
            addParam("bots_capabilities", if (value) 1 else 0)
        }
        botsStartButton?.let { value ->
            addParam("bots_start_button", if (value) 1 else 0)
        }
        botsAddToChat?.let { value ->
            addParam("bots_add_to_chat", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
