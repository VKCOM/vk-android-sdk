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
import com.vk.sdk.api.groups.dto.GroupsAddAddressWorkInfoStatus
import com.vk.sdk.api.groups.dto.GroupsAddress
import com.vk.sdk.api.groups.responses.GroupsAddAddressResponse
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * @param groupId  minimum 0
 * @param title  maxLength 255
 * @param address  maxLength 255
 * @param countryId  minimum 1
 * @param cityId  minimum 1
 * @param latitude  minimum -90 maximum 90
 * @param longitude  minimum -180 maximum 180
 * @param additionalAddress  maxLength 400
 * @param metroId  minimum 0
 * @param phone  
 * @param workInfoStatus  default "no_information"
 * @param timetable  
 * @param isMainAddress  
 */
class GroupsAddAddress(
    private val groupId: Int,
    private val title: String,
    private val address: String,
    private val countryId: Int,
    private val cityId: Int,
    private val latitude: Float,
    private val longitude: Float,
    private val additionalAddress: String? = null,
    private val metroId: Int? = null,
    private val phone: String? = null,
    private val workInfoStatus: GroupsAddAddressWorkInfoStatus? = null,
    private val timetable: String? = null,
    private val isMainAddress: Boolean? = null
) : VKRequest<GroupsAddress>("groups.addAddress") {
    init {
        addParam("group_id", groupId)
        addParam("title", title)
        addParam("address", address)
        addParam("country_id", countryId)
        addParam("city_id", cityId)
        addParam("latitude", latitude.toString())
        addParam("longitude", longitude.toString())
        additionalAddress?.let { value ->
            addParam("additional_address", value)
        }
        metroId?.let { value ->
            addParam("metro_id", value)
        }
        phone?.let { value ->
            addParam("phone", value)
        }
        workInfoStatus?.let { value ->
            addParam("work_info_status", value.value)
        }
        timetable?.let { value ->
            addParam("timetable", value)
        }
        isMainAddress?.let { value ->
            addParam("is_main_address", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): GroupsAddress = GsonHolder.gson.fromJson(r.toString(),
            GroupsAddAddressResponse::class.java).response
}
