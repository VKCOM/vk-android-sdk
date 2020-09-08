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
package com.vk.sdk.api.users.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import kotlin.Int
import kotlin.String

/**
 * @param type Relative type
 * @param birthDate Date of child birthday (format dd.mm.yyyy)
 * @param id Relative ID
 * @param name Name of relative
 */
data class UsersRelative(
    @SerializedName(value="type")
    val type: Type,
    @SerializedName(value="birth_date")
    val birthDate: String? = null,
    @SerializedName(value="id")
    val id: Int? = null,
    @SerializedName(value="name")
    val name: String? = null
) {
    enum class Type(
        val value: String
    ) {
        PARENT("parent"),

        CHILD("child"),

        GRANDPARENT("grandparent"),

        GRANDCHILD("grandchild"),

        SIBLING("sibling");

        class Serializer : JsonDeserializer<Type> {
            override fun deserialize(
                json: JsonElement?,
                typeOfT: java.lang.reflect.Type?,
                context: JsonDeserializationContext?
            ): Type = values().first { it.value.toString() == json!!.asJsonPrimitive.toString() }
        }
    }
}
