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
package com.vk.sdk.api.docs

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.base.dto.BaseUploadServerDto
import com.vk.sdk.api.docs.dto.DocsDocDto
import com.vk.sdk.api.docs.dto.DocsGetMessagesUploadServerTypeDto
import com.vk.sdk.api.docs.dto.DocsGetResponseDto
import com.vk.sdk.api.docs.dto.DocsGetTypeDto
import com.vk.sdk.api.docs.dto.DocsGetTypesResponseDto
import com.vk.sdk.api.docs.dto.DocsSaveResponseDto
import com.vk.sdk.api.docs.dto.DocsSearchResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class DocsService {
    /**
     * Copies a document to a user's or community's document list.
     *
     * @param ownerId - ID of the user or community that owns the document. Use a negative value to
     * designate a community ID.
     * @param docId - Document ID.
     * @param accessKey - Access key. This parameter is required if 'access_key' was returned with
     * the document's data.
     * @return [VKRequest] with [Int]
     */
    fun docsAdd(
        ownerId: UserId,
        docId: Int,
        accessKey: String? = null
    ): VKRequest<Int> = NewApiRequest("docs.add") {
        GsonHolder.gson.parse<Int>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("doc_id", docId, min = 0)
        accessKey?.let { addParam("access_key", it) }
    }

    /**
     * Deletes a user or community document.
     *
     * @param ownerId - ID of the user or community that owns the document. Use a negative value to
     * designate a community ID.
     * @param docId - Document ID.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun docsDelete(ownerId: UserId, docId: Int): VKRequest<BaseOkResponseDto> =
            NewApiRequest("docs.delete") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("doc_id", docId, min = 0)
    }

    /**
     * Edits a document.
     *
     * @param docId - Document ID.
     * @param title - Document title.
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param tags - Document tags.
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun docsEdit(
        docId: Int,
        title: String,
        ownerId: UserId? = null,
        tags: List<String>? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("docs.edit") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("doc_id", docId, min = 0)
        addParam("title", title, maxLength = 128)
        ownerId?.let { addParam("owner_id", it) }
        tags?.let { addParam("tags", it) }
    }

    /**
     * Returns detailed information about user or community documents.
     *
     * @param count - Number of documents to return. By default, all documents.
     * @param offset - Offset needed to return a specific subset of documents.
     * @param type
     * @param ownerId - ID of the user or community that owns the documents. Use a negative value to
     * designate a community ID.
     * @param returnTags
     * @return [VKRequest] with [DocsGetResponseDto]
     */
    fun docsGet(
        count: Int? = null,
        offset: Int? = null,
        type: DocsGetTypeDto? = null,
        ownerId: UserId? = null,
        returnTags: Boolean? = null
    ): VKRequest<DocsGetResponseDto> = NewApiRequest("docs.get") {
        GsonHolder.gson.parse<DocsGetResponseDto>(it)
    }
    .apply {
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        type?.let { addParam("type", it.value) }
        ownerId?.let { addParam("owner_id", it) }
        returnTags?.let { addParam("return_tags", it) }
    }

    /**
     * Returns information about documents by their IDs.
     *
     * @param docs - Document IDs. Example_ , "66748_91488,66748_91455",
     * @param returnTags
     * @return [VKRequest] with [Unit]
     */
    fun docsGetById(docs: List<String>, returnTags: Boolean? = null): VKRequest<List<DocsDocDto>> =
            NewApiRequest("docs.getById") {
        GsonHolder.gson.parseList<DocsDocDto>(it)
    }
    .apply {
        addParam("docs", docs)
        returnTags?.let { addParam("return_tags", it) }
    }

    /**
     * Returns the server address for document upload.
     *
     * @param type - Document type.
     * @param peerId - Destination ID. "For user_ 'User ID', e.g. '12345'. For chat_ '2000000000' +
     * 'Chat ID', e.g. '2000000001'. For community_ '- Community ID', e.g. '-12345'. "
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun docsGetMessagesUploadServer(type: DocsGetMessagesUploadServerTypeDto? = null, peerId: Int? =
            null): VKRequest<BaseUploadServerDto> = NewApiRequest("docs.getMessagesUploadServer") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }
    .apply {
        type?.let { addParam("type", it.value) }
        peerId?.let { addParam("peer_id", it) }
    }

    /**
     * Returns documents types available for current user.
     *
     * @param ownerId - ID of the user or community that owns the documents. Use a negative value to
     * designate a community ID.
     * @return [VKRequest] with [DocsGetTypesResponseDto]
     */
    fun docsGetTypes(ownerId: UserId? = null): VKRequest<DocsGetTypesResponseDto> =
            NewApiRequest("docs.getTypes") {
        GsonHolder.gson.parse<DocsGetTypesResponseDto>(it)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
    }

    /**
     * Returns the server address for document upload.
     *
     * @param groupId - Community ID (if the document will be uploaded to the community).
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun docsGetUploadServer(groupId: UserId? = null): VKRequest<BaseUploadServerDto> =
            NewApiRequest("docs.getUploadServer") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns the server address for document upload onto a user's or community's wall.
     *
     * @param groupId - Community ID (if the document will be uploaded to the community).
     * @return [VKRequest] with [BaseUploadServerDto]
     */
    fun docsGetWallUploadServer(groupId: UserId? = null): VKRequest<BaseUploadServerDto> =
            NewApiRequest("docs.getWallUploadServer") {
        GsonHolder.gson.parse<BaseUploadServerDto>(it)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Saves a document after [vk.com/dev/upload_files_2|uploading it to a server].
     *
     * @param file - This parameter is returned when the file is [vk.com/dev/upload_files_2|uploaded
     * to the server].
     * @param title - Document title.
     * @param tags - Document tags.
     * @param returnTags
     * @return [VKRequest] with [DocsSaveResponseDto]
     */
    fun docsSave(
        file: String,
        title: String? = null,
        tags: String? = null,
        returnTags: Boolean? = null
    ): VKRequest<DocsSaveResponseDto> = NewApiRequest("docs.save") {
        GsonHolder.gson.parse<DocsSaveResponseDto>(it)
    }
    .apply {
        addParam("file", file)
        title?.let { addParam("title", it) }
        tags?.let { addParam("tags", it) }
        returnTags?.let { addParam("return_tags", it) }
    }

    /**
     * Returns a list of documents matching the search criteria.
     *
     * @param q - Search query string.
     * @param searchOwn
     * @param count - Number of results to return.
     * @param offset - Offset needed to return a specific subset of results.
     * @param returnTags
     * @return [VKRequest] with [DocsSearchResponseDto]
     */
    fun docsSearch(
        q: String? = null,
        searchOwn: Boolean? = null,
        count: Int? = null,
        offset: Int? = null,
        returnTags: Boolean? = null
    ): VKRequest<DocsSearchResponseDto> = NewApiRequest("docs.search") {
        GsonHolder.gson.parse<DocsSearchResponseDto>(it)
    }
    .apply {
        q?.let { addParam("q", it, maxLength = 512) }
        searchOwn?.let { addParam("search_own", it) }
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        returnTags?.let { addParam("return_tags", it) }
    }

    object DocsAddRestrictions {
        const val DOC_ID_MIN: Long = 0
    }

    object DocsDeleteRestrictions {
        const val DOC_ID_MIN: Long = 0
    }

    object DocsEditRestrictions {
        const val DOC_ID_MIN: Long = 0

        const val TITLE_MAX_LENGTH: Int = 128
    }

    object DocsGetRestrictions {
        const val COUNT_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val TYPE_MIN: Long = 0
    }

    object DocsGetUploadServerRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object DocsGetWallUploadServerRestrictions {
        const val GROUP_ID_MIN: Long = 0
    }

    object DocsSearchRestrictions {
        const val Q_MAX_LENGTH: Int = 512

        const val COUNT_MIN: Long = 0

        const val OFFSET_MIN: Long = 0
    }
}
