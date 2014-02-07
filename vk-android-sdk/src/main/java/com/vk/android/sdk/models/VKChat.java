/**
 * Chat.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 19.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import android.os.Parcel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Chat object describes a user's chat.
 */
@SuppressWarnings("unused")
public class VKChat extends VKModel implements Identifiable, android.os.Parcelable {

    /**
     * Chat ID, positive number.
     */
    public int id;

    /**
     * Type of chat.
     */
    public String type;

    /**
     * Chat title.
     */
    public String title;

    /**
     * ID of the chat starter, positive number
     */
    public int admin_id;

    /**
     * List of chat participants' IDs.
     */
    public int[] users;

    /**
     * Fills a Chat instance from JSONObject.
     */
    public VKChat parse(JSONObject source) {
        id = source.optInt("id");
        type = source.optString("type");
        title = source.optString("title");
        admin_id = source.optInt("admin_id");
        JSONArray users = source.optJSONArray("users");
        if(users != null) {
            this.users = new int[users.length()];
            for(int i = 0; i < this.users.length; i++) {
                this.users[i] = users.optInt(i);
            }
        }
        return this;
    }

    /**
     * Creates a Chat instance from Parcel.
     */
    public VKChat(Parcel in) {
        this.id = in.readInt();
        this.type = in.readString();
        this.title = in.readString();
        this.admin_id = in.readInt();
        this.users = in.createIntArray();
    }

    /**
     * Creates empty Chat instance.
     */
    public VKChat() {

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
        dest.writeString(this.type);
        dest.writeString(this.title);
        dest.writeInt(this.admin_id);
        dest.writeIntArray(this.users);
    }

    public static Creator<VKChat> CREATOR = new Creator<VKChat>() {
        public VKChat createFromParcel(Parcel source) {
            return new VKChat(source);
        }

        public VKChat[] newArray(int size) {
            return new VKChat[size];
        }
    };
}
