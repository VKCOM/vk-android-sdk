package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;
import static com.vk.sdk.api.model.VKAttachments.*;

public class VKApiSticker extends VKAttachments.VKApiAttachment implements Parcelable, Identifiable {

    /**
     * Sticker id
     */
    public int id;

    /**
     * Product id
     */
    public int product_id;

    /**
     * URL of image with size 64x64px.
     */
    public String photo_64;

    /**
     * URL of image with size 128x128px.
     */
    public String photo_128;

    /**
     * URL of image with size 256x256px.
     */
    public String photo_256;

    /**
     * URL of image with size 352x352px.
     */
    public String photo_352;

    /**
     * URL of image with size 512x512px.
     */
    public String photo_512;

    /**
     * width px
     */
    public int width;

    /**
     * height px
     */
    public int height;

    public VKApiSticker(JSONObject from) throws JSONException
    {
        parse(from);
    }

    /**
     * Fills a Sticker instance from JSONObject.
     */
    public VKApiSticker parse(JSONObject from) {
        id = from.optInt("id");
        product_id = from.optInt("product_id");
        photo_64 = from.optString("photo_64");
        photo_128 = from.optString("photo_128");
        photo_256 = from.optString("photo_256");
        photo_352 = from.optString("photo_352");
        photo_512 = from.optString("photo_512");
        width = from.optInt("width");
        height = from.optInt("height");
        return this;
    }

    /**
     * Creates a Sticker instance from Parcel.
     */
    public VKApiSticker(Parcel in) {
        this.id = in.readInt();
        this.product_id = in.readInt();
        this.photo_64 = in.readString();
        this.photo_128 = in.readString();
        this.photo_256 = in.readString();
        this.photo_512 = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
    }

    /**
     * Creates empty Sticker instance.
     */
    public VKApiSticker() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public CharSequence toAttachmentString() {
        return new StringBuffer(TYPE_STICKER).append(product_id).append('_').append(id);
    }

    @Override
    public String getType() {
        return TYPE_STICKER;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.product_id);
        dest.writeString(this.photo_64);
        dest.writeString(this.photo_128);
        dest.writeString(this.photo_256);
        dest.writeString(this.photo_512);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
    }

    public static Creator<VKApiSticker> CREATOR = new Creator<VKApiSticker>() {
        @Override
        public VKApiSticker createFromParcel(Parcel source) {
            return new VKApiSticker(source);
        }

        @Override
        public VKApiSticker[] newArray(int size) {
            return new VKApiSticker[size];
        }
    };
}
