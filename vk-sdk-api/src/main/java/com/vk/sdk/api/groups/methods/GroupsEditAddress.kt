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
import com.vk.sdk.api.groups.dto.GroupsAddress
import com.vk.sdk.api.groups.dto.GroupsEditAddressWorkInfoStatus
import com.vk.sdk.api.groups.responses.GroupsEditAddressResponse
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * @param groupId  minimum 0
 * @param addressId  minimum 0
 * @param title  maxLength 255
 * @param address  maxLength 255
 * @param additionalAddress  maxLength 400
 * @param countryId  minimum 0
 * @param cityId  minimum 0
 * @param metroId  minimum 0
 * @param latitude  minimum -90 maximum 90
 * @param longitude  minimum -180 maximum 180
 * @param phone  
 * @param workInfoStatus  
 * @param timetable  
 * @param isMainAddress  
 */
class GroupsEditAddress(
    private val groupId: Int,
    private val addressId: Int,
    private val title: String? = null,
    private val address: String? = null,
    private val additionalAddress: String? = null,
    private val countryId: Int? = null,
    private val cityId: Int? = null,
    private val metroId: Int? = null,
    private val latitude: Float? = null,
    private val longitude: Float? = null,
    private val phone: String? = null,
    private val workInfoStatus: GroupsEditAddressWorkInfoStatus? = null,
    private val timetable: String? = null,
    private val isMainAddress: Boolean? = null
) : VKRequest<GroupsAddress>("groups.editAddress") {
    init {
        addParam("group_id", groupId)
        addParam("address_id", addressId)
        title?.let { value ->
            addParam("title", value)
        }
        address?.let { value ->
            addParam("address", value)
        }
        additionalAddress?.let { value ->
            addParam("additional_address", value)
        }
        countryId?.let { value ->
            addParam("country_id", value)
        }
        cityId?.let { value ->
            addParam("city_id", value)
        }
        metroId?.let { value ->
            addParam("metro_id", value)
        }
        latitude?.let { value ->
            addParam("latitude", value.toString())
        }
        longitude?.let { value ->
            addParam("longitude", value.toString())
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
            GroupsEditAddressResponse::class.java).response
}
