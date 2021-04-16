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

import com.google.gson.annotations.SerializedName
import kotlin.Int
import kotlin.String

/**
 * @param id
 * @param name
 * @param color
 * @param uses
 */
data class GroupsGroupTag(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("color")
    val color: GroupsGroupTag.Color,
    @SerializedName("uses")
    val uses: Int? = null
) {
    enum class Color(
        val value: String
    ) {
        @SerializedName("454647")
        FORTY_FIVE_4647("454647"),

        @SerializedName("45678f")
        FORTY_FIVE_678F("45678f"),

        @SerializedName("4bb34b")
        FOUR_BB34B("4bb34b"),

        @SerializedName("5181b8")
        FIFTY_ONE_81B8("5181b8"),

        @SerializedName("539b9c")
        FIFTY_THREE_9B9C("539b9c"),

        @SerializedName("5c9ce6")
        FIVE_C9CE6("5c9ce6"),

        @SerializedName("63b9ba")
        SIXTY_THREE_B9BA("63b9ba"),

        @SerializedName("6bc76b")
        SIX_BC76B("6bc76b"),

        @SerializedName("76787a")
        SEVENTY_SIX_787A("76787a"),

        @SerializedName("792ec0")
        SEVENTY_NINE_2EC0("792ec0"),

        @SerializedName("7a6c4f")
        SEVEN_A6C4F("7a6c4f"),

        @SerializedName("7ececf")
        SEVEN_ECECF("7ececf"),

        @SerializedName("9e8d6b")
        NINE_E8D6B("9e8d6b"),

        @SerializedName("a162de")
        A162DE("a162de"),

        @SerializedName("aaaeb3")
        AAAEB3("aaaeb3"),

        @SerializedName("bbaa84")
        BBAA84("bbaa84"),

        @SerializedName("e64646")
        E64646("e64646"),

        @SerializedName("ff5c5c")
        FF5C5C("ff5c5c"),

        @SerializedName("ffa000")
        FFA000("ffa000"),

        @SerializedName("ffc107")
        FFC107("ffc107");
    }
}
