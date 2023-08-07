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
package com.vk.sdk.api.account

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.account.dto.AccountAccountCountersDto
import com.vk.sdk.api.account.dto.AccountChangePasswordResponseDto
import com.vk.sdk.api.account.dto.AccountCountersFilterDto
import com.vk.sdk.api.account.dto.AccountGetActiveOffersResponseDto
import com.vk.sdk.api.account.dto.AccountGetBannedResponseDto
import com.vk.sdk.api.account.dto.AccountGetInfoFieldsDto
import com.vk.sdk.api.account.dto.AccountInfoDto
import com.vk.sdk.api.account.dto.AccountPushSettingsDto
import com.vk.sdk.api.account.dto.AccountSaveProfileInfoBdateVisibilityDto
import com.vk.sdk.api.account.dto.AccountSaveProfileInfoRelationDto
import com.vk.sdk.api.account.dto.AccountSaveProfileInfoResponseDto
import com.vk.sdk.api.account.dto.AccountSaveProfileInfoSexDto
import com.vk.sdk.api.account.dto.AccountSetInfoNameDto
import com.vk.sdk.api.account.dto.AccountUserSettingsDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class AccountService {
    /**
     * @param ownerId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun accountBan(ownerId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("account.ban") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Changes a user password after access is successfully restored with the
     * [vk.com/dev/auth.restore|auth.restore] method.
     *
     * @param newPassword - New password that will be set as a current
     * @param restoreSid - Session id received after the [vk.com/dev/auth.restore|auth.restore]
     * method is executed. (If the password is changed right after the access was restored)
     * @param changePasswordHash - Hash received after a successful OAuth authorization with a code
     * got by SMS. (If the password is changed right after the access was restored)
     * @param oldPassword - Current user password.
     * @return [VKRequest] with [AccountChangePasswordResponseDto]
     */
    fun accountChangePassword(
        newPassword: String,
        restoreSid: String? = null,
        changePasswordHash: String? = null,
        oldPassword: String? = null
    ): VKRequest<AccountChangePasswordResponseDto> = NewApiRequest("account.changePassword") {
        GsonHolder.gson.parse<AccountChangePasswordResponseDto>(it)
    }
    .apply {
        addParam("new_password", newPassword, minLength = 6)
        restoreSid?.let { addParam("restore_sid", it) }
        changePasswordHash?.let { addParam("change_password_hash", it) }
        oldPassword?.let { addParam("old_password", it) }
    }

    /**
     * Returns a list of active ads (offers) which executed by the user will bring him/her
     * respective number of votes to his balance in the application.
     *
     * @param offset
     * @param count - Number of results to return.
     * @return [VKRequest] with [AccountGetActiveOffersResponseDto]
     */
    fun accountGetActiveOffers(offset: Int? = null, count: Int? = null):
            VKRequest<AccountGetActiveOffersResponseDto> =
            NewApiRequest("account.getActiveOffers") {
        GsonHolder.gson.parse<AccountGetActiveOffersResponseDto>(it)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
    }

    /**
     * Gets settings of the user in this application.
     *
     * @param userId - User ID whose settings information shall be got. By default_ current user.
     * @return [VKRequest] with [Int]
     */
    fun accountGetAppPermissions(userId: UserId? = null): VKRequest<Int> =
            NewApiRequest("account.getAppPermissions") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 1) }
    }

    /**
     * Returns a user's blacklist.
     *
     * @param offset - Offset needed to return a specific subset of results.
     * @param count - Number of results to return.
     * @return [VKRequest] with [AccountGetBannedResponseDto]
     */
    fun accountGetBanned(offset: Int? = null, count: Int? = null):
            VKRequest<AccountGetBannedResponseDto> = NewApiRequest("account.getBanned") {
        GsonHolder.gson.parse<AccountGetBannedResponseDto>(it)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
    }

    /**
     * Returns non-null values of user counters.
     *
     * @param filter - Counters to be returned.
     * @return [VKRequest] with [AccountAccountCountersDto]
     */
    fun accountGetCounters(filter: List<AccountCountersFilterDto>? = null):
            VKRequest<AccountAccountCountersDto> = NewApiRequest("account.getCounters") {
        GsonHolder.gson.parse<AccountAccountCountersDto>(it)
    }
    .apply {
        val filterJsonConverted = filter?.map {
            it.value
        }
        filterJsonConverted?.let { addParam("filter", it) }
    }

    /**
     * Returns current account info.
     *
     * @param fields - Fields to return. Possible values_ *'country' - user country,,
     * *'https_required' - is "HTTPS only" option enabled,, *'own_posts_default' - is "Show my posts
     * only" option is enabled,, *'no_wall_replies' - are wall replies disabled or not,, *'intro' - is
     * intro passed by user or not,, *'lang' - user language. By default_ all.
     * @return [VKRequest] with [AccountInfoDto]
     */
    fun accountGetInfo(fields: List<AccountGetInfoFieldsDto>? = null): VKRequest<AccountInfoDto> =
            NewApiRequest("account.getInfo") {
        GsonHolder.gson.parse<AccountInfoDto>(it)
    }
    .apply {
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns the current account info.
     *
     * @return [VKRequest] with [AccountUserSettingsDto]
     */
    fun accountGetProfileInfo(): VKRequest<AccountUserSettingsDto> =
            NewApiRequest("account.getProfileInfo") {
        GsonHolder.gson.parse<AccountUserSettingsDto>(it)
    }

    /**
     * Gets settings of push notifications.
     *
     * @param deviceId - Unique device ID.
     * @return [VKRequest] with [AccountPushSettingsDto]
     */
    fun accountGetPushSettings(deviceId: String? = null): VKRequest<AccountPushSettingsDto> =
            NewApiRequest("account.getPushSettings") {
        GsonHolder.gson.parse<AccountPushSettingsDto>(it)
    }
    .apply {
        deviceId?.let { addParam("device_id", it) }
    }

    /**
     * Subscribes an iOS/Android/Windows Phone-based device to receive push notifications
     *
     * @param token - Device token used to send notifications. (for mpns, the token shall be URL for
     * sending of notifications)
     * @param deviceId - Unique device ID.
     * @param deviceModel - String name of device model.
     * @param deviceYear - Device year.
     * @param systemVersion - String version of device operating system.
     * @param settings - Push settings in a [vk.com/dev/push_settings|special format].
     * @param sandbox
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun accountRegisterDevice(
        token: String,
        deviceId: String,
        deviceModel: String? = null,
        deviceYear: Int? = null,
        systemVersion: String? = null,
        settings: String? = null,
        sandbox: Boolean? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("account.registerDevice") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("token", token)
        addParam("device_id", deviceId)
        deviceModel?.let { addParam("device_model", it) }
        deviceYear?.let { addParam("device_year", it) }
        systemVersion?.let { addParam("system_version", it) }
        settings?.let { addParam("settings", it) }
        sandbox?.let { addParam("sandbox", it) }
    }

    /**
     * Edits current profile info.
     *
     * @param firstName - User first name.
     * @param lastName - User last name.
     * @param maidenName - User maiden name (female only)
     * @param screenName - User screen name.
     * @param cancelRequestId - ID of the name change request to be canceled. If this parameter is
     * sent, all the others are ignored.
     * @param sex - User sex. Possible values_ , * '1' - female,, * '2' - male.
     * @param relation - User relationship status. Possible values_ , * '1' - single,, * '2' - in a
     * relationship,, * '3' - engaged,, * '4' - married,, * '5' - it's complicated,, * '6' - actively
     * searching,, * '7' - in love,, * '0' - not specified.
     * @param relationPartnerId - ID of the relationship partner.
     * @param bdate - User birth date, format_ DD.MM.YYYY.
     * @param bdateVisibility - Birth date visibility. Returned values_ , * '1' - show birth date,,
     * * '2' - show only month and day,, * '0' - hide birth date.
     * @param homeTown - User home town.
     * @param countryId - User country.
     * @param cityId - User city.
     * @param status - Status text.
     * @return [VKRequest] with [AccountSaveProfileInfoResponseDto]
     */
    fun accountSaveProfileInfo(
        firstName: String? = null,
        lastName: String? = null,
        maidenName: String? = null,
        screenName: String? = null,
        cancelRequestId: Int? = null,
        sex: AccountSaveProfileInfoSexDto? = null,
        relation: AccountSaveProfileInfoRelationDto? = null,
        relationPartnerId: UserId? = null,
        bdate: String? = null,
        bdateVisibility: AccountSaveProfileInfoBdateVisibilityDto? = null,
        homeTown: String? = null,
        countryId: Int? = null,
        cityId: Int? = null,
        status: String? = null
    ): VKRequest<AccountSaveProfileInfoResponseDto> = NewApiRequest("account.saveProfileInfo") {
        GsonHolder.gson.parse<AccountSaveProfileInfoResponseDto>(it)
    }
    .apply {
        firstName?.let { addParam("first_name", it) }
        lastName?.let { addParam("last_name", it) }
        maidenName?.let { addParam("maiden_name", it) }
        screenName?.let { addParam("screen_name", it) }
        cancelRequestId?.let { addParam("cancel_request_id", it, min = 0) }
        sex?.let { addParam("sex", it.value) }
        relation?.let { addParam("relation", it.value) }
        relationPartnerId?.let { addParam("relation_partner_id", it, min = 0) }
        bdate?.let { addParam("bdate", it) }
        bdateVisibility?.let { addParam("bdate_visibility", it.value) }
        homeTown?.let { addParam("home_town", it) }
        countryId?.let { addParam("country_id", it, min = 0) }
        cityId?.let { addParam("city_id", it, min = 0) }
        status?.let { addParam("status", it) }
    }

    /**
     * Allows to edit the current account info.
     *
     * @param name - Setting name.
     * @param value - Setting value.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun accountSetInfo(name: AccountSetInfoNameDto? = null, value: String? = null):
            VKRequest<BaseOkResponseDto> = NewApiRequest("account.setInfo") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        name?.let { addParam("name", it.value) }
        value?.let { addParam("value", it) }
    }

    /**
     * Marks a current user as offline.
     *
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun accountSetOffline(): VKRequest<BaseOkResponseDto> = NewApiRequest("account.setOffline") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }

    /**
     * Marks the current user as online for 15 minutes.
     *
     * @param voip - '1' if videocalls are available for current device.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun accountSetOnline(voip: Boolean? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("account.setOnline") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        voip?.let { addParam("voip", it) }
    }

    /**
     * Change push settings.
     *
     * @param deviceId - Unique device ID.
     * @param settings - Push settings in a [vk.com/dev/push_settings|special format].
     * @param key - Notification key.
     * @param value - New value for the key in a [vk.com/dev/push_settings|special format].
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun accountSetPushSettings(
        deviceId: String,
        settings: String? = null,
        key: String? = null,
        value: List<String>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("account.setPushSettings") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("device_id", deviceId)
        settings?.let { addParam("settings", it) }
        key?.let { addParam("key", it) }
        value?.let { addParam("value", it) }
    }

    /**
     * Mutes push notifications for the set period of time.
     *
     * @param deviceId - Unique device ID.
     * @param time - Time in seconds for what notifications should be disabled. '-1' to disable
     * forever.
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'Chat ID', e.g. '2000000001'. For community_ '- Community ID', e.g. '-12345'. "
     * @param sound - '1' - to enable sound in this dialog, '0' - to disable sound. Only if
     * 'peer_id' contains user or community ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun accountSetSilenceMode(
        deviceId: String? = null,
        time: Int? = null,
        peerId: UserId? = null,
        sound: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("account.setSilenceMode") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        deviceId?.let { addParam("device_id", it) }
        time?.let { addParam("time", it) }
        peerId?.let { addParam("peer_id", it) }
        sound?.let { addParam("sound", it) }
    }

    /**
     * @param ownerId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun accountUnban(ownerId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("account.unban") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Unsubscribes a device from push notifications.
     *
     * @param deviceId - Unique device ID.
     * @param sandbox
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun accountUnregisterDevice(deviceId: String? = null, sandbox: Boolean? = null):
            VKRequest<BaseOkResponseDto> = NewApiRequest("account.unregisterDevice") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        deviceId?.let { addParam("device_id", it) }
        sandbox?.let { addParam("sandbox", it) }
    }

    object AccountChangePasswordRestrictions {
        const val NEW_PASSWORD_MIN_LENGTH: Int = 6
    }

    object AccountGetActiveOffersRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object AccountGetAppPermissionsRestrictions {
        const val USER_ID_MIN: Long = 1
    }

    object AccountGetBannedRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200
    }

    object AccountSaveProfileInfoRestrictions {
        const val CANCEL_REQUEST_ID_MIN: Long = 0

        const val SEX_MIN: Long = 0

        const val RELATION_MIN: Long = 0

        const val RELATION_PARTNER_ID_MIN: Long = 0

        const val BDATE_VISIBILITY_MIN: Long = 0

        const val COUNTRY_ID_MIN: Long = 0

        const val CITY_ID_MIN: Long = 0
    }
}
