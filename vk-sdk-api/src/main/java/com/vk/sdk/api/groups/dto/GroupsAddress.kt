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
import kotlin.Float
import kotlin.Int
import kotlin.String

/**
 * @param id - Address id
 * @param additionalAddress - Additional address to the place (6 floor, left door)
 * @param address - String address to the place (Nevsky, 28)
 * @param cityId - City id of address
 * @param countryId - Country id of address
 * @param distance - Distance from the point
 * @param latitude - Address latitude
 * @param longitude - Address longitude
 * @param metroStationId - Metro id of address
 * @param phone - Address phone
 * @param timeOffset - Time offset int minutes from utc time
 * @param timetable - Week timetable for the address
 * @param title - Title of the place (Zinger, etc)
 * @param workInfoStatus - Status of information about timetable
 * @param placeId
 */
data class GroupsAddress(
    @SerializedName("id")
    val id: Int,
    @SerializedName("additional_address")
    val additionalAddress: String? = null,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("city_id")
    val cityId: Int? = null,
    @SerializedName("country_id")
    val countryId: Int? = null,
    @SerializedName("distance")
    val distance: Int? = null,
    @SerializedName("latitude")
    val latitude: Float? = null,
    @SerializedName("longitude")
    val longitude: Float? = null,
    @SerializedName("metro_station_id")
    val metroStationId: Int? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("time_offset")
    val timeOffset: Int? = null,
    @SerializedName("timetable")
    val timetable: GroupsAddressTimetable? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("work_info_status")
    val workInfoStatus: GroupsAddressWorkInfoStatus? = null,
    @SerializedName("place_id")
    val placeId: Int? = null
)
