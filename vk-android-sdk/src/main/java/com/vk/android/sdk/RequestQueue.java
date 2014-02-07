/**
 * RequestQueue.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 08.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vk.android.sdk.exceptions.*;
import com.vk.android.sdk.models.VKAccessToken;
import org.json.JSONException;

import java.io.IOException;
import java.util.concurrent.CancellationException;

/**
 * This class handles request queue and watches for events taking place in it.
 */
@SuppressWarnings("unused")
class RequestQueue {

    // Working with UI-interrupt implemented to block all requests simultaneously.
    private final static Object sCaptchaLock = new Object();
    private final static Object sAuthLock = new Object();
    private final static Object sValidateLock = new Object();
    private final static Settings sSettings = Settings.get();

    private static boolean sCaptchaReady = false;
    private static boolean sAuthReady = false;
    private static boolean sValidateReady = false;

    private static String sLastCaptchaKey;
    private final ConnectivityManager mConnectivityManager;

    final VK vk;
    final Context mContext;
    private Runloop mRunloop;

    RequestQueue(VK vk) {
        this.vk = vk;
        mContext = vk.mContext;
        mConnectivityManager = (ConnectivityManager) vk.mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    boolean isNetworkAvailable() {
        final NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
        return !(networkInfo == null || !networkInfo.isConnectedOrConnecting());
    }

    void exec(Runnable executor, long delay) {
        if (mRunloop == null) {
            mRunloop = new Runloop();
            mRunloop.start();
        }
        mRunloop.post(executor, delay);
    }

    void exec(Runnable executor) {
        exec(executor, 0);
    }

    <T> void exec(final RESTRequest<T> request, final VK.Callback<T> callback, long delay) {
        exec(new RequestExecutor<T>(request, callback), delay);
    }

    <T> void exec(final RESTRequest<T> request, final VK.Callback<T> callback) {
        exec(new RequestExecutor<T>(request, callback), 0);
    }

    <T> void exec(final VK.Codeblock<T> codeblock, final VK.Callback<T> callback, long delay) {
        exec(new CodeblockExecutor<T>(codeblock, callback), delay);
    }

    <T> void exec(final VK.Codeblock<T> codeblock, final VK.Callback<T> callback) {
        exec(new CodeblockExecutor<T>(codeblock, callback), 0);
    }

    void exec(RequestsBatch batch) {
        batch.exec(this);
    }

    void exec(ExecuteBuilder builder) {
        builder.exec(this);
    }

    static void resolveAuth(VKAccessToken account) {
        sSettings.authorize(account);
        synchronized (sAuthLock) {
            sAuthLock.notifyAll();
            sAuthReady = true;
        }
    }

    static void resolveValidation(VKAccessToken account) {
        if(account != null) {
            sSettings.authorize(account);
        }
        synchronized (sValidateLock) {
            sValidateLock.notifyAll();
            sValidateReady = true;
        }
    }

    @SuppressWarnings("unused")
    static void resolveCaptcha(String captchaSid, String text) {
        synchronized (sCaptchaLock) {
            sLastCaptchaKey = text;
            sCaptchaLock.notifyAll();
            sCaptchaReady = true;
        }
    }

    /**
     * This class implements the transfer of data from a background thread to the main.
     * Also it's can process validation, authorization, and captcha errors.
     */
    class CallbackHandler<T> extends Handler implements RESTRequest.UploadCallback {

        final static int MESSAGE_ADDED = 0;
        final static int MESSAGE_PRE_EXECUTE = 1;
        final static int MESSAGE_RESULT = 2;
        final static int MESSAGE_ERROR = 3;
        final static int MESSAGE_POST_EXECUTE = 4;
        final static int MESSAGE_VALIDATION = 5;
        final static int MESSAGE_CAPTCHA = 6;
        final static int MESSAGE_AUTH = 7;
        final static int MESSAGE_PROGRESS = 8;

        private final VK.Callback<T> mCallback;

        public CallbackHandler(VK.Callback<T> callback, Looper looper) {
            super(looper);
            mCallback = callback;
        }

        void dispatchAdded() {
            sendMessage(obtainMessage(MESSAGE_ADDED));
        }

        void dispatchPreExecute() {
            sendMessage(obtainMessage(MESSAGE_PRE_EXECUTE));
        }

        void dispatchPostExecute() {
            sendMessage(obtainMessage(MESSAGE_POST_EXECUTE));
        }

        void dispatchResult(T result) {
            Message message = obtainMessage(MESSAGE_RESULT);
            message.obj = result;
            sendMessage(message);
        }

        void dispatchError(VKException e) {
            Message message = obtainMessage(MESSAGE_ERROR);
            message.obj = e;
            sendMessage(message);
        }

        void dispatchValidation(VKValidationException e) {
            Message message = obtainMessage(MESSAGE_VALIDATION);
            message.obj = e;
            sendMessage(message);
        }

        void dispatchCaptcha(VKCaptchaException e) {
            Message message = obtainMessage(MESSAGE_CAPTCHA);
            message.obj = e;
            sendMessage(message);
        }

        void dispatchAuth(VKException e) {
            Message message = obtainMessage(MESSAGE_AUTH);
            message.obj = e;
            sendMessage(message);
        }

        void dispatchProgress(int file, int progress) {
            Message message = obtainMessage(MESSAGE_PROGRESS);
            message.arg1 = file;
            message.arg2 = progress;
            sendMessage(message);
        }

        @Override
        public void onUploadProgress(int file, int percent) {
            dispatchProgress(file, percent);
        }

        @Override
        @SuppressWarnings("unchecked")
        public void handleMessage(Message msg) {
            try {
                switch (msg.what) {
                    case MESSAGE_ADDED: {
                        mCallback.onAdded(vk);
                    } break;
                    case MESSAGE_PRE_EXECUTE: {
                        mCallback.onPreExecute(vk);
                    } break;
                    case MESSAGE_RESULT: {
                        mCallback.onSuccess(vk, (T) msg.obj);
                    } break;
                    case MESSAGE_ERROR: {
                        mCallback.onError(vk, (VKException) msg.obj);
                    } break;
                    case MESSAGE_POST_EXECUTE: {
                        mCallback.onPostExecute(vk);
                    } break;
                    case MESSAGE_PROGRESS: {
                        mCallback.onUploadProgress(vk ,msg.arg1, msg.arg2);
                    } break;
                    case MESSAGE_VALIDATION: {
                        VKActivity.showValidation(mContext, (VKValidationException) msg.obj);
                    } break;
                    case MESSAGE_AUTH: {
                        VKActivity.resolveAuth(mContext);
                    } break;
                    case MESSAGE_CAPTCHA: {
                        VKActivity.showCaptcha(mContext, (VKCaptchaException) msg.obj);
                    } break;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handles asynchronous operation of Codeblocks.
     */
    class CodeblockExecutor<T> implements Runnable {

        final CallbackHandler<T> mHandler;
        final VK.Callback<T> mCallback;
        final VK.Codeblock<T> mCodeblock;

        CodeblockExecutor(VK.Codeblock<T> codeblock, VK.Callback<T> callback) {
            Looper looper = Looper.myLooper();
            if(looper == null) {
                Looper.prepare();
                looper = Looper.myLooper();
            }
            mHandler = new CallbackHandler<T>(callback, looper);
            mCallback = callback;
            mCodeblock = codeblock;
            mHandler.dispatchAdded();
        }

        @Override
        public void run() {
            synchronized (sAuthLock) {
                synchronized (sValidateLock) {
                    synchronized (sCaptchaLock) {
                        mHandler.dispatchPreExecute();
                        try {
                            mHandler.dispatchResult(execute());
                            mHandler.dispatchPostExecute();
                        } catch(VKServerException e) {
                            mHandler.dispatchError(e);
                            mHandler.dispatchPostExecute();
                        } catch (VKValidationException e) {
                            handleValidation(e);
                        } catch (VKAuthException e) {
                            handleAuth(e);
                        } catch(CancellationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        protected void handleAuth(VKException e) {
            sAuthReady = false;
            synchronized (sAuthLock) {
                mHandler.dispatchAuth(e);
                while(!sAuthReady) {
                    try {
                        sAuthLock.wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                // Повторно отправляем запрос
                exec(this);
            }
        }

        protected void handleValidation(VKValidationException e) {
            sValidateReady = false;
            synchronized (sValidateLock) {
                mHandler.dispatchValidation(e);
                while(!sValidateReady) {
                    try {
                        sValidateLock.wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                // Повторно отправляем запрос
                exec(this);
            }
        }

        public T execute() throws VKValidationException, VKServerException, VKAuthException {
            boolean canInterruptUI = sSettings.interruptUIIfNecessary() && mCodeblock.interruptUIIfNecessary();
            try {
                if(isNetworkAvailable() && !mCodeblock.mCanceled) {
                    mCodeblock.mUploader = mHandler;
                    T result =  mCodeblock.run();
                    if(mCodeblock.mCanceled) {
                        throw new CancellationException();
                    } else {
                        return result;
                    }
                } else {
                    throw new IOException("Network is not available");
                }
            } catch (VKValidationException e) {
                if(canInterruptUI) {
                    throw e;
                } else {
                    throw new VKServerException(e);
                }
            } catch (VKCaptchaException e) {
                 throw new VKServerException(e);
            } catch (VKAuthException e) {
                if(canInterruptUI && sSettings.isAuthorized()) {
                    throw e;
                } else {
                    throw new VKServerException(e);
                }
            } catch (VKServerException e) {
                switch (e.getCode()) {
                    case VKException.TOO_MANY_REQUESTS_PER_SECOND:
                    case VKException.INTERVAL_SERVER_ERROR: {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        return execute();
                    }
                    case VKException.HTTPS_ONLY: {
                        sSettings.requireHttps();
                        return execute();
                    }
                }
                throw e;
            } catch (JSONException e) {
                throw new VKServerException(VKException.JSON_PARSE_ERROR, e);
            } catch (IOException e) {
                throw new VKServerException(VKException.NETWORK_ERROR, e);
            }
        }
    }

    /**
     * Handles asynchronous operation of usual requests.
     */
    class RequestExecutor<T> implements Runnable {

        final CallbackHandler<T> mHandler;
        final VK.Callback<T> mCallback;
        final RESTRequest<T> mRequest;

        RequestExecutor(RESTRequest<T> request, VK.Callback<T> callback) {
            Looper looper = Looper.myLooper();
            if(looper == null) {
                Looper.prepare();
                looper = Looper.myLooper();
            }
            mCallback = callback;
            mRequest = request;
            mHandler = new CallbackHandler<T>(callback, looper) {
                @Override
                public void handleMessage(Message msg) {
                    if(!mRequest.isCanceled()) {
                        super.handleMessage(msg);
                    }
                }
            };
            mRequest.setCallback(mHandler);
            mHandler.dispatchAdded();
        }

        @Override
        public void run() {
            synchronized (sAuthLock) {
                synchronized (sValidateLock) {
                    synchronized (sCaptchaLock) {
                        mHandler.dispatchPreExecute();
                        try {
                            mHandler.dispatchResult(execute());
                            mHandler.dispatchPostExecute();
                        } catch(VKServerException e) {
                            mHandler.dispatchError(e);
                            mHandler.dispatchPostExecute();
                        } catch (VKCaptchaException e) {
                            handleCaptcha(e);
                        } catch (VKValidationException e) {
                            handleValidation(e);
                        } catch (VKAuthException e) {
                            handleAuth(e);
                        } catch(CancellationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        /**
         * Выполняет запрос.
         * @throws com.vk.android.sdk.exceptions.VKServerException если исключение необхордимо передать в callback
         * @throws com.vk.android.sdk.exceptions.VKCaptchaException если необходимо ввести каптчу.
         * @throws com.vk.android.sdk.exceptions.VKValidationException если необходимо пройти валидацию.
         * @throws com.vk.android.sdk.exceptions.VKAuthException если необходимо пройти авторизацию.
         * @return результат запроса для передачи в Callback
         */
        public T execute() throws VKValidationException, VKServerException, VKCaptchaException, VKAuthException {
            boolean canInterruptUI = sSettings.interruptUIIfNecessary() && mRequest.interruptUIIfNecessary();
            try {
                for(int i = 0; i < sSettings.getAttempts(); i++) {
                    if(isNetworkAvailable() && !mRequest.isCanceled()) {
                        try {
                            return mRequest.execute();
                        } catch (IOException ignored) {
                            // keep the cycle is executed
                        } catch (JSONException e) {
                            throw new VKServerException(VKException.JSON_PARSE_ERROR, e);
                        }
                    }
                }
                throw new VKServerException(VKException.NETWORK_ERROR, "Network error");
            } catch (VKValidationException e) {
                if(canInterruptUI) {
                    throw e;
                } else {
                    throw new VKServerException(e);
                }
            } catch (VKCaptchaException e) {
                if(canInterruptUI) {
                    throw e;
                } else {
                    throw new VKServerException(e);
                }
            } catch (VKAuthException e) {
                if(canInterruptUI && sSettings.isAuthorized()) {
                    throw e;
                } else {
                    throw new VKServerException(e);
                }
            } catch (VKServerException e) {
                switch (e.getCode()) {
                    case VKException.TOO_MANY_REQUESTS_PER_SECOND:
                    case VKException.INTERVAL_SERVER_ERROR: {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        return execute();
                    }
                    case VKException.HTTPS_ONLY: {
                        sSettings.requireHttps();
                        return execute();
                    }
                }
                throw e;
            }
        }

        protected void handleCaptcha(VKCaptchaException e) {
            sCaptchaReady = false;
            synchronized (sCaptchaLock) {
                mHandler.dispatchCaptcha(e);
                while(!sCaptchaReady) {
                    try {
                        sCaptchaLock.wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                mRequest.param("captcha_sid", e.getCaptchaSid());
                mRequest.param("captcha_key", sLastCaptchaKey);
                sLastCaptchaKey = null;
                // Повторно отправляем запрос
                exec(this);
            }
        }

        protected void handleAuth(VKException e) {
            sAuthReady = false;
            synchronized (sAuthLock) {
                mHandler.dispatchAuth(e);
                while(!sAuthReady) {
                    try {
                        sAuthLock.wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                // Повторно отправляем запрос
                exec(this);
            }
        }

        protected void handleValidation(VKValidationException e) {
            sValidateReady = false;
            synchronized (sValidateLock) {
                mHandler.dispatchValidation(e);
                while(!sValidateReady) {
                    try {
                        sValidateLock.wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                // Повторно отправляем запрос
                exec(this);
            }
        }

    }

    /**
     * This class supports and maintains all messages in a background thread.
     * Through it all requests will be executed sequentially, but always in the same thread.
     */
    static class Runloop extends Thread {

        private Handler mHandler;
        private final Object mLock = new Object();
        private boolean mReady = false;

        @Override
        public void run() {
            Looper.prepare();
            mHandler = new Handler();
            synchronized (mLock) {
                this.mLock.notifyAll();
                mReady = true;
            }
            Looper.loop();
        }

        public void sendMessage(Message message) {
            sendMessage(message, 0);
        }

        public void post(Runnable runnable) {
            post(runnable, 0);
        }

        public void sendMessage(Message message, long delayMillis) {
            synchronized (mLock) {
                while(!mReady) {
                    try {
                        mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (mHandler != null) {
                    if (delayMillis <= 0) {
                        this.mHandler.sendMessage(message);
                    } else {
                        mHandler.sendMessageDelayed(message, delayMillis);
                    }
                }
            }
        }

        public void post(Runnable runnable, long delayMillis) {
            synchronized (mLock) {

                while(!mReady) {
                    try {
                        mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (mHandler != null) {
                    if (delayMillis <= 0) {
                        this.mHandler.post(runnable);
                    } else {
                        mHandler.postDelayed(runnable, delayMillis);
                    }
                }
            }
        }
    }
}