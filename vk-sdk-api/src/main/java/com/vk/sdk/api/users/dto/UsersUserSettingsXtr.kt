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
package com.vk.sdk.api.users.dto

import com.google.gson.annotations.SerializedName
import com.vk.sdk.api.account.dto.AccountNameRequest
import com.vk.sdk.api.account.dto.AccountUserSettingsInterests
import com.vk.sdk.api.audio.dto.AudioAudio
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseCity
import com.vk.sdk.api.base.dto.BaseCountry
import com.vk.sdk.api.base.dto.BaseSex
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * @param homeTown User's hometown
 * @param status User status
 * @param connections no description
 * @param bdate User's date of birth
 * @param bdateVisibility Information whether user's birthdate are hidden
 * @param city no description
 * @param country no description
 * @param firstName User first name
 * @param lastName User last name
 * @param maidenName User maiden name
 * @param nameRequest no description
 * @param personal no description
 * @param phone User phone number with some hidden digits
 * @param relation User relationship status
 * @param relationPartner no description
 * @param relationPending Information whether relation status is pending
 * @param relationRequests no description
 * @param screenName Domain name of the user's page
 * @param sex User sex
 * @param statusAudio no description
 * @param interests no description
 * @param languages no description
 */
data class UsersUserSettingsXtr(
    @SerializedName(value="home_town")
    val homeTown: String,
    @SerializedName(value="status")
    val status: String,
    @SerializedName(value="connections")
    val connections: UsersUserConnections? = null,
    @SerializedName(value="bdate")
    val bdate: String? = null,
    @SerializedName(value="bdate_visibility")
    val bdateVisibility: Int? = null,
    @SerializedName(value="city")
    val city: BaseCity? = null,
    @SerializedName(value="country")
    val country: BaseCountry? = null,
    @SerializedName(value="first_name")
    val firstName: String? = null,
    @SerializedName(value="last_name")
    val lastName: String? = null,
    @SerializedName(value="maiden_name")
    val maidenName: String? = null,
    @SerializedName(value="name_request")
    val nameRequest: AccountNameRequest? = null,
    @SerializedName(value="personal")
    val personal: UsersPersonal? = null,
    @SerializedName(value="phone")
    val phone: String? = null,
    @SerializedName(value="relation")
    val relation: UsersUserRelation? = null,
    @SerializedName(value="relation_partner")
    val relationPartner: UsersUserMin? = null,
    @SerializedName(value="relation_pending")
    val relationPending: BaseBoolInt? = null,
    @SerializedName(value="relation_requests")
    val relationRequests: List<UsersUserMin>? = null,
    @SerializedName(value="screen_name")
    val screenName: String? = null,
    @SerializedName(value="sex")
    val sex: BaseSex? = null,
    @SerializedName(value="status_audio")
    val statusAudio: AudioAudio? = null,
    @SerializedName(value="interests")
    val interests: AccountUserSettingsInterests? = null,
    @SerializedName(value="languages")
    val languages: List<String>? = null
)
