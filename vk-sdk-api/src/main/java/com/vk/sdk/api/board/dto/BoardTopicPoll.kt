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
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.polls.dto.PollsAnswer
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param answerId Current user's answer ID
 * @param answers no description
 * @param created Date when poll has been created in Unixtime
 * @param ownerId Poll owner's ID
 * @param pollId Poll ID
 * @param question Poll question
 * @param votes Votes number
 * @param isClosed Information whether the poll is closed
 */
data class BoardTopicPoll(
    @SerializedName(value="answer_id")
    val answerId: Int,
    @SerializedName(value="answers")
    val answers: List<PollsAnswer>,
    @SerializedName(value="created")
    val created: Int,
    @SerializedName(value="owner_id")
    val ownerId: Int,
    @SerializedName(value="poll_id")
    val pollId: Int,
    @SerializedName(value="question")
    val question: String,
    @SerializedName(value="votes")
    val votes: String,
    @SerializedName(value="is_closed")
    val isClosed: BaseBoolInt? = null
)
