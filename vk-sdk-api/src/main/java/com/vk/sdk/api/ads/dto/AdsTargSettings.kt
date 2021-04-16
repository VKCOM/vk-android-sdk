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
import com.vk.sdk.api.base.dto.BasePropertyExists
import kotlin.Int
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
 * @param retargetingGroups - Retargeting groups IDs
 * @param retargetingGroupsNot - Retargeting groups IDs to except
 * @param schoolFrom - School graduation year from
 * @param schoolTo - School graduation year to
 * @param schools - Schools IDs
 * @param sex
 * @param stations - Stations IDs
 * @param statuses - Relationship statuses
 * @param streets - Streets IDs
 * @param travellers - Travellers only
 * @param uniFrom - University graduation year from
 * @param uniTo - University graduation year to
 * @param userBrowsers - Browsers
 * @param userDevices - Devices
 * @param userOs - Operating systems
 */
data class AdsTargSettings(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("campaign_id")
    val campaignId: Int? = null,
    @SerializedName("age_from")
    val ageFrom: Int? = null,
    @SerializedName("age_to")
    val ageTo: Int? = null,
    @SerializedName("apps")
    val apps: String? = null,
    @SerializedName("apps_not")
    val appsNot: String? = null,
    @SerializedName("birthday")
    val birthday: Int? = null,
    @SerializedName("cities")
    val cities: String? = null,
    @SerializedName("cities_not")
    val citiesNot: String? = null,
    @SerializedName("country")
    val country: Int? = null,
    @SerializedName("districts")
    val districts: String? = null,
    @SerializedName("groups")
    val groups: String? = null,
    @SerializedName("interest_categories")
    val interestCategories: String? = null,
    @SerializedName("interests")
    val interests: String? = null,
    @SerializedName("paying")
    val paying: BaseBoolInt? = null,
    @SerializedName("positions")
    val positions: String? = null,
    @SerializedName("religions")
    val religions: String? = null,
    @SerializedName("retargeting_groups")
    val retargetingGroups: String? = null,
    @SerializedName("retargeting_groups_not")
    val retargetingGroupsNot: String? = null,
    @SerializedName("school_from")
    val schoolFrom: Int? = null,
    @SerializedName("school_to")
    val schoolTo: Int? = null,
    @SerializedName("schools")
    val schools: String? = null,
    @SerializedName("sex")
    val sex: AdsCriteriaSex? = null,
    @SerializedName("stations")
    val stations: String? = null,
    @SerializedName("statuses")
    val statuses: String? = null,
    @SerializedName("streets")
    val streets: String? = null,
    @SerializedName("travellers")
    val travellers: BasePropertyExists? = null,
    @SerializedName("uni_from")
    val uniFrom: Int? = null,
    @SerializedName("uni_to")
    val uniTo: Int? = null,
    @SerializedName("user_browsers")
    val userBrowsers: String? = null,
    @SerializedName("user_devices")
    val userDevices: String? = null,
    @SerializedName("user_os")
    val userOs: String? = null
)
