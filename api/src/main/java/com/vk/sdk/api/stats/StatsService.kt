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
package com.vk.sdk.api.stats

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.stats.dto.StatsGetIntervalDto
import com.vk.sdk.api.stats.dto.StatsPeriodDto
import com.vk.sdk.api.stats.dto.StatsWallpostStatDto
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class StatsService {
    /**
     * Returns statistics of a community or an application.
     *
     * @param groupId - Community ID.
     * @param appId - Application ID.
     * @param timestampFrom
     * @param timestampTo
     * @param interval
     * @param intervalsCount
     * @param filters
     * @param statsGroups
     * @param extended
     * @return [VKRequest] with [Unit]
     */
    fun statsGet(
        groupId: UserId? = null,
        appId: Int? = null,
        timestampFrom: Int? = null,
        timestampTo: Int? = null,
        interval: StatsGetIntervalDto? = null,
        intervalsCount: Int? = null,
        filters: List<String>? = null,
        statsGroups: List<String>? = null,
        extended: Boolean? = null
    ): VKRequest<List<StatsPeriodDto>> = NewApiRequest("stats.get") {
        GsonHolder.gson.parseList<StatsPeriodDto>(it)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 0) }
        appId?.let { addParam("app_id", it, min = 0) }
        timestampFrom?.let { addParam("timestamp_from", it, min = 0) }
        timestampTo?.let { addParam("timestamp_to", it, min = 0) }
        interval?.let { addParam("interval", it.value) }
        intervalsCount?.let { addParam("intervals_count", it, min = 0) }
        filters?.let { addParam("filters", it) }
        statsGroups?.let { addParam("stats_groups", it) }
        extended?.let { addParam("extended", it) }
    }

    /**
     * Returns stats for a wall post.
     *
     * @param ownerId - post owner community id. Specify with "-" sign.
     * @param postIds - wall posts id
     * @return [VKRequest] with [Unit]
     */
    fun statsGetPostReach(ownerId: Long, postIds: List<Long>): VKRequest<List<StatsWallpostStatDto>>
            = NewApiRequest("stats.getPostReach") {
        GsonHolder.gson.parseList<StatsWallpostStatDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("post_ids", postIds)
    }

    /**
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun statsTrackVisitor(): VKRequest<BaseOkResponseDto> = NewApiRequest("stats.trackVisitor") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }

    object StatsGetRestrictions {
        const val GROUP_ID_MIN: Long = 0

        const val APP_ID_MIN: Long = 0

        const val TIMESTAMP_FROM_MIN: Long = 0

        const val TIMESTAMP_TO_MIN: Long = 0

        const val INTERVALS_COUNT_MIN: Long = 0
    }
}
