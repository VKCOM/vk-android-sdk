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
package com.vk.sdk.api.wall.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.wall.dto.WallSearchResponseDto
import com.vk.sdk.api.wall.responses.WallSearchResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Allows to search posts on user or community walls.
 * @param ownerId user or community id. "Remember that for a community 'owner_id' must be negative."
 * 
 * @param domain user or community screen name. 
 * @param query search query string. 
 * @param ownersOnly '1' � returns only page owner's posts. 
 * @param count count of posts to return. default 20 minimum 0 maximum 100
 * @param offset Offset needed to return a specific subset of posts. default 0 minimum 0
 * @param extended show extended post info. 
 * @param fields  
 */
class WallSearch(
    private val ownerId: Int? = null,
    private val domain: String? = null,
    private val query: String? = null,
    private val ownersOnly: Boolean? = null,
    private val count: Int? = null,
    private val offset: Int? = null,
    private val extended: Boolean? = null,
    private val fields: List<BaseUserGroupFields>? = null
) : VKRequest<WallSearchResponseDto>("wall.search") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        domain?.let { value ->
            addParam("domain", value)
        }
        query?.let { value ->
            addParam("query", value)
        }
        ownersOnly?.let { value ->
            addParam("owners_only", if (value) 1 else 0)
        }
        count?.let { value ->
            addParam("count", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): WallSearchResponseDto =
            GsonHolder.gson.fromJson(r.toString(), WallSearchResponse::class.java).response
}
