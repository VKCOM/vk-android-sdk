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
package com.vk.sdk.api.market.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.market.dto.MarketGetCommentsResponseDto
import com.vk.sdk.api.market.dto.MarketGetCommentsSort
import com.vk.sdk.api.market.responses.MarketGetCommentsResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns comments list for an item.
 * @param ownerId ID of an item owner community 
 * @param itemId Item ID. minimum 0
 * @param needLikes '1' � to return likes info. 
 * @param startCommentId ID of a comment to start a list from (details below). minimum 0
 * @param offset  default 0 minimum 0
 * @param count Number of results to return. default 20 minimum 0 maximum 100
 * @param sort Sort order ('asc' � from old to new, 'desc' � from new to old) default "asc"
 * @param extended '1' � comments will be returned as numbered objects, in addition lists of
 * 'profiles' and 'groups' objects will be returned. 
 * @param fields List of additional profile fields to return. See the [vk.com/dev/fields|details] 
 */
class MarketGetComments(
    private val ownerId: Int,
    private val itemId: Int,
    private val needLikes: Boolean? = null,
    private val startCommentId: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val sort: MarketGetCommentsSort? = null,
    private val extended: Boolean? = null,
    private val fields: List<UsersFields>? = null
) : VKRequest<MarketGetCommentsResponseDto>("market.getComments") {
    init {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId)
        needLikes?.let { value ->
            addParam("need_likes", if (value) 1 else 0)
        }
        startCommentId?.let { value ->
            addParam("start_comment_id", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        sort?.let { value ->
            addParam("sort", value.value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
    }

    override fun parse(r: JSONObject): MarketGetCommentsResponseDto =
            GsonHolder.gson.fromJson(r.toString(), MarketGetCommentsResponse::class.java).response
}
