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
package com.vk.sdk.api.stories.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Boolean
import kotlin.String
import org.json.JSONObject

/**
 * @param accessKey  
 * @param message  maxLength 1000
 * @param isBroadcast  default false
 * @param isAnonymous  default false
 * @param unseenMarker  default false
 */
class StoriesSendInteraction(
    private val accessKey: String,
    private val message: String? = null,
    private val isBroadcast: Boolean? = null,
    private val isAnonymous: Boolean? = null,
    private val unseenMarker: Boolean? = null
) : VKRequest<BaseOkResponseDto>("stories.sendInteraction") {
    init {
        addParam("access_key", accessKey)
        message?.let { value ->
            addParam("message", value)
        }
        isBroadcast?.let { value ->
            addParam("is_broadcast", if (value) 1 else 0)
        }
        isAnonymous?.let { value ->
            addParam("is_anonymous", if (value) 1 else 0)
        }
        unseenMarker?.let { value ->
            addParam("unseen_marker", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
