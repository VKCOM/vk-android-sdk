/*******************************************************************************
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
 ******************************************************************************/

package com.vk.api.sdk

import java.util.concurrent.ConcurrentHashMap

interface VKKeyValueStorage {
    fun put(key: String, value: String)
    fun get(key: String): String?
    fun remove(key: String)

    fun putOrRemove(key: String, value: String?) {
        value?.let { put(key, value) } ?: remove(key)
    }
}

class VKCachedKeyValueStorage(private val storage: VKKeyValueStorage): VKKeyValueStorage {
    private val cache: MutableMap<String, String> = ConcurrentHashMap()

    override fun put(key: String, value: String) {
        if (cache[key] != value) {
            cache[key] = value
            storage.put(key, value)
        }
    }

    override fun get(key: String): String? {
        val value = cache[key]
        return if (value !== NULL_STRING) {
            return value ?: getFromStorage(key)
        } else null
    }

    override fun remove(key: String) {
        if (cache[key] !== NULL_STRING) {
            cache[key] = NULL_STRING
            storage.remove(key)
        }
    }

    private fun getFromStorage(key: String): String? {
        val value = storage.get(key)
        cache[key] = value ?: NULL_STRING
        return value
    }

    companion object {
        private val NULL_STRING = String()
    }
}

fun VKKeyValueStorage.cached(): VKKeyValueStorage = VKCachedKeyValueStorage(this)
