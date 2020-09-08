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
package com.vk.sdk.api.ads.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.ads.dto.AdsUpdateOfficeUsersResult
import com.vk.sdk.api.ads.dto.AdsUserSpecification
import com.vk.sdk.api.ads.responses.AdsUpdateOfficeUsersResponse
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Adds managers and/or supervisors to advertising account.
 * @param accountId Advertising account ID. minimum 0
 * @param data Serialized JSON array of objects that describe added managers. Description of
 * 'user_specification' objects see below. 
 */
class AdsUpdateOfficeUsers(
    private val accountId: Int,
    private val data: List<AdsUserSpecification>
) : VKRequest<List<AdsUpdateOfficeUsersResult>>("ads.updateOfficeUsers") {
    init {
        addParam("account_id", accountId)
        addParam("data", GsonHolder.gson.toJson(data))
    }

    override fun parse(r: JSONObject): List<AdsUpdateOfficeUsersResult> =
            GsonHolder.gson.fromJson(r.toString(),
            AdsUpdateOfficeUsersResponse::class.java).response
}
