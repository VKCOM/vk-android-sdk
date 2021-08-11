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
import com.vk.dto.common.id.UserId
import kotlin.Int
import kotlin.String

/**
 * Description of the action, that should be performed on button click
 * @param type - Button type
 * @param appId - Fragment value in app link like vk.com/app{app_id}_-654321#hash
 * @param hash - Fragment value in app link like vk.com/app123456_-654321#{hash}
 * @param label - Label for button
 * @param link - link for button
 * @param ownerId - Fragment value in app link like vk.com/app123456_{owner_id}#hash
 * @param payload - Additional data sent along with message for developer convenience
 */
data class MessagesKeyboardButtonAction(
    @SerializedName("type")
    val type: MessagesTemplateActionTypeNames,
    @SerializedName("app_id")
    val appId: Int? = null,
    @SerializedName("hash")
    val hash: String? = null,
    @SerializedName("label")
    val label: String? = null,
    @SerializedName("link")
    val link: String? = null,
    @SerializedName("owner_id")
    val ownerId: UserId? = null,
    @SerializedName("payload")
    val payload: String? = null
)
