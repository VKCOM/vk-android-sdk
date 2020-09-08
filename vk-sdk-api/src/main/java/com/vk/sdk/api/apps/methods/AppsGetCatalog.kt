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
package com.vk.sdk.api.apps.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.apps.dto.AppsGetCatalogFilter
import com.vk.sdk.api.apps.dto.AppsGetCatalogResponseDto
import com.vk.sdk.api.apps.dto.AppsGetCatalogSort
import com.vk.sdk.api.apps.responses.AppsGetCatalogResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of applications (apps) available to users in the App Catalog.
 * @param count Number of apps to return. default 100 minimum 0
 * @param sort Sort order: 'popular_today' � popular for one day (default), 'visitors' � by visitors
 * number , 'create_date' � by creation date, 'growth_rate' � by growth rate, 'popular_week' � popular
 * for one week 
 * @param offset Offset required to return a specific subset of apps. minimum 0
 * @param platform  
 * @param extended '1' � to return additional fields 'screenshots', 'MAU', 'catalog_position', and
 * 'international'. If set, 'count' must be less than or equal to '100'. '0' � not to return additional
 * fields (default). 
 * @param returnFriends  
 * @param fields  
 * @param nameCase  
 * @param q Search query string. 
 * @param genreId  minimum 0
 * @param filter 'installed' � to return list of installed apps (only for mobile platform). 
 */
class AppsGetCatalog(
    private val count: Int,
    private val sort: AppsGetCatalogSort? = null,
    private val offset: Int? = null,
    private val platform: String? = null,
    private val extended: Boolean? = null,
    private val returnFriends: Boolean? = null,
    private val fields: List<UsersFields>? = null,
    private val nameCase: String? = null,
    private val q: String? = null,
    private val genreId: Int? = null,
    private val filter: AppsGetCatalogFilter? = null
) : VKRequest<AppsGetCatalogResponseDto>("apps.getCatalog") {
    init {
        addParam("count", count)
        sort?.let { value ->
            addParam("sort", value.value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        platform?.let { value ->
            addParam("platform", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        returnFriends?.let { value ->
            addParam("return_friends", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        nameCase?.let { value ->
            addParam("name_case", value)
        }
        q?.let { value ->
            addParam("q", value)
        }
        genreId?.let { value ->
            addParam("genre_id", value)
        }
        filter?.let { value ->
            addParam("filter", value.value)
        }
    }

    override fun parse(r: JSONObject): AppsGetCatalogResponseDto =
            GsonHolder.gson.fromJson(r.toString(), AppsGetCatalogResponse::class.java).response
}
