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

package com.vk.sdk.api.httpClient;

import android.support.annotation.Nullable;

import com.vk.sdk.api.VKError;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;

/**
 * Class for loading any data by HTTP request
 */
public class VKHttpOperation<ResponseType> extends VKAbstractOperation {
    /**
     * Request initialized this object
     */
    private final VKHttpClient.VKHTTPRequest mUriRequest;
    /**
     * Last exception throws while loading or parsing
     */
    protected Exception mLastException;

    /**
     * Response data from server
     */
    @Nullable
    public VKHttpClient.VKHttpResponse response;

    /**
     * String representation of response
     */
    private String mResponseString;

    /**
     * Create new operation for loading prepared Http request. Requests may be prepared in VKHttpClient
     *
     * @param uriRequest Prepared request
     */
    public VKHttpOperation(VKHttpClient.VKHTTPRequest uriRequest) {
        mUriRequest = uriRequest;
    }


    /**
     * Start current prepared http-operation for result
     */
    @Override
    public void start(ExecutorService s) {
        super.start(s);
        setState(VKOperationState.Executing);
        try {
            if (this.mUriRequest.isAborted) {
                return;
            }
            response = VKHttpClient.execute(mUriRequest);

        } catch (IOException e) {
            mLastException = e;
        }
        setState(VKOperationState.Finished);
    }

    @Override
    public void finish() {
        postExecution();
        super.finish();
    }

    @Override
    public ResponseType getResultObject() {
        return response != null ? (ResponseType) response.responseBytes : null;
    }

    /**
     * Calls before providing result, but after response loads
     *
     * @return true is post execution succeed
     */
    protected boolean postExecution() {
        return true;
    }

    /**
     * Cancel current operation execution
     */
    @Override
    public void cancel() {
        VKHttpClient.cancelHttpOperation(this);
        super.cancel();
    }

    /**
     * Returns request associated with current operation
     *
     * @return URI request
     */
    public VKHttpClient.VKHTTPRequest getUriRequest() {
        return mUriRequest;
    }

    /**
     * Get operation response data
     *
     * @return Bytes of response
     */
    public byte[] getResponseData() {
        return response != null ? response.responseBytes : null;
    }

    /**
     * Get operation response string, if possible
     *
     * @return Encoded string from response data bytes
     */
    public String getResponseString() {
        if (response == null || response.responseBytes == null) {
            return null;
        }
        if (mResponseString == null) {
            try {
                mResponseString = new String(response.responseBytes, VKHttpClient.sDefaultStringEncoding);
            } catch (UnsupportedEncodingException e) {
                mLastException = e;
            }
        }
        return mResponseString;
    }

    /**
     * Generates VKError about that request fails
     *
     * @param e Exception for error
     * @return New generated error
     */
    protected VKError generateError(Exception e) {
        VKError error;
        if (state() == VKOperationState.Canceled) {
            error = new VKError(VKError.VK_CANCELED);
        } else {
            error = new VKError(VKError.VK_REQUEST_HTTP_FAILED);
        }
        if (e != null) {
            error.errorMessage = e.getMessage();
            if (error.errorMessage == null)
                error.errorMessage = e.toString();
            error.httpError = e;
        }
        return error;
    }


    /**
     * Set listener for current operation
     *
     * @param listener Listener subclasses VKHTTPOperationCompleteListener
     */
    public <OperationType extends VKHttpOperation> void setHttpOperationListener(final VKAbstractCompleteListener<OperationType, ResponseType> listener) {
        this.setCompleteListener(new VKOperationCompleteListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void onComplete() {
                if (VKHttpOperation.this.state() != VKOperationState.Finished || mLastException != null) {
                    listener.onError((OperationType) VKHttpOperation.this, generateError(mLastException));
                } else {
                    listener.onComplete((OperationType) VKHttpOperation.this, getResultObject());
                }
            }
        });
    }
}