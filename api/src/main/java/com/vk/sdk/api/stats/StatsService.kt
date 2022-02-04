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

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.stats.dto.StatsGetInterval
import com.vk.sdk.api.stats.dto.StatsPeriod
import com.vk.sdk.api.stats.dto.StatsWallpostStat
import kotlin.Int
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
     * @return [VKRequest] with [Unit]
     */
    fun statsGet(
        groupId: UserId? = null,
        appId: Int? = null,
        timestampFrom: Int? = null,
        timestampTo: Int? = null,
        interval: StatsGetInterval? = null,
        intervalsCount: Int? = null,
        filters: List<String>? = null,
        statsGroups: List<String>? = null
    ): VKRequest<List<StatsPeriod>> = NewApiRequest("stats.get") {
        val typeToken = object: TypeToken<List<StatsPeriod>>() {}.type
        GsonHolder.gson.fromJson<List<StatsPeriod>>(it, typeToken)
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
    }

    /**
     * Returns stats for a wall post.
     *
     * @param ownerId - post owner community id. Specify with "-" sign.
     * @param postIds - wall posts id
     * @return [VKRequest] with [Unit]
     */
    fun statsGetPostReach(ownerId: String, postIds: List<Int>): VKRequest<List<StatsWallpostStat>> =
            NewApiRequest("stats.getPostReach") {
        val typeToken = object: TypeToken<List<StatsWallpostStat>>() {}.type
        GsonHolder.gson.fromJson<List<StatsWallpostStat>>(it, typeToken)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("post_ids", postIds)
    }

    /**
     * @param id
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun statsTrackVisitor(id: String): VKRequest<BaseOkResponse> =
            NewApiRequest("stats.trackVisitor") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("id", id)
    }
}
