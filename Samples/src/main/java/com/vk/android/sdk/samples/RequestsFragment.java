/**
 * PickFragment.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 20.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.samples;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vk.android.sdk.ExecuteBuilder;
import com.vk.android.sdk.RequestsBatch;
import com.vk.android.sdk.VK;
import com.vk.android.sdk.exceptions.VKException;
import com.vk.android.sdk.methods.Users;
import com.vk.android.sdk.models.VKList;
import com.vk.android.sdk.models.VKUser;

public class RequestsFragment extends LoggableFragment implements View.OnClickListener {

    private static final int REQUEST_TEST_CODE = 14;
    private TestReceiverCallback receiver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_requests, container, false);
        view.findViewById(R.id.test_requests).setOnClickListener(this);
        view.findViewById(R.id.test_recreation).setOnClickListener(this);
        view.findViewById(R.id.test_batch).setOnClickListener(this);
        view.findViewById(R.id.test_builder).setOnClickListener(this);
        view.findViewById(R.id.test_scheduled).setOnClickListener(this);
        view.findViewById(R.id.test_cancel).setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        receiver = new TestReceiverCallback();
        getActivity().registerReceiver(receiver, VK.Receiver.FILTER);
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(receiver);
        receiver = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_requests: {
                runSampleRequest();
            } break;
            case R.id.test_recreation: {
                runActivityRecreationRequest();
            } break;
            case R.id.test_batch: {
                runRequestBatch();
            } break;
            case R.id.test_builder: {
                runExecuteBuilder();
            } break;
            case R.id.test_scheduled: {
                runScheduledRequest();
            } break;
            case R.id.test_cancel: {
                cancelScheduledRequest();
            } break;
        }
    }

    private void runSampleRequest() {
        log("Test request: getting information about users 1, 5, 6");
        VK.with(getActivity()).exec(Users.get(1, 5, 6), new VK.SimpleCallback<VKList<VKUser>>() {
            @Override
            public void onAdded(VK vk) {
                log("Test request: added");
            }

            @Override
            public void onPreExecute(VK vk) {
                log("Test request: onPreExecute");
            }

            @Override
            public void onSuccess(VK vk, VKList<VKUser> data) {
                log("Test request: onSuccess, result: " + TextUtils.join(", ", data));
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("Test request: onError, error: " + e.getLocalizedMessage(getResources()));
            }

            @Override
            public void onPostExecute(VK vk) {
                log("Test request: onPostExecute");
            }
        });
    }

    private void runRequestBatch() {
        log("RequestBatch will join two requests: users.get{1,6} and users.get{14,17}");

        RequestsBatch batch = new RequestsBatch();
        batch.add(new Users.get(1, 6), new VK.SimpleCallback<VKList<VKUser>>() {
            @Override
            public void onAdded(VK vk) {
                log("Request batch, request 1: added");
            }

            @Override
            public void onPreExecute(VK vk) {
                log("Request batch, request 1: onPreExecute");
            }

            @Override
            public void onSuccess(VK vk, VKList<VKUser> data) {
                log("Request batch, request 1: onSuccess, result: " + TextUtils.join(", ", data));
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("Request batch, request 1, error: " + e.getLocalizedMessage(getResources()));
            }

            @Override
            public void onPostExecute(VK vk) {
                log("Request batch, request 1: onPostExecute");
            }
        });

        batch.add(new Users.get(14, 17), new VK.SimpleCallback<VKList<VKUser>>() {
            @Override
            public void onAdded(VK vk) {
                log("Request batch, request 2: added");
            }

            @Override
            public void onPreExecute(VK vk) {
                log("Request batch, request 2: onPreExecute");
            }

            @Override
            public void onSuccess(VK vk, VKList<VKUser> data) {
                log("Request batch, request 2: onSuccess, result: " + TextUtils.join(", ", data));
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("Request batch, request 2, error: " + e.getLocalizedMessage(getResources()));
            }

            @Override
            public void onPostExecute(VK vk) {
                log("Request batch, request 2: onPostExecute");
            }
        });

        VK.with(getActivity()).exec(batch);
    }

    private void runExecuteBuilder() {
        log("ExecuteBuilder will join two requests: users.get{1,6} and users.get{14,17}");

        ExecuteBuilder builder = new ExecuteBuilder();
        builder.add(new Users.get(1, 6), new VK.SimpleCallback<VKList<VKUser>>() {
            @Override
            public void onAdded(VK vk) {
                log("ExecuteBuilder, request 1: added");
            }

            @Override
            public void onPreExecute(VK vk) {
                log("ExecuteBuilder, request 1: onPreExecute");
            }

            @Override
            public void onSuccess(VK vk, VKList<VKUser> data) {
                log("ExecuteBuilder, request 1: onSuccess, result: " + TextUtils.join(", ", data));
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("ExecuteBuilder, request 1, error: " + e.getLocalizedMessage(getResources()));
            }

            @Override
            public void onPostExecute(VK vk) {
                log("ExecuteBuilder, request 1: onPostExecute");
            }
        });

        builder.add(new Users.get(14, 17), new VK.SimpleCallback<VKList<VKUser>>() {
            @Override
            public void onAdded(VK vk) {
                log("ExecuteBuilder, request 2: added");
            }

            @Override
            public void onPreExecute(VK vk) {
                log("ExecuteBuilder, request 2: onPreExecute");
            }

            @Override
            public void onSuccess(VK vk, VKList<VKUser> data) {
                log("ExecuteBuilder, request 2: onSuccess, result: " + TextUtils.join(", ", data));
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("ExecuteBuilder, request 2, error: " + e.getLocalizedMessage(getResources()));
            }

            @Override
            public void onPostExecute(VK vk) {
                log("ExecuteBuilder, request 2: onPostExecute");
            }
        });

        VK.with(getActivity()).exec(builder);
    }

    private void runActivityRecreationRequest() {
        log("ActivityRecreationRequest: getting information about users 1, 5, 6, code is" + REQUEST_TEST_CODE);
        VK.with(getActivity()).exec(new getUsers(1, 5, 6), new VK.ReceiverCallback<VKList<VKUser>>(TestReceiverCallback.class, REQUEST_TEST_CODE));
    }

    private VK.ScheduledCallback<VKList<VKUser>> scheduledCallback;

    private void runScheduledRequest() {
        log("ScheduledRequest: getting information about users 1, 5, 6, with period in 5 seconds");

        Users.get request = Users.get(1, 5, 6);

        scheduledCallback = new VK.ScheduledCallback<VKList<VKUser>>(request, new VK.SimpleCallback<VKList<VKUser>>() {
            @Override
            public void onAdded(VK vk) {
                log("ScheduledRequest: added");
            }

            @Override
            public void onPreExecute(VK vk) {
                log("ScheduledRequest: onPreExecute");
            }

            @Override
            public void onSuccess(VK vk, VKList<VKUser> data) {
                log("ScheduledRequest: onSuccess, result: " + TextUtils.join(", ", data));
            }

            @Override
            public void onError(VK vk, VKException e) {
                log("ScheduledRequest: onError, error: " + e.getLocalizedMessage(getResources()));
            }

            @Override
            public void onPostExecute(VK vk) {
                log("ScheduledRequest: onPostExecute");
            }
        }, 5000L);

        VK.with(getActivity()).exec(request, scheduledCallback);
    }

    private void cancelScheduledRequest() {
        log("ScheduledRequest: canceled");
        if(scheduledCallback != null) {
            scheduledCallback.cancel();
        }

    }

    private class TestReceiverCallback extends VK.Receiver<VKList<VKUser>> {

        @Override
        public void onAdded(VK vk, int code) {
            setRetainInstance(false);
            log("ActivityRecreationRequest: added, code="+ code);
        }

        @Override
        public void onPreExecute(VK vk, int code) {
            log("ActivityRecreationRequest: onPostExecute, code="+ code);
        }

        @Override
        public void onSuccess(VK vk, int code, VKList<VKUser> data) {
            log("ActivityRecreationRequest: onSuccess, code=" + code + ", result: " + TextUtils.join(", ", data));
        }

        @Override
        public void onError(VK vk, int code, VKException e) {
            log("ActivityRecreationRequest: onError, code=" + code + ", error: " + e.getLocalizedMessage(getResources()));
        }

        @Override
        public void onPostExecute(VK vk, int code) {
            setRetainInstance(true);
            log("ActivityRecreationRequest: onPostExecute, code="+ code);
        }

    }

    // lets add some delay to user has a time to rotate device
    private static class getUsers extends Users.get {
        public getUsers(int... user_ids) {
            super(user_ids);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
