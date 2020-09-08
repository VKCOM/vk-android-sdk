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
package com.vk.sdk.api.fave.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.responses.BaseOkResponse
import com.vk.sdk.api.fave.dto.FaveSetTagsItemType
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.json.JSONObject

/**
 * @param itemType  
 * @param itemOwnerId  
 * @param itemId  
 * @param tagIds  
 * @param linkId  
 * @param linkUrl  
 */
class FaveSetTags(
    private val itemType: FaveSetTagsItemType? = null,
    private val itemOwnerId: Int? = null,
    private val itemId: Int? = null,
    private val tagIds: List<Int>? = null,
    private val linkId: String? = null,
    private val linkUrl: String? = null
) : VKRequest<BaseOkResponseDto>("fave.setTags") {
    init {
        itemType?.let { value ->
            addParam("item_type", value.value)
        }
        itemOwnerId?.let { value ->
            addParam("item_owner_id", value)
        }
        itemId?.let { value ->
            addParam("item_id", value)
        }
        tagIds?.let { value ->
            addParam("tag_ids", value)
        }
        linkId?.let { value ->
            addParam("link_id", value)
        }
        linkUrl?.let { value ->
            addParam("link_url", value)
        }
    }

    override fun parse(r: JSONObject): BaseOkResponseDto = GsonHolder.gson.fromJson(r.toString(),
            BaseOkResponse::class.java).response
}
