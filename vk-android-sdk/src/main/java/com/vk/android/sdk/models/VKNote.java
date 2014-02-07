/**
 * Note.java
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
 * A note object describes a note.
 */
@SuppressWarnings("unused")
public class VKNote extends VKAttachments.VKAttachment implements Identifiable, android.os.Parcelable {

    /**
     * Note ID, positive number
     */
    public int id;

    /**
     * Note owner ID.
     */
    public int user_id;

    /**
     * Note title.
     */
    public String title;

    /**
     * Note text.
     */
    public String text;

    /**
     * Date (in Unix time) when the note was created.
     */
    public long date;

    /**
     * Number of comments.
     */
    public int comments;

    /**
     * Number of read comments (only if owner_id is the current user).
     */
    public int read_comments;

    /**
     * Fills a Note instance from JSONObject.
     */
    public VKNote parse(JSONObject source) {
        id = source.optInt("id");
        user_id = source.optInt("user_id");
        title = source.optString("title");
        text = source.optString("text");
        date = source.optLong("date");
        comments = source.optInt("comments");
        read_comments = source.optInt("read_comments");
        return this;
    }

    /**
     * Creates a Note instance from Parcel.
     */
    public VKNote(Parcel in) {
        this.id = in.readInt();
        this.user_id = in.readInt();
        this.title = in.readString();
        this.text = in.readString();
        this.date = in.readLong();
        this.comments = in.readInt();
        this.read_comments = in.readInt();
    }

    /**
     * Creates empty Note instance.
     */
    public VKNote() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public CharSequence toAttachmentString() {
        return new StringBuilder(TYPE_NOTE).append(user_id).append('_').append(id);
    }

    @Override
    public String getType() {
        return TYPE_NOTE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.user_id);
        dest.writeString(this.title);
        dest.writeString(this.text);
        dest.writeLong(this.date);
        dest.writeInt(this.comments);
        dest.writeInt(this.read_comments);
    }

    public static Creator<VKNote> CREATOR = new Creator<VKNote>() {
        public VKNote createFromParcel(Parcel source) {
            return new VKNote(source);
        }

        public VKNote[] newArray(int size) {
            return new VKNote[size];
        }
    };

}
