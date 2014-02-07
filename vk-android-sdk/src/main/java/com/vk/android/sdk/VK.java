/**
 * VK.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 06.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk;

import android.app.Activity;
import android.content.*;
import android.os.Parcelable;
import android.text.TextUtils;
import com.vk.android.sdk.exceptions.*;
import com.vk.android.sdk.models.VKAccessToken;
import org.json.JSONException;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.CancellationException;

/**
 * Handles and represents all VK interface generally.
 */
@SuppressWarnings("unused")
public final class VK {

    /**
     * Name for account extra for authorization.
     */
    public final static String EXTRA_ACCOUNT = "com.vk.android.extra.account";

    /**
     * Name for error extra for authorization.
     */
    public final static String EXTRA_ERROR = "com.vk.android.extra.error";

    /**
     * Name for error reason extra for authorization.
     */
    public final static String EXTRA_ERROR_REASON = "com.vk.android.extra.error_reason";

    /**
     * Name for error description extra for authorization.
     */
    public final static String EXTRA_ERROR_DESCRIPTION = "com.vk.android.extra.error_description";

    private static VK sInstance;

    final Settings mSettings = Settings.get();
    final RequestQueue mQueue;
    final Context mContext;

    private VK(Context context) {
        if(context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        mContext = context.getApplicationContext();
        mQueue = new RequestQueue(this);
    }

    /**
     * Return an instance of VK
     */
    public static VK with(Context context) {
        if(sInstance == null) {
            sInstance = new VK(context);
        }
        return sInstance;
    }

    /***********************************************************************
     *                        EXECUTORS DELEGATE
     ***********************************************************************/

    /**
     * Executes request asynchronously with delay.
     * @param request request to execute
     * @param callback callback to handle result, state changes or errors
     * @param delay delay before sending the request in milliseconds
     * @param <T> type of the request result
     */
    public <T> void exec(RESTRequest<T> request, Callback<T> callback, long delay) {
        mQueue.exec(request, callback, delay);
    }

    /**
     * Executes request asynchronously.
     * @param request request to execute
     * @param callback callback to handle result, state changes or errors
     * @param <T> type of the request result
     */
    public <T> void exec(RESTRequest<T> request, Callback<T> callback) {
        mQueue.exec(request, callback);
    }

    /**
     * Executes codeblock asynchronously with delay.
     * <B>Note</B>: Codeblock are not allows you to handle UI errors.
     * @param codeblock codeblock to execute
     * @param callback callback to handle result, state changes or errors
     * @param delay delay before sending the request in milliseconds
     * @param <T> type of the request result
     */
    public <T> void exec(Codeblock<T> codeblock, Callback<T> callback, long delay) {
        mQueue.exec(codeblock, callback, delay);
    }

    /**
     * Executes codeblock asynchronously.
     * <B>Note</B>: Codeblock are not allows you to handle UI errors.
     * @param codeblock codeblock to exec
     * @param callback callback to handle result, state changes or errors
     * @param <T> type of the request result
     */
    public <T> void exec(Codeblock<T> codeblock, Callback<T> callback) {
        mQueue.exec(codeblock, callback);
    }

    /**
     * Executes {@link RequestsBatch} asynchronously.
     * @param batch RequestsBatch to execute.
     */
    public void exec(RequestsBatch batch) {
        mQueue.exec(batch);
    }

    /**
     * Executes {@link ExecuteBuilder} asynchronously.
     * <B>Note</B>: ExecuteBuilder are not allows you to handle UI errors.
     * @param builder ExecuteBuilder to execute.
     */
    public void exec(ExecuteBuilder builder) {
        mQueue.exec(builder);
    }

    /***********************************************************************
     *                        GETTERS AND SETTERS
     ***********************************************************************/

    /**
     * Authorizes whole VK system with given account.
     * @param account account to authorize.
     */
    public void authorize(VKAccessToken account) {
        mSettings.authorize(account);
    }

    /**
     * Returns SDK's authorization status.
     * @return true if VK is authorized, false otherwise
     */
    public boolean isAuthorized() {
        return mSettings.isAuthorized();
    }

    /**
     * Returns SDK's authorization account.
     * @return an account using for authorize requests, null if VK is not authorized.
     */
    public VKAccessToken getAccount() {
        return mSettings.getAccount();
    }

    /**
     * Returns number of attempts to repeat establish a connection for requests.
     * @return number of attempts to repeat establish a connection if network errors occurs.
     */
    public int getAttemptsCount() {
        return mSettings.getAttempts();
    }

    /**
     * Returns SDK's UI interruption status.
     * @return true if VK can show windows and dialogs if necessary, false if UI errors will be transferred to callback.
     */
    public boolean interruptUIIfNecessary() {
        return mSettings.interruptUIIfNecessary();
    }

    /**
     * Sets policy of UI interrupting.
     * Sometimes VK server can return the error which requires processing by user.
     * For example, captcha error.
     *
     * This param sets policy of such errors: if it's true, all UI errors will be handles
     * and shown in dialog boxes, otherwise errors will be transferred to callback.
     */
    public void setInterruptionEnabled(boolean interruptionEnabled) {
        mSettings.setInterruptionEnabled(interruptionEnabled);
    }

    /**
     * Returns SDK's HTTPs policy status.
     * @return if you prefer to send all requests through {@code HTTPs}, false otherwise
     */
    public boolean isHttpsEnabled() {
        return mSettings.isHttpsEnabled();
    }

    /**
     * Returns user's sets "Always use HTTPS" setting in his profile status.
     * @return true if user sets "Always use HTTPS" setting in his profile, false otherwise.
     */
    public boolean isHttpsRequired() {
        return mSettings.ismHttpsRequired();
    }

    /**
     * Sets number of attempts to repeat establish a connection if network errors occurs.
     */
    public void setAttemptsCount(int attempts) {
        mSettings.setAttempts(attempts);
    }

    /**
     * Sets policy of using HTTPS.
     *
     * If it's true, all request will be sent using https.
     * If it's false, all request will prefer to send via HTTP.
     * However, request can be sent via HTTP if user sets
     * "Always use HTTPS" setting in his profile.
     *
     * <b>Note</b>: you should require authorization via {@link com.vk.android.sdk.models.VKScopes#NOHTTPS} scope
     * if you want to send request via HTTP.
     */
    public void setHttpsEnabled(boolean httpsEnabled) {
        mSettings.setHttpsEnabled(httpsEnabled);
    }

    /**
     * Opens authorization dialog.
     * Result will became via {@link Activity#onActivityResult(int, int, android.content.Intent)} with {@link #EXTRA_ACCOUNT} key.
     * @param host activity to show dialog and handles the result.
     * @param appId application id th authorize
     * @param requestCode code that result back to the Activity
     * @param scopes scopes to access user data.
     */
    public void requestAuthorisation(Activity host, int appId, boolean forceOauth, int requestCode, String... scopes) {
        VKActivity.showAuth(host, appId, forceOauth, TextUtils.join(",", scopes), requestCode);
    }

    public void requestAuthorisation(Activity host, int appId, int requestCode, String... scopes) {
        VKActivity.showAuth(host, appId, false, TextUtils.join(",", scopes), requestCode);
    }

    /**
     * Callback for requests.
     * Each method invoked in UI thread.
     * @param <T> type of request result.
     */
    public static interface Callback<T> {

        /**
         * Called when request is added fo requests queue.
         */
        void onAdded(VK vk);

        /**
         * Called before the request has been executed.
         */
        void onPreExecute(VK vk);

        /**
         * Called if request was successful and without errors.
         * @param data result of this response.
         */
        void onSuccess(VK vk, T data);

        /**
         * Called if the server returned an error code.
         * @param e server's error exception.
         */
        void onError(VK vk, VKException e);

        /**
         * Called after the request has been executed.
         */
        void onPostExecute(VK vk);

        /**
         * Called where request is uploads files.
         * @param file number of file since 0
         * @param progress percentage of current file, number between [0, 100]
         */
        void onUploadProgress(VK vk, int file, int progress);

    }

    /**
     * Codeblock allows you to execute unlimited requests in one block asynchronously and successively. <br />
     * <B>Note</B>: Codeblock are not processes captcha errors automatically.
     * @param <T> type of request result.
     */
    public static abstract class Codeblock<T> {

        boolean mCanceled;
        RESTRequest.UploadCallback mUploader;

        /**
         * Executes the codeblock in accordance with the life cycle in the current thread.
         * @return parsed and checked the server's response.
         * @throws com.vk.android.sdk.exceptions.VKServerException if server returned error
         * @throws com.vk.android.sdk.exceptions.VKCaptchaException if server requires to enter captcha
         * @throws com.vk.android.sdk.exceptions.VKValidationException if server requires validation procedure
         * @throws com.vk.android.sdk.exceptions.VKAuthException if token has expired or closed method invoked without token
         * @throws IOException if network error occurs
         * @throws JSONException if server response unable to parse
         * @throws CancellationException if codeblock was canceled during its execution
         */
        public abstract T run() throws VKServerException, VKCaptchaException, VKValidationException, VKAuthException, IOException, JSONException, CancellationException;

        /**
         * If this method returns true, and same preference is enabled is
         * VK, the application can be interrupted by some VK server errors to
         * user can resolve them.
         *
         * For example, validation process, re-authorization.
         *
         * If this method return false or same preference is disabled is
         * VK, the exception will be sent to callback like any other server exception.
         *
         * @return true if this method allows UI interruption, false otherwise.
         */
        public boolean interruptUIIfNecessary() {
            return true;
        }

        /**
         * Cancels this codeblock.
         * If codeblock is canceled, it will never be executed to dispatched to callback.
         * Does not work, if the codeblock is already executed ​​or dispatched.
         * This action cannot be undone.
         */
        public void cancel() {
            mCanceled = true;
        }

        /**
         * @return upload callback to set it into mail upload request in {@link #run()}
         */
        public RESTRequest.UploadCallback getUploadCallback() {
            return mUploader;
        }
    }

    /**
     * Can be used for override some methods instead of all.
     * @param <T> type of request result.
     */
    public static class SimpleCallback<T> implements Callback<T> {

        @Override
        public void onAdded(VK vk) {

        }

        @Override
        public void onPreExecute(VK vk) {

        }

        @Override
        public void onSuccess(VK vk, T data) {

        }

        @Override
        public void onError(VK vk, VKException e) {

        }

        @Override
        public void onPostExecute(VK vk) {

        }

        @Override
        public void onUploadProgress(VK vk, int file, int progress) {

        }
    }

    /**
     * This callback will be useful if host {@link Activity} can be recreated during the process.
     * All events will be sent to given Receiver class.
     * @param <T> type of request result. Must support {@link android.os.Parcelable} or {@link java.io.Serializable} interfaces.
     */
    public static class ReceiverCallback<T> implements Callback<T> {

        private final String mClazz;
        private final int mCode;

        /**
         * Creates new Receiver callback
         * @param receiver receiver class to handle events.
         * @param requestCode unique code to identify requests.
         */
        public ReceiverCallback(Class<? extends Receiver<T>> receiver, int requestCode) {
            mClazz = receiver.getCanonicalName();
            mCode = requestCode;
        }

        @Override
        public final void onAdded(VK vk) {
            Intent intent = new Intent();
            intent.setAction(Receiver.ACTION_ADD);
            intent.putExtra(Receiver.EXTRA_TARGET, mClazz);
            intent.putExtra(Receiver.EXTRA_CODE, mCode);
            vk.mContext.sendBroadcast(intent);
        }

        @Override
        public final void onPreExecute(VK vk) {
            Intent intent = new Intent();
            intent.setAction(Receiver.ACTION_PRE_EXECUTE);
            intent.putExtra(Receiver.EXTRA_TARGET, mClazz);
            intent.putExtra(Receiver.EXTRA_CODE, mCode);
            vk.mContext.sendBroadcast(intent);
        }

        @Override
        public final void onSuccess(VK vk, T data) {
            Intent intent = new Intent();
            intent.setAction(Receiver.ACTION_SUCCESS);
            if(data instanceof Parcelable) {
                intent.putExtra(Receiver.EXTRA_RESULT, (Parcelable) data);
            } else if(data instanceof Serializable) {
                intent.putExtra(Receiver.EXTRA_RESULT, (Serializable) data);
            } else {
                throw new IllegalArgumentException("Parameter <T> in the ReceiverCallback must implement Parcelable or Serializable");
            }
            intent.putExtra(Receiver.EXTRA_TARGET, mClazz);
            intent.putExtra(Receiver.EXTRA_CODE, mCode);
            vk.mContext.sendBroadcast(intent);
        }

        @Override
        public final void onError(VK vk, VKException e) {
            Intent intent = new Intent();
            intent.setAction(Receiver.ACTION_ERROR);
            intent.putExtra(Receiver.EXTRA_ERROR, e);
            intent.putExtra(Receiver.EXTRA_TARGET, mClazz);
            intent.putExtra(Receiver.EXTRA_CODE, mCode);
            vk.mContext.sendBroadcast(intent);
        }

        @Override
        public final void onPostExecute(VK vk) {
            Intent intent = new Intent();
            intent.setAction(Receiver.ACTION_POST_EXECUTE);
            intent.putExtra(Receiver.EXTRA_CODE, mCode);
            intent.putExtra(Receiver.EXTRA_TARGET, mClazz);
            vk.mContext.sendBroadcast(intent);
        }

        @Override
        public void onUploadProgress(VK vk, int file, int progress) {
            Intent intent = new Intent();
            intent.setAction(Receiver.ACTION_PROGRESS);
            intent.putExtra(Receiver.EXTRA_CODE, mCode);
            intent.putExtra(Receiver.EXTRA_FILE, file);
            intent.putExtra(Receiver.EXTRA_PERCENT, progress);
            vk.mContext.sendBroadcast(intent);
        }
    }

    /**
     * This callback allow you to send the same request with given period. <br />
     * <b>Note</b>: if you cancels this callback, you'll should not use it again.
     * @param <T>  type of request result.
     */
    public final static class ScheduledCallback<T> implements Callback<T> {

        private final Callback<T> mCallback;
        private boolean mCanceled;
        private long mPeriod;
        private RESTRequest<T> mRequest;

        public ScheduledCallback(RESTRequest<T> request, Callback<T> wrapped, long period) {
            mRequest = request;
            mCallback = wrapped;
            mPeriod = period;
        }

        @Override
        public void onAdded(VK vk) {
            if(mCanceled) {
                throw new IllegalStateException("ScheduledCallback was canceled. Please use a new instance instead of this");
            }
            mCallback.onAdded(vk);
        }

        @Override
        public void onPostExecute(VK vk) {
            if(!mCanceled) {
                vk.exec(mRequest, this, mPeriod);
            }
            mCallback.onPostExecute(vk);
        }

        @Override
        public void onUploadProgress(VK vk, int file, int progress) {
            mCallback.onUploadProgress(vk ,file, progress);
        }

        @Override
        public void onPreExecute(VK vk) {
            mCallback.onPreExecute(vk);
        }

        public void onSuccess(VK vk, T data) {
            mCallback.onSuccess(vk, data);
        }

        @Override
        public void onError(VK vk, VKException e) {
            mCallback.onError(vk, e);
        }

        /**
         * Cancels current request and callback. <br />
         * <b>Note</b>: if you cancels this callback, you'll should not use it again.
         */
        public void cancel() {
            mCanceled = true;
            mRequest.cancel();
        }
    }

    /**
     * This receiver will receive all requests events, errors and results if
     * host {@link android.app.Activity} can be
     * recreated during the process.
     *
     * You should create a child of this class in your {@link android.app.Activity} or {@link android.app.Fragment},
     * and register its instance on {@code onStart()} and {@code onStop()} methods.
     * Then you can run requests using {@link ReceiverCallback}.
     *
     * @param <T> <T> type of request result. Must support {@link android.os.Parcelable} or {@link java.io.Serializable} interfaces.
     */
    public static class Receiver<T> extends android.content.BroadcastReceiver {

        final static String EXTRA_CODE = "com.vk.android.extra.code";
        final static String EXTRA_ERROR = "com.vk.android.extra.error";
        final static String EXTRA_FILE = "com.vk.android.extra.file";
        final static String EXTRA_PERCENT = "com.vk.android.extra.percent";
        final static String EXTRA_RESULT = "com.vk.android.extra.result";
        final static String EXTRA_TARGET = "com.vk.android.extra.target";
        final static String ACTION_ADD = "com.vk.android.action.add";
        final static String ACTION_PRE_EXECUTE = "com.vk.android.action.pre_execute";
        final static String ACTION_POST_EXECUTE = "com.vk.android.action.post_execute";
        final static String ACTION_SUCCESS = "com.vk.android.action.success";
        final static String ACTION_ERROR = "com.vk.android.action.error";
        final static String ACTION_PROGRESS = "com.vk.android.action.progress";

        /**
         * Universal filter that you can use for every child of this class.
         */
        public final static IntentFilter FILTER = new IntentFilter();

        static {
            FILTER.addAction(ACTION_ADD);
            FILTER.addAction(ACTION_PRE_EXECUTE);
            FILTER.addAction(ACTION_SUCCESS);
            FILTER.addAction(ACTION_ERROR);
            FILTER.addAction(ACTION_POST_EXECUTE);
            FILTER.addAction(ACTION_PROGRESS);
        }

        @Override
        @SuppressWarnings("unchecked")
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String target = intent.getStringExtra(EXTRA_TARGET);
            int code = intent.getIntExtra(EXTRA_CODE, Integer.MIN_VALUE);
            VK vk = VK.with(context);
            if(getClass().getCanonicalName().equals(target)) {
                if(ACTION_ADD.equals(action)) {
                    onAdded(vk, code);
                } else if(ACTION_PRE_EXECUTE.equals(action)) {
                    onPreExecute(vk, code);
                } else if(ACTION_SUCCESS.equals(action)) {
                    T result = (T) intent.getParcelableExtra(EXTRA_RESULT);
                    if(result == null) {
                        result = (T) intent.getSerializableExtra(EXTRA_RESULT);
                    }
                    onSuccess(vk, code, result);
                } else if(ACTION_ERROR.equals(action)) {
                    onError(vk, code, (VKException) intent.getSerializableExtra(EXTRA_ERROR));
                } else if(ACTION_POST_EXECUTE.equals(action)) {
                    onPostExecute(vk, code);
                } else if(ACTION_PROGRESS.equals(action)) {
                    onUploadProgress(vk, code, intent.getIntExtra(EXTRA_FILE, 0), intent.getIntExtra(EXTRA_PERCENT, 0));
                }
            }
        }

        /**
         * Called when request is added fo requests queue.
         * @param requestCode unique code of request to identify.
         */
        public void onAdded(VK vk, int requestCode) {

        }

        /**
         * Called before the request has been executed.
         * @param requestCode unique code of request to identify.
         */
        public void onPreExecute(VK vk, int requestCode) {

        }

        /**
         * Called if request was successful and without errors.
         * @param requestCode unique code of request to identify.
         * @param data result of this response.
         */
        public void onSuccess(VK vk, int requestCode, T data) {

        }

        /**
         * Called if the server returned an error code.
         * @param requestCode unique code of request to identify.
         * @param e server's error exception.
         */
        public void onError(VK vk, int requestCode, VKException e) {

        }

        /**
         * Called after the request has been executed.
         * @param requestCode unique code of request to identify.
         */
        public void onPostExecute(VK vk, int requestCode) {

        }

        /**
         * Called while request uploads files.
         * @param requestCode unique code of request to identify.
         * @param file number of file since 0
         * @param progress percentage of current file, number between [0, 100]
         */
        public void onUploadProgress(VK vk, int requestCode, int file, int progress) {

        }
    }

}
