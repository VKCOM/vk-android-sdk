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
import kotlin.String

/**
 * @param invite - Who can invite users to chat
 * @param changeInfo - Who can change chat info
 * @param changePin - Who can change pinned message
 * @param useMassMentions - Who can use mass mentions
 * @param seeInviteLink - Who can see invite link
 * @param call - Who can make calls
 * @param changeAdmins - Who can change admins
 */
data class MessagesChatSettingsPermissionsDto(
    @SerializedName("invite")
    val invite: MessagesChatSettingsPermissionsDto.InviteDto? = null,
    @SerializedName("change_info")
    val changeInfo: MessagesChatSettingsPermissionsDto.ChangeInfoDto? = null,
    @SerializedName("change_pin")
    val changePin: MessagesChatSettingsPermissionsDto.ChangePinDto? = null,
    @SerializedName("use_mass_mentions")
    val useMassMentions: MessagesChatSettingsPermissionsDto.UseMassMentionsDto? = null,
    @SerializedName("see_invite_link")
    val seeInviteLink: MessagesChatSettingsPermissionsDto.SeeInviteLinkDto? = null,
    @SerializedName("call")
    val call: MessagesChatSettingsPermissionsDto.CallDto? = null,
    @SerializedName("change_admins")
    val changeAdmins: MessagesChatSettingsPermissionsDto.ChangeAdminsDto? = null
) {
    enum class InviteDto(
        val value: String
    ) {
        @SerializedName("owner")
        OWNER("owner"),

        @SerializedName("owner_and_admins")
        OWNER_AND_ADMINS("owner_and_admins"),

        @SerializedName("all")
        ALL("all");
    }

    enum class ChangeInfoDto(
        val value: String
    ) {
        @SerializedName("owner")
        OWNER("owner"),

        @SerializedName("owner_and_admins")
        OWNER_AND_ADMINS("owner_and_admins"),

        @SerializedName("all")
        ALL("all");
    }

    enum class ChangePinDto(
        val value: String
    ) {
        @SerializedName("owner")
        OWNER("owner"),

        @SerializedName("owner_and_admins")
        OWNER_AND_ADMINS("owner_and_admins"),

        @SerializedName("all")
        ALL("all");
    }

    enum class UseMassMentionsDto(
        val value: String
    ) {
        @SerializedName("owner")
        OWNER("owner"),

        @SerializedName("owner_and_admins")
        OWNER_AND_ADMINS("owner_and_admins"),

        @SerializedName("all")
        ALL("all");
    }

    enum class SeeInviteLinkDto(
        val value: String
    ) {
        @SerializedName("owner")
        OWNER("owner"),

        @SerializedName("owner_and_admins")
        OWNER_AND_ADMINS("owner_and_admins"),

        @SerializedName("all")
        ALL("all");
    }

    enum class CallDto(
        val value: String
    ) {
        @SerializedName("owner")
        OWNER("owner"),

        @SerializedName("owner_and_admins")
        OWNER_AND_ADMINS("owner_and_admins"),

        @SerializedName("all")
        ALL("all");
    }

    enum class ChangeAdminsDto(
        val value: String
    ) {
        @SerializedName("owner")
        OWNER("owner"),

        @SerializedName("owner_and_admins")
        OWNER_AND_ADMINS("owner_and_admins");
    }
}
