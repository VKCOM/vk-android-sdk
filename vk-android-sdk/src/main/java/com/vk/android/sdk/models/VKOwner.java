/**
 * Owner.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 18.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import android.os.Parcel;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class represents owner of some VK object.
 */
@SuppressWarnings("unused")
public class VKOwner extends VKModel implements Identifiable, android.os.Parcelable {

    /**
     * User or group ID.
     * If ID is positive, owner is user.
     * If ID is negative, owner is community.
     */
    public int id;

    /**
     * Creates an owner with empty ID.
     */
    public VKOwner() {

    }

    /**
     * Fills an owner from JSONObject
     */
    public VKOwner parse(JSONObject from) {
        id = from.optInt("id");
        return this;
    }

    /**
     * Creates according with given ID.
     */
    public VKOwner(int id) {
        this.id = id;
    }

    /**
     * Creates an owner from Parcel.
     */
    public VKOwner(Parcel in) {
        this.id = in.readInt();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
    }

    public static Creator<VKOwner> CREATOR = new Creator<VKOwner>() {
        public VKOwner createFromParcel(Parcel source) {
            return new VKOwner(source);
        }

        public VKOwner[] newArray(int size) {
            return new VKOwner[size];
        }
    };
}
