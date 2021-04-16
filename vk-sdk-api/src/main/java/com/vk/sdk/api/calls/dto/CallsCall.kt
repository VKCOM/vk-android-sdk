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
package com.vk.sdk.api.calls.dto

import com.google.gson.annotations.SerializedName
import kotlin.Boolean
import kotlin.Int

/**
 * @param initiatorId - Caller initiator
 * @param receiverId - Caller receiver
 * @param state
 * @param time - Timestamp for call
 * @param duration - Call duration
 * @param video - Was this call initiated as video call
 * @param participants
 */
data class CallsCall(
    @SerializedName("initiator_id")
    val initiatorId: Int,
    @SerializedName("receiver_id")
    val receiverId: Int,
    @SerializedName("state")
    val state: CallsEndState,
    @SerializedName("time")
    val time: Int,
    @SerializedName("duration")
    val duration: Int? = null,
    @SerializedName("video")
    val video: Boolean? = null,
    @SerializedName("participants")
    val participants: CallsParticipants? = null
)
