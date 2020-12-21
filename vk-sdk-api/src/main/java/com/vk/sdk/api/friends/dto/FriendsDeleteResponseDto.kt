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
import com.google.gson.JsonNull
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type
import kotlin.Int

/**
 * @param success no description
 * @param friendDeleted Returns 1 if friend has been deleted
 * @param outRequestDeleted Returns 1 if out request has been canceled
 * @param inRequestDeleted Returns 1 if incoming request has been declined
 * @param suggestionDeleted Returns 1 if suggestion has been declined
 */
data class FriendsDeleteResponseDto(
    @SerializedName(value="success")
    val success: Int,
    @SerializedName(value="friend_deleted")
    val friendDeleted: FriendDeleted? = null,
    @SerializedName(value="out_request_deleted")
    val outRequestDeleted: OutRequestDeleted? = null,
    @SerializedName(value="in_request_deleted")
    val inRequestDeleted: InRequestDeleted? = null,
    @SerializedName(value="suggestion_deleted")
    val suggestionDeleted: SuggestionDeleted? = null
) {
    enum class FriendDeleted(
        val value: Int
    ) {
        OK(1);

        class Serializer : JsonSerializer<FriendDeleted>, JsonDeserializer<FriendDeleted> {
            override fun serialize(
                src: FriendDeleted?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): FriendDeleted {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }

    enum class InRequestDeleted(
        val value: Int
    ) {
        OK(1);

        class Serializer : JsonSerializer<InRequestDeleted>, JsonDeserializer<InRequestDeleted> {
            override fun serialize(
                src: InRequestDeleted?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): InRequestDeleted {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }

    enum class SuggestionDeleted(
        val value: Int
    ) {
        OK(1);

        class Serializer : JsonSerializer<SuggestionDeleted>, JsonDeserializer<SuggestionDeleted> {
            override fun serialize(
                src: SuggestionDeleted?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): SuggestionDeleted {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }

    enum class OutRequestDeleted(
        val value: Int
    ) {
        OK(1);

        class Serializer : JsonSerializer<OutRequestDeleted>, JsonDeserializer<OutRequestDeleted> {
            override fun serialize(
                src: OutRequestDeleted?,
                typeOfSrc: Type?,
                context: JsonSerializationContext?
            ): JsonElement = src?.let { JsonPrimitive(src.value) } ?: JsonNull.INSTANCE

            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): OutRequestDeleted {
                val value = values().firstOrNull {
                    it.value.toString() == json?.asJsonPrimitive?.asString
                }
                return value ?: throw JsonParseException(json.toString())
            }
        }
    }
}
