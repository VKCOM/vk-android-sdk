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

import com.vk.api.sdk.requests.VKRequest
import com.vk.sdk.api.GsonHolder
import com.vk.sdk.api.NewApiRequest
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetAppImageUploadServerImageTypeDto
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetAppImageUploadServerResponseDto
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetAppImagesImageTypeDto
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetGroupImageUploadServerImageTypeDto
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetGroupImageUploadServerResponseDto
import com.vk.sdk.api.appWidgets.dto.AppWidgetsGetGroupImagesImageTypeDto
import com.vk.sdk.api.appWidgets.dto.AppWidgetsPhotoDto
import com.vk.sdk.api.appWidgets.dto.AppWidgetsPhotosDto
import com.vk.sdk.api.appWidgets.dto.AppWidgetsUpdateTypeDto
import com.vk.sdk.api.base.dto.BaseOkResponseDto
import com.vk.sdk.api.mapToJsonPrimitive
import com.vk.sdk.api.parse
import com.vk.sdk.api.parseList
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

class AppWidgetsService {
    /**
     * Returns a URL for uploading a photo to the community collection for community app widgets
     *
     * @param imageType
     * @return [VKRequest] with [AppWidgetsGetAppImageUploadServerResponseDto]
     */
    fun appWidgetsGetAppImageUploadServer(imageType: AppWidgetsGetAppImageUploadServerImageTypeDto):
            VKRequest<AppWidgetsGetAppImageUploadServerResponseDto> =
            NewApiRequest("appWidgets.getAppImageUploadServer") {
        GsonHolder.gson.parse<AppWidgetsGetAppImageUploadServerResponseDto>(it)
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
     * @return [VKRequest] with [AppWidgetsPhotosDto]
     */
    fun appWidgetsGetAppImages(
        offset: Int? = null,
        count: Int? = null,
        imageType: AppWidgetsGetAppImagesImageTypeDto? = null
    ): VKRequest<AppWidgetsPhotosDto> = NewApiRequest("appWidgets.getAppImages") {
        GsonHolder.gson.parse<AppWidgetsPhotosDto>(it)
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
     * @return [VKRequest] with [AppWidgetsGetGroupImageUploadServerResponseDto]
     */
    fun appWidgetsGetGroupImageUploadServer(imageType: AppWidgetsGetGroupImageUploadServerImageTypeDto):
            VKRequest<AppWidgetsGetGroupImageUploadServerResponseDto> =
            NewApiRequest("appWidgets.getGroupImageUploadServer") {
        GsonHolder.gson.parse<AppWidgetsGetGroupImageUploadServerResponseDto>(it)
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
     * @return [VKRequest] with [AppWidgetsPhotosDto]
     */
    fun appWidgetsGetGroupImages(
        offset: Int? = null,
        count: Int? = null,
        imageType: AppWidgetsGetGroupImagesImageTypeDto? = null
    ): VKRequest<AppWidgetsPhotosDto> = NewApiRequest("appWidgets.getGroupImages") {
        GsonHolder.gson.parse<AppWidgetsPhotosDto>(it)
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
    fun appWidgetsGetImagesById(images: List<String>): VKRequest<List<AppWidgetsPhotoDto>> =
            NewApiRequest("appWidgets.getImagesById") {
        GsonHolder.gson.parseList<AppWidgetsPhotoDto>(it)
    }
    .apply {
        addParam("images", images)
    }

    /**
     * Allows to save image into app collection for community app widgets
     *
     * @param hash - Parameter returned when photo is uploaded to server
     * @param image - Parameter returned when photo is uploaded to server
     * @return [VKRequest] with [AppWidgetsPhotoDto]
     */
    fun appWidgetsSaveAppImage(hash: String, image: String): VKRequest<AppWidgetsPhotoDto> =
            NewApiRequest("appWidgets.saveAppImage") {
        GsonHolder.gson.parse<AppWidgetsPhotoDto>(it)
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
     * @return [VKRequest] with [AppWidgetsPhotoDto]
     */
    fun appWidgetsSaveGroupImage(hash: String, image: String): VKRequest<AppWidgetsPhotoDto> =
            NewApiRequest("appWidgets.saveGroupImage") {
        GsonHolder.gson.parse<AppWidgetsPhotoDto>(it)
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
     * @return [VKRequest] with [BaseOkResponseDto]
     */
    fun appWidgetsUpdate(code: String, type: AppWidgetsUpdateTypeDto): VKRequest<BaseOkResponseDto>
            = NewApiRequest("appWidgets.update") {
        GsonHolder.gson.parse<BaseOkResponseDto>(it)
    }
    .apply {
        addParam("code", code, maxLength = 100000)
        addParam("type", type.value)
    }

    object AppWidgetsGetAppImagesRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object AppWidgetsGetGroupImagesRestrictions {
        const val OFFSET_MIN: Long = 0

        const val COUNT_MIN: Long = 0

        const val COUNT_MAX: Long = 100
    }

    object AppWidgetsUpdateRestrictions {
        const val CODE_MAX_LENGTH: Int = 100000
    }
}
