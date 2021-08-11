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
package com.vk.sdk.api.ads.dto

import com.google.gson.annotations.SerializedName
import kotlin.Int

/**
 * @param hide - Hides amount
 * @param id - Object ID from 'ids' parameter
 * @param joinGroup - Community joins
 * @param links - Link clicks
 * @param reachSubscribers - Subscribers reach
 * @param reachTotal - Total reach
 * @param report - Reports amount
 * @param toGroup - Community clicks
 * @param unsubscribe - 'Unsubscribe' events amount
 * @param videoViews100p - Video views for 100 percent
 * @param videoViews25p - Video views for 25 percent
 * @param videoViews3s - Video views for 3 seconds
 * @param videoViews50p - Video views for 50 percent
 * @param videoViews75p - Video views for 75 percent
 * @param videoViewsStart - Video starts
 */
data class AdsPromotedPostReach(
    @SerializedName("hide")
    val hide: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("join_group")
    val joinGroup: Int,
    @SerializedName("links")
    val links: Int,
    @SerializedName("reach_subscribers")
    val reachSubscribers: Int,
    @SerializedName("reach_total")
    val reachTotal: Int,
    @SerializedName("report")
    val report: Int,
    @SerializedName("to_group")
    val toGroup: Int,
    @SerializedName("unsubscribe")
    val unsubscribe: Int,
    @SerializedName("video_views_100p")
    val videoViews100p: Int? = null,
    @SerializedName("video_views_25p")
    val videoViews25p: Int? = null,
    @SerializedName("video_views_3s")
    val videoViews3s: Int? = null,
    @SerializedName("video_views_50p")
    val videoViews50p: Int? = null,
    @SerializedName("video_views_75p")
    val videoViews75p: Int? = null,
    @SerializedName("video_views_start")
    val videoViewsStart: Int? = null
)
