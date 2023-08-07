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
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param version - Version
 * @param adNetworkId - ID of ad network received by Apple
 * @param campaignId - Campaign ID
 * @param appStoreId - ID of application in store
 * @param sourceAppStoreId - ID of current application in store
 * @param timestamp - Timestamp of request
 * @param nonce - Random UUID
 * @param sign - Sign of request
 * @param fidelities
 */
data class AdsSkadDto(
    @SerializedName("version")
    val version: String,
    @SerializedName("adNetworkId")
    val adNetworkId: String,
    @SerializedName("campaignId")
    val campaignId: Int,
    @SerializedName("appStoreId")
    val appStoreId: Int,
    @SerializedName("sourceAppStoreId")
    val sourceAppStoreId: Int,
    @SerializedName("timestamp")
    val timestamp: Int? = null,
    @SerializedName("nonce")
    val nonce: String? = null,
    @SerializedName("sign")
    val sign: String? = null,
    @SerializedName("fidelities")
    val fidelities: List<AdsSkadFidelityDto>? = null
)
