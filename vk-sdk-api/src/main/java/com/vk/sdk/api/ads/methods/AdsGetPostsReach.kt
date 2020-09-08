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
import com.vk.sdk.api.ads.dto.AdsGetPostsReachIdsType
import com.vk.sdk.api.ads.dto.AdsPromotedPostReach
import com.vk.sdk.api.ads.responses.AdsGetPostsReachResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns detailed statistics of promoted posts reach from campaigns and ads.
 * @param accountId Advertising account ID. 
 * @param idsType Type of requested objects listed in 'ids' parameter: *ad � ads,, *campaign �
 * campaigns. 
 * @param ids IDs requested ads or campaigns, separated with a comma, depending on the value set in
 * 'ids_type'. Maximum 100 objects. 
 */
class AdsGetPostsReach(
    private val accountId: Int,
    private val idsType: AdsGetPostsReachIdsType,
    private val ids: String
) : VKRequest<List<AdsPromotedPostReach>>("ads.getPostsReach") {
    init {
        addParam("account_id", accountId)
        addParam("ids_type", idsType.value)
        addParam("ids", ids)
    }

    override fun parse(r: JSONObject): List<AdsPromotedPostReach> =
            GsonHolder.gson.fromJson(r.toString(), AdsGetPostsReachResponse::class.java).response
}
