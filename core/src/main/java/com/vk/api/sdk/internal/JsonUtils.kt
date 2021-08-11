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