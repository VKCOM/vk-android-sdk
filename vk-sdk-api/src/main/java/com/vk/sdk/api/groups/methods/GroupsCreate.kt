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
import com.vk.sdk.api.groups.dto.GroupsCreateSubtype
import com.vk.sdk.api.groups.dto.GroupsCreateType
import com.vk.sdk.api.groups.dto.GroupsGroup
import com.vk.sdk.api.groups.responses.GroupsCreateResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Creates a new community.
 * @param title Community title. 
 * @param description Community description (ignored for 'type' = 'public'). 
 * @param type Community type. Possible values: *'group' � group,, *'event' � event,, *'public' �
 * public page default "group"
 * @param publicCategory Category ID (for 'type' = 'public' only). minimum 0
 * @param subtype Public page subtype. Possible values: *'1' � place or small business,, *'2' �
 * company, organization or website,, *'3' � famous person or group of people,, *'4' � product or work
 * of art. minimum 0
 */
class GroupsCreate(
    private val title: String,
    private val description: String? = null,
    private val type: GroupsCreateType? = null,
    private val publicCategory: Int? = null,
    private val subtype: GroupsCreateSubtype? = null
) : VKRequest<GroupsGroup>("groups.create") {
    init {
        addParam("title", title)
        description?.let { value ->
            addParam("description", value)
        }
        type?.let { value ->
            addParam("type", value.value)
        }
        publicCategory?.let { value ->
            addParam("public_category", value)
        }
        subtype?.let { value ->
            addParam("subtype", value.value)
        }
    }

    override fun parse(r: JSONObject): GroupsGroup = GsonHolder.gson.fromJson(r.toString(),
            GroupsCreateResponse::class.java).response
}
