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
package com.vk.sdk.api.groups.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param audio Audio settings
 * @param articles Articles settings
 * @param cityId City id of group
 * @param countryId Country id of group
 * @param description Community description
 * @param docs Docs settings
 * @param obsceneFilter Information whether the obscene filter is enabled
 * @param obsceneStopwords Information whether the stopwords filter is enabled
 * @param obsceneWords The list of stop words
 * @param photos Photos settings
 * @param title Community title
 * @param topics Topics settings
 * @param video Video settings
 * @param wall Wall settings
 * @param wiki Wiki settings
 * @param access Community access settings
 * @param address Community's page domain
 * @param contacts no description
 * @param links no description
 * @param sectionsList no description
 * @param mainSection no description
 * @param secondarySection no description
 * @param ageLimits no description
 * @param events no description
 * @param eventGroupId no description
 * @param publicCategory Information about the group category
 * @param publicCategoryList no description
 * @param publicDate no description
 * @param publicDateLabel no description
 * @param publicSubcategory Information about the group subcategory
 * @param rss URL of the RSS feed
 * @param startDate Start date
 * @param finishDate Finish date in Unixtime format
 * @param subject Community subject ID
 * @param subjectList no description
 * @param suggestedPrivacy no description
 * @param twitter no description
 * @param website Community website
 * @param phone Community phone
 * @param email Community email
 */
data class GroupsGetSettingsResponseDto(
    @SerializedName(value="audio")
    val audio: GroupsGroupAudio,
    @SerializedName(value="articles")
    val articles: Int,
    @SerializedName(value="city_id")
    val cityId: Int,
    @SerializedName(value="country_id")
    val countryId: Int,
    @SerializedName(value="description")
    val description: String,
    @SerializedName(value="docs")
    val docs: GroupsGroupDocs,
    @SerializedName(value="obscene_filter")
    val obsceneFilter: BaseBoolInt,
    @SerializedName(value="obscene_stopwords")
    val obsceneStopwords: BaseBoolInt,
    @SerializedName(value="obscene_words")
    val obsceneWords: List<String>,
    @SerializedName(value="photos")
    val photos: Int,
    @SerializedName(value="title")
    val title: String,
    @SerializedName(value="topics")
    val topics: GroupsGroupTopics,
    @SerializedName(value="video")
    val video: GroupsGroupVideo,
    @SerializedName(value="wall")
    val wall: GroupsGroupWall,
    @SerializedName(value="wiki")
    val wiki: GroupsGroupWiki,
    @SerializedName(value="access")
    val access: GroupsGroupAccess? = null,
    @SerializedName(value="address")
    val address: String? = null,
    @SerializedName(value="contacts")
    val contacts: BaseBoolInt? = null,
    @SerializedName(value="links")
    val links: BaseBoolInt? = null,
    @SerializedName(value="sections_list")
    val sectionsList: Any? = null,
    @SerializedName(value="main_section")
    val mainSection: GroupsGroupFullMainSection? = null,
    @SerializedName(value="secondary_section")
    val secondarySection: Int? = null,
    @SerializedName(value="age_limits")
    val ageLimits: Int? = null,
    @SerializedName(value="events")
    val events: BaseBoolInt? = null,
    @SerializedName(value="event_group_id")
    val eventGroupId: Int? = null,
    @SerializedName(value="public_category")
    val publicCategory: Int? = null,
    @SerializedName(value="public_category_list")
    val publicCategoryList: List<GroupsGroupPublicCategoryList>? = null,
    @SerializedName(value="public_date")
    val publicDate: String? = null,
    @SerializedName(value="public_date_label")
    val publicDateLabel: String? = null,
    @SerializedName(value="public_subcategory")
    val publicSubcategory: Int? = null,
    @SerializedName(value="rss")
    val rss: String? = null,
    @SerializedName(value="start_date")
    val startDate: Int? = null,
    @SerializedName(value="finish_date")
    val finishDate: Int? = null,
    @SerializedName(value="subject")
    val subject: Int? = null,
    @SerializedName(value="subject_list")
    val subjectList: List<GroupsSubjectItem>? = null,
    @SerializedName(value="suggested_privacy")
    val suggestedPrivacy: Int? = null,
    @SerializedName(value="twitter")
    val twitter: GroupsSettingsTwitter? = null,
    @SerializedName(value="website")
    val website: String? = null,
    @SerializedName(value="phone")
    val phone: String? = null,
    @SerializedName(value="email")
    val email: String? = null
)
