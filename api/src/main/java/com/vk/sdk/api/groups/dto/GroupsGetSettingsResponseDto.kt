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
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param audio - Audio settings
 * @param articles - Articles settings
 * @param cityId - City id of group
 * @param cityName - City name of group
 * @param countryId - Country id of group
 * @param countryName - Country name of group
 * @param description - Community description
 * @param docs - Docs settings
 * @param obsceneFilter - Information whether the obscene filter is enabled
 * @param obsceneStopwords - Information whether the stop words filter is enabled
 * @param obsceneWords - The list of stop words
 * @param photos - Photos settings
 * @param title - Community title
 * @param topics - Topics settings
 * @param video - Video settings
 * @param wall - Wall settings
 * @param wiki - Wiki settings
 * @param access - Community access settings
 * @param address - Community's page domain
 * @param recognizePhoto - Photo suggests setting
 * @param contacts
 * @param links
 * @param sectionsList
 * @param mainSection
 * @param secondarySection
 * @param ageLimits
 * @param events
 * @param addresses
 * @param botsCapabilities - By enabling bot abilities, you can send users messages with a
 * customized keyboard attached as well as use other promotional abilities
 * @param botsStartButton - If this setting is enabled, users will see a Start button when they
 * start a chat with your community for the first time
 * @param botsAddToChat - If this setting is enabled then users can add your community to a chat
 * @param eventGroupId
 * @param publicCategory - Information about the group category
 * @param publicCategoryList
 * @param publicDate
 * @param publicDateLabel
 * @param publicSubcategory - Information about the group subcategory
 * @param rss - URL of the RSS feed
 * @param startDate - Start date
 * @param finishDate - Finish date in Unix-time format
 * @param subject - Community subject ID
 * @param subjectList
 * @param suggestedPrivacy
 * @param twitter
 * @param website - Community website
 * @param phone - Community phone
 * @param email - Community email
 */
data class GroupsGetSettingsResponseDto(
    @SerializedName("audio")
    val audio: GroupsGroupAudioDto,
    @SerializedName("articles")
    val articles: Int,
    @SerializedName("city_id")
    val cityId: Int,
    @SerializedName("city_name")
    val cityName: String,
    @SerializedName("country_id")
    val countryId: Int,
    @SerializedName("country_name")
    val countryName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("docs")
    val docs: GroupsGroupDocsDto,
    @SerializedName("obscene_filter")
    val obsceneFilter: BaseBoolIntDto,
    @SerializedName("obscene_stopwords")
    val obsceneStopwords: BaseBoolIntDto,
    @SerializedName("obscene_words")
    val obsceneWords: List<String>,
    @SerializedName("photos")
    val photos: GroupsGroupPhotosDto,
    @SerializedName("title")
    val title: String,
    @SerializedName("topics")
    val topics: GroupsGroupTopicsDto,
    @SerializedName("video")
    val video: GroupsGroupVideoDto,
    @SerializedName("wall")
    val wall: GroupsGroupWallDto,
    @SerializedName("wiki")
    val wiki: GroupsGroupWikiDto,
    @SerializedName("access")
    val access: GroupsGroupAccessDto? = null,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("recognize_photo")
    val recognizePhoto: Int? = null,
    @SerializedName("contacts")
    val contacts: BaseBoolIntDto? = null,
    @SerializedName("links")
    val links: BaseBoolIntDto? = null,
    @SerializedName("sections_list")
    val sectionsList: List<List<Int>>? = null,
    @SerializedName("main_section")
    val mainSection: GroupsGroupFullSectionDto? = null,
    @SerializedName("secondary_section")
    val secondarySection: GroupsGroupFullSectionDto? = null,
    @SerializedName("age_limits")
    val ageLimits: GroupsGroupAgeLimitsDto? = null,
    @SerializedName("events")
    val events: BaseBoolIntDto? = null,
    @SerializedName("addresses")
    val addresses: Boolean? = null,
    @SerializedName("bots_capabilities")
    val botsCapabilities: BaseBoolIntDto? = null,
    @SerializedName("bots_start_button")
    val botsStartButton: BaseBoolIntDto? = null,
    @SerializedName("bots_add_to_chat")
    val botsAddToChat: BaseBoolIntDto? = null,
    @SerializedName("event_group_id")
    val eventGroupId: Int? = null,
    @SerializedName("public_category")
    val publicCategory: Int? = null,
    @SerializedName("public_category_list")
    val publicCategoryList: List<GroupsGroupPublicCategoryListDto>? = null,
    @SerializedName("public_date")
    val publicDate: String? = null,
    @SerializedName("public_date_label")
    val publicDateLabel: String? = null,
    @SerializedName("public_subcategory")
    val publicSubcategory: Int? = null,
    @SerializedName("rss")
    val rss: String? = null,
    @SerializedName("start_date")
    val startDate: Int? = null,
    @SerializedName("finish_date")
    val finishDate: Int? = null,
    @SerializedName("subject")
    val subject: Int? = null,
    @SerializedName("subject_list")
    val subjectList: List<GroupsSubjectItemDto>? = null,
    @SerializedName("suggested_privacy")
    val suggestedPrivacy: GroupsGroupSuggestedPrivacyDto? = null,
    @SerializedName("twitter")
    val twitter: GroupsSettingsTwitterDto? = null,
    @SerializedName("website")
    val website: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("email")
    val email: String? = null
)
