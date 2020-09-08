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
package com.vk.sdk.api.stories.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.stories.dto.StoriesGetV5113ResponseDto
import com.vk.sdk.api.stories.responses.StoriesGetV5113Response
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * @param q  maxLength 255
 * @param placeId  minimum 0
 * @param latitude  
 * @param longitude  
 * @param radius  minimum 0
 * @param mentionedId  
 * @param count  default 20 minimum 1 maximum 1000
 * @param extended  
 * @param fields  
 */
class StoriesSearch(
    private val q: String? = null,
    private val placeId: Int? = null,
    private val latitude: Float? = null,
    private val longitude: Float? = null,
    private val radius: Int? = null,
    private val mentionedId: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null,
    private val fields: List<String>? = null
) : VKRequest<StoriesGetV5113ResponseDto>("stories.search") {
    init {
        q?.let { value ->
            addParam("q", value)
        }
        placeId?.let { value ->
            addParam("place_id", value)
        }
        latitude?.let { value ->
            addParam("latitude", value.toString())
        }
        longitude?.let { value ->
            addParam("longitude", value.toString())
        }
        radius?.let { value ->
            addParam("radius", value)
        }
        mentionedId?.let { value ->
            addParam("mentioned_id", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): StoriesGetV5113ResponseDto =
            GsonHolder.gson.fromJson(r.toString(), StoriesGetV5113Response::class.java).response
}
