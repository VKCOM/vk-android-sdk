/**
 * Photos.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 18.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.methods;

import android.os.Parcel;
import com.vk.android.sdk.VKRequest;
import com.vk.android.sdk.models.*;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Methods of "photos" section.
 * @see <a href="http://vk.com/dev/photos">http://vk.com/dev/photos</a>
 */
public class Photos {

    private Photos() {}

    /**
     * @see <a href="http://vk.com/dev/photos.getUploadServer">http://vk.com/dev/photos.getUploadServer</a>
     */
    public static class getUploadServer extends VKRequest<String> {

        public getUploadServer(int album_id, int group_id) {
            this(album_id);
            param("group_id", group_id);
        }

        public getUploadServer(int album_id) {
            super("photos.getUploadServer");
            param("album_id", album_id);
            param("save_big", true);
        }

        protected String parse(String source) throws JSONException {
            return ParseUtils.rootJSONObject(source).getString("upload_url");
        }
    }

    /**
     * @see <a href="http://vk.com/dev/photos.getWallUploadServer">http://vk.com/dev/photos.getWallUploadServer</a>
     */
    public static class getWallUploadServer extends VKRequest<String> {

        public getWallUploadServer() {
            super("photos.getWallUploadServer");
        }

        public getWallUploadServer(int group_id) {
            this();
            param("group_id", group_id);
        }

        protected String parse(String source) throws JSONException {
            return ParseUtils.rootJSONObject(source).getString("upload_url");
        }
    }

    /**
     * @see <a href="http://vk.com/dev/photos.save">http://vk.com/dev/photos.save</a>
     */
    public static class save extends VKRequest<VKPhoto> {

        /**
         * @param paramResponse response returned by {Photos.getWallUploadServer}
         */
        public save(UploaderResponse paramResponse) {
            super("photos.save");
            param("server", paramResponse.server);
            param("photos_list", paramResponse.photos_list);
            param("album_id", paramResponse.album_id);
            param("hash", paramResponse.hash);
            param("group_id", paramResponse.group_id);
        }

        protected VKPhoto parse(String source) throws JSONException {
            return new VKList<VKPhoto>(ParseUtils.rootJSONArray(source), VKPhoto.class).get(0);
        }
    }

    /**
     * @see <a href="http://vk.com/dev/photos.saveWallPhoto">http://vk.com/dev/photos.saveWallPhoto</a>
     */
    public static class saveWallPhoto extends VKRequest<VKPhoto> {

        /**
         * @param paramResponse response returned by {Photos.getWallUploadServer}
         * @param owner_id ID of wall owner: positive integer for users, negative for communities.
         */
        public saveWallPhoto(UploaderResponse paramResponse, int owner_id) {
            super("photos.saveWallPhoto");
            param("server", paramResponse.server);
            param("photo", paramResponse.photo);
            param("hash", paramResponse.hash);
            if(owner_id > 0) {
                param("user_id", owner_id);
            } else if(owner_id < 0) {
                param("group_id", Math.abs(owner_id));
            }
        }

        protected VKPhoto parse(String source) throws JSONException {
            return new VKList<VKPhoto>(new JSONObject(source).getJSONArray("response"), VKPhoto.class).get(0);
        }
    }

    /**
     * @see <a href="http://vk.com/dev/photos.getUploadServer">http://vk.com/dev/photos.getUploadServer</a>
     */
    public static getUploadServer getUploadServer(int album_id) {
        return new getUploadServer(album_id);
    }

    /**
     * @see <a href="http://vk.com/dev/photos.getUploadServer">http://vk.com/dev/photos.getUploadServer</a>
     */
    public static getUploadServer getUploadServer(int album_id, int group_id) {
        return new getUploadServer(album_id, group_id);
    }

    /**
     * @see <a href="http://vk.com/dev/photos.getWallUploadServer">http://vk.com/dev/photos.getWallUploadServer</a>
     */
    public static getWallUploadServer getWallUploadServer() {
        return new getWallUploadServer();
    }

    /**
     * @see <a href="http://vk.com/dev/photos.getWallUploadServer">http://vk.com/dev/photos.getWallUploadServer</a>
     */
    public static getWallUploadServer getWallUploadServer(int group_id) {
        return new getWallUploadServer(group_id);
    }

    /**
     * @see <a href="http://vk.com/dev/photos.save">http://vk.com/dev/photos.save</a>
     */
    public static save save(UploaderResponse paramResponse) {
        return new save(paramResponse);
    }

    /**
     * @see <a href="http://vk.com/dev/photos.saveWallPhoto">http://vk.com/dev/photos.saveWallPhoto</a>
     */
    public static saveWallPhoto saveWallPhoto(UploaderResponse paramResponse, int owner_id) {
        return new saveWallPhoto(paramResponse, owner_id);
    }

    public static class UploaderResponse extends VKModel implements android.os.Parcelable {
        public int album_id;
        public String hash;
        public String photos_list;
        public String photo;
        public int group_id;
        public int server;

        public UploaderResponse(JSONObject from) {
            server = from.optInt("server");
            photos_list = from.optString("photos_list");
            photo = from.optString("photo");
            album_id = from.optInt("aid");
            hash = from.optString("hash");
            group_id = from.optInt("gid");
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.album_id);
            dest.writeString(this.hash);
            dest.writeString(this.photos_list);
            dest.writeString(this.photo);
            dest.writeInt(this.group_id);
            dest.writeInt(this.server);
        }

        private UploaderResponse(Parcel in) {
            this.album_id = in.readInt();
            this.hash = in.readString();
            this.photos_list = in.readString();
            this.photo = in.readString();
            this.group_id = in.readInt();
            this.server = in.readInt();
        }

        public static Creator<UploaderResponse> CREATOR = new Creator<UploaderResponse>() {
            public UploaderResponse createFromParcel(Parcel source) {
                return new UploaderResponse(source);
            }

            public UploaderResponse[] newArray(int size) {
                return new UploaderResponse[size];
            }
        };
    }
}
