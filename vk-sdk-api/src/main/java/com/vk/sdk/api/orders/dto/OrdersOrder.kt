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
package com.vk.sdk.api.orders.dto

import com.google.gson.annotations.SerializedName
import kotlin.Int
import kotlin.String

/**
 * @param amount Amount
 * @param appOrderId App order ID
 * @param cancelTransactionId Cancel transaction ID
 * @param date Date of creation in Unixtime
 * @param id Order ID
 * @param item Order item
 * @param receiverId Receiver ID
 * @param status Order status
 * @param transactionId Transaction ID
 * @param userId User ID
 */
data class OrdersOrder(
    @SerializedName(value="amount")
    val amount: Int? = null,
    @SerializedName(value="app_order_id")
    val appOrderId: Int? = null,
    @SerializedName(value="cancel_transaction_id")
    val cancelTransactionId: Int? = null,
    @SerializedName(value="date")
    val date: Int? = null,
    @SerializedName(value="id")
    val id: Int? = null,
    @SerializedName(value="item")
    val item: String? = null,
    @SerializedName(value="receiver_id")
    val receiverId: Int? = null,
    @SerializedName(value="status")
    val status: String? = null,
    @SerializedName(value="transaction_id")
    val transactionId: Int? = null,
    @SerializedName(value="user_id")
    val userId: Int? = null
)
