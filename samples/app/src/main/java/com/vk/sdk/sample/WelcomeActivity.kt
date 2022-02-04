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

package com.vk.sdk.sample

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.exceptions.VKAuthException
import com.vk.api.sdk.auth.VKScope

class WelcomeActivity: AppCompatActivity() {

    private lateinit var authLauncher: ActivityResultLauncher<Collection<VKScope>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (VK.isLoggedIn()) {
            UserActivity.startFrom(this)
            finish()
            return
        }
        setContentView(R.layout.activity_welcome)

        authLauncher = VK.login(this) { result : VKAuthenticationResult ->
            when (result) {
                is VKAuthenticationResult.Success -> onLogin()
                is VKAuthenticationResult.Failed -> onLoginFailed(result.exception)
            }
        }

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            authLauncher.launch(arrayListOf(VKScope.WALL, VKScope.PHOTOS))
        }
    }

    private fun onLogin() {
        UserActivity.startFrom(this@WelcomeActivity)
        finish()
    }

    private fun onLoginFailed(exception: VKAuthException) {
        if (!exception.isCanceled) {
            val descriptionResource =
                if (exception.webViewError == WebViewClient.ERROR_HOST_LOOKUP) R.string.message_connection_error
                else R.string.message_unknown_error
            AlertDialog.Builder(this@WelcomeActivity)
                .setMessage(descriptionResource)
                .setPositiveButton(R.string.vk_retry) { _, _ ->
                    authLauncher.launch(arrayListOf(VKScope.WALL, VKScope.PHOTOS))
                }
                .setNegativeButton(android.R.string.cancel) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }
    }
}