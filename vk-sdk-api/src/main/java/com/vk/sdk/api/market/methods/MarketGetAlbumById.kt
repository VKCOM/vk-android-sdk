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
import com.vk.sdk.api.market.dto.MarketGetAlbumByIdResponseDto
import com.vk.sdk.api.market.responses.MarketGetAlbumByIdResponse
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns items album's data
 * @param ownerId identifier of an album owner community, "Note that community id in the 'owner_id'
 * parameter should be negative number. For example 'owner_id'=-1 matches the [vk.com/apiclub|VK API]
 * community " 
 * @param albumIds collections identifiers to obtain data from 
 */
class MarketGetAlbumById(
    private val ownerId: Int,
    private val albumIds: List<Int>
) : VKRequest<MarketGetAlbumByIdResponseDto>("market.getAlbumById") {
    init {
        addParam("owner_id", ownerId)
        addParam("album_ids", albumIds)
    }

    override fun parse(r: JSONObject): MarketGetAlbumByIdResponseDto =
            GsonHolder.gson.fromJson(r.toString(), MarketGetAlbumByIdResponse::class.java).response
}
