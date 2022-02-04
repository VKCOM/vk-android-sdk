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
package com.vk.sdk.api.leadForms.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param formId
 * @param groupId
 * @param leadsCount
 * @param url
 * @param photo
 * @param name
 * @param title
 * @param description
 * @param confirmation
 * @param siteLinkUrl
 * @param policyLinkUrl
 * @param questions
 * @param active
 * @param pixelCode
 * @param oncePerUser
 * @param notifyAdmins
 * @param notifyEmails
 */
data class LeadFormsForm(
    @SerializedName("form_id")
    val formId: Int,
    @SerializedName("group_id")
    val groupId: UserId,
    @SerializedName("leads_count")
    val leadsCount: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("photo")
    val photo: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("confirmation")
    val confirmation: String? = null,
    @SerializedName("site_link_url")
    val siteLinkUrl: String? = null,
    @SerializedName("policy_link_url")
    val policyLinkUrl: String? = null,
    @SerializedName("questions")
    val questions: List<LeadFormsQuestionItem>? = null,
    @SerializedName("active")
    val active: BaseBoolInt? = null,
    @SerializedName("pixel_code")
    val pixelCode: String? = null,
    @SerializedName("once_per_user")
    val oncePerUser: Int? = null,
    @SerializedName("notify_admins")
    val notifyAdmins: String? = null,
    @SerializedName("notify_emails")
    val notifyEmails: String? = null
)
