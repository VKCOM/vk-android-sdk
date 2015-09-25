//
//  Copyright (c) 2015 VK.com
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


package com.vk.sdk.payments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.vk.sdk.VKSdk;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import org.json.JSONException;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class VKPaymentsServerSender {

    private static final String METHOD_NAME_CHECK_USER_INSTALL = "apps.checkUserInstall";
    private static final String METHOD_NAME_SAVE_TRANSACTION = "apps.saveTransaction";

    private static final String PLATFORM = "platform";
    private static final String APP_ID = "app_id";
    private static final String DEVICE_ID = "device_id";
    private static final String RECEIPT = "receipt";
    private static final String FORCE = "force";

    private static final String RESPONSE = "response";

    private static final int CHECK_USER_INSTALL_ANSWER_UNKNOWN = -1;
    private static final int CHECK_USER_INSTALL_ANSWER_NOT_VK = 0;
    private static final int CHECK_USER_INSTALL_ANSWER_VK = 1;
    private static final int CHECK_USER_INSTALL_ANSWER_VK_FORCE = 2;

    private static final String KEY_ANSWER = "VK_SDK_CHECK_USER_INSTALL";

    // ---------- SINGLETON PART ----------

    private static VKPaymentsServerSender sInstance = null;

    public static VKPaymentsServerSender getInstance(@NonNull Context ctx) {
        if (sInstance == null) {
            synchronized (VKPaymentsServerSender.class) {
                if (sInstance == null) {
                    sInstance = new VKPaymentsServerSender(ctx.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    // ---------- CLASS PART ----------

    @NonNull
    private final Handler mHandler;
    @NonNull
    private final Context mAppCtx;

    private volatile int mCheckUserInstallAnswer = -1;

    private final List<VKPaymentsCallback> mVkPaymentsCallbacks = new CopyOnWriteArrayList<>();

    private VKPaymentsServerSender(@NonNull Context ctx) {
        mAppCtx = ctx;

        mCheckUserInstallAnswer = restoreAnswer(ctx);

        HandlerThread handlerThread = new HandlerThread(getClass().getName());
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());

        // !!! WARNING !!! this for wait reference url from vk client
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000); // time for wait reference url
                } catch (Exception e) {
                    // nothing
                }
            }
        });
    }

    public void requestUserState(@NonNull VKPaymentsCallback callback) {
        synchronized (VKPaymentsServerSender.class) {
            switch (mCheckUserInstallAnswer) {
                case CHECK_USER_INSTALL_ANSWER_VK:
                case CHECK_USER_INSTALL_ANSWER_VK_FORCE:
                    callback.onUserState(true);
                    break;
                case CHECK_USER_INSTALL_ANSWER_NOT_VK:
                    callback.onUserState(false);
                    break;
                default:
                    mVkPaymentsCallbacks.add(callback);
            }
        }
    }

    // ---------- COMMON PART ----------

    private void request(boolean force) {
        if (force) {
            onCheckUserInstallReceive(CHECK_USER_INSTALL_ANSWER_VK_FORCE);
        }
        if (mCheckUserInstallAnswer == CHECK_USER_INSTALL_ANSWER_UNKNOWN
                || mCheckUserInstallAnswer == CHECK_USER_INSTALL_ANSWER_VK_FORCE) {
            mHandler.post(mCheckUserInstallRunnable);
            requestSaveTransaction();
        } else if (mCheckUserInstallAnswer == CHECK_USER_INSTALL_ANSWER_VK) {
            requestSaveTransaction();
        }
    }

    private void requestSaveTransaction() {
        HashSet<String> purchases = VKPaymentsDatabase.getInstance(mAppCtx).getPurchases();

        final Runnable runnableSaveTransaction;
        if (purchases.size() > 0) {
            runnableSaveTransaction = new SaveTransactionRunnable(purchases);
        } else {
            runnableSaveTransaction = null;
        }
        if (runnableSaveTransaction != null) {
            mHandler.post(runnableSaveTransaction);
        }
    }

    public static boolean isNotVkUser() {
        if (!VKSdk.isIsPaymentsEnable()) {
            return true;
        }
        final Context ctx = VKUIHelper.getApplicationContext();
        return ctx != null && VKPaymentsServerSender.getInstance(ctx).mCheckUserInstallAnswer == CHECK_USER_INSTALL_ANSWER_NOT_VK;
    }

    // ---------- SAVE TRANSACTION PART ----------

    public void saveTransaction(final String purchaseInfo) {
        VKPaymentsDatabase.getInstance(mAppCtx).insertPurchase(purchaseInfo);
        request(false);
    }

    class SaveTransactionRunnable implements Runnable {
        final HashSet<String> purchases;

        private SaveTransactionRunnable(HashSet<String> purchases) {
            this.purchases = purchases;
        }

        @Override
        public void run() {
            if (mCheckUserInstallAnswer == CHECK_USER_INSTALL_ANSWER_VK
                    || mCheckUserInstallAnswer == CHECK_USER_INSTALL_ANSWER_VK_FORCE) {
                for (final String receipt : purchases) {

                    final String platform = "android";
                    final int appId = getIntResByName(mAppCtx, VKSdk.SDK_APP_ID);
                    final String deviceId = getDeviceId(mAppCtx);

                    VKRequest request = new VKRequest(METHOD_NAME_SAVE_TRANSACTION);
                    request.addExtraParameter(PLATFORM, platform);
                    request.addExtraParameter(APP_ID, appId);
                    if (!TextUtils.isEmpty(deviceId)) {
                        request.addExtraParameter(DEVICE_ID, deviceId);
                    }
                    request.addExtraParameter(RECEIPT, receipt);

                    request.executeSyncWithListener(new VKRequest.VKRequestListener() {
                        @Override
                        public void onComplete(VKResponse response) {
                            VKPaymentsDatabase.getInstance(mAppCtx).deletePurchase(receipt);
                            log("apps.saveTransaction successful response=" + response.json);
                        }

                        @Override
                        public void onError(VKError error) {
                            log("apps.saveTransaction error=" + (error.apiError == null ? error.errorMessage : error.apiError.errorMessage));
                        }
                    });
                }
            }
        }
    }

    // ---------- CHECK USER INSTALL PART ----------

    public void checkUserInstall(boolean force) {
        request(force);
    }

    private void onCheckUserInstallReceive(int checkUserInstallAnswer) {
        saveAnswer(mAppCtx, checkUserInstallAnswer);
        synchronized (VKPaymentsServerSender.class) {
            for (VKPaymentsCallback callback : mVkPaymentsCallbacks) {
                switch (mCheckUserInstallAnswer) {
                    case CHECK_USER_INSTALL_ANSWER_VK:
                    case CHECK_USER_INSTALL_ANSWER_VK_FORCE:
                        callback.onUserState(true);
                        break;
                    case CHECK_USER_INSTALL_ANSWER_NOT_VK:
                        callback.onUserState(false);
                        break;
                }
            }
            mVkPaymentsCallbacks.clear();
        }
    }

    Runnable mCheckUserInstallRunnable = new Runnable() {

        @Override
        public void run() {
            if (VKSdk.isIsPaymentsEnable() && (mCheckUserInstallAnswer == CHECK_USER_INSTALL_ANSWER_UNKNOWN
                    || mCheckUserInstallAnswer == CHECK_USER_INSTALL_ANSWER_VK_FORCE)) {
                final String platform = "android";
                final int appId = getIntResByName(mAppCtx, VKSdk.SDK_APP_ID);
                final String deviceId = getDeviceId(mAppCtx);

                VKRequest request = new VKRequest(METHOD_NAME_CHECK_USER_INSTALL);
                request.addExtraParameter(PLATFORM, platform);
                request.addExtraParameter(APP_ID, appId);
                if (mCheckUserInstallAnswer == CHECK_USER_INSTALL_ANSWER_VK_FORCE) {
                    request.addExtraParameter(FORCE, 1);
                }
                if (!TextUtils.isEmpty(deviceId)) {
                    request.addExtraParameter(DEVICE_ID, deviceId);
                }

                request.executeSyncWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        try {
                            onCheckUserInstallReceive(response.json.getInt(RESPONSE));
                            log("apps.checkUserInstall successful response=" + response.json);
                        } catch (JSONException e) {
                            log("error", e);
                        }
                    }
                });
            }
        }
    };

    // ---------- UTILS PART ----------

    private static void log(String s) {
        if (VKSdk.DEBUG) {
            if (!TextUtils.isEmpty(s)) {
                Log.e("vk", s);
            }
        }
    }

    private static void log(String s, Exception e) {
        if (VKSdk.DEBUG) {
            if (!TextUtils.isEmpty(s)) {
                Log.e("vk", s, e);
            }
        }
    }

    private void saveAnswer(Context ctx, int value) {
        synchronized (VKPaymentsServerSender.class) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx.getApplicationContext());
            prefs.edit().putInt(KEY_ANSWER, value).apply();

            mCheckUserInstallAnswer = value;
        }
    }

    private int restoreAnswer(Context ctx) {
        synchronized (VKPaymentsServerSender.class) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx.getApplicationContext());
            return prefs.getInt(KEY_ANSWER, CHECK_USER_INSTALL_ANSWER_UNKNOWN);
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

    @Nullable
    private static String getDeviceId(Context ctx) {
        try {
            Class<?> advertisingIdClientClass = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Class<?> advertisingIdClientClassInfo = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            Method methodGetInfo = advertisingIdClientClass.getDeclaredMethod("getAdvertisingIdInfo", Context.class);
            Method methodGetId = advertisingIdClientClassInfo.getMethod("getId");

            Object info = methodGetInfo.invoke(advertisingIdClientClass, ctx);
            return (String) methodGetId.invoke(info);
        } catch (Exception e) {
            Log.e("vk", "error", e);
            return null;
        }
    }
}