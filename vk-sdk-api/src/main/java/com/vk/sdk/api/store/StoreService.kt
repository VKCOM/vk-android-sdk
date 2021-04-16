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
package com.vk.sdk.api.store

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.base.dto.BaseSticker
import com.vk.sdk.api.store.dto.StoreGetStickersKeywordsResponse
import com.vk.sdk.api.store.dto.StoreProduct
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class StoreService {
    /**
     * Adds given sticker IDs to the list of user's favorite stickers
     *
     * @param stickerIds - Sticker IDs to be added
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun storeAddStickersToFavorite(stickerIds: List<Int>): VKRequest<BaseOkResponse> =
            NewApiRequest("store.addStickersToFavorite") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("sticker_ids", stickerIds)
    }

    /**
     * @return [VKRequest] with [Unit]
     */
    fun storeGetFavoriteStickers(): VKRequest<List<BaseSticker>> =
            NewApiRequest("store.getFavoriteStickers") {
        val typeToken = object: TypeToken<List<BaseSticker>>() {}.type
        GsonHolder.gson.fromJson<List<BaseSticker>>(it, typeToken)
    }

    /**
     * @param type
     * @param merchant
     * @param section
     * @param productIds
     * @param filters
     * @return [VKRequest] with [Unit]
     */
    fun storeGetProducts(
        type: String? = null,
        merchant: String? = null,
        section: String? = null,
        productIds: List<Int>? = null,
        filters: List<String>? = null
    ): VKRequest<List<StoreProduct>> = NewApiRequest("store.getProducts") {
        val typeToken = object: TypeToken<List<StoreProduct>>() {}.type
        GsonHolder.gson.fromJson<List<StoreProduct>>(it, typeToken)
    }
    .apply {
        type?.let { addParam("type", it) }
        merchant?.let { addParam("merchant", it) }
        section?.let { addParam("section", it) }
        productIds?.let { addParam("product_ids", it) }
        filters?.let { addParam("filters", it) }
    }

    /**
     * @param stickersIds
     * @param productsIds
     * @param aliases
     * @param allProducts
     * @param needStickers
     * @return [VKRequest] with [StoreGetStickersKeywordsResponse]
     */
    fun storeGetStickersKeywords(
        stickersIds: List<Int>? = null,
        productsIds: List<Int>? = null,
        aliases: Boolean? = null,
        allProducts: Boolean? = null,
        needStickers: Boolean? = null
    ): VKRequest<StoreGetStickersKeywordsResponse> = NewApiRequest("store.getStickersKeywords") {
        GsonHolder.gson.fromJson(it, StoreGetStickersKeywordsResponse::class.java)
    }
    .apply {
        stickersIds?.let { addParam("stickers_ids", it) }
        productsIds?.let { addParam("products_ids", it) }
        aliases?.let { addParam("aliases", it) }
        allProducts?.let { addParam("all_products", it) }
        needStickers?.let { addParam("need_stickers", it) }
    }

    /**
     * Removes given sticker IDs from the list of user's favorite stickers
     *
     * @param stickerIds - Sticker IDs to be removed
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun storeRemoveStickersFromFavorite(stickerIds: List<Int>): VKRequest<BaseOkResponse> =
            NewApiRequest("store.removeStickersFromFavorite") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("sticker_ids", stickerIds)
    }
}
