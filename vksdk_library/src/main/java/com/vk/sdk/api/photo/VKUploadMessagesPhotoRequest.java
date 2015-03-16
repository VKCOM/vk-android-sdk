package com.vk.sdk.api.photo;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.api.photo.VKUploadPhotoBase;
import com.vk.sdk.util.VKJsonHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class VKUploadMessagesPhotoRequest extends VKUploadPhotoBase {
    private static final long serialVersionUID = 1L;

    public VKUploadMessagesPhotoRequest(File image) {
        super();
        mImages = new File[]{image};
    }

    public VKUploadMessagesPhotoRequest(VKUploadImage image) {
        super();
        mImages = new File[]{image.getTmpFile()};
    }

    @Override
    protected VKRequest getServerRequest() {
        return VKApi.photos().getMessagesUploadServer();
    }

    @Override
    protected VKRequest getSaveRequest(JSONObject response) {
        VKRequest saveRequest;
        try {
            saveRequest = VKApi.photos().saveMessagesPhoto(new VKParameters(VKJsonHelper.toMap(response)));
        } catch (JSONException e) {
            return null;
        }
        return saveRequest;
    }
}
