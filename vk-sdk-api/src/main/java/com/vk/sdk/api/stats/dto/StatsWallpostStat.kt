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
 * @param postId no description
 * @param hide Hidings number
 * @param joinGroup People have joined the group
 * @param links Link clickthrough
 * @param reachSubscribers Subscribers reach
 * @param reachSubscribersCount no description
 * @param reachTotal Total reach
 * @param reachTotalCount no description
 * @param reachViral no description
 * @param reachAds no description
 * @param report Reports number
 * @param toGroup Clickthrough to community
 * @param unsubscribe Unsubscribed members
 * @param sexAge no description
 */
data class StatsWallpostStat(
    @SerializedName(value="post_id")
    val postId: Int? = null,
    @SerializedName(value="hide")
    val hide: Int? = null,
    @SerializedName(value="join_group")
    val joinGroup: Int? = null,
    @SerializedName(value="links")
    val links: Int? = null,
    @SerializedName(value="reach_subscribers")
    val reachSubscribers: Int? = null,
    @SerializedName(value="reach_subscribers_count")
    val reachSubscribersCount: Int? = null,
    @SerializedName(value="reach_total")
    val reachTotal: Int? = null,
    @SerializedName(value="reach_total_count")
    val reachTotalCount: Int? = null,
    @SerializedName(value="reach_viral")
    val reachViral: Int? = null,
    @SerializedName(value="reach_ads")
    val reachAds: Int? = null,
    @SerializedName(value="report")
    val report: Int? = null,
    @SerializedName(value="to_group")
    val toGroup: Int? = null,
    @SerializedName(value="unsubscribe")
    val unsubscribe: Int? = null,
    @SerializedName(value="sex_age")
    val sexAge: List<StatsSexAge>? = null
)
