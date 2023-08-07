package com.vk.api.sdk.exceptions

import android.util.Log

enum class ApiErrorViewType {
    INPUT,
    FULLSCREEN,
    ALERT,
    CUSTOM,
    SKIP;

    companion object {
        private const val TAG = "VkApiErrorViewType"
        private val DEFAULT_VIEW_TYPE = CUSTOM

        fun fromString(errorType: String): ApiErrorViewType? {
            if (errorType.isBlank()) {
                Log.d(TAG, "Empty error view type")
                return null
            }

            return try {
                valueOf(errorType.uppercase())
            } catch (exception: IllegalArgumentException) {
                Log.e(TAG, "Unknown error view type: $errorType", exception)
                DEFAULT_VIEW_TYPE
            }
        }
    }
}
