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
import com.vk.sdk.api.video.dto.VideoSaveResult
import com.vk.sdk.api.video.responses.VideoSaveResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a server address (required for upload) and video data.
 * @param name Name of the video. 
 * @param description Description of the video. 
 * @param isPrivate '1' � to designate the video as private (send it via a private message), the
 * video will not appear on the user's video list and will not be available by ID for other users, '0'
 * � not to designate the video as private 
 * @param wallpost '1' � to post the saved video on a user's wall, '0' � not to post the saved video
 * on a user's wall 
 * @param link URL for embedding the video from an external website. 
 * @param groupId ID of the community in which the video will be saved. By default, the current
 * user's page. minimum 0
 * @param albumId ID of the album to which the saved video will be added. minimum 0
 * @param privacyView  
 * @param privacyComment  
 * @param noComments  
 * @param repeat '1' � to repeat the playback of the video, '0' � to play the video once, 
 * @param compression  
 */
class VideoSave(
    private val name: String? = null,
    private val description: String? = null,
    private val isPrivate: Boolean? = null,
    private val wallpost: Boolean? = null,
    private val link: String? = null,
    private val groupId: Int? = null,
    private val albumId: Int? = null,
    private val privacyView: List<String>? = null,
    private val privacyComment: List<String>? = null,
    private val noComments: Boolean? = null,
    private val repeat: Boolean? = null,
    private val compression: Boolean? = null
) : VKRequest<VideoSaveResult>("video.save") {
    init {
        name?.let { value ->
            addParam("name", value)
        }
        description?.let { value ->
            addParam("description", value)
        }
        isPrivate?.let { value ->
            addParam("is_private", if (value) 1 else 0)
        }
        wallpost?.let { value ->
            addParam("wallpost", if (value) 1 else 0)
        }
        link?.let { value ->
            addParam("link", value)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        albumId?.let { value ->
            addParam("album_id", value)
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
        compression?.let { value ->
            addParam("compression", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): VideoSaveResult = GsonHolder.gson.fromJson(r.toString(),
            VideoSaveResponse::class.java).response
}
