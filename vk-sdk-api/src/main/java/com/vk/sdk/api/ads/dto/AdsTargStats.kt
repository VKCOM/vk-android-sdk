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
import kotlin.Float
import kotlin.Int

/**
 * @param audienceCount - Audience
 * @param recommendedCpc - Recommended CPC value for 50 percent  reach (old format)
 * @param recommendedCpm - Recommended CPM value for 50 percent  reach (old format)
 * @param recommendedCpc50 - Recommended CPC value for 50 percent  reach
 * @param recommendedCpm50 - Recommended CPM value for 50 percent  reach
 * @param recommendedCpc70 - Recommended CPC value for 70 percent  reach
 * @param recommendedCpm70 - Recommended CPM value for 70 percent  reach
 * @param recommendedCpc90 - Recommended CPC value for 90 percent  reach
 * @param recommendedCpm90 - Recommended CPM value for 90 percent  reach
 */
data class AdsTargStats(
    @SerializedName("audience_count")
    val audienceCount: Int,
    @SerializedName("recommended_cpc")
    val recommendedCpc: Float? = null,
    @SerializedName("recommended_cpm")
    val recommendedCpm: Float? = null,
    @SerializedName("recommended_cpc_50")
    val recommendedCpc50: Float? = null,
    @SerializedName("recommended_cpm_50")
    val recommendedCpm50: Float? = null,
    @SerializedName("recommended_cpc_70")
    val recommendedCpc70: Float? = null,
    @SerializedName("recommended_cpm_70")
    val recommendedCpm70: Float? = null,
    @SerializedName("recommended_cpc_90")
    val recommendedCpc90: Float? = null,
    @SerializedName("recommended_cpm_90")
    val recommendedCpm90: Float? = null
)
