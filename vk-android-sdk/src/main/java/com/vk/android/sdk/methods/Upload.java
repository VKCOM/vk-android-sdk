/**
 * Upload.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 18.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.methods;

import android.net.Uri;
import com.vk.android.sdk.RESTRequest;
import com.vk.android.sdk.VK;
import com.vk.android.sdk.exceptions.*;
import com.vk.android.sdk.models.VKPhoto;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.CancellationException;

/**
 * Method for upload files
 * @see <a href="http://vk.com/dev/upload_files">http://vk.com/dev/upload_files</a>
 */
public class Upload {

    private Upload() {}

    /**
     * This class allows to upload photo to album.
     */
    public static class photoToAlbum extends VK.Codeblock<VKPhoto> {

        private Uri photo;
        private final int owner_id;
        private final int album_id;

        public photoToAlbum(Uri photo, int owner_id, int album_id) {
            this.photo = photo;
            this.owner_id = owner_id;
            this.album_id = album_id;
        }

        @Override
        public VKPhoto run() throws VKServerException, VKCaptchaException, VKValidationException, VKAuthException, IOException, JSONException, CancellationException {
            String uploadUrl = (owner_id > 0 ? Photos.getUploadServer(album_id) : Photos.getUploadServer(album_id, Math.abs(owner_id))).execute();
            Uploader uploader = new Uploader(uploadUrl, photo);
            uploader.setCallback(getUploadCallback());
            return Photos.save(uploader.execute()).execute();
        }

        private final static class Uploader extends RESTRequest<Photos.UploaderResponse> {

            public Uploader(String uploadUrl, Uri photo) {
                super(uploadUrl);
                files("file1", photo);
            }

            @Override
            protected Photos.UploaderResponse parse(String source) throws JSONException {
                return new Photos.UploaderResponse(new JSONObject(source));
            }
        }
    }

    /**
     * This class allows to upload photo to wall.
     */
    public static class photoToWall extends VK.Codeblock<VKPhoto> {

        private Uri photo;
        private final int owner_id;

        public photoToWall(Uri photo, int owner_id) {
            this.photo = photo;
            this.owner_id = owner_id;
        }

        @Override
        public VKPhoto run() throws VKServerException, VKCaptchaException, VKValidationException, VKAuthException, IOException, JSONException, CancellationException {
            String uploadUrl = (owner_id > 0 ? Photos.getWallUploadServer() : Photos.getWallUploadServer(Math.abs(owner_id))).execute();
            Uploader uploader = new Uploader(uploadUrl, photo);
            uploader.setCallback(getUploadCallback());
            return Photos.saveWallPhoto(uploader.execute(), owner_id).execute();
        }

        private final static class Uploader extends RESTRequest<Photos.UploaderResponse> {

            public Uploader(String uploadUrl, Uri photo) {
                super(uploadUrl);
                files("photo", photo);
            }

            @Override
            protected Photos.UploaderResponse parse(String source) throws JSONException {
                return new Photos.UploaderResponse(new JSONObject(source));
            }
        }
    }

    /**
     * Uploads photo to album
     */
    public static photoToAlbum photoToAlbum(Uri photo, int owner_id, int album_id) {
        return new photoToAlbum(photo, owner_id, album_id);
    }

    /**
     * Uploads photo to wall
     */
    public static photoToWall photoToWall(Uri photo, int owner_id) {
        return new photoToWall(photo, owner_id);
    }
}
