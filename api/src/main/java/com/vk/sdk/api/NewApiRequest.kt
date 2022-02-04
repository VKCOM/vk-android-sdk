/**
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
// *********************************************************************
// THIS FILE IS AUTO GENERATED!
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING.
// *********************************************************************
package com.vk.sdk.api

import com.google.gson.JsonParser
import com.vk.api.sdk.requests.VKRequest
import com.vk.dto.common.id.UserId
import java.lang.IllegalArgumentException
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

internal class NewApiRequest<T> internal constructor(
    methodName: String,
    parser: ApiResponseParser<T>
) : VKRequest<T>(methodName, requestApiVersion = "5.131"), ApiResponseParser<T> by parser {
    override fun parse(response: String): T {
        val responseJson = JsonParser.parseString(response).asJsonObject.get("response")
        return parseResponse(responseJson)
    }

    fun addParam(
        name: String,
        value: String?,
        minLength: Int = 0,
        maxLength: Int = Int.MAX_VALUE
    ) {
        if (value != null) {
            if (value.length !in minLength..maxLength) {
                throw IllegalArgumentException("Param $name not in $minLength..$maxLength")
            }
            params[name] = value
        }
    }

    fun addParam(
        name: String,
        value: Int,
        min: Int = Int.MIN_VALUE,
        max: Int = Int.MAX_VALUE
    ) {
        if (value !in min..max) {
            throw IllegalArgumentException("Param $name not in $min..$max")
        }
        params[name] = value.toString()
    }

    fun addParam(
        name: String,
        value: Long,
        min: Long = Long.MIN_VALUE,
        max: Long = Long.MAX_VALUE
    ) {
        if (value !in min..max) {
            throw IllegalArgumentException("Param $name not in $min..$max")
        }
        params[name] = value.toString()
    }

    fun addParam(
        name: String,
        value: Float,
        min: Double = Double.MIN_VALUE,
        max: Double = Double.MAX_VALUE
    ) {
        if (value !in min..max) {
            throw IllegalArgumentException("Param $name not in $min..$max")
        }
        params[name] = value.toString()
    }

    fun addParam(
        name: String,
        value: UserId?,
        min: Long = Long.MIN_VALUE,
        max: Long = Long.MAX_VALUE
    ) {
        if (value != null) {
            if (value.value !in min..max) {
                throw IllegalArgumentException("Param $name not in $min..$max")
            }
            params[name] = value.value.toString()
        }
    }

    fun addParam(
        name: String,
        values: List<UserId>,
        min: Long = Long.MIN_VALUE,
        max: Long = Long.MAX_VALUE
    ) {
        addParam(name, values.joinToString(",", transform =  {
            if (it.value !in min..max) {
                throw IllegalArgumentException("Param $name not in $min..$max")
            }
            it.value.toString()
        }
        ))
    }
}
