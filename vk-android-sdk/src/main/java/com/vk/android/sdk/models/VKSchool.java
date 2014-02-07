package com.vk.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

import static android.text.TextUtils.isEmpty;

/**
 * A school object describes a school.
 */
@SuppressWarnings("unused")
public class VKSchool extends VKModel implements Parcelable, Identifiable {

    /**
     * School ID, positive number
     */
    public int id;

    /**
     * ID of the country the school is located in, positive number
     */
    public int country_id;

    /**
     * ID of the city the school is located in, positive number
     */
    public int city_id;

    /**
     * School name
     */
    public String name;

    /**
     * Year the user started to study
     */
    public int year_from;

    /**
     * Year the user finished to study
     */
    public int year_to;

    /**
     * Graduation year
     */
    public int year_graduated;

    /**
     * School class letter
     */
    public String clazz;

    /**
     * Speciality
     */
    public String speciality;

    /**
     * Fills a School instance from JSONObject.
     */
    public VKSchool parse(JSONObject from) {
        id = from.optInt("id");
        country_id = from.optInt("country_id");
        city_id = from.optInt("city_id");
        name = from.optString("name");
        year_from = from.optInt("year_from");
        year_to = from.optInt("year_to");
        year_graduated = from.optInt("year_graduated");
        clazz = from.optString("class");
        speciality = from.optString("speciality");
        return this;
    }

    /**
     * Creates a School instance from Parcel.
     */
    public VKSchool(Parcel in) {
        this.id = in.readInt();
        this.country_id = in.readInt();
        this.city_id = in.readInt();
        this.name = in.readString();
        this.year_from = in.readInt();
        this.year_to = in.readInt();
        this.year_graduated = in.readInt();
        this.clazz = in.readString();
        this.speciality = in.readString();
    }

    /**
     * Creates empty School instance.
     */
    public VKSchool() {

    }

    @Override
    public int getId() {
        return id;
    }

    private String fullName;

    @Override
    public String toString() {
        if(fullName == null) {
            StringBuilder builder = new StringBuilder(name);
            if(year_graduated != 0) {
                builder.append(" \'");
                builder.append(String.format("%02d", year_graduated % 100));
            }
            if(year_from != 0 && year_to != 0) {
                builder.append(", ");
                builder.append(year_from);
                builder.append('-');
                builder.append(year_to);
            }
            if(!isEmpty(clazz)) {
                builder.append('(');
                builder.append(clazz);
                builder.append(')');
            }
            if(!isEmpty(speciality)) {
                builder.append(", ");
                builder.append(speciality);
            }
            fullName = builder.toString();
        }
        return fullName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.country_id);
        dest.writeInt(this.city_id);
        dest.writeString(this.name);
        dest.writeInt(this.year_from);
        dest.writeInt(this.year_to);
        dest.writeInt(this.year_graduated);
        dest.writeString(this.clazz);
        dest.writeString(this.speciality);
    }

    public static Creator<VKSchool> CREATOR = new Creator<VKSchool>() {
        public VKSchool createFromParcel(Parcel source) {
            return new VKSchool(source);
        }

        public VKSchool[] newArray(int size) {
            return new VKSchool[size];
        }
    };

}
