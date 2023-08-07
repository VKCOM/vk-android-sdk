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
package com.vk.sdk.api.status

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.status.dto.StatusStatusDto
import kotlin.Long
import kotlin.String

class StatusService {
    /**
     * Returns data required to show the status of a user or community.
     *
     * @param userId - User ID or community ID. Use a negative value to designate a community ID.
     * @param groupId
     * @return [VKRequest] with [StatusStatusDto]
     */
    fun statusGet(userId: UserId? = null, groupId: UserId? = null): VKRequest<StatusStatusDto> =
            NewApiRequest("status.get") {
        GsonHolder.gson.parse<StatusStatusDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Sets a new status for the current user.
     *
     * @param text - Text of the new status.
     * @param groupId - Identifier of a community to set a status in. If left blank the status is
     * set to current user.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun statusSet(text: String? = null, groupId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("status.set") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        text?.let { addParam("text", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    object StatusGetRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object StatusSetRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }
}
