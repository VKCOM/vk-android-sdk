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
                handleException(ex, args)
            }
        }
        throw VKApiException("Can't confirm validation due to retry limit!")
    }

    @Throws(Exception::class)
    private fun handleException(ex: VKApiExecutionException, args: ChainArgs) {
        when {
            ex.isCaptchaError -> handleCaptcha(ex, args)
            ex.isValidationRequired -> handleValidation(ex)
            ex.isUserConfirmRequired -> handleUserConfirmation(ex, args)
            else -> manager.validationHandler?.tryToHandleException(ex, manager) ?: throw ex
        }
    }

    private fun handleUserConfirmation(ex: VKApiExecutionException, args: ChainArgs) {
        val confirmation = awaitValidation(ex.userConfirmText, manager.validationHandler, VKApiValidationHandler::handleConfirm)
        when (confirmation) {
            null -> throw ex
            false -> throw ex
            else -> {
                args.userConfirmed = confirmation
            }
        }
    }

    private fun handleValidation(ex: VKApiExecutionException) {
        val credentials = awaitValidation(ex.validationUrl, manager.validationHandler, VKApiValidationHandler::handleValidation)
        persistToken(credentials, ex)
    }

    protected fun persistToken(credentials: VKApiValidationHandler.Credentials?, ex: VKApiExecutionException) {
        when {
            credentials == VKApiValidationHandler.Credentials.EMPTY -> {
                //no need to update credentials use current
            }
            credentials?.isValid == true -> manager.setCredentials(credentials.token!!, credentials.secret)
            else -> throw ex
        }
    }

    private fun handleCaptcha(ex: VKApiExecutionException, args: ChainArgs) {
        val captcha = awaitValidation(ex.captchaImg, manager.validationHandler, VKApiValidationHandler::handleCaptcha)
        when (captcha) {
            null -> throw ex
            else -> {
                args.captchaSid = ex.captchaSid
                args.captchaKey = captcha
            }
        }
    }

    protected fun <T, H> awaitValidation(extra: String, handler: H?, handlerMethod: H.(String, VKApiValidationHandler.Callback<T>) -> Unit): T? {
        handler ?: return null
        val latch = CountDownLatch(1)
        val callback = VKApiValidationHandler.Callback<T>(latch)
        handler.handlerMethod(extra, callback)
        latch.await()
        return callback.value
    }
}