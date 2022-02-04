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
package com.vk.sdk.api.pages

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.pages.dto.PagesSaveAccessEdit
import com.vk.sdk.api.pages.dto.PagesSaveAccessView
import com.vk.sdk.api.pages.dto.PagesWikipage
import com.vk.sdk.api.pages.dto.PagesWikipageFull
import com.vk.sdk.api.pages.dto.PagesWikipageHistory
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class PagesService {
    /**
     * Allows to clear the cache of particular 'external' pages which may be attached to VK posts.
     *
     * @param url - Address of the page where you need to refesh the cached version
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun pagesClearCache(url: String): VKRequest<BaseOkResponse> =
            NewApiRequest("pages.clearCache") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("url", url)
    }

    /**
     * Returns information about a wiki page.
     *
     * @param ownerId - Page owner ID.
     * @param pageId - Wiki page ID.
     * @param global - '1' - to return information about a global wiki page
     * @param sitePreview - '1' - resulting wiki page is a preview for the attached link
     * @param title - Wiki page title.
     * @param needSource
     * @param needHtml - '1' - to return the page as HTML,
     * @return [VKRequest] with [PagesWikipageFull]
     */
    fun pagesGet(
        ownerId: UserId? = null,
        pageId: Int? = null,
        global: Boolean? = null,
        sitePreview: Boolean? = null,
        title: String? = null,
        needSource: Boolean? = null,
        needHtml: Boolean? = null
    ): VKRequest<PagesWikipageFull> = NewApiRequest("pages.get") {
        GsonHolder.gson.fromJson(it, PagesWikipageFull::class.java)
    }
    .apply {
        ownerId?.let { addParam("owner_id", it) }
        pageId?.let { addParam("page_id", it) }
        global?.let { addParam("global", it) }
        sitePreview?.let { addParam("site_preview", it) }
        title?.let { addParam("title", it) }
        needSource?.let { addParam("need_source", it) }
        needHtml?.let { addParam("need_html", it) }
    }

    /**
     * Returns a list of all previous versions of a wiki page.
     *
     * @param pageId - Wiki page ID.
     * @param groupId - ID of the community that owns the wiki page.
     * @param userId
     * @return [VKRequest] with [Unit]
     */
    fun pagesGetHistory(
        pageId: Int,
        groupId: UserId? = null,
        userId: UserId? = null
    ): VKRequest<List<PagesWikipageHistory>> = NewApiRequest("pages.getHistory") {
        val typeToken = object: TypeToken<List<PagesWikipageHistory>>() {}.type
        GsonHolder.gson.fromJson<List<PagesWikipageHistory>>(it, typeToken)
    }
    .apply {
        addParam("page_id", pageId)
        groupId?.let { addParam("group_id", it) }
        userId?.let { addParam("user_id", it) }
    }

    /**
     * Returns a list of wiki pages in a group.
     *
     * @param groupId - ID of the community that owns the wiki page.
     * @return [VKRequest] with [Unit]
     */
    fun pagesGetTitles(groupId: UserId? = null): VKRequest<List<PagesWikipage>> =
            NewApiRequest("pages.getTitles") {
        val typeToken = object: TypeToken<List<PagesWikipage>>() {}.type
        GsonHolder.gson.fromJson<List<PagesWikipage>>(it, typeToken)
    }
    .apply {
        groupId?.let { addParam("group_id", it) }
    }

    /**
     * Returns the text of one of the previous versions of a wiki page.
     *
     * @param versionId
     * @param groupId - ID of the community that owns the wiki page.
     * @param userId
     * @param needHtml - '1' - to return the page as HTML
     * @return [VKRequest] with [PagesWikipageFull]
     */
    fun pagesGetVersion(
        versionId: Int,
        groupId: UserId? = null,
        userId: UserId? = null,
        needHtml: Boolean? = null
    ): VKRequest<PagesWikipageFull> = NewApiRequest("pages.getVersion") {
        GsonHolder.gson.fromJson(it, PagesWikipageFull::class.java)
    }
    .apply {
        addParam("version_id", versionId)
        groupId?.let { addParam("group_id", it) }
        userId?.let { addParam("user_id", it) }
        needHtml?.let { addParam("need_html", it) }
    }

    /**
     * Returns HTML representation of the wiki markup.
     *
     * @param text - Text of the wiki page.
     * @param groupId - ID of the group in the context of which this markup is interpreted.
     * @return [VKRequest] with [String]
     */
    fun pagesParseWiki(text: String, groupId: UserId? = null): VKRequest<String> =
            NewApiRequest("pages.parseWiki") {
        GsonHolder.gson.fromJson(it, String::class.java)
    }
    .apply {
        addParam("text", text)
        groupId?.let { addParam("group_id", it, min = 0) }
    }

    /**
     * Saves the text of a wiki page.
     *
     * @param text - Text of the wiki page in wiki-format.
     * @param pageId - Wiki page ID. The 'title' parameter can be passed instead of 'pid'.
     * @param groupId - ID of the community that owns the wiki page.
     * @param userId - User ID
     * @param title - Wiki page title.
     * @return [VKRequest] with [Int]
     */
    fun pagesSave(
        text: String? = null,
        pageId: Int? = null,
        groupId: UserId? = null,
        userId: UserId? = null,
        title: String? = null
    ): VKRequest<Int> = NewApiRequest("pages.save") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }
    .apply {
        text?.let { addParam("text", it) }
        pageId?.let { addParam("page_id", it) }
        groupId?.let { addParam("group_id", it) }
        userId?.let { addParam("user_id", it) }
        title?.let { addParam("title", it) }
    }

    /**
     * Saves modified read and edit access settings for a wiki page.
     *
     * @param pageId - Wiki page ID.
     * @param groupId - ID of the community that owns the wiki page.
     * @param userId
     * @param view - Who can view the wiki page_ '1' - only community members, '2' - all users can
     * view the page, '0' - only community managers
     * @param edit - Who can edit the wiki page_ '1' - only community members, '2' - all users can
     * edit the page, '0' - only community managers
     * @return [VKRequest] with [Int]
     */
    fun pagesSaveAccess(
        pageId: Int,
        groupId: UserId? = null,
        userId: UserId? = null,
        view: PagesSaveAccessView? = null,
        edit: PagesSaveAccessEdit? = null
    ): VKRequest<Int> = NewApiRequest("pages.saveAccess") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }
    .apply {
        addParam("page_id", pageId)
        groupId?.let { addParam("group_id", it) }
        userId?.let { addParam("user_id", it) }
        view?.let { addParam("view", it.value) }
        edit?.let { addParam("edit", it.value) }
    }
}
