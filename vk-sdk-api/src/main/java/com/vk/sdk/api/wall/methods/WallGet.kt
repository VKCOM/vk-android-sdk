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
import com.vk.sdk.api.wall.dto.WallGetFilter
import com.vk.sdk.api.wall.dto.WallGetResponseDto
import com.vk.sdk.api.wall.responses.WallGetResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of posts on a user wall or community wall.
 * @param ownerId ID of the user or community that owns the wall. By default, current user ID. Use a
 * negative value to designate a community ID. 
 * @param domain User or community short address. 
 * @param offset Offset needed to return a specific subset of posts. minimum 0
 * @param count Number of posts to return (maximum 100). minimum 0
 * @param filter Filter to apply: 'owner' � posts by the wall owner, 'others' � posts by someone
 * else, 'all' � posts by the wall owner and others (default), 'postponed' � timed posts (only
 * available for calls with an 'access_token'), 'suggests' � suggested posts on a community wall 
 * @param extended '1' � to return 'wall', 'profiles', and 'groups' fields, '0' � to return no
 * additional fields (default) 
 * @param fields  
 */
class WallGet(
    private val ownerId: Int? = null,
    private val domain: String? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val filter: WallGetFilter? = null,
    private val extended: Boolean? = null,
    private val fields: List<BaseUserGroupFields>? = null
) : VKRequest<WallGetResponseDto>("wall.get") {
    init {
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        domain?.let { value ->
            addParam("domain", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        filter?.let { value ->
            addParam("filter", value.value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): WallGetResponseDto = GsonHolder.gson.fromJson(r.toString(),
            WallGetResponse::class.java).response
}
