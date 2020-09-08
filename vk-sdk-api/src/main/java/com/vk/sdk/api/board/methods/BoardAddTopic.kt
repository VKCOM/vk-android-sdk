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
package com.vk.sdk.api.board.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.board.responses.BoardAddTopicResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Creates a new topic on a community's discussion board.
 * @param groupId ID of the community that owns the discussion board. minimum 0
 * @param title Topic title. 
 * @param text Text of the topic. 
 * @param fromGroup For a community: '1' � to post the topic as by the community, '0' � to post the
 * topic as by the user (default) 
 * @param attachments List of media objects attached to the topic, in the following format:
 * "<owner_id>_<media_id>,<owner_id>_<media_id>", '' � Type of media object: 'photo' � photo, 'video' �
 * video, 'audio' � audio, 'doc' � document, '<owner_id>' � ID of the media owner. '<media_id>' � Media
 * ID. Example: "photo100172_166443618,photo66748_265827614", , "NOTE: If you try to attach more than
 * one reference, an error will be thrown.", 
 */
class BoardAddTopic(
    private val groupId: Int,
    private val title: String,
    private val text: String? = null,
    private val fromGroup: Boolean? = null,
    private val attachments: List<String>? = null
) : VKRequest<Int>("board.addTopic") {
    init {
        addParam("group_id", groupId)
        addParam("title", title)
        text?.let { value ->
            addParam("text", value)
        }
        fromGroup?.let { value ->
            addParam("from_group", if (value) 1 else 0)
        }
        attachments?.let { value ->
            addParam("attachments", value)
        }
    }

    override fun parse(r: JSONObject): Int = GsonHolder.gson.fromJson(r.toString(),
            BoardAddTopicResponse::class.java).response
}
