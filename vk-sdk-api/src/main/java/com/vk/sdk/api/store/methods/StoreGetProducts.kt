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
package com.vk.sdk.api.store.methods

import com.vk.sdk.api.ApiRequestBase
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.store.dto.StoreProduct
import com.vk.sdk.api.store.responses.StoreGetProductsResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * @param type  
 * @param merchant  
 * @param section  
 * @param productIds  
 * @param filters  
 * @param extended  default 0
 */
class StoreGetProducts(
    private val type: String? = null,
    private val merchant: String? = null,
    private val section: String? = null,
    private val productIds: List<Int>? = null,
    private val filters: List<String>? = null,
    private val extended: Boolean? = null
) : ApiRequestBase<List<StoreProduct>>(methodName = "store.getProducts") {
    init {
        type?.let { value ->
            addParam("type", value)
        }
        merchant?.let { value ->
            addParam("merchant", value)
        }
        section?.let { value ->
            addParam("section", value)
        }
        productIds?.let { value ->
            addParam("product_ids", value)
        }
        filters?.let { value ->
            addParam("filters", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): List<StoreProduct> = GsonHolder.gson.fromJson(r.toString(),
            StoreGetProductsResponse::class.java).response
}
