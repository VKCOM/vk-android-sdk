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
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * @param firstName User first name
 * @param id User ID
 * @param lastName User last name
 * @param deactivated Returns if a profile is deleted or blocked
 * @param hidden Returns if a profile is hidden.
 * @param canAccessClosed no description
 * @param isClosed no description
 */
data class UsersUserMin(
    @SerializedName(value="first_name")
    val firstName: String,
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="last_name")
    val lastName: String,
    @SerializedName(value="deactivated")
    val deactivated: String? = null,
    @SerializedName(value="hidden")
    val hidden: Int? = null,
    @SerializedName(value="can_access_closed")
    val canAccessClosed: Boolean? = null,
    @SerializedName(value="is_closed")
    val isClosed: Boolean? = null
)
