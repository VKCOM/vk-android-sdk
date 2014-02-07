/**
 * DirectApiRequest.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 06.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk;

import android.net.Uri;
import android.text.TextUtils;
import com.vk.android.sdk.exceptions.*;
import org.json.JSONException;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;

import static java.lang.String.valueOf;

/**
 * Represents request to REST service.
 * All params will be transferred as POST.
 *
 * You can extend it to write custom raw request.
 *
 * This class does not support handling VK API errors,
 * but allows you to send some files.
 * @param <T> type of request result
 */
@SuppressWarnings("unused")
public abstract class RESTRequest<T> {

    /**
     * Delimiter for list params.
     */
    private final static String DELIMITER = ",";

    /**
     * Url to connection.
     */
    CharSequence mTag;

    /**
     * Arguments of this request.
     */
    final Map<CharSequence, CharSequence> mParams = new LinkedHashMap<CharSequence, CharSequence>();

    /**
     * Files to transfer via HTTP for this request.
     */
    final Map<CharSequence, Uri> mFiles = new LinkedHashMap<CharSequence, Uri>();

    /**
     * Callback for files uploading.
     */
    UploadCallback mCallback;

    /**
     * Flag for cancel this request.
     */
    private boolean mCanceled;

    /**
     * Creates request in accordance with the specified URL.
     */
    public RESTRequest(CharSequence url) {
        if(url == null) {
            throw new NullPointerException("URL cannot be null");
        }
        mTag = url;
    }

    /**
     * Constructor special for SDK subclasses.
     */
    RESTRequest() {

    }

    /***********************************************************************
     *                        LIFECYCLE METHODS
     ***********************************************************************/

    /**
     * This method is called each time before sending the request.
     * @return URL of this request to connect.
     */
    public CharSequence getUrl() {
        return mTag;
    }

    /**
     * If this method returns true, and same preference is enabled is
     * VK, the application can be interrupted by some VK server errors to
     * user can resolve them.
     *
     * For example, captcha entering, validation process, re-authorization.
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
     * This method checks raw server response for errors.
     * @param source raw server response to check.
     * @return checked and fixed server response.
     * @throws com.vk.android.sdk.exceptions.VKServerException если сервер вернул ошибку.
     * @throws com.vk.android.sdk.exceptions.VKCaptchaException если сервер требует ввести каптчу.
     * @throws com.vk.android.sdk.exceptions.VKValidationException если сервер требует прохожедения процедуры валидации.
     * @throws com.vk.android.sdk.exceptions.VKAuthException если токен устарел или закрытый метод вызывается без токена.
     * @throws CancellationException если запрос был отменен во время его выполения.
     */
    protected String validateResponse(String source) throws VKServerException, VKCaptchaException, VKValidationException, VKAuthException {
        return source;
    }

    /**
     * Override this method to define parsing data procedure.
     * @param source response from server without pre-processing.
     * @return valid data.
     * @throws JSONException if data is not correct. Exception handled
     * automatically by requests manager end sends to callback as API error.
     */
    protected abstract T parse(String source) throws JSONException;

    /**
     * This method is called each time before sending the request.
     * You can override it to add custom action with data.
     */
    protected void onPreExecute() {

    }

    /**
     * This method is called each time after sending the request.
     * You can override it to add custom action with data or result.
     * @throws com.vk.android.sdk.exceptions.VKServerException if server returned error
     * @throws com.vk.android.sdk.exceptions.VKCaptchaException if server requires to enter captcha
     * @throws com.vk.android.sdk.exceptions.VKValidationException if server requires validation procedure
     * @throws com.vk.android.sdk.exceptions.VKAuthException if token has expired or closed method invoked without token
     * @throws IOException if network error occurs
     * @throws JSONException if server response unable to parse
     * @throws CancellationException if request was canceled during its execution
     */
    protected void onPostExecute(T result) throws VKServerException, VKCaptchaException, VKValidationException, VKAuthException, IOException, JSONException, CancellationException {

    }

    /**
     * Executes the query in accordance with the life cycle in the current thread.
     * @return parsed and checked the server's response.
     * @throws com.vk.android.sdk.exceptions.VKServerException if server returned error
     * @throws com.vk.android.sdk.exceptions.VKCaptchaException if server requires to enter captcha
     * @throws com.vk.android.sdk.exceptions.VKValidationException if server requires validation procedure
     * @throws com.vk.android.sdk.exceptions.VKAuthException if token has expired or closed method invoked without token
     * @throws IOException if network error occurs
     * @throws JSONException if server response unable to parse
     * @throws CancellationException if request was canceled during its execution
     */
    public final T execute() throws VKServerException, VKCaptchaException, VKValidationException, VKAuthException, IOException, JSONException, CancellationException {
        if(!isCanceled()) {
            onPreExecute();
            HttpRequest httpRequest = HttpRequest.post(getUrl()).post(mParams).
                    files(mFiles).uploadCallback(mCallback);
            String body = httpRequest.body();
            httpRequest.close();
            String response = validateResponse(body);
            T result = parse(response);
            onPostExecute(result);
            return result;
        } else {
            throw new CancellationException("This request was canceled: " + mTag);
        }
    }

    /***********************************************************************
     *                        GETTERS AND SETTERS
     ***********************************************************************/

    /**
     * Cancels this request.
     * If request is canceled, it will never be executed to dispatched to callback.
     * Does not work, if the request is already executed ​​or dispatched.
     * This action cannot be undone.
     */
    public void cancel() {
        mCanceled = true;
    }

    /**
     * @return true is request wan canceler, false otherwise.
     * @see #cancel()
     */
    public boolean isCanceled() {
        return mCanceled;
    }

    /**
     * Adds a request params according with given key and value.
     */
    public RESTRequest param(CharSequence key, CharSequence value) {
        if(key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        mParams.put(key, value);
        return this;
    }

    /**
     * Adds a request params according with given key and value.
     * If value is {@code true}, param will be equal {@code 1}, {@code 0} otherwise.
     */
    public RESTRequest param(CharSequence key, boolean value) {
        return param(key, value ? 1 : 0);
    }

    /**
     * Adds a request params according with given key and value.
     */
    public RESTRequest param(CharSequence key, byte value) {
        return param(key, String.valueOf(value));
    }

    /**
     * Adds a request params according with given key and value.
     */
    public RESTRequest param(CharSequence key, short value) {
        return param(key, String.valueOf(value));
    }

    /**
     * Adds a request params according with given key and value.
     */
    public RESTRequest param(CharSequence key, int value) {
        return param(key, String.valueOf(value));
    }

    /**
     * Adds a request params according with given key and value.
     */
    public RESTRequest param(CharSequence key, long value) {
        return param(key, String.valueOf(value));
    }

    /**
     * Adds a request params according with given key and value.
     */
    public RESTRequest param(CharSequence key, float value) {
        return param(key, String.valueOf(value));
    }

    /**
     * Adds a request params according with given key and value.
     */
    public RESTRequest param(CharSequence key, double value) {
        return param(key, String.valueOf(value));
    }

    /**
     * Adds a request params according with given key and value.
     * The value will be sent as a list of values ​​separated by commas.
     *
     * For example, for this array {@code ["val1", "val2", "val3"} it's would be
     * {@code "val1,val2,val3"}.
     */
    public RESTRequest params(CharSequence key, CharSequence[] value) {
        if(value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        mParams.put(key, TextUtils.join(DELIMITER, value));
        return this;
    }

    /**
     * Adds a request params according with given key and value.
     * The value will be sent as a list of values ​​separated by commas.
     *
     * For example, for this list {@code {"val1", "val2", "val3"}} it's would be
     * {@code "val1,val2,val3"}.
     */
    public RESTRequest params(CharSequence key, Iterable value) {
        if(value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        mParams.put(key, TextUtils.join(DELIMITER, value));
        return this;
    }

    /**
     * Adds a request params according with given key and value.
     * The value will be sent as a list of values ​​separated by commas.
     *
     * For example, for this array {@code {1, 2, 3}} it's would be
     * {@code "1,2,3"}.
     */
    public RESTRequest params(CharSequence key, byte[] values) {
        if(values == null) {
            throw new NullPointerException("Values cannot be null");
        }
        String[] value = new String[values.length];
        for(int i = 0; i < values.length; i++) {
            value[i] = valueOf(values[i]);
        }
        return params(key, value);
    }

    /**
     * Adds a request params according with given key and value.
     * The value will be sent as a list of values ​​separated by commas.
     *
     * For example, for this array {@code {1, 2, 3}} it's would be
     * {@code "1,2,3"}.
     */
    public RESTRequest params(CharSequence key, short[] values) {
        if(values == null) {
            throw new NullPointerException("Values cannot be null");
        }
        String[] value = new String[values.length];
        for(int i = 0; i < values.length; i++) {
            value[i] = valueOf(values[i]);
        }
        return params(key, value);
    }

    /**
     * Adds a request params according with given key and value.
     * The value will be sent as a list of values ​​separated by commas.
     *
     * For example, for this array {@code {1, 2, 3}} it's would be
     * {@code "1,2,3"}.
     */
    public RESTRequest params(CharSequence key, int[] values) {
        if(values == null) {
            throw new NullPointerException("Values cannot be null");
        }
        String[] value = new String[values.length];
        for(int i = 0; i < values.length; i++) {
            value[i] = valueOf(values[i]);
        }
        return params(key, value);
    }

    /**
     * Adds a request params according with given key and value.
     * The value will be sent as a list of values ​​separated by commas.
     *
     * For example, for this array {@code {1, 2, 3}} it's would be
     * {@code "1,2,3"}.
     */
    public RESTRequest params(CharSequence key, long[] values) {
        if(values == null) {
            throw new NullPointerException("Values cannot be null");
        }
        String[] value = new String[values.length];
        for(int i = 0; i < values.length; i++) {
            value[i] = valueOf(values[i]);
        }
        return params(key, value);
    }

    /**
     * Adds a request params according with given key and value.
     * The value will be sent as a list of values ​​separated by commas.
     *
     * For example, for this array {@code {1, 2, 3}} it's would be
     * {@code "1,2,3"}.
     */
    public RESTRequest params(CharSequence key, float[] values) {
        if(values == null) {
            throw new NullPointerException("Values cannot be null");
        }
        String[] value = new String[values.length];
        for(int i = 0; i < values.length; i++) {
            value[i] = valueOf(values[i]);
        }
        return params(key, value);
    }

    /**
     * Adds a request params according with given key and value.
     * The value will be sent as a list of values ​​separated by commas.
     *
     * For example, for this array {@code {1, 2, 3}} it's would be
     * {@code "1,2,3"}.
     */
    public RESTRequest params(CharSequence key, double[] values) {
        if(values == null) {
            throw new NullPointerException("Values cannot be null");
        }
        String[] value = new String[values.length];
        for(int i = 0; i < values.length; i++) {
            value[i] = valueOf(values[i]);
        }
        return params(key, value);
    }

    /**
     * Attach file to this request.
     * @param key name of param for file.
     * @param file resolved absolute path to file.
     */
    public RESTRequest files(CharSequence key, Uri file) {
        mFiles.put(key, file);
        return this;
    }

    /**
     * @return callback which use for handles files uploading progress.
     */
    public UploadCallback getUploadCallback() {
        return mCallback;
    }

    /**
     * Allows to set callback to handles files uploading progress.
     * <b>Note</b>: callback of uploading will be run on the background thread.
     */
    public void setCallback(UploadCallback callback) {
        this.mCallback = callback;
    }

    /**
     * Allows to handle information about files uploading progress.
     * @since 1.0
     */
    public static interface UploadCallback {

        /**
         * Called every time that uploaded file changes percent of upload.
         * @param file number of file, since 0
         * @param percent percent of upload of the current file
         * @since 1.0
         */
        void onUploadProgress(int file, int percent);
    }
}

