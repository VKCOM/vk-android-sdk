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
package com.vk.sdk.api.wall.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.wall.dto.WallGetByIdExtendedResponseDto
import com.vk.sdk.api.wall.responses.WallGetByIdExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of posts from user or community walls by their IDs.
 * @param posts User or community IDs and post IDs, separated by underscores. Use a negative value
 * to designate a community ID. Example: "93388_21539,93388_20904,2943_4276,-1_1" 
 * @param extended '1' � to return user and community objects needed to display posts, '0' � no
 * additional fields are returned (default) 
 * @param copyHistoryDepth Sets the number of parent elements to include in the array 'copy_history'
 * that is returned if the post is a repost from another wall. default 2
 * @param fields  
 */
class WallGetByIdExtended(
    private val posts: List<String>,
    private val extended: Boolean? = null,
    private val copyHistoryDepth: Int? = null,
    private val fields: List<BaseUserGroupFields>? = null
) : VKRequest<WallGetByIdExtendedResponseDto>("wall.getById") {
    init {
        addParam("posts", posts)
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        copyHistoryDepth?.let { value ->
            addParam("copy_history_depth", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): WallGetByIdExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(), WallGetByIdExtendedResponse::class.java).response
}
