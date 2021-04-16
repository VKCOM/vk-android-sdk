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
package com.vk.sdk.api.events.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.groups.dto.GroupsGroupFullMemberStatus
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param buttonText - text of attach
 * @param friends - array of friends ids
 * @param id - event ID
 * @param isFavorite - is favorite
 * @param text - text of attach
 * @param address - address of event
 * @param memberStatus - Current user's member status
 * @param time - event start time
 */
data class EventsEventAttach(
    @SerializedName("button_text")
    val buttonText: String,
    @SerializedName("friends")
    val friends: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_favorite")
    val isFavorite: Boolean,
    @SerializedName("text")
    val text: String,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("member_status")
    val memberStatus: GroupsGroupFullMemberStatus? = null,
    @SerializedName("time")
    val time: Int? = null
)
