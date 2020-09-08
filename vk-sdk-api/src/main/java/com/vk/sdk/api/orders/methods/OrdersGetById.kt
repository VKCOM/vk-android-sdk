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
package com.vk.sdk.api.orders.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.orders.dto.OrdersOrder
import com.vk.sdk.api.orders.responses.OrdersGetByIdResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns information about orders by their IDs.
 * @param orderId order ID. minimum 0
 * @param orderIds order IDs (when information about several orders is requested). 
 * @param testMode if this parameter is set to 1, this method returns a list of test mode orders. By
 * default � 0. 
 */
class OrdersGetById(
    private val orderId: Int? = null,
    private val orderIds: List<Int>? = null,
    private val testMode: Boolean? = null
) : VKRequest<List<OrdersOrder>>("orders.getById") {
    init {
        orderId?.let { value ->
            addParam("order_id", value)
        }
        orderIds?.let { value ->
            addParam("order_ids", value)
        }
        testMode?.let { value ->
            addParam("test_mode", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): List<OrdersOrder> = GsonHolder.gson.fromJson(r.toString(),
            OrdersGetByIdResponse::class.java).response
}
