/**
 * Execute.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 15.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk;

import android.test.InstrumentationTestCase;
import android.util.Log;
import com.vk.android.sdk.exceptions.VKException;
import com.vk.android.sdk.methods.Users;
import com.vk.android.sdk.models.VKList;
import com.vk.android.sdk.models.VKUser;

public class ExecuteTest extends InstrumentationTestCase {

    public void testToExecuteString() throws Exception {
        VK vk = VK.with(getInstrumentation().getContext());
        RequestsBatch builder = new RequestsBatch();

        builder.add(Users.get(1, 2), new VK.SimpleCallback<VKList<VKUser>>() {
            @Override
            public void onAdded(VK vk) {
                d("Request1: onAdded()");
            }

            @Override
            public void onPreExecute(VK vk) {
                d("Request1: onPreExecute()");
            }

            @Override
            public void onSuccess(VK vk, VKList<VKUser> data) {
                d("Request1: onSuccess()");
            }

            @Override
            public void onError(VK vk, VKException e) {
                d("Request1: onError()");
            }

            @Override
            public void onPostExecute(VK vk) {
                d("Request1: onPostExecute()");
            }
        });

        builder.add(Users.get(6,14), new VK.SimpleCallback<VKList<VKUser>>() {
            @Override
            public void onAdded(VK vk) {
                d("Request2: onAdded()");
            }

            @Override
            public void onPreExecute(VK vk) {
                d("Request2: onPreExecute()");
            }

            @Override
            public void onSuccess(VK vk, VKList<VKUser> data) {
                d("Request2: onSuccess()");
            }

            @Override
            public void onError(VK vk, VKException e) {
                d("Request2: onError()");
            }

            @Override
            public void onPostExecute(VK vk) {
                d("Request2: onPostExecute()");
            }
        });

        builder.add(Users.get(17,34), new VK.SimpleCallback<VKList<VKUser>>() {
            @Override
            public void onAdded(VK vk) {
                d("Request3: onAdded()");
            }

            @Override
            public void onPreExecute(VK vk) {
                d("Request3: onPreExecute()");
            }

            @Override
            public void onSuccess(VK vk, VKList<VKUser> data) {
                d("Request3: onSuccess()");
            }

            @Override
            public void onError(VK vk, VKException e) {
                d("Request3: onError()");
            }

            @Override
            public void onPostExecute(VK vk) {
                d("Request3: onPostExecute()");
            }
        });

        vk.exec(builder);
    }

    static void d(String data) {
        Log.d("VK_REQUESTS_TESTING", data);
    }
}
