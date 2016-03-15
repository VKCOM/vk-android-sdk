package com.vk.sdk.api.model;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

public class VkAudioArray extends VKList<VKApiAudio> {
    @Override
    public VKApiModel parse(JSONObject response) throws JSONException {
        fill(response, VKApiAudio.class);
        return this;
    }

    @SuppressWarnings("unused")
    public VkAudioArray() {
    }

    public VkAudioArray(Parcel in) {
        super(in);
    }

    public static Creator<VkAudioArray> CREATOR = new Creator<VkAudioArray>() {
        public VkAudioArray createFromParcel(Parcel source) {
            return new VkAudioArray(source);
        }

        public VkAudioArray[] newArray(int size) {
            return new VkAudioArray[size];
        }
    };
}
