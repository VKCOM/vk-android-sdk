package com.vk.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/**
 * A city object describes a city.
 */
@SuppressWarnings("unused")
public class VKCity extends VKModel implements Parcelable, Identifiable {

    /**
     * City ID.
     */
    public int id;

    /**
     * City name
     */
    public String title;

    /**
     * Fills a City instance from JSONObject.
     */
    public VKCity parse(JSONObject from) {
        id = from.optInt("id");
        title = from.optString("title");
        return this;
    }

    /**
     * Creates a City instance from Parcel.
     */
    public VKCity(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
    }

    /**
     * Creates empty City instance.
     */
    public VKCity() {

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

    public static Creator<VKCity> CREATOR = new Creator<VKCity>() {
        public VKCity createFromParcel(Parcel source) {
            return new VKCity(source);
        }

        public VKCity[] newArray(int size) {
            return new VKCity[size];
        }
    };

}
