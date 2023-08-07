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
package com.vk.sdk.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.vk.dto.common.id.UserId
import com.vk.dto.common.id.UserId.GsonSerializer
import com.vk.sdk.api.friends.dto.FriendsRecDescriptionGenericDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedCommentsItemDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedMediaDiscoverActionDto
import com.vk.sdk.api.newsfeed.dto.NewsfeedNewsfeedItemDto
import com.vk.sdk.api.users.dto.UsersSubscriptionsItemDto
import com.vk.sdk.api.wall.dto.WallWallItemDto
import java.lang.reflect.Type
import kotlin.Boolean

object GsonHolder {
    val gson: Gson by lazy {
        GsonBuilder()
        .registerTypeAdapter(WallWallItemDto::class.java, WallWallItemDto.Deserializer())
        .registerTypeAdapter(UsersSubscriptionsItemDto::class.java,
                UsersSubscriptionsItemDto.Deserializer())
        .registerTypeAdapter(NewsfeedNewsfeedItemDto::class.java,
                NewsfeedNewsfeedItemDto.Deserializer())
        .registerTypeAdapter(FriendsRecDescriptionGenericDto::class.java,
                FriendsRecDescriptionGenericDto.Deserializer())
        .registerTypeAdapter(NewsfeedMediaDiscoverActionDto::class.java,
                NewsfeedMediaDiscoverActionDto.Deserializer())
        .registerTypeAdapter(NewsfeedCommentsItemDto::class.java,
                NewsfeedCommentsItemDto.Deserializer())
        .registerTypeAdapter(UserId::class.java, UserId.GsonSerializer(false))
        .registerTypeAdapter(Boolean::class.javaObjectType,
                BooleanGsonSerializer()).registerTypeAdapter(Boolean::class.javaPrimitiveType,
                BooleanGsonSerializer()).create()
    }


    class BooleanGsonSerializer : JsonDeserializer<Boolean?>, JsonSerializer<Boolean?> {
        override fun serialize(
            src: Boolean?,
            typeOfSrc: Type?,
            context: JsonSerializationContext?
        ): JsonElement {
            val asInt = if (src == true) 1 else 0
            return JsonPrimitive(asInt)
        }

        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): Boolean? {
            if (json !is JsonPrimitive) {
                return null
            }
            val asStr = json.asString
            return asStr == "1" || asStr == "true"
        }
    }
}
