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

package com.vk.api.sdk.internal

import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.VkResult
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Base class for making vk api requests
 * Use sdk sample as an example
 * If you need more easy way, use VKRequest
 */
abstract class ApiCommand<Response> {

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    fun execute(manager: VKApiManager): Response {
        return onExecute(manager)
    }

    @Throws(InterruptedException::class, IOException::class, VKApiException::class)
    protected abstract fun onExecute(manager: VKApiManager): Response

    companion object {
        const val RETRY_INFINITE = Integer.MAX_VALUE
    }

}

/**
 * Suspend extension that allows suspend [ApiCommand] inside of a coroutine.
 *
 * @return Result of request or throw exception
 */
suspend fun <T : Any> ApiCommand<T>.await() = suspendCoroutine<T> { continuation ->
    try {
        val result = VK.executeSync(this)
        continuation.resume(result)
    } catch (e: VKApiExecutionException) {
        if (e.isInvalidCredentialsError) {
            VK.handleTokenExpired()
        }
        continuation.resumeWithException(e)
    }
}

/**
 * Suspend extension that allows suspend [ApiCommand] inside coroutine.
 *
 * @return sealed class [VkResult] object that can be
 * casted to [VkResult.Success] (success) or [VkResult.Failure] (error)
 */
suspend fun <T : Any> ApiCommand<T>.awaitResult() = suspendCoroutine<VkResult<T>> { continuation ->
    try {
        val result = VK.executeSync(this)
        continuation.resume(VkResult.Success(result))
    } catch (e: VKApiExecutionException) {
        if (e.isInvalidCredentialsError) {
            VK.handleTokenExpired()
        }
        continuation.resume(VkResult.Failure(e))
    }
}