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
package com.vk.sdk.api.docs.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.docs.dto.DocsSearchResponseDto
import com.vk.sdk.api.docs.responses.DocsSearchResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Returns a list of documents matching the search criteria.
 * @param q Search query string. maxLength 512
 * @param searchOwn  
 * @param count Number of results to return. default 20 minimum 0
 * @param offset Offset needed to return a specific subset of results. minimum 0
 * @param returnTags  
 */
class DocsSearch(
    private val q: String,
    private val searchOwn: Boolean? = null,
    private val count: Int? = null,
    private val offset: Int? = null,
    private val returnTags: Boolean? = null
) : VKRequest<DocsSearchResponseDto>("docs.search") {
    init {
        addParam("q", q)
        searchOwn?.let { value ->
            addParam("search_own", if (value) 1 else 0)
        }
        count?.let { value ->
            addParam("count", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        returnTags?.let { value ->
            addParam("return_tags", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): DocsSearchResponseDto =
            GsonHolder.gson.fromJson(r.toString(), DocsSearchResponse::class.java).response
}
