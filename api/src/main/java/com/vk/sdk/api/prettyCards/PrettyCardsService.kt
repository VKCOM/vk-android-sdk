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
package com.vk.sdk.api.prettyCards

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.prettyCards.dto.PrettyCardsCreateResponse
import com.vk.sdk.api.prettyCards.dto.PrettyCardsDeleteResponse
import com.vk.sdk.api.prettyCards.dto.PrettyCardsEditResponse
import com.vk.sdk.api.prettyCards.dto.PrettyCardsGetResponse
import com.vk.sdk.api.prettyCards.dto.PrettyCardsPrettyCardOrError
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class PrettyCardsService {
    /**
     * @param ownerId
     * @param photo
     * @param title
     * @param link
     * @param price
     * @param priceOld
     * @param button
     * @return [VKRequest] with [PrettyCardsCreateResponse]
     */
    fun prettyCardsCreate(
        ownerId: Int,
        photo: String,
        title: String,
        link: String,
        price: String? = null,
        priceOld: String? = null,
        button: String? = null
    ): VKRequest<PrettyCardsCreateResponse> = NewApiRequest("prettyCards.create") {
        GsonHolder.gson.fromJson(it, PrettyCardsCreateResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("photo", photo)
        addParam("title", title)
        addParam("link", link, maxLength = 2000)
        price?.let { addParam("price", it, maxLength = 20) }
        priceOld?.let { addParam("price_old", it, maxLength = 20) }
        button?.let { addParam("button", it, maxLength = 255) }
    }

    /**
     * @param ownerId
     * @param cardId
     * @return [VKRequest] with [PrettyCardsDeleteResponse]
     */
    fun prettyCardsDelete(ownerId: Int, cardId: Int): VKRequest<PrettyCardsDeleteResponse> =
            NewApiRequest("prettyCards.delete") {
        GsonHolder.gson.fromJson(it, PrettyCardsDeleteResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("card_id", cardId)
    }

    /**
     * @param ownerId
     * @param cardId
     * @param photo
     * @param title
     * @param link
     * @param price
     * @param priceOld
     * @param button
     * @return [VKRequest] with [PrettyCardsEditResponse]
     */
    fun prettyCardsEdit(
        ownerId: Int,
        cardId: Int,
        photo: String? = null,
        title: String? = null,
        link: String? = null,
        price: String? = null,
        priceOld: String? = null,
        button: String? = null
    ): VKRequest<PrettyCardsEditResponse> = NewApiRequest("prettyCards.edit") {
        GsonHolder.gson.fromJson(it, PrettyCardsEditResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("card_id", cardId)
        photo?.let { addParam("photo", it) }
        title?.let { addParam("title", it) }
        link?.let { addParam("link", it, maxLength = 2000) }
        price?.let { addParam("price", it, maxLength = 20) }
        priceOld?.let { addParam("price_old", it, maxLength = 20) }
        button?.let { addParam("button", it, maxLength = 255) }
    }

    /**
     * @param ownerId
     * @param offset
     * @param count
     * @return [VKRequest] with [PrettyCardsGetResponse]
     */
    fun prettyCardsGet(
        ownerId: Int,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<PrettyCardsGetResponse> = NewApiRequest("prettyCards.get") {
        GsonHolder.gson.fromJson(it, PrettyCardsGetResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
    }

    /**
     * @param ownerId
     * @param cardIds
     * @return [VKRequest] with [Unit]
     */
    fun prettyCardsGetById(ownerId: Int, cardIds: List<Int>):
            VKRequest<List<PrettyCardsPrettyCardOrError>> = NewApiRequest("prettyCards.getById") {
        val typeToken = object: TypeToken<List<PrettyCardsPrettyCardOrError>>() {}.type
        GsonHolder.gson.fromJson<List<PrettyCardsPrettyCardOrError>>(it, typeToken)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("card_ids", cardIds)
    }

    /**
     * @return [VKRequest] with [String]
     */
    fun prettyCardsGetUploadURL(): VKRequest<String> = NewApiRequest("prettyCards.getUploadURL") {
        GsonHolder.gson.fromJson(it, String::class.java)
    }
}
