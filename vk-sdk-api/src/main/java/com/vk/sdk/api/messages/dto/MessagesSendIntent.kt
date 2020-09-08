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
package com.vk.sdk.api.messages.dto

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import kotlin.String

enum class MessagesSendIntent(
    val value: String
) {
    ACCOUNT_UPDATE("account_update"),

    BOT_AD_INVITE("bot_ad_invite"),

    BOT_AD_PROMO("bot_ad_promo"),

    CONFIRMED_NOTIFICATION("confirmed_notification"),

    CUSTOMER_SUPPORT("customer_support"),

    DEFAULT("default"),

    GAME_NOTIFICATION("game_notification"),

    MODERATED_NEWSLETTER("moderated_newsletter"),

    NON_PROMO_NEWSLETTER("non_promo_newsletter"),

    PROMO_NEWSLETTER("promo_newsletter"),

    PURCHASE_UPDATE("purchase_update");

    class Serializer : JsonDeserializer<MessagesSendIntent> {
        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): MessagesSendIntent = values().first { it.value.toString() ==
                json!!.asJsonPrimitive.toString() }
    }
}
