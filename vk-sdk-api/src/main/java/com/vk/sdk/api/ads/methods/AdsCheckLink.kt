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
import com.vk.sdk.api.ads.dto.AdsCheckLinkLinkType
import com.vk.sdk.api.ads.dto.AdsLinkStatus
import com.vk.sdk.api.ads.responses.AdsCheckLinkResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Allows to check the ad link.
 * @param accountId Advertising account ID. 
 * @param linkType Object type: *'community' � community,, *'post' � community post,, *'application'
 * � VK application,, *'video' � video,, *'site' � external site. 
 * @param linkUrl Object URL. 
 * @param campaignId Campaign ID 
 */
class AdsCheckLink(
    private val accountId: Int,
    private val linkType: AdsCheckLinkLinkType,
    private val linkUrl: String,
    private val campaignId: Int? = null
) : VKRequest<AdsLinkStatus>("ads.checkLink") {
    init {
        addParam("account_id", accountId)
        addParam("link_type", linkType.value)
        addParam("link_url", linkUrl)
        campaignId?.let { value ->
            addParam("campaign_id", value)
        }
    }

    override fun parse(r: JSONObject): AdsLinkStatus = GsonHolder.gson.fromJson(r.toString(),
            AdsCheckLinkResponse::class.java).response
}
