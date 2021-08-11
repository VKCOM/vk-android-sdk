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
package com.vk.sdk.api.addresses.dto

import com.google.gson.annotations.SerializedName
import kotlin.String

enum class AddressesFields(
    val value: String
) {
    @SerializedName("id")
    ID("id"),

    @SerializedName("title")
    TITLE("title"),

    @SerializedName("address")
    ADDRESS("address"),

    @SerializedName("additional_address")
    ADDITIONAL_ADDRESS("additional_address"),

    @SerializedName("country_id")
    COUNTRY_ID("country_id"),

    @SerializedName("city_id")
    CITY_ID("city_id"),

    @SerializedName("metro_station_id")
    METRO_STATION_ID("metro_station_id"),

    @SerializedName("latitude")
    LATITUDE("latitude"),

    @SerializedName("longitude")
    LONGITUDE("longitude"),

    @SerializedName("distance")
    DISTANCE("distance"),

    @SerializedName("work_info_status")
    WORK_INFO_STATUS("work_info_status"),

    @SerializedName("timetable")
    TIMETABLE("timetable"),

    @SerializedName("phone")
    PHONE("phone"),

    @SerializedName("time_offset")
    TIME_OFFSET("time_offset"),

    @SerializedName("has_vk_taxi")
    HAS_VK_TAXI("has_vk_taxi");
}
