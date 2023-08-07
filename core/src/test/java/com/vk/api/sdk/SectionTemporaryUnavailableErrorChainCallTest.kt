package com.vk.api.sdk

import android.content.Context
import com.nhaarman.mockito_kotlin.mock
import com.vk.api.sdk.chain.ChainArgs
import com.vk.api.sdk.chain.ChainCall
import com.vk.api.sdk.chain.SectionTemporaryUnavailableChainCall
import com.vk.api.sdk.exceptions.VKApiCodes
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.api.sdk.utils.TokenExponentialBackoff
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.TimeUnit

class SectionTemporaryUnavailableErrorChainCallTest {
    private lateinit var chainCall: SectionTemporaryUnavailableChainCall<Unit>
    private var realApiCallCounter = 0
    private var backoffedCallsCounter = 0
    private var shouldThrowSectionTemporaryUnavailable = false
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
                if (shouldThrowSectionTemporaryUnavailable) {
                    throw VKApiExecutionException(
                        code = VKApiCodes.CODE_SECTION_TEMPORARY_UNAVAILABLE,
                        apiMethod = METHOD_NAME,
                        hasLocalizedMessage = false,
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
        chainCall = SectionTemporaryUnavailableChainCall(
            manager, METHOD_NAME, backOff, internalChainCall
        )
    }

    @Test
    fun callWithoutSectionTemporaryUnavailableError() {
        makeCallBackoffAware()
        val message = "Calls without section temporary unavailable error shouldn't trigger backoff"
        Assert.assertTrue(message, backoffedCallsCounter == 0 && realApiCallCounter == 1)
    }

    @Test
    fun callAfterSectionTemporaryUnavailableErrorLessThanBackoffTime() {
        shouldThrowSectionTemporaryUnavailable = true
        makeCallBackoffAware()

        shouldThrowSectionTemporaryUnavailable = false
        realTime += backoffTime / 2
        makeCallBackoffAware()

        val message =
            "Calls with section temporary unavailable error should trigger VKApiExecutionException shortly after it without making calls"
        Assert.assertTrue(message, backoffedCallsCounter == 2 && realApiCallCounter == 1)
    }

    @Test
    fun callAfterSectionTemporaryUnavailableErrorMoreThanBackoffTime() {
        shouldThrowSectionTemporaryUnavailable = true
        realTime = 1000L
        makeCallBackoffAware()

        shouldThrowSectionTemporaryUnavailable = false
        realTime += backoffTime * 2
        makeCallBackoffAware()

        val message =
            "Calls after section temporary unavailable error and after backoff min time can make calls"
        Assert.assertTrue(message, backoffedCallsCounter == 1 && realApiCallCounter == 2)
    }

    private fun makeCallBackoffAware() {
        try {
            chainCall.call(ChainArgs())
        } catch (ex: VKApiExecutionException) {
            backoffedCallsCounter++
        }
    }

    private companion object {
        const val METHOD_NAME = "method_name"
    }
}