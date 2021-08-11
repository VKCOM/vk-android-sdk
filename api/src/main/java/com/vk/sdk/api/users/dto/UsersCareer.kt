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
package com.vk.sdk.api.users.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import kotlin.Int
import kotlin.String

/**
 * @param cityId - City ID
 * @param cityName - City name
 * @param company - Company name
 * @param countryId - Country ID
 * @param from - From year
 * @param groupId - Community ID
 * @param id - Career ID
 * @param position - Position
 * @param until - Till year
 */
data class UsersCareer(
    @SerializedName("city_id")
    val cityId: Int? = null,
    @SerializedName("city_name")
    val cityName: String? = null,
    @SerializedName("company")
    val company: String? = null,
    @SerializedName("country_id")
    val countryId: Int? = null,
    @SerializedName("from")
    val from: Int? = null,
    @SerializedName("group_id")
    val groupId: UserId? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("position")
    val position: String? = null,
    @SerializedName("until")
    val until: Int? = null
)
