/**
 * VKRequest.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 07.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk;

import android.net.Uri;
import com.vk.android.sdk.exceptions.*;
import com.vk.android.sdk.models.VKAccessToken;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.util.Locale;
import java.util.Map;

/**
 * Represents request to the VK.
 * All params will be transferred as POST.
 *
 * This class does not support sending files,
 * but allows you to handle errors of VK API.
 * @param <T> type of request result
 */
@SuppressWarnings("unused")
public abstract class VKRequest<T> extends RESTRequest<T> {

    final static String SERVER = "api.vk.com";
    final static String METHOD = "/method/";
    final static String HTTP = "http://";
    final static String HTTPS = "https://";
    final static String PARAM_SIG = "sig";
    final static String PARAM_HTTPS = "https";
    final static String PARAM_ACCESS_TOKEN = "access_token";
    final static String PARAM_LANG = "lang";
    final static String PARAM_VERSION = "v";
    final static String API = "API";

    /**
     * Creates request with VK API according with method.
     * @param method method to call
     */
    public VKRequest(CharSequence method) {
        if(method == null) {
            throw new NullPointerException("Method cannot be null");
        }
        mTag = method;
    }

    @Override
    public CharSequence getUrl() {
        return (Settings.get().isHttps() ? HTTPS : HTTP) + SERVER + METHOD + mTag;
    }

    @Override
    protected void onPreExecute() {
        Settings settings = Settings.get();
        VKAccessToken account = settings.getAccount();
        boolean useHTTPS = settings.isHttps();
        String token = null;
        String secret = null;

        if(account != null) {
            token = account.getAccessToken();
            secret = account.getSecret();
        }
        param(PARAM_VERSION, Settings.API_VERSION);
        param(PARAM_LANG, getDeviceLang());
        if (token != null) {
            param(PARAM_ACCESS_TOKEN, token);
        }
        if (useHTTPS) {
            param(PARAM_HTTPS, true);
        }
        if(secret != null) {
            mParams.remove(PARAM_SIG);
            param(PARAM_SIG, computeSig(secret));
        }
    }

    @Override
    protected final String validateResponse(String source) throws VKCaptchaException, VKValidationException, VKAuthException, VKServerException {
        try {
            final JSONObject error = new JSONObject(source).getJSONObject("error");
            final int error_code = error.getInt("error_code");
            final String error_msg = error.getString("error_msg");
            if(error_code == VKException.CAPTCHA_IS_NEEDED) {
                throw new VKCaptchaException(error.optString("captcha_img"), error.optString("captcha_sid"), error_msg);
            }
            if(error_code == VKException.VALIDATION_IS_REQUIRED) {
                throw new VKValidationException(error.optString("redirect_uri"), error_msg);
            }
            if(error_code == VKException.USER_AUTHORIZATION_FAILED) {
                throw new VKAuthException(error_msg);
            }
            throw new VKServerException(error_code, error_msg);
        } catch (JSONException e) {
            return source;
        }
    }

    @Override
    public RESTRequest files(CharSequence key, Uri file) {
        throw new UnsupportedOperationException("VKRequest not support file transferring, use RESTRequest instead.");
    }

    private String computeSig(String secret) {
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (Map.Entry<CharSequence, CharSequence> entry : mParams.entrySet()) {
            if (firstTime) {
                firstTime = false;
                sb.append('?');
            } else {
                sb.append('&');
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        return md5(METHOD + mTag + sb.toString() + secret);
    }

    static String getDeviceLang() {
        String locale = Locale.getDefault().getISO3Language().substring(0, 2);
        if("ru".equals(locale)) {
            return "ru";
        } else if("uk".equals(locale)) {
            return "ua";
        } else if("be".equals(locale)) {
            return "be";
        } else if("es".equals(locale)) {
            return "es";
        } else if("fi".equals(locale)) {
            return "fi";
        } else if("de".equals(locale)) {
            return "de";
        } else if("it".equals(locale)) {
            return "it";
        }
        return "en";
    }

    static String md5(String from) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(from.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte anArray : array) {
                sb.append(String.format("%02x", anArray & 0xFF));
//                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            return from;
        }
    }

}
