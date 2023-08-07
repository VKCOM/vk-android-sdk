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
package com.vk.sdk.api.asr

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.asr.dto.AsrProcessModelDto
import com.vk.sdk.api.asr.dto.AsrProcessResponseDto
import com.vk.sdk.api.asr.dto.AsrTaskDto
import com.vk.sdk.api.base.dto.BaseUploadServerDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.String

class AsrService {
    /**
     * Returns status of the task with provided `task_id`
     *
     * @param taskId - ID of ASR task in UUID format.
     * @return [VKRequest] with [AsrTaskDto]
     */
    fun asrCheckStatus(taskId: String): VKRequest<AsrTaskDto> = NewApiRequest("asr.checkStatus") {
        GsonHolder.gson.parse<AsrTaskDto>(it)
    }
    .apply {
        addParam("task_id", taskId)
    }

    /**
     * Returns the server address to [vk.com/dev/upload_files_2|upload audio files].
     *
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun asrGetUploadUrl(): VKRequest<BaseUploadServerDto> = NewApiRequest("asr.getUploadUrl") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }

    /**
     * Starts ASR task on [vk.com/dev/upload_files_2|uploaded audio file].
     *
     * @param audio - This parameter is a JSON response returned from
     * [vk.com/dev/upload_files_2|file uploading server].
     * @param model - Which model to use for recognition. `neutral` -- general purpose (interviews,
     * TV shows, etc.), `spontaneous` -- for NSFW audios (slang, profanity, etc.)
     * @return [VKRequest] with [AsrProcessResponseDto]
     */
    fun asrProcess(audio: String, model: AsrProcessModelDto): VKRequest<AsrProcessResponseDto> =
            NewApiRequest("asr.process") {
        GsonHolder.gson.parse<AsrProcessResponseDto>(it)
    }
    .apply {
        addParam("audio", audio)
        addParam("model", model.value)
    }
}
