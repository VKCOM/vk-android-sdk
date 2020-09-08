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
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * @param createTime Date of creation in Unixtime
 * @param id Subscription ID
 * @param itemId Subscription order item
 * @param period Subscription period
 * @param periodStartTime Date of last period start in Unixtime
 * @param price Subscription price
 * @param status Subscription status
 * @param updateTime Date of last change in Unixtime
 * @param cancelReason Cancel reason
 * @param nextBillTime Date of next bill in Unixtime
 * @param pendingCancel Pending cancel state
 * @param testMode Is test subscription
 * @param trialExpireTime Date of trial expire in Unixtime
 */
data class OrdersSubscription(
    @SerializedName(value="create_time")
    val createTime: Int,
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="item_id")
    val itemId: String,
    @SerializedName(value="period")
    val period: Int,
    @SerializedName(value="period_start_time")
    val periodStartTime: Int,
    @SerializedName(value="price")
    val price: Int,
    @SerializedName(value="status")
    val status: String,
    @SerializedName(value="update_time")
    val updateTime: Int,
    @SerializedName(value="cancel_reason")
    val cancelReason: String? = null,
    @SerializedName(value="next_bill_time")
    val nextBillTime: Int? = null,
    @SerializedName(value="pending_cancel")
    val pendingCancel: Boolean? = null,
    @SerializedName(value="test_mode")
    val testMode: Boolean? = null,
    @SerializedName(value="trial_expire_time")
    val trialExpireTime: Int? = null
)
