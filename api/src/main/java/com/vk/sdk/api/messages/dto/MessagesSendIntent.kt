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

import com.google.gson.annotations.SerializedName
import kotlin.String

enum class MessagesSendIntent(
    val value: String
) {
    @SerializedName("account_update")
    ACCOUNT_UPDATE("account_update"),

    @SerializedName("bot_ad_invite")
    BOT_AD_INVITE("bot_ad_invite"),

    @SerializedName("bot_ad_promo")
    BOT_AD_PROMO("bot_ad_promo"),

    @SerializedName("confirmed_notification")
    CONFIRMED_NOTIFICATION("confirmed_notification"),

    @SerializedName("customer_support")
    CUSTOMER_SUPPORT("customer_support"),

    @SerializedName("default")
    DEFAULT("default"),

    @SerializedName("game_notification")
    GAME_NOTIFICATION("game_notification"),

    @SerializedName("moderated_newsletter")
    MODERATED_NEWSLETTER("moderated_newsletter"),

    @SerializedName("non_promo_newsletter")
    NON_PROMO_NEWSLETTER("non_promo_newsletter"),

    @SerializedName("promo_newsletter")
    PROMO_NEWSLETTER("promo_newsletter"),

    @SerializedName("purchase_update")
    PURCHASE_UPDATE("purchase_update");
}
