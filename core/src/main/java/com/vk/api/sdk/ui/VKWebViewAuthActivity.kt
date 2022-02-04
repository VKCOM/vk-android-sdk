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

package com.vk.api.sdk.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import com.vk.api.sdk.R
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiValidationHandler
import com.vk.api.sdk.auth.VKAuthManager
import com.vk.api.sdk.auth.VKAuthParams
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.extensions.toActivitySafe
import com.vk.api.sdk.utils.VKUtils
import com.vk.api.sdk.utils.VKValidationLocker

/**
 * Activity for showing authorization or validation WebView
 */
open class VKWebViewAuthActivity: Activity() {

    private lateinit var webView: WebView
    private lateinit var progress: ProgressBar

    private lateinit var params: VKAuthParams

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vk_webview_auth_dialog)

        webView = findViewById(R.id.webView)
        progress = findViewById(R.id.progress)

        val authParams = VKAuthParams.fromBundle(intent.getBundleExtra(VK_EXTRA_AUTH_PARAMS))
        if (authParams == null) {
            if (!needValidationResult()) finish()
        } else {
            params = authParams
        }
        configureWebView()
        loadUrl()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun configureWebView() {
        webView.apply {
            webViewClient = OAuthWebViewClient()
            isVerticalScrollBarEnabled = false
            visibility = View.INVISIBLE
            overScrollMode = View.OVER_SCROLL_NEVER
        }
        webView.settings.apply {
            javaScriptEnabled = true
        }
    }

    protected open fun getUrlParams(): Map<String, String> = mapOf(
        "client_id" to params.appId.toString(),
        "scope" to params.getScopeString(),
        "redirect_uri" to params.redirectUrl,
        "response_type" to "token",
        "display" to "mobile",
        "v" to VK.getApiVersion(),
        "revoke" to "1"
    )

    private fun loadUrl() {
        try {
            val urlToLoad: String = if (needValidationResult()) {
                intent.getStringExtra(VK_EXTRA_VALIDATION_URL)
                    ?: throw IllegalStateException("There is no $VK_EXTRA_VALIDATION_URL key inside")
            } else {
                val uri = Uri.parse("https://oauth.vk.com/authorize").buildUpon()
                val params = getUrlParams()
                for ((key, value) in params) {
                    uri.appendQueryParameter(key, value)
                }
                uri.build().toString()
            }

            webView.loadUrl(urlToLoad)
        } catch (e: Exception) {
            e.printStackTrace()
            setResult(RESULT_CANCELED)
            finish()
        }
    }

    private fun needValidationResult() = intent.getStringExtra(VK_EXTRA_VALIDATION_URL) != null
    private val redirectUrl get() =
        if (needValidationResult()) intent.getStringExtra(VK_EXTRA_VALIDATION_URL)
        else params.redirectUrl

    private fun showWebView() {
        progress.visibility = View.GONE
        webView.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        webView.destroy()
        VKValidationLocker.signal()
        super.onDestroy()
    }

    inner class OAuthWebViewClient: WebViewClient() {
        private var hasError = false

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return handleUrl(request?.url.toString())
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return handleUrl(url)
        }

        private fun handleUrl(url: String?): Boolean {
            if (url == null) return false

            if (needValidationResult()) {
                val uri = Uri.parse(url.replace("#", "?"))
                if (uri.getQueryParameter("success") != null) {
                    handleSuccess(uri)
                } else if (uri.getQueryParameter("cancel") != null) {
                    notifyLockerAndFinish()
                }
                return false
            } else {
                val safeRedirect = redirectUrl
                if (safeRedirect != null && !url.startsWith(safeRedirect)) {
                    return false
                }
                val intent = Intent(VK_RESULT_INTENT_NAME)
                val extraData = url.substring(url.indexOf("#") + 1)
                intent.putExtra(VKAuthManager.VK_EXTRA_TOKEN_DATA, extraData)

                val resultParams = VKUtils.explodeQueryString(extraData)
                val resultCode = if (resultParams != null
                    && (resultParams.containsKey("error")
                        || resultParams.containsKey("cancel"))) RESULT_CANCELED else RESULT_OK

                setResult(resultCode, intent)
                notifyLockerAndFinish()
            }

            return true
        }


        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            handleUrl(url)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            if (!hasError) showWebView()
        }

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError?) {
            super.onReceivedError(view, request, error)
            val url = request.url.toString()
            var errorDescription = "no_description"
            var errorCode: Int = ERROR_UNKNOWN
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && error != null) {
                errorDescription = error.description.toString()
                errorCode = error.errorCode
            }

            Log.w(LOG_TAG, "$errorCode:$errorDescription:$url")
            if (webView.url == url) {
                onError(errorCode)
            }
        }

        @Suppress("DEPRECATION")
        override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
            super.onReceivedError(view, errorCode, description, failingUrl)
            Log.w(LOG_TAG, "$errorCode:$description:$failingUrl")
            if (webView.url == failingUrl) {
                onError(errorCode)
            }
        }

        private fun onError(errorCode: Int) {
            hasError = true

            val intent = Intent().apply {
                putExtra(VKApiCodes.EXTRA_VW_LOGIN_ERROR, errorCode)
            }
            setResult(RESULT_CANCELED, intent)
            finish()
        }
    }

    private fun notifyLockerAndFinish() {
        VKValidationLocker.signal()
        finish()
    }

    private fun handleSuccess(uri: Uri) {
        validationResult = if (uri.getQueryParameter("access_token") != null) {
            val token = uri.getQueryParameter("access_token")
            val secret = uri.getQueryParameter("secret")
            val userId = uri.getQueryParameter("user_id")?.toInt()
            VKApiValidationHandler.Credentials(secret, token, userId)
        } else {
            VKApiValidationHandler.Credentials.EMPTY
        }
        notifyLockerAndFinish()
    }

    companion object {
        const val VK_EXTRA_AUTH_PARAMS = "vk_auth_params"
        const val VK_RESULT_INTENT_NAME = "com.vk.auth-token"
        private const val LOG_TAG = "VKWebViewAuthActivity"

        private const val VK_EXTRA_VALIDATION_URL = "vk_validation_url"

        var validationResult: VKApiValidationHandler.Credentials? = null

        internal fun createAuthIntent(
            ctx: Context,
            params: VKAuthParams
        ) = Intent(ctx, VKWebViewAuthActivity::class.java)
            .putExtra(VK_EXTRA_AUTH_PARAMS, params.toBundle())

        fun startForAuth(activity: Activity, params: VKAuthParams, code: Int) {
            val intent = createAuthIntent(activity, params)
            activity.startActivityForResult(intent, code)
        }

        fun startForValidation(context: Context, validationUrl: String) {
            val intent = Intent(context, VKWebViewAuthActivity::class.java)
                .putExtra(VK_EXTRA_VALIDATION_URL, validationUrl)
            if (context.toActivitySafe() == null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }
    }
}