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
package com.vk.sdk.api.polls.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import com.vk.sdk.api.polls.dto.PollsEditBackgroundId
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Edits created polls
 * @param pollId edited poll's id minimum 0
 * @param ownerId poll owner id 
 * @param question new question text 
 * @param addAnswers answers list, for example: , "["yes","no","maybe"]" 
 * @param editAnswers object containing answers that need to be edited,, key � answer id, value �
 * new answer text. Example: {"382967099":"option1", "382967103":"option2"}" 
 * @param deleteAnswers list of answer ids to be deleted. For example: "[382967099, 382967103]" 
 * @param endDate  minimum 0
 * @param photoId  minimum 0
 * @param backgroundId  
 */
class PollsEdit(
    private val pollId: Int,
    private val ownerId: Int? = null,
    private val question: String? = null,
    private val addAnswers: String? = null,
    private val editAnswers: String? = null,
    private val deleteAnswers: String? = null,
    private val endDate: Int? = null,
    private val photoId: Int? = null,
    private val backgroundId: PollsEditBackgroundId? = null
) : VKRequest<BaseOkResponseDto>("polls.edit") {
    init {
        addParam("poll_id", pollId)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        question?.let { value ->
            addParam("question", value)
        }
        addAnswers?.let { value ->
            addParam("add_answers", value)
        }
        editAnswers?.let { value ->
            addParam("edit_answers", value)
        }
        deleteAnswers?.let { value ->
            addParam("delete_answers", value)
        }
        endDate?.let { value ->
            addParam("end_date", value)
        }
        photoId?.let { value ->
            addParam("photo_id", value)
        }
        backgroundId?.let { value ->
            addParam("background_id", value.value)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
