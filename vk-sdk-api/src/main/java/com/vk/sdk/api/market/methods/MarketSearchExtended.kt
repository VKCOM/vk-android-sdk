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
import com.vk.sdk.api.market.dto.MarketSearchExtendedResponseDto
import com.vk.sdk.api.market.dto.MarketSearchRev
import com.vk.sdk.api.market.dto.MarketSearchSort
import com.vk.sdk.api.market.dto.MarketSearchStatus
import com.vk.sdk.api.market.responses.MarketSearchExtendedResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Searches market items in a community's catalog
 * @param ownerId ID of an items owner community. 
 * @param albumId  default 0 minimum 0
 * @param q Search query, for example "pink slippers". 
 * @param priceFrom Minimum item price value. minimum 0
 * @param priceTo Maximum item price value. minimum 0
 * @param sort  default 0
 * @param rev '0' � do not use reverse order, '1' � use reverse order default 1 minimum 0
 * @param offset Offset needed to return a specific subset of results. minimum 0
 * @param count Number of items to return. default 20 minimum 0 maximum 200
 * @param extended '1' � to return additional fields: 'likes, can_comment, car_repost, photos'. By
 * default: '0'. default "0"
 * @param status  default 0 minimum 0
 */
class MarketSearchExtended(
    private val ownerId: Int,
    private val albumId: Int? = null,
    private val q: String? = null,
    private val priceFrom: Int? = null,
    private val priceTo: Int? = null,
    private val sort: MarketSearchSort? = null,
    private val rev: MarketSearchRev? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null,
    private val status: MarketSearchStatus? = null
) : VKRequest<MarketSearchExtendedResponseDto>("market.search") {
    init {
        addParam("owner_id", ownerId)
        albumId?.let { value ->
            addParam("album_id", value)
        }
        q?.let { value ->
            addParam("q", value)
        }
        priceFrom?.let { value ->
            addParam("price_from", value)
        }
        priceTo?.let { value ->
            addParam("price_to", value)
        }
        sort?.let { value ->
            addParam("sort", value.value)
        }
        rev?.let { value ->
            addParam("rev", value.value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        status?.let { value ->
            addParam("status", value.value)
        }
    }

    override fun parse(r: JSONObject): MarketSearchExtendedResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            MarketSearchExtendedResponse::class.java).response
}
