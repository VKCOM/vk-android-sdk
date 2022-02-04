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
package com.vk.sdk.api.market

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.market.dto.MarketAddAlbumResponse
import com.vk.sdk.api.market.dto.MarketAddResponse
import com.vk.sdk.api.market.dto.MarketEditOrderPaymentStatus
import com.vk.sdk.api.market.dto.MarketGetAlbumByIdResponse
import com.vk.sdk.api.market.dto.MarketGetAlbumsResponse
import com.vk.sdk.api.market.dto.MarketGetByIdExtendedResponse
import com.vk.sdk.api.market.dto.MarketGetByIdResponse
import com.vk.sdk.api.market.dto.MarketGetCategoriesResponse
import com.vk.sdk.api.market.dto.MarketGetCommentsResponse
import com.vk.sdk.api.market.dto.MarketGetCommentsSort
import com.vk.sdk.api.market.dto.MarketGetExtendedResponse
import com.vk.sdk.api.market.dto.MarketGetGroupOrdersResponse
import com.vk.sdk.api.market.dto.MarketGetOrderByIdResponse
import com.vk.sdk.api.market.dto.MarketGetOrderItemsResponse
import com.vk.sdk.api.market.dto.MarketGetOrdersExtendedResponse
import com.vk.sdk.api.market.dto.MarketGetOrdersResponse
import com.vk.sdk.api.market.dto.MarketGetResponse
import com.vk.sdk.api.market.dto.MarketReportCommentReason
import com.vk.sdk.api.market.dto.MarketReportReason
import com.vk.sdk.api.market.dto.MarketSearchExtendedResponse
import com.vk.sdk.api.market.dto.MarketSearchExtendedRev
import com.vk.sdk.api.market.dto.MarketSearchExtendedSort
import com.vk.sdk.api.market.dto.MarketSearchItemsSortBy
import com.vk.sdk.api.market.dto.MarketSearchItemsSortDirection
import com.vk.sdk.api.market.dto.MarketSearchResponse
import com.vk.sdk.api.market.dto.MarketSearchRev
import com.vk.sdk.api.market.dto.MarketSearchSort
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class MarketService {
    /**
     * Ads a new item to the market.
     *
     * @param ownerId - ID of an item owner community.
     * @param name - Item name.
     * @param description - Item description.
     * @param categoryId - Item category ID.
     * @param price - Item price.
     * @param oldPrice
     * @param deleted - Item status ('1' - deleted, '0' - not deleted).
     * @param mainPhotoId - Cover photo ID.
     * @param photoIds - IDs of additional photos.
     * @param url - Url for button in market item.
     * @param dimensionWidth
     * @param dimensionHeight
     * @param dimensionLength
     * @param weight
     * @param sku
     * @return [VKRequest] with [MarketAddResponse]
     */
    fun marketAdd(
        ownerId: UserId,
        name: String,
        description: String,
        categoryId: Int,
        price: Float? = null,
        oldPrice: Float? = null,
        deleted: Boolean? = null,
        mainPhotoId: Int? = null,
        photoIds: List<Int>? = null,
        url: String? = null,
        dimensionWidth: Int? = null,
        dimensionHeight: Int? = null,
        dimensionLength: Int? = null,
        weight: Int? = null,
        sku: String? = null
    ): VKRequest<MarketAddResponse> = NewApiRequest("market.add") {
        GsonHolder.gson.fromJson(it, MarketAddResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("name", name, minLength = 4, maxLength = 100)
        addParam("description", description, minLength = 10)
        addParam("category_id", categoryId, min = 0)
        price?.let { addParam("price", it, min = 0.0) }
        oldPrice?.let { addParam("old_price", it, min = 0.01) }
        deleted?.let { addParam("deleted", it) }
        mainPhotoId?.let { addParam("main_photo_id", it, min = 0) }
        photoIds?.let { addParam("photo_ids", it) }
        url?.let { addParam("url", it, minLength = 0, maxLength = 320) }
        dimensionWidth?.let { addParam("dimension_width", it, min = 0, max = 100000) }
        dimensionHeight?.let { addParam("dimension_height", it, min = 0, max = 100000) }
        dimensionLength?.let { addParam("dimension_length", it, min = 0, max = 100000) }
        weight?.let { addParam("weight", it, min = 0, max = 100000000) }
        sku?.let { addParam("sku", it, maxLength = 50) }
    }

    /**
     * Creates new collection of items
     *
     * @param ownerId - ID of an item owner community.
     * @param title - Collection title.
     * @param photoId - Cover photo ID.
     * @param mainAlbum - Set as main ('1' - set, '0' - no).
     * @param isHidden - Set as hidden
     * @return [VKRequest] with [MarketAddAlbumResponse]
     */
    fun marketAddAlbum(
        ownerId: UserId,
        title: String,
        photoId: Int? = null,
        mainAlbum: Boolean? = null,
        isHidden: Boolean? = null
    ): VKRequest<MarketAddAlbumResponse> = NewApiRequest("market.addAlbum") {
        GsonHolder.gson.fromJson(it, MarketAddAlbumResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("title", title, maxLength = 128)
        photoId?.let { addParam("photo_id", it, min = 0) }
        mainAlbum?.let { addParam("main_album", it) }
        isHidden?.let { addParam("is_hidden", it) }
    }

    /**
     * Adds an item to one or multiple collections.
     *
     * @param ownerId - ID of an item owner community.
     * @param itemIds
     * @param albumIds - Collections IDs to add item to.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketAddToAlbum(
        ownerId: UserId,
        itemIds: List<Int>,
        albumIds: List<Int>
    ): VKRequest<BaseOkResponse> = NewApiRequest("market.addToAlbum") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_ids", itemIds)
        addParam("album_ids", albumIds)
    }

    /**
     * Creates a new comment for an item.
     *
     * @param ownerId - ID of an item owner community.
     * @param itemId - Item ID.
     * @param message - Comment text (required if 'attachments' parameter is not specified)
     * @param attachments - Comma-separated list of objects attached to a comment. The field is
     * submitted the following way_ , "'<owner_id>_<media_id>,<owner_id>_<media_id>'", , '' - media
     * attachment type_ "'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document", ,
     * '<owner_id>' - media owner id, '<media_id>' - media attachment id, , For example_
     * "photo100172_166443618,photo66748_265827614",
     * @param fromGroup - '1' - comment will be published on behalf of a community, '0' - on behalf
     * of a user (by default).
     * @param replyToComment - ID of a comment to reply with current comment to.
     * @param stickerId - Sticker ID.
     * @param guid - Random value to avoid resending one comment.
     * @return [VKRequest] with [Int]
     */
    fun marketCreateComment(
        ownerId: UserId,
        itemId: Int,
        message: String? = null,
        attachments: List<String>? = null,
        fromGroup: Boolean? = null,
        replyToComment: Int? = null,
        stickerId: Int? = null,
        guid: String? = null
    ): VKRequest<Int> = NewApiRequest("market.createComment") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
        fromGroup?.let { addParam("from_group", it) }
        replyToComment?.let { addParam("reply_to_comment", it, min = 0) }
        stickerId?.let { addParam("sticker_id", it, min = 0) }
        guid?.let { addParam("guid", it) }
    }

    /**
     * Deletes an item.
     *
     * @param ownerId - ID of an item owner community.
     * @param itemId - Item ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketDelete(ownerId: UserId, itemId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("market.delete") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
    }

    /**
     * Deletes a collection of items.
     *
     * @param ownerId - ID of an collection owner community.
     * @param albumId - Collection ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketDeleteAlbum(ownerId: UserId, albumId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("market.deleteAlbum") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("album_id", albumId, min = 0)
    }

    /**
     * Deletes an item's comment
     *
     * @param ownerId - identifier of an item owner community, "Note that community id in the
     * 'owner_id' parameter should be negative number. For example 'owner_id'=-1 matches the
     * [vk.com/apiclub|VK API] community "
     * @param commentId - comment id
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun marketDeleteComment(ownerId: UserId, commentId: Int): VKRequest<BaseBoolInt> =
            NewApiRequest("market.deleteComment") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("comment_id", commentId, min = 0)
    }

    /**
     * Edits an item.
     *
     * @param ownerId - ID of an item owner community.
     * @param itemId - Item ID.
     * @param name - Item name.
     * @param description - Item description.
     * @param categoryId - Item category ID.
     * @param price - Item price.
     * @param deleted - Item status ('1' - deleted, '0' - not deleted).
     * @param mainPhotoId - Cover photo ID.
     * @param photoIds - IDs of additional photos.
     * @param url - Url for button in market item.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketEdit(
        ownerId: UserId,
        itemId: Int,
        name: String,
        description: String,
        categoryId: Int,
        price: Float? = null,
        deleted: Boolean? = null,
        mainPhotoId: Int? = null,
        photoIds: List<Int>? = null,
        url: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("market.edit") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
        addParam("name", name, minLength = 4, maxLength = 100)
        addParam("description", description, minLength = 10)
        addParam("category_id", categoryId, min = 0)
        price?.let { addParam("price", it, min = 0.0) }
        deleted?.let { addParam("deleted", it) }
        mainPhotoId?.let { addParam("main_photo_id", it, min = 0) }
        photoIds?.let { addParam("photo_ids", it) }
        url?.let { addParam("url", it, minLength = 0, maxLength = 320) }
    }

    /**
     * Edits a collection of items
     *
     * @param ownerId - ID of an collection owner community.
     * @param albumId - Collection ID.
     * @param title - Collection title.
     * @param photoId - Cover photo id
     * @param mainAlbum - Set as main ('1' - set, '0' - no).
     * @param isHidden - Set as hidden
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketEditAlbum(
        ownerId: UserId,
        albumId: Int,
        title: String,
        photoId: Int? = null,
        mainAlbum: Boolean? = null,
        isHidden: Boolean? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("market.editAlbum") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("album_id", albumId, min = 0)
        addParam("title", title, maxLength = 128)
        photoId?.let { addParam("photo_id", it, min = 0) }
        mainAlbum?.let { addParam("main_album", it) }
        isHidden?.let { addParam("is_hidden", it) }
    }

    /**
     * Chages item comment's text
     *
     * @param ownerId - ID of an item owner community.
     * @param commentId - Comment ID.
     * @param message - New comment text (required if 'attachments' are not specified), , 2048
     * symbols maximum.
     * @param attachments - Comma-separated list of objects attached to a comment. The field is
     * submitted the following way_ , "'<owner_id>_<media_id>,<owner_id>_<media_id>'", , '' - media
     * attachment type_ "'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document", ,
     * '<owner_id>' - media owner id, '<media_id>' - media attachment id, , For example_
     * "photo100172_166443618,photo66748_265827614",
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketEditComment(
        ownerId: UserId,
        commentId: Int,
        message: String? = null,
        attachments: List<String>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("market.editComment") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("comment_id", commentId, min = 0)
        message?.let { addParam("message", it) }
        attachments?.let { addParam("attachments", it) }
    }

    /**
     * Edit order
     *
     * @param userId
     * @param orderId
     * @param merchantComment
     * @param status
     * @param trackNumber
     * @param paymentStatus
     * @param deliveryPrice
     * @param width
     * @param length
     * @param height
     * @param weight
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketEditOrder(
        userId: UserId,
        orderId: Int,
        merchantComment: String? = null,
        status: Int? = null,
        trackNumber: String? = null,
        paymentStatus: MarketEditOrderPaymentStatus? = null,
        deliveryPrice: Int? = null,
        width: Int? = null,
        length: Int? = null,
        height: Int? = null,
        weight: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("market.editOrder") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        addParam("order_id", orderId, min = 0)
        merchantComment?.let { addParam("merchant_comment", it, maxLength = 800) }
        status?.let { addParam("status", it, min = 0) }
        trackNumber?.let { addParam("track_number", it, maxLength = 60) }
        paymentStatus?.let { addParam("payment_status", it.value) }
        deliveryPrice?.let { addParam("delivery_price", it, min = 0) }
        width?.let { addParam("width", it, min = 0, max = 100000) }
        length?.let { addParam("length", it, min = 0, max = 100000) }
        height?.let { addParam("height", it, min = 0, max = 100000) }
        weight?.let { addParam("weight", it, min = 0, max = 100000000) }
    }

    /**
     * Returns items list for a community.
     *
     * @param ownerId - ID of an item owner community, "Note that community id in the 'owner_id'
     * parameter should be negative number. For example 'owner_id'=-1 matches the [vk.com/apiclub|VK
     * API] community "
     * @param albumId
     * @param count - Number of items to return.
     * @param offset - Offset needed to return a specific subset of results.
     * @param dateFrom - Items update date from (format_ yyyy-mm-dd)
     * @param dateTo - Items update date to (format_ yyyy-mm-dd)
     * @param needVariants - Add variants to response if exist
     * @param withDisabled - Add disabled items to response
     * @return [VKRequest] with [MarketGetResponse]
     */
    fun marketGet(
        ownerId: UserId,
        albumId: Int? = null,
        count: Int? = null,
        offset: Int? = null,
        dateFrom: String? = null,
        dateTo: String? = null,
        needVariants: Boolean? = null,
        withDisabled: Boolean? = null
    ): VKRequest<MarketGetResponse> = NewApiRequest("market.get") {
        GsonHolder.gson.fromJson(it, MarketGetResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        albumId?.let { addParam("album_id", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        offset?.let { addParam("offset", it, min = 0) }
        dateFrom?.let { addParam("date_from", it) }
        dateTo?.let { addParam("date_to", it) }
        needVariants?.let { addParam("need_variants", it) }
        withDisabled?.let { addParam("with_disabled", it) }
    }

    /**
     * Returns items list for a community.
     *
     * @param ownerId - ID of an item owner community, "Note that community id in the 'owner_id'
     * parameter should be negative number. For example 'owner_id'=-1 matches the [vk.com/apiclub|VK
     * API] community "
     * @param albumId
     * @param count - Number of items to return.
     * @param offset - Offset needed to return a specific subset of results.
     * @param dateFrom - Items update date from (format_ yyyy-mm-dd)
     * @param dateTo - Items update date to (format_ yyyy-mm-dd)
     * @param needVariants - Add variants to response if exist
     * @param withDisabled - Add disabled items to response
     * @return [VKRequest] with [MarketGetExtendedResponse]
     */
    fun marketGetExtended(
        ownerId: UserId,
        albumId: Int? = null,
        count: Int? = null,
        offset: Int? = null,
        dateFrom: String? = null,
        dateTo: String? = null,
        needVariants: Boolean? = null,
        withDisabled: Boolean? = null
    ): VKRequest<MarketGetExtendedResponse> = NewApiRequest("market.get") {
        GsonHolder.gson.fromJson(it, MarketGetExtendedResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        albumId?.let { addParam("album_id", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        offset?.let { addParam("offset", it, min = 0) }
        addParam("extended", true)
        dateFrom?.let { addParam("date_from", it) }
        dateTo?.let { addParam("date_to", it) }
        needVariants?.let { addParam("need_variants", it) }
        withDisabled?.let { addParam("with_disabled", it) }
    }

    /**
     * Returns items album's data
     *
     * @param ownerId - identifier of an album owner community, "Note that community id in the
     * 'owner_id' parameter should be negative number. For example 'owner_id'=-1 matches the
     * [vk.com/apiclub|VK API] community "
     * @param albumIds - collections identifiers to obtain data from
     * @return [VKRequest] with [MarketGetAlbumByIdResponse]
     */
    fun marketGetAlbumById(ownerId: UserId, albumIds: List<Int>):
            VKRequest<MarketGetAlbumByIdResponse> = NewApiRequest("market.getAlbumById") {
        GsonHolder.gson.fromJson(it, MarketGetAlbumByIdResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("album_ids", albumIds)
    }

    /**
     * Returns community's market collections list.
     *
     * @param ownerId - ID of an items owner community.
     * @param offset - Offset needed to return a specific subset of results.
     * @param count - Number of items to return.
     * @return [VKRequest] with [MarketGetAlbumsResponse]
     */
    fun marketGetAlbums(
        ownerId: UserId,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<MarketGetAlbumsResponse> = NewApiRequest("market.getAlbums") {
        GsonHolder.gson.fromJson(it, MarketGetAlbumsResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
    }

    /**
     * Returns information about market items by their ids.
     *
     * @param itemIds - Comma-separated ids list_ {user id}_{item id}. If an item belongs to a
     * community -{community id} is used. " 'Videos' value example_ ,
     * '-4363_136089719,13245770_137352259'"
     * @return [VKRequest] with [MarketGetByIdResponse]
     */
    fun marketGetById(itemIds: List<String>): VKRequest<MarketGetByIdResponse> =
            NewApiRequest("market.getById") {
        GsonHolder.gson.fromJson(it, MarketGetByIdResponse::class.java)
    }
    .apply {
        addParam("item_ids", itemIds)
    }

    /**
     * Returns information about market items by their ids.
     *
     * @param itemIds - Comma-separated ids list_ {user id}_{item id}. If an item belongs to a
     * community -{community id} is used. " 'Videos' value example_ ,
     * '-4363_136089719,13245770_137352259'"
     * @return [VKRequest] with [MarketGetByIdExtendedResponse]
     */
    fun marketGetByIdExtended(itemIds: List<String>): VKRequest<MarketGetByIdExtendedResponse> =
            NewApiRequest("market.getById") {
        GsonHolder.gson.fromJson(it, MarketGetByIdExtendedResponse::class.java)
    }
    .apply {
        addParam("item_ids", itemIds)
        addParam("extended", true)
    }

    /**
     * Returns a list of market categories.
     *
     * @param count - Number of results to return.
     * @param offset - Offset needed to return a specific subset of results.
     * @return [VKRequest] with [MarketGetCategoriesResponse]
     */
    fun marketGetCategories(count: Int? = null, offset: Int? = null):
            VKRequest<MarketGetCategoriesResponse> = NewApiRequest("market.getCategories") {
        GsonHolder.gson.fromJson(it, MarketGetCategoriesResponse::class.java)
    }
    .apply {
        count?.let { addParam("count", it, min = 0, max = 1000) }
        offset?.let { addParam("offset", it, min = 0) }
    }

    /**
     * Returns comments list for an item.
     *
     * @param ownerId - ID of an item owner community
     * @param itemId - Item ID.
     * @param needLikes - '1' - to return likes info.
     * @param startCommentId - ID of a comment to start a list from (details below).
     * @param offset
     * @param count - Number of results to return.
     * @param sort - Sort order ('asc' - from old to new, 'desc' - from new to old)
     * @param fields - List of additional profile fields to return. See the
     * [vk.com/dev/fields|details]
     * @return [VKRequest] with [MarketGetCommentsResponse]
     */
    fun marketGetComments(
        ownerId: UserId,
        itemId: Int,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: MarketGetCommentsSort? = null,
        fields: List<UsersFields>? = null
    ): VKRequest<MarketGetCommentsResponse> = NewApiRequest("market.getComments") {
        GsonHolder.gson.fromJson(it, MarketGetCommentsResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        sort?.let { addParam("sort", it.value) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Get market orders
     *
     * @param groupId
     * @param offset
     * @param count
     * @return [VKRequest] with [MarketGetGroupOrdersResponse]
     */
    fun marketGetGroupOrders(
        groupId: UserId,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<MarketGetGroupOrdersResponse> = NewApiRequest("market.getGroupOrders") {
        GsonHolder.gson.fromJson(it, MarketGetGroupOrdersResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 1, max = 50) }
    }

    /**
     * Get order
     *
     * @param orderId
     * @param userId
     * @return [VKRequest] with [MarketGetOrderByIdResponse]
     */
    fun marketGetOrderById(orderId: Int, userId: UserId? = null):
            VKRequest<MarketGetOrderByIdResponse> = NewApiRequest("market.getOrderById") {
        GsonHolder.gson.fromJson(it, MarketGetOrderByIdResponse::class.java)
    }
    .apply {
        addParam("order_id", orderId, min = 0)
        userId?.let { addParam("user_id", it, min = 0) }
    }

    /**
     * Get market items in the order
     *
     * @param orderId
     * @param userId
     * @param offset
     * @param count
     * @return [VKRequest] with [MarketGetOrderItemsResponse]
     */
    fun marketGetOrderItems(
        orderId: Int,
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<MarketGetOrderItemsResponse> = NewApiRequest("market.getOrderItems") {
        GsonHolder.gson.fromJson(it, MarketGetOrderItemsResponse::class.java)
    }
    .apply {
        addParam("order_id", orderId, min = 0)
        userId?.let { addParam("user_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
    }

    /**
     * @param offset
     * @param count
     * @param dateFrom - Orders status updated date from (format_ yyyy-mm-dd)
     * @param dateTo - Orders status updated date to (format_ yyyy-mm-dd)
     * @return [VKRequest] with [MarketGetOrdersResponse]
     */
    fun marketGetOrders(
        offset: Int? = null,
        count: Int? = null,
        dateFrom: String? = null,
        dateTo: String? = null
    ): VKRequest<MarketGetOrdersResponse> = NewApiRequest("market.getOrders") {
        GsonHolder.gson.fromJson(it, MarketGetOrdersResponse::class.java)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 10) }
        dateFrom?.let { addParam("date_from", it) }
        dateTo?.let { addParam("date_to", it) }
    }

    /**
     * @param offset
     * @param count
     * @param dateFrom - Orders status updated date from (format_ yyyy-mm-dd)
     * @param dateTo - Orders status updated date to (format_ yyyy-mm-dd)
     * @return [VKRequest] with [MarketGetOrdersExtendedResponse]
     */
    fun marketGetOrdersExtended(
        offset: Int? = null,
        count: Int? = null,
        dateFrom: String? = null,
        dateTo: String? = null
    ): VKRequest<MarketGetOrdersExtendedResponse> = NewApiRequest("market.getOrders") {
        GsonHolder.gson.fromJson(it, MarketGetOrdersExtendedResponse::class.java)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 10) }
        addParam("extended", true)
        dateFrom?.let { addParam("date_from", it) }
        dateTo?.let { addParam("date_to", it) }
    }

    /**
     * Removes an item from one or multiple collections.
     *
     * @param ownerId - ID of an item owner community.
     * @param itemId - Item ID.
     * @param albumIds - Collections IDs to remove item from.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketRemoveFromAlbum(
        ownerId: UserId,
        itemId: Int,
        albumIds: List<Int>
    ): VKRequest<BaseOkResponse> = NewApiRequest("market.removeFromAlbum") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
        addParam("album_ids", albumIds)
    }

    /**
     * Reorders the collections list.
     *
     * @param ownerId - ID of an item owner community.
     * @param albumId - Collection ID.
     * @param before - ID of a collection to place current collection before it.
     * @param after - ID of a collection to place current collection after it.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketReorderAlbums(
        ownerId: UserId,
        albumId: Int,
        before: Int? = null,
        after: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("market.reorderAlbums") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("album_id", albumId)
        before?.let { addParam("before", it, min = 0) }
        after?.let { addParam("after", it, min = 0) }
    }

    /**
     * Changes item place in a collection.
     *
     * @param ownerId - ID of an item owner community.
     * @param itemId - Item ID.
     * @param albumId - ID of a collection to reorder items in. Set 0 to reorder full items list.
     * @param before - ID of an item to place current item before it.
     * @param after - ID of an item to place current item after it.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketReorderItems(
        ownerId: UserId,
        itemId: Int,
        albumId: Int? = null,
        before: Int? = null,
        after: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("market.reorderItems") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
        albumId?.let { addParam("album_id", it) }
        before?.let { addParam("before", it, min = 0) }
        after?.let { addParam("after", it, min = 0) }
    }

    /**
     * Sends a complaint to the item.
     *
     * @param ownerId - ID of an item owner community.
     * @param itemId - Item ID.
     * @param reason - Complaint reason. Possible values_ *'0' - spam,, *'1' - child porn,, *'2' -
     * extremism,, *'3' - violence,, *'4' - drugs propaganda,, *'5' - adult materials,, *'6' - insult.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketReport(
        ownerId: UserId,
        itemId: Int,
        reason: MarketReportReason? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("market.report") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
        reason?.let { addParam("reason", it.value) }
    }

    /**
     * Sends a complaint to the item's comment.
     *
     * @param ownerId - ID of an item owner community.
     * @param commentId - Comment ID.
     * @param reason - Complaint reason. Possible values_ *'0' - spam,, *'1' - child porn,, *'2' -
     * extremism,, *'3' - violence,, *'4' - drugs propaganda,, *'5' - adult materials,, *'6' - insult.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketReportComment(
        ownerId: UserId,
        commentId: Int,
        reason: MarketReportCommentReason
    ): VKRequest<BaseOkResponse> = NewApiRequest("market.reportComment") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("comment_id", commentId, min = 0)
        addParam("reason", reason.value)
    }

    /**
     * Restores recently deleted item
     *
     * @param ownerId - ID of an item owner community.
     * @param itemId - Deleted item ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun marketRestore(ownerId: UserId, itemId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("market.restore") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
    }

    /**
     * Restores a recently deleted comment
     *
     * @param ownerId - identifier of an item owner community, "Note that community id in the
     * 'owner_id' parameter should be negative number. For example 'owner_id'=-1 matches the
     * [vk.com/apiclub|VK API] community "
     * @param commentId - deleted comment id
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun marketRestoreComment(ownerId: UserId, commentId: Int): VKRequest<BaseBoolInt> =
            NewApiRequest("market.restoreComment") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("comment_id", commentId, min = 0)
    }

    /**
     * Searches market items in a community's catalog
     *
     * @param ownerId - ID of an items owner community.
     * @param albumId
     * @param q - Search query, for example "pink slippers".
     * @param priceFrom - Minimum item price value.
     * @param priceTo - Maximum item price value.
     * @param sort
     * @param rev - '0' - do not use reverse order, '1' - use reverse order
     * @param offset - Offset needed to return a specific subset of results.
     * @param count - Number of items to return.
     * @param status
     * @param needVariants - Add variants to response if exist
     * @return [VKRequest] with [MarketSearchResponse]
     */
    fun marketSearch(
        ownerId: UserId,
        albumId: Int? = null,
        q: String? = null,
        priceFrom: Int? = null,
        priceTo: Int? = null,
        sort: MarketSearchSort? = null,
        rev: MarketSearchRev? = null,
        offset: Int? = null,
        count: Int? = null,
        status: List<Int>? = null,
        needVariants: Boolean? = null
    ): VKRequest<MarketSearchResponse> = NewApiRequest("market.search") {
        GsonHolder.gson.fromJson(it, MarketSearchResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        albumId?.let { addParam("album_id", it, min = 0) }
        q?.let { addParam("q", it) }
        priceFrom?.let { addParam("price_from", it, min = 0) }
        priceTo?.let { addParam("price_to", it, min = 0) }
        sort?.let { addParam("sort", it.value) }
        rev?.let { addParam("rev", it.value) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        status?.let { addParam("status", it) }
        needVariants?.let { addParam("need_variants", it) }
    }

    /**
     * Searches market items in a community's catalog
     *
     * @param ownerId - ID of an items owner community.
     * @param albumId
     * @param q - Search query, for example "pink slippers".
     * @param priceFrom - Minimum item price value.
     * @param priceTo - Maximum item price value.
     * @param sort
     * @param rev - '0' - do not use reverse order, '1' - use reverse order
     * @param offset - Offset needed to return a specific subset of results.
     * @param count - Number of items to return.
     * @param status
     * @param needVariants - Add variants to response if exist
     * @return [VKRequest] with [MarketSearchExtendedResponse]
     */
    fun marketSearchExtended(
        ownerId: UserId,
        albumId: Int? = null,
        q: String? = null,
        priceFrom: Int? = null,
        priceTo: Int? = null,
        sort: MarketSearchExtendedSort? = null,
        rev: MarketSearchExtendedRev? = null,
        offset: Int? = null,
        count: Int? = null,
        status: List<Int>? = null,
        needVariants: Boolean? = null
    ): VKRequest<MarketSearchExtendedResponse> = NewApiRequest("market.search") {
        GsonHolder.gson.fromJson(it, MarketSearchExtendedResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        albumId?.let { addParam("album_id", it, min = 0) }
        q?.let { addParam("q", it) }
        priceFrom?.let { addParam("price_from", it, min = 0) }
        priceTo?.let { addParam("price_to", it, min = 0) }
        sort?.let { addParam("sort", it.value) }
        rev?.let { addParam("rev", it.value) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        addParam("extended", true)
        status?.let { addParam("status", it) }
        needVariants?.let { addParam("need_variants", it) }
    }

    /**
     * @param q
     * @param offset
     * @param count
     * @param categoryId
     * @param priceFrom
     * @param priceTo
     * @param sortBy
     * @param sortDirection
     * @param country
     * @param city
     * @return [VKRequest] with [MarketSearchResponse]
     */
    fun marketSearchItems(
        q: String,
        offset: Int? = null,
        count: Int? = null,
        categoryId: Int? = null,
        priceFrom: Int? = null,
        priceTo: Int? = null,
        sortBy: MarketSearchItemsSortBy? = null,
        sortDirection: MarketSearchItemsSortDirection? = null,
        country: Int? = null,
        city: Int? = null
    ): VKRequest<MarketSearchResponse> = NewApiRequest("market.searchItems") {
        GsonHolder.gson.fromJson(it, MarketSearchResponse::class.java)
    }
    .apply {
        addParam("q", q)
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 300) }
        categoryId?.let { addParam("category_id", it, min = 0) }
        priceFrom?.let { addParam("price_from", it, min = 0) }
        priceTo?.let { addParam("price_to", it, min = 0) }
        sortBy?.let { addParam("sort_by", it.value) }
        sortDirection?.let { addParam("sort_direction", it.value) }
        country?.let { addParam("country", it, min = 0) }
        city?.let { addParam("city", it, min = 0) }
    }
}
