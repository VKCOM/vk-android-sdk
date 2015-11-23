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

package com.vk.sdk.api;

import com.vk.sdk.api.methods.VKApiAudio;
import com.vk.sdk.api.methods.VKApiDocs;
import com.vk.sdk.api.methods.VKApiFriends;
import com.vk.sdk.api.methods.VKApiGroups;
import com.vk.sdk.api.methods.VKApiMessages;
import com.vk.sdk.api.methods.VKApiPhotos;
import com.vk.sdk.api.methods.VKApiUsers;
import com.vk.sdk.api.methods.VKApiVideo;
import com.vk.sdk.api.methods.VKApiWall;
import com.vk.sdk.api.photo.VKUploadAlbumPhotoRequest;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.api.photo.VKUploadMessagesPhotoRequest;
import com.vk.sdk.api.photo.VKUploadWallPhotoRequest;

import java.io.File;

/**
 Provides access for API parts.
 */
public class VKApi {
    /**
     * https://vk.com/dev/users
     * Returns object for preparing requests to users part of API
     */
    public static VKApiUsers users() {
        return new VKApiUsers();
    }
    /**
     * https://vk.com/dev/users
     * Returns object for preparing requests to users part of API
     */
    public static VKApiFriends friends() {
        return new VKApiFriends();
    }
    /**
     * https://vk.com/dev/messages
     * Returns object for preparing requests to messages part of API
     */
    public static VKApiMessages messages() {
        return new VKApiMessages();
    }
    /**
     * https://vk.com/dev/wall
     * Returns object for preparing requests to wall part of API
     */
    public static VKApiWall wall() {
        return new VKApiWall();
    }

    /**
     * https://vk.com/dev/photos
     * Returns object for preparing requests to photos part of API
     */
    public static VKApiPhotos photos() {
        return new VKApiPhotos();
    }

    /**
     * https://vk.com/dev/docs
     * Returns object for preparing requests to docs part of API
     */
    public static VKApiDocs docs() {
        return new VKApiDocs();
    }

    /**
     * https://vk.com/dev/audio
     * Returns object for preparing requests to audio part of API
     */
    public static VKApiAudio audio() {
        return new VKApiAudio();
    }

    /**
     * https://vk.com/dev/groups
     * Returns object for preparing requests to groups part of API
     */
    public static VKApiGroups groups() { return new VKApiGroups(); }
    /**
     * Upload a specified file to VK servers for posting on user or group wall
     * @param image Image file to upload. Must have extension jpg or png
     * @param userId User wall id or 0
     * @param groupId Group id or 0
     * @return Prepared vk request for photo upload
     */
    public static VKRequest uploadWallPhotoRequest(File image, long userId, int groupId) {
        return new VKUploadWallPhotoRequest(image, userId, groupId);
    }
    /**
     * Upload a specified file to VK servers for posting on user or group wall
     * @param image Special image object to upload
     * @param userId User wall id or 0
     * @param groupId Group id or 0
     * @return Prepared vk request for photo upload
     */
    public static VKRequest uploadWallPhotoRequest(VKUploadImage image, long userId, int groupId) {
        return new VKUploadWallPhotoRequest(image, userId, groupId);
    }

    /**
     * Upload a specified file to VK servers and saves it into the album
     * @param image Image file to upload. Must have extension jpg or png
     * @param albumId Album id to upload. Must be specified
     * @param groupId Group id or 0
     * @return Prepared vk request for photo upload
     */
    public static VKRequest uploadAlbumPhotoRequest(File image, long albumId, int groupId) {
        return new VKUploadAlbumPhotoRequest(image, albumId, groupId);
    }
    /**
     * Upload a specified file to VK servers and saves it into the album
     * @param image Special image object to upload
     * @param albumId Album id to upload. Must be specified
     * @param groupId Group id or 0
     * @return Prepared vk request for photo upload
     */
    public static VKRequest uploadAlbumPhotoRequest(VKUploadImage image, long albumId, int groupId) {
        return new VKUploadAlbumPhotoRequest(image, albumId, groupId);
    }
	
	/**
     * Upload a specified file to VK servers for use as an attachment to a message
     * @param image Image file to upload. Must have extension jpg or png
     * @return Prepared vk request for photo upload
     */
	public static VKRequest uploadMessagesPhotoRequest(File image) {
        return new VKUploadMessagesPhotoRequest(image);
    }
	/**
     * Upload a specified file to VK servers for use as an attachment to a message
     * @param image Special image object to upload
     * @return Prepared vk request for photo upload
     */
    public static VKRequest uploadMessagesPhotoRequest(VKUploadImage image) {
        return new VKUploadMessagesPhotoRequest(image);
    }

    /**
     * https://vk.com/dev/video
     * Returns object for preparing requests to audio part of API
     */
    public static VKApiVideo video() {
        return new VKApiVideo();
    }
}
