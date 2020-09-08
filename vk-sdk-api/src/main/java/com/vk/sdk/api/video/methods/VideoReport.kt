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
package com.vk.sdk.api.video.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import com.vk.sdk.api.video.dto.VideoReportReason
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Reports (submits a complaint about) a video.
 * @param ownerId ID of the user or community that owns the video. 
 * @param videoId Video ID. minimum 0
 * @param reason Reason for the complaint: '0' � spam, '1' � child pornography, '2' � extremism, '3'
 * � violence, '4' � drug propaganda, '5' � adult material, '6' � insult, abuse minimum 0
 * @param comment Comment describing the complaint. 
 * @param searchQuery (If the video was found in search results.) Search query string. 
 */
class VideoReport(
    private val ownerId: Int,
    private val videoId: Int,
    private val reason: VideoReportReason? = null,
    private val comment: String? = null,
    private val searchQuery: String? = null
) : VKRequest<BaseOkResponseDto>("video.report") {
    init {
        addParam("owner_id", ownerId)
        addParam("video_id", videoId)
        reason?.let { value ->
            addParam("reason", value.value)
        }
        comment?.let { value ->
            addParam("comment", value)
        }
        searchQuery?.let { value ->
            addParam("search_query", value)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
