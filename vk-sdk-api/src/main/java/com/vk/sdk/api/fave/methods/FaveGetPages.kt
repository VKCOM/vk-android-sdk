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
package com.vk.sdk.api.fave.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.fave.dto.FaveGetPagesResponseDto
import com.vk.sdk.api.fave.dto.FaveGetPagesType
import com.vk.sdk.api.fave.responses.FaveGetPagesResponse
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * @param offset  minimum 0 maximum 10000
 * @param count  default 50 minimum 1 maximum 500
 * @param type  
 * @param fields  
 * @param tagId  
 */
class FaveGetPages(
    private val offset: Int? = null,
    private val count: Int? = null,
    private val type: FaveGetPagesType? = null,
    private val fields: List<BaseUserGroupFields>? = null,
    private val tagId: Int? = null
) : VKRequest<FaveGetPagesResponseDto>("fave.getPages") {
    init {
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        type?.let { value ->
            addParam("type", value.value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        tagId?.let { value ->
            addParam("tag_id", value)
        }
    }

    override fun parse(r: JSONObject): FaveGetPagesResponseDto =
            GsonHolder.gson.fromJson(r.toString(), FaveGetPagesResponse::class.java).response
}
