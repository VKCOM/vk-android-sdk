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
package com.vk.sdk.api.newsfeed.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.wall.dto.WallWallpost
import java.lang.reflect.Type
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param buttonText no description
 * @param feedId id of feed in digest
 * @param items no description
 * @param mainPostIds no description
 * @param template type of digest
 * @param title no description
 * @param trackCode no description
 * @param type no description
 * @param sourceId Item source ID
 * @param date Date when item has been added in Unixtime
 */
data class NewsfeedItemDigest(
    @SerializedName(value="button_text")
    val buttonText: String? = null,
    @SerializedName(value="feed_id")
    val feedId: String? = null,
    @SerializedName(value="items")
    val items: List<WallWallpost>? = null,
    @SerializedName(value="main_post_ids")
    val mainPostIds: List<String>? = null,
    @SerializedName(value="template")
    val template: Template? = null,
    @SerializedName(value="title")
    val title: String? = null,
    @SerializedName(value="track_code")
    val trackCode: String? = null,
    @SerializedName(value="type")
    val type: NewsfeedNewsfeedItemType? = null,
    @SerializedName(value="source_id")
    val sourceId: Int? = null,
    @SerializedName(value="date")
    val date: Int? = null
) {
    enum class Template(
        val value: String
    ) {
        LIST("list"),

        GRID("grid");

        class Serializer : JsonDeserializer<Template> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): Template = values().first { it.value.toString() == json!!.asJsonPrimitive.toString()
                    }
        }
    }
}
