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
package com.vk.sdk.api.board.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Int
import kotlin.String

/**
 * @param comments - Comments number
 * @param created - Date when the topic has been created in Unixtime
 * @param createdBy - Creator ID
 * @param id - Topic ID
 * @param isClosed - Information whether the topic is closed
 * @param isFixed - Information whether the topic is fixed
 * @param title - Topic title
 * @param updated - Date when the topic has been updated in Unixtime
 * @param updatedBy - ID of user who updated the topic
 */
data class BoardTopic(
    @SerializedName("comments")
    val comments: Int? = null,
    @SerializedName("created")
    val created: Int? = null,
    @SerializedName("created_by")
    val createdBy: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("is_closed")
    val isClosed: BaseBoolInt? = null,
    @SerializedName("is_fixed")
    val isFixed: BaseBoolInt? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("updated")
    val updated: Int? = null,
    @SerializedName("updated_by")
    val updatedBy: Int? = null
)
