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

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseImage
import com.vk.sdk.api.base.dto.BaseStickerNew
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id - Id of the product
 * @param type - Product type
 * @param isNew - Information whether sticker product wasn't used after being purchased
 * @param purchased - Information whether the product is purchased (1 - yes, 0 - no)
 * @param active - Information whether the product is active (1 - yes, 0 - no)
 * @param promoted - Information whether the product is promoted (1 - yes, 0 - no)
 * @param purchaseDate - Date (Unix time) when the product was purchased
 * @param title - Title of the product
 * @param stickers
 * @param styleStickerIds - Array of style sticker ids (for sticker pack styles)
 * @param icon - Array of icon images or icon set object of the product (for stickers product type)
 * @param previews - Array of preview images of the product (for stickers product type)
 * @param hasAnimation - Information whether the product is an animated sticker pack (for stickers
 * product type)
 * @param subtitle - Subtitle of the product
 * @param paymentRegion
 */
data class StoreProduct(
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: StoreProduct.Type,
    @SerializedName("is_new")
    val isNew: Boolean? = null,
    @SerializedName("purchased")
    val purchased: BaseBoolInt? = null,
    @SerializedName("active")
    val active: BaseBoolInt? = null,
    @SerializedName("promoted")
    val promoted: BaseBoolInt? = null,
    @SerializedName("purchase_date")
    val purchaseDate: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("stickers")
    val stickers: List<BaseStickerNew>? = null,
    @SerializedName("style_sticker_ids")
    val styleStickerIds: List<Int>? = null,
    @SerializedName("icon")
    val icon: List<BaseImage>? = null,
    @SerializedName("previews")
    val previews: List<BaseImage>? = null,
    @SerializedName("has_animation")
    val hasAnimation: Boolean? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("payment_region")
    val paymentRegion: String? = null
) {
    enum class Type(
        val value: String
    ) {
        @SerializedName("stickers")
        STICKERS("stickers"),

        @SerializedName("votes")
        VOTES("votes"),

        @SerializedName("subscriprions")
        SUBSCRIPRIONS("subscriprions");
    }
}
