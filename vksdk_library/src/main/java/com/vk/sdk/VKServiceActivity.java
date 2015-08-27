//
//  Copyright (c) 2014 VK.com
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to
//  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
//  the Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
//  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
//  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
//  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
//  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

package com.vk.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.vk.sdk.api.VKError;
import com.vk.sdk.dialogs.VKCaptchaDialog;
import com.vk.sdk.util.VKStringJoiner;
import com.vk.sdk.util.VKUtil;

import java.util.ArrayList;

/**
 * Special activity for VK events, such as login, captcha and validation
 */
public class VKServiceActivity extends Activity implements DialogInterface.OnDismissListener {

    /**
     * Defines true VK application fingerprint
     */
    private static final String VK_APP_FINGERPRINT = "48761EEF50EE53AFC4CC9C5F10E6BDE7F8F5B82F";
    private static final String VK_APP_PACKAGE_ID = "com.vkontakte.android";
    private static final String VK_APP_AUTH_ACTION = "com.vkontakte.android.action.SDK_AUTH";

    private static final String KEY_TYPE = "arg1";
    private static final String KEY_SCOPE_LIST = "arg2";
    private static final String KEY_REQUEST = "arg3";
    private static final String KEY_SDK_CUSTOM_INITIALIZE = "arg4";

    // ---------- PUBLIC STATIC METHODS ----------

    public enum VKServiceType {
        Authorization(10485),
        Captcha(14079),
        Validation(11477);

        private int outerCode;

        VKServiceType(int outerCode) {
            this.outerCode = outerCode;
        }

        public int getOuterCode() {
            return outerCode;
        }
    }

    public static void interruptWithError(Context ctx, VKError apiError, VKServiceType type) {
        Intent intent = createIntent(ctx, type);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(KEY_REQUEST, apiError.registerObject());
        if (ctx != null) {
            ctx.startActivity(intent);
        }
    }

    // ---------- PACKAGE METHODS ----------

    /**
     * Starts login process with fragment
     * @param act       current running activity
     * @param scopeList authorization
     */
    static void startLoginActivity(@NonNull Activity act, @NonNull ArrayList<String> scopeList) {
        Intent intent = createIntent(act.getApplicationContext(), VKServiceType.Authorization);
        intent.putStringArrayListExtra(KEY_SCOPE_LIST, scopeList);
        act.startActivityForResult(intent, VKServiceType.Authorization.getOuterCode());
    }

    /**
     * Starts login process with fragment
     * warning: this method is available on SDK after honeycomb
     *
     * @param fr        current running fragment
     * @param scopeList authorization
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    static void startLoginActivity(@NonNull Fragment fr, ArrayList<String> scopeList) {
        Intent intent = createIntent(fr.getActivity().getApplication(), VKServiceType.Authorization);
        intent.putStringArrayListExtra(KEY_SCOPE_LIST, scopeList);
        fr.startActivityForResult(intent, VKServiceType.Authorization.getOuterCode());
    }

    // ---------- PRIVATE METHODS ----------

    @NonNull
    private static Intent createIntent(Context appCtx, VKServiceType type) {
        Intent intent = new Intent(appCtx, VKServiceActivity.class);
        intent.putExtra(KEY_TYPE, type.name());
        intent.putExtra(KEY_SDK_CUSTOM_INITIALIZE, VKSdk.isCustomInitialize());
        return intent;
    }

    @NonNull
    private VKServiceType getType() {
        return VKServiceType.valueOf(getIntent().getStringExtra(KEY_TYPE));
    }

    @Nullable
    private ArrayList<String> getScopeList() {
        return getIntent().getStringArrayListExtra(KEY_SCOPE_LIST);
    }

    private long getRequestId() {
        return getIntent().getLongExtra(KEY_REQUEST, 0);
    }

    // ---------- ACTIVITY METHODS ----------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getBooleanExtra(KEY_SDK_CUSTOM_INITIALIZE, false)) {
            VKSdk.customInitialize(this, 0, null);
        }

        if (savedInstanceState == null) {
            switch (getType()) {
                case Authorization:
                    Intent intent;
                    final Context ctx = getApplicationContext();
                    if (VKUtil.isAppInstalled(ctx, VK_APP_PACKAGE_ID) && VKUtil.isIntentAvailable(ctx, VK_APP_AUTH_ACTION)) {
                        intent = new Intent(VK_APP_AUTH_ACTION, null);
                    } else {
                        intent = VKOpenAuthActivity.createIntent(ctx);
                    }

                    intent.putExtra(VKOpenAuthActivity.VK_EXTRA_API_VERSION, VKSdk.getApiVersion());
                    intent.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, VKSdk.getsCurrentAppId());
                    intent.putExtra(VKOpenAuthActivity.VK_EXTRA_REVOKE, true);
                    intent.putExtra(VKOpenAuthActivity.VK_EXTRA_SCOPE, VKStringJoiner.join(getScopeList(), ","));
                    startActivityForResult(intent, VKServiceType.Authorization.getOuterCode());
                    break;
                case Captcha:
                    VKError vkError = (VKError) VKObject.getRegisteredObject(getRequestId());
                    if (vkError != null) {
                        VKCaptchaDialog vkCaptchaDialog = new VKCaptchaDialog(vkError);
                        vkCaptchaDialog.show(this, this);
                    } else {
                        finish();
                    }
                    break;
                case Validation:
                    vkError = (VKError) VKObject.getRegisteredObject(getRequestId());
                    if (vkError != null) {
                        intent = VKOpenAuthActivity.validationIntent(this, vkError);
                        startActivityForResult(intent, VKServiceType.Validation.getOuterCode());
                    } else {
                        finish();
                    }
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VKServiceType.Authorization.getOuterCode() || requestCode == VKServiceType.Validation.getOuterCode()) {
            VKSdk.processActivityResult(this, resultCode, data, new VKCallback<VKAccessToken>() {
                @Override
                public void onResult(VKAccessToken res) {
                    setResult(VKSdk.RESULT_OK);
                    finish();
                }

                @Override
                public void onError(VKError error) {
                    Object o = VKObject.getRegisteredObject(getRequestId());
                    if (o instanceof VKError) {
                        VKError vkError = ((VKError) o);
                        if (vkError.request != null) {
                            vkError.request.cancel();
                            if (vkError.request.requestListener != null) {
                                vkError.request.requestListener.onError(error);
                            }
                        }
                    }

                    if (error != null) {
                        setResult(VKSdk.RESULT_ERROR, getIntent().putExtra(VKSdk.EXTRA_ERROR_ID, error.registerObject()));
                    } else {
                        setResult(VKSdk.RESULT_ERROR);
                    }
                    finish();
                }
            });
        }
    }

    // ---------- ON DISMISS LISTENER ----------

    @Override
    public void onDismiss(DialogInterface dialog) {
        finish();
    }
}