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

import android.content.Context
import com.vk.api.sdk.ui.VKCaptchaActivity
import com.vk.api.sdk.ui.VKConfirmationActivity
import com.vk.api.sdk.ui.VKWebViewAuthActivity
import com.vk.api.sdk.utils.VKValidationLocker

/**
 * Default implementation for VKApiValidationHandler
 * It uses internal sdk activities
 */
class VKDefaultValidationHandler(val context: Context): VKApiValidationHandler {

    override fun handleCaptcha(img: String, cb: VKApiValidationHandler.Callback<String>) {
        VKCaptchaActivity.start(context, img)

        VKValidationLocker.await()

        checkCaptchaActivity(cb)
    }

    private fun checkCaptchaActivity(cb: VKApiValidationHandler.Callback<String>) {
        if (VKCaptchaActivity.lastKey != null) {
            cb.submit(VKCaptchaActivity.lastKey!!)
        } else {
            cb.cancel()
        }
    }

    override fun handleConfirm(confirmationText: String, cb: VKApiValidationHandler.Callback<Boolean>) {
        VKConfirmationActivity.result = false
        VKConfirmationActivity.start(context, confirmationText)

        VKValidationLocker.await()

        cb.submit(VKConfirmationActivity.result)
        VKConfirmationActivity.result = false
    }

    override fun handleValidation(validationUrl: String, cb: VKApiValidationHandler.Callback<VKApiValidationHandler.Credentials>) {
        VKWebViewAuthActivity.validationResult = null
        VKWebViewAuthActivity.startForValidation(context, validationUrl)

        VKValidationLocker.await()

        VKWebViewAuthActivity.validationResult?.let {
            cb.submit(it)
        } ?: run {
            cb.cancel()
        }

        VKWebViewAuthActivity.validationResult = null
    }
}