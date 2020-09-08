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
package com.vk.sdk.api.database.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.database.dto.DatabaseGetCountriesResponseDto
import com.vk.sdk.api.database.responses.DatabaseGetCountriesResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Returns a list of countries.
 * @param needAll '1' � to return a full list of all countries, '0' � to return a list of countries
 * near the current user's country (default). 
 * @param code Country codes in [vk.com/dev/country_codes|ISO 3166-1 alpha-2] standard. 
 * @param offset Offset needed to return a specific subset of countries. minimum 0
 * @param count Number of countries to return. default 100 minimum 0 maximum 1000
 */
class DatabaseGetCountries(
    private val needAll: Boolean? = null,
    private val code: String? = null,
    private val offset: Int? = null,
    private val count: Int? = null
) : VKRequest<DatabaseGetCountriesResponseDto>("database.getCountries") {
    init {
        needAll?.let { value ->
            addParam("need_all", if (value) 1 else 0)
        }
        code?.let { value ->
            addParam("code", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
    }

    override fun parse(r: JSONObject): DatabaseGetCountriesResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            DatabaseGetCountriesResponse::class.java).response
}
