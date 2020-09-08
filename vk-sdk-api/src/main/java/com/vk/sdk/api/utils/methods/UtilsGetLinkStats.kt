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
package com.vk.sdk.api.utils.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.utils.dto.UtilsGetLinkStatsInterval
import com.vk.sdk.api.utils.dto.UtilsGetLinkStatsSource
import com.vk.sdk.api.utils.dto.UtilsLinkStats
import com.vk.sdk.api.utils.responses.UtilsGetLinkStatsResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Returns stats data for shortened link.
 * @param key Link key (characters after vk.cc/). 
 * @param source Source of scope default "vk_cc"
 * @param accessKey Access key for private link stats. 
 * @param interval Interval. default "day"
 * @param intervalsCount Number of intervals to return. default 1 minimum 0 maximum 100
 * @param extended 1 � to return extended stats data (sex, age, geo). 0 � to return views number
 * only. default false
 */
class UtilsGetLinkStats(
    private val key: String,
    private val source: UtilsGetLinkStatsSource? = null,
    private val accessKey: String? = null,
    private val interval: UtilsGetLinkStatsInterval? = null,
    private val intervalsCount: Int? = null,
    private val extended: Boolean? = null
) : VKRequest<UtilsLinkStats>("utils.getLinkStats") {
    init {
        addParam("key", key)
        source?.let { value ->
            addParam("source", value.value)
        }
        accessKey?.let { value ->
            addParam("access_key", value)
        }
        interval?.let { value ->
            addParam("interval", value.value)
        }
        intervalsCount?.let { value ->
            addParam("intervals_count", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): UtilsLinkStats = GsonHolder.gson.fromJson(r.toString(),
            UtilsGetLinkStatsResponse::class.java).response
}
