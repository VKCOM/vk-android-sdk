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
package com.vk.sdk.api.photos.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.photos.dto.PhotosSearchResponseDto
import com.vk.sdk.api.photos.responses.PhotosSearchResponse
import kotlin.Float
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Returns a list of photos.
 * @param q Search query string. 
 * @param lat Geographical latitude, in degrees (from '-90' to '90'). 
 * @param long Geographical longitude, in degrees (from '-180' to '180'). 
 * @param startTime  minimum 0
 * @param endTime  minimum 0
 * @param sort Sort order: minimum 0
 * @param offset Offset needed to return a specific subset of photos. minimum 0
 * @param count Number of photos to return. default 100 minimum 0 maximum 1000
 * @param radius Radius of search in meters (works very approximately). Available values: '10',
 * '100', '800', '6000', '50000'. default 5000 minimum 0
 */
class PhotosSearch(
    private val q: String? = null,
    private val lat: Float? = null,
    private val long: Float? = null,
    private val startTime: Int? = null,
    private val endTime: Int? = null,
    private val sort: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val radius: Int? = null
) : VKRequest<PhotosSearchResponseDto>("photos.search") {
    init {
        q?.let { value ->
            addParam("q", value)
        }
        lat?.let { value ->
            addParam("lat", value.toString())
        }
        long?.let { value ->
            addParam("long", value.toString())
        }
        startTime?.let { value ->
            addParam("start_time", value)
        }
        endTime?.let { value ->
            addParam("end_time", value)
        }
        sort?.let { value ->
            addParam("sort", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        radius?.let { value ->
            addParam("radius", value)
        }
    }

    override fun parse(r: JSONObject): PhotosSearchResponseDto =
            GsonHolder.gson.fromJson(r.toString(), PhotosSearchResponse::class.java).response
}
