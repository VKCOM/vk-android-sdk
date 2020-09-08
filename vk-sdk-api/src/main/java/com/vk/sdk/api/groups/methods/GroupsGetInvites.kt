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
import com.vk.sdk.api.groups.dto.GroupsGetInvitesResponseDto
import com.vk.sdk.api.groups.responses.GroupsGetInvitesResponse
import kotlin.Boolean
import kotlin.Int
import org.json.JSONObject

/**
 * Returns a list of invitations to join communities and events.
 * @param offset Offset needed to return a specific subset of invitations. minimum 0
 * @param count Number of invitations to return. default 20 minimum 0
 * @param extended '1' � to return additional [vk.com/dev/fields_groups|fields] for communities.. 
 */
class GroupsGetInvites(
    private val offset: Int? = null,
    private val count: Int? = null,
    private val extended: Boolean? = null
) : VKRequest<GroupsGetInvitesResponseDto>("groups.getInvites") {
    init {
        offset?.let { value ->
            addParam("offset", value)
        }
        count?.let { value ->
            addParam("count", value)
        }
        extended?.let { value ->
            addParam("extended", if (value) 1 else 0)
        }
    }

    override fun parse(r: JSONObject): GroupsGetInvitesResponseDto =
            GsonHolder.gson.fromJson(r.toString(), GroupsGetInvitesResponse::class.java).response
}
