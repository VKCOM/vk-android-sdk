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
package com.vk.sdk.api.prettyCards.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.prettyCards.dto.PrettyCardsEditResponseDto
import com.vk.sdk.api.prettyCards.responses.PrettyCardsEditResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * @param ownerId  
 * @param cardId  
 * @param photo  
 * @param title  
 * @param link  maxLength 2000
 * @param price  maxLength 20
 * @param priceOld  maxLength 20
 * @param button  maxLength 255
 */
class PrettyCardsEdit(
    private val ownerId: Int,
    private val cardId: Int,
    private val photo: String? = null,
    private val title: String? = null,
    private val link: String? = null,
    private val price: String? = null,
    private val priceOld: String? = null,
    private val button: String? = null
) : VKRequest<PrettyCardsEditResponseDto>("prettyCards.edit") {
    init {
        addParam("owner_id", ownerId)
        addParam("card_id", cardId)
        photo?.let { value ->
            addParam("photo", value)
        }
        title?.let { value ->
            addParam("title", value)
        }
        link?.let { value ->
            addParam("link", value)
        }
        price?.let { value ->
            addParam("price", value)
        }
        priceOld?.let { value ->
            addParam("price_old", value)
        }
        button?.let { value ->
            addParam("button", value)
        }
    }

    override fun parse(r: JSONObject): PrettyCardsEditResponseDto =
            GsonHolder.gson.fromJson(r.toString(), PrettyCardsEditResponse::class.java).response
}
