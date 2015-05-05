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

package com.vk.sdk.api;

import android.os.Handler;
import android.os.Looper;

import com.vk.sdk.VKObject;
import com.vk.sdk.api.httpClient.VKHttpClient;

/**
 * Used for execution bunch of methods at time, and receive results of that methods in array
 */
public class VKBatchRequest extends VKObject {
    private final VKRequest[] mRequests;
    private final VKResponse[] mResponses;
    private final VKRequest.VKRequestListener[] mOriginalListeners;
    private boolean mCanceled = false;

    /**
     * Specify listener for current request
     */
    public VKBatchRequestListener requestListener;

    public VKBatchRequest(VKRequest... requests) {
        mRequests = requests;
        mResponses = new VKResponse[mRequests.length];
        mOriginalListeners = new VKRequest.VKRequestListener[mRequests.length];
        for (int i = 0; i < mRequests.length; i++) {
            mOriginalListeners[i] = mRequests[i].requestListener;
        }
    }

    /**
     * Start new batch execution. At this moment a batch simply sends all requests with interval
     * @param listener {@link com.vk.sdk.api.VKBatchRequest.VKBatchRequestListener}
     */
    public void executeWithListener(VKBatchRequestListener listener) {
        if (mRequests == null) {
            provideError(new VKError(VKError.VK_REQUEST_NOT_PREPARED));
            return;
        }
        this.requestListener = listener;
        Handler intervalHandler = new Handler(Looper.myLooper());

        int nextInterval = 0;
        for (final VKRequest request : mRequests) {
            intervalHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    final VKRequest.VKRequestListener originalListener = request.requestListener;
                    request.setRequestListener(new VKRequest.VKRequestListener() {
                        @Override
                        public void onComplete(VKResponse response) {
                            provideResponse(response);
                        }

                        @Override
                        public void onError(VKError error) {
                            provideError(error);
                        }

                        @Override
                        public void onProgress(VKRequest.VKProgressType progressType, long bytesLoaded, long bytesTotal) {
                            if (originalListener != null) {
                                originalListener.onProgress(progressType, bytesLoaded, bytesTotal);
                            }
                        }
                    });
                    VKHttpClient.enqueueOperation(request.getOperation());
                }
            }, nextInterval);

            nextInterval += 1000 / 3;
        }
    }

    /**
     * Cancel current batch request
     */
    public void cancel() {
        if (mCanceled) return;
        mCanceled = true;
        for (VKRequest request : mRequests)
            request.cancel();

    }

    protected void provideResponse(VKResponse response) {
        mResponses[indexOfRequest(response.request)] = response;
        for (VKResponse resp : mResponses) {
            if (resp == null) return;
        }
        for (int i = 0; i < mRequests.length; i++) {
            VKRequest.VKRequestListener l = mOriginalListeners[i];
            if (l != null) {
                l.onComplete(mResponses[i]);
            }
        }

        if (requestListener != null) {
            requestListener.onComplete(mResponses);
        }
    }

    private int indexOfRequest(VKRequest request) {
        for (int i = 0; i < mRequests.length; i++)
            if (mRequests[i].equals(request)) return i;
        return -1;
    }

    protected void provideError(VKError error) {
        if (mCanceled)
            return;
        for (int i = 0; i < mRequests.length; i++) {
            VKRequest.VKRequestListener l = mOriginalListeners[i];
            if (l != null) {
                l.onError(error);
            }
        }
        if (requestListener != null)
            requestListener.onError(error);
        cancel();
    }

    /**
     * Extend listeners for requests from that class
     */
    public static abstract class VKBatchRequestListener {
        /**
         * Called if there were no HTTP or API errors, returns execution result.
         *
         * @param responses responses from VKRequests in passing order of construction
         */
        public void onComplete(VKResponse[] responses) {
        }

        /**
         * Called immediately if there was API error, or after <b>attempts</b> tries if there was an HTTP error
         *
         * @param error error for VKRequest
         */
        public void onError(VKError error) {
        }
    }
}
