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
package com.vk.sdk.api.store.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseImage
import com.vk.sdk.api.base.dto.BaseSticker
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id Id of the product
 * @param type Product type
 * @param purchased Information whether the product is purchased (1 - yes, 0 - no)
 * @param active Information whether the product is active (1 - yes, 0 - no)
 * @param promoted Information whether the product is promoted (1 - yes, 0 - no)
 * @param purchaseDate Date (Unix time) when the product was purchased
 * @param title Title of the product
 * @param stickers no description
 * @param icon no description
 * @param previews Array of preview images of the product (for stickers product type)
 * @param hasAnimation Information whether the product is an animated sticker pack (for stickers
 * product type)
 * @param subtitle Subtitle of the product
 */
data class StoreProduct(
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="type")
    val type: Type,
    @SerializedName(value="purchased")
    val purchased: BaseBoolInt? = null,
    @SerializedName(value="active")
    val active: BaseBoolInt? = null,
    @SerializedName(value="promoted")
    val promoted: BaseBoolInt? = null,
    @SerializedName(value="purchase_date")
    val purchaseDate: Int? = null,
    @SerializedName(value="title")
    val title: String? = null,
    @SerializedName(value="stickers")
    val stickers: List<BaseSticker>? = null,
    @SerializedName(value="icon")
    val icon: List<BaseImage>? = null,
    @SerializedName(value="previews")
    val previews: List<BaseImage>? = null,
    @SerializedName(value="has_animation")
    val hasAnimation: Boolean? = null,
    @SerializedName(value="subtitle")
    val subtitle: String? = null
) {
    enum class Type(
        val value: String
    ) {
        STICKERS("stickers"),

        VOTES("votes"),

        SUBSCRIPRIONS("subscriprions");

        class Serializer : JsonSerializer<Type>, JsonDeserializer<Type> {
            override fun serialize(
                src: Type?,
                typeOfSrc: java.lang.reflect.Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: java.lang.reflect.Type?,
                context: JsonDeserializationContext?
            ): Type {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }
}
