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
package com.vk.sdk.api.board.dto

import com.google.gson.annotations.SerializedName
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.polls.dto.PollsAnswer
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param ownerId - Poll owner's ID
 * @param pollId - Poll ID
 * @param created - Date when poll has been created in Unixtime
 * @param question - Poll question
 * @param votes - Votes number
 * @param answerId - Current user's answer ID
 * @param answers
 * @param isClosed - Information whether the poll is closed
 */
data class BoardTopicPoll(
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("poll_id")
    val pollId: Int,
    @SerializedName("created")
    val created: Int,
    @SerializedName("question")
    val question: String,
    @SerializedName("votes")
    val votes: Int,
    @SerializedName("answer_id")
    val answerId: Int,
    @SerializedName("answers")
    val answers: List<PollsAnswer>,
    @SerializedName("is_closed")
    val isClosed: BaseBoolInt? = null
)
