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
package com.vk.sdk.api.market.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.market.responses.MarketCreateCommentResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Creates a new comment for an item.
 * @param ownerId ID of an item owner community. 
 * @param itemId Item ID. minimum 0
 * @param message Comment text (required if 'attachments' parameter is not specified) 
 * @param attachments Comma-separated list of objects attached to a comment. The field is submitted
 * the following way: , "'<owner_id>_<media_id>,<owner_id>_<media_id>'", , '' - media attachment type:
 * "'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document", , '<owner_id>' - media owner
 * id, '<media_id>' - media attachment id, , For example: "photo100172_166443618,photo66748_265827614",
 * 
 * @param fromGroup '1' - comment will be published on behalf of a community, '0' - on behalf of a
 * user (by default). 
 * @param replyToComment ID of a comment to reply with current comment to. minimum 0
 * @param stickerId Sticker ID. minimum 0
 * @param guid Random value to avoid resending one comment. 
 */
class MarketCreateComment(
    private val ownerId: Int,
    private val itemId: Int,
    private val message: String? = null,
    private val attachments: List<String>? = null,
    private val fromGroup: Boolean? = null,
    private val replyToComment: Int? = null,
    private val stickerId: Int? = null,
    private val guid: String? = null
) : VKRequest<Int>("market.createComment") {
    init {
        addParam("owner_id", ownerId)
        addParam("item_id", itemId)
        message?.let { value ->
            addParam("message", value)
        }
        attachments?.let { value ->
            addParam("attachments", value)
        }
        fromGroup?.let { value ->
            addParam("from_group", if (value) 1 else 0)
        }
        replyToComment?.let { value ->
            addParam("reply_to_comment", value)
        }
        stickerId?.let { value ->
            addParam("sticker_id", value)
        }
        guid?.let { value ->
            addParam("guid", value)
        }
    }

    override fun parse(r: JSONObject): Int = GsonHolder.gson.fromJson(r.toString(),
            MarketCreateCommentResponse::class.java).response
}
