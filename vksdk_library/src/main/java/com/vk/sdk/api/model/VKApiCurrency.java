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
 * Describes item currencies which use market.
 */
@SuppressWarnings("unused")
public class VKApiCurrency extends VKApiModel implements Parcelable, Identifiable {

    /**
     * Currency ID.
     */
    public int id;
    /**
     * Name of currency.
     */
    public String name;

    public VKApiCurrency(JSONObject from) throws JSONException {
        parse(from);
    }

    /**
     * Creates a Currency instance from Parcel.
     */
    public VKApiCurrency(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    /**
     * Creates empty Currency instance.
     */
    public VKApiCurrency() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Fills a Currency instance from JSONObject.
     */
    public VKApiCurrency parse(JSONObject from) {
        id = from.optInt("id");
        name = from.optString("name");
        return this;
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

    public static Creator<VKApiCurrency> CREATOR = new Creator<VKApiCurrency>() {
        public VKApiCurrency createFromParcel(Parcel source) {
            return new VKApiCurrency(source);
        }

        public VKApiCurrency[] newArray(int size) {
            return new VKApiCurrency[size];
        }
    };
}