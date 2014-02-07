/**
 * Link.java
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
 * A link object describes a link attachment
 */
@SuppressWarnings("unused")
public class VKLink extends VKAttachments.VKAttachment implements android.os.Parcelable {

    /**
     * Link URL
     */
    public String url;

    /**
     * Link title
     */
    public String title;

    /**
     * Link description;
     */
    public String description;

    /**
     * Image preview URL for the link (if any).
     */
    public String image_src;

    /**
     * ID wiki page with content for the preview of the page contents
     * ID is returned as "ownerid_pageid".
     */
    public String preview_page;

    /**
     * Creates link attachment to attach it to the post
     * @param url full URL of link
     */
    public VKLink(String url) {
        this.url = url;
    }

    /**
     * Fills a Link instance from JSONObject.
     */
    public VKLink parse(JSONObject source) {
        url = source.optString("url");
        title = source.optString("title");
        description = source.optString("description");
        image_src = source.optString("image_src");
        preview_page = source.optString("preview_page");
        return this;
    }

    /**
     * Creates a Link instance from Parcel.
     */
    private VKLink(Parcel in) {
        this.url = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.image_src = in.readString();
        this.preview_page = in.readString();
    }

    /**
     * Creates empty Link instance.
     */
    public VKLink() {

    }

    @Override
    public CharSequence toAttachmentString() {
        return url;
    }

    @Override
    public String getType() {
        return TYPE_LINK;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.image_src);
        dest.writeString(this.preview_page);
    }

    public static Creator<VKLink> CREATOR = new Creator<VKLink>() {
        public VKLink createFromParcel(Parcel source) {
            return new VKLink(source);
        }

        public VKLink[] newArray(int size) {
            return new VKLink[size];
        }
    };

    @Override
    public int getId() {
        return 0;
    }
}
