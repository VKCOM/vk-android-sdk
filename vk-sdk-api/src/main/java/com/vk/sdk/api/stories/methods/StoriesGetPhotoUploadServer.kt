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
package com.vk.sdk.api.stories.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.stories.dto.StoriesGetPhotoUploadServerResponseDto
import com.vk.sdk.api.stories.responses.StoriesGetPhotoUploadServerResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns URL for uploading a story with photo.
 * @param addToNews 1 � to add the story to friend's feed. 
 * @param userIds List of users IDs who can see the story. 
 * @param replyToStory ID of the story to reply with the current. 
 * @param linkText Link text (for community's stories only). 
 * @param linkUrl Link URL. Internal links on https://vk.com only. maxLength 2048
 * @param groupId ID of the community to upload the story (should be verified or with the "fire"
 * icon). minimum 0
 * @param clickableStickers  
 */
class StoriesGetPhotoUploadServer(
    private val addToNews: Boolean? = null,
    private val userIds: List<Int>? = null,
    private val replyToStory: String? = null,
    private val linkText: String? = null,
    private val linkUrl: String? = null,
    private val groupId: Int? = null,
    private val clickableStickers: String? = null
) : VKRequest<StoriesGetPhotoUploadServerResponseDto>("stories.getPhotoUploadServer") {
    init {
        addToNews?.let { value ->
            addParam("add_to_news", if (value) 1 else 0)
        }
        userIds?.let { value ->
            addParam("user_ids", value)
        }
        replyToStory?.let { value ->
            addParam("reply_to_story", value)
        }
        linkText?.let { value ->
            addParam("link_text", value)
        }
        linkUrl?.let { value ->
            addParam("link_url", value)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        clickableStickers?.let { value ->
            addParam("clickable_stickers", value)
        }
    }

    override fun parse(r: JSONObject): StoriesGetPhotoUploadServerResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            StoriesGetPhotoUploadServerResponse::class.java).response
}
