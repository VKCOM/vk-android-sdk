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
import kotlin.Boolean
import kotlin.Int

/**
 * @param disabledForever - Information whether push notifications are disabled forever
 * @param noSound - Information whether the sound is on
 * @param disabledUntil - Time until what notifications are disabled
 * @param disabledMentions - Information whether the mentions are disabled
 * @param disabledMassMentions - Information whether the mass mentions (like '@all', '@online') are
 * disabled
 */
data class MessagesPushSettings(
    @SerializedName("disabled_forever")
    val disabledForever: Boolean,
    @SerializedName("no_sound")
    val noSound: Boolean,
    @SerializedName("disabled_until")
    val disabledUntil: Int? = null,
    @SerializedName("disabled_mentions")
    val disabledMentions: Boolean? = null,
    @SerializedName("disabled_mass_mentions")
    val disabledMassMentions: Boolean? = null
)
