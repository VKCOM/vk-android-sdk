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
package com.vk.sdk.api.polls

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.dto.BaseUploadServerDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.polls.dto.PollsBackgroundDto
import com.vk.sdk.api.polls.dto.PollsCreateBackgroundIdDto
import com.vk.sdk.api.polls.dto.PollsEditBackgroundIdDto
import com.vk.sdk.api.polls.dto.PollsFieldsVotersDto
import com.vk.sdk.api.polls.dto.PollsGetByIdNameCaseDto
import com.vk.sdk.api.polls.dto.PollsPollDto
import com.vk.sdk.api.users.dto.UsersFieldsDto
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class PollsService {
    /**
     * Adds the current user's vote to the selected answer in the poll.
     *
     * @param pollId - Poll ID.
     * @param answerIds
     * @param ownerId - ID of the user or community that owns the poll. Use a negative value to
     * designate a community ID.
     * @param isBoard
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun pollsAddVote(
        pollId: Int,
        answerIds: List<Long>,
        ownerId: UserId? = null,
        isBoard: Boolean? = null
    ): VKRequest<BaseBoolIntDto> = NewApiRequest("polls.addVote") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("poll_id", pollId, min = 0)
        addParam("answer_ids", answerIds)
        ownerId?.let { addParam("owner_id", it) }
        isBoard?.let { addParam("is_board", it) }
    }

    /**
     * Creates polls that can be attached to the users' or communities' posts.
     *
     * @param question - question text
     * @param isAnonymous - '1' - anonymous poll, participants list is hidden,, '0' - public poll,
     * participants list is available,, Default value is '0'.
     * @param isMultiple
     * @param endDate
     * @param ownerId - If a poll will be added to a communty it is required to send a negative
     * group identifier. Current user by default.
     * @param appId
     * @param addAnswers - available answers list, for example_ " ["yes","no","maybe"]", There can
     * be from 1 to 10 answers.
     * @param photoId
     * @param backgroundId
     * @param disableUnvote
     * @return [VKRequest] with [PollsPollDto]
     */
    fun pollsCreate(
        question: String? = null,
        isAnonymous: Boolean? = null,
        isMultiple: Boolean? = null,
        endDate: Int? = null,
        ownerId: UserId? = null,
        appId: Int? = null,
        addAnswers: String? = null,
        photoId: Int? = null,
        backgroundId: PollsCreateBackgroundIdDto? = null,
        disableUnvote: Boolean? = null
    ): VKRequest<PollsPollDto> = NewApiRequest("polls.create") {
        GsonHolder.gson.parse<PollsPollDto>(it)
    }
    .apply {
        question?.let { addParam("question", it) }
        isAnonymous?.let { addParam("is_anonymous", it) }
        isMultiple?.let { addParam("is_multiple", it) }
        endDate?.let { addParam("end_date", it, min = 1550700000) }
        ownerId?.let { addParam("owner_id", it) }
        appId?.let { addParam("app_id", it) }
        addAnswers?.let { addParam("add_answers", it) }
        photoId?.let { addParam("photo_id", it, min = 0) }
        backgroundId?.let { addParam("background_id", it.value) }
        disableUnvote?.let { addParam("disable_unvote", it) }
    }

    /**
     * Deletes the current user's vote from the selected answer in the poll.
     *
     * @param pollId - Poll ID.
     * @param ownerId - ID of the user or community that owns the poll. Use a negative value to
     * designate a community ID.
     * @param isBoard
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun pollsDeleteVote(
        pollId: Int,
        ownerId: UserId? = null,
        isBoard: Boolean? = null
    ): VKRequest<BaseBoolIntDto> = NewApiRequest("polls.deleteVote") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("poll_id", pollId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        isBoard?.let { addParam("is_board", it) }
    }

    /**
     * Edits created polls
     *
     * @param pollId - edited poll's id
     * @param ownerId - poll owner id
     * @param question - new question text
     * @param addAnswers - answers list, for example_ , "["yes","no","maybe"]"
     * @param editAnswers - object containing answers that need to be edited,, key - answer id,
     * value - new answer text. Example_ {"382967099"_"option1", "382967103"_"option2"}"
     * @param deleteAnswers - list of answer ids to be deleted. For example_ "[382967099,
     * 382967103]"
     * @param endDate
     * @param photoId
     * @param backgroundId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun pollsEdit(
        pollId: Int,
        ownerId: UserId? = null,
        question: String? = null,
        addAnswers: String? = null,
        editAnswers: String? = null,
        deleteAnswers: String? = null,
        endDate: Int? = null,
        photoId: Int? = null,
        backgroundId: PollsEditBackgroundIdDto? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("polls.edit") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("poll_id", pollId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        question?.let { addParam("question", it) }
        addAnswers?.let { addParam("add_answers", it) }
        editAnswers?.let { addParam("edit_answers", it) }
        deleteAnswers?.let { addParam("delete_answers", it) }
        endDate?.let { addParam("end_date", it, min = 0) }
        photoId?.let { addParam("photo_id", it, min = 0) }
        backgroundId?.let { addParam("background_id", it.value) }
    }

    /**
     * @return [VKRequest] with [Unit]
     */
    fun pollsGetBackgrounds(): VKRequest<List<PollsBackgroundDto>> =
            NewApiRequest("polls.getBackgrounds") {
        GsonHolder.gson.parseList<PollsBackgroundDto>(it)
    }

    /**
     * Returns detailed information about a poll by its ID.
     *
     * @param pollId - Poll ID.
     * @param ownerId - ID of the user or community that owns the poll. Use a negative value to
     * designate a community ID.
     * @param isBoard - '1' - poll is in a board, '0' - poll is on a wall. '0' by default.
     * @param extended
     * @param friendsCount
     * @param fields
     * @param nameCase
     * @return [VKRequest] with [PollsPollDto]
     */
    fun pollsGetById(
        pollId: Int,
        ownerId: UserId? = null,
        isBoard: Boolean? = null,
        extended: Boolean? = null,
        friendsCount: Int? = null,
        fields: List<String>? = null,
        nameCase: PollsGetByIdNameCaseDto? = null
    ): VKRequest<PollsPollDto> = NewApiRequest("polls.getById") {
        GsonHolder.gson.parse<PollsPollDto>(it)
    }
    .apply {
        addParam("poll_id", pollId, min = 0)
        ownerId?.let { addParam("owner_id", it) }
        isBoard?.let { addParam("is_board", it) }
        extended?.let { addParam("extended", it) }
        friendsCount?.let { addParam("friends_count", it, min = 0, max = 100) }
        fields?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it.value) }
    }

    /**
     * @param ownerId
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun pollsGetPhotoUploadServer(ownerId: UserId? = null): VKRequest<BaseUploadServerDto> =
            NewApiRequest("polls.getPhotoUploadServer") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Returns a list of IDs of users who selected specific answers in the poll.
     *
     * @param pollId - Poll ID.
     * @param answerIds - Answer IDs.
     * @param ownerId - ID of the user or community that owns the poll. Use a negative value to
     * designate a community ID.
     * @param isBoard
     * @param friendsOnly - '1' - to return only current user's friends, '0' - to return all users
     * (default),
     * @param offset - Offset needed to return a specific subset of voters. '0' - (default)
     * @param count - Number of user IDs to return (if the 'friends_only' parameter is not set,
     * maximum '1000', otherwise '10'). '100' - (default)
     * @param fields - Profile fields to return. Sample values_ 'nickname', 'screen_name', 'sex',
     * 'bdate (birthdate)', 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big',
     * 'has_mobile', 'rate', 'contacts', 'education', 'online', 'counters'.
     * @param nameCase - Case for declension of user name and surname_ , 'nom' - nominative
     * (default) , 'gen' - genitive , 'dat' - dative , 'acc' - accusative , 'ins' - instrumental ,
     * 'abl' - prepositional
     * @return [VKRequest] with [Unit]
     */
    fun pollsGetVoters(
        pollId: Int,
        answerIds: List<Long>,
        ownerId: UserId? = null,
        isBoard: Boolean? = null,
        friendsOnly: Boolean? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<UsersFieldsDto>? = null,
        nameCase: String? = null
    ): VKRequest<List<PollsFieldsVotersDto>> = NewApiRequest("polls.getVoters") {
        GsonHolder.gson.parseList<PollsFieldsVotersDto>(it)
    }
    .apply {
        addParam("poll_id", pollId, min = 0)
        addParam("answer_ids", answerIds)
        ownerId?.let { addParam("owner_id", it) }
        isBoard?.let { addParam("is_board", it) }
        friendsOnly?.let { addParam("friends_only", it) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it) }
    }

    /**
     * @param photo
     * @param hash
     * @return [VKRequest] with [PollsBackgroundDto]
     */
    fun pollsSavePhoto(photo: String, hash: String): VKRequest<PollsBackgroundDto> =
            NewApiRequest("polls.savePhoto") {
        GsonHolder.gson.parse<PollsBackgroundDto>(it)
    }
    .apply {
        addParam("photo", photo)
        addParam("hash", hash)
    }

    object PollsAddVoteRestrictions {
        const val POLL_ID_MIN: Long = 0
    }

    object PollsCreateRestrictions {
        const val END_DATE_MIN: Long = 1550700000

        const val PHOTO_ID_MIN: Long = 0
    }

    object PollsDeleteVoteRestrictions {
        const val POLL_ID_MIN: Long = 0
    }

    object PollsEditRestrictions {
        const val POLL_ID_MIN: Long = 0

        const val END_DATE_MIN: Long = 0

        const val PHOTO_ID_MIN: Long = 0
    }

    object PollsGetByIdRestrictions {
        const val POLL_ID_MIN: Long = 0

        const val FRIENDS_COUNT_MIN: Long = 0

        const val FRIENDS_COUNT_MAX: Long = 100
    }

    object PollsGetVotersRestrictions {
        const val POLL_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0
    }
}
