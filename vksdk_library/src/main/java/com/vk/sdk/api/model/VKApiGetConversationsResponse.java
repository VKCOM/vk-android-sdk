package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class VKApiGetConversationsResponse extends VKApiModel implements Parcelable {

    public int count;

    public VKList<VKApiGetConversationsResponseItem> items;

    public int unread_count;

    public VKUsersArray profiles;

    public VKApiCommunityArray groups;

    public VKApiGetConversationsResponse(JSONObject source) {
        this.parse(source);
    }

    public VKApiGetConversationsResponse parse(JSONObject source) {
        JSONObject response = source.optJSONObject("response");
        count = response.optInt("count");
        items = new VKList<>(response.optJSONArray("items"), VKApiGetConversationsResponseItem.class);
        unread_count = response.optInt("unread_count");

        if (response.has("profiles")) {
            profiles = new VKUsersArray();
            profiles.addAll(new VKList<>(
                    response.optJSONArray("profiles"),
                    VKApiUserFull.class));
        }
        if (response.has("groups")) {
            groups = new VKApiCommunityArray();
            groups.addAll(new VKList<>(
                    response.optJSONArray("groups"),
                    VKApiCommunityFull.class));
        }
        return this;
    }

    public VKApiGetConversationsResponse(Parcel in) {
        count = in.readInt();
        items = in.readParcelable(VKList.class.getClassLoader());
        unread_count = in.readInt();
        profiles = in.readParcelable(VKList.class.getClassLoader());
        groups = in.readParcelable(VKList.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeParcelable(items, flags);
        dest.writeInt(unread_count);
        dest.writeParcelable(profiles, flags);
        dest.writeParcelable(groups, flags);
    }

    public static Parcelable.Creator<VKApiGetConversationsResponse> CREATOR =
            new Parcelable.Creator<VKApiGetConversationsResponse>() {
                @Override
                public VKApiGetConversationsResponse createFromParcel(Parcel source) {
                    return new VKApiGetConversationsResponse(source);
                }

                @Override
                public VKApiGetConversationsResponse[] newArray(int size) {
                    return new VKApiGetConversationsResponse[size];
                }
            };
}
