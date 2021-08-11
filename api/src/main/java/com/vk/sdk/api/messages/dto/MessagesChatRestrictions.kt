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
package com.vk.sdk.api.messages.dto

import com.google.gson.annotations.SerializedName
import kotlin.Boolean

/**
 * @param adminsPromoteUsers - Only admins can promote users to admins
 * @param onlyAdminsEditInfo - Only admins can change chat info
 * @param onlyAdminsEditPin - Only admins can edit pinned message
 * @param onlyAdminsInvite - Only admins can invite users to this chat
 * @param onlyAdminsKick - Only admins can kick users from this chat
 */
data class MessagesChatRestrictions(
    @SerializedName("admins_promote_users")
    val adminsPromoteUsers: Boolean? = null,
    @SerializedName("only_admins_edit_info")
    val onlyAdminsEditInfo: Boolean? = null,
    @SerializedName("only_admins_edit_pin")
    val onlyAdminsEditPin: Boolean? = null,
    @SerializedName("only_admins_invite")
    val onlyAdminsInvite: Boolean? = null,
    @SerializedName("only_admins_kick")
    val onlyAdminsKick: Boolean? = null
)
