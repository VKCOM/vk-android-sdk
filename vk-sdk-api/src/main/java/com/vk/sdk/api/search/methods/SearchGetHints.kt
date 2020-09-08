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
package com.vk.sdk.api.search.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.search.dto.SearchGetHintsResponseDto
import com.vk.sdk.api.search.responses.SearchGetHintsResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Allows the programmer to do a quick search for any substring.
 * @param q Search query string. 
 * @param offset Offset for querying specific result subset minimum 0 maximum 200
 * @param limit Maximum number of results to return. default 9 minimum 0 maximum 200
 * @param filters  
 * @param fields  
 * @param searchGlobal  default 1
 */
class SearchGetHints(
    private val q: String? = null,
    private val offset: Int? = null,
    private val limit: Int? = null,
    private val filters: List<String>? = null,
    private val fields: List<String>? = null,
    private val searchGlobal: Boolean? = null
) : VKRequest<SearchGetHintsResponseDto>("search.getHints") {
    init {
        q?.let { value ->
            addParam("q", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        limit?.let { value ->
            addParam("limit", value)
        }
        filters?.let { value ->
            addParam("filters", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        searchGlobal?.let { value ->
            addParam("search_global", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): SearchGetHintsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), SearchGetHintsResponse::class.java).response
}
