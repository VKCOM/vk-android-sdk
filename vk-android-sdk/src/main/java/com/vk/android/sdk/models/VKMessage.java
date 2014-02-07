/**
 * Message.java
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
 * A message object describes a private message
 */
@SuppressWarnings("unused")
public class VKMessage extends VKModel implements Identifiable, android.os.Parcelable {

    /**
     * 	Message ID. (Not returned for forwarded messages), positive number
     */
    public int id;

    /**
     * For an incoming message, the user ID of the author. For an outgoing message, the user ID of the receiver.
     */
    public int user_id;

    /**
     * 	Date (in Unix time) when the message was sent.
     */
    public long date;

    /**
     * Message status (false — not read, true — read). (Not returned for forwarded messages.)
     */
    public boolean read_state;

    /**
     * Message type (false — received, true — sent). (Not returned for forwarded messages.)
     */
    public boolean out;

    /**
     * Title of message or chat.
     */
    public String title;

    /**
     * Body of the message.
     */
    public String body;

    /**
     * List of media-attachments;
     */
    public VKAttachments attachments = new VKAttachments();

    /**
     * Array of forwarded messages (if any).
     */
    public VKList<VKMessage> fwd_messages;

    /**
     *	Whether the message contains smiles (false — no, true — yes).
     */
    public boolean emoji;

    /**
     * Whether the message is deleted (false — no, true — yes).
     */
    public boolean deleted;

    /**
     * Fills a Message instance from JSONObject.
     */
    public VKMessage parse(JSONObject source) throws JSONException {
        id = source.optInt("id");
        user_id = source.optInt("user_id");
        date = source.optLong("date");
        read_state = ParseUtils.parseBoolean(source, "read_state");
        out = ParseUtils.parseBoolean(source, "out");
        title = source.optString("title");
        body = source.optString("body");
        attachments .fill(source.optJSONArray("attachments"));
        fwd_messages = new VKList<VKMessage>(source.optJSONArray("fwd_messages"), VKMessage.class);
        emoji = ParseUtils.parseBoolean(source, "emoji");
        deleted = ParseUtils.parseBoolean(source, "deleted");
        return this;
    }

    /**
     * Creates a Message instance from Parcel.
     */
    public VKMessage(Parcel in) {
        this.id = in.readInt();
        this.user_id = in.readInt();
        this.date = in.readLong();
        this.read_state = in.readByte() != 0;
        this.out = in.readByte() != 0;
        this.title = in.readString();
        this.body = in.readString();
        this.attachments = in.readParcelable(VKAttachments.class.getClassLoader());
        this.fwd_messages = in.readParcelable(VKList.class.getClassLoader());
        this.emoji = in.readByte() != 0;
        this.deleted = in.readByte() != 0;
    }

    /**
     * Creates empty Country instance.
     */
    public VKMessage() {

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
        dest.writeInt(this.user_id);
        dest.writeLong(this.date);
        dest.writeByte(read_state ? (byte) 1 : (byte) 0);
        dest.writeByte(out ? (byte) 1 : (byte) 0);
        dest.writeString(this.title);
        dest.writeString(this.body);
        dest.writeParcelable(attachments, flags);
        dest.writeParcelable(this.fwd_messages, flags);
        dest.writeByte(emoji ? (byte) 1 : (byte) 0);
        dest.writeByte(deleted ? (byte) 1 : (byte) 0);
    }

    public static Creator<VKMessage> CREATOR = new Creator<VKMessage>() {
        public VKMessage createFromParcel(Parcel source) {
            return new VKMessage(source);
        }

        public VKMessage[] newArray(int size) {
            return new VKMessage[size];
        }
    };
}
