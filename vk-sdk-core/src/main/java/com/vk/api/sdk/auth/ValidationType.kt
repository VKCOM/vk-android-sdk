package com.vk.api.sdk.auth

enum class ValidationType(val jsonValue: String) {
    SMS("2fa_sms"),
    APP("2fa_app"),
    LIBVERIFY("2fa_libverify"),
    CALL_RESET("2fa_callreset"),
    PHONE("phone"),
    URL("");

    companion object {
        fun parse(jsonValue: String): ValidationType {
            return ValidationType.values().find { it.jsonValue == jsonValue } ?: URL
        }
    }
}