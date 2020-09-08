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
package com.vk.sdk.api.widgets.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.widgets.dto.WidgetsGetPagesResponseDto
import com.vk.sdk.api.widgets.responses.WidgetsGetPagesResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Gets a list of application/site pages where the [vk.com/dev/Comments|Comments widget] or
 * [vk.com/dev/Like|Like widget] is installed.
 * @param widgetApiId  
 * @param order  default "friend_likes"
 * @param period  default "week"
 * @param offset  default 0 minimum 0
 * @param count  default 10 minimum 10 maximum 200
 */
class WidgetsGetPages(
    private val widgetApiId: Int? = null,
    private val order: String? = null,
    private val period: String? = null,
    private val offset: Int? = null,
    private val count: Int? = null
) : VKRequest<WidgetsGetPagesResponseDto>("widgets.getPages") {
    init {
        widgetApiId?.let { value ->
            addParam("widget_api_id", value)
        }
        order?.let { value ->
            addParam("order", value)
        }
        period?.let { value ->
            addParam("period", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
    }

    override fun parse(r: JSONObject): WidgetsGetPagesResponseDto =
            GsonHolder.gson.fromJson(r.toString(), WidgetsGetPagesResponse::class.java).response
}
