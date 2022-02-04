/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 vk.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
*/
// *********************************************************************
// THIS FILE IS AUTO GENERATED!
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING.
// *********************************************************************
package com.vk.sdk.api.appWidgets

import com.google.gson.reflect.TypeToken
import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetAppImageUploadServerImageType
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetAppImageUploadServerResponse
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetAppImagesImageType
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetGroupImageUploadServerImageType
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetGroupImageUploadServerResponse
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetGroupImagesImageType
import com.vk.sdk.api.appWidgets.dto.AppWidgetsPhoto
import com.vk.sdk.api.appWidgets.dto.AppWidgetsPhotos
import com.vk.sdk.api.appWidgets.dto.AppWidgetsUpdateType
import com.vk.sdk.api.base.dto.BaseOkResponse
import kotlin.Int
import kotlin.String
import kotlin.collections.List

class AppWidgetsService {
    /**
     * Returns a URL for uploading a photo to the community collection for community app widgets
     *
     * @param imageType
     * @return [VKRequest] with [AppWidgetsGetAppImageUploadServerResponse]
     */
    fun appWidgetsGetAppImageUploadServer(imageType: AppWidgetsGetAppImageUploadServerImageType):
            VKRequest<AppWidgetsGetAppImageUploadServerResponse> =
            NewApiRequest("appWidgets.getAppImageUploadServer") {
        GsonHolder.gson.fromJson(it, AppWidgetsGetAppImageUploadServerResponse::class.java)
    }
    .apply {
        addParam("image_type", imageType.value)
    }

    /**
     * Returns an app collection of images for community app widgets
     *
     * @param offset - Offset needed to return a specific subset of images.
     * @param count - Maximum count of results.
     * @param imageType
     * @return [VKRequest] with [AppWidgetsPhotos]
     */
    fun appWidgetsGetAppImages(
        offset: Int? = null,
        count: Int? = null,
        imageType: AppWidgetsGetAppImagesImageType? = null
    ): VKRequest<AppWidgetsPhotos> = NewApiRequest("appWidgets.getAppImages") {
        GsonHolder.gson.fromJson(it, AppWidgetsPhotos::class.java)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        imageType?.let { addParam("image_type", it.value) }
    }

    /**
     * Returns a URL for uploading a photo to the community collection for community app widgets
     *
     * @param imageType
     * @return [VKRequest] with [AppWidgetsGetGroupImageUploadServerResponse]
     */
    fun appWidgetsGetGroupImageUploadServer(imageType: AppWidgetsGetGroupImageUploadServerImageType):
            VKRequest<AppWidgetsGetGroupImageUploadServerResponse> =
            NewApiRequest("appWidgets.getGroupImageUploadServer") {
        GsonHolder.gson.fromJson(it, AppWidgetsGetGroupImageUploadServerResponse::class.java)
    }
    .apply {
        addParam("image_type", imageType.value)
    }

    /**
     * Returns a community collection of images for community app widgets
     *
     * @param offset - Offset needed to return a specific subset of images.
     * @param count - Maximum count of results.
     * @param imageType
     * @return [VKRequest] with [AppWidgetsPhotos]
     */
    fun appWidgetsGetGroupImages(
        offset: Int? = null,
        count: Int? = null,
        imageType: AppWidgetsGetGroupImagesImageType? = null
    ): VKRequest<AppWidgetsPhotos> = NewApiRequest("appWidgets.getGroupImages") {
        GsonHolder.gson.fromJson(it, AppWidgetsPhotos::class.java)
    }
    .apply {
        offset?.let { addParam("offset", it, min = 0) }
        count?.let { addParam("count", it, min = 0, max = 100) }
        imageType?.let { addParam("image_type", it.value) }
    }

    /**
     * Returns an image for community app widgets by its ID
     *
     * @param images - List of images IDs
     * @return [VKRequest] with [Unit]
     */
    fun appWidgetsGetImagesById(images: List<String>): VKRequest<List<AppWidgetsPhoto>> =
            NewApiRequest("appWidgets.getImagesById") {
        val typeToken = object: TypeToken<List<AppWidgetsPhoto>>() {}.type
        GsonHolder.gson.fromJson<List<AppWidgetsPhoto>>(it, typeToken)
    }
    .apply {
        addParam("images", images)
    }

    /**
     * Allows to save image into app collection for community app widgets
     *
     * @param hash - Parameter returned when photo is uploaded to server
     * @param image - Parameter returned when photo is uploaded to server
     * @return [VKRequest] with [AppWidgetsPhoto]
     */
    fun appWidgetsSaveAppImage(hash: String, image: String): VKRequest<AppWidgetsPhoto> =
            NewApiRequest("appWidgets.saveAppImage") {
        GsonHolder.gson.fromJson(it, AppWidgetsPhoto::class.java)
    }
    .apply {
        addParam("hash", hash)
        addParam("image", image)
    }

    /**
     * Allows to save image into community collection for community app widgets
     *
     * @param hash - Parameter returned when photo is uploaded to server
     * @param image - Parameter returned when photo is uploaded to server
     * @return [VKRequest] with [AppWidgetsPhoto]
     */
    fun appWidgetsSaveGroupImage(hash: String, image: String): VKRequest<AppWidgetsPhoto> =
            NewApiRequest("appWidgets.saveGroupImage") {
        GsonHolder.gson.fromJson(it, AppWidgetsPhoto::class.java)
    }
    .apply {
        addParam("hash", hash)
        addParam("image", image)
    }

    /**
     * Allows to update community app widget
     *
     * @param code
     * @param type
     * @return [VKRequest] with [BaseOkResponse]
     */
    fun appWidgetsUpdate(code: String, type: AppWidgetsUpdateType): VKRequest<BaseOkResponse> =
            NewApiRequest("appWidgets.update") {
        GsonHolder.gson.fromJson(it, BaseOkResponse::class.java)
    }
    .apply {
        addParam("code", code, maxLength = 100000)
        addParam("type", type.value)
    }
}
