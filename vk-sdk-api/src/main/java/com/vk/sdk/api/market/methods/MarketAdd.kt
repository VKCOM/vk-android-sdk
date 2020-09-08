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
import com.vk.sdk.api.market.dto.MarketAddResponseDto
import com.vk.sdk.api.market.responses.MarketAddResponse
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Ads a new item to the market.
 * @param ownerId ID of an item owner community. 
 * @param name Item name. minLength 4 maxLength 100
 * @param description Item description. minLength 10
 * @param categoryId Item category ID. minimum 0
 * @param price Item price. minimum 0.01
 * @param oldPrice  minimum 0.01
 * @param deleted Item status ('1' � deleted, '0' � not deleted). 
 * @param mainPhotoId Cover photo ID. minimum 0
 * @param photoIds IDs of additional photos. 
 * @param url Url for button in market item. minLength 0 maxLength 320
 * @param dimensionWidth  minimum 0 maximum 100000
 * @param dimensionHeight  minimum 0 maximum 100000
 * @param dimensionLength  minimum 0 maximum 100000
 * @param weight  minimum 0 maximum 100000000
 */
class MarketAdd(
    private val ownerId: Int,
    private val name: String,
    private val description: String,
    private val categoryId: Int,
    private val price: Float? = null,
    private val oldPrice: Float? = null,
    private val deleted: Boolean? = null,
    private val mainPhotoId: Int? = null,
    private val photoIds: List<Int>? = null,
    private val url: String? = null,
    private val dimensionWidth: Int? = null,
    private val dimensionHeight: Int? = null,
    private val dimensionLength: Int? = null,
    private val weight: Int? = null
) : VKRequest<MarketAddResponseDto>("market.add") {
    init {
        addParam("owner_id", ownerId)
        addParam("name", name)
        addParam("description", description)
        addParam("category_id", categoryId)
        price?.let { value ->
            addParam("price", value.toString())
        }
        oldPrice?.let { value ->
            addParam("old_price", value.toString())
        }
        deleted?.let { value ->
            addParam("deleted", if (value) 1 else 0)
        }
        mainPhotoId?.let { value ->
            addParam("main_photo_id", value)
        }
        photoIds?.let { value ->
            addParam("photo_ids", value)
        }
        url?.let { value ->
            addParam("url", value)
        }
        dimensionWidth?.let { value ->
            addParam("dimension_width", value)
        }
        dimensionHeight?.let { value ->
            addParam("dimension_height", value)
        }
        dimensionLength?.let { value ->
            addParam("dimension_length", value)
        }
        weight?.let { value ->
            addParam("weight", value)
        }
    }

    override fun parse(r: JSONObject): MarketAddResponseDto = GsonHolder.gson.fromJson(r.toString(),
            MarketAddResponse::class.java).response
}
