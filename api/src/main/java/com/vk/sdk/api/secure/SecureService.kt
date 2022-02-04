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
package com.vk.sdk.api.secure

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.secure.dto.SecureGiveEventStickerItem
import com.vk.sdk.api.secure.dto.SecureLevel
import com.vk.sdk.api.secure.dto.SecureSmsNotification
import com.vk.sdk.api.secure.dto.SecureTokenChecked
import com.vk.sdk.api.secure.dto.SecureTransaction
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class SecureService {
    /**
     * Adds user activity information to an application
     *
     * @param userId - ID of a user to save the data
     * @param activityId - there are 2 default activities_ , * 1 - level. Works similar to ,, * 2 -
     * points, saves points amount, Any other value is for saving completed missions
     * @param value - depends on activity_id_ * 1 - number, current level number,, * 2 - number,
     * current user's points amount, , Any other value is ignored
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun secureAddAppEvent(
        userId: UserId,
        activityId: Int,
        value: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("secure.addAppEvent") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("activity_id", activityId, min = 0)
        value?.let { addParam("value", it, min = 0) }
    }

    /**
     * Checks the user authentication in 'IFrame' and 'Flash' apps using the 'access_token'
     * parameter.
     *
     * @param token - client 'access_token'
     * @param ip - user 'ip address'. Note that user may access using the 'ipv6' address, in this
     * case it is required to transmit the 'ipv6' address. If not transmitted, the address will not be
     * checked.
     * @return [VKRequest] with [SecureTokenChecked]
     */
    fun secureCheckToken(token: String? = null, ip: String? = null): VKRequest<SecureTokenChecked> =
            NewApiRequest("secure.checkToken") {
        GsonHolder.gson.fromJson(it, SecureTokenChecked::class.java)
    }
    .apply {
        token?.let { addParam("token", it) }
        ip?.let { addParam("ip", it) }
    }

    /**
     * Returns payment balance of the application in hundredth of a vote.
     *
     * @return [VKRequest] with [Int]
     */
    fun secureGetAppBalance(): VKRequest<Int> = NewApiRequest("secure.getAppBalance") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }

    /**
     * Shows a list of SMS notifications sent by the application using
     * [vk.com/dev/secure.sendSMSNotification|secure.sendSMSNotification] method.
     *
     * @param userId
     * @param dateFrom - filter by start date. It is set as UNIX-time.
     * @param dateTo - filter by end date. It is set as UNIX-time.
     * @param limit - number of returned posts. By default - 1000.
     * @return [VKRequest] with [Unit]
     */
    fun secureGetSMSHistory(
        userId: UserId? = null,
        dateFrom: Int? = null,
        dateTo: Int? = null,
        limit: Int? = null
    ): VKRequest<List<SecureSmsNotification>> = NewApiRequest("secure.getSMSHistory") {
        val typeToken = object: TypeToken<List<SecureSmsNotification>>() {}.type
        GsonHolder.gson.fromJson<List<SecureSmsNotification>>(it, typeToken)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        dateFrom?.let { addParam("date_from", it, min = 0) }
        dateTo?.let { addParam("date_to", it, min = 0) }
        limit?.let { addParam("limit", it, min = 0, max = 1000) }
    }

    /**
     * Shows history of votes transaction between users and the application.
     *
     * @param type
     * @param uidFrom
     * @param uidTo
     * @param dateFrom
     * @param dateTo
     * @param limit
     * @return [VKRequest] with [Unit]
     */
    fun secureGetTransactionsHistory(
        type: Int? = null,
        uidFrom: UserId? = null,
        uidTo: UserId? = null,
        dateFrom: Int? = null,
        dateTo: Int? = null,
        limit: Int? = null
    ): VKRequest<List<SecureTransaction>> = NewApiRequest("secure.getTransactionsHistory") {
        val typeToken = object: TypeToken<List<SecureTransaction>>() {}.type
        GsonHolder.gson.fromJson<List<SecureTransaction>>(it, typeToken)
    }
    .apply {
        type?.let { addParam("type", it) }
        uidFrom?.let { addParam("uid_from", it, min = 1) }
        uidTo?.let { addParam("uid_to", it, min = 1) }
        dateFrom?.let { addParam("date_from", it, min = 0) }
        dateTo?.let { addParam("date_to", it, min = 0) }
        limit?.let { addParam("limit", it, min = 0, max = 1000) }
    }

    /**
     * Returns one of the previously set game levels of one or more users in the application.
     *
     * @param userIds
     * @return [VKRequest] with [Unit]
     */
    fun secureGetUserLevel(userIds: List<UserId>): VKRequest<List<SecureLevel>> =
            NewApiRequest("secure.getUserLevel") {
        val typeToken = object: TypeToken<List<SecureLevel>>() {}.type
        GsonHolder.gson.fromJson<List<SecureLevel>>(it, typeToken)
    }
    .apply {
        addParam("user_ids", userIds)
    }

    /**
     * Opens the game achievement and gives the user a sticker
     *
     * @param userIds
     * @param achievementId
     * @return [VKRequest] with [Unit]
     */
    fun secureGiveEventSticker(userIds: List<UserId>, achievementId: Int):
            VKRequest<List<SecureGiveEventStickerItem>> = NewApiRequest("secure.giveEventSticker") {
        val typeToken = object: TypeToken<List<SecureGiveEventStickerItem>>() {}.type
        GsonHolder.gson.fromJson<List<SecureGiveEventStickerItem>>(it, typeToken)
    }
    .apply {
        addParam("user_ids", userIds)
        addParam("achievement_id", achievementId, min = 0)
    }

    /**
     * Sends notification to the user.
     *
     * @param message - notification text which should be sent in 'UTF-8' encoding ('254' characters
     * maximum).
     * @param userIds
     * @param userId
     * @return [VKRequest] with [Unit]
     */
    fun secureSendNotification(
        message: String,
        userIds: List<UserId>? = null,
        userId: UserId? = null
    ): VKRequest<List<UserId>> = NewApiRequest("secure.sendNotification") {
        val typeToken = object: TypeToken<List<UserId>>() {}.type
        GsonHolder.gson.fromJson<List<UserId>>(it, typeToken)
    }
    .apply {
        addParam("message", message)
        userIds?.let { addParam("user_ids", it) }
        userId?.let { addParam("user_id", it, min = 0) }
    }

    /**
     * Sends 'SMS' notification to a user's mobile device.
     *
     * @param userId - ID of the user to whom SMS notification is sent. The user shall allow the
     * application to send him/her notifications (, +1).
     * @param message - 'SMS' text to be sent in 'UTF-8' encoding. Only Latin letters and numbers
     * are allowed. Maximum size is '160' characters.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun secureSendSMSNotification(userId: UserId, message: String): VKRequest<BaseOkResponse> =
            NewApiRequest("secure.sendSMSNotification") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("message", message)
    }

    /**
     * Sets a counter which is shown to the user in bold in the left menu.
     *
     * @param counters
     * @param userId
     * @param counter - counter value.
     * @param increment
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun secureSetCounter(
        counters: List<String>? = null,
        userId: UserId? = null,
        counter: Int? = null,
        increment: Boolean? = null
    ): VKRequest<BaseBoolInt> = NewApiRequest("secure.setCounter") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        counters?.let { addParam("counters", it) }
        userId?.let { addParam("user_id", it, min = 0) }
        counter?.let { addParam("counter", it) }
        increment?.let { addParam("increment", it) }
    }
}
