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

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.users.dto.UsersFields
import com.vk.sdk.api.users.dto.UsersGetFollowersFieldsResponse
import com.vk.sdk.api.users.dto.UsersGetFollowersNameCase
import com.vk.sdk.api.users.dto.UsersGetNameCase
import com.vk.sdk.api.users.dto.UsersGetSubscriptionsExtendedResponse
import com.vk.sdk.api.users.dto.UsersGetSubscriptionsResponse
import com.vk.sdk.api.users.dto.UsersReportType
import com.vk.sdk.api.users.dto.UsersSearchResponse
import com.vk.sdk.api.users.dto.UsersSearchSex
import com.vk.sdk.api.users.dto.UsersSearchSort
import com.vk.sdk.api.users.dto.UsersSearchStatus
import com.vk.sdk.api.users.dto.UsersUserFull
import kotlin.Boolean
import kotlin.Int
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
        fields: List<UsersFields>? = null,
        nameCase: UsersGetNameCase? = null
    ): VKRequest<List<UsersUserFull>> = NewApiRequest("users.get") {
        val typeToken = object: TypeToken<List<UsersUserFull>>() {}.type
        GsonHolder.gson.fromJson<List<UsersUserFull>>(it, typeToken)
    }
    .apply {
        userIds?.let { addParam("user_ids", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it.value) }
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
     * @return [VKRequest] with [UsersGetFollowersFieldsResponse]
     */
    fun usersGetFollowers(
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFields>? = null,
        nameCase: UsersGetFollowersNameCase? = null
    ): VKRequest<UsersGetFollowersFieldsResponse> = NewApiRequest("users.getFollowers") {
        GsonHolder.gson.fromJson(it, UsersGetFollowersFieldsResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it.value) }
    }

    /**
     * Returns a list of IDs of users and communities followed by the user.
     *
     * @param userId - User ID.
     * @param offset - Offset needed to return a specific subset of subscriptions.
     * @param count - Number of users and communities to return.
     * @param fields
     * @return [VKRequest] with [UsersGetSubscriptionsResponse]
     */
    fun usersGetSubscriptions(
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFields>? = null
    ): VKRequest<UsersGetSubscriptionsResponse> = NewApiRequest("users.getSubscriptions") {
        GsonHolder.gson.fromJson(it, UsersGetSubscriptionsResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
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
     * @return [VKRequest] with [UsersGetSubscriptionsExtendedResponse]
     */
    fun usersGetSubscriptionsExtended(
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFields>? = null
    ): VKRequest<UsersGetSubscriptionsExtendedResponse> = NewApiRequest("users.getSubscriptions") {
        GsonHolder.gson.fromJson(it, UsersGetSubscriptionsExtendedResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun usersReport(
        userId: UserId,
        type: UsersReportType,
        comment: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("users.report") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @param country - Country ID.
     * @param hometown - City name in a string.
     * @param universityCountry - ID of the country where the user graduated.
     * @param university - ID of the institution of higher education.
     * @param universityYear - Year of graduation from an institution of higher education.
     * @param universityFaculty - Faculty ID.
     * @param universityChair - Chair ID.
     * @param sex - '1' - female, '2' - male, '0' - any (default)
     * @param status - Relationship status_ '1' - Not married, '2' - In a relationship, '3' -
     * Engaged, '4' - Married, '5' - It's complicated, '6' - Actively searching, '7' - In love
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
     * @return [VKRequest] with [UsersSearchResponse]
     */
    fun usersSearch(
        q: String? = null,
        sort: UsersSearchSort? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFields>? = null,
        city: Int? = null,
        country: Int? = null,
        hometown: String? = null,
        universityCountry: Int? = null,
        university: Int? = null,
        universityYear: Int? = null,
        universityFaculty: Int? = null,
        universityChair: Int? = null,
        sex: UsersSearchSex? = null,
        status: UsersSearchStatus? = null,
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
        fromList: List<String>? = null
    ): VKRequest<UsersSearchResponse> = NewApiRequest("users.search") {
        GsonHolder.gson.fromJson(it, UsersSearchResponse::class.java)
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
        country?.let { addParam("country", it, min = 0) }
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
    }
}
