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
package com.vk.sdk.api.wall.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.wall.dto.WallRepostResponseDto
import com.vk.sdk.api.wall.responses.WallRepostResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Reposts (copies) an object to a user wall or community wall.
 * @param objectValue ID of the object to be reposted on the wall. Example: "wall66748_3675" 
 * @param message Comment to be added along with the reposted object. 
 * @param groupId Target community ID when reposting to a community. minimum 0
 * @param markAsAds  default false
 * @param muteNotifications  
 */
class WallRepost(
    private val objectValue: String,
    private val message: String? = null,
    private val groupId: Int? = null,
    private val markAsAds: Boolean? = null,
    private val muteNotifications: Boolean? = null
) : VKRequest<WallRepostResponseDto>("wall.repost") {
    init {
        addParam("object", objectValue)
        message?.let { value ->
            addParam("message", value)
        }
        groupId?.let { value ->
            addParam("group_id", value)
        }
        markAsAds?.let { value ->
            addParam("mark_as_ads", if (value) 1 else 0)
        }
        muteNotifications?.let { value ->
            addParam("mute_notifications", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): WallRepostResponseDto =
            GsonHolder.gson.fromJson(r.toString(), WallRepostResponse::class.java).response
}
