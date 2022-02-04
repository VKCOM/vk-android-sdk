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
package com.vk.sdk.api.search

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.search.dto.SearchGetHintsResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class SearchService {
    /**
     * Allows the programmer to do a quick search for any substring.
     *
     * @param q - Search query string.
     * @param offset - Offset for querying specific result subset
     * @param limit - Maximum number of results to return.
     * @param filters
     * @param fields
     * @param searchGlobal
     * @return [VKRequest] with [SearchGetHintsResponse]
     */
    fun searchGetHints(
        q: String? = null,
        offset: Int? = null,
        limit: Int? = null,
        filters: List<String>? = null,
        fields: List<String>? = null,
        searchGlobal: Boolean? = null
    ): VKRequest<SearchGetHintsResponse> = NewApiRequest("search.getHints") {
        GsonHolder.gson.fromJson(it, SearchGetHintsResponse::class.java)
    }
    .apply {
        q?.let { addParam("q", it, maxLength = 9000) }
        offset?.let { addParam("offset", it, min = 0, max = 200) }
        limit?.let { addParam("limit", it, min = 0, max = 200) }
        filters?.let { addParam("filters", it) }
        fields?.let { addParam("fields", it) }
        searchGlobal?.let { addParam("search_global", it) }
    }
}
