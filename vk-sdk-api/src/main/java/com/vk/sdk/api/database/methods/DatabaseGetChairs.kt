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
import com.vk.sdk.api.database.dto.DatabaseGetChairsResponseDto
import com.vk.sdk.api.database.responses.DatabaseGetChairsResponse
import kotlin.Int
import org.json.JSONObject

/**
 * Returns list of chairs on a specified faculty.
 * @param facultyId id of the faculty to get chairs from minimum 0
 * @param offset offset required to get a certain subset of chairs minimum 0
 * @param count amount of chairs to get default 100 minimum 0 maximum 10000
 */
class DatabaseGetChairs(
    private val facultyId: Int,
    private val offset: Int? = null,
    private val count: Int? = null
) : VKRequest<DatabaseGetChairsResponseDto>("database.getChairs") {
    init {
        addParam("faculty_id", facultyId)
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
    }

    override fun parse(r: JSONObject): DatabaseGetChairsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), DatabaseGetChairsResponse::class.java).response
}
