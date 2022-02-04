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
package com.vk.api.sdk.internal

import android.util.JsonReader
import android.util.JsonToken
import android.util.MalformedJsonException
import java.io.Reader
import java.io.StringReader

object JsonUtils {

    fun containsElement(jsonString: String, name: String): Boolean {
        try {
            return containsElementImpl(jsonString, name)
        } catch (ex: MalformedJsonException) {
            throw MalformedJsonException("${ex.message}. Json: '$jsonString'")
        }
    }

    private fun containsElementImpl(jsonString: String, name: String): Boolean {
        if (jsonString.isEmpty()) {
            return false
        }
        val reader = JsonReader(StringReader(jsonString) as Reader) // Fix for bug in IntelliJ
        if (reader.hasNext() && reader.peek() == JsonToken.BEGIN_OBJECT) {
            reader.beginObject()
        } else {
            return false
        }
        while (reader.hasNext()) {
            val nextToken = reader.peek()
            if (nextToken == JsonToken.END_DOCUMENT) {
                break
            } else if (nextToken != JsonToken.NAME) {
                reader.skipValue()
            } else if (name == reader.nextName()) {
                return true
            }
        }
        return false
    }

}