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
package com.vk.sdk.api.ads.dto

import com.google.gson.annotations.SerializedName
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id - Group ID
 * @param name - Group name
 * @param isAudience - Is audience
 * @param isShared - Is shared
 * @param fileSource - File source
 * @param apiSource - API source
 * @param lookalikeSource - File source
 * @param audienceCount - Audience
 * @param domain - Site domain
 * @param lifetime - Number of days for user to be in group
 * @param pixel - Pixel code
 * @param targetPixelId - Target Pixel id
 * @param targetPixelRules - Target Pixel rules
 * @param lastUpdated - Last updated
 */
data class AdsTargetGroupDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("is_audience")
    val isAudience: Boolean? = null,
    @SerializedName("is_shared")
    val isShared: Boolean? = null,
    @SerializedName("file_source")
    val fileSource: Boolean? = null,
    @SerializedName("api_source")
    val apiSource: Boolean? = null,
    @SerializedName("lookalike_source")
    val lookalikeSource: Boolean? = null,
    @SerializedName("audience_count")
    val audienceCount: Int? = null,
    @SerializedName("domain")
    val domain: String? = null,
    @SerializedName("lifetime")
    val lifetime: Int? = null,
    @SerializedName("pixel")
    val pixel: String? = null,
    @SerializedName("target_pixel_id")
    val targetPixelId: Int? = null,
    @SerializedName("target_pixel_rules")
    val targetPixelRules: List<AdsTargetGroupTargetPixelRuleDto>? = null,
    @SerializedName("last_updated")
    val lastUpdated: Int? = null
)
