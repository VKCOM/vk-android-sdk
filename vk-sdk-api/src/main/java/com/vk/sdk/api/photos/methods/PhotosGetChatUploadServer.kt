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
package com.vk.sdk.api.photos.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseUploadServer
import com.vk.sdk.api.base.responses.BaseGetUploadServerResponse
import kotlin.Int
import org.json.JSONObject

/**
 * Returns an upload link for chat cover pictures.
 * @param chatId ID of the chat for which you want to upload a cover photo. minimum 0
 * @param cropX  minimum 0
 * @param cropY  minimum 0
 * @param cropWidth Width (in pixels) of the photo after cropping. minimum 200
 */
class PhotosGetChatUploadServer(
    private val chatId: Int,
    private val cropX: Int? = null,
    private val cropY: Int? = null,
    private val cropWidth: Int? = null
) : VKRequest<BaseUploadServer>("photos.getChatUploadServer") {
    init {
        addParam("chat_id", chatId)
        cropX?.let { value ->
            addParam("crop_x", value)
        }
        cropY?.let { value ->
            addParam("crop_y", value)
        }
        cropWidth?.let { value ->
            addParam("crop_width", value)
        }
    }

    override fun parse(r: JSONObject): BaseUploadServer = GsonHolder.gson.fromJson(r.toString(),
            BaseGetUploadServerResponse::class.java).response
}
