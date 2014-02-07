package com.vk.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONObject;
import static com.vk.android.sdk.models.VKAttachments.*;

/**
 * A document object describes a document file.
 */
@SuppressWarnings("unused")
public class VKDocument extends VKAttachments.VKAttachment implements Parcelable, Identifiable {

    /**
     * Document ID.
     */
    public int id;

    /**
     * ID of the user or group who uploaded the document.
     */
    public int owner_id;

    /**
     * Document title.
     */
    public String title;

    /**
     * Document size (in bytes).
     */
    public long size;

    /**
     * Document extension.
     */
    public String ext;

    /**
     * Document URL for downloading.
     */
    public String url;

    /**
     * URL of the 100x75px image (if the file is graphical).
     */
    public String photo_100;

    /**
     * URL of the 130x100px image (if the file is graphical).
     */
    public String photo_130;

    /**
     * Array of all photos.
     */
    public VKPhotoSizes photo = new VKPhotoSizes();

    /**
     * An access key using for get information about hidden objects.
     */
    public String access_key;

    private boolean mIsGif;
    private boolean mIsImage;

    /**
     * Fills a Doc instance from JSONObject.
     */
    public VKDocument parse(JSONObject jo) {
        id = jo.optInt("id");
        owner_id = jo.optInt("owner_id");
        title = jo.optString("title");
        size = jo.optLong("size");
        ext = jo.optString("ext");
        url = jo.optString("url");
        access_key = jo.optString("access_key");

        photo_100 = jo.optString("photo_100");
        if(!TextUtils.isEmpty(photo_100)) {
            photo.add(VKPhotoSize.create(photo_100, 100, 75));
        }
        photo_130 = jo.optString("photo_130");
        if(!TextUtils.isEmpty(photo_130)) {
            photo.add(VKPhotoSize.create(photo_130, 130, 100));
        }
        photo.sort();
        return this;
    }

    /**
     * Creates a Doc instance from Parcel.
     */
    public VKDocument(Parcel in) {
        this.id = in.readInt();
        this.owner_id = in.readInt();
        this.title = in.readString();
        this.size = in.readLong();
        this.ext = in.readString();
        this.url = in.readString();
        this.photo_100 = in.readString();
        this.photo_130 = in.readString();
        this.photo = in.readParcelable(VKPhotoSizes.class.getClassLoader());
        this.access_key = in.readString();
        this.mIsImage = in.readByte() != 0;
        this.mIsGif = in.readByte() != 0;
    }

    /**
     * Creates empty Doc instance.
     */
    public VKDocument() {

    }

    public boolean isImage() {
        mIsImage = mIsImage ||
                "jpg".equals(ext) ||
                "jpeg".equals(ext) ||
                "png".equals(ext) ||
                "bmp".equals(ext);
        return mIsImage;
    }

    public boolean isGif() {
        mIsGif = mIsGif || "gif".equals(ext);
        return mIsGif;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public CharSequence toAttachmentString() {
        StringBuilder result = new StringBuilder(TYPE_DOC).append(owner_id).append('_').append(id);
        if(!TextUtils.isEmpty(access_key)) {
            result.append('_');
            result.append(access_key);
        }
        return result;
    }

    @Override
    public String getType() {
        return TYPE_DOC;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.owner_id);
        dest.writeString(this.title);
        dest.writeLong(this.size);
        dest.writeString(this.ext);
        dest.writeString(this.url);
        dest.writeString(this.photo_100);
        dest.writeString(this.photo_130);
        dest.writeParcelable(this.photo, flags);
        dest.writeString(this.access_key);
        dest.writeByte(mIsImage ? (byte) 1 : (byte) 0);
        dest.writeByte(mIsGif ? (byte) 1 : (byte) 0);
    }

    public static Creator<VKDocument> CREATOR = new Creator<VKDocument>() {
        public VKDocument createFromParcel(Parcel source) {
            return new VKDocument(source);
        }

        public VKDocument[] newArray(int size) {
            return new VKDocument[size];
        }
    };
}
