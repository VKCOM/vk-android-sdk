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
package com.vk.sdk.api.messages.dto

import com.google.gson.annotations.SerializedName
import kotlin.Boolean
import kotlin.String

/**
 * @param photo50 - URL of the preview image with 50px in width
 * @param photo100 - URL of the preview image with 100px in width
 * @param photo200 - URL of the preview image with 200px in width
 * @param isDefaultPhoto - If provided photo is default
 * @param isDefaultCallPhoto - If provided photo is default call photo
 */
data class MessagesChatSettingsPhoto(
    @SerializedName("photo_50")
    val photo50: String? = null,
    @SerializedName("photo_100")
    val photo100: String? = null,
    @SerializedName("photo_200")
    val photo200: String? = null,
    @SerializedName("is_default_photo")
    val isDefaultPhoto: Boolean? = null,
    @SerializedName("is_default_call_photo")
    val isDefaultCallPhoto: Boolean? = null
)
