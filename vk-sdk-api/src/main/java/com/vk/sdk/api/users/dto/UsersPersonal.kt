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
import kotlin.collections.List

/**
 * @param alcohol - User's views on alcohol
 * @param inspiredBy - User's inspired by
 * @param langs
 * @param lifeMain - User's personal priority in life
 * @param peopleMain - User's personal priority in people
 * @param political - User's political views
 * @param religion - User's religion
 * @param religionId - User's religion id
 * @param smoking - User's views on smoking
 */
data class UsersPersonal(
    @SerializedName("alcohol")
    val alcohol: Int? = null,
    @SerializedName("inspired_by")
    val inspiredBy: String? = null,
    @SerializedName("langs")
    val langs: List<String>? = null,
    @SerializedName("life_main")
    val lifeMain: Int? = null,
    @SerializedName("people_main")
    val peopleMain: Int? = null,
    @SerializedName("political")
    val political: Int? = null,
    @SerializedName("religion")
    val religion: String? = null,
    @SerializedName("religion_id")
    val religionId: Int? = null,
    @SerializedName("smoking")
    val smoking: Int? = null
)
