package com.vk.api.sdk.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SecureInfoStripperTest(
    private val actualStrippedLog: String,
    private val expectedStrippedLog: String
) {
    private companion object {
        private val baseStripper = SecureInfoStripper.generateBaseStripper(listOf("access_token", "sign"))
        private const val difficultTokenValue = "vK_1.tOk-En2.t_EsT3"

        @Parameterized.Parameters
        @JvmStatic
        fun initParams(): Collection<Array<Any>> {
            val requestLogMsg = "request: uid=123&access_token=$difficultTokenValue&some_param=123&sign=$difficultTokenValue"
            val expectedRequestStrippedMsg = "request: uid=123&access_token=<HIDE>&some_param=123&sign=<HIDE>"

            val jsonLogMsg = "{uid:123,access_token:token,some_param:123,sign:$difficultTokenValue}"
            val expectedJsonStrippedMsg = "{uid:123,access_token:<HIDE>,some_param:123,sign:<HIDE>}"

            val jsonLogMsg2 = "{\"uid\":123,\"access_token\":\"$difficultTokenValue\",\"some_param\":123,\"sign\":\"$difficultTokenValue\"}"
            val expectedJsonStrippedMsg2 = "{\"uid\":123,\"access_token\":\"<HIDE>\",\"some_param\":123,\"sign\":\"<HIDE>\"}"

            // rule copied from LoggingInterceptor
            val kvLogMsg = "{\"key\":\"access_token\",\"value\":\"$difficultTokenValue\""
            val expectedKvStrippedMsg = "\"access_token:<HIDE>\"}"

            return arrayListOf(
                arrayOf(baseStripper.strip(requestLogMsg), expectedRequestStrippedMsg),
                arrayOf(baseStripper.strip(jsonLogMsg), expectedJsonStrippedMsg),
                arrayOf(baseStripper.strip(jsonLogMsg2), expectedJsonStrippedMsg2),
                arrayOf(baseStripper.strip(kvLogMsg), expectedKvStrippedMsg),
            )
        }
    }

    @Test
    fun stripTest() {
        assertEquals(expectedStrippedLog, actualStrippedLog)
    }
}