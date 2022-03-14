package com.vk.api.sdk.extensions

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.widget.Toast

internal fun Context.toActivitySafe(): Activity? {
    var context = this
    while (context !is Activity && context is ContextWrapper) context = context.baseContext
    return if (context is Activity) context else null
}

internal fun Context.showToast(resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
}