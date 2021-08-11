package com.vk.api.sdk.extensions

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

internal fun Context.toActivitySafe(): Activity? {
    var context = this
    while (context !is Activity && context is ContextWrapper) context = context.baseContext
    return if (context is Activity) context else null
}