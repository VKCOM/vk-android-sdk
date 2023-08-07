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
package com.vk.sdk.api.streaming

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.streaming.dto.StreamingGetServerUrlResponseDto
import com.vk.sdk.api.streaming.dto.StreamingGetSettingsResponseDto
import com.vk.sdk.api.streaming.dto.StreamingGetStatsIntervalDto
import com.vk.sdk.api.streaming.dto.StreamingGetStatsTypeDto
import com.vk.sdk.api.streaming.dto.StreamingGetStemResponseDto
import com.vk.sdk.api.streaming.dto.StreamingSetSettingsMonthlyTierDto
import com.vk.sdk.api.streaming.dto.StreamingStatsDto
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class StreamingService {
    /**
     * Allows to receive data for the connection to Streaming API.
     *
     * @return [VKRequest] with [StreamingGetServerUrlResponseDto]
     */
    fun streamingGetServerUrl(): VKRequest<StreamingGetServerUrlResponseDto> =
            NewApiRequest("streaming.getServerUrl") {
        GsonHolder.gson.parse<StreamingGetServerUrlResponseDto>(it)
    }

    /**
     * @return [VKRequest] with [StreamingGetSettingsResponseDto]
     */
    fun streamingGetSettings(): VKRequest<StreamingGetSettingsResponseDto> =
            NewApiRequest("streaming.getSettings") {
        GsonHolder.gson.parse<StreamingGetSettingsResponseDto>(it)
    }

    /**
     * @param type
     * @param interval
     * @param startTime
     * @param endTime
     * @return [VKRequest] with [Unit]
     */
    fun streamingGetStats(
        type: StreamingGetStatsTypeDto? = null,
        interval: StreamingGetStatsIntervalDto? = null,
        startTime: Long? = null,
        endTime: Long? = null
    ): VKRequest<List<StreamingStatsDto>> = NewApiRequest("streaming.getStats") {
        GsonHolder.gson.parseList<StreamingStatsDto>(it)
    }
    .apply {
        type?.let { addParam("type", it.value) }
        interval?.let { addParam("interval", it.value) }
        startTime?.let { addParam("start_time", it, min = 0) }
        endTime?.let { addParam("end_time", it, min = 0) }
    }

    /**
     * @param word
     * @return [VKRequest] with [StreamingGetStemResponseDto]
     */
    fun streamingGetStem(word: String): VKRequest<StreamingGetStemResponseDto> =
            NewApiRequest("streaming.getStem") {
        GsonHolder.gson.parse<StreamingGetStemResponseDto>(it)
    }
    .apply {
        addParam("word", word)
    }

    /**
     * @param monthlyTier
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun streamingSetSettings(monthlyTier: StreamingSetSettingsMonthlyTierDto? = null):
            VKRequest<BaseOkResponseDto> = NewApiRequest("streaming.setSettings") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        monthlyTier?.let { addParam("monthly_tier", it.value) }
    }

    object StreamingGetStatsRestrictions {
        const val START_TIME_MIN: Long = 0

        const val END_TIME_MIN: Long = 0
    }
}
