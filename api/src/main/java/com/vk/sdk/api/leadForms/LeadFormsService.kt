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
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.leadForms.dto.LeadFormsCreateResponseDto
import com.vk.sdk.api.leadForms.dto.LeadFormsDeleteResponseDto
import com.vk.sdk.api.leadForms.dto.LeadFormsFormDto
import com.vk.sdk.api.leadForms.dto.LeadFormsGetLeadsResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
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
     * @return [VKRequest] with [LeadFormsCreateResponseDto]
     */
    fun leadFormsCreate(
        groupId: UserId,
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
    ): VKRequest<LeadFormsCreateResponseDto> = NewApiRequest("leadForms.create") {
        GsonHolder.gson.parse<LeadFormsCreateResponseDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
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
     * @return [VKRequest] with [LeadFormsDeleteResponseDto]
     */
    fun leadFormsDelete(groupId: UserId, formId: Int): VKRequest<LeadFormsDeleteResponseDto> =
            NewApiRequest("leadForms.delete") {
        GsonHolder.gson.parse<LeadFormsDeleteResponseDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("form_id", formId)
    }

    /**
     * @param groupId
     * @param formId
     * @return [VKRequest] with [LeadFormsFormDto]
     */
    fun leadFormsGet(groupId: UserId, formId: Int): VKRequest<LeadFormsFormDto> =
            NewApiRequest("leadForms.get") {
        GsonHolder.gson.parse<LeadFormsFormDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("form_id", formId)
    }

    /**
     * @param groupId
     * @param formId
     * @param limit
     * @param nextPageToken
     * @return [VKRequest] with [LeadFormsGetLeadsResponseDto]
     */
    fun leadFormsGetLeads(
        groupId: UserId,
        formId: Int,
        limit: Int? = null,
        nextPageToken: String? = null
    ): VKRequest<LeadFormsGetLeadsResponseDto> = NewApiRequest("leadForms.getLeads") {
        GsonHolder.gson.parse<LeadFormsGetLeadsResponseDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("form_id", formId)
        limit?.let { addParam("limit", it, min = 1, max = 1000) }
        nextPageToken?.let { addParam("next_page_token", it) }
    }

    /**
     * @return [VKRequest] with [String]
     */
    fun leadFormsGetUploadURL(): VKRequest<String> = NewApiRequest("leadForms.getUploadURL") {
        GsonHolder.gson.parse<String>(it)
    }

    /**
     * @param groupId
     * @return [VKRequest] with [Unit]
     */
    fun leadFormsList(groupId: UserId): VKRequest<List<LeadFormsFormDto>> =
            NewApiRequest("leadForms.list") {
        GsonHolder.gson.parseList<LeadFormsFormDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
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
     * @return [VKRequest] with [LeadFormsCreateResponseDto]
     */
    fun leadFormsUpdate(
        groupId: UserId,
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
    ): VKRequest<LeadFormsCreateResponseDto> = NewApiRequest("leadForms.update") {
        GsonHolder.gson.parse<LeadFormsCreateResponseDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
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

    object LeadFormsCreateRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val NAME_MAX_LENGTH: Int = 100

        const val TITLE_MAX_LENGTH: Int = 60

        const val DESCRIPTION_MAX_LENGTH: Int = 600

        const val POLICY_LINK_URL_MAX_LENGTH: Int = 200

        const val CONFIRMATION_MAX_LENGTH: Int = 300

        const val SITE_LINK_URL_MAX_LENGTH: Int = 200
    }

    object LeadFormsDeleteRestrictions {
        const val GROUP_ID_MIN: Long = 1
    }

    object LeadFormsGetRestrictions {
        const val GROUP_ID_MIN: Long = 1
    }

    object LeadFormsGetLeadsRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val LIMIT_MIN: Long = 1

        const val LIMIT_MAX: Long = 1000
    }

    object LeadFormsListRestrictions {
        const val GROUP_ID_MIN: Long = 1
    }

    object LeadFormsUpdateRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val NAME_MAX_LENGTH: Int = 100

        const val TITLE_MAX_LENGTH: Int = 60

        const val DESCRIPTION_MAX_LENGTH: Int = 600

        const val POLICY_LINK_URL_MAX_LENGTH: Int = 200

        const val CONFIRMATION_MAX_LENGTH: Int = 300

        const val SITE_LINK_URL_MAX_LENGTH: Int = 200
    }
}
