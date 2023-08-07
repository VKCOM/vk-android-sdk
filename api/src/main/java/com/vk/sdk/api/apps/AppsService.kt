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
package com.vk.sdk.api.apps

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.apps.dto.AppsAppFieldsDto
import com.vk.sdk.api.apps.dto.AppsCatalogListDto
import com.vk.sdk.api.apps.dto.AppsCreatedGroupResponseDto
import com.vk.sdk.api.apps.dto.AppsGetCatalogFilterDto
import com.vk.sdk.api.apps.dto.AppsGetCatalogSortDto
import com.vk.sdk.api.apps.dto.AppsGetFriendsListExtendedResponseDto
import com.vk.sdk.api.apps.dto.AppsGetFriendsListExtendedTypeDto
import com.vk.sdk.api.apps.dto.AppsGetFriendsListResponseDto
import com.vk.sdk.api.apps.dto.AppsGetFriendsListTypeDto
import com.vk.sdk.api.apps.dto.AppsGetLastUploadedVersionResponseDto
import com.vk.sdk.api.apps.dto.AppsGetLeaderboardExtendedResponseDto
import com.vk.sdk.api.apps.dto.AppsGetLeaderboardExtendedTypeDto
import com.vk.sdk.api.apps.dto.AppsGetLeaderboardResponseDto
import com.vk.sdk.api.apps.dto.AppsGetLeaderboardTypeDto
import com.vk.sdk.api.apps.dto.AppsGetMiniAppPoliciesResponseDto
import com.vk.sdk.api.apps.dto.AppsGetPlatformDto
import com.vk.sdk.api.apps.dto.AppsGetResponseDto
import com.vk.sdk.api.apps.dto.AppsGetScopesResponseDto
import com.vk.sdk.api.apps.dto.AppsGetScopesTypeDto
import com.vk.sdk.api.apps.dto.AppsIsNotificationsAllowedResponseDto
import com.vk.sdk.api.apps.dto.AppsSendRequestTypeDto
import com.vk.sdk.api.apps.dto.AppsTestingGroupDto
import com.vk.sdk.api.apps.dto.AppsUpdateMetaForTestingGroupPlatformsDto
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.users.dto.UsersFieldsDto
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class AppsService {
    /**
     * @param userIds
     * @param groupId
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun appsAddUsersToTestingGroup(userIds: List<UserId>, groupId: UserId):
            VKRequest<BaseBoolIntDto> = NewApiRequest("apps.addUsersToTestingGroup") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("user_ids", userIds, min = 1)
        addParam("group_id", groupId, min = 1, max = 25)
    }

    /**
     * Deletes all request notifications from the current app.
     *
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun appsDeleteAppRequests(): VKRequest<BaseOkResponseDto> =
            NewApiRequest("apps.deleteAppRequests") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }

    /**
     * Returns applications data.
     *
     * @param appId - Application ID
     * @param appIds - List of application ID
     * @param platform - platform. Possible values_ *'ios' - iOS,, *'android' - Android,,
     * *'winphone' - Windows Phone,, *'web' - ---------- -- vk.com. By default_ 'web'.
     * @param extended
     * @param returnFriends
     * @param fields - Profile fields to return. Sample values_ 'nickname', 'screen_name', 'sex',
     * 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big',
     * 'has_mobile', 'contacts', 'education', 'online', 'counters', 'relation', 'last_seen',
     * 'activity', 'can_write_private_message', 'can_see_all_posts', 'can_post', 'universities', (only
     * if return_friends - 1)
     * @param nameCase - Case for declension of user name and surname_ 'nom' - nominative
     * (default),, 'gen' - genitive,, 'dat' - dative,, 'acc' - accusative,, 'ins' - instrumental,,
     * 'abl' - prepositional. (only if 'return_friends' = '1')
     * @param appFields - List of app fields to return. Fields 'id', 'type' and 'title' will always
     * be in response. Leave this field empty to get all fields
     * @return [VKRequest] with [AppsGetResponseDto]
     */
    fun appsGet(
        appId: Int? = null,
        appIds: List<Int>? = null,
        platform: AppsGetPlatformDto? = null,
        extended: Boolean? = null,
        returnFriends: Boolean? = null,
        fields: List<UsersFieldsDto>? = null,
        nameCase: String? = null,
        appFields: List<AppsAppFieldsDto>? = null
    ): VKRequest<AppsGetResponseDto> = NewApiRequest("apps.get") {
        GsonHolder.gson.parse<AppsGetResponseDto>(it)
    }
    .apply {
        appId?.let { addParam("app_id", it, min = 0) }
        appIds?.let { addParam("app_ids", it) }
        platform?.let { addParam("platform", it.value) }
        extended?.let { addParam("extended", it) }
        returnFriends?.let { addParam("return_friends", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it) }
        val appFieldsJsonConverted = appFields?.map {
            it.value
        }
        appFieldsJsonConverted?.let { addParam("app_fields", it) }
    }

    /**
     * Returns a list of applications (apps) available to users in the App Catalog.
     *
     * @param sort - Sort order_ 'popular_today' - popular for one day (default), 'visitors' - by
     * visitors number , 'create_date' - by creation date, 'growth_rate' - by growth rate,
     * 'popular_week' - popular for one week
     * @param offset - Offset required to return a specific subset of apps.
     * @param count - Number of apps to return.
     * @param platform
     * @param extended - '1' - to return additional fields 'screenshots', 'MAU', 'catalog_position',
     * and 'international'. If set, 'count' must be less than or equal to '100'. '0' - not to return
     * additional fields (default).
     * @param returnFriends
     * @param fields
     * @param nameCase
     * @param q - Search query string.
     * @param genreId
     * @param filter - 'installed' - to return list of installed apps (only for mobile platform).
     * @return [VKRequest] with [AppsCatalogListDto]
     */
    fun appsGetCatalog(
        sort: AppsGetCatalogSortDto? = null,
        offset: Int? = null,
        count: Int? = null,
        platform: String? = null,
        extended: Boolean? = null,
        returnFriends: Boolean? = null,
        fields: List<UsersFieldsDto>? = null,
        nameCase: String? = null,
        q: String? = null,
        genreId: Int? = null,
        filter: AppsGetCatalogFilterDto? = null
    ): VKRequest<AppsCatalogListDto> = NewApiRequest("apps.getCatalog") {
        GsonHolder.gson.parse<AppsCatalogListDto>(it)
    }
    .apply {
        sort?.let { addParam("sort", it.value) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        platform?.let { addParam("platform", it) }
        extended?.let { addParam("extended", it) }
        returnFriends?.let { addParam("return_friends", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it) }
        q?.let { addParam("q", it) }
        genreId?.let { addParam("genre_id", it, min = 0) }
        filter?.let { addParam("filter", it.value) }
    }

    /**
     * Creates friends list for requests and invites in current app.
     *
     * @param extended
     * @param count - List size.
     * @param offset
     * @param type - List type. Possible values_ * 'invite' - available for invites (don't play the
     * game),, * 'request' - available for request (play the game). By default_ 'invite'.
     * @param fields - Additional profile fields, see [vk.com/dev/fields|description].
     * @param query - Search query string (e.g., 'Vasya Babich').
     * @return [VKRequest] with [AppsGetFriendsListResponseDto]
     */
    fun appsGetFriendsList(
        extended: Boolean? = null,
        count: Int? = null,
        offset: Int? = null,
        type: AppsGetFriendsListTypeDto? = null,
        fields: List<UsersFieldsDto>? = null,
        query: String? = null
    ): VKRequest<AppsGetFriendsListResponseDto> = NewApiRequest("apps.getFriendsList") {
        GsonHolder.gson.parse<AppsGetFriendsListResponseDto>(it)
    }
    .apply {
        extended?.let { addParam("extended", it) }
        count?.let { addParam("count", it, min = 0, max = 5000) }
        offset?.let { addParam("offset", it, min = 0) }
        type?.let { addParam("type", it.value) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        query?.let { addParam("query", it, maxLength = 256) }
    }

    /**
     * Creates friends list for requests and invites in current app.
     *
     * @param count - List size.
     * @param offset
     * @param type - List type. Possible values_ * 'invite' - available for invites (don't play the
     * game),, * 'request' - available for request (play the game). By default_ 'invite'.
     * @param fields - Additional profile fields, see [vk.com/dev/fields|description].
     * @param query - Search query string (e.g., 'Vasya Babich').
     * @return [VKRequest] with [AppsGetFriendsListExtendedResponseDto]
     */
    fun appsGetFriendsListExtended(
        count: Int? = null,
        offset: Int? = null,
        type: AppsGetFriendsListExtendedTypeDto? = null,
        fields: List<UsersFieldsDto>? = null,
        query: String? = null
    ): VKRequest<AppsGetFriendsListExtendedResponseDto> = NewApiRequest("apps.getFriendsList") {
        GsonHolder.gson.parse<AppsGetFriendsListExtendedResponseDto>(it)
    }
    .apply {
        addParam("extended", true)
        count?.let { addParam("count", it, min = 0, max = 5000) }
        offset?.let { addParam("offset", it, min = 0) }
        type?.let { addParam("type", it.value) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        query?.let { addParam("query", it, maxLength = 256) }
    }

    /**
     * @return [VKRequest] with [AppsGetLastUploadedVersionResponseDto]
     */
    fun appsGetLastUploadedVersion(): VKRequest<AppsGetLastUploadedVersionResponseDto> =
            NewApiRequest("apps.getLastUploadedVersion") {
        GsonHolder.gson.parse<AppsGetLastUploadedVersionResponseDto>(it)
    }

    /**
     * Returns players rating in the game.
     *
     * @param type - Leaderboard type. Possible values_ *'level' - by level,, *'points' - by mission
     * points,, *'score' - by score ().
     * @param global - Rating type. Possible values_ *'1' - global rating among all players,, *'0' -
     * rating among user friends.
     * @param extended - 1 - to return additional info about users
     * @return [VKRequest] with [AppsGetLeaderboardResponseDto]
     */
    fun appsGetLeaderboard(
        type: AppsGetLeaderboardTypeDto,
        global: Boolean? = null,
        extended: Boolean? = null
    ): VKRequest<AppsGetLeaderboardResponseDto> = NewApiRequest("apps.getLeaderboard") {
        GsonHolder.gson.parse<AppsGetLeaderboardResponseDto>(it)
    }
    .apply {
        addParam("type", type.value)
        global?.let { addParam("global", it) }
        extended?.let { addParam("extended", it) }
    }

    /**
     * Returns players rating in the game.
     *
     * @param type - Leaderboard type. Possible values_ *'level' - by level,, *'points' - by mission
     * points,, *'score' - by score ().
     * @param global - Rating type. Possible values_ *'1' - global rating among all players,, *'0' -
     * rating among user friends.
     * @return [VKRequest] with [AppsGetLeaderboardExtendedResponseDto]
     */
    fun appsGetLeaderboardExtended(type: AppsGetLeaderboardExtendedTypeDto, global: Boolean? =
            null): VKRequest<AppsGetLeaderboardExtendedResponseDto> =
            NewApiRequest("apps.getLeaderboard") {
        GsonHolder.gson.parse<AppsGetLeaderboardExtendedResponseDto>(it)
    }
    .apply {
        addParam("type", type.value)
        global?.let { addParam("global", it) }
        addParam("extended", true)
    }

    /**
     * Returns policies and terms given to a mini app.
     *
     * @param appId - Mini App ID
     * @return [VKRequest] with [AppsGetMiniAppPoliciesResponseDto]
     */
    fun appsGetMiniAppPolicies(appId: Int): VKRequest<AppsGetMiniAppPoliciesResponseDto> =
            NewApiRequest("apps.getMiniAppPolicies") {
        GsonHolder.gson.parse<AppsGetMiniAppPoliciesResponseDto>(it)
    }
    .apply {
        addParam("app_id", appId, min = 0)
    }

    /**
     * Returns scopes for auth
     *
     * @param type
     * @return [VKRequest] with [AppsGetScopesResponseDto]
     */
    fun appsGetScopes(type: AppsGetScopesTypeDto? = null): VKRequest<AppsGetScopesResponseDto> =
            NewApiRequest("apps.getScopes") {
        GsonHolder.gson.parse<AppsGetScopesResponseDto>(it)
    }
    .apply {
        type?.let { addParam("type", it.value) }
    }

    /**
     * Returns user score in app
     *
     * @param userId
     * @return [VKRequest] with [Int]
     */
    fun appsGetScore(userId: UserId? = null): VKRequest<Int> = NewApiRequest("apps.getScore") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 1) }
    }

    /**
     * @param groupId
     * @return [VKRequest] with [Unit]
     */
    fun appsGetTestingGroups(groupId: UserId? = null): VKRequest<List<AppsTestingGroupDto>> =
            NewApiRequest("apps.getTestingGroups") {
        GsonHolder.gson.parseList<AppsTestingGroupDto>(it)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 1, max = 25) }
    }

    /**
     * @param userId
     * @return [VKRequest] with [AppsIsNotificationsAllowedResponseDto]
     */
    fun appsIsNotificationsAllowed(userId: UserId? = null):
            VKRequest<AppsIsNotificationsAllowedResponseDto> =
            NewApiRequest("apps.isNotificationsAllowed") {
        GsonHolder.gson.parse<AppsIsNotificationsAllowedResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 1) }
    }

    /**
     * @param promoId - Id of game promo action
     * @param userId
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun appsPromoHasActiveGift(promoId: Int, userId: UserId? = null): VKRequest<BaseBoolIntDto> =
            NewApiRequest("apps.promoHasActiveGift") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("promo_id", promoId, min = 0)
        userId?.let { addParam("user_id", it, min = 0) }
    }

    /**
     * @param promoId - Id of game promo action
     * @param userId
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun appsPromoUseGift(promoId: Int, userId: UserId? = null): VKRequest<BaseBoolIntDto> =
            NewApiRequest("apps.promoUseGift") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("promo_id", promoId, min = 0)
        userId?.let { addParam("user_id", it, min = 0) }
    }

    /**
     * @param groupId
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun appsRemoveTestingGroup(groupId: UserId): VKRequest<BaseBoolIntDto> =
            NewApiRequest("apps.removeTestingGroup") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1, max = 25)
    }

    /**
     * @param userIds
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun appsRemoveUsersFromTestingGroups(userIds: List<UserId>): VKRequest<BaseBoolIntDto> =
            NewApiRequest("apps.removeUsersFromTestingGroups") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("user_ids", userIds)
    }

    /**
     * Sends a request to another user in an app that uses VK authorization.
     *
     * @param userId - id of the user to send a request
     * @param text - request text
     * @param type - request type. Values_ 'invite' - if the request is sent to a user who does not
     * have the app installed,, 'request' - if a user has already installed the app
     * @param name
     * @param key - special string key to be sent with the request
     * @param separate
     * @return [VKRequest] with [Int]
     */
    fun appsSendRequest(
        userId: UserId,
        text: String? = null,
        type: AppsSendRequestTypeDto? = null,
        name: String? = null,
        key: String? = null,
        separate: Boolean? = null
    ): VKRequest<Int> = NewApiRequest("apps.sendRequest") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        text?.let { addParam("text", it) }
        type?.let { addParam("type", it.value) }
        name?.let { addParam("name", it, maxLength = 128) }
        key?.let { addParam("key", it) }
        separate?.let { addParam("separate", it) }
    }

    /**
     * @param webview
     * @param name
     * @param platforms
     * @param groupId
     * @param userIds
     * @return [VKRequest] with [AppsCreatedGroupResponseDto]
     */
    fun appsUpdateMetaForTestingGroup(
        webview: String,
        name: String,
        platforms: List<AppsUpdateMetaForTestingGroupPlatformsDto>,
        groupId: UserId? = null,
        userIds: List<UserId>? = null
    ): VKRequest<AppsCreatedGroupResponseDto> = NewApiRequest("apps.updateMetaForTestingGroup") {
        GsonHolder.gson.parse<AppsCreatedGroupResponseDto>(it)
    }
    .apply {
        addParam("webview", webview)
        addParam("name", name)
        val platformsJsonConverted = platforms.map {
            it.value
        }
        addParam("platforms", platformsJsonConverted)
        groupId?.let { addParam("group_id", it, min = 1, max = 25) }
        userIds?.let { addParam("user_ids", it, min = 1) }
    }

    object AppsAddUsersToTestingGroupRestrictions {
        const val USER_IDS_MIN: Long = 1

        const val GROUP_ID_MIN: Long = 1

        const val GROUP_ID_MAX: Long = 25
    }

    object AppsGetRestrictions {
        const val APP_ID_MIN: Long = 0
    }

    object AppsGetCatalogRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val GENRE_ID_MIN: Long = 0
    }

    object AppsGetFriendsListRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 5000

        const val OFFSET_MIN: Long = 0

        const val QUERY_MAX_LENGTH: Int = 256
    }

    object AppsGetFriendsListExtendedRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 5000

        const val OFFSET_MIN: Long = 0

        const val QUERY_MAX_LENGTH: Int = 256
    }

    object AppsGetMiniAppPoliciesRestrictions {
        const val APP_ID_MIN: Long = 0
    }

    object AppsGetScoreRestrictions {
        const val USER_ID_MIN: Long = 1
    }

    object AppsGetTestingGroupsRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val GROUP_ID_MAX: Long = 25
    }

    object AppsIsNotificationsAllowedRestrictions {
        const val USER_ID_MIN: Long = 1
    }

    object AppsPromoHasActiveGiftRestrictions {
        const val PROMO_ID_MIN: Long = 0

        const val USER_ID_MIN: Long = 0
    }

    object AppsPromoUseGiftRestrictions {
        const val PROMO_ID_MIN: Long = 0

        const val USER_ID_MIN: Long = 0
    }

    object AppsRemoveTestingGroupRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val GROUP_ID_MAX: Long = 25
    }

    object AppsSendRequestRestrictions {
        const val USER_ID_MIN: Long = 1

        const val NAME_MAX_LENGTH: Int = 128
    }

    object AppsUpdateMetaForTestingGroupRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val GROUP_ID_MAX: Long = 25

        const val USER_IDS_MIN: Long = 1
    }
}
