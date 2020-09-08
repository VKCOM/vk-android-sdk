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
package com.vk.sdk.api.stats.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.stats.dto.StatsGetInterval
import com.vk.sdk.api.stats.dto.StatsPeriod
import com.vk.sdk.api.stats.responses.StatsGetResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns statistics of a community or an application.
 * @param groupId Community ID. minimum 0
 * @param appId Application ID. minimum 0
 * @param timestampFrom  minimum 0
 * @param timestampTo  minimum 0
 * @param interval  default "day"
 * @param intervalsCount  minimum 0
 * @param filters  
 * @param statsGroups  
 * @param extended  default true
 */
class StatsGet(
    private val groupId: Int? = null,
    private val appId: Int? = null,
    private val timestampFrom: Int? = null,
    private val timestampTo: Int? = null,
    private val interval: StatsGetInterval? = null,
    private val intervalsCount: Int? = null,
    private val filters: List<String>? = null,
    private val statsGroups: List<String>? = null,
    private val extended: Boolean? = null
) : VKRequest<List<StatsPeriod>>("stats.get") {
    init {
        groupId?.let { value ->
            addParam("group_id", value)
        }
        appId?.let { value ->
            addParam("app_id", value)
        }
        timestampFrom?.let { value ->
            addParam("timestamp_from", value)
        }
        timestampTo?.let { value ->
            addParam("timestamp_to", value)
        }
        interval?.let { value ->
            addParam("interval", value.value)
        }
        intervalsCount?.let { value ->
            addParam("intervals_count", value)
        }
        filters?.let { value ->
            addParam("filters", value)
        }
        statsGroups?.let { value ->
            addParam("stats_groups", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): List<StatsPeriod> = GsonHolder.gson.fromJson(r.toString(),
            StatsGetResponse::class.java).response
}
