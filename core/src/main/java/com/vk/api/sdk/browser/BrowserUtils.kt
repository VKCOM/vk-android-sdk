package com.vk.api.sdk.browser

object BrowserUtils {
    private val browserList = lazy {
        mapOf(
            "Chrome Mobile" to "com.android.chrome",
            "Yandex Browser" to "com.yandex.browser",
            "Firefox Mobile" to "org.mozilla.firefox",
            "Opera Mobile" to "com.opera.browser"
        )
    }

    fun getBrowserPackageByFamilyName(browserName: String?) = browserList.value[browserName]
}