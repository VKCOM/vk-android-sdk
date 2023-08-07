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
package com.vk.sdk.api.search.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.apps.dto.AppsAppDto
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseLinkDto
import com.vk.sdk.api.groups.dto.GroupsGroupDto
import com.vk.sdk.api.users.dto.UsersUserMinDto
import kotlin.String

/**
 * @param description - Object description
 * @param type
 * @param app
 * @param global - Information whether the object has been found globally
 * @param group
 * @param profile
 * @param section
 * @param link
 */
data class SearchHintDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("type")
    val type: SearchHintTypeDto,
    @SerializedName("app")
    val app: AppsAppDto? = null,
    @SerializedName("global")
    val global: BaseBoolIntDto? = null,
    @SerializedName("group")
    val group: GroupsGroupDto? = null,
    @SerializedName("profile")
    val profile: UsersUserMinDto? = null,
    @SerializedName("section")
    val section: SearchHintSectionDto? = null,
    @SerializedName("link")
    val link: BaseLinkDto? = null
)
