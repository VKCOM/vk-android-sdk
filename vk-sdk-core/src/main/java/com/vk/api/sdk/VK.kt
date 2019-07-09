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

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKAuthManager
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.internal.ApiCommand
import com.vk.api.sdk.requests.VKBooleanRequest
import com.vk.api.sdk.utils.VKUtils
import java.io.IOException

/**
 * This is an entry point of VK SDK
 */
object VK {
    @SuppressLint("StaticFieldLeak")
    private lateinit var config: VKApiConfig
    internal lateinit var apiManager: VKApiManager

    private val authManager: VKAuthManager = VKAuthManager()

    private val tokenExpiredHandlers = ArrayList<VKTokenExpiredHandler>()

    /**
     * This method initializes VK SDK with your custom config
     * @param config contains all required data for vk api
     */
    @JvmStatic
    fun setConfig(config: VKApiConfig) {
        this.config = config
        apiManager = VKApiManager(config)
        authManager.getCurrentToken(config.context)?.let {
            apiManager.setCredentials(it.accessToken, it.secret)
        }
    }

    /**
     * This method starts authorization process. If VK app is available in the system, it will be opened
     * Otherwise, WebView with vk.com will be used
     * @param activity current activity
     * @param scopes list of scopes required for app
     */
    @JvmStatic
    @JvmOverloads
    fun login(activity: Activity, scopes: Collection<VKScope> = emptySet()) {
        authManager.login(activity, scopes)
    }

    /**
     * This method is used to set new credentials for future requests. E.g. if you login via your own lib
     * @param userId userId of saving user
     * @param accessToken accessToken for future requests
     * @param secret secret for future requests
     * @param saveAccessTokenToPrefs create access token info and save it to prefs. If you pass {@code false},
     * you will not able to use sdk execute methods
     */
    @JvmStatic
    fun setCredentials(context: Context, userId: Int, accessToken: String, secret: String?, saveAccessTokenToPrefs: Boolean) {
        if (saveAccessTokenToPrefs) {
            VKAccessToken(userId, accessToken, secret).save(authManager.getPreferences(context))
        }
        apiManager.setCredentials(accessToken, secret)
    }

    /**
     * This method clears information about access token and cookies
     */
    @JvmStatic
    fun logout() {
        authManager.logout(config.context)
        VKUtils.clearAllCookies(config.context)
    }

    /**
     * This method checks if user is already logged in
     */
    @JvmStatic
    fun isLoggedIn() = authManager.isLoggedIn(config.context)


    /**
     * This method provide you an api version of current config
     */
    @JvmStatic
    fun getApiVersion() = config.version


    /**
     * Use this method to handle authorization result from your activity
     */
    @JvmStatic
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?, callback: VKAuthCallback): Boolean {
        val result = authManager.onActivityResult(requestCode, resultCode, data, callback, config.context)
        if (result && isLoggedIn()) {
            trackVisitor()
        }
        return result
    }


    /**
     * Add your custom token expiration handler
     */
    @JvmStatic
    fun addTokenExpiredHandler(handler: VKTokenExpiredHandler) {
        tokenExpiredHandlers.add(handler)
    }

    /**
     * Remove your custom token expiration handler
     */
    @JvmStatic
    fun removeTokenExpiredHandler(handler: VKTokenExpiredHandler) {
        tokenExpiredHandlers.remove(handler)
    }

    internal fun handleTokenExpired() {
        authManager.logout(config.context)

        tokenExpiredHandlers.forEach {
            it.onTokenExpired()
        }
    }

    /**
     * Execute api request synchronously
     * Do not use this method in UI thread
     */
    @JvmStatic
    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    fun <T> executeSync(cmd: ApiCommand<T>): T {
        return cmd.execute(apiManager)
    }

    /**
     * Execute api request with callback
     * You can use this method in UI thread
     * Also you can use your own async mechanism, like coroutines or RX
     */
    @JvmStatic
    fun <T>execute(request: ApiCommand<T>, callback: VKApiCallback<T>? = null) {
        VKScheduler.networkExecutor.submit {
            try {
                val result = executeSync(request)
                VKScheduler.runOnMainThread(Runnable {
                    callback?.success(result)
                })
            } catch (e: VKApiExecutionException) {
                VKScheduler.runOnMainThread(Runnable {
                    if (e.isInvalidCredentialsError) {
                        VK.handleTokenExpired()
                    }
                    callback?.fail(e)
                })
            }
        }
    }

    /**
     * This method initializes VK SDK with default settings
     * It automatically runs on start
     */
    @JvmStatic
    fun initialize(context: Context) {
        val appId = authManager.getAppId(context)
        if (appId == 0) {
            throw RuntimeException("<integer name=\"com_vk_sdk_AppId\">your_app_id</integer> is not found in your resources.xml")
        }
        setConfig(VKApiConfig(
                context = context,
                appId = appId,
                validationHandler = VKDefaultValidationHandler(context)))

        if (isLoggedIn()) {
            trackVisitor()
        }
    }

    @JvmStatic
    fun clearAccessToken(context: Context) {
        authManager.getPreferences(context).edit().clear().apply()
    }

    private fun trackVisitor() {
        execute(VKBooleanRequest("stats.trackVisitor"))
    }
}