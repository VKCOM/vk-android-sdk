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
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.streaming.dto.StreamingGetServerUrlResponse
import com.vk.sdk.api.streaming.dto.StreamingGetStatsInterval
import com.vk.sdk.api.streaming.dto.StreamingGetStatsType
import com.vk.sdk.api.streaming.dto.StreamingSetSettingsMonthlyTier
import kotlin.Int
import kotlin.String
import kotlin.Unit

class StreamingService {
    /**
     * Allows to receive data for the connection to Streaming API.
     *
     * @return [VKRequest] with [StreamingGetServerUrlResponse]
     */
    fun streamingGetServerUrl(): VKRequest<StreamingGetServerUrlResponse> =
            NewApiRequest("streaming.getServerUrl") {
        GsonHolder.gson.fromJson(it, StreamingGetServerUrlResponse::class.java)
    }

    /**
     * @return [VKRequest] with [Unit]
     */
    fun streamingGetSettings(): VKRequest<Unit> = NewApiRequest("streaming.getSettings") {
    }

    /**
     * @param type
     * @param interval
     * @param startTime
     * @param endTime
     * @return [VKRequest] with [Unit]
     */
    fun streamingGetStats(
        type: StreamingGetStatsType? = null,
        interval: StreamingGetStatsInterval? = null,
        startTime: Int? = null,
        endTime: Int? = null
    ): VKRequest<Unit> = NewApiRequest("streaming.getStats") {
    }
    .apply {
        type?.let { addParam("type", it.value) }
        interval?.let { addParam("interval", it.value) }
        startTime?.let { addParam("start_time", it, min = 0) }
        endTime?.let { addParam("end_time", it, min = 0) }
    }

    /**
     * @param word
     * @return [VKRequest] with [Unit]
     */
    fun streamingGetStem(word: String): VKRequest<Unit> = NewApiRequest("streaming.getStem") {
    }
    .apply {
        addParam("word", word)
    }

    /**
     * @param monthlyTier
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun streamingSetSettings(monthlyTier: StreamingSetSettingsMonthlyTier? = null):
            VKRequest<BaseOkResponse> = NewApiRequest("streaming.setSettings") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        monthlyTier?.let { addParam("monthly_tier", it.value) }
    }
}
