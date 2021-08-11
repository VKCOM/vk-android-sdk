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
import kotlin.String

/**
 * @param clicks - Clicks number
 * @param linkExternalClicks - External clicks number
 * @param day - Day as YYYY-MM-DD
 * @param impressions - Impressions number
 * @param joinRate - Events number
 * @param month - Month as YYYY-MM
 * @param overall - 1 if period=overall
 * @param reach - Reach 
 * @param spent - Spent funds
 * @param videoClicksSite - Clickthoughs to the advertised site
 * @param videoViews - Video views number
 * @param videoViewsFull - Video views (full video)
 * @param videoViewsHalf - Video views (half of video)
 */
data class AdsStatsFormat(
    @SerializedName("clicks")
    val clicks: Int? = null,
    @SerializedName("link_external_clicks")
    val linkExternalClicks: Int? = null,
    @SerializedName("day")
    val day: String? = null,
    @SerializedName("impressions")
    val impressions: Int? = null,
    @SerializedName("join_rate")
    val joinRate: Int? = null,
    @SerializedName("month")
    val month: String? = null,
    @SerializedName("overall")
    val overall: Int? = null,
    @SerializedName("reach")
    val reach: Int? = null,
    @SerializedName("spent")
    val spent: Int? = null,
    @SerializedName("video_clicks_site")
    val videoClicksSite: Int? = null,
    @SerializedName("video_views")
    val videoViews: Int? = null,
    @SerializedName("video_views_full")
    val videoViewsFull: Int? = null,
    @SerializedName("video_views_half")
    val videoViewsHalf: Int? = null
)
