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

package com.vk.api.sdk.chain

import com.vk.api.sdk.VKApiValidationHandler
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import java.util.concurrent.CountDownLatch

class ValidationHandlerChainCall<T>(manager: VKApiManager, retryLimit: Int, val chain: ChainCall<T>) : RetryChainCall<T>(manager, retryLimit) {
    @Throws(Exception::class)
    override fun call(args: ChainArgs): T? {
        for (i in 0..retryLimit) {
            try {
                return chain.call(args)
            } catch (ex: VKApiExecutionException) {
                when {
                    ex.isCaptchaError -> handleCaptcha(ex, args)
                    ex.isValidationRequired -> handleValidation(ex)
                    ex.isUserConfirmRequired -> handleUserConfirmation(ex, args)
                    else -> throw ex
                }
            }
        }
        throw VKApiException("Can't confirm validation due to retry limit!")
    }

    private fun handleUserConfirmation(ex: VKApiExecutionException, args: ChainArgs) {
        val confirmation = awaitValidation(ex.userConfirmText, VKApiValidationHandler::handleConfirm)
        when (confirmation) {
            null -> throw ex
            false -> throw ex
            else -> {
                args.userConfirmed = confirmation
            }
        }
    }

    private fun handleValidation(ex: VKApiExecutionException) {
        val credentials = awaitValidation(ex.validationUrl, VKApiValidationHandler::handleValidation)
        when {
            credentials?.isValid == true -> manager.setCredentials(credentials.token!!, credentials.secret!!)
            else -> throw ex
        }
    }

    private fun handleCaptcha(ex: VKApiExecutionException, args: ChainArgs) {
        val captcha = awaitValidation(ex.captchaImg, VKApiValidationHandler::handleCaptcha)
        when (captcha) {
            null -> throw ex
            else -> {
                args.captchaSid = ex.captchaSid
                args.captchaKey = captcha
            }
        }
    }

    private fun <T> awaitValidation(url: String,
                                    handlerMethod: VKApiValidationHandler.(String, VKApiValidationHandler.Callback<T>) -> Unit): T? {
        val handler = manager.validationHandler ?: return null
        val latch = CountDownLatch(1)
        val callback = VKApiValidationHandler.Callback<T>(latch)
        handler.handlerMethod(url, callback)
        latch.await()
        return callback.value
    }
}