/**
 * User.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 18.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import android.os.Parcel;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * User object describes a user profile.
 */
@SuppressWarnings("unused")
public class VKUser extends VKOwner implements android.os.Parcelable {

    /**
     * Field name for {@link #online} param.
     */
    public final static String FIELD_ONLINE = "online";

    /**
     * Field name for {@link #online_mobile} param.
     */
    public final static String FIELD_ONLINE_MOBILE = "online_mobile";

    /**
     * Field name for {@link #photo_50} param.
     */
    public final static String FIELD_PHOTO_50 = "photo_50";

    /**
     * Field name for {@link #photo_100} param.
     */
    public final static String FIELD_PHOTO_100 = "photo_100";

    /**
     * Field name for {@link #photo_200} param.
     */
    public final static String FIELD_PHOTO_200 = "photo_200";

    /**
     * All required for fill all fields.
     */
    public final static String FIELDS_DEFAULT = TextUtils.join(",", new String[]{FIELD_ONLINE, FIELD_ONLINE_MOBILE, FIELD_PHOTO_50, FIELD_PHOTO_100, FIELD_PHOTO_200});

    /**
     * First name of user.
     */
    public String first_name = "DELETED";

    /**
     * Last name of user.
     */
    public String last_name = "DELETED";

    /**
     * Information whether the user is online.
     */
    public boolean online;

    /**
     * If user utilizes a mobile application or site mobile version, it returns online_mobile as additional.
     */
    public boolean online_mobile;

    /**
     * URL of default square photo of the user with 50 pixels in width.
     */
    public String photo_50 = "http://vk.com/images/camera_c.gif";

    /**
     * URL of default square photo of the user with 100 pixels in width.
     */
    public String photo_100 = "http://vk.com/images/camera_b.gif";

    /**
     * URL of default square photo of the user with 200 pixels in width.
     */
    public String photo_200 = "http://vk.com/images/camera_a.gif";

    /**
     * {@link #photo_50}, {@link #photo_100}, {@link #photo_200} included here in Photo Sizes format.
     */
    public VKPhotoSizes photo = new VKPhotoSizes();

    /**
     * Fills an user object from server response.
     */
    public VKUser parse(JSONObject from) {
        super.parse(from);
        first_name = from.optString("first_name", first_name);
        last_name = from.optString("last_name", last_name);
        online = ParseUtils.parseBoolean(from, FIELD_ONLINE);
        online_mobile = ParseUtils.parseBoolean(from, FIELD_ONLINE_MOBILE);

        photo_50 = from.optString(FIELD_PHOTO_50, photo_50);
        if(!TextUtils.isEmpty(photo_50)) {
            photo.add(VKPhotoSize.create(photo_50, 50));
        }
        photo_100 = from.optString(FIELD_PHOTO_100, photo_100);
        if(!TextUtils.isEmpty(photo_100)) {
            photo.add(VKPhotoSize.create(photo_100, 100));
        }
        photo_200 = from.optString(FIELD_PHOTO_200, null);
        if(!TextUtils.isEmpty(photo_200)) {
            photo.add(VKPhotoSize.create(photo_200, 200));
        }
        photo.sort();
        return this;
    }

    /**
     * Creates an User instance from Parcel.
     */
    public VKUser(Parcel in) {
        super(in);
        this.first_name = in.readString();
        this.last_name = in.readString();
        this.online = in.readByte() != 0;
        this.online_mobile = in.readByte() != 0;
        this.photo_50 = in.readString();
        this.photo_100 = in.readString();
        this.photo_200 = in.readString();
        this.photo = in.readParcelable(VKPhotoSizes.class.getClassLoader());
        this.full_name = in.readString();
    }

    /**
     * Creates empty User instance.
     */
    public VKUser() {

    }

    private String full_name;

    /**
     * @return full user name
     */
    @Override
    public String toString() {
        if(full_name == null) {
            full_name = first_name + ' ' + last_name;
        }
        return full_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.first_name);
        dest.writeString(this.last_name);
        dest.writeByte(online ? (byte) 1 : (byte) 0);
        dest.writeByte(online_mobile ? (byte) 1 : (byte) 0);
        dest.writeString(this.photo_50);
        dest.writeString(this.photo_100);
        dest.writeString(this.photo_200);
        dest.writeParcelable(this.photo, flags);
        dest.writeString(this.full_name);
    }

    public static Creator<VKUser> CREATOR = new Creator<VKUser>() {
        public VKUser createFromParcel(Parcel source) {
            return new VKUser(source);
        }

        public VKUser[] newArray(int size) {
            return new VKUser[size];
        }
    };
}
