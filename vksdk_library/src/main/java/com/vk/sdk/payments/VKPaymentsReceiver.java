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

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKUIHelper;


public class VKPaymentsReceiver extends BroadcastReceiver {

    private static VKAccessTokenTracker tracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(@Nullable VKAccessToken oldToken, @Nullable VKAccessToken newToken) {
            checkUserInstall(VKUIHelper.getApplicationContext(), false);
        }
    };

    @Override
    public void onReceive(final Context ctx, Intent intent) {
        onReceiveStatic(ctx, isNeedForceOurUser(intent));
    }

    public static void onReceiveStatic(final Context ctx) {
        onReceiveStatic(ctx, false);
    }

    private static void onReceiveStatic(final Context ctx, boolean forceOurUser) {
        if (isActiveNetwork(ctx) && VKSdk.isIsPaymentsEnable()) {
            if (VKAccessToken.currentToken() == null && !tracker.isTracking()) {
                tracker.startTracking();
            }
            checkUserInstall(ctx, forceOurUser);
        }
    }

    private static boolean isNeedForceOurUser(@Nullable final Intent intent) {
        String referrerStr = intent == null ? null : intent.getStringExtra("referrer");
        return intent != null && "com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) &&
                referrerStr != null && referrerStr.startsWith("utm_source=vk");
    }

    private static void checkUserInstall(@Nullable final Context ctx, boolean force) {
        if (ctx != null) {
            VKPaymentsServerSender.getInstance(ctx).checkUserInstall(force);
        }
    }

    // ---------- UTILS METHOD ----------

    private static boolean isActiveNetwork(Context ctx) {
        if (checkAccessNetworkStatePermission(ctx)) {
            ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        } else {
            return true;
        }
    }

    private static boolean checkAccessNetworkStatePermission(Context ctx) {
        String permission = "android.permission.ACCESS_NETWORK_STATE";
        int res = ctx.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
}