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
package com.vk.sdk.api.callback.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.groups.dto.GroupsGroupAudio
import com.vk.sdk.api.groups.dto.GroupsGroupFullAgeLimits
import com.vk.sdk.api.groups.dto.GroupsGroupIsClosed
import com.vk.sdk.api.groups.dto.GroupsGroupPhotos
import com.vk.sdk.api.groups.dto.GroupsGroupVideo
import com.vk.sdk.api.groups.dto.GroupsGroupWall
import kotlin.Int
import kotlin.String

/**
 * @param title no description
 * @param description no description
 * @param access no description
 * @param screenName no description
 * @param publicCategory no description
 * @param publicSubcategory no description
 * @param ageLimits no description
 * @param website no description
 * @param enableStatusDefault no description
 * @param enableAudio no description
 * @param enableVideo no description
 * @param enablePhoto no description
 * @param enableMarket no description
 */
data class CallbackGroupSettingsChanges(
    @SerializedName(value="title")
    val title: String? = null,
    @SerializedName(value="description")
    val description: String? = null,
    @SerializedName(value="access")
    val access: GroupsGroupIsClosed? = null,
    @SerializedName(value="screen_name")
    val screenName: String? = null,
    @SerializedName(value="public_category")
    val publicCategory: Int? = null,
    @SerializedName(value="public_subcategory")
    val publicSubcategory: Int? = null,
    @SerializedName(value="age_limits")
    val ageLimits: GroupsGroupFullAgeLimits? = null,
    @SerializedName(value="website")
    val website: String? = null,
    @SerializedName(value="enable_status_default")
    val enableStatusDefault: GroupsGroupWall? = null,
    @SerializedName(value="enable_audio")
    val enableAudio: GroupsGroupAudio? = null,
    @SerializedName(value="enable_video")
    val enableVideo: GroupsGroupVideo? = null,
    @SerializedName(value="enable_photo")
    val enablePhoto: GroupsGroupPhotos? = null,
    @SerializedName(value="enable_market")
    val enableMarket: CallbackGroupMarket? = null
)
