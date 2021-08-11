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
package com.vk.sdk.api.stats.dto

import com.google.gson.annotations.SerializedName
import kotlin.Int
import kotlin.collections.List

/**
 * @param postId
 * @param hide - Hidings number
 * @param joinGroup - People have joined the group
 * @param links - Link clickthrough
 * @param reachSubscribers - Subscribers reach
 * @param reachSubscribersCount
 * @param reachTotal - Total reach
 * @param reachTotalCount
 * @param reachViral
 * @param reachAds
 * @param report - Reports number
 * @param toGroup - Clickthrough to community
 * @param unsubscribe - Unsubscribed members
 * @param sexAge
 */
data class StatsWallpostStat(
    @SerializedName("post_id")
    val postId: Int? = null,
    @SerializedName("hide")
    val hide: Int? = null,
    @SerializedName("join_group")
    val joinGroup: Int? = null,
    @SerializedName("links")
    val links: Int? = null,
    @SerializedName("reach_subscribers")
    val reachSubscribers: Int? = null,
    @SerializedName("reach_subscribers_count")
    val reachSubscribersCount: Int? = null,
    @SerializedName("reach_total")
    val reachTotal: Int? = null,
    @SerializedName("reach_total_count")
    val reachTotalCount: Int? = null,
    @SerializedName("reach_viral")
    val reachViral: Int? = null,
    @SerializedName("reach_ads")
    val reachAds: Int? = null,
    @SerializedName("report")
    val report: Int? = null,
    @SerializedName("to_group")
    val toGroup: Int? = null,
    @SerializedName("unsubscribe")
    val unsubscribe: Int? = null,
    @SerializedName("sex_age")
    val sexAge: List<StatsSexAge>? = null
)
