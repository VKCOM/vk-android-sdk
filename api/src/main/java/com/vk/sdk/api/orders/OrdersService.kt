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
package com.vk.sdk.api.orders

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.orders.dto.OrdersAmount
import com.vk.sdk.api.orders.dto.OrdersChangeStateAction
import com.vk.sdk.api.orders.dto.OrdersGetUserSubscriptionsResponse
import com.vk.sdk.api.orders.dto.OrdersOrder
import com.vk.sdk.api.orders.dto.OrdersSubscription
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class OrdersService {
    /**
     * @param userId
     * @param subscriptionId
     * @param pendingCancel
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun ordersCancelSubscription(
        userId: UserId,
        subscriptionId: Int,
        pendingCancel: Boolean? = null
    ): VKRequest<BaseBoolInt> = NewApiRequest("orders.cancelSubscription") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("subscription_id", subscriptionId, min = 0)
        pendingCancel?.let { addParam("pending_cancel", it) }
    }

    /**
     * Changes order status.
     *
     * @param orderId - order ID.
     * @param action - action to be done with the order. Available actions_ *cancel - to cancel
     * unconfirmed order. *charge - to confirm unconfirmed order. Applies only if processing of
     * [vk.com/dev/payments_status|order_change_state] notification failed. *refund - to cancel
     * confirmed order.
     * @param appOrderId - internal ID of the order in the application.
     * @param testMode - if this parameter is set to 1, this method returns a list of test mode
     * orders. By default - 0.
     * @return [VKRequest] with [String]
     */
    fun ordersChangeState(
        orderId: Int,
        action: OrdersChangeStateAction,
        appOrderId: Int? = null,
        testMode: Boolean? = null
    ): VKRequest<String> = NewApiRequest("orders.changeState") {
        GsonHolder.gson.fromJson(it, String::class.java)
    }
    .apply {
        addParam("order_id", orderId, min = 0)
        addParam("action", action.value)
        appOrderId?.let { addParam("app_order_id", it, min = 0) }
        testMode?.let { addParam("test_mode", it) }
    }

    /**
     * Returns a list of orders.
     *
     * @param offset
     * @param count - number of returned orders.
     * @param testMode - if this parameter is set to 1, this method returns a list of test mode
     * orders. By default - 0.
     * @return [VKRequest] with [Unit]
     */
    fun ordersGet(
        offset: Int? = null,
        count: Int? = null,
        testMode: Boolean? = null
    ): VKRequest<List<OrdersOrder>> = NewApiRequest("orders.get") {
        val typeToken = object: TypeToken<List<OrdersOrder>>() {}.type
        GsonHolder.gson.fromJson<List<OrdersOrder>>(it, typeToken)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        testMode?.let { addParam("test_mode", it) }
    }

    /**
     * @param userId
     * @param votes
     * @return [VKRequest] with [Unit]
     */
    fun ordersGetAmount(userId: UserId, votes: List<String>): VKRequest<List<OrdersAmount>> =
            NewApiRequest("orders.getAmount") {
        val typeToken = object: TypeToken<List<OrdersAmount>>() {}.type
        GsonHolder.gson.fromJson<List<OrdersAmount>>(it, typeToken)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("votes", votes)
    }

    /**
     * Returns information about orders by their IDs.
     *
     * @param orderId - order ID.
     * @param orderIds - order IDs (when information about several orders is requested).
     * @param testMode - if this parameter is set to 1, this method returns a list of test mode
     * orders. By default - 0.
     * @return [VKRequest] with [Unit]
     */
    fun ordersGetById(
        orderId: Int? = null,
        orderIds: List<Int>? = null,
        testMode: Boolean? = null
    ): VKRequest<List<OrdersOrder>> = NewApiRequest("orders.getById") {
        val typeToken = object: TypeToken<List<OrdersOrder>>() {}.type
        GsonHolder.gson.fromJson<List<OrdersOrder>>(it, typeToken)
    }
    .apply {
        orderId?.let { addParam("order_id", it, min = 0) }
        orderIds?.let { addParam("order_ids", it) }
        testMode?.let { addParam("test_mode", it) }
    }

    /**
     * @param userId
     * @param subscriptionId
     * @return [VKRequest] with [OrdersSubscription]
     */
    fun ordersGetUserSubscriptionById(userId: UserId, subscriptionId: Int):
            VKRequest<OrdersSubscription> = NewApiRequest("orders.getUserSubscriptionById") {
        GsonHolder.gson.fromJson(it, OrdersSubscription::class.java)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("subscription_id", subscriptionId, min = 0)
    }

    /**
     * @param userId
     * @return [VKRequest] with [OrdersGetUserSubscriptionsResponse]
     */
    fun ordersGetUserSubscriptions(userId: UserId): VKRequest<OrdersGetUserSubscriptionsResponse> =
            NewApiRequest("orders.getUserSubscriptions") {
        GsonHolder.gson.fromJson(it, OrdersGetUserSubscriptionsResponse::class.java)
    }
    .apply {
        addParam("user_id", userId, min = 1)
    }

    /**
     * @param userId
     * @param subscriptionId
     * @param price
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun ordersUpdateSubscription(
        userId: UserId,
        subscriptionId: Int,
        price: Int
    ): VKRequest<BaseBoolInt> = NewApiRequest("orders.updateSubscription") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("subscription_id", subscriptionId, min = 0)
        addParam("price", price, min = 0)
    }
}
