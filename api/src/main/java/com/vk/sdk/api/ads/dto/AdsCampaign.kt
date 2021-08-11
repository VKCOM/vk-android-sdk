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
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * @param allLimit - Campaign's total limit, rubles
 * @param dayLimit - Campaign's day limit, rubles
 * @param id - Campaign ID
 * @param name - Campaign title
 * @param startTime - Campaign start time, as Unixtime
 * @param status
 * @param stopTime - Campaign stop time, as Unixtime
 * @param type
 * @param adsCount - Amount of active ads in campaign
 * @param createTime - Campaign create time, as Unixtime
 * @param goalType - Campaign goal type
 * @param userGoalType - Campaign user goal type
 * @param isCboEnabled - Shows if Campaign Budget Optimization is on
 * @param updateTime - Campaign update time, as Unixtime
 * @param viewsLimit - Limit of views per user per campaign
 */
data class AdsCampaign(
    @SerializedName("all_limit")
    val allLimit: String,
    @SerializedName("day_limit")
    val dayLimit: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("start_time")
    val startTime: Int,
    @SerializedName("status")
    val status: AdsCampaignStatus,
    @SerializedName("stop_time")
    val stopTime: Int,
    @SerializedName("type")
    val type: AdsCampaignType,
    @SerializedName("ads_count")
    val adsCount: Int? = null,
    @SerializedName("create_time")
    val createTime: Int? = null,
    @SerializedName("goal_type")
    val goalType: Int? = null,
    @SerializedName("user_goal_type")
    val userGoalType: Int? = null,
    @SerializedName("is_cbo_enabled")
    val isCboEnabled: Boolean? = null,
    @SerializedName("update_time")
    val updateTime: Int? = null,
    @SerializedName("views_limit")
    val viewsLimit: Int? = null
)
