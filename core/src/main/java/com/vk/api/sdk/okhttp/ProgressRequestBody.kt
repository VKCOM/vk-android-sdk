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
 */
package com.vk.api.sdk.okhttp

import com.vk.api.sdk.VKApiProgressListener

import java.io.IOException
import java.util.concurrent.TimeUnit

import okhttp3.MediaType
import okhttp3.RequestBody
import okio.*

class ProgressRequestBody(private val requestBody: RequestBody,
                          private val progressListener: VKApiProgressListener?) : RequestBody() {

    private var lastNotifyTime: Long = 0

    override fun contentType(): MediaType? {
        return requestBody.contentType()
    }

    @Throws(IOException::class)
    override fun contentLength(): Long {
        return requestBody.contentLength()
    }

    @Throws(IOException::class)
    override fun writeTo(sink: BufferedSink) {
        val bufferedSink = CountingSink(sink).buffer()
        requestBody.writeTo(bufferedSink)
        bufferedSink.flush()
    }

    private inner class CountingSink(delegate: Sink) : ForwardingSink(delegate) {

        private var bytesWritten: Long = 0
        private var contentLength: Long = -1

        @Throws(IOException::class)
        override fun write(source: Buffer, byteCount: Long) {
            super.write(source, byteCount)
            bytesWritten += byteCount

            if (contentLength < 0) {
                contentLength = contentLength()
            }
            if (contentLength < 0) {
                notifyProgressSend(0, 1)
            } else {
                notifyProgressSend(bytesWritten, contentLength)
            }
        }

    }

    private fun notifyProgressSend(progress: Long, maxValue: Long) {
        if (progressListener == null) {
            return
        }
        val now = System.currentTimeMillis()
        val diff = now - lastNotifyTime
        if (diff >= NOTIFY_INTERVAL) {
            val scale = 1000f / maxValue
            val progressValue = (progress * scale).toInt()
            val progressMaxValue = (maxValue * scale).toInt()
            progressListener.onProgress(progressValue, progressMaxValue)
            lastNotifyTime = System.currentTimeMillis()
        }
    }

    companion object {
        private val NOTIFY_INTERVAL = TimeUnit.MILLISECONDS.toMillis(160)
    }

}