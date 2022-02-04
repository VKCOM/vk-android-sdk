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

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.base.dto.BaseUploadServer
import com.vk.sdk.api.docs.dto.DocsDoc
import com.vk.sdk.api.docs.dto.DocsGetMessagesUploadServerType
import com.vk.sdk.api.docs.dto.DocsGetResponse
import com.vk.sdk.api.docs.dto.DocsGetType
import com.vk.sdk.api.docs.dto.DocsGetTypesResponse
import com.vk.sdk.api.docs.dto.DocsSaveResponse
import com.vk.sdk.api.docs.dto.DocsSearchResponse
import kotlin.Boolean
import kotlin.Int
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
        GsonHolder.gson.fromJson(it, Int::class.java)
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
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun docsDelete(ownerId: UserId, docId: Int): VKRequest<BaseOkResponse> =
            NewApiRequest("docs.delete") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("doc_id", docId, min = 0)
    }

    /**
     * Edits a document.
     *
     * @param ownerId - User ID or community ID. Use a negative value to designate a community ID.
     * @param docId - Document ID.
     * @param title - Document title.
     * @param tags - Document tags.
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun docsEdit(
        ownerId: UserId,
        docId: Int,
        title: String,
        tags: List<String>? = null
    ): VKRequest<BaseOkResponse> = NewApiRequest("docs.edit") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
        addParam("doc_id", docId, min = 0)
        addParam("title", title, maxLength = 128)
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
     * @return [VKRequest] with [DocsGetResponse]
     */
    fun docsGet(
        count: Int? = null,
        offset: Int? = null,
        type: DocsGetType? = null,
        ownerId: UserId? = null,
        returnTags: Boolean? = null
    ): VKRequest<DocsGetResponse> = NewApiRequest("docs.get") {
        GsonHolder.gson.fromJson(it, DocsGetResponse::class.java)
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
    fun docsGetById(docs: List<String>, returnTags: Boolean? = null): VKRequest<List<DocsDoc>> =
            NewApiRequest("docs.getById") {
        val typeToken = object: TypeToken<List<DocsDoc>>() {}.type
        GsonHolder.gson.fromJson<List<DocsDoc>>(it, typeToken)
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
     * @return [VKRequest] with [BaseUploadServer]
     */
    fun docsGetMessagesUploadServer(type: DocsGetMessagesUploadServerType? = null, peerId: Int? =
            null): VKRequest<BaseUploadServer> = NewApiRequest("docs.getMessagesUploadServer") {
        GsonHolder.gson.fromJson(it, BaseUploadServer::class.java)
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
     * @return [VKRequest] with [DocsGetTypesResponse]
     */
    fun docsGetTypes(ownerId: UserId): VKRequest<DocsGetTypesResponse> =
            NewApiRequest("docs.getTypes") {
        GsonHolder.gson.fromJson(it, DocsGetTypesResponse::class.java)
    }
    .apply {
        addParam("owner_id", ownerId)
    }

    /**
     * Returns the server address for document upload.
     *
     * @param groupId - Community ID (if the document will be uploaded to the community).
     * @return [VKRequest] with [BaseUploadServer]
     */
    fun docsGetUploadServer(groupId: UserId? = null): VKRequest<BaseUploadServer> =
            NewApiRequest("docs.getUploadServer") {
        GsonHolder.gson.fromJson(it, BaseUploadServer::class.java)
    }
    .apply {
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Returns the server address for document upload onto a user's or community's wall.
     *
     * @param groupId - Community ID (if the document will be uploaded to the community).
     * @return [VKRequest] with [BaseUploadServer]
     */
    fun docsGetWallUploadServer(groupId: UserId? = null): VKRequest<BaseUploadServer> =
            NewApiRequest("docs.getWallUploadServer") {
        GsonHolder.gson.fromJson(it, BaseUploadServer::class.java)
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
     * @return [VKRequest] with [DocsSaveResponse]
     */
    fun docsSave(
        file: String,
        title: String? = null,
        tags: String? = null,
        returnTags: Boolean? = null
    ): VKRequest<DocsSaveResponse> = NewApiRequest("docs.save") {
        GsonHolder.gson.fromJson(it, DocsSaveResponse::class.java)
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
     * @return [VKRequest] with [DocsSearchResponse]
     */
    fun docsSearch(
        q: String,
        searchOwn: Boolean? = null,
        count: Int? = null,
        offset: Int? = null,
        returnTags: Boolean? = null
    ): VKRequest<DocsSearchResponse> = NewApiRequest("docs.search") {
        GsonHolder.gson.fromJson(it, DocsSearchResponse::class.java)
    }
    .apply {
        addParam("q", q, maxLength = 512)
        searchOwn?.let { addParam("search_own", it) }
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        returnTags?.let { addParam("return_tags", it) }
    }
}
