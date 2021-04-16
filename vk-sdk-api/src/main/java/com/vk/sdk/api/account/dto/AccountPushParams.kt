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
package com.vk.sdk.api.account.dto

import com.google.gson.annotations.SerializedName
import kotlin.collections.List

/**
 * @param msg
 * @param chat
 * @param like
 * @param repost
 * @param comment
 * @param mention
 * @param reply
 * @param newPost
 * @param wallPost
 * @param wallPublish
 * @param friend
 * @param friendFound
 * @param friendAccepted
 * @param groupInvite
 * @param groupAccepted
 * @param birthday
 * @param eventSoon
 * @param appRequest
 * @param sdkOpen
 */
data class AccountPushParams(
    @SerializedName("msg")
    val msg: List<AccountPushParamsMode>? = null,
    @SerializedName("chat")
    val chat: List<AccountPushParamsMode>? = null,
    @SerializedName("like")
    val like: List<AccountPushParamsSettings>? = null,
    @SerializedName("repost")
    val repost: List<AccountPushParamsSettings>? = null,
    @SerializedName("comment")
    val comment: List<AccountPushParamsSettings>? = null,
    @SerializedName("mention")
    val mention: List<AccountPushParamsSettings>? = null,
    @SerializedName("reply")
    val reply: List<AccountPushParamsOnoff>? = null,
    @SerializedName("new_post")
    val newPost: List<AccountPushParamsOnoff>? = null,
    @SerializedName("wall_post")
    val wallPost: List<AccountPushParamsOnoff>? = null,
    @SerializedName("wall_publish")
    val wallPublish: List<AccountPushParamsOnoff>? = null,
    @SerializedName("friend")
    val friend: List<AccountPushParamsOnoff>? = null,
    @SerializedName("friend_found")
    val friendFound: List<AccountPushParamsOnoff>? = null,
    @SerializedName("friend_accepted")
    val friendAccepted: List<AccountPushParamsOnoff>? = null,
    @SerializedName("group_invite")
    val groupInvite: List<AccountPushParamsOnoff>? = null,
    @SerializedName("group_accepted")
    val groupAccepted: List<AccountPushParamsOnoff>? = null,
    @SerializedName("birthday")
    val birthday: List<AccountPushParamsOnoff>? = null,
    @SerializedName("event_soon")
    val eventSoon: List<AccountPushParamsOnoff>? = null,
    @SerializedName("app_request")
    val appRequest: List<AccountPushParamsOnoff>? = null,
    @SerializedName("sdk_open")
    val sdkOpen: List<AccountPushParamsOnoff>? = null
)
