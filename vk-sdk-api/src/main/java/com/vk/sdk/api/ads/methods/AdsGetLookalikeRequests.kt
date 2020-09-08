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
import com.vk.sdk.api.ads.dto.AdsGetLookalikeRequestsResponseDto
import com.vk.sdk.api.ads.responses.AdsGetLookalikeRequestsResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * @param accountId  
 * @param clientId  
 * @param requestsIds  
 * @param offset  default 0 minimum 0
 * @param limit  default 10 minimum 0 maximum 200
 * @param sortBy  default "id"
 */
class AdsGetLookalikeRequests(
    private val accountId: Int,
    private val clientId: Int? = null,
    private val requestsIds: String? = null,
    private val offset: Int? = null,
    private val limit: Int? = null,
    private val sortBy: String? = null
) : VKRequest<AdsGetLookalikeRequestsResponseDto>("ads.getLookalikeRequests") {
    init {
        addParam("account_id", accountId)
        clientId?.let { value ->
            addParam("client_id", value)
        }
        requestsIds?.let { value ->
            addParam("requests_ids", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        limit?.let { value ->
            addParam("limit", value)
        }
        sortBy?.let { value ->
            addParam("sort_by", value)
        }
    }

    override fun parse(r: JSONObject): AdsGetLookalikeRequestsResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            AdsGetLookalikeRequestsResponse::class.java).response
}
