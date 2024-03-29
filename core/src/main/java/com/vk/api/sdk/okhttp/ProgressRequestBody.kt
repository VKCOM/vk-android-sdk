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
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.internal.http2.StreamResetException
import okio.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class ProgressRequestBody(
    private val requestBody: RequestBody,
    private val progressListener: VKApiProgressListener?
) : RequestBody() {

    private var lastNotifyTime: Long = 0
    private val hasDuplexBody by lazy {
        if (requestBody is MultipartBody) {
            requestBody.parts.any { it.body.isDuplex() }
        } else {
            requestBody.isDuplex()
        }
    }

    override fun contentType(): MediaType? {
        return requestBody.contentType()
    }

    @Throws(IOException::class)
    override fun contentLength(): Long {
        return requestBody.contentLength()
    }

    /**
     * Если мы отправляем body в режиму дуплекса, то можем поймать асинхронно флаг RST_STREAM,
     * по которому обязаны завершить отправку данных в этом стриме. При этом, перед этим флагом
     * сервер нам может отправить хедеры со статус кодом. И вот если мы выбросим [StreamResetException],
     * то посчитаем просто I/O ошибкой и попробуем повторить, даже не вычитав хедеры со статус кодом.
     * Если же мы пропустим эту ошибку здесь, она всё-равно всплывёт выше, при попытке вычитать body,
     * без проверки на успешность запроса, но при этом у нас уже будут вычитаны хедеры и мы сможем различить:
     * это I/O ошибка или нас вполне резонно отпнул сервер, например, с 413 ошибкой.
     */
    @Throws(IOException::class)
    override fun writeTo(sink: BufferedSink) {
        val bufferedSink = CountingSink(sink).buffer()
        try {
            requestBody.writeTo(bufferedSink)
            bufferedSink.flush()
            bufferedSink.close()
        } catch (e: StreamResetException) {
            if (!isDuplex()) throw e
        }
    }

    override fun isDuplex(): Boolean = hasDuplexBody

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