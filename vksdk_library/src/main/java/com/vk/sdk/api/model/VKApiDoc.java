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
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import static com.vk.sdk.api.model.VKAttachments.TYPE_DOC;
import static com.vk.sdk.api.model.VKAttachments.VKApiAttachment;

/**
 * Describes a Document object from VK.
 */
public class VKApiDoc extends VKApiAttachment implements Parcelable, Identifiable {
    /**
     * Document ID, positive number
     */
    public int id;
    /**
     * ID of the user who uploaded the document.
     */
    public int owner_id;
    /**
     * Document title.
     */
    public String tittle;
    /**
     * Document size (in bytes).
     */
    public int size;
    /**
     * Document extension.
     */
    public String ext;
    /**
     * Document URL for uploading.
     */
    public String url;
    /**
     * URL of the 100x75px image (if the file is graphical).
     */
    public String photo_100;
    /**
     * URL of the 130x100px image (if the file is graphical).
     */
    public String photo_130;
    /**
     * An access key using for get information about hidden objects.
     */
    public String access_key;

	public VKApiDoc(JSONObject from) throws JSONException {
		parse(from);
	}
    /**
     * Fills a Doc instance from JSONObject.
     */
    public VKApiDoc parse(JSONObject from) {
        this.id = from.optInt("id");
        this.owner_id = from.optInt("owner_id");
        this.tittle = from.optString("tittle");
        this.size = from.optInt("size");
        this.ext = from.optString("ext");
        this.url = from.optString("url");
        this.photo_100 = from.optString("photo_100");
        this.photo_130 = from.optString("photo_130");
        this.access_key = from.optString("access_key");
        return this;
    }

    /**
     * Creates a Doc instance from Parcel.
     */
    public VKApiDoc(Parcel in) {
        this.id = in.readInt();
        this.owner_id = in.readInt();
        this.tittle = in.readString();
        this.size = in.readInt();
        this.ext = in.readString();
        this.url = in.readString();
        this.photo_100 = in.readString();
        this.photo_130 = in.readString();
        this.access_key = in.readString();
    }

    /**
     * Creates empty Doc instance.
     */
    public VKApiDoc() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public CharSequence toAttachmentString() {
        StringBuilder result = new StringBuilder(TYPE_DOC).append(owner_id).append('_').append(id);
        if(!TextUtils.isEmpty(access_key)) {
            result.append('_');
            result.append(access_key);
        }
        return result;
    }

    @Override
    public String getType() {
        return TYPE_DOC;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.owner_id);
        dest.writeString(this.tittle);
        dest.writeInt(this.size);
        dest.writeString(this.ext);
        dest.writeString(this.url);
        dest.writeString(this.photo_100);
        dest.writeString(this.photo_130);
        dest.writeString(this.access_key);
    }

    public static Creator<VKApiDoc> CREATOR = new Creator<VKApiDoc>() {
        public VKApiDoc createFromParcel(Parcel source) {
            return new VKApiDoc(source);
        }

        public VKApiDoc[] newArray(int size) {
            return new VKApiDoc[size];
        }
    };

}
