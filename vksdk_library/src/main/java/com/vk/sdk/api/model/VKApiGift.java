package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;
import static com.vk.sdk.api.model.VKAttachments.*;

public class VKApiGift extends VKAttachments.VKApiAttachment implements Parcelable, Identifiable {

    /**
     * Gift id
     */
    public int id;

    /**
     * URL of image with size 256x256px.
     */
    public String thumb_256;

    /**
     * URL of image with size 96x96px.
     */
    public String thumb_96;

    /**
     * URL of image with size 48x48x.
     */
    public String thumb_48;

    public VKApiGift(JSONObject from) {
        parse(from);
    }

    /**
     * Fills a Gift instance from JSONObject.
     */
    public VKApiGift parse(JSONObject from) {
        this.id = from.optInt("id");
        this.thumb_48 = from.optString("thumb_48");
        this.thumb_96 = from.optString("thumb_96");
        this.thumb_256 = from.optString("thumb_256");
        return this;
    }

    /**
     * Creates a Gift instance from Parcel.
     */
    public VKApiGift(Parcel in ) {
        this.id = in.readInt();
        this.thumb_256 = in.readString();
        this.thumb_96 = in.readString();
        this.thumb_48 = in.readString();
    }

    /**
     * Creates an empty Gift instance.
     */
    public VKApiGift() {

    }

    @Override
    public String getType() {
        return TYPE_GIFT;
    }

    @Override
    public CharSequence toAttachmentString() {
        return new StringBuffer(TYPE_GIFT).append(id);
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
        dest.writeString(this.thumb_256);
        dest.writeString(this.thumb_96);
        dest.writeString(this.thumb_48);
    }

    public static Creator<VKApiGift> CREATOR = new Creator<VKApiGift>() {
        @Override
        public VKApiGift createFromParcel(Parcel source) {
            return new VKApiGift(source);
        }

        @Override
        public VKApiGift[] newArray(int size) {
            return new VKApiGift[size];
        }
    };
}
