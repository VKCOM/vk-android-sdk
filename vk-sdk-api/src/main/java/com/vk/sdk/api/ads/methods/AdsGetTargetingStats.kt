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
import com.vk.sdk.api.ads.dto.AdsGetTargetingStatsAdFormat
import com.vk.sdk.api.ads.dto.AdsTargStats
import com.vk.sdk.api.ads.responses.AdsGetTargetingStatsResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Returns the size of targeting audience, and also recommended values for CPC and CPM.
 * @param accountId Advertising account ID. 
 * @param linkUrl URL for the advertised object. 
 * @param clientId  
 * @param criteria Serialized JSON object that describes targeting parameters. Description of
 * 'criteria' object see below. 
 * @param adId ID of an ad which targeting parameters shall be analyzed. 
 * @param adFormat Ad format. Possible values: *'1' � image and text,, *'2' � big image,, *'3' �
 * exclusive format,, *'4' � community, square image,, *'7' � special app format,, *'8' � special
 * community format,, *'9' � post in community,, *'10' � app board. 
 * @param adPlatform Platforms to use for ad showing. Possible values: (for 'ad_format' = '1'), *'0'
 * � VK and partner sites,, *'1' � VK only. (for 'ad_format' = '9'), *'all' � all platforms,,
 * *'desktop' � desktop version,, *'mobile' � mobile version and apps. 
 * @param adPlatformNoWall  
 * @param adPlatformNoAdNetwork  
 * @param linkDomain Domain of the advertised object. 
 * @param needPrecise Additionally return recommended cpc and cpm to reach 5,10..95 percents of
 * audience. 
 */
class AdsGetTargetingStats(
    private val accountId: Int,
    private val linkUrl: String,
    private val clientId: Int? = null,
    private val criteria: String? = null,
    private val adId: Int? = null,
    private val adFormat: AdsGetTargetingStatsAdFormat? = null,
    private val adPlatform: String? = null,
    private val adPlatformNoWall: String? = null,
    private val adPlatformNoAdNetwork: String? = null,
    private val linkDomain: String? = null,
    private val needPrecise: Boolean? = null
) : VKRequest<AdsTargStats>("ads.getTargetingStats") {
    init {
        addParam("account_id", accountId)
        addParam("link_url", linkUrl)
        clientId?.let { value ->
            addParam("client_id", value)
        }
        criteria?.let { value ->
            addParam("criteria", value)
        }
        adId?.let { value ->
            addParam("ad_id", value)
        }
        adFormat?.let { value ->
            addParam("ad_format", value.value)
        }
        adPlatform?.let { value ->
            addParam("ad_platform", value)
        }
        adPlatformNoWall?.let { value ->
            addParam("ad_platform_no_wall", value)
        }
        adPlatformNoAdNetwork?.let { value ->
            addParam("ad_platform_no_ad_network", value)
        }
        linkDomain?.let { value ->
            addParam("link_domain", value)
        }
        needPrecise?.let { value ->
            addParam("need_precise", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): AdsTargStats = GsonHolder.gson.fromJson(r.toString(),
            AdsGetTargetingStatsResponse::class.java).response
}
