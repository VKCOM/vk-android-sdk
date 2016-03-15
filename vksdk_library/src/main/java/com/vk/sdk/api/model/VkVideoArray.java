package com.vk.sdk.api.model;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lynnfield on 23.11.2015.
 */
public class VkVideoArray extends VKList<VKApiVideo> {
    @Override
    public VKApiModel parse(JSONObject response) throws JSONException {
        fill(response, VKApiVideo.class);
        return this;
    }

    @SuppressWarnings("unused")
    public VkVideoArray() {
    }

    public VkVideoArray(Parcel in) {
        super(in);
    }

    public static Creator<VkVideoArray> CREATOR = new Creator<VkVideoArray>() {
        public VkVideoArray createFromParcel(Parcel source) {
            return new VkVideoArray(source);
        }

        public VkVideoArray[] newArray(int size) {
            return new VkVideoArray[size];
        }
    };
}
