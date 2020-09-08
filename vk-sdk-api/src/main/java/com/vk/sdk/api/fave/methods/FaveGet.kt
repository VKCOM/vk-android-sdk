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
import com.vk.sdk.api.fave.dto.FaveGetItemType
import com.vk.sdk.api.fave.dto.FaveGetResponseDto
import com.vk.sdk.api.fave.responses.FaveGetResponse
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * @param extended '1' � to return additional 'wall', 'profiles', and 'groups' fields. By default:
 * '0'. default false
 * @param itemType  
 * @param tagId Tag ID. 
 * @param offset Offset needed to return a specific subset of users. minimum 0
 * @param count Number of users to return. default 50 minimum 1 maximum 100
 * @param fields  
 * @param isFromSnackbar  
 */
class FaveGet(
    private val extended: Boolean? = null,
    private val itemType: FaveGetItemType? = null,
    private val tagId: Int? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val fields: String? = null,
    private val isFromSnackbar: Boolean? = null
) : VKRequest<FaveGetResponseDto>("fave.get") {
    init {
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
        itemType?.let { value ->
            addParam("item_type", value.value)
        }
        tagId?.let { value ->
            addParam("tag_id", value)
        }
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        fields?.let { value ->
            addParam("fields", value)
        }
        isFromSnackbar?.let { value ->
            addParam("is_from_snackbar", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): FaveGetResponseDto = GsonHolder.gson.fromJson(r.toString(),
            FaveGetResponse::class.java).response
}
