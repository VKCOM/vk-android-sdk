//
//  Copyright (c) 2014 VK.com
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
import org.json.JSONObject;

public class VKApiGetDialogResponse extends VKApiModel implements android.os.Parcelable {
    /**
     * Number of messages to return
     */
    public int count;
    /**
     * Number of unread dialogs
     */
    public int unread_dialogs;
    /**
     * List dialogs
     */
    public VKList<VKApiDialog> items;

    public VKApiGetDialogResponse(JSONObject from) {
        this.parse(from);
    }

    /**
     * Fills an object from server response.
     */
    public VKApiGetDialogResponse parse(JSONObject source) {
        JSONObject response = source.optJSONObject("response");
        this.count = response.optInt("count");
        this.unread_dialogs = response.optInt("unread_dialogs");
        this.items = new VKList<>(response.optJSONArray("items"), VKApiDialog.class);
        return this;
    }

    /**
     * Creates an DialogResponse instance from Parcel.
     */
    public VKApiGetDialogResponse(Parcel in) {
        this.count = in.readInt();
        this.unread_dialogs = in.readInt();
        this.items = in.readParcelable(VKList.class.getClassLoader());
    }

    /**
     * Creates empty DialogResponse instance.
     */
    public VKApiGetDialogResponse() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeInt(this.unread_dialogs);
        dest.writeParcelable(this.items, flags);
    }

    public static Parcelable.Creator<VKApiGetDialogResponse> CREATOR = new Parcelable.Creator<VKApiGetDialogResponse>() {
        public VKApiGetDialogResponse createFromParcel(Parcel source) {
            return new VKApiGetDialogResponse(source);
        }

        public VKApiGetDialogResponse[] newArray(int size) {
            return new VKApiGetDialogResponse[size];
        }
    };
}
