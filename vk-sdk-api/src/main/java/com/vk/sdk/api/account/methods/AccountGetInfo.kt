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
package com.vk.sdk.api.account.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.account.dto.AccountGetInfoFields
import com.vk.sdk.api.account.dto.AccountInfo
import com.vk.sdk.api.account.responses.AccountGetInfoResponse
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns current account info.
 * @param fields Fields to return. Possible values: *'country' � user country,, *'https_required' �
 * is "HTTPS only" option enabled,, *'own_posts_default' � is "Show my posts only" option is enabled,,
 * *'no_wall_replies' � are wall replies disabled or not,, *'intro' � is intro passed by user or not,,
 * *'lang' � user language. By default: all. 
 */
class AccountGetInfo(
    private val fields: List<AccountGetInfoFields>? = null
) : VKRequest<AccountInfo>("account.getInfo") {
    init {
        fields?.let { value ->
            addParam("fields", value.map { it.value })
        }
    }

    override fun parse(r: JSONObject): AccountInfo = GsonHolder.gson.fromJson(r.toString(),
            AccountGetInfoResponse::class.java).response
}
