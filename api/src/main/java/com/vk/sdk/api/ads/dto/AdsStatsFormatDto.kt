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
import kotlin.collections.List

/**
 * @param clicks - Clicks number
 * @param linkExternalClicks - External clicks number
 * @param day - Day as YYYY-MM-DD
 * @param impressions - Impressions number
 * @param joinRate - Events number
 * @param month - Month as YYYY-MM
 * @param year - Year as YYYY
 * @param overall - 1 if period=overall
 * @param reach - Reach 
 * @param spent - Spent funds
 * @param videoPlaysUniqueStarted - Video plays unique started count
 * @param videoPlaysUnique3Seconds - Video plays unique 3 seconds count
 * @param videoPlaysUnique10Seconds - Video plays unique 10 seconds count
 * @param videoPlaysUnique25Percents - Video plays unique 25 percents count
 * @param videoPlaysUnique50Percents - Video plays unique 50 percents count
 * @param videoPlaysUnique75Percents - Video plays unique 75 percents count
 * @param videoPlaysUnique100Percents - Video plays unique 100 percents count
 * @param effectiveCostPerClick - Effective cost per click
 * @param effectiveCostPerMille - Effective cost per mille
 * @param effectiveCpf - Effective cpf
 * @param effectiveCostPerMessage - Effective cost per message
 * @param messageSends - Message sends count
 * @param messageSendsByAnyUser - Message sends by anu user
 * @param conversionsExternal - Conversions external
 * @param conversionCount - Conversions count
 * @param conversionCr - Conversions CR
 * @param dayFrom - Day from
 * @param dayTo - Day to
 * @param ctr - Ctr
 * @param uniqViewsCount - Unique views count
 * @param mobileAppStat - Mobile app stat
 */
data class AdsStatsFormatDto(
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
    @SerializedName("year")
    val year: Int? = null,
    @SerializedName("overall")
    val overall: Int? = null,
    @SerializedName("reach")
    val reach: Int? = null,
    @SerializedName("spent")
    val spent: String? = null,
    @SerializedName("video_plays_unique_started")
    val videoPlaysUniqueStarted: Int? = null,
    @SerializedName("video_plays_unique_3_seconds")
    val videoPlaysUnique3Seconds: Int? = null,
    @SerializedName("video_plays_unique_10_seconds")
    val videoPlaysUnique10Seconds: Int? = null,
    @SerializedName("video_plays_unique_25_percents")
    val videoPlaysUnique25Percents: Int? = null,
    @SerializedName("video_plays_unique_50_percents")
    val videoPlaysUnique50Percents: Int? = null,
    @SerializedName("video_plays_unique_75_percents")
    val videoPlaysUnique75Percents: Int? = null,
    @SerializedName("video_plays_unique_100_percents")
    val videoPlaysUnique100Percents: Int? = null,
    @SerializedName("effective_cost_per_click")
    val effectiveCostPerClick: String? = null,
    @SerializedName("effective_cost_per_mille")
    val effectiveCostPerMille: String? = null,
    @SerializedName("effective_cpf")
    val effectiveCpf: String? = null,
    @SerializedName("effective_cost_per_message")
    val effectiveCostPerMessage: String? = null,
    @SerializedName("message_sends")
    val messageSends: Int? = null,
    @SerializedName("message_sends_by_any_user")
    val messageSendsByAnyUser: Int? = null,
    @SerializedName("conversions_external")
    val conversionsExternal: Int? = null,
    @SerializedName("conversion_count")
    val conversionCount: Int? = null,
    @SerializedName("conversion_cr")
    val conversionCr: String? = null,
    @SerializedName("day_from")
    val dayFrom: String? = null,
    @SerializedName("day_to")
    val dayTo: String? = null,
    @SerializedName("ctr")
    val ctr: String? = null,
    @SerializedName("uniq_views_count")
    val uniqViewsCount: Int? = null,
    @SerializedName("mobile_app_stat")
    val mobileAppStat: List<AdsMobileStatItemDto>? = null
)
