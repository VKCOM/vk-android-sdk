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
import com.vk.sdk.api.ads.dto.AdsCampaign
import com.vk.sdk.api.ads.dto.AdsGetCampaignsFields
import com.vk.sdk.api.ads.responses.AdsGetCampaignsResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of campaigns in an advertising account.
 * @param accountId Advertising account ID. 
 * @param clientId 'For advertising agencies'. ID of the client advertising campaigns are retrieved
 * from. 
 * @param includeDeleted Flag that specifies whether archived ads shall be shown. *0 � show only
 * active campaigns,, *1 � show all campaigns. 
 * @param campaignIds Filter of advertising campaigns to show. Serialized JSON array with campaign
 * IDs. Only campaigns that exist in 'campaign_ids' and belong to the specified advertising account
 * will be shown. If the parameter is null, all campaigns will be shown. 
 * @param fields  
 */
class AdsGetCampaigns(
    private val accountId: Int,
    private val clientId: Int? = null,
    private val includeDeleted: Boolean? = null,
    private val campaignIds: String? = null,
    private val fields: List<AdsGetCampaignsFields>? = null
) : VKRequest<List<AdsCampaign>>("ads.getCampaigns") {
    init {
        addParam("account_id", accountId)
        clientId?.let { value ->
            addParam("client_id", value)
        }
        includeDeleted?.let { value ->
            addParam("include_deleted", if (value) 1 else 0)
        }
        campaignIds?.let { value ->
            addParam("campaign_ids", value)
        }
        fields?.let { value ->
            addParam("fields", value.map { it.value })
        }
    }

    override fun parse(r: JSONObject): List<AdsCampaign> = GsonHolder.gson.fromJson(r.toString(),
            AdsGetCampaignsResponse::class.java).response
}
