package com.vk.api.sdk.utils

import android.graphics.Point
import android.os.Build
import okio.Buffer
import java.util.*

data class DefaultUserAgent(
    val prefix: String,
    val appVersion: String,
    val appBuild: String,
    val displaySize: Point
) : UserAgentProvider {
    private val stringify: String by lazy {
        VKUtils.toHumanReadableAscii(
            String.format(Locale.US, "%s/%s-%s (Android %s; SDK %d; %s; %s %s; %s; %dx%d)",
                prefix, appVersion, appBuild, Build.VERSION.RELEASE, Build.VERSION.SDK_INT,
                Build.CPU_ABI, Build.MANUFACTURER, Build.MODEL, System.getProperty("user.language"),
                Math.max(displaySize.x, displaySize.y), Math.min(displaySize.x, displaySize.y)
            )
        )
    }

    override fun getUserAgent(): String = stringify
}