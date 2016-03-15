//
//  Copyright (c) 2016 VK.com
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to
//  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
//  the Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
//  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
//  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
//  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
//  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Describes item categories and sections.
 */
@SuppressWarnings("unused")
public class VKApiCategory extends VKApiModel implements Parcelable, Identifiable {

    /**
     * Category ID.
     */
    public int id;
    /**
     * The name of category.
     */
    public String name;
    /**
     * Section
     */
    public VKApiSection section;

    public VKApiCategory(JSONObject from) throws JSONException {
        parse(from);
    }

    /**
     * Creates empty Category instance.
     */
    public VKApiCategory() {

    }

    /**
     * Fills a Category instance from JSONObject.
     */
    public VKApiCategory parse(JSONObject jo) {
        id = jo.optInt("id");
        name = jo.optString("name");
        JSONObject section = jo.optJSONObject("section");
        if (section != null) this.section = new VKApiSection().parse(section);
        return this;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Creates a Category instance from Parcel.
     */
    public VKApiCategory(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    @Override
    public String toString() {
        return "VKApiCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", section=" + section +
                '}';
    }

    public static class VKApiSection extends VKApiModel implements Parcelable, Identifiable {

        /**
         * Category ID.
         */
        public int id;
        /**
         * Currency
         */
        public String name;

        public VKApiSection(JSONObject from) throws JSONException {
            parse(from);
        }

        /**
         * Creates a Section instance from Parcel.
         */
        public VKApiSection(Parcel in) {
            this.id = in.readInt();
            this.name = in.readString();
        }

        /**
         * Creates empty Section instance.
         */
        public VKApiSection() {

        }

        /**
         * Fills a Section instance from JSONObject.
         */
        public VKApiSection parse(JSONObject from) {
            id = from.optInt("id");
            name = from.optString("name");
            return this;
        }

        @Override
        public int getId() {
            return this.id;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.name);
        }

        @Override
        public String toString() {
            return this.name;
        }

        public static Creator<VKApiSection> CREATOR = new Creator<VKApiSection>() {
            public VKApiSection createFromParcel(Parcel source) {
                return new VKApiSection(source);
            }

            public VKApiSection[] newArray(int size) {
                return new VKApiSection[size];
            }
        };
    }

    public static Creator<VKApiCategory> CREATOR = new Creator<VKApiCategory>() {
        public VKApiCategory createFromParcel(Parcel source) {
            return new VKApiCategory(source);
        }

        public VKApiCategory[] newArray(int size) {
            return new VKApiCategory[size];
        }
    };
}