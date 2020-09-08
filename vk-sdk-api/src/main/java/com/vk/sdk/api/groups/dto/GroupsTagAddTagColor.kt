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
package com.vk.sdk.api.groups.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import kotlin.String

enum class GroupsTagAddTagColor(
    val value: String
) {
    FORTY_FIVE_4647("454647"),

    FORTY_FIVE_678F("45678f"),

    FOUR_BB34B("4bb34b"),

    FIFTY_ONE_81B8("5181b8"),

    FIFTY_THREE_9B9C("539b9c"),

    FIVE_C9CE6("5c9ce6"),

    SIXTY_THREE_B9BA("63b9ba"),

    SIX_BC76B("6bc76b"),

    SEVENTY_SIX_787A("76787a"),

    SEVENTY_NINE_2EC0("792ec0"),

    SEVEN_A6C4F("7a6c4f"),

    SEVEN_ECECF("7ececf"),

    NINE_E8D6B("9e8d6b"),

    A162DE("a162de"),

    AAAEB3("aaaeb3"),

    BBAA84("bbaa84"),

    E64646("e64646"),

    FF5C5C("ff5c5c"),

    FFA000("ffa000"),

    FFC107("ffc107");

    class Serializer : JsonDeserializer<GroupsTagAddTagColor> {
        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): GroupsTagAddTagColor = values().first { it.value.toString() ==
                json!!.asJsonPrimitive.toString() }
    }
}
