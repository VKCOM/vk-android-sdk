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
import kotlin.Int
import kotlin.String

/**
 * @param city - City ID
 * @param class - School class letter
 * @param country - Country ID
 * @param id - School ID
 * @param name - School name
 * @param type - School type ID
 * @param typeStr - School type name
 * @param yearFrom - Year the user started to study
 * @param yearGraduated - Graduation year
 * @param yearTo - Year the user finished to study
 * @param speciality
 */
data class UsersSchool(
    @SerializedName("city")
    val city: Int? = null,
    @SerializedName("class")
    val `class`: String? = null,
    @SerializedName("country")
    val country: Int? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: Int? = null,
    @SerializedName("type_str")
    val typeStr: String? = null,
    @SerializedName("year_from")
    val yearFrom: Int? = null,
    @SerializedName("year_graduated")
    val yearGraduated: Int? = null,
    @SerializedName("year_to")
    val yearTo: Int? = null,
    @SerializedName("speciality")
    val speciality: String? = null
)
