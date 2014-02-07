/**
 * ValidationException.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 08.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.exceptions;

/**
 * Indicates that user need to pass authorization.
 */
public class VKAuthException extends VKException {

    public VKAuthException(String message) {
        super(USER_AUTHORIZATION_FAILED, message);
    }
}
