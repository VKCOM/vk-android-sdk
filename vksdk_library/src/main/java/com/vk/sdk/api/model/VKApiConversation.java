package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class VKApiConversation extends VKApiModel implements Identifiable, Parcelable {

    public int peer_id;

    public int local_id;

    public int unread_count;

    /**
     * Type of conversation. Types: chat, user, email, group.
     */
    public Type type;

    public boolean can_write;

    /**
     * Id of last message read by this user.
     */
    public int in_read;

    /**
     * Id of last message sent by this user and read by any otherwise user.
     */
    public int out_read;

    /**
     * Id of last message from this conversation.
     */
    public int last_message_id;

    public VKApiConversation() {

    }

    public VKApiConversation(JSONObject source) {
        parse(source);
    }

    public VKApiConversation(Parcel source) {
        peer_id = source.readInt();
        local_id = source.readInt();
        unread_count = source.readInt();
        type = (Type) source.readSerializable();
        can_write = source.readInt() == 1;
        in_read = source.readInt();
        out_read = source.readInt();
        last_message_id = source.readInt();
    }

    public VKApiConversation parse(JSONObject in) {
        JSONObject peer = in.optJSONObject("peer");
        peer_id = peer.optInt("id");
        local_id = peer.optInt("local_id");

        unread_count = in.optInt("unread_count");

        switch (peer.optString("type")) {
            case "chat":
                type = Type.CHAT;
                break;
            case "user":
                type = Type.USER;
                break;
            case "group":
                type = Type.GROUP;
                break;
            case "email":
                type = Type.EMAIL;
                break;
        }

        can_write = in.optJSONObject("can_write").optBoolean("allowed");

        in_read = in.optInt("in_read");
        out_read = in.optInt("out_read");

        last_message_id = in.optInt("last_message_id");

        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(peer_id);
        dest.writeInt(local_id);
        dest.writeInt(unread_count);
        dest.writeSerializable(type);
        dest.writeInt(can_write ? 1 : 0);
        dest.writeInt(in_read);
        dest.writeInt(out_read);
        dest.writeInt(last_message_id);
    }

    public static Parcelable.Creator<VKApiConversation> CREATOR = new Parcelable.Creator<VKApiConversation>() {
        @Override
        public VKApiConversation createFromParcel(Parcel source) {
            return new VKApiConversation(source);
        }

        @Override
        public VKApiConversation[] newArray(int size) {
            return new VKApiConversation[size];
        }
    };

    @Override
    public int getId() {
        return peer_id;
    }

    public enum Type {
        CHAT,
        USER,
        GROUP,
        EMAIL
    }
}
