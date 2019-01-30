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

package com.vk.api.sdk.utils

import android.util.MalformedJsonException
import com.vk.api.sdk.internal.VKErrorUtils
import java.io.IOException
import java.io.InterruptedIOException
import java.net.SocketTimeoutException

internal inline fun <T, N : Number> T.applyPos(value: N, block: T.(N) -> Unit): T {
    return if (value.toDouble() > 0) {
        block.invoke(this, value)
        this
    }
    else throw IllegalArgumentException("Value is negative $value!")
}

fun IOException?.isInterruptedByThreadInterrupt(): Boolean {
    if (this == null) return false
    return this is InterruptedIOException && this !is SocketTimeoutException
}

fun IOException?.isMalformedJson(): Boolean {
    if (this == null) return false
    return this is MalformedJsonException
}

internal fun String.hasExecuteError(ignoredErrors: IntArray?) = VKErrorUtils.hasExecuteError(this, ignoredErrors)
internal fun String.hasSimpleError() = VKErrorUtils.hasSimpleError(this)
internal fun String.toSimpleError(method: String? = null) = VKErrorUtils.parseSimpleError(this, method)
internal fun String.toExecuteError(method: String, ignoredErrors: IntArray?) = VKErrorUtils.parseExecuteError(this, method, ignoredErrors)

operator fun <E> android.support.v4.util.LongSparseArray<E>.set(key: Long, value: E) = put(key, value)
