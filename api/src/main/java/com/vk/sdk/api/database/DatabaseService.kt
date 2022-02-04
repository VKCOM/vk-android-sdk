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
package com.vk.sdk.api.database

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseCountry
import com.vk.sdk.api.database.dto.DatabaseCityById
import com.vk.sdk.api.database.dto.DatabaseGetChairsResponse
import com.vk.sdk.api.database.dto.DatabaseGetCitiesResponse
import com.vk.sdk.api.database.dto.DatabaseGetCountriesResponse
import com.vk.sdk.api.database.dto.DatabaseGetFacultiesResponse
import com.vk.sdk.api.database.dto.DatabaseGetMetroStationsResponse
import com.vk.sdk.api.database.dto.DatabaseGetRegionsResponse
import com.vk.sdk.api.database.dto.DatabaseGetSchoolsResponse
import com.vk.sdk.api.database.dto.DatabaseGetUniversitiesResponse
import com.vk.sdk.api.database.dto.DatabaseStation
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class DatabaseService {
    /**
     * Returns list of chairs on a specified faculty.
     *
     * @param facultyId - id of the faculty to get chairs from
     * @param offset - offset required to get a certain subset of chairs
     * @param count - amount of chairs to get
     * @return [VKRequest] with [DatabaseGetChairsResponse]
     */
    fun databaseGetChairs(
        facultyId: Int,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetChairsResponse> = NewApiRequest("database.getChairs") {
        GsonHolder.gson.fromJson(it, DatabaseGetChairsResponse::class.java)
    }
    .apply {
        addParam("faculty_id", facultyId, min = 0)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 10000) }
    }

    /**
     * Returns a list of cities.
     *
     * @param countryId - Country ID.
     * @param regionId - Region ID.
     * @param q - Search query.
     * @param needAll - '1' - to return all cities in the country, '0' - to return major cities in
     * the country (default),
     * @param offset - Offset needed to return a specific subset of cities.
     * @param count - Number of cities to return.
     * @return [VKRequest] with [DatabaseGetCitiesResponse]
     */
    fun databaseGetCities(
        countryId: Int,
        regionId: Int? = null,
        q: String? = null,
        needAll: Boolean? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetCitiesResponse> = NewApiRequest("database.getCities") {
        GsonHolder.gson.fromJson(it, DatabaseGetCitiesResponse::class.java)
    }
    .apply {
        addParam("country_id", countryId, min = 0)
        regionId?.let { addParam("region_id", it, min = 0) }
        q?.let { addParam("q", it) }
        needAll?.let { addParam("need_all", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * Returns information about cities by their IDs.
     *
     * @param cityIds - City IDs.
     * @return [VKRequest] with [Unit]
     */
    fun databaseGetCitiesById(cityIds: List<Int>? = null): VKRequest<List<DatabaseCityById>> =
            NewApiRequest("database.getCitiesById") {
        val typeToken = object: TypeToken<List<DatabaseCityById>>() {}.type
        GsonHolder.gson.fromJson<List<DatabaseCityById>>(it, typeToken)
    }
    .apply {
        cityIds?.let { addParam("city_ids", it) }
    }

    /**
     * Returns a list of countries.
     *
     * @param needAll - '1' - to return a full list of all countries, '0' - to return a list of
     * countries near the current user's country (default).
     * @param code - Country codes in [vk.com/dev/country_codes|ISO 3166-1 alpha-2] standard.
     * @param offset - Offset needed to return a specific subset of countries.
     * @param count - Number of countries to return.
     * @return [VKRequest] with [DatabaseGetCountriesResponse]
     */
    fun databaseGetCountries(
        needAll: Boolean? = null,
        code: String? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetCountriesResponse> = NewApiRequest("database.getCountries") {
        GsonHolder.gson.fromJson(it, DatabaseGetCountriesResponse::class.java)
    }
    .apply {
        needAll?.let { addParam("need_all", it) }
        code?.let { addParam("code", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * Returns information about countries by their IDs.
     *
     * @param countryIds - Country IDs.
     * @return [VKRequest] with [Unit]
     */
    fun databaseGetCountriesById(countryIds: List<Int>? = null): VKRequest<List<BaseCountry>> =
            NewApiRequest("database.getCountriesById") {
        val typeToken = object: TypeToken<List<BaseCountry>>() {}.type
        GsonHolder.gson.fromJson<List<BaseCountry>>(it, typeToken)
    }
    .apply {
        countryIds?.let { addParam("country_ids", it) }
    }

    /**
     * Returns a list of faculties (i.e., university departments).
     *
     * @param universityId - University ID.
     * @param offset - Offset needed to return a specific subset of faculties.
     * @param count - Number of faculties to return.
     * @return [VKRequest] with [DatabaseGetFacultiesResponse]
     */
    fun databaseGetFaculties(
        universityId: Int,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetFacultiesResponse> = NewApiRequest("database.getFaculties") {
        GsonHolder.gson.fromJson(it, DatabaseGetFacultiesResponse::class.java)
    }
    .apply {
        addParam("university_id", universityId, min = 0)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 10000) }
    }

    /**
     * Get metro stations by city
     *
     * @param cityId
     * @param offset
     * @param count
     * @return [VKRequest] with [DatabaseGetMetroStationsResponse]
     */
    fun databaseGetMetroStations(
        cityId: Int,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetMetroStationsResponse> = NewApiRequest("database.getMetroStations") {
        GsonHolder.gson.fromJson(it, DatabaseGetMetroStationsResponse::class.java)
    }
    .apply {
        addParam("city_id", cityId, min = 0)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 500) }
    }

    /**
     * Get metro station by his id
     *
     * @param stationIds
     * @return [VKRequest] with [Unit]
     */
    fun databaseGetMetroStationsById(stationIds: List<Int>? = null):
            VKRequest<List<DatabaseStation>> = NewApiRequest("database.getMetroStationsById") {
        val typeToken = object: TypeToken<List<DatabaseStation>>() {}.type
        GsonHolder.gson.fromJson<List<DatabaseStation>>(it, typeToken)
    }
    .apply {
        stationIds?.let { addParam("station_ids", it) }
    }

    /**
     * Returns a list of regions.
     *
     * @param countryId - Country ID, received in
     * [vk.com/dev/database.getCountries|database.getCountries] method.
     * @param q - Search query.
     * @param offset - Offset needed to return specific subset of regions.
     * @param count - Number of regions to return.
     * @return [VKRequest] with [DatabaseGetRegionsResponse]
     */
    fun databaseGetRegions(
        countryId: Int,
        q: String? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetRegionsResponse> = NewApiRequest("database.getRegions") {
        GsonHolder.gson.fromJson(it, DatabaseGetRegionsResponse::class.java)
    }
    .apply {
        addParam("country_id", countryId, min = 0)
        q?.let { addParam("q", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * Returns a list of school classes specified for the country.
     *
     * @param countryId - Country ID.
     * @return [VKRequest] with [Unit]
     */
    fun databaseGetSchoolClasses(countryId: Int? = null): VKRequest<List<List<String>>> =
            NewApiRequest("database.getSchoolClasses") {
        val typeToken = object: TypeToken<List<List<String>>>() {}.type
        GsonHolder.gson.fromJson<List<List<String>>>(it, typeToken)
    }
    .apply {
        countryId?.let { addParam("country_id", it, min = 0) }
    }

    /**
     * Returns a list of schools.
     *
     * @param cityId - City ID.
     * @param q - Search query.
     * @param offset - Offset needed to return a specific subset of schools.
     * @param count - Number of schools to return.
     * @return [VKRequest] with [DatabaseGetSchoolsResponse]
     */
    fun databaseGetSchools(
        cityId: Int,
        q: String? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetSchoolsResponse> = NewApiRequest("database.getSchools") {
        GsonHolder.gson.fromJson(it, DatabaseGetSchoolsResponse::class.java)
    }
    .apply {
        addParam("city_id", cityId, min = 0)
        q?.let { addParam("q", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 10000) }
    }

    /**
     * Returns a list of higher education institutions.
     *
     * @param q - Search query.
     * @param countryId - Country ID.
     * @param cityId - City ID.
     * @param offset - Offset needed to return a specific subset of universities.
     * @param count - Number of universities to return.
     * @return [VKRequest] with [DatabaseGetUniversitiesResponse]
     */
    fun databaseGetUniversities(
        q: String? = null,
        countryId: Int? = null,
        cityId: Int? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetUniversitiesResponse> = NewApiRequest("database.getUniversities") {
        GsonHolder.gson.fromJson(it, DatabaseGetUniversitiesResponse::class.java)
    }
    .apply {
        q?.let { addParam("q", it) }
        countryId?.let { addParam("country_id", it, min = 0) }
        cityId?.let { addParam("city_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 10000) }
    }
}
