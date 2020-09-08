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
package com.vk.sdk.api.auth.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.auth.dto.AuthRestoreResponseDto
import com.vk.sdk.api.auth.responses.AuthRestoreResponse
import kotlin.String
import org.json.JSONObject

/**
 * Allows to restore account access using a code received via SMS. " This method is only available
 * for apps with [vk.com/dev/auth_direct|Direct authorization] access. "
 * @param phone User phone number. 
 * @param lastName User last name. 
 */
class AuthRestore(
    private val phone: String,
    private val lastName: String
) : VKRequest<AuthRestoreResponseDto>("auth.restore") {
    init {
        addParam("phone", phone)
        addParam("last_name", lastName)
    }

    override fun parse(r: JSONObject): AuthRestoreResponseDto =
            GsonHolder.gson.fromJson(r.toString(), AuthRestoreResponse::class.java).response
}
