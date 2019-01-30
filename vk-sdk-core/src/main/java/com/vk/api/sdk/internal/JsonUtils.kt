package com.vk.api.sdk.internal

import android.util.JsonReader
import android.util.JsonToken
import java.io.Reader
import java.io.StringReader

object JsonUtils {

    fun containsElement(jsonString: String, name: String): Boolean {
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