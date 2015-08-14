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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.util.VKUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Entry point of SDK. See example for using properly
 */
public class VKSdk {

    private static Handler handler = new Handler(Looper.getMainLooper());

    public static final boolean DEBUG = false;
    public static final boolean DEBUG_API_ERRORS = false;
    public static final String SDK_TAG = "VK SDK";
    public static final String SDK_APP_ID = "com_vk_sdk_AppId";
    public static final String SDK_API_VERSION = "com_vk_sdk_ApiVersion";

    static final int RESULT_OK = Activity.RESULT_OK;
    static final int RESULT_ERROR = Activity.RESULT_CANCELED;

    static final String EXTRA_ERROR_ID = "vk_extra_error_id";

    /**
     * App id for current application
     */
    private static int sCurrentAppId = 0;

    /**
     * Api version for current session
     */
    private static String sCurrentApiVersion;

    public enum LoginState {
        Unknown,
        LoggedOut,
        Pending,
        LoggedIn
    }

    private volatile static LoginState sCurrentLoginState;

    /**
     * Last requested permissions list
     */
    private static ArrayList<String> requestedPermissions;

    /**
     *
     */
    private static final List<VKAccessTokenTracker> sVKTokenListeners = new CopyOnWriteArrayList<>();

    private VKSdk() {

    }

    static void addVKTokenTracker(VKAccessTokenTracker vkAccessTokenTracker) {
        sVKTokenListeners.add(vkAccessTokenTracker);
    }

    static void removeVKTokenTracker(VKAccessTokenTracker vkAccessTokenTracker) {
        sVKTokenListeners.remove(vkAccessTokenTracker);
    }

    static void notifyVKTokenChanged(final VKAccessToken oldToken, final VKAccessToken newToken) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                for (VKAccessTokenTracker listener : sVKTokenListeners) {
                    listener.onVKAccessTokenChanged(oldToken, newToken);
                }
            }
        });
    }

    /**
     * Call this method to prepare VK SDK for work. Best for call - in your application class.
     * Don't forget to call this method when you starting a service
     *
     * @param applicationContext context of current application
     */
    public synchronized static void initialize(Context applicationContext) {
        if (sCurrentAppId != 0) {
            return;
        }

        if (!(applicationContext instanceof Application)) {
            if (applicationContext == null) {
                throw new NullPointerException("Application context cannot be null");
            } else {
                throw new RuntimeException("VKSdk.initialize(Context) must be call from Application#onCreate()");
            }
        } else {
            StackTraceElement element = trace("initialize");
            if (element != null) {
                try {
                    Class<?> aClass = Class.forName(element.getClassName());
                    aClass.asSubclass(Application.class);
                    if (!"onCreate".equals(element.getMethodName())) {
                        throw new RuntimeException("VKSdk.initialize(Context) must be call from Application#onCreate()");
                    }
                } catch (ClassNotFoundException e) {
                    // nothing
                } catch (ClassCastException e) {
                    throw new RuntimeException("VKSdk.initialize(Context) must be call from Application#onCreate()");
                }
            }
        }

        sCurrentAppId = getIntResByName(applicationContext, SDK_APP_ID);
        sCurrentApiVersion = getStringResByName(applicationContext, SDK_API_VERSION);
        if (sCurrentApiVersion == null) {
            sCurrentApiVersion = VKSdkVersion.DEFAULT_API_VERSION;
        }

        sCurrentLoginState = LoginState.Unknown;

        wakeUpSession(applicationContext);

        if (sCurrentAppId == 0) {
            throw new RuntimeException("String <integer name=\"com_vk_sdk_AppId\">your_app_id</integer> did not find in your resources.xml");
        }
    }

    private static String getStringResByName(Context ctx, String aString) {
        int resId = ctx.getResources().getIdentifier(aString, "string", ctx.getPackageName());
        try {
            return ctx.getString(resId);
        } catch (Exception e) {
            return null;
        }
    }

    private static Integer getIntResByName(Context ctx, String aString) {
        int resId = ctx.getResources().getIdentifier(aString, "integer", ctx.getPackageName());
        try {
            return ctx.getResources().getInteger(resId);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Starts authorization process. If VK app is available in system, it will opens and requests access from user.
     * Otherwise UIWebView with standard UINavigationBar will be opened for access request.
     *
     * @param activity current running activity
     * @param scope    array of permissions for your applications. All permissions you can
     */
    public static void login(@NonNull Activity activity, String... scope) {
        VKServiceActivity.startLoginActivity(activity, requestedPermissions = preparingScopeList(scope));
    }

    /**
     * Starts authorization process. If VK app is available in system, it will opens and requests access from user.
     * Otherwise UIWebView with standard UINavigationBar will be opened for access request.
     *
     * @param fragment current running fragment
     * @param scope    array of permissions for your applications. All permissions you can
     */
    public static void login(@NonNull Fragment fragment, String... scope) {
        VKServiceActivity.startLoginActivity(fragment, requestedPermissions = preparingScopeList(scope));
    }

    public static boolean onActivityResult(int requestCode, int resultCode, @NonNull Intent data, @NonNull VKCallback<VKAccessToken> vkCallback) {
        if (requestCode == VKServiceActivity.VKServiceType.Authorization.getOuterCode()) {
            if (resultCode == VKSdk.RESULT_OK) {
                vkCallback.onResult(VKAccessToken.currentToken());
            } else if (resultCode == VKSdk.RESULT_ERROR) {
                vkCallback.onError((VKError) VKObject.getRegisteredObject(data.getLongExtra(VKSdk.EXTRA_ERROR_ID, 0)));
            }
            return true;
        } else {
            return false;
        }
    }

    @NonNull
    private static ArrayList<String> preparingScopeList(String... scope) {
        if (scope == null) {
            scope = new String[]{};
        }
        ArrayList<String> scopeList = new ArrayList<>(Arrays.asList(scope));
        if (!scopeList.contains(VKScope.OFFLINE)) {
            scopeList.add(VKScope.OFFLINE);
        }
        return scopeList;
    }

    static int getsCurrentAppId() {
        return sCurrentAppId;
    }

    /**
     * Pass data of onActivityResult() function here
     *
     * @param resultCode result code of activity result
     * @param result     intent passed by activity
     * @param callback   activity result processing callback
     * @return If SDK parsed activity result properly, returns true. You can return from onActivityResult(). Otherwise, returns false.
     */
    static boolean processActivityResult(int resultCode, @Nullable Intent result, @Nullable VKCallback<VKAccessToken> callback) {
        if (resultCode != Activity.RESULT_OK || result == null) {
            //Result isn't ok, maybe user canceled
            if (callback != null) {
                callback.onError(new VKError(VKError.VK_CANCELED));
            }
            updateLoginState();
            return false;
        }

        CheckTokenResult tokenResult;
        Map<String, String> tokenParams = null;
        if (result.hasExtra(VKOpenAuthActivity.VK_EXTRA_TOKEN_DATA)) {
            //Token received via webview
            String tokenInfo = result.getStringExtra(VKOpenAuthActivity.VK_EXTRA_TOKEN_DATA);
            tokenParams = VKUtil.explodeQueryString(tokenInfo);
        } else if (result.getExtras() != null) {
            //Token received via VK app
            tokenParams = new HashMap<>();
            for (String key : result.getExtras().keySet()) {
                tokenParams.put(key, String.valueOf(result.getExtras().get(key)));
            }
        }

        tokenResult = checkAndSetToken(tokenParams);
        if (tokenResult.error != null && callback != null) {
            callback.onError(tokenResult.error);
        } else if (tokenResult.token != null) {
            if (tokenResult.oldToken != null) {
                VKRequest validationRequest = VKRequest.getRegisteredRequest(result.getLongExtra(VKOpenAuthActivity.VK_EXTRA_VALIDATION_REQUEST, 0));
                if (validationRequest != null) {
                    validationRequest.repeat();
                }
            } else {
                trackVisitor(null);
            }

            if (callback != null) {
                callback.onResult(tokenResult.token);
            }
        }
        requestedPermissions = null;
        updateLoginState();
        return true;
    }

    /**
     * Check new access token and sets it as working token
     *
     * @param tokenParams params of token
     * @return true if access token was set, or error was provided
     */
    private static CheckTokenResult checkAndSetToken(@Nullable Map<String, String> tokenParams) {
        if (tokenParams != null && requestedPermissions != null) {
            tokenParams.put(VKAccessToken.SCOPE, TextUtils.join(",", requestedPermissions));
        }
        VKAccessToken token = VKAccessToken.tokenFromParameters(tokenParams);
        if (token == null || token.accessToken == null) {
            if (tokenParams != null && tokenParams.containsKey(VKAccessToken.SUCCESS)) {
                return new CheckTokenResult(VKAccessToken.currentToken(), token != null ? token : VKAccessToken.currentToken());
            }

            VKError error = new VKError(tokenParams);
            if (error.errorMessage != null || error.errorReason != null) {
                error = new VKError(VKError.VK_CANCELED);
            }
            return new CheckTokenResult(error);
        } else {
            VKAccessToken old = VKAccessToken.currentToken();
            if (old != null) {
                VKAccessToken newToken = old.copyWithToken(token);
                VKAccessToken.replaceToken(old.copyWithToken(token));
                notifyVKTokenChanged(old, newToken);
                return new CheckTokenResult(old, token);
            } else {
                VKAccessToken.replaceToken(token);
                notifyVKTokenChanged(old, token);
                return new CheckTokenResult(token);
            }
        }
    }

    /**
     * Returns token for API requests
     *
     * @return Received access token or null, if user not yet authorized
     * @deprecated Use {@link VKAccessToken#currentToken()} instead
     */
    public static VKAccessToken getAccessToken() {
        return VKAccessToken.currentToken();
    }

    /**
     * Checks if an access token exist and performs a try to use it again
     *
     * @param context An application context for store an access token
     * @return true, if an access token exists and not expired
     */
    public static boolean wakeUpSession(Context context) {
        return wakeUpSession(context, null);
    }

    /**
     * Checks if an access token exist and performs a try to use it again
     *
     * @param context            An application context for store an access token
     * @param loginStateCallback if callback specified, {@link VKCallback#onResult(Object)} method will be called after login state changed
     * @return true, if an access token exists and not expired
     */
    public static boolean wakeUpSession(Context context, final VKCallback<LoginState> loginStateCallback) {
        if (context != null) {
            VKUIHelper.setApplicationContext(context);
        }

        VKAccessToken token = VKAccessToken.currentToken();

        if (token != null && token.accessToken != null && !token.isExpired()) {
            forceLoginState(LoginState.Pending, loginStateCallback);
            trackVisitor(new VKRequest.VKRequestListener() {
                @Override
                public void onComplete(VKResponse response) {
                    updateLoginState(loginStateCallback);
                }

                @Override
                public void onError(VKError error) {
                    //Possible double call of access token invalid
                    if (error != null && error.apiError != null && error.apiError.errorCode == 5) {
                        onAccessTokenIsInvalid();
                    }
                    updateLoginState(loginStateCallback);
                }
            });
            return true;
        }
        updateLoginState(loginStateCallback);
        return false;
    }

    private static void onAccessTokenIsInvalid() {
        VKAccessToken old = VKAccessToken.replaceToken(null);
        if (old != null) {
            notifyVKTokenChanged(old, null);
        }
    }

    /**
     * Common check for access denied errors
     *
     * @param apiError error from VKRequest
     */
    public static void notifySdkAboutApiError(VKError apiError) {
        if (apiError.errorCode == 5) {
            onAccessTokenIsInvalid();
        }
    }

    /**
     * Wipes out information about the access token and clears cookies for internal browse
     */
    @SuppressLint("NewApi")
    public static void logout() {
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.createInstance(VKUIHelper.getApplicationContext());
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeAllCookie();
        } else {
            CookieManager.getInstance().removeAllCookies(null);
        }

        VKAccessToken.replaceToken(null);

        updateLoginState();
    }

    /**
     * Indicated if an access token exists and not expired
     *
     * @return true if a token exists and not expired
     */
    public static boolean isLoggedIn() {
        VKAccessToken token = VKAccessToken.currentToken();
        return token != null && !token.isExpired();
    }

    private static void trackVisitor(VKRequest.VKRequestListener l) {
        VKRequest r = new VKRequest("stats.trackVisitor");
        r.attempts = 0;
        r.executeWithListener(l);
    }

    private static void updateLoginState() {
        updateLoginState(null);
    }

    private static void updateLoginState(VKCallback<LoginState> callback) {
        if (VKAccessToken.currentToken() != null) {
            forceLoginState(LoginState.LoggedIn, callback);
        } else {
            forceLoginState(LoginState.LoggedOut, callback);
        }
    }

    private static void forceLoginState(LoginState newState, VKCallback<LoginState> callback) {
        sCurrentLoginState = newState;
        if (callback != null) {
            callback.onResult(sCurrentLoginState);
        }
    }

    /**
     * @return Returns specified API version for VK requests
     */
    public static String getApiVersion() {
        return sCurrentApiVersion;
    }

    private static class CheckTokenResult {
        public VKAccessToken token;
        public VKAccessToken oldToken;
        public VKError error;

        public CheckTokenResult(VKAccessToken token) {
            this.token = token;
        }

        public CheckTokenResult(VKAccessToken oldToken, VKAccessToken newToken) {
            this.token = newToken;
            this.oldToken = oldToken;
        }

        public CheckTokenResult(VKError err) {
            this.error = err;
        }
    }

    @Nullable
    private static StackTraceElement trace(@Nullable final String callingMethodName) {
        StackTraceElement[] e = Thread.currentThread().getStackTrace();
        boolean doNext = false;
        for (StackTraceElement s : e) {
            if (doNext && !s.getMethodName().equals(callingMethodName)) {
                return s;
            }
            doNext = s.getMethodName().equals(callingMethodName);
        }
        return null;
    }
}