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

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.net.Uri
import android.provider.MediaStore

import com.vk.api.sdk.exceptions.VKLocalIOException

import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.net.URLConnection

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okio.BufferedSink

internal class FileFullRequestBody(
        private val context: Context,
        private val uri: Uri
) : RequestBody() {

    private val scheme: String
    private val lastPathSegment: String

    init {
        if (uri.scheme.isNullOrBlank() || uri.lastPathSegment.isNullOrBlank()) {
            throw IllegalArgumentException("Illegal fileUri value: '$uri'")
        }
        scheme = uri.scheme!!
        lastPathSegment = uri.lastPathSegment!!
    }

    override fun contentType(): MediaType? {
        var mimeType: String? = null

        try {
            mimeType = URLConnection.guessContentTypeFromName(lastPathSegment)
        } catch (ignored: Exception) {
            // Ignore
        }

        if (mimeType == null) {
            try {
                val projection = arrayOf(MediaStore.Images.ImageColumns.MIME_TYPE)
                val cursor = context.contentResolver.query(uri, projection, null, null, null)
                cursor?.use {
                    mimeType = if (it.isNull(0)) null else it.getString(0)
                }
            } catch (ignored: Throwable) {
                // Ignore
            }
        }

        return mimeType?.toMediaTypeOrNull() ?: "application/octet-stream".toMediaType()
    }

    @Throws(IOException::class)
    override fun contentLength(): Long {
        var fd: AssetFileDescriptor? = null
        try {
            fd = context.contentResolver.openAssetFileDescriptor(uri, "r")
            return fd?.length ?: throw FileNotFoundException("Cannot open uri: $uri")
        } catch (ex: FileNotFoundException) {
            throw VKLocalIOException(ex)
        } finally {
            try {
                fd?.close()
            } catch (ignored: Exception) {
                // Ignore
            }
        }
    }

    @Throws(IOException::class)
    override fun writeTo(sink: BufferedSink) {
        var fileDescriptor: AssetFileDescriptor? = null
        val os = sink.outputStream()
        try {
            val inputStream: FileInputStream // auto-closable
            try {
                fileDescriptor = context.contentResolver.openAssetFileDescriptor(uri, "r")
                if (fileDescriptor == null) {
                    throw FileNotFoundException("Cannot open uri: $uri")
                }
                inputStream = fileDescriptor.createInputStream()
            } catch (ex: IOException) {
                throw VKLocalIOException(ex)
            }

            val buffer = ByteArray(CHUNK)
            var readCount: Int
            while (inputStream.available() > 0) {
                try {
                    readCount = inputStream.read(buffer)
                } catch (ex: IOException) {
                    throw VKLocalIOException(ex)
                }

                if (readCount == -1) {
                    break
                }
                os.write(buffer, 0, readCount)
                os.flush()
            }
        } finally {
            try {
                fileDescriptor?.close()
            } catch (ignored: Exception) {
                // Ignore
            }
        }
    }

    companion object {
        private const val CHUNK = 1024 * 8
    }

}