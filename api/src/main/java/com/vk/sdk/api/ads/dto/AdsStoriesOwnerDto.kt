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
package com.vk.sdk.api.ads.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import kotlin.Boolean
import kotlin.String

/**
 * @param id - Owner id
 * @param href - Href
 * @param name - Name
 * @param photo - Photo
 * @param verify - Verify
 * @param gender - Gender
 * @param nameGet - Name get
 * @param firstName - First name
 * @param firstNameGen - First name gen
 * @param firstNameIns - First name ins
 * @param canFollow - Can follow
 * @param hash - Hash
 */
data class AdsStoriesOwnerDto(
    @SerializedName("id")
    val id: UserId? = null,
    @SerializedName("href")
    val href: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("photo")
    val photo: String? = null,
    @SerializedName("verify")
    val verify: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("name_get")
    val nameGet: String? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("first_name_gen")
    val firstNameGen: String? = null,
    @SerializedName("first_name_ins")
    val firstNameIns: String? = null,
    @SerializedName("can_follow")
    val canFollow: Boolean? = null,
    @SerializedName("hash")
    val hash: String? = null
)
