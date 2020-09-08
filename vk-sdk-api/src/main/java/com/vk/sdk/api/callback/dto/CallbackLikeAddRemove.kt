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
package com.vk.sdk.api.callback.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type
import kotlin.Int
import kotlin.String

/**
 * @param likerId no description
 * @param objectType no description
 * @param objectOwnerId no description
 * @param objectId no description
 * @param postId no description
 * @param threadReplyId no description
 */
data class CallbackLikeAddRemove(
    @SerializedName(value="liker_id")
    val likerId: Int,
    @SerializedName(value="object_type")
    val objectType: ObjectType,
    @SerializedName(value="object_owner_id")
    val objectOwnerId: Int,
    @SerializedName(value="object_id")
    val objectId: Int,
    @SerializedName(value="post_id")
    val postId: Int,
    @SerializedName(value="thread_reply_id")
    val threadReplyId: Int? = null
) {
    enum class ObjectType(
        val value: String
    ) {
        VIDEO("video"),

        PHOTO("photo"),

        POST("post"),

        COMMENT("comment"),

        NOTE("note"),

        TOPIC_COMMENT("topic_comment"),

        PHOTO_COMMENT("photo_comment"),

        VIDEO_COMMENT("video_comment"),

        MARKET("market"),

        MARKET_COMMENT("market_comment");

        class Serializer : JsonDeserializer<ObjectType> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: Type?,
                context: JsonDeserializationContext?
            ): ObjectType = values().first { it.value.toString() ==
                    json!!.asJsonPrimitive.toString() }
        }
    }
}
