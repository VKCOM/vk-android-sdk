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
import com.vk.sdk.api.groups.dto.GroupsGroupLink
import com.vk.sdk.api.groups.responses.GroupsAddLinkResponse
import kotlin.Int
import kotlin.String
import org.json.JSONObject

/**
 * Allows to add a link to the community.
 * @param groupId Community ID. minimum 0
 * @param link Link URL. 
 * @param text Description text for the link. 
 */
class GroupsAddLink(
    private val groupId: Int,
    private val link: String,
    private val text: String? = null
) : VKRequest<GroupsGroupLink>("groups.addLink") {
    init {
        addParam("group_id", groupId)
        addParam("link", link)
        text?.let { value ->
            addParam("text", value)
        }
    }

    override fun parse(r: JSONObject): GroupsGroupLink = GsonHolder.gson.fromJson(r.toString(),
            GroupsAddLinkResponse::class.java).response
}
