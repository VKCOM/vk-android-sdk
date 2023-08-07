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

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.prettyCards.dto.PrettyCardsCreateResponseDto
import com.vk.sdk.api.prettyCards.dto.PrettyCardsDeleteResponseDto
import com.vk.sdk.api.prettyCards.dto.PrettyCardsEditResponseDto
import com.vk.sdk.api.prettyCards.dto.PrettyCardsGetResponseDto
import com.vk.sdk.api.prettyCards.dto.PrettyCardsPrettyCardOrErrorDto
import kotlin.Int
import kotlin.Long
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
     * @return [VKRequest] with [PrettyCardsCreateResponseDto]
     */
    fun prettyCardsCreate(
        ownerId: UserId,
        photo: String,
        title: String,
        link: String,
        price: String? = null,
        priceOld: String? = null,
        button: String? = null
    ): VKRequest<PrettyCardsCreateResponseDto> = NewApiRequest("prettyCards.create") {
        GsonHolder.gson.parse<PrettyCardsCreateResponseDto>(it)
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
     * @return [VKRequest] with [PrettyCardsDeleteResponseDto]
     */
    fun prettyCardsDelete(ownerId: UserId, cardId: Int): VKRequest<PrettyCardsDeleteResponseDto> =
            NewApiRequest("prettyCards.delete") {
        GsonHolder.gson.parse<PrettyCardsDeleteResponseDto>(it)
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
     * @return [VKRequest] with [PrettyCardsEditResponseDto]
     */
    fun prettyCardsEdit(
        ownerId: UserId,
        cardId: Int,
        photo: String? = null,
        title: String? = null,
        link: String? = null,
        price: String? = null,
        priceOld: String? = null,
        button: String? = null
    ): VKRequest<PrettyCardsEditResponseDto> = NewApiRequest("prettyCards.edit") {
        GsonHolder.gson.parse<PrettyCardsEditResponseDto>(it)
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
     * @return [VKRequest] with [PrettyCardsGetResponseDto]
     */
    fun prettyCardsGet(
        ownerId: UserId,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<PrettyCardsGetResponseDto> = NewApiRequest("prettyCards.get") {
        GsonHolder.gson.parse<PrettyCardsGetResponseDto>(it)
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
    fun prettyCardsGetById(ownerId: UserId, cardIds: List<Int>):
            VKRequest<List<PrettyCardsPrettyCardOrErrorDto>> =
            NewApiRequest("prettyCards.getById") {
        GsonHolder.gson.parseList<PrettyCardsPrettyCardOrErrorDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("card_ids", cardIds)
    }

    /**
     * @return [VKRequest] with [String]
     */
    fun prettyCardsGetUploadURL(): VKRequest<String> = NewApiRequest("prettyCards.getUploadURL") {
        GsonHolder.gson.parse<String>(it)
    }

    object PrettyCardsCreateRestrictions {
        const val LINK_MAX_LENGTH: Int = 2000

        const val PRICE_MAX_LENGTH: Int = 20

        const val PRICE_OLD_MAX_LENGTH: Int = 20

        const val BUTTON_MAX_LENGTH: Int = 255
    }

    object PrettyCardsEditRestrictions {
        const val LINK_MAX_LENGTH: Int = 2000

        const val PRICE_MAX_LENGTH: Int = 20

        const val PRICE_OLD_MAX_LENGTH: Int = 20

        const val BUTTON_MAX_LENGTH: Int = 255
    }

    object PrettyCardsGetRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }
}
