/**
 * VKException.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 07.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.exceptions;

import android.content.res.Resources;
import android.util.SparseArray;
import com.vk.android.sdk.R;

/**
 * General class for all VK exceptions, including JSON and I/O exceptions.
 */
@SuppressWarnings("unused")
public abstract class VKException extends Exception {

    /**
     * Unable to pare server response to JSON in {@link com.vk.android.sdk.RESTRequest#parse(String)}.
     */
    public final static int JSON_PARSE_ERROR = -2;
    /**
     * Internet connection is down.
     */
    public final static int NETWORK_ERROR = -1;

    public final static int UNKNOWN_ERROR_OCCURRED = 1;

    /**
     * Application is disabled by VK.COM administration.
     */
    public final static int APPLICATION_IS_DISABLED = 2;

    /**
     * Invalid method name.
     */
    public final static int NO_METHOD_FOUND = 3;

    /**
     * Incorrect signature for HTTP requests.
     */
    public final static int INCORRECT_SIGNATURE = 4;

    /**
     * Method requires user authorisation.
     */
    public final static int USER_AUTHORIZATION_FAILED = 5;

    /**
     * Need to repeat request after some delay.
     */
    public final static int TOO_MANY_REQUESTS_PER_SECOND = 6;
    public final static int PERMISSION_TO_PERFORM_THIS_ACTION_IS_DENIED_BY_USER = 7;
    public final static int INVALID_REQUEST = 8;

    /**
     * Some methods returns API, which have a limit on the number of calls per hour.
     */
    public final static int FLOOD_CONTROL_ENABLED_FOR_THIS_ACTION = 9;
    public final static int INTERVAL_SERVER_ERROR = 10;

    /**
     * Returns for invalid execute code.
     */
    public final static int COMPILATION_ERROR = 12;
    /**
     * Returns for invalid execute code.
     */
    public final static int RUNTIME_ERROR = 13;
    /**
     * Returns if method require captcha entering.
     */
    public final static int CAPTCHA_IS_NEEDED = 14;
    public final static int NO_ACCESS = 15;
    /**
     * Returns if user has enabled "https-only" mode in the site settings.
     */
    public final static int HTTPS_ONLY = 16;
    /**
     * Returns if user need to pass validation procedure.
     */
    public final static int VALIDATION_IS_REQUIRED = 17;


    final int code;
    final String message;

    public VKException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public VKException(int code, Throwable throwable) {
        super(throwable);
        this.code = code;
        this.message = throwable.getMessage();
    }

    /**
     * Code field value from server "error" object.
     * @return code field value from server "error" object.
     */
    public int getCode() {
        return code;
    }

    /**
     * Message field value from server "error" object.
     * @return message field value from server "error" object.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Localized description of error to show to user.
     * @param res resources
     * @return localized description of error to show to user,
     * or localized "internal error" string if error is in the
     * code of the method or SDK can solve this error automatically.
     */
    public CharSequence getLocalizedMessage(Resources res) {
        switch (code) {
            case JSON_PARSE_ERROR:
                return res.getString(R.string.vk_json_parse_error);
            case NETWORK_ERROR:
                return res.getString(R.string.vk_network_error);
            case FLOOD_CONTROL_ENABLED_FOR_THIS_ACTION:
                return res.getString(R.string.vk_food_control_error);
            default:
                return res.getString(R.string.vk_internal_error);
        }
    }
}
