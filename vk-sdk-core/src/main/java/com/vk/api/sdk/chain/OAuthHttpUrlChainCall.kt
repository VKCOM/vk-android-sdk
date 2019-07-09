package com.vk.api.sdk.chain

import android.os.Bundle
import android.os.SystemClock
import com.vk.api.sdk.OauthHttpUrlPostCall
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.VKApiResponseParser
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiException
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.okhttp.OkHttpExecutor
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.math.max
import kotlin.math.min

/**
 * Used to implement an http request for authorization via oauth.
 * The implementation is identical to the implementation of [HttpPostChainCall] with the exception of error handling, since
 * The error format of the oauth request is different from the error format of the normal VK API request
 * @see [OauthHttpUrlPostCall]
 */
class OAuthHttpUrlChainCall<T>(manager: VKApiManager,
                               private val okHttpExecutor: OkHttpExecutor,
                               private val call: OauthHttpUrlPostCall,
                               private val parser: VKApiResponseParser<T>?)
    : ChainCall<T>(manager) {

    @Throws(Exception::class)
    override fun call(args: ChainArgs): T? {
        return call(args, System.currentTimeMillis())
    }

    @Throws(Exception::class)
    private fun call(args: ChainArgs, firstRequestTime: Long): T? {
        val currentTime = System.currentTimeMillis()
        if (firstRequestTime + getTimeout() < currentTime) {
            throw IOException()
        }

        val response = okHttpExecutor.execute(call, args)
        return when (response) {
            null -> throw VKApiException("Response returned null instead of valid string response")
            else -> {
                val jo = JSONObject(response)
                val error = jo.optString("error", null)
                val processing = jo.has("processing")
                when {
                    error == "need_captcha" -> {
                        // Hack conversion to VKApiExecutionException, because ApiManager is able to handle a captcha properly
                        val extras = Bundle().apply {
                            putString(VKApiCodes.EXTRA_CAPTCHA_SID, jo.getString(VKApiCodes.EXTRA_CAPTCHA_SID))
                            putString(VKApiCodes.EXTRA_CAPTCHA_IMG, jo.getString(VKApiCodes.EXTRA_CAPTCHA_IMG))
                        }
                        throw VKApiExecutionException(
                                code = VKApiCodes.CODE_CAPTCHA_REQUIRED,
                                apiMethod = call.url,
                                hasLocalizedMessage = false,
                                detailMessage = error,
                                extra = extras)
                    }
                    processing -> {
                        val timeout = jo.optLong("timeout", 200)
                        val realTimeout = max(200, min(timeout, getTimeout()))
                        SystemClock.sleep(realTimeout)
                        call(args, firstRequestTime)
                    }
                    else -> parser?.parse(response)
                }
            }
        }
    }

    private fun getTimeout(): Long {
        return if (call.timeoutMs > 0) {
            call.timeoutMs
        } else {
            DEFAULT_TIMEOUT
        }
    }

    companion object {
        private val DEFAULT_TIMEOUT = TimeUnit.SECONDS.toMillis(10)
    }
}