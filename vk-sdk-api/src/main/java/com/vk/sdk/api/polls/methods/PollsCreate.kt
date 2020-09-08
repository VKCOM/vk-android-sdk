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
import com.vk.sdk.api.polls.dto.PollsCreateBackgroundId
import com.vk.sdk.api.polls.dto.PollsPoll
import com.vk.sdk.api.polls.responses.PollsCreateResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Creates polls that can be attached to the users' or communities' posts.
 * @param question question text 
 * @param isAnonymous '1' � anonymous poll, participants list is hidden,, '0' � public poll,
 * participants list is available,, Default value is '0'. 
 * @param isMultiple  
 * @param endDate  minimum 1550700000
 * @param ownerId If a poll will be added to a communty it is required to send a negative group
 * identifier. Current user by default. 
 * @param addAnswers available answers list, for example: " ["yes","no","maybe"]", There can be from
 * 1 to 10 answers. 
 * @param photoId  minimum 0
 * @param backgroundId  
 * @param disableUnvote  
 */
class PollsCreate(
    private val question: String? = null,
    private val isAnonymous: Boolean? = null,
    private val isMultiple: Boolean? = null,
    private val endDate: Int? = null,
    private val ownerId: Int? = null,
    private val addAnswers: String? = null,
    private val photoId: Int? = null,
    private val backgroundId: PollsCreateBackgroundId? = null,
    private val disableUnvote: Boolean? = null
) : VKRequest<PollsPoll>("polls.create") {
    init {
        question?.let { value ->
            addParam("question", value)
        }
        isAnonymous?.let { value ->
            addParam("is_anonymous", if (value) 1 else 0)
        }
        isMultiple?.let { value ->
            addParam("is_multiple", if (value) 1 else 0)
        }
        endDate?.let { value ->
            addParam("end_date", value)
        }
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        addAnswers?.let { value ->
            addParam("add_answers", value)
        }
        photoId?.let { value ->
            addParam("photo_id", value)
        }
        backgroundId?.let { value ->
            addParam("background_id", value.value)
        }
        disableUnvote?.let { value ->
            addParam("disable_unvote", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): PollsPoll = GsonHolder.gson.fromJson(r.toString(),
            PollsCreateResponse::class.java).response
}
