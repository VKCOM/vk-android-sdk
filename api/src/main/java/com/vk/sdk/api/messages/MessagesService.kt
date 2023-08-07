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
package com.vk.sdk.api.messages

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolIntDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.dto.BaseUserGroupFieldsDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.messages.dto.MessagesAddChatUsersResponseDto
import com.vk.sdk.api.messages.dto.MessagesChatFullDto
import com.vk.sdk.api.messages.dto.MessagesDeleteChatPhotoResponseDto
import com.vk.sdk.api.messages.dto.MessagesDeleteConversationResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetByConversationMessageIdExtendedResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetByConversationMessageIdResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetByIdExtendedResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetByIdResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetChatPreviewResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetConversationByIdDto
import com.vk.sdk.api.messages.dto.MessagesGetConversationByIdExtendedDto
import com.vk.sdk.api.messages.dto.MessagesGetConversationMembersDto
import com.vk.sdk.api.messages.dto.MessagesGetConversationsFilterDto
import com.vk.sdk.api.messages.dto.MessagesGetConversationsResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetHistoryAttachmentsAttachmentTypesDto
import com.vk.sdk.api.messages.dto.MessagesGetHistoryAttachmentsMediaTypeDto
import com.vk.sdk.api.messages.dto.MessagesGetHistoryAttachmentsResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetHistoryExtendedResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetHistoryExtendedRevDto
import com.vk.sdk.api.messages.dto.MessagesGetHistoryResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetHistoryRevDto
import com.vk.sdk.api.messages.dto.MessagesGetImportantMessagesExtendedResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetImportantMessagesResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetIntentUsersIntentDto
import com.vk.sdk.api.messages.dto.MessagesGetIntentUsersResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetInviteLinkResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetLongPollHistoryResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetMessagesReactionsResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetReactedPeersResponseDto
import com.vk.sdk.api.messages.dto.MessagesGetReactionsAssetsResponseDto
import com.vk.sdk.api.messages.dto.MessagesIsMessagesFromGroupAllowedResponseDto
import com.vk.sdk.api.messages.dto.MessagesJoinChatByInviteLinkResponseDto
import com.vk.sdk.api.messages.dto.MessagesLastActivityDto
import com.vk.sdk.api.messages.dto.MessagesLongpollParamsDto
import com.vk.sdk.api.messages.dto.MessagesPinnedMessageDto
import com.vk.sdk.api.messages.dto.MessagesSearchConversationsExtendedResponseDto
import com.vk.sdk.api.messages.dto.MessagesSearchConversationsResponseDto
import com.vk.sdk.api.messages.dto.MessagesSearchExtendedResponseDto
import com.vk.sdk.api.messages.dto.MessagesSearchResponseDto
import com.vk.sdk.api.messages.dto.MessagesSendIntentDto
import com.vk.sdk.api.messages.dto.MessagesSetActivityTypeDto
import com.vk.sdk.api.messages.dto.MessagesSetChatPhotoResponseDto
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.users.dto.UsersFieldsDto
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class MessagesService {
    /**
     * Adds a new user to a chat.
     *
     * @param chatId - Chat ID.
     * @param userId - ID of the user to be added to the chat.
     * @param visibleMessagesCount
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesAddChatUser(
        chatId: Int,
        userId: UserId? = null,
        visibleMessagesCount: Int? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("messages.addChatUser") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("chat_id", chatId, min = 0, max = 100000000)
        userId?.let { addParam("user_id", it, min = 0) }
        visibleMessagesCount?.let { addParam("visible_messages_count", it, min = 0, max = 1000) }
    }

    /**
     * Adds new users to a chat.
     *
     * @param chatId
     * @param visibleMessagesCount
     * @return [VKRequest] with [MessagesAddChatUsersResponseDto]
     */
    fun messagesAddChatUsers(chatId: Long? = null, visibleMessagesCount: Int? = null):
            VKRequest<MessagesAddChatUsersResponseDto> = NewApiRequest("messages.addChatUsers") {
        GsonHolder.gson.parse<MessagesAddChatUsersResponseDto>(it)
    }
    .apply {
        chatId?.let { addParam("chat_id", it, min = 0, max = 100000000) }
        visibleMessagesCount?.let { addParam("visible_messages_count", it, min = 0, max = 1000) }
    }

    /**
     * Allows sending messages from community to the current user.
     *
     * @param groupId - Group ID.
     * @param key
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesAllowMessagesFromGroup(groupId: UserId, key: String? = null):
            VKRequest<BaseOkResponseDto> = NewApiRequest("messages.allowMessagesFromGroup") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        key?.let { addParam("key", it, maxLength = 256) }
    }

    /**
     * Creates a chat with several participants.
     *
     * @param userIds - IDs of the users to be added to the chat.
     * @param title - Chat title.
     * @param groupId
     * @return [VKRequest] with [Int]
     */
    fun messagesCreateChat(
        userIds: List<UserId>? = null,
        title: String? = null,
        groupId: UserId? = null
    ): VKRequest<Int> = NewApiRequest("messages.createChat") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        userIds?.let { addParam("user_ids", it, min = 0) }
        title?.let { addParam("title", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Deletes one or more messages.
     *
     * @param messageIds - Message IDs.
     * @param spam - '1' - to mark message as spam.
     * @param groupId - Group ID (for group messages with user access token)
     * @param deleteForAll - '1' - delete message for for all.
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param cmids - Conversation message IDs.
     * @return [VKRequest] with [Any]
     */
    fun messagesDelete(
        messageIds: List<Int>? = null,
        spam: Boolean? = null,
        groupId: UserId? = null,
        deleteForAll: Boolean? = null,
        peerId: UserId? = null,
        cmids: List<Int>? = null
    ): VKRequest<Any> = NewApiRequest("messages.delete") {
        GsonHolder.gson.parse<Any>(it)
    }
    .apply {
        messageIds?.let { addParam("message_ids", it) }
        spam?.let { addParam("spam", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        deleteForAll?.let { addParam("delete_for_all", it) }
        peerId?.let { addParam("peer_id", it) }
        cmids?.let { addParam("cmids", it) }
    }

    /**
     * Deletes a chat's cover picture.
     *
     * @param chatId - Chat ID.
     * @param groupId
     * @return [VKRequest] with [MessagesDeleteChatPhotoResponseDto]
     */
    fun messagesDeleteChatPhoto(chatId: Int, groupId: UserId? = null):
            VKRequest<MessagesDeleteChatPhotoResponseDto> =
            NewApiRequest("messages.deleteChatPhoto") {
        GsonHolder.gson.parse<MessagesDeleteChatPhotoResponseDto>(it)
    }
    .apply {
        addParam("chat_id", chatId, min = 0, max = 100000000)
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Deletes all private messages in a conversation.
     *
     * @param userId - User ID. To clear a chat history use 'chat_id'
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param groupId - Group ID (for group messages with user access token)
     * @return [VKRequest] with [MessagesDeleteConversationResponseDto]
     */
    fun messagesDeleteConversation(
        userId: UserId? = null,
        peerId: UserId? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesDeleteConversationResponseDto> =
            NewApiRequest("messages.deleteConversation") {
        GsonHolder.gson.parse<MessagesDeleteConversationResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it) }
        peerId?.let { addParam("peer_id", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Delete message reaction
     *
     * @param peerId
     * @param cmid
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun messagesDeleteReaction(peerId: UserId, cmid: Int): VKRequest<BaseBoolIntDto> =
            NewApiRequest("messages.deleteReaction") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        addParam("cmid", cmid, min = 0)
    }

    /**
     * Denies sending message from community to the current user.
     *
     * @param groupId - Group ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesDenyMessagesFromGroup(groupId: UserId): VKRequest<BaseOkResponseDto> =
            NewApiRequest("messages.denyMessagesFromGroup") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
    }

    /**
     * Edits the message.
     *
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param message - (Required if 'attachments' is not set.) Text of the message.
     * @param lat - Geographical latitude of a check-in, in degrees (from -90 to 90).
     * @param long - Geographical longitude of a check-in, in degrees (from -180 to 180).
     * @param attachment - (Required if 'message' is not set.) List of objects attached to the
     * message, separated by commas, in the following format_ "<owner_id>_<media_id>", '' - Type of
     * media attachment_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, 'wall' -
     * wall post, '<owner_id>' - ID of the media attachment owner. '<media_id>' - media attachment ID.
     * Example_ "photo100172_166443618"
     * @param keepForwardMessages - '1' - to keep forwarded, messages.
     * @param keepSnippets - '1' - to keep attached snippets.
     * @param groupId - Group ID (for group messages with user access token)
     * @param dontParseLinks
     * @param disableMentions
     * @param messageId
     * @param cmid
     * @param template
     * @param keyboard
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun messagesEdit(
        peerId: UserId,
        message: String? = null,
        lat: Float? = null,
        long: Float? = null,
        attachment: String? = null,
        keepForwardMessages: Boolean? = null,
        keepSnippets: Boolean? = null,
        groupId: UserId? = null,
        dontParseLinks: Boolean? = null,
        disableMentions: Boolean? = null,
        messageId: Int? = null,
        cmid: Int? = null,
        template: String? = null,
        keyboard: String? = null
    ): VKRequest<BaseBoolIntDto> = NewApiRequest("messages.edit") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        message?.let { addParam("message", it, maxLength = 9000) }
        lat?.let { addParam("lat", it) }
        long?.let { addParam("long", it) }
        attachment?.let { addParam("attachment", it) }
        keepForwardMessages?.let { addParam("keep_forward_messages", it) }
        keepSnippets?.let { addParam("keep_snippets", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        dontParseLinks?.let { addParam("dont_parse_links", it) }
        disableMentions?.let { addParam("disable_mentions", it) }
        messageId?.let { addParam("message_id", it, min = 0) }
        cmid?.let { addParam("cmid", it, min = 0) }
        template?.let { addParam("template", it) }
        keyboard?.let { addParam("keyboard", it) }
    }

    /**
     * Edits the title of a chat.
     *
     * @param chatId - Chat ID.
     * @param title - New title of the chat.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesEditChat(chatId: Int, title: String? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("messages.editChat") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("chat_id", chatId, min = 0, max = 100000000)
        title?.let { addParam("title", it) }
    }

    /**
     * Returns messages by their IDs within the conversation.
     *
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param conversationMessageIds - Conversation message IDs.
     * @param extended - Information whether the response should be extended
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetByConversationMessageIdResponseDto]
     */
    fun messagesGetByConversationMessageId(
        peerId: UserId,
        conversationMessageIds: List<Int>,
        extended: Boolean? = null,
        fields: List<UsersFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetByConversationMessageIdResponseDto> =
            NewApiRequest("messages.getByConversationMessageId") {
        GsonHolder.gson.parse<MessagesGetByConversationMessageIdResponseDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        addParam("conversation_message_ids", conversationMessageIds)
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns messages by their IDs within the conversation.
     *
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param conversationMessageIds - Conversation message IDs.
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetByConversationMessageIdExtendedResponseDto]
     */
    fun messagesGetByConversationMessageIdExtended(
        peerId: UserId,
        conversationMessageIds: List<Int>,
        fields: List<UsersFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetByConversationMessageIdExtendedResponseDto> =
            NewApiRequest("messages.getByConversationMessageId") {
        GsonHolder.gson.parse<MessagesGetByConversationMessageIdExtendedResponseDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        addParam("conversation_message_ids", conversationMessageIds)
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns messages by their IDs.
     *
     * @param messageIds - Message IDs.
     * @param cmids
     * @param previewLength - Number of characters after which to truncate a previewed message. To
     * preview the full message, specify '0'. "NOTE_ Messages are not truncated by default. Messages
     * are truncated by words."
     * @param extended - Information whether the response should be extended
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @param peerId
     * @return [VKRequest] with [MessagesGetByIdResponseDto]
     */
    fun messagesGetById(
        messageIds: List<Int>? = null,
        cmids: List<Int>? = null,
        previewLength: Int? = null,
        extended: Boolean? = null,
        fields: List<UsersFieldsDto>? = null,
        groupId: UserId? = null,
        peerId: UserId? = null
    ): VKRequest<MessagesGetByIdResponseDto> = NewApiRequest("messages.getById") {
        GsonHolder.gson.parse<MessagesGetByIdResponseDto>(it)
    }
    .apply {
        messageIds?.let { addParam("message_ids", it) }
        cmids?.let { addParam("cmids", it) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        peerId?.let { addParam("peer_id", it) }
    }

    /**
     * Returns messages by their IDs.
     *
     * @param messageIds - Message IDs.
     * @param cmids
     * @param previewLength - Number of characters after which to truncate a previewed message. To
     * preview the full message, specify '0'. "NOTE_ Messages are not truncated by default. Messages
     * are truncated by words."
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @param peerId
     * @return [VKRequest] with [MessagesGetByIdExtendedResponseDto]
     */
    fun messagesGetByIdExtended(
        messageIds: List<Int>? = null,
        cmids: List<Int>? = null,
        previewLength: Int? = null,
        fields: List<UsersFieldsDto>? = null,
        groupId: UserId? = null,
        peerId: UserId? = null
    ): VKRequest<MessagesGetByIdExtendedResponseDto> = NewApiRequest("messages.getById") {
        GsonHolder.gson.parse<MessagesGetByIdExtendedResponseDto>(it)
    }
    .apply {
        messageIds?.let { addParam("message_ids", it) }
        cmids?.let { addParam("cmids", it) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        peerId?.let { addParam("peer_id", it) }
    }

    /**
     * Returns information about a chat.
     *
     * @param chatId - Chat ID.
     * @param chatIds - Chat IDs.
     * @param fields - Profile fields to return.
     * @param nameCase - Case for declension of user name and surname_ 'nom' - nominative (default),
     * 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' -
     * prepositional
     * @return [VKRequest] with [MessagesChatFullDto]
     */
    fun messagesGetChat(
        chatId: Int? = null,
        chatIds: List<Int>? = null,
        fields: List<UsersFieldsDto>? = null,
        nameCase: String? = null
    ): VKRequest<MessagesChatFullDto> = NewApiRequest("messages.getChat") {
        GsonHolder.gson.parse<MessagesChatFullDto>(it)
    }
    .apply {
        chatId?.let { addParam("chat_id", it, min = 0, max = 100000000) }
        chatIds?.let { addParam("chat_ids", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        nameCase?.let { addParam("name_case", it) }
    }

    /**
     * @param peerId
     * @param link - Invitation link.
     * @param fields - Profile fields to return.
     * @return [VKRequest] with [MessagesGetChatPreviewResponseDto]
     */
    fun messagesGetChatPreview(
        peerId: Long? = null,
        link: String? = null,
        fields: List<UsersFieldsDto>? = null
    ): VKRequest<MessagesGetChatPreviewResponseDto> = NewApiRequest("messages.getChatPreview") {
        GsonHolder.gson.parse<MessagesGetChatPreviewResponseDto>(it)
    }
    .apply {
        peerId?.let { addParam("peer_id", it) }
        link?.let { addParam("link", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
    }

    /**
     * Returns a list of IDs of users participating in a chat.
     *
     * @param peerId - Peer ID.
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetConversationMembersDto]
     */
    fun messagesGetConversationMembers(
        peerId: UserId,
        fields: List<UsersFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetConversationMembersDto> =
            NewApiRequest("messages.getConversationMembers") {
        GsonHolder.gson.parse<MessagesGetConversationMembersDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns a list of the current user's conversations.
     *
     * @param offset - Offset needed to return a specific subset of conversations.
     * @param count - Number of conversations to return.
     * @param filter - Filter to apply_ 'all' - all conversations, 'unread' - conversations with
     * unread messages, 'important' - conversations, marked as important (only for community messages),
     * 'unanswered' - conversations, marked as unanswered (only for community messages)
     * @param extended - '1' - return extra information about users and communities
     * @param startMessageId - ID of the message from what to return dialogs.
     * @param fields - Profile and communities fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetConversationsResponseDto]
     */
    fun messagesGetConversations(
        offset: Int? = null,
        count: Int? = null,
        filter: MessagesGetConversationsFilterDto? = null,
        extended: Boolean? = null,
        startMessageId: Int? = null,
        fields: List<BaseUserGroupFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetConversationsResponseDto> = NewApiRequest("messages.getConversations") {
        GsonHolder.gson.parse<MessagesGetConversationsResponseDto>(it)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        filter?.let { addParam("filter", it.value) }
        extended?.let { addParam("extended", it) }
        startMessageId?.let { addParam("start_message_id", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns conversations by their IDs
     *
     * @param peerIds - Destination IDs. "For user_ 'User ID', e.g. '12345'. For chat_
     * '2000000000' + 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param extended - Return extended properties
     * @param fields - Profile and communities fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetConversationByIdDto]
     */
    fun messagesGetConversationsById(
        peerIds: List<UserId>,
        extended: Boolean? = null,
        fields: List<BaseUserGroupFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetConversationByIdDto> = NewApiRequest("messages.getConversationsById") {
        GsonHolder.gson.parse<MessagesGetConversationByIdDto>(it)
    }
    .apply {
        addParam("peer_ids", peerIds)
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns conversations by their IDs
     *
     * @param peerIds - Destination IDs. "For user_ 'User ID', e.g. '12345'. For chat_
     * '2000000000' + 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param fields - Profile and communities fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetConversationByIdExtendedDto]
     */
    fun messagesGetConversationsByIdExtended(
        peerIds: List<UserId>,
        fields: List<BaseUserGroupFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetConversationByIdExtendedDto> =
            NewApiRequest("messages.getConversationsById") {
        GsonHolder.gson.parse<MessagesGetConversationByIdExtendedDto>(it)
    }
    .apply {
        addParam("peer_ids", peerIds)
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns message history for the specified user or group chat.
     *
     * @param offset - Offset needed to return a specific subset of messages.
     * @param count - Number of messages to return.
     * @param userId - ID of the user whose message history you want to return.
     * @param peerId
     * @param startMessageId - Starting message ID from which to return history.
     * @param rev - Sort order_ '1' - return messages in chronological order. '0' - return messages
     * in reverse chronological order.
     * @param extended - Information whether the response should be extended
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetHistoryResponseDto]
     */
    fun messagesGetHistory(
        offset: Int? = null,
        count: Int? = null,
        userId: UserId? = null,
        peerId: UserId? = null,
        startMessageId: Int? = null,
        rev: MessagesGetHistoryRevDto? = null,
        extended: Boolean? = null,
        fields: List<UsersFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetHistoryResponseDto> = NewApiRequest("messages.getHistory") {
        GsonHolder.gson.parse<MessagesGetHistoryResponseDto>(it)
    }
    .apply {
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        userId?.let { addParam("user_id", it) }
        peerId?.let { addParam("peer_id", it) }
        startMessageId?.let { addParam("start_message_id", it) }
        rev?.let { addParam("rev", it.value) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns message history for the specified user or group chat.
     *
     * @param offset - Offset needed to return a specific subset of messages.
     * @param count - Number of messages to return.
     * @param userId - ID of the user whose message history you want to return.
     * @param peerId
     * @param startMessageId - Starting message ID from which to return history.
     * @param rev - Sort order_ '1' - return messages in chronological order. '0' - return messages
     * in reverse chronological order.
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetHistoryExtendedResponseDto]
     */
    fun messagesGetHistoryExtended(
        offset: Int? = null,
        count: Int? = null,
        userId: UserId? = null,
        peerId: UserId? = null,
        startMessageId: Int? = null,
        rev: MessagesGetHistoryExtendedRevDto? = null,
        fields: List<UsersFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetHistoryExtendedResponseDto> = NewApiRequest("messages.getHistory") {
        GsonHolder.gson.parse<MessagesGetHistoryExtendedResponseDto>(it)
    }
    .apply {
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        userId?.let { addParam("user_id", it) }
        peerId?.let { addParam("peer_id", it) }
        startMessageId?.let { addParam("start_message_id", it) }
        rev?.let { addParam("rev", it.value) }
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns media files from the dialog or group chat.
     *
     * @param attachmentTypes
     * @param groupId - Group ID (for group messages with group access token)
     * @param peerId - Peer ID. ", For group chat_ '2000000000 + chat ID' , , For community_
     * '-community ID'"
     * @param cmid
     * @param attachmentPosition
     * @param offset
     * @param count - Number of objects to return.
     * @param extended
     * @param fields - Additional profile [vk.com/dev/fields|fields] to return. 
     * @param maxForwardsLevel
     * @param mediaType - Type of media files to return_ *'photo',, *'video',, *'audio',, *'doc',,
     * *'link'.,*'market'.,*'wall'.,*'share'
     * @param startFrom - Message ID to start return results from.
     * @param preserveOrder
     * @param photoSizes - '1' - to return photo sizes in a
     * @return [VKRequest] with [MessagesGetHistoryAttachmentsResponseDto]
     */
    fun messagesGetHistoryAttachments(
        attachmentTypes: List<MessagesGetHistoryAttachmentsAttachmentTypesDto>? = null,
        groupId: UserId? = null,
        peerId: UserId? = null,
        cmid: Int? = null,
        attachmentPosition: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        extended: Boolean? = null,
        fields: List<UsersFieldsDto>? = null,
        maxForwardsLevel: Int? = null,
        mediaType: MessagesGetHistoryAttachmentsMediaTypeDto? = null,
        startFrom: String? = null,
        preserveOrder: Boolean? = null,
        photoSizes: Boolean? = null
    ): VKRequest<MessagesGetHistoryAttachmentsResponseDto> =
            NewApiRequest("messages.getHistoryAttachments") {
        GsonHolder.gson.parse<MessagesGetHistoryAttachmentsResponseDto>(it)
    }
    .apply {
        val attachmentTypesJsonConverted = attachmentTypes?.map {
            it.value
        }
        attachmentTypesJsonConverted?.let { addParam("attachment_types", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        peerId?.let { addParam("peer_id", it) }
        cmid?.let { addParam("cmid", it, min = 0) }
        attachmentPosition?.let { addParam("attachment_position", it, min = 1, max = 200) }
        offset?.let { addParam("offset", it, min = -200, max = 200) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        maxForwardsLevel?.let { addParam("max_forwards_level", it, min = 0, max = 45) }
        mediaType?.let { addParam("media_type", it.value) }
        startFrom?.let { addParam("start_from", it) }
        preserveOrder?.let { addParam("preserve_order", it) }
        photoSizes?.let { addParam("photo_sizes", it) }
    }

    /**
     * Returns a list of user's important messages.
     *
     * @param count - Amount of needed important messages.
     * @param offset
     * @param startMessageId
     * @param previewLength - Maximum length of messages body.
     * @param fields - Actors fields to return.
     * @param extended - Return extended properties
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetImportantMessagesResponseDto]
     */
    fun messagesGetImportantMessages(
        count: Int? = null,
        offset: Int? = null,
        startMessageId: Int? = null,
        previewLength: Int? = null,
        fields: List<BaseUserGroupFieldsDto>? = null,
        extended: Boolean? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetImportantMessagesResponseDto> =
            NewApiRequest("messages.getImportantMessages") {
        GsonHolder.gson.parse<MessagesGetImportantMessagesResponseDto>(it)
    }
    .apply {
        count?.let { addParam("count", it, min = 0, max = 200) }
        offset?.let { addParam("offset", it, min = 0) }
        startMessageId?.let { addParam("start_message_id", it, min = 0) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        extended?.let { addParam("extended", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns a list of user's important messages.
     *
     * @param count - Amount of needed important messages.
     * @param offset
     * @param startMessageId
     * @param previewLength - Maximum length of messages body.
     * @param fields - Actors fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetImportantMessagesExtendedResponseDto]
     */
    fun messagesGetImportantMessagesExtended(
        count: Int? = null,
        offset: Int? = null,
        startMessageId: Int? = null,
        previewLength: Int? = null,
        fields: List<BaseUserGroupFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetImportantMessagesExtendedResponseDto> =
            NewApiRequest("messages.getImportantMessages") {
        GsonHolder.gson.parse<MessagesGetImportantMessagesExtendedResponseDto>(it)
    }
    .apply {
        count?.let { addParam("count", it, min = 0, max = 200) }
        offset?.let { addParam("offset", it, min = 0) }
        startMessageId?.let { addParam("start_message_id", it, min = 0) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        addParam("extended", true)
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * @param intent
     * @param subscribeId
     * @param offset
     * @param count
     * @param extended
     * @param nameCase
     * @param fields
     * @return [VKRequest] with [MessagesGetIntentUsersResponseDto]
     */
    fun messagesGetIntentUsers(
        intent: MessagesGetIntentUsersIntentDto,
        subscribeId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        extended: Boolean? = null,
        nameCase: List<String>? = null,
        fields: List<String>? = null
    ): VKRequest<MessagesGetIntentUsersResponseDto> = NewApiRequest("messages.getIntentUsers") {
        GsonHolder.gson.parse<MessagesGetIntentUsersResponseDto>(it)
    }
    .apply {
        addParam("intent", intent.value)
        subscribeId?.let { addParam("subscribe_id", it, min = 0, max = 100) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        extended?.let { addParam("extended", it) }
        nameCase?.let { addParam("name_case", it) }
        fields?.let { addParam("fields", it) }
    }

    /**
     * @param peerId - Destination ID.
     * @param reset - 1 - to generate new link (revoke previous), 0 - to return previous link.
     * @param groupId - Group ID
     * @return [VKRequest] with [MessagesGetInviteLinkResponseDto]
     */
    fun messagesGetInviteLink(
        peerId: Long,
        reset: Boolean? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetInviteLinkResponseDto> = NewApiRequest("messages.getInviteLink") {
        GsonHolder.gson.parse<MessagesGetInviteLinkResponseDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        reset?.let { addParam("reset", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns a user's current status and date of last activity.
     *
     * @param userId - User ID.
     * @return [VKRequest] with [MessagesLastActivityDto]
     */
    fun messagesGetLastActivity(userId: UserId): VKRequest<MessagesLastActivityDto> =
            NewApiRequest("messages.getLastActivity") {
        GsonHolder.gson.parse<MessagesLastActivityDto>(it)
    }
    .apply {
        addParam("user_id", userId)
    }

    /**
     * Returns updates in user's private messages.
     *
     * @param ts - Last value of the 'ts' parameter returned from the Long Poll server or by using
     * [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method.
     * @param pts - Last value of 'pts' parameter returned from the Long Poll server or by using
     * [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method.
     * @param previewLength - Number of characters after which to truncate a previewed message. To
     * preview the full message, specify '0'. "NOTE_ Messages are not truncated by default. Messages
     * are truncated by words."
     * @param onlines - '1' - to return history with online users only.
     * @param fields - Additional profile [vk.com/dev/fields|fields] to return.
     * @param eventsLimit - Maximum number of events to return.
     * @param msgsLimit - Maximum number of messages to return.
     * @param maxMsgId - Maximum ID of the message among existing ones in the local copy. Both
     * messages received with API methods (for example, , ), and data received from a Long Poll server
     * (events with code 4) are taken into account.
     * @param groupId - Group ID (for group messages with user access token)
     * @param lpVersion
     * @param lastN
     * @param credentials
     * @param extended
     * @return [VKRequest] with [MessagesGetLongPollHistoryResponseDto]
     */
    fun messagesGetLongPollHistory(
        ts: Int? = null,
        pts: Int? = null,
        previewLength: Int? = null,
        onlines: Boolean? = null,
        fields: List<UsersFieldsDto>? = null,
        eventsLimit: Int? = null,
        msgsLimit: Int? = null,
        maxMsgId: Int? = null,
        groupId: UserId? = null,
        lpVersion: Int? = null,
        lastN: Int? = null,
        credentials: Boolean? = null,
        extended: Boolean? = null
    ): VKRequest<MessagesGetLongPollHistoryResponseDto> =
            NewApiRequest("messages.getLongPollHistory") {
        GsonHolder.gson.parse<MessagesGetLongPollHistoryResponseDto>(it)
    }
    .apply {
        ts?.let { addParam("ts", it, min = 0) }
        pts?.let { addParam("pts", it, min = 0) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
        onlines?.let { addParam("onlines", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        eventsLimit?.let { addParam("events_limit", it, min = 1000) }
        msgsLimit?.let { addParam("msgs_limit", it, min = 200) }
        maxMsgId?.let { addParam("max_msg_id", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
        lpVersion?.let { addParam("lp_version", it, min = 0) }
        lastN?.let { addParam("last_n", it, min = 0, max = 2000) }
        credentials?.let { addParam("credentials", it) }
        extended?.let { addParam("extended", it) }
    }

    /**
     * Returns data required for connection to a Long Poll server.
     *
     * @param needPts - '1' - to return the 'pts' field, needed for the
     * [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method.
     * @param groupId - Group ID (for group messages with user access token)
     * @param lpVersion - Long poll version
     * @return [VKRequest] with [MessagesLongpollParamsDto]
     */
    fun messagesGetLongPollServer(
        needPts: Boolean? = null,
        groupId: UserId? = null,
        lpVersion: Int? = null
    ): VKRequest<MessagesLongpollParamsDto> = NewApiRequest("messages.getLongPollServer") {
        GsonHolder.gson.parse<MessagesLongpollParamsDto>(it)
    }
    .apply {
        needPts?.let { addParam("need_pts", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        lpVersion?.let { addParam("lp_version", it, min = 0) }
    }

    /**
     * Get reaction counters for message
     *
     * @param peerId
     * @param cmids
     * @return [VKRequest] with [MessagesGetMessagesReactionsResponseDto]
     */
    fun messagesGetMessagesReactions(peerId: UserId, cmids: List<Int>):
            VKRequest<MessagesGetMessagesReactionsResponseDto> =
            NewApiRequest("messages.getMessagesReactions") {
        GsonHolder.gson.parse<MessagesGetMessagesReactionsResponseDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        addParam("cmids", cmids)
    }

    /**
     * Get reacted users and counters for message
     *
     * @param peerId
     * @param cmid
     * @param reactionId
     * @return [VKRequest] with [MessagesGetReactedPeersResponseDto]
     */
    fun messagesGetReactedPeers(
        peerId: UserId,
        cmid: Int,
        reactionId: Int? = null
    ): VKRequest<MessagesGetReactedPeersResponseDto> = NewApiRequest("messages.getReactedPeers") {
        GsonHolder.gson.parse<MessagesGetReactedPeersResponseDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        addParam("cmid", cmid, min = 0)
        reactionId?.let { addParam("reaction_id", it, min = 0) }
    }

    /**
     * Get assets to display message reactions
     *
     * @param clientVersion
     * @return [VKRequest] with [MessagesGetReactionsAssetsResponseDto]
     */
    fun messagesGetReactionsAssets(clientVersion: Int? = null):
            VKRequest<MessagesGetReactionsAssetsResponseDto> =
            NewApiRequest("messages.getReactionsAssets") {
        GsonHolder.gson.parse<MessagesGetReactionsAssetsResponseDto>(it)
    }
    .apply {
        clientVersion?.let { addParam("client_version", it, min = 1) }
    }

    /**
     * Returns information whether sending messages from the community to current user is allowed.
     *
     * @param groupId - Group ID.
     * @param userId - User ID.
     * @return [VKRequest] with [MessagesIsMessagesFromGroupAllowedResponseDto]
     */
    fun messagesIsMessagesFromGroupAllowed(groupId: UserId, userId: UserId):
            VKRequest<MessagesIsMessagesFromGroupAllowedResponseDto> =
            NewApiRequest("messages.isMessagesFromGroupAllowed") {
        GsonHolder.gson.parse<MessagesIsMessagesFromGroupAllowedResponseDto>(it)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("user_id", userId, min = 1)
    }

    /**
     * @param link - Invitation link.
     * @return [VKRequest] with [MessagesJoinChatByInviteLinkResponseDto]
     */
    fun messagesJoinChatByInviteLink(link: String):
            VKRequest<MessagesJoinChatByInviteLinkResponseDto> =
            NewApiRequest("messages.joinChatByInviteLink") {
        GsonHolder.gson.parse<MessagesJoinChatByInviteLinkResponseDto>(it)
    }
    .apply {
        addParam("link", link)
    }

    /**
     * Marks and unmarks conversations as unanswered.
     *
     * @param peerId - ID of conversation to mark as important.
     * @param answered - '1' - to mark as answered, '0' - to remove the mark
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesMarkAsAnsweredConversation(
        peerId: UserId,
        answered: Boolean? = null,
        groupId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("messages.markAsAnsweredConversation") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        answered?.let { addParam("answered", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Marks and unmarks messages as important (starred).
     *
     * @param messageIds - IDs of messages to mark as important.
     * @param important - '1' - to add a star (mark as important), '0' - to remove the star
     * @return [VKRequest] with [Unit]
     */
    fun messagesMarkAsImportant(messageIds: List<Int>? = null, important: Int? = null):
            VKRequest<List<Int>> = NewApiRequest("messages.markAsImportant") {
        GsonHolder.gson.parseList<Int>(it)
    }
    .apply {
        messageIds?.let { addParam("message_ids", it) }
        important?.let { addParam("important", it, min = 0) }
    }

    /**
     * Marks and unmarks conversations as important.
     *
     * @param peerId - ID of conversation to mark as important.
     * @param important - '1' - to add a star (mark as important), '0' - to remove the star
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesMarkAsImportantConversation(
        peerId: UserId,
        important: Boolean? = null,
        groupId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("messages.markAsImportantConversation") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        important?.let { addParam("important", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Marks messages as read.
     *
     * @param messageIds - IDs of messages to mark as read.
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param startMessageId - Message ID to start from.
     * @param groupId - Group ID (for group messages with user access token)
     * @param markConversationAsRead
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesMarkAsRead(
        messageIds: List<Int>? = null,
        peerId: UserId? = null,
        startMessageId: Int? = null,
        groupId: UserId? = null,
        markConversationAsRead: Boolean? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("messages.markAsRead") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        messageIds?.let { addParam("message_ids", it) }
        peerId?.let { addParam("peer_id", it) }
        startMessageId?.let { addParam("start_message_id", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
        markConversationAsRead?.let { addParam("mark_conversation_as_read", it) }
    }

    /**
     * Mark messages reactions as read
     *
     * @param peerId
     * @param cmids
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun messagesMarkReactionsAsRead(peerId: UserId, cmids: List<Int>? = null):
            VKRequest<BaseBoolIntDto> = NewApiRequest("messages.markReactionsAsRead") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        cmids?.let { addParam("cmids", it) }
    }

    /**
     * Pin a message.
     *
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'Chat ID', e.g. '2000000001'. For community_ '- Community ID', e.g. '-12345'. "
     * @param messageId - Message ID
     * @param cmid - Conversation message ID
     * @return [VKRequest] with [MessagesPinnedMessageDto]
     */
    fun messagesPin(
        peerId: Long,
        messageId: Int? = null,
        cmid: Int? = null
    ): VKRequest<MessagesPinnedMessageDto> = NewApiRequest("messages.pin") {
        GsonHolder.gson.parse<MessagesPinnedMessageDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        messageId?.let { addParam("message_id", it, min = 0) }
        cmid?.let { addParam("cmid", it, min = 0) }
    }

    /**
     * Allows the current user to leave a chat or, if the current user started the chat, allows the
     * user to remove another user from the chat.
     *
     * @param chatId - Chat ID.
     * @param userId - ID of the user to be removed from the chat.
     * @param memberId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesRemoveChatUser(
        chatId: Int,
        userId: UserId? = null,
        memberId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("messages.removeChatUser") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("chat_id", chatId, min = 0, max = 100000000)
        userId?.let { addParam("user_id", it) }
        memberId?.let { addParam("member_id", it) }
    }

    /**
     * Restores a deleted message.
     *
     * @param messageId - ID of a previously-deleted message to restore.
     * @param cmid
     * @param groupId - Group ID (for group messages with user access token)
     * @param peerId - Destination ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesRestore(
        messageId: Int? = null,
        cmid: Int? = null,
        groupId: UserId? = null,
        peerId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("messages.restore") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        messageId?.let { addParam("message_id", it, min = 0) }
        cmid?.let { addParam("cmid", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
        peerId?.let { addParam("peer_id", it) }
    }

    /**
     * Returns a list of the current user's private messages that match search criteria.
     *
     * @param q - Search query string.
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param date - Date to search message before in Unixtime.
     * @param previewLength - Number of characters after which to truncate a previewed message. To
     * preview the full message, specify '0'. "NOTE_ Messages are not truncated by default. Messages
     * are truncated by words."
     * @param offset - Offset needed to return a specific subset of messages.
     * @param count - Number of messages to return.
     * @param extended
     * @param fields
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesSearchResponseDto]
     */
    fun messagesSearch(
        q: String? = null,
        peerId: UserId? = null,
        date: Int? = null,
        previewLength: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        extended: Boolean? = null,
        fields: List<String>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesSearchResponseDto> = NewApiRequest("messages.search") {
        GsonHolder.gson.parse<MessagesSearchResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it, maxLength = 9000) }
        peerId?.let { addParam("peer_id", it) }
        date?.let { addParam("date", it, min = 0) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        extended?.let { addParam("extended", it) }
        fields?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns a list of the current user's private messages that match search criteria.
     *
     * @param q - Search query string.
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param date - Date to search message before in Unixtime.
     * @param previewLength - Number of characters after which to truncate a previewed message. To
     * preview the full message, specify '0'. "NOTE_ Messages are not truncated by default. Messages
     * are truncated by words."
     * @param offset - Offset needed to return a specific subset of messages.
     * @param count - Number of messages to return.
     * @param fields
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesSearchExtendedResponseDto]
     */
    fun messagesSearchExtended(
        q: String? = null,
        peerId: UserId? = null,
        date: Int? = null,
        previewLength: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<String>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesSearchExtendedResponseDto> = NewApiRequest("messages.search") {
        GsonHolder.gson.parse<MessagesSearchExtendedResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it, maxLength = 9000) }
        peerId?.let { addParam("peer_id", it) }
        date?.let { addParam("date", it, min = 0) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        addParam("extended", true)
        fields?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns a list of the current user's conversations that match search criteria.
     *
     * @param q - Search query string.
     * @param count - Maximum number of results.
     * @param extended - '1' - return extra information about users and communities
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with user access token)
     * @return [VKRequest] with [MessagesSearchConversationsResponseDto]
     */
    fun messagesSearchConversations(
        q: String? = null,
        count: Int? = null,
        extended: Boolean? = null,
        fields: List<UsersFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesSearchConversationsResponseDto> =
            NewApiRequest("messages.searchConversations") {
        GsonHolder.gson.parse<MessagesSearchConversationsResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it) }
        count?.let { addParam("count", it, min = 1, max = 255) }
        extended?.let { addParam("extended", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns a list of the current user's conversations that match search criteria.
     *
     * @param q - Search query string.
     * @param count - Maximum number of results.
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with user access token)
     * @return [VKRequest] with [MessagesSearchConversationsExtendedResponseDto]
     */
    fun messagesSearchConversationsExtended(
        q: String? = null,
        count: Int? = null,
        fields: List<UsersFieldsDto>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesSearchConversationsExtendedResponseDto> =
            NewApiRequest("messages.searchConversations") {
        GsonHolder.gson.parse<MessagesSearchConversationsExtendedResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it) }
        count?.let { addParam("count", it, min = 1, max = 255) }
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Sends a message.
     *
     * @param userId - User ID (by default - current user).
     * @param randomId - Unique identifier to avoid resending the message.
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param peerIds - IDs of message recipients. (See peer_id)
     * @param domain - User's short address (for example, 'illarionov').
     * @param chatId - ID of conversation the message will relate to.
     * @param userIds - IDs of message recipients (if new conversation shall be started).
     * @param message - (Required if 'attachments' is not set.) Text of the message.
     * @param lat - Geographical latitude of a check-in, in degrees (from -90 to 90).
     * @param long - Geographical longitude of a check-in, in degrees (from -180 to 180).
     * @param attachment - (Required if 'message' is not set.) List of objects attached to the
     * message, separated by commas, in the following format_ "<owner_id>_<media_id>", '' - Type of
     * media attachment_ 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, 'wall' -
     * wall post, '<owner_id>' - ID of the media attachment owner. '<media_id>' - media attachment ID.
     * Example_ "photo100172_166443618"
     * @param replyTo
     * @param forwardMessages - ID of forwarded messages, separated with a comma. Listed messages of
     * the sender will be shown in the message body at the recipient's. Example_ "123,431,544"
     * @param forward - JSON describing the forwarded message or reply
     * @param stickerId - Sticker id.
     * @param groupId - Group ID (for group messages with group access token)
     * @param keyboard
     * @param template
     * @param payload
     * @param contentSource - JSON describing the content source in the message
     * @param dontParseLinks
     * @param disableMentions
     * @param intent
     * @param subscribeId
     * @return [VKRequest] with [Int]
     */
    fun messagesSend(
        userId: UserId? = null,
        randomId: Int? = null,
        peerId: UserId? = null,
        peerIds: List<UserId>? = null,
        domain: String? = null,
        chatId: Int? = null,
        userIds: List<UserId>? = null,
        message: String? = null,
        lat: Float? = null,
        long: Float? = null,
        attachment: String? = null,
        replyTo: Int? = null,
        forwardMessages: List<Int>? = null,
        forward: String? = null,
        stickerId: Int? = null,
        groupId: UserId? = null,
        keyboard: String? = null,
        template: String? = null,
        payload: String? = null,
        contentSource: String? = null,
        dontParseLinks: Boolean? = null,
        disableMentions: Boolean? = null,
        intent: MessagesSendIntentDto? = null,
        subscribeId: Int? = null
    ): VKRequest<Int> = NewApiRequest("messages.send") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it) }
        randomId?.let { addParam("random_id", it) }
        peerId?.let { addParam("peer_id", it) }
        peerIds?.let { addParam("peer_ids", it) }
        domain?.let { addParam("domain", it) }
        chatId?.let { addParam("chat_id", it, min = 0, max = 100000000) }
        userIds?.let { addParam("user_ids", it) }
        message?.let { addParam("message", it, maxLength = 9000) }
        lat?.let { addParam("lat", it) }
        long?.let { addParam("long", it) }
        attachment?.let { addParam("attachment", it, maxLength = 9000) }
        replyTo?.let { addParam("reply_to", it) }
        forwardMessages?.let { addParam("forward_messages", it) }
        forward?.let { addParam("forward", it) }
        stickerId?.let { addParam("sticker_id", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
        keyboard?.let { addParam("keyboard", it) }
        template?.let { addParam("template", it) }
        payload?.let { addParam("payload", it, maxLength = 1000) }
        contentSource?.let { addParam("content_source", it) }
        dontParseLinks?.let { addParam("dont_parse_links", it) }
        disableMentions?.let { addParam("disable_mentions", it) }
        intent?.let { addParam("intent", it.value) }
        subscribeId?.let { addParam("subscribe_id", it, min = 0, max = 100) }
    }

    /**
     * @param eventId
     * @param userId
     * @param peerId
     * @param eventData
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesSendMessageEventAnswer(
        eventId: String,
        userId: UserId,
        peerId: UserId,
        eventData: String? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("messages.sendMessageEventAnswer") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("event_id", eventId)
        addParam("user_id", userId)
        addParam("peer_id", peerId)
        eventData?.let { addParam("event_data", it, maxLength = 1000) }
    }

    /**
     * Send message reaction
     *
     * @param peerId
     * @param cmid
     * @param reactionId
     * @return [VKRequest] with [BaseBoolIntDto]
     */
    fun messagesSendReaction(
        peerId: UserId,
        cmid: Int,
        reactionId: Int
    ): VKRequest<BaseBoolIntDto> = NewApiRequest("messages.sendReaction") {
        GsonHolder.gson.parse<BaseBoolIntDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        addParam("cmid", cmid, min = 0)
        addParam("reaction_id", reactionId, min = 0)
    }

    /**
     * Changes the status of a user as typing in a conversation.
     *
     * @param userId - User ID.
     * @param type - 'typing' - user has started to type.
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesSetActivity(
        userId: UserId? = null,
        type: MessagesSetActivityTypeDto? = null,
        peerId: UserId? = null,
        groupId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("messages.setActivity") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it) }
        type?.let { addParam("type", it.value) }
        peerId?.let { addParam("peer_id", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Sets a previously-uploaded picture as the cover picture of a chat.
     *
     * @param file - Upload URL from the 'response' field returned by the
     * [vk.com/dev/photos.getChatUploadServer|photos.getChatUploadServer] method upon successfully
     * uploading an image.
     * @return [VKRequest] with [MessagesSetChatPhotoResponseDto]
     */
    fun messagesSetChatPhoto(file: String): VKRequest<MessagesSetChatPhotoResponseDto> =
            NewApiRequest("messages.setChatPhoto") {
        GsonHolder.gson.parse<MessagesSetChatPhotoResponseDto>(it)
    }
    .apply {
        addParam("file", file)
    }

    /**
     * @param peerId
     * @param groupId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun messagesUnpin(peerId: Long, groupId: UserId? = null): VKRequest<BaseOkResponseDto> =
            NewApiRequest("messages.unpin") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("peer_id", peerId)
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    object MessagesAddChatUserRestrictions {
        const val CHAT_ID_MIN: Long = 0

        const val CHAT_ID_MAX: Long = 100000000

        const val USER_ID_MIN: Long = 0

        const val VISIBLE_MESSAGES_COUNT_MIN: Long = 0

        const val VISIBLE_MESSAGES_COUNT_MAX: Long = 1000
    }

    object MessagesAddChatUsersRestrictions {
        const val CHAT_ID_MIN: Long = 0

        const val CHAT_ID_MAX: Long = 100000000

        const val VISIBLE_MESSAGES_COUNT_MIN: Long = 0

        const val VISIBLE_MESSAGES_COUNT_MAX: Long = 1000
    }

    object MessagesAllowMessagesFromGroupRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val KEY_MAX_LENGTH: Int = 256
    }

    object MessagesCreateChatRestrictions {
        const val USER_IDS_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesDeleteRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesDeleteChatPhotoRestrictions {
        const val CHAT_ID_MIN: Long = 0

        const val CHAT_ID_MAX: Long = 100000000

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesDeleteConversationRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesDeleteReactionRestrictions {
        const val CMID_MIN: Long = 0
    }

    object MessagesDenyMessagesFromGroupRestrictions {
        const val GROUP_ID_MIN: Long = 1
    }

    object MessagesEditRestrictions {
        const val MESSAGE_MAX_LENGTH: Int = 9000

        const val GROUP_ID_MIN: Long = 0

        const val MESSAGE_ID_MIN: Long = 0

        const val CMID_MIN: Long = 0
    }

    object MessagesEditChatRestrictions {
        const val CHAT_ID_MIN: Long = 0

        const val CHAT_ID_MAX: Long = 100000000
    }

    object MessagesGetByConversationMessageIdRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetByConversationMessageIdExtendedRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetByIdRestrictions {
        const val PREVIEW_LENGTH_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetByIdExtendedRestrictions {
        const val PREVIEW_LENGTH_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetChatRestrictions {
        const val CHAT_ID_MIN: Long = 0

        const val CHAT_ID_MAX: Long = 100000000
    }

    object MessagesGetConversationMembersRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetConversationsRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200

        const val START_MESSAGE_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetConversationsByIdRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetConversationsByIdExtendedRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetHistoryRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetHistoryExtendedRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetHistoryAttachmentsRestrictions {
        const val GROUP_ID_MIN: Long = 0

        const val CMID_MIN: Long = 0

        const val ATTACHMENT_POSITION_MIN: Long = 1

        const val ATTACHMENT_POSITION_MAX: Long = 200

        const val OFFSET_MIN: Long = -200

        const val OFFSET_MAX: Long = 200

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200

        const val MAX_FORWARDS_LEVEL_MIN: Long = 0

        const val MAX_FORWARDS_LEVEL_MAX: Long = 45
    }

    object MessagesGetImportantMessagesRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200

        const val OFFSET_MIN: Long = 0

        const val START_MESSAGE_ID_MIN: Long = 0

        const val PREVIEW_LENGTH_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetImportantMessagesExtendedRestrictions {
        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200

        const val OFFSET_MIN: Long = 0

        const val START_MESSAGE_ID_MIN: Long = 0

        const val PREVIEW_LENGTH_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetIntentUsersRestrictions {
        const val SUBSCRIBE_ID_MIN: Long = 0

        const val SUBSCRIBE_ID_MAX: Long = 100

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 200
    }

    object MessagesGetInviteLinkRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesGetLongPollHistoryRestrictions {
        const val TS_MIN: Long = 0

        const val PTS_MIN: Long = 0

        const val PREVIEW_LENGTH_MIN: Long = 0

        const val EVENTS_LIMIT_MIN: Long = 1000

        const val MSGS_LIMIT_MIN: Long = 200

        const val MAX_MSG_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0

        const val LP_VERSION_MIN: Long = 0

        const val LAST_N_MIN: Long = 0

        const val LAST_N_MAX: Long = 2000
    }

    object MessagesGetLongPollServerRestrictions {
        const val GROUP_ID_MIN: Long = 0

        const val LP_VERSION_MIN: Long = 0
    }

    object MessagesGetReactedPeersRestrictions {
        const val CMID_MIN: Long = 0

        const val REACTION_ID_MIN: Long = 0
    }

    object MessagesGetReactionsAssetsRestrictions {
        const val CLIENT_VERSION_MIN: Long = 1
    }

    object MessagesIsMessagesFromGroupAllowedRestrictions {
        const val GROUP_ID_MIN: Long = 1

        const val USER_ID_MIN: Long = 1
    }

    object MessagesMarkAsAnsweredConversationRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesMarkAsImportantRestrictions {
        const val IMPORTANT_MIN: Long = 0
    }

    object MessagesMarkAsImportantConversationRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesMarkAsReadRestrictions {
        const val START_MESSAGE_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesPinRestrictions {
        const val MESSAGE_ID_MIN: Long = 0

        const val CMID_MIN: Long = 0
    }

    object MessagesRemoveChatUserRestrictions {
        const val CHAT_ID_MIN: Long = 0

        const val CHAT_ID_MAX: Long = 100000000
    }

    object MessagesRestoreRestrictions {
        const val MESSAGE_ID_MIN: Long = 0

        const val CMID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesSearchRestrictions {
        const val Q_MAX_LENGTH: Int = 9000

        const val DATE_MIN: Long = 0

        const val PREVIEW_LENGTH_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesSearchExtendedRestrictions {
        const val Q_MAX_LENGTH: Int = 9000

        const val DATE_MIN: Long = 0

        const val PREVIEW_LENGTH_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesSearchConversationsRestrictions {
        const val COUNT_MIN: Long = 1

        const val COUNT_MAX: Long = 255

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesSearchConversationsExtendedRestrictions {
        const val COUNT_MIN: Long = 1

        const val COUNT_MAX: Long = 255

        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesSendRestrictions {
        const val CHAT_ID_MIN: Long = 0

        const val CHAT_ID_MAX: Long = 100000000

        const val MESSAGE_MAX_LENGTH: Int = 9000

        const val ATTACHMENT_MAX_LENGTH: Int = 9000

        const val STICKER_ID_MIN: Long = 0

        const val GROUP_ID_MIN: Long = 0

        const val PAYLOAD_MAX_LENGTH: Int = 1000

        const val SUBSCRIBE_ID_MIN: Long = 0

        const val SUBSCRIBE_ID_MAX: Long = 100
    }

    object MessagesSendMessageEventAnswerRestrictions {
        const val EVENT_DATA_MAX_LENGTH: Int = 1000
    }

    object MessagesSendReactionRestrictions {
        const val CMID_MIN: Long = 0

        const val REACTION_ID_MIN: Long = 0
    }

    object MessagesSetActivityRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object MessagesUnpinRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }
}
