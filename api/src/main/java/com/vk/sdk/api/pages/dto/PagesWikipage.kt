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
package com.vk.sdk.api.pages.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import kotlin.Int
import kotlin.String

/**
 * @param groupId - Community ID
 * @param id - Page ID
 * @param title - Page title
 * @param views - Views number
 * @param whoCanEdit - Edit settings of the page
 * @param whoCanView - View settings of the page
 * @param creatorId - Page creator ID
 * @param creatorName - Page creator name
 * @param editorId - Last editor ID
 * @param editorName - Last editor name
 */
data class PagesWikipage(
    @SerializedName("group_id")
    val groupId: UserId,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("views")
    val views: Int,
    @SerializedName("who_can_edit")
    val whoCanEdit: PagesPrivacySettings,
    @SerializedName("who_can_view")
    val whoCanView: PagesPrivacySettings,
    @SerializedName("creator_id")
    val creatorId: Int? = null,
    @SerializedName("creator_name")
    val creatorName: Int? = null,
    @SerializedName("editor_id")
    val editorId: Int? = null,
    @SerializedName("editor_name")
    val editorName: String? = null
)
