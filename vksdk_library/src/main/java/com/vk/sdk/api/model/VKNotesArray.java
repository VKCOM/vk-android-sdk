package com.vk.sdk.api.model;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Array of API notes objects
 */
public class VKNotesArray extends VKList<VKApiNote> {
    @Override
    public VKApiModel parse(JSONObject response) throws JSONException {
        fill(response, VKApiNote.class);
        return this;
    }

    @SuppressWarnings("unused")
    public VKNotesArray() {
    }

    public VKNotesArray(Parcel in) {
        super(in);
    }

    public static Creator<VKNotesArray> CREATOR = new Creator<VKNotesArray>() {
        public VKNotesArray createFromParcel(Parcel source) {
            return new VKNotesArray(source);
        }

        public VKNotesArray[] newArray(int size) {
            return new VKNotesArray[size];
        }
    };
}
