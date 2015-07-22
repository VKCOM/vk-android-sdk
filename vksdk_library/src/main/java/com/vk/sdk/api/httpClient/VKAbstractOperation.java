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

import java.util.concurrent.ExecutorService;

/**
 * Class for executing any kind of asynchronous operation
 */
public abstract class VKAbstractOperation {

    public enum VKOperationState {
        Created,
        Ready,
        Executing,
        Paused,
        Finished,
        Canceled
    }

    /**
     * Listener called after operation finished
     */
    private VKOperationCompleteListener mCompleteListener;
    /**
     * Current operation state. Checked by stateTransitionIsValid function
     */
    private VKOperationState mState = VKOperationState.Created;
    /**
     * Flag for cancel
     */
    private boolean mCanceled = false;

    public VKAbstractOperation() {
        setState(VKOperationState.Ready);
    }

    @Nullable
    private ExecutorService mResponseQueue;

    /**
     * Entry point for operation
     */
    public void start(ExecutorService responseQueue) {
        mResponseQueue = responseQueue;
    }

    /**
     * Cancels current operation and finishes it
     */
    public void cancel() {
        mCanceled = true;
        setState(VKOperationState.Canceled);
    }

    /**
     * Finishes current operation. Will call onVkShareComplete() function for completeListener
     */
    public void finish() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (mCompleteListener != null) {
                    mCompleteListener.onComplete();
                }
            }
        };
        if (mResponseQueue != null) {
            mResponseQueue.submit(r);
        } else {
            r.run();
        }
    }

    public abstract Object getResultObject();

    /**
     * Set complete listener for current operation
     *
     * @param listener Complete listener
     */
    protected void setCompleteListener(VKOperationCompleteListener listener) {
        mCompleteListener = listener;
    }

    /**
     * Returns current operation state
     *
     * @return state constant from {@link VKOperationState}
     */
    protected VKOperationState state() {
        return mState;
    }

    /**
     * Sets operation state. Checks validity of state transition
     *
     * @param state New operation state
     */
    protected void setState(VKOperationState state) {
        if (isStateTransitionInvalid(mState, state, mCanceled)) {
            return;
        }
        mState = state;
        if (mState == VKOperationState.Finished ||
                mState == VKOperationState.Canceled) {
            finish();
        }
    }

    /**
     * Checks validity of state transition
     *
     * @param fromState   Old state (current operation state)
     * @param toState     New state, sets by developer
     * @param isCancelled Flag of cancelation
     * @return Result of validation
     */
    private boolean isStateTransitionInvalid(VKOperationState fromState, VKOperationState toState,
                                             boolean isCancelled) {
        switch (fromState) {
            case Ready:
                switch (toState) {
                    case Paused:
                    case Executing:
                    case Canceled:
                        return false;
                    case Finished:
                        return !isCancelled;

                    default:
                        return true;
                }

            case Executing:
                switch (toState) {
                    case Paused:
                    case Finished:
                    case Canceled:
                        return false;

                    default:
                        return true;
                }

            case Finished:
            case Canceled:
                return true;

            case Paused:
                switch (toState) {
                    case Canceled:
                        return false;
                    default:
                        return toState != VKOperationState.Ready;
                }

            default:
                return false;
        }
    }

    public interface VKOperationCompleteListener {
        void onComplete();
    }

    public static abstract class VKAbstractCompleteListener<OperationType extends VKAbstractOperation, ResponseType extends Object> {
        public abstract void onComplete(OperationType operation, ResponseType response);

        public abstract void onError(OperationType operation, VKError error);
    }
}
