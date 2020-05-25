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
import android.content.Intent
import android.util.Log
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKKeyValueStorage
import com.vk.api.sdk.ui.VKWebViewAuthActivity
import com.vk.api.sdk.utils.VKUtils
import java.util.*

internal class VKAuthManager(private val keyValueStorage: VKKeyValueStorage) {
    fun login(activity: Activity, scopes: Collection<VKScope>) {
        val params = VKAuthParams(VK.getAppId(activity), scope = scopes)
        if (VKUtils.isAppInstalled(activity, VK_APP_PACKAGE_ID) && VKUtils.isIntentAvailable(activity, VK_APP_AUTH_ACTION)) {
            startAuthActivity(activity, params)
        } else {
            // start dialog with webview
            startInternalAuthActivity(activity, params)
        }
    }

    private fun startAuthActivity(activity: Activity, params: VKAuthParams) {
        val intent = Intent(VK_APP_AUTH_ACTION, null).apply {
            setPackage(VK_APP_PACKAGE_ID)
            putExtras(params.toExtraBundle())
        }
        activity.startActivityForResult(intent, VK_APP_AUTH_CODE)
    }

    private fun startInternalAuthActivity(activity: Activity, params: VKAuthParams) {
        VKWebViewAuthActivity.startForAuth(activity, params, VK_APP_AUTH_CODE)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?, callback: VKAuthCallback): Boolean {
        if (requestCode != VK_APP_AUTH_CODE) {
            return false
        }

        if (data == null) {
            callback.onLoginFailed(VKAuthCallback.AUTH_CANCELED)
            return true
        }

        val result = processResult(data)
        if (resultCode != Activity.RESULT_OK || result == null || result.isError) {
            callback.onLoginFailed(VKAuthCallback.AUTH_CANCELED)
        } else {
            result.accessToken!!.save(keyValueStorage)
            VK.apiManager.setCredentials(result.accessToken.accessToken, result.accessToken.secret)
            callback.onLogin(result.accessToken)
        }

        return true
    }

    private fun processResult(result: Intent): VKAuthResult? {
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
            else -> return null
        }

        return if (tokenParams != null && tokenParams[VK_AUTH_ERROR] == null) {
            try {
                VKAuthResult(VKAccessToken(tokenParams))
            } catch (e: Exception) {
                Log.e(VKAuthManager::class.java.simpleName, "Failed to get VK token", e)
                null
            }
        } else null
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

    companion object {
        const val VK_APP_PACKAGE_ID = "com.vkontakte.android"
        private const val VK_APP_AUTH_ACTION = "com.vkontakte.android.action.SDK_AUTH"
        const val VK_EXTRA_TOKEN_DATA = "extra-token-data"
        const val VK_AUTH_ERROR = "error"

        private const val VK_APP_AUTH_CODE = 282
    }
}