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
package com.vk.sdk.api.secure.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.secure.dto.SecureTokenChecked
import com.vk.sdk.api.secure.responses.SecureCheckTokenResponse
import kotlin.String
import org.json.JSONObject

/**
 * Checks the user authentication in 'IFrame' and 'Flash' apps using the 'access_token' parameter.
 * @param token client 'access_token' 
 * @param ip user 'ip address'. Note that user may access using the 'ipv6' address, in this case it
 * is required to transmit the 'ipv6' address. If not transmitted, the address will not be checked. 
 */
class SecureCheckToken(
    private val token: String? = null,
    private val ip: String? = null
) : VKRequest<SecureTokenChecked>("secure.checkToken") {
    init {
        token?.let { value ->
            addParam("token", value)
        }
        ip?.let { value ->
            addParam("ip", value)
        }
    }

    override fun parse(r: JSONObject): SecureTokenChecked = GsonHolder.gson.fromJson(r.toString(),
            SecureCheckTokenResponse::class.java).response
}
