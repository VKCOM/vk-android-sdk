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
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.audio.dto.AudioAudio
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseCity
import com.vk.sdk.api.base.dto.BaseCountry
import com.vk.sdk.api.base.dto.BaseSex
import com.vk.sdk.api.users.dto.UsersPersonal
import com.vk.sdk.api.users.dto.UsersUserConnections
import com.vk.sdk.api.users.dto.UsersUserMin
import com.vk.sdk.api.users.dto.UsersUserRelation
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param id - User ID
 * @param homeTown - User's hometown
 * @param status - User status
 * @param photo200 - URL of square photo of the user with 200 pixels in width
 * @param isServiceAccount - flag about service account
 * @param deactivated - Returns if a profile is deleted or blocked
 * @param firstName - User first name
 * @param hidden - Returns if a profile is hidden.
 * @param lastName - User last name
 * @param canAccessClosed
 * @param isClosed
 * @param connections
 * @param bdate - User's date of birth
 * @param bdateVisibility - Information whether user's birthdate are hidden
 * @param city
 * @param country
 * @param maidenName - User maiden name
 * @param nameRequest
 * @param personal
 * @param phone - User phone number with some hidden digits
 * @param relation - User relationship status
 * @param relationPartner
 * @param relationPending - Information whether relation status is pending
 * @param relationRequests
 * @param screenName - Domain name of the user's page
 * @param sex - User sex
 * @param statusAudio
 * @param interests
 * @param languages
 */
data class AccountUserSettings(
    @SerializedName("id")
    val id: UserId,
    @SerializedName("home_town")
    val homeTown: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("photo_200")
    val photo200: String? = null,
    @SerializedName("is_service_account")
    val isServiceAccount: Boolean? = null,
    @SerializedName("deactivated")
    val deactivated: String? = null,
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("hidden")
    val hidden: Int? = null,
    @SerializedName("last_name")
    val lastName: String? = null,
    @SerializedName("can_access_closed")
    val canAccessClosed: Boolean? = null,
    @SerializedName("is_closed")
    val isClosed: Boolean? = null,
    @SerializedName("connections")
    val connections: UsersUserConnections? = null,
    @SerializedName("bdate")
    val bdate: String? = null,
    @SerializedName("bdate_visibility")
    val bdateVisibility: Int? = null,
    @SerializedName("city")
    val city: BaseCity? = null,
    @SerializedName("country")
    val country: BaseCountry? = null,
    @SerializedName("maiden_name")
    val maidenName: String? = null,
    @SerializedName("name_request")
    val nameRequest: AccountNameRequest? = null,
    @SerializedName("personal")
    val personal: UsersPersonal? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("relation")
    val relation: UsersUserRelation? = null,
    @SerializedName("relation_partner")
    val relationPartner: UsersUserMin? = null,
    @SerializedName("relation_pending")
    val relationPending: BaseBoolInt? = null,
    @SerializedName("relation_requests")
    val relationRequests: List<UsersUserMin>? = null,
    @SerializedName("screen_name")
    val screenName: String? = null,
    @SerializedName("sex")
    val sex: BaseSex? = null,
    @SerializedName("status_audio")
    val statusAudio: AudioAudio? = null,
    @SerializedName("interests")
    val interests: AccountUserSettingsInterests? = null,
    @SerializedName("languages")
    val languages: List<String>? = null
)
