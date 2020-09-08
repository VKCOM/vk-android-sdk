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
package com.vk.sdk.api.groups.methods

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.addresses.dto.AddressesFields
import com.vk.sdk.api.groups.dto.GroupsGetAddressesResponseDto
import com.vk.sdk.api.groups.responses.GroupsGetAddressesResponse
import kotlin.Float
import kotlin.Int
import kotlin.collections.List
import org.json.JSONObject

/**
 * Returns a list of community addresses.
 * @param groupId ID or screen name of the community. minimum 0
 * @param addressIds  
 * @param latitude Latitude of  the user geo position. minimum -90 maximum 90
 * @param longitude Longitude of the user geo position. minimum -180 maximum 180
 * @param offset Offset needed to return a specific subset of community addresses. minimum 0
 * @param count Number of community addresses to return. default 10 minimum 0
 * @param fields Address fields 
 */
class GroupsGetAddresses(
    private val groupId: Int,
    private val addressIds: List<Int>? = null,
    private val latitude: Float? = null,
    private val longitude: Float? = null,
    private val offset: Int? = null,
    private val count: Int? = null,
    private val fields: List<AddressesFields>? = null
) : VKRequest<GroupsGetAddressesResponseDto>("groups.getAddresses") {
    init {
        addParam("group_id", groupId)
        addressIds?.let { value ->
            addParam("address_ids", value)
        }
        latitude?.let { value ->
            addParam("latitude", value.toString())
        }
        longitude?.let { value ->
            addParam("longitude", value.toString())
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
    }

    override fun parse(r: JSONObject): GroupsGetAddressesResponseDto =
            GsonHolder.gson.fromJson(r.toString(), GroupsGetAddressesResponse::class.java).response
}
