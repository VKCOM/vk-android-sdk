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
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.market.dto.MarketAddAlbumResponseDto
import com.vk.sdk.api.market.dto.MarketAddResponseDto
import com.vk.sdk.api.market.dto.MarketEditOrderPaymentStatusDto
import com.vk.sdk.api.market.dto.MarketGetAlbumByIdResponseDto
import com.vk.sdk.api.market.dto.MarketGetAlbumsResponseDto
import com.vk.sdk.api.market.dto.MarketGetByIdExtendedResponseDto
import com.vk.sdk.api.market.dto.MarketGetByIdResponseDto
import com.vk.sdk.api.market.dto.MarketGetCategoriesNewResponseDto
import com.vk.sdk.api.market.dto.MarketGetCategoriesResponseDto
import com.vk.sdk.api.market.dto.MarketGetCommentsResponseDto
import com.vk.sdk.api.market.dto.MarketGetCommentsSortDto
import com.vk.sdk.api.market.dto.MarketGetExtendedResponseDto
import com.vk.sdk.api.market.dto.MarketGetGroupOrdersResponseDto
import com.vk.sdk.api.market.dto.MarketGetOrderByIdResponseDto
import com.vk.sdk.api.market.dto.MarketGetOrderItemsResponseDto
import com.vk.sdk.api.market.dto.MarketGetOrdersExtendedResponseDto
import com.vk.sdk.api.market.dto.MarketGetOrdersResponseDto
import com.vk.sdk.api.market.dto.MarketGetResponseDto
import com.vk.sdk.api.market.dto.MarketReportCommentReasonDto
import com.vk.sdk.api.market.dto.MarketReportReasonDto
import com.vk.sdk.api.market.dto.MarketSearchBasicResponseDto
import com.vk.sdk.api.market.dto.MarketSearchExtendedResponseDto
import com.vk.sdk.api.market.dto.MarketSearchExtendedRevDto
import com.vk.sdk.api.market.dto.MarketSearchExtendedSortDto
import com.vk.sdk.api.market.dto.MarketSearchItemsBasicSortByDto
import com.vk.sdk.api.market.dto.MarketSearchItemsBasicSortDirectionDto
import com.vk.sdk.api.market.dto.MarketSearchItemsSortByDto
import com.vk.sdk.api.market.dto.MarketSearchItemsSortDirectionDto
import com.vk.sdk.api.market.dto.MarketSearchResponseDto
import com.vk.sdk.api.market.dto.MarketSearchRevDto
import com.vk.sdk.api.market.dto.MarketSearchSortDto
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.users.dto.UsersFieldsDto
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
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
     * @param videoIds - IDs of additional videos.
     * @param url - Url for button in market item.
     * @param dimensionWidth
     * @param dimensionHeight
     * @param dimensionLength
     * @param weight
     * @param sku
     * @return [VKRequest] with [MarketAddResponseDto]
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
        videoIds: List<Int>? = null,
        url: String? = null,
        dimensionWidth: Int? = null,
        dimensionHeight: Int? = null,
        dimensionLength: Int? = null,
        weight: Int? = null,
        sku: String? = null
    ): VKRequest<MarketAddResponseDto> = NewApiRequest("market.add") {
        GsonHolder.gson.parse<MarketAddResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("name", name, minLength = 4, maxLength = 100)
        addParam("description", description, minLength = 10)
        addParam("category_id", categoryId, min = 0)
        price?.let { addParam("price", it, min = 0.0) }
        oldPrice?.let { addParam("old_price", it, min = 0.0) }
        deleted?.let { addParam("deleted", it) }
        mainPhotoId?.let { addParam("main_photo_id", it, min = 0) }
        photoIds?.let { addParam("photo_ids", it) }
        videoIds?.let { addParam("video_ids", it) }
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
     * @return [VKRequest] with [MarketAddAlbumResponseDto]
     */
    fun marketAddAlbum(
        ownerId: UserId,
        title: String,
        photoId: Int? = null,
        mainAlbum: Boolean? = null,
        isHidden: Boolean? = null
    ): VKRequest<MarketAddAlbumResponseDto> = NewApiRequest("market.addAlbum") {
        GsonHolder.gson.parse<MarketAddAlbumResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketAddToAlbum(
        ownerId: UserId,
        itemIds: List<Int>,
        albumIds: List<Int>
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("market.addToAlbum") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
        GsonHolder.gson.parse<Int>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketDelete(ownerId: UserId, itemId: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("market.delete") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketDeleteAlbum(ownerId: UserId, albumId: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("market.deleteAlbum") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun marketDeleteComment(ownerId: UserId, commentId: Int): VKRequest<BaseBoolIntDto> =
            NewApiRequest("market.deleteComment") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
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
     * @param oldPrice
     * @param deleted - Item status ('1' - deleted, '0' - not deleted).
     * @param mainPhotoId - Cover photo ID.
     * @param photoIds - IDs of additional photos.
     * @param videoIds - IDs of additional videos.
     * @param url - Url for button in market item.
     * @param dimensionWidth
     * @param dimensionHeight
     * @param dimensionLength
     * @param weight
     * @param sku
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketEdit(
        ownerId: UserId,
        itemId: Int,
        name: String? = null,
        description: String? = null,
        categoryId: Int? = null,
        price: Float? = null,
        oldPrice: Float? = null,
        deleted: Boolean? = null,
        mainPhotoId: Int? = null,
        photoIds: List<Int>? = null,
        videoIds: List<Int>? = null,
        url: String? = null,
        dimensionWidth: Int? = null,
        dimensionHeight: Int? = null,
        dimensionLength: Int? = null,
        weight: Int? = null,
        sku: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("market.edit") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
        name?.let { addParam("name", it, minLength = 4, maxLength = 100) }
        description?.let { addParam("description", it, minLength = 10) }
        categoryId?.let { addParam("category_id", it, min = 0) }
        price?.let { addParam("price", it, min = 0.0) }
        oldPrice?.let { addParam("old_price", it, min = 0.0) }
        deleted?.let { addParam("deleted", it) }
        mainPhotoId?.let { addParam("main_photo_id", it, min = 0) }
        photoIds?.let { addParam("photo_ids", it) }
        videoIds?.let { addParam("video_ids", it) }
        url?.let { addParam("url", it, minLength = 0, maxLength = 320) }
        dimensionWidth?.let { addParam("dimension_width", it, min = 0, max = 100000) }
        dimensionHeight?.let { addParam("dimension_height", it, min = 0, max = 100000) }
        dimensionLength?.let { addParam("dimension_length", it, min = 0, max = 100000) }
        weight?.let { addParam("weight", it, min = 0, max = 100000000) }
        sku?.let { addParam("sku", it, maxLength = 50) }
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketEditAlbum(
        ownerId: UserId,
        albumId: Int,
        title: String,
        photoId: Int? = null,
        mainAlbum: Boolean? = null,
        isHidden: Boolean? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("market.editAlbum") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketEditComment(
        ownerId: UserId,
        commentId: Int,
        message: String? = null,
        attachments: List<String>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("market.editComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketEditOrder(
        userId: UserId,
        orderId: Int,
        merchantComment: String? = null,
        status: Int? = null,
        trackNumber: String? = null,
        paymentStatus: MarketEditOrderPaymentStatusDto? = null,
        deliveryPrice: Int? = null,
        width: Int? = null,
        length: Int? = null,
        height: Int? = null,
        weight: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("market.editOrder") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * Returns a filter list of market categories.
     *
     * @param categoryId - Category_id filter categories
     * @param query - Query filter categories
     * @param count - Number of results to return.
     * @return [VKRequest] with [MarketGetCategoriesNewResponseDto]
     */
    fun marketFilterCategories(
        categoryId: Int? = null,
        query: String? = null,
        count: Int? = null
    ): VKRequest<MarketGetCategoriesNewResponseDto> = NewApiRequest("market.filterCategories") {
        GsonHolder.gson.parse<MarketGetCategoriesNewResponseDto>(it)
    }
    .apply {
        categoryId?.let { addParam("category_id", it, min = 0) }
        query?.let { addParam("query", it) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
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
     * @param extended - '1' - method will return additional fields_ 'likes, can_comment,
     * car_repost, photos'. These parameters are not returned by default.
     * @param dateFrom - Items update date from (format_ yyyy-mm-dd)
     * @param dateTo - Items update date to (format_ yyyy-mm-dd)
     * @param needVariants - Add variants to response if exist
     * @param withDisabled - Add disabled items to response
     * @return [VKRequest] with [MarketGetResponseDto]
     */
    fun marketGet(
        ownerId: UserId,
        albumId: Int? = null,
        count: Int? = null,
        offset: Int? = null,
        extended: Boolean? = null,
        dateFrom: String? = null,
        dateTo: String? = null,
        needVariants: Boolean? = null,
        withDisabled: Boolean? = null
    ): VKRequest<MarketGetResponseDto> = NewApiRequest("market.get") {
        GsonHolder.gson.parse<MarketGetResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        albumId?.let { addParam("album_id", it) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        offset?.let { addParam("offset", it, min = 0) }
        extended?.let { addParam("extended", it) }
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
     * @return [VKRequest] with [MarketGetExtendedResponseDto]
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
    ): VKRequest<MarketGetExtendedResponseDto> = NewApiRequest("market.get") {
        GsonHolder.gson.parse<MarketGetExtendedResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        albumId?.let { addParam("album_id", it) }
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
     * @return [VKRequest] with [MarketGetAlbumByIdResponseDto]
     */
    fun marketGetAlbumById(ownerId: UserId, albumIds: List<Int>):
            VKRequest<MarketGetAlbumByIdResponseDto> = NewApiRequest("market.getAlbumById") {
        GsonHolder.gson.parse<MarketGetAlbumByIdResponseDto>(it)
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
     * @return [VKRequest] with [MarketGetAlbumsResponseDto]
     */
    fun marketGetAlbums(
        ownerId: UserId,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<MarketGetAlbumsResponseDto> = NewApiRequest("market.getAlbums") {
        GsonHolder.gson.parse<MarketGetAlbumsResponseDto>(it)
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
     * @param extended - '1' - to return additional fields_ 'likes, can_comment, car_repost,
     * photos'. By default_ '0'.
     * @return [VKRequest] with [MarketGetByIdResponseDto]
     */
    fun marketGetById(itemIds: List<String>, extended: Boolean? = null):
            VKRequest<MarketGetByIdResponseDto> = NewApiRequest("market.getById") {
        GsonHolder.gson.parse<MarketGetByIdResponseDto>(it)
    }
    .apply {
        addParam("item_ids", itemIds)
        extended?.let { addParam("extended", it) }
    }

    /**
     * Returns information about market items by their ids.
     *
     * @param itemIds - Comma-separated ids list_ {user id}_{item id}. If an item belongs to a
     * community -{community id} is used. " 'Videos' value example_ ,
     * '-4363_136089719,13245770_137352259'"
     * @return [VKRequest] with [MarketGetByIdExtendedResponseDto]
     */
    fun marketGetByIdExtended(itemIds: List<String>): VKRequest<MarketGetByIdExtendedResponseDto> =
            NewApiRequest("market.getById") {
        GsonHolder.gson.parse<MarketGetByIdExtendedResponseDto>(it)
    }
    .apply {
        addParam("item_ids", itemIds)
        addParam("extended", true)
    }

    /**
     * Returns a list of market categories.
     *
     * @param groupId - Group Id.
     * @param albumId
     * @param count - Number of results to return.
     * @param offset - Offset needed to return a specific subset of results.
     * @return [VKRequest] with [MarketGetCategoriesResponseDto]
     */
    fun marketGetCategories(
        groupId: UserId? = null,
        albumId: Int? = null,
        count: Int? = null,
        offset: Int? = null
    ): VKRequest<MarketGetCategoriesResponseDto> = NewApiRequest("market.getCategories") {
        GsonHolder.gson.parse<MarketGetCategoriesResponseDto>(it)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 1) }
        albumId?.let { addParam("album_id", it, min = 1) }
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
     * @param extended - '1' - comments will be returned as numbered objects, in addition lists of
     * 'profiles' and 'groups' objects will be returned.
     * @param fields - List of additional profile fields to return. See the
     * [vk.com/dev/fields|details]
     * @return [VKRequest] with [MarketGetCommentsResponseDto]
     */
    fun marketGetComments(
        ownerId: UserId,
        itemId: Int,
        needLikes: Boolean? = null,
        startCommentId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        sort: MarketGetCommentsSortDto? = null,
        extended: Boolean? = null,
        fields: List<UsersFieldsDto>? = null
    ): VKRequest<MarketGetCommentsResponseDto> = NewApiRequest("market.getComments") {
        GsonHolder.gson.parse<MarketGetCommentsResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId, min = 0)
        needLikes?.let { addParam("need_likes", it) }
        startCommentId?.let { addParam("start_comment_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        sort?.let { addParam("sort", it.value) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Get market orders
     *
     * @param groupId - ID or groups domain
     * @param offset
     * @param count
     * @return [VKRequest] with [MarketGetGroupOrdersResponseDto]
     */
    fun marketGetGroupOrders(
        groupId: UserId? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<MarketGetGroupOrdersResponseDto> = NewApiRequest("market.getGroupOrders") {
        GsonHolder.gson.parse<MarketGetGroupOrdersResponseDto>(it)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 1) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 1, max = 50) }
    }

    /**
     * Get order
     *
     * @param orderId
     * @param userId
     * @param extended
     * @return [VKRequest] with [MarketGetOrderByIdResponseDto]
     */
    fun marketGetOrderById(
        orderId: Int,
        userId: UserId? = null,
        extended: Boolean? = null
    ): VKRequest<MarketGetOrderByIdResponseDto> = NewApiRequest("market.getOrderById") {
        GsonHolder.gson.parse<MarketGetOrderByIdResponseDto>(it)
    }
    .apply {
        addParam("order_id", orderId, min = 0)
        userId?.let { addParam("user_id", it, min = 0) }
        extended?.let { addParam("extended", it) }
    }

    /**
     * Get market items in the order
     *
     * @param orderId
     * @param userId
     * @param offset
     * @param count
     * @return [VKRequest] with [MarketGetOrderItemsResponseDto]
     */
    fun marketGetOrderItems(
        orderId: Int,
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<MarketGetOrderItemsResponseDto> = NewApiRequest("market.getOrderItems") {
        GsonHolder.gson.parse<MarketGetOrderItemsResponseDto>(it)
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
     * @param extended
     * @param dateFrom - Orders status updated date from (format_ yyyy-mm-dd)
     * @param dateTo - Orders status updated date to (format_ yyyy-mm-dd)
     * @return [VKRequest] with [MarketGetOrdersResponseDto]
     */
    fun marketGetOrders(
        offset: Int? = null,
        count: Int? = null,
        extended: Boolean? = null,
        dateFrom: String? = null,
        dateTo: String? = null
    ): VKRequest<MarketGetOrdersResponseDto> = NewApiRequest("market.getOrders") {
        GsonHolder.gson.parse<MarketGetOrdersResponseDto>(it)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 10) }
        extended?.let { addParam("extended", it) }
        dateFrom?.let { addParam("date_from", it) }
        dateTo?.let { addParam("date_to", it) }
    }

    /**
     * @param offset
     * @param count
     * @param dateFrom - Orders status updated date from (format_ yyyy-mm-dd)
     * @param dateTo - Orders status updated date to (format_ yyyy-mm-dd)
     * @return [VKRequest] with [MarketGetOrdersExtendedResponseDto]
     */
    fun marketGetOrdersExtended(
        offset: Int? = null,
        count: Int? = null,
        dateFrom: String? = null,
        dateTo: String? = null
    ): VKRequest<MarketGetOrdersExtendedResponseDto> = NewApiRequest("market.getOrders") {
        GsonHolder.gson.parse<MarketGetOrdersExtendedResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketRemoveFromAlbum(
        ownerId: UserId,
        itemId: Int,
        albumIds: List<Int>
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("market.removeFromAlbum") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketReorderAlbums(
        ownerId: UserId,
        albumId: Int,
        before: Int? = null,
        after: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("market.reorderAlbums") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketReorderItems(
        ownerId: UserId,
        itemId: Int,
        albumId: Int? = null,
        before: Int? = null,
        after: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("market.reorderItems") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketReport(
        ownerId: UserId,
        itemId: Int,
        reason: MarketReportReasonDto? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("market.report") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketReportComment(
        ownerId: UserId,
        commentId: Int,
        reason: MarketReportCommentReasonDto
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("market.reportComment") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun marketRestore(ownerId: UserId, itemId: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("market.restore") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun marketRestoreComment(ownerId: UserId, commentId: Int): VKRequest<BaseBoolIntDto> =
            NewApiRequest("market.restoreComment") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
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
     * @param extended - '1' - to return additional fields_ 'likes, can_comment, car_repost,
     * photos'. By default_ '0'.
     * @param status
     * @param needVariants - Add variants to response if exist
     * @return [VKRequest] with [MarketSearchResponseDto]
     */
    fun marketSearch(
        ownerId: UserId,
        albumId: Int? = null,
        q: String? = null,
        priceFrom: Int? = null,
        priceTo: Int? = null,
        sort: MarketSearchSortDto? = null,
        rev: MarketSearchRevDto? = null,
        offset: Int? = null,
        count: Int? = null,
        extended: Boolean? = null,
        status: List<Int>? = null,
        needVariants: Boolean? = null
    ): VKRequest<MarketSearchResponseDto> = NewApiRequest("market.search") {
        GsonHolder.gson.parse<MarketSearchResponseDto>(it)
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
        extended?.let { addParam("extended", it) }
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
     * @return [VKRequest] with [MarketSearchExtendedResponseDto]
     */
    fun marketSearchExtended(
        ownerId: UserId,
        albumId: Int? = null,
        q: String? = null,
        priceFrom: Int? = null,
        priceTo: Int? = null,
        sort: MarketSearchExtendedSortDto? = null,
        rev: MarketSearchExtendedRevDto? = null,
        offset: Int? = null,
        count: Int? = null,
        status: List<Int>? = null,
        needVariants: Boolean? = null
    ): VKRequest<MarketSearchExtendedResponseDto> = NewApiRequest("market.search") {
        GsonHolder.gson.parse<MarketSearchExtendedResponseDto>(it)
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
     * @return [VKRequest] with [MarketSearchResponseDto]
     */
    fun marketSearchItems(
        q: String,
        offset: Int? = null,
        count: Int? = null,
        categoryId: Int? = null,
        priceFrom: Int? = null,
        priceTo: Int? = null,
        sortBy: MarketSearchItemsSortByDto? = null,
        sortDirection: MarketSearchItemsSortDirectionDto? = null,
        country: Int? = null,
        city: Int? = null
    ): VKRequest<MarketSearchResponseDto> = NewApiRequest("market.searchItems") {
        GsonHolder.gson.parse<MarketSearchResponseDto>(it)
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
     * @param onlyMyGroups
     * @return [VKRequest] with [MarketSearchBasicResponseDto]
     */
    fun marketSearchItemsBasic(
        q: String,
        offset: Int? = null,
        count: Int? = null,
        categoryId: Int? = null,
        priceFrom: Int? = null,
        priceTo: Int? = null,
        sortBy: MarketSearchItemsBasicSortByDto? = null,
        sortDirection: MarketSearchItemsBasicSortDirectionDto? = null,
        country: Int? = null,
        city: Int? = null,
        onlyMyGroups: Boolean? = null
    ): VKRequest<MarketSearchBasicResponseDto> = NewApiRequest("market.searchItemsBasic") {
        GsonHolder.gson.parse<MarketSearchBasicResponseDto>(it)
    }
    .apply {
        addParam("q", q)
        offset?.let { addParam("offset", it, max = 1000) }
        count?.let { addParam("count", it, min = 0, max = 300) }
        categoryId?.let { addParam("category_id", it, min = 0) }
        priceFrom?.let { addParam("price_from", it, min = 0) }
        priceTo?.let { addParam("price_to", it, min = 0) }
        sortBy?.let { addParam("sort_by", it.value) }
        sortDirection?.let { addParam("sort_direction", it.value) }
        country?.let { addParam("country", it, min = 0) }
        city?.let { addParam("city", it, min = 0) }
        onlyMyGroups?.let { addParam("only_my_groups", it) }
    }

    object MarketAddRestrictions {
        const val NAME_MIN_LENGTH: Int = 4

        const val NAME_MAX_LENGTH: Int = 100

        const val DESCRIPTION_MIN_LENGTH: Int = 10

        const val CATEGORY_ID_MIN: Long = 0

        const val PRICE_MIN: Float = 0.0f

        const val OLD_PRICE_MIN: Float = 0.0f

        const val MAIN_PHOTO_ID_MIN: Long = 0

        const val URL_MIN_LENGTH: Int = 0

        const val URL_MAX_LENGTH: Int = 320

        const val DIMENSION_WIDTH_MIN: Long = 0

        const val DIMENSION_WIDTH_MAX: Long = 100000

        const val DIMENSION_HEIGHT_MIN: Long = 0

        const val DIMENSION_HEIGHT_MAX: Long = 100000

        const val DIMENSION_LENGTH_MIN: Long = 0

        const val DIMENSION_LENGTH_MAX: Long = 100000

        const val WEIGHT_MIN: Long = 0

        const val WEIGHT_MAX: Long = 100000000

        const val SKU_MAX_LENGTH: Int = 50
    }

    object MarketAddAlbumRestrictions {
        const val TITLE_MAX_LENGTH: Int = 128

        const val PHOTO_ID_MIN: Long = 0
    }

    object MarketCreateCommentRestrictions {
        const val ITEM_ID_MIN: Long = 0

        const val REPLY_TO_COMMENT_MIN: Long = 0

        const val STICKER_ID_MIN: Long = 0
    }

    object MarketDeleteRestrictions {
        const val ITEM_ID_MIN: Long = 0
    }

    object MarketDeleteAlbumRestrictions {
        const val ALBUM_ID_MIN: Long = 0
    }

    object MarketDeleteCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 0
    }

    object MarketEditRestrictions {
        const val ITEM_ID_MIN: Long = 0

        const val NAME_MIN_LENGTH: Int = 4

        const val NAME_MAX_LENGTH: Int = 100

        const val DESCRIPTION_MIN_LENGTH: Int = 10

        const val CATEGORY_ID_MIN: Long = 0

        const val PRICE_MIN: Float = 0.0f

        const val OLD_PRICE_MIN: Float = 0.0f

        const val MAIN_PHOTO_ID_MIN: Long = 0

        const val URL_MIN_LENGTH: Int = 0

        const val URL_MAX_LENGTH: Int = 320

        const val DIMENSION_WIDTH_MIN: Long = 0

        const val DIMENSION_WIDTH_MAX: Long = 100000

        const val DIMENSION_HEIGHT_MIN: Long = 0

        const val DIMENSION_HEIGHT_MAX: Long = 100000

        const val DIMENSION_LENGTH_MIN: Long = 0

        const val DIMENSION_LENGTH_MAX: Long = 100000

        const val WEIGHT_MIN: Long = 0

        const val WEIGHT_MAX: Long = 100000000

        const val SKU_MAX_LENGTH: Int = 50
    }

    object MarketEditAlbumRestrictions {
        const val ALBUM_ID_MIN: Long = 0

        const val TITLE_MAX_LENGTH: Int = 128

        const val PHOTO_ID_MIN: Long = 0
    }

    object MarketEditCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 0
    }

    object MarketEditOrderRestrictions {
        const val USER_ID_MIN: Long = 1

        const val ORDER_ID_MIN: Long = 0

        const val MERCHANT_COMMENT_MAX_LENGTH: Int = 800

        const val STATUS_MIN: Long = 0

        const val TRACK_NUMBER_MAX_LENGTH: Int = 60

        const val DELIVERY_PRICE_MIN: Long = 0

        const val WIDTH_MIN: Long = 0

        const val WIDTH_MAX: Long = 100000

        const val LENGTH_MIN: Long = 0

        const val LENGTH_MAX: Long = 100000

        const val HEIGHT_MIN: Long = 0

        const val HEIGHT_MAX: Long = 100000

        const val WEIGHT_MIN: Long = 0

        const val WEIGHT_MAX: Long = 100000000
    }

    object MarketFilterCategoriesRestrictions {
        const val CATEGORY_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object MarketGetRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200

        const val OFFSET_MIN: Long = 0
    }

    object MarketGetExtendedRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200

        const val OFFSET_MIN: Long = 0
    }

    object MarketGetAlbumsRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object MarketGetCategoriesRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val ALBUM_ID_MIN: Long = 1

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000

        const val OFFSET_MIN: Long = 0
    }

    object MarketGetCommentsRestrictions {
        const val ITEM_ID_MIN: Long = 0

        const val START_COMMENT_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object MarketGetGroupOrdersRestrictions {
        const val GROUP_ID_MIN: Int = 1

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 1

        const val COUNT_MAX: Long = 50
    }

    object MarketGetOrderByIdRestrictions {
        const val ORDER_ID_MIN: Long = 0

        const val USER_ID_MIN: Long = 0
    }

    object MarketGetOrderItemsRestrictions {
        const val ORDER_ID_MIN: Long = 0

        const val USER_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0
    }

    object MarketGetOrdersRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 10
    }

    object MarketGetOrdersExtendedRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 10
    }

    object MarketRemoveFromAlbumRestrictions {
        const val ITEM_ID_MIN: Long = 0
    }

    object MarketReorderAlbumsRestrictions {
        const val BEFORE_MIN: Long = 0

        const val AFTER_MIN: Long = 0
    }

    object MarketReorderItemsRestrictions {
        const val ITEM_ID_MIN: Long = 0

        const val BEFORE_MIN: Long = 0

        const val AFTER_MIN: Long = 0
    }

    object MarketReportRestrictions {
        const val ITEM_ID_MIN: Long = 0

        const val REASON_MIN: Long = 0
    }

    object MarketReportCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 0

        const val REASON_MIN: Long = 0
    }

    object MarketRestoreRestrictions {
        const val ITEM_ID_MIN: Long = 0
    }

    object MarketRestoreCommentRestrictions {
        const val COMMENT_ID_MIN: Long = 0
    }

    object MarketSearchRestrictions {
        const val ALBUM_ID_MIN: Long = 0

        const val PRICE_FROM_MIN: Long = 0

        const val PRICE_TO_MIN: Long = 0

        const val REV_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200
    }

    object MarketSearchExtendedRestrictions {
        const val ALBUM_ID_MIN: Long = 0

        const val PRICE_FROM_MIN: Long = 0

        const val PRICE_TO_MIN: Long = 0

        const val REV_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200
    }

    object MarketSearchItemsRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 300

        const val CATEGORY_ID_MIN: Long = 0

        const val PRICE_FROM_MIN: Long = 0

        const val PRICE_TO_MIN: Long = 0

        const val COUNTRY_MIN: Long = 0

        const val CITY_MIN: Long = 0
    }

    object MarketSearchItemsBasicRestrictions {
        const val OFFSET_MAX: Long = 1000

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 300

        const val CATEGORY_ID_MIN: Long = 0

        const val PRICE_FROM_MIN: Long = 0

        const val PRICE_TO_MIN: Long = 0

        const val COUNTRY_MIN: Long = 0

        const val CITY_MIN: Long = 0
    }
}
