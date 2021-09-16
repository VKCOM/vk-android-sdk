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
package com.vk.sdk.api.groups.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Int
import kotlin.String

/**
 * @param name - Link title
 * @param desc - Link description
 * @param editTitle - Information whether the link title can be edited
 * @param id - Link ID
 * @param photo100 - URL of square image of the link with 100 pixels in width
 * @param photo50 - URL of square image of the link with 50 pixels in width
 * @param url - Link URL
 * @param imageProcessing - Information whether the image on processing
 */
data class GroupsLinksItem(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("desc")
    val desc: String? = null,
    @SerializedName("edit_title")
    val editTitle: BaseBoolInt? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("photo_100")
    val photo100: String? = null,
    @SerializedName("photo_50")
    val photo50: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("image_processing")
    val imageProcessing: BaseBoolInt? = null
)
