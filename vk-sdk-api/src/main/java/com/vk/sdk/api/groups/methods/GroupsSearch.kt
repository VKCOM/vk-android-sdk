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
package com.vk.sdk.api.groups.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.groups.dto.GroupsSearchResponseDto
import com.vk.sdk.api.groups.dto.GroupsSearchSort
import com.vk.sdk.api.groups.dto.GroupsSearchType
import com.vk.sdk.api.groups.responses.GroupsSearchResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Returns a list of communities matching the search criteria.
 * @param q Search query string. 
 * @param type Community type. Possible values: 'group, page, event.' 
 * @param countryId Country ID. minimum 0
 * @param cityId City ID. If this parameter is transmitted, country_id is ignored. minimum 0
 * @param future '1' � to return only upcoming events. Works with the 'type' = 'event' only. 
 * @param market '1' � to return communities with enabled market only. 
 * @param sort Sort order. Possible values: *'0' � default sorting (similar the full version of the
 * site),, *'1' � by growth speed,, *'2'� by the "day attendance/members number" ratio,, *'3' � by the
 * "Likes number/members number" ratio,, *'4' � by the "comments number/members number" ratio,, *'5' �
 * by the "boards entries number/members number" ratio. 
 * @param offset Offset needed to return a specific subset of results. minimum 0
 * @param count Number of communities to return. "Note that you can not receive more than first
 * thousand of results, regardless of 'count' and 'offset' values." default 20 minimum 0 maximum 1000
 */
class GroupsSearch(
    private val q: String,
    private val type: GroupsSearchType? = null,
    private val countryId: Int? = null,
    private val cityId: Int? = null,
    private val future: Boolean? = null,
    private val market: Boolean? = null,
    private val sort: GroupsSearchSort? = null,
    private val offset: Int? = null,
    private val count: Int? = null
) : VKRequest<GroupsSearchResponseDto>("groups.search") {
    init {
        addParam("q", q)
        type?.let { value ->
            addParam("type", value.value)
        }
        countryId?.let { value ->
            addParam("country_id", value)
        }
        cityId?.let { value ->
            addParam("city_id", value)
        }
        future?.let { value ->
            addParam("future", if (value) 1 else 0)
        }
        market?.let { value ->
            addParam("market", if (value) 1 else 0)
        }
        sort?.let { value ->
            addParam("sort", value.value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
    }

    override fun parse(r: JSONObject): GroupsSearchResponseDto =
            GsonHolder.gson.fromJson(r.toString(), GroupsSearchResponse::class.java).response
}
