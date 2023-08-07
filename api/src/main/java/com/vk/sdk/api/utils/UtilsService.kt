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
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.utils.dto.UtilsDomainResolvedDto
import com.vk.sdk.api.utils.dto.UtilsGetLastShortenedLinksResponseDto
import com.vk.sdk.api.utils.dto.UtilsGetLinkStatsExtendedIntervalDto
import com.vk.sdk.api.utils.dto.UtilsGetLinkStatsExtendedSourceDto
import com.vk.sdk.api.utils.dto.UtilsGetLinkStatsIntervalDto
import com.vk.sdk.api.utils.dto.UtilsGetLinkStatsSourceDto
import com.vk.sdk.api.utils.dto.UtilsLinkCheckedDto
import com.vk.sdk.api.utils.dto.UtilsLinkStatsDto
import com.vk.sdk.api.utils.dto.UtilsLinkStatsExtendedDto
import com.vk.sdk.api.utils.dto.UtilsShortLinkDto
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String

class UtilsService {
    /**
     * Checks whether a link is blocked in VK.
     *
     * @param url - Link to check (e.g., 'http_//google.com').
     * @return [VKRequest] with [UtilsLinkCheckedDto]
     */
    fun utilsCheckLink(url: String): VKRequest<UtilsLinkCheckedDto> =
            NewApiRequest("utils.checkLink") {
        GsonHolder.gson.parse<UtilsLinkCheckedDto>(it)
    }
    .apply {
        addParam("url", url)
    }

    /**
     * Deletes shortened link from user's list.
     *
     * @param key - Link key (characters after vk.cc/).
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun utilsDeleteFromLastShortened(key: String): VKRequest<BaseOkResponseDto> =
            NewApiRequest("utils.deleteFromLastShortened") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("key", key)
    }

    /**
     * Returns a list of user's shortened links.
     *
     * @param count - Number of links to return.
     * @param offset - Offset needed to return a specific subset of links.
     * @return [VKRequest] with [UtilsGetLastShortenedLinksResponseDto]
     */
    fun utilsGetLastShortenedLinks(count: Int? = null, offset: Int? = null):
            VKRequest<UtilsGetLastShortenedLinksResponseDto> =
            NewApiRequest("utils.getLastShortenedLinks") {
        GsonHolder.gson.parse<UtilsGetLastShortenedLinksResponseDto>(it)
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
     * @param extended - 1 - to return extended stats data (sex, age, geo). 0 - to return views
     * number only.
     * @return [VKRequest] with [UtilsLinkStatsDto]
     */
    fun utilsGetLinkStats(
        key: String,
        source: UtilsGetLinkStatsSourceDto? = null,
        accessKey: String? = null,
        interval: UtilsGetLinkStatsIntervalDto? = null,
        intervalsCount: Int? = null,
        extended: Boolean? = null
    ): VKRequest<UtilsLinkStatsDto> = NewApiRequest("utils.getLinkStats") {
        GsonHolder.gson.parse<UtilsLinkStatsDto>(it)
    }
    .apply {
        addParam("key", key)
        source?.let { addParam("source", it.value) }
        accessKey?.let { addParam("access_key", it) }
        interval?.let { addParam("interval", it.value) }
        intervalsCount?.let { addParam("intervals_count", it, min = 0, max = 100) }
        extended?.let { addParam("extended", it) }
    }

    /**
     * Returns stats data for shortened link.
     *
     * @param key - Link key (characters after vk.cc/).
     * @param source - Source of scope
     * @param accessKey - Access key for private link stats.
     * @param interval - Interval.
     * @param intervalsCount - Number of intervals to return.
     * @return [VKRequest] with [UtilsLinkStatsExtendedDto]
     */
    fun utilsGetLinkStatsExtended(
        key: String,
        source: UtilsGetLinkStatsExtendedSourceDto? = null,
        accessKey: String? = null,
        interval: UtilsGetLinkStatsExtendedIntervalDto? = null,
        intervalsCount: Int? = null
    ): VKRequest<UtilsLinkStatsExtendedDto> = NewApiRequest("utils.getLinkStats") {
        GsonHolder.gson.parse<UtilsLinkStatsExtendedDto>(it)
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
        GsonHolder.gson.parse<Int>(it)
    }

    /**
     * Allows to receive a link shortened via vk.cc.
     *
     * @param url - URL to be shortened.
     * @param private - 1 - private stats, 0 - public stats.
     * @return [VKRequest] with [UtilsShortLinkDto]
     */
    fun utilsGetShortLink(url: String, private: Boolean? = null): VKRequest<UtilsShortLinkDto> =
            NewApiRequest("utils.getShortLink") {
        GsonHolder.gson.parse<UtilsShortLinkDto>(it)
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
     * @return [VKRequest] with [UtilsDomainResolvedDto]
     */
    fun utilsResolveScreenName(screenName: String): VKRequest<UtilsDomainResolvedDto> =
            NewApiRequest("utils.resolveScreenName") {
        GsonHolder.gson.parse<UtilsDomainResolvedDto>(it)
    }
    .apply {
        addParam("screen_name", screenName)
    }

    object UtilsGetLastShortenedLinksRestrictions {
        const val COUNT_MIN: Long = 0

        const val OFFSET_MIN: Long = 0
    }

    object UtilsGetLinkStatsRestrictions {
        const val INTERVALS_COUNT_MIN: Long = 0

        const val INTERVALS_COUNT_MAX: Long = 100
    }

    object UtilsGetLinkStatsExtendedRestrictions {
        const val INTERVALS_COUNT_MIN: Long = 0

        const val INTERVALS_COUNT_MAX: Long = 100
    }
}
