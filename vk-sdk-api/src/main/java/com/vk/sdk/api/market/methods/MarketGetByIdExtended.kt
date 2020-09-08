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
import com.vk.sdk.api.market.dto.MarketGetByIdExtendedResponseDto
import com.vk.sdk.api.market.responses.MarketGetByIdExtendedResponse
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns information about market items by their ids.
 * @param itemIds Comma-separated ids list: {user id}_{item id}. If an item belongs to a
 * community -{community id} is used. " 'Videos' value example: , '-4363_136089719,13245770_137352259'"
 * 
 * @param extended '1' � to return additional fields: 'likes, can_comment, car_repost, photos'. By
 * default: '0'. 
 */
class MarketGetByIdExtended(
    private val itemIds: List<String>,
    private val extended: Boolean? = null
) : VKRequest<MarketGetByIdExtendedResponseDto>("market.getById") {
    init {
        addParam("item_ids", itemIds)
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): MarketGetByIdExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            MarketGetByIdExtendedResponse::class.java).response
}
