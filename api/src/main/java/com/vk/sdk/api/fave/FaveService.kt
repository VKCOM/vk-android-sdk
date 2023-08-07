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
package com.vk.sdk.api.fave

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.dto.BaseUserGroupFieldsDto
import com.vk.sdk.api.fave.dto.FaveAddTagPositionDto
import com.vk.sdk.api.fave.dto.FaveGetExtendedItemTypeDto
import com.vk.sdk.api.fave.dto.FaveGetExtendedResponseDto
import com.vk.sdk.api.fave.dto.FaveGetItemTypeDto
import com.vk.sdk.api.fave.dto.FaveGetPagesResponseDto
import com.vk.sdk.api.fave.dto.FaveGetPagesTypeDto
import com.vk.sdk.api.fave.dto.FaveGetResponseDto
import com.vk.sdk.api.fave.dto.FaveGetTagsResponseDto
import com.vk.sdk.api.fave.dto.FaveSetTagsItemTypeDto
import com.vk.sdk.api.fave.dto.FaveTagDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class FaveService {
    /**
     * @param url
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveAddArticle(url: String): VKRequest<BaseOkResponseDto> =
            NewApiRequest("fave.addArticle") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("url", url)
    }

    /**
     * Adds a link to user faves.
     *
     * @param link - Link URL.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveAddLink(link: String): VKRequest<BaseOkResponseDto> = NewApiRequest("fave.addLink") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("link", link)
    }

    /**
     * @param userId
     * @param groupId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveAddPage(userId: UserId? = null, groupId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("fave.addPage") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * @param ownerId
     * @param id
     * @param accessKey
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveAddPost(
        ownerId: UserId,
        id: Int,
        accessKey: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("fave.addPost") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
        accessKey?.let { addParam("access_key", it) }
    }

    /**
     * @param ownerId
     * @param id
     * @param accessKey
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveAddProduct(
        ownerId: UserId,
        id: Int,
        accessKey: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("fave.addProduct") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
        accessKey?.let { addParam("access_key", it) }
    }

    /**
     * @param name
     * @param position
     * @return [VKRequest] with [FaveTagDto]
     */
    fun faveAddTag(name: String? = null, position: FaveAddTagPositionDto? = null):
            VKRequest<FaveTagDto> = NewApiRequest("fave.addTag") {
        GsonHolder.gson.parse<FaveTagDto>(it)
    }
    .apply {
        name?.let { addParam("name", it, maxLength = 50) }
        position?.let { addParam("position", it.value) }
    }

    /**
     * @param ownerId
     * @param id
     * @param accessKey
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveAddVideo(
        ownerId: UserId,
        id: Int,
        accessKey: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("fave.addVideo") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
        accessKey?.let { addParam("access_key", it) }
    }

    /**
     * @param id
     * @param name
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveEditTag(id: Int, name: String): VKRequest<BaseOkResponseDto> =
            NewApiRequest("fave.editTag") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("id", id)
        addParam("name", name, maxLength = 50)
    }

    /**
     * @param extended - '1' - to return additional 'wall', 'profiles', and 'groups' fields. By
     * default_ '0'.
     * @param itemType
     * @param tagId - Tag ID.
     * @param offset - Offset needed to return a specific subset of users.
     * @param count - Number of users to return.
     * @param fields
     * @param isFromSnackbar
     * @return [VKRequest] with [FaveGetResponseDto]
     */
    fun faveGet(
        extended: Boolean? = null,
        itemType: FaveGetItemTypeDto? = null,
        tagId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: String? = null,
        isFromSnackbar: Boolean? = null
    ): VKRequest<FaveGetResponseDto> = NewApiRequest("fave.get") {
        GsonHolder.gson.parse<FaveGetResponseDto>(it)
    }
    .apply {
        extended?.let { addParam("extended", it) }
        itemType?.let { addParam("item_type", it.value) }
        tagId?.let { addParam("tag_id", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 1, max = 100) }
        fields?.let { addParam("fields", it) }
        isFromSnackbar?.let { addParam("is_from_snackbar", it) }
    }

    /**
     * @param itemType
     * @param tagId - Tag ID.
     * @param offset - Offset needed to return a specific subset of users.
     * @param count - Number of users to return.
     * @param fields
     * @param isFromSnackbar
     * @return [VKRequest] with [FaveGetExtendedResponseDto]
     */
    fun faveGetExtended(
        itemType: FaveGetExtendedItemTypeDto? = null,
        tagId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: String? = null,
        isFromSnackbar: Boolean? = null
    ): VKRequest<FaveGetExtendedResponseDto> = NewApiRequest("fave.get") {
        GsonHolder.gson.parse<FaveGetExtendedResponseDto>(it)
    }
    .apply {
        addParam("extended", true)
        itemType?.let { addParam("item_type", it.value) }
        tagId?.let { addParam("tag_id", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 1, max = 100) }
        fields?.let { addParam("fields", it) }
        isFromSnackbar?.let { addParam("is_from_snackbar", it) }
    }

    /**
     * @param offset
     * @param count
     * @param type
     * @param fields
     * @param tagId
     * @return [VKRequest] with [FaveGetPagesResponseDto]
     */
    fun faveGetPages(
        offset: Int? = null,
        count: Int? = null,
        type: FaveGetPagesTypeDto? = null,
        fields: List<BaseUserGroupFieldsDto>? = null,
        tagId: Int? = null
    ): VKRequest<FaveGetPagesResponseDto> = NewApiRequest("fave.getPages") {
        GsonHolder.gson.parse<FaveGetPagesResponseDto>(it)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0, max = 10000) }
        count?.let { addParam("count", it, min = 1, max = 500) }
        type?.let { addParam("type", it.value) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        tagId?.let { addParam("tag_id", it) }
    }

    /**
     * @return [VKRequest] with [FaveGetTagsResponseDto]
     */
    fun faveGetTags(): VKRequest<FaveGetTagsResponseDto> = NewApiRequest("fave.getTags") {
        GsonHolder.gson.parse<FaveGetTagsResponseDto>(it)
    }

    /**
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun faveMarkSeen(): VKRequest<BaseBoolIntDto> = NewApiRequest("fave.markSeen") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }

    /**
     * @param ownerId
     * @param articleId
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun faveRemoveArticle(ownerId: UserId, articleId: Int): VKRequest<BaseBoolIntDto> =
            NewApiRequest("fave.removeArticle") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("article_id", articleId, min = 0)
    }

    /**
     * Removes link from the user's faves.
     *
     * @param linkId - Link ID (can be obtained by [vk.com/dev/faves.getLinks|faves.getLinks]
     * method).
     * @param link - Link URL
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveRemoveLink(linkId: String? = null, link: String? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("fave.removeLink") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        linkId?.let { addParam("link_id", it) }
        link?.let { addParam("link", it) }
    }

    /**
     * @param userId
     * @param groupId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveRemovePage(userId: UserId? = null, groupId: UserId? = null):
            VKRequest<BaseOkResponseDto> = NewApiRequest("fave.removePage") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it) }
        groupId?.let { addParam("group_id", it) }
    }

    /**
     * @param ownerId
     * @param id
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveRemovePost(ownerId: UserId, id: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("fave.removePost") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
    }

    /**
     * @param ownerId
     * @param id
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveRemoveProduct(ownerId: UserId, id: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("fave.removeProduct") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
    }

    /**
     * @param id
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveRemoveTag(id: Int): VKRequest<BaseOkResponseDto> = NewApiRequest("fave.removeTag") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("id", id)
    }

    /**
     * @param ownerId
     * @param id
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveRemoveVideo(ownerId: UserId, id: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("fave.removeVideo") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
    }

    /**
     * @param ids
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveReorderTags(ids: List<Int>): VKRequest<BaseOkResponseDto> =
            NewApiRequest("fave.reorderTags") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("ids", ids)
    }

    /**
     * @param userId
     * @param groupId
     * @param tagIds
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveSetPageTags(
        userId: UserId? = null,
        groupId: UserId? = null,
        tagIds: List<Int>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("fave.setPageTags") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
        tagIds?.let { addParam("tag_ids", it) }
    }

    /**
     * @param itemType
     * @param itemOwnerId
     * @param itemId
     * @param tagIds
     * @param linkId
     * @param linkUrl
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveSetTags(
        itemType: FaveSetTagsItemTypeDto? = null,
        itemOwnerId: UserId? = null,
        itemId: Int? = null,
        tagIds: List<Int>? = null,
        linkId: String? = null,
        linkUrl: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("fave.setTags") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        itemType?.let { addParam("item_type", it.value) }
        itemOwnerId?.let { addParam("item_owner_id", it) }
        itemId?.let { addParam("item_id", it) }
        tagIds?.let { addParam("tag_ids", it) }
        linkId?.let { addParam("link_id", it) }
        linkUrl?.let { addParam("link_url", it) }
    }

    /**
     * @param userId
     * @param groupId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun faveTrackPageInteraction(userId: UserId? = null, groupId: UserId? = null):
            VKRequest<BaseOkResponseDto> = NewApiRequest("fave.trackPageInteraction") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    object FaveAddPageRestrictions {
        const val USER_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object FaveAddTagRestrictions {
        const val NAME_MAX_LENGTH: Int = 50
    }

    object FaveEditTagRestrictions {
        const val NAME_MAX_LENGTH: Int = 50
    }

    object FaveGetRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 1

        const val COUNT_MAX: Long = 100
    }

    object FaveGetExtendedRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 1

        const val COUNT_MAX: Long = 100
    }

    object FaveGetPagesRestrictions {
        const val OFFSET_MIN: Long = 0

        const val OFFSET_MAX: Long = 10000

        const val COUNT_MIN: Long = 1

        const val COUNT_MAX: Long = 500
    }

    object FaveRemoveArticleRestrictions {
        const val ARTICLE_ID_MIN: Long = 0
    }

    object FaveSetPageTagsRestrictions {
        const val USER_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object FaveTrackPageInteractionRestrictions {
        const val USER_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }
}
