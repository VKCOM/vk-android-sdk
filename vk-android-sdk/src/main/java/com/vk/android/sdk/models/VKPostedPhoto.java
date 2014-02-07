/**
 * PostdPhoto.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 19.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import android.os.Parcel;
import org.json.JSONObject;
import static com.vk.android.sdk.models.VKAttachments.*;

/**
 * Subclass to directly uploaded wall photo.
 */
@SuppressWarnings("unused")
public class VKPostedPhoto extends VKPhoto {

    /**
     * Fills a PostedPhoto instance from JSONObject.
     */
    public VKPostedPhoto parse(JSONObject from) {
        super.parse(from);
        return this;
    }

    /**
     * Creates a PostedPhoto instance from Parcel.
     */
    public VKPostedPhoto(Parcel in) {
        super(in);
    }

    /**
     * Creates empty PostedPhoto instance.
     */
    public VKPostedPhoto() {

    }

    @Override
    public String getType() {
        return TYPE_POSTED_PHOTO;
    }
}
