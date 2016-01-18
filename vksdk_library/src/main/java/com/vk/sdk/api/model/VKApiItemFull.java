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

import org.json.JSONObject;

/**
 * Represents full item of market
 */
@SuppressWarnings("unused")
public class VKApiItemFull extends VKApiItem implements Parcelable {

    /**
     * Describes a photo object from VK.
     */
    public VKList<VKApiPhoto> photos;

    /**
     * Whether the opportunity to comment the item for the current user (false — no, true — yes).
     */
    public boolean can_comment;

    /**
     * Whether the opportunity to repost the item for the current user (false — no, true — yes).
     */
    public boolean can_repost;


    /**
     * Number of likes on the item.
     */
    public int likes;

    /**
     * Information whether the current user liked the item.
     */
    public boolean user_likes;

    /**
     * Creates empty ItemFull instance.
     */
    public VKApiItemFull() {
        super();
    }

    @Override
    public String toString() {
        return "VKApiItemFull{" +
                "photos=" + photos +
                ", can_comment=" + can_comment +
                ", can_repost=" + can_repost +
                ", likes=" + likes +
                ", user_likes=" + user_likes +
                "} " + super.toString();
    }

    public VKApiItemFull parse(JSONObject jo) {
        super.parse(jo);
        this.photos = new VKList<>(jo.optJSONArray("photos"), VKApiPhoto.class);
        this.can_comment = ParseUtils.parseBoolean(jo, "can_comment");
        this.can_repost = ParseUtils.parseBoolean(jo, "can_repost");
        JSONObject likes = jo.optJSONObject("likes");
        this.likes = ParseUtils.parseInt(likes, "count");
        this.user_likes = ParseUtils.parseBoolean(likes, "user_likes");
        return this;
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
     * Creates a Currency instance from Parcel.
     */
    public VKApiItemFull(Parcel in) {
        super(in);
        this.photos = in.readParcelable(VKList.class.getClassLoader());
        this.can_comment = in.readByte() != 0;
        this.can_repost = in.readByte() != 0;
        this.likes = in.readInt();
        this.user_likes = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(this.photos, flags);
        dest.writeByte(can_comment ? (byte) 1 : (byte) 0);
        dest.writeByte(can_repost ? (byte) 1 : (byte) 0);
        dest.writeInt(this.likes);
        dest.writeByte(user_likes ? (byte) 1 : (byte) 0);
    }

    public static Creator<VKApiItemFull> CREATOR = new Creator<VKApiItemFull>() {
        public VKApiItemFull createFromParcel(Parcel source) {
            return new VKApiItemFull(source);
        }

        public VKApiItemFull[] newArray(int size) {
            return new VKApiItemFull[size];
        }
    };

}
