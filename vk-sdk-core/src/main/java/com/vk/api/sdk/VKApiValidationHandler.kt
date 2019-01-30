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

import java.util.concurrent.CountDownLatch

/**
 * Handler for api errors
 */
interface VKApiValidationHandler {
    /**
     * This method will called, when user should enter captcha text
     */
    fun handleCaptcha(img: String, cb: Callback<String>)
    /**
     * This method will called, when auth validation required
     */
    fun handleValidation(validationUrl: String, cb: Callback<Credentials>)
    /**
     * This method will called, when confirmation from user required
     */
    fun handleConfirm(confirmationText: String, cb: Callback<Boolean>)

    class Callback<T>(private val latch: CountDownLatch) {
        @Volatile var value: T? = null

        fun cancel() = latch.countDown()
        fun submit(value: T) {
            this.value = value
            latch.countDown()
        }
    }
    class Credentials(val secret: String?, val token: String?, val uid: Int?) {
        val isValid = !(token.isNullOrBlank() || secret.isNullOrEmpty())
    }
}