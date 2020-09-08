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
package com.vk.sdk.api.video.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.video.dto.VideoSearchFilters
import com.vk.sdk.api.video.dto.VideoSearchResponseDto
import com.vk.sdk.api.video.dto.VideoSearchSort
import com.vk.sdk.api.video.responses.VideoSearchResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of videos under the set search criterion.
 * @param q Search query string (e.g., 'The Beatles'). 
 * @param sort Sort order: '1' � by duration, '2' � by relevance, '0' � by date added 
 * @param hd If not null, only searches for high-definition videos. 
 * @param adult '1' � to disable the Safe Search filter, '0' � to enable the Safe Search filter 
 * @param filters Filters to apply: 'youtube' � return YouTube videos only, 'vimeo' � return Vimeo
 * videos only, 'short' � return short videos only, 'long' � return long videos only 
 * @param searchOwn  
 * @param offset Offset needed to return a specific subset of videos. minimum 0
 * @param longer  minimum 0
 * @param shorter  minimum 0
 * @param count Number of videos to return. default 20 minimum 0 maximum 200
 * @param extended  default 0
 */
class VideoSearch(
    private val q: String,
    private val sort: VideoSearchSort? = null,
    private val hd: Int? = null,
    private val adult: Boolean? = null,
    private val filters: List<VideoSearchFilters>? = null,
    private val searchOwn: Boolean? = null,
    private val offset: Int? = null,
    private val longer: Int? = null,
    private val shorter: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null
) : VKRequest<VideoSearchResponseDto>("video.search") {
    init {
        addParam("q", q)
        sort?.let { value ->
            addParam("sort", value.value)
        }
        hd?.let { value ->
            addParam("hd", value)
        }
        adult?.let { value ->
            addParam("adult", if (value) 1 else 0)
        }
        filters?.let { value ->
            addParam("filters", value.map { it.value })
        }
        searchOwn?.let { value ->
            addParam("search_own", if (value) 1 else 0)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        longer?.let { value ->
            addParam("longer", value)
        }
        shorter?.let { value ->
            addParam("shorter", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): VideoSearchResponseDto =
            GsonHolder.gson.fromJson(r.toString(), VideoSearchResponse::class.java).response
}
