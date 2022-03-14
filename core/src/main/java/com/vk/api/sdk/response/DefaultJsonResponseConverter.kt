package com.vk.api.sdk.response

import com.vk.api.sdk.extensions.readString
import org.json.JSONObject
import org.json.JSONTokener
import java.io.InputStream

/**
 * Default json format deserializer
 */
internal class DefaultJsonResponseConverter : JsonResponseTypeConverter {

    override fun isSuitableForContentType(contentType: String): Boolean =
        contentType.contains("application/json", ignoreCase = true) ||
            contentType.contains("text/javascript", ignoreCase = true)

    override fun convertResponseBody(responseBodyStream: InputStream): JSONObject {
        val tokener = JSONTokener(responseBodyStream.readString())
        return when (val next = tokener.nextValue()) {
            is JSONObject -> next
            else -> JSONObject().apply {
                put(ResponseBodyJsonConverter.FALLBACK_RESPONSE_KEY, next)
            }
        }
    }
}