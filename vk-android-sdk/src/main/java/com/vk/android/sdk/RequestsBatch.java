/**
 * RequestsBatch.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 16.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk;

import android.util.Pair;
import com.vk.android.sdk.exceptions.VKException;
import com.vk.android.sdk.models.VKModel;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Allow to join a few request to execute them successively.
 */
public final class RequestsBatch {

    private Queue<Pair<RESTRequest, VK.Callback>> mQueue = new LinkedList<Pair<RESTRequest, VK.Callback>>();

    /**
     * Appends request to the batch.
     * @param request request to append
     * @param callback callback to take results of request.
     * @param <T> type of result
     * @return this batch
     */
    public <T> RequestsBatch add(RESTRequest<T> request, VK.Callback<T> callback) {
        mQueue.add(new Pair<RESTRequest, VK.Callback>(request, new CallbackWrapper<T>(callback)));
        return this;
    }

    void exec(RequestQueue queue) {
        if(mQueue.size() > 0) {
            Pair<RESTRequest,VK.Callback> pair = mQueue.remove();
            if(pair != null) {
                queue.exec(pair.first, pair.second);
            }
        }
    }

    private final class CallbackWrapper<T> implements VK.Callback<T> {

        private final VK.Callback<T> mWrapped;

        CallbackWrapper(VK.Callback<T> callback){
            mWrapped = callback;
        }

        @Override
        public void onAdded(VK vk) {
            mWrapped.onAdded(vk);
        }

        @Override
        public void onPreExecute(VK vk) {
            mWrapped.onPreExecute(vk);
        }

        @Override
        public void onSuccess(VK vk, T data) {
            mWrapped.onSuccess(vk, data);
        }

        @Override
        public void onError(VK vk, VKException e) {
            mWrapped.onError(vk, e);
        }

        @Override
        public void onPostExecute(VK vk) {
            mWrapped.onPostExecute(vk);
            exec(vk.mQueue);
        }

        @Override
        public void onUploadProgress(VK vk, int file, int progress) {
            mWrapped.onUploadProgress(vk, file, progress);
        }
    }

}
