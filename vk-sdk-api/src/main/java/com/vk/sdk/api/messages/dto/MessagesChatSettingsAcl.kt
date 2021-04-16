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
 * @param canChangeInfo - Can you change photo, description and name
 * @param canChangeInviteLink - Can you change invite link for this chat
 * @param canChangePin - Can you pin/unpin message for this chat
 * @param canInvite - Can you invite other peers in chat
 * @param canPromoteUsers - Can you promote simple users to chat admins
 * @param canSeeInviteLink - Can you see invite link for this chat
 * @param canModerate - Can you moderate (delete) other users' messages
 * @param canCopyChat - Can you copy chat
 * @param canCall - Can you init group call in the chat
 * @param canUseMassMentions - Can you use mass mentions
 * @param canChangeServiceType - Can you change chat service type
 */
data class MessagesChatSettingsAcl(
    @SerializedName("can_change_info")
    val canChangeInfo: Boolean,
    @SerializedName("can_change_invite_link")
    val canChangeInviteLink: Boolean,
    @SerializedName("can_change_pin")
    val canChangePin: Boolean,
    @SerializedName("can_invite")
    val canInvite: Boolean,
    @SerializedName("can_promote_users")
    val canPromoteUsers: Boolean,
    @SerializedName("can_see_invite_link")
    val canSeeInviteLink: Boolean,
    @SerializedName("can_moderate")
    val canModerate: Boolean,
    @SerializedName("can_copy_chat")
    val canCopyChat: Boolean,
    @SerializedName("can_call")
    val canCall: Boolean,
    @SerializedName("can_use_mass_mentions")
    val canUseMassMentions: Boolean,
    @SerializedName("can_change_service_type")
    val canChangeServiceType: Boolean? = null
)
