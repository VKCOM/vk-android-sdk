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
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 * @param adFormat - Ad format
 * @param adPlatform - Ad platform
 * @param allLimit - Total limit
 * @param approved
 * @param campaignId - Campaign ID
 * @param costType
 * @param id - Ad ID
 * @param name - Ad title
 * @param status
 * @param category1Id - Category ID
 * @param category2Id - Additional category ID
 * @param cpc - Cost of a click, kopecks
 * @param cpm - Cost of 1000 impressions, kopecks
 * @param cpa - Cost of an action, kopecks
 * @param ocpm - Cost of 1000 impressions optimized, kopecks
 * @param autobidding - Autobidding
 * @param autobiddingMaxCost - Max cost of target actions for autobidding, kopecks
 * @param disclaimerMedical - Information whether disclaimer is enabled
 * @param disclaimerSpecialist - Information whether disclaimer is enabled
 * @param disclaimerSupplements - Information whether disclaimer is enabled
 * @param impressionsLimit - Impressions limit
 * @param impressionsLimitPeriod - Impressions limit period
 * @param impressionsLimited - Information whether impressions are limited
 * @param video - Information whether the ad is a video
 * @param dayLimit - Day limit
 * @param goalType - Goal type
 * @param userGoalType - User goal type
 * @param ageRestriction - Age restriction
 * @param conversionPixelId - Conversion pixel id
 * @param conversionEventId - Conversion event id
 * @param createTime - Create time
 * @param updateTime - Update time
 * @param startTime - Start time
 * @param stopTime - Stop time
 * @param publisherPlatformsAuto - Publisher platform auto
 * @param publisherPlatforms - Publisher platforms
 * @param linkUrl - Link url
 * @param linkOwnerId - Link owner id
 * @param linkId - Link id
 * @param hasCampaignBudgetOptimization - Has campaign budget optimization
 * @param eventsRetargetingGroups - Events retargeting groups
 * @param weeklyScheduleHours - Weekly schedule hours
 * @param weeklyScheduleUseHolidays - Weekly schedule use holidays
 * @param adPlatformNoAdNetwork - Ad platform no ad network
 * @param adPlatformNoWall - Ad platform no wall
 * @param disclaimerFinance - Disclaimer finance
 * @param disclaimerFinanceName - Disclaimer finance name
 * @param disclaimerFinanceLicenseNo - Disclaimer finance license no
 * @param isPromo - is promo
 * @param suggestedCriteria - Suggested criteria
 */
data class AdsAdDto(
    @SerializedName("ad_format")
    val adFormat: Int,
    @SerializedName("ad_platform")
    val adPlatform: Int,
    @SerializedName("all_limit")
    val allLimit: String,
    @SerializedName("approved")
    val approved: AdsAdApprovedDto,
    @SerializedName("campaign_id")
    val campaignId: Int,
    @SerializedName("cost_type")
    val costType: AdsAdCostTypeDto,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: AdsAdStatusDto,
    @SerializedName("category1_id")
    val category1Id: Int? = null,
    @SerializedName("category2_id")
    val category2Id: Int? = null,
    @SerializedName("cpc")
    val cpc: String? = null,
    @SerializedName("cpm")
    val cpm: String? = null,
    @SerializedName("cpa")
    val cpa: String? = null,
    @SerializedName("ocpm")
    val ocpm: String? = null,
    @SerializedName("autobidding")
    val autobidding: BaseBoolIntDto? = null,
    @SerializedName("autobidding_max_cost")
    val autobiddingMaxCost: String? = null,
    @SerializedName("disclaimer_medical")
    val disclaimerMedical: BaseBoolIntDto? = null,
    @SerializedName("disclaimer_specialist")
    val disclaimerSpecialist: BaseBoolIntDto? = null,
    @SerializedName("disclaimer_supplements")
    val disclaimerSupplements: BaseBoolIntDto? = null,
    @SerializedName("impressions_limit")
    val impressionsLimit: Int? = null,
    @SerializedName("impressions_limit_period")
    val impressionsLimitPeriod: Int? = null,
    @SerializedName("impressions_limited")
    val impressionsLimited: BaseBoolIntDto? = null,
    @SerializedName("video")
    val video: BaseBoolIntDto? = null,
    @SerializedName("day_limit")
    val dayLimit: String? = null,
    @SerializedName("goal_type")
    val goalType: Int? = null,
    @SerializedName("user_goal_type")
    val userGoalType: Int? = null,
    @SerializedName("age_restriction")
    val ageRestriction: Int? = null,
    @SerializedName("conversion_pixel_id")
    val conversionPixelId: Int? = null,
    @SerializedName("conversion_event_id")
    val conversionEventId: Int? = null,
    @SerializedName("create_time")
    val createTime: Int? = null,
    @SerializedName("update_time")
    val updateTime: Int? = null,
    @SerializedName("start_time")
    val startTime: Int? = null,
    @SerializedName("stop_time")
    val stopTime: Int? = null,
    @SerializedName("publisher_platforms_auto")
    val publisherPlatformsAuto: BaseBoolIntDto? = null,
    @SerializedName("publisher_platforms")
    val publisherPlatforms: String? = null,
    @SerializedName("link_url")
    val linkUrl: String? = null,
    @SerializedName("link_owner_id")
    val linkOwnerId: Long? = null,
    @SerializedName("link_id")
    val linkId: Int? = null,
    @SerializedName("has_campaign_budget_optimization")
    val hasCampaignBudgetOptimization: Boolean? = null,
    @SerializedName("events_retargeting_groups")
    val eventsRetargetingGroups: List<AdsEventsRetargetingGroupDto>? = null,
    @SerializedName("weekly_schedule_hours")
    val weeklyScheduleHours: List<String>? = null,
    @SerializedName("weekly_schedule_use_holidays")
    val weeklyScheduleUseHolidays: Int? = null,
    @SerializedName("ad_platform_no_ad_network")
    val adPlatformNoAdNetwork: Int? = null,
    @SerializedName("ad_platform_no_wall")
    val adPlatformNoWall: Int? = null,
    @SerializedName("disclaimer_finance")
    val disclaimerFinance: Int? = null,
    @SerializedName("disclaimer_finance_name")
    val disclaimerFinanceName: String? = null,
    @SerializedName("disclaimer_finance_license_no")
    val disclaimerFinanceLicenseNo: String? = null,
    @SerializedName("is_promo")
    val isPromo: Boolean? = null,
    @SerializedName("suggested_criteria")
    val suggestedCriteria: Int? = null
)
