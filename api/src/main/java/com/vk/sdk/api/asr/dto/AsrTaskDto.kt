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
package com.vk.sdk.api.asr.dto

import com.google.gson.annotations.SerializedName
import kotlin.String

/**
 * @param id - Task ID in UUID format.
 * @param status - Status of the task.
 * @param text - Recognised text, if task is `finished`.
 */
data class AsrTaskDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("status")
    val status: AsrTaskDto.StatusDto,
    @SerializedName("text")
    val text: String
) {
    enum class StatusDto(
        val value: String
    ) {
        @SerializedName("processing")
        PROCESSING("processing"),

        @SerializedName("finished")
        FINISHED("finished"),

        @SerializedName("internal_error")
        INTERNAL_ERROR("internal_error"),

        @SerializedName("transcoding_error")
        TRANSCODING_ERROR("transcoding_error"),

        @SerializedName("recognition_error")
        RECOGNITION_ERROR("recognition_error");
    }
}
