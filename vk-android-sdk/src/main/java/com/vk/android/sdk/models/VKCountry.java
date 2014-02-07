package com.vk.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/**
 * A country object describes a country.
 */
@SuppressWarnings("unused")
public class VKCountry extends VKModel implements Parcelable, Identifiable {

    /**
     * Country ID.
     */
    public int id;

    /**
     * Country name
     */
    public String title;

    /**
     * Fills a Country instance from JSONObject.
     */
    public VKCountry parse(JSONObject from) {
        id = from.optInt("id");
        title = from.optString("title");
        return this;
    }

    /**
     * Creates a Country instance from Parcel.
     */
    public VKCountry(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
    }

    /**
     * Creates empty Country instance.
     */
    public VKCountry() {

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
    }

    public static Creator<VKCountry> CREATOR = new Creator<VKCountry>() {
        public VKCountry createFromParcel(Parcel source) {
            return new VKCountry(source);
        }

        public VKCountry[] newArray(int size) {
            return new VKCountry[size];
        }
    };

}
