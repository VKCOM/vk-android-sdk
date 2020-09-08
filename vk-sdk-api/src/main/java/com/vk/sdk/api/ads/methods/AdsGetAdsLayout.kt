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
import com.vk.sdk.api.ads.dto.AdsAdLayout
import com.vk.sdk.api.ads.responses.AdsGetAdsLayoutResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns descriptions of ad layouts.
 * @param accountId Advertising account ID. 
 * @param adIds Filter by ads. Serialized JSON array with ad IDs. If the parameter is null, all ads
 * will be shown. 
 * @param campaignIds Filter by advertising campaigns. Serialized JSON array with campaign IDs. If
 * the parameter is null, ads of all campaigns will be shown. 
 * @param clientId 'For advertising agencies.' ID of the client ads are retrieved from. 
 * @param includeDeleted Flag that specifies whether archived ads shall be shown. *0 � show only
 * active ads,, *1 � show all ads. 
 * @param limit Limit of number of returned ads. Used only if 'ad_ids' parameter is null, and
 * 'campaign_ids' parameter contains ID of only one campaign. 
 * @param offset Offset. Used in the same cases as 'limit' parameter. 
 */
class AdsGetAdsLayout(
    private val accountId: Int,
    private val adIds: String? = null,
    private val campaignIds: String? = null,
    private val clientId: Int? = null,
    private val includeDeleted: Boolean? = null,
    private val limit: Int? = null,
    private val offset: Int? = null
) : VKRequest<List<AdsAdLayout>>("ads.getAdsLayout") {
    init {
        addParam("account_id", accountId)
        adIds?.let { value ->
            addParam("ad_ids", value)
        }
        campaignIds?.let { value ->
            addParam("campaign_ids", value)
        }
        clientId?.let { value ->
            addParam("client_id", value)
        }
        includeDeleted?.let { value ->
            addParam("include_deleted", if (value) 1 else 0)
        }
        limit?.let { value ->
            addParam("limit", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
    }

    override fun parse(r: JSONObject): List<AdsAdLayout> = GsonHolder.gson.fromJson(r.toString(),
            AdsGetAdsLayoutResponse::class.java).response
}
