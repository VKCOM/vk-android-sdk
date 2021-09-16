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
            val urlToLoad = if (needValidationResult()) intent.getStringExtra(VK_EXTRA_VALIDATION_URL)
                    else {
                val uri = Uri.parse("https://oauth.vk.com/authorize").buildUpon()
                val params = getUrlParams()
                for ((key, value) in params) {
                    uri.appendQueryParameter(key, value)
                }
                uri.build().toString()
            }

            webView.loadUrl(urlToLoad)
        } catch (e: Exception) {
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
                if (!url.startsWith(redirectUrl)) {
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
        override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
            super.onReceivedError(view, request, error)
            val errorCode =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) error?.errorCode ?: ERROR_UNKNOWN
                else ERROR_UNKNOWN
            onError(errorCode)
        }

        @Suppress("DEPRECATION")
        override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
            super.onReceivedError(view, errorCode, description, failingUrl)
            onError(errorCode)
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

        private const val VK_EXTRA_VALIDATION_URL = "vk_validation_url"

        var validationResult: VKApiValidationHandler.Credentials? = null

        fun startForAuth(activity: Activity, params: VKAuthParams, launcher: Any?, code: Int) {
            val intent = Intent(activity, VKWebViewAuthActivity::class.java)
                .putExtra(VK_EXTRA_AUTH_PARAMS, params.toBundle())
            if (launcher == null) {
                activity.startActivityForResult(intent, code)
            } else {
                Class.forName("androidx.activity.result.ActivityResultLauncher")
                    .getDeclaredMethod("launch", Any::class.java)
                    .invoke(launcher, intent)
            }
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