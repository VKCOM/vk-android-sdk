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

import android.util.SparseArray

object HttpStatus {
    private val sMap = SparseArray<String>().apply {
        put(100, "Continue")
        put(101, "Switching Protocols")
        put(102, "Processing")
        put(103, "Checkpoint")

        put(200, "OK")
        put(201, "Created")
        put(202, "Accepted")
        put(203, "Non-Authoritative Information")
        put(204, "No Content")
        put(205, "Reset Content")
        put(206, "Partial Content")
        put(207, "Multi-Status")
        put(208, "Already Reported")
        put(226, "IM Used")

        put(300, "Multiple Choices")
        put(301, "Moved Permanently")
        put(302, "Found")
        put(303, "See Other")
        put(304, "Not Modified")
        put(305, "Use Proxy")
        put(307, "Temporary Redirect")
        put(308, "Permanent Redirect")

        put(400, "Bad Request")
        put(401, "Unauthorized")
        put(402, "Payment Required")
        put(403, "Forbidden")
        put(404, "Not Found")
        put(405, "Method Not Allowed")
        put(406, "Not Acceptable")
        put(407, "Proxy Authentication Required")
        put(408, "Request Timeout")
        put(409, "Conflict")
        put(410, "Gone")
        put(411, "Length Required")
        put(412, "Precondition Failed")
        put(413, "Payload Too Large")
        put(414, "URI Too Long")
        put(415, "Unsupported Media Type")
        put(416, "Requested range not satisfiable")
        put(417, "Expectation Failed")
        put(418, "I'm a teapot")
        put(419, "Insufficient Space On Resource")
        put(420, "Method Failure")
        put(421, "Destination Locked")
        put(422, "Unprocessable Entity")
        put(423, "Locked")
        put(424, "Failed Dependency")
        put(426, "Upgrade Required")
        put(428, "Precondition Required")
        put(429, "Too Many Requests")
        put(431, "Request Header Fields Too Large")

        put(500, "Internal Server Error")
        put(501, "Not Implemented")
        put(502, "Bad Gateway")
        put(503, "Service Unavailable")
        put(504, "Gateway Timeout")
        put(505, "HTTP Version not supported")
        put(506, "Variant Also Negotiates")
        put(507, "Insufficient Storage")
        put(508, "Loop Detected")
        put(509, "Bandwidth Limit Exceeded")
        put(510, "Not Extended")
        put(511, "Network Authentication Required")
    }

    fun getDescription(status: Int): String = sMap.get(status)
}