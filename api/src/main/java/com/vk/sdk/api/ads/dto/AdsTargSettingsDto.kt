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
import kotlin.String

/**
 * @param id - Ad ID
 * @param campaignId - Campaign ID
 * @param ageFrom - Age from
 * @param ageTo - Age to
 * @param apps - Apps IDs
 * @param appsNot - Apps IDs to except
 * @param birthday - Days to birthday
 * @param cities - Cities IDs
 * @param citiesNot - Cities IDs to except
 * @param country - Country ID
 * @param districts - Districts IDs
 * @param groups - Communities IDs
 * @param interestCategories - Interests categories IDs
 * @param interests - Interests
 * @param paying - Information whether the user has proceeded VK payments before
 * @param positions - Positions IDs
 * @param religions - Religions IDs
 * @param retargetingGroups - Retargeting groups ids
 * @param retargetingGroupsNot - Retargeting groups NOT ids
 * @param schoolFrom - School graduation year from
 * @param schoolTo - School graduation year to
 * @param schools - Schools IDs
 * @param sex
 * @param stations - Stations IDs
 * @param statuses - Relationship statuses
 * @param streets - Streets IDs
 * @param travellers - Travellers
 * @param abTest - AB test
 * @param uniFrom - University graduation year from
 * @param uniTo - University graduation year to
 * @param userBrowsers - Browsers
 * @param userDevices - Devices
 * @param userOs - Operating systems
 * @param suggestedCriteria - Suggested criteria
 * @param groupsNot - Group not
 * @param priceListAudienceType - Price list audience type
 * @param count - Count
 * @param groupsActiveFormula - Group active formula
 * @param interestCategoriesFormula - Interest categories formula
 * @param groupsFormula - Groups formula
 * @param groupsActive - Groups active
 * @param groupTypes - Group types
 * @param keyPhrases - Key phrases
 * @param keyPhrasesDays - Key phrases days
 * @param geoNear - Geo near
 * @param geoPointType - Geo point type
 * @param priceListId - Price list id
 * @param groupsRecommended - Groups recommended ids
 * @param groupsActiveRecommended - Groups active recommended ids
 * @param musicArtistsFormula - Music artists formula
 * @param priceListRetargetingFormula - Price list retargeting formula
 * @param tags - Tags
 * @param browsers - Browsers
 * @param mobileOsMinVersion - Mobile os min version
 * @param mobileAppsEventsFormula - Mobile apps events formula
 * @param mobileOsMaxVersion - Mobile os max version
 * @param operators - operators
 * @param wifiOnly - wifi_only
 * @param mobileManufacturers - mobile_manufacturers
 */
data class AdsTargSettingsDto(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("campaign_id")
    val campaignId: String? = null,
    @SerializedName("age_from")
    val ageFrom: String? = null,
    @SerializedName("age_to")
    val ageTo: String? = null,
    @SerializedName("apps")
    val apps: String? = null,
    @SerializedName("apps_not")
    val appsNot: String? = null,
    @SerializedName("birthday")
    val birthday: String? = null,
    @SerializedName("cities")
    val cities: String? = null,
    @SerializedName("cities_not")
    val citiesNot: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("districts")
    val districts: String? = null,
    @SerializedName("groups")
    val groups: String? = null,
    @SerializedName("interest_categories")
    val interestCategories: String? = null,
    @SerializedName("interests")
    val interests: String? = null,
    @SerializedName("paying")
    val paying: String? = null,
    @SerializedName("positions")
    val positions: String? = null,
    @SerializedName("religions")
    val religions: String? = null,
    @SerializedName("retargeting_groups")
    val retargetingGroups: String? = null,
    @SerializedName("retargeting_groups_not")
    val retargetingGroupsNot: String? = null,
    @SerializedName("school_from")
    val schoolFrom: String? = null,
    @SerializedName("school_to")
    val schoolTo: String? = null,
    @SerializedName("schools")
    val schools: String? = null,
    @SerializedName("sex")
    val sex: AdsCriteriaSexDto? = null,
    @SerializedName("stations")
    val stations: String? = null,
    @SerializedName("statuses")
    val statuses: String? = null,
    @SerializedName("streets")
    val streets: String? = null,
    @SerializedName("travellers")
    val travellers: String? = null,
    @SerializedName("ab_test")
    val abTest: String? = null,
    @SerializedName("uni_from")
    val uniFrom: String? = null,
    @SerializedName("uni_to")
    val uniTo: String? = null,
    @SerializedName("user_browsers")
    val userBrowsers: String? = null,
    @SerializedName("user_devices")
    val userDevices: String? = null,
    @SerializedName("user_os")
    val userOs: String? = null,
    @SerializedName("suggested_criteria")
    val suggestedCriteria: String? = null,
    @SerializedName("groups_not")
    val groupsNot: String? = null,
    @SerializedName("price_list_audience_type")
    val priceListAudienceType: String? = null,
    @SerializedName("count")
    val count: String? = null,
    @SerializedName("groups_active_formula")
    val groupsActiveFormula: String? = null,
    @SerializedName("interest_categories_formula")
    val interestCategoriesFormula: String? = null,
    @SerializedName("groups_formula")
    val groupsFormula: String? = null,
    @SerializedName("groups_active")
    val groupsActive: String? = null,
    @SerializedName("group_types")
    val groupTypes: String? = null,
    @SerializedName("key_phrases")
    val keyPhrases: String? = null,
    @SerializedName("key_phrases_days")
    val keyPhrasesDays: String? = null,
    @SerializedName("geo_near")
    val geoNear: String? = null,
    @SerializedName("geo_point_type")
    val geoPointType: String? = null,
    @SerializedName("price_list_id")
    val priceListId: String? = null,
    @SerializedName("groups_recommended")
    val groupsRecommended: String? = null,
    @SerializedName("groups_active_recommended")
    val groupsActiveRecommended: String? = null,
    @SerializedName("music_artists_formula")
    val musicArtistsFormula: String? = null,
    @SerializedName("price_list_retargeting_formula")
    val priceListRetargetingFormula: String? = null,
    @SerializedName("tags")
    val tags: String? = null,
    @SerializedName("browsers")
    val browsers: String? = null,
    @SerializedName("mobile_os_min_version")
    val mobileOsMinVersion: String? = null,
    @SerializedName("mobile_apps_events_formula")
    val mobileAppsEventsFormula: String? = null,
    @SerializedName("mobile_os_max_version")
    val mobileOsMaxVersion: String? = null,
    @SerializedName("operators")
    val operators: String? = null,
    @SerializedName("wifi_only")
    val wifiOnly: String? = null,
    @SerializedName("mobile_manufacturers")
    val mobileManufacturers: String? = null
)
