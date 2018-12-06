//
//  Copyright (c) 2014 VK.com
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to
//  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
//  the Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
//  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
//  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
//  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
//  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

/**
 * Message.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 19.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.sdk.api.model;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A message object describes a private message
 */
@SuppressWarnings("unused")
public class VKApiMessage extends VKApiModel implements Identifiable, android.os.Parcelable {

    /**
     * 	Message ID. (Not returned for forwarded messages), positive number
     */
    public int id;

    public int peer_id;

    public int conversation_message_id;

    public int random_id;

    /**
     * For an incoming message, the user ID of the author. For an outgoing message, the user ID of the receiver.
     */
    public int from_id;

    /**
     * 	Date (in Unix time) when the message was sent.
     */
    public long date;

    /**
     * Message type (false — received, true — sent). (Not returned for forwarded messages.)
     */
    public boolean out;

    public boolean important;

    public boolean is_hidden;

    /**
     * Body of the message.
     */
    public String text;

    /**
     * List of media-attachments;
     */
    public VKAttachments attachments = new VKAttachments();

    /**
     * Array of forwarded messages (if any).
     */
    public VKList<VKApiMessage> fwd_messages;

	public VKApiMessage(JSONObject from) throws JSONException
	{
		parse(from);
	}
    /**
     * Fills a Message instance from JSONObject.
     */
    public VKApiMessage parse(JSONObject source) throws JSONException {
        id = source.optInt("id");
        peer_id = source.optInt("peer_id");
        conversation_message_id = source.optInt("conversation_message_id");
        random_id = source.optInt("random_id");
        from_id = source.optInt("from_id");
        date = source.optLong("date");
        out = ParseUtils.parseBoolean(source, "out");
        important = source.optBoolean("important");
        is_hidden = source.optBoolean("is_hidden");
        text = source.optString("text");
        attachments.fill(source.optJSONArray("attachments"));
        fwd_messages = new VKList<>(source.optJSONArray("fwd_messages"), VKApiMessage.class);
        return this;
    }

    /**
     * Creates a Message instance from Parcel.
     */
    public VKApiMessage(Parcel in) {
        this.id = in.readInt();
        this.peer_id = in.readInt();
        this.conversation_message_id = in.readInt();
        this.random_id = in.readInt();
        this.from_id = in.readInt();
        this.date = in.readLong();
        this.out = in.readByte() != 0;
        this.important = in.readByte() != 0;
        this.is_hidden = in.readByte() != 0;
        this.text = in.readString();
        this.attachments = in.readParcelable(VKAttachments.class.getClassLoader());
        this.fwd_messages = in.readParcelable(VKList.class.getClassLoader());
    }

    /**
     * Creates empty Country instance.
     */
    public VKApiMessage() {

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
        dest.writeInt(this.peer_id);
        dest.writeInt(this.conversation_message_id);
        dest.writeInt(this.random_id);
        dest.writeInt(this.from_id);
        dest.writeLong(this.date);
        dest.writeByte(out ? (byte) 1 : 0);
        dest.writeByte(important ? (byte) 1 : 0);
        dest.writeByte(is_hidden ? (byte) 1 : 0);
        dest.writeString(this.text);
        dest.writeParcelable(attachments, flags);
        dest.writeParcelable(this.fwd_messages, flags);
    }

    public static Creator<VKApiMessage> CREATOR = new Creator<VKApiMessage>() {
        public VKApiMessage createFromParcel(Parcel source) {
            return new VKApiMessage(source);
        }

        public VKApiMessage[] newArray(int size) {
            return new VKApiMessage[size];
        }
    };
}
