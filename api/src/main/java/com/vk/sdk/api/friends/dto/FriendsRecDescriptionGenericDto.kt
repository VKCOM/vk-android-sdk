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
package com.vk.sdk.api.friends.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseImageDto
import java.lang.IllegalStateException
import java.lang.reflect.Type
import kotlin.String
import kotlin.collections.List

sealed class FriendsRecDescriptionGenericDto {
    /**
     * Description of recommended friend.
     * @param contentType
     * @param icon
     * @param text - Description text.
     * @param images
     */
    data class FriendsRecDescriptionDto(
        @SerializedName("content_type")
        val contentType: FriendsRecDescriptionContentTypeDto,
        @SerializedName("icon")
        val icon: FriendsRecDescriptionIconDto? = null,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("images")
        val images: List<List<BaseImageDto>>? = null
    ) : FriendsRecDescriptionGenericDto()

    /**
     * Simple wrapper for [String]
     */
    class StringWrapper(
        val value: String
    ) : FriendsRecDescriptionGenericDto()

    class Deserializer : JsonDeserializer<FriendsRecDescriptionGenericDto> {
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type?,
            context: JsonDeserializationContext
        ): FriendsRecDescriptionGenericDto {
            if (json.isJsonObject) {
                return context.deserialize(json, FriendsRecDescriptionDto::class.java)
            }
            val primitive = json.asJsonPrimitive
            return when {
                primitive.isString -> StringWrapper(primitive.asString)
                else -> throw IllegalStateException("no primitive mapping")
            }
        }
    }
}
