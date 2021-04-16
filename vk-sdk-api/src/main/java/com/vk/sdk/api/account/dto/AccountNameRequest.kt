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
package com.vk.sdk.api.account.dto

import com.google.gson.annotations.SerializedName
import kotlin.Int
import kotlin.String

/**
 * @param firstName - First name in request
 * @param id - Request ID needed to cancel the request
 * @param lastName - Last name in request
 * @param status
 * @param lang - Text to display to user
 * @param linkHref - href for link in lang field
 * @param linkLabel - label to display for link in lang field
 */
data class AccountNameRequest(
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("last_name")
    val lastName: String? = null,
    @SerializedName("status")
    val status: AccountNameRequestStatus? = null,
    @SerializedName("lang")
    val lang: String? = null,
    @SerializedName("link_href")
    val linkHref: String? = null,
    @SerializedName("link_label")
    val linkLabel: String? = null
)
