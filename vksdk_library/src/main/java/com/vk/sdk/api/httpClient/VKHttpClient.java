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

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKSdkVersion;
import com.vk.sdk.VKUIHelper;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKAttachments;
import com.vk.sdk.util.VKUtil;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;

/**
 * Class provides configured http client for API request loading
 */
public class VKHttpClient {

    /**
     * Prepares new "normal" request from VKRequest
     *
     * @param vkRequest Request, created for some method
     * @return Prepared request for creating VKHttpOperation
     */
    public static VKHTTPRequest requestWithVkRequest(@NonNull VKRequest vkRequest) {
        VKAccessToken token = VKAccessToken.currentToken();
        VKHTTPRequest result = new VKHTTPRequest(String.format(Locale.US, "http%s://api.vk.com/method/%s", vkRequest.secure || (token != null && token.httpsRequired) ? "s" : "", vkRequest.methodName));
        result.headers = getDefaultHeaders();
        result.setVkParameters(vkRequest.getPreparedParameters());
        return result;
    }

    /**
     * Prepares new request with multipart boundary for uploading files
     *
     * @param uploadUrl String url received with some of *.getUploadServer method
     * @param files     Files array to upload
     * @return prepared HTTP request, ready for upload
     */
    public static VKHTTPRequest fileUploadRequest(@NonNull String uploadUrl, File... files) {
        VKHTTPRequest request = new VKHTTPRequest(uploadUrl);
        request.entity = new VKMultipartEntity(files);
        return request;
    }

    /**
     * Prepares new request with multipart boundary for uploading document
     *
     * @param uploadUrl String url received with some of *.getUploadServer method
     * @param file      File to upload
     * @return prepared HTTP request, ready for upload
     */
    public static VKHTTPRequest docUploadRequest(@NonNull String uploadUrl, File file) {
        VKHTTPRequest request = new VKHTTPRequest(uploadUrl);
        request.entity = new VKMultipartEntity(new File[]{file}, VKAttachments.TYPE_DOC);
        return request;
    }

    /**
     * Returns map of default headers for any request
     *
     * @return Map of default headers
     */
    private static Map<String, String> getDefaultHeaders() {
        return new HashMap<String, String>() {
            /**
             *
             */
            private static final long serialVersionUID = 200199014417610665L;

            {
                put("Accept-Encoding", "gzip");
            }
        };
    }

    /**
     * Executor for performing requests in background
     */
    private static final ExecutorService mBackgroundExecutor = Executors.newFixedThreadPool(3);
    private static final ExecutorService mResponseService = Executors.newSingleThreadExecutor();

    /**
     * Starts operation in the one of network threads
     *
     * @param operation Operation to start
     */
    public static void enqueueOperation(final VKAbstractOperation operation) {
        mBackgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                operation.start(mResponseService);
            }
        });
    }

    /**
     * Cancel http operation request on background thread (to prevent exception)
     *
     * @param operation executing http operation
     */
    public static void cancelHttpOperation(final VKHttpOperation operation) {
        mBackgroundExecutor.execute(new Runnable() {
            @Override
            public void run() {
                operation.getUriRequest().abort();
            }
        });
    }

    public static VKHttpResponse execute(VKHTTPRequest request) throws IOException {
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

        VKHttpResponse response = new VKHttpResponse(request.createConnection(), null);
        if (request.isAborted) {
            return null;
        }
        return response;
    }

    /**
     * Class for managing http request at VK API
     */
    public static class VKHTTPRequest {
        public URL methodUrl = null;
        public int timeout = 20000;
        public List<Pair<String, String>> parameters = null;
        public VKMultipartEntity entity = null;
        public Map<String, String> headers = null;
        public boolean isAborted = false;
        public HttpURLConnection connection;

        public VKHTTPRequest(@Nullable String url) {
            if (url != null) {
                try {
                    this.methodUrl = new URL(url);
                } catch (MalformedURLException e) {
                    if (VKSdk.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * Write this request params to provided output stream
         *
         * @param os Output stream for parameters
         * @throws IOException
         */
        void writeParams(@NonNull OutputStream os) throws IOException {
            if (this.entity != null) {
                this.entity.writeTo(os);
            } else {
                String query = getQuery();
                if (query != null && query.length() > 0) {
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(query);
                    writer.flush();
                    writer.close();
                }
            }
        }

        /**
         * Serialize VKParameters map into http query parameters list
         *
         * @param params parameters map
         */
        void setVkParameters(VKParameters params) {
            ArrayList<Pair<String, String>> pairs = new ArrayList<>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof VKAttachments) {
                    pairs.add(new Pair<>(entry.getKey(), ((VKAttachments) value).toAttachmentsString()));
                } else if (value instanceof Collection) {
                    Collection<?> values = (Collection<?>) value;
                    //VK style
                    pairs.add(new Pair<>(entry.getKey(), TextUtils.join(",", values)));
                } else {
                    pairs.add(new Pair<>(entry.getKey(), value == null ? null : String.valueOf(value)));
                }
            }
            this.parameters = pairs;
        }

        /**
         * Returns prepared http query like k1=v1&k2=v2...
         *
         * @return string presentation of http query
         * @throws UnsupportedEncodingException
         */
        public String getQuery() throws UnsupportedEncodingException {
            if (this.parameters == null) {
                return null;
            }
            ArrayList<String> params = new ArrayList<>(this.parameters.size());
            for (Pair<String, String> pair : this.parameters) {
                params.add(String.format("%s=%s", URLEncoder.encode(pair.first, "UTF-8"), URLEncoder.encode(pair.second, "UTF-8")));
            }
            return TextUtils.join("&", params);
        }

        /**
         * Stops current operation
         */
        public void abort() {
            if (this.connection != null) {
                this.connection.disconnect();
            }
            isAborted = true;
        }


        HttpURLConnection createConnection() throws IOException {
            URL url = this.methodUrl;
            this.connection = (HttpURLConnection) url.openConnection();

            this.connection.setReadTimeout(this.timeout);
            this.connection.setConnectTimeout(this.timeout + 5000);
            this.connection.setRequestMethod("POST");
            this.connection.setUseCaches(false);
            this.connection.setDoInput(true);
            this.connection.setDoOutput(true);

            try {
                Context ctx = VKUIHelper.getApplicationContext();
                if (ctx != null) {
                    PackageManager packageManager = ctx.getPackageManager();
                    if (packageManager != null) {
                        PackageInfo info = packageManager.getPackageInfo(ctx.getPackageName(), 0);
                        this.connection.setRequestProperty("User-Agent",
                                String.format(Locale.US,
                                        "%s/%s (%s; Android %d; Scale/%.2f; VK SDK %s; %s)",
                                        VKUtil.getApplicationName(ctx), info.versionName,
                                        Build.MODEL, Build.VERSION.SDK_INT,
                                        ctx.getResources().getDisplayMetrics().density,
                                        VKSdkVersion.SDK_VERSION,
                                        info.packageName));
                    }
                }
            } catch (Exception ignored) {
            }

            this.connection.setRequestProperty("Connection", "Keep-Alive");
            if (this.headers != null) {
                for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                    this.connection.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            if (this.entity != null) {
                this.connection.addRequestProperty("Content-length", this.entity.getContentLength() + "");
                Pair<String, String> contentType = this.entity.getContentType();
                this.connection.addRequestProperty(contentType.first, contentType.second);
            }

            OutputStream os = this.connection.getOutputStream();
            this.writeParams(os);
            os.close();

            this.connection.connect();

            return this.connection;
        }
    }

    /**
     * Class for representing http response from VK API
     */
    public static class VKHttpResponse {

        public final int statusCode;
        public final long contentLength;
        public Map<String, String> responseHeaders = null;
        public final byte[] responseBytes;

        public VKHttpResponse(HttpURLConnection connection, VKHttpProgressCallback progress) throws IOException {
            this.statusCode = connection.getResponseCode();
            this.contentLength = connection.getContentLength();

            if (connection.getHeaderFields() != null) {
                responseHeaders = new HashMap<>();
                for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
                    responseHeaders.put(header.getKey(), TextUtils.join(",", header.getValue()));
                }
            }

            InputStream inputStream = connection.getInputStream();
            if (responseHeaders != null) {
                String contentEncoding = responseHeaders.get("Content-Encoding");
                if (contentEncoding != null && contentEncoding.equalsIgnoreCase("gzip")) {
                    inputStream = new GZIPInputStream(inputStream);
                }
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytesRead = 0;

            if (this.contentLength <= 0) {
                progress = null;
            }

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
                if (progress != null) {
                    progress.onProgress(totalBytesRead, this.contentLength);
                }
            }
            inputStream.close();
            outputStream.flush();

            responseBytes = outputStream.toByteArray();
            outputStream.close();
        }
    }

    public interface VKHttpProgressCallback {
        void onProgress(long current, long total);
    }
}