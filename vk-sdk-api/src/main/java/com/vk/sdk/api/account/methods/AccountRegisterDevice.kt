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
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Subscribes an iOS/Android/Windows Phone-based device to receive push notifications
 * @param token Device token used to send notifications. (for mpns, the token shall be URL for
 * sending of notifications) 
 * @param deviceId Unique device ID. 
 * @param deviceModel String name of device model. 
 * @param deviceYear Device year. 
 * @param systemVersion String version of device operating system. 
 * @param settings Push settings in a [vk.com/dev/push_settings|special format]. 
 * @param sandbox  default 0
 */
class AccountRegisterDevice(
    private val token: String,
    private val deviceId: String,
    private val deviceModel: String? = null,
    private val deviceYear: Int? = null,
    private val systemVersion: String? = null,
    private val settings: String? = null,
    private val sandbox: Boolean? = null
) : VKRequest<BaseOkResponseDto>("account.registerDevice") {
    init {
        addParam("token", token)
        addParam("device_id", deviceId)
        deviceModel?.let { value ->
            addParam("device_model", value)
        }
        deviceYear?.let { value ->
            addParam("device_year", value)
        }
        systemVersion?.let { value ->
            addParam("system_version", value)
        }
        settings?.let { value ->
            addParam("settings", value)
        }
        sandbox?.let { value ->
            addParam("sandbox", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
