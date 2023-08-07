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
package com.vk.sdk.api.storage

import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import com.vk.sdk.api.storage.dto.StorageValueDto
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class StorageService {
    /**
     * Returns a value of variable with the name set by key parameter.
     *
     * @param key
     * @param keys
     * @param userId
     * @return [VKRequest] with [Unit]
     */
    fun storageGet(
        key: String? = null,
        keys: List<String>? = null,
        userId: UserId? = null
    ): VKRequest<List<StorageValueDto>> = NewApiRequest("storage.get") {
        GsonHolder.gson.parseList<StorageValueDto>(it)
    }
    .apply {
        key?.let { addParam("key", it, maxLength = 100) }
        keys?.let { addParam("keys", it) }
        userId?.let { addParam("user_id", it, min = 0) }
    }

    /**
     * Returns the names of all variables.
     *
     * @param userId - user id, whose variables names are returned if they were requested with a
     * server method.
     * @param offset
     * @param count - amount of variable names the info needs to be collected from.
     * @return [VKRequest] with [Unit]
     */
    fun storageGetKeys(
        userId: UserId? = null,
        offset: Int? = null,
        count: Int? = null
    ): VKRequest<List<String>> = NewApiRequest("storage.getKeys") {
        GsonHolder.gson.parseList<String>(it)
    }
    .apply {
        userId?.let { addParam("user_id", it, min = 0) }
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 1000) }
    }

    /**
     * Saves a value of variable with the name set by 'key' parameter.
     *
     * @param key
     * @param value
     * @param userId
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun storageSet(
        key: String,
        value: String? = null,
        userId: UserId? = null
    ): VKRequest<BaseOkResponseDto> = NewApiRequest("storage.set") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("key", key, maxLength = 100)
        value?.let { addParam("value", it) }
        userId?.let { addParam("user_id", it, min = 0) }
    }

    object StorageGetRestrictions {
        const val KEY_MAX_LENGTH: Int = 100

        const val USER_ID_MIN: Long = 0
    }

    object StorageGetKeysRestrictions {
        const val USER_ID_MIN: Long = 0

        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 1000
    }

    object StorageSetRestrictions {
        const val KEY_MAX_LENGTH: Int = 100

        const val USER_ID_MIN: Long = 0
    }
}
