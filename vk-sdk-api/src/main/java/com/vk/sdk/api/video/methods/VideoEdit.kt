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
package com.vk.sdk.api.video.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Edits information about a video on a user or community page.
 * @param videoId Video ID. 
 * @param ownerId ID of the user or community that owns the video. 
 * @param name New video title. 
 * @param desc New video description. 
 * @param privacyView Privacy settings in a [vk.com/dev/privacy_setting|special format]. Privacy
 * setting is available for videos uploaded to own profile by user. 
 * @param privacyComment Privacy settings for comments in a [vk.com/dev/privacy_setting|special
 * format]. 
 * @param noComments Disable comments for the group video. 
 * @param repeat '1' � to repeat the playback of the video, '0' � to play the video once, 
 */
class VideoEdit(
    private val videoId: Int,
    private val ownerId: Int? = null,
    private val name: String? = null,
    private val desc: String? = null,
    private val privacyView: List<String>? = null,
    private val privacyComment: List<String>? = null,
    private val noComments: Boolean? = null,
    private val repeat: Boolean? = null
) : VKRequest<BaseOkResponseDto>("video.edit") {
    init {
        addParam("video_id", videoId)
        ownerId?.let { value ->
            addParam("owner_id", value)
        }
        name?.let { value ->
            addParam("name", value)
        }
        desc?.let { value ->
            addParam("desc", value)
        }
        privacyView?.let { value ->
            addParam("privacy_view", value)
        }
        privacyComment?.let { value ->
            addParam("privacy_comment", value)
        }
        noComments?.let { value ->
            addParam("no_comments", if (value) 1 else 0)
        }
        repeat?.let { value ->
            addParam("repeat", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
