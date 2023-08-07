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

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseCountryDto
import com.vk.sdk.api.database.dto.DatabaseCityByIdDto
import com.vk.sdk.api.database.dto.DatabaseGetChairsResponseDto
import com.vk.sdk.api.database.dto.DatabaseGetCitiesResponseDto
import com.vk.sdk.api.database.dto.DatabaseGetCountriesResponseDto
import com.vk.sdk.api.database.dto.DatabaseGetFacultiesResponseDto
import com.vk.sdk.api.database.dto.DatabaseGetMetroStationsResponseDto
import com.vk.sdk.api.database.dto.DatabaseGetRegionsResponseDto
import com.vk.sdk.api.database.dto.DatabaseGetSchoolsResponseDto
import com.vk.sdk.api.database.dto.DatabaseGetUniversitiesResponseDto
import com.vk.sdk.api.database.dto.DatabaseStationDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class DatabaseService {
    /**
     * Returns list of chairs on a specified faculty.
     *
     * @param facultyId - id of the faculty to get chairs from
     * @param offset - offset required to get a certain subset of chairs
     * @param count - amount of chairs to get
     * @return [VKRequest] with [DatabaseGetChairsResponseDto]
     */
    fun databaseGetChairs(
        facultyId: Int,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetChairsResponseDto> = NewApiRequest("database.getChairs") {
        GsonHolder.gson.parse<DatabaseGetChairsResponseDto>(it)
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
     * @return [VKRequest] with [DatabaseGetCitiesResponseDto]
     */
    fun databaseGetCities(
        countryId: Int? = null,
        regionId: Int? = null,
        q: String? = null,
        needAll: Boolean? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetCitiesResponseDto> = NewApiRequest("database.getCities") {
        GsonHolder.gson.parse<DatabaseGetCitiesResponseDto>(it)
    }
    .apply {
        countryId?.let { addParam("country_id", it, min = 0) }
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
    fun databaseGetCitiesById(cityIds: List<Int>? = null): VKRequest<List<DatabaseCityByIdDto>> =
            NewApiRequest("database.getCitiesById") {
        GsonHolder.gson.parseList<DatabaseCityByIdDto>(it)
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
     * @return [VKRequest] with [DatabaseGetCountriesResponseDto]
     */
    fun databaseGetCountries(
        needAll: Boolean? = null,
        code: String? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetCountriesResponseDto> = NewApiRequest("database.getCountries") {
        GsonHolder.gson.parse<DatabaseGetCountriesResponseDto>(it)
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
    fun databaseGetCountriesById(countryIds: List<Int>? = null): VKRequest<List<BaseCountryDto>> =
            NewApiRequest("database.getCountriesById") {
        GsonHolder.gson.parseList<BaseCountryDto>(it)
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
     * @return [VKRequest] with [DatabaseGetFacultiesResponseDto]
     */
    fun databaseGetFaculties(
        universityId: Int,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetFacultiesResponseDto> = NewApiRequest("database.getFaculties") {
        GsonHolder.gson.parse<DatabaseGetFacultiesResponseDto>(it)
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
     * @param extended
     * @return [VKRequest] with [DatabaseGetMetroStationsResponseDto]
     */
    fun databaseGetMetroStations(
        cityId: Int,
        offset: Int? = null,
        count: Int? = null,
        extended: Boolean? = null
    ): VKRequest<DatabaseGetMetroStationsResponseDto> = NewApiRequest("database.getMetroStations") {
        GsonHolder.gson.parse<DatabaseGetMetroStationsResponseDto>(it)
    }
    .apply {
        addParam("city_id", cityId, min = 0)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 500) }
        extended?.let { addParam("extended", it) }
    }

    /**
     * Get metro station by his id
     *
     * @param stationIds
     * @return [VKRequest] with [Unit]
     */
    fun databaseGetMetroStationsById(stationIds: List<Int>? = null):
            VKRequest<List<DatabaseStationDto>> = NewApiRequest("database.getMetroStationsById") {
        GsonHolder.gson.parseList<DatabaseStationDto>(it)
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
     * @return [VKRequest] with [DatabaseGetRegionsResponseDto]
     */
    fun databaseGetRegions(
        countryId: Int,
        q: String? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetRegionsResponseDto> = NewApiRequest("database.getRegions") {
        GsonHolder.gson.parse<DatabaseGetRegionsResponseDto>(it)
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
        GsonHolder.gson.parseList<List<String>>(it)
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
     * @return [VKRequest] with [DatabaseGetSchoolsResponseDto]
     */
    fun databaseGetSchools(
        cityId: Int,
        q: String? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetSchoolsResponseDto> = NewApiRequest("database.getSchools") {
        GsonHolder.gson.parse<DatabaseGetSchoolsResponseDto>(it)
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
     * @return [VKRequest] with [DatabaseGetUniversitiesResponseDto]
     */
    fun databaseGetUniversities(
        q: String? = null,
        countryId: Int? = null,
        cityId: Int? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<DatabaseGetUniversitiesResponseDto> = NewApiRequest("database.getUniversities") {
        GsonHolder.gson.parse<DatabaseGetUniversitiesResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it) }
        countryId?.let { addParam("country_id", it, min = 0) }
        cityId?.let { addParam("city_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 10000) }
    }

    object DatabaseGetChairsRestrictions {
        const val FACULTY_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 10000
    }

    object DatabaseGetCitiesRestrictions {
        const val COUNTRY_ID_MIN: Long = 0

        const val REGION_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object DatabaseGetCountriesRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object DatabaseGetFacultiesRestrictions {
        const val UNIVERSITY_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 10000
    }

    object DatabaseGetMetroStationsRestrictions {
        const val CITY_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 500
    }

    object DatabaseGetRegionsRestrictions {
        const val COUNTRY_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object DatabaseGetSchoolClassesRestrictions {
        const val COUNTRY_ID_MIN: Long = 0
    }

    object DatabaseGetSchoolsRestrictions {
        const val CITY_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 10000
    }

    object DatabaseGetUniversitiesRestrictions {
        const val COUNTRY_ID_MIN: Long = 0

        const val CITY_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 10000
    }
}
