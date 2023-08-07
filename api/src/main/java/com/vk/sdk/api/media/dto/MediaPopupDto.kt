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
package com.vk.sdk.api.media.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseImageDto
import com.vk.sdk.api.base.dto.BaseLinkButtonDto
import kotlin.String
import kotlin.collections.List

/**
 * @param title - Restriction title
 * @param id - Popup id
 * @param button - Restriction button
 * @param buttons - Restriction button
 * @param icons - Restriction icon
 * @param musicSubscriptionEvent - Stats param
 * @param text - Restriction text
 * @param imageMode
 * @param emojiIcons
 */
data class MediaPopupDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("button")
    val button: BaseLinkButtonDto? = null,
    @SerializedName("buttons")
    val buttons: List<BaseLinkButtonDto>? = null,
    @SerializedName("icons")
    val icons: List<BaseImageDto>? = null,
    @SerializedName("music_subscription_event")
    val musicSubscriptionEvent: String? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("image_mode")
    val imageMode: MediaPopupDto.ImageModeDto? = null,
    @SerializedName("emoji_icons")
    val emojiIcons: String? = null
) {
    enum class ImageModeDto(
        val value: String
    ) {
        @SerializedName("round")
        ROUND("round"),

        @SerializedName("small")
        SMALL("small"),

        @SerializedName("big")
        BIG("big"),

        @SerializedName("emoji")
        EMOJI("emoji");
    }
}
