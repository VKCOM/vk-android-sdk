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

import org.json.JSONException;
import org.json.JSONObject;

import static com.vk.sdk.api.model.VKAttachments.TYPE_ALBUM;
import static com.vk.sdk.api.model.VKAttachments.VKApiAttachment;

/**
 * Describes a photo album
 */
@SuppressWarnings("unused")
public class VKApiItemAlbum extends VKApiAttachment implements Parcelable, Identifiable {

    /**
     * ItemAlbum ID.
     */
    public int id;
    /**
     * ID of the user or market that owns the album.
     */
    public int owner_id;
    /**
     * Album title.
     */
    public String title;
    /**
     * Describes a photo object from VK.
     */
    public VKApiPhoto photo;
    /**
     * Number of items in the album.
     */
    public int count;
    /**
     * Date (in Unix time) the album was last updated.
     */
    public long updated_time;

    public VKApiItemAlbum(JSONObject from) throws JSONException {
        parse(from);
    }

    /**
     * Creates empty PhotoAlbum instance.
     */
    public VKApiItemAlbum() {

    }

    /**
     * Creates a PhotoAlbum instance from JSONObject.
     */
    public VKApiItemAlbum parse(JSONObject jo) {
        this.id = jo.optInt("id");
        this.owner_id = jo.optInt("owner_id");
        this.title = jo.optString("title");
        this.photo = new VKApiPhoto().parse(jo);
        this.count = jo.optInt("count");
        this.updated_time = jo.optLong("updated_time");
        return this;
    }

    @Override
    public String toString() {
        return "VKApiItemAlbum{" +
                "id=" + id +
                ", owner_id=" + owner_id +
                ", title='" + title + '\'' +
                ", photo=" + photo +
                ", count=" + count +
                ", updated_time=" + updated_time +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public CharSequence toAttachmentString() {
        return new StringBuilder(TYPE_ALBUM).append(owner_id).append('_').append(id);
    }

    @Override
    public String getType() {
        return TYPE_ALBUM;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.owner_id);
        dest.writeString(this.title);
        dest.writeParcelable(this.photo, flags);
        dest.writeInt(this.count);
        dest.writeLong(this.updated_time);
    }

    protected VKApiItemAlbum(Parcel in) {
        this.id = in.readInt();
        this.owner_id = in.readInt();
        this.title = in.readString();
        this.photo = in.readParcelable(VKApiPhoto.class.getClassLoader());
        this.count = in.readInt();
        this.updated_time = in.readLong();
    }

    public static final Creator<VKApiItemAlbum> CREATOR = new Creator<VKApiItemAlbum>() {
        public VKApiItemAlbum createFromParcel(Parcel source) {
            return new VKApiItemAlbum(source);
        }

        public VKApiItemAlbum[] newArray(int size) {
            return new VKApiItemAlbum[size];
        }
    };
}
