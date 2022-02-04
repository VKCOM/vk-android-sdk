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
import com.vk.sdk.api.apps.dto.AppsCatalogList
import com.vk.sdk.api.apps.dto.AppsGetCatalogFilter
import com.vk.sdk.api.apps.dto.AppsGetCatalogSort
import com.vk.sdk.api.apps.dto.AppsGetFriendsListExtendedResponse
import com.vk.sdk.api.apps.dto.AppsGetFriendsListExtendedType
import com.vk.sdk.api.apps.dto.AppsGetFriendsListResponse
import com.vk.sdk.api.apps.dto.AppsGetFriendsListType
import com.vk.sdk.api.apps.dto.AppsGetLeaderboardExtendedResponse
import com.vk.sdk.api.apps.dto.AppsGetLeaderboardExtendedType
import com.vk.sdk.api.apps.dto.AppsGetLeaderboardResponse
import com.vk.sdk.api.apps.dto.AppsGetLeaderboardType
import com.vk.sdk.api.apps.dto.AppsGetMiniAppPoliciesResponse
import com.vk.sdk.api.apps.dto.AppsGetNameCase
import com.vk.sdk.api.apps.dto.AppsGetPlatform
import com.vk.sdk.api.apps.dto.AppsGetResponse
import com.vk.sdk.api.apps.dto.AppsGetScopesResponse
import com.vk.sdk.api.apps.dto.AppsGetScopesType
import com.vk.sdk.api.apps.dto.AppsSendRequestType
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class AppsService {
    /**
     * Deletes all request notifications from the current app.
     *
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun appsDeleteAppRequests(): VKRequest<BaseOkResponse> =
            NewApiRequest("apps.deleteAppRequests") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }

    /**
     * Returns applications data.
     *
     * @param appId - Application ID
     * @param appIds - List of application ID
     * @param platform - platform. Possible values_ *'ios' - iOS,, *'android' - Android,,
     * *'winphone' - Windows Phone,, *'web' - ---------- -- vk.com. By default_ 'web'.
     * @param returnFriends
     * @param fields - Profile fields to return. Sample values_ 'nickname', 'screen_name', 'sex',
     * 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big',
     * 'has_mobile', 'contacts', 'education', 'online', 'counters', 'relation', 'last_seen',
     * 'activity', 'can_write_private_message', 'can_see_all_posts', 'can_post', 'universities', (only
     * if return_friends - 1)
     * @param nameCase - Case for declension of user name and surname_ 'nom' - nominative
     * (default),, 'gen' - genitive,, 'dat' - dative,, 'acc' - accusative,, 'ins' - instrumental,,
     * 'abl' - prepositional. (only if 'return_friends' = '1')
     * @return [VKRequest] with [AppsGetResponse]
     */
    fun appsGet(
        appId: Int? = null,
        appIds: List<String>? = null,
        platform: AppsGetPlatform? = null,
        returnFriends: Boolean? = null,
        fields: List<UsersFields>? = null,
        nameCase: AppsGetNameCase? = null
    ): VKRequest<AppsGetResponse> = NewApiRequest("apps.get") {
        GsonHolder.gson.fromJson(it, AppsGetResponse::class.java)
    }
    .apply {
        appId?.let { addParam("app_id", it, min = 0) }
        appIds?.let { addParam("app_ids", it) }
        platform?.let { addParam("platform", it.value) }
        returnFriends?.let { addParam("return_friends", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it.value) }
    }

    /**
     * Returns a list of applications (apps) available to users in the App Catalog.
     *
     * @param count - Number of apps to return.
     * @param sort - Sort order_ 'popular_today' - popular for one day (default), 'visitors' - by
     * visitors number , 'create_date' - by creation date, 'growth_rate' - by growth rate,
     * 'popular_week' - popular for one week
     * @param offset - Offset required to return a specific subset of apps.
     * @param platform
     * @param returnFriends
     * @param fields
     * @param nameCase
     * @param q - Search query string.
     * @param genreId
     * @param filter - 'installed' - to return list of installed apps (only for mobile platform).
     * @return [VKRequest] with [AppsCatalogList]
     */
    fun appsGetCatalog(
        count: Int,
        sort: AppsGetCatalogSort? = null,
        offset: Int? = null,
        platform: String? = null,
        returnFriends: Boolean? = null,
        fields: List<UsersFields>? = null,
        nameCase: String? = null,
        q: String? = null,
        genreId: Int? = null,
        filter: AppsGetCatalogFilter? = null
    ): VKRequest<AppsCatalogList> = NewApiRequest("apps.getCatalog") {
        GsonHolder.gson.fromJson(it, AppsCatalogList::class.java)
    }
    .apply {
        addParam("count", count, min = 0)
        sort?.let { addParam("sort", it.value) }
        offset?.let { addParam("offset", it, min = 0) }
        platform?.let { addParam("platform", it) }
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
     * @param count - List size.
     * @param offset
     * @param type - List type. Possible values_ * 'invite' - available for invites (don't play the
     * game),, * 'request' - available for request (play the game). By default_ 'invite'.
     * @param fields - Additional profile fields, see [vk.com/dev/fields|description].
     * @return [VKRequest] with [AppsGetFriendsListResponse]
     */
    fun appsGetFriendsList(
        count: Int? = null,
        offset: Int? = null,
        type: AppsGetFriendsListType? = null,
        fields: List<UsersFields>? = null
    ): VKRequest<AppsGetFriendsListResponse> = NewApiRequest("apps.getFriendsList") {
        GsonHolder.gson.fromJson(it, AppsGetFriendsListResponse::class.java)
    }
    .apply {
        count?.let { addParam("count", it, min = 0, max = 5000) }
        offset?.let { addParam("offset", it, min = 0) }
        type?.let { addParam("type", it.value) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Creates friends list for requests and invites in current app.
     *
     * @param count - List size.
     * @param offset
     * @param type - List type. Possible values_ * 'invite' - available for invites (don't play the
     * game),, * 'request' - available for request (play the game). By default_ 'invite'.
     * @param fields - Additional profile fields, see [vk.com/dev/fields|description].
     * @return [VKRequest] with [AppsGetFriendsListExtendedResponse]
     */
    fun appsGetFriendsListExtended(
        count: Int? = null,
        offset: Int? = null,
        type: AppsGetFriendsListExtendedType? = null,
        fields: List<UsersFields>? = null
    ): VKRequest<AppsGetFriendsListExtendedResponse> = NewApiRequest("apps.getFriendsList") {
        GsonHolder.gson.fromJson(it, AppsGetFriendsListExtendedResponse::class.java)
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
    }

    /**
     * Returns players rating in the game.
     *
     * @param type - Leaderboard type. Possible values_ *'level' - by level,, *'points' - by mission
     * points,, *'score' - by score ().
     * @param global - Rating type. Possible values_ *'1' - global rating among all players,, *'0' -
     * rating among user friends.
     * @return [VKRequest] with [AppsGetLeaderboardResponse]
     */
    fun appsGetLeaderboard(type: AppsGetLeaderboardType, global: Boolean? = null):
            VKRequest<AppsGetLeaderboardResponse> = NewApiRequest("apps.getLeaderboard") {
        GsonHolder.gson.fromJson(it, AppsGetLeaderboardResponse::class.java)
    }
    .apply {
        addParam("type", type.value)
        global?.let { addParam("global", it) }
    }

    /**
     * Returns players rating in the game.
     *
     * @param type - Leaderboard type. Possible values_ *'level' - by level,, *'points' - by mission
     * points,, *'score' - by score ().
     * @param global - Rating type. Possible values_ *'1' - global rating among all players,, *'0' -
     * rating among user friends.
     * @return [VKRequest] with [AppsGetLeaderboardExtendedResponse]
     */
    fun appsGetLeaderboardExtended(type: AppsGetLeaderboardExtendedType, global: Boolean? = null):
            VKRequest<AppsGetLeaderboardExtendedResponse> = NewApiRequest("apps.getLeaderboard") {
        GsonHolder.gson.fromJson(it, AppsGetLeaderboardExtendedResponse::class.java)
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
     * @return [VKRequest] with [AppsGetMiniAppPoliciesResponse]
     */
    fun appsGetMiniAppPolicies(appId: Int): VKRequest<AppsGetMiniAppPoliciesResponse> =
            NewApiRequest("apps.getMiniAppPolicies") {
        GsonHolder.gson.fromJson(it, AppsGetMiniAppPoliciesResponse::class.java)
    }
    .apply {
        addParam("app_id", appId, min = 0)
    }

    /**
     * Returns scopes for auth
     *
     * @param type
     * @return [VKRequest] with [AppsGetScopesResponse]
     */
    fun appsGetScopes(type: AppsGetScopesType? = null): VKRequest<AppsGetScopesResponse> =
            NewApiRequest("apps.getScopes") {
        GsonHolder.gson.fromJson(it, AppsGetScopesResponse::class.java)
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
    fun appsGetScore(userId: UserId): VKRequest<Int> = NewApiRequest("apps.getScore") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }
    .apply {
        addParam("user_id", userId, min = 1)
    }

    /**
     * @param promoId - Id of game promo action
     * @param userId
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun appsPromoHasActiveGift(promoId: Int, userId: UserId? = null): VKRequest<BaseBoolInt> =
            NewApiRequest("apps.promoHasActiveGift") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("promo_id", promoId, min = 0)
        userId?.let { addParam("user_id", it, min = 0) }
    }

    /**
     * @param promoId - Id of game promo action
     * @param userId
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun appsPromoUseGift(promoId: Int, userId: UserId? = null): VKRequest<BaseBoolInt> =
            NewApiRequest("apps.promoUseGift") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
    }
    .apply {
        addParam("promo_id", promoId, min = 0)
        userId?.let { addParam("user_id", it, min = 0) }
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
        type: AppsSendRequestType? = null,
        name: String? = null,
        key: String? = null,
        separate: Boolean? = null
    ): VKRequest<Int> = NewApiRequest("apps.sendRequest") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        text?.let { addParam("text", it) }
        type?.let { addParam("type", it.value) }
        name?.let { addParam("name", it, maxLength = 128) }
        key?.let { addParam("key", it) }
        separate?.let { addParam("separate", it) }
    }
}
