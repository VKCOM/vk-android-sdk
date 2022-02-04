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
import kotlin.String

/**
 * @param amount - Amount
 * @param appOrderId - App order ID
 * @param date - Date of creation in Unixtime
 * @param id - Order ID
 * @param item - Order item
 * @param receiverId - Receiver ID
 * @param status - Order status
 * @param userId - User ID
 * @param cancelTransactionId - Cancel transaction ID
 * @param transactionId - Transaction ID
 */
data class OrdersOrder(
    @SerializedName("amount")
    val amount: String,
    @SerializedName("app_order_id")
    val appOrderId: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("item")
    val item: String,
    @SerializedName("receiver_id")
    val receiverId: String,
    @SerializedName("status")
    val status: OrdersOrder.Status,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("cancel_transaction_id")
    val cancelTransactionId: String? = null,
    @SerializedName("transaction_id")
    val transactionId: String? = null
) {
    enum class Status(
        val value: String
    ) {
        @SerializedName("created")
        CREATED("created"),

        @SerializedName("charged")
        CHARGED("charged"),

        @SerializedName("refunded")
        REFUNDED("refunded"),

        @SerializedName("chargeable")
        CHARGEABLE("chargeable"),

        @SerializedName("cancelled")
        CANCELLED("cancelled"),

        @SerializedName("declined")
        DECLINED("declined");
    }
}
