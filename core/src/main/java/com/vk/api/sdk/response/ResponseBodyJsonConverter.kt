package com.vk.api.sdk.response

import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.extensions.readString
import com.vk.api.sdk.requests.VKRequest.Companion.ERROR_MALFORMED_RESPONSE
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

/**
 * Main response body to [JSONObject] converter, using [JsonResponseTypeConverter]
 *
 * if nothing matches we use the default [JSONObject] from string mapping
 */
class ResponseBodyJsonConverter(
    private val responseTypeConverters: List<JsonResponseTypeConverter>
) {

    /**
     * converts the response [InputStream] with the responseContentType into the [JSONObject]
     *
     * @param responseBodyStream - [InputStream] from the response
     * @param responseContentType - contentType of the response
     * @param method - api method if applicable
     */
    fun convertResponse(
        responseBodyStream: InputStream?,
        responseContentType: String?,
        path: String? = null
    ): JSONObject? {
        if (responseBodyStream == null) {
            return null
        }
        try {
            val jsonResponse = responseContentType?.let { contentType ->
                responseTypeConverters.firstOrNull {
                    it.isSuitableForContentType(contentType)
                }?.convertResponseBody(responseBodyStream)
            }
            
            return jsonResponse ?: JSONObject().apply {
                put(FALLBACK_RESPONSE_KEY, responseBodyStream.readString())
            }
        } catch (ex: JSONException) {
            throw VKApiExecutionException(ERROR_MALFORMED_RESPONSE, path ?: "no_path", true,
                    "[$path] ${ex.localizedMessage}")
        }
    }

    companion object {
        const val FALLBACK_RESPONSE_KEY = "root_response"
    }
}