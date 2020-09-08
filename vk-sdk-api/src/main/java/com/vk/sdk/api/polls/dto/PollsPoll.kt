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
package com.vk.sdk.api.polls.dto

import com.google.gson.annotations.SerializedName
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param anonymous Information whether the field is anonymous
 * @param multiple Information whether the poll with multiple choices
 * @param endDate no description
 * @param closed no description
 * @param isBoard no description
 * @param canEdit no description
 * @param canVote no description
 * @param canReport no description
 * @param canShare no description
 * @param answers no description
 * @param created Date when poll has been created in Unixtime
 * @param id Poll ID
 * @param ownerId Poll owner's ID
 * @param question Poll question
 * @param votes Votes number
 * @param disableUnvote no description
 * @param friends no description
 * @param answerId Current user's answer ID
 * @param answerIds Current user's answer IDs
 * @param photo no description
 * @param authorId Poll author's ID
 * @param background no description
 */
data class PollsPoll(
    @SerializedName(value="anonymous")
    val anonymous: Boolean,
    @SerializedName(value="multiple")
    val multiple: Boolean,
    @SerializedName(value="end_date")
    val endDate: Int,
    @SerializedName(value="closed")
    val closed: Boolean,
    @SerializedName(value="is_board")
    val isBoard: Boolean,
    @SerializedName(value="can_edit")
    val canEdit: Boolean,
    @SerializedName(value="can_vote")
    val canVote: Boolean,
    @SerializedName(value="can_report")
    val canReport: Boolean,
    @SerializedName(value="can_share")
    val canShare: Boolean,
    @SerializedName(value="answers")
    val answers: List<PollsAnswer>,
    @SerializedName(value="created")
    val created: Int,
    @SerializedName(value="id")
    val id: Int,
    @SerializedName(value="owner_id")
    val ownerId: Int,
    @SerializedName(value="question")
    val question: String,
    @SerializedName(value="votes")
    val votes: Int,
    @SerializedName(value="disable_unvote")
    val disableUnvote: Boolean,
    @SerializedName(value="friends")
    val friends: List<PollsFriend>? = null,
    @SerializedName(value="answer_id")
    val answerId: Int? = null,
    @SerializedName(value="answer_ids")
    val answerIds: List<Int>? = null,
    @SerializedName(value="photo")
    val photo: PollsBackground? = null,
    @SerializedName(value="author_id")
    val authorId: Int? = null,
    @SerializedName(value="background")
    val background: PollsBackground? = null
)
