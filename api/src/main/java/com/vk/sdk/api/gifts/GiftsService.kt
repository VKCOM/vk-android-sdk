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
package com.vk.sdk.api.gifts

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.gifts.dto.GiftsGetResponse
import kotlin.Int

class GiftsService {
    /**
     * Returns a list of user gifts.
     *
     * @param userId - User ID.
     * @param count - Number of gifts to return.
     * @param offset - Offset needed to return a specific subset of results.
     * @return [VKRequest] with [GiftsGetResponse]
     */
    fun giftsGet(
        userId: UserId? = null,
        count: Int? = null,
        offset: Int? = null
    ): VKRequest<GiftsGetResponse> = NewApiRequest("gifts.get") {
        GsonHolder.gson.fromJson(it, GiftsGetResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
    }
}
