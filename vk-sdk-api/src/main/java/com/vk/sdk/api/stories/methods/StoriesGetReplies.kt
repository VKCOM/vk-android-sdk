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
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.stories.dto.StoriesGetV5113ResponseDto
import com.vk.sdk.api.stories.responses.StoriesGetV5113Response
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns replies to the story.
 * @param ownerId Story owner ID. 
 * @param storyId Story ID. minimum 0
 * @param accessKey Access key for the private object. 
 * @param extended '1' � to return additional fields for users and communities. Default value is 0.
 * default false
 * @param fields Additional fields to return 
 */
class StoriesGetReplies(
    private val ownerId: Int,
    private val storyId: Int,
    private val accessKey: String? = null,
    private val extended: Boolean? = null,
    private val fields: List<BaseUserGroupFields>? = null
) : VKRequest<StoriesGetV5113ResponseDto>("stories.getReplies") {
    init {
        addParam("owner_id", ownerId)
        addParam("story_id", storyId)
        accessKey?.let { value ->
            addParam("access_key", value)
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
