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
import com.vk.sdk.api.ads.dto.AdsCreateTargetGroupResponseDto
import com.vk.sdk.api.ads.responses.AdsCreateTargetGroupResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Creates a group to re-target ads for users who visited advertiser's site (viewed information
 * about the product, registered, etc.).
 * @param accountId Advertising account ID. 
 * @param name Name of the target group � a string up to 64 characters long. 
 * @param lifetime 'For groups with auditory created with pixel code only.', , Number of days after
 * that users will be automatically removed from the group. minimum 1 maximum 720
 * @param clientId 'Only for advertising agencies.', ID of the client with the advertising account
 * where the group will be created. 
 * @param targetPixelId  
 * @param targetPixelRules  
 */
class AdsCreateTargetGroup(
    private val accountId: Int,
    private val name: String,
    private val lifetime: Int,
    private val clientId: Int? = null,
    private val targetPixelId: Int? = null,
    private val targetPixelRules: String? = null
) : VKRequest<AdsCreateTargetGroupResponseDto>("ads.createTargetGroup") {
    init {
        addParam("account_id", accountId)
        addParam("name", name)
        addParam("lifetime", lifetime)
        clientId?.let { value ->
            addParam("client_id", value)
        }
        targetPixelId?.let { value ->
            addParam("target_pixel_id", value)
        }
        targetPixelRules?.let { value ->
            addParam("target_pixel_rules", value)
        }
    }

    override fun parse(r: JSONObject): AdsCreateTargetGroupResponseDto =
            GsonHolder.gson.fromJson(r.toString(),
            AdsCreateTargetGroupResponse::class.java).response
}
