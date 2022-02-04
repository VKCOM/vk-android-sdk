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

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseBoolInt
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.base.dto.BaseUserGroupFields
import com.vk.sdk.api.messages.dto.MessagesDeleteChatPhotoResponse
import com.vk.sdk.api.messages.dto.MessagesDeleteConversationResponse
import com.vk.sdk.api.messages.dto.MessagesGetByConversationMessageIdExtendedResponse
import com.vk.sdk.api.messages.dto.MessagesGetByConversationMessageIdResponse
import com.vk.sdk.api.messages.dto.MessagesGetByIdExtendedResponse
import com.vk.sdk.api.messages.dto.MessagesGetByIdResponse
import com.vk.sdk.api.messages.dto.MessagesGetChatPreviewResponse
import com.vk.sdk.api.messages.dto.MessagesGetConversationById
import com.vk.sdk.api.messages.dto.MessagesGetConversationByIdExtended
import com.vk.sdk.api.messages.dto.MessagesGetConversationMembers
import com.vk.sdk.api.messages.dto.MessagesGetConversationsFilter
import com.vk.sdk.api.messages.dto.MessagesGetConversationsResponse
import com.vk.sdk.api.messages.dto.MessagesGetHistoryAttachmentsMediaType
import com.vk.sdk.api.messages.dto.MessagesGetHistoryAttachmentsResponse
import com.vk.sdk.api.messages.dto.MessagesGetHistoryExtendedResponse
import com.vk.sdk.api.messages.dto.MessagesGetHistoryExtendedRev
import com.vk.sdk.api.messages.dto.MessagesGetHistoryResponse
import com.vk.sdk.api.messages.dto.MessagesGetHistoryRev
import com.vk.sdk.api.messages.dto.MessagesGetImportantMessagesExtendedResponse
import com.vk.sdk.api.messages.dto.MessagesGetImportantMessagesResponse
import com.vk.sdk.api.messages.dto.MessagesGetIntentUsersIntent
import com.vk.sdk.api.messages.dto.MessagesGetIntentUsersResponse
import com.vk.sdk.api.messages.dto.MessagesGetInviteLinkResponse
import com.vk.sdk.api.messages.dto.MessagesGetLongPollHistoryResponse
import com.vk.sdk.api.messages.dto.MessagesIsMessagesFromGroupAllowedResponse
import com.vk.sdk.api.messages.dto.MessagesJoinChatByInviteLinkResponse
import com.vk.sdk.api.messages.dto.MessagesLastActivity
import com.vk.sdk.api.messages.dto.MessagesLongpollParams
import com.vk.sdk.api.messages.dto.MessagesPinnedMessage
import com.vk.sdk.api.messages.dto.MessagesSearchConversationsExtendedResponse
import com.vk.sdk.api.messages.dto.MessagesSearchConversationsResponse
import com.vk.sdk.api.messages.dto.MessagesSearchExtendedResponse
import com.vk.sdk.api.messages.dto.MessagesSearchResponse
import com.vk.sdk.api.messages.dto.MessagesSendIntent
import com.vk.sdk.api.messages.dto.MessagesSetActivityType
import com.vk.sdk.api.messages.dto.MessagesSetChatPhotoResponse
import com.vk.sdk.api.users.dto.UsersFields
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class MessagesService {
    /**
     * Adds a new user to a chat.
     *
     * @param chatId - Chat ID.
     * @param userId - ID of the user to be added to the chat.
     * @param visibleMessagesCount
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesAddChatUser(
        chatId: Int,
        userId: UserId? = null,
        visibleMessagesCount: Int? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("messages.addChatUser") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("chat_id", chatId, min = 0, max = 100000000)
        userId?.let { addParam("user_id", it, min = 0) }
        visibleMessagesCount?.let { addParam("visible_messages_count", it, min = 0, max = 1000) }
    }

    /**
     * Allows sending messages from community to the current user.
     *
     * @param groupId - Group ID.
     * @param key
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesAllowMessagesFromGroup(groupId: UserId, key: String? = null):
            VKRequest<BaseOkResponse> = NewApiRequest("messages.allowMessagesFromGroup") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
        GsonHolder.gson.fromJson(it, Int::class.java)
    }
    .apply {
        userIds?.let { addParam("user_ids", it) }
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
        peerId: Int? = null,
        cmids: List<Int>? = null
    ): VKRequest<Any> = NewApiRequest("messages.delete") {
        GsonHolder.gson.fromJson(it, Any::class.java)
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
     * @return [VKRequest] with [MessagesDeleteChatPhotoResponse]
     */
    fun messagesDeleteChatPhoto(chatId: Int, groupId: UserId? = null):
            VKRequest<MessagesDeleteChatPhotoResponse> = NewApiRequest("messages.deleteChatPhoto") {
        GsonHolder.gson.fromJson(it, MessagesDeleteChatPhotoResponse::class.java)
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
     * @return [VKRequest] with [MessagesDeleteConversationResponse]
     */
    fun messagesDeleteConversation(
        userId: Int? = null,
        peerId: Int? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesDeleteConversationResponse> =
            NewApiRequest("messages.deleteConversation") {
        GsonHolder.gson.fromJson(it, MessagesDeleteConversationResponse::class.java)
    }
    .apply {
        userId?.let { addParam("user_id", it) }
        peerId?.let { addParam("peer_id", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Denies sending message from community to the current user.
     *
     * @param groupId - Group ID.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesDenyMessagesFromGroup(groupId: UserId): VKRequest<BaseOkResponse> =
            NewApiRequest("messages.denyMessagesFromGroup") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @param conversationMessageId
     * @param template
     * @param keyboard
     * @return [VKRequest] with [BaseBoolInt]
     */
    fun messagesEdit(
        peerId: Int,
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
        conversationMessageId: Int? = null,
        template: String? = null,
        keyboard: String? = null
    ): VKRequest<BaseBoolInt> = NewApiRequest("messages.edit") {
        GsonHolder.gson.fromJson(it, BaseBoolInt::class.java)
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
        conversationMessageId?.let { addParam("conversation_message_id", it, min = 0) }
        template?.let { addParam("template", it) }
        keyboard?.let { addParam("keyboard", it) }
    }

    /**
     * Edits the title of a chat.
     *
     * @param chatId - Chat ID.
     * @param title - New title of the chat.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesEditChat(chatId: Int, title: String? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("messages.editChat") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetByConversationMessageIdResponse]
     */
    fun messagesGetByConversationMessageId(
        peerId: Int,
        conversationMessageIds: List<Int>,
        fields: List<UsersFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetByConversationMessageIdResponse> =
            NewApiRequest("messages.getByConversationMessageId") {
        GsonHolder.gson.fromJson(it, MessagesGetByConversationMessageIdResponse::class.java)
    }
    .apply {
        addParam("peer_id", peerId)
        addParam("conversation_message_ids", conversationMessageIds)
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
     * @return [VKRequest] with [MessagesGetByConversationMessageIdExtendedResponse]
     */
    fun messagesGetByConversationMessageIdExtended(
        peerId: Int,
        conversationMessageIds: List<Int>,
        fields: List<UsersFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetByConversationMessageIdExtendedResponse> =
            NewApiRequest("messages.getByConversationMessageId") {
        GsonHolder.gson.fromJson(it, MessagesGetByConversationMessageIdExtendedResponse::class.java)
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
     * @param previewLength - Number of characters after which to truncate a previewed message. To
     * preview the full message, specify '0'. "NOTE_ Messages are not truncated by default. Messages
     * are truncated by words."
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetByIdResponse]
     */
    fun messagesGetById(
        messageIds: List<Int>,
        previewLength: Int? = null,
        fields: List<UsersFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetByIdResponse> = NewApiRequest("messages.getById") {
        GsonHolder.gson.fromJson(it, MessagesGetByIdResponse::class.java)
    }
    .apply {
        addParam("message_ids", messageIds)
        previewLength?.let { addParam("preview_length", it, min = 0) }
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
     * @param previewLength - Number of characters after which to truncate a previewed message. To
     * preview the full message, specify '0'. "NOTE_ Messages are not truncated by default. Messages
     * are truncated by words."
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetByIdExtendedResponse]
     */
    fun messagesGetByIdExtended(
        messageIds: List<Int>,
        previewLength: Int? = null,
        fields: List<UsersFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetByIdExtendedResponse> = NewApiRequest("messages.getById") {
        GsonHolder.gson.fromJson(it, MessagesGetByIdExtendedResponse::class.java)
    }
    .apply {
        addParam("message_ids", messageIds)
        previewLength?.let { addParam("preview_length", it, min = 0) }
        addParam("extended", true)
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * @param peerId
     * @param link - Invitation link.
     * @param fields - Profile fields to return.
     * @return [VKRequest] with [MessagesGetChatPreviewResponse]
     */
    fun messagesGetChatPreview(
        peerId: Int? = null,
        link: String? = null,
        fields: List<UsersFields>? = null
    ): VKRequest<MessagesGetChatPreviewResponse> = NewApiRequest("messages.getChatPreview") {
        GsonHolder.gson.fromJson(it, MessagesGetChatPreviewResponse::class.java)
    }
    .apply {
        peerId?.let { addParam("peer_id", it, min = 0) }
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
     * @return [VKRequest] with [MessagesGetConversationMembers]
     */
    fun messagesGetConversationMembers(
        peerId: Int,
        fields: List<UsersFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetConversationMembers> =
            NewApiRequest("messages.getConversationMembers") {
        GsonHolder.gson.fromJson(it, MessagesGetConversationMembers::class.java)
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
     * @param startMessageId - ID of the message from what to return dialogs.
     * @param fields - Profile and communities fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetConversationsResponse]
     */
    fun messagesGetConversations(
        offset: Int? = null,
        count: Int? = null,
        filter: MessagesGetConversationsFilter? = null,
        startMessageId: Int? = null,
        fields: List<BaseUserGroupFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetConversationsResponse> = NewApiRequest("messages.getConversations") {
        GsonHolder.gson.fromJson(it, MessagesGetConversationsResponse::class.java)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        filter?.let { addParam("filter", it.value) }
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
     * @param fields - Profile and communities fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetConversationById]
     */
    fun messagesGetConversationsById(
        peerIds: List<Int>,
        fields: List<BaseUserGroupFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetConversationById> = NewApiRequest("messages.getConversationsById") {
        GsonHolder.gson.fromJson(it, MessagesGetConversationById::class.java)
    }
    .apply {
        addParam("peer_ids", peerIds)
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
     * @return [VKRequest] with [MessagesGetConversationByIdExtended]
     */
    fun messagesGetConversationsByIdExtended(
        peerIds: List<Int>,
        fields: List<BaseUserGroupFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetConversationByIdExtended> =
            NewApiRequest("messages.getConversationsById") {
        GsonHolder.gson.fromJson(it, MessagesGetConversationByIdExtended::class.java)
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
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [MessagesGetHistoryResponse]
     */
    fun messagesGetHistory(
        offset: Int? = null,
        count: Int? = null,
        userId: Int? = null,
        peerId: Int? = null,
        startMessageId: Int? = null,
        rev: MessagesGetHistoryRev? = null,
        fields: List<UsersFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetHistoryResponse> = NewApiRequest("messages.getHistory") {
        GsonHolder.gson.fromJson(it, MessagesGetHistoryResponse::class.java)
    }
    .apply {
        offset?.let { addParam("offset", it) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        userId?.let { addParam("user_id", it) }
        peerId?.let { addParam("peer_id", it) }
        startMessageId?.let { addParam("start_message_id", it) }
        rev?.let { addParam("rev", it.value) }
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
     * @return [VKRequest] with [MessagesGetHistoryExtendedResponse]
     */
    fun messagesGetHistoryExtended(
        offset: Int? = null,
        count: Int? = null,
        userId: Int? = null,
        peerId: Int? = null,
        startMessageId: Int? = null,
        rev: MessagesGetHistoryExtendedRev? = null,
        fields: List<UsersFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetHistoryExtendedResponse> = NewApiRequest("messages.getHistory") {
        GsonHolder.gson.fromJson(it, MessagesGetHistoryExtendedResponse::class.java)
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
     * @param peerId - Peer ID. ", For group chat_ '2000000000 + chat ID' , , For community_
     * '-community ID'"
     * @param mediaType - Type of media files to return_ *'photo',, *'video',, *'audio',, *'doc',,
     * *'link'.,*'market'.,*'wall'.,*'share'
     * @param startFrom - Message ID to start return results from.
     * @param count - Number of objects to return.
     * @param photoSizes - '1' - to return photo sizes in a
     * @param fields - Additional profile [vk.com/dev/fields|fields] to return. 
     * @param groupId - Group ID (for group messages with group access token)
     * @param preserveOrder
     * @param maxForwardsLevel
     * @return [VKRequest] with [MessagesGetHistoryAttachmentsResponse]
     */
    fun messagesGetHistoryAttachments(
        peerId: Int,
        mediaType: MessagesGetHistoryAttachmentsMediaType? = null,
        startFrom: String? = null,
        count: Int? = null,
        photoSizes: Boolean? = null,
        fields: List<UsersFields>? = null,
        groupId: UserId? = null,
        preserveOrder: Boolean? = null,
        maxForwardsLevel: Int? = null
    ): VKRequest<MessagesGetHistoryAttachmentsResponse> =
            NewApiRequest("messages.getHistoryAttachments") {
        GsonHolder.gson.fromJson(it, MessagesGetHistoryAttachmentsResponse::class.java)
    }
    .apply {
        addParam("peer_id", peerId)
        mediaType?.let { addParam("media_type", it.value) }
        startFrom?.let { addParam("start_from", it) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        photoSizes?.let { addParam("photo_sizes", it) }
        val fieldsJsonConverted = fields?.map {
            it.value
        }
        fieldsJsonConverted?.let { addParam("fields", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        preserveOrder?.let { addParam("preserve_order", it) }
        maxForwardsLevel?.let { addParam("max_forwards_level", it, min = 0, max = 45) }
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
     * @return [VKRequest] with [MessagesGetImportantMessagesResponse]
     */
    fun messagesGetImportantMessages(
        count: Int? = null,
        offset: Int? = null,
        startMessageId: Int? = null,
        previewLength: Int? = null,
        fields: List<BaseUserGroupFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetImportantMessagesResponse> =
            NewApiRequest("messages.getImportantMessages") {
        GsonHolder.gson.fromJson(it, MessagesGetImportantMessagesResponse::class.java)
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
     * @return [VKRequest] with [MessagesGetImportantMessagesExtendedResponse]
     */
    fun messagesGetImportantMessagesExtended(
        count: Int? = null,
        offset: Int? = null,
        startMessageId: Int? = null,
        previewLength: Int? = null,
        fields: List<BaseUserGroupFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetImportantMessagesExtendedResponse> =
            NewApiRequest("messages.getImportantMessages") {
        GsonHolder.gson.fromJson(it, MessagesGetImportantMessagesExtendedResponse::class.java)
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
     * @param nameCase
     * @param fields
     * @return [VKRequest] with [MessagesGetIntentUsersResponse]
     */
    fun messagesGetIntentUsers(
        intent: MessagesGetIntentUsersIntent,
        subscribeId: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        nameCase: List<String>? = null,
        fields: List<String>? = null
    ): VKRequest<MessagesGetIntentUsersResponse> = NewApiRequest("messages.getIntentUsers") {
        GsonHolder.gson.fromJson(it, MessagesGetIntentUsersResponse::class.java)
    }
    .apply {
        addParam("intent", intent.value)
        subscribeId?.let { addParam("subscribe_id", it, min = 0, max = 100) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 200) }
        nameCase?.let { addParam("name_case", it) }
        fields?.let { addParam("fields", it) }
    }

    /**
     * @param peerId - Destination ID.
     * @param reset - 1 - to generate new link (revoke previous), 0 - to return previous link.
     * @param groupId - Group ID
     * @return [VKRequest] with [MessagesGetInviteLinkResponse]
     */
    fun messagesGetInviteLink(
        peerId: Int,
        reset: Boolean? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesGetInviteLinkResponse> = NewApiRequest("messages.getInviteLink") {
        GsonHolder.gson.fromJson(it, MessagesGetInviteLinkResponse::class.java)
    }
    .apply {
        addParam("peer_id", peerId, min = 0)
        reset?.let { addParam("reset", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns a user's current status and date of last activity.
     *
     * @param userId - User ID.
     * @return [VKRequest] with [MessagesLastActivity]
     */
    fun messagesGetLastActivity(userId: UserId): VKRequest<MessagesLastActivity> =
            NewApiRequest("messages.getLastActivity") {
        GsonHolder.gson.fromJson(it, MessagesLastActivity::class.java)
    }
    .apply {
        addParam("user_id", userId)
    }

    /**
     * Returns updates in user's private messages.
     *
     * @param ts - Last value of the 'ts' parameter returned from the Long Poll server or by using
     * [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method.
     * @param pts - Lsat value of 'pts' parameter returned from the Long Poll server or by using
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
     * @return [VKRequest] with [MessagesGetLongPollHistoryResponse]
     */
    fun messagesGetLongPollHistory(
        ts: Int? = null,
        pts: Int? = null,
        previewLength: Int? = null,
        onlines: Boolean? = null,
        fields: List<UsersFields>? = null,
        eventsLimit: Int? = null,
        msgsLimit: Int? = null,
        maxMsgId: Int? = null,
        groupId: UserId? = null,
        lpVersion: Int? = null,
        lastN: Int? = null,
        credentials: Boolean? = null
    ): VKRequest<MessagesGetLongPollHistoryResponse> =
            NewApiRequest("messages.getLongPollHistory") {
        GsonHolder.gson.fromJson(it, MessagesGetLongPollHistoryResponse::class.java)
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
    }

    /**
     * Returns data required for connection to a Long Poll server.
     *
     * @param needPts - '1' - to return the 'pts' field, needed for the
     * [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method.
     * @param groupId - Group ID (for group messages with user access token)
     * @param lpVersion - Long poll version
     * @return [VKRequest] with [MessagesLongpollParams]
     */
    fun messagesGetLongPollServer(
        needPts: Boolean? = null,
        groupId: UserId? = null,
        lpVersion: Int? = null
    ): VKRequest<MessagesLongpollParams> = NewApiRequest("messages.getLongPollServer") {
        GsonHolder.gson.fromJson(it, MessagesLongpollParams::class.java)
    }
    .apply {
        needPts?.let { addParam("need_pts", it) }
        groupId?.let { addParam("group_id", it, min = 0) }
        lpVersion?.let { addParam("lp_version", it, min = 0) }
    }

    /**
     * Returns information whether sending messages from the community to current user is allowed.
     *
     * @param groupId - Group ID.
     * @param userId - User ID.
     * @return [VKRequest] with [MessagesIsMessagesFromGroupAllowedResponse]
     */
    fun messagesIsMessagesFromGroupAllowed(groupId: UserId, userId: UserId):
            VKRequest<MessagesIsMessagesFromGroupAllowedResponse> =
            NewApiRequest("messages.isMessagesFromGroupAllowed") {
        GsonHolder.gson.fromJson(it, MessagesIsMessagesFromGroupAllowedResponse::class.java)
    }
    .apply {
        addParam("group_id", groupId, min = 1)
        addParam("user_id", userId, min = 1)
    }

    /**
     * @param link - Invitation link.
     * @return [VKRequest] with [MessagesJoinChatByInviteLinkResponse]
     */
    fun messagesJoinChatByInviteLink(link: String): VKRequest<MessagesJoinChatByInviteLinkResponse>
            = NewApiRequest("messages.joinChatByInviteLink") {
        GsonHolder.gson.fromJson(it, MessagesJoinChatByInviteLinkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesMarkAsAnsweredConversation(
        peerId: Int,
        answered: Boolean? = null,
        groupId: UserId? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("messages.markAsAnsweredConversation") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
        val typeToken = object: TypeToken<List<Int>>() {}.type
        GsonHolder.gson.fromJson<List<Int>>(it, typeToken)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesMarkAsImportantConversation(
        peerId: Int,
        important: Boolean? = null,
        groupId: UserId? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("messages.markAsImportantConversation") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesMarkAsRead(
        messageIds: List<Int>? = null,
        peerId: Int? = null,
        startMessageId: Int? = null,
        groupId: UserId? = null,
        markConversationAsRead: Boolean? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("messages.markAsRead") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        messageIds?.let { addParam("message_ids", it) }
        peerId?.let { addParam("peer_id", it) }
        startMessageId?.let { addParam("start_message_id", it, min = 0) }
        groupId?.let { addParam("group_id", it, min = 0) }
        markConversationAsRead?.let { addParam("mark_conversation_as_read", it) }
    }

    /**
     * Pin a message.
     *
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'Chat ID', e.g. '2000000001'. For community_ '- Community ID', e.g. '-12345'. "
     * @param messageId - Message ID
     * @param conversationMessageId - Conversation message ID
     * @return [VKRequest] with [MessagesPinnedMessage]
     */
    fun messagesPin(
        peerId: Int,
        messageId: Int? = null,
        conversationMessageId: Int? = null
    ): VKRequest<MessagesPinnedMessage> = NewApiRequest("messages.pin") {
        GsonHolder.gson.fromJson(it, MessagesPinnedMessage::class.java)
    }
    .apply {
        addParam("peer_id", peerId)
        messageId?.let { addParam("message_id", it, min = 0) }
        conversationMessageId?.let { addParam("conversation_message_id", it, min = 0) }
    }

    /**
     * Allows the current user to leave a chat or, if the current user started the chat, allows the
     * user to remove another user from the chat.
     *
     * @param chatId - Chat ID.
     * @param userId - ID of the user to be removed from the chat.
     * @param memberId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesRemoveChatUser(
        chatId: Int,
        userId: UserId? = null,
        memberId: UserId? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("messages.removeChatUser") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @param groupId - Group ID (for group messages with user access token)
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesRestore(messageId: Int, groupId: UserId? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("messages.restore") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("message_id", messageId, min = 0)
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
     * @return [VKRequest] with [MessagesSearchResponse]
     */
    fun messagesSearch(
        q: String? = null,
        peerId: Int? = null,
        date: Int? = null,
        previewLength: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<String>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesSearchResponse> = NewApiRequest("messages.search") {
        GsonHolder.gson.fromJson(it, MessagesSearchResponse::class.java)
    }
    .apply {
        q?.let { addParam("q", it, maxLength = 9000) }
        peerId?.let { addParam("peer_id", it) }
        date?.let { addParam("date", it, min = 0) }
        previewLength?.let { addParam("preview_length", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
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
     * @return [VKRequest] with [MessagesSearchExtendedResponse]
     */
    fun messagesSearchExtended(
        q: String? = null,
        peerId: Int? = null,
        date: Int? = null,
        previewLength: Int? = null,
        offset: Int? = null,
        count: Int? = null,
        fields: List<String>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesSearchExtendedResponse> = NewApiRequest("messages.search") {
        GsonHolder.gson.fromJson(it, MessagesSearchExtendedResponse::class.java)
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
     * @param fields - Profile fields to return.
     * @param groupId - Group ID (for group messages with user access token)
     * @return [VKRequest] with [MessagesSearchConversationsResponse]
     */
    fun messagesSearchConversations(
        q: String? = null,
        count: Int? = null,
        fields: List<UsersFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesSearchConversationsResponse> =
            NewApiRequest("messages.searchConversations") {
        GsonHolder.gson.fromJson(it, MessagesSearchConversationsResponse::class.java)
    }
    .apply {
        q?.let { addParam("q", it) }
        count?.let { addParam("count", it, min = 1, max = 255) }
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
     * @return [VKRequest] with [MessagesSearchConversationsExtendedResponse]
     */
    fun messagesSearchConversationsExtended(
        q: String? = null,
        count: Int? = null,
        fields: List<UsersFields>? = null,
        groupId: UserId? = null
    ): VKRequest<MessagesSearchConversationsExtendedResponse> =
            NewApiRequest("messages.searchConversations") {
        GsonHolder.gson.fromJson(it, MessagesSearchConversationsExtendedResponse::class.java)
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
        peerId: Int? = null,
        peerIds: List<Int>? = null,
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
        intent: MessagesSendIntent? = null,
        subscribeId: Int? = null
    ): VKRequest<Int> = NewApiRequest("messages.send") {
        GsonHolder.gson.fromJson(it, Int::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesSendMessageEventAnswer(
        eventId: String,
        userId: UserId,
        peerId: Int,
        eventData: String? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("messages.sendMessageEventAnswer") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("event_id", eventId)
        addParam("user_id", userId)
        addParam("peer_id", peerId)
        eventData?.let { addParam("event_data", it, maxLength = 1000) }
    }

    /**
     * Changes the status of a user as typing in a conversation.
     *
     * @param userId - User ID.
     * @param type - 'typing' - user has started to type.
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'chat_id', e.g. '2000000001'. For community_ '- community ID', e.g. '-12345'. "
     * @param groupId - Group ID (for group messages with group access token)
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesSetActivity(
        userId: Int? = null,
        type: MessagesSetActivityType? = null,
        peerId: Int? = null,
        groupId: UserId? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("messages.setActivity") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
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
     * @return [VKRequest] with [MessagesSetChatPhotoResponse]
     */
    fun messagesSetChatPhoto(file: String): VKRequest<MessagesSetChatPhotoResponse> =
            NewApiRequest("messages.setChatPhoto") {
        GsonHolder.gson.fromJson(it, MessagesSetChatPhotoResponse::class.java)
    }
    .apply {
        addParam("file", file)
    }

    /**
     * @param peerId
     * @param groupId
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun messagesUnpin(peerId: Int, groupId: UserId? = null): VKRequest<BaseOkResponse> =
            NewApiRequest("messages.unpin") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("peer_id", peerId)
        groupId?.let { addParam("group_id", it, min = 0) }
    }
}
