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
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Edits an item.
 * @param ownerId ID of an item owner community. 
 * @param itemId Item ID. minimum 0
 * @param name Item name. minLength 4 maxLength 100
 * @param description Item description. minLength 10
 * @param categoryId Item category ID. minimum 0
 * @param price Item price. minimum 0.01
 * @param mainPhotoId Cover photo ID. minimum 0
 * @param deleted Item status ('1' � deleted, '0' � not deleted). 
 * @param photoIds IDs of additional photos. 
 * @param url Url for button in market item. minLength 0 maxLength 320
 */
class MarketEdit(
    private val ownerId: Int,
    private val itemId: Int,
    private val name: String,
    private val description: String,
    private val categoryId: Int,
    private val price: Float,
    private val mainPhotoId: Int,
    private val deleted: Boolean? = null,
    private val photoIds: List<Int>? = null,
    private val url: String? = null
) : VKRequest<BaseOkResponseDto>("market.edit") {
    init {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId)
        addParam("name", name)
        addParam("description", description)
        addParam("category_id", categoryId)
        addParam("price", price.toString())
        addParam("main_photo_id", mainPhotoId)
        deleted?.let { value ->
            addParam("deleted", if (value) 1 else 0)
        }
        photoIds?.let { value ->
            addParam("photo_ids", value)
        }
        url?.let { value ->
            addParam("url", value)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
