package com.vk.android.sdk;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

import java.io.*;
import java.net.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import static java.net.HttpURLConnection.*;

@TargetApi(Build.VERSION_CODES.FROYO)
@SuppressWarnings("unused")
class HttpRequest implements Closeable {

    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String ENCODING_GZIP = "gzip";
    public static final String ENCODING_8BIT = "8bit";
    public static final String ENCODING_BINARY = "binary";
    public static final String CONTENT_TYPE_TEXT = "text/plain";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";
    public static final String HEADER_DATE = "Date";
    public static final String HEADER_ETAG = "ETag";
    public static final String HEADER_EXPIRES = "Expires";
    public static final String HEADER_IF_NONE_MATCH = "If-None-Match";
    public static final String HEADER_LAST_MODIFIED = "Last-Modified";
    public static final String HEADER_LOCATION = "Location";
    public static final String HEADER_REFERER = "Referer";
    public static final String HEADER_SERVER = "Server";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_TRACE = "TRACE";
    private final static String BOUNDARY = UUID.randomUUID().toString();
    private static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    private static final String CONTENT_TYPE_MULTIPART = "multipart/form-data; boundary=" + BOUNDARY;
    private final static String LINEND = "\r\n";
    private final static String PREFIX = "--";
    private static final String CONTENT_DISPOSITION = "Content-Disposition: form-data; ";
    private static final String CONTENT_TYPE_MULTIPART_PLACEHOLDER = "Content-Type: %s; charset=utf-8";
    private static final String CONTENT_TYPE_MULTIPART_TEXT = String.format(CONTENT_TYPE_MULTIPART_PLACEHOLDER, CONTENT_TYPE_TEXT);
    private static final String CONTENT_TRANSFER_ENCODING_PLACEHOLDER = "Content-Transfer-Encoding: %s";
    private static final String CONTENT_TRANSFER_ENCODING_8BIT = String.format(CONTENT_TRANSFER_ENCODING_PLACEHOLDER, ENCODING_8BIT);
    private static final String CONTENT_TRANSFER_ENCODING_BINARY = String.format(CONTENT_TRANSFER_ENCODING_PLACEHOLDER, ENCODING_BINARY);
    private static final String CONTENT_TRANSFER_ENCODING_CHUNKED = String.format(CONTENT_TRANSFER_ENCODING_PLACEHOLDER, "chunked");
    private static final String MULTIPART_NAME = "name=\"";
    private static final String MULTIPART_FILENAME = "filename=\"";

    public static HttpRequest get(String url, Map<? extends String, ? extends String> params) throws IOException {
        if(TextUtils.isEmpty(url)) {
            throw new MalformedURLException("Param url must not be empty");
        }
        if(url.charAt(url.length() - 1) != '/') {
            url = url + '/';
        }
        url = url + paramsToUrlencoded(params);
        return get(url);
    }

    public static HttpRequest get(CharSequence url) throws IOException {
        return new HttpRequest(url, METHOD_GET);
    }

    public static HttpRequest post(CharSequence url) throws IOException {
        return new HttpRequest(url, METHOD_POST);
    }

    public static HttpRequest delete(CharSequence url) throws IOException {
        return new HttpRequest(url, METHOD_DELETE);
    }

    public static HttpRequest head(CharSequence url) throws IOException {
        return new HttpRequest(url, METHOD_HEAD);
    }

    public static HttpRequest options(CharSequence url) throws IOException {
        return new HttpRequest(url, METHOD_OPTIONS);
    }

    public static HttpRequest trace(CharSequence url) throws IOException {
        return new HttpRequest(url, METHOD_TRACE);
    }

    public static HttpRequest put(CharSequence url) throws IOException {
        return new HttpRequest(url, METHOD_PUT);
    }

    private int mConnectTimeout = 25000;
    private int mReadTimeout = 25000;
    private int mBufferSize = 1024;
    private boolean mUseCaches = false;
    protected RESTRequest.UploadCallback mUploadCallback;
    private Map<CharSequence, CharSequence> mPostParams = new LinkedHashMap<CharSequence, CharSequence>();
    private Map<CharSequence, Uri> mFiles = new LinkedHashMap<CharSequence, Uri>();
    private HttpURLConnection mConnection;
    private URL mUrl;
    private String mMethod;
    private boolean mSent = false;

    public HttpRequest(URL url, String requestMethod) {
        if(url == null || requestMethod == null) {
            throw new NullPointerException("URL and RequestMethod must not be null");
        }
        if(!METHOD_DELETE.equals(requestMethod) &&
                !METHOD_GET.equals(requestMethod) &&
                !METHOD_HEAD.equals(requestMethod) &&
                !METHOD_OPTIONS.equals(requestMethod) &&
                !METHOD_POST.equals(requestMethod) &&
                !METHOD_PUT.equals(requestMethod) &&
                !METHOD_TRACE.equals(requestMethod)) {
            throw new IllegalArgumentException("Unknown HTTP request method: " + requestMethod);
        }
        mUrl = url;
        mMethod = requestMethod;
    }

    public HttpRequest(CharSequence url, String requestMethod) throws MalformedURLException {
        this(new URL(url.toString()), requestMethod);
    }

    public void close() throws IOException {
        if(mConnection != null) {
            mConnection.disconnect();
        }
    }

    protected InputStream send() throws IOException {
        HttpURLConnection connection = getConnection();

        if(!mSent) {
            boolean hasParams = !mFiles.isEmpty() || !mPostParams.isEmpty();
            connection.setDoOutput(hasParams);
            if(hasParams) {
                OutputStream output;
                if(!mFiles.isEmpty()) {
                    int contentLength = calcContentLength();
                    connection.setFixedLengthStreamingMode(contentLength);
                    connection.setRequestProperty(HEADER_CONTENT_TYPE, CONTENT_TYPE_MULTIPART);
                    output = new BufferedOutputStream(connection.getOutputStream());
                    writeParamsMultipart(output);
                    writeFilesMultipart(output);
                    output.write((PREFIX + BOUNDARY + PREFIX + LINEND).getBytes());
                } else {
                    connection.setRequestProperty(HEADER_CONTENT_TYPE, CONTENT_TYPE_FORM);
                    output = new BufferedOutputStream(connection.getOutputStream());
                    output.write(paramsToUrlencoded(mPostParams).getBytes());
                }
                output.flush();
                output.close();
            }
            mSent = true;
        }
        InputStream input = new BufferedInputStream(connection.getInputStream());
        if(ENCODING_GZIP.equalsIgnoreCase(connection.getHeaderField(HEADER_CONTENT_ENCODING))) {
            input = new GZIPInputStream(input);
        }
        return input;
    }

    protected HttpURLConnection getConnection() throws IOException {
        if(mConnection == null) {
            mConnection = (HttpURLConnection) mUrl.openConnection();
            mConnection.setRequestMethod(mMethod);
            mConnection.setDoInput(true);
            mConnection.setUseCaches(mUseCaches);
            mConnection.setConnectTimeout(mConnectTimeout);
            mConnection.setReadTimeout(mReadTimeout);
            mConnection.setInstanceFollowRedirects(true);
            mConnection.setRequestProperty(HEADER_ACCEPT_ENCODING, ENCODING_GZIP);
        }
        return mConnection;
    }

    protected void writeParamsMultipart(OutputStream to) throws IOException {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<CharSequence, CharSequence> entry : mPostParams.entrySet()) {
            result.append(PREFIX).append(BOUNDARY).append(LINEND); // 2 + BOUNDARY.len + 2
            result.append(CONTENT_DISPOSITION); // 32
            result.append(MULTIPART_NAME).append(entry.getKey()).append('\"').append(LINEND); // 6 + key + 1 + 2
            result.append(CONTENT_TYPE_MULTIPART_TEXT).append(LINEND); // 39 + 2
            result.append(CONTENT_TRANSFER_ENCODING_8BIT).append(LINEND); // 31 + 2
            result.append(LINEND).append(entry.getValue()).append(LINEND); // 2 + value + 2
        }
        to.write(result.toString().getBytes());
    }

    private int calcContentLength() {
        int length = 0;
        int boundary = BOUNDARY.length();

        // Calculating post params
        int postBase = 2 + boundary + 2 +   // result.append(PREFIX).append(BOUNDARY).append(LINEND);
                        32 +                // result.append(CONTENT_DISPOSITION);
                        6 + 1 + 2 +         // result.append(MULTIPART_NAME).append(entry.getKey()).append('\"').append(LINEND);
                        39 + 2 +            // result.append(CONTENT_TYPE_MULTIPART_TEXT).append(LINEND);
                        31 + 2 +            // result.append(CONTENT_TRANSFER_ENCODING_8BIT).append(LINEND);
                        2 + 2;              // result.append(LINEND).append(entry.getValue()).append(LINEND);

        for(Map.Entry<CharSequence, CharSequence> entry : mPostParams.entrySet()) {
            length = length + postBase + entry.getKey().length() + entry.getValue().length();
        }

        int fileBase = 2 + boundary + 2 +   // headers.append(PREFIX).append(BOUNDARY).append(LINEND);
                32 +                        // headers.append(CONTENT_DISPOSITION);
                6 + 3 +                     // headers.append(MULTIPART_NAME).append(entry.getKey()).append("\"; ");
                10 + 1 + 2 +                // headers.append(MULTIPART_FILENAME).append(file.getName()).append('\"').append(LINEND);
                29 + 2 +                    // headers.append(String.format(CONTENT_TYPE_MULTIPART_PLACEHOLDER, TYPES.getContentTypeFor(file.getName()))).append(LINEND);
                33 + 2 +                    // headers.append(CONTENT_TRANSFER_ENCODING_BINARY).append(LINEND);
                2;                          // headers.append(LINEND);


        for(Map.Entry<CharSequence, Uri> entry : mFiles.entrySet()) {
            File file = new File(entry.getValue().getPath());
            length = (int) (length + fileBase + entry.getKey().length() +
                                file.getName().length() +
                                getMimeType(file.getName()).length() +
                        file.length() + 2); // to.write(LINEND.getBytes());
        }

        return length + 2 + boundary + 2 + 2; // output.write((PREFIX + BOUNDARY + PREFIX + LINEND).getBytes());
    }

    protected void writeFilesMultipart(OutputStream to) throws IOException {
        StringBuilder headers = new StringBuilder();

        int activeFile = 0;
        for(Map.Entry<CharSequence, Uri> entry : mFiles.entrySet()) {
            File file = new File(entry.getValue().getPath());

            // Формируем HTTP-заголовки
            headers.append(PREFIX).append(BOUNDARY).append(LINEND);
            headers.append(CONTENT_DISPOSITION);
            headers.append(MULTIPART_NAME).append(entry.getKey()).append("\"; ");
            headers.append(MULTIPART_FILENAME).append(file.getName()).append('\"').append(LINEND);
            headers.append(String.format(CONTENT_TYPE_MULTIPART_PLACEHOLDER, getMimeType(file.getName()))).append(LINEND);
            headers.append(CONTENT_TRANSFER_ENCODING_BINARY).append(LINEND);
            headers.append(LINEND);

            // Очищаем строковый буфер, дабы не повторять заголовки при
            // следующей интерации цикла, и записываем заголовки в поток.
            to.write(headers.toString().getBytes());
            headers.setLength(0);

            // Записываем в фоток файл
            FileInputStream input = new FileInputStream(file);
            byte[] buffer = new byte[mBufferSize];
            int len;
            int transferred = 0; // сколько байт передано
            long total = file.length(); // сколько всего байт
            int lastPercent = 0;
            while((len = input.read(buffer)) != -1) {
                to.write(buffer, 0, len);
                transferred += len;
                if(mUploadCallback != null) {
                    int percent = (int) ((transferred * 100) / (float) total);
                    if(percent != lastPercent) {
                        lastPercent = percent;
                        mUploadCallback.onUploadProgress(activeFile, percent);
                    }
                }
            }
            input.close();
            to.write(LINEND.getBytes());
            activeFile++;
        }
    }

    protected final void checkConnection() {
        if(mSent) {
            throw new IllegalStateException("Request has already been sent");
        }
    }

    public HttpRequest post(Map<? extends CharSequence, ? extends CharSequence> data) {
        for (Map.Entry<? extends CharSequence, ? extends CharSequence> header : data.entrySet()) {
            post(header.getKey(), header.getValue());
        }
        return this;
    }

    public HttpRequest post(Object key, Object value) {
        return post(String.valueOf(key), String.valueOf(value));
    }

    public HttpRequest post(CharSequence key, CharSequence value) {
        if(key == null || value == null) {
            throw new NullPointerException("Key and value must not be null");
        }
        checkConnection();
        mPostParams.put(key, value);
        return this;
    }

    public HttpRequest files(Map<? extends CharSequence, ? extends Uri> data) {
        for (Map.Entry<? extends CharSequence, ? extends Uri> header : data.entrySet()) {
            files(header.getKey(), header.getValue());
        }
        return this;
    }

    public HttpRequest files(CharSequence key, Uri value) {
        if(key == null || value == null) {
            throw new NullPointerException("Key and value must not be null");
        }
        if(!ContentResolver.SCHEME_FILE.equals(value.getScheme())) {
            throw new IllegalArgumentException("URI must be a file URI, starts with 'file://'");
        }
        checkConnection();
        mFiles.put(key, value);
        return this;
    }

    public HttpRequest header(String name, String value) throws IOException {
        checkConnection();
        getConnection().setRequestProperty(name, value);
        return this;
    }

    public HttpRequest headers(final Map<? extends String, ? extends String> headers) throws IOException {
        for (Map.Entry<? extends String, ? extends String> header : headers.entrySet()) {
            header(header.getKey(), header.getValue());
        }
        return this;
    }

    public void connectTimeout(int connectTimeout) {
        checkConnection();
        if(connectTimeout <= 0) {
            throw new IllegalArgumentException("Connect timeout must be a positive number");
        }
        this.mConnectTimeout = connectTimeout;
    }

    public void readTimeout(int readTimeout) {
        checkConnection();
        if(readTimeout <= 0) {
            throw new IllegalArgumentException("Read timeout must be a positive number");
        }
        this.mReadTimeout = readTimeout;
    }

    public void bufferSize(int bufferSize) {
        checkConnection();
        if(bufferSize <= 0) {
            throw new IllegalArgumentException("Buffer size must be a positive number");
        }
        this.mBufferSize = bufferSize;
    }

    public void useCaches(boolean useCaches) {
        checkConnection();
        this.mUseCaches = useCaches;
    }

    public HttpRequest uploadCallback(RESTRequest.UploadCallback callback) {
        checkConnection();
        this.mUploadCallback = callback;
        return this;
    }

    public HttpRequest userAgent(String userAgent) throws IOException {
        return header(HEADER_USER_AGENT, userAgent);
    }

    public HttpRequest referer(final String referer) throws IOException {
        return header(HEADER_REFERER, referer);
    }

    public HttpRequest acceptEncoding(String acceptEncoding) throws IOException {
        return header(HEADER_ACCEPT_ENCODING, acceptEncoding);
    }

    public HttpRequest acceptCharset(String acceptCharset) throws IOException {
        return header(HEADER_ACCEPT_CHARSET, acceptCharset);
    }

    public HttpRequest accept(String accept) throws IOException {
        return header(HEADER_ACCEPT, accept);
    }

    public HttpRequest acceptJson() throws IOException {
        return accept(CONTENT_TYPE_JSON);
    }

    public String header(String key) throws IOException {
        send();
        return getConnection().getHeaderField(key);
    }

    public int intHeader(String key) throws IOException {
        send();
        return getConnection().getHeaderFieldInt(key, -1);
    }

    public long dateHeader(String key) throws IOException {
        send();
        return getConnection().getHeaderFieldDate(key, -1);
    }

    public int code() throws IOException {
        send();
        return getConnection().getResponseCode();
    }

    public String message() throws IOException {
        send();
        return getConnection().getResponseMessage();
    }

    public byte[] bytes() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream input = send();
        byte[] buffer = new byte[mBufferSize];
        int read;
        while((read = input.read(buffer, 0, buffer.length)) != -1) {
            baos.write(buffer, 0, read);
        }
        baos.flush();
        baos.close();
        close();
        return baos.toByteArray();
    }

    public String body(String charset) throws IOException {
        InputStream input = send();
        Reader reader = new InputStreamReader(input, charset);
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[mBufferSize];
        int read;
        while ((read = reader.read(buffer)) > 0) {
            sb.append(buffer, 0, read);
        }
        reader.close();
        close();
        return sb.toString();
    }

    public String body() throws IOException {
        return body(CHARSET_UTF8);
    }

    public void receive(OutputStream out) throws IOException {
        InputStream input = send();
        byte[] buffer = new byte[mBufferSize];
        int read;
        while((read = input.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    public void receive(File file) throws IOException {
        OutputStream out = new FileOutputStream(file);
        receive(out);
        out.flush();
        out.close();
    }

    public String contentType() throws IOException {
        return header(HEADER_CONTENT_TYPE);
    }

    public int contentLength() throws IOException {
        return intHeader(HEADER_CONTENT_LENGTH);
    }

    public String location() throws IOException {
        return header(HEADER_LOCATION);
    }

    public String contentEncoding() throws IOException {
        return header(HEADER_CONTENT_ENCODING);
    }

    public String server() throws IOException {
        return header(HEADER_SERVER);
    }

    public long date() throws IOException {
        return dateHeader(HEADER_DATE);
    }

    public String cacheControl() throws IOException {
        return header(HEADER_CACHE_CONTROL);
    }

    public String eTag() throws IOException {
        return header(HEADER_ETAG);
    }

    public long expires() throws IOException {
        return dateHeader(HEADER_EXPIRES);
    }

    public long lastModified() throws IOException {
        return dateHeader(HEADER_LAST_MODIFIED);
    }

    public boolean ok() throws IOException {
        return HTTP_OK == code();
    }

    public boolean created() throws IOException {
        return HTTP_CREATED == code();
    }

    public boolean serverError() throws IOException {
        return HTTP_INTERNAL_ERROR == code();
    }

    public boolean badRequest() throws IOException {
        return HTTP_BAD_REQUEST == code();
    }

    public boolean notFound() throws IOException {
        return HTTP_NOT_FOUND == code();
    }

    public boolean notModified() throws IOException {
        return HTTP_NOT_MODIFIED == code();
    }

    public static void keepAlive(final boolean keepAlive) {
        System.setProperty("http.keepAlive", Boolean.toString(keepAlive));
    }

    public static void maxConnections(final int maxConnections) {
        System.setProperty("http.maxConnections", Integer.toString(maxConnections));
    }

    public String method() {
        return mMethod;
    }

    public String url() {
        return mUrl.toString();
    }

    public String params() {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<CharSequence, CharSequence> entry : mPostParams.entrySet()) {
            result.append(entry.getKey()).append("=>").append(entry.getValue()).append('\n');
        }
        return result.toString();
    }

    public String files() {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<CharSequence, Uri> entry : mFiles.entrySet()) {
            result.append(entry.getKey()).append("=>").append(entry.getValue().getPath()).append('\n');
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return method() + ' ' + url();
    }

    public RESTRequest.UploadCallback uploadCallback() {
        return mUploadCallback;
    }

    private final static FileNameMap map = URLConnection.getFileNameMap();

    public static String getMimeType(String filename) {
        String result =  map.getContentTypeFor(filename);
        return result != null ? result : "application/octet-stream";
    }

    @SuppressWarnings("deprecated")
    private static String paramsToUrlencoded(Map<? extends CharSequence, ? extends CharSequence> params) {
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (Map.Entry<? extends CharSequence, ? extends CharSequence> entry : params.entrySet()) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append('&');
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(URLEncoder.encode(entry.getValue().toString()));
        }
        return sb.toString();
    }

}