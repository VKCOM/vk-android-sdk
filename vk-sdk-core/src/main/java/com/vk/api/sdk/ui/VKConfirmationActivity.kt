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

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import com.vk.api.sdk.R
import com.vk.api.sdk.VKScheduler
import com.vk.api.sdk.utils.VKValidationLocker

/**
 * Default screen for showing confirmation dialog to user
 */
class VKConfirmationActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        overridePendingTransition(0, 0)

        setContentView(FrameLayout(this))

        @Suppress("DEPRECATION")
        AlertDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setTitle(R.string.vk_confirm)
                .setMessage(intent.getStringExtra(KEY_MESSAGE))
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    result = true
                    finish()
                }
                .setNegativeButton(android.R.string.cancel) { _, _ ->
                    result = false
                    finish()
                }
                .setOnCancelListener {
                    result = false
                    finish()
                }
                .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        VKValidationLocker.signal()
    }

    override fun finish() {
        super.finish()
        VKValidationLocker.signal()
        overridePendingTransition(0, 0)
    }

    companion object {
        var result = false

        private const val KEY_MESSAGE = "key_message"

        fun start(context: Context, message: String) {
            VKScheduler.runOnMainThread(Runnable {
                val intent = Intent(context, VKConfirmationActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .putExtra(KEY_MESSAGE, message)
                context.startActivity(intent)
            })
        }
    }
}