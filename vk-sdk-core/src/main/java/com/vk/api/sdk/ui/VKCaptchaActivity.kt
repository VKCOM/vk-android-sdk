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
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.*
import com.vk.api.sdk.R
import com.vk.api.sdk.VKScheduler
import com.vk.api.sdk.utils.VKLoader
import com.vk.api.sdk.utils.VKUtils
import com.vk.api.sdk.utils.VKValidationLocker

/**
 * Default screen for showing captcha to user
 */
class VKCaptchaActivity: Activity() {

    private lateinit var input: EditText
    private lateinit var image: ImageView
    private lateinit var progress: ProgressBar

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        overridePendingTransition(0, 0)

        setContentView(FrameLayout(this))

        val layout = LinearLayout(this)
        val padding = VKUtils.dp(12)
        val imageWidth = (130f * Math.max(1f, VKUtils.density())).toInt()
        val imageHeight = (50f * Math.max(1f, VKUtils.density())).toInt()
        layout.setPadding(padding, padding, padding, padding)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER_HORIZONTAL

        val imgFrame = FrameLayout(this)
        val flParams = LinearLayout.LayoutParams(imageWidth, imageHeight)
        flParams.bottomMargin = padding
        imgFrame.layoutParams = flParams

        progress = ProgressBar(this)
        val pbParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        pbParams.gravity = Gravity.CENTER
        progress.layoutParams = pbParams
        imgFrame.addView(progress)

        image = ImageView(this)
        val ivParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        ivParams.gravity = Gravity.CENTER
        image.layoutParams = ivParams
        imgFrame.addView(image)

        layout.addView(imgFrame)

        input = EditText(this)
        input.inputType = InputType.TYPE_TEXT_VARIATION_FILTER
        input.setSingleLine(true)
        val inParams = LinearLayout.LayoutParams(imageWidth, LinearLayout.LayoutParams.WRAP_CONTENT)
        input.layoutParams = inParams
        layout.addView(input)

        AlertDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setView(layout)
                .setTitle(R.string.vk_captcha_hint)
                .setPositiveButton(android.R.string.ok) {_,_ ->
                    captchaDone()
                }
                .setNegativeButton(android.R.string.cancel) {_,_ ->
                    captchaCancelled()
                }
                .setOnCancelListener {
                    captchaCancelled()
                }
                .show()

        input.requestFocus()
        loadImage()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0, 0)
    }

    private fun loadImage() {
        val url = intent.getStringExtra(KEY_URL)

        VKScheduler.networkExecutor.submit {
            val data = VKLoader.load(url)
            data?.let {
                displayImage(BitmapFactory.decodeByteArray(data, 0, data.size))
            }
        }
    }

    private fun displayImage(bitmap: Bitmap) {
        VKScheduler.runOnMainThread(Runnable {
            image.setImageBitmap(bitmap)
            progress.visibility = View.GONE
        })
    }

    private fun captchaDone() {
        lastKey = input.text.toString()
        VKValidationLocker.signal()
        finish()
    }

    private fun captchaCancelled() {
        lastKey = null
        VKValidationLocker.signal()
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    override fun onDestroy() {
        VKValidationLocker.signal()
        super.onDestroy()
    }

    companion object {
        var lastKey: String? = null

        private const val KEY_URL = "key_url"

        fun start(context: Context, img: String) {
            VKScheduler.runOnMainThread(Runnable {
                val intent = Intent(context, VKCaptchaActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .putExtra(KEY_URL, img)
                context.startActivity(intent)
            })
        }
    }
}