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
package com.vk.sdk.api.notes.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Int
import kotlin.String

/**
 * @param comments Comments number
 * @param date Date when the note has been created in Unixtime
 * @param id Note ID
 * @param ownerId Note owner's ID
 * @param title Note title
 * @param viewUrl URL of the page with note preview
 * @param readComments no description
 * @param canComment Information whether current user can comment the note
 * @param text Note text
 * @param textWiki Note text in wiki format
 */
data class NotesNote(
    @SerializedName(value="comments")
    val comments: Int,
    @SerializedName(value="date")
    val date: Int,
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="owner_id")
    val ownerId: Int,
    @SerializedName(value="title")
    val title: String,
    @SerializedName(value="view_url")
    val viewUrl: String,
    @SerializedName(value="read_comments")
    val readComments: Int? = null,
    @SerializedName(value="can_comment")
    val canComment: BaseBoolInt? = null,
    @SerializedName(value="text")
    val text: String? = null,
    @SerializedName(value="text_wiki")
    val textWiki: String? = null
)
