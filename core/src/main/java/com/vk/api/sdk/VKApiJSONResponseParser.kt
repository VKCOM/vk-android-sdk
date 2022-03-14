package com.vk.api.sdk

import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import org.json.JSONException
import org.json.JSONObject

fun interface VKApiJSONResponseParser<Result> {

    @Throws(
        VKApiException::class,
        VKApiExecutionException::class,
        JSONException::class,
        Exception::class
    )
    fun parse(responseJson: JSONObject): Result
}