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
package com.vk.sdk.api.widgets

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.users.dto.UsersFields
import com.vk.sdk.api.widgets.dto.WidgetsGetCommentsResponse
import com.vk.sdk.api.widgets.dto.WidgetsGetPagesResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class WidgetsService {
    /**
     * Gets a list of comments for the page added through the [vk.com/dev/Comments|Comments widget].
     *
     * @param widgetApiId
     * @param url
     * @param pageId
     * @param order
     * @param fields
     * @param offset
     * @param count
     * @return [VKRequest] with [WidgetsGetCommentsResponse]
     */
    fun widgetsGetComments(
        widgetApiId: Int? = null,
        url: String? = null,
        pageId: String? = null,
        order: String? = null,
        fields: List<UsersFields>? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<WidgetsGetCommentsResponse> = NewApiRequest("widgets.getComments") {
        GsonHolder.gson.fromJson(it, WidgetsGetCommentsResponse::class.java)
    }
    .apply {
        widgetApiId?.let { addParam("widget_api_id", it) }
        url?.let { addParam("url", it) }
        pageId?.let { addParam("page_id", it) }
        order?.let { addParam("order", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 10, max = 200) }
    }

    /**
     * Gets a list of application/site pages where the [vk.com/dev/Comments|Comments widget] or
     * [vk.com/dev/Like|Like widget] is installed.
     *
     * @param widgetApiId
     * @param order
     * @param period
     * @param offset
     * @param count
     * @return [VKRequest] with [WidgetsGetPagesResponse]
     */
    fun widgetsGetPages(
        widgetApiId: Int? = null,
        order: String? = null,
        period: String? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<WidgetsGetPagesResponse> = NewApiRequest("widgets.getPages") {
        GsonHolder.gson.fromJson(it, WidgetsGetPagesResponse::class.java)
    }
    .apply {
        widgetApiId?.let { addParam("widget_api_id", it) }
        order?.let { addParam("order", it) }
        period?.let { addParam("period", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 10, max = 200) }
    }
}
