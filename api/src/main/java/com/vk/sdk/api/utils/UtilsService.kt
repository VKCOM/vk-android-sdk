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
package com.vk.sdk.api.utils

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponse
import com.vk.sdk.api.utils.dto.UtilsDomainResolved
import com.vk.sdk.api.utils.dto.UtilsGetLastShortenedLinksResponse
import com.vk.sdk.api.utils.dto.UtilsGetLinkStatsExtendedInterval
import com.vk.sdk.api.utils.dto.UtilsGetLinkStatsExtendedSource
import com.vk.sdk.api.utils.dto.UtilsGetLinkStatsInterval
import com.vk.sdk.api.utils.dto.UtilsGetLinkStatsSource
import com.vk.sdk.api.utils.dto.UtilsLinkChecked
import com.vk.sdk.api.utils.dto.UtilsLinkStats
import com.vk.sdk.api.utils.dto.UtilsLinkStatsExtended
import com.vk.sdk.api.utils.dto.UtilsShortLink
import kotlin.Boolean
import kotlin.Int
import kotlin.String

class UtilsService {
    /**
     * Checks whether a link is blocked in VK.
     *
     * @param url - Link to check (e.g., 'http_//google.com').
     * @return [VKRequest] with [UtilsLinkChecked]
     */
    fun utilsCheckLink(url: String): VKRequest<UtilsLinkChecked> =
            NewApiRequest("utils.checkLink") {
        GsonHolder.gson.fromJson(it, UtilsLinkChecked::class.java)
    }
    .apply {
        addParam("url", url)
    }

    /**
     * Deletes shortened link from user's list.
     *
     * @param key - Link key (characters after vk.cc/).
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun utilsDeleteFromLastShortened(key: String): VKRequest<BaseOkResponse> =
            NewApiRequest("utils.deleteFromLastShortened") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("key", key)
    }

    /**
     * Returns a list of user's shortened links.
     *
     * @param count - Number of links to return.
     * @param offset - Offset needed to return a specific subset of links.
     * @return [VKRequest] with [UtilsGetLastShortenedLinksResponse]
     */
    fun utilsGetLastShortenedLinks(count: Int? = null, offset: Int? = null):
            VKRequest<UtilsGetLastShortenedLinksResponse> =
            NewApiRequest("utils.getLastShortenedLinks") {
        GsonHolder.gson.fromJson(it, UtilsGetLastShortenedLinksResponse::class.java)
    }
    .apply {
        count?.let { addParam("count", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
    }

    /**
     * Returns stats data for shortened link.
     *
     * @param key - Link key (characters after vk.cc/).
     * @param source - Source of scope
     * @param accessKey - Access key for private link stats.
     * @param interval - Interval.
     * @param intervalsCount - Number of intervals to return.
     * @return [VKRequest] with [UtilsLinkStats]
     */
    fun utilsGetLinkStats(
        key: String,
        source: UtilsGetLinkStatsSource? = null,
        accessKey: String? = null,
        interval: UtilsGetLinkStatsInterval? = null,
        intervalsCount: Int? = null
    ): VKRequest<UtilsLinkStats> = NewApiRequest("utils.getLinkStats") {
        GsonHolder.gson.fromJson(it, UtilsLinkStats::class.java)
    }
    .apply {
        addParam("key", key)
        source?.let { addParam("source", it.value) }
        accessKey?.let { addParam("access_key", it) }
        interval?.let { addParam("interval", it.value) }
        intervalsCount?.let { addParam("intervals_count", it, min = 0, max = 100) }
    }

    /**
     * Returns stats data for shortened link.
     *
     * @param key - Link key (characters after vk.cc/).
     * @param source - Source of scope
     * @param accessKey - Access key for private link stats.
     * @param interval - Interval.
     * @param intervalsCount - Number of intervals to return.
     * @return [VKRequest] with [UtilsLinkStatsExtended]
     */
    fun utilsGetLinkStatsExtended(
        key: String,
        source: UtilsGetLinkStatsExtendedSource? = null,
        accessKey: String? = null,
        interval: UtilsGetLinkStatsExtendedInterval? = null,
        intervalsCount: Int? = null
    ): VKRequest<UtilsLinkStatsExtended> = NewApiRequest("utils.getLinkStats") {
        GsonHolder.gson.fromJson(it, UtilsLinkStatsExtended::class.java)
    }
    .apply {
        addParam("key", key)
        source?.let { addParam("source", it.value) }
        accessKey?.let { addParam("access_key", it) }
        interval?.let { addParam("interval", it.value) }
        intervalsCount?.let { addParam("intervals_count", it, min = 0, max = 100) }
        addParam("extended", true)
    }

    /**
     * Returns the current time of the VK server.
     *
     * @return [VKRequest] with [Int]
     */
    fun utilsGetServerTime(): VKRequest<Int> = NewApiRequest("utils.getServerTime") {
        GsonHolder.gson.fromJson(it, Int::class.java)
    }

    /**
     * Allows to receive a link shortened via vk.cc.
     *
     * @param url - URL to be shortened.
     * @param private - 1 - private stats, 0 - public stats.
     * @return [VKRequest] with [UtilsShortLink]
     */
    fun utilsGetShortLink(url: String, private: Boolean? = null): VKRequest<UtilsShortLink> =
            NewApiRequest("utils.getShortLink") {
        GsonHolder.gson.fromJson(it, UtilsShortLink::class.java)
    }
    .apply {
        addParam("url", url)
        private?.let { addParam("private", it) }
    }

    /**
     * Detects a type of object (e.g., user, community, application) and its ID by screen name.
     *
     * @param screenName - Screen name of the user, community (e.g., 'apiclub,' 'andrew', or
     * 'rules_of_war'), or application.
     * @return [VKRequest] with [UtilsDomainResolved]
     */
    fun utilsResolveScreenName(screenName: String): VKRequest<UtilsDomainResolved> =
            NewApiRequest("utils.resolveScreenName") {
        GsonHolder.gson.fromJson(it, UtilsDomainResolved::class.java)
    }
    .apply {
        addParam("screen_name", screenName)
    }
}
