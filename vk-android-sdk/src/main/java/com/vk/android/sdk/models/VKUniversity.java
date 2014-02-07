package com.vk.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

import static android.text.TextUtils.isEmpty;

/**
 * An university object describes an university.
 */
@SuppressWarnings("unused")
public class VKUniversity extends VKModel implements Parcelable, Identifiable {

    /**
     * University ID, positive number
     */
    public int id;

    /**
     * ID of the country the university is located in, positive number
     */
    public int country_id;

    /**
     * ID of the city the university is located in, positive number
     */
    public int city_id;

    /**
     * University name
     */
    public String name;

    /**
     * Faculty ID
     */
    public String faculty;

    /**
     * Faculty name
     */
    public String faculty_name;

    /**
     * University chair ID;
     */
    public int chair;

    /**
     * Chair name
     */
    public String chair_name;

    /**
     * Graduation year
     */
    public int graduation;

    /**
     * Form of education
     */
    public String education_form;

    /**
     * Status of education
     */
    public String education_status;

    /**
     * Fills a University instance from JSONObject.
     */
    public VKUniversity parse(JSONObject from) {
        id = from.optInt("id");
        country_id = from.optInt("country_id");
        city_id = from.optInt("city_id");
        name = from.optString("name");
        faculty = from.optString("faculty");
        faculty_name = from.optString("faculty_name");
        chair = from.optInt("chair");
        chair_name = from.optString("chair_name");
        graduation = from.optInt("graduation");
        education_form = from.optString("education_form");
        education_status = from.optString("education_status");
        return this;
    }

    /**
     * Creates a University instance from Parcel.
     */
    public VKUniversity(Parcel in) {
        this.id = in.readInt();
        this.country_id = in.readInt();
        this.city_id = in.readInt();
        this.name = in.readString();
        this.faculty = in.readString();
        this.faculty_name = in.readString();
        this.chair = in.readInt();
        this.chair_name = in.readString();
        this.graduation = in.readInt();
        this.education_form = in.readString();
        this.education_status = in.readString();
    }

    /**
     * Creates empty University instance.
     */
    public VKUniversity() {

    }

    private String fullName;

    @Override
    public String toString() {
        if(fullName == null) {
            StringBuilder result = new StringBuilder(name);
            result.append(" \'");
            result.append(String.format("%02d", graduation % 100));
            if(!isEmpty(faculty_name)) {
                result.append(", ");
                result.append(faculty_name);
            }
            if(!isEmpty(chair_name)) {
                result.append(", ");
                result.append(chair_name);
            }
            fullName = result.toString();
        }
        return fullName;
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
        dest.writeInt(this.country_id);
        dest.writeInt(this.city_id);
        dest.writeString(this.name);
        dest.writeString(this.faculty);
        dest.writeString(this.faculty_name);
        dest.writeInt(this.chair);
        dest.writeString(this.chair_name);
        dest.writeInt(this.graduation);
        dest.writeString(this.education_form);
        dest.writeString(this.education_status);
    }

    public static Creator<VKUniversity> CREATOR = new Creator<VKUniversity>() {
        public VKUniversity createFromParcel(Parcel source) {
            return new VKUniversity(source);
        }

        public VKUniversity[] newArray(int size) {
            return new VKUniversity[size];
        }
    };

}
