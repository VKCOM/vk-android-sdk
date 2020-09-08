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
import com.vk.sdk.api.database.dto.DatabaseGetMetroStationsResponseDto
import com.vk.sdk.api.database.responses.DatabaseGetMetroStationsResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * Get metro stations by city
 * @param cityId  minimum 0
 * @param offset  minimum 0
 * @param count  default 100 minimum 0 maximum 500
 * @param extended  default false
 */
class DatabaseGetMetroStations(
    private val cityId: Int,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null
) : VKRequest<DatabaseGetMetroStationsResponseDto>("database.getMetroStations") {
    init {
        addParam("city_id", cityId)
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): DatabaseGetMetroStationsResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            DatabaseGetMetroStationsResponse::class.java).response
}
