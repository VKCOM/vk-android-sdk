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
package com.vk.sdk.api.donut

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseUserGroupFieldsDto
import com.vk.sdk.api.donut.dto.DonutDonatorSubscriptionInfoDto
import com.vk.sdk.api.donut.dto.DonutGetSubscriptionsResponseDto
import com.vk.sdk.api.groups.dto.GroupsGetMembersFieldsResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class DonutService {
    /**
     * @param ownerId
     * @param offset
     * @param count
     * @param fields
     * @return [VKRequest] with [GroupsGetMembersFieldsResponseDto]
     */
    fun donutGetFriends(
        ownerId: UserId,
        offset: Int? = null,
        count: Int? = null,
        fields: List<String>? = null
    ): VKRequest<GroupsGetMembersFieldsResponseDto> = NewApiRequest("donut.getFriends") {
        GsonHolder.gson.parse<GroupsGetMembersFieldsResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        fields?.let { addParam("fields", it) }
    }

    /**
     * @param ownerId
     * @return [VKRequest] with [DonutDonatorSubscriptionInfoDto]
     */
    fun donutGetSubscription(ownerId: UserId): VKRequest<DonutDonatorSubscriptionInfoDto> =
            NewApiRequest("donut.getSubscription") {
        GsonHolder.gson.parse<DonutDonatorSubscriptionInfoDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
    }

    /**
     * Returns a list of user's VK Donut subscriptions.
     *
     * @param fields
     * @param offset
     * @param count
     * @return [VKRequest] with [DonutGetSubscriptionsResponseDto]
     */
    fun donutGetSubscriptions(
        fields: List<BaseUserGroupFieldsDto>? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DonutGetSubscriptionsResponseDto> = NewApiRequest("donut.getSubscriptions") {
        GsonHolder.gson.parse<DonutGetSubscriptionsResponseDto>(it)
    }
    .apply {
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
    }

    /**
     * @param ownerId
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun donutIsDon(ownerId: UserId): VKRequest<BaseBoolIntDto> = NewApiRequest("donut.isDon") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
    }

    object DonutGetFriendsRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object DonutGetSubscriptionsRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }
}
