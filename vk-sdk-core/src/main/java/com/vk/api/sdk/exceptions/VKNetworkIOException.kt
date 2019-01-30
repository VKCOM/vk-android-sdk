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

package com.vk.api.sdk.exceptions

import java.io.IOException
import java.io.InterruptedIOException
import java.net.SocketException
import java.net.UnknownHostException

open class VKNetworkIOException
    @JvmOverloads
    constructor(detailMessage: String = "",
                throwable: Throwable? = null) : IOException(detailMessage, throwable) {

    constructor(throwable: Throwable?) : this("", throwable)

    companion object {
        internal const val serialVersionUID = -2758493010294573829L
    }

    /**
     * Signals that request failed because there were some network problems
     * like network was totally unavailable or socket disconnected or degraded.
     */
    private fun isNetworkUnavailableCause() = cause is UnknownHostException || cause is SocketException

    /**
     * Signals that an I/O operation has been interrupted.
     */
    private fun isRequestInterruptedCause() = cause is InterruptedIOException || cause is InterruptedException

    override fun toString(): String {
        return "NetworkIO(noNetwork=${isNetworkUnavailableCause().toInt()}," +
                "interrupted=${isRequestInterruptedCause().toInt()},${cause?.toString()})"
    }

    private fun Boolean.toInt() = if (this) 1 else 0
}