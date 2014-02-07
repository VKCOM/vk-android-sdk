/**
 * ValidationException.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 08.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.exceptions;

/**
 * Indicates that user need to pass validation procedure.
 */
public class VKValidationException extends VKException {

    private final String mRedirectUri;

    public VKValidationException(String redirect_uri, String error_msg) {
        super(VALIDATION_IS_REQUIRED, error_msg);
        mRedirectUri = redirect_uri;
    }

    public String getRedirectUri() {
        return mRedirectUri;
    }
}
