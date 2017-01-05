package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Aleksei Moisseev on 31.05.15.
 */
public class VKDialog extends VKApiModel implements Parcelable, Identifiable {

    public VKApiMessage message;
    public int count;
    public int unread_dialogs;

    public VKDialog(Parcel in) {
        message = in.readParcelable(VKApiMessage.class.getClassLoader());
        count = in.readInt();
        unread_dialogs = in.readInt();
    }

    public VKDialog() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(message, 0);
        dest.writeInt(count);
        dest.writeInt(unread_dialogs);
    }

    public VKDialog parse(JSONObject dialog) throws JSONException {
        VKApiMessage msg = new VKApiMessage();
        msg.parse(dialog.optJSONObject("message"));
        message = msg;
        count = dialog.optInt("count");
        unread_dialogs = dialog.optInt("unread_dialogs");
        return this;
    }


    @Override
    public int describeContents() {
        return 0;
    }


    public static Creator<VKDialog> CREATOR = new Creator<VKDialog>() {
        @Override
        public VKDialog createFromParcel(Parcel source) {
            return new VKDialog(source);
        }

        @Override
        public VKDialog[] newArray(int size) {
            return new VKDialog[size];
        }
    };

    @Override
    public int getId() {
        return message.id;
    }
}
