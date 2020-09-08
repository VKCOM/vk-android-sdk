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
package com.vk.sdk.api.account.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type
import kotlin.Float
import kotlin.Int
import kotlin.String

/**
 * @param description Offer description
 * @param id Offer ID
 * @param img URL of the preview image
 * @param instruction Instruction how to process the offer
 * @param instructionHtml Instruction how to process the offer (HTML format)
 * @param price Offer price
 * @param shortDescription Offer short description
 * @param tag Offer tag
 * @param title Offer title
 * @param currencyAmount Currency amount
 * @param linkId Link id
 * @param linkType Link type
 */
data class AccountOffer(
    @SerializedName(value="description")
    val description: String? = null,
    @SerializedName(value="id")
    val id: Int? = null,
    @SerializedName(value="img")
    val img: String? = null,
    @SerializedName(value="instruction")
    val instruction: String? = null,
    @SerializedName(value="instruction_html")
    val instructionHtml: String? = null,
    @SerializedName(value="price")
    val price: Int? = null,
    @SerializedName(value="short_description")
    val shortDescription: String? = null,
    @SerializedName(value="tag")
    val tag: String? = null,
    @SerializedName(value="title")
    val title: String? = null,
    @SerializedName(value="currency_amount")
    val currencyAmount: Float? = null,
    @SerializedName(value="link_id")
    val linkId: Int? = null,
    @SerializedName(value="link_type")
    val linkType: LinkType? = null
) {
    enum class LinkType(
        val value: String
    ) {
        PROFILE("profile"),

        GROUP("group"),

        APP("app");

        class Serializer : JsonDeserializer<LinkType> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): LinkType = values().first { it.value.toString() == json!!.asJsonPrimitive.toString()
                    }
        }
    }
}
