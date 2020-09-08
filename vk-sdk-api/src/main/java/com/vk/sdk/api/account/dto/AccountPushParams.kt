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
 * @param msg no description
 * @param chat no description
 * @param like no description
 * @param repost no description
 * @param comment no description
 * @param mention no description
 * @param reply no description
 * @param newPost no description
 * @param wallPost no description
 * @param wallPublish no description
 * @param friend no description
 * @param friendFound no description
 * @param friendAccepted no description
 * @param groupInvite no description
 * @param groupAccepted no description
 * @param birthday no description
 * @param eventSoon no description
 * @param appRequest no description
 * @param sdkOpen no description
 */
data class AccountPushParams(
    @SerializedName(value="msg")
    val msg: List<AccountPushParamsMode>? = null,
    @SerializedName(value="chat")
    val chat: List<AccountPushParamsMode>? = null,
    @SerializedName(value="like")
    val like: List<AccountPushParamsSettings>? = null,
    @SerializedName(value="repost")
    val repost: List<AccountPushParamsSettings>? = null,
    @SerializedName(value="comment")
    val comment: List<AccountPushParamsSettings>? = null,
    @SerializedName(value="mention")
    val mention: List<AccountPushParamsSettings>? = null,
    @SerializedName(value="reply")
    val reply: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="new_post")
    val newPost: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="wall_post")
    val wallPost: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="wall_publish")
    val wallPublish: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="friend")
    val friend: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="friend_found")
    val friendFound: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="friend_accepted")
    val friendAccepted: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="group_invite")
    val groupInvite: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="group_accepted")
    val groupAccepted: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="birthday")
    val birthday: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="event_soon")
    val eventSoon: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="app_request")
    val appRequest: List<AccountPushParamsOnoff>? = null,
    @SerializedName(value="sdk_open")
    val sdkOpen: List<AccountPushParamsOnoff>? = null
)
