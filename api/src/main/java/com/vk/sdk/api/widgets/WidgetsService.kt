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
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.users.dto.UsersFieldsDto
import com.vk.sdk.api.widgets.dto.WidgetsGetCommentsResponseDto
import com.vk.sdk.api.widgets.dto.WidgetsGetPagesResponseDto
import kotlin.Int
import kotlin.Long
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
     * @return [VKRequest] with [WidgetsGetCommentsResponseDto]
     */
    fun widgetsGetComments(
        widgetApiId: Int? = null,
        url: String? = null,
        pageId: String? = null,
        order: String? = null,
        fields: List<UsersFieldsDto>? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<WidgetsGetCommentsResponseDto> = NewApiRequest("widgets.getComments") {
        GsonHolder.gson.parse<WidgetsGetCommentsResponseDto>(it)
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
     * @return [VKRequest] with [WidgetsGetPagesResponseDto]
     */
    fun widgetsGetPages(
        widgetApiId: Int? = null,
        order: String? = null,
        period: String? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<WidgetsGetPagesResponseDto> = NewApiRequest("widgets.getPages") {
        GsonHolder.gson.parse<WidgetsGetPagesResponseDto>(it)
    }
    .apply {
        widgetApiId?.let { addParam("widget_api_id", it) }
        order?.let { addParam("order", it) }
        period?.let { addParam("period", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 10, max = 200) }
    }

    object WidgetsGetCommentsRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 10

        const val COUNT_MAX: Long = 200
    }

    object WidgetsGetPagesRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 10

        const val COUNT_MAX: Long = 200
    }
}
