/**
 * ServerException.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 15.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.exceptions;

/**
 * Describes a VK server exception.
 */
public class VKServerException extends VKException {

    public VKServerException(int code, String message) {
        super(code, message);
    }

    public VKServerException(int code, Throwable throwable) {
        super(code, throwable);
    }

    public VKServerException(VKException e) {
        this(e.getCode(), e.getMessage());
    }
}
