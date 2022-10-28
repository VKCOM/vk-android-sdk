package com.vk.api.sdk

import android.content.Context
import com.nhaarman.mockito_kotlin.mock
import com.vk.api.sdk.chain.ChainArgs
import com.vk.api.sdk.chain.ChainCall
import com.vk.api.sdk.chain.InternalErrorChainCall
import com.vk.api.sdk.exceptions.InternalServerErrorOccurredException
import com.vk.api.sdk.exceptions.VKInternalServerErrorException
import com.vk.api.sdk.utils.TokenExponentialBackoff
import java.util.concurrent.TimeUnit
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class InternalServerErrorChainCallTest {
    private lateinit var chainCall: InternalErrorChainCall<Unit>
    private var realApiCallCounter = 0
    private var backoffedCallsCounter = 0
    private var shouldThrowRateLimit = false
    private var realTime = 0L
    private val backoffTime = TimeUnit.HOURS.toMillis(1)

    private val context: Context = mock {}

    @Before
    fun setup() {
        val manager = VKApiManager(
            VKApiConfig(
                context = context,
                validationHandler = VKDefaultValidationHandler(context)
            )
        )
        val internalChainCall = object : ChainCall<Unit>(manager) {
            override fun call(args: ChainArgs): Unit? {
                realApiCallCounter++
                if (shouldThrowRateLimit) {
                    throw VKInternalServerErrorException(
                        httpStatus = 500,
                        detailMessage = ""
                    )
                }
                return null
            }
        }
        val backOff = TokenExponentialBackoff(
            store = TokenExponentialBackoff.TokenMemStore(),
            minBackoffTime = backoffTime
        ) { realTime }
        backOff.reset(METHOD_NAME)
        chainCall = InternalErrorChainCall(
            manager, METHOD_NAME, backOff, internalChainCall
        )
    }

    @Test
    fun callWithoutInternalError() {
        makeCallBackoffAware()
        val message = "Calls without internal server error shouldn't trigger backoff"
        Assert.assertTrue(message, backoffedCallsCounter == 0 && realApiCallCounter == 1)
    }

    @Test
    fun callAfterInternalErrorLessThanBackoffTime() {
        shouldThrowRateLimit = true
        makeCallBackoffAware()

        shouldThrowRateLimit = false
        realTime += backoffTime / 2
        makeCallBackoffAware()

        val message = "Calls after internal server error shortly after it should trigger InternalServerErrorOccurredException without making calls"
        Assert.assertTrue(message, backoffedCallsCounter == 1 && realApiCallCounter == 1)
    }

    @Test
    fun xcallAfterInternalErrorMoreThanBackoffTime() {
        shouldThrowRateLimit = true
        makeCallBackoffAware()

        shouldThrowRateLimit = false
        realTime += backoffTime * 2
        makeCallBackoffAware()

        val message = "Calls after internal server error and after backoff min time can make calls"
        Assert.assertTrue(message, backoffedCallsCounter == 0 && realApiCallCounter == 2)
    }

    private fun makeCallBackoffAware() {
        try {
            chainCall.call(ChainArgs())
        } catch (ex: Throwable) {
            if (ex is InternalServerErrorOccurredException) {
                backoffedCallsCounter++
            }
        }
    }

    private companion object {
        const val METHOD_NAME = "method_name"
    }
}