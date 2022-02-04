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
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.fave.dto.FaveAddTagPosition
import com.vk.sdk.api.fave.dto.FaveGetExtendedItemType
import com.vk.sdk.api.fave.dto.FaveGetExtendedResponse
import com.vk.sdk.api.fave.dto.FaveGetItemType
import com.vk.sdk.api.fave.dto.FaveGetPagesResponse
import com.vk.sdk.api.fave.dto.FaveGetPagesType
import com.vk.sdk.api.fave.dto.FaveGetResponse
import com.vk.sdk.api.fave.dto.FaveGetTagsResponse
import com.vk.sdk.api.fave.dto.FaveSetTagsItemType
import com.vk.sdk.api.fave.dto.FaveTag
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class FaveService {
    /**
     * @param url
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveAddArticle(url: String): VKRequest<BaseOkResponse> = NewApiRequest("fave.addArticle") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("url", url)
    }

    /**
     * Adds a link to user faves.
     *
     * @param link - Link URL.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveAddLink(link: String): VKRequest<BaseOkResponse> = NewApiRequest("fave.addLink") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("link", link)
    }

    /**
     * @param userId
     * @param groupId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveAddPage(userId: UserId? = null, groupId: UserId? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("fave.addPage") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * @param ownerId
     * @param id
     * @param accessKey
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveAddPost(
        ownerId: UserId,
        id: Int,
        accessKey: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("fave.addPost") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveAddProduct(
        ownerId: UserId,
        id: Int,
        accessKey: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("fave.addProduct") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
        accessKey?.let { addParam("access_key", it) }
    }

    /**
     * @param name
     * @param position
     * @return [VKRequest] with [FaveTag]
     */
    fun faveAddTag(name: String? = null, position: FaveAddTagPosition? = null): VKRequest<FaveTag> =
            NewApiRequest("fave.addTag") {
        GsonHolder.gson.fromJson(it, FaveTag::class.java)
    }
    .apply {
        name?.let { addParam("name", it, maxLength = 50) }
        position?.let { addParam("position", it.value) }
    }

    /**
     * @param ownerId
     * @param id
     * @param accessKey
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveAddVideo(
        ownerId: UserId,
        id: Int,
        accessKey: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("fave.addVideo") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
        accessKey?.let { addParam("access_key", it) }
    }

    /**
     * @param id
     * @param name
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveEditTag(id: Int, name: String): VKRequest<BaseOkResponse> =
            NewApiRequest("fave.editTag") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("id", id)
        addParam("name", name, maxLength = 50)
    }

    /**
     * @param itemType
     * @param tagId - Tag ID.
     * @param offset - Offset needed to return a specific subset of users.
     * @param count - Number of users to return.
     * @param fields
     * @param isFromSnackbar
     * @return [VKRequest] with [FaveGetResponse]
     */
    fun faveGet(
        itemType: FaveGetItemType? = null,
        tagId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: String? = null,
        isFromSnackbar: Boolean? = null
    ): VKRequest<FaveGetResponse> = NewApiRequest("fave.get") {
        GsonHolder.gson.fromJson(it, FaveGetResponse::class.java)
    }
    .apply {
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
     * @return [VKRequest] with [FaveGetExtendedResponse]
     */
    fun faveGetExtended(
        itemType: FaveGetExtendedItemType? = null,
        tagId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: String? = null,
        isFromSnackbar: Boolean? = null
    ): VKRequest<FaveGetExtendedResponse> = NewApiRequest("fave.get") {
        GsonHolder.gson.fromJson(it, FaveGetExtendedResponse::class.java)
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
     * @return [VKRequest] with [FaveGetPagesResponse]
     */
    fun faveGetPages(
        offset: Int? = null,
        count: Int? = null,
        type: FaveGetPagesType? = null,
        fields: List<BaseUserGroupFields>? = null,
        tagId: Int? = null
    ): VKRequest<FaveGetPagesResponse> = NewApiRequest("fave.getPages") {
        GsonHolder.gson.fromJson(it, FaveGetPagesResponse::class.java)
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
     * @return [VKRequest] with [FaveGetTagsResponse]
     */
    fun faveGetTags(): VKRequest<FaveGetTagsResponse> = NewApiRequest("fave.getTags") {
        GsonHolder.gson.fromJson(it, FaveGetTagsResponse::class.java)
    }

    /**
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun faveMarkSeen(): VKRequest<BaseBoolInt> = NewApiRequest("fave.markSeen") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }

    /**
     * @param ownerId
     * @param articleId
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun faveRemoveArticle(ownerId: UserId, articleId: Int): VKRequest<BaseBoolInt> =
            NewApiRequest("fave.removeArticle") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveRemoveLink(linkId: String? = null, link: String? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("fave.removeLink") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        linkId?.let { addParam("link_id", it) }
        link?.let { addParam("link", it) }
    }

    /**
     * @param userId
     * @param groupId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveRemovePage(userId: UserId? = null, groupId: UserId? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("fave.removePage") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it) }
        groupId?.let { addParam("group_id", it) }
    }

    /**
     * @param ownerId
     * @param id
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveRemovePost(ownerId: UserId, id: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("fave.removePost") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
    }

    /**
     * @param ownerId
     * @param id
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveRemoveProduct(ownerId: UserId, id: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("fave.removeProduct") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
    }

    /**
     * @param id
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveRemoveTag(id: Int): VKRequest<BaseOkResponse> = NewApiRequest("fave.removeTag") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("id", id)
    }

    /**
     * @param ownerId
     * @param id
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveRemoveVideo(ownerId: UserId, id: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("fave.removeVideo") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("id", id)
    }

    /**
     * @param ids
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveReorderTags(ids: List<Int>): VKRequest<BaseOkResponse> =
            NewApiRequest("fave.reorderTags") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("ids", ids)
    }

    /**
     * @param userId
     * @param groupId
     * @param tagIds
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveSetPageTags(
        userId: UserId? = null,
        groupId: UserId? = null,
        tagIds: List<Int>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("fave.setPageTags") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveSetTags(
        itemType: FaveSetTagsItemType? = null,
        itemOwnerId: UserId? = null,
        itemId: Int? = null,
        tagIds: List<Int>? = null,
        linkId: String? = null,
        linkUrl: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("fave.setTags") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun faveTrackPageInteraction(userId: UserId? = null, groupId: UserId? = null):
            VKRequest<BaseOkResponse> = NewApiRequest("fave.trackPageInteraction") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }
}
