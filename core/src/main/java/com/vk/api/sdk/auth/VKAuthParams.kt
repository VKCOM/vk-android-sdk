/**
 * Copyright (c) 2020 - present, LLC “V Kontakte”
 *
 * 1. Permission is hereby granted to any person obtaining a copy of this Software to
 * use the Software without charge.
 *
 * 2. Restrictions
 * You may not modify, merge, publish, distribute, sublicense, and/or sell copies,
 * create derivative works based upon the Software or any part thereof.
 *
 * 3. Termination
 * This License is effective until terminated. LLC “V Kontakte” may terminate this
 * License at any time without any negative consequences to our rights.
 * You may terminate this License at any time by deleting the Software and all copies
 * thereof. Upon termination of this license for any reason, you shall continue to be
 * bound by the provisions of Section 2 above.
 * Termination will be without prejudice to any rights LLC “V Kontakte” may have as
 * a result of this agreement.
 *
 * 4. Disclaimer of warranty and liability
 * THE SOFTWARE IS MADE AVAILABLE ON THE “AS IS” BASIS. LLC “V KONTAKTE” DISCLAIMS
 * ALL WARRANTIES THAT THE SOFTWARE MAY BE SUITABLE OR UNSUITABLE FOR ANY SPECIFIC
 * PURPOSES OF USE. LLC “V KONTAKTE” CAN NOT GUARANTEE AND DOES NOT PROMISE ANY
 * SPECIFIC RESULTS OF USE OF THE SOFTWARE.
 * UNDER NO CIRCUMSTANCES LLC “V KONTAKTE” BEAR LIABILITY TO THE LICENSEE OR ANY
 * THIRD PARTIES FOR ANY DAMAGE IN CONNECTION WITH USE OF THE SOFTWARE.
*/
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

class VKAuthParams @JvmOverloads constructor(val appId: Int, val redirectUrl: String = DEFAULT_REDIRECT_URL, scope: Collection<VKScope> = emptySet()) {
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
        bundle.putString(VK_APP_REDIRECT_URL_KEY, redirectUrl)
        return bundle
    }

    fun toExtraBundle(): Bundle {
        val bundle = Bundle()
        bundle.putInt(VK_EXTRA_CLIENT_ID, appId)
        bundle.putBoolean(VK_EXTRA_REVOKE, true)
        bundle.putString(VK_EXTRA_SCOPE, scope.joinToString(","))
        bundle.putString(VK_EXTRA_REDIRECT_URL, redirectUrl)
        return bundle
    }

    fun getScopeString() = scope.joinToString(",")

    companion object {
        private const val VK_APP_ID_KEY = "vk_app_id"
        private const val VK_APP_SCOPE_KEY = "vk_app_scope"
        private const val VK_APP_REDIRECT_URL_KEY = "vk_app_redirect_url"

        private const val VK_EXTRA_CLIENT_ID = "client_id"
        private const val VK_EXTRA_REVOKE = "revoke"
        private const val VK_EXTRA_SCOPE = "scope"
        private const val VK_EXTRA_REDIRECT_URL = "redirect_url"

        const val DEFAULT_REDIRECT_URL = "https://oauth.vk.com/blank.html"

        fun fromBundle(bundle: Bundle?): VKAuthParams? {
            if (bundle == null) {
                return null
            }
            val appId = bundle.getInt(VK_APP_ID_KEY)
            val scope: Collection<VKScope> = bundle.getStringArrayList(VK_APP_SCOPE_KEY)?.map { VKScope.valueOf(it) } ?: emptySet()
            val redirectUrl = bundle.getString(VK_APP_REDIRECT_URL_KEY, DEFAULT_REDIRECT_URL)

            return VKAuthParams(appId, redirectUrl, scope)
        }
    }
}