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

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.orders.dto.OrdersAmountDto
import com.vk.sdk.api.orders.dto.OrdersChangeStateActionDto
import com.vk.sdk.api.orders.dto.OrdersGetUserSubscriptionsResponseDto
import com.vk.sdk.api.orders.dto.OrdersOrderDto
import com.vk.sdk.api.orders.dto.OrdersSubscriptionDto
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class OrdersService {
    /**
     * @param userId
     * @param subscriptionId
     * @param pendingCancel
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun ordersCancelSubscription(
        userId: UserId,
        subscriptionId: Int,
        pendingCancel: Boolean? = null
    ): VKRequest<BaseBoolIntDto> = NewApiRequest("orders.cancelSubscription") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
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
        action: OrdersChangeStateActionDto,
        appOrderId: Int? = null,
        testMode: Boolean? = null
    ): VKRequest<String> = NewApiRequest("orders.changeState") {
        GsonHolder.gson.parse<String>(it)
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
    ): VKRequest<List<OrdersOrderDto>> = NewApiRequest("orders.get") {
        GsonHolder.gson.parseList<OrdersOrderDto>(it)
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
    fun ordersGetAmount(userId: UserId, votes: List<String>): VKRequest<List<OrdersAmountDto>> =
            NewApiRequest("orders.getAmount") {
        GsonHolder.gson.parseList<OrdersAmountDto>(it)
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
    ): VKRequest<List<OrdersOrderDto>> = NewApiRequest("orders.getById") {
        GsonHolder.gson.parseList<OrdersOrderDto>(it)
    }
    .apply {
        orderId?.let { addParam("order_id", it, min = 0) }
        orderIds?.let { addParam("order_ids", it) }
        testMode?.let { addParam("test_mode", it) }
    }

    /**
     * @param userId
     * @param subscriptionId
     * @return [VKRequest] with [OrdersSubscriptionDto]
     */
    fun ordersGetUserSubscriptionById(userId: UserId, subscriptionId: Int):
            VKRequest<OrdersSubscriptionDto> = NewApiRequest("orders.getUserSubscriptionById") {
        GsonHolder.gson.parse<OrdersSubscriptionDto>(it)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("subscription_id", subscriptionId, min = 0)
    }

    /**
     * @param userId
     * @return [VKRequest] with [OrdersGetUserSubscriptionsResponseDto]
     */
    fun ordersGetUserSubscriptions(userId: UserId): VKRequest<OrdersGetUserSubscriptionsResponseDto>
            = NewApiRequest("orders.getUserSubscriptions") {
        GsonHolder.gson.parse<OrdersGetUserSubscriptionsResponseDto>(it)
    }
    .apply {
        addParam("user_id", userId, min = 1)
    }

    /**
     * @param userId
     * @param subscriptionId
     * @param price
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun ordersUpdateSubscription(
        userId: UserId,
        subscriptionId: Int,
        price: Int
    ): VKRequest<BaseBoolIntDto> = NewApiRequest("orders.updateSubscription") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("subscription_id", subscriptionId, min = 0)
        addParam("price", price, min = 0)
    }

    object OrdersCancelSubscriptionRestrictions {
        const val USER_ID_MIN: Long = 1

        const val SUBSCRIPTION_ID_MIN: Long = 0
    }

    object OrdersChangeStateRestrictions {
        const val ORDER_ID_MIN: Long = 0

        const val APP_ORDER_ID_MIN: Long = 0
    }

    object OrdersGetRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object OrdersGetAmountRestrictions {
        const val USER_ID_MIN: Long = 1
    }

    object OrdersGetByIdRestrictions {
        const val ORDER_ID_MIN: Long = 0
    }

    object OrdersGetUserSubscriptionByIdRestrictions {
        const val USER_ID_MIN: Long = 1

        const val SUBSCRIPTION_ID_MIN: Long = 0
    }

    object OrdersGetUserSubscriptionsRestrictions {
        const val USER_ID_MIN: Long = 1
    }

    object OrdersUpdateSubscriptionRestrictions {
        const val USER_ID_MIN: Long = 1

        const val SUBSCRIPTION_ID_MIN: Long = 0

        const val PRICE_MIN: Long = 0
    }
}
