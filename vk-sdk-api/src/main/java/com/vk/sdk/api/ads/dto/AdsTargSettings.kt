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
 * @param id Ad ID
 * @param campaignId Campaign ID
 * @param ageFrom Age from
 * @param ageTo Age to
 * @param apps Apps IDs
 * @param appsNot Apps IDs to except
 * @param birthday Days to birthday
 * @param cities Cities IDs
 * @param citiesNot Cities IDs to except
 * @param country Country ID
 * @param districts Districts IDs
 * @param groups Communities IDs
 * @param interestCategories Interests categories IDs
 * @param interests Interests
 * @param paying Information whether the user has proceeded VK payments before
 * @param positions Positions IDs
 * @param religions Religions IDs
 * @param retargetingGroups Retargeting groups IDs
 * @param retargetingGroupsNot Retargeting groups IDs to except
 * @param schoolFrom School graduation year from
 * @param schoolTo School graduation year to
 * @param schools Schools IDs
 * @param sex no description
 * @param stations Stations IDs
 * @param statuses Relationship statuses
 * @param streets Streets IDs
 * @param travellers Travellers only
 * @param uniFrom University graduation year from
 * @param uniTo University graduation year to
 * @param userBrowsers Browsers
 * @param userDevices Devices
 * @param userOs Operating systems
 */
data class AdsTargSettings(
    @SerializedName(value="id")
    val id: Int? = null,
    @SerializedName(value="campaign_id")
    val campaignId: Int? = null,
    @SerializedName(value="age_from")
    val ageFrom: Int? = null,
    @SerializedName(value="age_to")
    val ageTo: Int? = null,
    @SerializedName(value="apps")
    val apps: String? = null,
    @SerializedName(value="apps_not")
    val appsNot: String? = null,
    @SerializedName(value="birthday")
    val birthday: Int? = null,
    @SerializedName(value="cities")
    val cities: String? = null,
    @SerializedName(value="cities_not")
    val citiesNot: String? = null,
    @SerializedName(value="country")
    val country: Int? = null,
    @SerializedName(value="districts")
    val districts: String? = null,
    @SerializedName(value="groups")
    val groups: String? = null,
    @SerializedName(value="interest_categories")
    val interestCategories: String? = null,
    @SerializedName(value="interests")
    val interests: String? = null,
    @SerializedName(value="paying")
    val paying: BaseBoolInt? = null,
    @SerializedName(value="positions")
    val positions: String? = null,
    @SerializedName(value="religions")
    val religions: String? = null,
    @SerializedName(value="retargeting_groups")
    val retargetingGroups: String? = null,
    @SerializedName(value="retargeting_groups_not")
    val retargetingGroupsNot: String? = null,
    @SerializedName(value="school_from")
    val schoolFrom: Int? = null,
    @SerializedName(value="school_to")
    val schoolTo: Int? = null,
    @SerializedName(value="schools")
    val schools: String? = null,
    @SerializedName(value="sex")
    val sex: AdsCriteriaSex? = null,
    @SerializedName(value="stations")
    val stations: String? = null,
    @SerializedName(value="statuses")
    val statuses: String? = null,
    @SerializedName(value="streets")
    val streets: String? = null,
    @SerializedName(value="travellers")
    val travellers: BasePropertyExists? = null,
    @SerializedName(value="uni_from")
    val uniFrom: Int? = null,
    @SerializedName(value="uni_to")
    val uniTo: Int? = null,
    @SerializedName(value="user_browsers")
    val userBrowsers: String? = null,
    @SerializedName(value="user_devices")
    val userDevices: String? = null,
    @SerializedName(value="user_os")
    val userOs: String? = null
)
