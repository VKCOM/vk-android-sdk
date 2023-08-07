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

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.friends.dto.FriendsAddListResponseDto
import com.vk.sdk.api.friends.dto.FriendsAddResponseDto
import com.vk.sdk.api.friends.dto.FriendsDeleteResponseDto
import com.vk.sdk.api.friends.dto.FriendsFriendExtendedStatusDto
import com.vk.sdk.api.friends.dto.FriendsFriendStatusDto
import com.vk.sdk.api.friends.dto.FriendsGetFieldsResponseDto
import com.vk.sdk.api.friends.dto.FriendsGetListsResponseDto
import com.vk.sdk.api.friends.dto.FriendsGetOrderDto
import com.vk.sdk.api.friends.dto.FriendsGetRequestsResponseDto
import com.vk.sdk.api.friends.dto.FriendsGetRequestsSortDto
import com.vk.sdk.api.friends.dto.FriendsGetSuggestionsFilterDto
import com.vk.sdk.api.friends.dto.FriendsGetSuggestionsResponseDto
import com.vk.sdk.api.friends.dto.FriendsSearchResponseDto
import com.vk.sdk.api.friends.dto.FriendsUserXtrPhoneDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.users.dto.UsersFieldsDto
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
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
     * @return [VKRequest] with [FriendsAddResponseDto]
     */
    fun friendsAdd(
        userId: UserId? = null,
        text: String? = null,
        follow: Boolean? = null
    ): VKRequest<FriendsAddResponseDto> = NewApiRequest("friends.add") {
        GsonHolder.gson.parse<FriendsAddResponseDto>(it)
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
     * @return [VKRequest] with [FriendsAddListResponseDto]
     */
    fun friendsAddList(name: String, userIds: List<UserId>? = null):
            VKRequest<FriendsAddListResponseDto> = NewApiRequest("friends.addList") {
        GsonHolder.gson.parse<FriendsAddListResponseDto>(it)
    }
    .apply {
        addParam("name", name)
        userIds?.let { addParam("user_ids", it, min = 0) }
    }

    /**
     * Checks the current user's friendship status with other specified users.
     *
     * @param userIds - IDs of the users whose friendship status to check.
     * @param needSign - '1' - to return 'sign' field. 'sign' is
     * md5("{id}_{user_id}_{friends_status}_{application_secret}"), where id is current user ID. This
     * field allows to check that data has not been modified by the client. By default_ '0'.
     * @param extended - Return friend request read_state field
     * @return [VKRequest] with [Unit]
     */
    fun friendsAreFriends(
        userIds: List<UserId>,
        needSign: Boolean? = null,
        extended: Boolean? = null
    ): VKRequest<List<FriendsFriendStatusDto>> = NewApiRequest("friends.areFriends") {
        GsonHolder.gson.parseList<FriendsFriendStatusDto>(it)
    }
    .apply {
        addParam("user_ids", userIds)
        needSign?.let { addParam("need_sign", it) }
        extended?.let { addParam("extended", it) }
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
            VKRequest<List<FriendsFriendExtendedStatusDto>> = NewApiRequest("friends.areFriends") {
        GsonHolder.gson.parseList<FriendsFriendExtendedStatusDto>(it)
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
     * @return [VKRequest] with [FriendsDeleteResponseDto]
     */
    fun friendsDelete(userId: UserId? = null): VKRequest<FriendsDeleteResponseDto> =
            NewApiRequest("friends.delete") {
        GsonHolder.gson.parse<FriendsDeleteResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
    }

    /**
     * Marks all incoming friend requests as viewed.
     *
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun friendsDeleteAllRequests(): VKRequest<BaseOkResponseDto> =
            NewApiRequest("friends.deleteAllRequests") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }

    /**
     * Deletes a friend list of the current user.
     *
     * @param listId - ID of the friend list to delete.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun friendsDeleteList(listId: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("friends.deleteList") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("list_id", listId, min = 0, max = 24)
    }

    /**
     * Edits the friend lists of the selected user.
     *
     * @param userId - ID of the user whose friend list is to be edited.
     * @param listIds - IDs of the friend lists to which to add the user.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun friendsEdit(userId: UserId, listIds: List<Int>? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("friends.edit") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun friendsEditList(
        listId: Int,
        name: String? = null,
        userIds: List<UserId>? = null,
        addUserIds: List<UserId>? = null,
        deleteUserIds: List<UserId>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("friends.editList") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("list_id", listId, min = 0)
        name?.let { addParam("name", it) }
        userIds?.let { addParam("user_ids", it, min = 0) }
        addUserIds?.let { addParam("add_user_ids", it, min = 0) }
        deleteUserIds?.let { addParam("delete_user_ids", it, min = 0) }
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
     * @param ref
     * @return [VKRequest] with [FriendsGetFieldsResponseDto]
     */
    fun friendsGet(
        userId: UserId? = null,
        order: FriendsGetOrderDto? = null,
        listId: Int? = null,
        count: Int? = null,
        offset: Int? = null,
        fields: List<UsersFieldsDto>? = null,
        ref: String? = null
    ): VKRequest<FriendsGetFieldsResponseDto> = NewApiRequest("friends.get") {
        GsonHolder.gson.parse<FriendsGetFieldsResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 1) }
        order?.let { addParam("order", it.value) }
        listId?.let { addParam("list_id", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        ref?.let { addParam("ref", it, maxLength = 255) }
    }

    /**
     * Returns a list of IDs of the current user's friends who installed the application.
     *
     * @return [VKRequest] with [Unit]
     */
    fun friendsGetAppUsers(): VKRequest<List<UserId>> = NewApiRequest("friends.getAppUsers") {
        GsonHolder.gson.parseList<UserId>(it)
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
    fun friendsGetByPhones(phones: List<String>? = null, fields: List<UsersFieldsDto>? = null):
            VKRequest<List<FriendsUserXtrPhoneDto>> = NewApiRequest("friends.getByPhones") {
        GsonHolder.gson.parseList<FriendsUserXtrPhoneDto>(it)
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
     * @return [VKRequest] with [FriendsGetListsResponseDto]
     */
    fun friendsGetLists(userId: UserId? = null, returnSystem: Boolean? = null):
            VKRequest<FriendsGetListsResponseDto> = NewApiRequest("friends.getLists") {
        GsonHolder.gson.parse<FriendsGetListsResponseDto>(it)
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
        GsonHolder.gson.parseList<UserId>(it)
    }
    .apply {
        sourceUid?.let { addParam("source_uid", it, min = 1) }
        targetUid?.let { addParam("target_uid", it, min = 1) }
        targetUids?.let { addParam("target_uids", it, min = 0) }
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
        GsonHolder.gson.parseList<UserId>(it)
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
    fun friendsGetRecent(count: Int? = null): VKRequest<List<UserId>> =
            NewApiRequest("friends.getRecent") {
        GsonHolder.gson.parseList<UserId>(it)
    }
    .apply {
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * Returns information about the current user's incoming and outgoing friend requests.
     *
     * @param offset - Offset needed to return a specific subset of friend requests.
     * @param count - Number of friend requests to return (default 100, maximum 1000).
     * @param extended - '1' - to return response messages from users who have sent a friend request
     * or, if 'suggested' is set to '1', to return a list of suggested friends
     * @param needMutual - '1' - to return a list of mutual friends (up to 20), if any
     * @param out - '1' - to return outgoing requests, '0' - to return incoming requests (default)
     * @param sort - Sort order_ '1' - by number of mutual friends, '0' - by date
     * @param needViewed
     * @param suggested - '1' - to return a list of suggested friends, '0' - to return friend
     * requests (default)
     * @param ref
     * @param fields
     * @return [VKRequest] with [FriendsGetRequestsResponseDto]
     */
    fun friendsGetRequests(
        offset: Int? = null,
        count: Int? = null,
        extended: Boolean? = null,
        needMutual: Boolean? = null,
        out: Boolean? = null,
        sort: FriendsGetRequestsSortDto? = null,
        needViewed: Boolean? = null,
        suggested: Boolean? = null,
        ref: String? = null,
        fields: List<UsersFieldsDto>? = null
    ): VKRequest<FriendsGetRequestsResponseDto> = NewApiRequest("friends.getRequests") {
        GsonHolder.gson.parse<FriendsGetRequestsResponseDto>(it)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
        extended?.let { addParam("extended", it) }
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
     * @return [VKRequest] with [FriendsGetSuggestionsResponseDto]
     */
    fun friendsGetSuggestions(
        filter: List<FriendsGetSuggestionsFilterDto>? = null,
        count: Int? = null,
        offset: Int? = null,
        fields: List<UsersFieldsDto>? = null,
        nameCase: String? = null
    ): VKRequest<FriendsGetSuggestionsResponseDto> = NewApiRequest("friends.getSuggestions") {
        GsonHolder.gson.parse<FriendsGetSuggestionsResponseDto>(it)
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
        nameCase?.let { addParam("name_case", it) }
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
     * @return [VKRequest] with [FriendsSearchResponseDto]
     */
    fun friendsSearch(
        userId: UserId? = null,
        q: String? = null,
        fields: List<UsersFieldsDto>? = null,
        nameCase: String? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<FriendsSearchResponseDto> = NewApiRequest("friends.search") {
        GsonHolder.gson.parse<FriendsSearchResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 1) }
        q?.let { addParam("q", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    object FriendsAddRestrictions {
        const val USER_ID_MIN: Long = 0
    }

    object FriendsAddListRestrictions {
        const val USER_IDS_MIN: Long = 0
    }

    object FriendsDeleteRestrictions {
        const val USER_ID_MIN: Long = 0
    }

    object FriendsDeleteListRestrictions {
        const val LIST_ID_MIN: Long = 0

        const val LIST_ID_MAX: Long = 24
    }

    object FriendsEditRestrictions {
        const val USER_ID_MIN: Long = 1
    }

    object FriendsEditListRestrictions {
        const val LIST_ID_MIN: Long = 0

        const val USER_IDS_MIN: Long = 0

        const val ADD_USER_IDS_MIN: Long = 0

        const val DELETE_USER_IDS_MIN: Long = 0
    }

    object FriendsGetRestrictions {
        const val USER_ID_MIN: Long = 1

        const val LIST_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val REF_MAX_LENGTH: Int = 255
    }

    object FriendsGetListsRestrictions {
        const val USER_ID_MIN: Long = 0
    }

    object FriendsGetMutualRestrictions {
        const val SOURCE_UID_MIN: Long = 1

        const val TARGET_UID_MIN: Long = 1

        const val TARGET_UIDS_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val OFFSET_MIN: Long = 0
    }

    object FriendsGetOnlineRestrictions {
        const val USER_ID_MIN: Long = 0

        const val LIST_ID_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val OFFSET_MIN: Long = 0
    }

    object FriendsGetRecentRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object FriendsGetRequestsRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000

        const val REF_MAX_LENGTH: Int = 255
    }

    object FriendsGetSuggestionsRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 500

        const val OFFSET_MIN: Long = 0
    }

    object FriendsSearchRestrictions {
        const val USER_ID_MIN: Long = 1

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }
}
