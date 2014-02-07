/**
 * Comment.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 19.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import android.os.Parcel;
import android.util.SparseArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Comment object describes a comment.
 */
@SuppressWarnings("unused")
public class VKComment extends VKModel implements Identifiable, android.os.Parcelable {

    /**
     * Comment ID, positive number
     */
    public int id;

    /**
     * Comment author ID.
     */
    public int from_id;

    /**
     * Date when the comment was added as unixtime.
     */
    public long date;

    /**
     * Text of the comment
     */
    public String text;

    /**
     * ID of the user or community to whom the reply is addressed (if the comment is a reply to another comment).
     */
    public int reply_to_user;

    /**
     * ID of the comment the reply to which is represented by the current comment (if the comment is a reply to another comment).
     */
    public int reply_to_comment;

    /**
     * Number of likes on the comment.
     */
    public int likes;

    /**
     * Information whether the current user liked the comment.
     */
    public boolean user_likes;

    /**
     * Whether the current user can like on the comment.
     */
    public boolean can_like;

    /**
     * Information about attachments in the comments (photos, links, etc.;)
     */
    public VKAttachments attachments = new VKAttachments();

    /**
     * Fills a Comment instance from JSONObject.
     */
    public VKComment parse(JSONObject from) throws JSONException {
        id = from.optInt("id");
        from_id = from.optInt("from_id");
        date = from.optLong("date");
        text = from.optString("text");
        reply_to_user = from.optInt("reply_to_user");
        reply_to_comment = from.optInt("reply_to_comment");
        attachments.fill(from.optJSONArray("attachments"));
        JSONObject likes = from.optJSONObject("likes");
        this.likes = ParseUtils.parseInt(likes, "count");
        this.user_likes = ParseUtils.parseBoolean(likes, "user_likes");
        this.can_like = ParseUtils.parseBoolean(likes, "can_like");
        return this;
    }

    /**
     * Creates a Comment instance from Parcel.
     */
    public VKComment(Parcel in) {
        this.id = in.readInt();
        this.from_id = in.readInt();
        this.date = in.readLong();
        this.text = in.readString();
        this.reply_to_user = in.readInt();
        this.reply_to_comment = in.readInt();
        this.likes = in.readInt();
        this.user_likes = in.readByte() != 0;
        this.can_like = in.readByte() != 0;
        this.attachments = in.readParcelable(VKAttachments.class.getClassLoader());
    }


    /**
     * Creates empty Comment instance.
     */
    public VKComment() {

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
        dest.writeInt(this.from_id);
        dest.writeLong(this.date);
        dest.writeString(this.text);
        dest.writeInt(this.reply_to_user);
        dest.writeInt(this.reply_to_comment);
        dest.writeInt(this.likes);
        dest.writeByte(user_likes ? (byte) 1 : (byte) 0);
        dest.writeByte(can_like ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.attachments, flags);
    }

    public static Creator<VKComment> CREATOR = new Creator<VKComment>() {
        public VKComment createFromParcel(Parcel source) {
            return new VKComment(source);
        }

        public VKComment[] newArray(int size) {
            return new VKComment[size];
        }
    };
}
