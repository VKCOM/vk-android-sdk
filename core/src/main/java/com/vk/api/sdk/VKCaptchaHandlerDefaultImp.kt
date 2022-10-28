package com.vk.api.sdk

import android.content.Context
import com.vk.api.sdk.ui.VKCaptchaActivity

class VKCaptchaHandlerDefaultImp: VKCaptchaHandler {
    override fun showCaptcha(context: Context, captcha: VKApiValidationHandler.Captcha) {
        VKCaptchaActivity.start(context, captcha.img, captcha.height, captcha.width)
    }

    override fun getLastKey(): String? = VKCaptchaActivity.lastKey

}