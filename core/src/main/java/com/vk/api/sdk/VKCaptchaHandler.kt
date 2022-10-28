package com.vk.api.sdk

import android.content.Context

interface VKCaptchaHandler {
    fun showCaptcha(context: Context, captcha: VKApiValidationHandler.Captcha)
    fun getLastKey(): String?
}