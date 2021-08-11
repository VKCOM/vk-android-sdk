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
package com.vk.sdk.api.textlives.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.photos.dto.PhotosPhoto
import kotlin.Boolean
import kotlin.Int
import kotlin.String

/**
 * @param online - Amount of people reading Livetext right now
 * @param url - url to be used for block buttons and onclick events
 * @param isLive - the live state of textlive. 0 is offline, 1 is ongoing
 * @param textliveId - Livetext id
 * @param type
 * @param title - Livetext title
 * @param unread - Amount of posts flagged as unread for current_user
 * @param coverPhoto
 * @param textpostIsImportant - whether the textpost should be highlighted
 * @param textliveOwnerId - Livetext owner id
 * @param textpostAuthorId - Livetext post author_id id
 * @param textpostDate - Livetext post publish date as unix timestamp
 * @param text - Livetext post text
 * @param textpostAttachment
 * @param attachUrl - Service field to allow special interactions
 * @param endDate - Textlive finish date as unix timestamp
 */
data class TextlivesTextliveTextpostBlock(
    @SerializedName("online")
    val online: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("is_live")
    val isLive: TextlivesTextliveTextpostBlock.IsLive,
    @SerializedName("textlive_id")
    val textliveId: Int,
    @SerializedName("type")
    val type: TextlivesTextliveTextpostBlock.Type? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("unread")
    val unread: Int? = null,
    @SerializedName("cover_photo")
    val coverPhoto: PhotosPhoto? = null,
    @SerializedName("textpost_is_important")
    val textpostIsImportant: Boolean? = null,
    @SerializedName("textlive_owner_id")
    val textliveOwnerId: UserId? = null,
    @SerializedName("textpost_author_id")
    val textpostAuthorId: UserId? = null,
    @SerializedName("textpost_date")
    val textpostDate: Int? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("textpost_attachment")
    val textpostAttachment: TextlivesTextpostAttachment? = null,
    @SerializedName("attach_url")
    val attachUrl: String? = null,
    @SerializedName("end_date")
    val endDate: Int? = null
) {
    enum class IsLive(
        val value: Int
    ) {
        @SerializedName("0")
        OFFLINE(0),

        @SerializedName("1")
        ONGOING(1);
    }

    enum class Type(
        val value: String
    ) {
        @SerializedName("textlive")
        TEXTLIVE("textlive"),

        @SerializedName("textpost")
        TEXTPOST("textpost"),

        @SerializedName("textpost_publish")
        TEXTPOST_PUBLISH("textpost_publish"),

        @SerializedName("textlive_feed_block")
        TEXTLIVE_FEED_BLOCK("textlive_feed_block");
    }
}
