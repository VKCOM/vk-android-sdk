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
import com.vk.dto.common.id.UserId
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param multiple - Information whether the poll with multiple choices
 * @param endDate
 * @param closed
 * @param isBoard
 * @param canEdit
 * @param canVote
 * @param canReport
 * @param canShare
 * @param answers
 * @param created - Date when poll has been created in Unixtime
 * @param id - Poll ID
 * @param ownerId - Poll owner's ID
 * @param question - Poll question
 * @param votes - Votes number
 * @param disableUnvote
 * @param anonymous
 * @param friends
 * @param answerId - Current user's answer ID
 * @param answerIds - Current user's answer IDs
 * @param embedHash
 * @param photo
 * @param authorId - Poll author's ID
 * @param background
 */
data class PollsPoll(
    @SerializedName("multiple")
    val multiple: Boolean,
    @SerializedName("end_date")
    val endDate: Int,
    @SerializedName("closed")
    val closed: Boolean,
    @SerializedName("is_board")
    val isBoard: Boolean,
    @SerializedName("can_edit")
    val canEdit: Boolean,
    @SerializedName("can_vote")
    val canVote: Boolean,
    @SerializedName("can_report")
    val canReport: Boolean,
    @SerializedName("can_share")
    val canShare: Boolean,
    @SerializedName("answers")
    val answers: List<PollsAnswer>,
    @SerializedName("created")
    val created: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner_id")
    val ownerId: UserId,
    @SerializedName("question")
    val question: String,
    @SerializedName("votes")
    val votes: Int,
    @SerializedName("disable_unvote")
    val disableUnvote: Boolean,
    @SerializedName("anonymous")
    val anonymous: Boolean? = null,
    @SerializedName("friends")
    val friends: List<PollsFriend>? = null,
    @SerializedName("answer_id")
    val answerId: Int? = null,
    @SerializedName("answer_ids")
    val answerIds: List<Int>? = null,
    @SerializedName("embed_hash")
    val embedHash: String? = null,
    @SerializedName("photo")
    val photo: PollsBackground? = null,
    @SerializedName("author_id")
    val authorId: Int? = null,
    @SerializedName("background")
    val background: PollsBackground? = null
)
