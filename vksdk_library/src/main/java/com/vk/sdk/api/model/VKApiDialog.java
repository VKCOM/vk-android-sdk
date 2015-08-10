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

/**
 * User.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 18.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.sdk.api.model;

import android.os.Parcel;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Dialog object describes a user dialog.
 */
public class VKApiDialog extends VKApiModel implements Identifiable, android.os.Parcelable {

    /**
     * Flag, either 1 or 0
     */
    public int unread;
    /**
     * The first message dialog.
     */
    public VKApiMessage message;

	public VKApiDialog(JSONObject from) throws JSONException
	{
		parse(from);
	}
    /**
     * Fills an dialog object from server response.
     */
    public VKApiDialog parse(JSONObject from) throws JSONException {
        unread = from.optInt("unread");
        message = new VKApiMessage(from.optJSONObject("message"));
        return this;
    }
    /**
     * Creates an Dialog instance from Parcel.
     */
    public VKApiDialog(Parcel in) {
        this.unread = in.readInt();
        this.message = in.readParcelable(VKApiMessage.class.getClassLoader());
    }
    /**
     * Creates empty Dialog instance.
     */
    public VKApiDialog() {
    }

    @Override
    public int getId() {
        return message.getId();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.unread);
        dest.writeParcelable(this.message, flags);
    }

    public static Creator<VKApiDialog> CREATOR = new Creator<VKApiDialog>() {
        public VKApiDialog createFromParcel(Parcel source) {
            return new VKApiDialog(source);
        }

        public VKApiDialog[] newArray(int size) {
            return new VKApiDialog[size];
        }
    };
}
