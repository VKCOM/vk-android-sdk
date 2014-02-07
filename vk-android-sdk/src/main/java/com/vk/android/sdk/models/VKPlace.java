package com.vk.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

/**
 * A place object describes a location.
 */
@SuppressWarnings("unused")
public class VKPlace extends VKModel implements Parcelable, Identifiable {

    /**
     * Location ID.
     */
    public int id;

    /**
     * Location title.
     */
    public String title;

    /**
     * Geographical latitude, in degrees (from -90 to 90).
     */
    public double latitude;

    /**
     * Geographical longitude, in degrees (from -180 to 180)
     */
    public double longitude;

    /**
     * Date (in Unix time) when the location was added
     */
    public long created;

    /**
     * Numbers of checkins in this place
     */
    public int checkins;

    /**
     * Date (in Unix time) when the location was last time updated
     */
    public long updated;

    /**
     * ID of the country the place is located in, positive number
     */
    public int country_id;

    /**
     * ID of the city the place is located in, positive number
     */
    public int city_id;

    /**
     * Location address.
     */
    public String address;

    /**
     * Fills a Place instance from JSONObject.
     */
    public VKPlace parse(JSONObject from) {
        id = from.optInt("id");
        title = from.optString("title");
        latitude = from.optDouble("latitude");
        longitude = from.optDouble("longitude");
        created = from.optLong("created");
        checkins = from.optInt("checkins");
        updated = from.optLong("updated");
        country_id = from.optInt("country");
        city_id = from.optInt("city");
        address = from.optString("address");
        return this;
    }

    /**
     * Creates a Place instance from Parcel.
     */
    public VKPlace(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.created = in.readLong();
        this.checkins = in.readInt();
        this.updated = in.readLong();
        this.country_id = in.readInt();
        this.city_id = in.readInt();
        this.address = in.readString();
    }

    /**
     * Creates empty Place instance.
     */
    public VKPlace() {

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
        dest.writeString(this.title);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeLong(this.created);
        dest.writeInt(this.checkins);
        dest.writeLong(this.updated);
        dest.writeInt(this.country_id);
        dest.writeInt(this.city_id);
        dest.writeString(address);
    }

    @Override
    public String toString() {
        return address;
    }

    public static Creator<VKPlace> CREATOR = new Creator<VKPlace>() {
        public VKPlace createFromParcel(Parcel source) {
            return new VKPlace(source);
        }

        public VKPlace[] newArray(int size) {
            return new VKPlace[size];
        }
    };
}
