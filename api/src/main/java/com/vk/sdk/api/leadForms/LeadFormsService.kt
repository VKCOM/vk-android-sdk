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

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.NewApiRequest
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
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
     * @return [VKRequest] with [Unit]
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
    ): VKRequest<Unit> = NewApiRequest("leadForms.create") {
    }
    .apply {
        addParam("group_id", groupId)
        addParam("name", name)
        addParam("title", title)
        addParam("description", description)
        addParam("questions", questions)
        addParam("policy_link_url", policyLinkUrl)
        photo?.let { addParam("photo", it) }
        confirmation?.let { addParam("confirmation", it) }
        siteLinkUrl?.let { addParam("site_link_url", it) }
        active?.let { addParam("active", it) }
        oncePerUser?.let { addParam("once_per_user", it) }
        pixelCode?.let { addParam("pixel_code", it) }
        notifyAdmins?.let { addParam("notify_admins", it) }
        notifyEmails?.let { addParam("notify_emails", it) }
    }

    /**
     * @param groupId
     * @param formId
     * @return [VKRequest] with [Unit]
     */
    fun leadFormsDelete(groupId: Int, formId: Int): VKRequest<Unit> =
            NewApiRequest("leadForms.delete") {
    }
    .apply {
        addParam("group_id", groupId)
        addParam("form_id", formId)
    }

    /**
     * @param groupId
     * @param formId
     * @return [VKRequest] with [Unit]
     */
    fun leadFormsGet(groupId: Int, formId: Int): VKRequest<Unit> = NewApiRequest("leadForms.get") {
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
     * @return [VKRequest] with [Unit]
     */
    fun leadFormsGetLeads(
        groupId: Int,
        formId: Int,
        limit: Int? = null,
        nextPageToken: String? = null
    ): VKRequest<Unit> = NewApiRequest("leadForms.getLeads") {
    }
    .apply {
        addParam("group_id", groupId)
        addParam("form_id", formId)
        limit?.let { addParam("limit", it) }
        nextPageToken?.let { addParam("next_page_token", it) }
    }

    /**
     * @return [VKRequest] with [Unit]
     */
    fun leadFormsGetUploadURL(): VKRequest<Unit> = NewApiRequest("leadForms.getUploadURL") {
    }

    /**
     * @param groupId
     * @return [VKRequest] with [Unit]
     */
    fun leadFormsList(groupId: Int): VKRequest<Unit> = NewApiRequest("leadForms.list") {
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
     * @return [VKRequest] with [Unit]
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
    ): VKRequest<Unit> = NewApiRequest("leadForms.update") {
    }
    .apply {
        addParam("group_id", groupId)
        addParam("form_id", formId)
        addParam("name", name)
        addParam("title", title)
        addParam("description", description)
        addParam("questions", questions)
        addParam("policy_link_url", policyLinkUrl)
        photo?.let { addParam("photo", it) }
        confirmation?.let { addParam("confirmation", it) }
        siteLinkUrl?.let { addParam("site_link_url", it) }
        active?.let { addParam("active", it) }
        oncePerUser?.let { addParam("once_per_user", it) }
        pixelCode?.let { addParam("pixel_code", it) }
        notifyAdmins?.let { addParam("notify_admins", it) }
        notifyEmails?.let { addParam("notify_emails", it) }
    }
}
