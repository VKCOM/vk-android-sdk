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

import android.net.Uri

interface HttpMultipartEntry {

    class File : HttpMultipartEntry {
        var fileUri: Uri
        var fileName: String? = null

        constructor(fileUri: Uri) {
            this.fileUri = fileUri
            this.fileName = fileUri.lastPathSegment
        }

        constructor(fileUri: Uri, fileName: String) {
            this.fileUri = fileUri
            this.fileName = fileName
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is HttpMultipartEntry.File) return false
            val that = other as HttpMultipartEntry.File?
            return fileUri == that!!.fileUri
        }

        override fun hashCode(): Int {
            return fileUri.hashCode()
        }

        override fun toString(): String {
            return "File{fileUri='$fileUri'}"
        }
    }

    class Text(var textValue: String) : HttpMultipartEntry {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is HttpMultipartEntry.Text) return false
            val that = other as HttpMultipartEntry.Text?
            return textValue == that!!.textValue
        }

        override fun hashCode(): Int {
            return textValue.hashCode()
        }

        override fun toString(): String {
            return "Text{" +
                    "textValue='" + textValue + '\''.toString() +
                    '}'.toString()
        }

    }
}