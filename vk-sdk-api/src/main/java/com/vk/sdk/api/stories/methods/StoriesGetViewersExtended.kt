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
import com.vk.sdk.api.stories.dto.StoriesGetViewersExtendedV5115ResponseDto
import com.vk.sdk.api.stories.responses.StoriesGetViewersExtendedV5115Response
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * Returns a list of story viewers.
 * @param ownerId Story owner ID. 
 * @param storyId Story ID. minimum 0
 * @param count Maximum number of results. default 100 minimum 0
 * @param offset Offset needed to return a specific subset of results. default 0 minimum 0
 * @param extended '1' � to return detailed information about photos default 0
 */
class StoriesGetViewersExtended(
    private val ownerId: Int,
    private val storyId: Int,
    private val count: Int? = null,
    private val offset: Int? = null,
    private val extended: Boolean? = null
) : VKRequest<StoriesGetViewersExtendedV5115ResponseDto>("stories.getViewers") {
    init {
        addParam("owner_id", ownerId)
        addParam("story_id", storyId)
        count?.let { value ->
            addParam("count", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): StoriesGetViewersExtendedV5115ResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            StoriesGetViewersExtendedV5115Response::class.java).response
}
