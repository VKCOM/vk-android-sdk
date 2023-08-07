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
package com.vk.sdk.api.account.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import kotlin.Int
import kotlin.String

/**
 * @param 2faRequired - Two factor authentication is enabled
 * @param country - Country code
 * @param httpsRequired - Information whether HTTPS-only is enabled
 * @param intro - Information whether user has been processed intro
 * @param lang - Language ID
 * @param noWallReplies - Information whether wall comments should be hidden
 * @param ownPostsDefault - Information whether only owners posts should be shown
 */
data class AccountInfoDto(
    @SerializedName("2fa_required")
    val `2faRequired`: BaseBoolIntDto? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("https_required")
    val httpsRequired: BaseBoolIntDto? = null,
    @SerializedName("intro")
    val intro: BaseBoolIntDto? = null,
    @SerializedName("lang")
    val lang: Int? = null,
    @SerializedName("no_wall_replies")
    val noWallReplies: BaseBoolIntDto? = null,
    @SerializedName("own_posts_default")
    val ownPostsDefault: BaseBoolIntDto? = null
)
