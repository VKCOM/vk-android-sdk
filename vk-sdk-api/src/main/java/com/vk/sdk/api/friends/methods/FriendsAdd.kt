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
package com.vk.sdk.api.friends.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.friends.dto.FriendsAddResponseDto
import com.vk.sdk.api.friends.responses.FriendsAddResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Approves or creates a friend request.
 * @param userId ID of the user whose friend request will be approved or to whom a friend request
 * will be sent. minimum 0
 * @param text Text of the message (up to 500 characters) for the friend request, if any. 
 * @param follow '1' to pass an incoming request to followers list. 
 */
class FriendsAdd(
    private val userId: Int? = null,
    private val text: String? = null,
    private val follow: Boolean? = null
) : VKRequest<FriendsAddResponseDto>("friends.add") {
    init {
        userId?.let { value ->
            addParam("user_id", value)
        }
        text?.let { value ->
            addParam("text", value)
        }
        follow?.let { value ->
            addParam("follow", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): FriendsAddResponseDto =
            GsonHolder.gson.fromJson(r.toString(), FriendsAddResponse::class.java).response
}
