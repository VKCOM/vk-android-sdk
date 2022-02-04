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
package com.vk.sdk.api.classifieds.dto

import com.google.gson.annotations.SerializedName
import kotlin.String

/**
 * @param type - Action button type
 * @param url - Action url
 */
data class ClassifiedsYoulaItemActionButton(
    @SerializedName("type")
    val type: ClassifiedsYoulaItemActionButton.Type,
    @SerializedName("url")
    val url: String? = null
) {
    enum class Type(
        val value: String
    ) {
        @SerializedName("menu_edit")
        MENU_EDIT("menu_edit"),

        @SerializedName("menu_support")
        MENU_SUPPORT("menu_support"),

        @SerializedName("menu_delete")
        MENU_DELETE("menu_delete"),

        @SerializedName("menu_share")
        MENU_SHARE("menu_share"),

        @SerializedName("btn_main")
        BTN_MAIN("btn_main"),

        @SerializedName("btn_create")
        BTN_CREATE("btn_create"),

        @SerializedName("btn_delete")
        BTN_DELETE("btn_delete"),

        @SerializedName("btn_support")
        BTN_SUPPORT("btn_support"),

        @SerializedName("btn_edit")
        BTN_EDIT("btn_edit"),

        @SerializedName("btn_republish")
        BTN_REPUBLISH("btn_republish"),

        @SerializedName("btn_promotion")
        BTN_PROMOTION("btn_promotion"),

        @SerializedName("btn_crossposting")
        BTN_CROSSPOSTING("btn_crossposting"),

        @SerializedName("btn_stop_publish")
        BTN_STOP_PUBLISH("btn_stop_publish");
    }
}
