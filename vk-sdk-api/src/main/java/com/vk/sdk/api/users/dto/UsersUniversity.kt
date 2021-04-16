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
 * @param chair - Chair ID
 * @param chairName - Chair name
 * @param city - City ID
 * @param country - Country ID
 * @param educationForm - Education form
 * @param educationStatus - Education status
 * @param faculty - Faculty ID
 * @param facultyName - Faculty name
 * @param graduation - Graduation year
 * @param id - University ID
 * @param name - University name
 * @param universityGroupId
 */
data class UsersUniversity(
    @SerializedName("chair")
    val chair: Int? = null,
    @SerializedName("chair_name")
    val chairName: String? = null,
    @SerializedName("city")
    val city: Int? = null,
    @SerializedName("country")
    val country: Int? = null,
    @SerializedName("education_form")
    val educationForm: String? = null,
    @SerializedName("education_status")
    val educationStatus: String? = null,
    @SerializedName("faculty")
    val faculty: Int? = null,
    @SerializedName("faculty_name")
    val facultyName: String? = null,
    @SerializedName("graduation")
    val graduation: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("university_group_id")
    val universityGroupId: Int? = null
)
