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
import com.vk.sdk.api.users.dto.UsersFields
import com.vk.sdk.api.widgets.dto.WidgetsGetCommentsResponseDto
import com.vk.sdk.api.widgets.responses.WidgetsGetCommentsResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Gets a list of comments for the page added through the [vk.com/dev/Comments|Comments widget].
 * @param widgetApiId  
 * @param url  
 * @param pageId  
 * @param order  default "date"
 * @param fields  
 * @param offset  default 0 minimum 0
 * @param count  default 10 minimum 10 maximum 200
 */
class WidgetsGetComments(
    private val widgetApiId: Int? = null,
    private val url: String? = null,
    private val pageId: String? = null,
    private val order: String? = null,
    private val fields: List<UsersFields>? = null,
    private val offset: Int? = null,
    private val count: Int? = null
) : VKRequest<WidgetsGetCommentsResponseDto>("widgets.getComments") {
    init {
        widgetApiId?.let { value ->
            addParam("widget_api_id", value)
        }
        url?.let { value ->
            addParam("url", value)
        }
        pageId?.let { value ->
            addParam("page_id", value)
        }
        order?.let { value ->
            addParam("order", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
    }

    override fun parse(r: JSONObject): WidgetsGetCommentsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), WidgetsGetCommentsResponse::class.java).response
}
