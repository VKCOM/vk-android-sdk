package com.vk.api.sdk.response

import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

/**
 * json response body type converter
 *
 * Responsible for converting the response body with the specific Content-Type value into [JSONObject]
 */
interface JsonResponseTypeConverter {

    /**
     * @param contentType - Content-Type header value
     *
     * @return true if we can convert responseBodyStream into [JSONObject]
     */
    fun isSuitableForContentType(contentType: String): Boolean

    /**
     * read and transform responseBodyStream
     *
     * @param responseBodyStream - [InputStream] from the response
     *
     * @return [JSONObject]
     */
    @Throws(JSONException::class)
    fun convertResponseBody(responseBodyStream: InputStream): JSONObject
}