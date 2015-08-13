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

import com.vk.sdk.VKSdk;
import com.vk.sdk.api.httpClient.VKAbstractOperation;
import com.vk.sdk.api.httpClient.VKHttpClient;
import com.vk.sdk.api.httpClient.VKJsonOperation;
import com.vk.sdk.api.httpClient.VKJsonOperation.VKJSONOperationCompleteListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutorService;

/**
 * Base class for upload files to server
 */
public abstract class VKUploadBase extends VKRequest {

    protected abstract VKRequest getServerRequest();

    protected abstract VKRequest getSaveRequest(JSONObject response);

    protected abstract VKJsonOperation getUploadOperation(String uploadUrl);

    public VKUploadBase() {
        super(null);
    }

    @Override
    public VKAbstractOperation getOperation() {
        return new VKUploadOperation();
    }

    private class VKUploadOperation extends VKAbstractOperation {

        protected VKAbstractOperation lastOperation;

        @Override
        public void start(ExecutorService s) {
            super.start(s);
            final VKRequestListener originalListener = VKUploadBase.this.requestListener;

            VKUploadBase.this.requestListener = new VKRequestListener() {
                @Override
                public void onComplete(VKResponse response) {
                    setState(VKOperationState.Finished);
                    response.request = VKUploadBase.this;
                    if (originalListener != null) {
                        originalListener.onComplete(response);
                    }
                }

                @Override
                public void onError(VKError error) {
                    setState(VKOperationState.Finished);
                    error.request = VKUploadBase.this;
                    if (originalListener != null) {
                        originalListener.onError(error);
                    }
                }

                @Override
                public void onProgress(VKProgressType progressType, long bytesLoaded,
                                       long bytesTotal) {
                    if (originalListener != null) {
                        originalListener.onProgress(progressType, bytesLoaded, bytesTotal);
                    }
                }
            };
            setState(VKOperationState.Executing);
            VKRequest serverRequest = getServerRequest();
            serverRequest.setRequestListener(new VKUploadRequestListener());
            lastOperation = serverRequest.getOperation();
            VKHttpClient.enqueueOperation(lastOperation);
        }

        @Override
        public void cancel() {
            if (lastOperation != null)
                lastOperation.cancel();
            super.cancel();
        }

        @Override
        public void finish() {
            super.finish();
            lastOperation = null;
        }

        @Override
        public Object getResultObject() {
            return null;
        }

        private class VKUploadRequestListener extends VKRequestListener {
            @Override
            public void onComplete(VKResponse response) {
                try {
                    String uploadUrl = response.json.getJSONObject("response").getString("upload_url");
                    VKJsonOperation postFileRequest = getUploadOperation(uploadUrl);
                    postFileRequest.setHttpOperationListener(new VKJSONOperationCompleteListener() {
                        @Override
                        public void onComplete(VKJsonOperation operation,
                                               JSONObject response) {

                            VKRequest saveRequest = getSaveRequest(response);
                            saveRequest.setRequestListener(new VKRequestListener() {
                                @Override
                                public void onComplete(VKResponse response) {
                                    if (requestListener != null) {
                                        requestListener.onComplete(response);
                                    }
                                    setState(VKOperationState.Finished);
                                }

                                @Override
                                public void onError(VKError error) {
                                    if (requestListener != null) {
                                        requestListener.onError(error);
                                    }
                                }
                            });
                            lastOperation = saveRequest.getOperation();
                            VKHttpClient.enqueueOperation(lastOperation);
                        }

                        @Override
                        public void onError(VKJsonOperation operation, VKError error) {
                            if (requestListener != null) {
                                requestListener.onError(error);
                            }
                        }
                    });

                    lastOperation = postFileRequest;
                    VKHttpClient.enqueueOperation(lastOperation);
                } catch (JSONException e) {
                    if (VKSdk.DEBUG)
                        e.printStackTrace();
                    VKError error = new VKError(VKError.VK_JSON_FAILED);
                    error.httpError = e;
                    error.errorMessage = e.getMessage();
                    if (requestListener != null) {
                        requestListener.onError(error);
                    }
                }
            }

            @Override
            public void onError(VKError error) {
                if (requestListener != null)
                    requestListener.onError(error);
            }
        }
    }
}
