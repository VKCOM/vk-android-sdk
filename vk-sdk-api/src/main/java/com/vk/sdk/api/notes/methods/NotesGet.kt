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
package com.vk.sdk.api.notes.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.notes.dto.NotesGetResponseDto
import com.vk.sdk.api.notes.dto.NotesGetSort
import com.vk.sdk.api.notes.responses.NotesGetResponse
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of notes created by a user.
 * @param noteIds Note IDs. 
 * @param userId Note owner ID. minimum 0
 * @param offset  default 0 minimum 0
 * @param count Number of notes to return. default 20 minimum 0 maximum 100
 * @param sort  default 0 minimum 0
 */
class NotesGet(
    private val noteIds: List<Int>? = null,
    private val userId: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val sort: NotesGetSort? = null
) : VKRequest<NotesGetResponseDto>("notes.get") {
    init {
        noteIds?.let { value ->
            addParam("note_ids", value)
        }
        userId?.let { value ->
            addParam("user_id", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        sort?.let { value ->
            addParam("sort", value.value)
        }
    }

    override fun parse(r: JSONObject): NotesGetResponseDto = GsonHolder.gson.fromJson(r.toString(),
            NotesGetResponse::class.java).response
}
