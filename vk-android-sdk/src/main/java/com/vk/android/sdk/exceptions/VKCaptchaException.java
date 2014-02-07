/**
 * CatchaException.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 08.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.exceptions;

/**
 * Indicated that user need to enter a captcha.
 */
public class VKCaptchaException extends VKException {

    private final String mCaptchaImg;
    private final String mCaptchaSid;

    public VKCaptchaException(String captcha_img, String captcha_sid, String error_code) {
        super(CAPTCHA_IS_NEEDED, error_code);
        mCaptchaImg = captcha_img;
        mCaptchaSid = captcha_sid;
    }

    public String getCaptchaSid() {
        return mCaptchaSid;
    }

    public String getCaptchaImg() {
        return mCaptchaImg;
    }
}
