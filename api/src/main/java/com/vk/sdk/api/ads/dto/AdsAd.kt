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
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Int
import kotlin.String

/**
 * @param adFormat - Ad format
 * @param allLimit - Total limit
 * @param approved
 * @param campaignId - Campaign ID
 * @param costType
 * @param id - Ad ID
 * @param name - Ad title
 * @param status
 * @param adPlatform - Ad platform
 * @param category1Id - Category ID
 * @param category2Id - Additional category ID
 * @param cpc - Cost of a click, kopecks
 * @param cpm - Cost of 1000 impressions, kopecks
 * @param cpa - Cost of an action, kopecks
 * @param ocpm - Cost of 1000 impressions optimized, kopecks
 * @param autobiddingMaxCost - Max cost of target actions for autobidding, kopecks
 * @param disclaimerMedical - Information whether disclaimer is enabled
 * @param disclaimerSpecialist - Information whether disclaimer is enabled
 * @param disclaimerSupplements - Information whether disclaimer is enabled
 * @param impressionsLimit - Impressions limit
 * @param impressionsLimited - Information whether impressions are limited
 * @param video - Information whether the ad is a video
 */
data class AdsAd(
    @SerializedName("ad_format")
    val adFormat: Int,
    @SerializedName("all_limit")
    val allLimit: Int,
    @SerializedName("approved")
    val approved: AdsAdApproved,
    @SerializedName("campaign_id")
    val campaignId: Int,
    @SerializedName("cost_type")
    val costType: AdsAdCostType,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: AdsAdStatus,
    @SerializedName("ad_platform")
    val adPlatform: Int? = null,
    @SerializedName("category1_id")
    val category1Id: Int? = null,
    @SerializedName("category2_id")
    val category2Id: Int? = null,
    @SerializedName("cpc")
    val cpc: Int? = null,
    @SerializedName("cpm")
    val cpm: Int? = null,
    @SerializedName("cpa")
    val cpa: Int? = null,
    @SerializedName("ocpm")
    val ocpm: Int? = null,
    @SerializedName("autobidding_max_cost")
    val autobiddingMaxCost: Int? = null,
    @SerializedName("disclaimer_medical")
    val disclaimerMedical: BaseBoolInt? = null,
    @SerializedName("disclaimer_specialist")
    val disclaimerSpecialist: BaseBoolInt? = null,
    @SerializedName("disclaimer_supplements")
    val disclaimerSupplements: BaseBoolInt? = null,
    @SerializedName("impressions_limit")
    val impressionsLimit: Int? = null,
    @SerializedName("impressions_limited")
    val impressionsLimited: BaseBoolInt? = null,
    @SerializedName("video")
    val video: BaseBoolInt? = null
)
