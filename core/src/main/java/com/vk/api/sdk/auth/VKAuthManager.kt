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

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import com.vk.api.sdk.R
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKKeyValueStorage
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKAuthException
import com.vk.api.sdk.extensions.showToast
import com.vk.api.sdk.ui.VKWebViewAuthActivity
import com.vk.api.sdk.utils.VKUtils
import java.util.*

internal class VKAuthManager(private val keyValueStorage: VKKeyValueStorage) {
    fun login(activity: Activity, scopes: Collection<VKScope>) {
        val params = VKAuthParams(VK.getAppId(activity), scope = prepareScopes(scopes))
        if (VKUtils.isIntentAvailable(activity, VK_APP_AUTH_ACTION, null, VK_APP_PACKAGE_ID)) {
            startAuthActivity(activity, params)
        } else {
            // start dialog with webview
            startInternalAuthActivity(activity, params)
        }
    }

    private fun startAuthActivity(activity: Activity, params: VKAuthParams) {
        val intent = createVKClientAuthIntent(params)
        activity.startActivityForResult(intent, VK_APP_AUTH_CODE)
    }

    private fun startInternalAuthActivity(activity: Activity, params: VKAuthParams) {
        VKWebViewAuthActivity.startForAuth(activity, params, VK_APP_AUTH_CODE)
    }

    fun createVKClientAuthIntent(params: VKAuthParams) = Intent(VK_APP_AUTH_ACTION, null).apply {
        setPackage(VK_APP_PACKAGE_ID)
        putExtras(params.toExtraBundle())
    }

    fun onActivityResult(
        context: Context,
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        callback: VKAuthCallback,
        showErrorToast: Boolean
    ): Boolean {
        if (requestCode != VK_APP_AUTH_CODE) {
            return false
        }

        if (data == null) {
            callback.onLoginFailed(VKAuthException())
            return true
        }

        val result: VKAuthenticationResult = processResult(data)
        if (resultCode != Activity.RESULT_OK || result is VKAuthenticationResult.Failed) {
            val loginError = (result as? VKAuthenticationResult.Failed)?.exception
                ?: obtainExceptionFromIntent(data)
            callback.onLoginFailed(loginError)
            if (showErrorToast && !loginError.isCanceled) {
                context.showToast(R.string.vk_message_login_error)
            }
        } else {
            (result as? VKAuthenticationResult.Success)?.let {
                storeLoginResult(it)
                callback.onLogin(it.token)
            }
        }

        return true
    }

    fun processResult(result: Intent?): VKAuthenticationResult {
        result ?: return VKAuthenticationResult.Failed(VKAuthException(authError = "No result from caller provided"))
        val tokenParams: MutableMap<String, String>?
        when {
            result.hasExtra(VK_EXTRA_TOKEN_DATA) -> {
                // Token received via webview
                val tokenInfo = result.getStringExtra(VK_EXTRA_TOKEN_DATA)
                tokenParams = VKUtils.explodeQueryString(tokenInfo)
            }
            result.extras != null -> {
                // Token received via VK app
                tokenParams = HashMap()
                for (key in result.extras!!.keySet()) {
                    tokenParams[key] = result.extras!!.get(key).toString()
                }
            }
            else -> tokenParams = null
        }
        return if (tokenParams != null && tokenParams[VK_AUTH_ERROR] == null) {
            try {
                VKAuthenticationResult.Success(VKAccessToken(tokenParams))
            } catch (e: Exception) {
                Log.e(VKAuthManager::class.java.simpleName, "Failed to get VK token", e)
                VKAuthenticationResult.Failed(VKAuthException(authError = "Auth failed due to exception: ${e.message}"))
            }
        } else {
            VKAuthenticationResult.Failed(obtainExceptionFromIntent(result))
        }
    }

    fun storeLoginResult(result: VKAuthenticationResult.Success) {
        result.token.save(keyValueStorage)
        VK.apiManager.setCredentials(result.token.accessToken, result.token.secret)
    }

    private fun prepareScopes(scopes: Collection<VKScope>): Collection<VKScope> {
        if (!scopes.contains(VKScope.OFFLINE)) {
            return scopes + VKScope.OFFLINE
        }
        return scopes
    }

    fun isLoggedIn(): Boolean {
        val token = getCurrentToken()
        return token != null && token.isValid
    }

    fun getCurrentToken(): VKAccessToken? {
        return VKAccessToken.restore(keyValueStorage)
    }

    fun clearAccessToken() {
        VKAccessToken.remove(keyValueStorage)
    }

    private fun obtainExceptionFromIntent(intent: Intent): VKAuthException {
        val webViewError = intent.extras?.getInt(VKApiCodes.EXTRA_VW_LOGIN_ERROR) ?: 0
        val authError = intent.extras?.getString(VKApiCodes.EXTRA_AUTH_ERROR)
        return VKAuthException(webViewError, authError)
    }

    companion object {
        const val VK_APP_PACKAGE_ID = "com.vkontakte.android"
        const val VK_APP_AUTH_ACTION = "com.vkontakte.android.action.SDK_AUTH"
        const val VK_EXTRA_TOKEN_DATA = "extra-token-data"
        const val VK_AUTH_ERROR = "error"

        private const val VK_APP_AUTH_CODE = 282
    }
}