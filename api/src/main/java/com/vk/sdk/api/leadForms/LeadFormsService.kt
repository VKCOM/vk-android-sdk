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
package com.vk.sdk.api.leadForms

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.leadForms.dto.LeadFormsCreateResponse
import com.vk.sdk.api.leadForms.dto.LeadFormsDeleteResponse
import com.vk.sdk.api.leadForms.dto.LeadFormsForm
import com.vk.sdk.api.leadForms.dto.LeadFormsGetLeadsResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class LeadFormsService {
    /**
     * @param groupId
     * @param name
     * @param title
     * @param description
     * @param questions
     * @param policyLinkUrl
     * @param photo
     * @param confirmation
     * @param siteLinkUrl
     * @param active
     * @param oncePerUser
     * @param pixelCode
     * @param notifyAdmins
     * @param notifyEmails
     * @return [VKRequest] with [LeadFormsCreateResponse]
     */
    fun leadFormsCreate(
        groupId: Int,
        name: String,
        title: String,
        description: String,
        questions: String,
        policyLinkUrl: String,
        photo: String? = null,
        confirmation: String? = null,
        siteLinkUrl: String? = null,
        active: Boolean? = null,
        oncePerUser: Boolean? = null,
        pixelCode: String? = null,
        notifyAdmins: List<Int>? = null,
        notifyEmails: List<String>? = null
    ): VKRequest<LeadFormsCreateResponse> = NewApiRequest("leadForms.create") {
        GsonHolder.gson.fromJson(it, LeadFormsCreateResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId)
        addParam("name", name, maxLength = 100)
        addParam("title", title, maxLength = 60)
        addParam("description", description, maxLength = 600)
        addParam("questions", questions)
        addParam("policy_link_url", policyLinkUrl, maxLength = 200)
        photo?.let { addParam("photo", it) }
        confirmation?.let { addParam("confirmation", it, maxLength = 300) }
        siteLinkUrl?.let { addParam("site_link_url", it, maxLength = 200) }
        active?.let { addParam("active", it) }
        oncePerUser?.let { addParam("once_per_user", it) }
        pixelCode?.let { addParam("pixel_code", it) }
        notifyAdmins?.let { addParam("notify_admins", it) }
        notifyEmails?.let { addParam("notify_emails", it) }
    }

    /**
     * @param groupId
     * @param formId
     * @return [VKRequest] with [LeadFormsDeleteResponse]
     */
    fun leadFormsDelete(groupId: Int, formId: Int): VKRequest<LeadFormsDeleteResponse> =
            NewApiRequest("leadForms.delete") {
        GsonHolder.gson.fromJson(it, LeadFormsDeleteResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId)
        addParam("form_id", formId)
    }

    /**
     * @param groupId
     * @param formId
     * @return [VKRequest] with [LeadFormsForm]
     */
    fun leadFormsGet(groupId: Int, formId: Int): VKRequest<LeadFormsForm> =
            NewApiRequest("leadForms.get") {
        GsonHolder.gson.fromJson(it, LeadFormsForm::class.java)
    }
    .apply {
        addParam("group_id", groupId)
        addParam("form_id", formId)
    }

    /**
     * @param groupId
     * @param formId
     * @param limit
     * @param nextPageToken
     * @return [VKRequest] with [LeadFormsGetLeadsResponse]
     */
    fun leadFormsGetLeads(
        groupId: Int,
        formId: Int,
        limit: Int? = null,
        nextPageToken: String? = null
    ): VKRequest<LeadFormsGetLeadsResponse> = NewApiRequest("leadForms.getLeads") {
        GsonHolder.gson.fromJson(it, LeadFormsGetLeadsResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId)
        addParam("form_id", formId)
        limit?.let { addParam("limit", it, min = 1, max = 1000) }
        nextPageToken?.let { addParam("next_page_token", it) }
    }

    /**
     * @return [VKRequest] with [String]
     */
    fun leadFormsGetUploadURL(): VKRequest<String> = NewApiRequest("leadForms.getUploadURL") {
        GsonHolder.gson.fromJson(it, String::class.java)
    }

    /**
     * @param groupId
     * @return [VKRequest] with [Unit]
     */
    fun leadFormsList(groupId: Int): VKRequest<List<LeadFormsForm>> =
            NewApiRequest("leadForms.list") {
        val typeToken = object: TypeToken<List<LeadFormsForm>>() {}.type
        GsonHolder.gson.fromJson<List<LeadFormsForm>>(it, typeToken)
    }
    .apply {
        addParam("group_id", groupId)
    }

    /**
     * @param groupId
     * @param formId
     * @param name
     * @param title
     * @param description
     * @param questions
     * @param policyLinkUrl
     * @param photo
     * @param confirmation
     * @param siteLinkUrl
     * @param active
     * @param oncePerUser
     * @param pixelCode
     * @param notifyAdmins
     * @param notifyEmails
     * @return [VKRequest] with [LeadFormsCreateResponse]
     */
    fun leadFormsUpdate(
        groupId: Int,
        formId: Int,
        name: String,
        title: String,
        description: String,
        questions: String,
        policyLinkUrl: String,
        photo: String? = null,
        confirmation: String? = null,
        siteLinkUrl: String? = null,
        active: Boolean? = null,
        oncePerUser: Boolean? = null,
        pixelCode: String? = null,
        notifyAdmins: List<Int>? = null,
        notifyEmails: List<String>? = null
    ): VKRequest<LeadFormsCreateResponse> = NewApiRequest("leadForms.update") {
        GsonHolder.gson.fromJson(it, LeadFormsCreateResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId)
        addParam("form_id", formId)
        addParam("name", name, maxLength = 100)
        addParam("title", title, maxLength = 60)
        addParam("description", description, maxLength = 600)
        addParam("questions", questions)
        addParam("policy_link_url", policyLinkUrl, maxLength = 200)
        photo?.let { addParam("photo", it) }
        confirmation?.let { addParam("confirmation", it, maxLength = 300) }
        siteLinkUrl?.let { addParam("site_link_url", it, maxLength = 200) }
        active?.let { addParam("active", it) }
        oncePerUser?.let { addParam("once_per_user", it) }
        pixelCode?.let { addParam("pixel_code", it) }
        notifyAdmins?.let { addParam("notify_admins", it) }
        notifyEmails?.let { addParam("notify_emails", it) }
    }
}
