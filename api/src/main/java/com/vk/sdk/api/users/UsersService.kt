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
package com.vk.sdk.api.users

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.users.dto.UsersFieldsDto
import com.vk.sdk.api.users.dto.UsersGetFollowersFieldsResponseDto
import com.vk.sdk.api.users.dto.UsersGetSubscriptionsExtendedResponseDto
import com.vk.sdk.api.users.dto.UsersGetSubscriptionsResponseDto
import com.vk.sdk.api.users.dto.UsersReportTypeDto
import com.vk.sdk.api.users.dto.UsersSearchResponseDto
import com.vk.sdk.api.users.dto.UsersSearchSexDto
import com.vk.sdk.api.users.dto.UsersSearchSortDto
import com.vk.sdk.api.users.dto.UsersSearchStatusDto
import com.vk.sdk.api.users.dto.UsersUserFullDto
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class UsersService {
    /**
     * Returns detailed information on users.
     *
     * @param userIds - User IDs or screen names ('screen_name'). By default, current user ID.
     * @param fields - Profile fields to return. Sample values_ 'nickname', 'screen_name', 'sex',
     * 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big',
     * 'has_mobile', 'contacts', 'education', 'online', 'counters', 'relation', 'last_seen',
     * 'activity', 'can_write_private_message', 'can_see_all_posts', 'can_post', 'universities',
     * 'can_invite_to_chats'
     * @param nameCase - Case for declension of user name and surname_ 'nom' - nominative (default),
     * 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' -
     * prepositional
     * @return [VKRequest] with [Unit]
     */
    fun usersGet(
        userIds: List<UserId>? = null,
        fields: List<UsersFieldsDto>? = null,
        nameCase: String? = null
    ): VKRequest<List<UsersUserFullDto>> = NewApiRequest("users.get") {
        GsonHolder.gson.parseList<UsersUserFullDto>(it)
    }
    .apply {
        userIds?.let { addParam("user_ids", it, min = 1) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it) }
    }

    /**
     * Returns a list of IDs of followers of the user in question, sorted by date added, most recent
     * first.
     *
     * @param userId - User ID.
     * @param offset - Offset needed to return a specific subset of followers.
     * @param count - Number of followers to return.
     * @param fields - Profile fields to return. Sample values_ 'nickname', 'screen_name', 'sex',
     * 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big',
     * 'has_mobile', 'rate', 'contacts', 'education', 'online'.
     * @param nameCase - Case for declension of user name and surname_ 'nom' - nominative (default),
     * 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' -
     * prepositional
     * @return [VKRequest] with [UsersGetFollowersFieldsResponseDto]
     */
    fun usersGetFollowers(
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFieldsDto>? = null,
        nameCase: String? = null
    ): VKRequest<UsersGetFollowersFieldsResponseDto> = NewApiRequest("users.getFollowers") {
        GsonHolder.gson.parse<UsersGetFollowersFieldsResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it) }
    }

    /**
     * Returns a list of IDs of users and communities followed by the user.
     *
     * @param userId - User ID.
     * @param extended - '1' - to return a combined list of users and communities, '0' - to return
     * separate lists of users and communities (default)
     * @param offset - Offset needed to return a specific subset of subscriptions.
     * @param count - Number of users and communities to return.
     * @param fields
     * @return [VKRequest] with [UsersGetSubscriptionsResponseDto]
     */
    fun usersGetSubscriptions(
        userId: UserId? = null,
        extended: Boolean? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFieldsDto>? = null
    ): VKRequest<UsersGetSubscriptionsResponseDto> = NewApiRequest("users.getSubscriptions") {
        GsonHolder.gson.parse<UsersGetSubscriptionsResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        extended?.let { addParam("extended", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of IDs of users and communities followed by the user.
     *
     * @param userId - User ID.
     * @param offset - Offset needed to return a specific subset of subscriptions.
     * @param count - Number of users and communities to return.
     * @param fields
     * @return [VKRequest] with [UsersGetSubscriptionsExtendedResponseDto]
     */
    fun usersGetSubscriptionsExtended(
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFieldsDto>? = null
    ): VKRequest<UsersGetSubscriptionsExtendedResponseDto> =
            NewApiRequest("users.getSubscriptions") {
        GsonHolder.gson.parse<UsersGetSubscriptionsExtendedResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        addParam("extended", true)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Reports (submits a complain about) a user.
     *
     * @param userId - ID of the user about whom a complaint is being made.
     * @param type - Type of complaint_ 'porn' - pornography, 'spam' - spamming, 'insult' - abusive
     * behavior, 'advertisement' - disruptive advertisements
     * @param comment - Comment describing the complaint.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun usersReport(
        userId: UserId,
        type: UsersReportTypeDto,
        comment: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("users.report") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("type", type.value)
        comment?.let { addParam("comment", it) }
    }

    /**
     * Returns a list of users matching the search criteria.
     *
     * @param q - Search query string (e.g., 'Vasya Babich').
     * @param sort - Sort order_ '1' - by date registered, '0' - by rating
     * @param offset - Offset needed to return a specific subset of users.
     * @param count - Number of users to return.
     * @param fields - Profile fields to return. Sample values_ 'nickname', 'screen_name', 'sex',
     * 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big',
     * 'has_mobile', 'rate', 'contacts', 'education', 'online',
     * @param city - City ID.
     * @param cityId - City ID. Use parameter city instead
     * @param country - Country ID.
     * @param countryId - Country ID. Use parameter country instead
     * @param hometown - City name in a string.
     * @param universityCountry - ID of the country where the user graduated.
     * @param university - ID of the institution of higher education.
     * @param universityYear - Year of graduation from an institution of higher education.
     * @param universityFaculty - Faculty ID.
     * @param universityChair - Chair ID.
     * @param sex - '1' - female, '2' - male, '0' - any (default)
     * @param status - Relationship status_ '0' - Not specified, '1' - Not married, '2' - In a
     * relationship, '3' - Engaged, '4' - Married, '5' - It's complicated, '6' - Actively searching,
     * '7' - In love, '8' - In a civil union
     * @param ageFrom - Minimum age.
     * @param ageTo - Maximum age.
     * @param birthDay - Day of birth.
     * @param birthMonth - Month of birth.
     * @param birthYear - Year of birth.
     * @param online - '1' - online only, '0' - all users
     * @param hasPhoto - '1' - with photo only, '0' - all users
     * @param schoolCountry - ID of the country where users finished school.
     * @param schoolCity - ID of the city where users finished school.
     * @param schoolClass
     * @param school - ID of the school.
     * @param schoolYear - School graduation year.
     * @param religion - Users' religious affiliation.
     * @param company - Name of the company where users work.
     * @param position - Job position.
     * @param groupId - ID of a community to search in communities.
     * @param fromList
     * @param screenRef
     * @return [VKRequest] with [UsersSearchResponseDto]
     */
    fun usersSearch(
        q: String? = null,
        sort: UsersSearchSortDto? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFieldsDto>? = null,
        city: Int? = null,
        cityId: Int? = null,
        country: Int? = null,
        countryId: Int? = null,
        hometown: String? = null,
        universityCountry: Int? = null,
        university: Int? = null,
        universityYear: Int? = null,
        universityFaculty: Int? = null,
        universityChair: Int? = null,
        sex: UsersSearchSexDto? = null,
        status: UsersSearchStatusDto? = null,
        ageFrom: Int? = null,
        ageTo: Int? = null,
        birthDay: Int? = null,
        birthMonth: Int? = null,
        birthYear: Int? = null,
        online: Boolean? = null,
        hasPhoto: Boolean? = null,
        schoolCountry: Int? = null,
        schoolCity: Int? = null,
        schoolClass: Int? = null,
        school: Int? = null,
        schoolYear: Int? = null,
        religion: String? = null,
        company: String? = null,
        position: String? = null,
        groupId: UserId? = null,
        fromList: List<String>? = null,
        screenRef: String? = null
    ): VKRequest<UsersSearchResponseDto> = NewApiRequest("users.search") {
        GsonHolder.gson.parse<UsersSearchResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it) }
        sort?.let { addParam("sort", it.value) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        city?.let { addParam("city", it, min = 0) }
        cityId?.let { addParam("city_id", it, min = 0) }
        country?.let { addParam("country", it, min = 0) }
        countryId?.let { addParam("country_id", it, min = 0) }
        hometown?.let { addParam("hometown", it) }
        universityCountry?.let { addParam("university_country", it, min = 0) }
        university?.let { addParam("university", it, min = 0) }
        universityYear?.let { addParam("university_year", it, min = 0) }
        universityFaculty?.let { addParam("university_faculty", it, min = 0) }
        universityChair?.let { addParam("university_chair", it, min = 0) }
        sex?.let { addParam("sex", it.value) }
        status?.let { addParam("status", it.value) }
        ageFrom?.let { addParam("age_from", it, min = 0) }
        ageTo?.let { addParam("age_to", it, min = 0) }
        birthDay?.let { addParam("birth_day", it, min = 0) }
        birthMonth?.let { addParam("birth_month", it, min = 0) }
        birthYear?.let { addParam("birth_year", it, min = 1900, max = 2100) }
        online?.let { addParam("online", it) }
        hasPhoto?.let { addParam("has_photo", it) }
        schoolCountry?.let { addParam("school_country", it, min = 0) }
        schoolCity?.let { addParam("school_city", it, min = 0) }
        schoolClass?.let { addParam("school_class", it, min = 0) }
        school?.let { addParam("school", it, min = 0) }
        schoolYear?.let { addParam("school_year", it, min = 0) }
        religion?.let { addParam("religion", it) }
        company?.let { addParam("company", it) }
        position?.let { addParam("position", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        fromList?.let { addParam("from_list", it) }
        screenRef?.let { addParam("screen_ref", it) }
    }

    object UsersGetRestrictions {
        const val USER_IDS_MIN: Int = 1
    }

    object UsersGetFollowersRestrictions {
        const val USER_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object UsersGetSubscriptionsRestrictions {
        const val USER_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200
    }

    object UsersGetSubscriptionsExtendedRestrictions {
        const val USER_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200
    }

    object UsersReportRestrictions {
        const val USER_ID_MIN: Long = 1
    }

    object UsersSearchRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000

        const val CITY_MIN: Long = 0

        const val CITY_ID_MIN: Long = 0

        const val COUNTRY_MIN: Long = 0

        const val COUNTRY_ID_MIN: Long = 0

        const val UNIVERSITY_COUNTRY_MIN: Long = 0

        const val UNIVERSITY_MIN: Long = 0

        const val UNIVERSITY_YEAR_MIN: Long = 0

        const val UNIVERSITY_FACULTY_MIN: Long = 0

        const val UNIVERSITY_CHAIR_MIN: Long = 0

        const val SEX_MIN: Long = 0

        const val STATUS_MIN: Long = 0

        const val AGE_FROM_MIN: Long = 0

        const val AGE_TO_MIN: Long = 0

        const val BIRTH_DAY_MIN: Long = 0

        const val BIRTH_MONTH_MIN: Long = 0

        const val BIRTH_YEAR_MIN: Long = 1900

        const val BIRTH_YEAR_MAX: Long = 2100

        const val SCHOOL_COUNTRY_MIN: Long = 0

        const val SCHOOL_CITY_MIN: Long = 0

        const val SCHOOL_CLASS_MIN: Long = 0

        const val SCHOOL_MIN: Long = 0

        const val SCHOOL_YEAR_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }
}
