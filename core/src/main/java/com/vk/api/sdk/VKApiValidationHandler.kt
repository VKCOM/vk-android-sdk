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

import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.dto.common.id.UserId
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicReference

/**
 * Handler for api errors
 */
interface VKApiValidationHandler {
    /**
     * This method will be called, when user should enter captcha text
     */
    fun handleCaptcha(captcha: Captcha, cb: Callback<String>)
    /**
     * This method will be called, when auth validation required
     */
    fun handleValidation(validationUrl: String, cb: Callback<Credentials>)
    /**
     * This method will be called, when confirmation from user required
     */
    fun handleConfirm(confirmationText: String, cb: Callback<Boolean>)
    /**
     * This method will be called, when no other method can handle exception
     */
    @Throws(VKApiExecutionException::class)
    fun tryToHandleException(ex: VKApiExecutionException, apiManager: VKApiManager): Unit = throw ex
    /**
     * This method will be called, when user solved captcha
     */
    fun handleCaptchaSolved() = Unit

    open class Callback<T>(val lock: ValidationLock) {
        @Volatile var value: T? = null

        open fun cancel() = lock.release()
        open fun submit(value: T) {
            this.value = value
            lock.release()
        }
    }

    class Credentials(val secret: String?, val token: String?, val uid: UserId?, val expiresInSec: Int, val createdMs: Long) {
        val isValid = !token.isNullOrBlank()

        companion object {
            val EMPTY = Credentials("", "", null, 0, 0)
        }
    }

    class ValidationLock {

        private val latchRef = AtomicReference<CountDownLatch?>()

        fun await() {
            latchRef.get()?.await()
        }

        fun acquire(): Boolean =
            latchRef.compareAndSet(null, CountDownLatch(1))

        fun release() {
            latchRef.getAndSet(null)?.countDown() ?: throw NullPointerException("Latch is null!")
        }
    }

    data class Captcha(
        val img: String,
        val height: Int?,
        val width: Int?,
        val ratio: Double?,
        val isRefreshEnabled: Boolean
    )
}