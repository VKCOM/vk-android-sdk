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
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolInt
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param comments - Comments number
 * @param date - Date when the note has been created in Unixtime
 * @param id - Note ID
 * @param ownerId - Note owner's ID
 * @param title - Note title
 * @param viewUrl - URL of the page with note preview
 * @param readComments
 * @param canComment - Information whether current user can comment the note
 * @param text - Note text
 * @param textWiki - Note text in wiki format
 * @param privacyView
 * @param privacyComment
 */
data class NotesNote(
    @SerializedName("comments")
    val comments: Int,
    @SerializedName("date")
    val date: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("title")
    val title: String,
    @SerializedName("view_url")
    val viewUrl: String,
    @SerializedName("read_comments")
    val readComments: Int? = null,
    @SerializedName("can_comment")
    val canComment: BaseBoolInt? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("text_wiki")
    val textWiki: String? = null,
    @SerializedName("privacy_view")
    val privacyView: List<String>? = null,
    @SerializedName("privacy_comment")
    val privacyComment: List<String>? = null
)
