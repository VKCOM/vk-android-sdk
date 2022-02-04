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
package com.vk.sdk.api.friends

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.friends.dto.FriendsAddListResponse
import com.vk.sdk.api.friends.dto.FriendsAddResponse
import com.vk.sdk.api.friends.dto.FriendsDeleteResponse
import com.vk.sdk.api.friends.dto.FriendsFriendExtendedStatus
import com.vk.sdk.api.friends.dto.FriendsFriendStatus
import com.vk.sdk.api.friends.dto.FriendsGetFieldsResponse
import com.vk.sdk.api.friends.dto.FriendsGetListsResponse
import com.vk.sdk.api.friends.dto.FriendsGetNameCase
import com.vk.sdk.api.friends.dto.FriendsGetOrder
import com.vk.sdk.api.friends.dto.FriendsGetRequestsResponse
import com.vk.sdk.api.friends.dto.FriendsGetRequestsSort
import com.vk.sdk.api.friends.dto.FriendsGetSuggestionsFilter
import com.vk.sdk.api.friends.dto.FriendsGetSuggestionsNameCase
import com.vk.sdk.api.friends.dto.FriendsGetSuggestionsResponse
import com.vk.sdk.api.friends.dto.FriendsSearchNameCase
import com.vk.sdk.api.friends.dto.FriendsSearchResponse
import com.vk.sdk.api.friends.dto.FriendsUserXtrPhone
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class FriendsService {
    /**
     * Approves or creates a friend request.
     *
     * @param userId - ID of the user whose friend request will be approved or to whom a friend
     * request will be sent.
     * @param text - Text of the message (up to 500 characters) for the friend request, if any.
     * @param follow - '1' to pass an incoming request to followers list.
     * @return [VKRequest] with [FriendsAddResponse]
     */
    fun friendsAdd(
        userId: UserId? = null,
        text: String? = null,
        follow: Boolean? = null
    ): VKRequest<FriendsAddResponse> = NewApiRequest("friends.add") {
        GsonHolder.gson.fromJson(it, FriendsAddResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        text?.let { addParam("text", it) }
        follow?.let { addParam("follow", it) }
    }

    /**
     * Creates a new friend list for the current user.
     *
     * @param name - Name of the friend list.
     * @param userIds - IDs of users to be added to the friend list.
     * @return [VKRequest] with [FriendsAddListResponse]
     */
    fun friendsAddList(name: String, userIds: List<UserId>? = null):
            VKRequest<FriendsAddListResponse> = NewApiRequest("friends.addList") {
        GsonHolder.gson.fromJson(it, FriendsAddListResponse::class.java)
    }
    .apply {
        addParam("name", name)
        userIds?.let { addParam("user_ids", it) }
    }

    /**
     * Checks the current user's friendship status with other specified users.
     *
     * @param userIds - IDs of the users whose friendship status to check.
     * @param needSign - '1' - to return 'sign' field. 'sign' is
     * md5("{id}_{user_id}_{friends_status}_{application_secret}"), where id is current user ID. This
     * field allows to check that data has not been modified by the client. By default_ '0'.
     * @return [VKRequest] with [Unit]
     */
    fun friendsAreFriends(userIds: List<UserId>, needSign: Boolean? = null):
            VKRequest<List<FriendsFriendStatus>> = NewApiRequest("friends.areFriends") {
        val typeToken = object: TypeToken<List<FriendsFriendStatus>>() {}.type
        GsonHolder.gson.fromJson<List<FriendsFriendStatus>>(it, typeToken)
    }
    .apply {
        addParam("user_ids", userIds)
        needSign?.let { addParam("need_sign", it) }
    }

    /**
     * Checks the current user's friendship status with other specified users.
     *
     * @param userIds - IDs of the users whose friendship status to check.
     * @param needSign - '1' - to return 'sign' field. 'sign' is
     * md5("{id}_{user_id}_{friends_status}_{application_secret}"), where id is current user ID. This
     * field allows to check that data has not been modified by the client. By default_ '0'.
     * @return [VKRequest] with [Unit]
     */
    fun friendsAreFriendsExtended(userIds: List<UserId>, needSign: Boolean? = null):
            VKRequest<List<FriendsFriendExtendedStatus>> = NewApiRequest("friends.areFriends") {
        val typeToken = object: TypeToken<List<FriendsFriendExtendedStatus>>() {}.type
        GsonHolder.gson.fromJson<List<FriendsFriendExtendedStatus>>(it, typeToken)
    }
    .apply {
        addParam("user_ids", userIds)
        needSign?.let { addParam("need_sign", it) }
        addParam("extended", true)
    }

    /**
     * Declines a friend request or deletes a user from the current user's friend list.
     *
     * @param userId - ID of the user whose friend request is to be declined or who is to be deleted
     * from the current user's friend list.
     * @return [VKRequest] with [FriendsDeleteResponse]
     */
    fun friendsDelete(userId: UserId? = null): VKRequest<FriendsDeleteResponse> =
            NewApiRequest("friends.delete") {
        GsonHolder.gson.fromJson(it, FriendsDeleteResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
    }

    /**
     * Marks all incoming friend requests as viewed.
     *
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun friendsDeleteAllRequests(): VKRequest<BaseOkResponse> =
            NewApiRequest("friends.deleteAllRequests") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }

    /**
     * Deletes a friend list of the current user.
     *
     * @param listId - ID of the friend list to delete.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun friendsDeleteList(listId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("friends.deleteList") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("list_id", listId, min = 0, max = 24)
    }

    /**
     * Edits the friend lists of the selected user.
     *
     * @param userId - ID of the user whose friend list is to be edited.
     * @param listIds - IDs of the friend lists to which to add the user.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun friendsEdit(userId: UserId, listIds: List<Int>? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("friends.edit") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("user_id", userId, min = 1)
        listIds?.let { addParam("list_ids", it) }
    }

    /**
     * Edits a friend list of the current user.
     *
     * @param listId - Friend list ID.
     * @param name - Name of the friend list.
     * @param userIds - IDs of users in the friend list.
     * @param addUserIds - (Applies if 'user_ids' parameter is not set.), User IDs to add to the
     * friend list.
     * @param deleteUserIds - (Applies if 'user_ids' parameter is not set.), User IDs to delete from
     * the friend list.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun friendsEditList(
        listId: Int,
        name: String? = null,
        userIds: List<UserId>? = null,
        addUserIds: List<UserId>? = null,
        deleteUserIds: List<UserId>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("friends.editList") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("list_id", listId, min = 0)
        name?.let { addParam("name", it) }
        userIds?.let { addParam("user_ids", it) }
        addUserIds?.let { addParam("add_user_ids", it) }
        deleteUserIds?.let { addParam("delete_user_ids", it) }
    }

    /**
     * Returns a list of user IDs or detailed information about a user's friends.
     *
     * @param userId - User ID. By default, the current user ID.
     * @param order - Sort order_ , 'name' - by name (enabled only if the 'fields' parameter is
     * used), 'hints' - by rating, similar to how friends are sorted in My friends section, , This
     * parameter is available only for [vk.com/dev/standalone|desktop applications].
     * @param listId - ID of the friend list returned by the
     * [vk.com/dev/friends.getLists|friends.getLists] method to be used as the source. This parameter
     * is taken into account only when the uid parameter is set to the current user ID. This parameter
     * is available only for [vk.com/dev/standalone|desktop applications].
     * @param count - Number of friends to return.
     * @param offset - Offset needed to return a specific subset of friends.
     * @param fields - Profile fields to return. Sample values_ 'uid', 'first_name', 'last_name',
     * 'nickname', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium',
     * 'photo_big', 'domain', 'has_mobile', 'rate', 'contacts', 'education'.
     * @param nameCase - Case for declension of user name and surname_ , 'nom' - nominative
     * (default) , 'gen' - genitive , 'dat' - dative , 'acc' - accusative , 'ins' - instrumental ,
     * 'abl' - prepositional
     * @param ref
     * @return [VKRequest] with [FriendsGetFieldsResponse]
     */
    fun friendsGet(
        userId: UserId? = null,
        order: FriendsGetOrder? = null,
        listId: Int? = null,
        count: Int? = null,
        offset: Int? = null,
        fields: List<UsersFields>? = null,
        nameCase: FriendsGetNameCase? = null,
        ref: String? = null
    ): VKRequest<FriendsGetFieldsResponse> = NewApiRequest("friends.get") {
        GsonHolder.gson.fromJson(it, FriendsGetFieldsResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it) }
        order?.let { addParam("order", it.value) }
        listId?.let { addParam("list_id", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it.value) }
        ref?.let { addParam("ref", it, maxLength = 255) }
    }

    /**
     * Returns a list of IDs of the current user's friends who installed the application.
     *
     * @return [VKRequest] with [Unit]
     */
    fun friendsGetAppUsers(): VKRequest<List<UserId>> = NewApiRequest("friends.getAppUsers") {
        val typeToken = object: TypeToken<List<UserId>>() {}.type
        GsonHolder.gson.fromJson<List<UserId>>(it, typeToken)
    }

    /**
     * Returns a list of the current user's friends whose phone numbers, validated or specified in a
     * profile, are in a given list.
     *
     * @param phones - List of phone numbers in MSISDN format (maximum 1000). Example_
     * "+79219876543,+79111234567"
     * @param fields - Profile fields to return. Sample values_ 'nickname', 'screen_name', 'sex',
     * 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big',
     * 'has_mobile', 'rate', 'contacts', 'education', 'online, counters'.
     * @return [VKRequest] with [Unit]
     */
    fun friendsGetByPhones(phones: List<String>? = null, fields: List<UsersFields>? = null):
            VKRequest<List<FriendsUserXtrPhone>> = NewApiRequest("friends.getByPhones") {
        val typeToken = object: TypeToken<List<FriendsUserXtrPhone>>() {}.type
        GsonHolder.gson.fromJson<List<FriendsUserXtrPhone>>(it, typeToken)
    }
    .apply {
        phones?.let { addParam("phones", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of the user's friend lists.
     *
     * @param userId - User ID.
     * @param returnSystem - '1' - to return system friend lists. By default_ '0'.
     * @return [VKRequest] with [FriendsGetListsResponse]
     */
    fun friendsGetLists(userId: UserId? = null, returnSystem: Boolean? = null):
            VKRequest<FriendsGetListsResponse> = NewApiRequest("friends.getLists") {
        GsonHolder.gson.fromJson(it, FriendsGetListsResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        returnSystem?.let { addParam("return_system", it) }
    }

    /**
     * Returns a list of user IDs of the mutual friends of two users.
     *
     * @param sourceUid - ID of the user whose friends will be checked against the friends of the
     * user specified in 'target_uid'.
     * @param targetUid - ID of the user whose friends will be checked against the friends of the
     * user specified in 'source_uid'.
     * @param targetUids - IDs of the users whose friends will be checked against the friends of the
     * user specified in 'source_uid'.
     * @param order - Sort order_ 'random' - random order
     * @param count - Number of mutual friends to return.
     * @param offset - Offset needed to return a specific subset of mutual friends.
     * @return [VKRequest] with [Unit]
     */
    fun friendsGetMutual(
        sourceUid: UserId? = null,
        targetUid: UserId? = null,
        targetUids: List<UserId>? = null,
        order: String? = null,
        count: Int? = null,
        offset: Int? = null
    ): VKRequest<List<UserId>> = NewApiRequest("friends.getMutual") {
        val typeToken = object: TypeToken<List<UserId>>() {}.type
        GsonHolder.gson.fromJson<List<UserId>>(it, typeToken)
    }
    .apply {
        sourceUid?.let { addParam("source_uid", it, min = 0) }
        targetUid?.let { addParam("target_uid", it, min = 0) }
        targetUids?.let { addParam("target_uids", it) }
        order?.let { addParam("order", it) }
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
    }

    /**
     * Returns a list of user IDs of a user's friends who are online.
     *
     * @param userId - User ID.
     * @param listId - Friend list ID. If this parameter is not set, information about all online
     * friends is returned.
     * @param onlineMobile - '1' - to return an additional 'online_mobile' field, '0' - (default),
     * @param order - Sort order_ 'random' - random order
     * @param count - Number of friends to return.
     * @param offset - Offset needed to return a specific subset of friends.
     * @return [VKRequest] with [Unit]
     */
    fun friendsGetOnline(
        userId: UserId? = null,
        listId: Int? = null,
        onlineMobile: Boolean? = null,
        order: String? = null,
        count: Int? = null,
        offset: Int? = null
    ): VKRequest<List<UserId>> = NewApiRequest("friends.getOnline") {
        val typeToken = object: TypeToken<List<UserId>>() {}.type
        GsonHolder.gson.fromJson<List<UserId>>(it, typeToken)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        listId?.let { addParam("list_id", it, min = 0) }
        onlineMobile?.let { addParam("online_mobile", it) }
        order?.let { addParam("order", it) }
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
    }

    /**
     * Returns a list of user IDs of the current user's recently added friends.
     *
     * @param count - Number of recently added friends to return.
     * @return [VKRequest] with [Unit]
     */
    fun friendsGetRecent(count: Int? = null): VKRequest<List<Int>> =
            NewApiRequest("friends.getRecent") {
        val typeToken = object: TypeToken<List<Int>>() {}.type
        GsonHolder.gson.fromJson<List<Int>>(it, typeToken)
    }
    .apply {
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * Returns information about the current user's incoming and outgoing friend requests.
     *
     * @param offset - Offset needed to return a specific subset of friend requests.
     * @param count - Number of friend requests to return (default 100, maximum 1000).
     * @param needMutual - '1' - to return a list of mutual friends (up to 20), if any
     * @param out - '1' - to return outgoing requests, '0' - to return incoming requests (default)
     * @param sort - Sort order_ '1' - by number of mutual friends, '0' - by date
     * @param needViewed
     * @param suggested - '1' - to return a list of suggested friends, '0' - to return friend
     * requests (default)
     * @param ref
     * @param fields
     * @return [VKRequest] with [FriendsGetRequestsResponse]
     */
    fun friendsGetRequests(
        offset: Int? = null,
        count: Int? = null,
        needMutual: Boolean? = null,
        out: Boolean? = null,
        sort: FriendsGetRequestsSort? = null,
        needViewed: Boolean? = null,
        suggested: Boolean? = null,
        ref: String? = null,
        fields: List<UsersFields>? = null
    ): VKRequest<FriendsGetRequestsResponse> = NewApiRequest("friends.getRequests") {
        GsonHolder.gson.fromJson(it, FriendsGetRequestsResponse::class.java)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        needMutual?.let { addParam("need_mutual", it) }
        out?.let { addParam("out", it) }
        sort?.let { addParam("sort", it.value) }
        needViewed?.let { addParam("need_viewed", it) }
        suggested?.let { addParam("suggested", it) }
        ref?.let { addParam("ref", it, maxLength = 255) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of profiles of users whom the current user may know.
     *
     * @param filter - Types of potential friends to return_ 'mutual' - users with many mutual
     * friends , 'contacts' - users found with the
     * [vk.com/dev/account.importContacts|account.importContacts] method , 'mutual_contacts' - users
     * who imported the same contacts as the current user with the
     * [vk.com/dev/account.importContacts|account.importContacts] method
     * @param count - Number of suggestions to return.
     * @param offset - Offset needed to return a specific subset of suggestions.
     * @param fields - Profile fields to return. Sample values_ 'nickname', 'screen_name', 'sex',
     * 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big',
     * 'has_mobile', 'rate', 'contacts', 'education', 'online', 'counters'.
     * @param nameCase - Case for declension of user name and surname_ , 'nom' - nominative
     * (default) , 'gen' - genitive , 'dat' - dative , 'acc' - accusative , 'ins' - instrumental ,
     * 'abl' - prepositional
     * @return [VKRequest] with [FriendsGetSuggestionsResponse]
     */
    fun friendsGetSuggestions(
        filter: List<FriendsGetSuggestionsFilter>? = null,
        count: Int? = null,
        offset: Int? = null,
        fields: List<UsersFields>? = null,
        nameCase: FriendsGetSuggestionsNameCase? = null
    ): VKRequest<FriendsGetSuggestionsResponse> = NewApiRequest("friends.getSuggestions") {
        GsonHolder.gson.fromJson(it, FriendsGetSuggestionsResponse::class.java)
    }
    .apply {
        val filterJsonConverted = filter?.map {
            it.value
        }
        filterJsonConverted?.let { addParam("filter", it) }
        count?.let { addParam("count", it, min = 0, max = 500) }
        offset?.let { addParam("offset", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it.value) }
    }

    /**
     * Returns a list of friends matching the search criteria.
     *
     * @param userId - User ID.
     * @param q - Search query string (e.g., 'Vasya Babich').
     * @param fields - Profile fields to return. Sample values_ 'nickname', 'screen_name', 'sex',
     * 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big',
     * 'has_mobile', 'rate', 'contacts', 'education', 'online',
     * @param nameCase - Case for declension of user name and surname_ 'nom' - nominative (default),
     * 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' -
     * prepositional
     * @param offset - Offset needed to return a specific subset of friends.
     * @param count - Number of friends to return.
     * @return [VKRequest] with [FriendsSearchResponse]
     */
    fun friendsSearch(
        userId: UserId? = null,
        q: String? = null,
        fields: List<UsersFields>? = null,
        nameCase: FriendsSearchNameCase? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<FriendsSearchResponse> = NewApiRequest("friends.search") {
        GsonHolder.gson.fromJson(it, FriendsSearchResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 1) }
        q?.let { addParam("q", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it.value) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }
}
