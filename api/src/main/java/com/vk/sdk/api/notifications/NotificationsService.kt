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
package com.vk.sdk.api.notifications

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.notifications.dto.NotificationsGetFilters
import com.vk.sdk.api.notifications.dto.NotificationsGetResponse
import com.vk.sdk.api.notifications.dto.NotificationsSendMessageItem
import com.vk.sdk.api.notifications.dto.NotificationsSendMessageSendingMode
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class NotificationsService {
    /**
     * Returns a list of notifications about other users' feedback to the current user's wall posts.
     *
     * @param count - Number of notifications to return.
     * @param startFrom
     * @param filters - Type of notifications to return_ 'wall' - wall posts, 'mentions' - mentions
     * in wall posts, comments, or topics, 'comments' - comments to wall posts, photos, and videos,
     * 'likes' - likes, 'reposted' - wall posts that are copied from the current user's wall,
     * 'followers' - new followers, 'friends' - accepted friend requests
     * @param startTime - Earliest timestamp (in Unix time) of a notification to return. By default,
     * 24 hours ago.
     * @param endTime - Latest timestamp (in Unix time) of a notification to return. By default, the
     * current time.
     * @return [VKRequest] with [NotificationsGetResponse]
     */
    fun notificationsGet(
        count: Int? = null,
        startFrom: String? = null,
        filters: List<NotificationsGetFilters>? = null,
        startTime: Int? = null,
        endTime: Int? = null
    ): VKRequest<NotificationsGetResponse> = NewApiRequest("notifications.get") {
        GsonHolder.gson.fromJson(it, NotificationsGetResponse::class.java)
    }
    .apply {
        count?.let { addParam("count", it, min = 1, max = 100) }
        startFrom?.let { addParam("start_from", it) }
        val filtersJsonConverted = filters?.map {
            it.value
        }
        filtersJsonConverted?.let { addParam("filters", it) }
        startTime?.let { addParam("start_time", it) }
        endTime?.let { addParam("end_time", it) }
    }

    /**
     * Resets the counter of new notifications about other users' feedback to the current user's
     * wall posts.
     *
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun notificationsMarkAsViewed(): VKRequest<BaseBoolInt> =
            NewApiRequest("notifications.markAsViewed") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }

    /**
     * @param userIds
     * @param message
     * @param fragment
     * @param groupId
     * @param randomId
     * @param sendingMode - Type of sending (delivering) notifications_ 'immediately' - push and
     * bell notifications will be delivered as soon as possible, 'delayed' - push and bell
     * notifications will be delivered in the most comfortable time for the user, 'delayed_push' - only
     * push notifications will be delivered in the most comfortable time, while the bell notifications
     * will be delivered as soon as possible
     * @return [VKRequest] with [Unit]
     */
    fun notificationsSendMessage(
        userIds: List<Int>,
        message: String,
        fragment: String? = null,
        groupId: UserId? = null,
        randomId: Int? = null,
        sendingMode: NotificationsSendMessageSendingMode? = null
    ): VKRequest<List<NotificationsSendMessageItem>> = NewApiRequest("notifications.sendMessage") {
        val typeToken = object: TypeToken<List<NotificationsSendMessageItem>>() {}.type
        GsonHolder.gson.fromJson<List<NotificationsSendMessageItem>>(it, typeToken)
    }
    .apply {
        addParam("user_ids", userIds)
        addParam("message", message, maxLength = 254)
        fragment?.let { addParam("fragment", it, maxLength = 2047) }
        groupId?.let { addParam("group_id", it, min = 0) }
        randomId?.let { addParam("random_id", it) }
        sendingMode?.let { addParam("sending_mode", it.value) }
    }
}
