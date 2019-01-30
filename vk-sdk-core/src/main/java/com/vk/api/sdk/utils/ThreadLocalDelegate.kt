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

import kotlin.reflect.KProperty

/**
 * Provides operator function for declaring ThreadLocal var throght kotlin delegate syntax.
 */
internal interface ThreadLocalDelegate<T> {
    fun get(): T
}

internal fun <T> threadLocal(factory: () -> T): ThreadLocalDelegate<T> {
    return ThreadLocalDelegateImpl(factory)
}

internal class ThreadLocalDelegateImpl<T>(val factory: () -> T) : ThreadLocalDelegate<T> {
    private val value: ThreadLocal<T> = object : ThreadLocal<T>() {
        override fun initialValue(): T {
            return factory.invoke()
        }
    }

    override fun get(): T {
        return value.get()
    }
}

internal operator fun <T> ThreadLocalDelegate<T>.getValue(any: Any?, property: KProperty<*>): T = this.get()
