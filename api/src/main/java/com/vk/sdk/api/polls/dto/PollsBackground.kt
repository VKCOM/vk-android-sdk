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
package com.vk.sdk.api.polls.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseGradientPoint
import com.vk.sdk.api.base.dto.BaseImage
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param angle - Gradient angle with 0 on positive X axis
 * @param color - Hex color code without #
 * @param height - Original height of pattern tile
 * @param id
 * @param name
 * @param images - Pattern tiles
 * @param points - Gradient points
 * @param type
 * @param width - Original with of pattern tile
 */
data class PollsBackground(
    @SerializedName("angle")
    val angle: Int? = null,
    @SerializedName("color")
    val color: String? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("images")
    val images: List<BaseImage>? = null,
    @SerializedName("points")
    val points: List<BaseGradientPoint>? = null,
    @SerializedName("type")
    val type: PollsBackground.Type? = null,
    @SerializedName("width")
    val width: Int? = null
) {
    enum class Type(
        val value: String
    ) {
        @SerializedName("gradient")
        GRADIENT("gradient"),

        @SerializedName("tile")
        TILE("tile");
    }
}
