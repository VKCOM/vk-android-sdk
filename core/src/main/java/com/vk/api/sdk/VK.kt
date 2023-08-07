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
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthManager
import com.vk.api.sdk.auth.VKAuthResultContract
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.internal.ApiCommand
import com.vk.api.sdk.requests.VKBooleanRequest
import com.vk.api.sdk.utils.DefaultUserAgent
import com.vk.api.sdk.utils.VKUrlResolver
import com.vk.api.sdk.utils.VKUtils
import com.vk.dto.common.id.UserId
import java.io.IOException

/**
 * This is an entry point of VK SDK
 */
object VK {
    private const val SDK_APP_ID = "com_vk_sdk_AppId"
    private const val SDK_UA_PREFIX = "VKAndroidSDK"
    private const val SDK_VERSION = "VKSdkVersion"
    private const val SDK_VERSION_CODE = "VKSdkVersionCode"

    @SuppressLint("StaticFieldLeak")
    private lateinit var config: VKApiConfig
    internal lateinit var apiManager: VKApiManager
    private lateinit var authManager: VKAuthManager

    private val tokenExpiredHandlers = ArrayList<VKTokenExpiredHandler>()

    private var cachedResourceAppId = 0

    /**
     * This field contains an instance of VKUrlResolver that can be used to open a URL in VK client.
     */
    val urlResolver by lazy { VKUrlResolver() }

    /**
     * This method initializes VK SDK with your custom config
     * @param config contains all required data for vk api
     */
    @JvmStatic
    fun setConfig(config: VKApiConfig) {
        this.config = config
        apiManager = VKApiManager(config)
        authManager = VKAuthManager(config.keyValueStorage)

        val lazyCredentials = lazy {
            val token = authManager.getCurrentToken() ?: return@lazy listOf(VKApiCredentials("", null, 0, 0, UserId.DEFAULT))
            listOf(VKApiCredentials(token.accessToken, token.secret, token.expiresInSec, token.createdMs, token.userId))
        }
        apiManager.setCredentials(lazyCredentials)
    }

    /**
     * This method register callback for authorization process.
     * If VK app is available in the system, it will be opened
     * Otherwise, WebView with vk.com will be used
     * @param activity current activity
     * @param callback callback with authentication result
     */
    @JvmStatic
    fun login(
        activity: ComponentActivity,
        callback: ActivityResultCallback<VKAuthenticationResult>
    ): ActivityResultLauncher<Collection<VKScope>> {
        return activity.registerForActivityResult(getVKAuthActivityResultContract(), callback)
    }

    /**
     * This method is used to set new credentials for future requests. E.g. if you login via your own lib
     *
     * @param userId userId of saving user
     * @param accessToken accessToken for future requests
     * @param secret secret for future requests
     * @param saveAccessTokenToStorage create access token info and save it to keyValueStorage provided
     * by [VKApiConfig] ([VKApiConfig.keyValueStorage]).
     * If you pass {@code false} you will not able to use sdk execute methods!
     */
    @JvmStatic
    fun setCredentials(userId: UserId, accessToken: String, secret: String?, expiresInSec: Int, createdMs: Long, saveAccessTokenToStorage: Boolean = true) {
        if (saveAccessTokenToStorage) {
            VKAccessToken(userId, accessToken, secret, expiresInSec, createdMs).save(config.keyValueStorage)
        }
        apiManager.setCredentials(listOf(VKApiCredentials(accessToken, secret, expiresInSec, createdMs, userId)))
    }

    fun setCredentials(credentials: List<Pair<UserId, VKApiCredentials>>) {
        val firstPair = credentials.firstOrNull() ?: return
        val firstCreds = firstPair.second
        VKAccessToken(firstPair.first, firstCreds.accessToken, firstCreds.secret, firstCreds.expiresInSec, firstCreds.createdMs).save(config.keyValueStorage)

        val allCreds = credentials.map { it.second }
        apiManager.setCredentials(allCreds)
    }

    /**
     * Save access token to keyValueStorage provided by [VKApiConfig] ([VKApiConfig.keyValueStorage]).
     *
     * @param userId userId of saving user
     * @param accessToken accessToken for future requests
     * @param secret secret for future requests
     */
    @JvmStatic
    fun saveAccessToken(userId: UserId, accessToken: String, secret: String?, expiresInSec: Int, createdMs: Long) {
        setCredentials(userId, accessToken, secret, expiresInSec, createdMs, true)
    }

    /**
     * This method clears information about access token and cookies
     */
    @JvmStatic
    fun logout() {
        authManager.clearAccessToken()
        VKUtils.clearAllCookies()
    }

    /**
     * This method checks if user is already logged in
     */
    @JvmStatic
    fun isLoggedIn() = authManager.isLoggedIn()

    /**
     * This method returns userId of currently logged in user or 0 if there is no logged in user
     */
    @JvmStatic
    fun getUserId() = authManager.getCurrentToken()?.userId ?: UserId.DEFAULT

    /**
     * This method provide you an api version of current config
     */
    @JvmStatic
    fun getApiVersion() = config.version

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
        authManager.clearAccessToken()

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
            } catch (e: Exception) {
                VKScheduler.runOnMainThread(Runnable {
                    if (e is VKApiExecutionException && e.isInvalidCredentialsError) {
                        handleTokenExpired()
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
        val appId = getAppIdFromResources(context)
        setConfig(VKApiConfig(
                context = context,
                appId = appId,
                validationHandler = VKDefaultValidationHandler(context)))

        if (isLoggedIn()) {
            trackVisitor()
        }
    }

    /**
     * This method returns Application ID of current [VKApiConfig]
     * or value of com_vk_sdk_AppId resource if VK SDK wasn't initialized
     */
    @JvmStatic
    fun getAppId(context: Context): Int {
        return try {
            apiManager.config.appId
        } catch (ignored: Exception) { // lateinit exception
            // If somebody calls this method before initialization, return resource value
            getAppIdFromResources(context)
        }
    }

    @JvmStatic
    fun clearAccessToken(context: Context) {
        if (::authManager.isInitialized) {
            authManager.clearAccessToken()
        }
    }

    /**
     * This method returns [androidx.activity.result.contract.ActivityResultContract] instance which
     * can be used to launch VK authentication
     */
    @JvmStatic
    fun getVKAuthActivityResultContract(): ActivityResultContract<Collection<VKScope>, VKAuthenticationResult> {
        return VKAuthResultContract(authManager)
    }

    internal fun getSDKUserAgent(): DefaultUserAgent {
        if (!::config.isInitialized) {
            throw RuntimeException("please call VK.initialize first!")
        }
        val metaData = config.context.packageManager
            .getApplicationInfo(config.context.packageName, PackageManager.GET_META_DATA)
        return DefaultUserAgent(
            SDK_UA_PREFIX,
            metaData.metaData[SDK_VERSION].toString(),
            metaData.metaData[SDK_VERSION_CODE].toString(),
            VKUtils.getPhysicalDisplaySize(config.context)
        )
    }

    internal fun trackVisitor() {
        execute(VKBooleanRequest("stats.trackVisitor"))
    }

    private fun getAppIdFromResources(context: Context): Int {
        if (cachedResourceAppId != 0) {
            return cachedResourceAppId
        }

        val appId = context.resources.getInteger(R.integer.com_vk_sdk_AppId)
        if (appId == 0) {
            throw RuntimeException("<integer name=\"$SDK_APP_ID\">your_app_id</integer> is not found in your resources.xml")
        }
        cachedResourceAppId = appId
        return appId
    }
}