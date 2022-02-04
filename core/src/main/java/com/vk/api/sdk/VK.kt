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

package com.vk.api.sdk

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import com.vk.api.sdk.auth.*
import com.vk.api.sdk.auth.VKAuthManager
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.internal.ApiCommand
import com.vk.api.sdk.requests.VKBooleanRequest
import com.vk.api.sdk.utils.VKUrlResolver
import com.vk.api.sdk.utils.VKUtils
import com.vk.api.sdk.utils.DefaultUserAgent
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

        apiManager.setCredentials(VKApiCredentials.lazyFrom { authManager.getCurrentToken() })
    }

    /**
     * This method starts authorization process. If VK app is available in the system, it will be opened
     * Otherwise, WebView with vk.com will be used
     * @param activity current activity
     * @param scopes list of scopes required for app
     */
    @Deprecated("Use login with usage of ActivityResultLauncher")
    @JvmStatic
    @JvmOverloads
    fun login(activity: Activity, scopes: Collection<VKScope> = emptySet()) {
        authManager.login(activity, scopes)
    }

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
    fun setCredentials(context: Context, userId: UserId, accessToken: String, secret: String?, saveAccessTokenToStorage: Boolean = true) {
        if (saveAccessTokenToStorage) {
            VKAccessToken(userId, accessToken, secret).save(config.keyValueStorage)
        }
        apiManager.setCredentials(accessToken, secret)
    }

    /**
     * Save access token to keyValueStorage provided by [VKApiConfig] ([VKApiConfig.keyValueStorage]).
     *
     * @param userId userId of saving user
     * @param accessToken accessToken for future requests
     * @param secret secret for future requests
     */
    @JvmStatic
    fun saveAccessToken(context: Context, userId: UserId, accessToken: String, secret: String?) {
        setCredentials(context, userId, accessToken, secret, true)
    }

    /**
     * This method clears information about access token and cookies
     */
    @JvmStatic
    fun logout() {
        authManager.clearAccessToken()
        VKUtils.clearAllCookies(config.context)
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
     * Use this method to handle authorization result from your activity
     */
    @JvmStatic
    @JvmOverloads
    @Deprecated("Use new api for getting a result from an activity instead")
    fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        callback: VKAuthCallback,
        showErrorToast: Boolean = true
    ): Boolean {
        val result = authManager.onActivityResult(config.context, requestCode, resultCode, data, callback, showErrorToast)
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

        val resId = context.resources.getIdentifier(SDK_APP_ID, "integer", context.packageName)
        val appId = try {
            context.resources.getInteger(resId)
        } catch (e: Exception) {
            0
        }
        if (appId == 0) {
            throw RuntimeException("<integer name=\"$SDK_APP_ID\">your_app_id</integer> is not found in your resources.xml")
        }
        cachedResourceAppId = appId
        return appId
    }
}