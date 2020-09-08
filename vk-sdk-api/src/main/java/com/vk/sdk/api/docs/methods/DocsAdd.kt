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
package com.vk.sdk.api.docs.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.docs.dto.DocsAddResponseDto
import com.vk.sdk.api.docs.responses.DocsAddResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Copies a document to a user's or community's document list.
 * @param ownerId ID of the user or community that owns the document. Use a negative value to
 * designate a community ID. 
 * @param docId Document ID. minimum 0
 * @param accessKey Access key. This parameter is required if 'access_key' was returned with the
 * document's data. 
 */
class DocsAdd(
    private val ownerId: Int,
    private val docId: Int,
    private val accessKey: String? = null
) : VKRequest<DocsAddResponseDto>("docs.add") {
    init {
        addParam("owner_id", ownerId)
        addParam("doc_id", docId)
        accessKey?.let { value ->
            addParam("access_key", value)
        }
    }

    override fun parse(r: JSONObject): DocsAddResponseDto = GsonHolder.gson.fromJson(r.toString(),
            DocsAddResponse::class.java).response
}
