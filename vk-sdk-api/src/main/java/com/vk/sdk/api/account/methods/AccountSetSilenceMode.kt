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
package com.vk.sdk.api.account.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Mutes push notifications for the set period of time.
 * @param deviceId Unique device ID. 
 * @param time Time in seconds for what notifications should be disabled. '-1' to disable forever. 
 * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'Chat
 * ID', e.g. '2000000001'. For community: '- Community ID', e.g. '-12345'. " 
 * @param sound '1' � to enable sound in this dialog, '0' � to disable sound. Only if 'peer_id'
 * contains user or community ID. 
 */
class AccountSetSilenceMode(
    private val deviceId: String? = null,
    private val time: Int? = null,
    private val peerId: Int? = null,
    private val sound: Int? = null
) : VKRequest<BaseOkResponseDto>("account.setSilenceMode") {
    init {
        deviceId?.let { value ->
            addParam("device_id", value)
        }
        time?.let { value ->
            addParam("time", value)
        }
        peerId?.let { value ->
            addParam("peer_id", value)
        }
        sound?.let { value ->
            addParam("sound", value)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
