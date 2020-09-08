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
package com.vk.sdk.api.users.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.users.dto.UsersFields
import com.vk.sdk.api.users.dto.UsersSearchResponseDto
import com.vk.sdk.api.users.dto.UsersSearchSex
import com.vk.sdk.api.users.dto.UsersSearchSort
import com.vk.sdk.api.users.dto.UsersSearchStatus
import com.vk.sdk.api.users.responses.UsersSearchResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of users matching the search criteria.
 * @param q Search query string (e.g., 'Vasya Babich'). 
 * @param sort Sort order: '1' � by date registered, '0' � by rating 
 * @param offset Offset needed to return a specific subset of users. minimum 0
 * @param count Number of users to return. default 20 minimum 0 maximum 1000
 * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate'
 * (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile',
 * 'rate', 'contacts', 'education', 'online', 
 * @param city City ID. minimum 0
 * @param country Country ID. minimum 0
 * @param hometown City name in a string. 
 * @param universityCountry ID of the country where the user graduated. minimum 0
 * @param university ID of the institution of higher education. minimum 0
 * @param universityYear Year of graduation from an institution of higher education. minimum 0
 * @param universityFaculty Faculty ID. minimum 0
 * @param universityChair Chair ID. minimum 0
 * @param sex '1' � female, '2' � male, '0' � any (default) minimum 0
 * @param status Relationship status: '1' � Not married, '2' � In a relationship, '3' � Engaged, '4'
 * � Married, '5' � It's complicated, '6' � Actively searching, '7' � In love minimum 0
 * @param ageFrom Minimum age. minimum 0
 * @param ageTo Maximum age. minimum 0
 * @param birthDay Day of birth. minimum 0
 * @param birthMonth Month of birth. minimum 0
 * @param birthYear Year of birth. minimum 1900 maximum 2100
 * @param online '1' � online only, '0' � all users 
 * @param hasPhoto '1' � with photo only, '0' � all users 
 * @param schoolCountry ID of the country where users finished school. minimum 0
 * @param schoolCity ID of the city where users finished school. minimum 0
 * @param schoolClass  minimum 0
 * @param school ID of the school. minimum 0
 * @param schoolYear School graduation year. minimum 0
 * @param religion Users' religious affiliation. 
 * @param company Name of the company where users work. 
 * @param position Job position. 
 * @param groupId ID of a community to search in communities. minimum 0
 * @param fromList  
 */
class UsersSearch(
    private val q: String? = null,
    private val sort: UsersSearchSort? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val fields: List<UsersFields>? = null,
    private val city: Int? = null,
    private val country: Int? = null,
    private val hometown: String? = null,
    private val universityCountry: Int? = null,
    private val university: Int? = null,
    private val universityYear: Int? = null,
    private val universityFaculty: Int? = null,
    private val universityChair: Int? = null,
    private val sex: UsersSearchSex? = null,
    private val status: UsersSearchStatus? = null,
    private val ageFrom: Int? = null,
    private val ageTo: Int? = null,
    private val birthDay: Int? = null,
    private val birthMonth: Int? = null,
    private val birthYear: Int? = null,
    private val online: Boolean? = null,
    private val hasPhoto: Boolean? = null,
    private val schoolCountry: Int? = null,
    private val schoolCity: Int? = null,
    private val schoolClass: Int? = null,
    private val school: Int? = null,
    private val schoolYear: Int? = null,
    private val religion: String? = null,
    private val company: String? = null,
    private val position: String? = null,
    private val groupId: Int? = null,
    private val fromList: List<String>? = null
) : VKRequest<UsersSearchResponseDto>("users.search") {
    init {
        q?.let { value ->
            addParam("q", value)
        }
        sort?.let { value ->
            addParam("sort", value.value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        fields?.let { value ->
            addParam("fields", value.map { it.value })
        }
        city?.let { value ->
            addParam("city", value)
        }
        country?.let { value ->
            addParam("country", value)
        }
        hometown?.let { value ->
            addParam("hometown", value)
        }
        universityCountry?.let { value ->
            addParam("university_country", value)
        }
        university?.let { value ->
            addParam("university", value)
        }
        universityYear?.let { value ->
            addParam("university_year", value)
        }
        universityFaculty?.let { value ->
            addParam("university_faculty", value)
        }
        universityChair?.let { value ->
            addParam("university_chair", value)
        }
        sex?.let { value ->
            addParam("sex", value.value)
        }
        status?.let { value ->
            addParam("status", value.value)
        }
        ageFrom?.let { value ->
            addParam("age_from", value)
        }
        ageTo?.let { value ->
            addParam("age_to", value)
        }
        birthDay?.let { value ->
            addParam("birth_day", value)
        }
        birthMonth?.let { value ->
            addParam("birth_month", value)
        }
        birthYear?.let { value ->
            addParam("birth_year", value)
        }
        online?.let { value ->
            addParam("online", if (value) 1 else 0)
        }
        hasPhoto?.let { value ->
            addParam("has_photo", if (value) 1 else 0)
        }
        schoolCountry?.let { value ->
            addParam("school_country", value)
        }
        schoolCity?.let { value ->
            addParam("school_city", value)
        }
        schoolClass?.let { value ->
            addParam("school_class", value)
        }
        school?.let { value ->
            addParam("school", value)
        }
        schoolYear?.let { value ->
            addParam("school_year", value)
        }
        religion?.let { value ->
            addParam("religion", value)
        }
        company?.let { value ->
            addParam("company", value)
        }
        position?.let { value ->
            addParam("position", value)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        fromList?.let { value ->
            addParam("from_list", value)
        }
    }

    override fun parse(r: JSONObject): UsersSearchResponseDto =
            GsonHolder.gson.fromJson(r.toString(), UsersSearchResponse::class.java).response
}
