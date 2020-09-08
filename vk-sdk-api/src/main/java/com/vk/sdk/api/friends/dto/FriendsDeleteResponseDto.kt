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

        class Serializer : JsonDeserializer<FriendDeleted> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): FriendDeleted = values().first { it.value.toString() ==
                    json!!.asJsonPrimitive.toString() }
        }
    }

    enum class InRequestDeleted(
        val value: Int
    ) {
        OK(1);

        class Serializer : JsonDeserializer<InRequestDeleted> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): InRequestDeleted = values().first { it.value.toString() ==
                    json!!.asJsonPrimitive.toString() }
        }
    }

    enum class SuggestionDeleted(
        val value: Int
    ) {
        OK(1);

        class Serializer : JsonDeserializer<SuggestionDeleted> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): SuggestionDeleted = values().first { it.value.toString() ==
                    json!!.asJsonPrimitive.toString() }
        }
    }

    enum class OutRequestDeleted(
        val value: Int
    ) {
        OK(1);

        class Serializer : JsonDeserializer<OutRequestDeleted> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): OutRequestDeleted = values().first { it.value.toString() ==
                    json!!.asJsonPrimitive.toString() }
        }
    }
}
