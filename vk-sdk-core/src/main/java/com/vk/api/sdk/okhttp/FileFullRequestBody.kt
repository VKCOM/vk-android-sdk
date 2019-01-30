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

import com.vk.api.sdk.exceptions.VKLocalIOException

import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.net.URLConnection

import okhttp3.MediaType
import okhttp3.RequestBody
import okio.BufferedSink

internal class FileFullRequestBody(private val context: Context?, private val fileUri: Uri?) : RequestBody() {

    init {
        if (context == null) {
            throw IllegalArgumentException("context is null")
        }
        if (fileUri == null) {
            throw IllegalArgumentException("fileUri is null")
        }
        if (!File(fileUri.path).exists()) {
            throw IllegalArgumentException("file is not exist")
        }
    }

    override fun contentType(): MediaType? {
        val fileName = fileUri?.lastPathSegment

        var mimeType: String? =
        if (fileName == null) {
            null
        } else {
            try {
                URLConnection.guessContentTypeFromName(fileName)
            } catch (ex: Exception) {
                null
            }

        }
        if (mimeType == null) {
            mimeType = "application/octet-stream"
        }

        return MediaType.parse(mimeType)
    }

    @Throws(IOException::class)
    override fun contentLength(): Long {
        var fd: AssetFileDescriptor? = null
        try {
            fd = context?.contentResolver?.openAssetFileDescriptor(fileUri, "r")
            return fd?.length ?: throw FileNotFoundException("Cannot open uri: $fileUri")
        } catch (ex: FileNotFoundException) {
            throw VKLocalIOException(ex)
        } finally {
            if (fd != null) {
                try {
                    fd.close()
                } catch (ex: Exception) {
                    // Ignore
                }

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
                fileDescriptor = context?.contentResolver?.openAssetFileDescriptor(fileUri, "r")
                if (fileDescriptor == null) {
                    throw FileNotFoundException("Cannot open uri: $fileUri")
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
            if (fileDescriptor != null) {
                try {
                    fileDescriptor.close()
                } catch (ignore: Exception) {
                }

            }
        }
    }

    companion object {
        private const val CHUNK = 1024 * 8
    }

}