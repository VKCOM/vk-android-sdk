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
import android.content.SharedPreferences
import com.vk.api.sdk.VK
import com.vk.api.sdk.ui.VKWebViewAuthActivity
import com.vk.api.sdk.utils.VKUtils
import java.util.*

internal class VKAuthManager {
    fun login(activity: Activity, scopes: Collection<VKScope>) {
        val params = VKAuthParams(getAppId(activity), scopes)
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

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?, callback: VKAuthCallback, context: Context): Boolean {
        if (requestCode != VK_APP_AUTH_CODE || data == null) {
            return false
        }

        val result = processResult(data)
        if (resultCode != Activity.RESULT_OK || result == null || result.isError) {
            callback.onLoginFailed(VKAuthCallback.AUTH_CANCELED)
        } else {
            result.accessToken!!.save(getPreferences(context))
            VK.apiManager.setCredentials(result.accessToken.accessToken, result.accessToken.secret)
            callback.onLogin(result.accessToken)
        }

        return true
    }

    fun getAppId(context: Context): Int {
        val resId = context.resources.getIdentifier(SDK_APP_ID, "integer", context.packageName)
        return try {
            context.resources.getInteger(resId)
        } catch (e: Exception) {
            0
        }
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

        return if (tokenParams != null && tokenParams[VK_AUTH_ERROR] == null) VKAuthResult(VKAccessToken(tokenParams)) else null
    }


    fun isLoggedIn(context: Context): Boolean {
        val token = getCurrentToken(context)
        return token != null && token.isValid
    }

    fun getCurrentToken(context: Context): VKAccessToken? {
        return VKAccessToken.restore(getPreferences(context))
    }

    fun logout(context: Context) {
        getPreferences(context).edit().clear().apply()
    }

    fun getPreferences(context: Context): SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    companion object {
        const val VK_APP_PACKAGE_ID = "com.vkontakte.android"
        private const val VK_APP_AUTH_ACTION = "com.vkontakte.android.action.SDK_AUTH"
        const val VK_EXTRA_TOKEN_DATA = "extra-token-data"
        const val VK_AUTH_ERROR = "error"

        private const val PREFERENCE_NAME = "com.vkontakte.android_pref_name"

        private const val SDK_APP_ID = "com_vk_sdk_AppId"

        private const val VK_APP_AUTH_CODE = 282
    }
}