/**
 * PickFragment.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 20.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.samples;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vk.android.sdk.VK;
import com.vk.android.sdk.VKRequest;
import com.vk.android.sdk.exceptions.*;
import com.vk.android.sdk.models.ParseUtils;
import org.json.JSONException;

import java.io.IOException;
import java.util.concurrent.CancellationException;

public class ErrorsFragment extends LoggableFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_errors, container, false);
        view.findViewById(R.id.test_network_error).setOnClickListener(this);
        view.findViewById(R.id.test_json_error).setOnClickListener(this);
        view.findViewById(R.id.test_auth_error).setOnClickListener(this);
        view.findViewById(R.id.test_captcha_error).setOnClickListener(this);
        view.findViewById(R.id.test_validation_error).setOnClickListener(this);
        view.findViewById(R.id.test_https_error).setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_network_error: {
                testNetworkError();
            } break;
            case R.id.test_json_error: {
                testJSONError();
            } break;
            case R.id.test_auth_error: {
                testAuthError();
            } break;
            case R.id.test_captcha_error: {
                testCaptcha();
            } break;
            case R.id.test_validation_error: {
                testValidation();
            } break;
            case R.id.test_https_error: {
                testHTTPSError();
            } break;
        }
    }

    private void testNetworkError() {
        VK.with(getActivity()).exec(new VKRequest<Boolean>("account.setOnline") {

            @Override
            protected void onPostExecute(Boolean result) throws VKServerException, VKCaptchaException, VKValidationException, VKAuthException, IOException, JSONException, CancellationException {
                throw new IOException("Network error");
            }

            @Override
            protected Boolean parse(String source) throws JSONException {
                return true;
            }
        }, new VK.SimpleCallback<Boolean>() {
            @Override
            public void onError(VK vk, VKException e) {
                log("error: " + e.getMessage() + ", localized: " + e.getLocalizedMessage(getResources()));
            }
        });
    }

    private void testJSONError() {
        VK.with(getActivity()).exec(new VKRequest<Boolean>("account.setOnline") {

            @Override
            protected Boolean parse(String source) throws JSONException {
                throw new JSONException("JSON Error");
            }
        }, new VK.SimpleCallback<Boolean>() {
            @Override
            public void onError(VK vk, VKException e) {
                log("error: " + e.getMessage() + ", localized: " + e.getLocalizedMessage(getResources()));
            }
        });
    }

    private void testAuthError() {
        VK.with(getActivity()).exec(new VKRequest<Boolean>("account.setOnline") {
            private String oldToken = VK.with(getActivity()).getAccount().getAccessToken();

            @Override
            protected void onPostExecute(Boolean result) throws VKServerException, VKCaptchaException, VKValidationException, VKAuthException, IOException, JSONException, CancellationException {
                if(oldToken == VK.with(getActivity()).getAccount().getAccessToken()) {
                    throw new VKAuthException("User authorisation failed");
                }
            }

            @Override
            protected Boolean parse(String source) throws JSONException {
                return true;
            }
        }, new VK.SimpleCallback<Boolean>() {
            @Override
            public void onSuccess(VK vk, Boolean data) {
                log("success, result: " + data);
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("error: " + e.getMessage() + ", localized: " + e.getLocalizedMessage(getResources()));
            }
        });
    }

    private void testHTTPSError() {
        VK.with(getActivity()).exec(new VKRequest<Boolean>("account.setOnline") {

            @Override
            protected void onPostExecute(Boolean result) throws VKServerException, VKCaptchaException, VKValidationException, VKAuthException, IOException, JSONException, CancellationException {
                if(!VK.with(getActivity()).isHttpsRequired()) {
                    throw new VKServerException(VKException.HTTPS_ONLY, "HTTPS only");
                }
            }

            @Override
            protected Boolean parse(String source) throws JSONException {
                return true;
            }
        }, new VK.SimpleCallback<Boolean>() {
            @Override
            public void onSuccess(VK vk, Boolean data) {
                log("success, result: " + data);
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("error: " + e.getMessage() + ", localized: " + e.getLocalizedMessage(getResources()));
            }
        });
    }

    private void testCaptcha() {
        VK.with(getActivity()).exec(new VKRequest<Boolean>("captcha.force") {
            @Override
            protected Boolean parse(String source) throws JSONException {
                return ParseUtils.parseBoolean(source);
            }
        }, new VK.SimpleCallback<Boolean>() {
            @Override
            public void onSuccess(VK vk, Boolean data) {
                log("success, result: " + data);
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("error: " + e.getMessage() + ", localized: " + e.getLocalizedMessage(getResources()));
            }
        });
    }

    private void testValidation() {
        VK.with(getActivity()).exec(new VKRequest<Boolean>("account.testValidation") {
            @Override
            protected Boolean parse(String source) throws JSONException {
                return ParseUtils.parseBoolean(source);
            }
        }, new VK.SimpleCallback<Boolean>() {
            @Override
            public void onSuccess(VK vk, Boolean data) {
                log("success, result: "  + data);
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("error: " + e.getMessage() + ", localized: " + e.getLocalizedMessage(getResources()));
            }
        });
    }
}
