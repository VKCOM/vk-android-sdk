/**
 * ExecuteBuilder.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 16.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk;

import com.vk.android.sdk.exceptions.VKException;
import com.vk.android.sdk.models.ParseUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Allow you to join a few request to one as execute format. <br/>
 * <B>Note</B>: this class cannot process VK errors which requires UI interrupt. <br/>
 * <B>Note</B>: VK execute method has limit to methods call. Be careful with this. <br/>
 * <b>Note</b>: this class requires authorization <br/>
 */
public final class ExecuteBuilder extends VKRequest<Object> {

    private final List<RequestItem> mList = new ArrayList<RequestItem>();

    /**
     * Creates a new empty builder.
     */
    public ExecuteBuilder() {
        super("execute");
    }

    /**
     * Appends request to the builder.
     * @param request request to append
     * @param callback callback to take results of request.
     * @param <T> type of result
     * @return this builder
     */
    public <T> ExecuteBuilder add(VKRequest<T> request, VK.Callback<T> callback) {
        mList.add(new RequestItem<T>(request, callback));
        return this;
    }

    @Override
    public boolean interruptUIIfNecessary() {
        return false;
    }

    @Override
    protected void onPreExecute() {
        // Сформируем параметр code, передадим дочерним запросам событие преподготовки.
        StringBuilder code = new StringBuilder("return {");
        for(int i = 0; i < mList.size(); i++) {
            if(i > 0) {
                code.append(',');
            }
            code.append('\n');
            code.append("\"request_");
            code.append(i);
            code.append("\": ");

            VKRequest request = mList.get(i).request;
            request.onPreExecute();
            code.append(toExecuteString(request));
        }
        code.append("};");
        param("code", code);
        super.onPreExecute();
    }

    @Override
    protected Object parse(String source) throws JSONException {
        JSONObject root = ParseUtils.rootJSONObject(source);
        for(int i = 0; i < mList.size(); i++) {
            RequestItem item = mList.get(i);
            mList.get(i).result = item.request.parse(String.format("{ \"response\": %s}", root.get("request_" + i)));
        }
        return null;
    }

    void exec(RequestQueue queue) {
        queue.exec(this, new CallbackWrapper());
    }

    // Специальный Callback Wrapper передаст события и на дочерние callback
    private class CallbackWrapper implements VK.Callback<Object> {

        @Override
        public void onAdded(VK vk) {
            for(RequestItem item: mList) {
                item.callback.onAdded(vk);
            }
        }

        @Override
        public void onPreExecute(VK vk) {
            for(RequestItem item: mList) {
                item.callback.onPreExecute(vk);
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public void onSuccess(VK vk, Object data) {
            for(RequestItem item: mList) {
                item.callback.onSuccess(vk, item.result);
            }
        }

        @Override
        public void onError(VK vk, VKException e) {
            for(RequestItem item: mList) {
                item.callback.onError(vk, e);
            }
        }

        @Override
        public void onPostExecute(VK vk) {
            for(RequestItem item: mList) {
                item.callback.onPostExecute(vk);
            }
        }

        @Override
        public void onUploadProgress(VK vk, int file, int progress) {
            // Nothing to implement here because VK does not allows file transfer via execute
        }
    }

    // Отдельный класс для запросов решит проблемы приведения типов и парсинга данных.
    private final static class RequestItem<T> {
        final VKRequest<T> request;
        final VK.Callback<T> callback;
        T result;

        RequestItem(VKRequest<T> request, VK.Callback<T> callback) {
            this.request = request;
            this.callback = callback;
        }
    }


    private static <T> CharSequence toExecuteString(VKRequest<T> request) {
        StringBuilder result = new StringBuilder(API);
        result.append('.');
        result.append(request.mTag);
        result.append("({");
        boolean firstTime = true;
        for (Map.Entry<CharSequence, CharSequence> entry : request.mParams.entrySet()) {
            if(firstTime) {
                firstTime = false;
            } else {
                result.append(',');
            }
            result.append('\n');
            result.append('"');
            result.append(entry.getKey());
            result.append("\": \"");
            result.append(entry.getValue());
            result.append('"');
        }
        result.append("})");
        return result;
    }
}
