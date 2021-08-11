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
package com.vk.sdk.api.docs.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id - Document ID
 * @param ownerId - Document owner ID
 * @param title - Document title
 * @param size - File size in bites
 * @param ext - File extension
 * @param date - Date when file has been uploaded in Unixtime
 * @param type - Document type
 * @param url - File URL
 * @param preview
 * @param isLicensed
 * @param accessKey - Access key for the document
 * @param tags - Document tags
 */
data class DocsDoc(
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("title")
    val title: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("ext")
    val ext: String,
    @SerializedName("date")
    val date: Int,
    @SerializedName("type")
    val type: Int,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("preview")
    val preview: DocsDocPreview? = null,
    @SerializedName("is_licensed")
    val isLicensed: BaseBoolInt? = null,
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("tags")
    val tags: List<String>? = null
)
