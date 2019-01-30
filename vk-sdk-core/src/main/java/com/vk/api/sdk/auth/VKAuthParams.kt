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

package com.vk.api.sdk.auth

import android.os.Bundle
import java.util.HashSet

class VKAuthParams @JvmOverloads constructor(val appId: Int, scope: Collection<VKScope> = emptySet()) {
    private val scope: Set<VKScope>

    init {
        if (appId == 0) {
            throw IllegalStateException("AppId is empty! Find out how to get your appId at https://vk.com/dev/access_token")
        }
        this.scope = HashSet(scope)
    }

    fun toBundle(): Bundle {
        val bundle = Bundle()
        bundle.putInt(VK_APP_ID_KEY, appId)
        bundle.putStringArrayList(VK_APP_SCOPE_KEY, ArrayList(scope.map { it.name }))
        return bundle
    }

    fun toExtraBundle(): Bundle {
        val bundle = Bundle()
        bundle.putInt(VK_EXTRA_CLIENT_ID, appId)
        bundle.putBoolean(VK_EXTRA_REVOKE, true)
        bundle.putString(VK_EXTRA_SCOPE, scope.joinToString(","))
        return bundle
    }

    fun getScopeString() = scope.joinToString(",")

    companion object {
        private const val VK_APP_ID_KEY = "vk_app_id"
        private const val VK_APP_SCOPE_KEY = "vk_app_scope"

        private const val VK_EXTRA_CLIENT_ID = "client_id"
        private const val VK_EXTRA_REVOKE = "revoke"
        private const val VK_EXTRA_SCOPE = "scope"

        fun fromBundle(bundle: Bundle?): VKAuthParams? {
            if (bundle == null) {
                return null
            }
            val appId = bundle.getInt(VK_APP_ID_KEY)
            val scope: Collection<VKScope> = bundle.getStringArrayList(VK_APP_SCOPE_KEY)?.map { VKScope.valueOf(it) } ?: emptySet()

            return VKAuthParams(appId, scope)
        }
    }
}