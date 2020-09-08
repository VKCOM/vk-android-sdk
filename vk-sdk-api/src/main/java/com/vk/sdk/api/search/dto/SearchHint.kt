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
import com.vk.sdk.api.apps.dto.AppsApp
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.groups.dto.GroupsGroup
import com.vk.sdk.api.users.dto.UsersUserMin
import kotlin.String

/**
 * @param description Object description
 * @param section no description
 * @param type no description
 * @param app no description
 * @param global Information whether the object has been found globally
 * @param group no description
 * @param profile no description
 */
data class SearchHint(
    @SerializedName(value="description")
    val description: String,
    @SerializedName(value="section")
    val section: SearchHintSection,
    @SerializedName(value="type")
    val type: SearchHintType,
    @SerializedName(value="app")
    val app: AppsApp? = null,
    @SerializedName(value="global")
    val global: BaseBoolInt? = null,
    @SerializedName(value="group")
    val group: GroupsGroup? = null,
    @SerializedName(value="profile")
    val profile: UsersUserMin? = null
)
