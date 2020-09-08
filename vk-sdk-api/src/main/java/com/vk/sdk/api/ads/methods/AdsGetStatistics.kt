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
package com.vk.sdk.api.ads.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.ads.dto.AdsGetStatisticsIdsType
import com.vk.sdk.api.ads.dto.AdsGetStatisticsPeriod
import com.vk.sdk.api.ads.dto.AdsGetStatisticsStatsFields
import com.vk.sdk.api.ads.dto.AdsStats
import com.vk.sdk.api.ads.responses.AdsGetStatisticsResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns statistics of performance indicators for ads, campaigns, clients or the whole account.
 * @param accountId Advertising account ID. 
 * @param idsType Type of requested objects listed in 'ids' parameter: *ad � ads,, *campaign �
 * campaigns,, *client � clients,, *office � account. 
 * @param ids IDs requested ads, campaigns, clients or account, separated with a comma, depending on
 * the value set in 'ids_type'. Maximum 2000 objects. 
 * @param period Data grouping by dates: *day � statistics by days,, *month � statistics by months,,
 * *overall � overall statistics. 'date_from' and 'date_to' parameters set temporary limits. 
 * @param dateFrom Date to show statistics from. For different value of 'period' different date
 * format is used: *day: YYYY-MM-DD, example: 2011-09-27 � September 27, 2011, **0 � day it was created
 * on,, *month: YYYY-MM, example: 2011-09 � September 2011, **0 � month it was created in,, *overall:
 * 0. 
 * @param dateTo Date to show statistics to. For different value of 'period' different date format
 * is used: *day: YYYY-MM-DD, example: 2011-09-27 � September 27, 2011, **0 � current day,, *month:
 * YYYY-MM, example: 2011-09 � September 2011, **0 � current month,, *overall: 0. 
 * @param statsFields Additional fields to add to statistics 
 */
class AdsGetStatistics(
    private val accountId: Int,
    private val idsType: AdsGetStatisticsIdsType,
    private val ids: String,
    private val period: AdsGetStatisticsPeriod,
    private val dateFrom: String,
    private val dateTo: String,
    private val statsFields: List<AdsGetStatisticsStatsFields>? = null
) : VKRequest<List<AdsStats>>("ads.getStatistics") {
    init {
        addParam("account_id", accountId)
        addParam("ids_type", idsType.value)
        addParam("ids", ids)
        addParam("period", period.value)
        addParam("date_from", dateFrom)
        addParam("date_to", dateTo)
        statsFields?.let { value ->
            addParam("stats_fields", value.map { it.value })
        }
    }

    override fun parse(r: JSONObject): List<AdsStats> = GsonHolder.gson.fromJson(r.toString(),
            AdsGetStatisticsResponse::class.java).response
}
