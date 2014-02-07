/**
 * Post.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 19.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import android.os.Parcel;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A post object describes a wall post.
 */
@SuppressWarnings("unused")
public class VKPost extends VKAttachments.VKAttachment implements Identifiable, android.os.Parcelable {

    /**
     * Post ID on the wall, positive number
     */
    public int id;

    /**
     * Wall owner ID.
     */
    public int to_id;

    /**
     * ID of the user who posted.
     */
    public int from_id;

    /**
     * Date (in Unix time) the post was added.
     */
    public long date;

    /**
     * Text of the post.
     */
    public String text;

    /**
     * ID of the wall owner the post to which the reply is addressed (if the post is a reply to another wall post).
     */
    public int reply_owner_id;

    /**
     * ID of the wall post to which the reply is addressed (if the post is a reply to another wall post).
     */
    public int reply_post_id;

    /**
     * True, if the post was created with "Friends only" option.
     */
    public boolean friends_only;

    /**
     * Number of comments.
     */
    public int comments_count;

    /**
     * Whether the current user can leave comments to the post (false — cannot, true — can)
     */
    public boolean can_post_comment;

    /**
     * Number of users who liked the post.
     */
    public int likes_count;

    /**
     * Whether the user liked the post (false — not liked, true — liked)
     */
    public boolean user_likes;

    /**
     * Whether the user can like the post (false — cannot, true — can).
     */
    public boolean can_like;

    /**
     * Whether the user can repost (false — cannot, true — can).
     */
    public boolean can_publish;

    /**
     * Number of users who copied the post.
     */
    public int reposts_count;

    /**
     * Whether the user reposted the post (false — not reposted, true — reposted).
     */
    public boolean user_reposted;

    /**
     * Type of the post, can be: post, copy, reply, postpone, suggest.
     */
    public String post_type;

    /**
     * Information about attachments to the post (photos, links, etc.), if any;
     */
    public VKAttachments attachments = new VKAttachments();

    /**
     * Information about location.
     */
    public VKPlace geo;

    /**
     * ID of the author (if the post was published by a community and signed by a user).
     */
    public int signer_id;

    /**
     * List of history of the reposts.
     */
    public VKList<VKPost> copy_history;

    /**
     * Fills a Post instance from JSONObject.
     */
    public VKPost parse(JSONObject source) throws JSONException {
        id = source.optInt("id");
        to_id = source.optInt("to_id");
        from_id = source.optInt("from_id");
        date = source.optLong("date");
        text = source.optString("text");
        reply_owner_id = source.optInt("reply_owner_id");
        reply_post_id = source.optInt("reply_post_id");
        friends_only = ParseUtils.parseBoolean(source, "friends_only");
        JSONObject comments = source.optJSONObject("comments");
        if(comments != null) {
            comments_count = comments.optInt("count");
            can_post_comment = ParseUtils.parseBoolean(comments, "can_post");
        }
        JSONObject likes = source.optJSONObject("likes");
        if(likes != null) {
            likes_count = likes.optInt("count");
            user_likes = ParseUtils.parseBoolean(likes, "user_likes");
            can_like = ParseUtils.parseBoolean(likes, "can_like");
            can_publish = ParseUtils.parseBoolean(likes, "can_publish");
        }
        JSONObject reposts = source.optJSONObject("reposts");
        if(reposts != null) {
            reposts_count = reposts.optInt("count");
            user_reposted = ParseUtils.parseBoolean(reposts, "user_reposted");
        }
        post_type = source.optString("post_type");
        attachments.fill(source.optJSONArray("attachments"));
        JSONObject geo = source.optJSONObject("geo");
        if(geo != null) {
            this.geo = new VKPlace().parse(geo);
        }
        signer_id = source.optInt("signer_id");
        copy_history = new VKList<VKPost>(source.optJSONArray("copy_history"), VKPost.class);
        return this;
    }

    /**
     * Creates a Post instance from Parcel.
     */
    public VKPost(Parcel in) {
        this.id = in.readInt();
        this.to_id = in.readInt();
        this.from_id = in.readInt();
        this.date = in.readLong();
        this.text = in.readString();
        this.reply_owner_id = in.readInt();
        this.reply_post_id = in.readInt();
        this.friends_only = in.readByte() != 0;
        this.comments_count = in.readInt();
        this.can_post_comment = in.readByte() != 0;
        this.likes_count = in.readInt();
        this.user_likes = in.readByte() != 0;
        this.can_like = in.readByte() != 0;
        this.can_publish = in.readByte() != 0;
        this.reposts_count = in.readInt();
        this.user_reposted = in.readByte() != 0;
        this.post_type = in.readString();
        this.attachments = in.readParcelable(VKAttachments.class.getClassLoader());
        this.geo = in.readParcelable(VKPlace.class.getClassLoader());
        this.signer_id = in.readInt();
    }

    /**
     * Creates empty Post instance.
     */
    public VKPost() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public CharSequence toAttachmentString() {
        return new StringBuilder(VKAttachments.TYPE_POST).append(to_id).append('_').append(id);
    }

    @Override
    public String getType() {
        return VKAttachments.TYPE_POST;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.to_id);
        dest.writeInt(this.from_id);
        dest.writeLong(this.date);
        dest.writeString(this.text);
        dest.writeInt(this.reply_owner_id);
        dest.writeInt(this.reply_post_id);
        dest.writeByte(friends_only ? (byte) 1 : (byte) 0);
        dest.writeInt(this.comments_count);
        dest.writeByte(can_post_comment ? (byte) 1 : (byte) 0);
        dest.writeInt(this.likes_count);
        dest.writeByte(user_likes ? (byte) 1 : (byte) 0);
        dest.writeByte(can_like ? (byte) 1 : (byte) 0);
        dest.writeByte(can_publish ? (byte) 1 : (byte) 0);
        dest.writeInt(this.reposts_count);
        dest.writeByte(user_reposted ? (byte) 1 : (byte) 0);
        dest.writeString(this.post_type);
        dest.writeParcelable(attachments, flags);
        dest.writeParcelable(this.geo, flags);
        dest.writeInt(this.signer_id);
    }

    public static Creator<VKPost> CREATOR = new Creator<VKPost>() {
        public VKPost createFromParcel(Parcel source) {
            return new VKPost(source);
        }

        public VKPost[] newArray(int size) {
            return new VKPost[size];
        }
    };

}
