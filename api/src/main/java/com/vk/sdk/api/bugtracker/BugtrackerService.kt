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
package com.vk.sdk.api.bugtracker

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.dto.BaseUploadServerDto
import com.vk.sdk.api.base.dto.BaseUserGroupFieldsDto
import com.vk.sdk.api.bugtracker.dto.BugtrackerAddCompanyGroupsMembersResponseDto
import com.vk.sdk.api.bugtracker.dto.BugtrackerAddCompanyMembersResponseDto
import com.vk.sdk.api.bugtracker.dto.BugtrackerCreateCommentResponseDto
import com.vk.sdk.api.bugtracker.dto.BugtrackerGetCompanyGroupMembersResponseDto
import com.vk.sdk.api.bugtracker.dto.BugtrackerGetCompanyMembersFilterRoleDto
import com.vk.sdk.api.bugtracker.dto.BugtrackerGetCompanyMembersResponseDto
import com.vk.sdk.api.bugtracker.dto.BugtrackerGetDownloadVersionUrlResponseDto
import com.vk.sdk.api.bugtracker.dto.BugtrackerSetCompanyMemberRoleRoleDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class BugtrackerService {
    /**
     * @param companyId
     * @param userIds
     * @param companyGroupIds
     * @return [VKRequest] with [BugtrackerAddCompanyGroupsMembersResponseDto]
     */
    fun bugtrackerAddCompanyGroupsMembers(
        companyId: Int,
        userIds: List<UserId>,
        companyGroupIds: List<Int>
    ): VKRequest<BugtrackerAddCompanyGroupsMembersResponseDto> =
            NewApiRequest("bugtracker.addCompanyGroupsMembers") {
        GsonHolder.gson.parse<BugtrackerAddCompanyGroupsMembersResponseDto>(it)
    }
    .apply {
        addParam("company_id", companyId, min = 0)
        addParam("user_ids", userIds)
        addParam("company_group_ids", companyGroupIds)
    }

    /**
     * @param userIds
     * @param companyId
     * @return [VKRequest] with [BugtrackerAddCompanyMembersResponseDto]
     */
    fun bugtrackerAddCompanyMembers(userIds: List<UserId>, companyId: Int):
            VKRequest<BugtrackerAddCompanyMembersResponseDto> =
            NewApiRequest("bugtracker.addCompanyMembers") {
        GsonHolder.gson.parse<BugtrackerAddCompanyMembersResponseDto>(it)
    }
    .apply {
        addParam("user_ids", userIds)
        addParam("company_id", companyId, min = 0)
    }

    /**
     * @param bugreportId
     * @param status
     * @param comment
     * @param fromStatuses
     * @param notInStatuses
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun bugtrackerChangeBugreportStatus(
        bugreportId: Int,
        status: Int? = null,
        comment: String? = null,
        fromStatuses: List<Int>? = null,
        notInStatuses: List<Int>? = null
    ): VKRequest<BaseBoolIntDto> = NewApiRequest("bugtracker.changeBugreportStatus") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("bugreport_id", bugreportId, min = 0)
        status?.let { addParam("status", it, min = 0) }
        comment?.let { addParam("comment", it) }
        fromStatuses?.let { addParam("from_statuses", it) }
        notInStatuses?.let { addParam("not_in_statuses", it) }
    }

    /**
     * Creates the comment to bugreport
     *
     * @param bugreportId
     * @param text
     * @param hidden
     * @param force
     * @return [VKRequest] with [BugtrackerCreateCommentResponseDto]
     */
    fun bugtrackerCreateComment(
        bugreportId: Int,
        text: String? = null,
        hidden: Boolean? = null,
        force: Boolean? = null
    ): VKRequest<BugtrackerCreateCommentResponseDto> = NewApiRequest("bugtracker.createComment") {
        GsonHolder.gson.parse<BugtrackerCreateCommentResponseDto>(it)
    }
    .apply {
        addParam("bugreport_id", bugreportId, min = 0)
        text?.let { addParam("text", it, maxLength = 4000) }
        hidden?.let { addParam("hidden", it) }
        force?.let { addParam("force", it) }
    }

    /**
     * @param companyId
     * @param companyGroupId
     * @param count
     * @param offset
     * @param filterName
     * @param extended
     * @param fields
     * @return [VKRequest] with [BugtrackerGetCompanyGroupMembersResponseDto]
     */
    fun bugtrackerGetCompanyGroupMembers(
        companyId: Int,
        companyGroupId: Int,
        count: Int? = null,
        offset: Int? = null,
        filterName: String? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null
    ): VKRequest<BugtrackerGetCompanyGroupMembersResponseDto> =
            NewApiRequest("bugtracker.getCompanyGroupMembers") {
        GsonHolder.gson.parse<BugtrackerGetCompanyGroupMembersResponseDto>(it)
    }
    .apply {
        addParam("company_id", companyId, min = 0)
        addParam("company_group_id", companyGroupId, min = 0)
        count?.let { addParam("count", it, min = 1, max = 100) }
        offset?.let { addParam("offset", it, min = 0) }
        filterName?.let { addParam("filter_name", it) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * @param companyId
     * @param count
     * @param offset
     * @param filterName
     * @param filterRole
     * @param filterNotGroup
     * @param filterMemberIds
     * @param extended
     * @param fields
     * @param extra
     * @return [VKRequest] with [BugtrackerGetCompanyMembersResponseDto]
     */
    fun bugtrackerGetCompanyMembers(
        companyId: Int,
        count: Int? = null,
        offset: Int? = null,
        filterName: String? = null,
        filterRole: BugtrackerGetCompanyMembersFilterRoleDto? = null,
        filterNotGroup: Int? = null,
        filterMemberIds: List<UserId>? = null,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null,
        extra: Boolean? = null
    ): VKRequest<BugtrackerGetCompanyMembersResponseDto> =
            NewApiRequest("bugtracker.getCompanyMembers") {
        GsonHolder.gson.parse<BugtrackerGetCompanyMembersResponseDto>(it)
    }
    .apply {
        addParam("company_id", companyId, min = 0)
        count?.let { addParam("count", it, min = 1, max = 100) }
        offset?.let { addParam("offset", it, min = 0) }
        filterName?.let { addParam("filter_name", it) }
        filterRole?.let { addParam("filter_role", it.value) }
        filterNotGroup?.let { addParam("filter_not_group", it, min = 0) }
        filterMemberIds?.let { addParam("filter_member_ids", it) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        extra?.let { addParam("extra", it) }
    }

    /**
     * @param productId
     * @param versionId
     * @param ttl
     * @return [VKRequest] with [BugtrackerGetDownloadVersionUrlResponseDto]
     */
    fun bugtrackerGetDownloadVersionUrl(
        productId: Int,
        versionId: Int,
        ttl: Int? = null
    ): VKRequest<BugtrackerGetDownloadVersionUrlResponseDto> =
            NewApiRequest("bugtracker.getDownloadVersionUrl") {
        GsonHolder.gson.parse<BugtrackerGetDownloadVersionUrlResponseDto>(it)
    }
    .apply {
        addParam("product_id", productId, min = 0)
        addParam("version_id", versionId, min = 0)
        ttl?.let { addParam("ttl", it, min = 1, max = 31536000) }
    }

    /**
     * @param productId
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun bugtrackerGetProductBuildUploadServer(productId: Int): VKRequest<BaseUploadServerDto> =
            NewApiRequest("bugtracker.getProductBuildUploadServer") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }
    .apply {
        addParam("product_id", productId, min = 0)
    }

    /**
     * @param companyId
     * @param userId
     * @param companyGroupId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun bugtrackerRemoveCompanyGroupMember(
        companyId: Int,
        userId: UserId,
        companyGroupId: Int
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("bugtracker.removeCompanyGroupMember") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("company_id", companyId, min = 0)
        addParam("user_id", userId)
        addParam("company_group_id", companyGroupId, min = 0)
    }

    /**
     * @param userId
     * @param companyId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun bugtrackerRemoveCompanyMember(userId: UserId, companyId: Int): VKRequest<BaseOkResponseDto>
            = NewApiRequest("bugtracker.removeCompanyMember") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("company_id", companyId, min = 0)
    }

    /**
     * @param title
     * @param productId
     * @param versionId
     * @param releaseNotes
     * @param visible
     * @param setRft
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun bugtrackerSaveProductVersion(
        title: String,
        productId: Int? = null,
        versionId: Int? = null,
        releaseNotes: String? = null,
        visible: Boolean? = null,
        setRft: Boolean? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("bugtracker.saveProductVersion") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("title", title)
        productId?.let { addParam("product_id", it, min = 0) }
        versionId?.let { addParam("version_id", it) }
        releaseNotes?.let { addParam("release_notes", it) }
        visible?.let { addParam("visible", it) }
        setRft?.let { addParam("set_rft", it) }
    }

    /**
     * @param userId
     * @param companyId
     * @param role
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun bugtrackerSetCompanyMemberRole(
        userId: UserId,
        companyId: Int,
        role: BugtrackerSetCompanyMemberRoleRoleDto
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("bugtracker.setCompanyMemberRole") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("company_id", companyId, min = 0)
        addParam("role", role.value)
    }

    /**
     * @param productId
     * @param isOver
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun bugtrackerSetProductIsOver(productId: Int, isOver: Boolean? = null):
            VKRequest<BaseOkResponseDto> = NewApiRequest("bugtracker.setProductIsOver") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("product_id", productId, min = 0)
        isOver?.let { addParam("is_over", it) }
    }

    object BugtrackerAddCompanyGroupsMembersRestrictions {
        const val COMPANY_ID_MIN: Long = 0
    }

    object BugtrackerAddCompanyMembersRestrictions {
        const val COMPANY_ID_MIN: Long = 0
    }

    object BugtrackerChangeBugreportStatusRestrictions {
        const val BUGREPORT_ID_MIN: Long = 0

        const val STATUS_MIN: Long = 0
    }

    object BugtrackerCreateCommentRestrictions {
        const val BUGREPORT_ID_MIN: Long = 0

        const val TEXT_MAX_LENGTH: Int = 4000
    }

    object BugtrackerGetCompanyGroupMembersRestrictions {
        const val COMPANY_ID_MIN: Long = 0

        const val COMPANY_GROUP_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 1

        const val COUNT_MAX: Long = 100

        const val OFFSET_MIN: Long = 0
    }

    object BugtrackerGetCompanyMembersRestrictions {
        const val COMPANY_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 1

        const val COUNT_MAX: Long = 100

        const val OFFSET_MIN: Long = 0

        const val FILTER_ROLE_MIN: Long = 0

        const val FILTER_NOT_GROUP_MIN: Long = 0
    }

    object BugtrackerGetDownloadVersionUrlRestrictions {
        const val PRODUCT_ID_MIN: Long = 0

        const val VERSION_ID_MIN: Long = 0

        const val TTL_MIN: Long = 1

        const val TTL_MAX: Long = 31536000
    }

    object BugtrackerGetProductBuildUploadServerRestrictions {
        const val PRODUCT_ID_MIN: Long = 0
    }

    object BugtrackerRemoveCompanyGroupMemberRestrictions {
        const val COMPANY_ID_MIN: Long = 0

        const val COMPANY_GROUP_ID_MIN: Long = 0
    }

    object BugtrackerRemoveCompanyMemberRestrictions {
        const val USER_ID_MIN: Long = 1

        const val COMPANY_ID_MIN: Long = 0
    }

    object BugtrackerSaveProductVersionRestrictions {
        const val PRODUCT_ID_MIN: Long = 0
    }

    object BugtrackerSetCompanyMemberRoleRestrictions {
        const val USER_ID_MIN: Long = 1

        const val COMPANY_ID_MIN: Long = 0

        const val ROLE_MIN: Long = 0
    }

    object BugtrackerSetProductIsOverRestrictions {
        const val PRODUCT_ID_MIN: Long = 0
    }
}
