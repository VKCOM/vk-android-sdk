package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class VKApiGetConversationsResponseItem extends VKApiModel implements Parcelable, Identifiable {

    public VKApiConversation conversation;

    public VKApiMessage last_message;


    public VKApiGetConversationsResponseItem(JSONObject from) throws JSONException {
        parse(from);
    }

    public VKApiGetConversationsResponseItem(Parcel in) {
        conversation = in.readParcelable(VKApiConversation.class.getClassLoader());
        last_message = in.readParcelable(VKApiMessage.class.getClassLoader());
    }

    @Override
    public VKApiModel parse(JSONObject from) throws JSONException {
        conversation = new VKApiConversation(from.optJSONObject("conversation"));
        last_message = new VKApiMessage(from.optJSONObject("last_message"));
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(conversation, flags);
        dest.writeParcelable(last_message, flags);
    }

    @Override
    public int getId() {
        return conversation.peer_id;
    }

    public static Parcelable.Creator<VKApiGetConversationsResponseItem> CREATOR =
            new Parcelable.Creator<VKApiGetConversationsResponseItem>() {
                @Override
                public VKApiGetConversationsResponseItem createFromParcel(Parcel source) {
                    return new VKApiGetConversationsResponseItem(source);
                }

                @Override
                public VKApiGetConversationsResponseItem[] newArray(int size) {
                    return new VKApiGetConversationsResponseItem[size];
                }
            };
}
